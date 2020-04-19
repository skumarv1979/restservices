package com.omrtb.restservices.repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityResult;
import javax.persistence.FieldResult;
import javax.persistence.SqlResultSetMapping;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.omrtb.restservices.entity.model.User;
import com.omrtb.restservices.request.model.UserEventActivities;

@RepositoryRestResource
public interface UserRepository extends CrudRepository<User, Long> {
    @Query("FROM User WHERE gender = ?1 order by dob ASC")
    List<User> findByGender(String gender);

    @Query("FROM User WHERE user_id = ?1 order by dob ASC")
    Optional<User> findByUserId(String userId);

    @Query("FROM User WHERE email = ?1 and status=2")
    Optional<User> findUniqueUserByEmail(String userId);

    @Query("select distinct u FROM User u left outer join u.activities WHERE u.email = ?1 and u.status=2")
    Optional<User> findUserNActivitiesByEmail(String email);

    @Query("FROM User WHERE mobile = ?1 and status=2 order by dob ASC")
    List<User> findByMobile(String mobile);

    @Query("FROM User WHERE email = ?1 order by dob ASC")
    List<User> findByEmail(String email);

    @Query("FROM User WHERE password is null order by dob ASC")
    List<User> findMigratedUsers();

    @Query("FROM User WHERE id >= ?1 order by dob ASC")
    List<User> findMigratedUsers(Long id);

    @Transactional
    @Modifying
    @Query("Delete FROM StravaUser su WHERE su.id = ?1")
    void deleteStravUser(Long id);
    
    @Transactional
    @Query("SELECT u FROM User u, StravaUser su where u.id=su.id")
    List<User> pullStravaUsers();

    @Query("FROM User WHERE status is null or status=1 order by createdAt ASC")
    List<User> findAllNewUsers();

    @Query("SELECT COUNT(u) FROM User u, StravaUser su where u.id=su.id and u.id!=?1 and su.atheleteId=?2")
    Long findAthlete(Long id, Integer atheleteId);

    @Query(value = "WITH prods AS (\r\n" + 
    		"    SELECT 1 AS COL FROM DUAL\r\n" + 
    		"    UNION ALL\r\n" + 
    		"    SELECT 1 AS COL FROM DUAL\r\n" + 
    		"    ),\r\n" + 
    		"    CROSS2X2 AS (SELECT 1 col \r\n" + 
    		"	                FROM PRODS p1, \r\n" + 
    		"						      PRODS p2),\r\n" + 
    		"	 CROSS4X4 AS (SELECT 1 col \r\n" + 
    		"	                FROM CROSS2X2 c21, \r\n" + 
    		"						      CROSS2X2 c22),\r\n" + 
    		"	 CROSS16X16 AS (SELECT 1 col \r\n" + 
    		"	                FROM CROSS4X4 c41, \r\n" + 
    		"						      CROSS4X4 c42),\r\n" + 
    		"	 RECORD256 AS (SELECT ROW_NUMBER() OVER ( ORDER BY COL ) ROWNUMBER  \r\n" + 
    		"                    FROM CROSS16X16),\r\n" + 
    		"    PAST_DATES AS (SELECT ROWNUMBER, \r\n" + 
    		"	                       DATE_SUB(CURDATE(),INTERVAL ROWNUMBER-1 DAY) PAST_DATE \r\n" + 
    		"							FROM RECORD256),\r\n" + 
    		"	 ACTIVITIES AS (SELECT u.id,\r\n" + 
    		"	                       u.email, \r\n" + 
    		"                          date(a.start_date) activity_date,\r\n" + 
    		"                          sum(a.moving_time) moving_time,\r\n" + 
    		"                          SUM(a.elapsed_time) elapsed_time\r\n" + 
    		"                     FROM user u\r\n" + 
    		"                            LEFT OUTER JOIN activity a ON u.id = a.user_id \r\n" + 
    		"                            AND date(a.start_date) >= STR_TO_DATE('01,04,2020','%d,%m,%Y'),\r\n" + 
    		"                          user_events_registration r\r\n" + 
    		"                    WHERE u.id = r.users_id\r\n" + 
    		"                      AND r.events_id = 1\r\n" + 
    		"                    GROUP BY u.id, u.email, date(a.start_date)\r\n" + 
    		"                       ),\r\n" + 
    		"     REGISTEREDUSERS AS (SELECT u.id,\r\n" + 
    		"	                             u.email \r\n" + 
    		"	                        FROM user u, \r\n" + 
    		"									     user_events_registration r \r\n" + 
    		"								  WHERE u.id = r.users_id \r\n" + 
    		"								    AND r.events_id = 1),\r\n" + 
    		"	  USER_EVENT_ACTIVITIES AS (SELECT PAST_DATE,\r\n" + 
    		"	                                   id,\r\n" + 
    		"	                                   email\r\n" + 
    		"	                              FROM PAST_DATES, \r\n" + 
    		"	                                   REGISTEREDUSERS\r\n" + 
    		"										)\r\n" + 
    		"\r\n" + 
    		"SELECT u.id,\r\n" + 
    		"       u.email,\r\n" + 
    		"       u.PAST_DATE,\r\n" + 
    		"       a.activity_date,\r\n" + 
    		"       a.moving_time,\r\n" + 
    		"       a.elapsed_time\r\n" + 
    		"  FROM USER_EVENT_ACTIVITIES u\r\n" + 
    		"  LEFT OUTER JOIN ACTIVITIES a\r\n" + 
    		" ON a.activity_date = u.PAST_DATE \r\n" + 
    		" AND a.elapsed_time > 8000 \r\n" + 
    		" AND u.id = a.id\r\n" + 
    		" WHERE u.PAST_DATE >= STR_TO_DATE('01,04,2020','%d,%m,%Y')\r\n" + 
    		" ORDER BY id, PAST_DATE DESC\r\n" + 
    		"",
    		nativeQuery = true)
    Object[][] getUerEventActivities();

}
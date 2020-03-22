package com.omrtb.restservices.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.omrtb.restservices.utils.Util;

@Converter
public class SecondsToHoursMinutesSecondsConverter implements AttributeConverter<String, Integer> {

	@Override
	public Integer convertToDatabaseColumn(String hms) {
		return Util.hoursMinutesSecondsToSecondsConverter(hms);
	}

	@Override
	public String convertToEntityAttribute(Integer seconds) {
		return Util.secondsToHoursMinutesSecondsConverter(seconds);
	}
}
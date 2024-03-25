package com.dartbony.bars_test_client;

import java.time.format.DateTimeFormatter;

public abstract class DateUtils {
    private DateUtils() {}

    public static final String FULL_DATE_TIME_PATTERN = "dd.MM.yyyy HH:mm:ss";
    public static final DateTimeFormatter DATE_TIME_FORMAT = DateTimeFormatter.ofPattern(FULL_DATE_TIME_PATTERN);
}
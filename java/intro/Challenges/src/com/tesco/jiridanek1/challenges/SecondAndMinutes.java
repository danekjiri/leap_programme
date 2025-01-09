package com.tesco.jiridanek1.challenges;

public class SecondAndMinutes {
    public static final String TIME_FORMAT = "%2dh %02dm %02ds";
    public static final int SECONDS_PER_MINUTE = 60;
    public static final int MINUTES_PER_HOUR = 60;

    public static void main(String[] args) {
        /// valid inputs
        System.out.println(getDurationString(100));
        System.out.println(getDurationString(90, 42));

        /// invalid inputs
        System.out.println(getDurationString(90, 90));
        System.out.println(getDurationString(-90, 42));
        System.out.println(getDurationString(-100));
    }

    public static String getDurationString(int seconds) {
        if (seconds < 0) {
            return "Seconds cannot be negative";
        }

        return getDurationString(seconds / SECONDS_PER_MINUTE,
                seconds % SECONDS_PER_MINUTE);
    }

    public static String getDurationString(int minutes, int seconds) {
        if (minutes < 0) {
            return "Minutes cannot be negative";
        } else if (seconds < 0 || seconds > 59) {
            return "Seconds must be between 0 and 59";
        }

        return String.format(TIME_FORMAT, minutes / MINUTES_PER_HOUR, minutes % MINUTES_PER_HOUR,
                seconds);
    }
}

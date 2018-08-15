package com.pipi.base.time;

import java.time.Clock;
import java.time.LocalTime;

public class NewTimeTest {

    public static void main(String[] args) {

        long now = Clock.systemDefaultZone().millis();
//        long now = next;
//        String now = "2017-12-23T00:03:30.000Z";
//        String now = "1513987410000";

//        2. 计算查询时间段开始时间
        long begin = now - 300*1000;

    }
}

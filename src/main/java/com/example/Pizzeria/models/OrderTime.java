package com.example.Pizzeria.models;

import java.sql.Time;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class OrderTime {
    LocalTime timeOrder;
    DateTimeFormatter dateTimeFormatter= DateTimeFormatter.ofPattern("HH:mm:ss");
    LocalTime time = LocalTime.parse(LocalTime.now().format(dateTimeFormatter));

    boolean early=false;
    public OrderTime() {
        this.timeOrder = time;
    }

    public boolean earlyTime(){
        LocalTime timeafter = LocalTime.parse(LocalTime.parse("12:00:00").format(dateTimeFormatter));
        if( time.isBefore(timeafter)){
            return true;
        }
        return false;
    }


}

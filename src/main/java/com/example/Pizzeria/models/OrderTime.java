package com.example.Pizzeria.models;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class OrderTime {
    LocalTime timeOrder;
    DateTimeFormatter dateTimeFormatter= DateTimeFormatter.ofPattern("HH:mm:ss");
    LocalTime time = LocalTime.parse(LocalTime.now().format(dateTimeFormatter));
    public OrderTime() {
        this.timeOrder = time;
    }

    public boolean earlyTime(){
        LocalTime timeafter = LocalTime.parse(LocalTime.parse("12:00:00").format(dateTimeFormatter));
        return time.isBefore(timeafter);
    }


}

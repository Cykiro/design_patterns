package org.example.exercises.design_patterns.decorator_alarm.util;

import org.example.exercises.design_patterns.decorator_alarm.interfaces.AlarmInterface;

public class Util implements AlarmInterface {
    @Override
    public void alarm(String message) {
        System.out.println(message+"\n");
    }

    @Override
    public Object getInfo() {
        return null;
    }
}

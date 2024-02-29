package org.example.exercises.design_patterns.decorator_alarm.util;

import org.example.exercises.design_patterns.decorator_alarm.interfaces.AlarmInterface;

public class AlarmDircetorDecorator implements AlarmInterface{
    AlarmInterface alarmInterface;

    public AlarmDircetorDecorator(AlarmInterface alarmInterface) {
        this.alarmInterface = alarmInterface;
    }

    @Override
    public void alarm(String message) {
        alarmInterface.alarm(message);
    }

    @Override
    public Object getInfo() {
        return null;
    }
}

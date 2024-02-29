package org.example.exercises.design_patterns.decorator_alarm;

import org.example.exercises.design_patterns.decorator_alarm.interfaces.AlarmInterface;

public class AlarmManager {
    AlarmInterface alarmInterface;

    public AlarmManager(AlarmInterface alarmInterface) {
        this.alarmInterface = alarmInterface;
    }
    public void alarm(String message){
        alarmInterface.alarm(message);
    }
    public Object getInfo(){
        return alarmInterface.getInfo();
    }
}

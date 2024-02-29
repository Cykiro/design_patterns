package org.example.exercises.design_patterns.decorator_alarm.decorators;

import org.example.exercises.design_patterns.decorator_alarm.interfaces.AlarmInterface;
import org.example.exercises.design_patterns.decorator_alarm.util.AlarmDircetorDecorator;

public class SkypeDecorator extends AlarmDircetorDecorator {

    public SkypeDecorator(AlarmInterface alarmInterface) {
        super(alarmInterface);
    }

    @Override
    public void alarm(String message) {
        super.alarm(message);
        System.out.println("WIADOMOSC DO SKYPE");
    }
}

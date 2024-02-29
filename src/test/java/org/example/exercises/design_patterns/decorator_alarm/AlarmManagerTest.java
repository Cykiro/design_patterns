package org.example.exercises.design_patterns.decorator_alarm;

import com.twilio.rest.api.v2010.account.Message;
import org.example.exercises.design_patterns.decorator_alarm.decorators.GmailDecorator;
import org.example.exercises.design_patterns.decorator_alarm.decorators.SmsDecorator;
import org.example.exercises.design_patterns.decorator_alarm.util.Util;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThat;

class AlarmManagerTest {
    @Test
    public void makeEmailAlarm() throws Exception {
        AlarmManager alarmManager = new AlarmManager(new GmailDecorator(new Util()));
        alarmManager.alarm("""
                    Hi there,
                    your computer has been hacked.
                     """);

        com.google.api.services.gmail.model.Message message = (com.google.api.services.gmail.model.Message) alarmManager.getInfo();
        assertThat(message.getLabelIds().get(1)).isEqualTo("SENT");
    }
    @Test
    public void makeSMSAlarm() throws InterruptedException {
        AlarmManager alarmManager = new AlarmManager(new SmsDecorator(new Util()));
        alarmManager.alarm("""
                    Hi there,
                    your computer has been hacked.
                     """);
        Thread.sleep(10000);
        Message message = Message.reader().read().iterator().next();
        System.out.println(message.getStatus()+ "  -  "+message.getDateCreated().plusHours(2));
        assertThat(message.getStatus().toString()).isEqualTo("delivered");
    }
    @Test
    public void makeSMSandEmailAlarm() throws InterruptedException {
        AlarmManager alarmManager = new AlarmManager(new GmailDecorator(new SmsDecorator(new Util())));
        alarmManager.alarm("""
                    Hi there,
                    your computer has been hacked.
                     """);

    }

}
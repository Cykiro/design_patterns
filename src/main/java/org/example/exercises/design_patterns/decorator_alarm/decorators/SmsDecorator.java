package org.example.exercises.design_patterns.decorator_alarm.decorators;

import com.twilio.Twilio;
import com.twilio.base.ResourceSet;
import com.twilio.converter.Promoter;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;


import org.example.exercises.design_patterns.decorator_alarm.interfaces.AlarmInterface;
import org.example.exercises.design_patterns.decorator_alarm.util.AlarmDircetorDecorator;


public class SmsDecorator extends AlarmDircetorDecorator {
    public static final String ACCOUNT_SID = "ACee427b40ffcb4d5f4cf528365f8562f3";
    public static final String AUTH_TOKEN = "1fe4809db6983f636753461c6796c15f";

    public SmsDecorator(AlarmInterface alarmInterface) {
        super(alarmInterface);
    }

    @Override
    public void alarm(String message) {
        super.alarm(message);
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message.creator(
                new PhoneNumber("+48790363780"),
                new PhoneNumber("+15079441649"),
                message).create();
    }
}

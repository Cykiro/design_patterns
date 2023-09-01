package org.example.exercises.exercises;

import org.example.exercises.exercises.Device;
import org.example.exercises.exercises.Phone;
import org.junit.jupiter.api.Test;

class DeviceTest {
    @Test
    public void shouldSetModel(){
        Phone phone = new Phone("7","Apple");
        phone.sendMassage();
        Device device = new Device();
        device.sendMassage();
        System.out.println(phone);
    }

}
package org.example.exercises.design_patterns.decorator_file.decorators;

import org.example.exercises.design_patterns.decorator_file.interfaces.DataSource;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Decorator extends DataSourceDecorator{
    public MD5Decorator(DataSource source) {
        super(source);
    }

    @Override
    public void writeData(String data) {
        String encode = encode(data);
        super.writeData(encode);
    }

    private static String encode(String data) {
        String password = "ILoveJava";

        MessageDigest md;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        md.update(password.getBytes());
        byte[] digest = md.digest();
        String myHash = DatatypeConverter.printHexBinary(digest).toUpperCase();

        return myHash;
    }

    @Override
    public String readData() {
        return super.readData();
    }


}

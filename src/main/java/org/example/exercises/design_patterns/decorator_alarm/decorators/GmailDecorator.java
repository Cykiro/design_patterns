package org.example.exercises.design_patterns.decorator_alarm.decorators;


import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.googleapis.json.GoogleJsonError;
import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.gmail.Gmail;
import com.google.api.services.gmail.model.Message;
import org.apache.commons.codec.binary.Base64;
import org.example.exercises.design_patterns.decorator_alarm.interfaces.AlarmInterface;
import org.example.exercises.design_patterns.decorator_alarm.util.AlarmDircetorDecorator;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Paths;
import java.security.GeneralSecurityException;
import java.util.Properties;
import java.util.Set;

import static com.google.api.services.gmail.GmailScopes.*;
import static javax.mail.Message.RecipientType.TO;

public class GmailDecorator extends AlarmDircetorDecorator {
    private  static final String TEST_EMAIL = "dominiknumerek12@gmail.com";
    private   final Gmail service;
    Message msg = new Message();
    public GmailDecorator(AlarmInterface alarmInterface)  {
        super(alarmInterface);
        try {
            service = createService();
        } catch (GeneralSecurityException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Gmail createService() throws GeneralSecurityException, IOException {
        NetHttpTransport httpTransport = GoogleNetHttpTransport.newTrustedTransport();
        GsonFactory jsonFactory = GsonFactory.getDefaultInstance();
        Gmail service = new Gmail.Builder(httpTransport, jsonFactory, getCredentials(httpTransport, jsonFactory))
                .setApplicationName("Test Mailer")
                .build();
        return service;
    }

    private static Credential getCredentials(final NetHttpTransport httpTransport, GsonFactory jsonFactory)
            throws IOException {
        GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(jsonFactory, new InputStreamReader(GmailDecorator.class.getResourceAsStream("/client_secret_1016356306562-n1lksof8b142tj39gs8ckvud770fqui7.apps.googleusercontent.com.json")));

        GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
                httpTransport, jsonFactory, clientSecrets, Set.of(GMAIL_SEND))
                .setDataStoreFactory(new FileDataStoreFactory(Paths.get("tokens").toFile()))
                .setAccessType("offline")
                .build();
        LocalServerReceiver receiver = new LocalServerReceiver.Builder().setPort(8888).build();
        return new AuthorizationCodeInstalledApp(flow, receiver).authorize("user");
    }

    public void sendMail(String subject, String message) throws Exception {
        MimeMessage email = getMimeMessage(subject, message);
        String encodedEmail = getEncodedEmail(email);

        try {
            sendEmail(encodedEmail);
        } catch (GoogleJsonResponseException e) {
            throwAndPrintGoogleException(e);
        }
    }

    private static void throwAndPrintGoogleException(GoogleJsonResponseException e) throws GoogleJsonResponseException {
        GoogleJsonError error = e.getDetails();
        if (error.getCode() == 403) {
            System.err.println("Unable to send message: " + e.getDetails());
        } else {
            throw e;
        }
    }

    private void sendEmail(String encodedEmail) throws IOException {
        msg.setRaw(encodedEmail);
        msg = service.users().messages().send("me", msg).execute();
    }

    private static String getEncodedEmail(MimeMessage email) throws IOException, MessagingException {
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        email.writeTo(buffer);
        byte[] rawMessageBytes = buffer.toByteArray();
        String encodedEmail = Base64.encodeBase64URLSafeString(rawMessageBytes);
        return encodedEmail;
    }

    private static Session getSession() {
        Properties props = new Properties();
        Session session = Session.getDefaultInstance(props, null);
        return session;
    }

    private static MimeMessage getMimeMessage(String subject, String message) throws MessagingException {
        Session session = getSession();
        MimeMessage email = new MimeMessage(session);
        email.setFrom(new InternetAddress(TEST_EMAIL));
        email.addRecipient(TO, new InternetAddress(TEST_EMAIL));
        email.setSubject(subject);
        email.setText(message);
        return email;
    }

    @Override
    public void alarm(String message) {
        super.alarm(message);
        try {
            sendMail("ALARM!", message);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public Object getInfo() {
        return msg;
    }
}

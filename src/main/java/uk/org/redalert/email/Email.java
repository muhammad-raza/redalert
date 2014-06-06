package uk.org.redalert.email;

import com.sendgrid.*;

public class Email {
    public void send() {
        SendGrid sendgrid = new SendGrid("app25332788@heroku.com", "xg6tz7jp");
        SendGrid.Email email = new SendGrid.Email();
        email.addTo("mr.muhammad.raza86@gmail.com");
        email.setFrom("muhammad_raza2009@yahoo.com");
        email.setFromName("Muhammad Raza");
        email.setSubject("Hello World");
        email.setText("My first email through SendGrid");

        try {
            SendGrid.Response response = sendgrid.send(email);
        } catch (SendGridException e) {
            e.printStackTrace();
        }
    }
}
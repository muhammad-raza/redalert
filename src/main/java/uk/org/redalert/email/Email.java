package uk.org.redalert.email;

import com.sendgrid.*;
import uk.org.redalert.application.ApplicationProperties;

public class Email {

    private final EmailContent emailContent;
    private final String TO_EMAIL = ApplicationProperties.TO_EMAIL.getValue();
    private final String USERNAME = "app25332788@heroku.com";
    private final String PASSWORD = "xg6tz7jp";

    public Email(EmailContent emailContent) {
        this.emailContent = emailContent;
    }

    public boolean send() {
        SendGrid sendgrid = new SendGrid(USERNAME, PASSWORD);
        SendGrid.Email email = new SendGrid.Email();

        email.addTo(TO_EMAIL);
        email.setFromName(emailContent.getName());
        email.setFrom(emailContent.getEmail());
        email.setSubject(emailContent.getSubject());
        email.setText(emailContent.getMessage());

        boolean response = false;
        try {
            response = sendgrid.send(email).getStatus();
        } catch (SendGridException e) {
            e.printStackTrace();
        }
        return response;
    }
}
package uk.org.redalert.email;

public class EmailContent {

    private String subject;
    private String name;
    private String email;
    private String message;
    private boolean hasContents;
    private boolean status;

    public EmailContent(String name, String email, String message, String subject) {
        this.name = name;
        this.email = email;
        this.message = message;
        this.subject = subject+" from Red Alert" ;
        this.hasContents = true;
    }

    public EmailContent(){
        this.hasContents = false;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getMessage() {
        return message;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean isStatus() {
        return status;
    }

    public boolean hasContents() {
        return hasContents;
    }

    public String getSubject() {
        return subject;
    }
}

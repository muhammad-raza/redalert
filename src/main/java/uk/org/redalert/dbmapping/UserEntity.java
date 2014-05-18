package uk.org.redalert.dbmapping;

import javax.persistence.*;
@Entity
@Table(name = "users")
public class UserEntity {
    @Id
    @Column(name="id")
    private int id;

    @Column(name="username")
    private String email;

    @Column(name="password")
    private String password;

    @Column(name="activated")
    private int active;

    @Column(name="token")
    private String token;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
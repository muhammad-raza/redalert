package uk.org.redalert.dbmapping;

import javax.persistence.*;
@Entity
@Table(name = "admin")
public class AdminEntity {

    @Id
    @GeneratedValue
    @Column(name="id", nullable = false)
    private int id;

    @Column(name="username", nullable = false)
    private String username;

    @Column(name="password", nullable = false)
    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
package uk.org.redalert.dbmapping;

import javax.persistence.*;

@Entity
@Table(name = "blog")
public class BlogEntity {

    @Id
    @GeneratedValue
    @Column(name="id", nullable = false)
    private int id;

    @Column(name="topic", nullable = false)
    private String topic;

    @Column(name="description", nullable = false)
    private String description;

    @Column(name="date", nullable = false)
    private String date;

    @Column(name="sort", nullable = false)
    private int sortDate;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getSortDate() {
        return sortDate;
    }

    public void setSortDate(int sortDate) {
        this.sortDate = sortDate;
    }
}

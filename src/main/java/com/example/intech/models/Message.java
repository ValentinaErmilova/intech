package com.example.intech.models;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Entity // This tells Hibernate to make a table out of this class
@Table(name="messages")
public class Message {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String mFrom;
    private String mTo;

    private String text;

    @Temporal(TemporalType.DATE)
    private Date createAt;

    public Message() {}

    public Message(String text) {
        this.text = text;
    }

    public Integer getId() {
        return id;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getMFrom() {
        return this.mFrom;
    }

    public void setMFrom(String mFrom) {
        this.mFrom = mFrom;
    }

    public String getMTo() {
        return this.mTo;
    }

    public void setMTo(String mTo) {
        this.mTo = mTo;
    }
}

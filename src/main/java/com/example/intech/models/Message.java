package com.example.intech.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

@Entity
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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "userId")
    @JsonIgnore
    private User user;

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

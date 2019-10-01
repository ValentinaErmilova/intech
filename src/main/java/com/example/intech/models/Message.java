package com.example.intech.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="messages")
public class Message {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String mFrom;
    private String mTo;

    private String text;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_at")
    private Date createAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    public Message() {}

    public Message(String text, User user) {
        this.text = text;
        this.user = user;
    }

    public Long getId() {
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

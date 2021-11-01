package com.sentiment.sentimentanalys.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.sql.Timestamp;
import java.util.Date;

//Model to create a collection company in the mongoDB

@Document
public class Company {

    @Id
    private String id;
    private String name;
    private String isin;
    private String text;
    private String sentiment;
    private Date date;

    public Company() {

    }

    public Company(String id) {
        this.id = id;
    }

    public Company(String id, String name, String isin, String text, String sentiment, Date date) {
        this.id = id;
        this.name = name;
        this.isin = isin;
        this.text = text;
        this.sentiment = sentiment;
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = new Timestamp(System.currentTimeMillis());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIsin() {
        return isin;
    }

    public void setIsin(String isin) {
        this.isin = isin;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSentiment() {
        return sentiment;
    }

    public void setSentiment(String sentiment) {
        this.sentiment = sentiment;
    }

}

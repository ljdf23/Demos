package com.retrofit.android.retrofitdemo.db;

import org.greenrobot.greendao.annotation.*;

// THIS CODE IS GENERATED BY greenDAO, EDIT ONLY INSIDE THE "KEEP"-SECTIONS

// KEEP INCLUDES - put your custom includes here
// KEEP INCLUDES END

/**
 * Entity mapped to table "TERMS_AND_CONDITIONS".
 */
@Entity
public class TermsAndConditions {

    @Id(autoincrement = true)
    private Long id;
    private String timestamp;
    private String url;

    // KEEP FIELDS - put your custom fields here
    // KEEP FIELDS END

    @Generated
    public TermsAndConditions() {
    }

    public TermsAndConditions(Long id) {
        this.id = id;
    }

    @Generated
    public TermsAndConditions(Long id, String timestamp, String url) {
        this.id = id;
        this.timestamp = timestamp;
        this.url = url;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    // KEEP METHODS - put your custom methods here
    // KEEP METHODS END

}
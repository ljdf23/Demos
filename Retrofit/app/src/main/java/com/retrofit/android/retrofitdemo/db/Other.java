package com.retrofit.android.retrofitdemo.db;

import org.greenrobot.greendao.annotation.*;

// THIS CODE IS GENERATED BY greenDAO, EDIT ONLY INSIDE THE "KEEP"-SECTIONS

// KEEP INCLUDES - put your custom includes here
// KEEP INCLUDES END

/**
 * Entity mapped to table "OTHER".
 */
@Entity
public class Other {

    @Id(autoincrement = true)
    private Long id;
    private String item;

    // KEEP FIELDS - put your custom fields here
    // KEEP FIELDS END

    @Generated
    public Other() {
    }

    public Other(Long id) {
        this.id = id;
    }

    @Generated
    public Other(Long id, String item) {
        this.id = id;
        this.item = item;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    // KEEP METHODS - put your custom methods here
    // KEEP METHODS END

}

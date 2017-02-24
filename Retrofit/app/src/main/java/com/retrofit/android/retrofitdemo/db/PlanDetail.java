package com.retrofit.android.retrofitdemo.db;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.JoinProperty;
import org.greenrobot.greendao.annotation.ToMany;

@Entity
public class PlanDetail {

    @Id(autoincrement = true)
    private Long id;
    @SerializedName("remainMinutes")
    @Expose
    private Long remainMinutes;
    @SerializedName("remainSms")
    @Expose
    private Long remainSms;
    @SerializedName("remainInternet")
    @Expose
    private Long remainInternet;
    @SerializedName("other")
    @Expose
    @ToMany(joinProperties = {
            @JoinProperty(name = "id", referencedName = "id")
    })
    private List<Other> other = null;

    public Long getRemainMinutes() {
        return remainMinutes;
    }

    public void setRemainMinutes(Long remainMinutes) {
        this.remainMinutes = remainMinutes;
    }

    public Long getRemainSms() {
        return remainSms;
    }

    public void setRemainSms(Long remainSms) {
        this.remainSms = remainSms;
    }

    public Long getRemainInternet() {
        return remainInternet;
    }

    public void setRemainInternet(Long remainInternet) {
        this.remainInternet = remainInternet;
    }

    public List<Other> getOther() {
        return other;
    }

    public void setOther(List<Other> other) {
        this.other = other;
    }

}

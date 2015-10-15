package wyz.android.com.weather_version_10.domain;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by wangyuzhe on 10/8/15.
 */
public class Rain implements Serializable {
    @SerializedName("3h")
    private String mThour;
    @SerializedName("1h")
    private String mOhour;

    public Rain(String mThour, String mOhour) {
        this.mThour = mThour;
        this.mOhour = mOhour;
    }

    public String getmThour() {
        return mThour;
    }

    public void setmThour(String mThour) {
        this.mThour = mThour;
    }

    public String getmOhour() {
        return mOhour;
    }

    public void setmOhour(String mOhour) {
        this.mOhour = mOhour;
    }
}

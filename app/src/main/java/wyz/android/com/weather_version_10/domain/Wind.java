package wyz.android.com.weather_version_10.domain;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by wangyuzhe on 10/8/15.
 */
public class Wind implements Serializable {
    @SerializedName("speed")
    private String mSpeed;
    @SerializedName("deg")
    private String mDeg;

    public Wind(String mSpeed, String mDeg) {
        this.mSpeed = mSpeed;
        this.mDeg = mDeg;
    }

    public String getmSpeed() {
        return mSpeed;
    }

    public void setmSpeed(String mSpeed) {
        this.mSpeed = mSpeed;
    }

    public String getmDeg() {
        return mDeg;
    }

    public void setmDeg(String mDeg) {
        this.mDeg = mDeg;
    }
}

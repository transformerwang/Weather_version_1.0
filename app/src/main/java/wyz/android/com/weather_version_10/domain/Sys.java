package wyz.android.com.weather_version_10.domain;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by wangyuzhe on 10/8/15.
 */
public class Sys implements Serializable {
    @SerializedName("type")
    private String mType;
    @SerializedName("id")
    private String mId;
    @SerializedName("message")
    private String mMessage;
    @SerializedName("country")
    private String mCountry;
    @SerializedName("sunrise")
    private String mSunrise;
    @SerializedName("sunset")
    private String mSunset;
    @SerializedName("pod")
    private String mPod;

    public Sys(String mType, String mId, String mMessage, String mCountry, String mSunrise, String mSunset, String mPod) {
        this.mType = mType;
        this.mId = mId;
        this.mMessage = mMessage;
        this.mCountry = mCountry;
        this.mSunrise = mSunrise;
        this.mSunset = mSunset;
        this.mPod = mPod;
    }

    public String getmType() {
        return mType;
    }

    public void setmType(String mType) {
        this.mType = mType;
    }

    public String getmId() {
        return mId;
    }

    public void setmId(String mId) {
        this.mId = mId;
    }

    public String getmMessage() {
        return mMessage;
    }

    public void setmMessage(String mMessage) {
        this.mMessage = mMessage;
    }

    public String getmCountry() {
        return mCountry;
    }

    public void setmCountry(String mCountry) {
        this.mCountry = mCountry;
    }

    public String getmSunrise() {
        return mSunrise;
    }

    public void setmSunrise(String mSunrise) {
        this.mSunrise = mSunrise;
    }

    public String getmSunset() {
        return mSunset;
    }

    public void setmSunset(String mSunset) {
        this.mSunset = mSunset;
    }

    public String getmPod() {
        return mPod;
    }

    public void setmPod(String mPod) {
        this.mPod = mPod;
    }
}

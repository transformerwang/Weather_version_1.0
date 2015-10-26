package wyz.android.com.weather_version_10.domain;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by wangyuzhe on 10/15/15.
 */
public class Alerts implements Serializable {
    @SerializedName("title")
    private String mTitle;
    @SerializedName("time")
    private String mTime;
    @SerializedName("expires")
    private String mExpires;
    @SerializedName("description")
    private String mDescription;
    @SerializedName("uri")
    private String mUri;

    public Alerts(String mTitle, String mTime, String mExpires, String mDescription, String mUri) {
        this.mTitle = mTitle;
        this.mTime = mTime;
        this.mExpires = mExpires;
        this.mDescription = mDescription;
        this.mUri = mUri;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getmExpires() {
        return mExpires;
    }

    public void setmExpires(String mExpires) {
        this.mExpires = mExpires;
    }

    public String getmDescription() {
        return mDescription;
    }

    public void setmDescription(String mDescription) {
        this.mDescription = mDescription;
    }

    public String getmUri() {
        return mUri;
    }

    public void setmUri(String mUri) {
        this.mUri = mUri;
    }

    public String getmTime() {
        return mTime;
    }

    public void setmTime(String mTime) {
        this.mTime = mTime;
    }
}

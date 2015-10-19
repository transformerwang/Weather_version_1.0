package wyz.android.com.weather_version_10.domain;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by wangyuzhe on 10/15/15.
 */
public class CurrentWeather implements Serializable {
    @SerializedName("latitude")
    private String mLatitude;
    @SerializedName("longitude")
    private String mLongitude;
    @SerializedName("timezone")
    private String mTimeZone;
    @SerializedName("offset")
    private String mOffSet;
    @SerializedName("currently")
    private Currently mCurrently;
    @SerializedName("hourly")
    private Hourly mHourly;
    @SerializedName("daily")
    private Daily mDaily;
    @SerializedName("alerts")
    private List<Alerts> mList;

    public CurrentWeather(String mLatitude, String mLongitude, String mTimeZone, String mOffSet, Currently mCurrently, Hourly mHourly, Daily mDaily, List<Alerts> mList) {
        this.mLatitude = mLatitude;
        this.mLongitude = mLongitude;
        this.mTimeZone = mTimeZone;
        this.mOffSet = mOffSet;
        this.mCurrently = mCurrently;
        this.mHourly = mHourly;
        this.mDaily = mDaily;
        this.mList = mList;
    }

    public String getmLatitude() {
        return mLatitude;
    }

    public void setmLatitude(String mLatitude) {
        this.mLatitude = mLatitude;
    }

    public String getmLongitude() {
        return mLongitude;
    }

    public void setmLongitude(String mLongitude) {
        this.mLongitude = mLongitude;
    }

    public String getmTimeZone() {
        return mTimeZone;
    }

    public void setmTimeZone(String mTimeZone) {
        this.mTimeZone = mTimeZone;
    }

    public String getmOffSet() {
        return mOffSet;
    }

    public void setmOffSet(String mOffSet) {
        this.mOffSet = mOffSet;
    }

    public Currently getmCurrently() {
        return mCurrently;
    }

    public void setmCurrently(Currently mCurrently) {
        this.mCurrently = mCurrently;
    }

    public Hourly getmHourly() {
        return mHourly;
    }

    public void setmHourly(Hourly mHourly) {
        this.mHourly = mHourly;
    }

    public Daily getmDaily() {
        return mDaily;
    }

    public void setmDaily(Daily mDaily) {
        this.mDaily = mDaily;
    }

    public List<Alerts> getmAlerts() {
        return mList;
    }

    public void setmAlerts(List<Alerts> mAlerts) {
        this.mList = mAlerts;
    }
}

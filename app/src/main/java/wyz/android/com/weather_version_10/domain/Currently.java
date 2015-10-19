package wyz.android.com.weather_version_10.domain;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by wangyuzhe on 10/15/15.
 */
public class Currently implements Serializable {
    @SerializedName("time")
    private String mTime;
    @SerializedName("summary")
    private String mSummary;
    @SerializedName("icon")
    private String mIcon;
    @SerializedName("nearestStormDistance")
    private String mNearestStormDistance;
    @SerializedName("nearestStormBearing")
    private String mNearestStormBearing;
    @SerializedName("precipIntensity")
    private String mPrecipIntensity;
    @SerializedName("precipProbability")
    private String mPrecipProbability;
    @SerializedName("temperature")
    private String mTemperature;
    @SerializedName("apparentTemperature")
    private String mApparentTemperature;
    @SerializedName("dewPoint")
    private String mDewPoint;
    @SerializedName("humidity")
    private String mHumidity;
    @SerializedName("windSpeed")
    private String mWindSpeed;
    @SerializedName("windBearing")
    private String mWindBearing;
    @SerializedName("visibility")
    private String mVisibility;
    @SerializedName("cloudCover")
    private String mCloundCover;
    @SerializedName("pressure")
    private String mPressure;
    @SerializedName("ozone")
    private String mOzone;

    public Currently(String mTime, String mSummary, String mIcon, String mNearestStormDistance, String mNearestStormBearing, String mPrecipIntensity, String mPrecipProbability, String mTemperature, String mApparentTemperature, String mDewPoint, String mHumidity, String mWindSpeed, String mWindBearing, String mVisibility, String mCloundCover, String mPressure, String mOzone) {
        this.mTime = mTime;
        this.mSummary = mSummary;
        this.mIcon = mIcon;
        this.mNearestStormDistance = mNearestStormDistance;
        this.mNearestStormBearing = mNearestStormBearing;
        this.mPrecipIntensity = mPrecipIntensity;
        this.mPrecipProbability = mPrecipProbability;
        this.mTemperature = mTemperature;
        this.mApparentTemperature = mApparentTemperature;
        this.mDewPoint = mDewPoint;
        this.mHumidity = mHumidity;
        this.mWindSpeed = mWindSpeed;
        this.mWindBearing = mWindBearing;
        this.mVisibility = mVisibility;
        this.mCloundCover = mCloundCover;
        this.mPressure = mPressure;
        this.mOzone = mOzone;
    }

    public String getmTime() {
        return mTime;
    }

    public void setmTime(String mTime) {
        this.mTime = mTime;
    }

    public String getmSummary() {
        return mSummary;
    }

    public void setmSummary(String mSummary) {
        this.mSummary = mSummary;
    }

    public String getmIcon() {
        return mIcon;
    }

    public void setmIcon(String mIcon) {
        this.mIcon = mIcon;
    }

    public String getmNearestStormDistance() {
        return mNearestStormDistance;
    }

    public void setmNearestStormDistance(String mNearestStormDistance) {
        this.mNearestStormDistance = mNearestStormDistance;
    }

    public String getmNearestStormBearing() {
        return mNearestStormBearing;
    }

    public void setmNearestStormBearing(String mNearestStormBearing) {
        this.mNearestStormBearing = mNearestStormBearing;
    }

    public String getmPrecipIntensity() {
        return mPrecipIntensity;
    }

    public void setmPrecipIntensity(String mPrecipIntensity) {
        this.mPrecipIntensity = mPrecipIntensity;
    }

    public String getmPrecipProbability() {
        return mPrecipProbability;
    }

    public void setmPrecipProbability(String mPrecipProbability) {
        this.mPrecipProbability = mPrecipProbability;
    }

    public String getmTemperature() {
        return mTemperature;
    }

    public void setmTemperature(String mTemperature) {
        this.mTemperature = mTemperature;
    }

    public String getmApparentTemperature() {
        return mApparentTemperature;
    }

    public void setmApparentTemperature(String mApparentTemperature) {
        this.mApparentTemperature = mApparentTemperature;
    }

    public String getmDewPoint() {
        return mDewPoint;
    }

    public void setmDewPoint(String mDewPoint) {
        this.mDewPoint = mDewPoint;
    }

    public String getmHumidity() {
        return mHumidity;
    }

    public void setmHumidity(String mHumidity) {
        this.mHumidity = mHumidity;
    }

    public String getmWindSpeed() {
        return mWindSpeed;
    }

    public void setmWindSpeed(String mWindSpeed) {
        this.mWindSpeed = mWindSpeed;
    }

    public String getmWindBearing() {
        return mWindBearing;
    }

    public void setmWindBearing(String mWindBearing) {
        this.mWindBearing = mWindBearing;
    }

    public String getmVisibility() {
        return mVisibility;
    }

    public void setmVisibility(String mVisibility) {
        this.mVisibility = mVisibility;
    }

    public String getmCloundCover() {
        return mCloundCover;
    }

    public void setmCloundCover(String mCloundCover) {
        this.mCloundCover = mCloundCover;
    }

    public String getmPressure() {
        return mPressure;
    }

    public void setmPressure(String mPressure) {
        this.mPressure = mPressure;
    }

    public String getmOzone() {
        return mOzone;
    }

    public void setmOzone(String mOzone) {
        this.mOzone = mOzone;
    }
}

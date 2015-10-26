package wyz.android.com.weather_version_10.domain;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by wangyuzhe on 10/15/15.
 */
public class WeatherData implements Serializable {
    @SerializedName("time")
    private String mTime;
    @SerializedName("summary")
    private String mSummary;
    @SerializedName("icon")
    private String mIcon;
    @SerializedName("sunriseTime")
    private String mSunriseTime;
    @SerializedName("sunsetTime")
    private String mSunsetTime;
    @SerializedName("moonPhase")
    private String mMoonPhase;
    @SerializedName("precipIntensity")
    private String mPrecipIntensity;
    @SerializedName("precipIntensityMax")
    private String mPrecipIntensityMax;
    @SerializedName("precipProbability")
    private String mPrecipProbability;
    @SerializedName("temperatureMin")
    private String mTemperatureMin;
    @SerializedName("temperatureMinTime")
    private String mTemperatureMinTime;
    @SerializedName("temperatureMax")
    private String mTemperatureMax;
    @SerializedName("temperatureMaxTime")
    private String mTemperatureMaxTime;
    @SerializedName("apparentTemperatureMin")
    private String mApparentTemperatureMin;
    @SerializedName("apparentTemperatureMinTime")
    private String mApparentTemperatureMinTime;
    @SerializedName("apparentTemperatureMax")
    private String mApparentTemperatureMax;
    @SerializedName("apparentTemperatureMaxTime")
    private String mApparentTemperatureMaxTime;
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
    private String mCloudCover;
    @SerializedName("pressure")
    private String mPressure;
    @SerializedName("ozone")
    private String mOzone;
    @SerializedName("temperature")
    private String mTemprature;
    @SerializedName("precipType")
    private String mPrecipType;

    public WeatherData(String mTime, String mSummary, String mIcon, String mSunriseTime, String mSunsetTime, String mMoonPhase, String mPrecipIntensity, String mPrecipIntensityMax, String mPrecipProbability, String mTemperatureMin, String mTemperatureMinTime, String mTemperatureMax, String mTemperatureMaxTime, String mApparentTemperatureMin, String mApparentTemperatureMinTime, String mApparentTemperatureMax, String mApparentTemperatureMaxTime, String mDewPoint, String mHumidity, String mWindSpeed, String mWindBearing, String mVisibility, String mCloudCover, String mPressure, String mOzone, String mTemprature, String mPrecipType) {
        this.mTime = mTime;
        this.mSummary = mSummary;
        this.mIcon = mIcon;
        this.mSunriseTime = mSunriseTime;
        this.mSunsetTime = mSunsetTime;
        this.mMoonPhase = mMoonPhase;
        this.mPrecipIntensity = mPrecipIntensity;
        this.mPrecipIntensityMax = mPrecipIntensityMax;
        this.mPrecipProbability = mPrecipProbability;
        this.mTemperatureMin = mTemperatureMin;
        this.mTemperatureMinTime = mTemperatureMinTime;
        this.mTemperatureMax = mTemperatureMax;
        this.mTemperatureMaxTime = mTemperatureMaxTime;
        this.mApparentTemperatureMin = mApparentTemperatureMin;
        this.mApparentTemperatureMinTime = mApparentTemperatureMinTime;
        this.mApparentTemperatureMax = mApparentTemperatureMax;
        this.mApparentTemperatureMaxTime = mApparentTemperatureMaxTime;
        this.mDewPoint = mDewPoint;
        this.mHumidity = mHumidity;
        this.mWindSpeed = mWindSpeed;
        this.mWindBearing = mWindBearing;
        this.mVisibility = mVisibility;
        this.mCloudCover = mCloudCover;
        this.mPressure = mPressure;
        this.mOzone = mOzone;
        this.mTemprature = mTemprature;
        this.mPrecipType = mPrecipType;
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

    public String getmSunriseTime() {
        return mSunriseTime;
    }

    public void setmSunriseTime(String mSunriseTime) {
        this.mSunriseTime = mSunriseTime;
    }

    public String getmSunsetTime() {
        return mSunsetTime;
    }

    public void setmSunsetTime(String mSunsetTime) {
        this.mSunsetTime = mSunsetTime;
    }

    public String getmMoonPhase() {
        return mMoonPhase;
    }

    public void setmMoonPhase(String mMoonPhase) {
        this.mMoonPhase = mMoonPhase;
    }

    public String getmPrecipIntensity() {
        return mPrecipIntensity;
    }

    public void setmPrecipIntensity(String mPrecipIntensity) {
        this.mPrecipIntensity = mPrecipIntensity;
    }

    public String getmPrecipIntensityMax() {
        return mPrecipIntensityMax;
    }

    public void setmPrecipIntensityMax(String mPrecipIntensityMax) {
        this.mPrecipIntensityMax = mPrecipIntensityMax;
    }

    public String getmPrecipProbability() {
        return mPrecipProbability;
    }

    public void setmPrecipProbability(String mPrecipProbability) {
        this.mPrecipProbability = mPrecipProbability;
    }

    public String getmTemperatureMin() {
        return mTemperatureMin;
    }

    public void setmTemperatureMin(String mTemperatureMin) {
        this.mTemperatureMin = mTemperatureMin;
    }

    public String getmTemperatureMinTime() {
        return mTemperatureMinTime;
    }

    public void setmTemperatureMinTime(String mTemperatureMinTime) {
        this.mTemperatureMinTime = mTemperatureMinTime;
    }

    public String getmTemperatureMax() {
        return mTemperatureMax;
    }

    public void setmTemperatureMax(String mTemperatureMax) {
        this.mTemperatureMax = mTemperatureMax;
    }

    public String getmTemperatureMaxTime() {
        return mTemperatureMaxTime;
    }

    public void setmTemperatureMaxTime(String mTemperatureMaxTime) {
        this.mTemperatureMaxTime = mTemperatureMaxTime;
    }

    public String getmApparentTemperatureMin() {
        return mApparentTemperatureMin;
    }

    public void setmApparentTemperatureMin(String mApparentTemperatureMin) {
        this.mApparentTemperatureMin = mApparentTemperatureMin;
    }

    public String getmApparentTemperatureMinTime() {
        return mApparentTemperatureMinTime;
    }

    public void setmApparentTemperatureMinTime(String mApparentTemperatureMinTime) {
        this.mApparentTemperatureMinTime = mApparentTemperatureMinTime;
    }

    public String getmApparentTemperatureMax() {
        return mApparentTemperatureMax;
    }

    public void setmApparentTemperatureMax(String mApparentTemperatureMax) {
        this.mApparentTemperatureMax = mApparentTemperatureMax;
    }

    public String getmApparentTemperatureMaxTime() {
        return mApparentTemperatureMaxTime;
    }

    public void setmApparentTemperatureMaxTime(String mApparentTemperatureMaxTime) {
        this.mApparentTemperatureMaxTime = mApparentTemperatureMaxTime;
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

    public String getmCloudCover() {
        return mCloudCover;
    }

    public void setmCloudCover(String mCloudCover) {
        this.mCloudCover = mCloudCover;
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

    public String getmTemprature() {
        return mTemprature;
    }

    public void setmTemprature(String mTemprature) {
        this.mTemprature = mTemprature;
    }

    public String getmPrecipType() {
        return mPrecipType;
    }

    public void setmPrecipType(String mPrecipType) {
        this.mPrecipType = mPrecipType;
    }
}

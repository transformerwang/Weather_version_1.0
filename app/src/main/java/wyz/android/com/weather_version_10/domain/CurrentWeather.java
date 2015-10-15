package wyz.android.com.weather_version_10.domain;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by wangyuzhe on 10/8/15.
 */
public class CurrentWeather implements Serializable {
    @SerializedName("coord")
    private Coord mCoord;
    @SerializedName("weather")
    private List<Weather> mWeather;
    @SerializedName("base")
    private String mBase;
    @SerializedName("main")
    private Main mMain;
    @SerializedName("wind")
    private Wind mWind;
    @SerializedName("dt")
    private String mDt;
    @SerializedName("sys")
    private Sys mSys;
    @SerializedName("id")
    private String mId;
    @SerializedName("name")
    private String mName;
    @SerializedName("cod")
    private String mCod;
    @SerializedName("dt_txt")
    private String mDt_txt;
    @SerializedName("clouds")
    private Clouds mClouds;
    @SerializedName("rain")
    private Rain mRain;
    @SerializedName("snow")
    private Snow mSnow;
    @SerializedName("visibility")
    private String mVisibility;

    public CurrentWeather(Coord mCoord, List<Weather> mWeather, String mBase, Main mMain, Wind mWind, String mDt, Sys mSys, String mId, String mName, String mCod, String mDt_txt, Clouds mClouds, Rain mRain, Snow mSnow, String mVisibility) {

        this.mCoord = mCoord;
        this.mWeather = mWeather;
        this.mBase = mBase;
        this.mMain = mMain;
        this.mWind = mWind;
        this.mDt = mDt;
        this.mSys = mSys;
        this.mId = mId;
        this.mName = mName;
        this.mCod = mCod;
        this.mDt_txt = mDt_txt;
        this.mClouds = mClouds;
        this.mRain = mRain;
        this.mSnow = mSnow;
        this.mVisibility = mVisibility;
    }

    public Coord getmCoord() {
        return mCoord;
    }

    public void setmCoord(Coord mCoord) {
        this.mCoord = mCoord;
    }

    public List<Weather> getmWeather() {
        return mWeather;
    }

    public void setmWeather(List<Weather> mWeather) {
        this.mWeather = mWeather;
    }

    public String getmBase() {
        return mBase;
    }

    public void setmBase(String mBase) {
        this.mBase = mBase;
    }

    public Main getmMain() {
        return mMain;
    }

    public void setmMain(Main mMain) {
        this.mMain = mMain;
    }

    public Wind getmWind() {
        return mWind;
    }

    public void setmWind(Wind mWind) {
        this.mWind = mWind;
    }

    public String getmDt() {
        return mDt;
    }

    public void setmDt(String mDt) {
        this.mDt = mDt;
    }

    public Sys getmSys() {
        return mSys;
    }

    public void setmSys(Sys mSys) {
        this.mSys = mSys;
    }

    public String getmId() {
        return mId;
    }

    public void setmId(String mId) {
        this.mId = mId;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmCod() {
        return mCod;
    }

    public void setmCod(String mCod) {
        this.mCod = mCod;
    }

    public String getmDt_txt() {
        return mDt_txt;
    }

    public void setmDt_txt(String mDt_txt) {
        this.mDt_txt = mDt_txt;
    }

    public Clouds getmClouds() {
        return mClouds;
    }

    public void setmClouds(Clouds mClouds) {
        this.mClouds = mClouds;
    }

    public Rain getmRain() {
        return mRain;
    }

    public void setmRain(Rain mRain) {
        this.mRain = mRain;
    }

    public Snow getmSnow() {
        return mSnow;
    }

    public void setmSnow(Snow mSnow) {
        this.mSnow = mSnow;
    }

    public String getmVisibility() {
        return mVisibility;
    }

    public void setmVisibility(String mVisibility) {
        this.mVisibility = mVisibility;
    }
}

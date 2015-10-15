package wyz.android.com.weather_version_10.domain;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by wangyuzhe on 10/8/15.
 */
public class Main implements Serializable {
    @SerializedName("temp")
    private String mTemp;
    @SerializedName("pressure")
    private String mPressure;
    @SerializedName("humidity")
    private String mHumidity;
    @SerializedName("temp_min")
    private String mTemp_min;
    @SerializedName("temp_max")
    private String mTemp_max;
    @SerializedName("sea_level")
    private String mSea_level;
    @SerializedName("grnd_level")
    private String mGrnd_level;
    @SerializedName("temp_kf")
    private String mTemp_kf;

    public Main(String mTemp, String mPressure, String mHumidity, String mTemp_min, String mTemp_max, String mSea_level, String mGrnd_level, String mTemp_kf) {
        this.mTemp = mTemp;
        this.mPressure = mPressure;
        this.mHumidity = mHumidity;
        this.mTemp_min = mTemp_min;
        this.mTemp_max = mTemp_max;
        this.mSea_level = mSea_level;
        this.mGrnd_level = mGrnd_level;
        this.mTemp_kf = mTemp_kf;
    }

    public String getmTemp() {
        return mTemp;
    }

    public void setmTemp(String mTemp) {
        this.mTemp = mTemp;
    }

    public String getmPressure() {
        return mPressure;
    }

    public void setmPressure(String mPressure) {
        this.mPressure = mPressure;
    }

    public String getmHumidity() {
        return mHumidity;
    }

    public void setmHumidity(String mHumidity) {
        this.mHumidity = mHumidity;
    }

    public String getmTemp_min() {
        return mTemp_min;
    }

    public void setmTemp_min(String mTemp_min) {
        this.mTemp_min = mTemp_min;
    }

    public String getmTemp_max() {
        return mTemp_max;
    }

    public void setmTemp_max(String mTemp_max) {
        this.mTemp_max = mTemp_max;
    }

    public String getmSea_level() {
        return mSea_level;
    }

    public void setmSea_level(String mSea_level) {
        this.mSea_level = mSea_level;
    }

    public String getmGrnd_level() {
        return mGrnd_level;
    }

    public void setmGrnd_level(String mGrnd_level) {
        this.mGrnd_level = mGrnd_level;
    }

    public String getmTemp_kf() {
        return mTemp_kf;
    }

    public void setmTemp_kf(String mTemp_kf) {
        this.mTemp_kf = mTemp_kf;
    }
}

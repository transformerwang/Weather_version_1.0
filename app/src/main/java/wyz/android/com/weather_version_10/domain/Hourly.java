package wyz.android.com.weather_version_10.domain;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by wangyuzhe on 10/15/15.
 */
public class Hourly implements Serializable {
    @SerializedName("summary")
    private String mSummary;
    @SerializedName("icon")
    private String mIcon;
    @SerializedName("data")
    private List<WeatherData> mList;

    public Hourly(String mSummary, String mIcon, List<WeatherData> mList) {
        this.mSummary = mSummary;
        this.mIcon = mIcon;
        this.mList = mList;
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

    public List<WeatherData> getmList() {
        return mList;
    }

    public void setmList(List<WeatherData> mList) {
        this.mList = mList;
    }
}

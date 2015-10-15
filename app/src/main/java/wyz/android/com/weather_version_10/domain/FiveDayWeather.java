package wyz.android.com.weather_version_10.domain;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by wangyuzhe on 10/8/15.
 */
public class FiveDayWeather implements Serializable {
    @SerializedName("city")
    private City mCity;
    @SerializedName("cod")
    private String mCod;
    @SerializedName("message")
    private String mMessage;
    @SerializedName("cnt")
    private String mCnt;
    @SerializedName("list")
    private List<CurrentWeather> mList;

    public FiveDayWeather(City mCity, String mCod, String mMessage, String mCnt, List<CurrentWeather> mList) {
        this.mCity = mCity;
        this.mCod = mCod;
        this.mMessage = mMessage;
        this.mCnt = mCnt;
        this.mList = mList;
    }

    public City getmCity() {
        return mCity;
    }

    public void setmCity(City mCity) {
        this.mCity = mCity;
    }

    public String getmCod() {
        return mCod;
    }

    public void setmCod(String mCod) {
        this.mCod = mCod;
    }

    public String getmMessage() {
        return mMessage;
    }

    public void setmMessage(String mMessage) {
        this.mMessage = mMessage;
    }

    public String getmCnt() {
        return mCnt;
    }

    public void setmCnt(String mCnt) {
        this.mCnt = mCnt;
    }

    public List<CurrentWeather> getmList() {
        return mList;
    }

    public void setmList(List<CurrentWeather> mList) {
        this.mList = mList;
    }
}

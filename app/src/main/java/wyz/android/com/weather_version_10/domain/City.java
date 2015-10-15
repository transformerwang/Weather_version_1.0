package wyz.android.com.weather_version_10.domain;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by wangyuzhe on 10/8/15.
 */
public class City implements Serializable {
    @SerializedName("id")
    private String mId;
    @SerializedName("name")
    private String mName;
    @SerializedName("coord")
    private Coord mCoord;
    @SerializedName("country")
    private String mCountry;
    @SerializedName("population")
    private String mPopulation;
    @SerializedName("sys")
    private Sys mSys;

    public City(String id, String name, Coord coord, String country, String population, Sys sys)
    {
        this.mId = id;
        this.mName = name;
        this.mCoord = coord;
        this.mCountry = country;
        this.mPopulation = population;
        this.mSys = sys;
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

    public Coord getmCoord() {
        return mCoord;
    }

    public void setmCoord(Coord mCoord) {
        this.mCoord = mCoord;
    }

    public String getmCountry() {
        return mCountry;
    }

    public void setmCountry(String mCountry) {
        this.mCountry = mCountry;
    }

    public String getmPopulation() {
        return mPopulation;
    }

    public void setmPopulation(String mPopulation) {
        this.mPopulation = mPopulation;
    }

    public Sys getmSys() {
        return mSys;
    }

    public void setmSys(Sys mSys) {
        this.mSys = mSys;
    }
}

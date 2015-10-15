package wyz.android.com.weather_version_10.domain;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by wangyuzhe on 10/8/15.
 */
public class Coord implements Serializable {
    @SerializedName("lon")
    private String mLon;
    @SerializedName("lat")
    private String mlat;

    public Coord(String lon, String lat)
    {
        this.mLon = lon;
        this.mlat = lat;
    }

    public String getmLon() {
        return mLon;
    }

    public void setmLon(String mLon) {
        this.mLon = mLon;
    }

    public String getMlat() {
        return mlat;
    }

    public void setMlat(String mlat) {
        this.mlat = mlat;
    }
}

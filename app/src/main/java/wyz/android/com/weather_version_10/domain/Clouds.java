package wyz.android.com.weather_version_10.domain;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by wangyuzhe on 10/8/15.
 */
public class Clouds implements Serializable {
    @SerializedName("all")
    private String mAll;

    public Clouds(String all)
    {
        this.mAll = all;
    }

    public String getmAll() {
        return mAll;
    }

    public void setmAll(String mAll) {
        this.mAll = mAll;
    }
}

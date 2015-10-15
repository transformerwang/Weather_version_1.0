package wyz.android.com.weather_version_10.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

import wyz.android.com.weather_version_10.domain.CurrentWeather;
import wyz.android.com.weather_version_10.domain.FiveDayWeather;
import wyz.android.com.weather_version_10.fragment.WeatherByCityFragment;

/**
 * Created by wangyuzhe on 10/10/15.
 */
public class ViewPagerAdatper extends FragmentStatePagerAdapter {

    private List<CurrentWeather> mListCurrent = new ArrayList<>();
    private List<FiveDayWeather> mListFiveDay = new ArrayList<>();

    public ViewPagerAdatper(FragmentManager fm, List<CurrentWeather> mListCurrent)
    {
        super(fm);
        this.mListCurrent = mListCurrent;
        //this.mListFiveDay = mListFiveDay;
    }


    @Override
    public Fragment getItem(int position) {
        CurrentWeather currentWeather = mListCurrent.get(position);
        //FiveDayWeather fiveDayWeather = mListFiveDay.get(position);
        return new WeatherByCityFragment(currentWeather);
    }

    @Override
    public int getCount() {
        return mListCurrent.size();
    }

}

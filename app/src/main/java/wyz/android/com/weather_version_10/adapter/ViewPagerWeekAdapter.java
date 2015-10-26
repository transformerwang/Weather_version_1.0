package wyz.android.com.weather_version_10.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import wyz.android.com.weather_version_10.domain.CurrentWeather;
import wyz.android.com.weather_version_10.fragment.WeatherWeekFragment;

/**
 * Created by wangyuzhe on 10/20/15.
 */
public class ViewPagerWeekAdapter extends FragmentStatePagerAdapter {

    private CurrentWeather mCurrentWeather;

    public ViewPagerWeekAdapter(FragmentManager fm, CurrentWeather currentWeather)
    {
        super(fm);
        this.mCurrentWeather = currentWeather;
    }

    @Override
    public Fragment getItem(int position) {
        return new WeatherWeekFragment(mCurrentWeather,position);
    }

    @Override
    public int getCount() {
        return 8;
    }
}

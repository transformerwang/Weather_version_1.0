package wyz.android.com.weather_version_10.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import butterknife.Bind;
import butterknife.ButterKnife;
import wyz.android.com.weather_version_10.R;
import wyz.android.com.weather_version_10.adapter.ViewPagerWeekAdapter;
import wyz.android.com.weather_version_10.domain.CurrentWeather;

/**
 * Created by wangyuzhe on 10/20/15.
 */
public class WeekWeatherActivity extends FragmentActivity {

    private CurrentWeather mCurrentWeather;

    @Bind(R.id.pager_week)
    ViewPager pagerWeek;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.weather_week_viewpager);

        ButterKnife.bind(this);

        Intent intent = getIntent();
        mCurrentWeather = (CurrentWeather)intent.getSerializableExtra("weather");
        int position = intent.getIntExtra("position",0);
        pagerWeek.setOffscreenPageLimit(5);
        pagerWeek.setAdapter(new ViewPagerWeekAdapter(getSupportFragmentManager(),mCurrentWeather));
        pagerWeek.setCurrentItem(position);
    }
}

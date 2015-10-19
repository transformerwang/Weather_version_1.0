package wyz.android.com.weather_version_10.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import wyz.android.com.weather_version_10.R;
import wyz.android.com.weather_version_10.adapter.ViewPagerAdatper;
import wyz.android.com.weather_version_10.domain.CurrentWeather;

/**
 * Created by wangyuzhe on 10/10/15.
 */
public class CurrentWeatherDetailActivity extends FragmentActivity {

    private List<CurrentWeather> mListCurrent = new ArrayList<>();

    @Bind(R.id.pager) ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.currentweather_detail);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        mListCurrent = (List<CurrentWeather>) intent.getSerializableExtra("current");
        int position = intent.getIntExtra("position", 0);


        viewPager.setOffscreenPageLimit(10);
        viewPager.setAdapter(new ViewPagerAdatper(getSupportFragmentManager(),mListCurrent));
        viewPager.setCurrentItem(position);
    }

    @Override
    public void onBackPressed() {
        if(viewPager.getCurrentItem() == 0)
        {
            super.onBackPressed();
        }
        else
        {
            viewPager.setCurrentItem(viewPager.getCurrentItem()-1);
        }
    }
}

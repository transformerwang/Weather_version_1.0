package wyz.android.com.weather_version_10.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

import com.google.gson.Gson;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import wyz.android.com.weather_version_10.R;
import wyz.android.com.weather_version_10.adapter.ViewPagerAdatper;
import wyz.android.com.weather_version_10.constant.Constant;
import wyz.android.com.weather_version_10.domain.CurrentWeather;
import wyz.android.com.weather_version_10.service.GetWeatherDataAsyncTask;
import wyz.android.com.weather_version_10.service.LoadWeatherDataCompletionListener;

/**
 * Created by wangyuzhe on 10/10/15.
 */
public class CurrentWeatherDetailActivity extends FragmentActivity implements LoadWeatherDataCompletionListener{

    private List<CurrentWeather> mListCurrent = new ArrayList<>();
    private List<URL> mListUrl = new ArrayList<URL>();

    @Bind(R.id.pager)
    ViewPager viewPager;
    @Bind(R.id.swipefresh)
    SwipeRefreshLayout swipeRefreshLayout;
    @Bind(R.id.linear)
    LinearLayout linearLayout;
    private int mCurrentPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.weather_detail);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        mListCurrent = (List<CurrentWeather>) intent.getSerializableExtra("current");
        final int position = intent.getIntExtra("position", 0);

        viewPager.setOffscreenPageLimit(10);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mCurrentPosition = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
        viewPager.setAdapter(new ViewPagerAdatper(getSupportFragmentManager(), mListCurrent));
        viewPager.setCurrentItem(position);
        viewPager.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                switch (event.getAction()) {
                    case MotionEvent.ACTION_MOVE:
                        swipeRefreshLayout.setEnabled(false);
                        break;
                    case MotionEvent.ACTION_UP:
                    case MotionEvent.ACTION_CANCEL:
                        swipeRefreshLayout.setEnabled(true);
                        break;
                }
                return false;
            }
        });

        try {

            SharedPreferences sharedPreferences = getSharedPreferences("session", Activity.MODE_PRIVATE);
            int length=0;
            while(sharedPreferences.getString("latlon_"+length,"")!="")
            {
                String latlon = sharedPreferences.getString("latlon_" + length, "");
                Log.e("a",latlon.substring(10,latlon.length()-1));
                URL url = new URL(Constant.DEFAULT_WEATHER_URL + latlon.substring(10,latlon.length()-1) +"?units=si&exclude=minutely");
                mListUrl.add(url);
                length++;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new GetWeatherDataAsyncTask(CurrentWeatherDetailActivity.this,CurrentWeatherDetailActivity.this).execute(mListUrl);
                Snackbar.make(linearLayout, "Refreshing now!", Snackbar.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void getWeatherDataFail() {
        Snackbar.make(linearLayout, "Please check your internet connection!", Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void getWeatherData(String[]WeatherData) {
        List<CurrentWeather> listCurrentWeather = new ArrayList<>();
        for(int i = 0; i < WeatherData.length; i++)
        {
            Gson gson = new Gson();
            CurrentWeather currentWeather = gson.fromJson(WeatherData[i], CurrentWeather.class);
            listCurrentWeather.add(currentWeather);
        }
        viewPager.setAdapter(new ViewPagerAdatper(getSupportFragmentManager(),listCurrentWeather));
        //viewPager.setCurrentItem(mCurrentPosition);
        swipeRefreshLayout.setRefreshing(false);
    }


}

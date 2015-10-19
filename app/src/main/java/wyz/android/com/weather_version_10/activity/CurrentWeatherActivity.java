package wyz.android.com.weather_version_10.activity;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.google.gson.Gson;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import wyz.android.com.weather_version_10.R;
import wyz.android.com.weather_version_10.adapter.RecyclerViewMainAdapter;
import wyz.android.com.weather_version_10.constant.Constant;
import wyz.android.com.weather_version_10.domain.CurrentWeather;
import wyz.android.com.weather_version_10.service.GetWeatherDataAsyncTask;
import wyz.android.com.weather_version_10.service.LoadWeatherDataCompletionListener;

public class CurrentWeatherActivity extends AppCompatActivity implements LoadWeatherDataCompletionListener{

    private RecyclerView.LayoutManager mLayoutManager;
    private List<CurrentWeather> mList = new ArrayList<>();
    private List<URL> mListUrl = new ArrayList<URL>();
    private URL mUrl_1;
    private URL mUrl_2;
    private URL mUrl_3;
    private URL mUrl_7;


    @Bind(R.id.main_layout)
    CoordinatorLayout cdLayout;
    @Bind(R.id.toolbar_main)
    android.support.v7.widget.Toolbar toolBar;
    @Bind(R.id.refresh_layout)
    android.support.v4.widget.SwipeRefreshLayout swipeRefreshLayout;
    @Bind(R.id.recycler_view_main)
    android.support.v7.widget.RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.currentweather_main);
        ButterKnife.bind(this);
        Snackbar.make(cdLayout,"Hello,I am snackbar...............!",Snackbar.LENGTH_LONG).show();

        setSupportActionBar(toolBar);
        toolBar.setNavigationIcon(R.drawable.icon_action_button);
        toolBar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                return false;
            }
        });

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                try {
                    mUrl_7 = new URL(Constant.DEFAULT_WEATHER_URL+ "36.36,114.29" + "?units=si&exclude=minutely&lang=zh");
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                mListUrl.add(mUrl_7);
                launchTask(mListUrl);
                Snackbar.make(cdLayout, "Refreshing now!", Snackbar.LENGTH_SHORT).show();
            }
        });

        recyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(CurrentWeatherActivity.this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(new RecyclerViewMainAdapter(mList, this));
        try {
            mUrl_1 = new URL(Constant.DEFAULT_WEATHER_URL+ "39.90, 116.39" + "?units=si&exclude=minutely&lang=zh");
            mUrl_2 = new URL(Constant.DEFAULT_WEATHER_URL+ "38.53,-77.02" + "?units=si&exclude=minutely&lang=zh");
            mUrl_3 = new URL(Constant.DEFAULT_WEATHER_URL+ "34.04,-118.15" + "?units=si&exclude=minutely&lang=zh");


            mListUrl.add(mUrl_1);
            mListUrl.add(mUrl_2);
            mListUrl.add(mUrl_3);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        launchTask(mListUrl);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void getWeatherData(String[] WeatherData) {
        List<CurrentWeather> listCurrentWeather = new ArrayList<>();
        for(int i = 0; i < WeatherData.length; i++)
        {
            Gson gson = new Gson();
            CurrentWeather currentWeather = gson.fromJson(WeatherData[i], CurrentWeather.class);
            listCurrentWeather.add(currentWeather);
        }
        RecyclerViewMainAdapter recyclerViewMainAdapter = new RecyclerViewMainAdapter(listCurrentWeather,CurrentWeatherActivity.this);
        recyclerView.setAdapter(recyclerViewMainAdapter);
        swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void getWeatherDataFail() {
        Snackbar.make(cdLayout, "Please check your internet connection!", Snackbar.LENGTH_LONG).show();
    }

    public void launchTask(List<URL> list)
    {
        GetWeatherDataAsyncTask getWeatherDataAsyncTask = new GetWeatherDataAsyncTask(this,this);
        getWeatherDataAsyncTask.execute(list);
    }
}

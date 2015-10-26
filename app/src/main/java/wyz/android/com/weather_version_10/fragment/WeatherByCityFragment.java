package wyz.android.com.weather_version_10.fragment;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v17.leanback.widget.HorizontalGridView;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import wyz.android.com.weather_version_10.R;
import wyz.android.com.weather_version_10.adapter.HorizontalGridViewAdapter;
import wyz.android.com.weather_version_10.adapter.RecyclerViewWeekAdapter;
import wyz.android.com.weather_version_10.domain.CurrentWeather;
import wyz.android.com.weather_version_10.service.DataHandler;

/**
 * Created by wangyuzhe on 10/10/15.
 */
public class WeatherByCityFragment extends Fragment{
    @Nullable
    @Bind(R.id.image_current_weather)
    ImageView imageView;
    @Bind(R.id.text_current_weather)
    TextView textCurrentWeather;
    @Bind(R.id.text_current_tempturature)
    TextView textCurrentTempturature;
    @Bind(R.id.recycler_view_week)
    RecyclerView recyclerViewWeek;
    @Bind(R.id.toolbar_main)
    Toolbar toolbarMain;
    @Bind(R.id.toolbar_title)
    TextView toolbarTitle;

    private URL mUrl_1;
    private URL mUrl_2;
    private URL mUrl_3;
    private List<URL> mList = new ArrayList<>();


    private CurrentWeather mCurrentWeather;
    private HorizontalGridView mHorizontalGridView;
    private int mPosition;
    private RecyclerView.LayoutManager mLayoutManager;


    public WeatherByCityFragment(CurrentWeather currentWeather, int position) {
        this.mCurrentWeather = currentWeather;
        this.mPosition = position;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.weather_detail_fragment, container, false);
        mHorizontalGridView = (HorizontalGridView) view.findViewById(R.id.horizontal_card);
        mHorizontalGridView.setWindowAlignment(HorizontalGridView.WINDOW_ALIGN_BOTH_EDGE);
        mHorizontalGridView.setAdapter(new HorizontalGridViewAdapter(mCurrentWeather));
        ButterKnife.bind(this, view);
        return view;
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        ButterKnife.bind(this, view);
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("session", Activity.MODE_PRIVATE);
        String city = sharedPreferences.getString("cityname_"+mPosition,"");
        toolbarTitle.setText(city);
        toolbarMain.setBackgroundColor(getResources().getColor(R.color.bluedark));
        bindData();//bind data for city
        mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerViewWeek.setHasFixedSize(true);
        recyclerViewWeek.setVerticalScrollBarEnabled(false);
        recyclerViewWeek.setLayoutManager(mLayoutManager);
        recyclerViewWeek.setAdapter(new RecyclerViewWeekAdapter(mCurrentWeather, getActivity()));
        //Picasso.with(getActivity()).load("http://www.easyicon.net/download/png/1070346/128/").into(imageView);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    public void bindData() {
        textCurrentWeather.setText(mCurrentWeather.getmCurrently().getmSummary());
        String temp = DataHandler.parseTemp(Double.valueOf(mCurrentWeather.getmCurrently().getmTemperature()));
        textCurrentTempturature.setText(temp + "°");
    }



}

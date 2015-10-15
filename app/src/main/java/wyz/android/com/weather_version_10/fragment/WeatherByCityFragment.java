package wyz.android.com.weather_version_10.fragment;

import android.os.Bundle;
import android.support.v17.leanback.widget.HorizontalGridView;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import butterknife.Bind;
import butterknife.ButterKnife;
import wyz.android.com.weather_version_10.R;
import wyz.android.com.weather_version_10.adapter.HorizontalGridViewAdapter;
import wyz.android.com.weather_version_10.domain.CurrentWeather;

/**
 * Created by wangyuzhe on 10/10/15.
 */
public class WeatherByCityFragment extends Fragment {
    @Bind(R.id.image_current_weather)
    ImageView imageView;


    private CurrentWeather mCurrentWeather;
    private HorizontalGridView horizontalGridView;
    //private FiveDayWeather mFiveDayWeahter;


    public WeatherByCityFragment(CurrentWeather currentWeather) {
        this.mCurrentWeather = currentWeather;
        //this.mFiveDayWeahter = fiveDayWeather;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.currentweather_fragment, container, false);
        horizontalGridView = (HorizontalGridView) view.findViewById(R.id.horizontal_card);
        horizontalGridView.setWindowAlignment(HorizontalGridView.WINDOW_ALIGN_BOTH_EDGE);
        horizontalGridView.setAdapter(new HorizontalGridViewAdapter());
        return view;
    }


    @Override
    public void onViewCreated(View view,Bundle savedInstanceState) {
        ButterKnife.bind(this, view);
        //Picasso.with(getActivity()).load("http://www.easyicon.net/download/png/1070346/128/").into(imageView);

    }

}

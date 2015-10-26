package wyz.android.com.weather_version_10.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.NumberFormat;

import butterknife.Bind;
import butterknife.ButterKnife;
import wyz.android.com.weather_version_10.R;
import wyz.android.com.weather_version_10.domain.CurrentWeather;
import wyz.android.com.weather_version_10.domain.WeatherData;
import wyz.android.com.weather_version_10.service.DataHandler;

/**
 * Created by wangyuzhe on 10/20/15.
 */
public class WeatherWeekFragment extends Fragment {

    @Bind(R.id.rain)
    TextView rain;
    @Bind(R.id.image_rain)
    ImageView imageRain;
    @Bind(R.id.week)
    TextView weekDay;
    @Bind(R.id.des)
    TextView description;
    @Bind(R.id.sunset)
    TextView sunset;
    @Bind(R.id.sunrise)
    TextView sunrise;
    @Bind(R.id.temperature)
    TextView temperature;
    @Bind(R.id.wind_speed)
    TextView windSpeed;
    @Bind(R.id.rain_probility)
    TextView rainProbility;
    @Bind(R.id.rain_inch)
    TextView rainInch;
    @Bind(R.id.humidity)
    TextView humidity;
    @Bind(R.id.pressure)
    TextView pressure;
    @Bind(R.id.dewpoint)
    TextView dewpoint;
    @Bind(R.id.visibility)
    TextView visibility;

    private CurrentWeather mCurrentWeather;
    private int mPosition;

    public WeatherWeekFragment(CurrentWeather currentWeather, int position) {
        this.mCurrentWeather = currentWeather;
        this.mPosition = position;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.weather_week_fragment, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        binddata();

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    public void binddata()
    {
        String date = DataHandler.parseWeek(mCurrentWeather.getmDaily().getmList().get(mPosition).getmTime(), mCurrentWeather.getmTimeZone());
        WeatherData data = mCurrentWeather.getmDaily().getmList().get(mPosition);
        if(mPosition == 0)
        {
            weekDay.setText("Today");
        }
        else
        {
            weekDay.setText(date);
        }

        description.setText(data.getmSummary());
        String sunSet =  DataHandler.parseTime(data.getmSunsetTime(),mCurrentWeather.getmTimeZone());
        String sunRise = DataHandler.parseTime(data.getmSunriseTime(), mCurrentWeather.getmTimeZone());
        sunset.setText(sunSet);
        sunrise.setText(sunRise);
        String tempMin = DataHandler.parseTemp(Double.valueOf(data.getmTemperatureMin()));
        String tempMax = DataHandler.parseTemp(Double.valueOf(data.getmTemperatureMax()));
        temperature.setText(tempMin+"°/"+tempMax+"°");
        windSpeed.setText(data.getmWindSpeed()+"mph");
        parseRain(data);

    }

    public void parseRain(WeatherData data)
    {
        if(!data.getmPrecipIntensity().equals("0"))
        {
            switch(data.getmPrecipType())
            {
                case "snow":
                    imageRain.setImageResource(R.mipmap.snow);
                    break;
                case "sleet":
                    imageRain.setImageResource(R.mipmap.sleet);
                    break;
                case "hail":
                    imageRain.setImageResource(R.mipmap.hail7);
                    break;
                default:
                    imageRain.setImageResource(R.mipmap.raindrops);
                    break;
            }
            rain.setText(data.getmPrecipType().toUpperCase());
            rainInch.setText(data.getmPrecipIntensity()+"in./h");
            NumberFormat nf = NumberFormat.getPercentInstance();
            rainProbility.setText(nf.format(Double.valueOf(data.getmPrecipProbability())));

        }
        NumberFormat nF = NumberFormat.getPercentInstance();
        humidity.setText(nF.format(Double.valueOf(data.getmHumidity())));
        pressure.setText(DataHandler.parseTemp(Double.valueOf(data.getmPressure()))+"mb");
        dewpoint.setText(DataHandler.parseTemp(Double.valueOf(data.getmDewPoint()))+"°");
        if( data.getmVisibility()!=null&&Double.valueOf(data.getmVisibility()) >= 10)
        {
            visibility.setText("10mi");
        }
        else if(data.getmVisibility()!=null)
        {
            visibility.setText(DataHandler.parseTemp(Double.valueOf(data.getmVisibility()))+"mi");
        }
        else
        {
            visibility.setText("N/A");
        }
    }

}

package wyz.android.com.weather_version_10.service;

import java.util.List;

import wyz.android.com.weather_version_10.R;
import wyz.android.com.weather_version_10.domain.CurrentWeather;

/**
 * Created by wangyuzhe on 10/10/15.
 */
public class DataHandler {

    public static int setCardViewBackground(List<CurrentWeather> list, int position)
    {
        String weatherDescription = list.get(position).getmWeather().get(0).getmMain();
        int backgroundColor;

        switch (weatherDescription)
        {
            case "Clouds":
                backgroundColor= R.color.grey;
                break;
            case "Clear":
                backgroundColor = R.color.orange;
                break;
            case "Rain":
                backgroundColor = R.color.blue;
                break;
            case "Fog":
                backgroundColor = R.color.green;
                break;
            case "Haze":
                backgroundColor = R.color.pink;
                break;
            case "Mist":
                backgroundColor = R.color.darkgrey;
                break;
            case "Snow":
                backgroundColor = R.color.greenyellow;
                break;
            case "Thunderstorm":
                backgroundColor = R.color.yellow;
                break;
            default:
                backgroundColor = R.color.black;
                break;
        }
        return backgroundColor;
    }
}

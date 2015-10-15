package wyz.android.com.weather_version_10.service;

/**
 * Created by wangyuzhe on 10/7/15.
 */
public interface LoadWeatherDataCompletionListener {

    public void getWeatherData(String[] WeatherData);
    public void getWeatherDataFail();
}

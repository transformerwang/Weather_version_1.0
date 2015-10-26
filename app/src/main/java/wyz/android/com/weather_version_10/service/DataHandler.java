package wyz.android.com.weather_version_10.service;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import wyz.android.com.weather_version_10.R;
import wyz.android.com.weather_version_10.domain.CurrentWeather;

/**
 * Created by wangyuzhe on 10/10/15.
 */
public class DataHandler {

    public static int setCardViewBackground(List<CurrentWeather> list, int position)
    {
        String weatherDescription = list.get(position).getmCurrently().getmSummary();
        int backgroundColor;

        switch (weatherDescription)
        {
            case "Partly Cloudy":
                backgroundColor= R.color.grey;
                break;
            case "Clear":
                backgroundColor = R.color.orange;
                break;
            case "Mostly Cloudy":
                backgroundColor = R.color.blue;
                break;
            case "Drizzle":
                backgroundColor = R.color.green;
                break;
            case "Rain":
                backgroundColor = R.color.pink;
                break;
            case "Scattered Light Rain":
                backgroundColor = R.color.darkgrey;
                break;
            case "Snow":
                backgroundColor = R.color.greenyellow;
                break;
            case "Overcast":
                backgroundColor = R.color.goldenrod;
                break;
            case "Thunderstorm":
                backgroundColor = R.color.yellow;
                break;
            case "Fog":
                backgroundColor = R.color.ivory;
                break;
            case "Sleet":
                backgroundColor = R.color.red;
                break;
            case "Cloudy":
                backgroundColor = R.color.blueviolet;
                break;
            default:
                backgroundColor = R.color.black;
                break;
        }
        return backgroundColor;
    }

    public static List<Address> parseCity(String lat, String lon, Context context)
    {
        Geocoder geocoder = new Geocoder(context);
        List<Address> list = new ArrayList<>();
        try {
            list = geocoder.getFromLocation(Double.valueOf(lat),Double.valueOf(lon),2);
            return list;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String parseTime(String time, String timezone)
    {
        Long  longtime = Long.parseLong(time) * 1000;
        SimpleDateFormat sd = new SimpleDateFormat("HH:mm");
        sd.setTimeZone(TimeZone.getTimeZone(timezone));
        String date = sd.format(new Date(longtime));
        return date;
    }

    public static String parseWeek(String time, String timezone)
    {
        Long longtime = Long.parseLong(time) * 1000;
        SimpleDateFormat sd = new SimpleDateFormat("EEEE");
        sd.setTimeZone(TimeZone.getTimeZone(timezone));
        String date = sd.format(new Date(longtime));
        return date;
    }

    public static String parseTemp(double temp)
    {
        int temp_1 = Integer.parseInt(new java.text.DecimalFormat("0").format(temp));
        String temp_2 = String.valueOf(temp_1);
        return temp_2;
    }
}

package wyz.android.com.weather_version_10.service;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.net.URL;
import java.util.List;

/**
 * Created by wangyuzhe on 10/7/15.
 */
public class GetWeatherDataAsyncTask extends AsyncTask<List<URL>, Integer, String[]> {

    private Context mContext;
    private LoadWeatherDataCompletionListener mLoadWeatherData;

    public GetWeatherDataAsyncTask(Context context, LoadWeatherDataCompletionListener loadWeatherData)
    {
        this.mContext = context;
        this.mLoadWeatherData = loadWeatherData;
    }

    @Override
    protected String[] doInBackground(List<URL>... params) {
        String[] JsonArray = new String[params[0].size()];
        for(int i = 0; i < params[0].size(); i++)
        {
            OkHttpClient okHttpClient = new OkHttpClient();
            Request request = new Request.Builder().url(params[0].get(i)).build();
            try {
                Response response = okHttpClient.newCall(request).execute();
                JsonArray[i] = response.body().string();
            } catch (IOException e) {
                Log.v("exception",e.getMessage());
                e.printStackTrace();
            }
        }
        return JsonArray;
    }

    @Override
    protected void onPostExecute(String[] strings) {
        super.onPostExecute(strings);
        if(mLoadWeatherData != null)
        {
            mLoadWeatherData.getWeatherData(strings);
        }
        else
        {
            mLoadWeatherData.getWeatherDataFail();
        }
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }
}


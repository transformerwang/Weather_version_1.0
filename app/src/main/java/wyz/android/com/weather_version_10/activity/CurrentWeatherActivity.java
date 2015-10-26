package wyz.android.com.weather_version_10.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.SharedPreferences;
import android.location.Address;
import android.location.Location;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.location.places.AutocompletePrediction;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.PlaceBuffer;
import com.google.android.gms.location.places.Places;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.gson.Gson;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import wyz.android.com.weather_version_10.R;
import wyz.android.com.weather_version_10.adapter.AutoCompleteAdapter;
import wyz.android.com.weather_version_10.adapter.RecyclerViewMainAdapter;
import wyz.android.com.weather_version_10.constant.Constant;
import wyz.android.com.weather_version_10.domain.CurrentWeather;
import wyz.android.com.weather_version_10.service.DataHandler;
import wyz.android.com.weather_version_10.service.GetWeatherDataAsyncTask;
import wyz.android.com.weather_version_10.service.LoadWeatherDataCompletionListener;
import wyz.android.com.weather_version_10.service.LocationService;

public class CurrentWeatherActivity extends AppCompatActivity implements LoadWeatherDataCompletionListener, GoogleApiClient.OnConnectionFailedListener,LocationService.LocationDetector{

    private RecyclerView.LayoutManager mLayoutManager;
    private List<CurrentWeather> mList = new ArrayList<>();
    private List<URL> mListUrl = new ArrayList<URL>();
    private AutoCompleteTextView mAutonCompletetTextView;
    private AutoCompleteAdapter mAdapter;
    protected GoogleApiClient mGoogleApiClient;
    private static final LatLngBounds BOUNDS_GREATER_SYDNEY = new LatLngBounds(new LatLng(-34.041458, 150.790100), new LatLng(-33.682247, 151.383362));
    private int mClienId = 0;
    private int mCityId = 0;
    private Location mLocation;
    private ImageButton mImageButton;

    @Bind(R.id.button)
    Button button;
    @Bind(R.id.main_layout)
    CoordinatorLayout cdLayout;
    @Bind(R.id.toolbar_main)
    android.support.v7.widget.Toolbar toolBar;
    @Bind(R.id.refresh_layout)
    android.support.v4.widget.SwipeRefreshLayout swipeRefreshLayout;
    @Bind(R.id.recycler_view_main)
    android.support.v7.widget.RecyclerView recyclerView;
    @Bind(R.id.float_button)
    android.support.design.widget.FloatingActionButton flButton;
    private Dialog dialog;
    private Boolean mLanguage = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.weather_citylist);
        ButterKnife.bind(this);

        setSupportActionBar(toolBar);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mLanguage = true;
            }
        });
        flButton = (FloatingActionButton) findViewById(R.id.float_button);
        flButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mGoogleApiClient = new GoogleApiClient.Builder(CurrentWeatherActivity.this)
                        .enableAutoManage(CurrentWeatherActivity.this, mClienId, CurrentWeatherActivity.this)
                        .addApi(Places.GEO_DATA_API)
                        .addOnConnectionFailedListener(CurrentWeatherActivity.this)
                        .build();

                View view = LayoutInflater.from(CurrentWeatherActivity.this).inflate(R.layout.weather_addcity,null);
                mImageButton = (ImageButton)view.findViewById(R.id.right_gps);
                mImageButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        LocationService locationService = new LocationService(CurrentWeatherActivity.this,CurrentWeatherActivity.this);
                        locationService.detectLocation();
                        dialog.dismiss();
                    }
                });

                mAutonCompletetTextView = (AutoCompleteTextView)view.findViewById(R.id.autoCompleteTextView);
                mAutonCompletetTextView.setThreshold(2);
                mAutonCompletetTextView.setOnItemClickListener(mAutocompleteClickListener);
                mAdapter = new AutoCompleteAdapter(CurrentWeatherActivity.this,mGoogleApiClient,BOUNDS_GREATER_SYDNEY,null);
                mAutonCompletetTextView.setAdapter(mAdapter);
                dialog = new Dialog(CurrentWeatherActivity.this,android.R.style.Theme_Material_Light_NoActionBar_Fullscreen);
                dialog.setCanceledOnTouchOutside(true);
                dialog.setContentView(view);
                dialog.show();

                mClienId++;
            }
        });


        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                launchTask(mListUrl);
                Snackbar.make(cdLayout, "Refreshing now!", Snackbar.LENGTH_SHORT).show();
            }
        });

        recyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(CurrentWeatherActivity.this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(new RecyclerViewMainAdapter(mList, this));
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


    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {
        Log.e("a", String.valueOf(connectionResult.getErrorCode()));

    }


    public void launchTask(List<URL> list)
    {
        GetWeatherDataAsyncTask getWeatherDataAsyncTask = new GetWeatherDataAsyncTask(this,this);
        getWeatherDataAsyncTask.execute(list);
    }

    private AdapterView.OnItemClickListener mAutocompleteClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            final AutocompletePrediction item = mAdapter.getItem(position);
            final String placeId = item.getPlaceId();
            dialog.dismiss();
            PendingResult<PlaceBuffer> placeResult = Places.GeoDataApi.getPlaceById(mGoogleApiClient, placeId);
            placeResult.setResultCallback(mUpdatePlaceDetailsCallback);
        }
    };


    private ResultCallback<PlaceBuffer> mUpdatePlaceDetailsCallback = new ResultCallback<PlaceBuffer>() {
        @Override
        public void onResult(PlaceBuffer places) {
            if(!places.getStatus().isSuccess())
            {
                places.release();
                return;
            }
            final Place place = places.get(0);

            SharedPreferences sharedPreferences = getSharedPreferences("session", Activity.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("cityname_"+mCityId,place.getName().toString());
            editor.putString("city_" + mCityId,place.getAddress().toString());
            editor.putString("latlon_" + mCityId, place.getLatLng().toString());
            Log.e("city", place.getName().toString());
            Log.e("address", place.getAddress().toString());
            mCityId++;
            String temp;
            editor.commit();
            try {

                if(mLanguage == true)
                {
                    temp = Constant.DEFAULT_WEATHER_URL + place.getLatLng().latitude + "," + place.getLatLng().longitude +"?units=si&exclude=minutely&lang=zh";

                }
                else {
                    temp = Constant.DEFAULT_WEATHER_URL + place.getLatLng().latitude + "," + place.getLatLng().longitude + "?units=si&exclude=minutely";
                }
                URL url = new URL(temp);
                mListUrl.add(url);
                launchTask(mListUrl);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            places.release();
            mGoogleApiClient.disconnect();
        }
    };

    @Override
    public void locationFound(Location location) {
        if(mLocation == location)
        {
            return;
        }
        mLocation = location;
        List<Address> city = DataHandler.parseCity(String.valueOf(location.getLatitude()), String.valueOf(location.getLongitude()),this);
        SharedPreferences sharedPreferences = getSharedPreferences("session", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("cityname_"+mCityId,city.get(0).getAdminArea());
        editor.putString("city_"+mCityId,city.get(0).getCountryName());
        editor.putString("latlon_"+mCityId,"aaaaaaaaaa" +location.getLatitude()+","+location.getLongitude()+"a");
        editor.commit();
        try {
            String temp;
            if(mLanguage == true)
            {
                temp = Constant.DEFAULT_WEATHER_URL + location.getLatitude() + "," + location.getLongitude() +"?units=si&exclude=minutely&lang=zh";

            }
            else
            {
                temp = Constant.DEFAULT_WEATHER_URL + location.getLatitude() + "," + location.getLongitude() +"?units=si&exclude=minutely";

            }
            URL url = new URL(temp);
            mListUrl.add(url);
            launchTask(mListUrl);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void locationNotFound(LocationService.FailureReason failureReason) {
        Toast.makeText(this,"Could not find location! Please make sure open GPS!",Toast.LENGTH_LONG);
        Log.e("Location","Location not found!");
    }
}

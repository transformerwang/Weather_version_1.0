package wyz.android.com.weather_version_10.service;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.util.Log;

/**
 * Created by wangyuzhe on 10/26/15.
 */
public class LocationService implements LocationListener {

    private Context mContext;
    private LocationDetector mLocationDetector;
    private LocationManager mLocationManager;
    private final int TIMEOUT_IN_MS = 10000;
    private boolean mIsDetectingLocation = false;

    public enum FailureReason{
        NO_PERMISSION,
        TIMEOUT
    }

    public interface LocationDetector{
        void locationFound(Location location);
        void locationNotFound(FailureReason failureReason);
    }

    public LocationService(Context context, LocationDetector locationDetector){
        mContext = context;
        mLocationDetector = locationDetector;
    }
    public void detectLocation(){
        if(mIsDetectingLocation == false){
            mIsDetectingLocation = true;

            if(mLocationManager == null){
                mLocationManager = (LocationManager) mContext.getSystemService(Context.LOCATION_SERVICE);
            }

            if(ContextCompat.checkSelfPermission(mContext, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED || Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
                mLocationManager.requestSingleUpdate(LocationManager.GPS_PROVIDER, this, null);
                startTimer();
            }
            else {
                endLocationDetection();
                mLocationDetector.locationNotFound(FailureReason.NO_PERMISSION);
            }
        }
        else{
            Log.d("time", "already trying to detect location");
        }
    }

    private void startTimer(){
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if(mIsDetectingLocation){
                    fallbackOnLastKnownLocation();
                }
            }
        }, TIMEOUT_IN_MS);

    }

    private void fallbackOnLastKnownLocation(){
        Location lastKnownLocation = null;

        if(ContextCompat.checkSelfPermission(mContext, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED || Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            lastKnownLocation = mLocationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        }

        if(lastKnownLocation != null){
            mLocationDetector.locationFound(lastKnownLocation);
        }
        else{
            mLocationDetector.locationNotFound(FailureReason.TIMEOUT);
        }

    }

    @Override
    public void onLocationChanged(Location location) {
        mLocationDetector.locationFound(location);
    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {

    }

    private void endLocationDetection(){
        if(mIsDetectingLocation) {
            mIsDetectingLocation = false;

            if(ContextCompat.checkSelfPermission(mContext, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED || Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
                mLocationManager.removeUpdates(this);
            }
        }
    }
}

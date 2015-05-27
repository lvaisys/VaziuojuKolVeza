package transport.psi.vu.mif.com.vezukolveza.TripManager;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;

import java.util.List;

import transport.psi.vu.mif.com.vezukolveza.DataManager.DataManager;
import transport.psi.vu.mif.com.vezukolveza.DataManager.GPSpoint;

public class GPSManager implements View.OnClickListener {
    private final Context context;

    private static final long MIN_TIME_BW_UPDATES = 1000 * 60 * 1;

    DataManager dataManager;

    boolean isGPSEnabled = false;
    boolean canGetLocation = false;
    boolean stop=false;

    public Location getCurrentLocation() {
        return currentLocation;
    }

    private Location currentLocation;

    protected LocationManager locationManager;
    protected LocationListener ll;

    public GPSManager(Context context) {
        this.context = context;
        locationManager = (LocationManager) context.getSystemService(context.LOCATION_SERVICE);
        ll = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                currentLocation = location;
            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {

            }

            @Override
            public void onProviderEnabled(String provider) {

            }

            @Override
            public void onProviderDisabled(String provider) {

            }
        };
    }

    public boolean isGPSEnabled(){
        isGPSEnabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
        return isGPSEnabled;
    }

    public void turnOnGPSTracker(){
        String beforeEnable = Settings.Secure.getString (context.getContentResolver(),
                Settings.Secure.LOCATION_PROVIDERS_ALLOWED);
        String newSet = String.format ("%s,%s",
                beforeEnable,
                LocationManager.GPS_PROVIDER);
        try {
            Settings.Secure.putString (context.getContentResolver(),
                    Settings.Secure.LOCATION_PROVIDERS_ALLOWED,
                    newSet);
            isGPSEnabled();
        } catch(Exception e) {}
    }
    public boolean startTracking (){
        if (isGPSEnabled()){

            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, MIN_TIME_BW_UPDATES , 0 , ll);
            canGetLocation = true;
            return true;
        }
        else{
            return false;
        }
    }
    public void stopTracking(){
        locationManager.removeUpdates(ll);
        canGetLocation = false;
        stop=true;
    }

    public GPSpoint getGPSPoint (){
        return new GPSpoint(currentLocation.hasSpeed(), currentLocation.getSpeed(), currentLocation.getLatitude(), currentLocation.getLongitude());
    }

    public void startSavingGPSCoordinates(){
        Runnable r = new Runnable() {
            @Override
            public void run() {
                while(!stop){
                    dataManager.AddGPSPoint(getGPSPoint());
                    try {
                        Thread.sleep(MIN_TIME_BW_UPDATES);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        };
        Thread t = new Thread(r);
        t.start();
    }

    @Override
    public void onClick(View v) {
        stop=true;
    }

    public float getAverageSpeed(){
        float speedSum = 0;
        int speedCount = 0;
        List<GPSpoint> points = dataManager.getListGPSPoints();
        for(GPSpoint point:points){
            if (point.isGotSpeed()){
                speedCount++;
                speedSum+=point.getSpeed();

            }
        }
        return speedSum/speedCount;
    }
}

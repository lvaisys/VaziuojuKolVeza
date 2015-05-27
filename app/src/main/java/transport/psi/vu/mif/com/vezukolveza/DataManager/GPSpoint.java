package transport.psi.vu.mif.com.vezukolveza.DataManager;

/**
 * Created by Laurynas on 2015-05-27.
 */
public class GPSpoint {
    public double getLongitude() {
        return longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public float getSpeed() {
        return speed;
    }

    public boolean isGotSpeed() {
        return gotSpeed;
    }

    private double longitude;
    private double latitude;
    private float speed;
    private boolean gotSpeed;

    public GPSpoint(boolean gotSpeed, float speed, double latitude, double longitude) {
        this.gotSpeed = gotSpeed;
        this.speed = speed;
        this.latitude = latitude;
        this.longitude = longitude;
    }
}

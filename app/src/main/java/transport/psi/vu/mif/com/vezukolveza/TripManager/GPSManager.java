package transport.psi.vu.mif.com.vezukolveza.TripManager;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;

public class GPSManager {
    public GPSManager() {

    }

    public Location getCurentLocation() {
        return curentLocation;
    }

    public void setCurentLocation(Location curentLocation) {
        this.curentLocation = curentLocation;
    }

    public Location curentLocation;
    public Location getLocation(){
        return curentLocation;
    }

}

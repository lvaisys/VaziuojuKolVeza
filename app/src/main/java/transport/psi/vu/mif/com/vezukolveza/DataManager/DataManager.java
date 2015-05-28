package transport.psi.vu.mif.com.vezukolveza.DataManager;

import java.util.List;

import transport.psi.vu.mif.com.vezukolveza.DataManager.GPSpoint;


public interface DataManager {
    void AddGPSPoint(GPSpoint gpsPoint);

    List<GPSpoint> getListGPSPoints();
}

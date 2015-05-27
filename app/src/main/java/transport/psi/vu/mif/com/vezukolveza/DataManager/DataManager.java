package transport.psi.vu.mif.com.vezukolveza.DataManager;

import java.util.List;

import transport.psi.vu.mif.com.vezukolveza.DataManager.GPSpoint;

/**
 * Created by Laurynas on 2015-05-27.
 */
public interface DataManager {
    void AddGPSPoint(GPSpoint gpsPoint);

    List<GPSpoint> getListGPSPoints();
}

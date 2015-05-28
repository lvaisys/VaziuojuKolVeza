package transport.psi.vu.mif.com.vezukolveza.DataManager;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by Tomas on 5/27/2015.
 */
public class Trip {
    private int id;
    private City fromCity;
    private City toCity;
    private GregorianCalendar date;
    private List<GPSpoint> points;
    private int freeSpaces;
    private int spacesLimit;
    private long time;

    public Trip(int id, City fromCity, City toCity) {
        this.id = id;
        this.fromCity = fromCity;
        this.toCity = toCity;
        this.time = 0;
        points = new ArrayList<GPSpoint>();
    }

    public City getFromCity() {
        return fromCity;
    }

    public void setFromCity(City fromCity) {
        this.fromCity = fromCity;
    }

    public City getToCity() {
        return toCity;
    }


    public void setToCity(City toCity) {
        this.toCity = toCity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public GregorianCalendar getDate() {
        return date;
    }

    public void setDate(GregorianCalendar date) {
        this.date = date;
    }

    public List<GPSpoint> getPoints() {
        return points;
    }

    public void setPoints(List<GPSpoint> points) {
        this.points = points;
    }

    public int getFreeSpaces() {
        return freeSpaces;
    }

    public void setFreeSpaces(int freeSpaces) {
        this.freeSpaces = freeSpaces;
    }

    public int getSpacesLimit() {
        return spacesLimit;
    }

    public void setSpacesLimit(int spacesLimit) {
        this.spacesLimit = spacesLimit;
    }

    public static Trip findTripById(int id, List<Trip> list) {
        for (Trip trip : list) {
            if (trip.getId() == id)
                return trip;
        }

        return null;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time += time;
    }

    public void increaseSpaces() {
        if(freeSpaces < spacesLimit) {
            freeSpaces++;
        }
    }

    public void decreaseSpaces() {
        if(freeSpaces > 0) {
            freeSpaces--;
        }
    }

}

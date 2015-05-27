package transport.psi.vu.mif.com.vezukolveza.Context;

import android.app.Application;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import transport.psi.vu.mif.com.vezukolveza.DataManager.City;
import transport.psi.vu.mif.com.vezukolveza.DataManager.Trip;

/**
 * Created by Tomas on 5/27/2015.
 */
public class ApplicationController extends Application {

    public ApplicationController() {
        fillTestData();
    }

    private static List<Trip> trips = new ArrayList<Trip>();
    private static List<City> cities = new ArrayList<City>();


    public static List<Trip> getTrips() {
        return trips;
    }

    public static List<City> getCities() {
        return cities;
    }

    /**
     * Metodas uzpildantis informacija
     * statine informacija.
     */
    public static void fillTestData() {

        cities.add(new City(0, "Kaunas"));
        cities.add(new City(1, "Vilnius"));
        cities.add(new City(2, "Klaipėda"));
        cities.add(new City(3, "Panevėžys"));
        cities.add(new City(4, "Šiauliai"));
        cities.add(new City(5, "Alytus"));
        cities.add(new City(6, "Telšiai"));

        //
        Trip trip = new Trip(0, cities.get(0), cities.get(1));
        trip.setDate(new GregorianCalendar(2015, 5, 4));
        trip.setSpacesLimit(4);
        trip.setFreeSpaces(4);

        trips.add(trip);

        //

        trip = new Trip(1, cities.get(1), cities.get(2));
        trip.setDate(new GregorianCalendar(2015, 4, 24));

        trip.setSpacesLimit(4);
        trip.setFreeSpaces(2);

        trips.add(trip);

        //

        trip = new Trip(2, cities.get(2), cities.get(5));
        trip.setDate(new GregorianCalendar(2015, 3, 20));

        trip.setSpacesLimit(6);
        trip.setFreeSpaces(4);

        trips.add(trip);

        //

        trip = new Trip(3, cities.get(5), cities.get(6));
        trip.setDate(new GregorianCalendar(2015, 4, 10));

        trip.setSpacesLimit(4);
        trip.setFreeSpaces(1);

        trips.add(trip);

        //



    }

}

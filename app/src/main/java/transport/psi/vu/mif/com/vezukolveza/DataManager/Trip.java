package transport.psi.vu.mif.com.vezukolveza.DataManager;

/**
 * Created by Tomas on 5/27/2015.
 */
public class Trip {
    private int id;
    private City fromCity;
    private City toCity;

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
}
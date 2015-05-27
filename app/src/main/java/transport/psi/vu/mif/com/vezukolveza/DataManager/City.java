package transport.psi.vu.mif.com.vezukolveza.DataManager;

/**
 * Created by Tomas on 5/27/2015.
 */
public class City {
    private String name;
    private long id;

    public City(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}

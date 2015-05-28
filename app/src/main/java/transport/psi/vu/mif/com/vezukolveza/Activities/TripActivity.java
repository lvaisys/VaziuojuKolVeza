package transport.psi.vu.mif.com.vezukolveza.Activities;

import android.app.FragmentManager;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import transport.psi.vu.mif.com.vezukolveza.Fragments.TripActivityFragment;
import transport.psi.vu.mif.com.vezukolveza.Fragments.TripInfoFragment;
import transport.psi.vu.mif.com.vezukolveza.R;

public class TripActivity extends ActionBarActivity {

    private TripActivityFragment tripActivityFragment;
    private TripInfoFragment tripInfoFragment;

    public int selectedTripId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trip);
        tripInfoFragment = new TripInfoFragment();
        selectedTripId = getIntent().getExtras().getInt("trip_id");

        tripActivityFragment = new TripActivityFragment();
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.popBackStack();

        fragmentManager
                .beginTransaction()
                .replace(R.id.fragment_trip, tripActivityFragment, "Trip")
                .addToBackStack("Trip")
                .commit();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_trip, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        return super.onOptionsItemSelected(item);
    }

    public void openTripInfo() {
        TripInfoFragment tripEditFragment = TripInfoFragment.newInstance();
        FragmentManager fragmentManager = getFragmentManager();


        fragmentManager
                .beginTransaction()
                .replace(R.id.fragment_trip, tripInfoFragment, "TripInfo")
                .addToBackStack("TripInfo")
                .commit();
    }

    public void openMainActivity(){
        Intent nextScreen = new Intent(getApplicationContext(), MainActivity.class);


        startActivity(nextScreen);
        this.finish();
    }
}

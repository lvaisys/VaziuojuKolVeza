package transport.psi.vu.mif.com.vezukolveza.Activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Spinner;

import java.util.List;

import transport.psi.vu.mif.com.vezukolveza.Context.ApplicationController;
import transport.psi.vu.mif.com.vezukolveza.DataManager.City;
import transport.psi.vu.mif.com.vezukolveza.DataManager.Trip;
import transport.psi.vu.mif.com.vezukolveza.Fragments.MainActivityFragment;
import transport.psi.vu.mif.com.vezukolveza.Fragments.TripEditFragment;
import transport.psi.vu.mif.com.vezukolveza.R;
import transport.psi.vu.mif.com.vezukolveza.TripManager.GPSManager;


public class MainActivity extends ActionBarActivity {
    private MainActivityFragment mainActivityFragment;
    private static final String ARG_PARAM = "trip_id";
    private TripEditFragment tripEditFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainActivityFragment = new MainActivityFragment();
        tripEditFragment = new TripEditFragment();

        FragmentManager fragmentManager = getFragmentManager();

        fragmentManager
                .beginTransaction()
                .replace(R.id.fragment_main, mainActivityFragment, "Main")
                .addToBackStack("Main")
                .commit();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();



        return super.onOptionsItemSelected(item);
    }

    public void openTripEdit() {
        Spinner spinner = (Spinner) findViewById(R.id.main_trip_list);
        int tripId = (int) spinner.getSelectedItemPosition();
        tripEditFragment = TripEditFragment.newInstance(tripId);
        FragmentManager fragmentManager = getFragmentManager();


        fragmentManager
                .beginTransaction()
                .replace(R.id.fragment_main, tripEditFragment, "TripEdit")
                .addToBackStack("TripEdit")
                .commit();
    }

    public void openTripStart(int tripId) {
        if(GPSManager.isGPSEnabled(getApplicationContext()))
        {
            Intent intent = new Intent(this, TripActivity.class);
            Bundle bundle = new Bundle();
            bundle.putInt(ARG_PARAM, tripId);
            intent.putExtras(bundle);

            startActivity(intent);
        } else {
            AlertDialog.Builder builder =
                    new AlertDialog.Builder(this);
            final String action = Settings.ACTION_LOCATION_SOURCE_SETTINGS;
            final String message = "Prašome įsijungti GPS tikslesnei informacijai surinkti";

            builder.setMessage(message)
                    .setPositiveButton("Taip",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface d, int id) {
                                    startActivity(new Intent(action));
                                    d.dismiss();
                                }
                            })
                    .setNegativeButton("Ne",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface d, int id) {
                                    d.cancel();
                                }
                            });
            builder.create().show();
        }

    }

}

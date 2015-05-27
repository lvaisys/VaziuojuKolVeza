package transport.psi.vu.mif.com.vezukolveza.Activities;

import android.app.FragmentManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import transport.psi.vu.mif.com.vezukolveza.Fragments.MainActivityFragment;
import transport.psi.vu.mif.com.vezukolveza.Fragments.TripEditFragment;
import transport.psi.vu.mif.com.vezukolveza.R;


public class MainActivity extends ActionBarActivity {
    private MainActivityFragment mainActivityFragment;
    private TripEditFragment tripEditFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainActivityFragment = new MainActivityFragment();
        tripEditFragment = new TripEditFragment();

        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.popBackStack();

        fragmentManager
                .beginTransaction()
                .replace(R.id.fragment_main, mainActivityFragment, "Main")
                .addToBackStack("Main")
                .commit();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void openTripEdit() {
        TripEditFragment tripEditFragment = TripEditFragment.newInstance();
        FragmentManager fragmentManager = getFragmentManager();


        fragmentManager
                .beginTransaction()
                .replace(R.id.fragment_main, tripEditFragment, "TripEdit")
                .addToBackStack("TripEdit")
                .commit();
    }
}

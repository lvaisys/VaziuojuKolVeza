package transport.psi.vu.mif.com.vezukolveza.Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import transport.psi.vu.mif.com.vezukolveza.Activities.MainActivity;
import transport.psi.vu.mif.com.vezukolveza.DataManager.City;
import transport.psi.vu.mif.com.vezukolveza.DataManager.Trip;
import transport.psi.vu.mif.com.vezukolveza.R;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment implements View.OnClickListener {

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        Button next = (Button) rootView.findViewById(R.id.edit_info_button);
        next.setOnClickListener(this);


        /**
         * Testiniai duomenys laikinai iki
         * kol reikes imti is duombazes
         */






        // use the SimpleCursorAdapter to show the
        // elements in a ListView


        /**
         * End
         */

        Spinner list = (Spinner) rootView.findViewById(R.id.main_trip_list);
        //TripCursorAdapter tripCursorAdapter = new TripCursorAdapter(getActivity(), trips);

        //list.setAdapter(tripCursorAdapter);


        return rootView;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.edit_info_button:
                MainActivity mainActivity = (MainActivity) getActivity();
                mainActivity.openTripEdit();
                break;
        }
    }
}

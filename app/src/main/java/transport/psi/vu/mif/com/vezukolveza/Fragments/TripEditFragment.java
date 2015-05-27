package transport.psi.vu.mif.com.vezukolveza.Fragments;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import transport.psi.vu.mif.com.vezukolveza.Context.ApplicationController;
import transport.psi.vu.mif.com.vezukolveza.DataManager.Trip;
import transport.psi.vu.mif.com.vezukolveza.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TripEditFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TripEditFragment extends Fragment {

    private static final String ARG_PARAM = "tripe_id";

    // TODO: Rename and change types of parameters
    private int tripId;
    private Trip trip;
    private TextView cityA;

    public static TripEditFragment newInstance(int id) {
        TripEditFragment fragment = new TripEditFragment();
        Bundle args = new Bundle();
        args.putInt("trip_id", id);
        fragment.setArguments(args);
        return fragment;
    }

    public TripEditFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            tripId = getArguments().getInt(ARG_PARAM);
            trip = Trip.findTripById(tripId, ApplicationController.getTrips());
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_trip_edit, container, false);
        cityA = (TextView) rootView.findViewById(R.id.city_name_a);

        if(trip != null) {
            cityA.setText(trip.getFromCity().getName());
        }

        return rootView;
    }


}

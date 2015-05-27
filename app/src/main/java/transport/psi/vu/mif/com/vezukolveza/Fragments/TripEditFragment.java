package transport.psi.vu.mif.com.vezukolveza.Fragments;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;

import transport.psi.vu.mif.com.vezukolveza.Activities.MainActivity;
import transport.psi.vu.mif.com.vezukolveza.Context.ApplicationController;
import transport.psi.vu.mif.com.vezukolveza.DataManager.Trip;
import transport.psi.vu.mif.com.vezukolveza.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TripEditFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TripEditFragment extends Fragment implements View.OnClickListener {

    private static final String ARG_PARAM = "trip_id";

    // TODO: Rename and change types of parameters
    private int tripId;
    private Trip trip;
    private TextView cityA;
    private TextView cityB;
    private TextView tripDate;
    private Button startTrip;

    public static TripEditFragment newInstance(int id) {
        TripEditFragment fragment = new TripEditFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM, id);
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
        cityB = (TextView) rootView.findViewById(R.id.city_name_b);
        tripDate = (TextView) rootView.findViewById(R.id.edit_trip_date);
        startTrip = (Button) rootView.findViewById(R.id.edit_start_trip);

        startTrip.setOnClickListener(this);


        if(trip != null) {
            cityA.setText(trip.getFromCity().getName());
            cityB.setText(trip.getToCity().getName());

            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            tripDate.setText(format.format(trip.getDate().getTime()));
        }

        return rootView;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.edit_start_trip:
                MainActivity activity = (MainActivity) getActivity();
                activity.openTripStart(tripId);
                break;
        }
    }
}

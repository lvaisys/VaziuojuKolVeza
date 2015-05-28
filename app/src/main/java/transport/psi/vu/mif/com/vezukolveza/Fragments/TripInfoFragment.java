package transport.psi.vu.mif.com.vezukolveza.Fragments;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import transport.psi.vu.mif.com.vezukolveza.Activities.TripActivity;
import transport.psi.vu.mif.com.vezukolveza.Context.ApplicationController;
import transport.psi.vu.mif.com.vezukolveza.R;
import transport.psi.vu.mif.com.vezukolveza.TripManager.GPSManager;


public class TripInfoFragment extends Fragment implements View.OnClickListener {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    TextView cityFromTV;
    TextView cityToTV;
    Button backBtn;
    TextView timeTV;
    TextView speedTV;


    private OnFragmentInteractionListener mListener;


    public static TripInfoFragment newInstance() {
        TripInfoFragment fragment = new TripInfoFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    public TripInfoFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         View rootView =inflater.inflate(R.layout.fragment_trip_info, container, false);
        backBtn = (Button)rootView.findViewById(R.id.backButton);
        backBtn.setOnClickListener(this);
        timeTV = (TextView) rootView.findViewById(R.id.textViewLaikas);

        speedTV = (TextView) rootView.findViewById(R.id.textViewVidGreitis);
        cityFromTV = (TextView) rootView.findViewById(R.id.textViewCityA);
        cityToTV = (TextView) rootView.findViewById(R.id.textViewCityB);
        TripActivity tripActivity = (TripActivity) getActivity();
        int id = tripActivity.selectedTripId;
        cityFromTV.setText(ApplicationController.getTrips().get(id).getFromCity().getName());
        float x =ApplicationController.getTrips().get(id).getTime() ;
        int hours = (int) (x / 3600000);
        int minutes = (int) (x - hours * 3600000) / 60000;
        int seconds = (int) (x - hours * 3600000 - minutes * 60000) / 1000;
        timeTV.setText(hours + ":" + minutes + ":" + seconds);
        speedTV.setText(Float.toString(GPSManager.getAverageSpeed(id)) + "(m/s)");
        cityToTV.setText(ApplicationController.getTrips().get(id).getToCity().getName());
        return rootView;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onClick(View v) {
        TripActivity tripActivity = (TripActivity) getActivity();
        tripActivity.openMainActivity();

    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }

}

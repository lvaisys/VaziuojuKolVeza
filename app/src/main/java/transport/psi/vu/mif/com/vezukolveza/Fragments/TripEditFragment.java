package transport.psi.vu.mif.com.vezukolveza.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import transport.psi.vu.mif.com.vezukolveza.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TripEditFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TripEditFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TripEditFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TripEditFragment newInstance() {
        TripEditFragment fragment = new TripEditFragment();
        Bundle args = new Bundle();

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
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_trip_edit, container, false);
    }


}

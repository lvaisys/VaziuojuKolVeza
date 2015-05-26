package transport.psi.vu.mif.com.vezukolveza.Fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import transport.psi.vu.mif.com.vezukolveza.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class TripActivityFragment extends Fragment {

    public TripActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_trip, container, false);
    }
}

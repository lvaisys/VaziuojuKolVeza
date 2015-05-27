package transport.psi.vu.mif.com.vezukolveza.Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.Chronometer.OnChronometerTickListener;
import android.widget.TextView;

import transport.psi.vu.mif.com.vezukolveza.Activities.TripActivity;
import transport.psi.vu.mif.com.vezukolveza.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class TripActivityFragment extends Fragment implements View.OnClickListener{

    public TripActivityFragment() {
    }
    Button endTripBtn;
    Chronometer timeElapsed;
    TextView tvElapsed;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView =inflater.inflate(R.layout.fragment_trip, container, false);
        endTripBtn = (Button) rootView.findViewById(R.id.end_trip_button);
        endTripBtn.setOnClickListener(this);
        tvElapsed = (TextView)rootView.findViewById(R.id.textViewElapsed);


        timeElapsed  = (Chronometer) rootView.findViewById(R.id.chronometer);
        timeElapsed.setOnChronometerTickListener(new OnChronometerTickListener(){
            @Override
            public void onChronometerTick(Chronometer cArg) {
                long time = SystemClock.elapsedRealtime() - cArg.getBase();
                int h   = (int)(time /3600000);
                int m = (int)(time - h*3600000)/60000;
                int s= (int)(time - h*3600000- m*60000)/1000 ;
                String hh = h < 10 ? "0"+h: h+"";
                String mm = m < 10 ? "0"+m: m+"";
                String ss = s < 10 ? "0"+s: s+"";
                cArg.setText(hh+":"+mm+":"+ss);
            }
        });
        timeElapsed.setBase(SystemClock.elapsedRealtime());
        timeElapsed.start();



        return rootView;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.end_trip_button:
                timeElapsed.stop();
                try
                {
                    long elapsedMillis = SystemClock.elapsedRealtime()
                            - timeElapsed.getBase();
                    tvElapsed.setText( (int)elapsedMillis);
                }
                catch (Exception ex){

                }




                TripActivity tripActivity = (TripActivity) getActivity();
                tripActivity.openTripInfo();
                break;
        }
    }
}

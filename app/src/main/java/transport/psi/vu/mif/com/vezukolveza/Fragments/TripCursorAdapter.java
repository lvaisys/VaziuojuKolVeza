package transport.psi.vu.mif.com.vezukolveza.Fragments;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import transport.psi.vu.mif.com.vezukolveza.DataManager.Trip;
import transport.psi.vu.mif.com.vezukolveza.R;


public class TripCursorAdapter extends BaseAdapter implements SpinnerAdapter {
    private Activity activity;
    private List<Trip> list;

    public TripCursorAdapter(Activity activity, List<Trip> list){
        this.activity = activity;
        this.list = list;
    }

    public int getCount() {
        return list.size();
    }

    public Object getItem(int position) {
        return list.get(position);
    }

    public long getItemId(int position) {
        return list.get(position).getId();
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        View spinView;
        if( convertView == null ){
            LayoutInflater inflater = activity.getLayoutInflater();
            spinView = inflater.inflate(R.layout.spin_layout, null);
        } else {
            spinView = convertView;
        }
        TextView t1 = (TextView) spinView.findViewById(R.id.spin_from);
        TextView t2 = (TextView) spinView.findViewById(R.id.spin_to);
        TextView t3 = (TextView) spinView.findViewById(R.id.spin_date);

        Trip trip = list.get(position);

        t1.setText(String.valueOf(trip.getFromCity().getName()));
        t2.setText(trip.getToCity().getName());

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        t3.setText(format.format(trip.getDate().getTime()));
        return spinView;
    }
}
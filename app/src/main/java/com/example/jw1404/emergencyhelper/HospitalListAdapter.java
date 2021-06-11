package com.example.jw1404.emergencyhelper;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by jw140 on 2018-02-28.
 */

public class HospitalListAdapter extends BaseAdapter {

    private Context context;
    private List<Hospital> hospitalsList;

    public HospitalListAdapter(Context context, List<Hospital> hospitalsList) {
        this.context = context;
        this.hospitalsList = hospitalsList;
    }

    @Override
    public int getCount() {
        return hospitalsList.size();
    }

    @Override
    public Object getItem(int position) {
        return hospitalsList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View b =View.inflate(context, R.layout.hospital, null);
        TextView hospitalName = (TextView) b.findViewById(R.id.hospitalName);
        TextView hospitalNumber = (TextView) b.findViewById(R.id.hospitalNumber);
        TextView hospitalPlace = (TextView) b.findViewById(R.id.hospitalPlace);

        hospitalName.setText(hospitalsList.get(position).getHospitalname());
        hospitalNumber.setText(hospitalsList.get(position).getHospitalnumber());
        hospitalPlace.setText(hospitalsList.get(position).getHospitalplace());
        b.setTag(hospitalsList.get(position).getHospitalname());
        return b;
    }
}


package com.example.jw1404.emergencyhelper;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by jw140 on 2018-03-01.
 */

public class PoliceListAdapter extends BaseAdapter {
    private Context context;
    private List<Police> policeList;

    public PoliceListAdapter(Context context, List<Police> policeList) {
        this.context = context;
        this.policeList = policeList;

    }

    @Override
    public int getCount() {
        return policeList.size();
    }

    @Override
    public Object getItem(int position) {
        return policeList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v =View.inflate(context, R.layout.police, null);
        TextView policeName = (TextView) v.findViewById(R.id.policeName);
        TextView policeNumber = (TextView) v.findViewById(R.id.policeNumber);
        TextView policePlace = (TextView) v.findViewById(R.id.policePlace);

        policeName.setText(policeList.get(position).getPolicename());
        policeNumber.setText(policeList.get(position).getPolicenumber());
        policePlace.setText(policeList.get(position).getPoliceplace());
        v.setTag(policeList.get(position).getPolicename());
        return v;
    }
}

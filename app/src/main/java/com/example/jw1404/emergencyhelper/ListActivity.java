package com.example.jw1404.emergencyhelper;

import android.app.FragmentManager;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity implements OnMapReadyCallback {

    private ListView noticeListView;
    private ListView noticeListView2;

    private HospitalListAdapter hadapter;
    private PoliceListAdapter padapter;
    private List<Hospital> hospitalList;
    private List<Police> policeList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        FragmentManager fragmentManager = getFragmentManager();
        MapFragment mapFragment = (MapFragment)fragmentManager
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        noticeListView = (ListView) findViewById(R.id.noticeListView);
        noticeListView2 = (ListView) findViewById(R.id.noticeListView);

        hospitalList = new ArrayList<Hospital>();
        hospitalList.add(new Hospital("AAA","QQQ","ZZZ"));
        hospitalList.add(new Hospital("BBB","DDD","TTT"));
        hadapter = new HospitalListAdapter(getApplicationContext(),hospitalList);
        noticeListView2.setAdapter(hadapter);

        policeList = new ArrayList<Police>();
        policeList.add(new Police("PPP","AAA","PPP"));
        policeList.add(new Police("PPP","AAA","PPP"));
        padapter = new PoliceListAdapter(getApplicationContext(),policeList);
        noticeListView.setAdapter(padapter);

        new BackgroundTaskk().execute();
        new BackgroundTask().execute();
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        LatLng BAGUIO = new LatLng(16.402491, 120.595932);
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(BAGUIO);
        markerOptions.title("BAGUIO");
        markerOptions.snippet("Gov.Pack RD");
        googleMap.addMarker(markerOptions);
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(BAGUIO));
        googleMap.animateCamera(CameraUpdateFactory.zoomTo(10));
    }

    private class BackgroundTask extends AsyncTask<Void, Void, String> {
        String target;

        @Override
        protected void onPreExecute() {
            target = "https://ehapplication.000webhostapp.com/HospitalList.php";
        }
        @Override
        protected String doInBackground(Void... voids) {
            try{
                URL url = new URL(target);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                String temp;
                StringBuilder stringBuilder = new StringBuilder();
                while ((temp = bufferedReader.readLine()) != null){
                    stringBuilder.append(temp + "\n");
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return stringBuilder.toString().trim();
            }catch (Exception e){
                e.printStackTrace();
            }
            return null;
        }
        @Override
        public void onProgressUpdate(Void... values){
            super.onProgressUpdate();
        }
        @Override
        public void onPostExecute(String result){
            try{
                JSONObject jsonObject = new JSONObject(result);
                JSONArray jsonArray = jsonObject.getJSONArray("response");
                int count = 0;
                String hospitalName,hospitalNumber,hospitalPlace;

                while (count < jsonArray.length()){
                    JSONObject object = jsonArray.getJSONObject(count);
                    hospitalName = object.getString("hospitalName");
                    hospitalNumber = object.getString("hospitalNumber");
                    hospitalPlace = object.getString("hospitalPlace");
                    Hospital hospital = new Hospital(hospitalName,hospitalNumber,hospitalPlace);
                    hospitalList.add(hospital);
                    count++;
                }

            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    class BackgroundTaskk extends AsyncTask<Void,Void,String>{
        String target;

        @Override
        protected void onPreExecute() {
            target = "https://ehapplication.000webhostapp.com/PoliceList.php";
        }
        @Override
        protected String doInBackground(Void... voids) {
            try{
                URL url = new URL(target);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                String temp;
                StringBuilder stringBuilder = new StringBuilder();
                while ((temp = bufferedReader.readLine()) != null){
                    stringBuilder.append(temp + "\n");
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return stringBuilder.toString().trim();
            }catch (Exception e){
                e.printStackTrace();
            }
            return null;
        }
        @Override
        public void onProgressUpdate(Void... values){
            super.onProgressUpdate();
        }
        @Override
        public void onPostExecute(String result){
            try{
                JSONObject jsonObject = new JSONObject(result);
                JSONArray jsonArray = jsonObject.getJSONArray("response");
                int count = 0;
                String PoliceName,PoliceNumber,PolicePlace;

                while (count <jsonArray.length()){
                    JSONObject object = jsonArray.getJSONObject(count);
                    PoliceName = object.getString("PoliceName");
                    PoliceNumber = object.getString("PoliceNumber");
                    PolicePlace = object.getString("PolicePlace");
                    Police police = new Police(PoliceName,PoliceNumber,PolicePlace);
                    policeList.add(police);
                    count++;
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

}

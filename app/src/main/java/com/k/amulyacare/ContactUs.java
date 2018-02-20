package com.k.amulyacare;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;



public class ContactUs extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    Button bt_message;

    FrameLayout fl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);
        bt_message=(Button)findViewById(R.id.enquairy_button);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        fl=(FrameLayout)findViewById(R.id.online_consultation);


      /*  MapFragment mMapFragment = MapFragment.newInstance();
        FragmentTransaction fragmentTransaction =
                getFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.my_container, mMapFragment);
        fragmentTransaction.commit();    */


      fl.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {

              Intent i=new Intent(ContactUs.this,Onlineconsultation.class);
              startActivity(i);
          }
      });


      bt_message.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {

              EditText et=(EditText)findViewById(R.id.enquairy_message);
              String s1=et.getText().toString();

              String mblNumVar = "9160261625";
              Intent smsMsgAppVar = new Intent(Intent.ACTION_VIEW);
              smsMsgAppVar.setData(Uri.parse("sms:" +  mblNumVar));
              smsMsgAppVar.putExtra("sms_body",s1);
              startActivity(smsMsgAppVar);
          }
      });
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng ll = new LatLng(14.669799, 77.593960);
        mMap.addMarker(new MarkerOptions().position(new LatLng(14.669799, 77.593960)).title("AMULYA CARE"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(ll));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(ll,14));
        MarkerOptions mo=new MarkerOptions();
        mo.position(ll);
        mo.title("AMULYA CARE");
        mo.snippet("11-914 Aravinda Nagar, Sharada Nagar Anantapuram, Andhra Pradesh \n" +
                "510051 anantapuram");
        mMap.addMarker(mo);
    }


}

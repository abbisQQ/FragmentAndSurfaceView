package com.abbisqq.fragmentandsurfaceview;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import layout.myFragment;

public class MainActivity extends AppCompatActivity implements myFragment.OnMyFragmentInteractionListener{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager manager = getSupportFragmentManager();
        Fragment fragment = manager.findFragmentById(R.id.fragmentContainer);
        if(fragment==null){
            fragment = new myFragment();
            FragmentTransaction transaction= manager.beginTransaction();
            transaction.add(R.id.fragmentContainer,fragment).commit();



        }


    }

    @Override
    public void OnMyFragmentInteraction(Uri uri) {

    }

    @Override
    protected void onPause() {
        super.onPause();

    }

    @Override
    protected void onResume() {
        super.onResume();

    }
}

package com.example.mariabirsanmc;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mariabirsanmc.R;

public class MainActivity extends AppCompatActivity {

    private Button accelerometer;
    private Button camera;
    private Button maps;
    private Button connection;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        connection= (Button) findViewById(R.id.connection);
        connection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openConnection();
            }
        });

        accelerometer = (Button) findViewById(R.id.accelerometer);
        accelerometer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAccelerometer();
            }
        });

        camera= (Button) findViewById(R.id.camera);
        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCamera();
            }
        });

        maps = (Button) findViewById(R.id.maps);
        maps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMaps();
            }
        });
        //link views with xml


    }

    public void openAccelerometer(){
        Intent intent = new Intent(this, Accelerometer.class);
        startActivity(intent);
    }
    public void openConnection(){
        Intent intent = new Intent(this, Connection.class);
        startActivity(intent);
    }

    public void openCamera(){
        Intent intent = new Intent(this, Camera.class);
        startActivity(intent);
    }

    public void openMaps(){
        Intent intent = new Intent(this, MapsActivity.class);
        startActivity(intent);
    }

    public void clickExit(View v)
    {
        moveTaskToBack(true);
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(1);}
}
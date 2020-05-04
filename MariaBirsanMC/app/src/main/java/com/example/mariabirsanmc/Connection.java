package com.example.mariabirsanmc;

import android.content.Context;
import android.media.Image;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mariabirsanmc.R;

public class Connection extends AppCompatActivity {

    //Views
    ImageView mConStatusIv;
    TextView mConStatusTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //link views with xml
        mConStatusTv = findViewById(R.id.conStatusTv);
        checkNetworkConnectionStatus();
    }

    private void checkNetworkConnectionStatus() {
        boolean wifiConnected;
        boolean mobileConnected;
        ConnectivityManager connMgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeInfo = connMgr.getActiveNetworkInfo();
        if (activeInfo != null && activeInfo.isConnected()){ //connected with either mobile or wifi
            wifiConnected = activeInfo.getType() == ConnectivityManager.TYPE_WIFI;
            mobileConnected = activeInfo.getType() == ConnectivityManager.TYPE_MOBILE;
            if (wifiConnected){ //wifi connected
                mConStatusIv.setImageResource(R.drawable.wifi);
                mConStatusTv.setText("Connected with Wifi");
            }
            else if (mobileConnected){ //mobile data connected
                mConStatusIv.setImageResource(R.drawable.mobile);
                mConStatusTv.setText("Connected with Mobile Data Connection");
            }
        }
        else { //no internet connection
            mConStatusIv.setImageResource(R.drawable.nosignal);
            mConStatusTv.setText("No internet connection");
        }
    }
}
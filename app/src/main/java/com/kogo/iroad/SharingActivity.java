package com.kogo.iroad;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SharingActivity extends AppCompatActivity {

    private TextView textview_myLocationltlng, textviewCurrentTempC, textViewWindKph, textViewHumidity, textViewCloud;
    private Button buttonShareWp;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sharing);

        buttonShareWp = findViewById(R.id.buttonShareWp);
        textview_myLocationltlng = findViewById(R.id.textview_myLocationltlng);
        textviewCurrentTempC = findViewById(R.id.textviewCurrentTempC);
        textViewWindKph = findViewById(R.id.textViewWindKph);
        textViewHumidity = findViewById(R.id.textViewHumidity);
        textViewCloud = findViewById(R.id.textViewCloud);

        String myLocationltlng = getIntent().getStringExtra("myLocationltlng");
        String currentTempC = getIntent().getStringExtra("currentTempC");
        String wind_kph = getIntent().getStringExtra("wind_kph");
        String humidity = getIntent().getStringExtra("humidity");
        String cloud = getIntent().getStringExtra("cloud");

        textview_myLocationltlng.setText("My Location: " + myLocationltlng);
        textviewCurrentTempC.setText("Current Temp C: : " + currentTempC);
        textViewWindKph.setText("Wind Kph: " + wind_kph);
        textViewHumidity.setText("Humadity: " + humidity);
        textViewCloud.setText("Cloud: " + cloud);

        buttonShareWp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // https://stackoverflow.com/questions/12952865/how-to-share-text-to-whatsapp-from-my-app
                Intent whatsappIntent = new Intent(Intent.ACTION_SEND);
                whatsappIntent.setType("text/plain");
                whatsappIntent.setPackage("com.whatsapp");
                whatsappIntent.putExtra(Intent.EXTRA_TEXT, "My Location: " + myLocationltlng + "\nCurrent Temp C: " + currentTempC + "\nWind Kph: " + wind_kph + "\nHumadity: " + humidity + "\nCloud: "+ cloud);
                try {
                    SharingActivity.this.startActivity(whatsappIntent);
                } catch (android.content.ActivityNotFoundException ex) {
                    // ToastHelper.MakeShortText("Whatsapp have not been installed.");
                }
            }
        });


    }
}
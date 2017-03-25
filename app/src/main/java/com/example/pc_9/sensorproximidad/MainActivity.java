package com.example.pc_9.sensorproximidad;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaActionSound;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements SensorEventListener{

    TextView texto;
    RelativeLayout fondo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SensorManager miSensor = (SensorManager) getSystemService(SENSOR_SERVICE);
        miSensor.registerListener(this,miSensor.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
                SensorManager.SENSOR_DELAY_UI);
        texto = (TextView) findViewById(R.id.texto);
        texto.setTextColor(Color.WHITE);
        fondo = (RelativeLayout) findViewById(R.id.activity_main);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        // Toast.makeText(this,"Proximidad: " + sensorEvent.values[0],Toast.LENGTH_SHORT).show();
        int x = (int)sensorEvent.values[0];
        int y = (int)sensorEvent.values[1];
        int z = (int)sensorEvent.values[2];
        String valor = "Proximidad: \n" + x + ",\n " + y+ ",\n " + z;
        texto.setText(valor);

        fondo.setBackgroundColor(Color.rgb(x*20,y*20,z*20));

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}

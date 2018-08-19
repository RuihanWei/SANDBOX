package wave.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements SensorEventListener{

    private  TextView xAcc, yAcc, zAcc;
    private Sensor sensor;
    private SensorManager sensorM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sensorM = (SensorManager) getSystemService(SENSOR_SERVICE);

        sensor = sensorM.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        sensorM.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL);

        xAcc = (TextView)findViewById(R.id.xAcc);
        yAcc = (TextView)findViewById(R.id.yAcc);
        zAcc = (TextView)findViewById(R.id.zAcc);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        xAcc.setText((int) event.values[0]);
        yAcc.setText((int) event.values[1]);
        zAcc.setText((int) event.values[2]);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }
}

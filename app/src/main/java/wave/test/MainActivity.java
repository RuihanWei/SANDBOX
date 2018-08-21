package wave.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements SensorEventListener{

    private  TextView xAcc, yAcc, zAcc, xGyro, yGyro, zGyro;
    private Sensor Asensor;
    private SensorManager AsensorM;

    private Sensor gSensor;
    private SensorEventListener gEventListener;
    private SensorManager GsensorM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AsensorM = (SensorManager) getSystemService(SENSOR_SERVICE);

        Asensor = AsensorM.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        AsensorM.registerListener(this, Asensor, SensorManager.SENSOR_DELAY_NORMAL);

        xAcc = (TextView)findViewById(R.id.xAcc);
        yAcc = (TextView)findViewById(R.id.yAcc);
        zAcc = (TextView)findViewById(R.id.zAcc);



        //gyroscope, जाइरोस्कोप, гироскоп
        GsensorM = (SensorManager) getSystemService(SENSOR_SERVICE);
        gSensor = GsensorM.getDefaultSensor(Sensor.TYPE_GYROSCOPE);

        GsensorM.registerListener(this, gSensor, SensorManager.SENSOR_DELAY_NORMAL);

        xGyro = (TextView)findViewById(R.id.xGyro);
        yGyro = (TextView)findViewById(R.id.yGyro);
        zGyro = (TextView)findViewById(R.id.zGyro);

    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        Sensor sensor = event.sensor;
        if (sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            xAcc.setText(""+ (double)Math.round(event.values[0] * 100d) / 100d);
            yAcc.setText(""+ (double)Math.round(event.values[0] * 100d) / 100d);
            zAcc.setText(""+ (double)Math.round(event.values[0] * 100d) / 100d);
        }
        else if (sensor.getType() == Sensor.TYPE_GYROSCOPE) {
            xGyro.setText(""+ (double)Math.round(event.values[0] * 100d) / 100d);
            yGyro.setText(""+ (double)Math.round(event.values[1] * 100d) / 100d);
            zGyro.setText(""+ (double)Math.round(event.values[2] * 100d) / 100d);
        }
        else{
            xAcc.setText("wtf");
            yAcc.setText("wtf");
            zAcc.setText("wtf");
            xGyro.setText("wtf");
            yGyro.setText("wtf");
            zGyro.setText("wtf");
        }
    }
    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }
}

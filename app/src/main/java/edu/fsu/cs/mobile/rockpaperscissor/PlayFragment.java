package edu.fsu.cs.mobile.rockpaperscissor;


import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;


/**
 * A simple {@link Fragment} subclass.
 */
//public class PlayFragment extends Fragment {
//
//
//    public PlayFragment() {
//        // Required empty public constructor
//    }
//
//
////    @Override
////    public View onCreateView(LayoutInflater inflater, ViewGroup container,
////                             Bundle savedInstanceState) {
////        // Inflate the layout for this fragment
////        return inflater.inflate(R.layout.fragment_play, container, false);
////    }
//
//}

public class PlayFragment extends Fragment implements SensorEventListener {

    private SensorManager sensorManager;
    private Sensor accelerometer;
    private float threshold = 0;
    private float avgAccel = 0;

    RadioGroup throwChoices = (RadioGroup) getActivity().findViewById(R.id.throwChoices);
    RadioButton cRock = (RadioButton) getActivity().findViewById(R.id.radioButton_rock);
    RadioButton cPaper = (RadioButton) getActivity().findViewById(R.id.radioButton_paper);
    RadioButton cScissors = (RadioButton) getActivity().findViewById(R.id.radioButton_scissors);

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_inflate, container, false);

        sensorManager = (SensorManager) getActivity().getSystemService(Context.SENSOR_SERVICE);
        if (sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER) != null){
            //accelerometer retrieved
            accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
            sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
            threshold = accelerometer.getMaximumRange() / 2;
        }
        else {
            //accelerometer not retrieved
        }

        return v;
    }
    public void onResume(){
        super.onResume();
        sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
    }

    public void onPause(){
        super.onPause();
        sensorManager.unregisterListener(this);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy){

    }

    @Override
    public void onSensorChanged(SensorEvent event){
        avgAccel = (Math.abs(event.values[0]) + Math.abs(event.values[1]) + Math.abs(event.values[2])) / 3;
        if (avgAccel > threshold){
            //check which choice is selected and push it to match up with the other user

            //replace this to work with whatever user selection method we use
            int selectedId = throwChoices.getCheckedRadioButtonId();
            RadioButton playerChoice = (RadioButton) getActivity().findViewById(selectedId);

            if (playerChoice == cRock){
                //return 0 to PlayActivity
            }
            else if (playerChoice == cPaper){
                //return 1 to PlayActivity
            }
            else if (playerChoice == cScissors){
                //return 2 to PlayActivity
            }
        }
    }
}
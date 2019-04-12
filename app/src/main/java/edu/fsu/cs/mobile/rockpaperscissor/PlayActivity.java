package edu.fsu.cs.mobile.rockpaperscissor;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.Random;


public class PlayActivity extends AppCompatActivity implements SensorEventListener{

    static public boolean human = true;
    Bundle bundle;
    private SensorManager sensorManager;
    private Sensor accelerometer;
    private float threshold = 0;

    RadioGroup throwChoices;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        throwChoices = (RadioGroup) findViewById(R.id.throwChoices);
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        if (sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER) != null) {
            //accelerometer retrieved
            accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
            sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
            threshold = 10;
        } else {
            Toast.makeText(this, "Accelerometer not retrieved", Toast.LENGTH_SHORT).show();
        }

        bundle = getIntent().getExtras();


        //if (human == true){


        //}

    }

    int getRandomThrow() {
        Random randomGenerator = new Random();
        return randomGenerator.nextInt(3);
    }



    //returns 1 for player 1 winner, returns 2 for player 2 winner, return 0 for tie
    int getWinner(int p1move, int p2move) {
        if (p1move == p2move) return 0;
        //rock
        if (p1move == 0)
        {
            if (p2move == 1) return 1;
            else return 2;
        }
        //paper
        if (p1move == 1)
        {
            if (p2move == 0) return 1;
            else return 2;
        }
        //scissors
        if (p1move == 2)
        {
            if (p2move == 1) return 1;
            else return 2;
        }

        //The code will never reach this point but java doesn't know that so it was yelling at me
        return 0;
    }
    //pass this function the winner of the game to make an appropriate toast,
    //preferably through [ winnerToast(getWinner(player1Move, player2Move)) ]
//or                 [ winnerToast(getWinner(player1Move, getRandomThrow()))  ]
    void winnerToast(int winner)
    {
        Log.d("debug", "inside winnerToast");
        if (winner == 1)
        {
            Log.d("debug", "winner was 1, printing toast");
            Toast toast=Toast.makeText(getApplicationContext(),"Player 1 is the winner!", Toast.LENGTH_SHORT);
            toast.show();
        }
        else if (winner == 2)
        {
            Log.d("debug", "winner was 1, printing toast");
            Toast toast=Toast.makeText(getApplicationContext(),"Player 2 is the winner!", Toast.LENGTH_SHORT);
            toast.show();
        }
        else
        {

            Log.d("debug", "winner was 1, printing toast");
            Toast toast=Toast.makeText(getApplicationContext(),"Draw!", Toast.LENGTH_SHORT);
            toast.show();
        }
    }


    //this is an on click listener for a button that is only used for testing

    //in the final version, the sensor listener will be used instead of this on click listener
    //this means that the body of this function will be put inside that listener.


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
        float accelX = Math.abs(event.values[0]);
        float accelY = Math.abs(event.values[1]);
        float accelZ = Math.abs(event.values[2]);
        //Toast.makeText(this, accelX + ", " + accelY + ", " + accelZ, Toast.LENGTH_SHORT).show();
        if (accelX > threshold || accelY > threshold || accelZ > threshold){
            //Toast.makeText(this, accelX + ", " + accelY + ", " + accelZ + ", " + threshold, Toast.LENGTH_SHORT).show();
            RadioGroup rg = findViewById(R.id.throwChoices);
            int selectedId = throwChoices.getCheckedRadioButtonId();
            RadioButton playerChoice = (RadioButton) findViewById(selectedId);

            if (rg.getCheckedRadioButtonId() == -1)
            {
                Toast toast=Toast.makeText(getApplicationContext(),"You need to choose a throw!", Toast.LENGTH_SHORT);
                toast.show();
                return;
            }

            RadioButton rb = findViewById(rg.getCheckedRadioButtonId());

            //call startActivity(myintent) when we want to switch to lobby
            Intent myintent = new Intent(this, lobbyActivity.class);

            int chosenThrow = -1;

            if (rb.getId() == R.id.radioButton_rock)
            {
                chosenThrow = 0;
            }
            if (rb.getId() == R.id.radioButton_paper)
            {
                chosenThrow = 1;
            }
            else
            {
                chosenThrow = 2;
            }


            //if (bundle.getBoolean("CPU" == true))
            //          ^^^^^^
            //  this is what this if statement will look like once we have PvP

            if (true)
            {
                //this should print out the winner
                Log.d("debug", "running winnerToast");
                winnerToast(getWinner(chosenThrow, getRandomThrow()));

                //
                // this is where we would send data to firebase
                //

                startActivity(myintent);
            }
            else
            {
                startActivity(myintent);
            }
        }
    }


    /*//This will determine a winner,
    //RIGHT NOW it only works for the CPU but in theory player versus player will also be run
    //through this function
    public void KevinsThingyTest(View view) {
        //this code will run inside the sensor listener
        RadioGroup rg = findViewById(R.id.throwChoices);
        if (rg.getCheckedRadioButtonId() == -1)
        {
            Toast toast=Toast.makeText(getApplicationContext(),"You need to choose a throw!", Toast.LENGTH_SHORT);
            toast.show();
            return;
        }

        RadioButton rb = findViewById(rg.getCheckedRadioButtonId());

        //call startActivity(myintent) when we want to switch to lobby
        Intent myintent = new Intent(this, lobbyActivity.class);

        int chosenThrow = -1;

            if (rb.getId() == R.id.radioButton_rock)
        {
            chosenThrow = 0;
        }
        if (rb.getId() == R.id.radioButton_paper)
        {
            chosenThrow = 1;
        }
        else
        {
            chosenThrow = 2;
        }


        //if (bundle.getBoolean("CPU" == true))
        //          ^^^^^^
        //  this is what this if statement will look like once we have PvP

        if (true)
        {
            //this should print out the winner
            Log.d("debug", "running winnerToast");
            winnerToast(getWinner(chosenThrow, getRandomThrow()));

            //
            // this is where we would send data to firebase
            //

            startActivity(myintent);
        }
        else
        {
            startActivity(myintent);
        }
        return;
    }*/

    public void exitPlay(View view) {
        //player exits game
        //other player automatically wins

        Intent myintent = new Intent(this, lobbyActivity.class);
        startActivity(myintent);

    }
}

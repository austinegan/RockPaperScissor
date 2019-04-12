package edu.fsu.cs.mobile.rockpaperscissor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class LeaderBoardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leader_board);

        //future implementation: sort leaders from Users section of firebase, sorted by total wins or win percentage
    }
}

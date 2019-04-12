package edu.fsu.cs.mobile.rockpaperscissor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class lobbyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lobby);
        //button that send user into a instant play vs computer
        Button instantPlay = (Button) findViewById(R.id.instant_play);
        instantPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(lobbyActivity.this, PlayActivity.class));
            }
        });
    }

    public void logOut(View view) {
        startActivity(new Intent(lobbyActivity.this, LoginActivity.class));

    }

    public void exitPlay(View view) {
        startActivity(new Intent(lobbyActivity.this, LoginActivity.class));
    }
}
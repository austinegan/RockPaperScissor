package edu.fsu.cs.mobile.rockpaperscissor;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.firebase.auth.FirebaseAuth;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class LoginActivity extends AppCompatActivity  {
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        final TextView loginFieldUser = findViewById(R.id.login_user);
        final TextView loginFieldPass = findViewById(R.id.login_pass);
        final TextView registerFieldUser = findViewById(R.id.login_user);
        final TextView registerFieldPass = findViewById(R.id.login_pass);
        final String loginUserValue = loginFieldUser.getText().toString();
        final String loginPassValue = loginFieldPass.getText().toString();
        final String registerUserValue = registerFieldUser.getText().toString();
        final String registerPassValue = registerFieldPass.getText().toString();

        Button login;
        login = findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                //check that the username and password are correct, if not, exit this onclick, toast that they are not correct
                //Toast.makeText(getApplicationContext(), "I'm in the onClick for the login button", Toast.LENGTH_LONG).show();\
                Log.i("AUSTIN", "login button clicked");

                Log.i("AUSTIN", "Username = " + loginUserValue);
                Log.i("AUSTIN", "Password = " + loginPassValue);
                //User thisUser = new User(loginUserValue, loginPassValue, 0,0,0);
                //myRef.child("Users").setValue(thisUser);
                Intent i = new Intent(getApplicationContext(), PlayActivity.class);
                startActivity(i);
            }
        });

        Button register;
        register = findViewById(R.id.register);
        register.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Log.i("AUSTIN", "register button clicked");

                Log.i("AUSTIN", "Username = " + registerUserValue);
                Log.i("AUSTIN", "Password = " + registerPassValue);
                User thisUser = new User(registerUserValue, registerPassValue, 0,0,0);
                myRef.child("Users").setValue(thisUser);
                Intent i = new Intent(getApplicationContext(), PlayActivity.class);
                startActivity(i);
            }
        });
    }



}

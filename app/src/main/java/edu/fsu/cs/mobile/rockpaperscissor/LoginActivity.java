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
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class LoginActivity extends AppCompatActivity  {
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("Users");
//    DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
//    mDatabase.push();

//    myRef.setValue();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
//        myRef.setValue("test");


        DatabaseReference connectedRef = FirebaseDatabase.getInstance().getReference(".info/connected");
        connectedRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                boolean connected = snapshot.getValue(Boolean.class);
                if (connected) {
                    Log.d("AUSTIN", "connected");
                } else {
                    Log.d("AUSTIN", "not connected");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.w("AUSTIN", "Listener was cancelled");
            }
        });

        final TextView loginFieldUser = findViewById(R.id.login_user);
        final TextView loginFieldPass = findViewById(R.id.login_pass);
        final TextView registerFieldUser = findViewById(R.id.regUser);
        final TextView registerFieldPass = findViewById(R.id.RegPass);

        Button login;
        login = findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                //check that the username and password are correct, if not, exit this onclick, toast that they are not correct
                //Toast.makeText(getApplicationContext(), "I'm in the onClick for the login button", Toast.LENGTH_LONG).show();\
                Log.i("AUSTIN", "login button clicked");
                String loginUserValue = loginFieldUser.getText().toString();
                String loginPassValue = loginFieldPass.getText().toString();
                Log.i("AUSTIN", "Username = " + loginUserValue);
                Log.i("AUSTIN", "Password = " + loginPassValue);
                Intent i = new Intent(getApplicationContext(), lobbyActivity.class);
                startActivity(i);
            }
        });

        Button register;
        register = findViewById(R.id.register);
        register.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Log.i("AUSTIN", "register button clicked");
                String registerPassValue = registerFieldPass.getText().toString();
                String registerUserValue = registerFieldUser.getText().toString();
                Log.i("AUSTIN", "Username = " + registerUserValue);
                Log.i("AUSTIN", "Password = " + registerPassValue);

//                String key  myRef.child("Users").push().getKey();
//                Map<String, User> childUpdates = newHasMap<>();
//                childUpdates.put("/users/" + key, postValues);
//                myRef.updateChildren(childUpdates);
//                DatabaseReference newUsersRef = myRef.child("/Users/").push();
//                newUsersRef.s(thisUser);

                String id = myRef.push().getKey();

                User thisUser = new User(registerUserValue, registerPassValue, id, 0,0,0);
                myRef.child(id).setValue(thisUser);
//                myRef.child("Users").setValue(thisUser);

                myRef.child("users").push().setValue(thisUser);                   //child(registerUserValue).setValue(thisUser);
                Intent i = new Intent(getApplicationContext(), lobbyActivity.class);
                startActivity(i);
            }
        });
    }



}

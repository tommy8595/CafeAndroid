package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class BarcodeGenerator extends AppCompatActivity {

    private Button btnsignout;
    private FirebaseAuth mAuth1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.barcode_generator);

        mAuth1=FirebaseAuth.getInstance();
        btnsignout = (Button)findViewById(R.id.signout);

        btnsignout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signout();
            }
        });
    }

    //function signout
    private void signout()
    {
        mAuth1.signOut();
        startActivities(new Intent[]{new Intent(BarcodeGenerator.this, MainActivity.class)});
    }
}


package com.example.myapplication;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login_Activity extends AppCompatActivity  {

    //declare auth
    private FirebaseAuth mAuth;

    //get data
    private Button btntest;//sign in
    private Button btntest1;//sign up
    private EditText email;
    private EditText password;
    //check user if it alr logging
    private FirebaseAuth.AuthStateListener mAuthListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        mAuth=FirebaseAuth.getInstance();
        btntest = (Button)findViewById(R.id.btntestxml);
        btntest1 = (Button)findViewById(R.id.btntest1xml);
        email =(EditText)findViewById(R.id.emailxml);
        password=(EditText)findViewById(R.id.passwordxml);

        //sign in
        btntest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signin();
            }
        });

        //sign up
        btntest1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signup();
            }
        });

        //AuthListener check if it login
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if (firebaseAuth.getCurrentUser()!=null)
                {
                    startActivities(new Intent[]{new Intent(Login_Activity.this, BarcodeGenerator.class)});
                }
            }
        };
    }

    @Override
    protected void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    //function sign in
    private void signin()
    {
        String e =email.getText().toString();
        String p =password.getText().toString();

        if (TextUtils.isEmpty(e)||TextUtils.isEmpty(p))
        {
            Toast.makeText(this,"Shouldn't leave blank",Toast.LENGTH_SHORT).show();
        }else
            mAuth.signInWithEmailAndPassword(e,p)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful())
                            {
                                startActivities(new Intent[]{new Intent(Login_Activity.this, BarcodeGenerator.class)});
                            }
                            else
                                Toast.makeText(Login_Activity.this,"Not Success",Toast.LENGTH_SHORT).show();
                        }
                    });


    }
    //function sign up
    private void signup()
    {
        String e =email.getText().toString();
        String p =password.getText().toString();

        if (TextUtils.isEmpty(e)||TextUtils.isEmpty(p))
        {
            Toast.makeText(this,"Shouldn't leave blank",Toast.LENGTH_SHORT).show();
        }else
            mAuth.createUserWithEmailAndPassword(e,p)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful())
                        {
                            Toast.makeText(Login_Activity.this,"Register Complete",Toast.LENGTH_SHORT).show();
                        }
                        else Toast.makeText(Login_Activity.this,"Register Not Complete",Toast.LENGTH_SHORT).show();
                    }
                });
    }

}

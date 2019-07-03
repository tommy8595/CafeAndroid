package com.example.myapplication;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;

public class BarcodeGenerator extends AppCompatActivity {

    private Button btnsignout;
    private FirebaseAuth mAuth1;

    //for barcode
    private Bitmap myBitmap;
    private int size_width = 660;
    private int size_height = 264;
    ImageView imageView;
    private String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.barcode_generator);

        //sign out
        mAuth1=FirebaseAuth.getInstance();
        btnsignout = (Button)findViewById(R.id.signout);

        btnsignout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signout();
            }
        });

        //barcode gen stuff
        //final EditText input1= findViewById(R.id.textinput);
        Button gen = findViewById(R.id.genBarcode);
        imageView = findViewById(R.id.barcode);

        gen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //generate Barcode
                FirebaseUser user1=mAuth1.getCurrentUser();
                message=((FirebaseUser) user1).getEmail();
                Bitmap bitmap=genimg(message);
                myBitmap=bitmap;
                imageView.setImageBitmap(bitmap);
            }
        });
    }
////check mel user
//    @Override
//    protected void onStart() {
//        super.onStart();
//        if (mAuth1.getCurrentUser()!=null)
//        {
//            startActivities(new Intent[]{new Intent(this, BarcodeGenerator.class)});
//        }
//    }

    //function signout
    private void signout()
    {
        mAuth1.signOut();
        startActivities(new Intent[]{new Intent(BarcodeGenerator.this, MainActivity.class)});
    }
    //function generate code
    private Bitmap genimg(String message) {
        //bitmatrix jea array 01010101...
        BitMatrix bitMatrix = null;
        //bitmap encode trov ka exception
        try {
            bitMatrix = new MultiFormatWriter().encode(message, BarcodeFormat.CODE_128, size_width, size_height);
        } catch (WriterException e) {
            e.printStackTrace();
        }
        //set height weight bos barcode
        int width = bitMatrix.getWidth();
        int height = bitMatrix.getHeight();
        int [] pixels = new int [width * height];
        for (int i = 0 ; i < height ; i++)
        {
            for (int j = 0 ; j < width ; j++)
            {
                if (bitMatrix.get(j, i))
                {
                    //0xff000000 is android graphic eximal
                    pixels[i * width + j] = 0xff000000;
                }
                else
                {
                    pixels[i * width + j] = 0xffffffff;
                }
            }
        }
        //Bitmap.Config.ARGB_8888 is how android store pixel in 4 bit
        Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        bitmap.setPixels(pixels, 0, width, 0, 0, width, height);
        return bitmap;
    }

}


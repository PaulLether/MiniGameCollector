package com.example.minigamecollector;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    ImageView imageViewXOLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // XO logo button
        imageViewXOLogo = (ImageView) findViewById(R.id.imageViewXOLogo);
        imageViewXOLogo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                xoButtonPressed(v);
            }
        });



    }

    private void xoButtonPressed(View v)
    {
        Intent intent = new Intent (v.getContext(), xo.class);
        startActivityForResult(intent, 0);
    }

}

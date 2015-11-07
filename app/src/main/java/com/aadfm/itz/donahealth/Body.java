package com.aadfm.itz.donahealth;

import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class Body extends AppCompatActivity {

    AnimationDrawable corazonA, higadoA, cornia, pancreas, hueso, pulmon, pulmon1, intestino;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_body);

        corazonA = (AnimationDrawable)getResources().getDrawable(R.drawable.corazonani);
        ImageView vistaC = (ImageView) findViewById(R.id.corazon);
        vistaC.setImageDrawable(corazonA);
        corazonA.start();

        vistaC.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

            }
        });

        pancreas = (AnimationDrawable)getResources().getDrawable(R.drawable.pancreasani);
        ImageView vistaP = (ImageView) findViewById(R.id.pancreas);
        vistaP.setImageDrawable(pancreas);
        pancreas.start();

        vistaP.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

            }
        });


        higadoA = (AnimationDrawable)getResources().getDrawable(R.drawable.higadoani);
        ImageView vistaH = (ImageView) findViewById(R.id.higado);
        vistaH.setImageDrawable(higadoA);
        higadoA.start();

        vistaP.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

            }
        });


        pulmon = (AnimationDrawable)getResources().getDrawable(R.drawable.pulmonesani);
        ImageView vistaPu = (ImageView) findViewById(R.id.pulmon1);
        vistaPu.setImageDrawable(pulmon);
        pulmon.start();

        vistaP.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

            }
        });


        pulmon1 = (AnimationDrawable)getResources().getDrawable(R.drawable.pulmonesani);
        ImageView vistaPu1 = (ImageView) findViewById(R.id.pulmon2);
        vistaPu1.setImageDrawable(pulmon1);
        pulmon1.start();

        vistaPu1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

            }
        });


        intestino= (AnimationDrawable)getResources().getDrawable(R.drawable.intestinoani);
        ImageView vistaI = (ImageView) findViewById(R.id.intestino);
        vistaI.setImageDrawable(intestino);
        intestino.start();

        vistaI.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

            }
        });

        hueso= (AnimationDrawable)getResources().getDrawable(R.drawable.huesoani);
        ImageView vistaHu = (ImageView) findViewById(R.id.hueso);
        vistaHu.setImageDrawable(hueso);
        hueso.start();

        vistaHu.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

            }
        });


    }


    public void message(){

        Toast.makeText(this,"",Toast.LENGTH_LONG).show();


    }



}


/*
* <ImageButton
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:id="@+id/imageButton2"
        android:layout_gravity="center"
        android:layout_weight=".1"
        android:scaleType="fitCenter"
        android:adjustViewBounds="true"/>
* */
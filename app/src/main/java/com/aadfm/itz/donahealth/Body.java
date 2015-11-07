package com.aadfm.itz.donahealth;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
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
                message("Corazon");
            }
        });

        pancreas = (AnimationDrawable)getResources().getDrawable(R.drawable.pancreasani);
        ImageView vistaP = (ImageView) findViewById(R.id.pancreas);
        vistaP.setImageDrawable(pancreas);
        pancreas.start();

        vistaP.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                message("Pancreas");
            }
        });


        higadoA = (AnimationDrawable)getResources().getDrawable(R.drawable.higadoani);
        ImageView vistaH = (ImageView) findViewById(R.id.higado);
        vistaH.setImageDrawable(higadoA);
        higadoA.start();

        vistaH.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                message("Higado");
            }
        });


        pulmon = (AnimationDrawable)getResources().getDrawable(R.drawable.pulmonesani);
        ImageView vistaPu = (ImageView) findViewById(R.id.pulmon1);
        vistaPu.setImageDrawable(pulmon);
        pulmon.start();

        vistaPu.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                message("Pulmones");
            }
        });


        pulmon1 = (AnimationDrawable)getResources().getDrawable(R.drawable.pulmonesani1);
        ImageView vistaPu1 = (ImageView) findViewById(R.id.pulmon2);
        vistaPu1.setImageDrawable(pulmon1);
        pulmon1.start();

        vistaPu1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                message("Pulmones");
            }
        });


        intestino= (AnimationDrawable)getResources().getDrawable(R.drawable.intestinoani);
        ImageView vistaI = (ImageView) findViewById(R.id.intestino);
        vistaI.setImageDrawable(intestino);
        intestino.start();

        vistaI.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                message("Intestino");
            }
        });

        hueso= (AnimationDrawable)getResources().getDrawable(R.drawable.huesoani);
        ImageView vistaHu = (ImageView) findViewById(R.id.hueso);
        vistaHu.setImageDrawable(hueso);
        hueso.start();

        vistaHu.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                message("Huesos");
            }
        });

        cornia= (AnimationDrawable)getResources().getDrawable(R.drawable.corniaani);
        ImageView vistaCo = (ImageView) findViewById(R.id.ojo);
        vistaCo.setImageDrawable(cornia);
        cornia.start();

        vistaCo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                message("Cornia");
            }
        });


    }





    public void message(String org){


        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.main, (ViewGroup) findViewById(R.id.custom_toast_layout_id));

        ImageView image = (ImageView) layout.findViewById(R.id.imgToast);
        image.setImageResource(R.drawable.corazon2);
        TextView text = (TextView) layout.findViewById(R.id.textoToast);
        text.setText("Hola corazon!");


        TextView text2 = (TextView) layout.findViewById(R.id.textoToast1);
        text2.setText(org+".");

        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.show();


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
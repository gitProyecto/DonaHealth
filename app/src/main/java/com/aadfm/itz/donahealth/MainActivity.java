package com.aadfm.itz.donahealth;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    AnimationDrawable animacion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        animacion = (AnimationDrawable)getResources().getDrawable(R.drawable.animacion);
        ImageView vista = new ImageView(MainActivity.this);
        vista.setBackgroundColor(Color.WHITE);
        vista.setImageDrawable(animacion);
        animacion.start();
        setContentView(vista);

        vista.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                clase();
            }
        });
    }

    public void clase(){
        Intent intent = new Intent(this, Body.class);
        startActivity(intent);
        finish();
    }


}

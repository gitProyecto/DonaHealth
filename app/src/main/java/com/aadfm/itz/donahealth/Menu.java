package com.aadfm.itz.donahealth;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class Menu extends AppCompatActivity implements View.OnClickListener {
    ImageView tictac;
    ImageView body;
    ImageView heroe;
    //Boolean desbloqBody = false;
    SharedPreferences prefs;

    String estado = "0";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        tictac = (ImageView)findViewById(R.id.opcTicTae);
        body = (ImageView)findViewById(R.id.opcBody);
        heroe = (ImageView)findViewById(R.id.opcHeroe);
        tictac.setOnClickListener(this);
        body.setOnClickListener(this);
        heroe.setOnClickListener(this);
        //desbloqBody = new Boolean(getIntent().getStringExtra("nombre")+"");
        prefs = getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);
        body.setEnabled(false);
        estado= prefs.getString("estado", "0");
        if(estado.equals("1")){
            body.setEnabled(true);
        } else {
            body.setEnabled(false);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        estado= prefs.getString("estado", "0");
        if(estado.equals("1")){
            body.setEnabled(true);
        } else {
            body.setEnabled(false);
        }

        tictac.setImageResource(R.drawable.itt);
        body.setImageResource(R.drawable.ib);
        heroe.setImageResource(R.drawable.heroe);
    }



    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.opcTicTae:
                tictac.setImageResource(R.drawable.itts);
                Intent intencion1 = new Intent(this, TicTae.class);
                startActivity(intencion1);
                break;
            case R.id.opcBody:
                body.setImageResource(R.drawable.ibs);
                Intent intencion2 = new Intent (this,Body.class);
                startActivity(intencion2);
                break;
            case R.id.opcHeroe:
                heroe.setImageResource(R.drawable.heroes);
                Intent intencion3 = new Intent (this,Web.class);
                startActivity(intencion3);
                break;
        }
    }
}

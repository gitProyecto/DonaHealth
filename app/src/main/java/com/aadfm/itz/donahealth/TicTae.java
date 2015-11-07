package com.aadfm.itz.donahealth;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class TicTae extends AppCompatActivity implements OnClickListener {
    ImageView btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9;
    Button reinicio, regresar;
    ImageButton corazon,cornea, intestino, pulmon;
    boolean e1,e2,e3,e4,e5,e6,e7,e8,e9;
    boolean ganaste = false;
    TextView players;
    //Boolean[] estadoJuego = new Boolean[9];

    int contador=0,modulo=0,puntajeX=0,puntajeO=0;
    int g1=0,g2=0,g3=0,g4=0,g5=0,g6=0,g7=0,g8=0,g9=0;
    String jugador1,jugador2,mensaje;
    int resSelected = 0;
    int[] recursos = {R.drawable.corazon21,R.drawable.ojo21,R.drawable.intestino21,R.drawable.pulmones21};
    AyudanteBD aBD;
    SQLiteDatabase db = null;
    //int juegosGanados = 0;

    SharedPreferences prefs;

    MediaPlayer mp;

    int []audio={R.raw.audcorazon, R.raw.audcornea, R.raw.audintestino, R.raw.audpulmon};




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tic_tae);
        //Area de botones, que conforman el tablero
        btn1=(ImageView)findViewById(R.id.i1);
        btn2=(ImageView)findViewById(R.id.i2);
        btn3=(ImageView)findViewById(R.id.i3);
        btn4=(ImageView)findViewById(R.id.i4);
        btn5=(ImageView)findViewById(R.id.i5);
        btn6=(ImageView)findViewById(R.id.i6);
        btn7=(ImageView)findViewById(R.id.i7);
        btn8=(ImageView)findViewById(R.id.i8);
        btn9=(ImageView)findViewById(R.id.i9);
        //Botones selectores de icono de juego
        corazon = (ImageButton) findViewById(R.id.imgBtn1);
        cornea = (ImageButton) findViewById(R.id.imgBtn2);
        intestino = (ImageButton)findViewById(R.id.imgBtn3);
        pulmon = (ImageButton) findViewById(R.id.imgBtn4);



        //Escuchadores de botones
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);

        corazon.setOnClickListener(this);
        cornea.setOnClickListener(this);
        intestino.setOnClickListener(this);
        pulmon.setOnClickListener(this);

        //Botones de operacion
        reinicio=(Button)findViewById(R.id.button10);
        regresar=(Button)findViewById(R.id.regresar);

        reinicio.setOnClickListener(this);
        regresar.setOnClickListener(this);

        players=(TextView)findViewById(R.id.jugadores);

        prefs = getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.i1:
                if (e1==false) {
                    modulo = contador % 2 ;
                    if(modulo==0){
                        btn1.setImageResource(recursos[resSelected]);
                        g1=1; //Para ver quien va a ganar X
                        contador+=1;
                    }else{
                        btn1.setImageResource(R.drawable.cruz);
                        g1=2; //Para ver quien va a ganar O
                        contador+=1;
                    }
                    e1 = true;

                    if(g2==1&&g3==1&&g1==1||g7==1&&g4==1&&g1==1||g9==1&&g5==1&&g1==1){
                        Toast t2=Toast.makeText(this,"Gano el jugador "+ jugador1, Toast.LENGTH_LONG);
                        t2.show();
                        puntajeX+=1;
                        desbloqueo(puntajeX);
                        inicia(puntajeX + puntajeO);
                        mensaje=""; players.setText("");
                        mensaje = "Jugador "+jugador1 +": "+ puntajeX  +"\nJugador "+jugador2 +" : "+ puntajeO;
                        players.setText(mensaje);
                        btn1.setEnabled(false);  btn2.setEnabled(false);  btn3.setEnabled(false);
                        btn4.setEnabled(false);  btn5.setEnabled(false);  btn6.setEnabled(false);
                        btn7.setEnabled(false);  btn8.setEnabled(false);  btn9.setEnabled(false);
                        reset();
                    }else if(g2==2&&g3==2&&g1==2||g7==2&&g4==2&&g1==2||g9==2&&g5==2&&g1==2){
                        Toast t2=Toast.makeText(this,"Gano el jugador "+ jugador2, Toast.LENGTH_LONG);
                        t2.show();
                        puntajeO+=1;
                        inicia(puntajeX + puntajeO);
                        mensaje="";players.setText("");
                        mensaje = "Jugador "+jugador1 +": "+ puntajeX  +"\nJugador "+jugador2 +" : "+ puntajeO;
                        players.setText(mensaje);
                        btn1.setEnabled(false);  btn2.setEnabled(false);  btn3.setEnabled(false);
                        btn4.setEnabled(false);  btn5.setEnabled(false);  btn6.setEnabled(false);
                        btn7.setEnabled(false);  btn8.setEnabled(false);  btn9.setEnabled(false);
                        reset();
                    }else if (e1==true&&e2==true&&e3==true&&e4==true&&e5==true&&e6==true&&e7==true&&e8==true&&e9==true){
                        Toast t2=Toast.makeText(this,"El juego se ha empatado", Toast.LENGTH_LONG);
                        t2.show();
                        reset();
                    }
                }else{
                    Toast t1=Toast.makeText(this,"La casilla ya esta ocupada", Toast.LENGTH_LONG);
                    t1.show();
                    reset();
                }
                break;

            case R.id.i2:

                if (e2==false) {

                    modulo = contador % 2 ;
                    if(modulo==0){
                        btn2.setImageResource(recursos[resSelected]);
                        contador+=1;
                        g2=1;

                    }else{
                        btn2.setImageResource(R.drawable.cruz);
                        contador+=1;
                        g2=2;
                    }

                    e2 = true;

                    if(g1==1&&g3==1&&g2==1||g5==1&&g8==1&&g2==1){
                        Toast t2=Toast.makeText(this,"Gano el jugador "+ jugador1, Toast.LENGTH_LONG);
                        t2.show();
                        puntajeX+=1;
                        desbloqueo(puntajeX);
                        inicia(puntajeX + puntajeO);
                        mensaje="";players.setText("");
                        mensaje = "Jugador "+jugador1 +": "+ puntajeX  +"\nJugador "+jugador2 +" : "+ puntajeO;
                        players.setText(mensaje);
                        btn1.setEnabled(false);  btn2.setEnabled(false);  btn3.setEnabled(false);
                        btn4.setEnabled(false);  btn5.setEnabled(false);  btn6.setEnabled(false);
                        btn7.setEnabled(false);  btn8.setEnabled(false);  btn9.setEnabled(false);
                        reset();
                    }else if(g1==2&&g3==2&&g2==2||g5==2&&g8==2&&g2==2){
                        Toast t2=Toast.makeText(this,"Gano el jugador "+ jugador2, Toast.LENGTH_LONG);
                        t2.show();
                        puntajeO+=1;
                        inicia(puntajeX + puntajeO);
                        mensaje="";players.setText("");
                        mensaje = "Jugador "+jugador1 +": "+ puntajeX  +"\nJugador "+jugador2 +" : "+ puntajeO;
                        players.setText(mensaje);
                        btn1.setEnabled(false);  btn2.setEnabled(false);  btn3.setEnabled(false);
                        btn4.setEnabled(false);  btn5.setEnabled(false);  btn6.setEnabled(false);
                        btn7.setEnabled(false);  btn8.setEnabled(false);  btn9.setEnabled(false);
                        reset();
                    }else if (e1==true&&e2==true&&e3==true&&e4==true&&e5==true&&e6==true&&e7==true&&e8==true&&e9==true){
                        Toast t2=Toast.makeText(this,"El juego se ha empatado", Toast.LENGTH_LONG);
                        t2.show();
                        reset();
                    }

                }else{
                    Toast t1=Toast.makeText(this,"La casilla ya esta ocupada", Toast.LENGTH_LONG);
                    t1.show();
                }
                break;
            case R.id.i3:

                if (e3==false) {
                    modulo = contador % 2 ;
                    if(modulo==0){
                        btn3.setImageResource(recursos[resSelected]);
                        contador+=1;
                        g3=1;
                    }else{
                        btn3.setImageResource(R.drawable.cruz);
                        contador+=1;
                        g3=2;
                    }
                    e3 = true;

                    if(g1==1&&g2==1&&g3==1||g6==1&&g9==1&&g3==1||g7==1&&g5==1&&g3==1){
                        Toast t2=Toast.makeText(this,"Gano el jugador "+ jugador1, Toast.LENGTH_LONG);
                        t2.show();
                        puntajeX+=1;
                        desbloqueo(puntajeX);
                        inicia(puntajeX + puntajeO);
                        mensaje="";players.setText("");
                        mensaje = "Jugador "+jugador1 +": "+ puntajeX  +"\nJugador "+jugador2 +" : "+ puntajeO;
                        players.setText(mensaje);
                        btn1.setEnabled(false);  btn2.setEnabled(false);  btn3.setEnabled(false);
                        btn4.setEnabled(false);  btn5.setEnabled(false);  btn6.setEnabled(false);
                        btn7.setEnabled(false);  btn8.setEnabled(false);  btn9.setEnabled(false);
                        reset();
                    }else if(g1==2&&g2==2&&g3==2||g6==2&&g9==2&&g3==2||g7==2&&g5==2&&g3==2){
                        Toast t2=Toast.makeText(this,"Gano el jugador "+ jugador2, Toast.LENGTH_LONG);
                        t2.show();
                        puntajeO+=1;
                        inicia(puntajeX + puntajeO);
                        //reset();
                        mensaje="";players.setText("");
                        mensaje = "Jugador "+jugador1 +": "+ puntajeX  +"\nJugador "+jugador2 +" : "+ puntajeO;
                        players.setText(mensaje);
                        btn1.setEnabled(false);  btn2.setEnabled(false);  btn3.setEnabled(false);
                        btn4.setEnabled(false);  btn5.setEnabled(false);  btn6.setEnabled(false);
                        btn7.setEnabled(false);  btn8.setEnabled(false);  btn9.setEnabled(false);
                        reset();
                    }else if (e1==true&&e2==true&&e3==true&&e4==true&&e5==true&&e6==true&&e7==true&&e8==true&&e9==true){
                        Toast t2=Toast.makeText(this,"El juego se ha empatado", Toast.LENGTH_LONG);
                        t2.show();
                        reset();
                    }

                }else{
                    Toast t1=Toast.makeText(this,"La casilla ya esta ocupada", Toast.LENGTH_LONG);
                    t1.show();
                }
                break;
            case R.id.i4:

                if (e4==false) {
                    modulo = contador % 2 ;
                    if(modulo==0){
                        btn4.setImageResource(recursos[resSelected]);
                        contador+=1;
                        g4=1;
                    }else{
                        btn4.setImageResource(R.drawable.cruz);
                        contador+=1;
                        g4=2;
                    }
                    e4 = true;

                    if(g1==1&&g7==1&&g4==1||g5==1&&g6==1&&g4==1){
                        Toast t2=Toast.makeText(this,"Gano el jugador "+ jugador1, Toast.LENGTH_LONG);
                        t2.show();
                        puntajeX+=1;
                        desbloqueo(puntajeX);
                        inicia(puntajeX + puntajeO);
                        mensaje="";players.setText("");
                        mensaje = "Jugador "+jugador1 +": "+ puntajeX  +"\nJugador "+jugador2 +" : "+ puntajeO;
                        players.setText(mensaje);
                        btn1.setEnabled(false);  btn2.setEnabled(false);  btn3.setEnabled(false);
                        btn4.setEnabled(false);  btn5.setEnabled(false);  btn6.setEnabled(false);
                        btn7.setEnabled(false);  btn8.setEnabled(false);  btn9.setEnabled(false);
                        reset();
                    }else if(g1==2&&g7==2&&g4==2||g5==2&&g6==2&&g4==2){
                        Toast t2=Toast.makeText(this,"Gano el jugador "+ jugador2, Toast.LENGTH_LONG);
                        t2.show();
                        puntajeO+=1;
                        inicia(puntajeX + puntajeO);
                        //reset();
                        mensaje="";players.setText("");
                        mensaje = "Jugador "+jugador1 +": "+ puntajeX  +"\nJugador "+jugador2 +" : "+ puntajeO;
                        players.setText(mensaje);
                        btn1.setEnabled(false);  btn2.setEnabled(false);  btn3.setEnabled(false);
                        btn4.setEnabled(false);  btn5.setEnabled(false);  btn6.setEnabled(false);
                        btn7.setEnabled(false);  btn8.setEnabled(false);  btn9.setEnabled(false);
                        reset();
                    }else if (e1==true&&e2==true&&e3==true&&e4==true&&e5==true&&e6==true&&e7==true&&e8==true&&e9==true){
                        Toast t2=Toast.makeText(this,"El juego se ha empatado", Toast.LENGTH_LONG);
                        t2.show();
                        reset();
                    }

                }else{
                    Toast t1=Toast.makeText(this,"La casilla ya esta ocupada", Toast.LENGTH_LONG);
                    t1.show();
                }
                break;
            case R.id.i5:

                if (e5==false) {

                    modulo = contador % 2 ;
                    if(modulo==0){
                        btn5.setImageResource(recursos[resSelected]);
                        contador+=1;
                        g5=1;
                    }else{
                        btn5.setImageResource(R.drawable.cruz);
                        contador+=1;
                        g5=2;
                    }
                    e5 = true;

                    if(g1==1&&g9==1&&g5==1||g3==1&&g7==1&&g5==1||g2==1&&g8==1&&g5==1||g4==1&&g6==1&&g5==1){
                        Toast t2=Toast.makeText(this,"Gano el jugador "+ jugador1, Toast.LENGTH_LONG);
                        t2.show();
                        puntajeX+=1;
                        desbloqueo(puntajeX);
                        inicia(puntajeX + puntajeO);
                        mensaje="";players.setText("");
                        mensaje = "Jugador "+jugador1 +": "+ puntajeX  +"\nJugador "+jugador2 +" : "+ puntajeO;
                        players.setText(mensaje);
                        btn1.setEnabled(false);  btn2.setEnabled(false);  btn3.setEnabled(false);
                        btn4.setEnabled(false);  btn5.setEnabled(false);  btn6.setEnabled(false);
                        btn7.setEnabled(false);  btn8.setEnabled(false);  btn9.setEnabled(false);
                        reset();
                    }else if(g1==2&&g9==2&&g5==2||g3==2&&g7==2&&g5==2||g2==2&&g8==2&&g5==2||g4==2&&g6==2&&g5==2){
                        Toast t2=Toast.makeText(this,"Gano el jugador "+ jugador2, Toast.LENGTH_LONG);
                        t2.show();
                        puntajeO+=1;
                        inicia(puntajeX + puntajeO);
                        mensaje="";players.setText("");
                        mensaje = "Jugador "+jugador1 +": "+ puntajeX  +"\nJugador "+jugador2 +" : "+ puntajeO;
                        players.setText(mensaje);
                        btn1.setEnabled(false);  btn2.setEnabled(false);  btn3.setEnabled(false);
                        btn4.setEnabled(false);  btn5.setEnabled(false);  btn6.setEnabled(false);
                        btn7.setEnabled(false);  btn8.setEnabled(false);  btn9.setEnabled(false);
                        reset();
                    }else if (e1==true&&e2==true&&e3==true&&e4==true&&e5==true&&e6==true&&e7==true&&e8==true&&e9==true){
                        Toast t2=Toast.makeText(this,"El juego se ha empatado", Toast.LENGTH_LONG);
                        t2.show();
                        reset();
                    }

                }else{
                    Toast t1=Toast.makeText(this,"La casilla ya esta ocupada", Toast.LENGTH_LONG);
                    t1.show();
                }
                break;
            case R.id.i6:

                if (e6==false) {

                    modulo = contador % 2 ;
                    if(modulo==0){
                        btn6.setImageResource(recursos[resSelected]);
                        contador+=1;
                        g6=1;
                    }else{
                        btn6.setImageResource(R.drawable.cruz);
                        contador+=1;
                        g6=2;
                    }

                    e6 = true;

                    if(g4==1&&g5==1&&g6==1||g3==1&&g9==1&&g6==1){
                        Toast t2=Toast.makeText(this,"Gano el jugador "+ jugador1, Toast.LENGTH_LONG);
                        t2.show();
                        puntajeX+=1;
                        desbloqueo(puntajeX);
                        inicia(puntajeX + puntajeO);
                        mensaje="";players.setText("");
                        mensaje = "Jugador "+jugador1 +": "+ puntajeX  +"\nJugador "+jugador2 +" : "+ puntajeO;
                        players.setText(mensaje);btn1.setEnabled(false);  btn2.setEnabled(false);  btn3.setEnabled(false);
                        btn4.setEnabled(false);  btn5.setEnabled(false);  btn6.setEnabled(false);
                        btn7.setEnabled(false);  btn8.setEnabled(false);  btn9.setEnabled(false);
                        reset();
                    }else if(g4==2&&g5==2&&g6==2||g3==2&&g9==2&&g6==2){
                        Toast t2=Toast.makeText(this,"Gano el jugador "+ jugador2, Toast.LENGTH_LONG);
                        t2.show();
                        puntajeO+=1;
                        inicia(puntajeX + puntajeO);
                        //reset();
                        mensaje="";players.setText("");
                        mensaje = "Jugador "+jugador1 +": "+ puntajeX  +"\nJugador "+jugador2 +" : "+ puntajeO;
                        players.setText(mensaje);
                        btn1.setEnabled(false);  btn2.setEnabled(false);  btn3.setEnabled(false);
                        btn4.setEnabled(false);  btn5.setEnabled(false);  btn6.setEnabled(false);
                        btn7.setEnabled(false);  btn8.setEnabled(false);  btn9.setEnabled(false);
                        reset();
                    }else if (e1==true&&e2==true&&e3==true&&e4==true&&e5==true&&e6==true&&e7==true&&e8==true&&e9==true){
                        Toast t2=Toast.makeText(this,"El juego se ha empatado", Toast.LENGTH_LONG);
                        t2.show();
                        reset();
                    }

                }else{
                    Toast t1=Toast.makeText(this,"La casilla ya esta ocupada", Toast.LENGTH_LONG);
                    t1.show();
                }
                break;
            case R.id.i7:
                if (e7==false) {

                    modulo = contador % 2 ;
                    if(modulo==0){
                        btn7.setImageResource(recursos[resSelected]);
                        contador+=1;
                        g7=1;
                    }else{
                        btn7.setImageResource(R.drawable.cruz);
                        contador+=1;
                        g7=2;
                    }

                    e7 = true;

                    if(g1==1&&g4==1&&g7==1||g8==1&&g9==1&&g7==1||g5==1&&g3==1&&g7==1){
                        Toast t2=Toast.makeText(this,"Gano el jugador "+ jugador1, Toast.LENGTH_LONG);
                        t2.show();
                        puntajeX+=1;
                        desbloqueo(puntajeX);
                        inicia(puntajeX + puntajeO);
                        mensaje="";players.setText("");
                        mensaje = "Jugador "+jugador1 +": "+ puntajeX  +"\nJugador "+jugador2 +" : "+ puntajeO;
                        players.setText(mensaje);
                        btn1.setEnabled(false);  btn2.setEnabled(false);  btn3.setEnabled(false);
                        btn4.setEnabled(false);  btn5.setEnabled(false);  btn6.setEnabled(false);
                        btn7.setEnabled(false);  btn8.setEnabled(false);  btn9.setEnabled(false);
                        reset();
                    }else if(g1==2&&g4==2&&g7==2||g8==2&&g9==2&&g7==2||g5==2&&g3==2&&g7==2){
                        Toast t2=Toast.makeText(this,"Gano el jugador "+ jugador2, Toast.LENGTH_LONG);
                        t2.show();
                        inicia(puntajeX + puntajeO);
                        puntajeO+=1;
                        mensaje="";players.setText("");
                        mensaje = "Jugador "+jugador1 +": "+ puntajeX  +"\nJugador "+jugador2 +" : "+ puntajeO;
                        players.setText(mensaje);
                        btn1.setEnabled(false);  btn2.setEnabled(false);  btn3.setEnabled(false);
                        btn4.setEnabled(false);  btn5.setEnabled(false);  btn6.setEnabled(false);
                        btn7.setEnabled(false);  btn8.setEnabled(false);  btn9.setEnabled(false);
                        reset();
                    }else if (e1==true&&e2==true&&e3==true&&e4==true&&e5==true&&e6==true&&e7==true&&e8==true&&e9==true){
                        Toast t2=Toast.makeText(this,"El juego se ha empatado", Toast.LENGTH_LONG);
                        t2.show();
                        reset();
                    }

                }else{
                    Toast t1=Toast.makeText(this,"La casilla ya esta ocupada", Toast.LENGTH_LONG);
                    t1.show();
                }
                break;
            case R.id.i8:

                if (e8==false) {

                    modulo = contador % 2 ;
                    if(modulo==0){
                        btn8.setImageResource(recursos[resSelected]);
                        contador+=1;
                        g8=1;
                    }else{
                        btn8.setImageResource(R.drawable.cruz);
                        contador+=1;
                        g8=2;
                    }

                    e8 = true;

                    if(g7==1&&g9==1&&g8==1||g2==1&&g5==1&&g8==1){
                        Toast t2=Toast.makeText(this,"Gano el jugador "+ jugador1, Toast.LENGTH_LONG);
                        t2.show();
                        puntajeX+=1;
                        desbloqueo(puntajeX);
                        inicia(puntajeX + puntajeO);
                        mensaje="";players.setText("");
                        mensaje = "Jugador "+jugador1 +": "+ puntajeX  +"\nJugador "+jugador2 +" : "+ puntajeO;
                        players.setText(mensaje);
                        btn1.setEnabled(false);  btn2.setEnabled(false);  btn3.setEnabled(false);
                        btn4.setEnabled(false);  btn5.setEnabled(false);  btn6.setEnabled(false);
                        btn7.setEnabled(false);  btn8.setEnabled(false);  btn9.setEnabled(false);
                        reset();
                    }else if(g7==2&&g9==2&&g8==2||g2==2&&g5==2&&g8==2){
                        Toast t2=Toast.makeText(this,"Gano el jugador "+ jugador2, Toast.LENGTH_LONG);
                        t2.show();
                        puntajeO+=1;
                        inicia(puntajeX + puntajeO);
                        //reset();
                        mensaje="";players.setText("");
                        mensaje = "Jugador "+jugador1 +": "+ puntajeX  +"\nJugador "+jugador2 +" : "+ puntajeO;
                        players.setText(mensaje);
                        btn1.setEnabled(false);  btn2.setEnabled(false);  btn3.setEnabled(false);
                        btn4.setEnabled(false);  btn5.setEnabled(false);  btn6.setEnabled(false);
                        btn7.setEnabled(false);  btn8.setEnabled(false);  btn9.setEnabled(false);
                        reset();
                    }else if (e1==true&&e2==true&&e3==true&&e4==true&&e5==true&&e6==true&&e7==true&&e8==true&&e9==true){
                        Toast t2=Toast.makeText(this,"El juego se ha empatado", Toast.LENGTH_LONG);
                        t2.show();
                        reset();
                    }

                }else{
                    Toast t1=Toast.makeText(this,"La casilla ya esta ocupada", Toast.LENGTH_LONG);
                    t1.show();
                }
                break;
            case R.id.i9:

                if (e9==false) {

                    modulo = contador % 2 ;
                    if(modulo==0){
                        btn9.setImageResource(recursos[resSelected]);
                        contador+=1;
                        g9=1;
                    }else{
                        btn9.setImageResource(R.drawable.cruz);
                        contador+=1;
                        g9=2;
                    }

                    e9 = true;

                    if(g1==1&&g5==1&&g9==1||g7==1&&g8==1&&g9==1||g3==1&&g6==1&&g9==1){
                        Toast t2=Toast.makeText(this,"Gano el jugador "+ jugador1, Toast.LENGTH_LONG);
                        t2.show();
                        puntajeX+=1;
                        desbloqueo(puntajeX);
                        inicia(puntajeX + puntajeO);
                        mensaje="";players.setText("");
                        mensaje = "Jugador "+jugador1 +": "+ puntajeX  +"\nJugador "+jugador2 +" : "+ puntajeO;
                        players.setText(mensaje);
                        btn1.setEnabled(false);  btn2.setEnabled(false);  btn3.setEnabled(false);
                        btn4.setEnabled(false);  btn5.setEnabled(false);  btn6.setEnabled(false);
                        btn7.setEnabled(false);  btn8.setEnabled(false);  btn9.setEnabled(false);
                        reset();
                    }else if(g1==2&&g5==2&&g9==2||g7==2&&g8==2&&g9==2||g3==2&&g6==2&&g9==2){
                        Toast t2=Toast.makeText(this,"Gano el jugador "+ jugador2, Toast.LENGTH_LONG);
                        t2.show();
                        puntajeO+=1;
                        inicia(puntajeX+puntajeO);
                        mensaje="";players.setText("");
                        mensaje = "Jugador "+jugador1 +": "+ puntajeX  +"\nJugador "+jugador2 +" : "+ puntajeO;
                        players.setText(mensaje);
                        btn1.setEnabled(false);  btn2.setEnabled(false);  btn3.setEnabled(false);
                        btn4.setEnabled(false);  btn5.setEnabled(false);  btn6.setEnabled(false);
                        btn7.setEnabled(false);  btn8.setEnabled(false);  btn9.setEnabled(false);
                        reset();
                    }else if (e1==true&&e2==true&&e3==true&&e4==true&&e5==true&&e6==true&&e7==true&&e8==true&&e9==true){
                        Toast t2=Toast.makeText(this,"El juego se ha empatado", Toast.LENGTH_LONG);
                        t2.show();
                        reset();
                    }

                }else{
                    Toast t1=Toast.makeText(this,"La casilla ya esta ocupada", Toast.LENGTH_LONG);
                    t1.show();
                }
                break;
            case R.id.button10:
                reset();
                break;
            case R.id.regresar:
                try {
                    aBD = new AyudanteBD(this, "Gato", null, 1);
                    db = aBD.getWritableDatabase();
                    if (db != null) {
                        db.execSQL("insert into resultados values ('" + jugador1
                                + "','" + puntajeX + "','" + jugador2 + "','" + puntajeO + "')");
                        db.close();
                        //Toast.makeText(getApplicationContext(),"Puntaje de la Batalla Guardada!!",Toast.LENGTH_LONG).show();
                    } else
                        Toast.makeText(getApplicationContext(), "BD fue null",
                                Toast.LENGTH_LONG).show();
                }// try
                catch (Exception e) {
                    Toast.makeText(getApplicationContext(),
                            e.getMessage() + "\n\n", Toast.LENGTH_LONG).show();
                }

                SharedPreferences.Editor editor = prefs.edit();
                if (ganaste){
                    try{
                        editor.putString("estado", "1");
                        editor.commit();
                    } catch(Exception e){
                        msg(e.getMessage());
                    }
                }
                Intent intencion2 = new Intent (this,Menu.class);
                startActivity(intencion2);

                //Intent i = new Intent (TicTae.this, Menu.class);
                //i.putExtra("estado", "true");
                //startActivity(i);


                break;
            case R.id.imgBtn1:
                voz(0);
                resSelected = 0;
                msgCorto("Corazon");
                jugador1 = "Corazon";
                jugador2 = "Indiferencia";
                mensaje = jugador1+ " vs " + jugador2;
                players.setText(mensaje);
                msg(mensaje);
                corazon.setVisibility(View.INVISIBLE);
                cornea.setEnabled(false);
                intestino.setEnabled(false);
                pulmon.setEnabled(false);
                break;
            case R.id.imgBtn2:
                voz(1);
                resSelected = 1;
                msgCorto("Cornea");
                jugador1 = "Cornea";
                jugador2 = "Indiferencia";
                mensaje = jugador1+ " vs " + jugador2;
                players.setText(mensaje);
                msg(mensaje);
                cornea.setVisibility(View.INVISIBLE);
                corazon.setEnabled(false);
                intestino.setEnabled(false);
                pulmon.setEnabled(false);
                break;
            case R.id.imgBtn3:
                voz(2);
                resSelected = 2;
                msgCorto("Intestino");
                jugador1 = "Intestino";
                jugador2 = "Indiferencia";
                mensaje = jugador1+ " vs " + jugador2;
                players.setText(mensaje);
                msg(mensaje);
                intestino.setVisibility(View.INVISIBLE);
                cornea.setEnabled(false);
                corazon.setEnabled(false);
                pulmon.setEnabled(false);
                break;
            case R.id.imgBtn4:
                voz(3);
                resSelected = 3;
                msgCorto("Pulmon");
                jugador1 = "Pulmon";
                jugador2 = "Indiferencia";
                mensaje = jugador1+ " vs " + jugador2;
                players.setText(mensaje);
                msg(mensaje);
                pulmon.setVisibility(View.INVISIBLE);
                cornea.setEnabled(false);
                intestino.setEnabled(false);
                corazon.setEnabled(false);
                break;
        }
    }

    public void msg (String cad){
        Toast.makeText(getApplicationContext(), cad,
                Toast.LENGTH_LONG).show();
    }

    public void msgCorto (String cad){
        Toast.makeText(getApplicationContext(), cad,
                Toast.LENGTH_SHORT).show();
    }


    public void desbloqueo (int num) {
        //reset();
        if (num==4) {
            ganaste = true;
            msg("HAZ DESBLOQUEADO EL JUEGO 'BODY'");
            corazon.setVisibility(View.VISIBLE);
            cornea.setVisibility(View.VISIBLE);
            intestino.setVisibility(View.VISIBLE);
            pulmon.setVisibility(View.VISIBLE);
            reset();
            puntajeO = 0;
            puntajeX = 0;
        }
    }

    public void inicia(int num) {
        if (num == 4) {
            msgCorto("INTENTA NUEVAMENTE'");
            corazon.setVisibility(View.VISIBLE);
            cornea.setVisibility(View.VISIBLE);
            intestino.setVisibility(View.VISIBLE);
            pulmon.setVisibility(View.VISIBLE);
            reset();
            puntajeO = 0;
            puntajeX = 0;
        }
    }


    public void voz(int i) {
        mp = MediaPlayer.create(this, audio[i]);
        mp.start();
    }


    public void reset() {
        e1 = false;e2 = false;e3 = false;e4 = false;e5 = false;e6 = false; e7 = false;e8 = false;e9 = false;
        contador = 0; modulo = 0;
        g1=0; g2=0; g3=0; g4=0; g5=0; g6=0; g7=0; g8=0; g9=0;
        btn1.setImageResource(R.drawable.nada);
        btn2.setImageResource(R.drawable.nada);
        btn3.setImageResource(R.drawable.nada);
        btn4.setImageResource(R.drawable.nada);
        btn5.setImageResource(R.drawable.nada);
        btn6.setImageResource(R.drawable.nada);
        btn7.setImageResource(R.drawable.nada);
        btn8.setImageResource(R.drawable.nada);
        btn9.setImageResource(R.drawable.nada);
        btn1.setEnabled(true);  btn2.setEnabled(true);  btn3.setEnabled(true);
        btn4.setEnabled(true);  btn5.setEnabled(true);  btn6.setEnabled(true);
        btn7.setEnabled(true);  btn8.setEnabled(true);  btn9.setEnabled(true);
        corazon.setEnabled(true);
        cornea.setEnabled(true);
        intestino.setEnabled(true);
        pulmon.setEnabled(true);
        players.setText("");
    }

}


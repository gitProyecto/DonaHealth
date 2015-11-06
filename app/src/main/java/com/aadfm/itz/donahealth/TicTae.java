package com.aadfm.itz.donahealth;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class TicTae extends AppCompatActivity implements OnClickListener {
    ImageView btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9;
    Button reinicio, regresar;
    boolean e1,e2,e3,e4,e5,e6,e7,e8,e9;
    boolean yaEligio = false;
    TextView players;
    //Boolean[] estadoJuego = new Boolean[9];

    int contador=0,modulo=0,puntajeX=0,puntajeO=0;
    int g1=0,g2=0,g3=0,g4=0,g5=0,g6=0,g7=0,g8=0,g9=0;
    String jugador1,jugador2,mensaje;

    //AyudanteBD aBD;
    //SQLiteDatabase db = null;



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

        //Botones de operacion
        reinicio=(Button)findViewById(R.id.button10);
        regresar=(Button)findViewById(R.id.regresar);

        players=(TextView)findViewById(R.id.jugadores);

        players.setText(mensaje);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.i1:
                if (e1==false) {
                    modulo = contador % 2 ;
                    if(modulo==0){
                        btn1.setImageResource(R.drawable.cruz);
                        g1=1; //Para ver quien va a ganar X
                        contador+=1;
                    }else{
                        btn1.setImageResource(R.drawable.aro);
                        g1=2; //Para ver quien va a ganar O
                        contador+=1;
                    }
                    e1 = true;

                    if(g2==1&&g3==1&&g1==1||g7==1&&g4==1&&g1==1||g9==1&&g5==1&&g1==1){
                        Toast t2=Toast.makeText(this,"Gano el jugador "+ jugador1, Toast.LENGTH_LONG);
                        t2.show();
                        puntajeX+=1;
                        mensaje=""; players.setText("");
                        mensaje = "X Jugador "+jugador1 +": "+ puntajeX  +"\nO Jugador "+jugador2 +" : "+ puntajeO;
                        players.setText(mensaje);
                        btn1.setEnabled(false);  btn2.setEnabled(false);  btn3.setEnabled(false);
                        btn4.setEnabled(false);  btn5.setEnabled(false);  btn6.setEnabled(false);
                        btn7.setEnabled(false);  btn8.setEnabled(false);  btn9.setEnabled(false);
                    }else if(g2==2&&g3==2&&g1==2||g7==2&&g4==2&&g1==2||g9==2&&g5==2&&g1==2){
                        Toast t2=Toast.makeText(this,"Gano el jugador "+ jugador2, Toast.LENGTH_LONG);
                        t2.show();
                        puntajeO+=1;
                        mensaje="";players.setText("");
                        mensaje = "X Jugador "+jugador1 +": "+ puntajeX  +"\nO Jugador "+jugador2 +" : "+ puntajeO;
                        players.setText(mensaje);
                        btn1.setEnabled(false);  btn2.setEnabled(false);  btn3.setEnabled(false);
                        btn4.setEnabled(false);  btn5.setEnabled(false);  btn6.setEnabled(false);
                        btn7.setEnabled(false);  btn8.setEnabled(false);  btn9.setEnabled(false);
                    }else if (e1==true&&e2==true&&e3==true&&e4==true&&e5==true&&e6==true&&e7==true&&e8==true&&e9==true){
                        Toast t2=Toast.makeText(this,"El juego se ha empatado", Toast.LENGTH_LONG);
                        t2.show();
                    }
                }else{
                    Toast t1=Toast.makeText(this,"La casilla ya esta ocupada", Toast.LENGTH_LONG);
                    t1.show();
                }
                break;

            case R.id.i2:

                if (e2==false) {

                    modulo = contador % 2 ;
                    if(modulo==0){
                        btn2.setImageResource(R.drawable.cruz);
                        contador+=1;
                        g2=1;

                    }else{
                        btn2.setImageResource(R.drawable.aro);
                        contador+=1;
                        g2=2;
                    }

                    e2 = true;

                    if(g1==1&&g3==1&&g2==1||g5==1&&g8==1&&g2==1){
                        Toast t2=Toast.makeText(this,"Gano el jugador "+ jugador1, Toast.LENGTH_LONG);
                        t2.show();
                        puntajeX+=1;
                        mensaje="";players.setText("");
                        mensaje = "X Jugador "+jugador1 +": "+ puntajeX  +"\nO Jugador "+jugador2 +" : "+ puntajeO;
                        players.setText(mensaje);
                        btn1.setEnabled(false);  btn2.setEnabled(false);  btn3.setEnabled(false);
                        btn4.setEnabled(false);  btn5.setEnabled(false);  btn6.setEnabled(false);
                        btn7.setEnabled(false);  btn8.setEnabled(false);  btn9.setEnabled(false);
                    }else if(g1==2&&g3==2&&g2==2||g5==2&&g8==2&&g2==2){
                        Toast t2=Toast.makeText(this,"Gano el jugador "+ jugador2, Toast.LENGTH_LONG);
                        t2.show();
                        puntajeO+=1;
                        mensaje="";players.setText("");
                        mensaje = "X Jugador "+jugador1 +": "+ puntajeX  +"\nO Jugador "+jugador2 +" : "+ puntajeO;
                        players.setText(mensaje);
                        btn1.setEnabled(false);  btn2.setEnabled(false);  btn3.setEnabled(false);
                        btn4.setEnabled(false);  btn5.setEnabled(false);  btn6.setEnabled(false);
                        btn7.setEnabled(false);  btn8.setEnabled(false);  btn9.setEnabled(false);
                    }else if (e1==true&&e2==true&&e3==true&&e4==true&&e5==true&&e6==true&&e7==true&&e8==true&&e9==true){
                        Toast t2=Toast.makeText(this,"El juego se ha empatado", Toast.LENGTH_LONG);
                        t2.show();
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
                        btn3.setImageResource(R.drawable.cruz);
                        contador+=1;
                        g3=1;
                    }else{
                        btn3.setImageResource(R.drawable.aro);
                        contador+=1;
                        g3=2;
                    }
                    e3 = true;

                    if(g1==1&&g2==1&&g3==1||g6==1&&g9==1&&g3==1||g7==1&&g5==1&&g3==1){
                        Toast t2=Toast.makeText(this,"Gano el jugador "+ jugador1, Toast.LENGTH_LONG);
                        t2.show();
                        puntajeX+=1;
                        mensaje="";players.setText("");
                        mensaje = "X Jugador "+jugador1 +": "+ puntajeX  +"\nO Jugador "+jugador2 +" : "+ puntajeO;
                        players.setText(mensaje);
                        btn1.setEnabled(false);  btn2.setEnabled(false);  btn3.setEnabled(false);
                        btn4.setEnabled(false);  btn5.setEnabled(false);  btn6.setEnabled(false);
                        btn7.setEnabled(false);  btn8.setEnabled(false);  btn9.setEnabled(false);
                    }else if(g1==2&&g2==2&&g3==2||g6==2&&g9==2&&g3==2||g7==2&&g5==2&&g3==2){
                        Toast t2=Toast.makeText(this,"Gano el jugador "+ jugador2, Toast.LENGTH_LONG);
                        t2.show();
                        puntajeO+=1;
                        mensaje="";players.setText("");
                        mensaje = "X Jugador "+jugador1 +": "+ puntajeX  +"\nO Jugador "+jugador2 +" : "+ puntajeO;
                        players.setText(mensaje);
                        btn1.setEnabled(false);  btn2.setEnabled(false);  btn3.setEnabled(false);
                        btn4.setEnabled(false);  btn5.setEnabled(false);  btn6.setEnabled(false);
                        btn7.setEnabled(false);  btn8.setEnabled(false);  btn9.setEnabled(false);
                    }else if (e1==true&&e2==true&&e3==true&&e4==true&&e5==true&&e6==true&&e7==true&&e8==true&&e9==true){
                        Toast t2=Toast.makeText(this,"El juego se ha empatado", Toast.LENGTH_LONG);
                        t2.show();
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
                        btn4.setImageResource(R.drawable.cruz);
                        contador+=1;
                        g4=1;
                    }else{
                        btn4.setImageResource(R.drawable.aro);
                        contador+=1;
                        g4=2;
                    }
                    e4 = true;

                    if(g1==1&&g7==1&&g4==1||g5==1&&g6==1&&g4==1){
                        Toast t2=Toast.makeText(this,"Gano el jugador "+ jugador1, Toast.LENGTH_LONG);
                        t2.show();
                        puntajeX+=1;
                        mensaje="";players.setText("");
                        mensaje = "X Jugador "+jugador1 +": "+ puntajeX  +"\nO Jugador "+jugador2 +" : "+ puntajeO;
                        players.setText(mensaje);
                        btn1.setEnabled(false);  btn2.setEnabled(false);  btn3.setEnabled(false);
                        btn4.setEnabled(false);  btn5.setEnabled(false);  btn6.setEnabled(false);
                        btn7.setEnabled(false);  btn8.setEnabled(false);  btn9.setEnabled(false);
                    }else if(g1==2&&g7==2&&g4==2||g5==2&&g6==2&&g4==2){
                        Toast t2=Toast.makeText(this,"Gano el jugador "+ jugador2, Toast.LENGTH_LONG);
                        t2.show();
                        puntajeO+=1;
                        mensaje="";players.setText("");
                        mensaje = "X Jugador "+jugador1 +": "+ puntajeX  +"\nO Jugador "+jugador2 +" : "+ puntajeO;
                        players.setText(mensaje);
                        btn1.setEnabled(false);  btn2.setEnabled(false);  btn3.setEnabled(false);
                        btn4.setEnabled(false);  btn5.setEnabled(false);  btn6.setEnabled(false);
                        btn7.setEnabled(false);  btn8.setEnabled(false);  btn9.setEnabled(false);
                    }else if (e1==true&&e2==true&&e3==true&&e4==true&&e5==true&&e6==true&&e7==true&&e8==true&&e9==true){
                        Toast t2=Toast.makeText(this,"El juego se ha empatado", Toast.LENGTH_LONG);
                        t2.show();
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
                        btn5.setImageResource(R.drawable.cruz);
                        contador+=1;
                        g5=1;
                    }else{
                        btn5.setImageResource(R.drawable.aro);
                        contador+=1;
                        g5=2;
                    }
                    e5 = true;

                    if(g1==1&&g9==1&&g5==1||g3==1&&g7==1&&g5==1||g2==1&&g8==1&&g5==1||g4==1&&g6==1&&g5==1){
                        Toast t2=Toast.makeText(this,"Gano el jugador "+ jugador1, Toast.LENGTH_LONG);
                        t2.show();
                        puntajeX+=1;
                        mensaje="";players.setText("");
                        mensaje = "X Jugador "+jugador1 +": "+ puntajeX  +"\nO Jugador "+jugador2 +" : "+ puntajeO;
                        players.setText(mensaje);
                        btn1.setEnabled(false);  btn2.setEnabled(false);  btn3.setEnabled(false);
                        btn4.setEnabled(false);  btn5.setEnabled(false);  btn6.setEnabled(false);
                        btn7.setEnabled(false);  btn8.setEnabled(false);  btn9.setEnabled(false);
                    }else if(g1==2&&g9==2&&g5==2||g3==2&&g7==2&&g5==2||g2==2&&g8==2&&g5==2||g4==2&&g6==2&&g5==2){
                        Toast t2=Toast.makeText(this,"Gano el jugador "+ jugador2, Toast.LENGTH_LONG);
                        t2.show();
                        puntajeO+=1;
                        mensaje="";players.setText("");
                        mensaje = "X Jugador "+jugador1 +": "+ puntajeX  +"\nO Jugador "+jugador2 +" : "+ puntajeO;
                        players.setText(mensaje);
                        btn1.setEnabled(false);  btn2.setEnabled(false);  btn3.setEnabled(false);
                        btn4.setEnabled(false);  btn5.setEnabled(false);  btn6.setEnabled(false);
                        btn7.setEnabled(false);  btn8.setEnabled(false);  btn9.setEnabled(false);
                    }else if (e1==true&&e2==true&&e3==true&&e4==true&&e5==true&&e6==true&&e7==true&&e8==true&&e9==true){
                        Toast t2=Toast.makeText(this,"El juego se ha empatado", Toast.LENGTH_LONG);
                        t2.show();
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
                        btn6.setImageResource(R.drawable.cruz);
                        contador+=1;
                        g6=1;
                    }else{
                        btn6.setImageResource(R.drawable.aro);
                        contador+=1;
                        g6=2;
                    }

                    e6 = true;

                    if(g4==1&&g5==1&&g6==1||g3==1&&g9==1&&g6==1){
                        Toast t2=Toast.makeText(this,"Gano el jugador "+ jugador1, Toast.LENGTH_LONG);
                        t2.show();
                        puntajeX+=1;
                        mensaje="";players.setText("");
                        mensaje = "X Jugador "+jugador1 +": "+ puntajeX  +"\nO Jugador "+jugador2 +" : "+ puntajeO;
                        players.setText(mensaje);btn1.setEnabled(false);  btn2.setEnabled(false);  btn3.setEnabled(false);
                        btn4.setEnabled(false);  btn5.setEnabled(false);  btn6.setEnabled(false);
                        btn7.setEnabled(false);  btn8.setEnabled(false);  btn9.setEnabled(false);
                    }else if(g4==2&&g5==2&&g6==2||g3==2&&g9==2&&g6==2){
                        Toast t2=Toast.makeText(this,"Gano el jugador "+ jugador2, Toast.LENGTH_LONG);
                        t2.show();
                        puntajeO+=1;
                        mensaje="";players.setText("");
                        mensaje = "X Jugador "+jugador1 +": "+ puntajeX  +"\nO Jugador "+jugador2 +" : "+ puntajeO;
                        players.setText(mensaje);
                        btn1.setEnabled(false);  btn2.setEnabled(false);  btn3.setEnabled(false);
                        btn4.setEnabled(false);  btn5.setEnabled(false);  btn6.setEnabled(false);
                        btn7.setEnabled(false);  btn8.setEnabled(false);  btn9.setEnabled(false);
                    }else if (e1==true&&e2==true&&e3==true&&e4==true&&e5==true&&e6==true&&e7==true&&e8==true&&e9==true){
                        Toast t2=Toast.makeText(this,"El juego se ha empatado", Toast.LENGTH_LONG);
                        t2.show();
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
                        btn7.setImageResource(R.drawable.cruz);
                        contador+=1;
                        g7=1;
                    }else{
                        btn7.setImageResource(R.drawable.aro);
                        contador+=1;
                        g7=2;
                    }

                    e7 = true;

                    if(g1==1&&g4==1&&g7==1||g8==1&&g9==1&&g7==1||g5==1&&g3==1&&g7==1){
                        Toast t2=Toast.makeText(this,"Gano el jugador "+ jugador1, Toast.LENGTH_LONG);
                        t2.show();
                        puntajeX+=1;
                        mensaje="";players.setText("");
                        mensaje = "X Jugador "+jugador1 +": "+ puntajeX  +"\nO Jugador "+jugador2 +" : "+ puntajeO;
                        players.setText(mensaje);
                        btn1.setEnabled(false);  btn2.setEnabled(false);  btn3.setEnabled(false);
                        btn4.setEnabled(false);  btn5.setEnabled(false);  btn6.setEnabled(false);
                        btn7.setEnabled(false);  btn8.setEnabled(false);  btn9.setEnabled(false);
                    }else if(g1==2&&g4==2&&g7==2||g8==2&&g9==2&&g7==2||g5==2&&g3==2&&g7==2){
                        Toast t2=Toast.makeText(this,"Gano el jugador "+ jugador2, Toast.LENGTH_LONG);
                        t2.show();
                        puntajeO+=1;
                        mensaje="";players.setText("");
                        mensaje = "X Jugador "+jugador1 +": "+ puntajeX  +"\nO Jugador "+jugador2 +" : "+ puntajeO;
                        players.setText(mensaje);
                        btn1.setEnabled(false);  btn2.setEnabled(false);  btn3.setEnabled(false);
                        btn4.setEnabled(false);  btn5.setEnabled(false);  btn6.setEnabled(false);
                        btn7.setEnabled(false);  btn8.setEnabled(false);  btn9.setEnabled(false);
                    }else if (e1==true&&e2==true&&e3==true&&e4==true&&e5==true&&e6==true&&e7==true&&e8==true&&e9==true){
                        Toast t2=Toast.makeText(this,"El juego se ha empatado", Toast.LENGTH_LONG);
                        t2.show();
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
                        btn8.setImageResource(R.drawable.cruz);
                        contador+=1;
                        g8=1;
                    }else{
                        btn8.setImageResource(R.drawable.aro);
                        contador+=1;
                        g8=2;
                    }

                    e8 = true;

                    if(g7==1&&g9==1&&g8==1||g2==1&&g5==1&&g8==1){
                        Toast t2=Toast.makeText(this,"Gano el jugador "+ jugador1, Toast.LENGTH_LONG);
                        t2.show();
                        puntajeX+=1;
                        mensaje="";players.setText("");
                        mensaje = "X Jugador "+jugador1 +": "+ puntajeX  +"\nO Jugador "+jugador2 +" : "+ puntajeO;
                        players.setText(mensaje);
                        btn1.setEnabled(false);  btn2.setEnabled(false);  btn3.setEnabled(false);
                        btn4.setEnabled(false);  btn5.setEnabled(false);  btn6.setEnabled(false);
                        btn7.setEnabled(false);  btn8.setEnabled(false);  btn9.setEnabled(false);
                    }else if(g7==2&&g9==2&&g8==2||g2==2&&g5==2&&g8==2){
                        Toast t2=Toast.makeText(this,"Gano el jugador "+ jugador2, Toast.LENGTH_LONG);
                        t2.show();
                        puntajeO+=1;
                        mensaje="";players.setText("");
                        mensaje = "X Jugador "+jugador1 +": "+ puntajeX  +"\nO Jugador "+jugador2 +" : "+ puntajeO;
                        players.setText(mensaje);
                        btn1.setEnabled(false);  btn2.setEnabled(false);  btn3.setEnabled(false);
                        btn4.setEnabled(false);  btn5.setEnabled(false);  btn6.setEnabled(false);
                        btn7.setEnabled(false);  btn8.setEnabled(false);  btn9.setEnabled(false);
                    }else if (e1==true&&e2==true&&e3==true&&e4==true&&e5==true&&e6==true&&e7==true&&e8==true&&e9==true){
                        Toast t2=Toast.makeText(this,"El juego se ha empatado", Toast.LENGTH_LONG);
                        t2.show();
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
                        btn9.setImageResource(R.drawable.cruz);
                        contador+=1;
                        g9=1;
                    }else{
                        btn9.setImageResource(R.drawable.aro);
                        contador+=1;
                        g9=2;
                    }

                    e9 = true;

                    if(g1==1&&g5==1&&g9==1||g7==1&&g8==1&&g9==1||g3==1&&g6==1&&g9==1){
                        Toast t2=Toast.makeText(this,"Gano el jugador "+ jugador1, Toast.LENGTH_LONG);
                        t2.show();
                        puntajeX+=1;
                        mensaje="";players.setText("");
                        mensaje = "X Jugador "+jugador1 +": "+ puntajeX  +"\nO Jugador "+jugador2 +" : "+ puntajeO;
                        players.setText(mensaje);
                        btn1.setEnabled(false);  btn2.setEnabled(false);  btn3.setEnabled(false);
                        btn4.setEnabled(false);  btn5.setEnabled(false);  btn6.setEnabled(false);
                        btn7.setEnabled(false);  btn8.setEnabled(false);  btn9.setEnabled(false);
                    }else if(g1==2&&g5==2&&g9==2||g7==2&&g8==2&&g9==2||g3==2&&g6==2&&g9==2){
                        Toast t2=Toast.makeText(this,"Gano el jugador "+ jugador2, Toast.LENGTH_LONG);
                        t2.show();
                        puntajeO+=1;
                        mensaje="";players.setText("");
                        mensaje = "X Jugador "+jugador1 +": "+ puntajeX  +"\nO Jugador "+jugador2 +" : "+ puntajeO;
                        players.setText(mensaje);
                        btn1.setEnabled(false);  btn2.setEnabled(false);  btn3.setEnabled(false);
                        btn4.setEnabled(false);  btn5.setEnabled(false);  btn6.setEnabled(false);
                        btn7.setEnabled(false);  btn8.setEnabled(false);  btn9.setEnabled(false);
                    }else if (e1==true&&e2==true&&e3==true&&e4==true&&e5==true&&e6==true&&e7==true&&e8==true&&e9==true){
                        Toast t2=Toast.makeText(this,"El juego se ha empatado", Toast.LENGTH_LONG);
                        t2.show();
                    }

                }else{
                    Toast t1=Toast.makeText(this,"La casilla ya esta ocupada", Toast.LENGTH_LONG);
                    t1.show();
                }
                break;
            case R.id.button10:
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
                break;
            case R.id.regresar:
                try {
                    aBD = new AyudanteBD(this, "Gato", null, 1);
                    db = aBD.getWritableDatabase();
                    if (db != null) {
                        db.execSQL("insert into resultados values ('" + jugador1
                                + "','" + puntajeX + "','" + jugador2 + "','" + puntajeO + "')");
                        db.close();
                        Toast.makeText(getApplicationContext(),
                                "Puntaje de la Batalla Guardada!!",
                                Toast.LENGTH_LONG).show();
                    } else
                        Toast.makeText(getApplicationContext(), "BD fue null",
                                Toast.LENGTH_LONG).show();
                }// try
                catch (Exception e) {
                    Toast.makeText(getApplicationContext(),
                            e.getMessage() + "\n\n", Toast.LENGTH_LONG).show();
                }

                Intent intencion2 = new Intent (this,Principal.class);
                startActivity(intencion2);
                break;
            case R.id.imgBtn1:
                jugador1 = "Corazon";
                if (yaEligio){
                    jugador2 = "Corazon";
                }
                yaEligio = true;
                break;
            case R.id.imgBtn2:
                jugador1 = "Cornea";
                if (yaEligio){
                    jugador2 = "Cornea";
                }
                yaEligio = true;
                break;
            case R.id.imgBtn3:
                jugador1 = "Rinion";
                if (yaEligio){
                    jugador2 = "Rinion";
                }
                yaEligio = true;
                break;
            case R.id.imgBtn4:
                jugador1 = "Pulmon";
                if (yaEligio){
                    jugador2 = "Pulmon";
                }
                yaEligio = true;
                break;
        }


    }
}

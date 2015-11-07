package com.aadfm.itz.donahealth;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class Body extends AppCompatActivity {

    MediaPlayer mp;

    AnimationDrawable corazonA, higadoA, cornia, pancreas, hueso, pulmon, pulmon1, intestino;
    Ayudante aBD;
    SQLiteDatabase db=null;
    int incre;

    int []audio={R.raw.g1, R.raw.g2 ,R.raw.g1,R.raw.g1,R.raw.g5,R.raw.g6,R.raw.c1,R.raw.c2, R.raw.c3, R.raw.cz2, R.raw.h1,
            R.raw.hg2};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_body);

        datos();

        corazonA = (AnimationDrawable)getResources().getDrawable(R.drawable.corazonani);
        ImageView vistaC = (ImageView) findViewById(R.id.corazon);
        vistaC.setImageDrawable(corazonA);
        corazonA.start();

        vistaC.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                message("Corazón");
            }
        });

        pancreas = (AnimationDrawable)getResources().getDrawable(R.drawable.pancreasani);
        ImageView vistaP = (ImageView) findViewById(R.id.pancreas);
        vistaP.setImageDrawable(pancreas);
        pancreas.start();

        vistaP.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                message("Páncreas");
            }
        });


        higadoA = (AnimationDrawable)getResources().getDrawable(R.drawable.higadoani);
        ImageView vistaH = (ImageView) findViewById(R.id.higado);
        vistaH.setImageDrawable(higadoA);
        higadoA.start();

        vistaH.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                message("Hígado");
            }
        });


        pulmon = (AnimationDrawable)getResources().getDrawable(R.drawable.pulmonesani);
        ImageView vistaPu = (ImageView) findViewById(R.id.pulmon1);
        vistaPu.setImageDrawable(pulmon);
        pulmon.start();

        vistaPu.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                message("Pulmón");
            }
        });


        pulmon1 = (AnimationDrawable)getResources().getDrawable(R.drawable.pulmonesani1);
        ImageView vistaPu1 = (ImageView) findViewById(R.id.pulmon2);
        vistaPu1.setImageDrawable(pulmon1);
        pulmon1.start();

        vistaPu1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                message("Pulmón");
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
                message("Córnea");
            }
        });


    }

    public String mensaje(String organo){

        String cad="";
        int numAleatorio;
        if(organo.equalsIgnoreCase("General")){
            numAleatorio= aleatorio(6);
        }else{
            numAleatorio= aleatorio(2);
        }

        try{
            aBD=new Ayudante(this,"mensajes",null,1);
            db = aBD.getReadableDatabase();
            if (db!=null) {
                Cursor cursor = db.rawQuery("SELECT * FROM mensajes where tematica='"+organo+"' and  num="+numAleatorio,null);//+i+" and num="+g,null);//+num+" and num="+numAleatorio+"",null);
                int numcol=cursor.getColumnCount();
                int numren=cursor.getCount();
                while (cursor.moveToNext()){
                    cad=cursor.getString(2);
                }//while
                //Toast.makeText(getApplicationContext(),"es "+numAleatorio,Toast.LENGTH_SHORT).show();

                cursor.close();
                db.close();
            }//if
            else
                cad="db fue null";
        }//try
        catch (Exception e) {
            String cad2="ERROR "+e.getMessage();
        }//catch
        return cad;
    }

    public int aleatorio(int numero){ // devuelve numeros aleatorios del 1 al 3
        int num=0;
        num=(int) (Math.random()*numero+1);
        return num;
    }

    public void voz() {
        mp = MediaPlayer.create(this,audio[incre]);
        mp.start();
    }

    public void datos(){

        //llamada al metodo para regresar el mensaje.
        String h="";
        try{
            aBD=new Ayudante(this,"mensajes",null,1);
            db = aBD.getWritableDatabase();
            if (db!=null) {
                db.execSQL("insert into mensajes values(null,'General','Puedes donar en vida y después de la muerte',1)");
                db.execSQL("insert into mensajes values(null,'General',' El 26 de septiembre, se celebra en México el Día Nacional de Donación y Trasplante de Órganos y Tejidos',2)");
                db.execSQL("insert into mensajes values(null,'General',' En México cerca de 19 mil personas están en espera de un trasplante, de riñón',3)");
                db.execSQL("insert into mensajes values(null,'General','¡Una persona que dona sus órganos cuando ya no los necesita puede salvar más de 7 vidas!',4)");
                db.execSQL("insert into mensajes values(null,'General','Un receptor no debe cumplir necesariamente con la misma edad que el donante',5)");
                db.execSQL("insert into mensajes values(null,'General',' Corazón, hígado y riñón se pueden donar desde los dos meses de vida, hasta los 55 años de edad los dos primeros y el riñón hasta 75',6)");
                db.execSQL("insert into mensajes values(null,'Córnea',' En este año, se han realizado 327 trasplantes de Córnea, de los cuales solo 36 fueron importados ',1)");
                db.execSQL("insert into mensajes values(null,'Córnea',' El Estado de México obtuvo licencia para trasplantes de córnea en el 2007',2)");
                db.execSQL("insert into mensajes values(null,'Riñón','Este año ha habido sólo 69 trasplantes de riñón',1)");
                db.execSQL("insert into mensajes values(null,'Riñón',' Este año las donaciones de riñón han aumentado un 97%',2)");
                db.execSQL("insert into mensajes values(null,'Corazón','El Estado de México obtuvo licencia para trasplantes de corazón en el 2015',1)");
                db.execSQL("insert into mensajes values(null,'Corazón',' El primer trasplante humano de corazón ocurrió en 1964 en la Universidad de Mississippi en Jackson',2)");
                db.execSQL("insert into mensajes values(null,'Hígado','El Estado de México obtuvo licencia para trasplantes de hígado en el 2014',1)");
                db.execSQL("insert into mensajes values(null,'Huesos','Un solo donador puede beneficiar hasta 250 personas que recibirán un trasplante de hueso',1)");
                db.execSQL("insert into mensajes values(null,'Huesos','La donación de láminas de piel no es deformante ni mutilante',2)");
                db.execSQL("insert into mensajes values(null,'Piel','El trasplante de piel puede permitir conservar la vida de enfermos para los que no habría ninguna otra opción terapéutica',1)");
                db.execSQL("insert into mensajes values(null,'Pulmón','El Un donante vivo también puede ser donador de pulmón Cada persona dona un segmento (lóbulo) de su pulmón para formar un pulmón entero para la persona que lo recibe',1)");
                db.execSQL("insert into mensajes values(null,'Pulmón','El Un donante vivo también puede ser donador de pulmón Cada persona dona un segmento (lóbulo) de su pulmón para formar un pulmón entero para la persona que lo recibe...-',2)");
                db.execSQL("insert into mensajes values(null,'Piel','La donación de láminas de piel no es deformante ni mutilante',2)");
                db.execSQL("insert into mensajes values(null,'Páncreas','Un trasplante de páncreas puede curar la diabetes y eliminar la necesidad de inyecciones de insulina',1)");
                db.execSQL("insert into mensajes values(null,'Páncreas','Una persona puede recibir una parte del páncreas de un familiar vivo.',2)");
                db.execSQL("insert into mensajes values(null,'Hígado','Una persona puede recibir la mitad del Hígado de un familiar vivo.',2)");

                db.close();
            } else
                h="db fue null :-(";
        }//try
        catch (Exception e)
        {
            h=e.getMessage()+"\n\n";
        }



    }




    public void alerta(String menssage){

        AlertDialog alertDialog = new AlertDialog.Builder(

                Body.this).create();

        // Setting Dialog Title
        alertDialog.setTitle("¿ Sabias que ?");

        // Setting Dialog Message
        alertDialog.setMessage(menssage);

        // Setting Icon to Dialog
        alertDialog.setIcon(R.drawable.acorazon1);
        alertDialog.setCancelable(false);

        // Setting OK Button
        alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                // Write your code here to execute after dialog closed
               mp.stop();
            }
        });

        // Showing Alert Message
        alertDialog.show();


    }




    public void message(String org){




        String p = mensaje(org);//mensaje(1).toString()

        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.main, (ViewGroup) findViewById(R.id.custom_toast_layout_id));

        ImageView image = (ImageView) layout.findViewById(R.id.imgToast);
        image.setImageResource(R.drawable.corazon2);
        TextView text = (TextView) layout.findViewById(R.id.textoToast);
        text.setText(p + "!");


       /* TextView text2 = (TextView) layout.findViewById(R.id.textoToast1);
        text2.setText(org+".");

        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        //toast.show();


        toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(layout);
        //toast.show();
*/
        alerta(p);



        if(incre == audio.length) incre=0;
        voz();
        incre++;




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
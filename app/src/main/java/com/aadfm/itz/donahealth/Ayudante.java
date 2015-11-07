package com.aadfm.itz.donahealth;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class Ayudante extends SQLiteOpenHelper {
	//Sentencia para crear la tabla de Usuarios
	
	String sentenciaCreacionSQL = "CREATE TABLE mensajes (id INTEGER PRIMARY KEY AUTOINCREMENT,tematica TEXT, texto TEXT, num INTEGER)";

	public Ayudante(Context context, String name, CursorFactory factory,int version) {
					 //					//nombre base de datos 	//null //version del proyecto
	super(context, name, factory, version);
	}
	@Override
	public void onCreate(SQLiteDatabase db) {
	//Se ejecuta la sentencia SQL de creaci�n de la tabla
	db.execSQL(sentenciaCreacionSQL);
	}
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

	}
	}
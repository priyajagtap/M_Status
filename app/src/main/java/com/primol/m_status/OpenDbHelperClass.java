package com.primol.m_status;

/**
 * Created by Amol on 09/11/2015.
 */

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


public class OpenDbHelperClass extends SQLiteOpenHelper {
    private static String DB_PATH= "data/data/com.primol.m_status/databases/";
    private static String DB_NAME = "M_Status_DB";
    private SQLiteDatabase dbObj;
    private final Context context;

    public OpenDbHelperClass(Context context) {
        super(context,  DB_NAME , null, 3);
        this. context  = context;
    }

    public void createDB() throws IOException {

        this.getReadableDatabase();
        Log.i("Readable ends...","end");

        try {
            copyDB();
            Log.i("copy db ends...","end");

        } catch (IOException e) {

            throw new Error("Error copying database");
        }
    }

    public boolean checkDB(){

        SQLiteDatabase checkDB = null;

        try{
            String path = DB_PATH + DB_NAME;
            Log.i("myPath ......",path);
            checkDB = SQLiteDatabase.openDatabase(path, null, SQLiteDatabase.OPEN_READONLY);

            Log.i("myPath ......",path);
            if (checkDB!=null)
            {
                 }
            else
            {
                return false;
            }

        }catch(SQLiteException e){
            e.printStackTrace();
        }

        if(checkDB != null){

            checkDB.close();

        }
        return checkDB != null ? true : false;
    }

    public void copyDB() throws IOException{
        try {
            Log.i("inside copyDB...","start");

            InputStream ip =  context.getAssets().open(DB_NAME+".sqlite");
            Log.i("Input Stream....",ip+"");
            String op =  DB_PATH  +  DB_NAME ;
            OutputStream output = new FileOutputStream( op);
            byte[] buffer = new byte[2024];
            int length;
            while ((length = ip.read(buffer))>0){
                output.write(buffer, 0, length);
                Log.i("Content.... ",length+"");
            }
            //output.flush();
            output.close();
            ip.close();
        }
        catch (IOException e) {
            Log.v("error", e.toString());
        }
    }

    public void openDB() throws SQLException {

        String myPath = DB_PATH + DB_NAME;
        dbObj = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READWRITE);
        Log.i("open DB......",dbObj.toString());
    }

    @Override
    public synchronized void close() {

        if(dbObj != null)
            dbObj.close();

        super.close();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

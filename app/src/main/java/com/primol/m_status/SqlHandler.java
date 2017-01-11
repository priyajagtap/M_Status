package com.primol.m_status;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


public class SqlHandler {


    Context context;
    SQLiteDatabase sqlDatabase;
    OpenDbHelperClass dbHelper;
    public SqlHandler(Context context) {

        dbHelper = new OpenDbHelperClass(context);
        sqlDatabase = dbHelper.getWritableDatabase();
        // TODO Auto-generated constructor stub
    }

    public void executeQuery(String query) {
        try {
            // if (sqlDatabase.isOpen()) {
            // sqlDatabase.close();
            //}
            sqlDatabase = dbHelper.getWritableDatabase();
            //System.out.print("inserting");
            sqlDatabase.execSQL(query);
            // System.out.print("inserted");
        }
        catch (Exception e) {
            System.out.println("DATABASE ERROR " + e);
        }
    }

    public Cursor selectQuery(String query) {

        Cursor c1 = null;

        try {
            if (sqlDatabase.isOpen()) {
                sqlDatabase.close();
            }
            sqlDatabase = dbHelper.getWritableDatabase();
            c1 = sqlDatabase.rawQuery(query, null);

        }
        catch (Exception e)
        {
            System.out.println("DATABASE ERROR " + e);
        }
        return c1;
    }
}

package com.android.dvs.machinetesthealthcoco;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.ContactsContract;
import android.util.Log;

import java.util.ArrayList;

public class DatabaseHelper  extends SQLiteOpenHelper {

   private static final String DATABASE_NAME ="EmployeeDatabase";
   private static final String TABLENAME ="Employee";

   private static final String COLUMN_ID ="Id";
   private static final String NAME ="Name";
   private static final String MOBILENO ="MobileNo";
   private static final String GENDER ="gender";

    private  String CREATE_TABLE = "CREATE TABLE " + TABLENAME + "("
            + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + NAME + " TEXT,"
            + MOBILENO + " TEXT,"
            + GENDER+" TEXT"
            + ")";;


    public DatabaseHelper(Context context){
        super(context,DATABASE_NAME,null,1);
    }

    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_TABLE);


    }
    public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {

        database.execSQL("DROP TABLE IF EXISTS " + TABLENAME);

        // Create tables again
        onCreate(database);


    }


    public long addEmployee(String name,String mobno,String gender)
    {


        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        // `id` and `timestamp` will be inserted automatically.
        // no need to add them
        values.put(NAME, name);
        values.put(MOBILENO, mobno);
        values.put(GENDER, gender);

        // insert row
        long id = db.insert(TABLENAME, null, values);

        // close db connection
        db.close();

        // return newly inserted row id
        return id;


    }


    public ArrayList<EmployeeModel> getAllRecords(){

        ArrayList<EmployeeModel> empList = new ArrayList<>();
        String selectQuery = "SELECT  * FROM " + TABLENAME ;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                EmployeeModel employeeModel = new EmployeeModel();
                employeeModel.setName(cursor.getString(cursor.getColumnIndex(NAME)));
                employeeModel.setGender(cursor.getString(cursor.getColumnIndex(GENDER)));
                employeeModel.setMobNo(cursor.getString(cursor.getColumnIndex(MOBILENO)));
                empList.add(employeeModel);
            } while (cursor.moveToNext());
        }

        // close db connection
        db.close();


        return empList;

    }







}

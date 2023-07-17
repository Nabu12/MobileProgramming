package com.example.sqliteexample;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;


public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "employee_database";
    private static final int DB_VERSION = 1;
    private static final String TABLE_NAME = "EMPLOYEE";
    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String EMAIL = "email";
     private SQLiteDatabase sqLiteDatabase;
    private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " ("+ ID + "INTEGER PRIMARY KEY AUTOINCREMENT,"
            + NAME + " TEXT NOT NULL,"
            + EMAIL + " TEXT NOT NULL);";

    public DatabaseHelper(Context context){
        super(context,DB_NAME, null,DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }


    //Add Employee data
    public void addEmployee(EmployeeModel employeeModel){
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelper.NAME,employeeModel.getName());
        contentValues.put(DatabaseHelper.EMAIL,employeeModel.getEmail());
        sqLiteDatabase =  this.getWritableDatabase();
        sqLiteDatabase.insert(DatabaseHelper.TABLE_NAME,null,contentValues);

    }
public List<EmployeeModel> getEmployeeList(){
        String sql = "select * from " +TABLE_NAME;
        sqLiteDatabase = this.getReadableDatabase();
        List<EmployeeModel> storeEmployee = new ArrayList<>();
    Cursor cursor = sqLiteDatabase.rawQuery(sql,null);
    if (cursor.moveToFirst()){
        do{
            int id = Integer.parseInt(cursor.getString(0));
            String name = cursor.getString(1);
            String email = cursor.getString(2);
            storeEmployee.add(new EmployeeModel(id,name,email));
        }while(cursor.moveToNext());
    }
    cursor.close();
    return  storeEmployee;

}
}

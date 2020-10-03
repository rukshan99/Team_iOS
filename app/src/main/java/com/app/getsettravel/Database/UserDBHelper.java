package com.app.getsettravel.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.app.getsettravel.model.User;

import java.util.ArrayList;

public class UserDBHelper extends SQLiteOpenHelper {

    public static final String DBNAME = "getsettravel.db";

    public static final String USERS_TABLE_NAME = "users";
    /*public static final String USERS_COLUMN_ID = "id"; */
    public static final String USERS_COLUMN_NAME = "userName";
    public static final String USERS_COLUMN_EMAIL = "email";
    public static final String USERS_COLUMN_PASS = "password";
    public static final String USERS_COLUMN_ADDRESS = "address";
    public static final String USERS_COLUMN_PHONE="phone";


    public UserDBHelper(Context context) {
        super(context, DBNAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase getsettravel) {

        String SQL_CREATE_ENTRIES =
                "CREATE TABLE " + USERS_TABLE_NAME + " (" +
                        USERS_COLUMN_NAME + " TEXT PRIMARY KEY," +
                        USERS_COLUMN_EMAIL + " TEXT NOT NULL," +
                        USERS_COLUMN_PASS + " TEXT NOT NULL," +
                        USERS_COLUMN_ADDRESS + " TEXT NOT NULL," +
                        USERS_COLUMN_PHONE + " TEXT NOT NULL)";

        getsettravel.execSQL(SQL_CREATE_ENTRIES);



       /* getsettravel.execSQL("CREATE TABLE users(userName TEXT PRIMARY KEY  , email TEXT ,  password TEXT  , address TEXT , phone TEXT )");*/

    }

    @Override
    public void onUpgrade(SQLiteDatabase getsettravel, int i, int i1) {

        getsettravel.execSQL("drop Table if exists " + USERS_TABLE_NAME );


    }

    public Boolean insertData(String userName, String password, String email, String address, String phone){
        /*
        SQLiteDatabase getsettravel = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(User.Users.COLUMN_NAME_USERNAME, userName);
        values.put(User.Users.COLUMN_NAME_PASSWORD, password);
        values.put(User.Users.COLUMN_NAME_EMAIL, email);
        values.put(User.Users.COLUMN_NAME_ADDRESS, address);
        values.put(User.Users.COLUMN_NAME_PHONE, phone);

        long results = getsettravel.insert(User.Users.TABLE_NAME, null,values);
        if (results==-1) return false;
        else
            return true;
        */

        SQLiteDatabase getsettravel = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(USERS_COLUMN_NAME, userName);
        contentValues.put(USERS_COLUMN_EMAIL,email);
        contentValues.put(USERS_COLUMN_PASS,password);
        contentValues.put(USERS_COLUMN_ADDRESS,address);
        contentValues.put(USERS_COLUMN_PHONE,phone);

        long results = getsettravel.insert(USERS_TABLE_NAME,null,contentValues);
        if (results==-1) return false;
        else
            return true;


    }

    public Boolean checkUsername(String userName){

        SQLiteDatabase getsettravel = this.getWritableDatabase();
        Cursor cursor = getsettravel.rawQuery("Select * FROM users WHERE userName = ?" ,new String[] {userName});
        if (cursor.getCount()>0)
            return true;
        else
            return false;
    }

    public  Boolean checkUsernamePassword(String userName, String password){

        SQLiteDatabase getsettravel = this.getWritableDatabase();
        Cursor cursor = getsettravel.rawQuery("SELECT * FROM users WHERE userName = ? and password = ?" ,new String[] {userName,password});
        if (cursor.getCount()>0)
            return true;
        else
            return false;
    }

    public Boolean updateData( String userName, String email, String password, String address, String phone){

        SQLiteDatabase getsettravel = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("email",email);
        contentValues.put("password",password);
        contentValues.put("address",address);
        contentValues.put("phone",phone);

        Cursor cursor = getsettravel.rawQuery("select * from users Where userName=?",new String[] {userName});
        if (cursor.getCount()>0) {

            long results = getsettravel.update("users", contentValues, "userName=?", new String[]{userName});
            if (results == -1) {
                return false;
            }
            else
                return true;
        }
        else{

            return false;
        }
    }

    public Boolean deleteData(String userName){

        SQLiteDatabase getsettravel = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        Cursor cursor = getsettravel.rawQuery("select * from users Where userName=?",new String[] {userName});
        if (cursor.getCount()>0) {

            long results = getsettravel.delete("users", "userName=?", new String[]{userName});
            if (results == -1) return false;
            else
                return true;
        }
        else{

            return false;
        }
    }
/*
    public Cursor getUser(String userName) {
        SQLiteDatabase getsettravel = this.getReadableDatabase();
        Cursor cursor =  getsettravel.rawQuery( "select * from users where userName="+userName+"", null );

        return cursor;
    }*/

    /*
    public Cursor getData(String userName){

        SQLiteDatabase getsettravel = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        Cursor cursor = getsettravel.rawQuery("select * from users Where userName=?",new String[] {userName});
        if (cursor.getCount()>0) {

            long results = getsettravel.delete("users", "userName=?", new String[]{userName});


        }

        return cursor;

    } */

    public Cursor getAllData(){

        SQLiteDatabase getsettravel = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        Cursor cursor = getsettravel.rawQuery("select * from users ",null);
        return cursor;
    }

    public Boolean ResetPassword(String userName,String password){


        SQLiteDatabase getsettravel = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();


        contentValues.put("password",password);


        long results = getsettravel.update("users",contentValues,"userName = ?",new String[] {userName});
        if (results==-1) return false;
        else
            return true;


    }


    public ArrayList<User> getUsers(){

        ArrayList<User> list = new ArrayList<>();
        SQLiteDatabase getsettravel = getReadableDatabase();

        String userName;
        Cursor cursor = getsettravel.rawQuery("SELECT * FROM users",null);
        while ( cursor.moveToNext()){

            String  name = cursor.getString(0);
            String email = cursor.getString(1);
            String add = cursor.getString(3);
            String phone = cursor.getString(4);

            User user = new User(name,email,add,phone);

            list.add(user);

        }

        return list;

    }

    public User getUser(String userName){

        SQLiteDatabase getsettravel = getWritableDatabase();
        Cursor cursor = getsettravel.query(USERS_TABLE_NAME,new String[]{USERS_COLUMN_NAME,USERS_COLUMN_EMAIL,USERS_COLUMN_PASS,USERS_COLUMN_ADDRESS,USERS_COLUMN_PHONE},
                USERS_COLUMN_NAME + "= ?",new String[]{userName},null,null,null);

        User user;

        if (cursor!=null){

            cursor.moveToFirst();
            user = new User(
                    cursor.getString(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4)


            );

            return  user;


        }

        return  null;


    }


}

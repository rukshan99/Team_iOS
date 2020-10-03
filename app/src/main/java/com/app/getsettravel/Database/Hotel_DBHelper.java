package com.app.getsettravel.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import com.app.getsettravel.model.Hotel;

import java.util.ArrayList;
import java.util.List;


public class Hotel_DBHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "GetSetTravel.db";

    public Hotel_DBHelper(Context context) {
        super(context,DATABASE_NAME,null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String SQL_CREATE_ENTRIES =
                "CREATE TABLE " + HotelAdd.HotelAdds.TABLE_NAME + " (" +
                        HotelAdd.HotelAdds._ID + " INTEGER PRIMARY KEY," +
                        HotelAdd.HotelAdds.COLUMN_NAME_HotelName + " TEXT NOT NULL," +
                        HotelAdd.HotelAdds.COLUMN_NAME_WebSite + " TEXT NOT NULL," +
                        HotelAdd.HotelAdds.COLUMN_NAME_Location + " TEXT NOT NULL," +
                        HotelAdd.HotelAdds.COLUMN_NAME_ContactPersonName + " TEXT NOT NULL," +
                        HotelAdd.HotelAdds.COLUMN_NAME_Email + " TEXT NOT NULL,"+
                        HotelAdd.HotelAdds.COLUMN_NAME_MobileNo + " TEXT NOT NULL," +
                        HotelAdd.HotelAdds.COLUMN_NAME_Budget + " TEXT NOT NULL," +
                        HotelAdd.HotelAdds.COLUMN_NAME_Description + " TEXT NOT NULL)" ;

        sqLiteDatabase.execSQL(SQL_CREATE_ENTRIES);
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public long addHotel(Hotel hotel) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(HotelAdd.HotelAdds.COLUMN_NAME_HotelName, hotel.getHotelName());
        values.put(HotelAdd.HotelAdds.COLUMN_NAME_WebSite, hotel.getWebSite());
        values.put(HotelAdd.HotelAdds.COLUMN_NAME_Location , hotel.getLocation());
        values.put(HotelAdd.HotelAdds.COLUMN_NAME_ContactPersonName, hotel.getContactPersonName());
        values.put(HotelAdd.HotelAdds.COLUMN_NAME_Email, hotel.getEmail());
        values.put(HotelAdd.HotelAdds.COLUMN_NAME_MobileNo, hotel.getMobileNo());
        values.put(HotelAdd.HotelAdds.COLUMN_NAME_Budget, hotel.getBudget());
        values.put(HotelAdd.HotelAdds.COLUMN_NAME_Description, hotel.getDescription());


        long newRowId = sqLiteDatabase.insert(HotelAdd.HotelAdds.TABLE_NAME, null,values);
        return newRowId;

    }

    public List<Hotel> getAllHotel(){
        List<Hotel> hotels = new ArrayList();
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        String query = "SELECT * FROM "+HotelAdd.HotelAdds.TABLE_NAME;

        Cursor cursor = sqLiteDatabase.rawQuery(query,null);

        if(cursor.moveToFirst()){
            do{
                Hotel hotel = new Hotel();

                hotel.setId(cursor.getInt(0));
                hotel.setHotelName(cursor.getString(1));
                hotel.setWebSite(cursor.getString(2));
                hotel.setLocation(cursor.getString(3));
                hotel.setContactPersonName(cursor.getString(4));
                hotel.setEmail(cursor.getString(5));
                hotel.setMobileNo(cursor.getString(6));
                hotel.setBudget(cursor.getString(7));
                hotel.setDescription(cursor.getString(8));

                hotels.add(hotel);
            }while (cursor.moveToNext());
        }
        return hotels;

    }


    public void deletehotel(int Id){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        sqLiteDatabase.delete(HotelAdd.HotelAdds.TABLE_NAME,HotelAdd.HotelAdds._ID +" =?",new String[]{String.valueOf(Id)});
        sqLiteDatabase.close();
    }


    public Hotel getHotel(int Id){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();


        Cursor cursor = sqLiteDatabase.query(HotelAdd.HotelAdds.TABLE_NAME,new String[]{HotelAdd.HotelAdds._ID,
                HotelAdd.HotelAdds.COLUMN_NAME_HotelName,
                HotelAdd.HotelAdds.COLUMN_NAME_WebSite,
                HotelAdd.HotelAdds.COLUMN_NAME_Location,
                HotelAdd.HotelAdds.COLUMN_NAME_ContactPersonName,
                HotelAdd.HotelAdds.COLUMN_NAME_Email,
                HotelAdd.HotelAdds.COLUMN_NAME_MobileNo,
                HotelAdd.HotelAdds.COLUMN_NAME_Budget,
                HotelAdd.HotelAdds.COLUMN_NAME_Description},
                HotelAdd.HotelAdds._ID + "= ?",new String[]{String.valueOf(Id)},null,null,null);
        Hotel hotel;
        if(cursor != null){
            cursor.moveToFirst();
            hotel = new Hotel(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4),
                    cursor.getString(5),
                    cursor.getString(6),
                    cursor.getString(7),
                    cursor.getString(8)
            );
            return hotel;
        }
        return null;
    }

    public  int updateHotel(Hotel hotel){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(HotelAdd.HotelAdds.COLUMN_NAME_HotelName,hotel.getHotelName());
        values.put(HotelAdd.HotelAdds.COLUMN_NAME_WebSite,hotel.getWebSite());
        values.put(HotelAdd.HotelAdds.COLUMN_NAME_Location,hotel.getLocation());
        values.put(HotelAdd.HotelAdds.COLUMN_NAME_ContactPersonName,hotel.getContactPersonName());
        values.put(HotelAdd.HotelAdds.COLUMN_NAME_Email,hotel.getEmail());
        values.put(HotelAdd.HotelAdds.COLUMN_NAME_MobileNo,hotel.getMobileNo());
        values.put(HotelAdd.HotelAdds.COLUMN_NAME_Budget,hotel.getBudget());
        values.put(HotelAdd.HotelAdds.COLUMN_NAME_Description,hotel.getDescription());

        int status = sqLiteDatabase.update(HotelAdd.HotelAdds.TABLE_NAME,values,HotelAdd.HotelAdds._ID +" =?",
                new String[]{String.valueOf(hotel.getId())});

        sqLiteDatabase.close();
        return status;
    }





}


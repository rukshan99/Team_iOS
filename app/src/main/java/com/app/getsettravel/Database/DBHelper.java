package com.app.getsettravel.Database;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;


import com.app.getsettravel.FeedbackV;
import com.app.getsettravel.Pro;

import java.util.ArrayList;
import java.util.List;


public class DBHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "GetSetTravel.db";

    public DBHelper(Context context) {

        super(context,DATABASE_NAME,null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String SQL_CREATE_ENTRIES =
                "CREATE TABLE " + Promotion.Promotions.TABLE_NAME + "(" +
                        Promotion.Promotions._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                        Promotion.Promotions.COLUMN_NAME_PROMOTIONCODE + "   TEXT NOT NULL," +
                        Promotion.Promotions.COLUMN_NAME_PROMOTIONTYPE + " TEXT NOT NULL," +
                        Promotion.Promotions.COLUMN_NAME_OFFER + " TEXT NOT NULL," +
                        Promotion.Promotions.COLUMN_NAME_DESCRIPTION + " TEXT NOT NULL)";
        String SQL_FEEDBACK_ENTRIES =
                "CREATE TABLE " + Promotion.Feedbacks.TABLE_NAME + " (" +
                        Promotion.Feedbacks._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                        Promotion.Feedbacks.COLUMN_NAME_FEEDCOMMENT + " TEXT," +
                        Promotion.Feedbacks.COLUMN_NAME_FEEDMAIL + " TEXT )";

        sqLiteDatabase.execSQL(SQL_CREATE_ENTRIES);
        sqLiteDatabase.execSQL(SQL_FEEDBACK_ENTRIES);

    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }


    public long addPromo(String PromotionCode, String PromotionType, String Offer, String Description ) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Promotion.Promotions.COLUMN_NAME_PROMOTIONCODE, PromotionCode);
        values.put(Promotion.Promotions.COLUMN_NAME_PROMOTIONTYPE, PromotionType);
        values.put(Promotion.Promotions.COLUMN_NAME_OFFER, Offer);
        values.put(Promotion.Promotions.COLUMN_NAME_DESCRIPTION, Description);

        long newRowId = sqLiteDatabase.insert(Promotion.Promotions.TABLE_NAME, null,values);
        return newRowId;

    }

    public List<Pro> getAllPro()  {
        List<Pro> promotions = new ArrayList();
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        String query = "SELECT * FROM " +Promotion.Promotions.TABLE_NAME;

        Cursor cursor = sqLiteDatabase.rawQuery(query,null);

        if (cursor.moveToFirst()){
            do{
                Pro pro = new Pro();

                pro.setId(cursor.getInt(0));
                pro.setPcode(cursor.getString(1));
                pro.setPtype(cursor.getString(2));
                pro.setPoffer(cursor.getString(3));
                pro.setPdes(cursor.getString(4));

                promotions.add(pro);
            }while (cursor.moveToNext());
        }
        return promotions;
    }

    public void deletepro(int Id) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        sqLiteDatabase.delete(Promotion.Promotions.TABLE_NAME, Promotion.Promotions._ID + " =?", new String[]{String.valueOf(Id)});
        sqLiteDatabase.close();

    }
    public Pro getPro (int Id){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        Cursor cursor = sqLiteDatabase.query(Promotion.Promotions.TABLE_NAME,new String[]{Promotion.Promotions._ID,Promotion.Promotions.COLUMN_NAME_PROMOTIONCODE,Promotion.Promotions.COLUMN_NAME_PROMOTIONTYPE,Promotion.Promotions.COLUMN_NAME_OFFER,Promotion.Promotions.COLUMN_NAME_DESCRIPTION},Promotion.Promotions._ID + "= ?",new String[]{String.valueOf(Id)},null,null,null);
        Pro pro;
        if(cursor != null){
            cursor.moveToFirst();
            pro = new Pro(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4)
            );

            return pro;
        }
        return null;

    }
    public int updatePro(Pro pro){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Promotion.Promotions.COLUMN_NAME_PROMOTIONCODE,pro.getPcode());
        values.put(Promotion.Promotions.COLUMN_NAME_PROMOTIONTYPE,pro.getPtype());
        values.put(Promotion.Promotions.COLUMN_NAME_OFFER,pro.getPoffer());
        values.put(Promotion.Promotions.COLUMN_NAME_DESCRIPTION,pro.getPdes());

        int status = sqLiteDatabase.update(Promotion.Promotions.TABLE_NAME,values,Promotion.Promotions._ID +" =?",
                new String[]{String.valueOf(pro.getId())});

        sqLiteDatabase.close();
        return status;
    }






    public long addfeedback(FeedbackV feedbackV){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Promotion.Feedbacks.COLUMN_NAME_FEEDCOMMENT,feedbackV.getComment());
        values.put(Promotion.Feedbacks.COLUMN_NAME_FEEDMAIL,feedbackV.getFmail());

        long newRowId = sqLiteDatabase.insert(Promotion.Feedbacks.TABLE_NAME,null,values);
        return newRowId;

    }

    public List<FeedbackV> getAllFeedback() {
        List<FeedbackV> feedbackVS = new ArrayList();
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        String query = "SELECT * FROM "+ Promotion.Feedbacks.TABLE_NAME;

        Cursor cursor = sqLiteDatabase.rawQuery(query,null);

        if(cursor.moveToFirst()){
            do{
                FeedbackV feedbackV = new FeedbackV();

                feedbackV.setId(cursor.getInt(0));
                feedbackV.setComment(cursor.getString(1));
                feedbackV.setFmail(cursor.getString(2));

                feedbackVS.add(feedbackV);
            }while (cursor.moveToNext());
        }
        return feedbackVS;

    }

    public void deletefeedback(int Id){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        sqLiteDatabase.delete(Promotion.Feedbacks.TABLE_NAME, Promotion.Feedbacks._ID +" =?",new String[]{String.valueOf(Id)});
        sqLiteDatabase.close();
    }

    public FeedbackV getfeedback (int Id){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        Cursor cursor = sqLiteDatabase.query(Promotion.Feedbacks.TABLE_NAME,new String[]{Promotion.Feedbacks._ID, Promotion.Feedbacks.COLUMN_NAME_FEEDCOMMENT,Promotion.Feedbacks.COLUMN_NAME_FEEDMAIL}, Promotion.Feedbacks._ID + "= ?",new String[]{String.valueOf(Id)},null,null,null);
        FeedbackV feedbackV;
        if(cursor != null){
            cursor.moveToFirst();
            feedbackV = new FeedbackV(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2)
            );
            return feedbackV;
        }
        return null;

    }


}




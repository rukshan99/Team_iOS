package com.app.getsettravel.Database;

        import android.provider.BaseColumns;

public class HotelAdd {
    public HotelAdd(){
    }

    public static class HotelAdds implements BaseColumns {
        public static final String TABLE_NAME = "Hotel";
        public static final String COLUMN_NAME_HotelName = "hotelName";
        public static final String COLUMN_NAME_WebSite = "webSite";
        public static final String COLUMN_NAME_Location = "location" ;
        public static final String COLUMN_NAME_ContactPersonName = "contactPersonName";
        public static final String COLUMN_NAME_Email = "email";
        public static final String COLUMN_NAME_MobileNo = "mobileNo";
        public static final String COLUMN_NAME_Budget = "budget";
        public static final String COLUMN_NAME_Description = "description";
    }

}
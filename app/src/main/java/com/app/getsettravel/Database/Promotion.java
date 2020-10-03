package com.app.getsettravel.Database;

import android.provider.BaseColumns;

public class Promotion {
    public Promotion() {
    }

    public static class Promotions implements BaseColumns {
        public static final String TABLE_NAME = "Promotion";
        public static final String COLUMN_NAME_PROMOTIONCODE = "PromotionCode";
        public static final String COLUMN_NAME_PROMOTIONTYPE = "PromotionType";
        public static final String COLUMN_NAME_OFFER = "Offer";
        public static final String COLUMN_NAME_DESCRIPTION = "Description";
    }


    public static class Feedbacks implements BaseColumns {
        public static final String TABLE_NAME = "Feedback";
        public static final String COLUMN_NAME_FEEDCOMMENT = "FeedComment";
        public static final String COLUMN_NAME_FEEDMAIL = "FeedMail";

    }


}
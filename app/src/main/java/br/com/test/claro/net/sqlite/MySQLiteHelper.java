package br.com.test.claro.net.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MySQLiteHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "databasetest.db";
    private static final int DATABASE_VERSION = 1;

    public MySQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(ShotDao.CREATE_TABLE_ITEM_MEDIA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(ShotDao.CREATE_TABLE_ITEM_MEDIA);
    }

}
package br.com.test.claro.net.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import br.com.test.claro.net.model.CustonShot;

public class ShotDao {
    private SQLiteDatabase database;
    private MySQLiteHelper dbHelper;

    public static final String TABLE_ITEM_MEDIA = "tbl_item_media";

    public static final String COLUNA_ID = "_id";
    public static final String COLUNA_TITLE = "title";
    public static final String COLUNA_DESCRIPTION = "description";
    public static final String COLUNA_PUBLISHAT = "coluna_publishat";
    public static final String COLUNA_UPDATEAT = "coluna_updateat";
    public static final String COLUNA_LINK_PAGE = "url_avatar";
    public static final String COLUNA_URL_IMAGE = "url_image";

    public static String[] allColumns = {
            COLUNA_ID,
            COLUNA_TITLE,
            COLUNA_DESCRIPTION,
            COLUNA_PUBLISHAT,
            COLUNA_UPDATEAT,
            COLUNA_LINK_PAGE,
            COLUNA_URL_IMAGE
    };

    public static final String CREATE_TABLE_ITEM_MEDIA = "CREATE TABLE IF NOT EXISTS " + TABLE_ITEM_MEDIA + " ("
            + allColumns[0]  + " INTEGER PRIMARY KEY NOT NULL, "
            + allColumns[1]  + " TEXT DEFAULT '', "
            + allColumns[2]  + " TEXT DEFAULT '', "
            + allColumns[3]  + " TEXT DEFAULT '', "
            + allColumns[4]  + " TEXT DEFAULT '', "
            + allColumns[5]  + " TEXT DEFAULT '', "
            + allColumns[6]  + " TEXT DEFAULT '' ); ";

    public ShotDao(Context context) {
        dbHelper = new MySQLiteHelper(context);
    }

    private void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    private void close() {
        dbHelper.close();
    }

    public void removeAll() {
        open();
        database.execSQL("DELETE FROM " + TABLE_ITEM_MEDIA);
        close();
    }

    public void removeCustonShotById(int id) {
        open();
        database.execSQL("DELETE FROM " + TABLE_ITEM_MEDIA + "WHERE " + COLUNA_ID + " = " + id);
        close();
    }

    public long insertCustonShot(CustonShot custonShot) {
        open();
        ContentValues values = fromObjectToTable(custonShot);
        long i = database.insert(TABLE_ITEM_MEDIA, null, values);
        close();
        return i;
    }

    public long insertListCustonShot(List<CustonShot> lisItemMediaApp) {

        open();

        database.beginTransaction();

        for (CustonShot itemMediaApp : lisItemMediaApp) {

            ContentValues values = fromObjectToTable(itemMediaApp);
//
//            if( getItemMediaAppById(itemMediaApp.getId()) == null){
            database.insert(TABLE_ITEM_MEDIA, null, values);
//            }else{
//                database.update(TABLE_ITEM_MEDIA, values, allColumns[0] + " = ?", new String[]{String.valueOf(itemMediaApp.getId())});
//            }

        }

        database.setTransactionSuccessful();
        database.endTransaction();
        close();

        return 1;

    }

    public int updateCustonShotById(CustonShot itemMediaApp) {
        open();
        ContentValues values = fromObjectToTable(itemMediaApp);
        int i= database.update(TABLE_ITEM_MEDIA, values, allColumns[0] + " = ?", new String[]{String.valueOf(itemMediaApp.getId())});
        close();
        return i;
    }

    public int deleteCustonShotById(CustonShot itemMediaApp) {
        open();
        long id = itemMediaApp.getId();
        int i = database.delete(TABLE_ITEM_MEDIA, COLUNA_ID + " = " + id, null);
        close();
        return i;
    }

    public CustonShot getCustonShotById(int id) throws SQLException {
        open();
        Cursor cursor = database.query(TABLE_ITEM_MEDIA, allColumns, allColumns[0] + " = ?", new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null && cursor.moveToFirst()) {
            cursor.moveToFirst();
            CustonShot itemMediaApp = cursorToItemMediaApp(cursor);
            cursor.close();
            close();
            return itemMediaApp;
        }else{
            return null;
        }

    }

    public List<CustonShot> getAllCustonShot() {
        open();
        List<CustonShot> itemMediaAppList = new ArrayList<CustonShot>();

        Cursor cursor = database.query(TABLE_ITEM_MEDIA, allColumns, null, null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            CustonShot itemMediaApp = cursorToItemMediaApp(cursor);
            itemMediaAppList.add(itemMediaApp);
            cursor.moveToNext();
        }
        cursor.close();
        close();
        return itemMediaAppList;
    }

    public List<CustonShot> getCustonShotBiggerTo(int idCustonShotLasted) {
        open();
        List<CustonShot> itemMediaAppList = new ArrayList<CustonShot>();

        Cursor cursor = database.query(TABLE_ITEM_MEDIA, allColumns, allColumns[0] + " > ?", new String[]{String.valueOf(idCustonShotLasted)}, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            CustonShot itemMediaApp = cursorToItemMediaApp(cursor);
            itemMediaAppList.add(itemMediaApp);
            cursor.moveToNext();
        }
        cursor.close();
        close();
        return itemMediaAppList;
    }

    private CustonShot cursorToItemMediaApp(Cursor cursor) {
        CustonShot itemMediaApp = new CustonShot();
        itemMediaApp.setId(cursor.getInt(0));
        itemMediaApp.setTitle(cursor.getString(1));
        itemMediaApp.setDescription(cursor.getString(2));
        itemMediaApp.setPublishedAt(cursor.getString(3));
        itemMediaApp.setUpdatedAt(cursor.getString(4));
        itemMediaApp.setUrlAvatar(cursor.getString(5));
        itemMediaApp.setUrlImage(cursor.getString(6));

        return itemMediaApp;
    }

    private ContentValues fromObjectToTable(CustonShot itemMediaApp) {
        ContentValues values = new ContentValues();
        values.put(allColumns[0], itemMediaApp.getId() );
        values.put(allColumns[1], itemMediaApp.getTitle());
        values.put(allColumns[2], itemMediaApp.getDescription());
        values.put(allColumns[3], itemMediaApp.getPublishedAt());
        values.put(allColumns[4], itemMediaApp.getUpdatedAt());
        values.put(allColumns[5], itemMediaApp.getUrlAvatar());
        values.put(allColumns[6], itemMediaApp.getUrlImage());

        return values;
    }

}

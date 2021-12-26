package com.example.myfirstapp.Data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.myfirstapp.Items.DaoMaster;

public class GreenDaoManager {
    private final static String databaseName = "test_db";
    private static GreenDaoManager manager;
    private DaoMaster.DevOpenHelper openHelper;
    private Context context;

    private GreenDaoManager(Context context) {
        this.context = context;
        openHelper = new DaoMaster.DevOpenHelper(context, databaseName, null);
    }

    public static GreenDaoManager getInstance(Context context) {
        if (manager == null) {
            synchronized (GreenDaoManager.class) {
                manager = new GreenDaoManager(context);
            }
        }
        return manager;
    }

    public SQLiteDatabase getReadableDatabase() {
        if (openHelper == null) {
            openHelper = new DaoMaster.DevOpenHelper(context, databaseName, null);
        }
        SQLiteDatabase db = openHelper.getReadableDatabase();
        return db;
    }

    public SQLiteDatabase getWritableDatabase() {
        if (openHelper == null) {
            openHelper = new DaoMaster.DevOpenHelper(context, databaseName, null);
        }
        SQLiteDatabase db = openHelper.getWritableDatabase();
        return db;
    }
}

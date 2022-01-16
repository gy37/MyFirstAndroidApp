package com.example.myfirstapp.Data;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.CancellationSignal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class MyProvider extends ContentProvider {
    public static final int TABLE1_DIR = 0;
    public static final int TABLE1_ITEM = 1;
    public static final int TABLE2_DIR = 2;
    public static final int TABLE2_ITEM = 3;
    private static UriMatcher uriMatcher;

    static {
        uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI("com.example.myfirstapp.provider", "table1", TABLE1_DIR);
        uriMatcher.addURI("com.example.myfirstapp.provider", "table1/#", TABLE1_ITEM);
        uriMatcher.addURI("com.example.myfirstapp.provider", "table2", TABLE2_DIR);
        uriMatcher.addURI("com.example.myfirstapp.provider", "table2/#", TABLE2_ITEM);
    }

    //初始化内容提供器，进行数据库创建和升级等操作，返回true成功，false失败
    @Override
    public boolean onCreate() {
        return false;
    }

    //查询数据，uri定位表，projection确定列，selection和selectionArgs查询条件，sortOrder结果排序，返回Cursor对象
    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        switch (uriMatcher.match(uri)) {
            case TABLE1_DIR:
                break;
            case TABLE1_ITEM:
                break;
            case TABLE2_DIR:
                break;
            case TABLE2_ITEM:
                break;
            default:
                break;
        }
        return null;
    }

    //添加数据，values要添加的数据，返回该条记录的uri
    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        return null;
    }

    //更新数据，返回更新的行数
    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }

    //删除数据，返回删除的行数
    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }

    //根据uri返回对应的mime类型
    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        String mime = null;
        switch (uriMatcher.match(uri)) {
            case TABLE1_DIR:
                mime = "vnd.android.cursor.dir/vnd.com.example.myfirstapp.provider.table1";
                break;
            case TABLE1_ITEM:
                mime = "vnd.android.cursor.item/vnd.com.example.myfirstapp.provider.table1";
                break;
            case TABLE2_DIR:
                mime = "vnd.android.cursor.dir/vnd.com.example.myfirstapp.provider.table2";
                break;
            case TABLE2_ITEM:
                mime = "vnd.android.cursor.item/vnd.com.example.myfirstapp.provider.table2";
                break;
            default:
                break;
        }
        return mime;
    }
}

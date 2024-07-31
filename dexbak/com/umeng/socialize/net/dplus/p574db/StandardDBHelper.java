package com.umeng.socialize.net.dplus.p574db;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.umeng.socialize.utils.SLog;
import com.umeng.socialize.utils.UmengText;

/* renamed from: com.umeng.socialize.net.dplus.db.StandardDBHelper */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class StandardDBHelper extends SQLiteOpenHelper {

    /* renamed from: a */
    private static Context f39581a;

    /* renamed from: b */
    private String f39582b;

    public StandardDBHelper(Context context) {
        super(context, DBConfig.DB_NAME, (SQLiteDatabase.CursorFactory) null, 1);
        this.f39582b = null;
    }

    /* renamed from: a */
    private void m13233a(SQLiteDatabase sQLiteDatabase) {
        try {
            this.f39582b = "create table if not exists stats (Id integer primary key,_json TEXT)";
            sQLiteDatabase.execSQL("create table if not exists stats (Id integer primary key,_json TEXT)");
        } catch (SQLException e) {
            SLog.error(UmengText.CACHE.CACHEFILE, e);
        }
    }

    /* renamed from: b */
    private void m13232b(SQLiteDatabase sQLiteDatabase) {
        try {
            this.f39582b = "create table if not exists s_e (Id integer primary key,_json TEXT)";
            sQLiteDatabase.execSQL("create table if not exists s_e (Id integer primary key,_json TEXT)");
        } catch (SQLException e) {
            SLog.error(UmengText.CACHE.CACHEFILE, e);
        }
    }

    /* renamed from: c */
    private void m13231c(SQLiteDatabase sQLiteDatabase) {
        try {
            this.f39582b = "create table if not exists auth (Id integer primary key,_json TEXT)";
            sQLiteDatabase.execSQL("create table if not exists auth (Id integer primary key,_json TEXT)");
        } catch (SQLException e) {
            SLog.error(UmengText.CACHE.CACHEFILE, e);
        }
    }

    /* renamed from: d */
    private void m13230d(SQLiteDatabase sQLiteDatabase) {
        try {
            this.f39582b = "create table if not exists userinfo (Id integer primary key,_json TEXT)";
            sQLiteDatabase.execSQL("create table if not exists userinfo (Id integer primary key,_json TEXT)");
        } catch (SQLException e) {
            SLog.error(UmengText.CACHE.CACHEFILE, e);
        }
    }

    /* renamed from: e */
    private void m13229e(SQLiteDatabase sQLiteDatabase) {
        try {
            this.f39582b = "create table if not exists dau (Id integer primary key,_json TEXT)";
            sQLiteDatabase.execSQL("create table if not exists dau (Id integer primary key,_json TEXT)");
        } catch (SQLException e) {
            SLog.error(UmengText.CACHE.CACHEFILE, e);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        m13233a(sQLiteDatabase);
        m13232b(sQLiteDatabase);
        m13231c(sQLiteDatabase);
        m13230d(sQLiteDatabase);
        m13229e(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }
}

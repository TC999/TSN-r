package com.umeng.socialize.net.dplus.db;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.umeng.socialize.utils.SLog;
import com.umeng.socialize.utils.UmengText;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class StandardDBHelper extends SQLiteOpenHelper {

    /* renamed from: a  reason: collision with root package name */
    private static Context f54155a;

    /* renamed from: b  reason: collision with root package name */
    private String f54156b;

    public StandardDBHelper(Context context) {
        super(context, "share.db", (SQLiteDatabase.CursorFactory) null, 1);
        this.f54156b = null;
    }

    private void a(SQLiteDatabase sQLiteDatabase) {
        try {
            this.f54156b = "create table if not exists stats (Id integer primary key,_json TEXT)";
            sQLiteDatabase.execSQL("create table if not exists stats (Id integer primary key,_json TEXT)");
        } catch (SQLException e4) {
            SLog.error(UmengText.CACHE.CACHEFILE, e4);
        }
    }

    private void b(SQLiteDatabase sQLiteDatabase) {
        try {
            this.f54156b = "create table if not exists s_e (Id integer primary key,_json TEXT)";
            sQLiteDatabase.execSQL("create table if not exists s_e (Id integer primary key,_json TEXT)");
        } catch (SQLException e4) {
            SLog.error(UmengText.CACHE.CACHEFILE, e4);
        }
    }

    private void c(SQLiteDatabase sQLiteDatabase) {
        try {
            this.f54156b = "create table if not exists auth (Id integer primary key,_json TEXT)";
            sQLiteDatabase.execSQL("create table if not exists auth (Id integer primary key,_json TEXT)");
        } catch (SQLException e4) {
            SLog.error(UmengText.CACHE.CACHEFILE, e4);
        }
    }

    private void d(SQLiteDatabase sQLiteDatabase) {
        try {
            this.f54156b = "create table if not exists userinfo (Id integer primary key,_json TEXT)";
            sQLiteDatabase.execSQL("create table if not exists userinfo (Id integer primary key,_json TEXT)");
        } catch (SQLException e4) {
            SLog.error(UmengText.CACHE.CACHEFILE, e4);
        }
    }

    private void e(SQLiteDatabase sQLiteDatabase) {
        try {
            this.f54156b = "create table if not exists dau (Id integer primary key,_json TEXT)";
            sQLiteDatabase.execSQL("create table if not exists dau (Id integer primary key,_json TEXT)");
        } catch (SQLException e4) {
            SLog.error(UmengText.CACHE.CACHEFILE, e4);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        a(sQLiteDatabase);
        b(sQLiteDatabase);
        c(sQLiteDatabase);
        d(sQLiteDatabase);
        e(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i4, int i5) {
    }
}

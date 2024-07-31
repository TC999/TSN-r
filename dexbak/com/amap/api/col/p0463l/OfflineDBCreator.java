package com.amap.api.col.p0463l;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/* renamed from: com.amap.api.col.3l.q0 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class OfflineDBCreator implements DBCreator {

    /* renamed from: a */
    private static volatile OfflineDBCreator f5098a;

    private OfflineDBCreator() {
    }

    /* renamed from: a */
    public static OfflineDBCreator m54155a() {
        if (f5098a == null) {
            synchronized (OfflineDBCreator.class) {
                if (f5098a == null) {
                    f5098a = new OfflineDBCreator();
                }
            }
        }
        return f5098a;
    }

    @Override // com.amap.api.col.p0463l.DBCreator
    /* renamed from: b */
    public final String mo51411b() {
        return "offlineDbV4.db";
    }

    @Override // com.amap.api.col.p0463l.DBCreator
    /* renamed from: c */
    public final int mo51410c() {
        return 2;
    }

    @Override // com.amap.api.col.p0463l.DBCreator
    /* renamed from: a */
    public final void mo51413a(SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase == null) {
            return;
        }
        try {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS update_item (_id integer primary key autoincrement, title  TEXT, url TEXT,mAdcode TEXT,fileName TEXT,version TEXT,lLocalLength INTEGER,lRemoteLength INTEGER,localPath TEXT,mIndex INTEGER,isProvince INTEGER NOT NULL,mCompleteCode INTEGER,mCityCode TEXT,mState INTEGER,mPinyin TEXT, UNIQUE(mAdcode));");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS update_item_file (_id integer primary key autoincrement,mAdcode TTEXT, file TEXT);");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS update_item_download_info (_id integer primary key autoincrement,mAdcode TEXT,fileLength integer,splitter integer,startPos integer,endPos integer, UNIQUE(mAdcode));");
        } catch (Throwable th) {
            SDKLogHandler.m53863p(th, "DB", "onCreate");
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.col.p0463l.DBCreator
    /* renamed from: a */
    public final void mo51412a(SQLiteDatabase sQLiteDatabase, int i) {
        if (sQLiteDatabase != null && i == 1) {
            sQLiteDatabase.execSQL("ALTER TABLE update_item ADD COLUMN mPinyin TEXT;");
            Cursor query = sQLiteDatabase.query("update_item", null, null, null, null, null, null);
            if (query == null) {
                sQLiteDatabase.close();
                sQLiteDatabase = null;
            }
            if (query != null) {
                while (query.moveToNext()) {
                    String string = query.getString(query.getColumnIndex("url"));
                    String substring = string.substring(string.lastIndexOf("/") + 1);
                    sQLiteDatabase.execSQL("update update_item set mPinyin=? where url =?", new String[]{substring.substring(0, substring.lastIndexOf(".")), string});
                }
                query.close();
            }
        }
    }
}

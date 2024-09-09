package com.amap.api.col.p0003l;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: OfflineDBCreator.java */
/* renamed from: com.amap.api.col.3l.q0  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class q0 implements c6 {

    /* renamed from: a  reason: collision with root package name */
    private static volatile q0 f8821a;

    private q0() {
    }

    public static q0 a() {
        if (f8821a == null) {
            synchronized (q0.class) {
                if (f8821a == null) {
                    f8821a = new q0();
                }
            }
        }
        return f8821a;
    }

    @Override // com.amap.api.col.p0003l.c6
    public final String b() {
        return "offlineDbV4.db";
    }

    @Override // com.amap.api.col.p0003l.c6
    public final int c() {
        return 2;
    }

    @Override // com.amap.api.col.p0003l.c6
    public final void a(SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase == null) {
            return;
        }
        try {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS update_item (_id integer primary key autoincrement, title  TEXT, url TEXT,mAdcode TEXT,fileName TEXT,version TEXT,lLocalLength INTEGER,lRemoteLength INTEGER,localPath TEXT,mIndex INTEGER,isProvince INTEGER NOT NULL,mCompleteCode INTEGER,mCityCode TEXT,mState INTEGER,mPinyin TEXT, UNIQUE(mAdcode));");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS update_item_file (_id integer primary key autoincrement,mAdcode TTEXT, file TEXT);");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS update_item_download_info (_id integer primary key autoincrement,mAdcode TEXT,fileLength integer,splitter integer,startPos integer,endPos integer, UNIQUE(mAdcode));");
        } catch (Throwable th) {
            u5.p(th, "DB", "onCreate");
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.col.p0003l.c6
    public final void a(SQLiteDatabase sQLiteDatabase, int i4) {
        if (sQLiteDatabase != null && i4 == 1) {
            sQLiteDatabase.execSQL("ALTER TABLE update_item ADD COLUMN mPinyin TEXT;");
            Cursor query = sQLiteDatabase.query("update_item", null, null, null, null, null, null);
            if (query == null) {
                sQLiteDatabase.close();
                sQLiteDatabase = null;
            }
            if (query != null) {
                while (query.moveToNext()) {
                    String string = query.getString(query.getColumnIndex("url"));
                    String substring = string.substring(string.lastIndexOf(TTPathConst.sSeparator) + 1);
                    sQLiteDatabase.execSQL("update update_item set mPinyin=? where url =?", new String[]{substring.substring(0, substring.lastIndexOf(".")), string});
                }
                query.close();
            }
        }
    }
}

package com.autonavi.aps.amapapi.storage;

import android.database.sqlite.SQLiteDatabase;
import com.amap.api.col.p0003l.c6;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: SdCardDbCreator.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class c implements c6 {
    @Override // com.amap.api.col.p0003l.c6
    public final void a(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS c (_id integer primary key autoincrement, a2 varchar(100), a4 varchar(2000), a3 LONG );");
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "SdCardDbCreator", "onCreate");
        }
    }

    @Override // com.amap.api.col.p0003l.c6
    public final void a(SQLiteDatabase sQLiteDatabase, int i4) {
    }

    @Override // com.amap.api.col.p0003l.c6
    public final String b() {
        return "alsn20170807.db";
    }

    @Override // com.amap.api.col.p0003l.c6
    public final int c() {
        return 1;
    }
}

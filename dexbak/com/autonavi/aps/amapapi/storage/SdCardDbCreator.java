package com.autonavi.aps.amapapi.storage;

import android.database.sqlite.SQLiteDatabase;
import com.amap.api.col.p0463l.DBCreator;
import com.autonavi.aps.amapapi.utils.C2428b;

/* renamed from: com.autonavi.aps.amapapi.storage.c */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class SdCardDbCreator implements DBCreator {
    @Override // com.amap.api.col.p0463l.DBCreator
    /* renamed from: a */
    public final void mo51413a(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS c (_id integer primary key autoincrement, a2 varchar(100), a4 varchar(2000), a3 LONG );");
        } catch (Throwable th) {
            C2428b.m51299a(th, "SdCardDbCreator", "onCreate");
        }
    }

    @Override // com.amap.api.col.p0463l.DBCreator
    /* renamed from: a */
    public final void mo51412a(SQLiteDatabase sQLiteDatabase, int i) {
    }

    @Override // com.amap.api.col.p0463l.DBCreator
    /* renamed from: b */
    public final String mo51411b() {
        return "alsn20170807.db";
    }

    @Override // com.amap.api.col.p0463l.DBCreator
    /* renamed from: c */
    public final int mo51410c() {
        return 1;
    }
}

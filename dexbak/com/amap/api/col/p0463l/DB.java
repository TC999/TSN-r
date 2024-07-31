package com.amap.api.col.p0463l;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/* renamed from: com.amap.api.col.3l.d6 */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class DB extends SQLiteOpenHelper {

    /* renamed from: b */
    private static boolean f3873b = true;

    /* renamed from: c */
    private static boolean f3874c;

    /* renamed from: a */
    private DBCreator f3875a;

    public DB(Context context, String str, int i, DBCreator dBCreator) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, i);
        this.f3875a = dBCreator;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        this.f3875a.mo51413a(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        this.f3875a.mo51412a(sQLiteDatabase, i);
    }
}

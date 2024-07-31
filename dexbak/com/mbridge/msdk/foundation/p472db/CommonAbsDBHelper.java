package com.mbridge.msdk.foundation.p472db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.tools.SameLogTool;

/* renamed from: com.mbridge.msdk.foundation.db.h */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public abstract class CommonAbsDBHelper {

    /* renamed from: a */
    private C11276a f30355a;

    /* compiled from: CommonAbsDBHelper.java */
    /* renamed from: com.mbridge.msdk.foundation.db.h$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    private class C11276a extends SQLiteOpenHelper {
        public C11276a(Context context, String str, int i) {
            super(context, str, (SQLiteDatabase.CursorFactory) null, i);
            if (MBridgeConstans.DEBUG) {
                SameLogTool.m21738a("DatabaseOpenHelper", "数据库： name :" + str + "  " + i);
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onCreate(SQLiteDatabase sQLiteDatabase) {
            if (MBridgeConstans.DEBUG) {
                SameLogTool.m21738a("DatabaseOpenHelper", "数据库创建了");
            }
            CommonAbsDBHelper.this.mo22720a(sQLiteDatabase);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            CommonAbsDBHelper.this.mo22717b(sQLiteDatabase, i, i2);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            if (MBridgeConstans.DEBUG) {
                SameLogTool.m21738a("DatabaseOpenHelper", "数据库升级了");
            }
            CommonAbsDBHelper.this.mo22719a(sQLiteDatabase, i, i2);
        }
    }

    public CommonAbsDBHelper(Context context) {
        this.f30355a = new C11276a(context, mo22716c(), mo22714d());
    }

    /* renamed from: a */
    public final SQLiteDatabase m22723a() {
        return this.f30355a.getReadableDatabase();
    }

    /* renamed from: a */
    protected abstract void mo22720a(SQLiteDatabase sQLiteDatabase);

    /* renamed from: a */
    protected abstract void mo22719a(SQLiteDatabase sQLiteDatabase, int i, int i2);

    /* renamed from: b */
    public final synchronized SQLiteDatabase m22722b() {
        SQLiteDatabase sQLiteDatabase;
        try {
            sQLiteDatabase = this.f30355a.getWritableDatabase();
        } catch (Exception unused) {
            sQLiteDatabase = null;
        }
        return sQLiteDatabase;
    }

    /* renamed from: b */
    protected abstract void mo22717b(SQLiteDatabase sQLiteDatabase, int i, int i2);

    /* renamed from: c */
    protected abstract String mo22716c();

    /* renamed from: d */
    protected abstract int mo22714d();
}

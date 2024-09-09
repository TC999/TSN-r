package com.mbridge.msdk.foundation.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.tools.x;

/* compiled from: CommonAbsDBHelper.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public abstract class h {

    /* renamed from: a  reason: collision with root package name */
    private a f39182a;

    /* compiled from: CommonAbsDBHelper.java */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    private class a extends SQLiteOpenHelper {
        public a(Context context, String str, int i4) {
            super(context, str, (SQLiteDatabase.CursorFactory) null, i4);
            if (MBridgeConstans.DEBUG) {
                x.a("DatabaseOpenHelper", "\u6570\u636e\u5e93\uff1a name :" + str + "  " + i4);
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onCreate(SQLiteDatabase sQLiteDatabase) {
            if (MBridgeConstans.DEBUG) {
                x.a("DatabaseOpenHelper", "\u6570\u636e\u5e93\u521b\u5efa\u4e86");
            }
            h.this.a(sQLiteDatabase);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i4, int i5) {
            h.this.b(sQLiteDatabase, i4, i5);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i4, int i5) {
            if (MBridgeConstans.DEBUG) {
                x.a("DatabaseOpenHelper", "\u6570\u636e\u5e93\u5347\u7ea7\u4e86");
            }
            h.this.a(sQLiteDatabase, i4, i5);
        }
    }

    public h(Context context) {
        this.f39182a = new a(context, c(), d());
    }

    public final SQLiteDatabase a() {
        return this.f39182a.getReadableDatabase();
    }

    protected abstract void a(SQLiteDatabase sQLiteDatabase);

    protected abstract void a(SQLiteDatabase sQLiteDatabase, int i4, int i5);

    public final synchronized SQLiteDatabase b() {
        SQLiteDatabase sQLiteDatabase;
        try {
            sQLiteDatabase = this.f39182a.getWritableDatabase();
        } catch (Exception unused) {
            sQLiteDatabase = null;
        }
        return sQLiteDatabase;
    }

    protected abstract void b(SQLiteDatabase sQLiteDatabase, int i4, int i5);

    protected abstract String c();

    protected abstract int d();
}

package com.amap.api.col.p0003l;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: DB.java */
/* renamed from: com.amap.api.col.3l.e6  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class e6 extends SQLiteOpenHelper {

    /* renamed from: b  reason: collision with root package name */
    private static boolean f7493b = true;

    /* renamed from: c  reason: collision with root package name */
    private static boolean f7494c;

    /* renamed from: a  reason: collision with root package name */
    private c6 f7495a;

    public e6(Context context, String str, int i4, c6 c6Var) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, i4);
        this.f7495a = c6Var;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        this.f7495a.a(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i4, int i5) {
        this.f7495a.a(sQLiteDatabase, i4);
    }
}

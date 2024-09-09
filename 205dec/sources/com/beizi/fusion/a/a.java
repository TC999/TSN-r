package com.beizi.fusion.a;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.beizi.fusion.g.af;
import com.stub.StubApp;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: AdSQLiteOpenHelper.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class a extends SQLiteOpenHelper {

    /* renamed from: a  reason: collision with root package name */
    private static volatile a f14417a;

    private a(Context context) {
        super(context, "beizi_ad.db", (SQLiteDatabase.CursorFactory) null, 2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a a(Context context) {
        if (f14417a == null) {
            synchronized (a.class) {
                if (f14417a == null) {
                    f14417a = new a(StubApp.getOrigApplicationContext(context.getApplicationContext()));
                }
            }
        }
        return f14417a;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i4, int i5) {
        if (i5 > i4) {
            Cursor cursor = null;
            try {
                try {
                    cursor = sQLiteDatabase.query("Sqlite_master", new String[]{"name"}, "type=?", new String[]{"table"}, null, null, null);
                    while (cursor.moveToNext()) {
                        String string = cursor.getString(0);
                        if (string != null && string.startsWith("T_")) {
                            af.c("BeiZis", "before alter table ");
                            sQLiteDatabase.execSQL("alter table " + string + " add column space_id");
                        }
                    }
                } catch (Exception e4) {
                    e4.printStackTrace();
                    if (cursor == null) {
                        return;
                    }
                }
                cursor.close();
            } catch (Throwable th) {
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        }
    }
}

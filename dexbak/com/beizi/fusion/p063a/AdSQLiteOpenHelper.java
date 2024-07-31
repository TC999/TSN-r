package com.beizi.fusion.p063a;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.beizi.fusion.p072g.C3116af;
import com.stub.StubApp;

/* renamed from: com.beizi.fusion.a.a */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class AdSQLiteOpenHelper extends SQLiteOpenHelper {

    /* renamed from: a */
    private static volatile AdSQLiteOpenHelper f10853a;

    private AdSQLiteOpenHelper(Context context) {
        super(context, "beizi_ad.db", (SQLiteDatabase.CursorFactory) null, 2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static AdSQLiteOpenHelper m49000a(Context context) {
        if (f10853a == null) {
            synchronized (AdSQLiteOpenHelper.class) {
                if (f10853a == null) {
                    f10853a = new AdSQLiteOpenHelper(StubApp.getOrigApplicationContext(context.getApplicationContext()));
                }
            }
        }
        return f10853a;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (i2 > i) {
            Cursor cursor = null;
            try {
                try {
                    cursor = sQLiteDatabase.query("Sqlite_master", new String[]{"name"}, "type=?", new String[]{"table"}, null, null, null);
                    while (cursor.moveToNext()) {
                        String string = cursor.getString(0);
                        if (string != null && string.startsWith("T_")) {
                            C3116af.m48494c("BeiZis", "before alter table ");
                            sQLiteDatabase.execSQL("alter table " + string + " add column space_id");
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
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

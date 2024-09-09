package com.bytedance.msdk.f.c;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c extends SQLiteOpenHelper {

    /* renamed from: c  reason: collision with root package name */
    public static String f28307c = c.class.getSimpleName();

    public c(@Nullable Context context) {
        super(new com.bytedance.sdk.openadsdk.api.plugin.c(context), "mediation_behavior.db", (SQLiteDatabase.CursorFactory) null, 1);
    }

    private void c(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS gromore_prime_rit_adn_perform (id INTEGER PRIMARY KEY AUTOINCREMENT, adn_name TEXT NOT NULL , prime_rit TEXT NOT NULL , adn_rit TEXT NOT NULL ,ad_action TEXT NOT NULL ,time_stamp LONG DEFAULT 0)");
    }

    private void w(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS gromore_prime_rit_adn_perform ;");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            c(sQLiteDatabase);
        } catch (Throwable unused) {
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i4, int i5) {
        try {
            String str = f28307c;
            com.bytedance.msdk.adapter.sr.xv.c(str, "onUpgrade....Database version upgrade.....old:" + i4 + ",new:" + i5);
            if (i4 > i5) {
                w(sQLiteDatabase);
                c(sQLiteDatabase);
                com.bytedance.msdk.adapter.sr.xv.c(f28307c, "onUpgrade...Reverse installation Database reset - create table.....");
            } else {
                c(sQLiteDatabase);
            }
        } catch (Throwable unused) {
        }
    }

    public void c(ContentValues contentValues) {
        if (contentValues != null) {
            String asString = contentValues.getAsString("adn_name");
            String asString2 = contentValues.getAsString("prime_rit");
            String asString3 = contentValues.getAsString("adn_rit");
            String asString4 = contentValues.getAsString("ad_action");
            long longValue = contentValues.getAsLong("time_stamp").longValue();
            SQLiteDatabase writableDatabase = getWritableDatabase();
            ContentValues contentValues2 = new ContentValues();
            contentValues2.put("adn_name", asString);
            contentValues2.put("prime_rit", asString2);
            contentValues2.put("adn_rit", asString3);
            contentValues2.put("ad_action", asString4);
            contentValues2.put("time_stamp", Long.valueOf(longValue));
            writableDatabase.insert("gromore_prime_rit_adn_perform", null, contentValues2);
            writableDatabase.close();
        }
    }

    public void w(String str, String[] strArr) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        writableDatabase.delete("gromore_prime_rit_adn_perform", str, strArr);
        writableDatabase.close();
    }

    public Cursor c(String str, String[] strArr) {
        return getReadableDatabase().query("gromore_prime_rit_adn_perform", null, str, strArr, null, null, null);
    }
}

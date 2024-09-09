package com.bytedance.msdk.xv.c;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class gd extends SQLiteOpenHelper {

    /* renamed from: c  reason: collision with root package name */
    private final Context f28480c;

    public gd(Context context, String str, int i4) {
        super(new com.bytedance.sdk.openadsdk.api.plugin.c(context), str, (SQLiteDatabase.CursorFactory) null, i4);
        this.f28480c = context;
        com.bytedance.msdk.adapter.sr.xv.c("DBHelper", "DatabaseHelper ........");
    }

    private void c(SQLiteDatabase sQLiteDatabase) {
        com.bytedance.msdk.adapter.sr.xv.c("DBHelper", "initDB........");
        try {
            sQLiteDatabase.execSQL(c.c());
        } catch (Throwable th) {
            th.printStackTrace();
        }
        try {
            sQLiteDatabase.execSQL(c.w());
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
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
            com.bytedance.msdk.adapter.sr.xv.c("DBHelper", "onUpgrade....\u6570\u636e\u5e93\u7248\u672c\u5347\u7ea7.....");
            if (i4 == 1 || i4 == 2) {
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS 'ad_video_info';");
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS 'show_freqctl';");
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS 'show_pacing';");
            } else if (i4 != 3) {
                return;
            }
            sQLiteDatabase.execSQL(c.w());
            c(sQLiteDatabase, i4, i5);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void c(SQLiteDatabase sQLiteDatabase, int i4, int i5) {
        try {
            sQLiteDatabase.execSQL(c.xv());
        } catch (Throwable th) {
            th.printStackTrace();
        }
        try {
            sQLiteDatabase.execSQL(c.sr());
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }
}

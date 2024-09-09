package com.bytedance.sdk.component.r.w.c.c.c;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import com.bytedance.sdk.component.r.c.f;
import com.bytedance.sdk.component.r.w.c.c.w.r;
import com.bytedance.sdk.component.r.w.c.c.w.sr;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c extends SQLiteOpenHelper {

    /* renamed from: c  reason: collision with root package name */
    final Context f30052c;

    /* renamed from: w  reason: collision with root package name */
    private f f30053w;

    public c(Context context, f fVar) {
        super(new com.bytedance.sdk.openadsdk.api.plugin.c(context), "ttadlog.db", (SQLiteDatabase.CursorFactory) null, 1);
        this.f30052c = context;
        this.f30053w = fVar;
    }

    private void c(SQLiteDatabase sQLiteDatabase) {
        Log.d("log_default", "initDB........");
        sQLiteDatabase.execSQL(com.bytedance.sdk.component.r.w.c.c.w.f.sr(this.f30053w.w()));
        sQLiteDatabase.execSQL(sr.w(this.f30053w.c()));
        sQLiteDatabase.execSQL(r.sr(this.f30053w.sr()));
        sQLiteDatabase.execSQL(com.bytedance.sdk.component.r.w.c.c.w.c.w(this.f30053w.ux()));
        sQLiteDatabase.execSQL(com.bytedance.sdk.component.r.w.f.f.w());
    }

    private void w(SQLiteDatabase sQLiteDatabase) {
        ArrayList<String> xv = xv(sQLiteDatabase);
        if (xv == null || xv.size() <= 0) {
            return;
        }
        Iterator<String> it = xv.iterator();
        while (it.hasNext()) {
            sQLiteDatabase.execSQL(String.format("DROP TABLE IF EXISTS %s ;", it.next()));
        }
    }

    private ArrayList<String> xv(SQLiteDatabase sQLiteDatabase) {
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            Cursor rawQuery = sQLiteDatabase.rawQuery("select name from sqlite_master where type='table' order by name", null);
            if (rawQuery != null) {
                while (rawQuery.moveToNext()) {
                    String string = rawQuery.getString(0);
                    if (!string.equals("android_metadata") && !string.equals("sqlite_sequence")) {
                        arrayList.add(string);
                    }
                }
                rawQuery.close();
            }
        } catch (Exception unused) {
        }
        return arrayList;
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
            Log.d("log_default", "onUpgrade....Database version upgrade.....old:" + i4 + ",new:" + i5);
            if (i4 > i5) {
                w(sQLiteDatabase);
                c(sQLiteDatabase);
                Log.d("log_default", "onUpgrade...Reverse installation Database reset - create table.....");
            } else {
                c(sQLiteDatabase);
            }
        } catch (Throwable unused) {
        }
    }
}

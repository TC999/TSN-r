package com.qq.e.comm.plugin.apkmanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import com.qq.e.comm.plugin.util.d1;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class s extends SQLiteOpenHelper {

    /* renamed from: d  reason: collision with root package name */
    private static volatile s f41887d;

    /* renamed from: e  reason: collision with root package name */
    private static SQLiteDatabase f41888e;

    /* renamed from: c  reason: collision with root package name */
    private AtomicInteger f41889c;

    private s(Context context) {
        super(new com.qq.e.comm.plugin.l.a(context), "GDTSDK.db", (SQLiteDatabase.CursorFactory) null, 10);
        this.f41889c = new AtomicInteger();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static s a(Context context) {
        if (f41887d == null) {
            synchronized (s.class) {
                if (f41887d == null) {
                    f41887d = new s(context);
                }
            }
        }
        return f41887d;
    }

    public int b(ApkDownloadTask apkDownloadTask) {
        SQLiteDatabase sQLiteDatabase;
        int i4 = 0;
        try {
            sQLiteDatabase = getWritableDatabase();
            try {
                i4 = sQLiteDatabase.delete("tasks", "id=?", new String[]{String.valueOf(apkDownloadTask.t())});
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            sQLiteDatabase = null;
        }
        a(sQLiteDatabase, (Cursor) null);
        return i4;
    }

    public int c(ApkDownloadTask apkDownloadTask) {
        SQLiteDatabase sQLiteDatabase;
        int t3 = apkDownloadTask.t();
        int i4 = 0;
        if (t3 > 0) {
            try {
                sQLiteDatabase = getWritableDatabase();
            } catch (Throwable th) {
                th = th;
                sQLiteDatabase = null;
            }
            try {
                i4 = sQLiteDatabase.update("tasks", a(apkDownloadTask, false), "id=" + t3, null);
            } catch (Throwable th2) {
                th = th2;
                try {
                    d1.a("Update Task Error", th);
                    return i4;
                } finally {
                    a(sQLiteDatabase, (Cursor) null);
                }
            }
            return i4;
        } else if (apkDownloadTask.o() == 1) {
            return a(apkDownloadTask);
        } else {
            return 0;
        }
    }

    public List<ApkDownloadTask> d() {
        return b(new String("(4)"));
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public synchronized SQLiteDatabase getReadableDatabase() {
        if (this.f41889c.incrementAndGet() == 1) {
            f41888e = super.getReadableDatabase();
        }
        return f41888e;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public synchronized SQLiteDatabase getWritableDatabase() {
        if (this.f41889c.incrementAndGet() == 1) {
            f41888e = super.getWritableDatabase();
        }
        return f41888e;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("create table tasks(id integer primary key autoincrement,ad_id text not null,ad_type integer,pos_id text not null,trace_id text,target_id text not null,click_id text not null,url text not null unique,name text not null,pkg text not null,tracer text,icon text not null,create_time integer not null,is_returned integer,title text,description text,network integer not null,status integer not null,fail_reason text,launch_param text,delay_download integer not null,manual_paused integer not null,progress integer not null,total_size integer not null)");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i4, int i5) {
        if (i5 == 10) {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS tasks");
            onCreate(sQLiteDatabase);
        }
    }

    private ApkDownloadTask b(Cursor cursor) {
        if (cursor.moveToNext()) {
            String string = cursor.getString(cursor.getColumnIndex("target_id"));
            String string2 = cursor.getString(cursor.getColumnIndex("click_id"));
            String string3 = cursor.getString(cursor.getColumnIndex(RewardPlus.ICON));
            String string4 = cursor.getString(cursor.getColumnIndex("url"));
            String string5 = cursor.getString(cursor.getColumnIndex("name"));
            String string6 = cursor.getString(cursor.getColumnIndex("pkg"));
            long j4 = cursor.getLong(cursor.getColumnIndex("create_time"));
            int i4 = cursor.getInt(cursor.getColumnIndex("is_returned"));
            ApkDownloadTask apkDownloadTask = new ApkDownloadTask(cursor.getString(cursor.getColumnIndex("ad_id")), cursor.getInt(cursor.getColumnIndex("ad_type")), cursor.getString(cursor.getColumnIndex("pos_id")), cursor.getString(cursor.getColumnIndex("trace_id")), string, string2, string3, string4, string5, string6, new Bundle(), com.qq.e.comm.plugin.d0.a.d().c().n().a(), j4, cursor.getInt(cursor.getColumnIndex("status")), cursor.getString(cursor.getColumnIndex("title")), cursor.getString(cursor.getColumnIndex("description")));
            apkDownloadTask.e(cursor.getString(cursor.getColumnIndex("tracer")));
            apkDownloadTask.d(cursor.getInt(cursor.getColumnIndex("id")));
            apkDownloadTask.f(cursor.getString(cursor.getColumnIndex("fail_reason")));
            apkDownloadTask.a("totalSize", cursor.getLong(cursor.getColumnIndex("total_size")));
            apkDownloadTask.a("progress", cursor.getInt(cursor.getColumnIndex("progress")));
            apkDownloadTask.a(i4 != 0);
            String string7 = cursor.getString(cursor.getColumnIndex("launch_param"));
            try {
                JSONObject jSONObject = TextUtils.isEmpty(string7) ? null : new JSONObject(string7);
                if (jSONObject != null) {
                    apkDownloadTask.a(jSONObject);
                    apkDownloadTask.a("autoInstall", jSONObject.optBoolean("autoInstall", true));
                }
            } catch (JSONException e4) {
                d1.a("Parse Task LaunchParam Error", e4);
            }
            return apkDownloadTask;
        }
        return null;
    }

    public int a(ApkDownloadTask apkDownloadTask) {
        SQLiteDatabase sQLiteDatabase;
        long j4 = -1;
        try {
            sQLiteDatabase = getWritableDatabase();
            try {
                j4 = sQLiteDatabase.insert("tasks", null, a(apkDownloadTask, true));
                if (j4 > 0) {
                    apkDownloadTask.d((int) j4);
                }
                d1.a("TEST_DB:new taskID=" + j4, new Object[0]);
            } catch (Throwable unused) {
                try {
                    d1.a("Add New Task Error");
                    a(sQLiteDatabase, (Cursor) null);
                    return (int) j4;
                } catch (Throwable th) {
                    a(sQLiteDatabase, (Cursor) null);
                    throw th;
                }
            }
        } catch (Throwable unused2) {
            sQLiteDatabase = null;
        }
        a(sQLiteDatabase, (Cursor) null);
        return (int) j4;
    }

    public ApkDownloadTask c(int i4) {
        return a("id", i4 + "");
    }

    public List<ApkDownloadTask> c() {
        return b(new String("(4,32,16)"));
    }

    private ContentValues a(ApkDownloadTask apkDownloadTask, boolean z3) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("target_id", apkDownloadTask.q());
        contentValues.put("click_id", apkDownloadTask.c());
        contentValues.put("url", apkDownloadTask.s());
        contentValues.put("name", apkDownloadTask.p());
        contentValues.put("pkg", apkDownloadTask.r());
        contentValues.put(RewardPlus.ICON, apkDownloadTask.k());
        contentValues.put("create_time", Long.valueOf(apkDownloadTask.e()));
        contentValues.put("is_returned", Boolean.valueOf(apkDownloadTask.y()));
        contentValues.put("title", apkDownloadTask.u());
        contentValues.put("description", apkDownloadTask.g());
        contentValues.put("network", Integer.valueOf(apkDownloadTask.d()));
        contentValues.put("status", Integer.valueOf(apkDownloadTask.o()));
        contentValues.put("fail_reason", apkDownloadTask.d("failReason"));
        String d4 = apkDownloadTask.d("launchParam");
        if (d4 == null) {
            d4 = "";
        }
        contentValues.put("launch_param", d4);
        contentValues.put("ad_id", apkDownloadTask.a());
        contentValues.put("ad_type", Integer.valueOf(apkDownloadTask.b()));
        contentValues.put("pos_id", apkDownloadTask.m());
        contentValues.put("trace_id", apkDownloadTask.w());
        contentValues.put("delay_download", (Integer) 0);
        contentValues.put("manual_paused", Integer.valueOf(apkDownloadTask.b("manualPause")));
        long c4 = apkDownloadTask.c("totalSize");
        if (z3 || c4 > 0) {
            contentValues.put("total_size", Long.valueOf(c4));
        }
        if (!TextUtils.isEmpty(apkDownloadTask.h())) {
            contentValues.put("tracer", apkDownloadTask.h());
        }
        contentValues.put("progress", Integer.valueOf(apkDownloadTask.b("progress")));
        return contentValues;
    }

    public ApkDownloadTask b(int i4) {
        return a(i4, new String("(32,16)"));
    }

    public List<ApkDownloadTask> b() {
        return b("(8)");
    }

    private List<ApkDownloadTask> b(String str) {
        Cursor cursor;
        SQLiteDatabase readableDatabase;
        ArrayList arrayList = new ArrayList();
        SQLiteDatabase sQLiteDatabase = null;
        Cursor cursor2 = null;
        try {
            readableDatabase = getReadableDatabase();
        } catch (Throwable th) {
            th = th;
            cursor = null;
        }
        try {
            cursor2 = readableDatabase.rawQuery("select * from tasks where status in " + str, null);
            while (a(cursor2)) {
                arrayList.add(b(cursor2));
            }
            a(readableDatabase, cursor2);
        } catch (Throwable th2) {
            th = th2;
            cursor = cursor2;
            sQLiteDatabase = readableDatabase;
            try {
                d1.a("Get getTasksByStatus Error", th);
                return arrayList;
            } finally {
                a(sQLiteDatabase, cursor);
            }
        }
        return arrayList;
    }

    public int a(String str, int i4) {
        SQLiteDatabase sQLiteDatabase;
        int i5;
        try {
            sQLiteDatabase = getWritableDatabase();
        } catch (Throwable th) {
            th = th;
            sQLiteDatabase = null;
        }
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("status", Integer.valueOf(i4));
            i5 = sQLiteDatabase.update("tasks", contentValues, "pkg = '" + str + "'", null);
        } catch (Throwable th2) {
            th = th2;
            try {
                d1.a("Update Task Error", th);
                i5 = 0;
                return i5;
            } finally {
                a(sQLiteDatabase, (Cursor) null);
            }
        }
        return i5;
    }

    private boolean a(Cursor cursor) {
        return cursor.getCount() > 0 && !cursor.isLast();
    }

    public ApkDownloadTask a(int i4) {
        return a(i4, new String("(4)"));
    }

    public List<ApkDownloadTask> a() {
        return b("(8,1)");
    }

    private ApkDownloadTask a(int i4, String str) {
        Cursor cursor;
        SQLiteDatabase sQLiteDatabase;
        try {
            sQLiteDatabase = getReadableDatabase();
            try {
                cursor = sQLiteDatabase.rawQuery("select * from tasks where id = '" + i4 + "' and status in " + str, null);
                try {
                    if (a(cursor)) {
                        return b(cursor);
                    }
                    return null;
                } catch (Throwable th) {
                    th = th;
                    try {
                        d1.a("Get getTaskByTargetUrlAStatus Error", th);
                        return null;
                    } finally {
                        a(sQLiteDatabase, cursor);
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                cursor = null;
            }
        } catch (Throwable th3) {
            th = th3;
            cursor = null;
            sQLiteDatabase = null;
        }
    }

    public ApkDownloadTask a(String str) {
        return a("pkg", str);
    }

    private ApkDownloadTask a(String str, String str2) {
        Cursor cursor;
        SQLiteDatabase sQLiteDatabase;
        try {
            sQLiteDatabase = getReadableDatabase();
            try {
                cursor = sQLiteDatabase.rawQuery("select * from tasks where " + str + " = '" + str2 + "'", null);
            } catch (Throwable th) {
                th = th;
                cursor = null;
            }
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
            sQLiteDatabase = null;
        }
        try {
            if (a(cursor)) {
                return b(cursor);
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            try {
                d1.a("Get TaskByColumn " + str + " Error", th);
                return null;
            } finally {
                a(sQLiteDatabase, cursor);
            }
        }
    }

    private synchronized void a(SQLiteDatabase sQLiteDatabase, Cursor cursor) {
        if (cursor != null) {
            try {
                cursor.close();
            } catch (Throwable th) {
                throw th;
            }
        }
        if (sQLiteDatabase != null && this.f41889c.decrementAndGet() == 0) {
            sQLiteDatabase.close();
        }
    }
}

package com.mbridge.msdk.mbdownload;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.mbridge.msdk.foundation.tools.x;
import java.text.SimpleDateFormat;
import java.util.Date;

/* compiled from: DownloadTaskList.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private static final String f40084a = "com.mbridge.msdk.mbdownload.d";

    /* renamed from: b  reason: collision with root package name */
    private static Context f40085b;

    /* renamed from: c  reason: collision with root package name */
    private a f40086c;

    /* compiled from: DownloadTaskList.java */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    class a extends SQLiteOpenHelper {
        a(Context context) {
            super(context, "MB_DATA", (SQLiteDatabase.CursorFactory) null, 2);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onCreate(SQLiteDatabase sQLiteDatabase) {
            x.a(d.f40084a, "CREATE TABLE mb_download_task_list (cp TEXT, url TEXT, progress INTEGER, extra TEXT, last_modified TEXT, UNIQUE (cp,url) ON CONFLICT ABORT);");
            sQLiteDatabase.execSQL("CREATE TABLE mb_download_task_list (cp TEXT, url TEXT, progress INTEGER, extra TEXT, last_modified TEXT, UNIQUE (cp,url) ON CONFLICT ABORT);");
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i4, int i5) {
        }
    }

    /* compiled from: DownloadTaskList.java */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    private static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final d f40088a = new d();
    }

    public void finalize() {
        this.f40086c.close();
    }

    private d() {
        this.f40086c = new a(f40085b);
    }

    public static d a(Context context) {
        Context context2 = f40085b;
        if (context2 == null) {
            context.getClass();
        }
        if (context2 == null) {
            f40085b = context;
        }
        return b.f40088a;
    }

    public final void a(String str, String str2, int i4) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("progress", Integer.valueOf(i4));
        contentValues.put("last_modified", e.a());
        this.f40086c.getWritableDatabase().update("mb_download_task_list", contentValues, "cp=? and url=?", new String[]{str, str2});
    }

    public final void a(int i4) {
        try {
            Date date = new Date(new Date().getTime() - (i4 * 1000));
            String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
            this.f40086c.getWritableDatabase().execSQL(" DELETE FROM mb_download_task_list WHERE strftime('yyyy-MM-dd HH:mm:ss', last_modified)<=strftime('yyyy-MM-dd HH:mm:ss', '" + format + "')");
            String str = f40084a;
            x.a(str, "clearOverdueTasks(" + i4 + ") remove all tasks before " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date));
        } catch (Exception e4) {
            x.d(f40084a, e4.getMessage());
        }
    }
}

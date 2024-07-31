package com.mbridge.msdk.mbdownload;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.core.app.NotificationCompat;
import com.mbridge.msdk.foundation.tools.SameLogTool;
import java.text.SimpleDateFormat;
import java.util.Date;

/* renamed from: com.mbridge.msdk.mbdownload.d */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class DownloadTaskList {

    /* renamed from: a */
    private static final String f31312a = "com.mbridge.msdk.mbdownload.d";

    /* renamed from: b */
    private static Context f31313b;

    /* renamed from: c */
    private C11465a f31314c;

    /* compiled from: DownloadTaskList.java */
    /* renamed from: com.mbridge.msdk.mbdownload.d$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    class C11465a extends SQLiteOpenHelper {
        C11465a(Context context) {
            super(context, "MB_DATA", (SQLiteDatabase.CursorFactory) null, 2);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onCreate(SQLiteDatabase sQLiteDatabase) {
            SameLogTool.m21738a(DownloadTaskList.f31312a, "CREATE TABLE mb_download_task_list (cp TEXT, url TEXT, progress INTEGER, extra TEXT, last_modified TEXT, UNIQUE (cp,url) ON CONFLICT ABORT);");
            sQLiteDatabase.execSQL("CREATE TABLE mb_download_task_list (cp TEXT, url TEXT, progress INTEGER, extra TEXT, last_modified TEXT, UNIQUE (cp,url) ON CONFLICT ABORT);");
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        }
    }

    /* compiled from: DownloadTaskList.java */
    /* renamed from: com.mbridge.msdk.mbdownload.d$b */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    private static class C11466b {

        /* renamed from: a */
        public static final DownloadTaskList f31316a = new DownloadTaskList();
    }

    public void finalize() {
        this.f31314c.close();
    }

    private DownloadTaskList() {
        this.f31314c = new C11465a(f31313b);
    }

    /* renamed from: a */
    public static DownloadTaskList m21637a(Context context) {
        Context context2 = f31313b;
        if (context2 == null) {
            context.getClass();
        }
        if (context2 == null) {
            f31313b = context;
        }
        return C11466b.f31316a;
    }

    /* renamed from: a */
    public final void m21636a(String str, String str2, int i) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(NotificationCompat.CATEGORY_PROGRESS, Integer.valueOf(i));
        contentValues.put("last_modified", DownloadTool.m21635a());
        this.f31314c.getWritableDatabase().update("mb_download_task_list", contentValues, "cp=? and url=?", new String[]{str, str2});
    }

    /* renamed from: a */
    public final void m21638a(int i) {
        try {
            Date date = new Date(new Date().getTime() - (i * 1000));
            String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
            this.f31314c.getWritableDatabase().execSQL(" DELETE FROM mb_download_task_list WHERE strftime('yyyy-MM-dd HH:mm:ss', last_modified)<=strftime('yyyy-MM-dd HH:mm:ss', '" + format + "')");
            String str = f31312a;
            SameLogTool.m21738a(str, "clearOverdueTasks(" + i + ") remove all tasks before " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date));
        } catch (Exception e) {
            SameLogTool.m21733d(f31312a, e.getMessage());
        }
    }
}

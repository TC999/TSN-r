package com.bytedance.sdk.openadsdk.core;

import android.content.ContentValues;
import android.content.Context;
import android.database.AbstractCursor;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class gd {
    private static final Object xv = new Object();

    /* renamed from: c  reason: collision with root package name */
    private xv f33712c;

    /* renamed from: w  reason: collision with root package name */
    private Context f33713w;

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    private class w extends AbstractCursor {
        private w() {
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public String[] getColumnNames() {
            return new String[0];
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public int getCount() {
            return 0;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public double getDouble(int i4) {
            return 0.0d;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public float getFloat(int i4) {
            return 0.0f;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public int getInt(int i4) {
            return 0;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public long getLong(int i4) {
            return 0L;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public short getShort(int i4) {
            return (short) 0;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public String getString(int i4) {
            return null;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public boolean isNull(int i4) {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public gd(Context context) {
        try {
            this.f33713w = context == null ? ls.getContext() : StubApp.getOrigApplicationContext(context.getApplicationContext());
            if (this.f33712c == null) {
                this.f33712c = new xv();
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Context getContext() {
        Context context = this.f33713w;
        return context == null ? ls.getContext() : context;
    }

    public xv c() {
        return this.f33712c;
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public class xv {

        /* renamed from: w  reason: collision with root package name */
        private SQLiteDatabase f33724w = null;

        public xv() {
        }

        private boolean f() {
            SQLiteDatabase sQLiteDatabase = this.f33724w;
            return sQLiteDatabase != null && sQLiteDatabase.inTransaction();
        }

        public void c() {
            boolean f4;
            try {
                SQLiteDatabase sQLiteDatabase = this.f33724w;
                if (sQLiteDatabase == null || !sQLiteDatabase.isOpen()) {
                    synchronized (gd.xv) {
                        SQLiteDatabase sQLiteDatabase2 = this.f33724w;
                        if (sQLiteDatabase2 == null || !sQLiteDatabase2.isOpen()) {
                            gd gdVar = gd.this;
                            this.f33724w = new c(gdVar.getContext()).getWritableDatabase();
                        }
                    }
                }
            } finally {
                if (!f4) {
                }
            }
        }

        public int delete(String str, String str2, String[] strArr) {
            try {
                c();
                return this.f33724w.delete(str, str2, strArr);
            } catch (Exception e4) {
                e4.printStackTrace();
                if (f()) {
                    throw e4;
                }
                return 0;
            }
        }

        public long insert(String str, String str2, ContentValues contentValues) {
            try {
                c();
                return this.f33724w.insert(str, str2, contentValues);
            } catch (Exception e4) {
                e4.printStackTrace();
                if (f()) {
                    throw e4;
                }
                return -1L;
            }
        }

        public Cursor query(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5) {
            try {
                c();
                return this.f33724w.query(str, strArr, str2, strArr2, str3, str4, str5);
            } catch (Throwable th) {
                w wVar = new w();
                if (f()) {
                    throw th;
                }
                return wVar;
            }
        }

        public void sr() {
            c();
            SQLiteDatabase sQLiteDatabase = this.f33724w;
            if (sQLiteDatabase == null) {
                return;
            }
            sQLiteDatabase.setTransactionSuccessful();
        }

        public int update(String str, ContentValues contentValues, String str2, String[] strArr) {
            try {
                c();
                return this.f33724w.update(str, contentValues, str2, strArr);
            } catch (Exception e4) {
                e4.printStackTrace();
                if (f()) {
                    throw e4;
                }
                return 0;
            }
        }

        public void ux() {
            c();
            SQLiteDatabase sQLiteDatabase = this.f33724w;
            if (sQLiteDatabase == null) {
                return;
            }
            sQLiteDatabase.endTransaction();
        }

        public SQLiteDatabase w() {
            return this.f33724w;
        }

        public void xv() {
            c();
            SQLiteDatabase sQLiteDatabase = this.f33724w;
            if (sQLiteDatabase == null) {
                return;
            }
            sQLiteDatabase.beginTransaction();
        }

        public void c(String str) throws SQLException {
            boolean f4;
            try {
                c();
                this.f33724w.execSQL(str);
            } finally {
                if (!f4) {
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public class c extends SQLiteOpenHelper {

        /* renamed from: c  reason: collision with root package name */
        final Context f33714c;

        public c(Context context) {
            super(new com.bytedance.sdk.openadsdk.api.plugin.c(context), "ttopensdk.db", (SQLiteDatabase.CursorFactory) null, 10);
            this.f33714c = context;
        }

        private void c(SQLiteDatabase sQLiteDatabase, Context context) {
            com.bytedance.sdk.component.utils.a.w("DBHelper", "initDB:" + com.bytedance.sdk.openadsdk.core.fz.w.xv.get());
            sQLiteDatabase.execSQL(com.bytedance.sdk.component.r.w.c.c.w.f.sr("adevent"));
            sQLiteDatabase.execSQL(com.bytedance.sdk.component.r.w.c.c.w.sr.w("loghighpriority"));
            sQLiteDatabase.execSQL(com.bytedance.sdk.component.r.w.c.c.w.r.sr("logstats"));
            sQLiteDatabase.execSQL(com.bytedance.sdk.component.r.w.c.c.w.c.w("logstatsbatch"));
            sQLiteDatabase.execSQL(com.bytedance.sdk.component.r.w.f.f.w());
            sQLiteDatabase.execSQL(com.bytedance.sdk.component.adexpress.c.w.w.xv());
            sQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.tools.w.xv());
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS setting_base_info (_id INTEGER PRIMARY KEY,value TEXT)");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS setting_global_info (_id INTEGER PRIMARY KEY,value TEXT)");
            com.bytedance.sdk.component.utils.a.w("DBHelper", "initDB  END");
        }

        private ArrayList<String> w(SQLiteDatabase sQLiteDatabase) {
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
                c(sQLiteDatabase, this.f33714c);
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.a.f("DBHelper", th.getMessage());
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i4, int i5) {
            com.bytedance.sdk.component.utils.a.w("DBHelper", "onDowngrade....\u6570\u636e\u5e93\u7248\u672c\u964d\u7ea7.....old:" + i4 + ",new:" + i5);
            if (i4 > i5) {
                c(sQLiteDatabase);
                c(sQLiteDatabase, gd.this.f33713w);
                com.bytedance.sdk.component.utils.a.w("DBHelper", "onDowngrade...\u9006\u5411\u5b89\u88c5.\u6570\u636e\u5e93\u91cd\u7f6e-\u521b\u5efa\u8868.....");
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i4, int i5) {
            try {
                com.bytedance.sdk.component.utils.a.w("DBHelper", "onUpgrade....\u6570\u636e\u5e93\u7248\u672c\u5347\u7ea7.....old:" + i4 + ",new:" + i5);
                if (i4 <= i5) {
                    c(sQLiteDatabase, gd.this.f33713w);
                } else {
                    c(sQLiteDatabase);
                    c(sQLiteDatabase, gd.this.f33713w);
                    com.bytedance.sdk.component.utils.a.w("DBHelper", "onUpgrade...\u9006\u5411\u5b89\u88c5.\u6570\u636e\u5e93\u91cd\u7f6e-\u521b\u5efa\u8868.....");
                }
                switch (i4) {
                    case 1:
                        c(sQLiteDatabase, i4, i5);
                        com.bytedance.sdk.component.utils.a.w("DBHelper", "onUpgrade.....\u6267\u884c\u8868\u521b\u5efa.....");
                        break;
                    case 2:
                        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS 'ad_video_info';");
                        c(sQLiteDatabase, i4, i5);
                        break;
                    case 3:
                        sQLiteDatabase.execSQL(com.bytedance.sdk.component.r.w.c.c.w.r.sr("logstats"));
                        c(sQLiteDatabase, i4, i5);
                        break;
                    case 4:
                        sQLiteDatabase.execSQL(com.bytedance.sdk.component.adexpress.c.w.w.xv());
                        c(sQLiteDatabase, i4, i5);
                        break;
                    case 5:
                        sQLiteDatabase.execSQL(com.bytedance.sdk.component.r.w.c.c.w.c.w("logstatsbatch"));
                        c(sQLiteDatabase, i4, i5);
                        break;
                    case 6:
                    case 8:
                    case 9:
                        c(sQLiteDatabase, i4, i5);
                        break;
                    case 7:
                        sQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.tools.w.xv());
                        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS setting_base_info (_id INTEGER PRIMARY KEY,value TEXT)");
                        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS setting_global_info (_id INTEGER PRIMARY KEY,value TEXT)");
                        c(sQLiteDatabase, i4, i5);
                        break;
                }
                com.bytedance.sdk.component.utils.a.w("DBHelper", "over");
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.a.f("DBHelper", th.getMessage());
            }
        }

        private void c(SQLiteDatabase sQLiteDatabase, int i4, int i5) {
            sQLiteDatabase.execSQL(com.bytedance.sdk.component.r.w.c.c.w.f.ux("adevent"));
            sQLiteDatabase.execSQL(com.bytedance.sdk.component.r.w.c.c.w.sr.xv("loghighpriority"));
            sQLiteDatabase.execSQL(com.bytedance.sdk.component.r.w.c.c.w.r.ux("logstats"));
            sQLiteDatabase.execSQL(com.bytedance.sdk.component.r.w.c.c.w.c.xv("logstatsbatch"));
        }

        private void c(SQLiteDatabase sQLiteDatabase) {
            ArrayList<String> w3 = w(sQLiteDatabase);
            if (w3 == null || w3.size() <= 0) {
                return;
            }
            Iterator<String> it = w3.iterator();
            while (it.hasNext()) {
                sQLiteDatabase.execSQL(String.format("DROP TABLE IF EXISTS %s ;", it.next()));
            }
        }
    }
}

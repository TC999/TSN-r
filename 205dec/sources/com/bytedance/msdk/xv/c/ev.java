package com.bytedance.msdk.xv.c;

import android.content.ContentValues;
import android.content.Context;
import android.database.AbstractCursor;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import com.stub.StubApp;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ev {
    private static final Object xv = new Object();

    /* renamed from: c  reason: collision with root package name */
    private w f28475c;

    /* renamed from: w  reason: collision with root package name */
    private Context f28476w;

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    private class c extends AbstractCursor {
        private c() {
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
    public ev(Context context) {
        try {
            this.f28476w = context == null ? com.bytedance.msdk.core.c.getContext() : StubApp.getOrigApplicationContext(context.getApplicationContext());
            if (this.f28475c == null) {
                this.f28475c = new w();
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Context getContext() {
        Context context = this.f28476w;
        return context == null ? com.bytedance.msdk.core.c.getContext() : context;
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public class w {

        /* renamed from: w  reason: collision with root package name */
        private SQLiteDatabase f28479w = null;

        public w() {
        }

        private void w() {
            try {
                synchronized (ev.xv) {
                    SQLiteDatabase sQLiteDatabase = this.f28479w;
                    if (sQLiteDatabase == null || !sQLiteDatabase.isOpen()) {
                        SQLiteDatabase writableDatabase = new gd(ev.this.getContext(), "tt_mediation_open_sdk.db", 4).getWritableDatabase();
                        this.f28479w = writableDatabase;
                        writableDatabase.setLockingEnabled(false);
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
                xv();
            }
        }

        private boolean xv() {
            SQLiteDatabase sQLiteDatabase = this.f28479w;
            return sQLiteDatabase != null && sQLiteDatabase.isOpen() && sQLiteDatabase.inTransaction();
        }

        public SQLiteDatabase c() {
            w();
            return this.f28479w;
        }

        public int delete(String str, String str2, String[] strArr) {
            try {
                w();
                return this.f28479w.delete(str, str2, strArr);
            } catch (Exception e4) {
                e4.printStackTrace();
                if (xv()) {
                    throw e4;
                }
                return 0;
            }
        }

        public long insert(String str, String str2, ContentValues contentValues) {
            try {
                w();
                return this.f28479w.insert(str, str2, contentValues);
            } catch (Exception e4) {
                com.bytedance.msdk.xv.w.w.c("insert:" + str, e4.toString());
                e4.printStackTrace();
                if (xv()) {
                    throw e4;
                }
                return -1L;
            }
        }

        public Cursor query(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5) {
            boolean xv;
            try {
                w();
                return this.f28479w.query(str, strArr, str2, strArr2, str3, str4, str5);
            } finally {
                if (!xv) {
                }
            }
        }

        public int update(String str, ContentValues contentValues, String str2, String[] strArr) {
            try {
                w();
                return this.f28479w.update(str, contentValues, str2, strArr);
            } catch (Exception e4) {
                e4.printStackTrace();
                if (xv()) {
                    throw e4;
                }
                return 0;
            }
        }

        public void c(String str) throws SQLException {
            boolean xv;
            try {
                w();
                this.f28479w.execSQL(str);
            } finally {
                if (!xv) {
                }
            }
        }

        public Cursor query(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6) {
            try {
                w();
                return this.f28479w.query(str, strArr, str2, strArr2, str3, str4, str5, str6);
            } catch (Throwable th) {
                com.bytedance.msdk.xv.w.w.c("query2:" + str, th.toString());
                th.printStackTrace();
                c cVar = new c();
                if (xv()) {
                    throw th;
                }
                return cVar;
            }
        }

        public Cursor query(boolean z3, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6) {
            try {
                w();
                return this.f28479w.query(z3, str, strArr, str2, strArr2, str3, str4, str5, str6);
            } catch (Throwable th) {
                com.bytedance.msdk.xv.w.w.c("query3:" + str, th.toString());
                th.printStackTrace();
                c cVar = new c();
                if (xv()) {
                    throw th;
                }
                return cVar;
            }
        }
    }

    public w c() {
        return this.f28475c;
    }
}

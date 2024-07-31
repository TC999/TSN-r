package bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do;

import android.content.ContentValues;
import android.content.Context;
import android.database.AbstractCursor;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.InternalContainer;
import com.github.mikephil.charting.utils.Utils;
import com.stub.StubApp;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.i */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class DBHelper {

    /* renamed from: c */
    private static final Object f571c = new Object();

    /* renamed from: a */
    private C0975c f572a;

    /* renamed from: b */
    private Context f573b;

    /* compiled from: DBHelper.java */
    /* renamed from: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.i$b */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    private class C0974b extends AbstractCursor {
        private C0974b(DBHelper dBHelper) {
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
        public double getDouble(int i) {
            return Utils.DOUBLE_EPSILON;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public float getFloat(int i) {
            return 0.0f;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public int getInt(int i) {
            return 0;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public long getLong(int i) {
            return 0L;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public short getShort(int i) {
            return (short) 0;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public String getString(int i) {
            return null;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public boolean isNull(int i) {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DBHelper(Context context) {
        try {
            this.f573b = context == null ? InternalContainer.m59945d() : StubApp.getOrigApplicationContext(context.getApplicationContext());
            if (this.f572a == null) {
                this.f572a = new C0975c();
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public Context m59399c() {
        Context context = this.f573b;
        return context == null ? InternalContainer.m59945d() : context;
    }

    /* renamed from: a */
    public C0975c m59402a() {
        return this.f572a;
    }

    /* compiled from: DBHelper.java */
    /* renamed from: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.i$c */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public class C0975c {

        /* renamed from: a */
        private SQLiteDatabase f574a = null;

        public C0975c() {
        }

        /* renamed from: a */
        private void m59398a() {
            try {
                synchronized (DBHelper.f571c) {
                    SQLiteDatabase sQLiteDatabase = this.f574a;
                    if (sQLiteDatabase == null || !sQLiteDatabase.isOpen()) {
                        SQLiteDatabase writableDatabase = new DatabaseHelper(DBHelper.this.m59399c(), "tt_mediation_open_sdk.db", 2).getWritableDatabase();
                        this.f574a = writableDatabase;
                        writableDatabase.setLockingEnabled(false);
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
                m59393b();
            }
        }

        /* renamed from: b */
        private boolean m59393b() {
            SQLiteDatabase sQLiteDatabase = this.f574a;
            return sQLiteDatabase != null && sQLiteDatabase.isOpen() && sQLiteDatabase.inTransaction();
        }

        /* renamed from: a */
        public void m59397a(String str) throws SQLException {
            boolean m59393b;
            try {
                m59398a();
                this.f574a.execSQL(str);
            } finally {
                if (!m59393b) {
                }
            }
        }

        /* renamed from: a */
        public Cursor m59394a(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6) {
            try {
                m59398a();
                return this.f574a.query(str, strArr, str2, strArr2, str3, str4, str5, str6);
            } catch (Throwable th) {
                th.printStackTrace();
                C0974b c0974b = new C0974b();
                if (m59393b()) {
                    throw th;
                }
                return c0974b;
            }
        }

        /* renamed from: a */
        public long m59396a(String str, String str2, ContentValues contentValues) {
            try {
                m59398a();
                return this.f574a.insert(str, str2, contentValues);
            } catch (Exception e) {
                e.printStackTrace();
                if (m59393b()) {
                    throw e;
                }
                return -1L;
            }
        }

        /* renamed from: a */
        public int m59395a(String str, String str2, String[] strArr) {
            try {
                m59398a();
                return this.f574a.delete(str, str2, strArr);
            } catch (Exception e) {
                e.printStackTrace();
                if (m59393b()) {
                    throw e;
                }
                return 0;
            }
        }
    }
}

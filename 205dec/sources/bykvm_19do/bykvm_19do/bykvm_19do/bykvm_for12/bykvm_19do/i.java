package bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do;

import android.content.ContentValues;
import android.content.Context;
import android.database.AbstractCursor;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import com.stub.StubApp;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DBHelper.java */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class i {

    /* renamed from: c  reason: collision with root package name */
    private static final Object f564c = new Object();

    /* renamed from: a  reason: collision with root package name */
    private c f565a;

    /* renamed from: b  reason: collision with root package name */
    private Context f566b;

    /* compiled from: DBHelper.java */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    private class b extends AbstractCursor {
        private b(i iVar) {
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
    public i(Context context) {
        try {
            this.f566b = context == null ? bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a.d() : StubApp.getOrigApplicationContext(context.getApplicationContext());
            if (this.f565a == null) {
                this.f565a = new c();
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Context c() {
        Context context = this.f566b;
        return context == null ? bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a.d() : context;
    }

    public c a() {
        return this.f565a;
    }

    /* compiled from: DBHelper.java */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    public class c {

        /* renamed from: a  reason: collision with root package name */
        private SQLiteDatabase f567a = null;

        public c() {
        }

        private void a() {
            try {
                synchronized (i.f564c) {
                    SQLiteDatabase sQLiteDatabase = this.f567a;
                    if (sQLiteDatabase == null || !sQLiteDatabase.isOpen()) {
                        SQLiteDatabase writableDatabase = new j(i.this.c(), "tt_mediation_open_sdk.db", 2).getWritableDatabase();
                        this.f567a = writableDatabase;
                        writableDatabase.setLockingEnabled(false);
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
                b();
            }
        }

        private boolean b() {
            SQLiteDatabase sQLiteDatabase = this.f567a;
            return sQLiteDatabase != null && sQLiteDatabase.isOpen() && sQLiteDatabase.inTransaction();
        }

        public void a(String str) throws SQLException {
            boolean b4;
            try {
                a();
                this.f567a.execSQL(str);
            } finally {
                if (!b4) {
                }
            }
        }

        public Cursor a(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6) {
            try {
                a();
                return this.f567a.query(str, strArr, str2, strArr2, str3, str4, str5, str6);
            } catch (Throwable th) {
                th.printStackTrace();
                b bVar = new b();
                if (b()) {
                    throw th;
                }
                return bVar;
            }
        }

        public long a(String str, String str2, ContentValues contentValues) {
            try {
                a();
                return this.f567a.insert(str, str2, contentValues);
            } catch (Exception e4) {
                e4.printStackTrace();
                if (b()) {
                    throw e4;
                }
                return -1L;
            }
        }

        public int a(String str, String str2, String[] strArr) {
            try {
                a();
                return this.f567a.delete(str, str2, strArr);
            } catch (Exception e4) {
                e4.printStackTrace();
                if (b()) {
                    throw e4;
                }
                return 0;
            }
        }
    }
}

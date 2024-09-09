package com.bytedance.pangle.sdk.component.log.impl.cache.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.AbstractCursor;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import com.bytedance.pangle.sdk.component.log.impl.LogInternalManager;
import com.bytedance.pangle.sdk.component.log.impl.debug.LDebug;
import com.stub.StubApp;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class DBHelper {
    private static final String TAG = "DBHelper";
    private static final Object mLocker = new Object();
    private MySQLiteDatabase db;
    private Context mContext;

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    private class EmptyCursor extends AbstractCursor {
        private EmptyCursor() {
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

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public class MySQLiteDatabase {
        private volatile SQLiteDatabase mydb = null;

        public MySQLiteDatabase() {
        }

        private synchronized void checkDBIsOpen() {
            try {
                synchronized (DBHelper.mLocker) {
                    if (this.mydb == null || !this.mydb.isOpen()) {
                        this.mydb = LogInternalManager.getInstance().getDbCallback().getDatabase(LogInternalManager.getInstance().getContext());
                        this.mydb.setLockingEnabled(false);
                        LDebug.d("---------------DB CREATE  SUCCESS------------");
                    }
                }
            } finally {
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void close() {
            this.mydb.close();
        }

        private synchronized boolean inTransaction() {
            boolean z3;
            SQLiteDatabase sQLiteDatabase = this.mydb;
            if (sQLiteDatabase != null) {
                z3 = sQLiteDatabase.inTransaction();
            }
            return z3;
        }

        public synchronized int delete(String str, String str2, String[] strArr) {
            int i4;
            try {
                checkDBIsOpen();
                i4 = this.mydb.delete(str, str2, strArr);
            } catch (Exception e4) {
                e4.printStackTrace();
                if (inTransaction()) {
                    throw e4;
                }
                i4 = 0;
            }
            return i4;
        }

        public synchronized void execSQL(String str) throws SQLException {
            try {
                checkDBIsOpen();
                this.mydb.execSQL(str);
            } catch (Throwable th) {
                if (inTransaction()) {
                    throw th;
                }
            }
        }

        public synchronized long insert(String str, String str2, ContentValues contentValues) {
            long j4;
            try {
                checkDBIsOpen();
                j4 = this.mydb.insert(str, str2, contentValues);
            } catch (Exception e4) {
                e4.printStackTrace();
                if (inTransaction()) {
                    throw e4;
                }
                j4 = -1;
            }
            return j4;
        }

        public synchronized boolean isOpen() {
            boolean z3;
            if (this.mydb != null) {
                z3 = this.mydb.isOpen();
            }
            return z3;
        }

        public synchronized Cursor query(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5) {
            Cursor cursor;
            try {
                checkDBIsOpen();
                cursor = this.mydb.query(str, strArr, str2, strArr2, str3, str4, str5);
            } catch (Throwable th) {
                th.printStackTrace();
                EmptyCursor emptyCursor = new EmptyCursor();
                if (inTransaction()) {
                    throw th;
                }
                cursor = emptyCursor;
            }
            return cursor;
        }

        public synchronized int update(String str, ContentValues contentValues, String str2, String[] strArr) {
            int i4;
            try {
                checkDBIsOpen();
                i4 = this.mydb.update(str, contentValues, str2, strArr);
            } catch (Exception e4) {
                e4.printStackTrace();
                if (inTransaction()) {
                    throw e4;
                }
                i4 = 0;
            }
            return i4;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DBHelper(Context context) {
        try {
            this.mContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
            if (this.db == null) {
                this.db = new MySQLiteDatabase();
            }
        } catch (Throwable unused) {
        }
    }

    private Context getContext() {
        return this.mContext;
    }

    public void close() {
        try {
            MySQLiteDatabase mySQLiteDatabase = this.db;
            if (mySQLiteDatabase != null) {
                mySQLiteDatabase.close();
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public MySQLiteDatabase getDb() {
        return this.db;
    }
}

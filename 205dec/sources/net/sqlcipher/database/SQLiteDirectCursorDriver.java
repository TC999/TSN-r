package net.sqlcipher.database;

import net.sqlcipher.Cursor;
import net.sqlcipher.database.SQLiteDatabase;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class SQLiteDirectCursorDriver implements SQLiteCursorDriver {
    private Cursor mCursor;
    private SQLiteDatabase mDatabase;
    private String mEditTable;
    private SQLiteQuery mQuery;
    private String mSql;

    public SQLiteDirectCursorDriver(SQLiteDatabase sQLiteDatabase, String str, String str2) {
        this.mDatabase = sQLiteDatabase;
        this.mEditTable = str2;
        this.mSql = str;
    }

    @Override // net.sqlcipher.database.SQLiteCursorDriver
    public void cursorClosed() {
        this.mCursor = null;
    }

    @Override // net.sqlcipher.database.SQLiteCursorDriver
    public void cursorDeactivated() {
    }

    @Override // net.sqlcipher.database.SQLiteCursorDriver
    public void cursorRequeried(android.database.Cursor cursor) {
    }

    public Cursor query(SQLiteDatabase.CursorFactory cursorFactory, Object[] objArr) {
        SQLiteQuery sQLiteQuery = new SQLiteQuery(this.mDatabase, this.mSql, 0, objArr);
        try {
            sQLiteQuery.bindArguments(objArr);
            if (cursorFactory == null) {
                this.mCursor = new SQLiteCursor(this.mDatabase, this, this.mEditTable, sQLiteQuery);
            } else {
                this.mCursor = cursorFactory.newCursor(this.mDatabase, this, this.mEditTable, sQLiteQuery);
            }
            this.mQuery = sQLiteQuery;
            sQLiteQuery = null;
            return this.mCursor;
        } catch (Throwable th) {
            if (sQLiteQuery != null) {
                sQLiteQuery.close();
            }
            throw th;
        }
    }

    @Override // net.sqlcipher.database.SQLiteCursorDriver
    public void setBindArguments(String[] strArr) {
        int length = strArr.length;
        int i4 = 0;
        while (i4 < length) {
            int i5 = i4 + 1;
            this.mQuery.bindString(i5, strArr[i4]);
            i4 = i5;
        }
    }

    public String toString() {
        return "SQLiteDirectCursorDriver: " + this.mSql;
    }

    @Override // net.sqlcipher.database.SQLiteCursorDriver
    public Cursor query(SQLiteDatabase.CursorFactory cursorFactory, String[] strArr) {
        int length;
        int i4 = 0;
        SQLiteQuery sQLiteQuery = new SQLiteQuery(this.mDatabase, this.mSql, 0, strArr);
        if (strArr == null) {
            length = 0;
        } else {
            try {
                length = strArr.length;
            } catch (Throwable th) {
                if (sQLiteQuery != null) {
                    sQLiteQuery.close();
                }
                throw th;
            }
        }
        while (i4 < length) {
            int i5 = i4 + 1;
            sQLiteQuery.bindString(i5, strArr[i4]);
            i4 = i5;
        }
        if (cursorFactory == null) {
            this.mCursor = new SQLiteCursor(this.mDatabase, this, this.mEditTable, sQLiteQuery);
        } else {
            this.mCursor = cursorFactory.newCursor(this.mDatabase, this, this.mEditTable, sQLiteQuery);
        }
        this.mQuery = sQLiteQuery;
        sQLiteQuery = null;
        return this.mCursor;
    }
}

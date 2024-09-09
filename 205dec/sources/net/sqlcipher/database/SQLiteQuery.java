package net.sqlcipher.database;

import android.os.SystemClock;
import android.util.Log;
import net.sqlcipher.CursorWindow;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class SQLiteQuery extends SQLiteProgram {
    private static final String TAG = "Cursor";
    private String[] mBindArgs;
    private Object[] mObjectBindArgs;
    private int mOffsetIndex;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SQLiteQuery(SQLiteDatabase sQLiteDatabase, String str, int i4, String[] strArr) {
        super(sQLiteDatabase, str);
        this.mOffsetIndex = i4;
        this.mBindArgs = strArr;
    }

    private final native int native_column_count();

    private final native String native_column_name(int i4);

    private final native int native_fill_window(CursorWindow cursorWindow, int i4, int i5, int i6, int i7, int i8);

    public void bindArguments(Object[] objArr) {
        if (objArr == null || objArr.length <= 0) {
            return;
        }
        for (int i4 = 0; i4 < objArr.length; i4++) {
            Object obj = objArr[i4];
            if (obj == null) {
                bindNull(i4 + 1);
            } else if (obj instanceof Double) {
                bindDouble(i4 + 1, ((Double) obj).doubleValue());
            } else if (obj instanceof Float) {
                bindDouble(i4 + 1, Double.valueOf(((Number) obj).floatValue()).doubleValue());
            } else if (obj instanceof Long) {
                bindLong(i4 + 1, ((Long) obj).longValue());
            } else if (obj instanceof Integer) {
                bindLong(i4 + 1, Long.valueOf(((Number) obj).intValue()).longValue());
            } else if (obj instanceof Boolean) {
                bindLong(i4 + 1, ((Boolean) obj).booleanValue() ? 1L : 0L);
            } else if (obj instanceof byte[]) {
                bindBlob(i4 + 1, (byte[]) obj);
            } else {
                bindString(i4 + 1, obj.toString());
            }
        }
    }

    @Override // net.sqlcipher.database.SQLiteProgram, androidx.sqlite.db.SupportSQLiteProgram
    public void bindDouble(int i4, double d4) {
        this.mBindArgs[i4 - 1] = Double.toString(d4);
        if (this.mClosed) {
            return;
        }
        super.bindDouble(i4, d4);
    }

    @Override // net.sqlcipher.database.SQLiteProgram, androidx.sqlite.db.SupportSQLiteProgram
    public void bindLong(int i4, long j4) {
        this.mBindArgs[i4 - 1] = Long.toString(j4);
        if (this.mClosed) {
            return;
        }
        super.bindLong(i4, j4);
    }

    @Override // net.sqlcipher.database.SQLiteProgram, androidx.sqlite.db.SupportSQLiteProgram
    public void bindNull(int i4) {
        this.mBindArgs[i4 - 1] = null;
        if (this.mClosed) {
            return;
        }
        super.bindNull(i4);
    }

    @Override // net.sqlcipher.database.SQLiteProgram, androidx.sqlite.db.SupportSQLiteProgram
    public void bindString(int i4, String str) {
        this.mBindArgs[i4 - 1] = str;
        if (this.mClosed) {
            return;
        }
        super.bindString(i4, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int columnCountLocked() {
        acquireReference();
        try {
            return native_column_count();
        } finally {
            releaseReference();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String columnNameLocked(int i4) {
        acquireReference();
        try {
            return native_column_name(i4);
        } finally {
            releaseReference();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int fillWindow(CursorWindow cursorWindow, int i4, int i5) {
        int i6;
        SystemClock.uptimeMillis();
        this.mDatabase.lock();
        try {
            acquireReference();
            try {
                cursorWindow.acquireReference();
                i6 = native_fill_window(cursorWindow, cursorWindow.getStartPosition(), cursorWindow.getRequiredPosition(), this.mOffsetIndex, i4, i5);
                if (SQLiteDebug.DEBUG_SQL_STATEMENTS) {
                    Log.d("Cursor", "fillWindow(): " + this.mSql);
                }
            } catch (IllegalStateException unused) {
                i6 = 0;
            } catch (SQLiteDatabaseCorruptException e4) {
                this.mDatabase.onCorruption();
                throw e4;
            }
            cursorWindow.releaseReference();
            return i6;
        } finally {
            releaseReference();
            this.mDatabase.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void requery() {
        String[] strArr = this.mBindArgs;
        if (strArr != null) {
            int length = strArr.length;
            try {
                Object[] objArr = this.mObjectBindArgs;
                if (objArr != null) {
                    bindArguments(objArr);
                    return;
                }
                int i4 = 0;
                while (i4 < length) {
                    int i5 = i4 + 1;
                    super.bindString(i5, this.mBindArgs[i4]);
                    i4 = i5;
                }
            } catch (SQLiteMisuseException e4) {
                StringBuilder sb = new StringBuilder("mSql " + this.mSql);
                for (int i6 = 0; i6 < length; i6++) {
                    sb.append(" ");
                    sb.append(this.mBindArgs[i6]);
                }
                sb.append(" ");
                throw new IllegalStateException(sb.toString(), e4);
            }
        }
    }

    public String toString() {
        return "SQLiteQuery: " + this.mSql;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SQLiteQuery(SQLiteDatabase sQLiteDatabase, String str, int i4, Object[] objArr) {
        super(sQLiteDatabase, str);
        this.mOffsetIndex = i4;
        this.mObjectBindArgs = objArr;
        this.mBindArgs = new String[objArr != null ? objArr.length : 0];
    }
}

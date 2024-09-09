package net.sqlcipher.database;

import android.os.SystemClock;
import androidx.sqlite.db.SupportSQLiteStatement;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class SQLiteStatement extends SQLiteProgram implements SupportSQLiteStatement {
    /* JADX INFO: Access modifiers changed from: package-private */
    public SQLiteStatement(SQLiteDatabase sQLiteDatabase, String str) {
        super(sQLiteDatabase, str);
    }

    private final native long native_1x1_long();

    private final native String native_1x1_string();

    private final native void native_execute();

    @Override // androidx.sqlite.db.SupportSQLiteStatement
    public void execute() {
        if (this.mDatabase.isOpen()) {
            SystemClock.uptimeMillis();
            this.mDatabase.lock();
            acquireReference();
            try {
                native_execute();
                return;
            } finally {
                releaseReference();
                this.mDatabase.unlock();
            }
        }
        throw new IllegalStateException("database " + this.mDatabase.getPath() + " already closed");
    }

    @Override // androidx.sqlite.db.SupportSQLiteStatement
    public long executeInsert() {
        if (this.mDatabase.isOpen()) {
            SystemClock.uptimeMillis();
            this.mDatabase.lock();
            acquireReference();
            try {
                native_execute();
                return this.mDatabase.lastChangeCount() > 0 ? this.mDatabase.lastInsertRow() : -1L;
            } finally {
                releaseReference();
                this.mDatabase.unlock();
            }
        }
        throw new IllegalStateException("database " + this.mDatabase.getPath() + " already closed");
    }

    @Override // androidx.sqlite.db.SupportSQLiteStatement
    public int executeUpdateDelete() {
        if (this.mDatabase.isOpen()) {
            SystemClock.uptimeMillis();
            this.mDatabase.lock();
            acquireReference();
            try {
                native_execute();
                return this.mDatabase.lastChangeCount();
            } finally {
                releaseReference();
                this.mDatabase.unlock();
            }
        }
        throw new IllegalStateException("database " + this.mDatabase.getPath() + " already closed");
    }

    @Override // androidx.sqlite.db.SupportSQLiteStatement
    public long simpleQueryForLong() {
        if (this.mDatabase.isOpen()) {
            SystemClock.uptimeMillis();
            this.mDatabase.lock();
            acquireReference();
            try {
                return native_1x1_long();
            } finally {
                releaseReference();
                this.mDatabase.unlock();
            }
        }
        throw new IllegalStateException("database " + this.mDatabase.getPath() + " already closed");
    }

    @Override // androidx.sqlite.db.SupportSQLiteStatement
    public String simpleQueryForString() {
        if (this.mDatabase.isOpen()) {
            SystemClock.uptimeMillis();
            this.mDatabase.lock();
            acquireReference();
            try {
                return native_1x1_string();
            } finally {
                releaseReference();
                this.mDatabase.unlock();
            }
        }
        throw new IllegalStateException("database " + this.mDatabase.getPath() + " already closed");
    }
}

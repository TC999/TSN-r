package net.sqlcipher.database;

import android.util.Log;
import androidx.sqlite.db.SupportSQLiteProgram;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public abstract class SQLiteProgram extends SQLiteClosable implements SupportSQLiteProgram {
    private static final String TAG = "SQLiteProgram";
    boolean mClosed = false;
    private SQLiteCompiledSql mCompiledSql;
    @Deprecated
    protected SQLiteDatabase mDatabase;
    final String mSql;
    @Deprecated
    protected long nHandle;
    @Deprecated
    protected long nStatement;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SQLiteProgram(SQLiteDatabase sQLiteDatabase, String str) {
        this.nHandle = 0L;
        this.nStatement = 0L;
        this.mDatabase = sQLiteDatabase;
        String trim = str.trim();
        this.mSql = trim;
        sQLiteDatabase.acquireReference();
        sQLiteDatabase.addSQLiteClosable(this);
        this.nHandle = sQLiteDatabase.mNativeHandle;
        trim = trim.length() >= 6 ? trim.substring(0, 6) : trim;
        if (!trim.equalsIgnoreCase("INSERT") && !trim.equalsIgnoreCase("UPDATE") && !trim.equalsIgnoreCase("REPLAC") && !trim.equalsIgnoreCase("DELETE") && !trim.equalsIgnoreCase("SELECT")) {
            SQLiteCompiledSql sQLiteCompiledSql = new SQLiteCompiledSql(sQLiteDatabase, str);
            this.mCompiledSql = sQLiteCompiledSql;
            this.nStatement = sQLiteCompiledSql.nStatement;
            return;
        }
        SQLiteCompiledSql compiledStatementForSql = sQLiteDatabase.getCompiledStatementForSql(str);
        this.mCompiledSql = compiledStatementForSql;
        if (compiledStatementForSql == null) {
            SQLiteCompiledSql sQLiteCompiledSql2 = new SQLiteCompiledSql(sQLiteDatabase, str);
            this.mCompiledSql = sQLiteCompiledSql2;
            sQLiteCompiledSql2.acquire();
            sQLiteDatabase.addToCompiledQueries(str, this.mCompiledSql);
            if (SQLiteDebug.DEBUG_ACTIVE_CURSOR_FINALIZATION) {
                Log.v("SQLiteProgram", "Created DbObj (id#" + this.mCompiledSql.nStatement + ") for sql: " + str);
            }
        } else if (!compiledStatementForSql.acquire()) {
            long j4 = this.mCompiledSql.nStatement;
            this.mCompiledSql = new SQLiteCompiledSql(sQLiteDatabase, str);
            if (SQLiteDebug.DEBUG_ACTIVE_CURSOR_FINALIZATION) {
                Log.v("SQLiteProgram", "** possible bug ** Created NEW DbObj (id#" + this.mCompiledSql.nStatement + ") because the previously created DbObj (id#" + j4 + ") was not released for sql:" + str);
            }
        }
        this.nStatement = this.mCompiledSql.nStatement;
    }

    private final native void native_clear_bindings();

    private void releaseCompiledSqlIfNotInCache() {
        if (this.mCompiledSql == null) {
            return;
        }
        synchronized (this.mDatabase.mCompiledQueries) {
            if (!this.mDatabase.mCompiledQueries.containsValue(this.mCompiledSql)) {
                this.mCompiledSql.releaseSqlStatement();
                this.mCompiledSql = null;
                this.nStatement = 0L;
            } else {
                this.mCompiledSql.release();
            }
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindBlob(int i4, byte[] bArr) {
        if (bArr != null) {
            if (!this.mClosed) {
                if (this.mDatabase.isOpen()) {
                    acquireReference();
                    try {
                        native_bind_blob(i4, bArr);
                        return;
                    } finally {
                        releaseReference();
                    }
                }
                throw new IllegalStateException("database " + this.mDatabase.getPath() + " already closed");
            }
            throw new IllegalStateException("program already closed");
        }
        throw new IllegalArgumentException("the bind value at index " + i4 + " is null");
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindDouble(int i4, double d4) {
        if (!this.mClosed) {
            if (this.mDatabase.isOpen()) {
                acquireReference();
                try {
                    native_bind_double(i4, d4);
                    return;
                } finally {
                    releaseReference();
                }
            }
            throw new IllegalStateException("database " + this.mDatabase.getPath() + " already closed");
        }
        throw new IllegalStateException("program already closed");
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindLong(int i4, long j4) {
        if (!this.mClosed) {
            if (this.mDatabase.isOpen()) {
                acquireReference();
                try {
                    native_bind_long(i4, j4);
                    return;
                } finally {
                    releaseReference();
                }
            }
            throw new IllegalStateException("database " + this.mDatabase.getPath() + " already closed");
        }
        throw new IllegalStateException("program already closed");
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindNull(int i4) {
        if (!this.mClosed) {
            if (this.mDatabase.isOpen()) {
                acquireReference();
                try {
                    native_bind_null(i4);
                    return;
                } finally {
                    releaseReference();
                }
            }
            throw new IllegalStateException("database " + this.mDatabase.getPath() + " already closed");
        }
        throw new IllegalStateException("program already closed");
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindString(int i4, String str) {
        if (str != null) {
            if (!this.mClosed) {
                if (this.mDatabase.isOpen()) {
                    acquireReference();
                    try {
                        native_bind_string(i4, str);
                        return;
                    } finally {
                        releaseReference();
                    }
                }
                throw new IllegalStateException("database " + this.mDatabase.getPath() + " already closed");
            }
            throw new IllegalStateException("program already closed");
        }
        throw new IllegalArgumentException("the bind value at index " + i4 + " is null");
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void clearBindings() {
        if (!this.mClosed) {
            if (this.mDatabase.isOpen()) {
                acquireReference();
                try {
                    native_clear_bindings();
                    return;
                } finally {
                    releaseReference();
                }
            }
            throw new IllegalStateException("database " + this.mDatabase.getPath() + " already closed");
        }
        throw new IllegalStateException("program already closed");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (!this.mClosed && this.mDatabase.isOpen()) {
            this.mDatabase.lock();
            try {
                releaseReference();
                this.mDatabase.unlock();
                this.mClosed = true;
            } catch (Throwable th) {
                this.mDatabase.unlock();
                throw th;
            }
        }
    }

    @Deprecated
    protected void compile(String str, boolean z3) {
    }

    String getSqlString() {
        return this.mSql;
    }

    public final long getUniqueId() {
        return this.nStatement;
    }

    protected final native void native_bind_blob(int i4, byte[] bArr);

    protected final native void native_bind_double(int i4, double d4);

    protected final native void native_bind_long(int i4, long j4);

    protected final native void native_bind_null(int i4);

    protected final native void native_bind_string(int i4, String str);

    @Deprecated
    protected final native void native_compile(String str);

    @Deprecated
    protected final native void native_finalize();

    @Override // net.sqlcipher.database.SQLiteClosable
    protected void onAllReferencesReleased() {
        releaseCompiledSqlIfNotInCache();
        this.mDatabase.releaseReference();
        this.mDatabase.removeSQLiteClosable(this);
    }

    @Override // net.sqlcipher.database.SQLiteClosable
    protected void onAllReferencesReleasedFromContainer() {
        releaseCompiledSqlIfNotInCache();
        this.mDatabase.releaseReference();
    }
}

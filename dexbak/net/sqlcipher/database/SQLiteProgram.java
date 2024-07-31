package net.sqlcipher.database;

import android.util.Log;
import androidx.sqlite.p021db.SupportSQLiteProgram;

/* loaded from: E:\fuckcool\tsn\5406560.dex */
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
                Log.v(TAG, "Created DbObj (id#" + this.mCompiledSql.nStatement + ") for sql: " + str);
            }
        } else if (!compiledStatementForSql.acquire()) {
            long j = this.mCompiledSql.nStatement;
            this.mCompiledSql = new SQLiteCompiledSql(sQLiteDatabase, str);
            if (SQLiteDebug.DEBUG_ACTIVE_CURSOR_FINALIZATION) {
                Log.v(TAG, "** possible bug ** Created NEW DbObj (id#" + this.mCompiledSql.nStatement + ") because the previously created DbObj (id#" + j + ") was not released for sql:" + str);
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

    @Override // androidx.sqlite.p021db.SupportSQLiteProgram
    public void bindBlob(int i, byte[] bArr) {
        if (bArr != null) {
            if (!this.mClosed) {
                if (this.mDatabase.isOpen()) {
                    acquireReference();
                    try {
                        native_bind_blob(i, bArr);
                        return;
                    } finally {
                        releaseReference();
                    }
                }
                throw new IllegalStateException("database " + this.mDatabase.getPath() + " already closed");
            }
            throw new IllegalStateException("program already closed");
        }
        throw new IllegalArgumentException("the bind value at index " + i + " is null");
    }

    @Override // androidx.sqlite.p021db.SupportSQLiteProgram
    public void bindDouble(int i, double d) {
        if (!this.mClosed) {
            if (this.mDatabase.isOpen()) {
                acquireReference();
                try {
                    native_bind_double(i, d);
                    return;
                } finally {
                    releaseReference();
                }
            }
            throw new IllegalStateException("database " + this.mDatabase.getPath() + " already closed");
        }
        throw new IllegalStateException("program already closed");
    }

    @Override // androidx.sqlite.p021db.SupportSQLiteProgram
    public void bindLong(int i, long j) {
        if (!this.mClosed) {
            if (this.mDatabase.isOpen()) {
                acquireReference();
                try {
                    native_bind_long(i, j);
                    return;
                } finally {
                    releaseReference();
                }
            }
            throw new IllegalStateException("database " + this.mDatabase.getPath() + " already closed");
        }
        throw new IllegalStateException("program already closed");
    }

    @Override // androidx.sqlite.p021db.SupportSQLiteProgram
    public void bindNull(int i) {
        if (!this.mClosed) {
            if (this.mDatabase.isOpen()) {
                acquireReference();
                try {
                    native_bind_null(i);
                    return;
                } finally {
                    releaseReference();
                }
            }
            throw new IllegalStateException("database " + this.mDatabase.getPath() + " already closed");
        }
        throw new IllegalStateException("program already closed");
    }

    @Override // androidx.sqlite.p021db.SupportSQLiteProgram
    public void bindString(int i, String str) {
        if (str != null) {
            if (!this.mClosed) {
                if (this.mDatabase.isOpen()) {
                    acquireReference();
                    try {
                        native_bind_string(i, str);
                        return;
                    } finally {
                        releaseReference();
                    }
                }
                throw new IllegalStateException("database " + this.mDatabase.getPath() + " already closed");
            }
            throw new IllegalStateException("program already closed");
        }
        throw new IllegalArgumentException("the bind value at index " + i + " is null");
    }

    @Override // androidx.sqlite.p021db.SupportSQLiteProgram
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
    protected void compile(String str, boolean z) {
    }

    String getSqlString() {
        return this.mSql;
    }

    public final long getUniqueId() {
        return this.nStatement;
    }

    protected final native void native_bind_blob(int i, byte[] bArr);

    protected final native void native_bind_double(int i, double d);

    protected final native void native_bind_long(int i, long j);

    protected final native void native_bind_null(int i);

    protected final native void native_bind_string(int i, String str);

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

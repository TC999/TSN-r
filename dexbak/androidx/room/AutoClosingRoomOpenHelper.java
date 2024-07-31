package androidx.room;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.database.SQLException;
import android.database.sqlite.SQLiteTransactionListener;
import android.net.Uri;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.arch.core.util.Function;
import androidx.room.AutoClosingRoomOpenHelper;
import androidx.room.util.SneakyThrow;
import androidx.sqlite.p021db.SupportSQLiteDatabase;
import androidx.sqlite.p021db.SupportSQLiteOpenHelper;
import androidx.sqlite.p021db.SupportSQLiteQuery;
import androidx.sqlite.p021db.SupportSQLiteStatement;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class AutoClosingRoomOpenHelper implements SupportSQLiteOpenHelper, DelegatingOpenHelper {
    @NonNull
    private final AutoCloser mAutoCloser;
    @NonNull
    private final AutoClosingSupportSQLiteDatabase mAutoClosingDb;
    @NonNull
    private final SupportSQLiteOpenHelper mDelegateOpenHelper;

    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    static final class AutoClosingSupportSQLiteDatabase implements SupportSQLiteDatabase {
        @NonNull
        private final AutoCloser mAutoCloser;

        AutoClosingSupportSQLiteDatabase(@NonNull AutoCloser autoCloser) {
            this.mAutoCloser = autoCloser;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ Integer lambda$delete$5(String str, String str2, Object[] objArr, SupportSQLiteDatabase supportSQLiteDatabase) {
            return Integer.valueOf(supportSQLiteDatabase.delete(str, str2, objArr));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ Object lambda$execSQL$7(String str, SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.execSQL(str);
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ Object lambda$execSQL$8(String str, Object[] objArr, SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.execSQL(str, objArr);
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ Long lambda$insert$4(String str, int i, ContentValues contentValues, SupportSQLiteDatabase supportSQLiteDatabase) {
            return Long.valueOf(supportSQLiteDatabase.insert(str, i, contentValues));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ Boolean lambda$isWriteAheadLoggingEnabled$13(SupportSQLiteDatabase supportSQLiteDatabase) {
            return Boolean.valueOf(supportSQLiteDatabase.isWriteAheadLoggingEnabled());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ Boolean lambda$needUpgrade$9(int i, SupportSQLiteDatabase supportSQLiteDatabase) {
            return Boolean.valueOf(supportSQLiteDatabase.needUpgrade(i));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ Object lambda$pokeOpen$0(SupportSQLiteDatabase supportSQLiteDatabase) {
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ Object lambda$setForeignKeyConstraintsEnabled$12(boolean z, SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.setForeignKeyConstraintsEnabled(z);
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ Object lambda$setLocale$10(Locale locale, SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.setLocale(locale);
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ Object lambda$setMaxSqlCacheSize$11(int i, SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.setMaxSqlCacheSize(i);
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ Long lambda$setMaximumSize$2(long j, SupportSQLiteDatabase supportSQLiteDatabase) {
            return Long.valueOf(supportSQLiteDatabase.setMaximumSize(j));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ Object lambda$setPageSize$3(long j, SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.setPageSize(j);
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ Object lambda$setVersion$1(int i, SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.setVersion(i);
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ Integer lambda$update$6(String str, int i, ContentValues contentValues, String str2, Object[] objArr, SupportSQLiteDatabase supportSQLiteDatabase) {
            return Integer.valueOf(supportSQLiteDatabase.update(str, i, contentValues, str2, objArr));
        }

        @Override // androidx.sqlite.p021db.SupportSQLiteDatabase
        public void beginTransaction() {
            try {
                this.mAutoCloser.incrementCountAndEnsureDbIsOpen().beginTransaction();
            } catch (Throwable th) {
                this.mAutoCloser.decrementCountAndScheduleClose();
                throw th;
            }
        }

        @Override // androidx.sqlite.p021db.SupportSQLiteDatabase
        public void beginTransactionNonExclusive() {
            try {
                this.mAutoCloser.incrementCountAndEnsureDbIsOpen().beginTransactionNonExclusive();
            } catch (Throwable th) {
                this.mAutoCloser.decrementCountAndScheduleClose();
                throw th;
            }
        }

        @Override // androidx.sqlite.p021db.SupportSQLiteDatabase
        public void beginTransactionWithListener(SQLiteTransactionListener transactionListener) {
            try {
                this.mAutoCloser.incrementCountAndEnsureDbIsOpen().beginTransactionWithListener(transactionListener);
            } catch (Throwable th) {
                this.mAutoCloser.decrementCountAndScheduleClose();
                throw th;
            }
        }

        @Override // androidx.sqlite.p021db.SupportSQLiteDatabase
        public void beginTransactionWithListenerNonExclusive(SQLiteTransactionListener transactionListener) {
            try {
                this.mAutoCloser.incrementCountAndEnsureDbIsOpen().beginTransactionWithListenerNonExclusive(transactionListener);
            } catch (Throwable th) {
                this.mAutoCloser.decrementCountAndScheduleClose();
                throw th;
            }
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.mAutoCloser.closeDatabaseIfOpen();
        }

        @Override // androidx.sqlite.p021db.SupportSQLiteDatabase
        public SupportSQLiteStatement compileStatement(String sql) {
            return new AutoClosingSupportSqliteStatement(sql, this.mAutoCloser);
        }

        @Override // androidx.sqlite.p021db.SupportSQLiteDatabase
        public int delete(final String table, final String whereClause, final Object[] whereArgs) {
            return ((Integer) this.mAutoCloser.executeRefCountingFunction(new Function() { // from class: androidx.room.x
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    Integer lambda$delete$5;
                    lambda$delete$5 = AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteDatabase.lambda$delete$5(table, whereClause, whereArgs, (SupportSQLiteDatabase) obj);
                    return lambda$delete$5;
                }
            })).intValue();
        }

        @Override // androidx.sqlite.p021db.SupportSQLiteDatabase
        public void disableWriteAheadLogging() {
            throw new UnsupportedOperationException("Enable/disable write ahead logging on the OpenHelper instead of on the database directly.");
        }

        @Override // androidx.sqlite.p021db.SupportSQLiteDatabase
        public boolean enableWriteAheadLogging() {
            throw new UnsupportedOperationException("Enable/disable write ahead logging on the OpenHelper instead of on the database directly.");
        }

        @Override // androidx.sqlite.p021db.SupportSQLiteDatabase
        public void endTransaction() {
            if (this.mAutoCloser.getDelegateDatabase() != null) {
                try {
                    this.mAutoCloser.getDelegateDatabase().endTransaction();
                    return;
                } finally {
                    this.mAutoCloser.decrementCountAndScheduleClose();
                }
            }
            throw new IllegalStateException("End transaction called but delegateDb is null");
        }

        @Override // androidx.sqlite.p021db.SupportSQLiteDatabase
        public void execSQL(final String sql) throws SQLException {
            this.mAutoCloser.executeRefCountingFunction(new Function() { // from class: androidx.room.u
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    Object lambda$execSQL$7;
                    lambda$execSQL$7 = AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteDatabase.lambda$execSQL$7(sql, (SupportSQLiteDatabase) obj);
                    return lambda$execSQL$7;
                }
            });
        }

        @Override // androidx.sqlite.p021db.SupportSQLiteDatabase
        public List<Pair<String, String>> getAttachedDbs() {
            return (List) this.mAutoCloser.executeRefCountingFunction(new Function() { // from class: androidx.room.f
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return ((SupportSQLiteDatabase) obj).getAttachedDbs();
                }
            });
        }

        @Override // androidx.sqlite.p021db.SupportSQLiteDatabase
        public long getMaximumSize() {
            return ((Long) this.mAutoCloser.executeRefCountingFunction(new Function() { // from class: androidx.room.o
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return Long.valueOf(((SupportSQLiteDatabase) obj).getMaximumSize());
                }
            })).longValue();
        }

        @Override // androidx.sqlite.p021db.SupportSQLiteDatabase
        public long getPageSize() {
            return ((Long) this.mAutoCloser.executeRefCountingFunction(new Function() { // from class: androidx.room.p
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return Long.valueOf(((SupportSQLiteDatabase) obj).getPageSize());
                }
            })).longValue();
        }

        @Override // androidx.sqlite.p021db.SupportSQLiteDatabase
        public String getPath() {
            return (String) this.mAutoCloser.executeRefCountingFunction(new Function() { // from class: androidx.room.g
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return ((SupportSQLiteDatabase) obj).getPath();
                }
            });
        }

        @Override // androidx.sqlite.p021db.SupportSQLiteDatabase
        public int getVersion() {
            return ((Integer) this.mAutoCloser.executeRefCountingFunction(new Function() { // from class: androidx.room.h
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return Integer.valueOf(((SupportSQLiteDatabase) obj).getVersion());
                }
            })).intValue();
        }

        @Override // androidx.sqlite.p021db.SupportSQLiteDatabase
        public boolean inTransaction() {
            if (this.mAutoCloser.getDelegateDatabase() == null) {
                return false;
            }
            return ((Boolean) this.mAutoCloser.executeRefCountingFunction(new Function() { // from class: androidx.room.i
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return Boolean.valueOf(((SupportSQLiteDatabase) obj).inTransaction());
                }
            })).booleanValue();
        }

        @Override // androidx.sqlite.p021db.SupportSQLiteDatabase
        public long insert(final String table, final int conflictAlgorithm, final ContentValues values) throws SQLException {
            return ((Long) this.mAutoCloser.executeRefCountingFunction(new Function() { // from class: androidx.room.v
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    Long lambda$insert$4;
                    lambda$insert$4 = AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteDatabase.lambda$insert$4(table, conflictAlgorithm, values, (SupportSQLiteDatabase) obj);
                    return lambda$insert$4;
                }
            })).longValue();
        }

        @Override // androidx.sqlite.p021db.SupportSQLiteDatabase
        public boolean isDatabaseIntegrityOk() {
            return ((Boolean) this.mAutoCloser.executeRefCountingFunction(new Function() { // from class: androidx.room.j
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return Boolean.valueOf(((SupportSQLiteDatabase) obj).isDatabaseIntegrityOk());
                }
            })).booleanValue();
        }

        @Override // androidx.sqlite.p021db.SupportSQLiteDatabase
        public boolean isDbLockedByCurrentThread() {
            if (this.mAutoCloser.getDelegateDatabase() == null) {
                return false;
            }
            return ((Boolean) this.mAutoCloser.executeRefCountingFunction(new Function() { // from class: androidx.room.k
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return Boolean.valueOf(((SupportSQLiteDatabase) obj).isDbLockedByCurrentThread());
                }
            })).booleanValue();
        }

        @Override // androidx.sqlite.p021db.SupportSQLiteDatabase
        public boolean isOpen() {
            SupportSQLiteDatabase delegateDatabase = this.mAutoCloser.getDelegateDatabase();
            if (delegateDatabase == null) {
                return false;
            }
            return delegateDatabase.isOpen();
        }

        @Override // androidx.sqlite.p021db.SupportSQLiteDatabase
        public boolean isReadOnly() {
            return ((Boolean) this.mAutoCloser.executeRefCountingFunction(new Function() { // from class: androidx.room.m
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return Boolean.valueOf(((SupportSQLiteDatabase) obj).isReadOnly());
                }
            })).booleanValue();
        }

        @Override // androidx.sqlite.p021db.SupportSQLiteDatabase
        @RequiresApi(api = 16)
        @SuppressLint({"UnsafeNewApiCall"})
        public boolean isWriteAheadLoggingEnabled() {
            return ((Boolean) this.mAutoCloser.executeRefCountingFunction(new Function() { // from class: androidx.room.d
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    Boolean lambda$isWriteAheadLoggingEnabled$13;
                    lambda$isWriteAheadLoggingEnabled$13 = AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteDatabase.lambda$isWriteAheadLoggingEnabled$13((SupportSQLiteDatabase) obj);
                    return lambda$isWriteAheadLoggingEnabled$13;
                }
            })).booleanValue();
        }

        @Override // androidx.sqlite.p021db.SupportSQLiteDatabase
        public boolean needUpgrade(final int newVersion) {
            return ((Boolean) this.mAutoCloser.executeRefCountingFunction(new Function() { // from class: androidx.room.a
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    Boolean lambda$needUpgrade$9;
                    lambda$needUpgrade$9 = AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteDatabase.lambda$needUpgrade$9(newVersion, (SupportSQLiteDatabase) obj);
                    return lambda$needUpgrade$9;
                }
            })).booleanValue();
        }

        void pokeOpen() {
            this.mAutoCloser.executeRefCountingFunction(new Function() { // from class: androidx.room.e
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    Object lambda$pokeOpen$0;
                    lambda$pokeOpen$0 = AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteDatabase.lambda$pokeOpen$0((SupportSQLiteDatabase) obj);
                    return lambda$pokeOpen$0;
                }
            });
        }

        @Override // androidx.sqlite.p021db.SupportSQLiteDatabase
        public Cursor query(String query) {
            try {
                return new KeepAliveCursor(this.mAutoCloser.incrementCountAndEnsureDbIsOpen().query(query), this.mAutoCloser);
            } catch (Throwable th) {
                this.mAutoCloser.decrementCountAndScheduleClose();
                throw th;
            }
        }

        @Override // androidx.sqlite.p021db.SupportSQLiteDatabase
        @RequiresApi(api = 16)
        @SuppressLint({"UnsafeNewApiCall"})
        public void setForeignKeyConstraintsEnabled(final boolean enable) {
            this.mAutoCloser.executeRefCountingFunction(new Function() { // from class: androidx.room.c
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    Object lambda$setForeignKeyConstraintsEnabled$12;
                    lambda$setForeignKeyConstraintsEnabled$12 = AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteDatabase.lambda$setForeignKeyConstraintsEnabled$12(enable, (SupportSQLiteDatabase) obj);
                    return lambda$setForeignKeyConstraintsEnabled$12;
                }
            });
        }

        @Override // androidx.sqlite.p021db.SupportSQLiteDatabase
        public void setLocale(final Locale locale) {
            this.mAutoCloser.executeRefCountingFunction(new Function() { // from class: androidx.room.b
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    Object lambda$setLocale$10;
                    lambda$setLocale$10 = AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteDatabase.lambda$setLocale$10(locale, (SupportSQLiteDatabase) obj);
                    return lambda$setLocale$10;
                }
            });
        }

        @Override // androidx.sqlite.p021db.SupportSQLiteDatabase
        public void setMaxSqlCacheSize(final int cacheSize) {
            this.mAutoCloser.executeRefCountingFunction(new Function() { // from class: androidx.room.l
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    Object lambda$setMaxSqlCacheSize$11;
                    lambda$setMaxSqlCacheSize$11 = AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteDatabase.lambda$setMaxSqlCacheSize$11(cacheSize, (SupportSQLiteDatabase) obj);
                    return lambda$setMaxSqlCacheSize$11;
                }
            });
        }

        @Override // androidx.sqlite.p021db.SupportSQLiteDatabase
        public long setMaximumSize(final long numBytes) {
            return ((Long) this.mAutoCloser.executeRefCountingFunction(new Function() { // from class: androidx.room.t
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    Long lambda$setMaximumSize$2;
                    lambda$setMaximumSize$2 = AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteDatabase.lambda$setMaximumSize$2(numBytes, (SupportSQLiteDatabase) obj);
                    return lambda$setMaximumSize$2;
                }
            })).longValue();
        }

        @Override // androidx.sqlite.p021db.SupportSQLiteDatabase
        public void setPageSize(final long numBytes) {
            this.mAutoCloser.executeRefCountingFunction(new Function() { // from class: androidx.room.s
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    Object lambda$setPageSize$3;
                    lambda$setPageSize$3 = AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteDatabase.lambda$setPageSize$3(numBytes, (SupportSQLiteDatabase) obj);
                    return lambda$setPageSize$3;
                }
            });
        }

        @Override // androidx.sqlite.p021db.SupportSQLiteDatabase
        public void setTransactionSuccessful() {
            SupportSQLiteDatabase delegateDatabase = this.mAutoCloser.getDelegateDatabase();
            if (delegateDatabase != null) {
                delegateDatabase.setTransactionSuccessful();
                return;
            }
            throw new IllegalStateException("setTransactionSuccessful called but delegateDb is null");
        }

        @Override // androidx.sqlite.p021db.SupportSQLiteDatabase
        public void setVersion(final int version) {
            this.mAutoCloser.executeRefCountingFunction(new Function() { // from class: androidx.room.q
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    Object lambda$setVersion$1;
                    lambda$setVersion$1 = AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteDatabase.lambda$setVersion$1(version, (SupportSQLiteDatabase) obj);
                    return lambda$setVersion$1;
                }
            });
        }

        @Override // androidx.sqlite.p021db.SupportSQLiteDatabase
        public int update(final String table, final int conflictAlgorithm, final ContentValues values, final String whereClause, final Object[] whereArgs) {
            return ((Integer) this.mAutoCloser.executeRefCountingFunction(new Function() { // from class: androidx.room.w
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    Integer lambda$update$6;
                    lambda$update$6 = AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteDatabase.lambda$update$6(table, conflictAlgorithm, values, whereClause, whereArgs, (SupportSQLiteDatabase) obj);
                    return lambda$update$6;
                }
            })).intValue();
        }

        @Override // androidx.sqlite.p021db.SupportSQLiteDatabase
        public boolean yieldIfContendedSafely() {
            return ((Boolean) this.mAutoCloser.executeRefCountingFunction(C0761n.f189a)).booleanValue();
        }

        @Override // androidx.sqlite.p021db.SupportSQLiteDatabase
        public void execSQL(final String sql, final Object[] bindArgs) throws SQLException {
            this.mAutoCloser.executeRefCountingFunction(new Function() { // from class: androidx.room.y
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    Object lambda$execSQL$8;
                    lambda$execSQL$8 = AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteDatabase.lambda$execSQL$8(sql, bindArgs, (SupportSQLiteDatabase) obj);
                    return lambda$execSQL$8;
                }
            });
        }

        @Override // androidx.sqlite.p021db.SupportSQLiteDatabase
        public boolean yieldIfContendedSafely(long sleepAfterYieldDelay) {
            return ((Boolean) this.mAutoCloser.executeRefCountingFunction(C0761n.f189a)).booleanValue();
        }

        @Override // androidx.sqlite.p021db.SupportSQLiteDatabase
        public Cursor query(String query, Object[] bindArgs) {
            try {
                return new KeepAliveCursor(this.mAutoCloser.incrementCountAndEnsureDbIsOpen().query(query, bindArgs), this.mAutoCloser);
            } catch (Throwable th) {
                this.mAutoCloser.decrementCountAndScheduleClose();
                throw th;
            }
        }

        @Override // androidx.sqlite.p021db.SupportSQLiteDatabase
        public Cursor query(SupportSQLiteQuery query) {
            try {
                return new KeepAliveCursor(this.mAutoCloser.incrementCountAndEnsureDbIsOpen().query(query), this.mAutoCloser);
            } catch (Throwable th) {
                this.mAutoCloser.decrementCountAndScheduleClose();
                throw th;
            }
        }

        @Override // androidx.sqlite.p021db.SupportSQLiteDatabase
        @RequiresApi(api = 24)
        public Cursor query(SupportSQLiteQuery query, CancellationSignal cancellationSignal) {
            try {
                return new KeepAliveCursor(this.mAutoCloser.incrementCountAndEnsureDbIsOpen().query(query, cancellationSignal), this.mAutoCloser);
            } catch (Throwable th) {
                this.mAutoCloser.decrementCountAndScheduleClose();
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public static class AutoClosingSupportSqliteStatement implements SupportSQLiteStatement {
        private final AutoCloser mAutoCloser;
        private final ArrayList<Object> mBinds = new ArrayList<>();
        private final String mSql;

        AutoClosingSupportSqliteStatement(String sql, AutoCloser autoCloser) {
            this.mSql = sql;
            this.mAutoCloser = autoCloser;
        }

        private void doBinds(SupportSQLiteStatement supportSQLiteStatement) {
            int i = 0;
            while (i < this.mBinds.size()) {
                int i2 = i + 1;
                Object obj = this.mBinds.get(i);
                if (obj == null) {
                    supportSQLiteStatement.bindNull(i2);
                } else if (obj instanceof Long) {
                    supportSQLiteStatement.bindLong(i2, ((Long) obj).longValue());
                } else if (obj instanceof Double) {
                    supportSQLiteStatement.bindDouble(i2, ((Double) obj).doubleValue());
                } else if (obj instanceof String) {
                    supportSQLiteStatement.bindString(i2, (String) obj);
                } else if (obj instanceof byte[]) {
                    supportSQLiteStatement.bindBlob(i2, (byte[]) obj);
                }
                i = i2;
            }
        }

        private <T> T executeSqliteStatementWithRefCount(final Function<SupportSQLiteStatement, T> func) {
            return (T) this.mAutoCloser.executeRefCountingFunction(new Function() { // from class: androidx.room.z
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    Object lambda$executeSqliteStatementWithRefCount$0;
                    lambda$executeSqliteStatementWithRefCount$0 = AutoClosingRoomOpenHelper.AutoClosingSupportSqliteStatement.this.lambda$executeSqliteStatementWithRefCount$0(func, (SupportSQLiteDatabase) obj);
                    return lambda$executeSqliteStatementWithRefCount$0;
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ Object lambda$execute$1(SupportSQLiteStatement supportSQLiteStatement) {
            supportSQLiteStatement.execute();
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Object lambda$executeSqliteStatementWithRefCount$0(Function function, SupportSQLiteDatabase supportSQLiteDatabase) {
            SupportSQLiteStatement compileStatement = supportSQLiteDatabase.compileStatement(this.mSql);
            doBinds(compileStatement);
            return function.apply(compileStatement);
        }

        private void saveBinds(int bindIndex, Object value) {
            int i = bindIndex - 1;
            if (i >= this.mBinds.size()) {
                for (int size = this.mBinds.size(); size <= i; size++) {
                    this.mBinds.add(null);
                }
            }
            this.mBinds.set(i, value);
        }

        @Override // androidx.sqlite.p021db.SupportSQLiteProgram
        public void bindBlob(int index, byte[] value) {
            saveBinds(index, value);
        }

        @Override // androidx.sqlite.p021db.SupportSQLiteProgram
        public void bindDouble(int index, double value) {
            saveBinds(index, Double.valueOf(value));
        }

        @Override // androidx.sqlite.p021db.SupportSQLiteProgram
        public void bindLong(int index, long value) {
            saveBinds(index, Long.valueOf(value));
        }

        @Override // androidx.sqlite.p021db.SupportSQLiteProgram
        public void bindNull(int index) {
            saveBinds(index, null);
        }

        @Override // androidx.sqlite.p021db.SupportSQLiteProgram
        public void bindString(int index, String value) {
            saveBinds(index, value);
        }

        @Override // androidx.sqlite.p021db.SupportSQLiteProgram
        public void clearBindings() {
            this.mBinds.clear();
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
        }

        @Override // androidx.sqlite.p021db.SupportSQLiteStatement
        public void execute() {
            executeSqliteStatementWithRefCount(new Function() { // from class: androidx.room.a0
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    Object lambda$execute$1;
                    lambda$execute$1 = AutoClosingRoomOpenHelper.AutoClosingSupportSqliteStatement.lambda$execute$1((SupportSQLiteStatement) obj);
                    return lambda$execute$1;
                }
            });
        }

        @Override // androidx.sqlite.p021db.SupportSQLiteStatement
        public long executeInsert() {
            return ((Long) executeSqliteStatementWithRefCount(new Function() { // from class: androidx.room.d0
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return Long.valueOf(((SupportSQLiteStatement) obj).executeInsert());
                }
            })).longValue();
        }

        @Override // androidx.sqlite.p021db.SupportSQLiteStatement
        public int executeUpdateDelete() {
            return ((Integer) executeSqliteStatementWithRefCount(new Function() { // from class: androidx.room.b0
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return Integer.valueOf(((SupportSQLiteStatement) obj).executeUpdateDelete());
                }
            })).intValue();
        }

        @Override // androidx.sqlite.p021db.SupportSQLiteStatement
        public long simpleQueryForLong() {
            return ((Long) executeSqliteStatementWithRefCount(new Function() { // from class: androidx.room.e0
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return Long.valueOf(((SupportSQLiteStatement) obj).simpleQueryForLong());
                }
            })).longValue();
        }

        @Override // androidx.sqlite.p021db.SupportSQLiteStatement
        public String simpleQueryForString() {
            return (String) executeSqliteStatementWithRefCount(new Function() { // from class: androidx.room.c0
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return ((SupportSQLiteStatement) obj).simpleQueryForString();
                }
            });
        }
    }

    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    private static final class KeepAliveCursor implements Cursor {
        private final AutoCloser mAutoCloser;
        private final Cursor mDelegate;

        KeepAliveCursor(Cursor delegate, AutoCloser autoCloser) {
            this.mDelegate = delegate;
            this.mAutoCloser = autoCloser;
        }

        @Override // android.database.Cursor, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.mDelegate.close();
            this.mAutoCloser.decrementCountAndScheduleClose();
        }

        @Override // android.database.Cursor
        public void copyStringToBuffer(int columnIndex, CharArrayBuffer buffer) {
            this.mDelegate.copyStringToBuffer(columnIndex, buffer);
        }

        @Override // android.database.Cursor
        @Deprecated
        public void deactivate() {
            this.mDelegate.deactivate();
        }

        @Override // android.database.Cursor
        public byte[] getBlob(int columnIndex) {
            return this.mDelegate.getBlob(columnIndex);
        }

        @Override // android.database.Cursor
        public int getColumnCount() {
            return this.mDelegate.getColumnCount();
        }

        @Override // android.database.Cursor
        public int getColumnIndex(String columnName) {
            return this.mDelegate.getColumnIndex(columnName);
        }

        @Override // android.database.Cursor
        public int getColumnIndexOrThrow(String columnName) throws IllegalArgumentException {
            return this.mDelegate.getColumnIndexOrThrow(columnName);
        }

        @Override // android.database.Cursor
        public String getColumnName(int columnIndex) {
            return this.mDelegate.getColumnName(columnIndex);
        }

        @Override // android.database.Cursor
        public String[] getColumnNames() {
            return this.mDelegate.getColumnNames();
        }

        @Override // android.database.Cursor
        public int getCount() {
            return this.mDelegate.getCount();
        }

        @Override // android.database.Cursor
        public double getDouble(int columnIndex) {
            return this.mDelegate.getDouble(columnIndex);
        }

        @Override // android.database.Cursor
        public Bundle getExtras() {
            return this.mDelegate.getExtras();
        }

        @Override // android.database.Cursor
        public float getFloat(int columnIndex) {
            return this.mDelegate.getFloat(columnIndex);
        }

        @Override // android.database.Cursor
        public int getInt(int columnIndex) {
            return this.mDelegate.getInt(columnIndex);
        }

        @Override // android.database.Cursor
        public long getLong(int columnIndex) {
            return this.mDelegate.getLong(columnIndex);
        }

        @Override // android.database.Cursor
        @RequiresApi(api = 19)
        @SuppressLint({"UnsafeNewApiCall"})
        public Uri getNotificationUri() {
            return this.mDelegate.getNotificationUri();
        }

        @Override // android.database.Cursor
        @Nullable
        @RequiresApi(api = 29)
        @SuppressLint({"UnsafeNewApiCall"})
        public List<Uri> getNotificationUris() {
            return this.mDelegate.getNotificationUris();
        }

        @Override // android.database.Cursor
        public int getPosition() {
            return this.mDelegate.getPosition();
        }

        @Override // android.database.Cursor
        public short getShort(int columnIndex) {
            return this.mDelegate.getShort(columnIndex);
        }

        @Override // android.database.Cursor
        public String getString(int columnIndex) {
            return this.mDelegate.getString(columnIndex);
        }

        @Override // android.database.Cursor
        public int getType(int columnIndex) {
            return this.mDelegate.getType(columnIndex);
        }

        @Override // android.database.Cursor
        public boolean getWantsAllOnMoveCalls() {
            return this.mDelegate.getWantsAllOnMoveCalls();
        }

        @Override // android.database.Cursor
        public boolean isAfterLast() {
            return this.mDelegate.isAfterLast();
        }

        @Override // android.database.Cursor
        public boolean isBeforeFirst() {
            return this.mDelegate.isBeforeFirst();
        }

        @Override // android.database.Cursor
        public boolean isClosed() {
            return this.mDelegate.isClosed();
        }

        @Override // android.database.Cursor
        public boolean isFirst() {
            return this.mDelegate.isFirst();
        }

        @Override // android.database.Cursor
        public boolean isLast() {
            return this.mDelegate.isLast();
        }

        @Override // android.database.Cursor
        public boolean isNull(int columnIndex) {
            return this.mDelegate.isNull(columnIndex);
        }

        @Override // android.database.Cursor
        public boolean move(int offset) {
            return this.mDelegate.move(offset);
        }

        @Override // android.database.Cursor
        public boolean moveToFirst() {
            return this.mDelegate.moveToFirst();
        }

        @Override // android.database.Cursor
        public boolean moveToLast() {
            return this.mDelegate.moveToLast();
        }

        @Override // android.database.Cursor
        public boolean moveToNext() {
            return this.mDelegate.moveToNext();
        }

        @Override // android.database.Cursor
        public boolean moveToPosition(int position) {
            return this.mDelegate.moveToPosition(position);
        }

        @Override // android.database.Cursor
        public boolean moveToPrevious() {
            return this.mDelegate.moveToPrevious();
        }

        @Override // android.database.Cursor
        public void registerContentObserver(ContentObserver observer) {
            this.mDelegate.registerContentObserver(observer);
        }

        @Override // android.database.Cursor
        public void registerDataSetObserver(DataSetObserver observer) {
            this.mDelegate.registerDataSetObserver(observer);
        }

        @Override // android.database.Cursor
        @Deprecated
        public boolean requery() {
            return this.mDelegate.requery();
        }

        @Override // android.database.Cursor
        public Bundle respond(Bundle extras) {
            return this.mDelegate.respond(extras);
        }

        @Override // android.database.Cursor
        @RequiresApi(api = 23)
        @SuppressLint({"UnsafeNewApiCall"})
        public void setExtras(Bundle extras) {
            this.mDelegate.setExtras(extras);
        }

        @Override // android.database.Cursor
        public void setNotificationUri(ContentResolver cr, Uri uri) {
            this.mDelegate.setNotificationUri(cr, uri);
        }

        @Override // android.database.Cursor
        @RequiresApi(api = 29)
        @SuppressLint({"UnsafeNewApiCall"})
        public void setNotificationUris(@NonNull ContentResolver cr, @NonNull List<Uri> uris) {
            this.mDelegate.setNotificationUris(cr, uris);
        }

        @Override // android.database.Cursor
        public void unregisterContentObserver(ContentObserver observer) {
            this.mDelegate.unregisterContentObserver(observer);
        }

        @Override // android.database.Cursor
        public void unregisterDataSetObserver(DataSetObserver observer) {
            this.mDelegate.unregisterDataSetObserver(observer);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoClosingRoomOpenHelper(@NonNull SupportSQLiteOpenHelper supportSQLiteOpenHelper, @NonNull AutoCloser autoCloser) {
        this.mDelegateOpenHelper = supportSQLiteOpenHelper;
        this.mAutoCloser = autoCloser;
        autoCloser.init(supportSQLiteOpenHelper);
        this.mAutoClosingDb = new AutoClosingSupportSQLiteDatabase(autoCloser);
    }

    @Override // androidx.sqlite.p021db.SupportSQLiteOpenHelper, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            this.mAutoClosingDb.close();
        } catch (IOException e) {
            SneakyThrow.reThrow(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public AutoCloser getAutoCloser() {
        return this.mAutoCloser;
    }

    @NonNull
    SupportSQLiteDatabase getAutoClosingDb() {
        return this.mAutoClosingDb;
    }

    @Override // androidx.sqlite.p021db.SupportSQLiteOpenHelper
    @Nullable
    public String getDatabaseName() {
        return this.mDelegateOpenHelper.getDatabaseName();
    }

    @Override // androidx.room.DelegatingOpenHelper
    @NonNull
    public SupportSQLiteOpenHelper getDelegate() {
        return this.mDelegateOpenHelper;
    }

    @Override // androidx.sqlite.p021db.SupportSQLiteOpenHelper
    @NonNull
    @RequiresApi(api = 24)
    public SupportSQLiteDatabase getReadableDatabase() {
        this.mAutoClosingDb.pokeOpen();
        return this.mAutoClosingDb;
    }

    @Override // androidx.sqlite.p021db.SupportSQLiteOpenHelper
    @NonNull
    @RequiresApi(api = 24)
    public SupportSQLiteDatabase getWritableDatabase() {
        this.mAutoClosingDb.pokeOpen();
        return this.mAutoClosingDb;
    }

    @Override // androidx.sqlite.p021db.SupportSQLiteOpenHelper
    @RequiresApi(api = 16)
    public void setWriteAheadLoggingEnabled(boolean enabled) {
        this.mDelegateOpenHelper.setWriteAheadLoggingEnabled(enabled);
    }
}

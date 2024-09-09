package net.sqlcipher.database;

import android.content.ContentValues;
import android.content.Context;
import android.os.CancellationSignal;
import android.os.Debug;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteQuery;
import com.bykv.vk.component.ttvideo.player.C;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Pattern;
import java.util.zip.ZipInputStream;
import net.sqlcipher.CrossProcessCursorWrapper;
import net.sqlcipher.Cursor;
import net.sqlcipher.CursorWrapper;
import net.sqlcipher.DatabaseErrorHandler;
import net.sqlcipher.DatabaseUtils;
import net.sqlcipher.SQLException;
import net.sqlcipher.database.SQLiteDebug;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class SQLiteDatabase extends SQLiteClosable implements SupportSQLiteDatabase {
    private static final String COMMIT_SQL = "COMMIT;";
    public static final int CONFLICT_ABORT = 2;
    public static final int CONFLICT_FAIL = 3;
    public static final int CONFLICT_IGNORE = 4;
    public static final int CONFLICT_NONE = 0;
    public static final int CONFLICT_REPLACE = 5;
    public static final int CONFLICT_ROLLBACK = 1;
    public static final int CREATE_IF_NECESSARY = 268435456;
    private static final int EVENT_DB_CORRUPT = 75004;
    private static final int EVENT_DB_OPERATION = 52000;
    static final String GET_LOCK_LOG_PREFIX = "GETLOCK:";
    private static final String KEY_ENCODING = "UTF-8";
    private static final int LOCK_ACQUIRED_WARNING_THREAD_TIME_IN_MS = 100;
    private static final int LOCK_ACQUIRED_WARNING_TIME_IN_MS = 300;
    private static final int LOCK_ACQUIRED_WARNING_TIME_IN_MS_ALWAYS_PRINT = 2000;
    private static final int LOCK_WARNING_WINDOW_IN_MS = 20000;
    private static final String LOG_SLOW_QUERIES_PROPERTY = "db.log.slow_query_threshold";
    public static final int MAX_SQL_CACHE_SIZE = 250;
    private static final int MAX_WARNINGS_ON_CACHESIZE_CONDITION = 1;
    public static final String MEMORY = ":memory:";
    public static final int NO_LOCALIZED_COLLATORS = 16;
    public static final int OPEN_READONLY = 1;
    public static final int OPEN_READWRITE = 0;
    private static final int OPEN_READ_MASK = 1;
    private static final int QUERY_LOG_SQL_LENGTH = 64;
    private static final int SLEEP_AFTER_YIELD_QUANTUM = 1000;
    public static final String SQLCIPHER_ANDROID_VERSION = "4.4.3";
    public static final int SQLITE_MAX_LIKE_PATTERN_LENGTH = 50000;
    private static final String TAG = "Database";
    private int mCacheFullWarnings;
    Map<String, SQLiteCompiledSql> mCompiledQueries;
    private final DatabaseErrorHandler mErrorHandler;
    private CursorFactory mFactory;
    private int mFlags;
    private boolean mInnerTransactionIsSuccessful;
    private long mLastLockMessageTime;
    private String mLastSqlStatement;
    private final ReentrantLock mLock;
    private long mLockAcquiredThreadTime;
    private long mLockAcquiredWallTime;
    private boolean mLockingEnabled;
    private int mMaxSqlCacheSize;
    long mNativeHandle;
    private int mNumCacheHits;
    private int mNumCacheMisses;
    private String mPath;
    private String mPathForLogs;
    private WeakHashMap<SQLiteClosable, Object> mPrograms;
    private final int mSlowQueryThreshold;
    private Throwable mStackTrace;
    private final Map<String, SyncUpdateInfo> mSyncUpdateInfo;
    int mTempTableSequence;
    private String mTimeClosed;
    private String mTimeOpened;
    private boolean mTransactionIsSuccessful;
    private SQLiteTransactionListener mTransactionListener;
    private static WeakHashMap<SQLiteDatabase, Object> sActiveDatabases = new WeakHashMap<>();
    private static final String[] CONFLICT_VALUES = {"", " OR ROLLBACK ", " OR ABORT ", " OR FAIL ", " OR IGNORE ", " OR REPLACE "};
    private static final Pattern EMAIL_IN_DB_PATTERN = Pattern.compile("[\\w\\.\\-]+@[\\w\\.\\-]+");
    private static int sQueryLogTimeInMillis = 0;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public interface CursorFactory {
        Cursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery);
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public interface LibraryLoader {
        void loadLibraries(String... strArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public enum SQLiteDatabaseTransactionType {
        Deferred,
        Immediate,
        Exclusive
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static class SyncUpdateInfo {
        String deletedTable;
        String foreignKey;
        String masterTable;

        SyncUpdateInfo(String str, String str2, String str3) {
            this.masterTable = str;
            this.deletedTable = str2;
            this.foreignKey = str3;
        }
    }

    public SQLiteDatabase(String str, char[] cArr, CursorFactory cursorFactory, int i4) {
        this(str, cursorFactory, i4, (DatabaseErrorHandler) null);
        openDatabaseInternal(cArr, (SQLiteDatabaseHook) null);
    }

    private void beginTransactionWithListenerInternal(SQLiteTransactionListener sQLiteTransactionListener, SQLiteDatabaseTransactionType sQLiteDatabaseTransactionType) {
        lockForced();
        if (isOpen()) {
            try {
                if (this.mLock.getHoldCount() > 1) {
                    if (this.mInnerTransactionIsSuccessful) {
                        throw new IllegalStateException("Cannot call beginTransaction between calling setTransactionSuccessful and endTransaction");
                    }
                    return;
                }
                if (sQLiteDatabaseTransactionType == SQLiteDatabaseTransactionType.Exclusive) {
                    execSQL("BEGIN EXCLUSIVE;");
                } else if (sQLiteDatabaseTransactionType == SQLiteDatabaseTransactionType.Immediate) {
                    execSQL("BEGIN IMMEDIATE;");
                } else if (sQLiteDatabaseTransactionType == SQLiteDatabaseTransactionType.Deferred) {
                    execSQL("BEGIN DEFERRED;");
                } else {
                    throw new IllegalArgumentException(String.format("%s is an unsupported transaction type", sQLiteDatabaseTransactionType));
                }
                this.mTransactionListener = sQLiteTransactionListener;
                this.mTransactionIsSuccessful = true;
                this.mInnerTransactionIsSuccessful = false;
                if (sQLiteTransactionListener != null) {
                    try {
                        sQLiteTransactionListener.onBegin();
                        return;
                    } catch (RuntimeException e4) {
                        execSQL("ROLLBACK;");
                        throw e4;
                    }
                }
                return;
            } catch (Throwable th) {
                unlockForced();
                throw th;
            }
        }
        throw new IllegalStateException("database not open");
    }

    private void checkLockHoldTime() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j4 = elapsedRealtime - this.mLockAcquiredWallTime;
        if ((j4 >= 2000 || Log.isLoggable("Database", 2) || elapsedRealtime - this.mLastLockMessageTime >= 20000) && j4 > 300) {
            if (((int) ((Debug.threadCpuTimeNanos() - this.mLockAcquiredThreadTime) / C.MICROS_PER_SECOND)) > 100 || j4 > 2000) {
                this.mLastLockMessageTime = elapsedRealtime;
                boolean z3 = SQLiteDebug.DEBUG_LOCK_TIME_TRACKING_STACK_TRACE;
            }
        }
    }

    private void closeClosable() {
        deallocCachedSqlStatements();
        for (Map.Entry<SQLiteClosable, Object> entry : this.mPrograms.entrySet()) {
            SQLiteClosable key = entry.getKey();
            if (key != null) {
                key.onAllReferencesReleasedFromContainer();
            }
        }
    }

    private boolean containsNull(char[] cArr) {
        if (cArr == null || cArr.length <= 0) {
            return false;
        }
        for (char c4 : cArr) {
            if (c4 == 0) {
                return true;
            }
        }
        return false;
    }

    public static SQLiteDatabase create(CursorFactory cursorFactory, String str) {
        return openDatabase(":memory:", str == null ? null : str.toCharArray(), cursorFactory, 268435456);
    }

    private native void dbclose();

    private native void dbopen(String str, int i4);

    private void deallocCachedSqlStatements() {
        synchronized (this.mCompiledQueries) {
            for (SQLiteCompiledSql sQLiteCompiledSql : this.mCompiledQueries.values()) {
                sQLiteCompiledSql.releaseSqlStatement();
            }
            this.mCompiledQueries.clear();
        }
    }

    private native void enableSqlProfiling(String str);

    private native void enableSqlTracing(String str);

    public static String findEditTable(String str) {
        if (!TextUtils.isEmpty(str)) {
            int indexOf = str.indexOf(32);
            int indexOf2 = str.indexOf(44);
            if (indexOf <= 0 || (indexOf >= indexOf2 && indexOf2 >= 0)) {
                return indexOf2 > 0 ? (indexOf2 < indexOf || indexOf < 0) ? str.substring(0, indexOf2) : str : str;
            }
            return str.substring(0, indexOf);
        }
        throw new IllegalStateException("Invalid tables");
    }

    private static ArrayList<SQLiteDatabase> getActiveDatabases() {
        ArrayList<SQLiteDatabase> arrayList = new ArrayList<>();
        synchronized (sActiveDatabases) {
            arrayList.addAll(sActiveDatabases.keySet());
        }
        return arrayList;
    }

    public static byte[] getBytes(char[] cArr) {
        if (cArr == null || cArr.length == 0) {
            return null;
        }
        ByteBuffer encode = Charset.forName("UTF-8").encode(CharBuffer.wrap(cArr));
        byte[] bArr = new byte[encode.limit()];
        encode.get(bArr);
        return bArr;
    }

    public static char[] getChars(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        CharBuffer decode = Charset.forName("UTF-8").decode(ByteBuffer.wrap(bArr));
        char[] cArr = new char[decode.limit()];
        decode.get(cArr);
        return cArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ArrayList<SQLiteDebug.DbStats> getDbStats() {
        String str;
        ArrayList<SQLiteDebug.DbStats> arrayList = new ArrayList<>();
        Iterator<SQLiteDatabase> it = getActiveDatabases().iterator();
        while (it.hasNext()) {
            SQLiteDatabase next = it.next();
            if (next != null && next.isOpen()) {
                int native_getDbLookaside = next.native_getDbLookaside();
                String path = next.getPath();
                int lastIndexOf = path.lastIndexOf(TTPathConst.sSeparator);
                String substring = path.substring(lastIndexOf != -1 ? lastIndexOf + 1 : 0);
                ArrayList<Pair<String, String>> attachedDbs = getAttachedDbs(next);
                if (attachedDbs != null) {
                    for (int i4 = 0; i4 < attachedDbs.size(); i4++) {
                        Pair<String, String> pair = attachedDbs.get(i4);
                        long pragmaVal = getPragmaVal(next, ((String) pair.first) + ".page_count;");
                        if (i4 == 0) {
                            str = substring;
                        } else {
                            String str2 = "  (attached) " + ((String) pair.first);
                            if (((String) pair.second).trim().length() > 0) {
                                int lastIndexOf2 = ((String) pair.second).lastIndexOf(TTPathConst.sSeparator);
                                StringBuilder sb = new StringBuilder();
                                sb.append(str2);
                                sb.append(" : ");
                                sb.append(((String) pair.second).substring(lastIndexOf2 != -1 ? lastIndexOf2 + 1 : 0));
                                str2 = sb.toString();
                            }
                            str = str2;
                            native_getDbLookaside = 0;
                        }
                        if (pragmaVal > 0) {
                            arrayList.add(new SQLiteDebug.DbStats(str, pragmaVal, next.getPageSize(), native_getDbLookaside));
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    private String getPathForLogs() {
        String str = this.mPathForLogs;
        if (str != null) {
            return str;
        }
        String str2 = this.mPath;
        if (str2 == null) {
            return null;
        }
        if (str2.indexOf(64) == -1) {
            this.mPathForLogs = this.mPath;
        } else {
            this.mPathForLogs = EMAIL_IN_DB_PATTERN.matcher(this.mPath).replaceAll("XX@YY");
        }
        return this.mPathForLogs;
    }

    private static long getPragmaVal(SQLiteDatabase sQLiteDatabase, String str) {
        SQLiteStatement sQLiteStatement;
        if (sQLiteDatabase.isOpen()) {
            SQLiteStatement sQLiteStatement2 = null;
            try {
                sQLiteStatement = new SQLiteStatement(sQLiteDatabase, "PRAGMA " + str);
            } catch (Throwable th) {
                th = th;
            }
            try {
                long simpleQueryForLong = sQLiteStatement.simpleQueryForLong();
                sQLiteStatement.close();
                return simpleQueryForLong;
            } catch (Throwable th2) {
                th = th2;
                sQLiteStatement2 = sQLiteStatement;
                if (sQLiteStatement2 != null) {
                    sQLiteStatement2.close();
                }
                throw th;
            }
        }
        return 0L;
    }

    private Pair<Boolean, String> getResultFromPragma(String str) {
        Cursor rawQuery = rawQuery(str, new Object[0]);
        if (rawQuery == null) {
            return new Pair<>(Boolean.FALSE, "");
        }
        rawQuery.moveToFirst();
        String string = rawQuery.getString(0);
        rawQuery.close();
        return new Pair<>(Boolean.TRUE, string);
    }

    private String getTime() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS ", Locale.US).format(Long.valueOf(System.currentTimeMillis()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public native void key(byte[] bArr) throws SQLException;

    private void keyDatabase(SQLiteDatabaseHook sQLiteDatabaseHook, Runnable runnable) {
        if (sQLiteDatabaseHook != null) {
            sQLiteDatabaseHook.preKey(this);
        }
        if (runnable != null) {
            runnable.run();
        }
        if (sQLiteDatabaseHook != null) {
            sQLiteDatabaseHook.postKey(this);
        }
        if (SQLiteDebug.DEBUG_SQL_CACHE) {
            this.mTimeOpened = getTime();
        }
        try {
            Cursor rawQuery = rawQuery("select count(*) from sqlite_master;", new String[0]);
            if (rawQuery != null) {
                rawQuery.moveToFirst();
                rawQuery.getInt(0);
                rawQuery.close();
            }
        } catch (RuntimeException e4) {
            throw e4;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public native void key_mutf8(char[] cArr) throws SQLException;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v3 */
    private static void loadICUData(Context context, File file) {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2;
        File file2 = new File(file, "icu");
        File file3 = new File(file2, "icudt46l.dat");
        ZipInputStream zipInputStream = null;
        try {
            try {
                if (!file2.exists()) {
                    file2.mkdirs();
                }
                if (file3.exists()) {
                    fileOutputStream2 = null;
                } else {
                    ZipInputStream zipInputStream2 = new ZipInputStream(context.getAssets().open("icudt46l.zip"));
                    try {
                        zipInputStream2.getNextEntry();
                        fileOutputStream2 = new FileOutputStream(file3);
                        try {
                            byte[] bArr = new byte[1024];
                            while (true) {
                                int read = zipInputStream2.read(bArr);
                                if (read <= 0) {
                                    break;
                                }
                                fileOutputStream2.write(bArr, 0, read);
                            }
                            zipInputStream = zipInputStream2;
                        } catch (Exception e4) {
                            e = e4;
                            if (file3.exists()) {
                                file3.delete();
                            }
                            throw new RuntimeException(e);
                        } catch (Throwable th) {
                            zipInputStream = zipInputStream2;
                            fileOutputStream = fileOutputStream2;
                            th = th;
                            if (zipInputStream != null) {
                                try {
                                    zipInputStream.close();
                                } catch (IOException e5) {
                                    throw new RuntimeException(e5);
                                }
                            }
                            if (fileOutputStream != null) {
                                fileOutputStream.flush();
                                fileOutputStream.close();
                            }
                            throw th;
                        }
                    } catch (Exception e6) {
                        e = e6;
                    }
                }
                if (zipInputStream != null) {
                    try {
                        zipInputStream.close();
                    } catch (IOException e7) {
                        throw new RuntimeException(e7);
                    }
                }
                if (fileOutputStream2 != null) {
                    fileOutputStream2.flush();
                    fileOutputStream2.close();
                }
            } catch (Exception e8) {
                e = e8;
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = null;
            }
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
            zipInputStream = file2;
        }
    }

    public static synchronized void loadLibs(Context context) {
        synchronized (SQLiteDatabase.class) {
            loadLibs(context, context.getFilesDir());
        }
    }

    private void lockForced() {
        this.mLock.lock();
        if (SQLiteDebug.DEBUG_LOCK_TIME_TRACKING && this.mLock.getHoldCount() == 1) {
            this.mLockAcquiredWallTime = SystemClock.elapsedRealtime();
            this.mLockAcquiredThreadTime = Debug.threadCpuTimeNanos();
        }
    }

    private native int native_getDbLookaside();

    private native void native_rawExecSQL(String str);

    private native int native_status(int i4, boolean z3);

    public static SQLiteDatabase openDatabase(String str, String str2, CursorFactory cursorFactory, int i4) {
        return openDatabase(str, str2, cursorFactory, i4, (SQLiteDatabaseHook) null);
    }

    private void openDatabaseInternal(char[] cArr, SQLiteDatabaseHook sQLiteDatabaseHook) {
        openDatabaseInternal(getBytes(cArr), sQLiteDatabaseHook);
    }

    public static SQLiteDatabase openOrCreateDatabase(File file, String str, CursorFactory cursorFactory, SQLiteDatabaseHook sQLiteDatabaseHook) {
        return openOrCreateDatabase(file, str, cursorFactory, sQLiteDatabaseHook, (DatabaseErrorHandler) null);
    }

    private native void rekey(byte[] bArr) throws SQLException;

    public static native int releaseMemory();

    public static native void setICURoot(String str);

    private void unlockForced() {
        if (SQLiteDebug.DEBUG_LOCK_TIME_TRACKING && this.mLock.getHoldCount() == 1) {
            checkLockHoldTime();
        }
        this.mLock.unlock();
    }

    private boolean yieldIfContendedHelper(boolean z3, long j4) {
        if (this.mLock.getQueueLength() == 0) {
            this.mLockAcquiredWallTime = SystemClock.elapsedRealtime();
            this.mLockAcquiredThreadTime = Debug.threadCpuTimeNanos();
            return false;
        }
        setTransactionSuccessful();
        SQLiteTransactionListener sQLiteTransactionListener = this.mTransactionListener;
        endTransaction();
        if (z3 && isDbLockedByCurrentThread()) {
            throw new IllegalStateException("Db locked more than once. yielfIfContended cannot yield");
        }
        if (j4 > 0) {
            while (j4 > 0) {
                try {
                    Thread.sleep(j4 < 1000 ? j4 : 1000L);
                } catch (InterruptedException unused) {
                    Thread.interrupted();
                }
                j4 -= 1000;
                if (this.mLock.getQueueLength() == 0) {
                    break;
                }
            }
        }
        beginTransactionWithListener(sQLiteTransactionListener);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addSQLiteClosable(SQLiteClosable sQLiteClosable) {
        lock();
        try {
            this.mPrograms.put(sQLiteClosable, null);
        } finally {
            unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addToCompiledQueries(String str, SQLiteCompiledSql sQLiteCompiledSql) {
        if (this.mMaxSqlCacheSize == 0) {
            boolean z3 = SQLiteDebug.DEBUG_SQL_CACHE;
            return;
        }
        synchronized (this.mCompiledQueries) {
            if (this.mCompiledQueries.get(str) != null) {
                return;
            }
            if (this.mCompiledQueries.size() == this.mMaxSqlCacheSize) {
                this.mCacheFullWarnings++;
            } else {
                this.mCompiledQueries.put(str, sQLiteCompiledSql);
                boolean z4 = SQLiteDebug.DEBUG_SQL_CACHE;
            }
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void beginTransaction() {
        beginTransactionWithListener((SQLiteTransactionListener) null);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void beginTransactionNonExclusive() {
        beginTransactionWithListenerInternal(null, SQLiteDatabaseTransactionType.Immediate);
    }

    public void beginTransactionWithListener(SQLiteTransactionListener sQLiteTransactionListener) {
        beginTransactionWithListenerInternal(sQLiteTransactionListener, SQLiteDatabaseTransactionType.Exclusive);
    }

    public void beginTransactionWithListenerNonExclusive(SQLiteTransactionListener sQLiteTransactionListener) {
        beginTransactionWithListenerInternal(sQLiteTransactionListener, SQLiteDatabaseTransactionType.Immediate);
    }

    public void changePassword(String str) throws SQLiteException {
        if (!isOpen()) {
            throw new SQLiteException("database not open");
        }
        if (str != null) {
            byte[] bytes = getBytes(str.toCharArray());
            rekey(bytes);
            Arrays.fill(bytes, (byte) 0);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (isOpen()) {
            lock();
            try {
                closeClosable();
                onAllReferencesReleased();
            } finally {
                unlock();
            }
        }
    }

    public int delete(String str, String str2, String[] strArr) {
        return delete(str, str2, (Object[]) strArr);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void disableWriteAheadLogging() {
        if (!inTransaction()) {
            rawExecSQL("PRAGMA journal_mode = DELETE;");
            return;
        }
        throw new IllegalStateException("Write Ahead Logging cannot be disabled while in a transaction");
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean enableWriteAheadLogging() {
        if (!inTransaction()) {
            ArrayList<Pair<String, String>> attachedDbs = getAttachedDbs(this);
            if ((attachedDbs != null && attachedDbs.size() > 1) || isReadOnly() || getPath().equals(":memory:")) {
                return false;
            }
            rawExecSQL("PRAGMA journal_mode = WAL;");
            return true;
        }
        throw new IllegalStateException("Write Ahead Logging cannot be enabled while in a transaction");
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void endTransaction() {
        if (isOpen()) {
            if (this.mLock.isHeldByCurrentThread()) {
                try {
                    if (this.mInnerTransactionIsSuccessful) {
                        this.mInnerTransactionIsSuccessful = false;
                    } else {
                        this.mTransactionIsSuccessful = false;
                    }
                    if (this.mLock.getHoldCount() != 1) {
                        return;
                    }
                    SQLiteTransactionListener sQLiteTransactionListener = this.mTransactionListener;
                    if (sQLiteTransactionListener != null) {
                        try {
                            if (this.mTransactionIsSuccessful) {
                                sQLiteTransactionListener.onCommit();
                            } else {
                                sQLiteTransactionListener.onRollback();
                            }
                        } catch (RuntimeException e4) {
                            e = e4;
                            this.mTransactionIsSuccessful = false;
                        }
                    }
                    e = null;
                    if (this.mTransactionIsSuccessful) {
                        execSQL("COMMIT;");
                    } else {
                        try {
                            execSQL("ROLLBACK;");
                            if (e != null) {
                                throw e;
                            }
                        } catch (SQLException unused) {
                        }
                    }
                    return;
                } finally {
                    this.mTransactionListener = null;
                    unlockForced();
                }
            }
            throw new IllegalStateException("no transaction pending");
        }
        throw new IllegalStateException("database not open");
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void execSQL(String str) throws SQLException {
        SystemClock.uptimeMillis();
        lock();
        try {
            try {
                if (isOpen()) {
                    native_execSQL(str);
                    return;
                }
                throw new IllegalStateException("database not open");
            } catch (SQLiteDatabaseCorruptException e4) {
                onCorruption();
                throw e4;
            }
        } finally {
            unlock();
        }
    }

    protected void finalize() {
        if (isOpen()) {
            closeClosable();
            onAllReferencesReleased();
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public List<Pair<String, String>> getAttachedDbs() {
        return getAttachedDbs(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SQLiteCompiledSql getCompiledStatementForSql(String str) {
        synchronized (this.mCompiledQueries) {
            if (this.mMaxSqlCacheSize == 0) {
                boolean z3 = SQLiteDebug.DEBUG_SQL_CACHE;
                return null;
            }
            SQLiteCompiledSql sQLiteCompiledSql = this.mCompiledQueries.get(str);
            boolean z4 = sQLiteCompiledSql != null;
            if (z4) {
                this.mNumCacheHits++;
            } else {
                this.mNumCacheMisses++;
            }
            boolean z5 = SQLiteDebug.DEBUG_SQL_CACHE;
            return sQLiteCompiledSql;
        }
    }

    public synchronized int getMaxSqlCacheSize() {
        return this.mMaxSqlCacheSize;
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public long getMaximumSize() {
        SQLiteStatement sQLiteStatement;
        Throwable th;
        lock();
        try {
            if (isOpen()) {
                sQLiteStatement = new SQLiteStatement(this, "PRAGMA max_page_count;");
                try {
                    long simpleQueryForLong = sQLiteStatement.simpleQueryForLong() * getPageSize();
                    sQLiteStatement.close();
                    unlock();
                    return simpleQueryForLong;
                } catch (Throwable th2) {
                    th = th2;
                    if (sQLiteStatement != null) {
                        sQLiteStatement.close();
                    }
                    unlock();
                    throw th;
                }
            }
            throw new IllegalStateException("database not open");
        } catch (Throwable th3) {
            sQLiteStatement = null;
            th = th3;
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public long getPageSize() {
        SQLiteStatement sQLiteStatement;
        Throwable th;
        lock();
        try {
            if (isOpen()) {
                sQLiteStatement = new SQLiteStatement(this, "PRAGMA page_size;");
                try {
                    long simpleQueryForLong = sQLiteStatement.simpleQueryForLong();
                    sQLiteStatement.close();
                    unlock();
                    return simpleQueryForLong;
                } catch (Throwable th2) {
                    th = th2;
                    if (sQLiteStatement != null) {
                        sQLiteStatement.close();
                    }
                    unlock();
                    throw th;
                }
            }
            throw new IllegalStateException("database not open");
        } catch (Throwable th3) {
            sQLiteStatement = null;
            th = th3;
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final String getPath() {
        return this.mPath;
    }

    public SQLiteQueryStats getQueryStats(String str, Object[] objArr) {
        try {
            execSQL(String.format("CREATE TABLE tempstat AS %s", str), objArr);
            Cursor rawQuery = rawQuery("SELECT sum(payload) FROM dbstat WHERE name = 'tempstat';", new Object[0]);
            if (rawQuery == null) {
                return new SQLiteQueryStats(0L, 0L);
            }
            rawQuery.moveToFirst();
            long j4 = rawQuery.getLong(0);
            rawQuery.close();
            Cursor rawQuery2 = rawQuery("SELECT max(mx_payload) FROM dbstat WHERE name = 'tempstat';", new Object[0]);
            if (rawQuery2 == null) {
                return new SQLiteQueryStats(j4, 0L);
            }
            rawQuery2.moveToFirst();
            long j5 = rawQuery2.getLong(0);
            rawQuery2.close();
            execSQL("DROP TABLE tempstat;");
            return new SQLiteQueryStats(j4, j5);
        } catch (SQLiteException e4) {
            execSQL("DROP TABLE IF EXISTS tempstat;");
            throw e4;
        }
    }

    public Map<String, String> getSyncedTables() {
        HashMap hashMap;
        synchronized (this.mSyncUpdateInfo) {
            hashMap = new HashMap();
            for (String str : this.mSyncUpdateInfo.keySet()) {
                String str2 = this.mSyncUpdateInfo.get(str).deletedTable;
                if (str2 != null) {
                    hashMap.put(str, str2);
                }
            }
        }
        return hashMap;
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public int getVersion() {
        SQLiteStatement sQLiteStatement;
        Throwable th;
        lock();
        try {
            if (isOpen()) {
                sQLiteStatement = new SQLiteStatement(this, "PRAGMA user_version;");
                try {
                    int simpleQueryForLong = (int) sQLiteStatement.simpleQueryForLong();
                    sQLiteStatement.close();
                    unlock();
                    return simpleQueryForLong;
                } catch (Throwable th2) {
                    th = th2;
                    if (sQLiteStatement != null) {
                        sQLiteStatement.close();
                    }
                    unlock();
                    throw th;
                }
            }
            throw new IllegalStateException("database not open");
        } catch (Throwable th3) {
            sQLiteStatement = null;
            th = th3;
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean inTransaction() {
        return this.mLock.getHoldCount() > 0;
    }

    public long insert(String str, String str2, ContentValues contentValues) {
        try {
            return insertWithOnConflict(str, str2, contentValues, 0);
        } catch (SQLException unused) {
            return -1L;
        }
    }

    public long insertOrThrow(String str, String str2, ContentValues contentValues) throws SQLException {
        return insertWithOnConflict(str, str2, contentValues, 0);
    }

    public long insertWithOnConflict(String str, String str2, ContentValues contentValues, int i4) {
        Set<Map.Entry<String, Object>> set;
        if (isOpen()) {
            StringBuilder sb = new StringBuilder(152);
            sb.append("INSERT");
            sb.append(CONFLICT_VALUES[i4]);
            sb.append(" INTO ");
            sb.append(str);
            StringBuilder sb2 = new StringBuilder(40);
            int i5 = 0;
            SQLiteStatement sQLiteStatement = null;
            if (contentValues != null && contentValues.size() > 0) {
                set = contentValues.valueSet();
                sb.append('(');
                boolean z3 = false;
                for (Map.Entry<String, Object> entry : set) {
                    if (z3) {
                        sb.append(", ");
                        sb2.append(", ");
                    }
                    sb.append(entry.getKey());
                    sb2.append('?');
                    z3 = true;
                }
                sb.append(')');
            } else {
                sb.append("(" + str2 + ") ");
                sb2.append("NULL");
                set = null;
            }
            sb.append(" VALUES(");
            sb.append((CharSequence) sb2);
            sb.append(");");
            lock();
            try {
                try {
                    sQLiteStatement = compileStatement(sb.toString());
                    if (set != null) {
                        int size = set.size();
                        Iterator<Map.Entry<String, Object>> it = set.iterator();
                        while (i5 < size) {
                            i5++;
                            DatabaseUtils.bindObjectToProgram(sQLiteStatement, i5, it.next().getValue());
                        }
                    }
                    sQLiteStatement.execute();
                    long lastInsertRow = lastChangeCount() > 0 ? lastInsertRow() : -1L;
                    sQLiteStatement.close();
                    unlock();
                    return lastInsertRow;
                } catch (SQLiteDatabaseCorruptException e4) {
                    onCorruption();
                    throw e4;
                }
            } catch (Throwable th) {
                if (sQLiteStatement != null) {
                    sQLiteStatement.close();
                }
                unlock();
                throw th;
            }
        }
        throw new IllegalStateException("database not open");
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean isDatabaseIntegrityOk() {
        Pair<Boolean, String> resultFromPragma = getResultFromPragma("PRAGMA integrity_check;");
        return ((Boolean) resultFromPragma.first).booleanValue() ? ((String) resultFromPragma.second).equals("ok") : ((Boolean) resultFromPragma.first).booleanValue();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean isDbLockedByCurrentThread() {
        return this.mLock.isHeldByCurrentThread();
    }

    public boolean isDbLockedByOtherThreads() {
        return !this.mLock.isHeldByCurrentThread() && this.mLock.isLocked();
    }

    public boolean isInCompiledSqlCache(String str) {
        boolean containsKey;
        synchronized (this.mCompiledQueries) {
            containsKey = this.mCompiledQueries.containsKey(str);
        }
        return containsKey;
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean isOpen() {
        return this.mNativeHandle != 0;
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean isReadOnly() {
        return (this.mFlags & 1) == 1;
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean isWriteAheadLoggingEnabled() {
        Pair<Boolean, String> resultFromPragma = getResultFromPragma("PRAGMA journal_mode;");
        return ((Boolean) resultFromPragma.first).booleanValue() ? ((String) resultFromPragma.second).equals("wal") : ((Boolean) resultFromPragma.first).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public native int lastChangeCount();

    /* JADX INFO: Access modifiers changed from: package-private */
    public native long lastInsertRow();

    /* JADX INFO: Access modifiers changed from: package-private */
    public void lock() {
        if (this.mLockingEnabled) {
            this.mLock.lock();
            if (SQLiteDebug.DEBUG_LOCK_TIME_TRACKING && this.mLock.getHoldCount() == 1) {
                this.mLockAcquiredWallTime = SystemClock.elapsedRealtime();
                this.mLockAcquiredThreadTime = Debug.threadCpuTimeNanos();
            }
        }
    }

    public void markTableSyncable(String str, String str2) {
        if (isOpen()) {
            markTableSyncable(str, "_id", str, str2);
            return;
        }
        throw new SQLiteException("database not open");
    }

    native void native_execSQL(String str) throws SQLException;

    native void native_setLocale(String str, int i4);

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean needUpgrade(int i4) {
        return i4 > getVersion();
    }

    @Override // net.sqlcipher.database.SQLiteClosable
    protected void onAllReferencesReleased() {
        if (isOpen()) {
            if (SQLiteDebug.DEBUG_SQL_CACHE) {
                this.mTimeClosed = getTime();
            }
            dbclose();
            synchronized (sActiveDatabases) {
                sActiveDatabases.remove(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onCorruption() {
        this.mErrorHandler.onCorruption(this);
    }

    public void purgeFromCompiledSqlCache(String str) {
        synchronized (this.mCompiledQueries) {
            this.mCompiledQueries.remove(str);
        }
    }

    public Cursor query(boolean z3, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6) {
        return queryWithFactory(null, z3, str, strArr, str2, strArr2, str3, str4, str5, str6);
    }

    public Cursor queryWithFactory(CursorFactory cursorFactory, boolean z3, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6) {
        if (isOpen()) {
            return rawQueryWithFactory(cursorFactory, SQLiteQueryBuilder.buildQueryString(z3, str, strArr, str2, str3, str4, str5, str6), strArr2, findEditTable(str));
        }
        throw new IllegalStateException("database not open");
    }

    public void rawExecSQL(String str) {
        SystemClock.uptimeMillis();
        lock();
        try {
            try {
                if (isOpen()) {
                    native_rawExecSQL(str);
                    return;
                }
                throw new IllegalStateException("database not open");
            } catch (SQLiteDatabaseCorruptException e4) {
                onCorruption();
                throw e4;
            }
        } finally {
            unlock();
        }
    }

    public Cursor rawQuery(String str, String[] strArr) {
        return rawQueryWithFactory(null, str, strArr, null);
    }

    /* JADX WARN: Finally extract failed */
    public Cursor rawQueryWithFactory(CursorFactory cursorFactory, String str, String[] strArr, String str2) {
        if (isOpen()) {
            long currentTimeMillis = this.mSlowQueryThreshold != -1 ? System.currentTimeMillis() : 0L;
            SQLiteDirectCursorDriver sQLiteDirectCursorDriver = new SQLiteDirectCursorDriver(this, str, str2);
            if (cursorFactory == null) {
                try {
                    cursorFactory = this.mFactory;
                } catch (Throwable th) {
                    if (this.mSlowQueryThreshold != -1) {
                        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                        if (currentTimeMillis2 >= this.mSlowQueryThreshold) {
                            Log.v("Database", "query (" + currentTimeMillis2 + " ms): " + sQLiteDirectCursorDriver.toString() + ", args are <redacted>, count is -1");
                        }
                    }
                    throw th;
                }
            }
            Cursor query = sQLiteDirectCursorDriver.query(cursorFactory, strArr);
            if (this.mSlowQueryThreshold != -1) {
                int count = query != null ? query.getCount() : -1;
                long currentTimeMillis3 = System.currentTimeMillis() - currentTimeMillis;
                if (currentTimeMillis3 >= this.mSlowQueryThreshold) {
                    Log.v("Database", "query (" + currentTimeMillis3 + " ms): " + sQLiteDirectCursorDriver.toString() + ", args are <redacted>, count is " + count);
                }
            }
            return new CrossProcessCursorWrapper(query);
        }
        throw new IllegalStateException("database not open");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void removeSQLiteClosable(SQLiteClosable sQLiteClosable) {
        lock();
        try {
            this.mPrograms.remove(sQLiteClosable);
        } finally {
            unlock();
        }
    }

    public long replace(String str, String str2, ContentValues contentValues) {
        try {
            return insertWithOnConflict(str, str2, contentValues, 5);
        } catch (SQLException unused) {
            return -1L;
        }
    }

    public long replaceOrThrow(String str, String str2, ContentValues contentValues) throws SQLException {
        return insertWithOnConflict(str, str2, contentValues, 5);
    }

    public void resetCompiledSqlCache() {
        synchronized (this.mCompiledQueries) {
            this.mCompiledQueries.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void rowUpdated(String str, long j4) {
        SyncUpdateInfo syncUpdateInfo;
        synchronized (this.mSyncUpdateInfo) {
            syncUpdateInfo = this.mSyncUpdateInfo.get(str);
        }
        if (syncUpdateInfo != null) {
            execSQL("UPDATE " + syncUpdateInfo.masterTable + " SET _sync_dirty=1 WHERE _id=(SELECT " + syncUpdateInfo.foreignKey + " FROM " + str + " WHERE _id=" + j4 + ")");
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void setForeignKeyConstraintsEnabled(boolean z3) {
        if (!inTransaction()) {
            Object[] objArr = new Object[1];
            objArr[0] = z3 ? "ON" : "OFF";
            execSQL(String.format("PRAGMA foreign_keys = %s;", objArr));
            return;
        }
        throw new IllegalStateException("Foreign key constraints may not be changed while in a transaction");
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void setLocale(Locale locale) {
        lock();
        try {
            native_setLocale(locale.toString(), this.mFlags);
        } finally {
            unlock();
        }
    }

    public void setLockingEnabled(boolean z3) {
        this.mLockingEnabled = z3;
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public synchronized void setMaxSqlCacheSize(int i4) {
        if (i4 <= 250 && i4 >= 0) {
            if (i4 >= this.mMaxSqlCacheSize) {
                this.mMaxSqlCacheSize = i4;
            } else {
                throw new IllegalStateException("cannot set cacheSize to a value less than the value set with previous setMaxSqlCacheSize() call.");
            }
        } else {
            throw new IllegalStateException("expected value between 0 and 250");
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public long setMaximumSize(long j4) {
        lock();
        SQLiteStatement sQLiteStatement = null;
        try {
            if (isOpen()) {
                long pageSize = getPageSize();
                long j5 = j4 / pageSize;
                if (j4 % pageSize != 0) {
                    j5++;
                }
                SQLiteStatement sQLiteStatement2 = new SQLiteStatement(this, "PRAGMA max_page_count = " + j5);
                try {
                    long simpleQueryForLong = sQLiteStatement2.simpleQueryForLong() * pageSize;
                    sQLiteStatement2.close();
                    unlock();
                    return simpleQueryForLong;
                } catch (Throwable th) {
                    th = th;
                    sQLiteStatement = sQLiteStatement2;
                    if (sQLiteStatement != null) {
                        sQLiteStatement.close();
                    }
                    unlock();
                    throw th;
                }
            }
            throw new IllegalStateException("database not open");
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void setPageSize(long j4) {
        execSQL("PRAGMA page_size = " + j4);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void setTransactionSuccessful() {
        if (isOpen()) {
            if (this.mLock.isHeldByCurrentThread()) {
                if (!this.mInnerTransactionIsSuccessful) {
                    this.mInnerTransactionIsSuccessful = true;
                    return;
                }
                throw new IllegalStateException("setTransactionSuccessful may only be called once per call to beginTransaction");
            }
            throw new IllegalStateException("no transaction pending");
        }
        throw new IllegalStateException("database not open");
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void setVersion(int i4) {
        execSQL("PRAGMA user_version = " + i4);
    }

    public int status(int i4, boolean z3) {
        return native_status(i4, z3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void unlock() {
        if (this.mLockingEnabled) {
            if (SQLiteDebug.DEBUG_LOCK_TIME_TRACKING && this.mLock.getHoldCount() == 1) {
                checkLockHoldTime();
            }
            this.mLock.unlock();
        }
    }

    public int update(String str, ContentValues contentValues, String str2, String[] strArr) {
        return updateWithOnConflict(str, contentValues, str2, strArr, 0);
    }

    public int updateWithOnConflict(String str, ContentValues contentValues, String str2, String[] strArr, int i4) {
        if (contentValues != null && contentValues.size() != 0) {
            StringBuilder sb = new StringBuilder(120);
            sb.append("UPDATE ");
            sb.append(CONFLICT_VALUES[i4]);
            sb.append(str);
            sb.append(" SET ");
            Set<Map.Entry<String, Object>> valueSet = contentValues.valueSet();
            Iterator<Map.Entry<String, Object>> it = valueSet.iterator();
            while (it.hasNext()) {
                sb.append(it.next().getKey());
                sb.append("=?");
                if (it.hasNext()) {
                    sb.append(", ");
                }
            }
            if (!TextUtils.isEmpty(str2)) {
                sb.append(" WHERE ");
                sb.append(str2);
            }
            AutoCloseable autoCloseable = null;
            lock();
            try {
                try {
                    try {
                        if (isOpen()) {
                            SQLiteStatement compileStatement = compileStatement(sb.toString());
                            int size = valueSet.size();
                            Iterator<Map.Entry<String, Object>> it2 = valueSet.iterator();
                            int i5 = 1;
                            for (int i6 = 0; i6 < size; i6++) {
                                DatabaseUtils.bindObjectToProgram(compileStatement, i5, it2.next().getValue());
                                i5++;
                            }
                            if (strArr != null) {
                                for (String str3 : strArr) {
                                    compileStatement.bindString(i5, str3);
                                    i5++;
                                }
                            }
                            compileStatement.execute();
                            int lastChangeCount = lastChangeCount();
                            compileStatement.close();
                            unlock();
                            return lastChangeCount;
                        }
                        throw new IllegalStateException("database not open");
                    } catch (SQLiteDatabaseCorruptException e4) {
                        onCorruption();
                        throw e4;
                    }
                } catch (SQLException e5) {
                    throw e5;
                }
            } catch (Throwable th) {
                if (0 != 0) {
                    autoCloseable.close();
                }
                unlock();
                throw th;
            }
        }
        throw new IllegalArgumentException("Empty values");
    }

    @Deprecated
    public boolean yieldIfContended() {
        if (isOpen()) {
            return yieldIfContendedHelper(false, -1L);
        }
        return false;
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean yieldIfContendedSafely() {
        if (isOpen()) {
            return yieldIfContendedHelper(true, -1L);
        }
        return false;
    }

    public static SQLiteDatabase create(CursorFactory cursorFactory, char[] cArr) {
        return openDatabase(":memory:", cArr, cursorFactory, 268435456);
    }

    private static ArrayList<Pair<String, String>> getAttachedDbs(SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase.isOpen()) {
            ArrayList<Pair<String, String>> arrayList = new ArrayList<>();
            Cursor rawQuery = sQLiteDatabase.rawQuery("pragma database_list;", (String[]) null);
            while (rawQuery.moveToNext()) {
                arrayList.add(new Pair<>(rawQuery.getString(1), rawQuery.getString(2)));
            }
            rawQuery.close();
            return arrayList;
        }
        return null;
    }

    public static SQLiteDatabase openDatabase(String str, char[] cArr, CursorFactory cursorFactory, int i4) {
        return openDatabase(str, cArr, cursorFactory, i4, (SQLiteDatabaseHook) null, (DatabaseErrorHandler) null);
    }

    public static SQLiteDatabase openOrCreateDatabase(File file, String str, CursorFactory cursorFactory, SQLiteDatabaseHook sQLiteDatabaseHook, DatabaseErrorHandler databaseErrorHandler) {
        return openOrCreateDatabase(file == null ? null : file.getPath(), str, cursorFactory, sQLiteDatabaseHook, databaseErrorHandler);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void beginTransactionWithListener(final android.database.sqlite.SQLiteTransactionListener sQLiteTransactionListener) {
        beginTransactionWithListener(new SQLiteTransactionListener() { // from class: net.sqlcipher.database.SQLiteDatabase.4
            @Override // net.sqlcipher.database.SQLiteTransactionListener
            public void onBegin() {
                sQLiteTransactionListener.onBegin();
            }

            @Override // net.sqlcipher.database.SQLiteTransactionListener
            public void onCommit() {
                sQLiteTransactionListener.onCommit();
            }

            @Override // net.sqlcipher.database.SQLiteTransactionListener
            public void onRollback() {
                sQLiteTransactionListener.onRollback();
            }
        });
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void beginTransactionWithListenerNonExclusive(final android.database.sqlite.SQLiteTransactionListener sQLiteTransactionListener) {
        beginTransactionWithListenerNonExclusive(new SQLiteTransactionListener() { // from class: net.sqlcipher.database.SQLiteDatabase.5
            @Override // net.sqlcipher.database.SQLiteTransactionListener
            public void onBegin() {
                sQLiteTransactionListener.onBegin();
            }

            @Override // net.sqlcipher.database.SQLiteTransactionListener
            public void onCommit() {
                sQLiteTransactionListener.onCommit();
            }

            @Override // net.sqlcipher.database.SQLiteTransactionListener
            public void onRollback() {
                sQLiteTransactionListener.onRollback();
            }
        });
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public SQLiteStatement compileStatement(String str) throws SQLException {
        lock();
        try {
            if (isOpen()) {
                return new SQLiteStatement(this, str);
            }
            throw new IllegalStateException("database not open");
        } finally {
            unlock();
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public int delete(String str, String str2, Object[] objArr) {
        String str3;
        lock();
        AutoCloseable autoCloseable = null;
        try {
            try {
                if (isOpen()) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("DELETE FROM ");
                    sb.append(str);
                    if (TextUtils.isEmpty(str2)) {
                        str3 = "";
                    } else {
                        str3 = " WHERE " + str2;
                    }
                    sb.append(str3);
                    SQLiteStatement compileStatement = compileStatement(sb.toString());
                    if (objArr != null) {
                        int length = objArr.length;
                        int i4 = 0;
                        while (i4 < length) {
                            int i5 = i4 + 1;
                            DatabaseUtils.bindObjectToProgram(compileStatement, i5, objArr[i4]);
                            i4 = i5;
                        }
                    }
                    compileStatement.execute();
                    int lastChangeCount = lastChangeCount();
                    compileStatement.close();
                    unlock();
                    return lastChangeCount;
                }
                throw new IllegalStateException("database not open");
            } catch (SQLiteDatabaseCorruptException e4) {
                onCorruption();
                throw e4;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                autoCloseable.close();
            }
            unlock();
            throw th;
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public long insert(String str, int i4, ContentValues contentValues) throws android.database.SQLException {
        return insertWithOnConflict(str, null, contentValues, i4);
    }

    public Cursor query(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5) {
        return query(false, str, strArr, str2, strArr2, str3, str4, str5, null);
    }

    /* JADX WARN: Finally extract failed */
    public Cursor rawQuery(String str, Object[] objArr) {
        if (isOpen()) {
            long currentTimeMillis = this.mSlowQueryThreshold != -1 ? System.currentTimeMillis() : 0L;
            SQLiteDirectCursorDriver sQLiteDirectCursorDriver = new SQLiteDirectCursorDriver(this, str, null);
            try {
                Cursor query = sQLiteDirectCursorDriver.query(this.mFactory, objArr);
                if (this.mSlowQueryThreshold != -1) {
                    int count = query != null ? query.getCount() : -1;
                    long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                    if (currentTimeMillis2 >= this.mSlowQueryThreshold) {
                        Log.v("Database", "query (" + currentTimeMillis2 + " ms): " + sQLiteDirectCursorDriver.toString() + ", args are <redacted>, count is " + count);
                    }
                }
                return new CrossProcessCursorWrapper(query);
            } catch (Throwable th) {
                if (this.mSlowQueryThreshold != -1) {
                    long currentTimeMillis3 = System.currentTimeMillis() - currentTimeMillis;
                    if (currentTimeMillis3 >= this.mSlowQueryThreshold) {
                        Log.v("Database", "query (" + currentTimeMillis3 + " ms): " + sQLiteDirectCursorDriver.toString() + ", args are <redacted>, count is -1");
                    }
                }
                throw th;
            }
        }
        throw new IllegalStateException("database not open");
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public int update(String str, int i4, ContentValues contentValues, String str2, Object[] objArr) {
        String[] strArr = new String[objArr.length];
        for (int i5 = 0; i5 < objArr.length; i5++) {
            strArr[i5] = objArr[i5].toString();
        }
        return updateWithOnConflict(str, contentValues, str2, strArr, i4);
    }

    public SQLiteDatabase(String str, char[] cArr, CursorFactory cursorFactory, int i4, SQLiteDatabaseHook sQLiteDatabaseHook) {
        this(str, cursorFactory, i4, (DatabaseErrorHandler) null);
        openDatabaseInternal(cArr, sQLiteDatabaseHook);
    }

    public static synchronized void loadLibs(Context context, File file) {
        synchronized (SQLiteDatabase.class) {
            loadLibs(context, file, new LibraryLoader() { // from class: net.sqlcipher.database.SQLiteDatabase.1
                @Override // net.sqlcipher.database.SQLiteDatabase.LibraryLoader
                public void loadLibraries(String... strArr) {
                    for (String str : strArr) {
                        System.loadLibrary(str);
                    }
                }
            });
        }
    }

    public static SQLiteDatabase openDatabase(String str, String str2, CursorFactory cursorFactory, int i4, SQLiteDatabaseHook sQLiteDatabaseHook) {
        return openDatabase(str, str2, cursorFactory, i4, sQLiteDatabaseHook, (DatabaseErrorHandler) null);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x003f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void openDatabaseInternal(final byte[] r6, net.sqlcipher.database.SQLiteDatabaseHook r7) {
        /*
            r5 = this;
            java.lang.String r0 = r5.mPath
            int r1 = r5.mFlags
            r5.dbopen(r0, r1)
            r0 = 0
            r1 = 1
            net.sqlcipher.database.SQLiteDatabase$2 r2 = new net.sqlcipher.database.SQLiteDatabase$2     // Catch: java.lang.Throwable -> L12 java.lang.RuntimeException -> L15
            r2.<init>()     // Catch: java.lang.Throwable -> L12 java.lang.RuntimeException -> L15
            r5.keyDatabase(r7, r2)     // Catch: java.lang.Throwable -> L12 java.lang.RuntimeException -> L15
            goto L3b
        L12:
            r6 = move-exception
            r0 = 1
            goto L3d
        L15:
            r2 = move-exception
            char[] r3 = getChars(r6)     // Catch: java.lang.Throwable -> L12
            boolean r4 = r5.containsNull(r3)     // Catch: java.lang.Throwable -> L12
            if (r4 == 0) goto L3c
            net.sqlcipher.database.SQLiteDatabase$3 r2 = new net.sqlcipher.database.SQLiteDatabase$3     // Catch: java.lang.Throwable -> L12
            r2.<init>()     // Catch: java.lang.Throwable -> L12
            r5.keyDatabase(r7, r2)     // Catch: java.lang.Throwable -> L12
            if (r6 == 0) goto L30
            int r7 = r6.length     // Catch: java.lang.Throwable -> L12
            if (r7 <= 0) goto L30
            r5.rekey(r6)     // Catch: java.lang.Throwable -> L12
        L30:
            if (r3 == 0) goto L3b
            int r6 = r3.length     // Catch: java.lang.Throwable -> L39
            if (r6 <= 0) goto L3b
            java.util.Arrays.fill(r3, r0)     // Catch: java.lang.Throwable -> L39
            goto L3b
        L39:
            r6 = move-exception
            goto L3d
        L3b:
            return
        L3c:
            throw r2     // Catch: java.lang.Throwable -> L12
        L3d:
            if (r0 == 0) goto L4c
            r5.dbclose()
            boolean r7 = net.sqlcipher.database.SQLiteDebug.DEBUG_SQL_CACHE
            if (r7 == 0) goto L4c
            java.lang.String r7 = r5.getTime()
            r5.mTimeClosed = r7
        L4c:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: net.sqlcipher.database.SQLiteDatabase.openDatabaseInternal(byte[], net.sqlcipher.database.SQLiteDatabaseHook):void");
    }

    public static SQLiteDatabase openOrCreateDatabase(String str, String str2, CursorFactory cursorFactory, SQLiteDatabaseHook sQLiteDatabaseHook) {
        return openDatabase(str, str2, cursorFactory, 268435456, sQLiteDatabaseHook);
    }

    public Cursor query(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6) {
        return query(false, str, strArr, str2, strArr2, str3, str4, str5, str6);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean yieldIfContendedSafely(long j4) {
        if (isOpen()) {
            return yieldIfContendedHelper(true, j4);
        }
        return false;
    }

    public static SQLiteDatabase openDatabase(String str, char[] cArr, CursorFactory cursorFactory, int i4, SQLiteDatabaseHook sQLiteDatabaseHook) {
        return openDatabase(str, cArr, cursorFactory, i4, sQLiteDatabaseHook, (DatabaseErrorHandler) null);
    }

    public static SQLiteDatabase openOrCreateDatabase(String str, String str2, CursorFactory cursorFactory, SQLiteDatabaseHook sQLiteDatabaseHook, DatabaseErrorHandler databaseErrorHandler) {
        return openDatabase(str, str2 == null ? null : str2.toCharArray(), cursorFactory, 268435456, sQLiteDatabaseHook, databaseErrorHandler);
    }

    public void markTableSyncable(String str, String str2, String str3) {
        if (isOpen()) {
            markTableSyncable(str, str2, str3, null);
            return;
        }
        throw new SQLiteException("database not open");
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public android.database.Cursor query(String str) {
        return rawQuery(str, (String[]) null);
    }

    public SQLiteDatabase(String str, byte[] bArr, CursorFactory cursorFactory, int i4, SQLiteDatabaseHook sQLiteDatabaseHook) {
        this(str, cursorFactory, i4, (DatabaseErrorHandler) null);
        openDatabaseInternal(bArr, sQLiteDatabaseHook);
    }

    public static synchronized void loadLibs(Context context, LibraryLoader libraryLoader) {
        synchronized (SQLiteDatabase.class) {
            loadLibs(context, context.getFilesDir(), libraryLoader);
        }
    }

    public static SQLiteDatabase openDatabase(String str, String str2, CursorFactory cursorFactory, int i4, SQLiteDatabaseHook sQLiteDatabaseHook, DatabaseErrorHandler databaseErrorHandler) {
        return openDatabase(str, str2 == null ? null : str2.toCharArray(), cursorFactory, i4, sQLiteDatabaseHook, databaseErrorHandler);
    }

    public static SQLiteDatabase openOrCreateDatabase(String str, char[] cArr, CursorFactory cursorFactory, SQLiteDatabaseHook sQLiteDatabaseHook) {
        return openDatabase(str, cArr, cursorFactory, 268435456, sQLiteDatabaseHook);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public android.database.Cursor query(String str, Object[] objArr) {
        return rawQuery(str, objArr);
    }

    public static SQLiteDatabase openDatabase(String str, char[] cArr, CursorFactory cursorFactory, int i4, SQLiteDatabaseHook sQLiteDatabaseHook, DatabaseErrorHandler databaseErrorHandler) {
        return openDatabase(str, getBytes(cArr), cursorFactory, i4, sQLiteDatabaseHook, databaseErrorHandler);
    }

    public static SQLiteDatabase openOrCreateDatabase(String str, char[] cArr, CursorFactory cursorFactory, SQLiteDatabaseHook sQLiteDatabaseHook, DatabaseErrorHandler databaseErrorHandler) {
        return openDatabase(str, cArr, cursorFactory, 268435456, sQLiteDatabaseHook, databaseErrorHandler);
    }

    public void changePassword(char[] cArr) throws SQLiteException {
        if (!isOpen()) {
            throw new SQLiteException("database not open");
        }
        if (cArr != null) {
            byte[] bytes = getBytes(cArr);
            rekey(bytes);
            Arrays.fill(bytes, (byte) 0);
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public android.database.Cursor query(SupportSQLiteQuery supportSQLiteQuery) {
        return query(supportSQLiteQuery, (CancellationSignal) null);
    }

    private SQLiteDatabase(String str, CursorFactory cursorFactory, int i4, DatabaseErrorHandler databaseErrorHandler) {
        this.mLock = new ReentrantLock(true);
        this.mLockAcquiredWallTime = 0L;
        this.mLockAcquiredThreadTime = 0L;
        this.mLastLockMessageTime = 0L;
        this.mLastSqlStatement = null;
        this.mNativeHandle = 0L;
        this.mTempTableSequence = 0;
        this.mPathForLogs = null;
        this.mCompiledQueries = new HashMap();
        this.mMaxSqlCacheSize = 250;
        this.mTimeOpened = null;
        this.mTimeClosed = null;
        this.mStackTrace = null;
        this.mLockingEnabled = true;
        this.mSyncUpdateInfo = new HashMap();
        if (str != null) {
            this.mFlags = i4;
            this.mPath = str;
            this.mSlowQueryThreshold = -1;
            this.mStackTrace = new DatabaseObjectNotClosedException().fillInStackTrace();
            this.mFactory = cursorFactory;
            this.mPrograms = new WeakHashMap<>();
            this.mErrorHandler = databaseErrorHandler;
            return;
        }
        throw new IllegalArgumentException("path should not be null");
    }

    public static synchronized void loadLibs(Context context, File file, LibraryLoader libraryLoader) {
        synchronized (SQLiteDatabase.class) {
            libraryLoader.loadLibraries("sqlcipher");
        }
    }

    private void markTableSyncable(String str, String str2, String str3, String str4) {
        lock();
        try {
            native_execSQL("SELECT _sync_dirty FROM " + str3 + " LIMIT 0");
            native_execSQL("SELECT " + str2 + " FROM " + str + " LIMIT 0");
            unlock();
            SyncUpdateInfo syncUpdateInfo = new SyncUpdateInfo(str3, str4, str2);
            synchronized (this.mSyncUpdateInfo) {
                this.mSyncUpdateInfo.put(str, syncUpdateInfo);
            }
        } catch (Throwable th) {
            unlock();
            throw th;
        }
    }

    public static SQLiteDatabase openOrCreateDatabase(String str, byte[] bArr, CursorFactory cursorFactory, SQLiteDatabaseHook sQLiteDatabaseHook) {
        return openDatabase(str, bArr, cursorFactory, 268435456, sQLiteDatabaseHook, (DatabaseErrorHandler) null);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public android.database.Cursor query(SupportSQLiteQuery supportSQLiteQuery, CancellationSignal cancellationSignal) {
        String sql = supportSQLiteQuery.getSql();
        SQLiteDirectCursorDriver sQLiteDirectCursorDriver = new SQLiteDirectCursorDriver(this, sql, null);
        SQLiteQuery sQLiteQuery = new SQLiteQuery(this, sql, 0, new Object[supportSQLiteQuery.getArgCount()]);
        supportSQLiteQuery.bindTo(sQLiteQuery);
        return new CrossProcessCursorWrapper(new SQLiteCursor(this, sQLiteDirectCursorDriver, null, sQLiteQuery));
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0022  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x002f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static net.sqlcipher.database.SQLiteDatabase openDatabase(java.lang.String r2, byte[] r3, net.sqlcipher.database.SQLiteDatabase.CursorFactory r4, int r5, net.sqlcipher.database.SQLiteDatabaseHook r6, net.sqlcipher.DatabaseErrorHandler r7) {
        /*
            if (r7 == 0) goto L3
            goto L8
        L3:
            net.sqlcipher.DefaultDatabaseErrorHandler r7 = new net.sqlcipher.DefaultDatabaseErrorHandler
            r7.<init>()
        L8:
            r0 = 0
            net.sqlcipher.database.SQLiteDatabase r1 = new net.sqlcipher.database.SQLiteDatabase     // Catch: net.sqlcipher.database.SQLiteDatabaseCorruptException -> L12
            r1.<init>(r2, r4, r5, r7)     // Catch: net.sqlcipher.database.SQLiteDatabaseCorruptException -> L12
            r1.openDatabaseInternal(r3, r6)     // Catch: net.sqlcipher.database.SQLiteDatabaseCorruptException -> L13
            goto L1e
        L12:
            r1 = r0
        L13:
            r7.onCorruption(r1)
            net.sqlcipher.database.SQLiteDatabase r1 = new net.sqlcipher.database.SQLiteDatabase
            r1.<init>(r2, r4, r5, r7)
            r1.openDatabaseInternal(r3, r6)
        L1e:
            boolean r3 = net.sqlcipher.database.SQLiteDebug.DEBUG_SQL_STATEMENTS
            if (r3 == 0) goto L25
            r1.enableSqlTracing(r2)
        L25:
            boolean r3 = net.sqlcipher.database.SQLiteDebug.DEBUG_SQL_TIME
            if (r3 == 0) goto L2c
            r1.enableSqlProfiling(r2)
        L2c:
            java.util.WeakHashMap<net.sqlcipher.database.SQLiteDatabase, java.lang.Object> r2 = net.sqlcipher.database.SQLiteDatabase.sActiveDatabases
            monitor-enter(r2)
            java.util.WeakHashMap<net.sqlcipher.database.SQLiteDatabase, java.lang.Object> r3 = net.sqlcipher.database.SQLiteDatabase.sActiveDatabases     // Catch: java.lang.Throwable -> L36
            r3.put(r1, r0)     // Catch: java.lang.Throwable -> L36
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L36
            return r1
        L36:
            r3 = move-exception
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L36
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: net.sqlcipher.database.SQLiteDatabase.openDatabase(java.lang.String, byte[], net.sqlcipher.database.SQLiteDatabase$CursorFactory, int, net.sqlcipher.database.SQLiteDatabaseHook, net.sqlcipher.DatabaseErrorHandler):net.sqlcipher.database.SQLiteDatabase");
    }

    public static SQLiteDatabase openOrCreateDatabase(String str, byte[] bArr, CursorFactory cursorFactory, SQLiteDatabaseHook sQLiteDatabaseHook, DatabaseErrorHandler databaseErrorHandler) {
        return openDatabase(str, bArr, cursorFactory, 268435456, sQLiteDatabaseHook, databaseErrorHandler);
    }

    public static SQLiteDatabase openOrCreateDatabase(File file, String str, CursorFactory cursorFactory) {
        return openOrCreateDatabase(file, str, cursorFactory, (SQLiteDatabaseHook) null);
    }

    public static SQLiteDatabase openOrCreateDatabase(String str, String str2, CursorFactory cursorFactory) {
        return openDatabase(str, str2, cursorFactory, 268435456, (SQLiteDatabaseHook) null);
    }

    public static SQLiteDatabase openOrCreateDatabase(String str, char[] cArr, CursorFactory cursorFactory) {
        return openDatabase(str, cArr, cursorFactory, 268435456, (SQLiteDatabaseHook) null);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void execSQL(String str, Object[] objArr) throws SQLException {
        if (objArr != null) {
            SystemClock.uptimeMillis();
            lock();
            AutoCloseable autoCloseable = null;
            try {
                try {
                    if (isOpen()) {
                        SQLiteStatement compileStatement = compileStatement(str);
                        int length = objArr.length;
                        int i4 = 0;
                        while (i4 < length) {
                            int i5 = i4 + 1;
                            DatabaseUtils.bindObjectToProgram(compileStatement, i5, objArr[i4]);
                            i4 = i5;
                        }
                        compileStatement.execute();
                        compileStatement.close();
                        unlock();
                        return;
                    }
                    throw new IllegalStateException("database not open");
                } catch (SQLiteDatabaseCorruptException e4) {
                    onCorruption();
                    throw e4;
                }
            } catch (Throwable th) {
                if (0 != 0) {
                    autoCloseable.close();
                }
                unlock();
                throw th;
            }
        }
        throw new IllegalArgumentException("Empty bindArgs");
    }

    public static SQLiteDatabase openOrCreateDatabase(String str, byte[] bArr, CursorFactory cursorFactory) {
        return openDatabase(str, bArr, cursorFactory, 268435456, (SQLiteDatabaseHook) null, (DatabaseErrorHandler) null);
    }

    public Cursor rawQuery(String str, String[] strArr, int i4, int i5) {
        CursorWrapper cursorWrapper = (CursorWrapper) rawQueryWithFactory(null, str, strArr, null);
        ((SQLiteCursor) cursorWrapper.getWrappedCursor()).setLoadStyle(i4, i5);
        return cursorWrapper;
    }
}

package net.sqlcipher.database;

import android.database.DataSetObserver;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;
import net.sqlcipher.AbstractWindowedCursor;
import net.sqlcipher.CursorWindow;
import net.sqlcipher.SQLException;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class SQLiteCursor extends AbstractWindowedCursor {
    static final int NO_COUNT = -1;
    static final String TAG = "Cursor";
    private String[] mColumns;
    private SQLiteDatabase mDatabase;
    private SQLiteCursorDriver mDriver;
    private String mEditTable;
    protected MainThreadNotificationHandler mNotificationHandler;
    private SQLiteQuery mQuery;
    private int mCount = -1;
    private int mCursorWindowCapacity = 0;
    private boolean fillWindowForwardOnly = false;
    private int mMaxRead = Integer.MAX_VALUE;
    private int mInitialRead = Integer.MAX_VALUE;
    private int mCursorState = 0;
    private ReentrantLock mLock = null;
    private boolean mPendingData = false;
    private Throwable mStackTrace = new DatabaseObjectNotClosedException().fillInStackTrace();
    private Map<String, Integer> mColumnNameMap = null;

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static class MainThreadNotificationHandler extends Handler {
        private final WeakReference<SQLiteCursor> wrappedCursor;

        MainThreadNotificationHandler(SQLiteCursor sQLiteCursor) {
            this.wrappedCursor = new WeakReference<>(sQLiteCursor);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            SQLiteCursor sQLiteCursor = this.wrappedCursor.get();
            if (sQLiteCursor != null) {
                sQLiteCursor.notifyDataSetChange();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public final class QueryThread implements Runnable {
        private final int mThreadState;

        QueryThread(int i4) {
            this.mThreadState = i4;
        }

        private void sendMessage() {
            SQLiteCursor sQLiteCursor = SQLiteCursor.this;
            MainThreadNotificationHandler mainThreadNotificationHandler = sQLiteCursor.mNotificationHandler;
            if (mainThreadNotificationHandler != null) {
                mainThreadNotificationHandler.sendEmptyMessage(1);
                SQLiteCursor.this.mPendingData = false;
                return;
            }
            sQLiteCursor.mPendingData = true;
        }

        /* JADX WARN: Code restructure failed: missing block: B:15:0x0077, code lost:
            r4.this$0.mCount = r1;
            sendMessage();
         */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void run() {
            /*
                r4 = this;
                net.sqlcipher.database.SQLiteCursor r0 = net.sqlcipher.database.SQLiteCursor.this
                net.sqlcipher.CursorWindow r0 = net.sqlcipher.database.SQLiteCursor.access$100(r0)
                int r1 = android.os.Process.myTid()
                r2 = 10
                android.os.Process.setThreadPriority(r1, r2)
            Lf:
                net.sqlcipher.database.SQLiteCursor r1 = net.sqlcipher.database.SQLiteCursor.this
                java.util.concurrent.locks.ReentrantLock r1 = net.sqlcipher.database.SQLiteCursor.access$200(r1)
                if (r1 != 0) goto L22
                net.sqlcipher.database.SQLiteCursor r1 = net.sqlcipher.database.SQLiteCursor.this
                java.util.concurrent.locks.ReentrantLock r2 = new java.util.concurrent.locks.ReentrantLock
                r3 = 1
                r2.<init>(r3)
                net.sqlcipher.database.SQLiteCursor.access$202(r1, r2)
            L22:
                net.sqlcipher.database.SQLiteCursor r1 = net.sqlcipher.database.SQLiteCursor.this
                java.util.concurrent.locks.ReentrantLock r1 = net.sqlcipher.database.SQLiteCursor.access$200(r1)
                r1.lock()
                net.sqlcipher.database.SQLiteCursor r1 = net.sqlcipher.database.SQLiteCursor.this
                int r1 = net.sqlcipher.database.SQLiteCursor.access$300(r1)
                int r2 = r4.mThreadState
                if (r1 == r2) goto L3f
                net.sqlcipher.database.SQLiteCursor r0 = net.sqlcipher.database.SQLiteCursor.this
                java.util.concurrent.locks.ReentrantLock r0 = net.sqlcipher.database.SQLiteCursor.access$200(r0)
                r0.unlock()
                goto L94
            L3f:
                net.sqlcipher.database.SQLiteCursor r1 = net.sqlcipher.database.SQLiteCursor.this     // Catch: java.lang.Throwable -> L80 java.lang.Exception -> L8b
                net.sqlcipher.database.SQLiteQuery r1 = net.sqlcipher.database.SQLiteCursor.access$600(r1)     // Catch: java.lang.Throwable -> L80 java.lang.Exception -> L8b
                net.sqlcipher.database.SQLiteCursor r2 = net.sqlcipher.database.SQLiteCursor.this     // Catch: java.lang.Throwable -> L80 java.lang.Exception -> L8b
                int r2 = net.sqlcipher.database.SQLiteCursor.access$400(r2)     // Catch: java.lang.Throwable -> L80 java.lang.Exception -> L8b
                net.sqlcipher.database.SQLiteCursor r3 = net.sqlcipher.database.SQLiteCursor.this     // Catch: java.lang.Throwable -> L80 java.lang.Exception -> L8b
                int r3 = net.sqlcipher.database.SQLiteCursor.access$500(r3)     // Catch: java.lang.Throwable -> L80 java.lang.Exception -> L8b
                int r1 = r1.fillWindow(r0, r2, r3)     // Catch: java.lang.Throwable -> L80 java.lang.Exception -> L8b
                if (r1 == 0) goto L8b
                r2 = -1
                if (r1 != r2) goto L77
                net.sqlcipher.database.SQLiteCursor r1 = net.sqlcipher.database.SQLiteCursor.this     // Catch: java.lang.Throwable -> L80 java.lang.Exception -> L8b
                int r2 = net.sqlcipher.database.SQLiteCursor.access$500(r1)     // Catch: java.lang.Throwable -> L80 java.lang.Exception -> L8b
                net.sqlcipher.database.SQLiteCursor r3 = net.sqlcipher.database.SQLiteCursor.this     // Catch: java.lang.Throwable -> L80 java.lang.Exception -> L8b
                int r3 = net.sqlcipher.database.SQLiteCursor.access$400(r3)     // Catch: java.lang.Throwable -> L80 java.lang.Exception -> L8b
                int r2 = r2 + r3
                net.sqlcipher.database.SQLiteCursor.access$502(r1, r2)     // Catch: java.lang.Throwable -> L80 java.lang.Exception -> L8b
                r4.sendMessage()     // Catch: java.lang.Throwable -> L80 java.lang.Exception -> L8b
                net.sqlcipher.database.SQLiteCursor r1 = net.sqlcipher.database.SQLiteCursor.this
                java.util.concurrent.locks.ReentrantLock r1 = net.sqlcipher.database.SQLiteCursor.access$200(r1)
                r1.unlock()
                goto Lf
            L77:
                net.sqlcipher.database.SQLiteCursor r0 = net.sqlcipher.database.SQLiteCursor.this     // Catch: java.lang.Throwable -> L80 java.lang.Exception -> L8b
                net.sqlcipher.database.SQLiteCursor.access$502(r0, r1)     // Catch: java.lang.Throwable -> L80 java.lang.Exception -> L8b
                r4.sendMessage()     // Catch: java.lang.Throwable -> L80 java.lang.Exception -> L8b
                goto L8b
            L80:
                r0 = move-exception
                net.sqlcipher.database.SQLiteCursor r1 = net.sqlcipher.database.SQLiteCursor.this
                java.util.concurrent.locks.ReentrantLock r1 = net.sqlcipher.database.SQLiteCursor.access$200(r1)
                r1.unlock()
                throw r0
            L8b:
                net.sqlcipher.database.SQLiteCursor r0 = net.sqlcipher.database.SQLiteCursor.this
                java.util.concurrent.locks.ReentrantLock r0 = net.sqlcipher.database.SQLiteCursor.access$200(r0)
                r0.unlock()
            L94:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.sqlcipher.database.SQLiteCursor.QueryThread.run():void");
        }
    }

    public SQLiteCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
        this.mDatabase = sQLiteDatabase;
        this.mDriver = sQLiteCursorDriver;
        this.mEditTable = str;
        this.mQuery = sQLiteQuery;
        try {
            sQLiteDatabase.lock();
            int columnCountLocked = this.mQuery.columnCountLocked();
            this.mColumns = new String[columnCountLocked];
            for (int i4 = 0; i4 < columnCountLocked; i4++) {
                String columnNameLocked = this.mQuery.columnNameLocked(i4);
                this.mColumns[i4] = columnNameLocked;
                if ("_id".equals(columnNameLocked)) {
                    this.mRowIdColumnIndex = i4;
                }
            }
        } finally {
            sQLiteDatabase.unlock();
        }
    }

    private void deactivateCommon() {
        this.mCursorState = 0;
        CursorWindow cursorWindow = this.mWindow;
        if (cursorWindow != null) {
            cursorWindow.close();
            this.mWindow = null;
        }
    }

    private void fillWindow(int i4) {
        int cursorPickFillWindowStartPosition;
        if (this.mWindow == null) {
            this.mWindow = new CursorWindow(true);
        } else {
            this.mCursorState++;
            queryThreadLock();
            try {
                this.mWindow.clear();
            } finally {
                queryThreadUnlock();
            }
        }
        if (this.fillWindowForwardOnly) {
            cursorPickFillWindowStartPosition = i4;
        } else if (this.mCount == -1) {
            cursorPickFillWindowStartPosition = cursorPickFillWindowStartPosition(i4, 0);
        } else {
            cursorPickFillWindowStartPosition = cursorPickFillWindowStartPosition(i4, this.mCursorWindowCapacity);
        }
        this.mWindow.setStartPosition(cursorPickFillWindowStartPosition);
        this.mWindow.setRequiredPosition(i4);
        this.mCount = this.mQuery.fillWindow(this.mWindow, this.mInitialRead, 0);
        if (this.mCursorWindowCapacity == 0) {
            this.mCursorWindowCapacity = this.mWindow.getNumRows();
        }
        if (this.mCount == -1) {
            this.mCount = cursorPickFillWindowStartPosition + this.mInitialRead;
            new Thread(new QueryThread(this.mCursorState), "query thread").start();
        }
    }

    private void queryThreadLock() {
        ReentrantLock reentrantLock = this.mLock;
        if (reentrantLock != null) {
            reentrantLock.lock();
        }
    }

    private void queryThreadUnlock() {
        ReentrantLock reentrantLock = this.mLock;
        if (reentrantLock != null) {
            reentrantLock.unlock();
        }
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        super.close();
        deactivateCommon();
        this.mQuery.close();
        this.mDriver.cursorClosed();
    }

    @Override // net.sqlcipher.AbstractCursor
    public boolean commitUpdates(Map<? extends Long, ? extends Map<String, Object>> map) {
        if (supportsUpdates()) {
            synchronized (this.mUpdatedRows) {
                if (map != null) {
                    this.mUpdatedRows.putAll(map);
                }
                if (this.mUpdatedRows.size() == 0) {
                    return true;
                }
                this.mDatabase.beginTransaction();
                StringBuilder sb = new StringBuilder(128);
                for (Map.Entry<Long, Map<String, Object>> entry : this.mUpdatedRows.entrySet()) {
                    Map<String, Object> value = entry.getValue();
                    Long key = entry.getKey();
                    if (key != null && value != null) {
                        if (value.size() != 0) {
                            long longValue = key.longValue();
                            Iterator<Map.Entry<String, Object>> it = value.entrySet().iterator();
                            sb.setLength(0);
                            sb.append("UPDATE " + this.mEditTable + " SET ");
                            Object[] objArr = new Object[value.size()];
                            int i4 = 0;
                            while (it.hasNext()) {
                                Map.Entry<String, Object> next = it.next();
                                sb.append(next.getKey());
                                sb.append("=?");
                                objArr[i4] = next.getValue();
                                if (it.hasNext()) {
                                    sb.append(", ");
                                }
                                i4++;
                            }
                            sb.append(" WHERE " + this.mColumns[this.mRowIdColumnIndex] + '=' + longValue);
                            sb.append(';');
                            this.mDatabase.execSQL(sb.toString(), objArr);
                            this.mDatabase.rowUpdated(this.mEditTable, longValue);
                        }
                    } else {
                        throw new IllegalStateException("null rowId or values found! rowId = " + key + ", values = " + value);
                    }
                }
                this.mDatabase.setTransactionSuccessful();
                this.mDatabase.endTransaction();
                this.mUpdatedRows.clear();
                onChange(true);
                return true;
            }
        }
        return false;
    }

    public int cursorPickFillWindowStartPosition(int i4, int i5) {
        return Math.max(i4 - (i5 / 3), 0);
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor
    public void deactivate() {
        super.deactivate();
        deactivateCommon();
        this.mDriver.cursorDeactivated();
    }

    @Override // net.sqlcipher.AbstractCursor
    public boolean deleteRow() {
        boolean z3;
        checkPosition();
        if (this.mRowIdColumnIndex == -1 || this.mCurrentRowID == null) {
            return false;
        }
        this.mDatabase.lock();
        try {
            try {
                SQLiteDatabase sQLiteDatabase = this.mDatabase;
                String str = this.mEditTable;
                sQLiteDatabase.delete(str, this.mColumns[this.mRowIdColumnIndex] + "=?", new String[]{this.mCurrentRowID.toString()});
                z3 = true;
            } finally {
                this.mDatabase.unlock();
            }
        } catch (SQLException unused) {
            z3 = false;
        }
        int i4 = this.mPos;
        requery();
        moveToPosition(i4);
        if (z3) {
            onChange(true);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // net.sqlcipher.AbstractCursor
    public void finalize() {
        try {
            if (this.mWindow != null) {
                this.mQuery.mSql.length();
                close();
                SQLiteDebug.notifyActiveCursorFinalized();
            }
        } finally {
            super.finalize();
        }
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor
    public int getColumnIndex(String str) {
        if (this.mColumnNameMap == null) {
            String[] strArr = this.mColumns;
            int length = strArr.length;
            HashMap hashMap = new HashMap(length, 1.0f);
            for (int i4 = 0; i4 < length; i4++) {
                hashMap.put(strArr[i4], Integer.valueOf(i4));
            }
            this.mColumnNameMap = hashMap;
        }
        if (str.lastIndexOf(46) != -1) {
            new Exception();
        }
        Integer num = this.mColumnNameMap.get(str);
        if (num != null) {
            return num.intValue();
        }
        return -1;
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor
    public String[] getColumnNames() {
        return this.mColumns;
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor
    public int getCount() {
        if (this.mCount == -1) {
            fillWindow(0);
        }
        return this.mCount;
    }

    public SQLiteDatabase getDatabase() {
        return this.mDatabase;
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.CrossProcessCursor
    public boolean onMove(int i4, int i5) {
        CursorWindow cursorWindow = this.mWindow;
        if (cursorWindow == null || i5 < cursorWindow.getStartPosition() || i5 >= this.mWindow.getStartPosition() + this.mWindow.getNumRows()) {
            fillWindow(i5);
            return true;
        }
        return true;
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor
    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
        super.registerDataSetObserver(dataSetObserver);
        if (!(Integer.MAX_VALUE == this.mMaxRead && Integer.MAX_VALUE == this.mInitialRead) && this.mNotificationHandler == null) {
            queryThreadLock();
            try {
                this.mNotificationHandler = new MainThreadNotificationHandler(this);
                if (this.mPendingData) {
                    notifyDataSetChange();
                    this.mPendingData = false;
                }
            } finally {
                queryThreadUnlock();
            }
        }
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor
    public boolean requery() {
        if (isClosed()) {
            return false;
        }
        this.mDatabase.lock();
        try {
            CursorWindow cursorWindow = this.mWindow;
            if (cursorWindow != null) {
                cursorWindow.clear();
            }
            this.mPos = -1;
            this.mDriver.cursorRequeried(this);
            this.mCount = -1;
            this.mCursorState++;
            queryThreadLock();
            this.mQuery.requery();
            queryThreadUnlock();
            this.mDatabase.unlock();
            return super.requery();
        } catch (Throwable th) {
            this.mDatabase.unlock();
            throw th;
        }
    }

    public void setFillWindowForwardOnly(boolean z3) {
        this.fillWindowForwardOnly = z3;
    }

    public void setLoadStyle(int i4, int i5) {
        this.mMaxRead = i5;
        this.mInitialRead = i4;
        this.mLock = new ReentrantLock(true);
    }

    public void setSelectionArguments(String[] strArr) {
        this.mDriver.setBindArguments(strArr);
    }

    @Override // net.sqlcipher.AbstractWindowedCursor
    public void setWindow(CursorWindow cursorWindow) {
        if (this.mWindow != null) {
            this.mCursorState++;
            queryThreadLock();
            try {
                this.mWindow.close();
                queryThreadUnlock();
                this.mCount = -1;
            } catch (Throwable th) {
                queryThreadUnlock();
                throw th;
            }
        }
        this.mWindow = cursorWindow;
    }

    @Override // net.sqlcipher.AbstractCursor
    public boolean supportsUpdates() {
        return !TextUtils.isEmpty(this.mEditTable);
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.CrossProcessCursor
    public void fillWindow(int i4, android.database.CursorWindow cursorWindow) {
        int cursorPickFillWindowStartPosition;
        if (this.mWindow == null) {
            this.mWindow = new CursorWindow(true);
        } else {
            this.mCursorState++;
            queryThreadLock();
            try {
                this.mWindow.clear();
            } finally {
                queryThreadUnlock();
            }
        }
        if (this.fillWindowForwardOnly) {
            cursorPickFillWindowStartPosition = i4;
        } else if (this.mCount == -1) {
            cursorPickFillWindowStartPosition = cursorPickFillWindowStartPosition(i4, 0);
        } else {
            cursorPickFillWindowStartPosition = cursorPickFillWindowStartPosition(i4, this.mCursorWindowCapacity);
        }
        this.mWindow.setStartPosition(cursorPickFillWindowStartPosition);
        this.mWindow.setRequiredPosition(i4);
        this.mCount = this.mQuery.fillWindow(this.mWindow, this.mInitialRead, 0);
        if (this.mCursorWindowCapacity == 0) {
            this.mCursorWindowCapacity = this.mWindow.getNumRows();
        }
        if (this.mCount == -1) {
            this.mCount = cursorPickFillWindowStartPosition + this.mInitialRead;
            new Thread(new QueryThread(this.mCursorState), "query thread").start();
        }
    }
}

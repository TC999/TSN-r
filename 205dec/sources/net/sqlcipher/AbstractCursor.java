package net.sqlcipher;

import android.content.ContentResolver;
import android.database.CharArrayBuffer;
import android.database.ContentObservable;
import android.database.ContentObserver;
import android.database.CrossProcessCursor;
import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public abstract class AbstractCursor implements CrossProcessCursor, Cursor {
    private static final String TAG = "Cursor";
    protected ContentResolver mContentResolver;
    private Uri mNotifyUri;
    private ContentObserver mSelfObserver;
    private boolean mSelfObserverRegistered;
    DataSetObservable mDataSetObservable = new DataSetObservable();
    ContentObservable mContentObservable = new ContentObservable();
    private Bundle mExtras = Bundle.EMPTY;
    protected boolean mClosed = false;
    private final Object mSelfObserverLock = new Object();
    protected int mPos = -1;
    protected int mRowIdColumnIndex = -1;
    protected Long mCurrentRowID = null;
    protected HashMap<Long, Map<String, Object>> mUpdatedRows = new HashMap<>();

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    protected static class SelfContentObserver extends ContentObserver {
        WeakReference<AbstractCursor> mCursor;

        public SelfContentObserver(AbstractCursor abstractCursor) {
            super(null);
            this.mCursor = new WeakReference<>(abstractCursor);
        }

        @Override // android.database.ContentObserver
        public boolean deliverSelfNotifications() {
            return false;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z3) {
            AbstractCursor abstractCursor = this.mCursor.get();
            if (abstractCursor != null) {
                abstractCursor.onChange(false);
            }
        }
    }

    public void abortUpdates() {
        synchronized (this.mUpdatedRows) {
            this.mUpdatedRows.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void checkPosition() {
        if (-1 == this.mPos || getCount() == this.mPos) {
            throw new CursorIndexOutOfBoundsException(this.mPos, getCount());
        }
    }

    @Override // android.database.Cursor, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.mClosed = true;
        this.mContentObservable.unregisterAll();
        deactivateInternal();
    }

    public boolean commitUpdates() {
        return commitUpdates(null);
    }

    public boolean commitUpdates(Map<? extends Long, ? extends Map<String, Object>> map) {
        return false;
    }

    @Override // android.database.Cursor
    public void copyStringToBuffer(int i4, CharArrayBuffer charArrayBuffer) {
        String string = getString(i4);
        if (string != null) {
            char[] cArr = charArrayBuffer.data;
            if (cArr != null && cArr.length >= string.length()) {
                string.getChars(0, string.length(), cArr, 0);
            } else {
                charArrayBuffer.data = string.toCharArray();
            }
            charArrayBuffer.sizeCopied = string.length();
            return;
        }
        charArrayBuffer.sizeCopied = 0;
    }

    @Override // android.database.Cursor
    public void deactivate() {
        deactivateInternal();
    }

    public void deactivateInternal() {
        ContentObserver contentObserver = this.mSelfObserver;
        if (contentObserver != null) {
            this.mContentResolver.unregisterContentObserver(contentObserver);
            this.mSelfObserverRegistered = false;
        }
        this.mDataSetObservable.notifyInvalidated();
    }

    public boolean deleteRow() {
        return false;
    }

    @Override // android.database.CrossProcessCursor
    public void fillWindow(int i4, android.database.CursorWindow cursorWindow) {
        DatabaseUtils.cursorFillWindow(this, i4, cursorWindow);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void finalize() {
        ContentObserver contentObserver = this.mSelfObserver;
        if (contentObserver == null || !this.mSelfObserverRegistered) {
            return;
        }
        this.mContentResolver.unregisterContentObserver(contentObserver);
    }

    @Override // android.database.Cursor
    public byte[] getBlob(int i4) {
        throw new UnsupportedOperationException("getBlob is not supported");
    }

    @Override // android.database.Cursor
    public int getColumnCount() {
        return getColumnNames().length;
    }

    @Override // android.database.Cursor
    public int getColumnIndex(String str) {
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf != -1) {
            Exception exc = new Exception();
            Log.e("Cursor", "requesting column name with table name -- " + str, exc);
            str = str.substring(lastIndexOf + 1);
        }
        String[] columnNames = getColumnNames();
        int length = columnNames.length;
        for (int i4 = 0; i4 < length; i4++) {
            if (columnNames[i4].equalsIgnoreCase(str)) {
                return i4;
            }
        }
        return -1;
    }

    @Override // android.database.Cursor
    public int getColumnIndexOrThrow(String str) {
        int columnIndex = getColumnIndex(str);
        if (columnIndex >= 0) {
            return columnIndex;
        }
        throw new IllegalArgumentException("column '" + str + "' does not exist");
    }

    @Override // android.database.Cursor
    public String getColumnName(int i4) {
        return getColumnNames()[i4];
    }

    @Override // android.database.Cursor
    public abstract String[] getColumnNames();

    @Override // android.database.Cursor
    public abstract int getCount();

    protected DataSetObservable getDataSetObservable() {
        return this.mDataSetObservable;
    }

    @Override // android.database.Cursor
    public abstract double getDouble(int i4);

    @Override // android.database.Cursor
    public Bundle getExtras() {
        return this.mExtras;
    }

    @Override // android.database.Cursor
    public abstract float getFloat(int i4);

    @Override // android.database.Cursor
    public abstract int getInt(int i4);

    @Override // android.database.Cursor
    public abstract long getLong(int i4);

    @Override // android.database.Cursor
    public Uri getNotificationUri() {
        return this.mNotifyUri;
    }

    @Override // android.database.Cursor
    public final int getPosition() {
        return this.mPos;
    }

    @Override // android.database.Cursor
    public abstract short getShort(int i4);

    @Override // android.database.Cursor
    public abstract String getString(int i4);

    @Override // android.database.Cursor, net.sqlcipher.Cursor
    public abstract int getType(int i4);

    /* JADX INFO: Access modifiers changed from: protected */
    public Object getUpdatedField(int i4) {
        return this.mUpdatedRows.get(this.mCurrentRowID).get(getColumnNames()[i4]);
    }

    @Override // android.database.Cursor
    public boolean getWantsAllOnMoveCalls() {
        return false;
    }

    @Override // android.database.CrossProcessCursor
    public CursorWindow getWindow() {
        return null;
    }

    public boolean hasUpdates() {
        boolean z3;
        synchronized (this.mUpdatedRows) {
            z3 = this.mUpdatedRows.size() > 0;
        }
        return z3;
    }

    @Override // android.database.Cursor
    public final boolean isAfterLast() {
        return getCount() == 0 || this.mPos == getCount();
    }

    @Override // android.database.Cursor
    public final boolean isBeforeFirst() {
        return getCount() == 0 || this.mPos == -1;
    }

    @Override // android.database.Cursor
    public boolean isClosed() {
        return this.mClosed;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isFieldUpdated(int i4) {
        Map<String, Object> map;
        return this.mRowIdColumnIndex != -1 && this.mUpdatedRows.size() > 0 && (map = this.mUpdatedRows.get(this.mCurrentRowID)) != null && map.containsKey(getColumnNames()[i4]);
    }

    @Override // android.database.Cursor
    public final boolean isFirst() {
        return this.mPos == 0 && getCount() != 0;
    }

    @Override // android.database.Cursor
    public final boolean isLast() {
        int count = getCount();
        return this.mPos == count + (-1) && count != 0;
    }

    @Override // android.database.Cursor
    public abstract boolean isNull(int i4);

    @Override // android.database.Cursor
    public final boolean move(int i4) {
        return moveToPosition(this.mPos + i4);
    }

    @Override // android.database.Cursor
    public final boolean moveToFirst() {
        return moveToPosition(0);
    }

    @Override // android.database.Cursor
    public final boolean moveToLast() {
        return moveToPosition(getCount() - 1);
    }

    @Override // android.database.Cursor
    public final boolean moveToNext() {
        return moveToPosition(this.mPos + 1);
    }

    @Override // android.database.Cursor
    public final boolean moveToPosition(int i4) {
        int count = getCount();
        if (i4 >= count) {
            this.mPos = count;
            return false;
        } else if (i4 < 0) {
            this.mPos = -1;
            return false;
        } else {
            int i5 = this.mPos;
            if (i4 == i5) {
                return true;
            }
            boolean onMove = onMove(i5, i4);
            if (!onMove) {
                this.mPos = -1;
            } else {
                this.mPos = i4;
                int i6 = this.mRowIdColumnIndex;
                if (i6 != -1) {
                    this.mCurrentRowID = Long.valueOf(getLong(i6));
                }
            }
            return onMove;
        }
    }

    @Override // android.database.Cursor
    public final boolean moveToPrevious() {
        return moveToPosition(this.mPos - 1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void notifyDataSetChange() {
        this.mDataSetObservable.notifyChanged();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChange(boolean z3) {
        synchronized (this.mSelfObserverLock) {
            this.mContentObservable.dispatchChange(z3);
            Uri uri = this.mNotifyUri;
            if (uri != null && z3) {
                this.mContentResolver.notifyChange(uri, this.mSelfObserver);
            }
        }
    }

    @Override // android.database.CrossProcessCursor
    public boolean onMove(int i4, int i5) {
        return true;
    }

    @Override // android.database.Cursor
    public void registerContentObserver(ContentObserver contentObserver) {
        this.mContentObservable.registerObserver(contentObserver);
    }

    @Override // android.database.Cursor
    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
        this.mDataSetObservable.registerObserver(dataSetObserver);
    }

    @Override // android.database.Cursor
    public boolean requery() {
        ContentObserver contentObserver = this.mSelfObserver;
        if (contentObserver != null && !this.mSelfObserverRegistered) {
            this.mContentResolver.registerContentObserver(this.mNotifyUri, true, contentObserver);
            this.mSelfObserverRegistered = true;
        }
        this.mDataSetObservable.notifyChanged();
        return true;
    }

    @Override // android.database.Cursor
    public Bundle respond(Bundle bundle) {
        return Bundle.EMPTY;
    }

    @Override // android.database.Cursor
    public void setExtras(Bundle bundle) {
        if (bundle == null) {
            bundle = Bundle.EMPTY;
        }
        this.mExtras = bundle;
    }

    @Override // android.database.Cursor
    public void setNotificationUri(ContentResolver contentResolver, Uri uri) {
        synchronized (this.mSelfObserverLock) {
            this.mNotifyUri = uri;
            this.mContentResolver = contentResolver;
            ContentObserver contentObserver = this.mSelfObserver;
            if (contentObserver != null) {
                contentResolver.unregisterContentObserver(contentObserver);
            }
            SelfContentObserver selfContentObserver = new SelfContentObserver(this);
            this.mSelfObserver = selfContentObserver;
            this.mContentResolver.registerContentObserver(this.mNotifyUri, true, selfContentObserver);
            this.mSelfObserverRegistered = true;
        }
    }

    public boolean supportsUpdates() {
        return this.mRowIdColumnIndex != -1;
    }

    @Override // android.database.Cursor
    public void unregisterContentObserver(ContentObserver contentObserver) {
        if (this.mClosed) {
            return;
        }
        this.mContentObservable.unregisterObserver(contentObserver);
    }

    @Override // android.database.Cursor
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        this.mDataSetObservable.unregisterObserver(dataSetObserver);
    }

    public boolean update(int i4, Object obj) {
        if (supportsUpdates()) {
            Long valueOf = Long.valueOf(getLong(this.mRowIdColumnIndex));
            if (valueOf != null) {
                synchronized (this.mUpdatedRows) {
                    Map<String, Object> map = this.mUpdatedRows.get(valueOf);
                    if (map == null) {
                        map = new HashMap<>();
                        this.mUpdatedRows.put(valueOf, map);
                    }
                    map.put(getColumnNames()[i4], obj);
                }
                return true;
            }
            throw new IllegalStateException("null rowid. mRowIdColumnIndex = " + this.mRowIdColumnIndex);
        }
        return false;
    }

    public boolean updateBlob(int i4, byte[] bArr) {
        return update(i4, bArr);
    }

    public boolean updateDouble(int i4, double d4) {
        return update(i4, Double.valueOf(d4));
    }

    public boolean updateFloat(int i4, float f4) {
        return update(i4, Float.valueOf(f4));
    }

    public boolean updateInt(int i4, int i5) {
        return update(i4, Integer.valueOf(i5));
    }

    public boolean updateLong(int i4, long j4) {
        return update(i4, Long.valueOf(j4));
    }

    public boolean updateShort(int i4, short s3) {
        return update(i4, Short.valueOf(s3));
    }

    public boolean updateString(int i4, String str) {
        return update(i4, str);
    }

    public boolean updateToNull(int i4) {
        return update(i4, null);
    }
}

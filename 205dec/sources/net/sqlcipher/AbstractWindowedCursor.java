package net.sqlcipher;

import android.database.CharArrayBuffer;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public abstract class AbstractWindowedCursor extends AbstractCursor {
    protected CursorWindow mWindow;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // net.sqlcipher.AbstractCursor
    public void checkPosition() {
        super.checkPosition();
        if (this.mWindow == null) {
            throw new StaleDataException("Access closed cursor");
        }
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor
    public void copyStringToBuffer(int i4, CharArrayBuffer charArrayBuffer) {
        checkPosition();
        synchronized (this.mUpdatedRows) {
            if (isFieldUpdated(i4)) {
                super.copyStringToBuffer(i4, charArrayBuffer);
            }
        }
        this.mWindow.copyStringToBuffer(this.mPos, i4, charArrayBuffer);
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor
    public byte[] getBlob(int i4) {
        checkPosition();
        synchronized (this.mUpdatedRows) {
            if (isFieldUpdated(i4)) {
                return (byte[]) getUpdatedField(i4);
            }
            return this.mWindow.getBlob(this.mPos, i4);
        }
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor
    public double getDouble(int i4) {
        checkPosition();
        synchronized (this.mUpdatedRows) {
            if (isFieldUpdated(i4)) {
                return ((Number) getUpdatedField(i4)).doubleValue();
            }
            return this.mWindow.getDouble(this.mPos, i4);
        }
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor
    public float getFloat(int i4) {
        checkPosition();
        synchronized (this.mUpdatedRows) {
            if (isFieldUpdated(i4)) {
                return ((Number) getUpdatedField(i4)).floatValue();
            }
            return this.mWindow.getFloat(this.mPos, i4);
        }
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor
    public int getInt(int i4) {
        checkPosition();
        synchronized (this.mUpdatedRows) {
            if (isFieldUpdated(i4)) {
                return ((Number) getUpdatedField(i4)).intValue();
            }
            return this.mWindow.getInt(this.mPos, i4);
        }
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor
    public long getLong(int i4) {
        checkPosition();
        synchronized (this.mUpdatedRows) {
            if (isFieldUpdated(i4)) {
                return ((Number) getUpdatedField(i4)).longValue();
            }
            return this.mWindow.getLong(this.mPos, i4);
        }
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor
    public short getShort(int i4) {
        checkPosition();
        synchronized (this.mUpdatedRows) {
            if (isFieldUpdated(i4)) {
                return ((Number) getUpdatedField(i4)).shortValue();
            }
            return this.mWindow.getShort(this.mPos, i4);
        }
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor
    public String getString(int i4) {
        checkPosition();
        synchronized (this.mUpdatedRows) {
            if (isFieldUpdated(i4)) {
                return (String) getUpdatedField(i4);
            }
            return this.mWindow.getString(this.mPos, i4);
        }
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor, net.sqlcipher.Cursor
    public int getType(int i4) {
        checkPosition();
        return this.mWindow.getType(this.mPos, i4);
    }

    public boolean hasWindow() {
        return this.mWindow != null;
    }

    public boolean isBlob(int i4) {
        boolean z3;
        checkPosition();
        synchronized (this.mUpdatedRows) {
            if (isFieldUpdated(i4)) {
                Object updatedField = getUpdatedField(i4);
                if (updatedField != null && !(updatedField instanceof byte[])) {
                    z3 = false;
                    return z3;
                }
                z3 = true;
                return z3;
            }
            return this.mWindow.isBlob(this.mPos, i4);
        }
    }

    public boolean isFloat(int i4) {
        checkPosition();
        synchronized (this.mUpdatedRows) {
            if (isFieldUpdated(i4)) {
                Object updatedField = getUpdatedField(i4);
                return updatedField != null && ((updatedField instanceof Float) || (updatedField instanceof Double));
            }
            return this.mWindow.isFloat(this.mPos, i4);
        }
    }

    public boolean isLong(int i4) {
        checkPosition();
        synchronized (this.mUpdatedRows) {
            if (isFieldUpdated(i4)) {
                Object updatedField = getUpdatedField(i4);
                return updatedField != null && ((updatedField instanceof Integer) || (updatedField instanceof Long));
            }
            return this.mWindow.isLong(this.mPos, i4);
        }
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor
    public boolean isNull(int i4) {
        checkPosition();
        synchronized (this.mUpdatedRows) {
            if (isFieldUpdated(i4)) {
                return getUpdatedField(i4) == null;
            }
            return this.mWindow.isNull(this.mPos, i4);
        }
    }

    public boolean isString(int i4) {
        boolean z3;
        checkPosition();
        synchronized (this.mUpdatedRows) {
            if (isFieldUpdated(i4)) {
                Object updatedField = getUpdatedField(i4);
                if (updatedField != null && !(updatedField instanceof String)) {
                    z3 = false;
                    return z3;
                }
                z3 = true;
                return z3;
            }
            return this.mWindow.isString(this.mPos, i4);
        }
    }

    public void setWindow(CursorWindow cursorWindow) {
        CursorWindow cursorWindow2 = this.mWindow;
        if (cursorWindow2 != null) {
            cursorWindow2.close();
        }
        this.mWindow = cursorWindow;
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.CrossProcessCursor
    public CursorWindow getWindow() {
        return this.mWindow;
    }
}

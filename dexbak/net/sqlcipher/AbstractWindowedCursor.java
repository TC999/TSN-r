package net.sqlcipher;

import android.database.CharArrayBuffer;

/* loaded from: E:\fuckcool\tsn\5406560.dex */
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
    public void copyStringToBuffer(int i, CharArrayBuffer charArrayBuffer) {
        checkPosition();
        synchronized (this.mUpdatedRows) {
            if (isFieldUpdated(i)) {
                super.copyStringToBuffer(i, charArrayBuffer);
            }
        }
        this.mWindow.copyStringToBuffer(this.mPos, i, charArrayBuffer);
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor
    public byte[] getBlob(int i) {
        checkPosition();
        synchronized (this.mUpdatedRows) {
            if (isFieldUpdated(i)) {
                return (byte[]) getUpdatedField(i);
            }
            return this.mWindow.getBlob(this.mPos, i);
        }
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor
    public double getDouble(int i) {
        checkPosition();
        synchronized (this.mUpdatedRows) {
            if (isFieldUpdated(i)) {
                return ((Number) getUpdatedField(i)).doubleValue();
            }
            return this.mWindow.getDouble(this.mPos, i);
        }
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor
    public float getFloat(int i) {
        checkPosition();
        synchronized (this.mUpdatedRows) {
            if (isFieldUpdated(i)) {
                return ((Number) getUpdatedField(i)).floatValue();
            }
            return this.mWindow.getFloat(this.mPos, i);
        }
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor
    public int getInt(int i) {
        checkPosition();
        synchronized (this.mUpdatedRows) {
            if (isFieldUpdated(i)) {
                return ((Number) getUpdatedField(i)).intValue();
            }
            return this.mWindow.getInt(this.mPos, i);
        }
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor
    public long getLong(int i) {
        checkPosition();
        synchronized (this.mUpdatedRows) {
            if (isFieldUpdated(i)) {
                return ((Number) getUpdatedField(i)).longValue();
            }
            return this.mWindow.getLong(this.mPos, i);
        }
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor
    public short getShort(int i) {
        checkPosition();
        synchronized (this.mUpdatedRows) {
            if (isFieldUpdated(i)) {
                return ((Number) getUpdatedField(i)).shortValue();
            }
            return this.mWindow.getShort(this.mPos, i);
        }
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor
    public String getString(int i) {
        checkPosition();
        synchronized (this.mUpdatedRows) {
            if (isFieldUpdated(i)) {
                return (String) getUpdatedField(i);
            }
            return this.mWindow.getString(this.mPos, i);
        }
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor, net.sqlcipher.Cursor
    public int getType(int i) {
        checkPosition();
        return this.mWindow.getType(this.mPos, i);
    }

    public boolean hasWindow() {
        return this.mWindow != null;
    }

    public boolean isBlob(int i) {
        boolean z;
        checkPosition();
        synchronized (this.mUpdatedRows) {
            if (isFieldUpdated(i)) {
                Object updatedField = getUpdatedField(i);
                if (updatedField != null && !(updatedField instanceof byte[])) {
                    z = false;
                    return z;
                }
                z = true;
                return z;
            }
            return this.mWindow.isBlob(this.mPos, i);
        }
    }

    public boolean isFloat(int i) {
        checkPosition();
        synchronized (this.mUpdatedRows) {
            if (isFieldUpdated(i)) {
                Object updatedField = getUpdatedField(i);
                return updatedField != null && ((updatedField instanceof Float) || (updatedField instanceof Double));
            }
            return this.mWindow.isFloat(this.mPos, i);
        }
    }

    public boolean isLong(int i) {
        checkPosition();
        synchronized (this.mUpdatedRows) {
            if (isFieldUpdated(i)) {
                Object updatedField = getUpdatedField(i);
                return updatedField != null && ((updatedField instanceof Integer) || (updatedField instanceof Long));
            }
            return this.mWindow.isLong(this.mPos, i);
        }
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor
    public boolean isNull(int i) {
        checkPosition();
        synchronized (this.mUpdatedRows) {
            if (isFieldUpdated(i)) {
                return getUpdatedField(i) == null;
            }
            return this.mWindow.isNull(this.mPos, i);
        }
    }

    public boolean isString(int i) {
        boolean z;
        checkPosition();
        synchronized (this.mUpdatedRows) {
            if (isFieldUpdated(i)) {
                Object updatedField = getUpdatedField(i);
                if (updatedField != null && !(updatedField instanceof String)) {
                    z = false;
                    return z;
                }
                z = true;
                return z;
            }
            return this.mWindow.isString(this.mPos, i);
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

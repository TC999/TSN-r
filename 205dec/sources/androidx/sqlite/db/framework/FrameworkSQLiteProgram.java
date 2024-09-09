package androidx.sqlite.db.framework;

import android.database.sqlite.SQLiteProgram;
import androidx.sqlite.db.SupportSQLiteProgram;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
class FrameworkSQLiteProgram implements SupportSQLiteProgram {
    private final SQLiteProgram mDelegate;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FrameworkSQLiteProgram(SQLiteProgram sQLiteProgram) {
        this.mDelegate = sQLiteProgram;
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindBlob(int i4, byte[] bArr) {
        this.mDelegate.bindBlob(i4, bArr);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindDouble(int i4, double d4) {
        this.mDelegate.bindDouble(i4, d4);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindLong(int i4, long j4) {
        this.mDelegate.bindLong(i4, j4);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindNull(int i4) {
        this.mDelegate.bindNull(i4);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindString(int i4, String str) {
        this.mDelegate.bindString(i4, str);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void clearBindings() {
        this.mDelegate.clearBindings();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.mDelegate.close();
    }
}

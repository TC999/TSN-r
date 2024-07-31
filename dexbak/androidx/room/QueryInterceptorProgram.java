package androidx.room;

import androidx.sqlite.p021db.SupportSQLiteProgram;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class QueryInterceptorProgram implements SupportSQLiteProgram {
    private List<Object> mBindArgsCache = new ArrayList();

    private void saveArgsToCache(int bindIndex, Object value) {
        int i = bindIndex - 1;
        if (i >= this.mBindArgsCache.size()) {
            for (int size = this.mBindArgsCache.size(); size <= i; size++) {
                this.mBindArgsCache.add(null);
            }
        }
        this.mBindArgsCache.set(i, value);
    }

    @Override // androidx.sqlite.p021db.SupportSQLiteProgram
    public void bindBlob(int index, byte[] value) {
        saveArgsToCache(index, value);
    }

    @Override // androidx.sqlite.p021db.SupportSQLiteProgram
    public void bindDouble(int index, double value) {
        saveArgsToCache(index, Double.valueOf(value));
    }

    @Override // androidx.sqlite.p021db.SupportSQLiteProgram
    public void bindLong(int index, long value) {
        saveArgsToCache(index, Long.valueOf(value));
    }

    @Override // androidx.sqlite.p021db.SupportSQLiteProgram
    public void bindNull(int index) {
        saveArgsToCache(index, null);
    }

    @Override // androidx.sqlite.p021db.SupportSQLiteProgram
    public void bindString(int index, String value) {
        saveArgsToCache(index, value);
    }

    @Override // androidx.sqlite.p021db.SupportSQLiteProgram
    public void clearBindings() {
        this.mBindArgsCache.clear();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<Object> getBindArgs() {
        return this.mBindArgsCache;
    }
}

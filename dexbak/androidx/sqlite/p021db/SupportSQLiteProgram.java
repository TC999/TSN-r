package androidx.sqlite.p021db;

import java.io.Closeable;

/* renamed from: androidx.sqlite.db.SupportSQLiteProgram */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public interface SupportSQLiteProgram extends Closeable {
    void bindBlob(int i, byte[] bArr);

    void bindDouble(int i, double d);

    void bindLong(int i, long j);

    void bindNull(int i);

    void bindString(int i, String str);

    void clearBindings();
}

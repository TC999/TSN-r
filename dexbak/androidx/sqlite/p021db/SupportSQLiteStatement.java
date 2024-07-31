package androidx.sqlite.p021db;

/* renamed from: androidx.sqlite.db.SupportSQLiteStatement */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public interface SupportSQLiteStatement extends SupportSQLiteProgram {
    void execute();

    long executeInsert();

    int executeUpdateDelete();

    long simpleQueryForLong();

    String simpleQueryForString();
}

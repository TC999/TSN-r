package net.sqlcipher.database;

/* loaded from: E:\fuckcool\tsn\5406560.dex */
public interface SQLiteDatabaseHook {
    void postKey(SQLiteDatabase sQLiteDatabase);

    void preKey(SQLiteDatabase sQLiteDatabase);
}

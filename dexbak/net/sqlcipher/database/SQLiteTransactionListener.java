package net.sqlcipher.database;

/* loaded from: E:\fuckcool\tsn\5406560.dex */
public interface SQLiteTransactionListener {
    void onBegin();

    void onCommit();

    void onRollback();
}

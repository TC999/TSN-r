package net.sqlcipher.database;

/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class DatabaseObjectNotClosedException extends RuntimeException {

    /* renamed from: s */
    private static final String f44154s = "Application did not close the cursor or database object that was opened here";

    public DatabaseObjectNotClosedException() {
        super(f44154s);
    }
}

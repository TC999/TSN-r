package net.sqlcipher.database;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class DatabaseObjectNotClosedException extends RuntimeException {

    /* renamed from: s  reason: collision with root package name */
    private static final String f61568s = "Application did not close the cursor or database object that was opened here";

    public DatabaseObjectNotClosedException() {
        super("Application did not close the cursor or database object that was opened here");
    }
}

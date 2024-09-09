package net.sqlcipher;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class CursorIndexOutOfBoundsException extends IndexOutOfBoundsException {
    public CursorIndexOutOfBoundsException(int i4, int i5) {
        super("Index " + i4 + " requested, with a size of " + i5);
    }

    public CursorIndexOutOfBoundsException(String str) {
        super(str);
    }
}

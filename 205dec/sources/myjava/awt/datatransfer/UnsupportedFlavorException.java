package myjava.awt.datatransfer;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class UnsupportedFlavorException extends Exception {
    private static final long serialVersionUID = 5383814944251665601L;

    public UnsupportedFlavorException(DataFlavor dataFlavor) {
        super("flavor = " + String.valueOf(dataFlavor));
    }
}

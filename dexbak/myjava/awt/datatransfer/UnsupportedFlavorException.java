package myjava.awt.datatransfer;

/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class UnsupportedFlavorException extends Exception {
    private static final long serialVersionUID = 5383814944251665601L;

    public UnsupportedFlavorException(DataFlavor dataFlavor) {
        super("flavor = " + String.valueOf(dataFlavor));
    }
}

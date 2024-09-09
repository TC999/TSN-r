package myjava.awt.datatransfer;

import java.io.IOException;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public interface Transferable {
    Object getTransferData(DataFlavor dataFlavor) throws UnsupportedFlavorException, IOException;

    DataFlavor[] getTransferDataFlavors();

    boolean isDataFlavorSupported(DataFlavor dataFlavor);
}

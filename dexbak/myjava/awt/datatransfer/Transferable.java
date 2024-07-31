package myjava.awt.datatransfer;

import java.io.IOException;

/* loaded from: E:\fuckcool\tsn\5406560.dex */
public interface Transferable {
    Object getTransferData(DataFlavor dataFlavor) throws UnsupportedFlavorException, IOException;

    DataFlavor[] getTransferDataFlavors();

    boolean isDataFlavorSupported(DataFlavor dataFlavor);
}

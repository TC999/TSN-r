package javax.activation;

import java.io.IOException;
import java.io.OutputStream;
import myjava.awt.datatransfer.DataFlavor;
import myjava.awt.datatransfer.UnsupportedFlavorException;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public interface DataContentHandler {
    Object getContent(DataSource dataSource) throws IOException;

    Object getTransferData(DataFlavor dataFlavor, DataSource dataSource) throws UnsupportedFlavorException, IOException;

    DataFlavor[] getTransferDataFlavors();

    void writeTo(Object obj, String str, OutputStream outputStream) throws IOException;
}

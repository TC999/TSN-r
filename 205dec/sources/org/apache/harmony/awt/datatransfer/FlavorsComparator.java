package org.apache.harmony.awt.datatransfer;

import java.awt.datatransfer.DataFlavor;
import java.util.Comparator;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class FlavorsComparator implements Comparator<DataFlavor> {
    @Override // java.util.Comparator
    public int compare(DataFlavor dataFlavor, DataFlavor dataFlavor2) {
        if (dataFlavor.isFlavorTextType() || dataFlavor2.isFlavorTextType()) {
            if (dataFlavor.isFlavorTextType() || !dataFlavor2.isFlavorTextType()) {
                return ((!dataFlavor.isFlavorTextType() || dataFlavor2.isFlavorTextType()) && DataFlavor.selectBestTextFlavor(new DataFlavor[]{dataFlavor, dataFlavor2}) == dataFlavor) ? -1 : 1;
            }
            return -1;
        }
        return 0;
    }
}

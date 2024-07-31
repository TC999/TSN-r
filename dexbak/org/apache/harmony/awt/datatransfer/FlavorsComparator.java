package org.apache.harmony.awt.datatransfer;

import java.awt.datatransfer.DataFlavor;
import java.util.Comparator;

/* loaded from: E:\fuckcool\tsn\5406560.dex */
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

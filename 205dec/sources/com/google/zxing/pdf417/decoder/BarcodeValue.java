package com.google.zxing.pdf417.decoder;

import com.google.zxing.pdf417.PDF417Common;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
final class BarcodeValue {
    private final Map<Integer, Integer> values = new HashMap();

    public Integer getConfidence(int i4) {
        return this.values.get(Integer.valueOf(i4));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int[] getValue() {
        ArrayList arrayList = new ArrayList();
        int i4 = -1;
        for (Map.Entry<Integer, Integer> entry : this.values.entrySet()) {
            if (entry.getValue().intValue() > i4) {
                i4 = entry.getValue().intValue();
                arrayList.clear();
                arrayList.add(entry.getKey());
            } else if (entry.getValue().intValue() == i4) {
                arrayList.add(entry.getKey());
            }
        }
        return PDF417Common.toIntArray(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setValue(int i4) {
        Integer num = this.values.get(Integer.valueOf(i4));
        if (num == null) {
            num = 0;
        }
        this.values.put(Integer.valueOf(i4), Integer.valueOf(num.intValue() + 1));
    }
}

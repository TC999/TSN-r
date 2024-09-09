package com.github.mikephil.charting.utils;

import com.github.mikephil.charting.data.Entry;
import java.util.Comparator;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class EntryXComparator implements Comparator<Entry> {
    @Override // java.util.Comparator
    public int compare(Entry entry, Entry entry2) {
        float x3 = entry.getX() - entry2.getX();
        if (x3 == 0.0f) {
            return 0;
        }
        return x3 > 0.0f ? 1 : -1;
    }
}

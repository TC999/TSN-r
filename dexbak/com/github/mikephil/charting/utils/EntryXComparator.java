package com.github.mikephil.charting.utils;

import com.github.mikephil.charting.data.Entry;
import java.util.Comparator;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class EntryXComparator implements Comparator<Entry> {
    @Override // java.util.Comparator
    public int compare(Entry entry, Entry entry2) {
        float x = entry.getX() - entry2.getX();
        if (x == 0.0f) {
            return 0;
        }
        return x > 0.0f ? 1 : -1;
    }
}

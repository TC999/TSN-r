package com.ss.android.socialbase.downloader.q;

import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class p<K, T> extends LinkedHashMap<K, T> {
    private int ok;

    public p() {
        this(4, 4);
    }

    public void ok(int i4) {
        this.ok = i4;
    }

    @Override // java.util.LinkedHashMap
    protected boolean removeEldestEntry(Map.Entry<K, T> entry) {
        return size() > this.ok;
    }

    public p(int i4, int i5) {
        this(i4, i5, true);
    }

    public p(int i4, int i5, boolean z3) {
        super(i4, 0.75f, z3);
        ok(i5);
    }
}

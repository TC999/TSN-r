package com.p521ss.android.socialbase.downloader.p556q;

import java.util.LinkedHashMap;
import java.util.Map;

/* renamed from: com.ss.android.socialbase.downloader.q.p */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12718p<K, T> extends LinkedHashMap<K, T> {

    /* renamed from: ok */
    private int f35811ok;

    public C12718p() {
        this(4, 4);
    }

    /* renamed from: ok */
    public void m16509ok(int i) {
        this.f35811ok = i;
    }

    @Override // java.util.LinkedHashMap
    protected boolean removeEldestEntry(Map.Entry<K, T> entry) {
        return size() > this.f35811ok;
    }

    public C12718p(int i, int i2) {
        this(i, i2, true);
    }

    public C12718p(int i, int i2, boolean z) {
        super(i, 0.75f, z);
        m16509ok(i2);
    }
}

package com.ss.android.socialbase.downloader.gd;

import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class ev<K, T> extends LinkedHashMap<K, T> {

    /* renamed from: c  reason: collision with root package name */
    private int f49649c;

    public ev() {
        this(4, 4);
    }

    public void c(int i4) {
        this.f49649c = i4;
    }

    @Override // java.util.LinkedHashMap
    protected boolean removeEldestEntry(Map.Entry<K, T> entry) {
        return size() > this.f49649c;
    }

    public ev(int i4, int i5) {
        this(i4, i5, true);
    }

    public ev(int i4, int i5, boolean z3) {
        super(i4, 0.75f, z3);
        c(i5);
    }
}

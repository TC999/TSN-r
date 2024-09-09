package com.mbridge.msdk.foundation.same.net.e;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* compiled from: NetworkResponse.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public final int f39545a;

    /* renamed from: b  reason: collision with root package name */
    public final byte[] f39546b;

    /* renamed from: c  reason: collision with root package name */
    public final Map<String, String> f39547c;

    /* renamed from: d  reason: collision with root package name */
    public final List<com.mbridge.msdk.foundation.same.net.c.b> f39548d;

    public c(int i4, byte[] bArr, List<com.mbridge.msdk.foundation.same.net.c.b> list) {
        this(i4, bArr, a(list), list);
    }

    private static Map<String, String> a(List<com.mbridge.msdk.foundation.same.net.c.b> list) {
        if (list == null) {
            return null;
        }
        if (list.isEmpty()) {
            return Collections.emptyMap();
        }
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        for (com.mbridge.msdk.foundation.same.net.c.b bVar : list) {
            treeMap.put(bVar.a(), bVar.b());
        }
        return treeMap;
    }

    private c(int i4, byte[] bArr, Map<String, String> map, List<com.mbridge.msdk.foundation.same.net.c.b> list) {
        this.f39545a = i4;
        this.f39546b = bArr;
        this.f39547c = map;
        if (list == null) {
            this.f39548d = null;
        } else {
            this.f39548d = Collections.unmodifiableList(list);
        }
    }
}

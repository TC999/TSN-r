package com.mbridge.msdk.foundation.same.net.p484e;

import com.mbridge.msdk.foundation.same.net.p482c.C11336b;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* renamed from: com.mbridge.msdk.foundation.same.net.e.c */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class NetworkResponse {

    /* renamed from: a */
    public final int f30751a;

    /* renamed from: b */
    public final byte[] f30752b;

    /* renamed from: c */
    public final Map<String, String> f30753c;

    /* renamed from: d */
    public final List<C11336b> f30754d;

    public NetworkResponse(int i, byte[] bArr, List<C11336b> list) {
        this(i, bArr, m22268a(list), list);
    }

    /* renamed from: a */
    private static Map<String, String> m22268a(List<C11336b> list) {
        if (list == null) {
            return null;
        }
        if (list.isEmpty()) {
            return Collections.emptyMap();
        }
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        for (C11336b c11336b : list) {
            treeMap.put(c11336b.m22291a(), c11336b.m22290b());
        }
        return treeMap;
    }

    private NetworkResponse(int i, byte[] bArr, Map<String, String> map, List<C11336b> list) {
        this.f30751a = i;
        this.f30752b = bArr;
        this.f30753c = map;
        if (list == null) {
            this.f30754d = null;
        } else {
            this.f30754d = Collections.unmodifiableList(list);
        }
    }
}

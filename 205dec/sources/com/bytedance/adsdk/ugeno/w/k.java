package com.bytedance.adsdk.ugeno.w;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class k {

    /* renamed from: a  reason: collision with root package name */
    private static Map<String, n> f26401a = new HashMap();

    public static n a(String str) {
        return f26401a.get(str);
    }

    public static void b(List<n> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        for (n nVar : list) {
            if (nVar != null) {
                f26401a.put(nVar.c(), nVar);
            }
        }
    }
}

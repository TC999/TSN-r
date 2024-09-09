package com.bytedance.msdk.f;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class q {

    /* renamed from: c  reason: collision with root package name */
    private static Map<Integer, Integer> f28351c = new ConcurrentHashMap();

    public static Integer c(int i4) {
        Integer num = f28351c.get(Integer.valueOf(i4));
        if (num == null) {
            Integer valueOf = Integer.valueOf(i4);
            f28351c.put(Integer.valueOf(i4), valueOf);
            return valueOf;
        }
        return num;
    }
}

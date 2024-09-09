package com.bytedance.sdk.openadsdk.ats;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class AutoService implements Bridge {

    /* renamed from: c  reason: collision with root package name */
    private static List<Bridge> f31500c = new ArrayList();

    public static <T> T c(Class<T> cls) {
        T t3 = (T) c.c().c(cls);
        if (t3 == null && f31500c.size() > 0) {
            Iterator<Bridge> it = f31500c.iterator();
            while (it.hasNext() && (t3 = (T) it.next().call(1, null, cls)) == null) {
            }
        }
        return t3;
    }

    public static Bridge init(Bridge bridge) {
        if (bridge != null) {
            f31500c.add(bridge);
        }
        return new AutoService();
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i4, ValueSet valueSet, Class<T> cls) {
        if (i4 != 1) {
            return null;
        }
        return (T) c.c().c(cls);
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return null;
    }
}

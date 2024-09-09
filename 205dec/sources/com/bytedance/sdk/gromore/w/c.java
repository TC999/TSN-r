package com.bytedance.sdk.gromore.w;

import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c implements Bridge {

    /* renamed from: c  reason: collision with root package name */
    private static volatile c f31282c;

    /* renamed from: w  reason: collision with root package name */
    private static Bridge f31283w;

    private c() {
    }

    public static void c(Bridge bridge) {
        f31283w = bridge;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i4, ValueSet valueSet, Class<T> cls) {
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return null;
    }

    public static c c() {
        if (f31282c == null) {
            synchronized (c.class) {
                if (f31282c == null) {
                    f31282c = new c();
                }
            }
        }
        return f31282c;
    }

    public void c(String str, String str2) {
        if (f31283w != null) {
            b a4 = b.a();
            a4.i(20000, str);
            a4.i(20001, str2);
            f31283w.call(10000, a4.l(), null);
        }
    }
}

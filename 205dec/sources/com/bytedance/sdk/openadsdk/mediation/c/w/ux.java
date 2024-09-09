package com.bytedance.sdk.openadsdk.mediation.c.w;

import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class ux {

    /* renamed from: c  reason: collision with root package name */
    private Bridge f36129c;

    public ux(Bridge bridge) {
        this.f36129c = bridge == null ? b.f24741d : bridge;
    }

    public int c() {
        return ((Integer) this.f36129c.call(271044, b.b(0).l(), Integer.TYPE)).intValue();
    }

    public c w() {
        return new c((ValueSet) this.f36129c.call(271045, b.b(0).l(), ValueSet.class));
    }

    public List<String> xv() {
        return (List) this.f36129c.call(271046, b.b(0).l(), List.class);
    }
}

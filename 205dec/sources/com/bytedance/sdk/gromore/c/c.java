package com.bytedance.sdk.gromore.c;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.ad.c.w.c.xv;
import com.bytedance.sdk.openadsdk.mediation.c.w.w;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c {

    /* renamed from: c  reason: collision with root package name */
    private ValueSet f31133c;

    /* renamed from: w  reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.mediation.c.w.c f31134w;

    public c(ValueSet valueSet) {
        this.f31133c = valueSet;
        this.f31134w = new com.bytedance.sdk.openadsdk.mediation.c.w.c(valueSet);
    }

    public int c() {
        return this.f31134w.ev();
    }

    public Bridge ev() {
        ValueSet valueSet = this.f31133c;
        if (valueSet != null) {
            return (Bridge) valueSet.objectValue(8302, Bridge.class);
        }
        return null;
    }

    public w f() {
        com.bytedance.sdk.openadsdk.mediation.c.w.c cVar = this.f31134w;
        if (cVar != null) {
            return cVar.c();
        }
        return null;
    }

    public int gd() {
        ValueSet valueSet = this.f31133c;
        if (valueSet != null) {
            return valueSet.intValue(3);
        }
        return 0;
    }

    public xv r() {
        if (f() != null) {
            return f().bk();
        }
        return null;
    }

    public float sr() {
        return this.f31134w.k();
    }

    public String ux() {
        return this.f31134w.f();
    }

    public int w() {
        return this.f31134w.gd();
    }

    public float xv() {
        return this.f31134w.p();
    }
}

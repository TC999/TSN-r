package com.bytedance.sdk.openadsdk.mediation.c.c.w;

import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.MediationAppDialogClickListener;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class ux implements Bridge {

    /* renamed from: c  reason: collision with root package name */
    private ValueSet f36115c = b.f24740c;

    /* renamed from: w  reason: collision with root package name */
    private final MediationAppDialogClickListener f36116w;

    public ux(MediationAppDialogClickListener mediationAppDialogClickListener) {
        this.f36116w = mediationAppDialogClickListener;
    }

    protected void c(int i4, ValueSet valueSet, Class cls) {
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i4, ValueSet valueSet, Class<T> cls) {
        if (this.f36116w == null) {
            return null;
        }
        if (i4 == 270025) {
            this.f36116w.onButtonClick(valueSet.intValue(0));
        }
        c(i4, valueSet, cls);
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return this.f36115c;
    }
}

package com.bytedance.sdk.openadsdk.mediation.ok.ok.a;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.MediationAppDialogClickListener;

/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class n implements Bridge {

    /* renamed from: a  reason: collision with root package name */
    private final MediationAppDialogClickListener f36236a;
    private ValueSet ok = com.bykv.ok.ok.ok.ok.a.f24747c;

    public n(MediationAppDialogClickListener mediationAppDialogClickListener) {
        this.f36236a = mediationAppDialogClickListener;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i4, ValueSet valueSet, Class<T> cls) {
        if (this.f36236a == null) {
            return null;
        }
        if (i4 == 270025) {
            this.f36236a.onButtonClick(valueSet.intValue(0));
        }
        ok(i4, valueSet, cls);
        return null;
    }

    protected void ok(int i4, ValueSet valueSet, Class cls) {
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return this.ok;
    }
}

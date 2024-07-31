package com.bytedance.sdk.openadsdk.mediation.p170ok.p171ok.p172a;

import com.bykv.p106ok.p107ok.p108ok.p109ok.C5930a;
import com.bykv.p110vk.openvk.api.proto.Bridge;
import com.bykv.p110vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.MediationAppDialogClickListener;

/* renamed from: com.bytedance.sdk.openadsdk.mediation.ok.ok.a.n */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class C6478n implements Bridge {

    /* renamed from: a */
    private final MediationAppDialogClickListener f22843a;

    /* renamed from: ok */
    private ValueSet f22844ok = C5930a.f21279c;

    public C6478n(MediationAppDialogClickListener mediationAppDialogClickListener) {
        this.f22843a = mediationAppDialogClickListener;
    }

    @Override // com.bykv.p110vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        if (this.f22843a == null) {
            return null;
        }
        if (i == 270025) {
            this.f22843a.onButtonClick(valueSet.intValue(0));
        }
        m36222ok(i, valueSet, cls);
        return null;
    }

    /* renamed from: ok */
    protected void m36222ok(int i, ValueSet valueSet, Class cls) {
    }

    @Override // com.bykv.p110vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return this.f22844ok;
    }
}

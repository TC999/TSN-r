package com.bytedance.sdk.openadsdk.mediation.p170ok.p171ok.p172a;

import com.bykv.p106ok.p107ok.p108ok.p109ok.C5930a;
import com.bykv.p110vk.openvk.api.proto.Bridge;
import com.bykv.p110vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.IMediationNativeAdTokenCallback;
import com.bytedance.sdk.openadsdk.mediation.p170ok.p171ok.p173ok.C6489bl;

/* renamed from: com.bytedance.sdk.openadsdk.mediation.ok.ok.a.bl */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class C6477bl implements Bridge {

    /* renamed from: a */
    private final IMediationNativeAdTokenCallback f22841a;

    /* renamed from: ok */
    private ValueSet f22842ok = C5930a.f21279c;

    public C6477bl(IMediationNativeAdTokenCallback iMediationNativeAdTokenCallback) {
        this.f22841a = iMediationNativeAdTokenCallback;
    }

    @Override // com.bykv.p110vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        if (this.f22841a == null) {
            return null;
        }
        switch (i) {
            case 270026:
                C6489bl c6489bl = new C6489bl((Bridge) valueSet.objectValue(1, Bridge.class));
                this.f22841a.onAdTokenLoaded((String) valueSet.objectValue(0, String.class), c6489bl);
                break;
            case 270027:
                this.f22841a.onAdTokenLoadedFail(valueSet.intValue(0), (String) valueSet.objectValue(1, String.class));
                break;
        }
        m36223ok(i, valueSet, cls);
        return null;
    }

    /* renamed from: ok */
    protected void m36223ok(int i, ValueSet valueSet, Class cls) {
    }

    @Override // com.bykv.p110vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return this.f22842ok;
    }
}

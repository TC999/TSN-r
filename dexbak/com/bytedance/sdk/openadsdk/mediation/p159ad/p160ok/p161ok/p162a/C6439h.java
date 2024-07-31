package com.bytedance.sdk.openadsdk.mediation.p159ad.p160ok.p161ok.p162a;

import com.bykv.p106ok.p107ok.p108ok.p109ok.C5930a;
import com.bykv.p110vk.openvk.api.proto.Bridge;
import com.bykv.p110vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.p159ad.MediationShakeViewListener;

/* renamed from: com.bytedance.sdk.openadsdk.mediation.ad.ok.ok.a.h */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class C6439h implements Bridge {

    /* renamed from: a */
    private final MediationShakeViewListener f22694a;

    /* renamed from: ok */
    private ValueSet f22695ok = C5930a.f21279c;

    public C6439h(MediationShakeViewListener mediationShakeViewListener) {
        this.f22694a = mediationShakeViewListener;
    }

    @Override // com.bykv.p110vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        MediationShakeViewListener mediationShakeViewListener = this.f22694a;
        if (mediationShakeViewListener == null) {
            return null;
        }
        if (i == 270012) {
            mediationShakeViewListener.onDismissed();
        }
        m36277ok(i, valueSet, cls);
        return null;
    }

    /* renamed from: ok */
    protected void m36277ok(int i, ValueSet valueSet, Class cls) {
    }

    @Override // com.bykv.p110vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return this.f22695ok;
    }
}

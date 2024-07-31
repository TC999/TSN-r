package com.bytedance.sdk.openadsdk.mediation.p170ok.p171ok;

import com.bykv.p106ok.p107ok.p108ok.p109ok.C5930a;
import com.bykv.p110vk.openvk.api.proto.Bridge;
import com.bykv.p110vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.p159ad.MediationAdDislike;

/* renamed from: com.bytedance.sdk.openadsdk.mediation.ok.ok.k */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class C6484k implements Bridge {

    /* renamed from: a */
    private final MediationAdDislike f22852a;

    /* renamed from: ok */
    private ValueSet f22853ok = C5930a.f21279c;

    public C6484k(MediationAdDislike mediationAdDislike) {
        this.f22852a = mediationAdDislike;
    }

    @Override // com.bykv.p110vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        MediationAdDislike mediationAdDislike = this.f22852a;
        if (mediationAdDislike == null) {
            return null;
        }
        switch (i) {
            case 270032:
                mediationAdDislike.showDislikeDialog();
                break;
            case 270033:
                this.f22852a.setDislikeCallback(new C6485kf((Bridge) valueSet.objectValue(0, Bridge.class)));
                break;
        }
        m36218ok(i, valueSet, cls);
        return null;
    }

    /* renamed from: ok */
    protected void m36218ok(int i, ValueSet valueSet, Class cls) {
    }

    @Override // com.bykv.p110vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return this.f22853ok;
    }
}

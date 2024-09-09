package com.bytedance.sdk.openadsdk.mediation.ok.ok;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationAdDislike;

/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class k implements Bridge {

    /* renamed from: a  reason: collision with root package name */
    private final MediationAdDislike f36239a;
    private ValueSet ok = com.bykv.ok.ok.ok.ok.a.f24747c;

    public k(MediationAdDislike mediationAdDislike) {
        this.f36239a = mediationAdDislike;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i4, ValueSet valueSet, Class<T> cls) {
        MediationAdDislike mediationAdDislike = this.f36239a;
        if (mediationAdDislike == null) {
            return null;
        }
        switch (i4) {
            case 270032:
                mediationAdDislike.showDislikeDialog();
                break;
            case 270033:
                this.f36239a.setDislikeCallback(new kf((Bridge) valueSet.objectValue(0, Bridge.class)));
                break;
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

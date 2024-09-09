package com.bytedance.sdk.openadsdk.mediation.c.c;

import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationAdDislike;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class p implements Bridge {

    /* renamed from: c  reason: collision with root package name */
    private ValueSet f36105c = b.f24740c;

    /* renamed from: w  reason: collision with root package name */
    private final MediationAdDislike f36106w;

    public p(MediationAdDislike mediationAdDislike) {
        this.f36106w = mediationAdDislike;
    }

    protected void c(int i4, ValueSet valueSet, Class cls) {
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i4, ValueSet valueSet, Class<T> cls) {
        MediationAdDislike mediationAdDislike = this.f36106w;
        if (mediationAdDislike == null) {
            return null;
        }
        switch (i4) {
            case 270032:
                mediationAdDislike.showDislikeDialog();
                break;
            case 270033:
                this.f36106w.setDislikeCallback(new f((Bridge) valueSet.objectValue(0, Bridge.class)));
                break;
        }
        c(i4, valueSet, cls);
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return this.f36105c;
    }
}

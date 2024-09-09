package com.bytedance.sdk.openadsdk.mediation.ad.c.c.c;

import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.mediation.ad.IMediationDislikeCallback;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationAdDislike;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class w implements MediationAdDislike {

    /* renamed from: c  reason: collision with root package name */
    private final Bridge f36023c;

    public w(Bridge bridge) {
        this.f36023c = bridge == null ? b.f24741d : bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.MediationAdDislike
    public void setDislikeCallback(IMediationDislikeCallback iMediationDislikeCallback) {
        b b4 = b.b(1);
        b4.h(0, new com.bytedance.sdk.openadsdk.mediation.ad.c.c.w.w(iMediationDislikeCallback));
        this.f36023c.call(270033, b4.l(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.MediationAdDislike
    public void showDislikeDialog() {
        this.f36023c.call(270032, b.b(0).l(), Void.class);
    }
}

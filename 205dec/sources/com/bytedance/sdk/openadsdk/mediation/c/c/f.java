package com.bytedance.sdk.openadsdk.mediation.c.c;

import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.mediation.ad.IMediationDislikeCallback;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class f implements IMediationDislikeCallback {

    /* renamed from: c  reason: collision with root package name */
    private final Bridge f36102c;

    public f(Bridge bridge) {
        this.f36102c = bridge == null ? b.f24741d : bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationDislikeCallback
    public void onCancel() {
        this.f36102c.call(268014, b.b(0).l(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationDislikeCallback
    public void onSelected(int i4, String str) {
        b b4 = b.b(2);
        b4.e(0, i4);
        b4.i(1, str);
        this.f36102c.call(268013, b4.l(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationDislikeCallback
    public void onShow() {
        this.f36102c.call(268015, b.b(0).l(), Void.class);
    }
}

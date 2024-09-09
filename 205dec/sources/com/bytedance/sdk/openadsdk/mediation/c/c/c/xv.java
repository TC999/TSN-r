package com.bytedance.sdk.openadsdk.mediation.c.c.c;

import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.mediation.IMediationNativeTokenInfo;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class xv implements IMediationNativeTokenInfo {

    /* renamed from: c  reason: collision with root package name */
    private final Bridge f36100c;

    public xv(Bridge bridge) {
        this.f36100c = bridge == null ? b.f24741d : bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.IMediationNativeTokenInfo
    public void loadNativeAdByAdm(String str, TTAdNative.FeedAdListener feedAdListener) {
        b b4 = b.b(2);
        b4.i(0, str);
        b4.h(1, new com.bytedance.sdk.openadsdk.fz.c.c.c.w(feedAdListener));
        this.f36100c.call(270028, b4.l(), Void.class);
    }
}

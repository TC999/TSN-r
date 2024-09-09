package com.bytedance.sdk.openadsdk.mediation.c.c.c;

import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.mediation.IMediationDrawTokenInfo;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class c implements IMediationDrawTokenInfo {

    /* renamed from: c  reason: collision with root package name */
    private final Bridge f36098c;

    public c(Bridge bridge) {
        this.f36098c = bridge == null ? b.f24741d : bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.IMediationDrawTokenInfo
    public void loadDrawAdByAdm(String str, TTAdNative.DrawFeedAdListener drawFeedAdListener) {
        b b4 = b.b(2);
        b4.i(0, str);
        b4.h(1, new com.bytedance.sdk.openadsdk.fz.c.c.c.c(drawFeedAdListener));
        this.f36098c.call(270031, b4.l(), Void.class);
    }
}

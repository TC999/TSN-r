package com.bytedance.sdk.openadsdk.i.c.w.c;

import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.Bridge;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class w {

    /* renamed from: c  reason: collision with root package name */
    private final Bridge f35899c;

    public w(Bridge bridge) {
        this.f35899c = bridge == null ? b.f24741d : bridge;
    }

    public void onFeedRewardCountDown(int i4) {
        b b4 = b.b(1);
        b4.e(0, i4);
        this.f35899c.call(163101, b4.l(), Void.class);
    }
}

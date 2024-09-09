package com.bytedance.sdk.openadsdk.q.c.w.c;

import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.Bridge;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class c {

    /* renamed from: c  reason: collision with root package name */
    private final Bridge f36258c;

    public c(Bridge bridge) {
        this.f36258c = bridge == null ? b.f24741d : bridge;
    }

    public void onAdClose() {
        this.f36258c.call(131103, b.b(0).l(), Void.class);
    }

    public void onAdShow() {
        this.f36258c.call(131101, b.b(0).l(), Void.class);
    }

    public void onAdVideoBarClick() {
        this.f36258c.call(131102, b.b(0).l(), Void.class);
    }

    public void onSkippedVideo() {
        this.f36258c.call(131105, b.b(0).l(), Void.class);
    }

    public void onVideoComplete() {
        this.f36258c.call(131104, b.b(0).l(), Void.class);
    }
}

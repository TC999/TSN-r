package com.bytedance.sdk.openadsdk.ls.c.w.c;

import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.Bridge;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class xv {

    /* renamed from: c  reason: collision with root package name */
    private final Bridge f35970c;

    public xv(Bridge bridge) {
        this.f35970c = bridge == null ? b.f24741d : bridge;
    }

    public void onClickRetry() {
        this.f35970c.call(152108, b.b(0).l(), Void.class);
    }

    public void onProgressUpdate(long j4, long j5) {
        b b4 = b.b(2);
        b4.f(0, j4);
        b4.f(1, j5);
        this.f35970c.call(152106, b4.l(), Void.class);
    }

    public void onVideoAdComplete() {
        this.f35970c.call(152107, b.b(0).l(), Void.class);
    }

    public void onVideoAdContinuePlay() {
        this.f35970c.call(152105, b.b(0).l(), Void.class);
    }

    public void onVideoAdPaused() {
        this.f35970c.call(152104, b.b(0).l(), Void.class);
    }

    public void onVideoAdStartPlay() {
        this.f35970c.call(152103, b.b(0).l(), Void.class);
    }

    public void onVideoError(int i4, int i5) {
        b b4 = b.b(2);
        b4.e(0, i4);
        b4.e(1, i5);
        this.f35970c.call(152102, b4.l(), Void.class);
    }

    public void onVideoLoad() {
        this.f35970c.call(152101, b.b(0).l(), Void.class);
    }
}

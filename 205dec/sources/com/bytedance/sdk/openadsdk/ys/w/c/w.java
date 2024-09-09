package com.bytedance.sdk.openadsdk.ys.w.c;

import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.Bridge;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class w {

    /* renamed from: c  reason: collision with root package name */
    private final Bridge f36462c;

    public w(Bridge bridge) {
        this.f36462c = bridge == null ? b.f24741d : bridge;
    }

    public void onDownloadActive(long j4, long j5, String str, String str2) {
        b b4 = b.b(4);
        b4.f(0, j4);
        b4.f(1, j5);
        b4.i(2, str);
        b4.i(3, str2);
        this.f36462c.call(221102, b4.l(), Void.class);
    }

    public void onDownloadFailed(long j4, long j5, String str, String str2) {
        b b4 = b.b(4);
        b4.f(0, j4);
        b4.f(1, j5);
        b4.i(2, str);
        b4.i(3, str2);
        this.f36462c.call(221104, b4.l(), Void.class);
    }

    public void onDownloadFinished(long j4, String str, String str2) {
        b b4 = b.b(3);
        b4.f(0, j4);
        b4.i(1, str);
        b4.i(2, str2);
        this.f36462c.call(221105, b4.l(), Void.class);
    }

    public void onDownloadPaused(long j4, long j5, String str, String str2) {
        b b4 = b.b(4);
        b4.f(0, j4);
        b4.f(1, j5);
        b4.i(2, str);
        b4.i(3, str2);
        this.f36462c.call(221103, b4.l(), Void.class);
    }

    public void onIdle() {
        this.f36462c.call(221101, b.b(0).l(), Void.class);
    }

    public void onInstalled(String str, String str2) {
        b b4 = b.b(2);
        b4.i(0, str);
        b4.i(1, str2);
        this.f36462c.call(221106, b4.l(), Void.class);
    }
}

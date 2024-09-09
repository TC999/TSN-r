package com.bytedance.sdk.openadsdk.i.c.w.c;

import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.ys.w.w.k;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c {

    /* renamed from: c  reason: collision with root package name */
    private final Bridge f35898c;

    public c(Bridge bridge) {
        this.f35898c = bridge == null ? b.f24741d : bridge;
    }

    public void onProgressUpdate(long j4, long j5) {
        b b4 = b.b(2);
        b4.f(0, j4);
        b4.f(1, j5);
        this.f35898c.call(161106, b4.l(), Void.class);
    }

    public void onVideoAdComplete(k kVar) {
        b b4 = b.b(1);
        b4.h(0, kVar);
        this.f35898c.call(161107, b4.l(), Void.class);
    }

    public void onVideoAdContinuePlay(k kVar) {
        b b4 = b.b(1);
        b4.h(0, kVar);
        this.f35898c.call(161105, b4.l(), Void.class);
    }

    public void onVideoAdPaused(k kVar) {
        b b4 = b.b(1);
        b4.h(0, kVar);
        this.f35898c.call(161103, b4.l(), Void.class);
    }

    public void onVideoAdStartPlay(k kVar) {
        b b4 = b.b(1);
        b4.h(0, kVar);
        this.f35898c.call(161104, b4.l(), Void.class);
    }

    public void onVideoError(int i4, int i5) {
        b b4 = b.b(2);
        b4.e(0, i4);
        b4.e(1, i5);
        this.f35898c.call(161102, b4.l(), Void.class);
    }

    public void onVideoLoad(k kVar) {
        b b4 = b.b(1);
        b4.h(0, kVar);
        this.f35898c.call(161101, b4.l(), Void.class);
    }
}

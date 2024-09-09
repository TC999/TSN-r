package com.bytedance.sdk.openadsdk.gb.c.w.c;

import android.os.Bundle;
import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.Bridge;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c {

    /* renamed from: c  reason: collision with root package name */
    private final Bridge f35885c;

    public c(Bridge bridge) {
        this.f35885c = bridge == null ? b.f24741d : bridge;
    }

    public void onAdClose() {
        this.f35885c.call(121103, b.b(0).l(), Void.class);
    }

    public void onAdShow() {
        this.f35885c.call(121101, b.b(0).l(), Void.class);
    }

    public void onAdVideoBarClick() {
        this.f35885c.call(121102, b.b(0).l(), Void.class);
    }

    public void onRewardArrived(boolean z3, int i4, Bundle bundle) {
        b b4 = b.b(3);
        b4.j(0, z3);
        b4.e(1, i4);
        b4.h(2, bundle);
        this.f35885c.call(121107, b4.l(), Void.class);
    }

    public void onRewardVerify(boolean z3, int i4, String str, int i5, String str2) {
        b b4 = b.b(5);
        b4.j(0, z3);
        b4.e(1, i4);
        b4.i(2, str);
        b4.e(3, i5);
        b4.i(4, str2);
        this.f35885c.call(121106, b4.l(), Void.class);
    }

    public void onSkippedVideo() {
        this.f35885c.call(121108, b.b(0).l(), Void.class);
    }

    public void onVideoComplete() {
        this.f35885c.call(121104, b.b(0).l(), Void.class);
    }

    public void onVideoError() {
        this.f35885c.call(121105, b.b(0).l(), Void.class);
    }
}

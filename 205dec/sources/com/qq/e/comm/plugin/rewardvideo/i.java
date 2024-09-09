package com.qq.e.comm.plugin.rewardvideo;

import com.qq.e.comm.plugin.util.d1;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class i extends com.qq.e.comm.plugin.q0.u.i {

    /* renamed from: b  reason: collision with root package name */
    private static final String f45968b = h.V;

    /* renamed from: a  reason: collision with root package name */
    private final h f45969a;

    public i(h hVar) {
        this.f45969a = hVar;
    }

    @Override // com.qq.e.comm.plugin.q0.u.i
    public String a() {
        return "onReward";
    }

    @Override // com.qq.e.comm.plugin.q0.u.i
    public void a(com.qq.e.comm.plugin.q0.h hVar, com.qq.e.comm.plugin.q0.s.d dVar) {
        String str = f45968b;
        d1.a(str, "RewardPageHandler handleAction ,action : " + dVar.a());
        if (!dVar.a().equals("onReward") || this.f45969a == null) {
            return;
        }
        d1.a(f45968b, "\u8e4a\u5f84\u53d1\u9001onReward Action\uff0c\u4e0b\u53d1\u5956\u52b1");
        this.f45969a.b(false);
    }
}

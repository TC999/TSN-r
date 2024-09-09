package com.qq.e.comm.plugin.callback.biz;

import com.qq.e.comm.plugin.h.c;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public final class LPCallbackImpl implements LPCallback {

    /* renamed from: a  reason: collision with root package name */
    private c<Void> f42157a = null;

    /* renamed from: b  reason: collision with root package name */
    private c<Void> f42158b = null;

    @Override // com.qq.e.comm.plugin.callback.biz.LPCallback
    public c<Void> g() {
        if (this.f42157a == null) {
            this.f42157a = new c<>();
        }
        return this.f42157a;
    }

    @Override // com.qq.e.comm.plugin.callback.biz.LPCallback
    public c<Void> onClose() {
        if (this.f42158b == null) {
            this.f42158b = new c<>();
        }
        return this.f42158b;
    }
}

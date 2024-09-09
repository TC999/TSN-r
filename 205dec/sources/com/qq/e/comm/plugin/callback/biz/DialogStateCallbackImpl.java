package com.qq.e.comm.plugin.callback.biz;

import com.qq.e.comm.plugin.h.c;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public final class DialogStateCallbackImpl implements DialogStateCallback {

    /* renamed from: a  reason: collision with root package name */
    private c<Integer> f42153a = null;

    /* renamed from: b  reason: collision with root package name */
    private c<Integer> f42154b = null;

    @Override // com.qq.e.comm.plugin.callback.biz.DialogStateCallback
    public c<Integer> d() {
        if (this.f42153a == null) {
            this.f42153a = new c<>();
        }
        return this.f42153a;
    }

    @Override // com.qq.e.comm.plugin.callback.biz.DialogStateCallback
    public c<Integer> onDismiss() {
        if (this.f42154b == null) {
            this.f42154b = new c<>();
        }
        return this.f42154b;
    }
}

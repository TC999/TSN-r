package com.qq.e.comm.plugin.callback.biz;

import com.qq.e.comm.plugin.callback.biz.LifecycleCallback;
import com.qq.e.comm.plugin.h.c;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public final class LifecycleCallbackImpl implements LifecycleCallback {

    /* renamed from: a  reason: collision with root package name */
    private c<LifecycleCallback.a> f42165a = null;

    @Override // com.qq.e.comm.plugin.callback.biz.LifecycleCallback
    public c<LifecycleCallback.a> l() {
        if (this.f42165a == null) {
            this.f42165a = new c<>();
        }
        return this.f42165a;
    }
}

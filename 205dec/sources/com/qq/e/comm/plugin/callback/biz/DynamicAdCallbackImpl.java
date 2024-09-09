package com.qq.e.comm.plugin.callback.biz;

import android.util.Pair;
import com.qq.e.comm.plugin.g0.e;
import com.qq.e.comm.plugin.h.c;

/* loaded from: E:\TSN-r\205dec\2450172.dex */
public final class DynamicAdCallbackImpl implements DynamicAdCallback {

    /* renamed from: a  reason: collision with root package name */
    private c<String> f42155a = null;

    /* renamed from: b  reason: collision with root package name */
    private c<Pair<String, e>> f42156b = null;

    @Override // com.qq.e.comm.plugin.callback.biz.DynamicAdCallback
    public c<String> loadAd() {
        if (this.f42155a == null) {
            this.f42155a = new c<>();
        }
        return this.f42155a;
    }

    @Override // com.qq.e.comm.plugin.callback.biz.DynamicAdCallback
    public c<Pair<String, e>> t() {
        if (this.f42156b == null) {
            this.f42156b = new c<>();
        }
        return this.f42156b;
    }
}

package com.acse.ottn.c;

import java.util.concurrent.atomic.AtomicLong;
import okhttp3.Call;
import okhttp3.EventListener;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
class d implements EventListener.Factory {

    /* renamed from: a  reason: collision with root package name */
    final AtomicLong f5316a = new AtomicLong(1);

    @Override // okhttp3.EventListener.Factory
    public EventListener create(Call call) {
        return new e(this.f5316a.getAndIncrement(), call.request().url(), System.nanoTime());
    }
}

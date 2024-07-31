package com.acse.ottn.p041c;

import java.util.concurrent.atomic.AtomicLong;
import okhttp3.Call;
import okhttp3.EventListener;

/* renamed from: com.acse.ottn.c.d */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
class C1473d implements EventListener.Factory {

    /* renamed from: a */
    final AtomicLong f2703a = new AtomicLong(1);

    @Override // okhttp3.EventListener.Factory
    public EventListener create(Call call) {
        return new C1474e(this.f2703a.getAndIncrement(), call.request().url(), System.nanoTime());
    }
}

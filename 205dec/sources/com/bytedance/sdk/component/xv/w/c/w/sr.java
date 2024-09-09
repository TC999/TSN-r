package com.bytedance.sdk.component.xv.w.c.w;

import com.bytedance.sdk.component.xv.w.eq;
import java.util.LinkedHashSet;
import java.util.Set;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class sr {

    /* renamed from: c  reason: collision with root package name */
    private final Set<eq> f30927c = new LinkedHashSet();

    public synchronized void c(eq eqVar) {
        this.f30927c.add(eqVar);
    }

    public synchronized void w(eq eqVar) {
        this.f30927c.remove(eqVar);
    }

    public synchronized boolean xv(eq eqVar) {
        return this.f30927c.contains(eqVar);
    }
}

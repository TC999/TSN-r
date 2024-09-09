package com.bumptech.glide.load.engine;

import androidx.annotation.VisibleForTesting;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: Jobs.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
final class r {

    /* renamed from: a  reason: collision with root package name */
    private final Map<com.bumptech.glide.load.c, l<?>> f17214a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private final Map<com.bumptech.glide.load.c, l<?>> f17215b = new HashMap();

    private Map<com.bumptech.glide.load.c, l<?>> c(boolean z3) {
        return z3 ? this.f17215b : this.f17214a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public l<?> a(com.bumptech.glide.load.c cVar, boolean z3) {
        return c(z3).get(cVar);
    }

    @VisibleForTesting
    Map<com.bumptech.glide.load.c, l<?>> b() {
        return Collections.unmodifiableMap(this.f17214a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(com.bumptech.glide.load.c cVar, l<?> lVar) {
        c(lVar.q()).put(cVar, lVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(com.bumptech.glide.load.c cVar, l<?> lVar) {
        Map<com.bumptech.glide.load.c, l<?>> c4 = c(lVar.q());
        if (lVar.equals(c4.get(cVar))) {
            c4.remove(cVar);
        }
    }
}

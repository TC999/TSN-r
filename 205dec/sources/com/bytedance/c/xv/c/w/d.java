package com.bytedance.c.xv.c.w;

import com.bytedance.c.xv.c.w.w;
import java.util.UUID;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public abstract class d implements w, Comparable<d>, Runnable {

    /* renamed from: a  reason: collision with root package name */
    private w.c f26671a = w.c.NORMAL;

    /* renamed from: b  reason: collision with root package name */
    private String f26672b = UUID.randomUUID().toString() + "-" + String.valueOf(System.nanoTime());

    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(d dVar) {
        if (b().c() < dVar.b().c()) {
            return 1;
        }
        return b().c() > dVar.b().c() ? -1 : 0;
    }

    public w.c b() {
        return this.f26671a;
    }
}

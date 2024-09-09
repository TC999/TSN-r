package com.bumptech.glide.load.engine.bitmap_recycle;

import com.bumptech.glide.load.engine.bitmap_recycle.m;
import java.util.Queue;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: BaseKeyPool.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
abstract class d<T extends m> {

    /* renamed from: b  reason: collision with root package name */
    private static final int f16883b = 20;

    /* renamed from: a  reason: collision with root package name */
    private final Queue<T> f16884a = com.bumptech.glide.util.k.f(20);

    abstract T a();

    /* JADX INFO: Access modifiers changed from: package-private */
    public T b() {
        T poll = this.f16884a.poll();
        return poll == null ? a() : poll;
    }

    public void c(T t3) {
        if (this.f16884a.size() < 20) {
            this.f16884a.offer(t3);
        }
    }
}

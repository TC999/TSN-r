package com.bumptech.glide.load.engine.bitmap_recycle;

import com.bumptech.glide.load.engine.bitmap_recycle.Poolable;
import com.bumptech.glide.util.C3771k;
import java.util.Queue;

/* renamed from: com.bumptech.glide.load.engine.bitmap_recycle.d */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
abstract class BaseKeyPool<T extends Poolable> {

    /* renamed from: b */
    private static final int f13560b = 20;

    /* renamed from: a */
    private final Queue<T> f13561a = C3771k.m44385f(20);

    /* renamed from: a */
    abstract T mo45340a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public T m45414b() {
        T poll = this.f13561a.poll();
        return poll == null ? mo45340a() : poll;
    }

    /* renamed from: c */
    public void m45413c(T t) {
        if (this.f13561a.size() < 20) {
            this.f13561a.offer(t);
        }
    }
}

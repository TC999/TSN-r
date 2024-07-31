package com.bumptech.glide.load.engine.cache;

import com.bumptech.glide.util.C3770j;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* renamed from: com.bumptech.glide.load.engine.cache.c */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
final class DiskCacheWriteLocker {

    /* renamed from: a */
    private final Map<String, C3595a> f13625a = new HashMap();

    /* renamed from: b */
    private final C3596b f13626b = new C3596b();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DiskCacheWriteLocker.java */
    /* renamed from: com.bumptech.glide.load.engine.cache.c$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class C3595a {

        /* renamed from: a */
        final Lock f13627a = new ReentrantLock();

        /* renamed from: b */
        int f13628b;

        C3595a() {
        }
    }

    /* compiled from: DiskCacheWriteLocker.java */
    /* renamed from: com.bumptech.glide.load.engine.cache.c$b */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    private static class C3596b {

        /* renamed from: b */
        private static final int f13629b = 10;

        /* renamed from: a */
        private final Queue<C3595a> f13630a = new ArrayDeque();

        C3596b() {
        }

        /* renamed from: a */
        C3595a m45334a() {
            C3595a poll;
            synchronized (this.f13630a) {
                poll = this.f13630a.poll();
            }
            return poll == null ? new C3595a() : poll;
        }

        /* renamed from: b */
        void m45333b(C3595a c3595a) {
            synchronized (this.f13630a) {
                if (this.f13630a.size() < 10) {
                    this.f13630a.offer(c3595a);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m45336a(String str) {
        C3595a c3595a;
        synchronized (this) {
            c3595a = this.f13625a.get(str);
            if (c3595a == null) {
                c3595a = this.f13626b.m45334a();
                this.f13625a.put(str, c3595a);
            }
            c3595a.f13628b++;
        }
        c3595a.f13627a.lock();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public void m45335b(String str) {
        C3595a c3595a;
        synchronized (this) {
            c3595a = (C3595a) C3770j.m44392d(this.f13625a.get(str));
            int i = c3595a.f13628b;
            if (i >= 1) {
                int i2 = i - 1;
                c3595a.f13628b = i2;
                if (i2 == 0) {
                    C3595a remove = this.f13625a.remove(str);
                    if (remove.equals(c3595a)) {
                        this.f13626b.m45333b(remove);
                    } else {
                        throw new IllegalStateException("Removed the wrong lock, expected to remove: " + c3595a + ", but actually removed: " + remove + ", safeKey: " + str);
                    }
                }
            } else {
                throw new IllegalStateException("Cannot release a lock that is not held, safeKey: " + str + ", interestedThreads: " + c3595a.f13628b);
            }
        }
        c3595a.f13627a.unlock();
    }
}

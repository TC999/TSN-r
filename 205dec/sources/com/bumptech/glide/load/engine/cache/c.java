package com.bumptech.glide.load.engine.cache;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: DiskCacheWriteLocker.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
final class c {

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, a> f16948a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private final b f16949b = new b();

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: DiskCacheWriteLocker.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        final Lock f16950a = new ReentrantLock();

        /* renamed from: b  reason: collision with root package name */
        int f16951b;

        a() {
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: DiskCacheWriteLocker.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    private static class b {

        /* renamed from: b  reason: collision with root package name */
        private static final int f16952b = 10;

        /* renamed from: a  reason: collision with root package name */
        private final Queue<a> f16953a = new ArrayDeque();

        b() {
        }

        a a() {
            a poll;
            synchronized (this.f16953a) {
                poll = this.f16953a.poll();
            }
            return poll == null ? new a() : poll;
        }

        void b(a aVar) {
            synchronized (this.f16953a) {
                if (this.f16953a.size() < 10) {
                    this.f16953a.offer(aVar);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str) {
        a aVar;
        synchronized (this) {
            aVar = this.f16948a.get(str);
            if (aVar == null) {
                aVar = this.f16949b.a();
                this.f16948a.put(str, aVar);
            }
            aVar.f16951b++;
        }
        aVar.f16950a.lock();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(String str) {
        a aVar;
        synchronized (this) {
            aVar = (a) com.bumptech.glide.util.j.d(this.f16948a.get(str));
            int i4 = aVar.f16951b;
            if (i4 >= 1) {
                int i5 = i4 - 1;
                aVar.f16951b = i5;
                if (i5 == 0) {
                    a remove = this.f16948a.remove(str);
                    if (remove.equals(aVar)) {
                        this.f16949b.b(remove);
                    } else {
                        throw new IllegalStateException("Removed the wrong lock, expected to remove: " + aVar + ", but actually removed: " + remove + ", safeKey: " + str);
                    }
                }
            } else {
                throw new IllegalStateException("Cannot release a lock that is not held, safeKey: " + str + ", interestedThreads: " + aVar.f16951b);
            }
        }
        aVar.f16950a.unlock();
    }
}

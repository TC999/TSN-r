package io.netty.resolver.dns;

import io.netty.channel.EventLoop;
import io.netty.channel.a;
import io.netty.util.internal.PlatformDependent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.Delayed;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public abstract class Cache<E> {
    private final ConcurrentMap<String, Cache<E>.Entries> resolveCache = PlatformDependent.newConcurrentHashMap();
    private static final AtomicReferenceFieldUpdater<Entries, ScheduledFuture> FUTURE_UPDATER = AtomicReferenceFieldUpdater.newUpdater(Entries.class, ScheduledFuture.class, "expirationFuture");
    private static final ScheduledFuture<?> CANCELLED = new ScheduledFuture<Object>() { // from class: io.netty.resolver.dns.Cache.1
        @Override // java.util.concurrent.Future
        public boolean cancel(boolean z3) {
            return false;
        }

        @Override // java.util.concurrent.Future
        public Object get() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.concurrent.Delayed
        public long getDelay(TimeUnit timeUnit) {
            return Long.MIN_VALUE;
        }

        @Override // java.util.concurrent.Future
        public boolean isCancelled() {
            return true;
        }

        @Override // java.util.concurrent.Future
        public boolean isDone() {
            return true;
        }

        @Override // java.lang.Comparable
        public int compareTo(Delayed delayed) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.concurrent.Future
        public Object get(long j4, TimeUnit timeUnit) {
            throw new UnsupportedOperationException();
        }
    };
    static final int MAX_SUPPORTED_TTL_SECS = (int) TimeUnit.DAYS.toSeconds(730);

    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    private final class Entries extends AtomicReference<List<E>> implements Runnable {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        volatile ScheduledFuture<?> expirationFuture;
        private final String hostname;

        Entries(String str) {
            super(Collections.emptyList());
            this.hostname = str;
        }

        private void scheduleCacheExpirationIfNeeded(int i4, EventLoop eventLoop) {
            while (true) {
                ScheduledFuture scheduledFuture = (ScheduledFuture) Cache.FUTURE_UPDATER.get(this);
                if (scheduledFuture != null && scheduledFuture.getDelay(TimeUnit.SECONDS) <= i4) {
                    return;
                }
                io.netty.util.concurrent.ScheduledFuture<?> schedule = eventLoop.schedule((Runnable) this, i4, TimeUnit.SECONDS);
                if (a.a(Cache.FUTURE_UPDATER, this, scheduledFuture, schedule)) {
                    if (scheduledFuture != null) {
                        scheduledFuture.cancel(true);
                        return;
                    }
                    return;
                }
                schedule.cancel(true);
            }
        }

        void add(E e4, int i4, EventLoop eventLoop) {
            if (Cache.this.shouldReplaceAll(e4)) {
                set(Collections.singletonList(e4));
                scheduleCacheExpirationIfNeeded(i4, eventLoop);
                return;
            }
            while (true) {
                List<E> list = get();
                if (!list.isEmpty()) {
                    int i5 = 0;
                    if (Cache.this.shouldReplaceAll(list.get(0))) {
                        if (compareAndSet(list, Collections.singletonList(e4))) {
                            scheduleCacheExpirationIfNeeded(i4, eventLoop);
                            return;
                        }
                    } else {
                        ArrayList arrayList = new ArrayList(list.size() + 1);
                        E e5 = null;
                        while (true) {
                            E e6 = list.get(i5);
                            if (!Cache.this.equals(e4, e6)) {
                                arrayList.add(e6);
                                i5++;
                                if (i5 >= list.size()) {
                                    break;
                                }
                            } else {
                                arrayList.add(e4);
                                while (true) {
                                    i5++;
                                    if (i5 >= list.size()) {
                                        break;
                                    }
                                    arrayList.add(list.get(i5));
                                }
                                e5 = e6;
                            }
                        }
                        if (e5 == null) {
                            arrayList.add(e4);
                        }
                        Cache.this.sortEntries(this.hostname, arrayList);
                        if (compareAndSet(list, Collections.unmodifiableList(arrayList))) {
                            scheduleCacheExpirationIfNeeded(i4, eventLoop);
                            return;
                        }
                    }
                } else if (compareAndSet(list, Collections.singletonList(e4))) {
                    scheduleCacheExpirationIfNeeded(i4, eventLoop);
                    return;
                }
            }
        }

        boolean clearAndCancel() {
            if (getAndSet(Collections.emptyList()).isEmpty()) {
                return false;
            }
            ScheduledFuture scheduledFuture = (ScheduledFuture) Cache.FUTURE_UPDATER.getAndSet(this, Cache.CANCELLED);
            if (scheduledFuture != null) {
                scheduledFuture.cancel(false);
                return true;
            }
            return true;
        }

        @Override // java.lang.Runnable
        public void run() {
            Cache.this.resolveCache.remove(this.hostname, this);
            clearAndCancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void cache(String str, E e4, int i4, EventLoop eventLoop) {
        Cache<E>.Entries putIfAbsent;
        Cache<E>.Entries entries = this.resolveCache.get(str);
        if (entries == null && (putIfAbsent = this.resolveCache.putIfAbsent(str, (entries = new Entries(str)))) != null) {
            entries = putIfAbsent;
        }
        entries.add(e4, i4, eventLoop);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void clear() {
        while (!this.resolveCache.isEmpty()) {
            Iterator<Map.Entry<String, Cache<E>.Entries>> it = this.resolveCache.entrySet().iterator();
            while (it.hasNext()) {
                it.remove();
                it.next().getValue().clearAndCancel();
            }
        }
    }

    protected abstract boolean equals(E e4, E e5);

    /* JADX INFO: Access modifiers changed from: package-private */
    public final List<? extends E> get(String str) {
        Cache<E>.Entries entries = this.resolveCache.get(str);
        if (entries == null) {
            return null;
        }
        return (List) ((List<E>) entries.get());
    }

    protected abstract boolean shouldReplaceAll(E e4);

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int size() {
        return this.resolveCache.size();
    }

    protected void sortEntries(String str, List<E> list) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean clear(String str) {
        Cache<E>.Entries remove = this.resolveCache.remove(str);
        return remove != null && remove.clearAndCancel();
    }
}

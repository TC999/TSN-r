package rx.internal.operators;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
import rx.Notification;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: BlockingOperatorNext.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class d {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: BlockingOperatorNext.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static class a<T> implements Iterable<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ rx.e f62479a;

        a(rx.e eVar) {
            this.f62479a = eVar;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            return new b(this.f62479a, new c());
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: BlockingOperatorNext.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class b<T> implements Iterator<T> {

        /* renamed from: a  reason: collision with root package name */
        private final c<T> f62480a;

        /* renamed from: b  reason: collision with root package name */
        private final rx.e<? extends T> f62481b;

        /* renamed from: c  reason: collision with root package name */
        private T f62482c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f62483d = true;

        /* renamed from: e  reason: collision with root package name */
        private boolean f62484e = true;

        /* renamed from: f  reason: collision with root package name */
        private Throwable f62485f;

        /* renamed from: g  reason: collision with root package name */
        private boolean f62486g;

        b(rx.e<? extends T> eVar, c<T> cVar) {
            this.f62481b = eVar;
            this.f62480a = cVar;
        }

        private boolean a() {
            try {
                if (!this.f62486g) {
                    this.f62486g = true;
                    this.f62480a.v(1);
                    this.f62481b.d3().q5(this.f62480a);
                }
                Notification<? extends T> x3 = this.f62480a.x();
                if (x3.m()) {
                    this.f62484e = false;
                    this.f62482c = x3.h();
                    return true;
                }
                this.f62483d = false;
                if (x3.k()) {
                    return false;
                }
                if (x3.l()) {
                    Throwable g4 = x3.g();
                    this.f62485f = g4;
                    throw rx.exceptions.a.c(g4);
                }
                throw new IllegalStateException("Should not reach here");
            } catch (InterruptedException e4) {
                this.f62480a.unsubscribe();
                Thread.currentThread().interrupt();
                this.f62485f = e4;
                throw rx.exceptions.a.c(e4);
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            Throwable th = this.f62485f;
            if (th == null) {
                if (this.f62483d) {
                    return !this.f62484e || a();
                }
                return false;
            }
            throw rx.exceptions.a.c(th);
        }

        @Override // java.util.Iterator
        public T next() {
            Throwable th = this.f62485f;
            if (th == null) {
                if (hasNext()) {
                    this.f62484e = true;
                    return this.f62482c;
                }
                throw new NoSuchElementException("No more elements");
            }
            throw rx.exceptions.a.c(th);
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Read only iterator");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: BlockingOperatorNext.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class c<T> extends rx.l<Notification<? extends T>> {

        /* renamed from: a  reason: collision with root package name */
        private final BlockingQueue<Notification<? extends T>> f62487a = new ArrayBlockingQueue(1);

        /* renamed from: b  reason: collision with root package name */
        final AtomicInteger f62488b = new AtomicInteger();

        c() {
        }

        @Override // rx.f
        /* renamed from: g */
        public void onNext(Notification<? extends T> notification) {
            if (this.f62488b.getAndSet(0) == 1 || !notification.m()) {
                while (!this.f62487a.offer(notification)) {
                    Notification<? extends T> poll = this.f62487a.poll();
                    if (poll != null && !poll.m()) {
                        notification = poll;
                    }
                }
            }
        }

        @Override // rx.f
        public void onCompleted() {
        }

        @Override // rx.f
        public void onError(Throwable th) {
        }

        void v(int i4) {
            this.f62488b.set(i4);
        }

        public Notification<? extends T> x() throws InterruptedException {
            v(1);
            return this.f62487a.take();
        }
    }

    private d() {
        throw new IllegalStateException("No instances!");
    }

    public static <T> Iterable<T> a(rx.e<? extends T> eVar) {
        return new a(eVar);
    }
}

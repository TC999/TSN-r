package rx.internal.operators;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicReference;
import rx.Notification;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: BlockingOperatorLatest.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class b {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: BlockingOperatorLatest.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static class a<T> implements Iterable<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ rx.e f62376a;

        a(rx.e eVar) {
            this.f62376a = eVar;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            C1275b c1275b = new C1275b();
            this.f62376a.d3().q5(c1275b);
            return c1275b;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: BlockingOperatorLatest.java */
    /* renamed from: rx.internal.operators.b$b  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class C1275b<T> extends rx.l<Notification<? extends T>> implements Iterator<T> {

        /* renamed from: a  reason: collision with root package name */
        final Semaphore f62377a = new Semaphore(0);

        /* renamed from: b  reason: collision with root package name */
        final AtomicReference<Notification<? extends T>> f62378b = new AtomicReference<>();

        /* renamed from: c  reason: collision with root package name */
        Notification<? extends T> f62379c;

        C1275b() {
        }

        @Override // rx.f
        /* renamed from: g */
        public void onNext(Notification<? extends T> notification) {
            if (this.f62378b.getAndSet(notification) == null) {
                this.f62377a.release();
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            Notification<? extends T> notification = this.f62379c;
            if (notification != null && notification.l()) {
                throw rx.exceptions.a.c(this.f62379c.g());
            }
            Notification<? extends T> notification2 = this.f62379c;
            if ((notification2 == null || !notification2.k()) && this.f62379c == null) {
                try {
                    this.f62377a.acquire();
                    Notification<? extends T> andSet = this.f62378b.getAndSet(null);
                    this.f62379c = andSet;
                    if (andSet.l()) {
                        throw rx.exceptions.a.c(this.f62379c.g());
                    }
                } catch (InterruptedException e4) {
                    unsubscribe();
                    Thread.currentThread().interrupt();
                    this.f62379c = Notification.d(e4);
                    throw rx.exceptions.a.c(e4);
                }
            }
            return !this.f62379c.k();
        }

        @Override // java.util.Iterator
        public T next() {
            if (hasNext() && this.f62379c.m()) {
                T h4 = this.f62379c.h();
                this.f62379c = null;
                return h4;
            }
            throw new NoSuchElementException();
        }

        @Override // rx.f
        public void onCompleted() {
        }

        @Override // rx.f
        public void onError(Throwable th) {
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Read-only iterator.");
        }
    }

    private b() {
        throw new IllegalStateException("No instances!");
    }

    public static <T> Iterable<T> a(rx.e<? extends T> eVar) {
        return new a(eVar);
    }
}

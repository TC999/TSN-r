package p640rx.internal.operators;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicReference;
import p640rx.Notification;
import p640rx.Observable;
import p640rx.Subscriber;
import p640rx.exceptions.C15575a;

/* renamed from: rx.internal.operators.b */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class BlockingOperatorLatest {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: BlockingOperatorLatest.java */
    /* renamed from: rx.internal.operators.b$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static class C15657a<T> implements Iterable<T> {

        /* renamed from: a */
        final /* synthetic */ Observable f44945a;

        C15657a(Observable observable) {
            this.f44945a = observable;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            C15658b c15658b = new C15658b();
            this.f44945a.m1657d3().m1551q5(c15658b);
            return c15658b;
        }
    }

    /* compiled from: BlockingOperatorLatest.java */
    /* renamed from: rx.internal.operators.b$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static final class C15658b<T> extends Subscriber<Notification<? extends T>> implements Iterator<T> {

        /* renamed from: a */
        final Semaphore f44946a = new Semaphore(0);

        /* renamed from: b */
        final AtomicReference<Notification<? extends T>> f44947b = new AtomicReference<>();

        /* renamed from: c */
        Notification<? extends T> f44948c;

        C15658b() {
        }

        @Override // p640rx.Observer
        /* renamed from: F */
        public void onNext(Notification<? extends T> notification) {
            if (this.f44947b.getAndSet(notification) == null) {
                this.f44946a.release();
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            Notification<? extends T> notification = this.f44948c;
            if (notification != null && notification.m1995l()) {
                throw C15575a.m1476c(this.f44948c.m2000g());
            }
            Notification<? extends T> notification2 = this.f44948c;
            if ((notification2 == null || !notification2.m1996k()) && this.f44948c == null) {
                try {
                    this.f44946a.acquire();
                    Notification<? extends T> andSet = this.f44947b.getAndSet(null);
                    this.f44948c = andSet;
                    if (andSet.m1995l()) {
                        throw C15575a.m1476c(this.f44948c.m2000g());
                    }
                } catch (InterruptedException e) {
                    unsubscribe();
                    Thread.currentThread().interrupt();
                    this.f44948c = Notification.m2003d(e);
                    throw C15575a.m1476c(e);
                }
            }
            return !this.f44948c.m1996k();
        }

        @Override // java.util.Iterator
        public T next() {
            if (hasNext() && this.f44948c.m1994m()) {
                T m1999h = this.f44948c.m1999h();
                this.f44948c = null;
                return m1999h;
            }
            throw new NoSuchElementException();
        }

        @Override // p640rx.Observer
        public void onCompleted() {
        }

        @Override // p640rx.Observer
        public void onError(Throwable th) {
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Read-only iterator.");
        }
    }

    private BlockingOperatorLatest() {
        throw new IllegalStateException("No instances!");
    }

    /* renamed from: a */
    public static <T> Iterable<T> m1306a(Observable<? extends T> observable) {
        return new C15657a(observable);
    }
}

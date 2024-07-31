package p640rx.internal.operators;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import p640rx.Notification;
import p640rx.Observable;
import p640rx.Subscriber;
import p640rx.exceptions.C15575a;
import p640rx.internal.util.RxRingBuffer;

/* renamed from: rx.internal.operators.f */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class BlockingOperatorToIterator {

    /* compiled from: BlockingOperatorToIterator.java */
    /* renamed from: rx.internal.operators.f$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15703a<T> extends Subscriber<Notification<? extends T>> implements Iterator<T> {

        /* renamed from: d */
        static final int f45131d = (RxRingBuffer.f46509d * 3) / 4;

        /* renamed from: a */
        private final BlockingQueue<Notification<? extends T>> f45132a = new LinkedBlockingQueue();

        /* renamed from: b */
        private Notification<? extends T> f45133b;

        /* renamed from: c */
        private int f45134c;

        /* renamed from: G */
        private Notification<? extends T> m1264G() {
            try {
                Notification<? extends T> poll = this.f45132a.poll();
                return poll != null ? poll : this.f45132a.take();
            } catch (InterruptedException e) {
                unsubscribe();
                throw C15575a.m1476c(e);
            }
        }

        @Override // p640rx.Observer
        /* renamed from: F */
        public void onNext(Notification<? extends T> notification) {
            this.f45132a.offer(notification);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f45133b == null) {
                this.f45133b = m1264G();
                int i = this.f45134c + 1;
                this.f45134c = i;
                if (i >= f45131d) {
                    request(i);
                    this.f45134c = 0;
                }
            }
            if (!this.f45133b.m1995l()) {
                return !this.f45133b.m1996k();
            }
            throw C15575a.m1476c(this.f45133b.m2000g());
        }

        @Override // java.util.Iterator
        public T next() {
            if (hasNext()) {
                T m1999h = this.f45133b.m1999h();
                this.f45133b = null;
                return m1999h;
            }
            throw new NoSuchElementException();
        }

        @Override // p640rx.Observer
        public void onCompleted() {
        }

        @Override // p640rx.Observer
        public void onError(Throwable th) {
            this.f45132a.offer(Notification.m2003d(th));
        }

        @Override // p640rx.Subscriber
        public void onStart() {
            request(RxRingBuffer.f46509d);
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Read-only iterator");
        }
    }

    private BlockingOperatorToIterator() {
        throw new IllegalStateException("No instances!");
    }

    /* renamed from: a */
    public static <T> Iterator<T> m1266a(Observable<? extends T> observable) {
        C15703a c15703a = new C15703a();
        observable.m1657d3().m1551q5(c15703a);
        return c15703a;
    }
}

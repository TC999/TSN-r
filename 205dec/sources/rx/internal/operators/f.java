package rx.internal.operators;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import rx.Notification;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: BlockingOperatorToIterator.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class f {

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: BlockingOperatorToIterator.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a<T> extends rx.l<Notification<? extends T>> implements Iterator<T> {

        /* renamed from: d  reason: collision with root package name */
        static final int f62562d = (rx.internal.util.j.f63940d * 3) / 4;

        /* renamed from: a  reason: collision with root package name */
        private final BlockingQueue<Notification<? extends T>> f62563a = new LinkedBlockingQueue();

        /* renamed from: b  reason: collision with root package name */
        private Notification<? extends T> f62564b;

        /* renamed from: c  reason: collision with root package name */
        private int f62565c;

        private Notification<? extends T> v() {
            try {
                Notification<? extends T> poll = this.f62563a.poll();
                return poll != null ? poll : this.f62563a.take();
            } catch (InterruptedException e4) {
                unsubscribe();
                throw rx.exceptions.a.c(e4);
            }
        }

        @Override // rx.f
        /* renamed from: g */
        public void onNext(Notification<? extends T> notification) {
            this.f62563a.offer(notification);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f62564b == null) {
                this.f62564b = v();
                int i4 = this.f62565c + 1;
                this.f62565c = i4;
                if (i4 >= f62562d) {
                    request(i4);
                    this.f62565c = 0;
                }
            }
            if (!this.f62564b.l()) {
                return !this.f62564b.k();
            }
            throw rx.exceptions.a.c(this.f62564b.g());
        }

        @Override // java.util.Iterator
        public T next() {
            if (hasNext()) {
                T h4 = this.f62564b.h();
                this.f62564b = null;
                return h4;
            }
            throw new NoSuchElementException();
        }

        @Override // rx.f
        public void onCompleted() {
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f62563a.offer(Notification.d(th));
        }

        @Override // rx.l
        public void onStart() {
            request(rx.internal.util.j.f63940d);
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Read-only iterator");
        }
    }

    private f() {
        throw new IllegalStateException("No instances!");
    }

    public static <T> Iterator<T> a(rx.e<? extends T> eVar) {
        a aVar = new a();
        eVar.d3().q5(aVar);
        return aVar;
    }
}

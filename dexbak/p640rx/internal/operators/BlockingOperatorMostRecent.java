package p640rx.internal.operators;

import java.util.Iterator;
import java.util.NoSuchElementException;
import p640rx.Observable;
import p640rx.Subscriber;
import p640rx.exceptions.C15575a;

/* renamed from: rx.internal.operators.c */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class BlockingOperatorMostRecent {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: BlockingOperatorMostRecent.java */
    /* renamed from: rx.internal.operators.c$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static class C15669a<T> implements Iterable<T> {

        /* renamed from: a */
        final /* synthetic */ Object f44988a;

        /* renamed from: b */
        final /* synthetic */ Observable f44989b;

        C15669a(Object obj, Observable observable) {
            this.f44988a = obj;
            this.f44989b = observable;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            C15670b c15670b = new C15670b(this.f44988a);
            this.f44989b.m1551q5(c15670b);
            return c15670b.m1298F();
        }
    }

    /* compiled from: BlockingOperatorMostRecent.java */
    /* renamed from: rx.internal.operators.c$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static final class C15670b<T> extends Subscriber<T> {

        /* renamed from: a */
        volatile Object f44990a;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: BlockingOperatorMostRecent.java */
        /* renamed from: rx.internal.operators.c$b$a */
        /* loaded from: E:\fuckcool\tsn\5406560.dex */
        public class C15671a implements Iterator<T> {

            /* renamed from: a */
            private Object f44991a;

            C15671a() {
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                Object obj = C15670b.this.f44990a;
                this.f44991a = obj;
                return !NotificationLite.m1047f(obj);
            }

            @Override // java.util.Iterator
            public T next() {
                try {
                    if (this.f44991a == null) {
                        this.f44991a = C15670b.this.f44990a;
                    }
                    if (!NotificationLite.m1047f(this.f44991a)) {
                        if (!NotificationLite.m1046g(this.f44991a)) {
                            return (T) NotificationLite.m1048e(this.f44991a);
                        }
                        throw C15575a.m1476c(NotificationLite.m1049d(this.f44991a));
                    }
                    throw new NoSuchElementException();
                } finally {
                    this.f44991a = null;
                }
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException("Read only iterator");
            }
        }

        C15670b(T t) {
            this.f44990a = NotificationLite.m1043j(t);
        }

        /* renamed from: F */
        public Iterator<T> m1298F() {
            return new C15671a();
        }

        @Override // p640rx.Observer
        public void onCompleted() {
            this.f44990a = NotificationLite.m1051b();
        }

        @Override // p640rx.Observer
        public void onError(Throwable th) {
            this.f44990a = NotificationLite.m1050c(th);
        }

        @Override // p640rx.Observer
        public void onNext(T t) {
            this.f44990a = NotificationLite.m1043j(t);
        }
    }

    private BlockingOperatorMostRecent() {
        throw new IllegalStateException("No instances!");
    }

    /* renamed from: a */
    public static <T> Iterable<T> m1299a(Observable<? extends T> observable, T t) {
        return new C15669a(t, observable);
    }
}

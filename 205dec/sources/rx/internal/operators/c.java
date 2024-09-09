package rx.internal.operators;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: BlockingOperatorMostRecent.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class c {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: BlockingOperatorMostRecent.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static class a<T> implements Iterable<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Object f62419a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ rx.e f62420b;

        a(Object obj, rx.e eVar) {
            this.f62419a = obj;
            this.f62420b = eVar;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            b bVar = new b(this.f62419a);
            this.f62420b.q5(bVar);
            return bVar.g();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: BlockingOperatorMostRecent.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class b<T> extends rx.l<T> {

        /* renamed from: a  reason: collision with root package name */
        volatile Object f62421a;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
        /* compiled from: BlockingOperatorMostRecent.java */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public class a implements Iterator<T> {

            /* renamed from: a  reason: collision with root package name */
            private Object f62422a;

            a() {
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                Object obj = b.this.f62421a;
                this.f62422a = obj;
                return !v.f(obj);
            }

            @Override // java.util.Iterator
            public T next() {
                try {
                    if (this.f62422a == null) {
                        this.f62422a = b.this.f62421a;
                    }
                    if (!v.f(this.f62422a)) {
                        if (!v.g(this.f62422a)) {
                            return (T) v.e(this.f62422a);
                        }
                        throw rx.exceptions.a.c(v.d(this.f62422a));
                    }
                    throw new NoSuchElementException();
                } finally {
                    this.f62422a = null;
                }
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException("Read only iterator");
            }
        }

        b(T t3) {
            this.f62421a = v.j(t3);
        }

        public Iterator<T> g() {
            return new a();
        }

        @Override // rx.f
        public void onCompleted() {
            this.f62421a = v.b();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f62421a = v.c(th);
        }

        @Override // rx.f
        public void onNext(T t3) {
            this.f62421a = v.j(t3);
        }
    }

    private c() {
        throw new IllegalStateException("No instances!");
    }

    public static <T> Iterable<T> a(rx.e<? extends T> eVar, T t3) {
        return new a(t3, eVar);
    }
}

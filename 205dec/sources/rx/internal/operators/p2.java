package rx.internal.operators;

import java.util.concurrent.atomic.AtomicLong;
import rx.e;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: OperatorOnBackpressureDrop.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class p2<T> implements e.b<T, T> {

    /* renamed from: a  reason: collision with root package name */
    final rx.functions.b<? super T> f63130a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OperatorOnBackpressureDrop.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public class a implements rx.g {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AtomicLong f63131a;

        a(AtomicLong atomicLong) {
            this.f63131a = atomicLong;
        }

        @Override // rx.g
        public void request(long j4) {
            rx.internal.operators.a.b(this.f63131a, j4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OperatorOnBackpressureDrop.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public class b extends rx.l<T> {

        /* renamed from: a  reason: collision with root package name */
        boolean f63133a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ rx.l f63134b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ AtomicLong f63135c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(rx.l lVar, rx.l lVar2, AtomicLong atomicLong) {
            super(lVar);
            this.f63134b = lVar2;
            this.f63135c = atomicLong;
        }

        @Override // rx.f
        public void onCompleted() {
            if (this.f63133a) {
                return;
            }
            this.f63133a = true;
            this.f63134b.onCompleted();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            if (!this.f63133a) {
                this.f63133a = true;
                this.f63134b.onError(th);
                return;
            }
            rx.plugins.c.I(th);
        }

        @Override // rx.f
        public void onNext(T t3) {
            if (this.f63133a) {
                return;
            }
            if (this.f63135c.get() > 0) {
                this.f63134b.onNext(t3);
                this.f63135c.decrementAndGet();
                return;
            }
            rx.functions.b<? super T> bVar = p2.this.f63130a;
            if (bVar != null) {
                try {
                    bVar.call(t3);
                } catch (Throwable th) {
                    rx.exceptions.a.g(th, this, t3);
                }
            }
        }

        @Override // rx.l
        public void onStart() {
            request(Long.MAX_VALUE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OperatorOnBackpressureDrop.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        static final p2<Object> f63137a = new p2<>();

        c() {
        }
    }

    p2() {
        this(null);
    }

    public static <T> p2<T> a() {
        return (p2<T>) c.f63137a;
    }

    @Override // rx.functions.p
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.l) ((rx.l) obj));
    }

    public p2(rx.functions.b<? super T> bVar) {
        this.f63130a = bVar;
    }

    public rx.l<? super T> call(rx.l<? super T> lVar) {
        AtomicLong atomicLong = new AtomicLong();
        lVar.setProducer(new a(atomicLong));
        return new b(lVar, lVar, atomicLong);
    }
}

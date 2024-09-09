package rx.internal.operators;

import java.util.concurrent.atomic.AtomicBoolean;
import rx.e;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: OperatorElementAt.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class f2<T> implements e.b<T, T> {

    /* renamed from: a  reason: collision with root package name */
    final int f62578a;

    /* renamed from: b  reason: collision with root package name */
    final boolean f62579b;

    /* renamed from: c  reason: collision with root package name */
    final T f62580c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OperatorElementAt.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public class a extends rx.l<T> {

        /* renamed from: a  reason: collision with root package name */
        private int f62581a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ rx.l f62582b;

        a(rx.l lVar) {
            this.f62582b = lVar;
        }

        @Override // rx.f
        public void onCompleted() {
            int i4 = this.f62581a;
            f2 f2Var = f2.this;
            if (i4 <= f2Var.f62578a) {
                if (f2Var.f62579b) {
                    this.f62582b.onNext(f2Var.f62580c);
                    this.f62582b.onCompleted();
                    return;
                }
                rx.l lVar = this.f62582b;
                lVar.onError(new IndexOutOfBoundsException(f2.this.f62578a + " is out of bounds"));
            }
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f62582b.onError(th);
        }

        @Override // rx.f
        public void onNext(T t3) {
            int i4 = this.f62581a;
            this.f62581a = i4 + 1;
            if (i4 == f2.this.f62578a) {
                this.f62582b.onNext(t3);
                this.f62582b.onCompleted();
                unsubscribe();
            }
        }

        @Override // rx.l, rx.observers.a
        public void setProducer(rx.g gVar) {
            this.f62582b.setProducer(new b(gVar));
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OperatorElementAt.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static class b extends AtomicBoolean implements rx.g {
        private static final long serialVersionUID = 1;

        /* renamed from: a  reason: collision with root package name */
        final rx.g f62584a;

        public b(rx.g gVar) {
            this.f62584a = gVar;
        }

        @Override // rx.g
        public void request(long j4) {
            if (j4 >= 0) {
                if (j4 <= 0 || !compareAndSet(false, true)) {
                    return;
                }
                this.f62584a.request(Long.MAX_VALUE);
                return;
            }
            throw new IllegalArgumentException("n >= 0 required");
        }
    }

    public f2(int i4) {
        this(i4, null, false);
    }

    @Override // rx.functions.p
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.l) ((rx.l) obj));
    }

    public f2(int i4, T t3) {
        this(i4, t3, true);
    }

    public rx.l<? super T> call(rx.l<? super T> lVar) {
        a aVar = new a(lVar);
        lVar.add(aVar);
        return aVar;
    }

    private f2(int i4, T t3, boolean z3) {
        if (i4 >= 0) {
            this.f62578a = i4;
            this.f62580c = t3;
            this.f62579b = z3;
            return;
        }
        throw new IndexOutOfBoundsException(i4 + " is out of bounds");
    }
}

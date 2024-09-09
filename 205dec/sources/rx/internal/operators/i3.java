package rx.internal.operators;

import java.util.concurrent.atomic.AtomicLong;
import rx.e;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: OperatorTake.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class i3<T> implements e.b<T, T> {

    /* renamed from: a  reason: collision with root package name */
    final int f62784a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OperatorTake.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public class a extends rx.l<T> {

        /* renamed from: a  reason: collision with root package name */
        int f62785a;

        /* renamed from: b  reason: collision with root package name */
        boolean f62786b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ rx.l f62787c;

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
        /* compiled from: OperatorTake.java */
        /* renamed from: rx.internal.operators.i3$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        class C1283a implements rx.g {

            /* renamed from: a  reason: collision with root package name */
            final AtomicLong f62789a = new AtomicLong(0);

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ rx.g f62790b;

            C1283a(rx.g gVar) {
                this.f62790b = gVar;
            }

            @Override // rx.g
            public void request(long j4) {
                long j5;
                long min;
                if (j4 <= 0 || a.this.f62786b) {
                    return;
                }
                do {
                    j5 = this.f62789a.get();
                    min = Math.min(j4, i3.this.f62784a - j5);
                    if (min == 0) {
                        return;
                    }
                } while (!this.f62789a.compareAndSet(j5, j5 + min));
                this.f62790b.request(min);
            }
        }

        a(rx.l lVar) {
            this.f62787c = lVar;
        }

        @Override // rx.f
        public void onCompleted() {
            if (this.f62786b) {
                return;
            }
            this.f62786b = true;
            this.f62787c.onCompleted();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            if (this.f62786b) {
                return;
            }
            this.f62786b = true;
            try {
                this.f62787c.onError(th);
            } finally {
                unsubscribe();
            }
        }

        @Override // rx.f
        public void onNext(T t3) {
            if (isUnsubscribed()) {
                return;
            }
            int i4 = this.f62785a;
            int i5 = i4 + 1;
            this.f62785a = i5;
            int i6 = i3.this.f62784a;
            if (i4 < i6) {
                boolean z3 = i5 == i6;
                this.f62787c.onNext(t3);
                if (!z3 || this.f62786b) {
                    return;
                }
                this.f62786b = true;
                try {
                    this.f62787c.onCompleted();
                } finally {
                    unsubscribe();
                }
            }
        }

        @Override // rx.l, rx.observers.a
        public void setProducer(rx.g gVar) {
            this.f62787c.setProducer(new C1283a(gVar));
        }
    }

    public i3(int i4) {
        if (i4 >= 0) {
            this.f62784a = i4;
            return;
        }
        throw new IllegalArgumentException("limit >= 0 required but it was " + i4);
    }

    @Override // rx.functions.p
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.l) ((rx.l) obj));
    }

    public rx.l<? super T> call(rx.l<? super T> lVar) {
        a aVar = new a(lVar);
        if (this.f62784a == 0) {
            lVar.onCompleted();
            aVar.unsubscribe();
        }
        lVar.add(aVar);
        return aVar;
    }
}

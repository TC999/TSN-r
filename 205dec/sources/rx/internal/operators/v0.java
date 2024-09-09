package rx.internal.operators;

import java.util.concurrent.atomic.AtomicLong;
import rx.e;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: OnSubscribeRange.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class v0 implements e.a<Integer> {

    /* renamed from: a  reason: collision with root package name */
    private final int f63443a;

    /* renamed from: b  reason: collision with root package name */
    private final int f63444b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OnSubscribeRange.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a extends AtomicLong implements rx.g {
        private static final long serialVersionUID = 4114392207069098388L;

        /* renamed from: a  reason: collision with root package name */
        private final rx.l<? super Integer> f63445a;

        /* renamed from: b  reason: collision with root package name */
        private final int f63446b;

        /* renamed from: c  reason: collision with root package name */
        private long f63447c;

        a(rx.l<? super Integer> lVar, int i4, int i5) {
            this.f63445a = lVar;
            this.f63447c = i4;
            this.f63446b = i5;
        }

        void a() {
            long j4 = this.f63446b + 1;
            rx.l<? super Integer> lVar = this.f63445a;
            for (long j5 = this.f63447c; j5 != j4; j5++) {
                if (lVar.isUnsubscribed()) {
                    return;
                }
                lVar.onNext(Integer.valueOf((int) j5));
            }
            if (lVar.isUnsubscribed()) {
                return;
            }
            lVar.onCompleted();
        }

        void b(long j4) {
            long j5 = this.f63446b + 1;
            long j6 = this.f63447c;
            rx.l<? super Integer> lVar = this.f63445a;
            do {
                long j7 = 0;
                while (true) {
                    if (j7 != j4 && j6 != j5) {
                        if (lVar.isUnsubscribed()) {
                            return;
                        }
                        lVar.onNext(Integer.valueOf((int) j6));
                        j6++;
                        j7++;
                    } else if (lVar.isUnsubscribed()) {
                        return;
                    } else {
                        if (j6 == j5) {
                            lVar.onCompleted();
                            return;
                        }
                        j4 = get();
                        if (j4 == j7) {
                            this.f63447c = j6;
                            j4 = addAndGet(-j7);
                        }
                    }
                }
            } while (j4 != 0);
        }

        @Override // rx.g
        public void request(long j4) {
            if (get() == Long.MAX_VALUE) {
                return;
            }
            if (j4 == Long.MAX_VALUE && compareAndSet(0L, Long.MAX_VALUE)) {
                a();
            } else if (j4 <= 0 || rx.internal.operators.a.b(this, j4) != 0) {
            } else {
                b(j4);
            }
        }
    }

    public v0(int i4, int i5) {
        this.f63443a = i4;
        this.f63444b = i5;
    }

    @Override // rx.functions.b
    public void call(rx.l<? super Integer> lVar) {
        lVar.setProducer(new a(lVar, this.f63443a, this.f63444b));
    }
}

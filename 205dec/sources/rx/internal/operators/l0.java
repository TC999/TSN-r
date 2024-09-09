package rx.internal.operators;

import java.util.concurrent.atomic.AtomicLong;
import rx.e;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: OnSubscribeFromArray.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class l0<T> implements e.a<T> {

    /* renamed from: a  reason: collision with root package name */
    final T[] f62903a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OnSubscribeFromArray.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a<T> extends AtomicLong implements rx.g {
        private static final long serialVersionUID = 3534218984725836979L;

        /* renamed from: a  reason: collision with root package name */
        final rx.l<? super T> f62904a;

        /* renamed from: b  reason: collision with root package name */
        final T[] f62905b;

        /* renamed from: c  reason: collision with root package name */
        int f62906c;

        public a(rx.l<? super T> lVar, T[] tArr) {
            this.f62904a = lVar;
            this.f62905b = tArr;
        }

        void a() {
            rx.l<? super T> lVar = this.f62904a;
            for (T t3 : this.f62905b) {
                Object obj = (Object) t3;
                if (lVar.isUnsubscribed()) {
                    return;
                }
                lVar.onNext(obj);
            }
            if (lVar.isUnsubscribed()) {
                return;
            }
            lVar.onCompleted();
        }

        void b(long j4) {
            rx.l<? super T> lVar = this.f62904a;
            T[] tArr = this.f62905b;
            int length = tArr.length;
            int i4 = this.f62906c;
            do {
                long j5 = 0;
                while (true) {
                    if (j4 != 0 && i4 != length) {
                        if (lVar.isUnsubscribed()) {
                            return;
                        }
                        lVar.onNext((Object) tArr[i4]);
                        i4++;
                        if (i4 == length) {
                            if (lVar.isUnsubscribed()) {
                                return;
                            }
                            lVar.onCompleted();
                            return;
                        }
                        j4--;
                        j5--;
                    } else {
                        j4 = get() + j5;
                        if (j4 == 0) {
                            this.f62906c = i4;
                            j4 = addAndGet(j5);
                        }
                    }
                }
            } while (j4 != 0);
        }

        @Override // rx.g
        public void request(long j4) {
            if (j4 < 0) {
                throw new IllegalArgumentException("n >= 0 required but it was " + j4);
            } else if (j4 == Long.MAX_VALUE) {
                if (rx.internal.operators.a.b(this, j4) == 0) {
                    a();
                }
            } else if (j4 == 0 || rx.internal.operators.a.b(this, j4) != 0) {
            } else {
                b(j4);
            }
        }
    }

    public l0(T[] tArr) {
        this.f62903a = tArr;
    }

    @Override // rx.functions.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((rx.l) ((rx.l) obj));
    }

    public void call(rx.l<? super T> lVar) {
        lVar.setProducer(new a(lVar, this.f62903a));
    }
}

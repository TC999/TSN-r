package rx.internal.operators;

import java.util.concurrent.TimeUnit;
import rx.e;
import rx.h;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: OnSubscribeSkipTimed.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class b1<T> implements e.a<T> {

    /* renamed from: a  reason: collision with root package name */
    final long f62381a;

    /* renamed from: b  reason: collision with root package name */
    final TimeUnit f62382b;

    /* renamed from: c  reason: collision with root package name */
    final rx.h f62383c;

    /* renamed from: d  reason: collision with root package name */
    final rx.e<T> f62384d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OnSubscribeSkipTimed.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a<T> extends rx.l<T> implements rx.functions.a {

        /* renamed from: a  reason: collision with root package name */
        final rx.l<? super T> f62385a;

        /* renamed from: b  reason: collision with root package name */
        volatile boolean f62386b;

        a(rx.l<? super T> lVar) {
            this.f62385a = lVar;
        }

        @Override // rx.functions.a
        public void call() {
            this.f62386b = true;
        }

        @Override // rx.f
        public void onCompleted() {
            try {
                this.f62385a.onCompleted();
            } finally {
                unsubscribe();
            }
        }

        @Override // rx.f
        public void onError(Throwable th) {
            try {
                this.f62385a.onError(th);
            } finally {
                unsubscribe();
            }
        }

        @Override // rx.f
        public void onNext(T t3) {
            if (this.f62386b) {
                this.f62385a.onNext(t3);
            }
        }
    }

    public b1(rx.e<T> eVar, long j4, TimeUnit timeUnit, rx.h hVar) {
        this.f62384d = eVar;
        this.f62381a = j4;
        this.f62382b = timeUnit;
        this.f62383c = hVar;
    }

    @Override // rx.functions.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((rx.l) ((rx.l) obj));
    }

    public void call(rx.l<? super T> lVar) {
        h.a a4 = this.f62383c.a();
        a aVar = new a(lVar);
        aVar.add(a4);
        lVar.add(aVar);
        a4.e(aVar, this.f62381a, this.f62382b);
        this.f62384d.I6(aVar);
    }
}

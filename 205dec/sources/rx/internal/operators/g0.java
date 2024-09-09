package rx.internal.operators;

import java.util.Arrays;
import rx.e;
import rx.exceptions.CompositeException;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: OnSubscribeDoOnEach.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class g0<T> implements e.a<T> {

    /* renamed from: a  reason: collision with root package name */
    private final rx.f<? super T> f62615a;

    /* renamed from: b  reason: collision with root package name */
    private final rx.e<T> f62616b;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OnSubscribeDoOnEach.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a<T> extends rx.l<T> {

        /* renamed from: a  reason: collision with root package name */
        private final rx.l<? super T> f62617a;

        /* renamed from: b  reason: collision with root package name */
        private final rx.f<? super T> f62618b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f62619c;

        a(rx.l<? super T> lVar, rx.f<? super T> fVar) {
            super(lVar);
            this.f62617a = lVar;
            this.f62618b = fVar;
        }

        @Override // rx.f
        public void onCompleted() {
            if (this.f62619c) {
                return;
            }
            try {
                this.f62618b.onCompleted();
                this.f62619c = true;
                this.f62617a.onCompleted();
            } catch (Throwable th) {
                rx.exceptions.a.f(th, this);
            }
        }

        @Override // rx.f
        public void onError(Throwable th) {
            if (this.f62619c) {
                rx.plugins.c.I(th);
                return;
            }
            this.f62619c = true;
            try {
                this.f62618b.onError(th);
                this.f62617a.onError(th);
            } catch (Throwable th2) {
                rx.exceptions.a.e(th2);
                this.f62617a.onError(new CompositeException(Arrays.asList(th, th2)));
            }
        }

        @Override // rx.f
        public void onNext(T t3) {
            if (this.f62619c) {
                return;
            }
            try {
                this.f62618b.onNext(t3);
                this.f62617a.onNext(t3);
            } catch (Throwable th) {
                rx.exceptions.a.g(th, this, t3);
            }
        }
    }

    public g0(rx.e<T> eVar, rx.f<? super T> fVar) {
        this.f62616b = eVar;
        this.f62615a = fVar;
    }

    @Override // rx.functions.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((rx.l) ((rx.l) obj));
    }

    public void call(rx.l<? super T> lVar) {
        this.f62616b.I6(new a(lVar, this.f62615a));
    }
}

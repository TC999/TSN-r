package rx.internal.operators;

import java.util.NoSuchElementException;
import rx.i;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: OnSubscribeSingle.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class a1<T> implements i.t<T> {

    /* renamed from: a  reason: collision with root package name */
    private final rx.e<T> f62321a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OnSubscribeSingle.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public class a extends rx.l<T> {

        /* renamed from: a  reason: collision with root package name */
        private boolean f62322a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f62323b;

        /* renamed from: c  reason: collision with root package name */
        private T f62324c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ rx.k f62325d;

        a(rx.k kVar) {
            this.f62325d = kVar;
        }

        @Override // rx.f
        public void onCompleted() {
            if (this.f62322a) {
                return;
            }
            if (this.f62323b) {
                this.f62325d.c(this.f62324c);
            } else {
                this.f62325d.onError(new NoSuchElementException("Observable emitted no items"));
            }
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f62325d.onError(th);
            unsubscribe();
        }

        @Override // rx.f
        public void onNext(T t3) {
            if (this.f62323b) {
                this.f62322a = true;
                this.f62325d.onError(new IllegalArgumentException("Observable emitted too many elements"));
                unsubscribe();
                return;
            }
            this.f62323b = true;
            this.f62324c = t3;
        }

        @Override // rx.l
        public void onStart() {
            request(2L);
        }
    }

    public a1(rx.e<T> eVar) {
        this.f62321a = eVar;
    }

    public static <T> a1<T> a(rx.e<T> eVar) {
        return new a1<>(eVar);
    }

    @Override // rx.functions.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((rx.k) ((rx.k) obj));
    }

    public void call(rx.k<? super T> kVar) {
        a aVar = new a(kVar);
        kVar.b(aVar);
        this.f62321a.I6(aVar);
    }
}

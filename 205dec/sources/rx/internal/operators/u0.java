package rx.internal.operators;

import rx.exceptions.AssemblyStackTraceException;
import rx.i;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: OnSubscribeOnAssemblySingle.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class u0<T> implements i.t<T> {

    /* renamed from: c  reason: collision with root package name */
    public static volatile boolean f63399c;

    /* renamed from: a  reason: collision with root package name */
    final i.t<T> f63400a;

    /* renamed from: b  reason: collision with root package name */
    final String f63401b = s0.a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OnSubscribeOnAssemblySingle.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a<T> extends rx.k<T> {

        /* renamed from: b  reason: collision with root package name */
        final rx.k<? super T> f63402b;

        /* renamed from: c  reason: collision with root package name */
        final String f63403c;

        public a(rx.k<? super T> kVar, String str) {
            this.f63402b = kVar;
            this.f63403c = str;
            kVar.b(this);
        }

        @Override // rx.k
        public void c(T t3) {
            this.f63402b.c(t3);
        }

        @Override // rx.k
        public void onError(Throwable th) {
            new AssemblyStackTraceException(this.f63403c).attachTo(th);
            this.f63402b.onError(th);
        }
    }

    public u0(i.t<T> tVar) {
        this.f63400a = tVar;
    }

    @Override // rx.functions.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((rx.k) ((rx.k) obj));
    }

    public void call(rx.k<? super T> kVar) {
        this.f63400a.call(new a(kVar, this.f63401b));
    }
}

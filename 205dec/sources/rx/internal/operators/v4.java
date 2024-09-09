package rx.internal.operators;

import java.util.Arrays;
import rx.exceptions.CompositeException;
import rx.i;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: SingleOnSubscribeUsing.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class v4<T, Resource> implements i.t<T> {

    /* renamed from: a  reason: collision with root package name */
    final rx.functions.o<Resource> f63476a;

    /* renamed from: b  reason: collision with root package name */
    final rx.functions.p<? super Resource, ? extends rx.i<? extends T>> f63477b;

    /* renamed from: c  reason: collision with root package name */
    final rx.functions.b<? super Resource> f63478c;

    /* renamed from: d  reason: collision with root package name */
    final boolean f63479d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: SingleOnSubscribeUsing.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public class a extends rx.k<T> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Object f63480b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ rx.k f63481c;

        a(Object obj, rx.k kVar) {
            this.f63480b = obj;
            this.f63481c = kVar;
        }

        @Override // rx.k
        public void c(T t3) {
            v4 v4Var = v4.this;
            if (v4Var.f63479d) {
                try {
                    v4Var.f63478c.call((Object) this.f63480b);
                } catch (Throwable th) {
                    rx.exceptions.a.e(th);
                    this.f63481c.onError(th);
                    return;
                }
            }
            this.f63481c.c(t3);
            v4 v4Var2 = v4.this;
            if (v4Var2.f63479d) {
                return;
            }
            try {
                v4Var2.f63478c.call((Object) this.f63480b);
            } catch (Throwable th2) {
                rx.exceptions.a.e(th2);
                rx.plugins.c.I(th2);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // rx.k
        public void onError(Throwable th) {
            v4.this.a(this.f63481c, this.f63480b, th);
        }
    }

    public v4(rx.functions.o<Resource> oVar, rx.functions.p<? super Resource, ? extends rx.i<? extends T>> pVar, rx.functions.b<? super Resource> bVar, boolean z3) {
        this.f63476a = oVar;
        this.f63477b = pVar;
        this.f63478c = bVar;
        this.f63479d = z3;
    }

    void a(rx.k<? super T> kVar, Resource resource, Throwable th) {
        rx.exceptions.a.e(th);
        if (this.f63479d) {
            try {
                this.f63478c.call(resource);
            } catch (Throwable th2) {
                rx.exceptions.a.e(th2);
                th = new CompositeException(Arrays.asList(th, th2));
            }
        }
        kVar.onError(th);
        if (this.f63479d) {
            return;
        }
        try {
            this.f63478c.call(resource);
        } catch (Throwable th3) {
            rx.exceptions.a.e(th3);
            rx.plugins.c.I(th3);
        }
    }

    @Override // rx.functions.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((rx.k) ((rx.k) obj));
    }

    public void call(rx.k<? super T> kVar) {
        try {
            Resource call = this.f63476a.call();
            try {
                rx.i<? extends T> call2 = this.f63477b.call(call);
                if (call2 == null) {
                    a(kVar, call, new NullPointerException("The single"));
                    return;
                }
                a aVar = new a(call, kVar);
                kVar.b(aVar);
                call2.i0(aVar);
            } catch (Throwable th) {
                a(kVar, call, th);
            }
        } catch (Throwable th2) {
            rx.exceptions.a.e(th2);
            kVar.onError(th2);
        }
    }
}

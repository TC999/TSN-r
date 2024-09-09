package rx.internal.operators;

import rx.i;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: SingleOperatorOnErrorResumeNext.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class w4<T> implements i.t<T> {

    /* renamed from: a  reason: collision with root package name */
    private final rx.i<? extends T> f63552a;

    /* renamed from: b  reason: collision with root package name */
    final rx.functions.p<Throwable, ? extends rx.i<? extends T>> f63553b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: SingleOperatorOnErrorResumeNext.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static class a implements rx.functions.p<Throwable, rx.i<? extends T>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ rx.i f63554a;

        a(rx.i iVar) {
            this.f63554a = iVar;
        }

        @Override // rx.functions.p
        public rx.i<? extends T> call(Throwable th) {
            return this.f63554a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: SingleOperatorOnErrorResumeNext.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public class b extends rx.k<T> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ rx.k f63555b;

        b(rx.k kVar) {
            this.f63555b = kVar;
        }

        @Override // rx.k
        public void c(T t3) {
            this.f63555b.c(t3);
        }

        @Override // rx.k
        public void onError(Throwable th) {
            try {
                w4.this.f63553b.call(th).i0(this.f63555b);
            } catch (Throwable th2) {
                rx.exceptions.a.h(th2, this.f63555b);
            }
        }
    }

    private w4(rx.i<? extends T> iVar, rx.functions.p<Throwable, ? extends rx.i<? extends T>> pVar) {
        if (iVar == null) {
            throw new NullPointerException("originalSingle must not be null");
        }
        if (pVar != null) {
            this.f63552a = iVar;
            this.f63553b = pVar;
            return;
        }
        throw new NullPointerException("resumeFunctionInCaseOfError must not be null");
    }

    public static <T> w4<T> a(rx.i<? extends T> iVar, rx.functions.p<Throwable, ? extends rx.i<? extends T>> pVar) {
        return new w4<>(iVar, pVar);
    }

    public static <T> w4<T> b(rx.i<? extends T> iVar, rx.i<? extends T> iVar2) {
        if (iVar2 != null) {
            return new w4<>(iVar, new a(iVar2));
        }
        throw new NullPointerException("resumeSingleInCaseOfError must not be null");
    }

    @Override // rx.functions.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((rx.k) ((rx.k) obj));
    }

    public void call(rx.k<? super T> kVar) {
        b bVar = new b(kVar);
        kVar.b(bVar);
        this.f63552a.i0(bVar);
    }
}

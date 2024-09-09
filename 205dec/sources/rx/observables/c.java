package rx.observables;

import rx.e;
import rx.internal.operators.OnSubscribeAutoConnect;
import rx.internal.operators.z0;
import rx.m;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
/* compiled from: ConnectableObservable.java */
/* loaded from: E:\TSN-r\205dec\5406560.dex */
public abstract class c<T> extends rx.e<T> {

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
    /* compiled from: ConnectableObservable.java */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    class a implements rx.functions.b<m> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ m[] f64145a;

        a(m[] mVarArr) {
            this.f64145a = mVarArr;
        }

        @Override // rx.functions.b
        public void call(m mVar) {
            this.f64145a[0] = mVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public c(e.a<T> aVar) {
        super(aVar);
    }

    public rx.e<T> A7() {
        return rx.e.H6(new z0(this));
    }

    public rx.e<T> v7() {
        return w7(1);
    }

    public rx.e<T> w7(int i4) {
        return x7(i4, rx.functions.m.a());
    }

    public rx.e<T> x7(int i4, rx.functions.b<? super m> bVar) {
        if (i4 <= 0) {
            z7(bVar);
            return this;
        }
        return rx.e.H6(new OnSubscribeAutoConnect(this, i4, bVar));
    }

    public final m y7() {
        m[] mVarArr = new m[1];
        z7(new a(mVarArr));
        return mVarArr[0];
    }

    public abstract void z7(rx.functions.b<? super m> bVar);
}

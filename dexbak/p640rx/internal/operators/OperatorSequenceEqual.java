package p640rx.internal.operators;

import p640rx.Observable;
import p640rx.functions.Func2;
import p640rx.internal.util.UtilityFunctions;

/* renamed from: rx.internal.operators.y2 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class OperatorSequenceEqual {

    /* renamed from: a */
    static final Object f46211a = new Object();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorSequenceEqual.java */
    /* renamed from: rx.internal.operators.y2$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static class C15975a implements Func2<Object, Object, Boolean> {

        /* renamed from: a */
        final /* synthetic */ Func2 f46212a;

        C15975a(Func2 func2) {
            this.f46212a = func2;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // p640rx.functions.Func2
        public Boolean call(Object obj, Object obj2) {
            Object obj3 = OperatorSequenceEqual.f46211a;
            boolean z = obj == obj3;
            boolean z2 = obj2 == obj3;
            if (z && z2) {
                return Boolean.TRUE;
            }
            if (!z && !z2) {
                return (Boolean) this.f46212a.call(obj, obj2);
            }
            return Boolean.FALSE;
        }
    }

    private OperatorSequenceEqual() {
        throw new IllegalStateException("No instances!");
    }

    /* renamed from: a */
    static <T> Observable<Object> m992a(Observable<T> observable) {
        return Observable.m1516v0(observable, Observable.m1802L2(f46211a));
    }

    /* renamed from: b */
    public static <T> Observable<Boolean> m991b(Observable<? extends T> observable, Observable<? extends T> observable2, Func2<? super T, ? super T, Boolean> func2) {
        return Observable.m1549q7(m992a(observable), m992a(observable2), new C15975a(func2)).m1661d(UtilityFunctions.m803c());
    }
}

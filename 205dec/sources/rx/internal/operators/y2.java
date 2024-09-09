package rx.internal.operators;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: OperatorSequenceEqual.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class y2 {

    /* renamed from: a  reason: collision with root package name */
    static final Object f63642a = new Object();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OperatorSequenceEqual.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static class a implements rx.functions.q<Object, Object, Boolean> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ rx.functions.q f63643a;

        a(rx.functions.q qVar) {
            this.f63643a = qVar;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // rx.functions.q
        public Boolean call(Object obj, Object obj2) {
            Object obj3 = y2.f63642a;
            boolean z3 = obj == obj3;
            boolean z4 = obj2 == obj3;
            if (z3 && z4) {
                return Boolean.TRUE;
            }
            if (!z3 && !z4) {
                return (Boolean) this.f63643a.call(obj, obj2);
            }
            return Boolean.FALSE;
        }
    }

    private y2() {
        throw new IllegalStateException("No instances!");
    }

    static <T> rx.e<Object> a(rx.e<T> eVar) {
        return rx.e.v0(eVar, rx.e.L2(f63642a));
    }

    public static <T> rx.e<Boolean> b(rx.e<? extends T> eVar, rx.e<? extends T> eVar2, rx.functions.q<? super T, ? super T, Boolean> qVar) {
        return rx.e.q7(a(eVar), a(eVar2), new a(qVar)).c(rx.internal.util.n.c());
    }
}

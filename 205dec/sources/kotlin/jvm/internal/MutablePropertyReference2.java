package kotlin.jvm.internal;

import kotlin.SinceKotlin;
import kotlin.reflect.m;
import kotlin.reflect.q;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public abstract class MutablePropertyReference2 extends MutablePropertyReference implements kotlin.reflect.m {
    public MutablePropertyReference2() {
    }

    @Override // kotlin.jvm.internal.CallableReference
    protected kotlin.reflect.c computeReflected() {
        return n0.l(this);
    }

    @Override // kotlin.reflect.q
    @SinceKotlin(version = "1.1")
    public Object getDelegate(Object obj, Object obj2) {
        return ((kotlin.reflect.m) getReflected()).getDelegate(obj, obj2);
    }

    @Override // d2.p
    public Object invoke(Object obj, Object obj2) {
        return get(obj, obj2);
    }

    @SinceKotlin(version = "1.4")
    public MutablePropertyReference2(Class cls, String str, String str2, int i4) {
        super(CallableReference.NO_RECEIVER, cls, str, str2, i4);
    }

    @Override // kotlin.reflect.n
    public q.a getGetter() {
        return ((kotlin.reflect.m) getReflected()).getGetter();
    }

    @Override // kotlin.reflect.j
    public m.a getSetter() {
        return ((kotlin.reflect.m) getReflected()).getSetter();
    }
}

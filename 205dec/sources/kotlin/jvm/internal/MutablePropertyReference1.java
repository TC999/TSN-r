package kotlin.jvm.internal;

import kotlin.SinceKotlin;
import kotlin.reflect.l;
import kotlin.reflect.p;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public abstract class MutablePropertyReference1 extends MutablePropertyReference implements kotlin.reflect.l {
    public MutablePropertyReference1() {
    }

    @Override // kotlin.jvm.internal.CallableReference
    protected kotlin.reflect.c computeReflected() {
        return n0.k(this);
    }

    @Override // kotlin.reflect.p
    @SinceKotlin(version = "1.1")
    public Object getDelegate(Object obj) {
        return ((kotlin.reflect.l) getReflected()).getDelegate(obj);
    }

    @Override // d2.l
    public Object invoke(Object obj) {
        return get(obj);
    }

    @SinceKotlin(version = "1.1")
    public MutablePropertyReference1(Object obj) {
        super(obj);
    }

    @Override // kotlin.reflect.n
    public p.a getGetter() {
        return ((kotlin.reflect.l) getReflected()).getGetter();
    }

    @Override // kotlin.reflect.j
    public l.a getSetter() {
        return ((kotlin.reflect.l) getReflected()).getSetter();
    }

    @SinceKotlin(version = "1.4")
    public MutablePropertyReference1(Object obj, Class cls, String str, String str2, int i4) {
        super(obj, cls, str, str2, i4);
    }
}

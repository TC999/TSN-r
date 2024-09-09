package kotlin.jvm.internal;

import kotlin.SinceKotlin;
import kotlin.reflect.o;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public abstract class PropertyReference0 extends PropertyReference implements kotlin.reflect.o {
    public PropertyReference0() {
    }

    @Override // kotlin.jvm.internal.CallableReference
    protected kotlin.reflect.c computeReflected() {
        return n0.t(this);
    }

    @Override // kotlin.reflect.o
    @SinceKotlin(version = "1.1")
    public Object getDelegate() {
        return ((kotlin.reflect.o) getReflected()).getDelegate();
    }

    @Override // d2.a
    public Object invoke() {
        return get();
    }

    @SinceKotlin(version = "1.1")
    public PropertyReference0(Object obj) {
        super(obj);
    }

    @Override // kotlin.reflect.n
    public o.a getGetter() {
        return ((kotlin.reflect.o) getReflected()).getGetter();
    }

    @SinceKotlin(version = "1.4")
    public PropertyReference0(Object obj, Class cls, String str, String str2, int i4) {
        super(obj, cls, str, str2, i4);
    }
}

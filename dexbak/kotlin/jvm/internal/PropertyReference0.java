package kotlin.jvm.internal;

import com.daimajia.numberprogressbar.BuildConfig;
import kotlin.SinceKotlin;
import kotlin.reflect.InterfaceC14450o;
import kotlin.reflect.KCallable;

/* loaded from: E:\fuckcool\tsn\5406560.dex */
public abstract class PropertyReference0 extends PropertyReference implements InterfaceC14450o {
    public PropertyReference0() {
    }

    @Override // kotlin.jvm.internal.CallableReference
    protected KCallable computeReflected() {
        return Reflection.m8110q(this);
    }

    @Override // kotlin.reflect.InterfaceC14450o
    @SinceKotlin(version = "1.1")
    public Object getDelegate() {
        return ((InterfaceC14450o) getReflected()).getDelegate();
    }

    @Override // p617l1.InterfaceC15269a
    public Object invoke() {
        return get();
    }

    @SinceKotlin(version = "1.1")
    public PropertyReference0(Object obj) {
        super(obj);
    }

    @Override // kotlin.reflect.InterfaceC14446n
    public InterfaceC14450o.InterfaceC14451a getGetter() {
        return ((InterfaceC14450o) getReflected()).getGetter();
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    public PropertyReference0(Object obj, Class cls, String str, String str2, int i) {
        super(obj, cls, str, str2, i);
    }
}

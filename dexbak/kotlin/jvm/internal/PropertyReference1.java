package kotlin.jvm.internal;

import com.daimajia.numberprogressbar.BuildConfig;
import kotlin.SinceKotlin;
import kotlin.reflect.InterfaceC14452p;
import kotlin.reflect.KCallable;

/* loaded from: E:\fuckcool\tsn\5406560.dex */
public abstract class PropertyReference1 extends PropertyReference implements InterfaceC14452p {
    public PropertyReference1() {
    }

    @Override // kotlin.jvm.internal.CallableReference
    protected KCallable computeReflected() {
        return Reflection.m8109r(this);
    }

    @Override // kotlin.reflect.InterfaceC14452p
    @SinceKotlin(version = "1.1")
    public Object getDelegate(Object obj) {
        return ((InterfaceC14452p) getReflected()).getDelegate(obj);
    }

    @Override // p617l1.InterfaceC15280l
    public Object invoke(Object obj) {
        return get(obj);
    }

    @SinceKotlin(version = "1.1")
    public PropertyReference1(Object obj) {
        super(obj);
    }

    @Override // kotlin.reflect.InterfaceC14446n
    public InterfaceC14452p.InterfaceC14453a getGetter() {
        return ((InterfaceC14452p) getReflected()).getGetter();
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    public PropertyReference1(Object obj, Class cls, String str, String str2, int i) {
        super(obj, cls, str, str2, i);
    }
}

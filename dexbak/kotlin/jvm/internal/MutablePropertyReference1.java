package kotlin.jvm.internal;

import com.daimajia.numberprogressbar.BuildConfig;
import kotlin.SinceKotlin;
import kotlin.reflect.InterfaceC14442l;
import kotlin.reflect.InterfaceC14452p;
import kotlin.reflect.KCallable;

/* loaded from: E:\fuckcool\tsn\5406560.dex */
public abstract class MutablePropertyReference1 extends MutablePropertyReference implements InterfaceC14442l {
    public MutablePropertyReference1() {
    }

    @Override // kotlin.jvm.internal.CallableReference
    protected KCallable computeReflected() {
        return Reflection.m8117j(this);
    }

    @Override // kotlin.reflect.InterfaceC14452p
    @SinceKotlin(version = "1.1")
    public Object getDelegate(Object obj) {
        return ((InterfaceC14442l) getReflected()).getDelegate(obj);
    }

    @Override // p617l1.InterfaceC15280l
    public Object invoke(Object obj) {
        return get(obj);
    }

    @SinceKotlin(version = "1.1")
    public MutablePropertyReference1(Object obj) {
        super(obj);
    }

    @Override // kotlin.reflect.InterfaceC14446n
    public InterfaceC14452p.InterfaceC14453a getGetter() {
        return ((InterfaceC14442l) getReflected()).getGetter();
    }

    @Override // kotlin.reflect.KProperty
    public InterfaceC14442l.InterfaceC14443a getSetter() {
        return ((InterfaceC14442l) getReflected()).getSetter();
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    public MutablePropertyReference1(Object obj, Class cls, String str, String str2, int i) {
        super(obj, cls, str, str2, i);
    }
}

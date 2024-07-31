package kotlin.jvm.internal;

import com.daimajia.numberprogressbar.BuildConfig;
import kotlin.SinceKotlin;
import kotlin.reflect.InterfaceC14454q;
import kotlin.reflect.KCallable;

/* loaded from: E:\fuckcool\tsn\5406560.dex */
public abstract class PropertyReference2 extends PropertyReference implements InterfaceC14454q {
    public PropertyReference2() {
    }

    @Override // kotlin.jvm.internal.CallableReference
    protected KCallable computeReflected() {
        return Reflection.m8108s(this);
    }

    @Override // kotlin.reflect.InterfaceC14454q
    @SinceKotlin(version = "1.1")
    public Object getDelegate(Object obj, Object obj2) {
        return ((InterfaceC14454q) getReflected()).getDelegate(obj, obj2);
    }

    @Override // p617l1.InterfaceC15284p
    public Object invoke(Object obj, Object obj2) {
        return get(obj, obj2);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    public PropertyReference2(Class cls, String str, String str2, int i) {
        super(CallableReference.NO_RECEIVER, cls, str, str2, i);
    }

    @Override // kotlin.reflect.InterfaceC14446n
    public InterfaceC14454q.InterfaceC14455a getGetter() {
        return ((InterfaceC14454q) getReflected()).getGetter();
    }
}

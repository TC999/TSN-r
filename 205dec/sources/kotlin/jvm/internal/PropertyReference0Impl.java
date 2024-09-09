package kotlin.jvm.internal;

import kotlin.SinceKotlin;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class PropertyReference0Impl extends PropertyReference0 {
    public PropertyReference0Impl(kotlin.reflect.h hVar, String str, String str2) {
        super(CallableReference.NO_RECEIVER, ((r) hVar).d(), str, str2, !(hVar instanceof kotlin.reflect.d) ? 1 : 0);
    }

    @Override // kotlin.reflect.o
    public Object get() {
        return getGetter().call(new Object[0]);
    }

    @SinceKotlin(version = "1.4")
    public PropertyReference0Impl(Class cls, String str, String str2, int i4) {
        super(CallableReference.NO_RECEIVER, cls, str, str2, i4);
    }

    @SinceKotlin(version = "1.4")
    public PropertyReference0Impl(Object obj, Class cls, String str, String str2, int i4) {
        super(obj, cls, str, str2, i4);
    }
}

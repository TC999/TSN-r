package kotlin.jvm.internal;

import kotlin.SinceKotlin;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class PropertyReference1Impl extends PropertyReference1 {
    public PropertyReference1Impl(kotlin.reflect.h hVar, String str, String str2) {
        super(CallableReference.NO_RECEIVER, ((r) hVar).d(), str, str2, !(hVar instanceof kotlin.reflect.d) ? 1 : 0);
    }

    @Override // kotlin.reflect.p
    public Object get(Object obj) {
        return getGetter().call(obj);
    }

    @SinceKotlin(version = "1.4")
    public PropertyReference1Impl(Class cls, String str, String str2, int i4) {
        super(CallableReference.NO_RECEIVER, cls, str, str2, i4);
    }

    @SinceKotlin(version = "1.4")
    public PropertyReference1Impl(Object obj, Class cls, String str, String str2, int i4) {
        super(obj, cls, str, str2, i4);
    }
}

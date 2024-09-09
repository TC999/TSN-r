package kotlin.jvm.internal;

import kotlin.SinceKotlin;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class MutablePropertyReference2Impl extends MutablePropertyReference2 {
    public MutablePropertyReference2Impl(kotlin.reflect.h hVar, String str, String str2) {
        super(((r) hVar).d(), str, str2, !(hVar instanceof kotlin.reflect.d) ? 1 : 0);
    }

    @Override // kotlin.reflect.q
    public Object get(Object obj, Object obj2) {
        return getGetter().call(obj, obj2);
    }

    @Override // kotlin.reflect.m
    public void set(Object obj, Object obj2, Object obj3) {
        getSetter().call(obj, obj2, obj3);
    }

    @SinceKotlin(version = "1.4")
    public MutablePropertyReference2Impl(Class cls, String str, String str2, int i4) {
        super(cls, str, str2, i4);
    }
}

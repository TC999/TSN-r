package kotlin.jvm.internal;

import kotlin.SinceKotlin;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class FunctionReferenceImpl extends FunctionReference {
    public FunctionReferenceImpl(int i4, kotlin.reflect.h hVar, String str, String str2) {
        super(i4, CallableReference.NO_RECEIVER, ((r) hVar).d(), str, str2, !(hVar instanceof kotlin.reflect.d) ? 1 : 0);
    }

    @SinceKotlin(version = "1.4")
    public FunctionReferenceImpl(int i4, Class cls, String str, String str2, int i5) {
        super(i4, CallableReference.NO_RECEIVER, cls, str, str2, i5);
    }

    @SinceKotlin(version = "1.4")
    public FunctionReferenceImpl(int i4, Object obj, Class cls, String str, String str2, int i5) {
        super(i4, obj, cls, str, str2, i5);
    }
}

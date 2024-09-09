package kotlinx.coroutines;

import kotlin.Metadata;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final /* synthetic */ class s0 {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int[] f60552a;

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ int[] f60553b;

    static {
        int[] iArr = new int[CoroutineStart.values().length];
        f60552a = iArr;
        CoroutineStart coroutineStart = CoroutineStart.DEFAULT;
        iArr[coroutineStart.ordinal()] = 1;
        CoroutineStart coroutineStart2 = CoroutineStart.ATOMIC;
        iArr[coroutineStart2.ordinal()] = 2;
        CoroutineStart coroutineStart3 = CoroutineStart.UNDISPATCHED;
        iArr[coroutineStart3.ordinal()] = 3;
        CoroutineStart coroutineStart4 = CoroutineStart.LAZY;
        iArr[coroutineStart4.ordinal()] = 4;
        int[] iArr2 = new int[CoroutineStart.values().length];
        f60553b = iArr2;
        iArr2[coroutineStart.ordinal()] = 1;
        iArr2[coroutineStart2.ordinal()] = 2;
        iArr2[coroutineStart3.ordinal()] = 3;
        iArr2[coroutineStart4.ordinal()] = 4;
    }
}

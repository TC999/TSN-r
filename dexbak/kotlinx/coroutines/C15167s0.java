package kotlinx.coroutines;

import kotlin.Metadata;

@Metadata(m12618bv = {1, 0, 3}, m12615k = 3, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.s0 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final /* synthetic */ class C15167s0 {

    /* renamed from: a */
    public static final /* synthetic */ int[] f43235a;

    /* renamed from: b */
    public static final /* synthetic */ int[] f43236b;

    static {
        int[] iArr = new int[CoroutineStart.values().length];
        f43235a = iArr;
        CoroutineStart coroutineStart = CoroutineStart.DEFAULT;
        iArr[coroutineStart.ordinal()] = 1;
        CoroutineStart coroutineStart2 = CoroutineStart.ATOMIC;
        iArr[coroutineStart2.ordinal()] = 2;
        CoroutineStart coroutineStart3 = CoroutineStart.UNDISPATCHED;
        iArr[coroutineStart3.ordinal()] = 3;
        CoroutineStart coroutineStart4 = CoroutineStart.LAZY;
        iArr[coroutineStart4.ordinal()] = 4;
        int[] iArr2 = new int[CoroutineStart.values().length];
        f43236b = iArr2;
        iArr2[coroutineStart.ordinal()] = 1;
        iArr2[coroutineStart2.ordinal()] = 2;
        iArr2[coroutineStart3.ordinal()] = 3;
        iArr2[coroutineStart4.ordinal()] = 4;
    }
}

package kotlin.reflect;

import kotlin.Metadata;

@Metadata(m12615k = 3, m12614mv = {1, 5, 1})
/* renamed from: kotlin.reflect.z */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final /* synthetic */ class C14463z {

    /* renamed from: a */
    public static final /* synthetic */ int[] f41349a;

    /* renamed from: b */
    public static final /* synthetic */ int[] f41350b;

    static {
        int[] iArr = new int[KVariance.values().length];
        f41349a = iArr;
        KVariance kVariance = KVariance.IN;
        iArr[kVariance.ordinal()] = 1;
        KVariance kVariance2 = KVariance.INVARIANT;
        iArr[kVariance2.ordinal()] = 2;
        KVariance kVariance3 = KVariance.OUT;
        iArr[kVariance3.ordinal()] = 3;
        int[] iArr2 = new int[KVariance.values().length];
        f41350b = iArr2;
        iArr2[kVariance2.ordinal()] = 1;
        iArr2[kVariance.ordinal()] = 2;
        iArr2[kVariance3.ordinal()] = 3;
    }
}

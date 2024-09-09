package kotlin.jvm.internal;

import kotlin.Metadata;
import kotlin.reflect.KVariance;

@Metadata(k = 3, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\5406560.dex */
public final /* synthetic */ class w0 {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int[] f55709a;

    static {
        int[] iArr = new int[KVariance.values().length];
        f55709a = iArr;
        iArr[KVariance.INVARIANT.ordinal()] = 1;
        iArr[KVariance.IN.ordinal()] = 2;
        iArr[KVariance.OUT.ordinal()] = 3;
    }
}

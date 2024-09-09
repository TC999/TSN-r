package kotlinx.coroutines.channels;

import kotlin.Metadata;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final /* synthetic */ class k0 {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int[] f59429a;

    static {
        int[] iArr = new int[TickerMode.values().length];
        f59429a = iArr;
        iArr[TickerMode.FIXED_PERIOD.ordinal()] = 1;
        iArr[TickerMode.FIXED_DELAY.ordinal()] = 2;
    }
}

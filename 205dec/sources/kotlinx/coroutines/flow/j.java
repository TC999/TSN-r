package kotlinx.coroutines.flow;

import kotlin.Metadata;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final /* synthetic */ class j {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int[] f60181a;

    static {
        int[] iArr = new int[SharingCommand.values().length];
        f60181a = iArr;
        iArr[SharingCommand.START.ordinal()] = 1;
        iArr[SharingCommand.STOP.ordinal()] = 2;
        iArr[SharingCommand.STOP_AND_RESET_REPLAY_CACHE.ordinal()] = 3;
    }
}

package kotlinx.coroutines.scheduling;

import kotlin.Metadata;
import kotlinx.coroutines.scheduling.CoroutineScheduler;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final /* synthetic */ class a {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int[] f60591a;

    static {
        int[] iArr = new int[CoroutineScheduler.WorkerState.values().length];
        f60591a = iArr;
        iArr[CoroutineScheduler.WorkerState.PARKING.ordinal()] = 1;
        iArr[CoroutineScheduler.WorkerState.BLOCKING.ordinal()] = 2;
        iArr[CoroutineScheduler.WorkerState.CPU_ACQUIRED.ordinal()] = 3;
        iArr[CoroutineScheduler.WorkerState.DORMANT.ordinal()] = 4;
        iArr[CoroutineScheduler.WorkerState.TERMINATED.ordinal()] = 5;
    }
}

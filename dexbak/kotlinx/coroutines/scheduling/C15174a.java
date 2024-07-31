package kotlinx.coroutines.scheduling;

import kotlin.Metadata;
import kotlinx.coroutines.scheduling.CoroutineScheduler;

@Metadata(m12618bv = {1, 0, 3}, m12615k = 3, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.scheduling.a */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final /* synthetic */ class C15174a {

    /* renamed from: a */
    public static final /* synthetic */ int[] f43274a;

    static {
        int[] iArr = new int[CoroutineScheduler.WorkerState.values().length];
        f43274a = iArr;
        iArr[CoroutineScheduler.WorkerState.PARKING.ordinal()] = 1;
        iArr[CoroutineScheduler.WorkerState.BLOCKING.ordinal()] = 2;
        iArr[CoroutineScheduler.WorkerState.CPU_ACQUIRED.ordinal()] = 3;
        iArr[CoroutineScheduler.WorkerState.DORMANT.ordinal()] = 4;
        iArr[CoroutineScheduler.WorkerState.TERMINATED.ordinal()] = 5;
    }
}

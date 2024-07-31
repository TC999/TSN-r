package kotlinx.coroutines.scheduling;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlinx.coroutines.scheduling.CoroutineScheduler;
import org.jetbrains.annotations.NotNull;

/* compiled from: CoroutineScheduler.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\u0010\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0001\u001a\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0001¨\u0006\u0005"}, m12616d2 = {"Ljava/lang/Thread;", "thread", "", "a", "b", "kotlinx-coroutines-core"}, m12615k = 2, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.scheduling.b */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class C15175b {
    @JvmName(name = "isSchedulerWorker")
    /* renamed from: a */
    public static final boolean m3753a(@NotNull Thread thread) {
        return thread instanceof CoroutineScheduler.C15173b;
    }

    @JvmName(name = "mayNotBlock")
    /* renamed from: b */
    public static final boolean m3752b(@NotNull Thread thread) {
        return (thread instanceof CoroutineScheduler.C15173b) && ((CoroutineScheduler.C15173b) thread).f43268b == CoroutineScheduler.WorkerState.CPU_ACQUIRED;
    }
}

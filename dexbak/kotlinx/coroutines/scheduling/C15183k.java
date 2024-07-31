package kotlinx.coroutines.scheduling;

import kotlin.Metadata;
import kotlin.jvm.JvmPlatformAnnotations;
import kotlinx.coroutines.DebugStrings;
import org.jetbrains.annotations.NotNull;

/* compiled from: Tasks.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B#\u0012\n\u0010\n\u001a\u00060\u0006j\u0002`\u0007\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\u0018\u0010\n\u001a\u00060\u0006j\u0002`\u00078\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\u0011"}, m12616d2 = {"Lkotlinx/coroutines/scheduling/k;", "Lkotlinx/coroutines/scheduling/i;", "Lkotlin/f1;", "run", "", "toString", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "c", "Ljava/lang/Runnable;", "block", "", "submissionTime", "Lkotlinx/coroutines/scheduling/j;", "taskContext", "<init>", "(Ljava/lang/Runnable;JLkotlinx/coroutines/scheduling/j;)V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.scheduling.k */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class C15183k extends AbstractRunnableC15181i {
    @JvmPlatformAnnotations
    @NotNull

    /* renamed from: c */
    public final Runnable f43293c;

    public C15183k(@NotNull Runnable runnable, long j, @NotNull InterfaceC15182j interfaceC15182j) {
        super(j, interfaceC15182j);
        this.f43293c = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f43293c.run();
        } finally {
            this.f43292b.mo3739f();
        }
    }

    @NotNull
    public String toString() {
        return "Task[" + DebugStrings.m3554a(this.f43293c) + '@' + DebugStrings.m3553b(this.f43293c) + ", " + this.f43291a + ", " + this.f43292b + ']';
    }
}

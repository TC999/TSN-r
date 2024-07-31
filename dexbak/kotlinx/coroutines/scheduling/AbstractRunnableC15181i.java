package kotlinx.coroutines.scheduling;

import io.netty.handler.codec.rtsp.RtspHeaders;
import kotlin.Metadata;
import kotlin.jvm.JvmPlatformAnnotations;
import org.jetbrains.annotations.NotNull;

/* compiled from: Tasks.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\b \u0018\u00002\u00060\u0001j\u0002`\u0002B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000e\u0010\u000fB\t\b\u0016¢\u0006\u0004\b\u000e\u0010\u0010R\u0016\u0010\u0006\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0016\u0010\n\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0012\u0010\r\u001a\u00020\u000b8Æ\u0002¢\u0006\u0006\u001a\u0004\b\b\u0010\f¨\u0006\u0011"}, m12616d2 = {"Lkotlinx/coroutines/scheduling/i;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "", "a", "J", "submissionTime", "Lkotlinx/coroutines/scheduling/j;", "b", "Lkotlinx/coroutines/scheduling/j;", "taskContext", "", "()I", RtspHeaders.Values.MODE, "<init>", "(JLkotlinx/coroutines/scheduling/j;)V", "()V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.scheduling.i */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public abstract class AbstractRunnableC15181i implements Runnable {
    @JvmPlatformAnnotations

    /* renamed from: a */
    public long f43291a;
    @JvmPlatformAnnotations
    @NotNull

    /* renamed from: b */
    public InterfaceC15182j f43292b;

    public AbstractRunnableC15181i(long j, @NotNull InterfaceC15182j interfaceC15182j) {
        this.f43291a = j;
        this.f43292b = interfaceC15182j;
    }

    /* renamed from: b */
    public final int m3740b() {
        return this.f43292b.mo3738h();
    }

    public AbstractRunnableC15181i() {
        this(0L, C15180h.f43290b);
    }
}

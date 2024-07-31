package kotlinx.coroutines.test;

import com.kwad.sdk.api.model.AdnName;
import io.netty.handler.codec.rtsp.RtspHeaders;
import kotlin.Metadata;
import kotlin.jvm.JvmPlatformAnnotations;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.internal.InterfaceC15102t0;
import kotlinx.coroutines.internal.ThreadSafeHeap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TestCoroutineContext.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\t\n\u0002\b\u0006\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00060\u0002j\u0002`\u00032\u00020\u0004B'\u0012\n\u0010\u0006\u001a\u00060\u0002j\u0002`\u0003\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u001a\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u001a¢\u0006\u0004\b\u001e\u0010\u001fJ\b\u0010\u0006\u001a\u00020\u0005H\u0016J\u0011\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0000H\u0096\u0002J\b\u0010\u000b\u001a\u00020\nH\u0016R(\u0010\u0012\u001a\b\u0012\u0002\b\u0003\u0018\u00010\f8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\r\u0010\u0011R\"\u0010\u0018\u001a\u00020\b8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0013\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0006\u001a\u00060\u0002j\u0002`\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0019R\u0014\u0010\u001c\u001a\u00020\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u001bR\u0014\u0010\u001d\u001a\u00020\u001a8\u0000X\u0081\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u001b¨\u0006 "}, m12616d2 = {"Lkotlinx/coroutines/test/c;", "", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "Lkotlinx/coroutines/internal/t0;", "Lkotlin/f1;", "run", AdnName.OTHER, "", "e", "", "toString", "Lkotlinx/coroutines/internal/s0;", "a", "Lkotlinx/coroutines/internal/s0;", "c", "()Lkotlinx/coroutines/internal/s0;", "(Lkotlinx/coroutines/internal/s0;)V", "heap", "b", "I", "()I", "d", "(I)V", "index", "Ljava/lang/Runnable;", "", "J", "count", RtspHeaders.Values.TIME, "<init>", "(Ljava/lang/Runnable;JJ)V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.test.c */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class RunnableC15234c implements Comparable<RunnableC15234c>, Runnable, InterfaceC15102t0 {
    @Nullable

    /* renamed from: a */
    private ThreadSafeHeap<?> f43420a;

    /* renamed from: b */
    private int f43421b;

    /* renamed from: c */
    private final Runnable f43422c;

    /* renamed from: d */
    private final long f43423d;
    @JvmPlatformAnnotations

    /* renamed from: e */
    public final long f43424e;

    public RunnableC15234c(@NotNull Runnable runnable, long j, long j2) {
        this.f43422c = runnable;
        this.f43423d = j;
        this.f43424e = j2;
    }

    @Override // kotlinx.coroutines.internal.InterfaceC15102t0
    /* renamed from: a */
    public void mo3559a(@Nullable ThreadSafeHeap<?> threadSafeHeap) {
        this.f43420a = threadSafeHeap;
    }

    @Override // kotlinx.coroutines.internal.InterfaceC15102t0
    /* renamed from: b */
    public int mo3558b() {
        return this.f43421b;
    }

    @Override // kotlinx.coroutines.internal.InterfaceC15102t0
    @Nullable
    /* renamed from: c */
    public ThreadSafeHeap<?> mo3557c() {
        return this.f43420a;
    }

    @Override // kotlinx.coroutines.internal.InterfaceC15102t0
    /* renamed from: d */
    public void mo3556d(int i) {
        this.f43421b = i;
    }

    @Override // java.lang.Comparable
    /* renamed from: e */
    public int compareTo(@NotNull RunnableC15234c runnableC15234c) {
        long j = this.f43424e;
        long j2 = runnableC15234c.f43424e;
        if (j == j2) {
            j = this.f43423d;
            j2 = runnableC15234c.f43423d;
        }
        return (j > j2 ? 1 : (j == j2 ? 0 : -1));
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f43422c.run();
    }

    @NotNull
    public String toString() {
        return "TimedRunnable(time=" + this.f43424e + ", run=" + this.f43422c + ')';
    }

    public /* synthetic */ RunnableC15234c(Runnable runnable, long j, long j2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(runnable, (i & 2) != 0 ? 0L : j, (i & 4) != 0 ? 0L : j2);
    }
}

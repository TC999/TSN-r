package kotlinx.coroutines;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: TimeSource.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0004\u001a\u00020\u0002H&J\u0018\u0010\b\u001a\u00060\u0005j\u0002`\u00062\n\u0010\u0007\u001a\u00060\u0005j\u0002`\u0006H&J\b\u0010\n\u001a\u00020\tH&J\b\u0010\u000b\u001a\u00020\tH&J\b\u0010\f\u001a\u00020\tH&J\b\u0010\r\u001a\u00020\tH&J\u0018\u0010\u0010\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0002H&J\u0010\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0011H&¨\u0006\u0014"}, m12616d2 = {"Lkotlinx/coroutines/o3;", "", "", "a", "nanoTime", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "block", "g", "Lkotlin/f1;", "f", "b", "h", "e", "blocker", "nanos", "d", "Ljava/lang/Thread;", "thread", "c", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.o3 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public interface InterfaceC15152o3 {
    /* renamed from: a */
    long m3932a();

    /* renamed from: b */
    void m3931b();

    /* renamed from: c */
    void m3930c(@NotNull Thread thread);

    /* renamed from: d */
    void m3929d(@NotNull Object obj, long j);

    /* renamed from: e */
    void m3928e();

    /* renamed from: f */
    void m3927f();

    @NotNull
    /* renamed from: g */
    Runnable m3926g(@NotNull Runnable runnable);

    /* renamed from: h */
    void m3925h();

    long nanoTime();
}

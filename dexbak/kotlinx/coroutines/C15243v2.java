package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.jvm.JvmPlatformAnnotations;
import org.jetbrains.annotations.NotNull;

/* compiled from: ThreadPoolDispatcher.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\n\u0010\b\u001a\u00060\u0006j\u0002`\u0007\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\r"}, m12616d2 = {"Lkotlinx/coroutines/v2;", "Ljava/lang/Thread;", "Lkotlinx/coroutines/l3;", "a", "Lkotlinx/coroutines/l3;", "dispatcher", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "target", "", "name", "<init>", "(Lkotlinx/coroutines/l3;Ljava/lang/Runnable;Ljava/lang/String;)V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.v2 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class C15243v2 extends Thread {
    @JvmPlatformAnnotations
    @NotNull

    /* renamed from: a */
    public final ThreadPoolDispatcher f43437a;

    public C15243v2(@NotNull ThreadPoolDispatcher threadPoolDispatcher, @NotNull Runnable runnable, @NotNull String str) {
        super(runnable, str);
        this.f43437a = threadPoolDispatcher;
        setDaemon(true);
    }
}

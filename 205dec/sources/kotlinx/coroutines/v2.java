package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: ThreadPoolDispatcher.kt */
@Metadata(bv = {}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\n\u0010\b\u001a\u00060\u0006j\u0002`\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u00a2\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\r"}, d2 = {"Lkotlinx/coroutines/v2;", "Ljava/lang/Thread;", "Lkotlinx/coroutines/l3;", "a", "Lkotlinx/coroutines/l3;", "dispatcher", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "target", "", "name", "<init>", "(Lkotlinx/coroutines/l3;Ljava/lang/Runnable;Ljava/lang/String;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class v2 extends Thread {
    @JvmField
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public final l3 f60754a;

    public v2(@NotNull l3 l3Var, @NotNull Runnable runnable, @NotNull String str) {
        super(runnable, str);
        this.f60754a = l3Var;
        setDaemon(true);
    }
}

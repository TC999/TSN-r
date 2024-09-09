package kotlinx.coroutines.scheduling;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: Tasks.kt */
@Metadata(bv = {}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\b \u0018\u00002\u00060\u0001j\u0002`\u0002B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fB\t\b\u0016\u00a2\u0006\u0004\b\u000e\u0010\u0010R\u0016\u0010\u0006\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0016\u0010\n\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0012\u0010\r\u001a\u00020\u000b8\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\f\u00a8\u0006\u0011"}, d2 = {"Lkotlinx/coroutines/scheduling/i;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "", "a", "J", "submissionTime", "Lkotlinx/coroutines/scheduling/j;", "b", "Lkotlinx/coroutines/scheduling/j;", "taskContext", "", "()I", "mode", "<init>", "(JLkotlinx/coroutines/scheduling/j;)V", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public abstract class i implements Runnable {
    @JvmField

    /* renamed from: a  reason: collision with root package name */
    public long f60608a;
    @JvmField
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    public j f60609b;

    public i(long j4, @NotNull j jVar) {
        this.f60608a = j4;
        this.f60609b = jVar;
    }

    public final int b() {
        return this.f60609b.n();
    }

    public i() {
        this(0L, h.f60607b);
    }
}

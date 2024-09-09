package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: CompletionState.kt */
@Metadata(bv = {}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0007\b\u0010\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\b\b\u0002\u0010\f\u001a\u00020\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u000b\u001a\u00020\b8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0011\u0010\f\u001a\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\u0004\u00a8\u0006\u000f"}, d2 = {"Lkotlinx/coroutines/d0;", "", "", "b", "()Z", "", "toString", "()Ljava/lang/String;", "", "a", "Ljava/lang/Throwable;", "cause", "handled", "<init>", "(Ljava/lang/Throwable;Z)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class d0 {

    /* renamed from: b  reason: collision with root package name */
    private static final AtomicIntegerFieldUpdater f59533b = AtomicIntegerFieldUpdater.newUpdater(d0.class, "_handled");
    private volatile int _handled;
    @JvmField
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public final Throwable f59534a;

    public d0(@NotNull Throwable th, boolean z3) {
        this.f59534a = th;
        this._handled = z3 ? 1 : 0;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [boolean, int] */
    public final boolean a() {
        return this._handled;
    }

    public final boolean b() {
        return f59533b.compareAndSet(this, 0, 1);
    }

    @NotNull
    public String toString() {
        return u0.a(this) + '[' + this.f59534a + ']';
    }

    public /* synthetic */ d0(Throwable th, boolean z3, int i4, kotlin.jvm.internal.u uVar) {
        this(th, (i4 & 2) != 0 ? false : z3);
    }
}

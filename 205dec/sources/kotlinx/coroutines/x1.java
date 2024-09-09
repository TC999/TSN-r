package kotlinx.coroutines;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: JobSupport.kt */
@Metadata(bv = {}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\t\u001a\u00020\u0004\u00a2\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u001a\u0010\t\u001a\u00020\u00048\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u000b\u001a\u00020\n8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u000f"}, d2 = {"Lkotlinx/coroutines/x1;", "Lkotlinx/coroutines/y1;", "", "toString", "Lkotlinx/coroutines/q2;", "a", "Lkotlinx/coroutines/q2;", "f", "()Lkotlinx/coroutines/q2;", "list", "", "isActive", "()Z", "<init>", "(Lkotlinx/coroutines/q2;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class x1 implements y1 {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final q2 f60765a;

    public x1(@NotNull q2 q2Var) {
        this.f60765a = q2Var;
    }

    @Override // kotlinx.coroutines.y1
    @NotNull
    public q2 f() {
        return this.f60765a;
    }

    @Override // kotlinx.coroutines.y1
    public boolean isActive() {
        return false;
    }

    @NotNull
    public String toString() {
        return super.toString();
    }
}

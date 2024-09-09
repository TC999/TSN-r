package kotlinx.coroutines;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: JobSupport.kt */
@Metadata(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\u000e\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003J\b\u0010\u0006\u001a\u00020\u0003H\u0016R\u0014\u0010\b\u001a\u00020\u00078VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\f\u001a\u00020\u00008VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lkotlinx/coroutines/q2;", "Lkotlinx/coroutines/internal/q;", "Lkotlinx/coroutines/y1;", "", "state", "k0", "toString", "", "isActive", "()Z", "f", "()Lkotlinx/coroutines/q2;", "list", "<init>", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class q2 extends kotlinx.coroutines.internal.q implements y1 {
    @Override // kotlinx.coroutines.y1
    @NotNull
    public q2 f() {
        return this;
    }

    @Override // kotlinx.coroutines.y1
    public boolean isActive() {
        return true;
    }

    @NotNull
    public final String k0(@NotNull String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("List{");
        sb.append(str);
        sb.append("}[");
        Object Q = Q();
        if (Q != null) {
            boolean z3 = true;
            for (kotlinx.coroutines.internal.s sVar = (kotlinx.coroutines.internal.s) Q; !kotlin.jvm.internal.f0.g(sVar, this); sVar = sVar.R()) {
                if (sVar instanceof k2) {
                    k2 k2Var = (k2) sVar;
                    if (z3) {
                        z3 = false;
                    } else {
                        sb.append(", ");
                    }
                    sb.append(k2Var);
                }
            }
            sb.append("]");
            String sb2 = sb.toString();
            kotlin.jvm.internal.f0.o(sb2, "StringBuilder().apply(builderAction).toString()");
            return sb2;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
    }

    @Override // kotlinx.coroutines.internal.s
    @NotNull
    public String toString() {
        return super.toString();
    }
}

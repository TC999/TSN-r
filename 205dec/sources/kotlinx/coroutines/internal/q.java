package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.f1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: LockFreeLinkedList.kt */
@Metadata(bv = {}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0016\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0012\u0010\fJ-\u0010\u0007\u001a\u00020\u0005\"\u000e\b\u0000\u0010\u0003\u0018\u0001*\u00060\u0001j\u0002`\u00022\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\u0004H\u0086\bJ\u0006\u0010\t\u001a\u00020\bJ\u0010\u0010\n\u001a\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u0002H\u0014J\u000f\u0010\u000b\u001a\u00020\u0005H\u0000\u00a2\u0006\u0004\b\u000b\u0010\fR\u0011\u0010\u000f\u001a\u00020\b8F\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u000e\u00a8\u0006\u0013"}, d2 = {"Lkotlinx/coroutines/internal/q;", "Lkotlinx/coroutines/internal/s;", "Lkotlinx/coroutines/internal/Node;", "T", "Lkotlin/Function1;", "Lkotlin/f1;", "block", "h0", "", "a0", "Z", "j0", "()V", "i0", "()Z", "isEmpty", "X", "isRemoved", "<init>", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class q extends s {
    @Override // kotlinx.coroutines.internal.s
    public boolean X() {
        return false;
    }

    @Override // kotlinx.coroutines.internal.s
    @Nullable
    protected s Z() {
        return null;
    }

    @Override // kotlinx.coroutines.internal.s
    public final boolean a0() {
        throw new IllegalStateException("head cannot be removed".toString());
    }

    public final /* synthetic */ <T extends s> void h0(@NotNull d2.l<? super T, f1> lVar) {
        Object Q = Q();
        if (Q != null) {
            for (s sVar = (s) Q; !kotlin.jvm.internal.f0.g(sVar, this); sVar = sVar.R()) {
                kotlin.jvm.internal.f0.y(3, "T");
                if (sVar instanceof s) {
                    lVar.invoke(sVar);
                }
            }
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
    }

    public final boolean i0() {
        return Q() == this;
    }

    public final void j0() {
        Object Q = Q();
        if (Q != null) {
            s sVar = (s) Q;
            s sVar2 = this;
            while (!kotlin.jvm.internal.f0.g(sVar, this)) {
                s R = sVar.R();
                sVar.g0(sVar2, R);
                sVar2 = sVar;
                sVar = R;
            }
            Object Q2 = Q();
            if (Q2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
            }
            g0(sVar2, (s) Q2);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
    }
}

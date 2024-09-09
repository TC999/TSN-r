package kotlinx.coroutines.channels;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.r1;
import kotlinx.coroutines.u0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: Actor.kt */
@Metadata(bv = {}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0012\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003B%\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\r\u0012\u0006\u0010\u000f\u001a\u00020\t\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0004H\u0014\u00a8\u0006\u0012"}, d2 = {"Lkotlinx/coroutines/channels/d;", "E", "Lkotlinx/coroutines/channels/o;", "Lkotlinx/coroutines/channels/f;", "", "cause", "Lkotlin/f1;", "R0", "exception", "", "z0", "Lkotlin/coroutines/f;", "parentContext", "Lkotlinx/coroutines/channels/n;", "channel", "active", "<init>", "(Lkotlin/coroutines/f;Lkotlinx/coroutines/channels/n;Z)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
class d<E> extends o<E> implements f<E> {
    public d(@NotNull kotlin.coroutines.f fVar, @NotNull n<E> nVar, boolean z3) {
        super(fVar, nVar, z3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.l2
    protected void R0(@Nullable Throwable th) {
        n<E> s12 = s1();
        if (th != null) {
            r1 = th instanceof CancellationException ? th : null;
            if (r1 == null) {
                r1 = r1.a(u0.a(this) + " was cancelled", th);
            }
        }
        s12.b(r1);
    }

    @Override // kotlinx.coroutines.l2
    protected boolean z0(@NotNull Throwable th) {
        n0.b(getContext(), th);
        return true;
    }
}

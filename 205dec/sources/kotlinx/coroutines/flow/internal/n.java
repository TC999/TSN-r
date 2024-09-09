package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlinx.coroutines.channels.a0;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: FlowCoroutine.kt */
@Metadata(bv = {}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u001d\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\t\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016\u00a8\u0006\r"}, d2 = {"Lkotlinx/coroutines/flow/internal/n;", "T", "Lkotlinx/coroutines/channels/a0;", "", "cause", "", "h0", "Lkotlin/coroutines/f;", "parentContext", "Lkotlinx/coroutines/channels/n;", "channel", "<init>", "(Lkotlin/coroutines/f;Lkotlinx/coroutines/channels/n;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class n<T> extends a0<T> {
    public n(@NotNull kotlin.coroutines.f fVar, @NotNull kotlinx.coroutines.channels.n<T> nVar) {
        super(fVar, nVar);
    }

    @Override // kotlinx.coroutines.l2
    public boolean h0(@NotNull Throwable th) {
        if (th instanceof ChildCancelledException) {
            return true;
        }
        return c0(th);
    }
}

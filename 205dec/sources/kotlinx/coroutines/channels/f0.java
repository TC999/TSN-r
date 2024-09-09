package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.f1;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: RendezvousChannel.kt */
@Metadata(bv = {}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B)\u0012 \u0010\u0010\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rj\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\u000f\u00a2\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0006\u001a\u00020\u00038DX\u0084\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\b\u001a\u00020\u00038DX\u0084\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0014\u0010\n\u001a\u00020\u00038DX\u0084\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\u0005R\u0014\u0010\f\u001a\u00020\u00038DX\u0084\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\u0005\u00a8\u0006\u0013"}, d2 = {"Lkotlinx/coroutines/channels/f0;", "E", "Lkotlinx/coroutines/channels/a;", "", "Z", "()Z", "isBufferAlwaysEmpty", "a0", "isBufferEmpty", "x", "isBufferAlwaysFull", "y", "isBufferFull", "Lkotlin/Function1;", "Lkotlin/f1;", "Lkotlinx/coroutines/internal/OnUndeliveredElement;", "onUndeliveredElement", "<init>", "(Ld2/l;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class f0<E> extends a<E> {
    public f0(@Nullable d2.l<? super E, f1> lVar) {
        super(lVar);
    }

    @Override // kotlinx.coroutines.channels.a
    protected final boolean Z() {
        return true;
    }

    @Override // kotlinx.coroutines.channels.a
    protected final boolean a0() {
        return true;
    }

    @Override // kotlinx.coroutines.channels.c
    protected final boolean x() {
        return true;
    }

    @Override // kotlinx.coroutines.channels.c
    protected final boolean y() {
        return true;
    }
}

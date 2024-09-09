package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.f1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: LinkedListChannel.kt */
@Metadata(bv = {}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B)\u0012 \u0010\u0018\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\u0017\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0000H\u0014\u00a2\u0006\u0004\b\u0005\u0010\u0006J#\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u00002\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u0007H\u0014\u00a2\u0006\u0004\b\t\u0010\nR\u0014\u0010\u000e\u001a\u00020\u000b8DX\u0084\u0004\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0010\u001a\u00020\u000b8DX\u0084\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\rR\u0014\u0010\u0012\u001a\u00020\u000b8DX\u0084\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\rR\u0014\u0010\u0014\u001a\u00020\u000b8DX\u0084\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\r\u00a8\u0006\u001b"}, d2 = {"Lkotlinx/coroutines/channels/y;", "E", "Lkotlinx/coroutines/channels/a;", "element", "", "A", "(Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlinx/coroutines/selects/f;", "select", "B", "(Ljava/lang/Object;Lkotlinx/coroutines/selects/f;)Ljava/lang/Object;", "", "Z", "()Z", "isBufferAlwaysEmpty", "a0", "isBufferEmpty", "x", "isBufferAlwaysFull", "y", "isBufferFull", "Lkotlin/Function1;", "Lkotlin/f1;", "Lkotlinx/coroutines/internal/OnUndeliveredElement;", "onUndeliveredElement", "<init>", "(Ld2/l;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class y<E> extends a<E> {
    public y(@Nullable d2.l<? super E, f1> lVar) {
        super(lVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.channels.c
    @NotNull
    public Object A(E e4) {
        e0<?> H;
        do {
            Object A = super.A(e4);
            kotlinx.coroutines.internal.j0 j0Var = b.f59397e;
            if (A == j0Var) {
                return j0Var;
            }
            if (A == b.f59398f) {
                H = H(e4);
                if (H == null) {
                    return j0Var;
                }
            } else if (A instanceof t) {
                return A;
            } else {
                throw new IllegalStateException(("Invalid offerInternal result " + A).toString());
            }
        } while (!(H instanceof t));
        return H;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.channels.c
    @NotNull
    public Object B(E e4, @NotNull kotlinx.coroutines.selects.f<?> fVar) {
        Object w3;
        while (true) {
            if (Y()) {
                w3 = super.B(e4, fVar);
            } else {
                w3 = fVar.w(h(e4));
                if (w3 == null) {
                    w3 = b.f59397e;
                }
            }
            if (w3 == kotlinx.coroutines.selects.g.d()) {
                return kotlinx.coroutines.selects.g.d();
            }
            kotlinx.coroutines.internal.j0 j0Var = b.f59397e;
            if (w3 == j0Var) {
                return j0Var;
            }
            if (w3 != b.f59398f && w3 != kotlinx.coroutines.internal.c.f60351b) {
                if (w3 instanceof t) {
                    return w3;
                }
                throw new IllegalStateException(("Invalid result " + w3).toString());
            }
        }
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
        return false;
    }

    @Override // kotlinx.coroutines.channels.c
    protected final boolean y() {
        return false;
    }
}

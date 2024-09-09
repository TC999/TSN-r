package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlinx.coroutines.channels.BufferOverflow;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: SharedFlow.kt */
@Metadata(bv = {}, d1 = {"\u0000H\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a0\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\"\u0004\b\u0000\u0010\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u001a%\u0010\f\u001a\u0004\u0018\u00010\t*\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002\u00a2\u0006\u0004\b\f\u0010\r\u001a-\u0010\u0010\u001a\u00020\u000f*\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\b2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\tH\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011\u001a6\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0016\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00122\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0004H\u0000\"\u001a\u0010\u001c\u001a\u00020\u00188\u0000X\u0081\u0004\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0019\u0012\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001d"}, d2 = {"T", "", "replay", "extraBufferCapacity", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "Lkotlinx/coroutines/flow/s;", "a", "", "", "", "index", "f", "([Ljava/lang/Object;J)Ljava/lang/Object;", "item", "Lkotlin/f1;", "h", "([Ljava/lang/Object;JLjava/lang/Object;)V", "Lkotlinx/coroutines/flow/x;", "Lkotlin/coroutines/f;", "context", "capacity", "Lkotlinx/coroutines/flow/h;", "e", "Lkotlinx/coroutines/internal/j0;", "Lkotlinx/coroutines/internal/j0;", "getNO_VALUE$annotations", "()V", "NO_VALUE", "kotlinx-coroutines-core"}, k = 2, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class a0 {
    @JvmField
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final kotlinx.coroutines.internal.j0 f59989a = new kotlinx.coroutines.internal.j0("NO_VALUE");

    @NotNull
    public static final <T> s<T> a(int i4, int i5, @NotNull BufferOverflow bufferOverflow) {
        boolean z3 = true;
        if (!(i4 >= 0)) {
            throw new IllegalArgumentException(("replay cannot be negative, but was " + i4).toString());
        }
        if (i5 >= 0) {
            if (i4 <= 0 && i5 <= 0 && bufferOverflow != BufferOverflow.SUSPEND) {
                z3 = false;
            }
            if (z3) {
                int i6 = i5 + i4;
                if (i6 < 0) {
                    i6 = Integer.MAX_VALUE;
                }
                return new y(i4, i6, bufferOverflow);
            }
            throw new IllegalArgumentException(("replay or extraBufferCapacity must be positive with non-default onBufferOverflow strategy " + bufferOverflow).toString());
        }
        throw new IllegalArgumentException(("extraBufferCapacity cannot be negative, but was " + i5).toString());
    }

    public static /* synthetic */ s b(int i4, int i5, BufferOverflow bufferOverflow, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i4 = 0;
        }
        if ((i6 & 2) != 0) {
            i5 = 0;
        }
        if ((i6 & 4) != 0) {
            bufferOverflow = BufferOverflow.SUSPEND;
        }
        return a(i4, i5, bufferOverflow);
    }

    @NotNull
    public static final <T> h<T> e(@NotNull x<? extends T> xVar, @NotNull kotlin.coroutines.f fVar, int i4, @NotNull BufferOverflow bufferOverflow) {
        return ((i4 == 0 || i4 == -3) && bufferOverflow == BufferOverflow.SUSPEND) ? xVar : new kotlinx.coroutines.flow.internal.h(xVar, fVar, i4, bufferOverflow);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object f(Object[] objArr, long j4) {
        return objArr[(objArr.length - 1) & ((int) j4)];
    }

    public static /* synthetic */ void g() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(Object[] objArr, long j4, Object obj) {
        objArr[(objArr.length - 1) & ((int) j4)] = obj;
    }
}

package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.f1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: Channel.kt */
@Metadata(bv = {}, d1 = {"\u0000 \n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a>\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u001a\u001e\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0001H\u0007\u00a8\u0006\u000b"}, d2 = {"E", "", "capacity", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "Lkotlin/Function1;", "Lkotlin/f1;", "onUndeliveredElement", "Lkotlinx/coroutines/channels/n;", "b", "a", "kotlinx-coroutines-core"}, k = 2, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class q {
    @NotNull
    public static final <E> n<E> b(int i4, @NotNull BufferOverflow bufferOverflow, @Nullable d2.l<? super E, f1> lVar) {
        if (i4 == -2) {
            return new i(bufferOverflow == BufferOverflow.SUSPEND ? n.f59462j0.a() : 1, bufferOverflow, lVar);
        } else if (i4 == -1) {
            if ((bufferOverflow != BufferOverflow.SUSPEND ? 0 : 1) != 0) {
                return new v(lVar);
            }
            throw new IllegalArgumentException("CONFLATED capacity cannot be used with non-default onBufferOverflow".toString());
        } else if (i4 == 0) {
            if (bufferOverflow == BufferOverflow.SUSPEND) {
                return new f0(lVar);
            }
            return new i(1, bufferOverflow, lVar);
        } else if (i4 != Integer.MAX_VALUE) {
            if (i4 == 1 && bufferOverflow == BufferOverflow.DROP_OLDEST) {
                return new v(lVar);
            }
            return new i(i4, bufferOverflow, lVar);
        } else {
            return new y(lVar);
        }
    }

    public static /* synthetic */ n c(int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i4 = 0;
        }
        return d(i4, null, null, 6, null);
    }

    public static /* synthetic */ n d(int i4, BufferOverflow bufferOverflow, d2.l lVar, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i4 = 0;
        }
        if ((i5 & 2) != 0) {
            bufferOverflow = BufferOverflow.SUSPEND;
        }
        if ((i5 & 4) != 0) {
            lVar = null;
        }
        return b(i4, bufferOverflow, lVar);
    }
}

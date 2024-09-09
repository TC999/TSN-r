package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlinx.coroutines.InternalCoroutinesApi;
import kotlinx.coroutines.channels.BufferOverflow;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: ChannelFlow.kt */
@InternalCoroutinesApi
@Metadata(bv = {}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002J,\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u0007H&\u00a8\u0006\n"}, d2 = {"Lkotlinx/coroutines/flow/internal/o;", "T", "Lkotlinx/coroutines/flow/h;", "Lkotlin/coroutines/f;", "context", "", "capacity", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "a", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public interface o<T> extends kotlinx.coroutines.flow.h<T> {

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: ChannelFlow.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a {
        public static /* synthetic */ kotlinx.coroutines.flow.h a(o oVar, kotlin.coroutines.f fVar, int i4, BufferOverflow bufferOverflow, int i5, Object obj) {
            if (obj == null) {
                if ((i5 & 1) != 0) {
                    fVar = EmptyCoroutineContext.INSTANCE;
                }
                if ((i5 & 2) != 0) {
                    i4 = -3;
                }
                if ((i5 & 4) != 0) {
                    bufferOverflow = BufferOverflow.SUSPEND;
                }
                return oVar.a(fVar, i4, bufferOverflow);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fuse");
        }
    }

    @NotNull
    kotlinx.coroutines.flow.h<T> a(@NotNull kotlin.coroutines.f fVar, int i4, @NotNull BufferOverflow bufferOverflow);
}

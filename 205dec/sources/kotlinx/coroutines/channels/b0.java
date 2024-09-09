package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import kotlinx.coroutines.q0;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: Produce.kt */
@Metadata(bv = {}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00020\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00038&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0007"}, d2 = {"Lkotlinx/coroutines/channels/b0;", "E", "Lkotlinx/coroutines/q0;", "Lkotlinx/coroutines/channels/h0;", "getChannel", "()Lkotlinx/coroutines/channels/h0;", "channel", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
@ExperimentalCoroutinesApi
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public interface b0<E> extends q0, h0<E> {
    @NotNull
    h0<E> getChannel();
}

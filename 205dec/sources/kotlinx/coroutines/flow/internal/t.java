package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.f1;
import kotlinx.coroutines.InternalCoroutinesApi;
import kotlinx.coroutines.channels.h0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: SendingCollector.kt */
@InternalCoroutinesApi
@Metadata(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u0015\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\u001b\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\r"}, d2 = {"Lkotlinx/coroutines/flow/internal/t;", "T", "Lkotlinx/coroutines/flow/i;", "value", "Lkotlin/f1;", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/c;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/h0;", "a", "Lkotlinx/coroutines/channels/h0;", "channel", "<init>", "(Lkotlinx/coroutines/channels/h0;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class t<T> implements kotlinx.coroutines.flow.i<T> {

    /* renamed from: a  reason: collision with root package name */
    private final h0<T> f60171a;

    /* JADX WARN: Multi-variable type inference failed */
    public t(@NotNull h0<? super T> h0Var) {
        this.f60171a = h0Var;
    }

    @Override // kotlinx.coroutines.flow.i
    @Nullable
    public Object emit(T t3, @NotNull kotlin.coroutines.c<? super f1> cVar) {
        Object h4;
        Object O = this.f60171a.O(t3, cVar);
        h4 = kotlin.coroutines.intrinsics.b.h();
        return O == h4 ? O : f1.f55527a;
    }
}

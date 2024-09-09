package kotlinx.coroutines.internal;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: Scopes.kt */
@Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0004\u00a2\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u001a\u0010\t\u001a\u00020\u00048\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\r"}, d2 = {"Lkotlinx/coroutines/internal/i;", "Lkotlinx/coroutines/q0;", "", "toString", "Lkotlin/coroutines/f;", "a", "Lkotlin/coroutines/f;", "getCoroutineContext", "()Lkotlin/coroutines/f;", "coroutineContext", "context", "<init>", "(Lkotlin/coroutines/f;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class i implements kotlinx.coroutines.q0 {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final kotlin.coroutines.f f60363a;

    public i(@NotNull kotlin.coroutines.f fVar) {
        this.f60363a = fVar;
    }

    @Override // kotlinx.coroutines.q0
    @NotNull
    public kotlin.coroutines.f getCoroutineContext() {
        return this.f60363a;
    }

    @NotNull
    public String toString() {
        return "CoroutineScope(coroutineContext=" + getCoroutineContext() + ')';
    }
}

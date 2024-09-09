package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.coroutines.EmptyCoroutineContext;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: SafeCollector.kt */
@Metadata(bv = {}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c2\u0002\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\"\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0003H\u0016\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u001a\u0010\r\u001a\u00020\b8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0010"}, d2 = {"Lkotlinx/coroutines/flow/internal/p;", "Lkotlin/coroutines/c;", "", "Lkotlin/Result;", "result", "Lkotlin/f1;", "resumeWith", "(Ljava/lang/Object;)V", "Lkotlin/coroutines/f;", "a", "Lkotlin/coroutines/f;", "getContext", "()Lkotlin/coroutines/f;", "context", "<init>", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
final class p implements kotlin.coroutines.c<Object> {

    /* renamed from: b  reason: collision with root package name */
    public static final p f60165b = new p();
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private static final kotlin.coroutines.f f60164a = EmptyCoroutineContext.INSTANCE;

    private p() {
    }

    @Override // kotlin.coroutines.c
    @NotNull
    public kotlin.coroutines.f getContext() {
        return f60164a;
    }

    @Override // kotlin.coroutines.c
    public void resumeWith(@NotNull Object obj) {
    }
}

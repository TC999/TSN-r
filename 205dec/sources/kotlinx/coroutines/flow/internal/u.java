package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: ChannelFlow.kt */
@Metadata(bv = {}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\u00060\u0003j\u0002`\u0004B\u001d\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0019\u0010\u001aJ \u0010\b\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0016\u00f8\u0001\u0000\u00a2\u0006\u0004\b\b\u0010\tJ\u0010\u0010\f\u001a\n\u0018\u00010\nj\u0004\u0018\u0001`\u000bH\u0016R\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u001a\u0010\u0015\u001a\u00020\u00108\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0018\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u00048VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001b"}, d2 = {"Lkotlinx/coroutines/flow/internal/u;", "T", "Lkotlin/coroutines/c;", "Lkotlin/coroutines/jvm/internal/c;", "Lkotlinx/coroutines/internal/CoroutineStackFrame;", "Lkotlin/Result;", "result", "Lkotlin/f1;", "resumeWith", "(Ljava/lang/Object;)V", "Ljava/lang/StackTraceElement;", "Lkotlinx/coroutines/internal/StackTraceElement;", "getStackTraceElement", "a", "Lkotlin/coroutines/c;", "uCont", "Lkotlin/coroutines/f;", "b", "Lkotlin/coroutines/f;", "getContext", "()Lkotlin/coroutines/f;", "context", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/c;", "callerFrame", "<init>", "(Lkotlin/coroutines/c;Lkotlin/coroutines/f;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
final class u<T> implements kotlin.coroutines.c<T>, kotlin.coroutines.jvm.internal.c {

    /* renamed from: a  reason: collision with root package name */
    private final kotlin.coroutines.c<T> f60172a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final kotlin.coroutines.f f60173b;

    /* JADX WARN: Multi-variable type inference failed */
    public u(@NotNull kotlin.coroutines.c<? super T> cVar, @NotNull kotlin.coroutines.f fVar) {
        this.f60172a = cVar;
        this.f60173b = fVar;
    }

    @Override // kotlin.coroutines.jvm.internal.c
    @Nullable
    public kotlin.coroutines.jvm.internal.c getCallerFrame() {
        kotlin.coroutines.c<T> cVar = this.f60172a;
        if (!(cVar instanceof kotlin.coroutines.jvm.internal.c)) {
            cVar = null;
        }
        return (kotlin.coroutines.jvm.internal.c) cVar;
    }

    @Override // kotlin.coroutines.c
    @NotNull
    public kotlin.coroutines.f getContext() {
        return this.f60173b;
    }

    @Override // kotlin.coroutines.jvm.internal.c
    @Nullable
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override // kotlin.coroutines.c
    public void resumeWith(@NotNull Object obj) {
        this.f60172a.resumeWith(obj);
    }
}

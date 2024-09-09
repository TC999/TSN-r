package kotlinx.coroutines.debug.internal;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: StackTraceFrame.kt */
@Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0001\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00018\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\u000b\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lkotlinx/coroutines/debug/internal/j;", "Lkotlin/coroutines/jvm/internal/c;", "Ljava/lang/StackTraceElement;", "getStackTraceElement", "a", "Lkotlin/coroutines/jvm/internal/c;", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/c;", "callerFrame", "b", "Ljava/lang/StackTraceElement;", "stackTraceElement", "<init>", "(Lkotlin/coroutines/jvm/internal/c;Ljava/lang/StackTraceElement;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class j implements kotlin.coroutines.jvm.internal.c {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private final kotlin.coroutines.jvm.internal.c f59621a;

    /* renamed from: b  reason: collision with root package name */
    private final StackTraceElement f59622b;

    public j(@Nullable kotlin.coroutines.jvm.internal.c cVar, @NotNull StackTraceElement stackTraceElement) {
        this.f59621a = cVar;
        this.f59622b = stackTraceElement;
    }

    @Override // kotlin.coroutines.jvm.internal.c
    @Nullable
    public kotlin.coroutines.jvm.internal.c getCallerFrame() {
        return this.f59621a;
    }

    @Override // kotlin.coroutines.jvm.internal.c
    @NotNull
    public StackTraceElement getStackTraceElement() {
        return this.f59622b;
    }
}

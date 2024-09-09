package kotlinx.coroutines.internal;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: ThreadContext.kt */
@Metadata(bv = {}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0010\u001a\u00020\f\u0012\u0006\u0010\u0011\u001a\u00020\t\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001J\b\u0010\u0005\u001a\u0004\u0018\u00010\u0001J\u0006\u0010\u0006\u001a\u00020\u0003R\u001e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\bR\u0016\u0010\u000b\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\nR\u0017\u0010\u0010\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\r\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0014"}, d2 = {"Lkotlinx/coroutines/internal/u0;", "", "value", "Lkotlin/f1;", "a", "c", "b", "", "[Ljava/lang/Object;", "", "I", "i", "Lkotlin/coroutines/f;", "Lkotlin/coroutines/f;", "getContext", "()Lkotlin/coroutines/f;", "context", "n", "<init>", "(Lkotlin/coroutines/f;I)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
final class u0 {

    /* renamed from: a  reason: collision with root package name */
    private Object[] f60419a;

    /* renamed from: b  reason: collision with root package name */
    private int f60420b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final kotlin.coroutines.f f60421c;

    public u0(@NotNull kotlin.coroutines.f fVar, int i4) {
        this.f60421c = fVar;
        this.f60419a = new Object[i4];
    }

    public final void a(@Nullable Object obj) {
        Object[] objArr = this.f60419a;
        int i4 = this.f60420b;
        this.f60420b = i4 + 1;
        objArr[i4] = obj;
    }

    public final void b() {
        this.f60420b = 0;
    }

    @Nullable
    public final Object c() {
        Object[] objArr = this.f60419a;
        int i4 = this.f60420b;
        this.f60420b = i4 + 1;
        return objArr[i4];
    }

    @NotNull
    public final kotlin.coroutines.f getContext() {
        return this.f60421c;
    }
}

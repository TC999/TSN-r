package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.jvm.JvmField;
import kotlinx.coroutines.e2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: Scopes.kt */
@Metadata(bv = {}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0010\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u00028\u00000\u00022\u00060\u0003j\u0002`\u0004B\u001d\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\r\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u000e\u0010\u0007\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006J\u0012\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0014J\u0012\u0010\f\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0014R\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\r8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0013\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u00048F\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0017\u001a\u00020\u00148DX\u0084\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u0004\u0018\u00010\u00188@X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a\u00a8\u0006 "}, d2 = {"Lkotlinx/coroutines/internal/f0;", "T", "Lkotlinx/coroutines/a;", "Lkotlin/coroutines/jvm/internal/c;", "Lkotlinx/coroutines/internal/CoroutineStackFrame;", "Ljava/lang/StackTraceElement;", "Lkotlinx/coroutines/internal/StackTraceElement;", "getStackTraceElement", "", "state", "Lkotlin/f1;", "Y", "k1", "Lkotlin/coroutines/c;", "d", "Lkotlin/coroutines/c;", "uCont", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/c;", "callerFrame", "", "E0", "()Z", "isScopedCoroutine", "Lkotlinx/coroutines/e2;", "s1", "()Lkotlinx/coroutines/e2;", "parent", "Lkotlin/coroutines/f;", "context", "<init>", "(Lkotlin/coroutines/f;Lkotlin/coroutines/c;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class f0<T> extends kotlinx.coroutines.a<T> implements kotlin.coroutines.jvm.internal.c {
    @JvmField
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    public final kotlin.coroutines.c<T> f60357d;

    /* JADX WARN: Multi-variable type inference failed */
    public f0(@NotNull kotlin.coroutines.f fVar, @NotNull kotlin.coroutines.c<? super T> cVar) {
        super(fVar, true);
        this.f60357d = cVar;
    }

    @Override // kotlinx.coroutines.l2
    protected final boolean E0() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.l2
    public void Y(@Nullable Object obj) {
        kotlin.coroutines.c d4;
        d4 = IntrinsicsKt__IntrinsicsJvmKt.d(this.f60357d);
        k.g(d4, kotlinx.coroutines.i0.a(obj, this.f60357d), null, 2, null);
    }

    @Override // kotlin.coroutines.jvm.internal.c
    @Nullable
    public final kotlin.coroutines.jvm.internal.c getCallerFrame() {
        return (kotlin.coroutines.jvm.internal.c) this.f60357d;
    }

    @Override // kotlin.coroutines.jvm.internal.c
    @Nullable
    public final StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override // kotlinx.coroutines.a
    protected void k1(@Nullable Object obj) {
        kotlin.coroutines.c<T> cVar = this.f60357d;
        cVar.resumeWith(kotlinx.coroutines.i0.a(obj, cVar));
    }

    @Nullable
    public final e2 s1() {
        return (e2) this.f59032c.get(e2.f59626i0);
    }
}

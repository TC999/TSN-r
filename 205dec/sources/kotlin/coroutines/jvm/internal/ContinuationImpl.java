package kotlin.coroutines.jvm.internal;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.coroutines.f;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: ContinuationImpl.kt */
@SinceKotlin(version = "1.3")
@Metadata(bv = {}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b!\u0018\u00002\u00020\u0001B#\u0012\u0010\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0002\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010B\u001b\b\u0016\u0012\u0010\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0011J\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0014R\u0016\u0010\b\u001a\u0004\u0018\u00010\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR \u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\nR\u0014\u0010\r\u001a\u00020\u00078VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0012"}, d2 = {"Lkotlin/coroutines/jvm/internal/ContinuationImpl;", "Lkotlin/coroutines/jvm/internal/BaseContinuationImpl;", "Lkotlin/coroutines/c;", "", "intercepted", "Lkotlin/f1;", "releaseIntercepted", "Lkotlin/coroutines/f;", "_context", "Lkotlin/coroutines/f;", "Lkotlin/coroutines/c;", "getContext", "()Lkotlin/coroutines/f;", "context", "completion", "<init>", "(Lkotlin/coroutines/c;Lkotlin/coroutines/f;)V", "(Lkotlin/coroutines/c;)V", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public abstract class ContinuationImpl extends BaseContinuationImpl {
    @Nullable
    private final kotlin.coroutines.f _context;
    @Nullable
    private transient kotlin.coroutines.c<Object> intercepted;

    public ContinuationImpl(@Nullable kotlin.coroutines.c<Object> cVar, @Nullable kotlin.coroutines.f fVar) {
        super(cVar);
        this._context = fVar;
    }

    @Override // kotlin.coroutines.c
    @NotNull
    public kotlin.coroutines.f getContext() {
        kotlin.coroutines.f fVar = this._context;
        f0.m(fVar);
        return fVar;
    }

    @NotNull
    public final kotlin.coroutines.c<Object> intercepted() {
        kotlin.coroutines.c<Object> cVar = this.intercepted;
        if (cVar == null) {
            kotlin.coroutines.d dVar = (kotlin.coroutines.d) getContext().get(kotlin.coroutines.d.f55503f0);
            cVar = dVar == null ? this : dVar.interceptContinuation(this);
            this.intercepted = cVar;
        }
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public void releaseIntercepted() {
        kotlin.coroutines.c<?> cVar = this.intercepted;
        if (cVar != null && cVar != this) {
            f.b bVar = getContext().get(kotlin.coroutines.d.f55503f0);
            f0.m(bVar);
            ((kotlin.coroutines.d) bVar).releaseInterceptedContinuation(cVar);
        }
        this.intercepted = b.f55511a;
    }

    public ContinuationImpl(@Nullable kotlin.coroutines.c<Object> cVar) {
        this(cVar, cVar == null ? null : cVar.getContext());
    }
}

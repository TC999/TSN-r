package kotlin.coroutines.jvm.internal;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.SinceKotlin;
import kotlin.d0;
import kotlin.f1;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: ContinuationImpl.kt */
@SinceKotlin(version = "1.3")
@Metadata(bv = {}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b!\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\u00020\u00032\u00020\u0004B\u0019\u0012\u0010\u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u0001\u00a2\u0006\u0004\b\u001a\u0010\u001bJ \u0010\b\u001a\u00020\u00072\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0005\u00f8\u0001\u0000\u00a2\u0006\u0004\b\b\u0010\tJ$\u0010\n\u001a\u0004\u0018\u00010\u00022\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0005H$\u00f8\u0001\u0000\u00a2\u0006\u0004\b\n\u0010\u000bJ\b\u0010\f\u001a\u00020\u0007H\u0014J\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\u00012\n\u0010\r\u001a\u0006\u0012\u0002\b\u00030\u0001H\u0016J$\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\u00012\b\u0010\u000f\u001a\u0004\u0018\u00010\u00022\n\u0010\r\u001a\u0006\u0012\u0002\b\u00030\u0001H\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016R!\u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u00018\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0019\u001a\u0004\u0018\u00010\u00038VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001c"}, d2 = {"Lkotlin/coroutines/jvm/internal/BaseContinuationImpl;", "Lkotlin/coroutines/c;", "", "Lkotlin/coroutines/jvm/internal/c;", "Ljava/io/Serializable;", "Lkotlin/Result;", "result", "Lkotlin/f1;", "resumeWith", "(Ljava/lang/Object;)V", "invokeSuspend", "(Ljava/lang/Object;)Ljava/lang/Object;", "releaseIntercepted", "completion", "create", "value", "", "toString", "Ljava/lang/StackTraceElement;", "getStackTraceElement", "Lkotlin/coroutines/c;", "getCompletion", "()Lkotlin/coroutines/c;", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/c;", "callerFrame", "<init>", "(Lkotlin/coroutines/c;)V", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public abstract class BaseContinuationImpl implements kotlin.coroutines.c<Object>, c, Serializable {
    @Nullable
    private final kotlin.coroutines.c<Object> completion;

    public BaseContinuationImpl(@Nullable kotlin.coroutines.c<Object> cVar) {
        this.completion = cVar;
    }

    @NotNull
    public kotlin.coroutines.c<f1> create(@NotNull kotlin.coroutines.c<?> completion) {
        f0.p(completion, "completion");
        throw new UnsupportedOperationException("create(Continuation) has not been overridden");
    }

    @Override // kotlin.coroutines.jvm.internal.c
    @Nullable
    public c getCallerFrame() {
        kotlin.coroutines.c<Object> cVar = this.completion;
        if (cVar instanceof c) {
            return (c) cVar;
        }
        return null;
    }

    @Nullable
    public final kotlin.coroutines.c<Object> getCompletion() {
        return this.completion;
    }

    @Override // kotlin.coroutines.jvm.internal.c
    @Nullable
    public StackTraceElement getStackTraceElement() {
        return d.e(this);
    }

    @Nullable
    protected abstract Object invokeSuspend(@NotNull Object obj);

    protected void releaseIntercepted() {
    }

    @Override // kotlin.coroutines.c
    public final void resumeWith(@NotNull Object obj) {
        Object invokeSuspend;
        Object h4;
        BaseContinuationImpl baseContinuationImpl = this;
        while (true) {
            e.b(baseContinuationImpl);
            BaseContinuationImpl baseContinuationImpl2 = baseContinuationImpl;
            kotlin.coroutines.c<Object> completion = baseContinuationImpl2.getCompletion();
            f0.m(completion);
            try {
                invokeSuspend = baseContinuationImpl2.invokeSuspend(obj);
                h4 = kotlin.coroutines.intrinsics.b.h();
            } catch (Throwable th) {
                Result.a aVar = Result.Companion;
                obj = Result.m119constructorimpl(d0.a(th));
            }
            if (invokeSuspend == h4) {
                return;
            }
            Result.a aVar2 = Result.Companion;
            obj = Result.m119constructorimpl(invokeSuspend);
            baseContinuationImpl2.releaseIntercepted();
            if (!(completion instanceof BaseContinuationImpl)) {
                completion.resumeWith(obj);
                return;
            }
            baseContinuationImpl = completion;
        }
    }

    @NotNull
    public String toString() {
        Object stackTraceElement = getStackTraceElement();
        if (stackTraceElement == null) {
            stackTraceElement = getClass().getName();
        }
        return f0.C("Continuation at ", stackTraceElement);
    }

    @NotNull
    public kotlin.coroutines.c<f1> create(@Nullable Object obj, @NotNull kotlin.coroutines.c<?> completion) {
        f0.p(completion, "completion");
        throw new UnsupportedOperationException("create(Any?;Continuation) has not been overridden");
    }
}

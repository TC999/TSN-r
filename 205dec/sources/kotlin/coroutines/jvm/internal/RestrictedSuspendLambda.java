package kotlin.coroutines.jvm.internal;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.internal.b0;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.n0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: ContinuationImpl.kt */
@SinceKotlin(version = "1.3")
@Metadata(bv = {}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b!\u0018\u00002\u00020\u00012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00022\u00020\u0004B!\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0010\u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\f\u00a2\u0006\u0004\b\u000e\u0010\u000fB\u0011\b\u0016\u0012\u0006\u0010\b\u001a\u00020\u0007\u00a2\u0006\u0004\b\u000e\u0010\u0010J\b\u0010\u0006\u001a\u00020\u0005H\u0016R\u001a\u0010\b\u001a\u00020\u00078\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u0011"}, d2 = {"Lkotlin/coroutines/jvm/internal/RestrictedSuspendLambda;", "Lkotlin/coroutines/jvm/internal/RestrictedContinuationImpl;", "Lkotlin/jvm/internal/b0;", "", "Lkotlin/coroutines/jvm/internal/i;", "", "toString", "", "arity", "I", "getArity", "()I", "Lkotlin/coroutines/c;", "completion", "<init>", "(ILkotlin/coroutines/c;)V", "(I)V", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public abstract class RestrictedSuspendLambda extends RestrictedContinuationImpl implements b0<Object>, i {
    private final int arity;

    public RestrictedSuspendLambda(int i4, @Nullable kotlin.coroutines.c<Object> cVar) {
        super(cVar);
        this.arity = i4;
    }

    @Override // kotlin.jvm.internal.b0
    public int getArity() {
        return this.arity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public String toString() {
        if (getCompletion() == null) {
            String w3 = n0.w(this);
            f0.o(w3, "renderLambdaToString(this)");
            return w3;
        }
        return super.toString();
    }

    public RestrictedSuspendLambda(int i4) {
        this(i4, null);
    }
}

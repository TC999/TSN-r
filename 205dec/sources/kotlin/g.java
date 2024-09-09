package kotlin;

import kotlin.coroutines.RestrictsSuspension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: DeepRecursive.kt */
@SinceKotlin(version = "1.4")
@Metadata(bv = {}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003B\t\b\u0004\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u001b\u0010\u0005\u001a\u00028\u00012\u0006\u0010\u0004\u001a\u00028\u0000H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0005\u0010\u0006J7\u0010\n\u001a\u00028\u0003\"\u0004\b\u0002\u0010\u0007\"\u0004\b\u0003\u0010\b*\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\t2\u0006\u0010\u0004\u001a\u00028\u0002H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\r\u001a\u00020\f*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\t2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0087\u0002\u0082\u0001\u0001\u0010\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0011"}, d2 = {"Lkotlin/g;", "T", "R", "", "value", "b", "(Ljava/lang/Object;Lkotlin/coroutines/c;)Ljava/lang/Object;", "U", "S", "Lkotlin/e;", "c", "(Lkotlin/e;Ljava/lang/Object;Lkotlin/coroutines/c;)Ljava/lang/Object;", "", "e", "<init>", "()V", "Lkotlin/h;", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
@ExperimentalStdlibApi
@RestrictsSuspension
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public abstract class g<T, R> {

    /* compiled from: Continuation.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J \u0010\u0005\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0016\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\n\u001a\u00020\u00078VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\t\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000b\u00b8\u0006\u0000"}, d2 = {"kotlin/coroutines/e$a", "Lkotlin/coroutines/c;", "Lkotlin/Result;", "result", "Lkotlin/f1;", "resumeWith", "(Ljava/lang/Object;)V", "Lkotlin/coroutines/f;", "getContext", "()Lkotlin/coroutines/f;", "context", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    public static final class a implements kotlin.coroutines.c<Object> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ kotlin.coroutines.f f55528a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ g f55529b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ l1.q f55530c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ kotlin.coroutines.c f55531d;

        public a(kotlin.coroutines.f fVar, g gVar, l1.q qVar, kotlin.coroutines.c cVar) {
            this.f55528a = fVar;
            this.f55529b = gVar;
            this.f55530c = qVar;
            this.f55531d = cVar;
        }

        @Override // kotlin.coroutines.c
        @NotNull
        public kotlin.coroutines.f getContext() {
            return this.f55528a;
        }

        @Override // kotlin.coroutines.c
        public void resumeWith(@NotNull Object obj) {
            g.k(this.f55529b, this.f55530c);
            g.j(this.f55529b, this.f55531d);
            g.l(this.f55529b, obj);
        }
    }

    private g() {
    }

    public /* synthetic */ g(kotlin.jvm.internal.u uVar) {
        this();
    }

    @Nullable
    public abstract Object b(T t3, @NotNull kotlin.coroutines.c<? super R> cVar);

    @Nullable
    public abstract <U, S> Object c(@NotNull e<U, S> eVar, U u3, @NotNull kotlin.coroutines.c<? super S> cVar);

    @Deprecated(level = DeprecationLevel.ERROR, message = "'invoke' should not be called from DeepRecursiveScope. Use 'callRecursive' to do recursion in the heap instead of the call stack.", replaceWith = @ReplaceWith(expression = "this.callRecursive(value)", imports = {}))
    @NotNull
    public final Void e(@NotNull e<?, ?> eVar, @Nullable Object obj) {
        kotlin.jvm.internal.f0.p(eVar, "<this>");
        throw new UnsupportedOperationException("Should not be called from DeepRecursiveScope");
    }
}

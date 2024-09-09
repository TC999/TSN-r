package kotlin.coroutines;

import d2.l;
import d2.p;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.Result;
import kotlin.SinceKotlin;
import kotlin.d0;
import kotlin.f1;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.c0;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: Continuation.kt */
@Metadata(bv = {}, d1 = {"\u0000>\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\u001a(\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u0087\b\u00a2\u0006\u0004\b\u0004\u0010\u0005\u001a!\u0010\b\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0007\u001a\u00020\u0006H\u0087\b\u001a?\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u00002\u0006\u0010\n\u001a\u00020\t2\u001a\b\u0004\u0010\r\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\f\u0012\u0004\u0012\u00020\u00030\u000bH\u0087\b\u00f8\u0001\u0000\u00f8\u0001\u0001\u001aF\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\u0001\"\u0004\b\u0000\u0010\u0000*\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000b2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0011\u0010\u0012\u001a_\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00030\u0001\"\u0004\b\u0000\u0010\u0013\"\u0004\b\u0001\u0010\u0000*#\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u0014\u00a2\u0006\u0002\b\u00152\u0006\u0010\u0016\u001a\u00028\u00002\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00010\u0001H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0017\u0010\u0018\u001a@\u0010\u0019\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000*\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000b2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0019\u0010\u001a\u001aY\u0010\u001b\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0013\"\u0004\b\u0001\u0010\u0000*#\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u0014\u00a2\u0006\u0002\b\u00152\u0006\u0010\u0016\u001a\u00028\u00002\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00010\u0001H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001b\u0010\u001c\u001aB\u0010\u001e\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00002\u001a\b\u0004\u0010\u001d\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0001\u0012\u0004\u0012\u00020\u00030\u000bH\u0087H\u00f8\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u00a2\u0006\u0004\b\u001e\u0010\u001f\"\u001b\u0010$\u001a\u00020\t8\u00c6\u0002X\u0087\u0004\u00a2\u0006\f\u0012\u0004\b\"\u0010#\u001a\u0004\b \u0010!\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b\u009920\u0001\u00a8\u0006%"}, d2 = {"T", "Lkotlin/coroutines/c;", "value", "Lkotlin/f1;", "f", "(Lkotlin/coroutines/c;Ljava/lang/Object;)V", "", "exception", "g", "Lkotlin/coroutines/f;", "context", "Lkotlin/Function1;", "Lkotlin/Result;", "resumeWith", "a", "", "completion", "b", "(Ld2/l;Lkotlin/coroutines/c;)Lkotlin/coroutines/c;", "R", "Lkotlin/Function2;", "Lkotlin/ExtensionFunctionType;", "receiver", "c", "(Ld2/p;Ljava/lang/Object;Lkotlin/coroutines/c;)Lkotlin/coroutines/c;", "h", "(Ld2/l;Lkotlin/coroutines/c;)V", "i", "(Ld2/p;Ljava/lang/Object;Lkotlin/coroutines/c;)V", "block", "j", "(Ld2/l;Lkotlin/coroutines/c;)Ljava/lang/Object;", "d", "()Lkotlin/coroutines/f;", "getCoroutineContext$annotations", "()V", "coroutineContext", "kotlin-stdlib"}, k = 2, mv = {1, 6, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class e {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Continuation.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J \u0010\u0005\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0016\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\n\u001a\u00020\u00078VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\t\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000b"}, d2 = {"kotlin/coroutines/e$a", "Lkotlin/coroutines/c;", "Lkotlin/Result;", "result", "Lkotlin/f1;", "resumeWith", "(Ljava/lang/Object;)V", "Lkotlin/coroutines/f;", "getContext", "()Lkotlin/coroutines/f;", "context", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a<T> implements c<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f f55505a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ l<Result<? extends T>, f1> f55506b;

        /* JADX WARN: Multi-variable type inference failed */
        public a(f fVar, l<? super Result<? extends T>, f1> lVar) {
            this.f55505a = fVar;
            this.f55506b = lVar;
        }

        @Override // kotlin.coroutines.c
        @NotNull
        public f getContext() {
            return this.f55505a;
        }

        @Override // kotlin.coroutines.c
        public void resumeWith(@NotNull Object obj) {
            this.f55506b.invoke(Result.m118boximpl(obj));
        }
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final <T> c<T> a(f context, l<? super Result<? extends T>, f1> resumeWith) {
        f0.p(context, "context");
        f0.p(resumeWith, "resumeWith");
        return new a(context, resumeWith);
    }

    @SinceKotlin(version = "1.3")
    @NotNull
    public static final <T> c<f1> b(@NotNull l<? super c<? super T>, ? extends Object> lVar, @NotNull c<? super T> completion) {
        f0.p(lVar, "<this>");
        f0.p(completion, "completion");
        return new h(kotlin.coroutines.intrinsics.a.d(kotlin.coroutines.intrinsics.a.b(lVar, completion)), kotlin.coroutines.intrinsics.a.h());
    }

    @SinceKotlin(version = "1.3")
    @NotNull
    public static final <R, T> c<f1> c(@NotNull p<? super R, ? super c<? super T>, ? extends Object> pVar, R r3, @NotNull c<? super T> completion) {
        f0.p(pVar, "<this>");
        f0.p(completion, "completion");
        return new h(kotlin.coroutines.intrinsics.a.d(kotlin.coroutines.intrinsics.a.c(pVar, r3, completion)), kotlin.coroutines.intrinsics.a.h());
    }

    private static final f d() {
        throw new NotImplementedError("Implemented as intrinsic");
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    public static /* synthetic */ void e() {
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final <T> void f(c<? super T> cVar, T t3) {
        f0.p(cVar, "<this>");
        Result.a aVar = Result.Companion;
        cVar.resumeWith(Result.m119constructorimpl(t3));
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final <T> void g(c<? super T> cVar, Throwable exception) {
        f0.p(cVar, "<this>");
        f0.p(exception, "exception");
        Result.a aVar = Result.Companion;
        cVar.resumeWith(Result.m119constructorimpl(d0.a(exception)));
    }

    @SinceKotlin(version = "1.3")
    public static final <T> void h(@NotNull l<? super c<? super T>, ? extends Object> lVar, @NotNull c<? super T> completion) {
        f0.p(lVar, "<this>");
        f0.p(completion, "completion");
        c d4 = kotlin.coroutines.intrinsics.a.d(kotlin.coroutines.intrinsics.a.b(lVar, completion));
        Result.a aVar = Result.Companion;
        d4.resumeWith(Result.m119constructorimpl(f1.f55527a));
    }

    @SinceKotlin(version = "1.3")
    public static final <R, T> void i(@NotNull p<? super R, ? super c<? super T>, ? extends Object> pVar, R r3, @NotNull c<? super T> completion) {
        f0.p(pVar, "<this>");
        f0.p(completion, "completion");
        c d4 = kotlin.coroutines.intrinsics.a.d(kotlin.coroutines.intrinsics.a.c(pVar, r3, completion));
        Result.a aVar = Result.Companion;
        d4.resumeWith(Result.m119constructorimpl(f1.f55527a));
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final <T> Object j(l<? super c<? super T>, f1> lVar, c<? super T> cVar) {
        c0.e(0);
        h hVar = new h(kotlin.coroutines.intrinsics.a.d(cVar));
        lVar.invoke(hVar);
        Object b4 = hVar.b();
        if (b4 == kotlin.coroutines.intrinsics.a.h()) {
            kotlin.coroutines.jvm.internal.e.c(cVar);
        }
        c0.e(1);
        return b4;
    }
}

package kotlin;

import kotlin.Result;
import kotlin.coroutines.EmptyCoroutineContext;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: DeepRecursive.kt */
@Metadata(bv = {}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0003\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00032\b\u0012\u0004\u0012\u00028\u00010\u0004BM\u00129\u0010\"\u001a5\b\u0001\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005\u00a2\u0006\u0002\b\u0007\u0012\u0006\u0010\u0011\u001a\u00028\u0000\u00f8\u0001\u0000\u00a2\u0006\u0004\b#\u0010$Je\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u000429\u0010\b\u001a5\b\u0001\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005\u00a2\u0006\u0002\b\u00072\u000e\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004H\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\b\n\u0010\u000bJ \u0010\u000f\u001a\u00020\u000e2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00010\fH\u0016\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u001b\u0010\u0012\u001a\u00028\u00012\u0006\u0010\u0011\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0012\u0010\u0013J7\u0010\u0017\u001a\u00028\u0003\"\u0004\b\u0002\u0010\u0014\"\u0004\b\u0003\u0010\u0015*\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00162\u0006\u0010\u0011\u001a\u00028\u0002H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0017\u0010\u0018J\r\u0010\u0019\u001a\u00028\u0001\u00a2\u0006\u0004\b\u0019\u0010\u001aR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u001bR \u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u001cR$\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\f8\u0002@\u0002X\u0082\u000e\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001bR\u0014\u0010!\u001a\u00020\u001e8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001f\u0010 \u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!\u00a8\u0006%"}, d2 = {"Lkotlin/h;", "T", "R", "Lkotlin/g;", "Lkotlin/coroutines/c;", "Lkotlin/Function3;", "", "Lkotlin/ExtensionFunctionType;", "currentFunction", "cont", "i", "(Ld2/q;Lkotlin/coroutines/c;)Lkotlin/coroutines/c;", "Lkotlin/Result;", "result", "Lkotlin/f1;", "resumeWith", "(Ljava/lang/Object;)V", "value", "b", "(Ljava/lang/Object;Lkotlin/coroutines/c;)Ljava/lang/Object;", "U", "S", "Lkotlin/e;", "c", "(Lkotlin/e;Ljava/lang/Object;Lkotlin/coroutines/c;)Ljava/lang/Object;", "j", "()Ljava/lang/Object;", "Ljava/lang/Object;", "Lkotlin/coroutines/c;", "d", "Lkotlin/coroutines/f;", "getContext", "()Lkotlin/coroutines/f;", "context", "block", "<init>", "(Ld2/q;Ljava/lang/Object;)V", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
@ExperimentalStdlibApi
/* loaded from: E:\TSN-r\205dec\7343912.dex */
final class h<T, R> extends g<T, R> implements kotlin.coroutines.c<R> {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private d2.q<? super g<?, ?>, Object, ? super kotlin.coroutines.c<Object>, ? extends Object> f55532a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private Object f55533b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private kotlin.coroutines.c<Object> f55534c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private Object f55535d;

    /* compiled from: Continuation.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J \u0010\u0005\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0016\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\n\u001a\u00020\u00078VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\t\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000b\u00b8\u0006\u0000"}, d2 = {"kotlin/coroutines/e$a", "Lkotlin/coroutines/c;", "Lkotlin/Result;", "result", "Lkotlin/f1;", "resumeWith", "(Ljava/lang/Object;)V", "Lkotlin/coroutines/f;", "getContext", "()Lkotlin/coroutines/f;", "context", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a implements kotlin.coroutines.c<Object> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ kotlin.coroutines.f f55536a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ h f55537b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ d2.q f55538c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ kotlin.coroutines.c f55539d;

        public a(kotlin.coroutines.f fVar, h hVar, d2.q qVar, kotlin.coroutines.c cVar) {
            this.f55536a = fVar;
            this.f55537b = hVar;
            this.f55538c = qVar;
            this.f55539d = cVar;
        }

        @Override // kotlin.coroutines.c
        @NotNull
        public kotlin.coroutines.f getContext() {
            return this.f55536a;
        }

        @Override // kotlin.coroutines.c
        public void resumeWith(@NotNull Object obj) {
            this.f55537b.f55532a = this.f55538c;
            this.f55537b.f55534c = this.f55539d;
            this.f55537b.f55535d = obj;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public h(@NotNull d2.q<? super g<T, R>, ? super T, ? super kotlin.coroutines.c<? super R>, ? extends Object> block, T t3) {
        super(null);
        Object obj;
        kotlin.jvm.internal.f0.p(block, "block");
        this.f55532a = block;
        this.f55533b = t3;
        this.f55534c = this;
        obj = f.f55526a;
        this.f55535d = obj;
    }

    private final kotlin.coroutines.c<Object> i(d2.q<? super g<?, ?>, Object, ? super kotlin.coroutines.c<Object>, ? extends Object> qVar, kotlin.coroutines.c<Object> cVar) {
        return new a(EmptyCoroutineContext.INSTANCE, this, qVar, cVar);
    }

    @Override // kotlin.g
    @Nullable
    public Object b(T t3, @NotNull kotlin.coroutines.c<? super R> cVar) {
        Object h4;
        Object h5;
        this.f55534c = cVar;
        this.f55533b = t3;
        h4 = kotlin.coroutines.intrinsics.b.h();
        h5 = kotlin.coroutines.intrinsics.b.h();
        if (h4 == h5) {
            kotlin.coroutines.jvm.internal.e.c(cVar);
        }
        return h4;
    }

    @Override // kotlin.g
    @Nullable
    public <U, S> Object c(@NotNull e<U, S> eVar, U u3, @NotNull kotlin.coroutines.c<? super S> cVar) {
        Object h4;
        Object h5;
        d2.q<g<U, S>, U, kotlin.coroutines.c<? super S>, Object> a4 = eVar.a();
        d2.q<? super g<?, ?>, Object, ? super kotlin.coroutines.c<Object>, ? extends Object> qVar = this.f55532a;
        if (a4 != qVar) {
            this.f55532a = a4;
            this.f55534c = i(qVar, cVar);
        } else {
            this.f55534c = cVar;
        }
        this.f55533b = u3;
        h4 = kotlin.coroutines.intrinsics.b.h();
        h5 = kotlin.coroutines.intrinsics.b.h();
        if (h4 == h5) {
            kotlin.coroutines.jvm.internal.e.c(cVar);
        }
        return h4;
    }

    @Override // kotlin.coroutines.c
    @NotNull
    public kotlin.coroutines.f getContext() {
        return EmptyCoroutineContext.INSTANCE;
    }

    public final R j() {
        Object obj;
        Object obj2;
        Object h4;
        while (true) {
            R r3 = (R) this.f55535d;
            kotlin.coroutines.c<Object> cVar = this.f55534c;
            if (cVar == null) {
                d0.n(r3);
                return r3;
            }
            obj = f.f55526a;
            if (Result.m121equalsimpl0(obj, r3)) {
                try {
                    d2.q<? super g<?, ?>, Object, ? super kotlin.coroutines.c<Object>, ? extends Object> qVar = this.f55532a;
                    Object invoke = ((d2.q) kotlin.jvm.internal.t0.q(qVar, 3)).invoke(this, this.f55533b, cVar);
                    h4 = kotlin.coroutines.intrinsics.b.h();
                    if (invoke != h4) {
                        Result.a aVar = Result.Companion;
                        cVar.resumeWith(Result.m119constructorimpl(invoke));
                    }
                } catch (Throwable th) {
                    Result.a aVar2 = Result.Companion;
                    cVar.resumeWith(Result.m119constructorimpl(d0.a(th)));
                }
            } else {
                obj2 = f.f55526a;
                this.f55535d = obj2;
                cVar.resumeWith(r3);
            }
        }
    }

    @Override // kotlin.coroutines.c
    public void resumeWith(@NotNull Object obj) {
        this.f55534c = null;
        this.f55535d = obj;
    }
}

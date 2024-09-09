package kotlinx.coroutines;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.coroutines.d;
import kotlin.coroutines.f;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: CoroutineDispatcher.kt */
@Metadata(bv = {}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\b&\u0018\u0000 \u00182\u00020\u00012\u00020\u0002:\u0001\u0019B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001c\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00032\n\u0010\t\u001a\u00060\u0007j\u0002`\bH&J\u001c\u0010\f\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00032\n\u0010\t\u001a\u00060\u0007j\u0002`\bH\u0017J \u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e\"\u0004\b\u0000\u0010\r2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000eJ\u0014\u0010\u0011\u001a\u00020\n2\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u000eH\u0017J\u0011\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0000H\u0087\u0002J\b\u0010\u0015\u001a\u00020\u0014H\u0016\u00a8\u0006\u001a"}, d2 = {"Lkotlinx/coroutines/l0;", "Lkotlin/coroutines/a;", "Lkotlin/coroutines/d;", "Lkotlin/coroutines/f;", "context", "", "isDispatchNeeded", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "block", "Lkotlin/f1;", "dispatch", "dispatchYield", "T", "Lkotlin/coroutines/c;", "continuation", "interceptContinuation", "releaseInterceptedContinuation", "other", "plus", "", "toString", "<init>", "()V", "Key", "a", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public abstract class l0 extends kotlin.coroutines.a implements kotlin.coroutines.d {
    public static final a Key = new a(null);

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: CoroutineDispatcher.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"Lkotlinx/coroutines/l0$a;", "Lkotlin/coroutines/b;", "Lkotlin/coroutines/d;", "Lkotlinx/coroutines/l0;", "<init>", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    @ExperimentalStdlibApi
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a extends kotlin.coroutines.b<kotlin.coroutines.d, l0> {

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
        /* compiled from: CoroutineDispatcher.kt */
        @Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlin/coroutines/f$b;", "it", "Lkotlinx/coroutines/l0;", "a", "(Lkotlin/coroutines/f$b;)Lkotlinx/coroutines/l0;"}, k = 3, mv = {1, 4, 0})
        /* renamed from: kotlinx.coroutines.l0$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        static final class C1219a extends Lambda implements d2.l<f.b, l0> {

            /* renamed from: a  reason: collision with root package name */
            public static final C1219a f60467a = new C1219a();

            C1219a() {
                super(1);
            }

            @Override // d2.l
            @Nullable
            /* renamed from: a */
            public final l0 invoke(@NotNull f.b bVar) {
                if (!(bVar instanceof l0)) {
                    bVar = null;
                }
                return (l0) bVar;
            }
        }

        public /* synthetic */ a(kotlin.jvm.internal.u uVar) {
            this();
        }

        private a() {
            super(kotlin.coroutines.d.f55503f0, C1219a.f60467a);
        }
    }

    public l0() {
        super(kotlin.coroutines.d.f55503f0);
    }

    public abstract void dispatch(@NotNull kotlin.coroutines.f fVar, @NotNull Runnable runnable);

    @InternalCoroutinesApi
    public void dispatchYield(@NotNull kotlin.coroutines.f fVar, @NotNull Runnable runnable) {
        dispatch(fVar, runnable);
    }

    @Override // kotlin.coroutines.a, kotlin.coroutines.f.b, kotlin.coroutines.f
    @Nullable
    public <E extends f.b> E get(@NotNull f.c<E> cVar) {
        return (E) d.a.b(this, cVar);
    }

    @Override // kotlin.coroutines.d
    @NotNull
    public final <T> kotlin.coroutines.c<T> interceptContinuation(@NotNull kotlin.coroutines.c<? super T> cVar) {
        return new kotlinx.coroutines.internal.j(this, cVar);
    }

    public boolean isDispatchNeeded(@NotNull kotlin.coroutines.f fVar) {
        return true;
    }

    @Override // kotlin.coroutines.a, kotlin.coroutines.f.b, kotlin.coroutines.f
    @NotNull
    public kotlin.coroutines.f minusKey(@NotNull f.c<?> cVar) {
        return d.a.c(this, cVar);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Operator '+' on two CoroutineDispatcher objects is meaningless. CoroutineDispatcher is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The dispatcher to the right of `+` just replaces the dispatcher to the left.")
    @NotNull
    public final l0 plus(@NotNull l0 l0Var) {
        return l0Var;
    }

    @Override // kotlin.coroutines.d
    @InternalCoroutinesApi
    public void releaseInterceptedContinuation(@NotNull kotlin.coroutines.c<?> cVar) {
        if (cVar == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
        }
        p<?> m4 = ((kotlinx.coroutines.internal.j) cVar).m();
        if (m4 != null) {
            m4.t();
        }
    }

    @NotNull
    public String toString() {
        return u0.a(this) + '@' + u0.b(this);
    }
}

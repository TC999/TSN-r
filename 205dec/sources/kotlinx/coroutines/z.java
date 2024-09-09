package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: CompletableDeferred.kt */
@Metadata(bv = {}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u00022\b\u0012\u0004\u0012\u00028\u00000\u00032\b\u0012\u0004\u0012\u00028\u00000\u0004B\u0011\u0012\b\u0010!\u001a\u0004\u0018\u00010 \u00a2\u0006\u0004\b\"\u0010#J\u000f\u0010\u0005\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0013\u0010\u0007\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0007\u0010\bJJ\u0010\u0011\u001a\u00020\u0010\"\u0004\b\u0001\u0010\t2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00010\n2\"\u0010\u000f\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\fH\u0016\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0017H\u0016R\u0014\u0010\u001c\u001a\u00020\u00148PX\u0090\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00048VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006$"}, d2 = {"Lkotlinx/coroutines/z;", "T", "Lkotlinx/coroutines/l2;", "Lkotlinx/coroutines/y;", "Lkotlinx/coroutines/selects/d;", "e", "()Ljava/lang/Object;", "k", "(Lkotlin/coroutines/c;)Ljava/lang/Object;", "R", "Lkotlinx/coroutines/selects/f;", "select", "Lkotlin/Function2;", "Lkotlin/coroutines/c;", "", "block", "Lkotlin/f1;", "I", "(Lkotlinx/coroutines/selects/f;Ld2/p;)V", "value", "", "v", "(Ljava/lang/Object;)Z", "", "exception", "c", "v0", "()Z", "onCancelComplete", "y", "()Lkotlinx/coroutines/selects/d;", "onAwait", "Lkotlinx/coroutines/e2;", "parent", "<init>", "(Lkotlinx/coroutines/e2;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
final class z<T> extends l2 implements y<T>, kotlinx.coroutines.selects.d<T> {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: CompletableDeferred.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0004\u001a\u0004\u0018\u00010\u0003\"\u0004\b\u0000\u0010\u00002\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0096@"}, d2 = {"T", "Lkotlin/coroutines/c;", "continuation", "", "await"}, k = 3, mv = {1, 4, 0})
    @DebugMetadata(c = "kotlinx.coroutines.CompletableDeferredImpl", f = "CompletableDeferred.kt", i = {0}, l = {86}, m = "await", n = {"this"}, s = {"L$0"})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        /* synthetic */ Object f60772a;

        /* renamed from: b  reason: collision with root package name */
        int f60773b;

        /* renamed from: d  reason: collision with root package name */
        Object f60775d;

        a(kotlin.coroutines.c cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f60772a = obj;
            this.f60773b |= Integer.MIN_VALUE;
            return z.this.k(this);
        }
    }

    public z(@Nullable e2 e2Var) {
        super(true);
        B0(e2Var);
    }

    @Override // kotlinx.coroutines.selects.d
    public <R> void I(@NotNull kotlinx.coroutines.selects.f<? super R> fVar, @NotNull d2.p<? super T, ? super kotlin.coroutines.c<? super R>, ? extends Object> pVar) {
        W0(fVar, pVar);
    }

    @Override // kotlinx.coroutines.y
    public boolean c(@NotNull Throwable th) {
        return J0(new d0(th, false, 2, null));
    }

    @Override // kotlinx.coroutines.x0
    public T e() {
        return (T) p0();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0035  */
    @Override // kotlinx.coroutines.x0
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object k(@org.jetbrains.annotations.NotNull kotlin.coroutines.c<? super T> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof kotlinx.coroutines.z.a
            if (r0 == 0) goto L13
            r0 = r5
            kotlinx.coroutines.z$a r0 = (kotlinx.coroutines.z.a) r0
            int r1 = r0.f60773b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f60773b = r1
            goto L18
        L13:
            kotlinx.coroutines.z$a r0 = new kotlinx.coroutines.z$a
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.f60772a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.a.h()
            int r2 = r0.f60773b
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r0 = r0.f60775d
            kotlinx.coroutines.z r0 = (kotlinx.coroutines.z) r0
            kotlin.d0.n(r5)
            goto L43
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L35:
            kotlin.d0.n(r5)
            r0.f60775d = r4
            r0.f60773b = r3
            java.lang.Object r5 = r4.Z(r0)
            if (r5 != r1) goto L43
            return r1
        L43:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.z.k(kotlin.coroutines.c):java.lang.Object");
    }

    @Override // kotlinx.coroutines.y
    public boolean v(T t3) {
        return J0(t3);
    }

    @Override // kotlinx.coroutines.l2
    public boolean v0() {
        return true;
    }

    @Override // kotlinx.coroutines.x0
    @NotNull
    public kotlinx.coroutines.selects.d<T> y() {
        return this;
    }
}

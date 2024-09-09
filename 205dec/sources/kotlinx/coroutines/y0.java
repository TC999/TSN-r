package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: Builders.common.kt */
@Metadata(bv = {}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0012\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u00032\b\u0012\u0004\u0012\u00028\u00000\u0004B\u0017\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u0005\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0013\u0010\u0007\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0007\u0010\bJJ\u0010\u0011\u001a\u00020\u0010\"\u0004\b\u0001\u0010\t2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00010\n2\"\u0010\u000f\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\fH\u0016\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u00048VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001c"}, d2 = {"Lkotlinx/coroutines/y0;", "T", "Lkotlinx/coroutines/a;", "Lkotlinx/coroutines/x0;", "Lkotlinx/coroutines/selects/d;", "e", "()Ljava/lang/Object;", "k", "(Lkotlin/coroutines/c;)Ljava/lang/Object;", "R", "Lkotlinx/coroutines/selects/f;", "select", "Lkotlin/Function2;", "Lkotlin/coroutines/c;", "", "block", "Lkotlin/f1;", "I", "(Lkotlinx/coroutines/selects/f;Ld2/p;)V", "y", "()Lkotlinx/coroutines/selects/d;", "onAwait", "Lkotlin/coroutines/f;", "parentContext", "", "active", "<init>", "(Lkotlin/coroutines/f;Z)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class y0<T> extends kotlinx.coroutines.a<T> implements x0<T>, kotlinx.coroutines.selects.d<T> {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Builders.common.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0004\u001a\u0004\u0018\u00010\u0003\"\u0004\b\u0000\u0010\u00002\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0096@"}, d2 = {"T", "Lkotlin/coroutines/c;", "continuation", "", "await"}, k = 3, mv = {1, 4, 0})
    @DebugMetadata(c = "kotlinx.coroutines.DeferredCoroutine", f = "Builders.common.kt", i = {0}, l = {101}, m = "await$suspendImpl", n = {"this"}, s = {"L$0"})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        /* synthetic */ Object f60767a;

        /* renamed from: b  reason: collision with root package name */
        int f60768b;

        /* renamed from: d  reason: collision with root package name */
        Object f60770d;

        a(kotlin.coroutines.c cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f60767a = obj;
            this.f60768b |= Integer.MIN_VALUE;
            return y0.s1(y0.this, this);
        }
    }

    public y0(@NotNull kotlin.coroutines.f fVar, boolean z3) {
        super(fVar, z3);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0035  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static /* synthetic */ java.lang.Object s1(kotlinx.coroutines.y0 r4, kotlin.coroutines.c r5) {
        /*
            boolean r0 = r5 instanceof kotlinx.coroutines.y0.a
            if (r0 == 0) goto L13
            r0 = r5
            kotlinx.coroutines.y0$a r0 = (kotlinx.coroutines.y0.a) r0
            int r1 = r0.f60768b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f60768b = r1
            goto L18
        L13:
            kotlinx.coroutines.y0$a r0 = new kotlinx.coroutines.y0$a
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.f60767a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.a.h()
            int r2 = r0.f60768b
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r4 = r0.f60770d
            kotlinx.coroutines.y0 r4 = (kotlinx.coroutines.y0) r4
            kotlin.d0.n(r5)
            goto L43
        L2d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L35:
            kotlin.d0.n(r5)
            r0.f60770d = r4
            r0.f60768b = r3
            java.lang.Object r5 = r4.Z(r0)
            if (r5 != r1) goto L43
            return r1
        L43:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.y0.s1(kotlinx.coroutines.y0, kotlin.coroutines.c):java.lang.Object");
    }

    @Override // kotlinx.coroutines.selects.d
    public <R> void I(@NotNull kotlinx.coroutines.selects.f<? super R> fVar, @NotNull d2.p<? super T, ? super kotlin.coroutines.c<? super R>, ? extends Object> pVar) {
        W0(fVar, pVar);
    }

    @Override // kotlinx.coroutines.x0
    public T e() {
        return (T) p0();
    }

    @Override // kotlinx.coroutines.x0
    @Nullable
    public Object k(@NotNull kotlin.coroutines.c<? super T> cVar) {
        return s1(this, cVar);
    }

    @Override // kotlinx.coroutines.x0
    @NotNull
    public kotlinx.coroutines.selects.d<T> y() {
        return this;
    }
}

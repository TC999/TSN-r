package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.time.ExperimentalTime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: Timeout.kt */
@Metadata(bv = {}, d1 = {"\u0000<\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aW\u0010\t\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001a\u00020\u00012'\u0010\b\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0003\u00a2\u0006\u0002\b\u0007H\u0086@\u00f8\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001\u00a2\u0006\u0004\b\t\u0010\n\u001aZ\u0010\r\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00002\u0006\u0010\f\u001a\u00020\u000b2'\u0010\b\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0003\u00a2\u0006\u0002\b\u0007H\u0087@\u00f8\u0001\u0000\u00f8\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001\u00a2\u0006\u0004\b\r\u0010\u000e\u001aL\u0010\u000f\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001a\u00020\u00012'\u0010\b\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0003\u00a2\u0006\u0002\b\u0007H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000f\u0010\n\u001aO\u0010\u0010\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u00002\u0006\u0010\f\u001a\u00020\u000b2'\u0010\b\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0003\u00a2\u0006\u0002\b\u0007H\u0087@\u00f8\u0001\u0000\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0010\u0010\u000e\u001aa\u0010\u0014\u001a\u0004\u0018\u00010\u0006\"\u0004\b\u0000\u0010\u0011\"\b\b\u0001\u0010\u0000*\u00028\u00002\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00122'\u0010\b\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0003\u00a2\u0006\u0002\b\u0007H\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0014\u0010\u0015\u001a\u0018\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0016\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u0017H\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001a"}, d2 = {"T", "", "timeMillis", "Lkotlin/Function2;", "Lkotlinx/coroutines/q0;", "Lkotlin/coroutines/c;", "", "Lkotlin/ExtensionFunctionType;", "block", "c", "(JLd2/p;Lkotlin/coroutines/c;)Ljava/lang/Object;", "Lkotlin/time/d;", "timeout", "d", "(DLd2/p;Lkotlin/coroutines/c;)Ljava/lang/Object;", "e", "f", "U", "Lkotlinx/coroutines/q3;", "coroutine", "b", "(Lkotlinx/coroutines/q3;Ld2/p;)Ljava/lang/Object;", "time", "Lkotlinx/coroutines/e2;", "Lkotlinx/coroutines/TimeoutCancellationException;", "a", "kotlinx-coroutines-core"}, k = 2, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class r3 {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Timeout.kt */
    @Metadata(bv = {}, d1 = {"\u0000 \n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u0006\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001a\u00020\u00012'\u0010\b\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0003\u00a2\u0006\u0002\b\u00072\u000e\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0005H\u0086@"}, d2 = {"T", "", "timeMillis", "Lkotlin/Function2;", "Lkotlinx/coroutines/q0;", "Lkotlin/coroutines/c;", "", "Lkotlin/ExtensionFunctionType;", "block", "continuation", "withTimeoutOrNull"}, k = 3, mv = {1, 4, 0})
    @DebugMetadata(c = "kotlinx.coroutines.TimeoutKt", f = "Timeout.kt", i = {0, 0, 0}, l = {101}, m = "withTimeoutOrNull", n = {"timeMillis", "block", "coroutine"}, s = {"J$0", "L$0", "L$1"})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        /* synthetic */ Object f60546a;

        /* renamed from: b  reason: collision with root package name */
        int f60547b;

        /* renamed from: c  reason: collision with root package name */
        long f60548c;

        /* renamed from: d  reason: collision with root package name */
        Object f60549d;

        /* renamed from: e  reason: collision with root package name */
        Object f60550e;

        a(kotlin.coroutines.c cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f60546a = obj;
            this.f60547b |= Integer.MIN_VALUE;
            return r3.e(0L, null, this);
        }
    }

    @NotNull
    public static final TimeoutCancellationException a(long j4, @NotNull e2 e2Var) {
        return new TimeoutCancellationException("Timed out waiting for " + j4 + " ms", e2Var);
    }

    private static final <U, T extends U> Object b(q3<U, ? super T> q3Var, d2.p<? super q0, ? super kotlin.coroutines.c<? super T>, ? extends Object> pVar) {
        h2.z(q3Var, a1.d(q3Var.f60357d.getContext()).f(q3Var.f60544e, q3Var, q3Var.getContext()));
        return z2.b.g(q3Var, q3Var, pVar);
    }

    @Nullable
    public static final <T> Object c(long j4, @NotNull d2.p<? super q0, ? super kotlin.coroutines.c<? super T>, ? extends Object> pVar, @NotNull kotlin.coroutines.c<? super T> cVar) {
        Object h4;
        if (j4 > 0) {
            Object b4 = b(new q3(j4, cVar), pVar);
            h4 = kotlin.coroutines.intrinsics.b.h();
            if (b4 == h4) {
                kotlin.coroutines.jvm.internal.e.c(cVar);
            }
            return b4;
        }
        throw new TimeoutCancellationException("Timed out immediately");
    }

    @ExperimentalTime
    @Nullable
    public static final <T> Object d(double d4, @NotNull d2.p<? super q0, ? super kotlin.coroutines.c<? super T>, ? extends Object> pVar, @NotNull kotlin.coroutines.c<? super T> cVar) {
        return c(a1.e(d4), pVar, cVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0078 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0079  */
    /* JADX WARN: Type inference failed for: r2v1, types: [T, kotlinx.coroutines.q3] */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <T> java.lang.Object e(long r7, @org.jetbrains.annotations.NotNull d2.p<? super kotlinx.coroutines.q0, ? super kotlin.coroutines.c<? super T>, ? extends java.lang.Object> r9, @org.jetbrains.annotations.NotNull kotlin.coroutines.c<? super T> r10) {
        /*
            boolean r0 = r10 instanceof kotlinx.coroutines.r3.a
            if (r0 == 0) goto L13
            r0 = r10
            kotlinx.coroutines.r3$a r0 = (kotlinx.coroutines.r3.a) r0
            int r1 = r0.f60547b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f60547b = r1
            goto L18
        L13:
            kotlinx.coroutines.r3$a r0 = new kotlinx.coroutines.r3$a
            r0.<init>(r10)
        L18:
            java.lang.Object r10 = r0.f60546a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.a.h()
            int r2 = r0.f60547b
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L3c
            if (r2 != r3) goto L34
            java.lang.Object r7 = r0.f60550e
            kotlin.jvm.internal.Ref$ObjectRef r7 = (kotlin.jvm.internal.Ref.ObjectRef) r7
            java.lang.Object r8 = r0.f60549d
            d2.p r8 = (d2.p) r8
            kotlin.d0.n(r10)     // Catch: kotlinx.coroutines.TimeoutCancellationException -> L32
            goto L6d
        L32:
            r8 = move-exception
            goto L70
        L34:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L3c:
            kotlin.d0.n(r10)
            r5 = 0
            int r10 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r10 > 0) goto L46
            return r4
        L46:
            kotlin.jvm.internal.Ref$ObjectRef r10 = new kotlin.jvm.internal.Ref$ObjectRef
            r10.<init>()
            r10.element = r4
            r0.f60548c = r7     // Catch: kotlinx.coroutines.TimeoutCancellationException -> L6e
            r0.f60549d = r9     // Catch: kotlinx.coroutines.TimeoutCancellationException -> L6e
            r0.f60550e = r10     // Catch: kotlinx.coroutines.TimeoutCancellationException -> L6e
            r0.f60547b = r3     // Catch: kotlinx.coroutines.TimeoutCancellationException -> L6e
            kotlinx.coroutines.q3 r2 = new kotlinx.coroutines.q3     // Catch: kotlinx.coroutines.TimeoutCancellationException -> L6e
            r2.<init>(r7, r0)     // Catch: kotlinx.coroutines.TimeoutCancellationException -> L6e
            r10.element = r2     // Catch: kotlinx.coroutines.TimeoutCancellationException -> L6e
            java.lang.Object r7 = b(r2, r9)     // Catch: kotlinx.coroutines.TimeoutCancellationException -> L6e
            java.lang.Object r8 = kotlin.coroutines.intrinsics.a.h()     // Catch: kotlinx.coroutines.TimeoutCancellationException -> L6e
            if (r7 != r8) goto L69
            kotlin.coroutines.jvm.internal.e.c(r0)     // Catch: kotlinx.coroutines.TimeoutCancellationException -> L6e
        L69:
            if (r7 != r1) goto L6c
            return r1
        L6c:
            r10 = r7
        L6d:
            return r10
        L6e:
            r8 = move-exception
            r7 = r10
        L70:
            kotlinx.coroutines.e2 r9 = r8.coroutine
            T r7 = r7.element
            kotlinx.coroutines.q3 r7 = (kotlinx.coroutines.q3) r7
            if (r9 != r7) goto L79
            return r4
        L79:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.r3.e(long, d2.p, kotlin.coroutines.c):java.lang.Object");
    }

    @ExperimentalTime
    @Nullable
    public static final <T> Object f(double d4, @NotNull d2.p<? super q0, ? super kotlin.coroutines.c<? super T>, ? extends Object> pVar, @NotNull kotlin.coroutines.c<? super T> cVar) {
        return e(a1.e(d4), pVar, cVar);
    }
}

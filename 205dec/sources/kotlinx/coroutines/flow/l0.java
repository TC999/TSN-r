package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.f1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: Share.kt */
@Metadata(bv = {}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002BG\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012-\u0010\u000f\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\f\u0012\u0006\u0012\u0004\u0018\u00010\r0\u000b\u00a2\u0006\u0002\b\u000e\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0013\u0010\u0004\u001a\u00020\u0003H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00028\u0000H\u0096A\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0007\u0010\bR\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\t\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0012"}, d2 = {"Lkotlinx/coroutines/flow/l0;", "T", "Lkotlinx/coroutines/flow/i;", "Lkotlin/f1;", "a", "(Lkotlin/coroutines/c;)Ljava/lang/Object;", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/c;)Ljava/lang/Object;", "Lkotlinx/coroutines/flow/i;", "collector", "Lkotlin/Function2;", "Lkotlin/coroutines/c;", "", "Lkotlin/ExtensionFunctionType;", "action", "<init>", "(Lkotlinx/coroutines/flow/i;Ld2/p;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class l0<T> implements i<T> {

    /* renamed from: a  reason: collision with root package name */
    private final i<T> f60194a;

    /* renamed from: b  reason: collision with root package name */
    private final d2.p<i<? super T>, kotlin.coroutines.c<? super f1>, Object> f60195b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Share.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0005\u001a\u0004\u0018\u00010\u0004\"\u0004\b\u0000\u0010\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0086@"}, d2 = {"T", "Lkotlin/coroutines/c;", "Lkotlin/f1;", "continuation", "", "onSubscription"}, k = 3, mv = {1, 4, 0})
    @DebugMetadata(c = "kotlinx.coroutines.flow.SubscribedFlowCollector", f = "Share.kt", i = {0, 0, 1, 1}, l = {407, 411}, m = "onSubscription", n = {"this", "safeCollector", "this", "safeCollector"}, s = {"L$0", "L$1", "L$0", "L$1"})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        /* synthetic */ Object f60196a;

        /* renamed from: b  reason: collision with root package name */
        int f60197b;

        /* renamed from: d  reason: collision with root package name */
        Object f60199d;

        /* renamed from: e  reason: collision with root package name */
        Object f60200e;

        a(kotlin.coroutines.c cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f60196a = obj;
            this.f60197b |= Integer.MIN_VALUE;
            return l0.this.a(this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public l0(@NotNull i<? super T> iVar, @NotNull d2.p<? super i<? super T>, ? super kotlin.coroutines.c<? super f1>, ? extends Object> pVar) {
        this.f60194a = iVar;
        this.f60195b = pVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0072  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(@org.jetbrains.annotations.NotNull kotlin.coroutines.c<? super kotlin.f1> r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof kotlinx.coroutines.flow.l0.a
            if (r0 == 0) goto L13
            r0 = r7
            kotlinx.coroutines.flow.l0$a r0 = (kotlinx.coroutines.flow.l0.a) r0
            int r1 = r0.f60197b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f60197b = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.l0$a r0 = new kotlinx.coroutines.flow.l0$a
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.f60196a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.a.h()
            int r2 = r0.f60197b
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L4a
            if (r2 == r4) goto L3c
            if (r2 != r3) goto L34
            java.lang.Object r1 = r0.f60200e
            kotlinx.coroutines.flow.internal.SafeCollector r1 = (kotlinx.coroutines.flow.internal.SafeCollector) r1
            java.lang.Object r0 = r0.f60199d
            kotlinx.coroutines.flow.l0 r0 = (kotlinx.coroutines.flow.l0) r0
            kotlin.d0.n(r7)
            goto L81
        L34:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L3c:
            java.lang.Object r2 = r0.f60200e
            kotlinx.coroutines.flow.internal.SafeCollector r2 = (kotlinx.coroutines.flow.internal.SafeCollector) r2
            java.lang.Object r4 = r0.f60199d
            kotlinx.coroutines.flow.l0 r4 = (kotlinx.coroutines.flow.l0) r4
            kotlin.d0.n(r7)     // Catch: java.lang.Throwable -> L48
            goto L69
        L48:
            r7 = move-exception
            goto L86
        L4a:
            kotlin.d0.n(r7)
            kotlinx.coroutines.flow.i<T> r7 = r6.f60194a
            kotlin.coroutines.f r2 = r0.getContext()
            kotlinx.coroutines.flow.internal.SafeCollector r5 = new kotlinx.coroutines.flow.internal.SafeCollector
            r5.<init>(r7, r2)
            d2.p<kotlinx.coroutines.flow.i<? super T>, kotlin.coroutines.c<? super kotlin.f1>, java.lang.Object> r7 = r6.f60195b     // Catch: java.lang.Throwable -> L84
            r0.f60199d = r6     // Catch: java.lang.Throwable -> L84
            r0.f60200e = r5     // Catch: java.lang.Throwable -> L84
            r0.f60197b = r4     // Catch: java.lang.Throwable -> L84
            java.lang.Object r7 = r7.invoke(r5, r0)     // Catch: java.lang.Throwable -> L84
            if (r7 != r1) goto L67
            return r1
        L67:
            r4 = r6
            r2 = r5
        L69:
            r2.releaseIntercepted()
            kotlinx.coroutines.flow.i<T> r7 = r4.f60194a
            boolean r5 = r7 instanceof kotlinx.coroutines.flow.l0
            if (r5 == 0) goto L81
            kotlinx.coroutines.flow.l0 r7 = (kotlinx.coroutines.flow.l0) r7
            r0.f60199d = r4
            r0.f60200e = r2
            r0.f60197b = r3
            java.lang.Object r7 = r7.a(r0)
            if (r7 != r1) goto L81
            return r1
        L81:
            kotlin.f1 r7 = kotlin.f1.f55527a
            return r7
        L84:
            r7 = move-exception
            r2 = r5
        L86:
            r2.releaseIntercepted()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.l0.a(kotlin.coroutines.c):java.lang.Object");
    }

    @Override // kotlinx.coroutines.flow.i
    @Nullable
    public Object emit(T t3, @NotNull kotlin.coroutines.c<? super f1> cVar) {
        return this.f60194a.emit(t3, cVar);
    }
}

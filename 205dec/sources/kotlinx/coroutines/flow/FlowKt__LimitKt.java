package kotlinx.coroutines.flow;

import kotlin.BuilderInference;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.f1;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import kotlinx.coroutines.flow.internal.AbortFlowException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: Limit.kt */
@Metadata(bv = {}, d1 = {"\u0000B\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a$\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u0002\u001aJ\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\"\u0010\t\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005\u00f8\u0001\u0000\u00a2\u0006\u0004\b\n\u0010\u000b\u001a$\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u0002\u001a+\u0010\u0010\u001a\u00020\u000f\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\r2\u0006\u0010\u000e\u001a\u00028\u0000H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0010\u0010\u0011\u001aJ\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\"\u0010\t\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0012\u0010\u000b\u001at\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00010\u0001\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0013*\b\u0012\u0004\u0012\u00028\u00000\u00012D\b\u0001\u0010\u0018\u001a>\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\r\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0014\u00a2\u0006\u0002\b\u0017H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0019\u0010\u001a\u001aX\u0010\u001b\u001a\u00020\u000f\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u000123\b\u0004\u0010\t\u001a-\b\u0001\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005H\u0080H\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001b\u0010\u001c\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001d"}, d2 = {"T", "Lkotlinx/coroutines/flow/h;", "", "count", "c", "Lkotlin/Function2;", "Lkotlin/coroutines/c;", "", "", "predicate", "d", "(Lkotlinx/coroutines/flow/h;Ld2/p;)Lkotlinx/coroutines/flow/h;", "f", "Lkotlinx/coroutines/flow/i;", "value", "Lkotlin/f1;", "e", "(Lkotlinx/coroutines/flow/i;Ljava/lang/Object;Lkotlin/coroutines/c;)Ljava/lang/Object;", "g", "R", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "Lkotlin/ExtensionFunctionType;", "transform", "h", "(Lkotlinx/coroutines/flow/h;Ld2/q;)Lkotlinx/coroutines/flow/h;", "a", "(Lkotlinx/coroutines/flow/h;Ld2/p;Lkotlin/coroutines/c;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 5, mv = {1, 4, 0}, xs = "kotlinx/coroutines/flow/FlowKt")
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final /* synthetic */ class FlowKt__LimitKt {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: SafeCollector.common.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J!\u0010\u0005\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0005\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0007\u00b8\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/h;", "Lkotlinx/coroutines/flow/i;", "collector", "Lkotlin/f1;", "e", "(Lkotlinx/coroutines/flow/i;Lkotlin/coroutines/c;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a<T> implements h<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ h f59752a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f59753b;

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
        /* compiled from: Collect.kt */
        @Metadata(bv = {}, d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\u0007"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/i;", "value", "Lkotlin/f1;", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/c;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__LimitKt$$special$$inlined$collect$1"}, k = 1, mv = {1, 4, 0})
        /* renamed from: kotlinx.coroutines.flow.FlowKt__LimitKt$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public static final class C1205a implements i<T> {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ i f59754a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ Ref.IntRef f59755b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ a f59756c;

            public C1205a(i iVar, Ref.IntRef intRef, a aVar) {
                this.f59754a = iVar;
                this.f59755b = intRef;
                this.f59756c = aVar;
            }

            @Override // kotlinx.coroutines.flow.i
            @Nullable
            public Object emit(Object obj, @NotNull kotlin.coroutines.c cVar) {
                Object h4;
                Ref.IntRef intRef = this.f59755b;
                int i4 = intRef.element;
                if (i4 >= this.f59756c.f59753b) {
                    Object emit = this.f59754a.emit(obj, cVar);
                    h4 = kotlin.coroutines.intrinsics.b.h();
                    if (emit == h4) {
                        return emit;
                    }
                } else {
                    intRef.element = i4 + 1;
                }
                return f1.f55527a;
            }
        }

        public a(h hVar, int i4) {
            this.f59752a = hVar;
            this.f59753b = i4;
        }

        @Override // kotlinx.coroutines.flow.h
        @Nullable
        public Object e(@NotNull i iVar, @NotNull kotlin.coroutines.c cVar) {
            Object h4;
            Ref.IntRef intRef = new Ref.IntRef();
            intRef.element = 0;
            Object e4 = this.f59752a.e(new C1205a(iVar, intRef, this), cVar);
            h4 = kotlin.coroutines.intrinsics.b.h();
            return e4 == h4 ? e4 : f1.f55527a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Limit.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0007\u001a\u0004\u0018\u00010\u0006\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0002\u001a\u00028\u00002\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0082@"}, d2 = {"T", "Lkotlinx/coroutines/flow/i;", "value", "Lkotlin/coroutines/c;", "Lkotlin/f1;", "continuation", "", "emitAbort"}, k = 3, mv = {1, 4, 0})
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__LimitKt", f = "Limit.kt", i = {0, 0}, l = {73}, m = "emitAbort$FlowKt__LimitKt", n = {"$this$emitAbort", "value"}, s = {"L$0", "L$1"})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class b extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        /* synthetic */ Object f59757a;

        /* renamed from: b  reason: collision with root package name */
        int f59758b;

        /* renamed from: c  reason: collision with root package name */
        Object f59759c;

        /* renamed from: d  reason: collision with root package name */
        Object f59760d;

        b(kotlin.coroutines.c cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f59757a = obj;
            this.f59758b |= Integer.MIN_VALUE;
            return FlowKt__LimitKt.e(null, null, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x003f  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <T> java.lang.Object a(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.h<? extends T> r4, @org.jetbrains.annotations.NotNull d2.p<? super T, ? super kotlin.coroutines.c<? super java.lang.Boolean>, ? extends java.lang.Object> r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.c<? super kotlin.f1> r6) {
        /*
            boolean r0 = r6 instanceof kotlinx.coroutines.flow.FlowKt__LimitKt$collectWhile$1
            if (r0 == 0) goto L13
            r0 = r6
            kotlinx.coroutines.flow.FlowKt__LimitKt$collectWhile$1 r0 = (kotlinx.coroutines.flow.FlowKt__LimitKt$collectWhile$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.FlowKt__LimitKt$collectWhile$1 r0 = new kotlinx.coroutines.flow.FlowKt__LimitKt$collectWhile$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.a.h()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3f
            if (r2 != r3) goto L37
            java.lang.Object r4 = r0.L$2
            kotlinx.coroutines.flow.FlowKt__LimitKt$collectWhile$collector$1 r4 = (kotlinx.coroutines.flow.FlowKt__LimitKt$collectWhile$collector$1) r4
            java.lang.Object r5 = r0.L$1
            d2.p r5 = (d2.p) r5
            java.lang.Object r5 = r0.L$0
            kotlinx.coroutines.flow.h r5 = (kotlinx.coroutines.flow.h) r5
            kotlin.d0.n(r6)     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L35
            goto L5b
        L35:
            r5 = move-exception
            goto L58
        L37:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L3f:
            kotlin.d0.n(r6)
            kotlinx.coroutines.flow.FlowKt__LimitKt$collectWhile$collector$1 r6 = new kotlinx.coroutines.flow.FlowKt__LimitKt$collectWhile$collector$1
            r6.<init>(r5)
            r0.L$0 = r4     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L56
            r0.L$1 = r5     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L56
            r0.L$2 = r6     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L56
            r0.label = r3     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L56
            java.lang.Object r4 = r4.e(r6, r0)     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L56
            if (r4 != r1) goto L5b
            return r1
        L56:
            r5 = move-exception
            r4 = r6
        L58:
            kotlinx.coroutines.flow.internal.m.b(r5, r4)
        L5b:
            kotlin.f1 r4 = kotlin.f1.f55527a
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__LimitKt.a(kotlinx.coroutines.flow.h, d2.p, kotlin.coroutines.c):java.lang.Object");
    }

    @Nullable
    private static final Object b(@NotNull h hVar, @NotNull d2.p pVar, @NotNull kotlin.coroutines.c cVar) {
        FlowKt__LimitKt$collectWhile$collector$1 flowKt__LimitKt$collectWhile$collector$1 = new FlowKt__LimitKt$collectWhile$collector$1(pVar);
        try {
            kotlin.jvm.internal.c0.e(0);
            hVar.e(flowKt__LimitKt$collectWhile$collector$1, cVar);
            kotlin.jvm.internal.c0.e(2);
            kotlin.jvm.internal.c0.e(1);
        } catch (AbortFlowException e4) {
            kotlinx.coroutines.flow.internal.m.b(e4, flowKt__LimitKt$collectWhile$collector$1);
        }
        return f1.f55527a;
    }

    @NotNull
    public static final <T> h<T> c(@NotNull h<? extends T> hVar, int i4) {
        if (i4 >= 0) {
            return new a(hVar, i4);
        }
        throw new IllegalArgumentException(("Drop count should be non-negative, but had " + i4).toString());
    }

    @NotNull
    public static final <T> h<T> d(@NotNull h<? extends T> hVar, @NotNull d2.p<? super T, ? super kotlin.coroutines.c<? super Boolean>, ? extends Object> pVar) {
        return new FlowKt__LimitKt$dropWhile$$inlined$unsafeFlow$1(hVar, pVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0035  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final /* synthetic */ <T> java.lang.Object e(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.i<? super T> r4, T r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.c<? super kotlin.f1> r6) {
        /*
            boolean r0 = r6 instanceof kotlinx.coroutines.flow.FlowKt__LimitKt.b
            if (r0 == 0) goto L13
            r0 = r6
            kotlinx.coroutines.flow.FlowKt__LimitKt$b r0 = (kotlinx.coroutines.flow.FlowKt__LimitKt.b) r0
            int r1 = r0.f59758b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f59758b = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.FlowKt__LimitKt$b r0 = new kotlinx.coroutines.flow.FlowKt__LimitKt$b
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.f59757a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.a.h()
            int r2 = r0.f59758b
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 == r3) goto L2d
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L2d:
            java.lang.Object r4 = r0.f59759c
            kotlinx.coroutines.flow.i r4 = (kotlinx.coroutines.flow.i) r4
            kotlin.d0.n(r6)
            goto L45
        L35:
            kotlin.d0.n(r6)
            r0.f59759c = r4
            r0.f59760d = r5
            r0.f59758b = r3
            java.lang.Object r5 = r4.emit(r5, r0)
            if (r5 != r1) goto L45
            return r1
        L45:
            kotlinx.coroutines.flow.internal.AbortFlowException r5 = new kotlinx.coroutines.flow.internal.AbortFlowException
            r5.<init>(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__LimitKt.e(kotlinx.coroutines.flow.i, java.lang.Object, kotlin.coroutines.c):java.lang.Object");
    }

    @NotNull
    public static final <T> h<T> f(@NotNull h<? extends T> hVar, int i4) {
        if (i4 > 0) {
            return new FlowKt__LimitKt$take$$inlined$unsafeFlow$1(hVar, i4);
        }
        throw new IllegalArgumentException(("Requested element count " + i4 + " should be positive").toString());
    }

    @NotNull
    public static final <T> h<T> g(@NotNull h<? extends T> hVar, @NotNull d2.p<? super T, ? super kotlin.coroutines.c<? super Boolean>, ? extends Object> pVar) {
        return new FlowKt__LimitKt$takeWhile$$inlined$unsafeFlow$1(hVar, pVar);
    }

    @ExperimentalCoroutinesApi
    @NotNull
    public static final <T, R> h<R> h(@NotNull h<? extends T> hVar, @BuilderInference @NotNull d2.q<? super i<? super R>, ? super T, ? super kotlin.coroutines.c<? super Boolean>, ? extends Object> qVar) {
        return k.N0(new FlowKt__LimitKt$transformWhile$1(hVar, qVar, null));
    }
}

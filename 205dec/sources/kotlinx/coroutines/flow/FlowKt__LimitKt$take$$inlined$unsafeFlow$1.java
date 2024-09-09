package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.f1;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: SafeCollector.common.kt */
@Metadata(bv = {}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J!\u0010\u0005\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0005\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0007\u00b8\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/h;", "Lkotlinx/coroutines/flow/i;", "collector", "Lkotlin/f1;", "e", "(Lkotlinx/coroutines/flow/i;Lkotlin/coroutines/c;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class FlowKt__LimitKt$take$$inlined$unsafeFlow$1<T> implements h<T> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ h f59741a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ int f59742b;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    @Metadata(bv = {}, d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006\"\u0004\b\u0000\u0010\u00002\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0096@\u00a8\u0006\u0007"}, d2 = {"T", "Lkotlinx/coroutines/flow/i;", "collector", "Lkotlin/coroutines/c;", "Lkotlin/f1;", "continuation", "", "kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1$collect$1", "collect"}, k = 3, mv = {1, 4, 0})
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__LimitKt$take$$inlined$unsafeFlow$1", f = "Limit.kt", i = {0, 0, 0, 0, 0, 0}, l = {116}, m = "collect", n = {"this", "collector", "continuation", "$receiver", "consumed", "$this$collect$iv"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5"})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__LimitKt$take$$inlined$unsafeFlow$1$1  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(kotlin.coroutines.c cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FlowKt__LimitKt$take$$inlined$unsafeFlow$1.this.e(null, this);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Collect.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\u0007"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/i;", "value", "Lkotlin/f1;", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/c;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__LimitKt$$special$$inlined$collect$3"}, k = 1, mv = {1, 4, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a implements i<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ i f59743a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Ref.IntRef f59744b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ FlowKt__LimitKt$take$$inlined$unsafeFlow$1 f59745c;

        public a(i iVar, Ref.IntRef intRef, FlowKt__LimitKt$take$$inlined$unsafeFlow$1 flowKt__LimitKt$take$$inlined$unsafeFlow$1) {
            this.f59743a = iVar;
            this.f59744b = intRef;
            this.f59745c = flowKt__LimitKt$take$$inlined$unsafeFlow$1;
        }

        @Override // kotlinx.coroutines.flow.i
        @Nullable
        public Object emit(Object obj, @NotNull kotlin.coroutines.c cVar) {
            Object h4;
            Object h5;
            Ref.IntRef intRef = this.f59744b;
            int i4 = intRef.element + 1;
            intRef.element = i4;
            if (i4 < this.f59745c.f59742b) {
                Object emit = this.f59743a.emit(obj, cVar);
                h5 = kotlin.coroutines.intrinsics.b.h();
                return emit == h5 ? emit : f1.f55527a;
            }
            Object e4 = FlowKt__LimitKt.e(this.f59743a, obj, cVar);
            h4 = kotlin.coroutines.intrinsics.b.h();
            return e4 == h4 ? e4 : f1.f55527a;
        }
    }

    public FlowKt__LimitKt$take$$inlined$unsafeFlow$1(h hVar, int i4) {
        this.f59741a = hVar;
        this.f59742b = i4;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(9:1|(2:3|(7:5|6|7|(1:(2:10|11)(2:17|18))(3:19|20|(1:22))|12|13|14))|25|6|7|(0)(0)|12|13|14) */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0070, code lost:
        r7 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0071, code lost:
        kotlinx.coroutines.flow.internal.m.b(r7, r6);
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0049  */
    @Override // kotlinx.coroutines.flow.h
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object e(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.i r6, @org.jetbrains.annotations.NotNull kotlin.coroutines.c r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof kotlinx.coroutines.flow.FlowKt__LimitKt$take$$inlined$unsafeFlow$1.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r7
            kotlinx.coroutines.flow.FlowKt__LimitKt$take$$inlined$unsafeFlow$1$1 r0 = (kotlinx.coroutines.flow.FlowKt__LimitKt$take$$inlined$unsafeFlow$1.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.FlowKt__LimitKt$take$$inlined$unsafeFlow$1$1 r0 = new kotlinx.coroutines.flow.FlowKt__LimitKt$take$$inlined$unsafeFlow$1$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.a.h()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L49
            if (r2 != r3) goto L41
            java.lang.Object r6 = r0.L$5
            kotlinx.coroutines.flow.h r6 = (kotlinx.coroutines.flow.h) r6
            java.lang.Object r6 = r0.L$4
            kotlin.jvm.internal.Ref$IntRef r6 = (kotlin.jvm.internal.Ref.IntRef) r6
            java.lang.Object r6 = r0.L$3
            kotlinx.coroutines.flow.i r6 = (kotlinx.coroutines.flow.i) r6
            java.lang.Object r1 = r0.L$2
            kotlin.coroutines.c r1 = (kotlin.coroutines.c) r1
            java.lang.Object r1 = r0.L$1
            kotlinx.coroutines.flow.i r1 = (kotlinx.coroutines.flow.i) r1
            java.lang.Object r0 = r0.L$0
            kotlinx.coroutines.flow.FlowKt__LimitKt$take$$inlined$unsafeFlow$1 r0 = (kotlinx.coroutines.flow.FlowKt__LimitKt$take$$inlined$unsafeFlow$1) r0
            kotlin.d0.n(r7)     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L70
            goto L74
        L41:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L49:
            kotlin.d0.n(r7)
            kotlin.jvm.internal.Ref$IntRef r7 = new kotlin.jvm.internal.Ref$IntRef
            r7.<init>()
            r2 = 0
            r7.element = r2
            kotlinx.coroutines.flow.h r2 = r5.f59741a     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L70
            kotlinx.coroutines.flow.FlowKt__LimitKt$take$$inlined$unsafeFlow$1$a r4 = new kotlinx.coroutines.flow.FlowKt__LimitKt$take$$inlined$unsafeFlow$1$a     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L70
            r4.<init>(r6, r7, r5)     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L70
            r0.L$0 = r5     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L70
            r0.L$1 = r6     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L70
            r0.L$2 = r0     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L70
            r0.L$3 = r6     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L70
            r0.L$4 = r7     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L70
            r0.L$5 = r2     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L70
            r0.label = r3     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L70
            java.lang.Object r6 = r2.e(r4, r0)     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L70
            if (r6 != r1) goto L74
            return r1
        L70:
            r7 = move-exception
            kotlinx.coroutines.flow.internal.m.b(r7, r6)
        L74:
            kotlin.f1 r6 = kotlin.f1.f55527a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__LimitKt$take$$inlined$unsafeFlow$1.e(kotlinx.coroutines.flow.i, kotlin.coroutines.c):java.lang.Object");
    }
}

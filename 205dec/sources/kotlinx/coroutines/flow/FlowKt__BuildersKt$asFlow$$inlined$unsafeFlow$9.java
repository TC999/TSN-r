package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: SafeCollector.common.kt */
@Metadata(bv = {}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J!\u0010\u0005\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0005\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0007\u00b8\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/h;", "Lkotlinx/coroutines/flow/i;", "collector", "Lkotlin/f1;", "e", "(Lkotlinx/coroutines/flow/i;Lkotlin/coroutines/c;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$9 implements h<Integer> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ kotlin.ranges.k f59648a;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    @Metadata(bv = {}, d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006\"\u0004\b\u0000\u0010\u00002\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0096@\u00a8\u0006\u0007"}, d2 = {"T", "Lkotlinx/coroutines/flow/i;", "collector", "Lkotlin/coroutines/c;", "Lkotlin/f1;", "continuation", "", "kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1$collect$1", "collect"}, k = 3, mv = {1, 4, 0})
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$9", f = "Builders.kt", i = {0, 0, 0, 0, 0, 0, 0}, l = {115}, m = "collect", n = {"this", "collector", "continuation", "$receiver", "$this$forEach$iv", "element$iv", "value"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$6", "I$0"})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$9$1  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
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
            return FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$9.this.e(null, this);
        }
    }

    public FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$9(kotlin.ranges.k kVar) {
        this.f59648a = kVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0067  */
    @Override // kotlinx.coroutines.flow.h
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object e(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.i<? super java.lang.Integer> r12, @org.jetbrains.annotations.NotNull kotlin.coroutines.c r13) {
        /*
            r11 = this;
            boolean r0 = r13 instanceof kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$9.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r13
            kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$9$1 r0 = (kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$9.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$9$1 r0 = new kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$9$1
            r0.<init>(r13)
        L18:
            java.lang.Object r13 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.a.h()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L50
            if (r2 != r3) goto L48
            java.lang.Object r12 = r0.L$5
            java.util.Iterator r12 = (java.util.Iterator) r12
            java.lang.Object r2 = r0.L$4
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.lang.Object r4 = r0.L$3
            kotlinx.coroutines.flow.i r4 = (kotlinx.coroutines.flow.i) r4
            java.lang.Object r5 = r0.L$2
            kotlin.coroutines.c r5 = (kotlin.coroutines.c) r5
            java.lang.Object r6 = r0.L$1
            kotlinx.coroutines.flow.i r6 = (kotlinx.coroutines.flow.i) r6
            java.lang.Object r7 = r0.L$0
            kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$9 r7 = (kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$9) r7
            kotlin.d0.n(r13)
            r13 = r4
            r4 = r1
            r1 = r0
            r0 = r6
            r10 = r5
            r5 = r2
            r2 = r10
            goto L61
        L48:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L50:
            kotlin.d0.n(r13)
            kotlin.ranges.k r13 = r11.f59648a
            java.util.Iterator r2 = r13.iterator()
            r7 = r11
            r5 = r13
            r4 = r1
            r13 = r12
            r1 = r0
            r12 = r2
            r0 = r13
            r2 = r1
        L61:
            boolean r6 = r12.hasNext()
            if (r6 == 0) goto L8f
            java.lang.Object r6 = r12.next()
            r8 = r6
            java.lang.Number r8 = (java.lang.Number) r8
            int r8 = r8.intValue()
            java.lang.Integer r9 = kotlin.coroutines.jvm.internal.a.f(r8)
            r1.L$0 = r7
            r1.L$1 = r0
            r1.L$2 = r2
            r1.L$3 = r13
            r1.L$4 = r5
            r1.L$5 = r12
            r1.L$6 = r6
            r1.I$0 = r8
            r1.label = r3
            java.lang.Object r6 = r13.emit(r9, r1)
            if (r6 != r4) goto L61
            return r4
        L8f:
            kotlin.f1 r12 = kotlin.f1.f55527a
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$9.e(kotlinx.coroutines.flow.i, kotlin.coroutines.c):java.lang.Object");
    }
}

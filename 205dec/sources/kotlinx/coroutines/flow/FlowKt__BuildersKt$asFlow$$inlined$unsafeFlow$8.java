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
public final class FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$8 implements h<Long> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ long[] f59647a;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    @Metadata(bv = {}, d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006\"\u0004\b\u0000\u0010\u00002\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0096@\u00a8\u0006\u0007"}, d2 = {"T", "Lkotlinx/coroutines/flow/i;", "collector", "Lkotlin/coroutines/c;", "Lkotlin/f1;", "continuation", "", "kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1$collect$1", "collect"}, k = 3, mv = {1, 4, 0})
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$8", f = "Builders.kt", i = {0, 0, 0, 0, 0, 0, 0}, l = {115}, m = "collect", n = {"this", "collector", "continuation", "$receiver", "$this$forEach$iv", "element$iv", "value"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "J$0", "J$1"})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$8$1  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        int I$1;
        long J$0;
        long J$1;
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
            return FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$8.this.e(null, this);
        }
    }

    public FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$8(long[] jArr) {
        this.f59647a = jArr;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00a7  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x009c -> B:20:0x00a1). Please submit an issue!!! */
    @Override // kotlinx.coroutines.flow.h
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object e(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.i<? super java.lang.Long> r17, @org.jetbrains.annotations.NotNull kotlin.coroutines.c r18) {
        /*
            r16 = this;
            r0 = r16
            r1 = r18
            boolean r2 = r1 instanceof kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$8.AnonymousClass1
            if (r2 == 0) goto L17
            r2 = r1
            kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$8$1 r2 = (kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$8.AnonymousClass1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L17
            int r3 = r3 - r4
            r2.label = r3
            goto L1c
        L17:
            kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$8$1 r2 = new kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$8$1
            r2.<init>(r1)
        L1c:
            java.lang.Object r1 = r2.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.a.h()
            int r4 = r2.label
            r5 = 1
            if (r4 == 0) goto L58
            if (r4 != r5) goto L50
            int r4 = r2.I$1
            int r6 = r2.I$0
            java.lang.Object r7 = r2.L$5
            long[] r7 = (long[]) r7
            java.lang.Object r8 = r2.L$4
            long[] r8 = (long[]) r8
            java.lang.Object r9 = r2.L$3
            kotlinx.coroutines.flow.i r9 = (kotlinx.coroutines.flow.i) r9
            java.lang.Object r10 = r2.L$2
            kotlin.coroutines.c r10 = (kotlin.coroutines.c) r10
            java.lang.Object r11 = r2.L$1
            kotlinx.coroutines.flow.i r11 = (kotlinx.coroutines.flow.i) r11
            java.lang.Object r12 = r2.L$0
            kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$8 r12 = (kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$8) r12
            kotlin.d0.n(r1)
            r1 = r9
            r9 = r7
            r7 = r8
            r8 = r6
            r6 = r3
            r3 = r2
            r2 = r11
            goto La1
        L50:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L58:
            kotlin.d0.n(r1)
            long[] r1 = r0.f59647a
            int r4 = r1.length
            r6 = 0
            r12 = r0
            r9 = r1
            r10 = r9
            r6 = r3
            r8 = r4
            r7 = 0
            r1 = r17
            r3 = r2
            r4 = r3
            r2 = r1
        L6a:
            if (r7 >= r8) goto La7
            r13 = r9[r7]
            java.lang.Long r11 = kotlin.coroutines.jvm.internal.a.g(r13)
            r17 = r6
            long r5 = r11.longValue()
            java.lang.Long r11 = kotlin.coroutines.jvm.internal.a.g(r5)
            r3.L$0 = r12
            r3.L$1 = r2
            r3.L$2 = r4
            r3.L$3 = r1
            r3.L$4 = r10
            r3.L$5 = r9
            r3.I$0 = r8
            r3.I$1 = r7
            r3.J$0 = r13
            r3.J$1 = r5
            r5 = 1
            r3.label = r5
            java.lang.Object r6 = r1.emit(r11, r3)
            r11 = r17
            if (r6 != r11) goto L9c
            return r11
        L9c:
            r6 = r11
            r15 = r10
            r10 = r4
            r4 = r7
            r7 = r15
        La1:
            int r4 = r4 + r5
            r15 = r7
            r7 = r4
            r4 = r10
            r10 = r15
            goto L6a
        La7:
            kotlin.f1 r1 = kotlin.f1.f55527a
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$8.e(kotlinx.coroutines.flow.i, kotlin.coroutines.c):java.lang.Object");
    }
}

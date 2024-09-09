package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: SafeCollector.common.kt */
@Metadata(bv = {}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J!\u0010\u0005\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0005\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0007\u00b8\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/h;", "Lkotlinx/coroutines/flow/i;", "collector", "Lkotlin/f1;", "e", "(Lkotlinx/coroutines/flow/i;Lkotlin/coroutines/c;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1<T> implements h<T> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ h f59683a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ d2.p f59684b;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    @Metadata(bv = {}, d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006\"\u0004\b\u0000\u0010\u00002\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0096@\u00a8\u0006\u0007"}, d2 = {"T", "Lkotlinx/coroutines/flow/i;", "collector", "Lkotlin/coroutines/c;", "Lkotlin/f1;", "continuation", "", "kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1$collect$1", "collect"}, k = 3, mv = {1, 4, 0})
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1", f = "Emitters.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1}, l = {116, 120}, m = "collect", n = {"this", "collector", "continuation", "$receiver", "safeCollector", "this", "collector", "continuation", "$receiver", "safeCollector"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4"})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1$1  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
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
            return FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1.this.e(null, this);
        }
    }

    public FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1(h hVar, d2.p pVar) {
        this.f59683a = hVar;
        this.f59684b = pVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00a7 A[RETURN] */
    @Override // kotlinx.coroutines.flow.h
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object e(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.i r8, @org.jetbrains.annotations.NotNull kotlin.coroutines.c r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof kotlinx.coroutines.flow.FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r9
            kotlinx.coroutines.flow.FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1$1 r0 = (kotlinx.coroutines.flow.FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1$1 r0 = new kotlinx.coroutines.flow.FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1$1
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.a.h()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L62
            if (r2 == r4) goto L48
            if (r2 != r3) goto L40
            java.lang.Object r8 = r0.L$4
            kotlinx.coroutines.flow.internal.SafeCollector r8 = (kotlinx.coroutines.flow.internal.SafeCollector) r8
            java.lang.Object r8 = r0.L$3
            kotlinx.coroutines.flow.i r8 = (kotlinx.coroutines.flow.i) r8
            java.lang.Object r8 = r0.L$2
            kotlin.coroutines.c r8 = (kotlin.coroutines.c) r8
            java.lang.Object r8 = r0.L$1
            kotlinx.coroutines.flow.i r8 = (kotlinx.coroutines.flow.i) r8
            java.lang.Object r8 = r0.L$0
            kotlinx.coroutines.flow.FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1 r8 = (kotlinx.coroutines.flow.FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1) r8
            kotlin.d0.n(r9)
            goto La8
        L40:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L48:
            java.lang.Object r8 = r0.L$4
            kotlinx.coroutines.flow.internal.SafeCollector r8 = (kotlinx.coroutines.flow.internal.SafeCollector) r8
            java.lang.Object r2 = r0.L$3
            kotlinx.coroutines.flow.i r2 = (kotlinx.coroutines.flow.i) r2
            java.lang.Object r4 = r0.L$2
            kotlin.coroutines.c r4 = (kotlin.coroutines.c) r4
            java.lang.Object r5 = r0.L$1
            kotlinx.coroutines.flow.i r5 = (kotlinx.coroutines.flow.i) r5
            java.lang.Object r6 = r0.L$0
            kotlinx.coroutines.flow.FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1 r6 = (kotlinx.coroutines.flow.FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1) r6
            kotlin.d0.n(r9)     // Catch: java.lang.Throwable -> L60
            goto L90
        L60:
            r9 = move-exception
            goto Lad
        L62:
            kotlin.d0.n(r9)
            kotlin.coroutines.f r9 = r0.getContext()
            kotlinx.coroutines.flow.internal.SafeCollector r2 = new kotlinx.coroutines.flow.internal.SafeCollector
            r2.<init>(r8, r9)
            d2.p r9 = r7.f59684b     // Catch: java.lang.Throwable -> Lab
            r0.L$0 = r7     // Catch: java.lang.Throwable -> Lab
            r0.L$1 = r8     // Catch: java.lang.Throwable -> Lab
            r0.L$2 = r0     // Catch: java.lang.Throwable -> Lab
            r0.L$3 = r8     // Catch: java.lang.Throwable -> Lab
            r0.L$4 = r2     // Catch: java.lang.Throwable -> Lab
            r0.label = r4     // Catch: java.lang.Throwable -> Lab
            r4 = 6
            kotlin.jvm.internal.c0.e(r4)     // Catch: java.lang.Throwable -> Lab
            java.lang.Object r9 = r9.invoke(r2, r0)     // Catch: java.lang.Throwable -> Lab
            r4 = 7
            kotlin.jvm.internal.c0.e(r4)     // Catch: java.lang.Throwable -> Lab
            if (r9 != r1) goto L8b
            return r1
        L8b:
            r6 = r7
            r5 = r8
            r4 = r0
            r8 = r2
            r2 = r5
        L90:
            r8.releaseIntercepted()
            kotlinx.coroutines.flow.h r9 = r6.f59683a
            r0.L$0 = r6
            r0.L$1 = r5
            r0.L$2 = r4
            r0.L$3 = r2
            r0.L$4 = r8
            r0.label = r3
            java.lang.Object r8 = r9.e(r2, r0)
            if (r8 != r1) goto La8
            return r1
        La8:
            kotlin.f1 r8 = kotlin.f1.f55527a
            return r8
        Lab:
            r9 = move-exception
            r8 = r2
        Lad:
            r8.releaseIntercepted()
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1.e(kotlinx.coroutines.flow.i, kotlin.coroutines.c):java.lang.Object");
    }
}

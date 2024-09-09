package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.f1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: SafeCollector.common.kt */
@Metadata(bv = {}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J!\u0010\u0005\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0005\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0007\u00b8\u0006\b"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/h;", "Lkotlinx/coroutines/flow/i;", "collector", "Lkotlin/f1;", "e", "(Lkotlinx/coroutines/flow/i;Lkotlin/coroutines/c;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__TransformKt$unsafeTransform$$inlined$unsafeFlow$1"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class FlowKt__TransformKt$filter$$inlined$unsafeTransform$1<T> implements h<T> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ h f59874a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ d2.p f59875b;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Collect.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\u0007"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/i;", "value", "Lkotlin/f1;", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/c;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__TransformKt$unsafeTransform$$inlined$unsafeFlow$1$lambda$1"}, k = 1, mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__TransformKt$filter$$inlined$unsafeTransform$1$2  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class AnonymousClass2 implements i<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ i f59876a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ FlowKt__TransformKt$filter$$inlined$unsafeTransform$1 f59877b;

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
        @Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0001\u001a\u00028\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0096@\u00a8\u0006\u0006"}, d2 = {"T", "value", "Lkotlin/coroutines/c;", "Lkotlin/f1;", "continuation", "", "kotlinx/coroutines/flow/FlowKt__TransformKt$unsafeTransform$$inlined$unsafeFlow$1$lambda$1$1", "emit"}, k = 3, mv = {1, 4, 0})
        @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__TransformKt$filter$$inlined$unsafeTransform$1$2", f = "Transform.kt", i = {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1}, l = {134, 134}, m = "emit", n = {"this", "value", "continuation", "value", "continuation", "value", "$receiver", "this", "value", "continuation", "value", "continuation", "value", "$receiver"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6"})
        /* renamed from: kotlinx.coroutines.flow.FlowKt__TransformKt$filter$$inlined$unsafeTransform$1$2$1  reason: invalid class name */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public static final class AnonymousClass1 extends ContinuationImpl {
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
                return AnonymousClass2.this.emit(null, this);
            }
        }

        public AnonymousClass2(i iVar, FlowKt__TransformKt$filter$$inlined$unsafeTransform$1 flowKt__TransformKt$filter$$inlined$unsafeTransform$1) {
            this.f59876a = iVar;
            this.f59877b = flowKt__TransformKt$filter$$inlined$unsafeTransform$1;
        }

        @Nullable
        public Object a(Object obj, @NotNull kotlin.coroutines.c cVar) {
            kotlin.jvm.internal.c0.e(4);
            new AnonymousClass1(cVar);
            kotlin.jvm.internal.c0.e(5);
            i iVar = this.f59876a;
            if (((Boolean) this.f59877b.f59875b.invoke(obj, cVar)).booleanValue()) {
                kotlin.jvm.internal.c0.e(0);
                Object emit = iVar.emit(obj, cVar);
                kotlin.jvm.internal.c0.e(2);
                kotlin.jvm.internal.c0.e(1);
                return emit;
            }
            return f1.f55527a;
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
        /* JADX WARN: Removed duplicated region for block: B:16:0x005f  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x008f  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x00a9  */
        @Override // kotlinx.coroutines.flow.i
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public java.lang.Object emit(java.lang.Object r10, @org.jetbrains.annotations.NotNull kotlin.coroutines.c r11) {
            /*
                r9 = this;
                boolean r0 = r11 instanceof kotlinx.coroutines.flow.FlowKt__TransformKt$filter$$inlined$unsafeTransform$1.AnonymousClass2.AnonymousClass1
                if (r0 == 0) goto L13
                r0 = r11
                kotlinx.coroutines.flow.FlowKt__TransformKt$filter$$inlined$unsafeTransform$1$2$1 r0 = (kotlinx.coroutines.flow.FlowKt__TransformKt$filter$$inlined$unsafeTransform$1.AnonymousClass2.AnonymousClass1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.label = r1
                goto L18
            L13:
                kotlinx.coroutines.flow.FlowKt__TransformKt$filter$$inlined$unsafeTransform$1$2$1 r0 = new kotlinx.coroutines.flow.FlowKt__TransformKt$filter$$inlined$unsafeTransform$1$2$1
                r0.<init>(r11)
            L18:
                java.lang.Object r11 = r0.result
                java.lang.Object r1 = kotlin.coroutines.intrinsics.a.h()
                int r2 = r0.label
                r3 = 2
                r4 = 1
                if (r2 == 0) goto L5f
                if (r2 == r4) goto L45
                if (r2 != r3) goto L3d
                java.lang.Object r10 = r0.L$6
                kotlinx.coroutines.flow.i r10 = (kotlinx.coroutines.flow.i) r10
                java.lang.Object r10 = r0.L$4
                kotlin.coroutines.c r10 = (kotlin.coroutines.c) r10
                java.lang.Object r10 = r0.L$2
                kotlinx.coroutines.flow.FlowKt__TransformKt$filter$$inlined$unsafeTransform$1$2$1 r10 = (kotlinx.coroutines.flow.FlowKt__TransformKt$filter$$inlined$unsafeTransform$1.AnonymousClass2.AnonymousClass1) r10
                java.lang.Object r10 = r0.L$0
                kotlinx.coroutines.flow.FlowKt__TransformKt$filter$$inlined$unsafeTransform$1$2 r10 = (kotlinx.coroutines.flow.FlowKt__TransformKt$filter$$inlined$unsafeTransform$1.AnonymousClass2) r10
                kotlin.d0.n(r11)
                goto La6
            L3d:
                java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
                r10.<init>(r11)
                throw r10
            L45:
                java.lang.Object r10 = r0.L$6
                kotlinx.coroutines.flow.i r10 = (kotlinx.coroutines.flow.i) r10
                java.lang.Object r2 = r0.L$5
                java.lang.Object r4 = r0.L$4
                kotlin.coroutines.c r4 = (kotlin.coroutines.c) r4
                java.lang.Object r5 = r0.L$3
                java.lang.Object r6 = r0.L$2
                kotlinx.coroutines.flow.FlowKt__TransformKt$filter$$inlined$unsafeTransform$1$2$1 r6 = (kotlinx.coroutines.flow.FlowKt__TransformKt$filter$$inlined$unsafeTransform$1.AnonymousClass2.AnonymousClass1) r6
                java.lang.Object r7 = r0.L$1
                java.lang.Object r8 = r0.L$0
                kotlinx.coroutines.flow.FlowKt__TransformKt$filter$$inlined$unsafeTransform$1$2 r8 = (kotlinx.coroutines.flow.FlowKt__TransformKt$filter$$inlined$unsafeTransform$1.AnonymousClass2) r8
                kotlin.d0.n(r11)
                goto L87
            L5f:
                kotlin.d0.n(r11)
                kotlinx.coroutines.flow.i r11 = r9.f59876a
                kotlinx.coroutines.flow.FlowKt__TransformKt$filter$$inlined$unsafeTransform$1 r2 = r9.f59877b
                d2.p r2 = r2.f59875b
                r0.L$0 = r9
                r0.L$1 = r10
                r0.L$2 = r0
                r0.L$3 = r10
                r0.L$4 = r0
                r0.L$5 = r10
                r0.L$6 = r11
                r0.label = r4
                java.lang.Object r2 = r2.invoke(r10, r0)
                if (r2 != r1) goto L7f
                return r1
            L7f:
                r8 = r9
                r5 = r10
                r7 = r5
                r4 = r0
                r6 = r4
                r10 = r11
                r11 = r2
                r2 = r7
            L87:
                java.lang.Boolean r11 = (java.lang.Boolean) r11
                boolean r11 = r11.booleanValue()
                if (r11 == 0) goto La9
                r0.L$0 = r8
                r0.L$1 = r7
                r0.L$2 = r6
                r0.L$3 = r5
                r0.L$4 = r4
                r0.L$5 = r2
                r0.L$6 = r10
                r0.label = r3
                java.lang.Object r10 = r10.emit(r2, r0)
                if (r10 != r1) goto La6
                return r1
            La6:
                kotlin.f1 r10 = kotlin.f1.f55527a
                goto Lab
            La9:
                kotlin.f1 r10 = kotlin.f1.f55527a
            Lab:
                return r10
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__TransformKt$filter$$inlined$unsafeTransform$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.c):java.lang.Object");
        }
    }

    public FlowKt__TransformKt$filter$$inlined$unsafeTransform$1(h hVar, d2.p pVar) {
        this.f59874a = hVar;
        this.f59875b = pVar;
    }

    @Override // kotlinx.coroutines.flow.h
    @Nullable
    public Object e(@NotNull i iVar, @NotNull kotlin.coroutines.c cVar) {
        Object h4;
        Object e4 = this.f59874a.e(new AnonymousClass2(iVar, this), cVar);
        h4 = kotlin.coroutines.intrinsics.b.h();
        return e4 == h4 ? e4 : f1.f55527a;
    }

    @Nullable
    public Object g(@NotNull i iVar, @NotNull kotlin.coroutines.c cVar) {
        kotlin.jvm.internal.c0.e(4);
        new ContinuationImpl(cVar) { // from class: kotlinx.coroutines.flow.FlowKt__TransformKt$filter$$inlined$unsafeTransform$1.1
            int label;
            /* synthetic */ Object result;

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                this.result = obj;
                this.label |= Integer.MIN_VALUE;
                return FlowKt__TransformKt$filter$$inlined$unsafeTransform$1.this.e(null, this);
            }
        };
        kotlin.jvm.internal.c0.e(5);
        h hVar = this.f59874a;
        AnonymousClass2 anonymousClass2 = new AnonymousClass2(iVar, this);
        kotlin.jvm.internal.c0.e(0);
        hVar.e(anonymousClass2, cVar);
        kotlin.jvm.internal.c0.e(2);
        kotlin.jvm.internal.c0.e(1);
        return f1.f55527a;
    }
}

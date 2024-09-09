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
/* compiled from: SafeCollector.common.kt */
@Metadata(bv = {}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J!\u0010\u0005\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0005\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0007\u00b8\u0006\b"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/h;", "Lkotlinx/coroutines/flow/i;", "collector", "Lkotlin/f1;", "e", "(Lkotlinx/coroutines/flow/i;Lkotlin/coroutines/c;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__TransformKt$filter$$inlined$unsafeTransform$2"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class FlowKt__TransformKt$filterIsInstance$$inlined$filter$1 implements h<Object> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ h f59882a;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Collect.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\u0007"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/i;", "value", "Lkotlin/f1;", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/c;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__TransformKt$filter$$inlined$unsafeTransform$2$2"}, k = 1, mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__TransformKt$filterIsInstance$$inlined$filter$1$2  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class AnonymousClass2 implements i<Object> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ i f59883a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ FlowKt__TransformKt$filterIsInstance$$inlined$filter$1 f59884b;

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
        @Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0001\u001a\u00028\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0096@\u00a8\u0006\u0006"}, d2 = {"T", "value", "Lkotlin/coroutines/c;", "Lkotlin/f1;", "continuation", "", "kotlinx/coroutines/flow/FlowKt__TransformKt$filter$$inlined$unsafeTransform$2$2$1", "emit"}, k = 3, mv = {1, 4, 0})
        @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__TransformKt$filterIsInstance$$inlined$filter$1$2", f = "Transform.kt", i = {0, 0, 0, 0, 0, 0, 0}, l = {135}, m = "emit", n = {"this", "value", "continuation", "value", "continuation", "value", "$receiver"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6"})
        /* renamed from: kotlinx.coroutines.flow.FlowKt__TransformKt$filterIsInstance$$inlined$filter$1$2$1  reason: invalid class name */
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

        public AnonymousClass2(i iVar, FlowKt__TransformKt$filterIsInstance$$inlined$filter$1 flowKt__TransformKt$filterIsInstance$$inlined$filter$1) {
            this.f59883a = iVar;
            this.f59884b = flowKt__TransformKt$filterIsInstance$$inlined$filter$1;
        }

        @Nullable
        public Object a(Object obj, @NotNull kotlin.coroutines.c cVar) {
            kotlin.jvm.internal.c0.e(4);
            new AnonymousClass1(cVar);
            kotlin.jvm.internal.c0.e(5);
            i iVar = this.f59883a;
            kotlin.jvm.internal.f0.y(3, "R");
            if (obj instanceof Object) {
                kotlin.jvm.internal.c0.e(0);
                Object emit = iVar.emit(obj, cVar);
                kotlin.jvm.internal.c0.e(2);
                kotlin.jvm.internal.c0.e(1);
                return emit;
            }
            return f1.f55527a;
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x0041  */
        @Override // kotlinx.coroutines.flow.i
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public java.lang.Object emit(java.lang.Object r6, @org.jetbrains.annotations.NotNull kotlin.coroutines.c r7) {
            /*
                r5 = this;
                boolean r0 = r7 instanceof kotlinx.coroutines.flow.FlowKt__TransformKt$filterIsInstance$$inlined$filter$1.AnonymousClass2.AnonymousClass1
                if (r0 == 0) goto L13
                r0 = r7
                kotlinx.coroutines.flow.FlowKt__TransformKt$filterIsInstance$$inlined$filter$1$2$1 r0 = (kotlinx.coroutines.flow.FlowKt__TransformKt$filterIsInstance$$inlined$filter$1.AnonymousClass2.AnonymousClass1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.label = r1
                goto L18
            L13:
                kotlinx.coroutines.flow.FlowKt__TransformKt$filterIsInstance$$inlined$filter$1$2$1 r0 = new kotlinx.coroutines.flow.FlowKt__TransformKt$filterIsInstance$$inlined$filter$1$2$1
                r0.<init>(r7)
            L18:
                java.lang.Object r7 = r0.result
                java.lang.Object r1 = kotlin.coroutines.intrinsics.a.h()
                int r2 = r0.label
                r3 = 1
                if (r2 == 0) goto L41
                if (r2 != r3) goto L39
                java.lang.Object r6 = r0.L$6
                kotlinx.coroutines.flow.i r6 = (kotlinx.coroutines.flow.i) r6
                java.lang.Object r6 = r0.L$4
                kotlinx.coroutines.flow.FlowKt__TransformKt$filterIsInstance$$inlined$filter$1$2$1 r6 = (kotlinx.coroutines.flow.FlowKt__TransformKt$filterIsInstance$$inlined$filter$1.AnonymousClass2.AnonymousClass1) r6
                java.lang.Object r6 = r0.L$2
                kotlinx.coroutines.flow.FlowKt__TransformKt$filterIsInstance$$inlined$filter$1$2$1 r6 = (kotlinx.coroutines.flow.FlowKt__TransformKt$filterIsInstance$$inlined$filter$1.AnonymousClass2.AnonymousClass1) r6
                java.lang.Object r6 = r0.L$0
                kotlinx.coroutines.flow.FlowKt__TransformKt$filterIsInstance$$inlined$filter$1$2 r6 = (kotlinx.coroutines.flow.FlowKt__TransformKt$filterIsInstance$$inlined$filter$1.AnonymousClass2) r6
                kotlin.d0.n(r7)
                goto L6f
            L39:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r7)
                throw r6
            L41:
                kotlin.d0.n(r7)
                kotlinx.coroutines.flow.i r7 = r5.f59883a
                r2 = 3
                java.lang.String r4 = "R"
                kotlin.jvm.internal.f0.y(r2, r4)
                boolean r2 = r6 instanceof java.lang.Object
                java.lang.Boolean r2 = kotlin.coroutines.jvm.internal.a.a(r2)
                boolean r2 = r2.booleanValue()
                if (r2 == 0) goto L72
                r0.L$0 = r5
                r0.L$1 = r6
                r0.L$2 = r0
                r0.L$3 = r6
                r0.L$4 = r0
                r0.L$5 = r6
                r0.L$6 = r7
                r0.label = r3
                java.lang.Object r6 = r7.emit(r6, r0)
                if (r6 != r1) goto L6f
                return r1
            L6f:
                kotlin.f1 r6 = kotlin.f1.f55527a
                goto L74
            L72:
                kotlin.f1 r6 = kotlin.f1.f55527a
            L74:
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__TransformKt$filterIsInstance$$inlined$filter$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.c):java.lang.Object");
        }
    }

    public FlowKt__TransformKt$filterIsInstance$$inlined$filter$1(h hVar) {
        this.f59882a = hVar;
    }

    @Override // kotlinx.coroutines.flow.h
    @Nullable
    public Object e(@NotNull i<? super Object> iVar, @NotNull kotlin.coroutines.c cVar) {
        Object h4;
        h hVar = this.f59882a;
        kotlin.jvm.internal.f0.w();
        Object e4 = hVar.e(new AnonymousClass2(iVar, this), cVar);
        h4 = kotlin.coroutines.intrinsics.b.h();
        return e4 == h4 ? e4 : f1.f55527a;
    }

    @Nullable
    public Object g(@NotNull i iVar, @NotNull kotlin.coroutines.c cVar) {
        kotlin.jvm.internal.c0.e(4);
        new ContinuationImpl(cVar) { // from class: kotlinx.coroutines.flow.FlowKt__TransformKt$filterIsInstance$$inlined$filter$1.1
            int label;
            /* synthetic */ Object result;

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                this.result = obj;
                this.label |= Integer.MIN_VALUE;
                return FlowKt__TransformKt$filterIsInstance$$inlined$filter$1.this.e(null, this);
            }
        };
        kotlin.jvm.internal.c0.e(5);
        h hVar = this.f59882a;
        kotlin.jvm.internal.f0.w();
        AnonymousClass2 anonymousClass2 = new AnonymousClass2(iVar, this);
        kotlin.jvm.internal.c0.e(0);
        hVar.e(anonymousClass2, cVar);
        kotlin.jvm.internal.c0.e(2);
        kotlin.jvm.internal.c0.e(1);
        return f1.f55527a;
    }
}

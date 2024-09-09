package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.d0;
import kotlin.f1;
import kotlinx.coroutines.channels.b0;
import kotlinx.coroutines.e2;
import kotlinx.coroutines.q0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: Collect.kt */
@Metadata(bv = {}, d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/i;", "value", "Lkotlin/f1;", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/c;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class ChannelFlowMerge$collectTo$$inlined$collect$1<T> implements kotlinx.coroutines.flow.i<kotlinx.coroutines.flow.h<? extends T>> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ e2 f60035a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ kotlinx.coroutines.sync.e f60036b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ b0 f60037c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ t f60038d;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    @Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0001\u001a\u00028\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0096@\u00a8\u0006\u0006"}, d2 = {"T", "value", "Lkotlin/coroutines/c;", "Lkotlin/f1;", "continuation", "", "kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3$emit$1", "emit"}, k = 3, mv = {1, 4, 0})
    @DebugMetadata(c = "kotlinx.coroutines.flow.internal.ChannelFlowMerge$collectTo$$inlined$collect$1", f = "Merge.kt", i = {0, 0, 0, 0}, l = {134}, m = "emit", n = {"this", "value", "continuation", "inner"}, s = {"L$0", "L$1", "L$2", "L$3"})
    /* renamed from: kotlinx.coroutines.flow.internal.ChannelFlowMerge$collectTo$$inlined$collect$1$1  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
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
            return ChannelFlowMerge$collectTo$$inlined$collect$1.this.emit(null, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Merge.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0006\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0005"}, d2 = {"T", "Lkotlinx/coroutines/q0;", "Lkotlin/f1;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx/coroutines/flow/internal/ChannelFlowMerge$collectTo$2$1", "<anonymous>"}, k = 3, mv = {1, 4, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a extends SuspendLambda implements d2.p<q0, kotlin.coroutines.c<? super f1>, Object> {

        /* renamed from: a  reason: collision with root package name */
        private q0 f60039a;

        /* renamed from: b  reason: collision with root package name */
        Object f60040b;

        /* renamed from: c  reason: collision with root package name */
        int f60041c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.flow.h f60042d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ ChannelFlowMerge$collectTo$$inlined$collect$1 f60043e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(kotlinx.coroutines.flow.h hVar, kotlin.coroutines.c cVar, ChannelFlowMerge$collectTo$$inlined$collect$1 channelFlowMerge$collectTo$$inlined$collect$1) {
            super(2, cVar);
            this.f60042d = hVar;
            this.f60043e = channelFlowMerge$collectTo$$inlined$collect$1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final kotlin.coroutines.c<f1> create(@Nullable Object obj, @NotNull kotlin.coroutines.c<?> cVar) {
            a aVar = new a(this.f60042d, cVar, this.f60043e);
            aVar.f60039a = (q0) obj;
            return aVar;
        }

        @Override // d2.p
        public final Object invoke(q0 q0Var, kotlin.coroutines.c<? super f1> cVar) {
            return ((a) create(q0Var, cVar)).invokeSuspend(f1.f55527a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object h4;
            h4 = kotlin.coroutines.intrinsics.b.h();
            int i4 = this.f60041c;
            try {
                if (i4 == 0) {
                    d0.n(obj);
                    q0 q0Var = this.f60039a;
                    kotlinx.coroutines.flow.h hVar = this.f60042d;
                    t tVar = this.f60043e.f60038d;
                    this.f60040b = q0Var;
                    this.f60041c = 1;
                    if (hVar.e(tVar, this) == h4) {
                        return h4;
                    }
                } else if (i4 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    q0 q0Var2 = (q0) this.f60040b;
                    d0.n(obj);
                }
                this.f60043e.f60036b.release();
                return f1.f55527a;
            } catch (Throwable th) {
                this.f60043e.f60036b.release();
                throw th;
            }
        }
    }

    public ChannelFlowMerge$collectTo$$inlined$collect$1(e2 e2Var, kotlinx.coroutines.sync.e eVar, b0 b0Var, t tVar) {
        this.f60035a = e2Var;
        this.f60036b = eVar;
        this.f60037c = b0Var;
        this.f60038d = tVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003d  */
    @Override // kotlinx.coroutines.flow.i
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object emit(java.lang.Object r8, @org.jetbrains.annotations.NotNull kotlin.coroutines.c r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof kotlinx.coroutines.flow.internal.ChannelFlowMerge$collectTo$$inlined$collect$1.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r9
            kotlinx.coroutines.flow.internal.ChannelFlowMerge$collectTo$$inlined$collect$1$1 r0 = (kotlinx.coroutines.flow.internal.ChannelFlowMerge$collectTo$$inlined$collect$1.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.internal.ChannelFlowMerge$collectTo$$inlined$collect$1$1 r0 = new kotlinx.coroutines.flow.internal.ChannelFlowMerge$collectTo$$inlined$collect$1$1
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.a.h()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3d
            if (r2 != r3) goto L35
            java.lang.Object r8 = r0.L$3
            kotlinx.coroutines.flow.h r8 = (kotlinx.coroutines.flow.h) r8
            java.lang.Object r1 = r0.L$2
            kotlin.coroutines.c r1 = (kotlin.coroutines.c) r1
            java.lang.Object r0 = r0.L$0
            kotlinx.coroutines.flow.internal.ChannelFlowMerge$collectTo$$inlined$collect$1 r0 = (kotlinx.coroutines.flow.internal.ChannelFlowMerge$collectTo$$inlined$collect$1) r0
            kotlin.d0.n(r9)
            goto L5f
        L35:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L3d:
            kotlin.d0.n(r9)
            r9 = r8
            kotlinx.coroutines.flow.h r9 = (kotlinx.coroutines.flow.h) r9
            kotlinx.coroutines.e2 r2 = r7.f60035a
            if (r2 == 0) goto L4a
            kotlinx.coroutines.h2.B(r2)
        L4a:
            kotlinx.coroutines.sync.e r2 = r7.f60036b
            r0.L$0 = r7
            r0.L$1 = r8
            r0.L$2 = r0
            r0.L$3 = r9
            r0.label = r3
            java.lang.Object r8 = r2.c(r0)
            if (r8 != r1) goto L5d
            return r1
        L5d:
            r0 = r7
            r8 = r9
        L5f:
            kotlinx.coroutines.channels.b0 r1 = r0.f60037c
            r2 = 0
            r3 = 0
            kotlinx.coroutines.flow.internal.ChannelFlowMerge$collectTo$$inlined$collect$1$a r4 = new kotlinx.coroutines.flow.internal.ChannelFlowMerge$collectTo$$inlined$collect$1$a
            r9 = 0
            r4.<init>(r8, r9, r0)
            r5 = 3
            r6 = 0
            kotlinx.coroutines.h.f(r1, r2, r3, r4, r5, r6)
            kotlin.f1 r8 = kotlin.f1.f55527a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.internal.ChannelFlowMerge$collectTo$$inlined$collect$1.emit(java.lang.Object, kotlin.coroutines.c):java.lang.Object");
    }
}

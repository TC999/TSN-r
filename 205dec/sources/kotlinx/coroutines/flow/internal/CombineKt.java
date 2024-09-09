package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.d0;
import kotlin.f1;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.channels.b0;
import kotlinx.coroutines.channels.h0;
import kotlinx.coroutines.q0;
import kotlinx.coroutines.r0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: Combine.kt */
@Metadata(bv = {}, d1 = {"\u00008\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0092\u0001\u0010\u000e\u001a\u00020\n\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00022\u0014\u0010\u0005\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00028\u00010\u00040\u00032\u0016\u0010\u0007\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00018\u0001\u0018\u00010\u00030\u000629\u0010\r\u001a5\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\b\u00a2\u0006\u0002\b\fH\u0081@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000e\u0010\u000f\u001ap\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00020\u0004\"\u0004\b\u0000\u0010\u0010\"\u0004\b\u0001\u0010\u0011\"\u0004\b\u0002\u0010\u00002\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00010\u00042(\u0010\r\u001a$\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\bH\u0000\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0014\u0010\u0015*\u001c\b\u0002\u0010\u0017\"\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u00162\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0016\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0018"}, d2 = {"R", "T", "Lkotlinx/coroutines/flow/i;", "", "Lkotlinx/coroutines/flow/h;", "flows", "Lkotlin/Function0;", "arrayFactory", "Lkotlin/Function3;", "Lkotlin/coroutines/c;", "Lkotlin/f1;", "", "Lkotlin/ExtensionFunctionType;", "transform", "a", "(Lkotlinx/coroutines/flow/i;[Lkotlinx/coroutines/flow/h;Ld2/a;Ld2/q;Lkotlin/coroutines/c;)Ljava/lang/Object;", "T1", "T2", "flow", "flow2", "b", "(Lkotlinx/coroutines/flow/h;Lkotlinx/coroutines/flow/h;Ld2/q;)Lkotlinx/coroutines/flow/h;", "Lkotlin/collections/o0;", "Update", "kotlinx-coroutines-core"}, k = 2, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class CombineKt {

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: SafeCollector.common.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J!\u0010\u0005\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0005\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0007\u00b8\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/h;", "Lkotlinx/coroutines/flow/i;", "collector", "Lkotlin/f1;", "e", "(Lkotlinx/coroutines/flow/i;Lkotlin/coroutines/c;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a<R> implements kotlinx.coroutines.flow.h<R> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.flow.h f60061a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.flow.h f60062b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ d2.q f60063c;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
        /* compiled from: Combine.kt */
        @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\b\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0002*\u00020\u0003H\u008a@\u00a2\u0006\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"T1", "T2", "R", "Lkotlinx/coroutines/q0;", "Lkotlin/f1;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx/coroutines/flow/internal/CombineKt$zipImpl$1$1", "<anonymous>"}, k = 3, mv = {1, 4, 0})
        /* renamed from: kotlinx.coroutines.flow.internal.CombineKt$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public static final class C1210a extends SuspendLambda implements d2.p<q0, kotlin.coroutines.c<? super f1>, Object> {

            /* renamed from: a  reason: collision with root package name */
            private q0 f60064a;

            /* renamed from: b  reason: collision with root package name */
            Object f60065b;

            /* renamed from: c  reason: collision with root package name */
            Object f60066c;

            /* renamed from: d  reason: collision with root package name */
            Object f60067d;

            /* renamed from: e  reason: collision with root package name */
            Object f60068e;

            /* renamed from: f  reason: collision with root package name */
            Object f60069f;

            /* renamed from: g  reason: collision with root package name */
            int f60070g;

            /* renamed from: h  reason: collision with root package name */
            final /* synthetic */ kotlinx.coroutines.flow.i f60071h;

            /* renamed from: i  reason: collision with root package name */
            final /* synthetic */ a f60072i;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
            /* compiled from: Combine.kt */
            @Metadata(bv = {}, d1 = {"\u0000\u0014\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\t\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0002*\b\u0012\u0004\u0012\u00020\u00040\u0003H\u008a@\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"T1", "T2", "R", "Lkotlinx/coroutines/channels/b0;", "", "Lkotlin/f1;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx/coroutines/flow/internal/CombineKt$zipImpl$1$1$second$1", "<anonymous>"}, k = 3, mv = {1, 4, 0})
            /* renamed from: kotlinx.coroutines.flow.internal.CombineKt$a$a$a  reason: collision with other inner class name */
            /* loaded from: E:\TSN-r\205dec\7343912.dex */
            public static final class C1211a extends SuspendLambda implements d2.p<b0<? super Object>, kotlin.coroutines.c<? super f1>, Object> {

                /* renamed from: a  reason: collision with root package name */
                private b0 f60073a;

                /* renamed from: b  reason: collision with root package name */
                Object f60074b;

                /* renamed from: c  reason: collision with root package name */
                Object f60075c;

                /* renamed from: d  reason: collision with root package name */
                int f60076d;

                /* JADX INFO: Add missing generic type declarations: [T2] */
                /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
                /* compiled from: Collect.kt */
                @Metadata(bv = {}, d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\u0007"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/i;", "value", "Lkotlin/f1;", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/c;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/internal/CombineKt$zipImpl$1$1$second$1$invokeSuspend$$inlined$collect$1"}, k = 1, mv = {1, 4, 0})
                /* renamed from: kotlinx.coroutines.flow.internal.CombineKt$a$a$a$a  reason: collision with other inner class name */
                /* loaded from: E:\TSN-r\205dec\7343912.dex */
                public static final class C1212a<T2> implements kotlinx.coroutines.flow.i<T2> {

                    /* renamed from: a  reason: collision with root package name */
                    final /* synthetic */ b0 f60078a;

                    public C1212a(b0 b0Var) {
                        this.f60078a = b0Var;
                    }

                    @Override // kotlinx.coroutines.flow.i
                    @Nullable
                    public Object emit(Object obj, @NotNull kotlin.coroutines.c cVar) {
                        Object h4;
                        h0 channel = this.f60078a.getChannel();
                        if (obj == null) {
                            obj = r.f60167a;
                        }
                        Object O = channel.O(obj, cVar);
                        h4 = kotlin.coroutines.intrinsics.b.h();
                        return O == h4 ? O : f1.f55527a;
                    }
                }

                C1211a(kotlin.coroutines.c cVar) {
                    super(2, cVar);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @NotNull
                public final kotlin.coroutines.c<f1> create(@Nullable Object obj, @NotNull kotlin.coroutines.c<?> cVar) {
                    C1211a c1211a = new C1211a(cVar);
                    c1211a.f60073a = (b0) obj;
                    return c1211a;
                }

                @Override // d2.p
                public final Object invoke(b0<? super Object> b0Var, kotlin.coroutines.c<? super f1> cVar) {
                    return ((C1211a) create(b0Var, cVar)).invokeSuspend(f1.f55527a);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @Nullable
                public final Object invokeSuspend(@NotNull Object obj) {
                    Object h4;
                    h4 = kotlin.coroutines.intrinsics.b.h();
                    int i4 = this.f60076d;
                    if (i4 == 0) {
                        d0.n(obj);
                        b0 b0Var = this.f60073a;
                        kotlinx.coroutines.flow.h hVar = C1210a.this.f60072i.f60061a;
                        C1212a c1212a = new C1212a(b0Var);
                        this.f60074b = b0Var;
                        this.f60075c = hVar;
                        this.f60076d = 1;
                        if (hVar.e(c1212a, this) == h4) {
                            return h4;
                        }
                    } else if (i4 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        kotlinx.coroutines.flow.h hVar2 = (kotlinx.coroutines.flow.h) this.f60075c;
                        b0 b0Var2 = (b0) this.f60074b;
                        d0.n(obj);
                    }
                    return f1.f55527a;
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
            /* compiled from: Combine.kt */
            @Metadata(bv = {}, d1 = {"\u0000\u0012\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\t\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"T1", "T2", "R", "", "it", "Lkotlin/f1;", "invoke", "(Ljava/lang/Throwable;)V", "kotlinx/coroutines/flow/internal/CombineKt$zipImpl$1$1$1", "<anonymous>"}, k = 3, mv = {1, 4, 0})
            /* renamed from: kotlinx.coroutines.flow.internal.CombineKt$a$a$b */
            /* loaded from: E:\TSN-r\205dec\7343912.dex */
            public static final class b extends Lambda implements d2.l<Throwable, f1> {

                /* renamed from: b  reason: collision with root package name */
                final /* synthetic */ kotlinx.coroutines.b0 f60080b;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                b(kotlinx.coroutines.b0 b0Var) {
                    super(1);
                    this.f60080b = b0Var;
                }

                @Override // d2.l
                public /* bridge */ /* synthetic */ f1 invoke(Throwable th) {
                    invoke2(th);
                    return f1.f55527a;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(@Nullable Throwable th) {
                    if (this.f60080b.isActive()) {
                        this.f60080b.b(new AbortFlowException(C1210a.this.f60071h));
                    }
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
            /* compiled from: Combine.kt */
            @Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0010\b\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u008a@\u00a2\u0006\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"T1", "T2", "R", "Lkotlin/f1;", "it", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx/coroutines/flow/internal/CombineKt$zipImpl$1$1$2", "<anonymous>"}, k = 3, mv = {1, 4, 0})
            /* renamed from: kotlinx.coroutines.flow.internal.CombineKt$a$a$c */
            /* loaded from: E:\TSN-r\205dec\7343912.dex */
            public static final class c extends SuspendLambda implements d2.p<f1, kotlin.coroutines.c<? super f1>, Object> {

                /* renamed from: a  reason: collision with root package name */
                private f1 f60081a;

                /* renamed from: b  reason: collision with root package name */
                Object f60082b;

                /* renamed from: c  reason: collision with root package name */
                Object f60083c;

                /* renamed from: d  reason: collision with root package name */
                int f60084d;

                /* renamed from: f  reason: collision with root package name */
                final /* synthetic */ kotlin.coroutines.f f60086f;

                /* renamed from: g  reason: collision with root package name */
                final /* synthetic */ Object f60087g;

                /* renamed from: h  reason: collision with root package name */
                final /* synthetic */ kotlinx.coroutines.channels.d0 f60088h;

                /* JADX INFO: Add missing generic type declarations: [T1] */
                /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
                /* compiled from: Collect.kt */
                @Metadata(bv = {}, d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\u0007"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/i;", "value", "Lkotlin/f1;", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/c;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/internal/CombineKt$zipImpl$1$1$2$invokeSuspend$$inlined$collect$1"}, k = 1, mv = {1, 4, 0})
                /* renamed from: kotlinx.coroutines.flow.internal.CombineKt$a$a$c$a  reason: collision with other inner class name */
                /* loaded from: E:\TSN-r\205dec\7343912.dex */
                public static final class C1213a<T1> implements kotlinx.coroutines.flow.i<T1> {

                    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
                    /* compiled from: Combine.kt */
                    @Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0010\b\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u008a@\u00a2\u0006\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"T1", "T2", "R", "Lkotlin/f1;", "it", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx/coroutines/flow/internal/CombineKt$zipImpl$1$1$2$invokeSuspend$$inlined$collect$1$lambda$1", "<anonymous>"}, k = 3, mv = {1, 4, 0})
                    /* renamed from: kotlinx.coroutines.flow.internal.CombineKt$a$a$c$a$a  reason: collision with other inner class name */
                    /* loaded from: E:\TSN-r\205dec\7343912.dex */
                    static final class C1214a extends SuspendLambda implements d2.p<f1, kotlin.coroutines.c<? super f1>, Object> {

                        /* renamed from: a  reason: collision with root package name */
                        private f1 f60090a;

                        /* renamed from: b  reason: collision with root package name */
                        Object f60091b;

                        /* renamed from: c  reason: collision with root package name */
                        Object f60092c;

                        /* renamed from: d  reason: collision with root package name */
                        Object f60093d;

                        /* renamed from: e  reason: collision with root package name */
                        int f60094e;

                        /* renamed from: f  reason: collision with root package name */
                        final /* synthetic */ Object f60095f;

                        /* renamed from: g  reason: collision with root package name */
                        final /* synthetic */ C1213a f60096g;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        C1214a(Object obj, kotlin.coroutines.c cVar, C1213a c1213a) {
                            super(2, cVar);
                            this.f60095f = obj;
                            this.f60096g = c1213a;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        @NotNull
                        public final kotlin.coroutines.c<f1> create(@Nullable Object obj, @NotNull kotlin.coroutines.c<?> cVar) {
                            C1214a c1214a = new C1214a(this.f60095f, cVar, this.f60096g);
                            c1214a.f60090a = (f1) obj;
                            return c1214a;
                        }

                        @Override // d2.p
                        public final Object invoke(f1 f1Var, kotlin.coroutines.c<? super f1> cVar) {
                            return ((C1214a) create(f1Var, cVar)).invokeSuspend(f1.f55527a);
                        }

                        /* JADX WARN: Removed duplicated region for block: B:27:0x0094 A[RETURN] */
                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        @org.jetbrains.annotations.Nullable
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                            To view partially-correct code enable 'Show inconsistent code' option in preferences
                        */
                        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r9) {
                            /*
                                r8 = this;
                                java.lang.Object r0 = kotlin.coroutines.intrinsics.a.h()
                                int r1 = r8.f60094e
                                r2 = 3
                                r3 = 2
                                r4 = 1
                                if (r1 == 0) goto L39
                                if (r1 == r4) goto L30
                                if (r1 == r3) goto L22
                                if (r1 != r2) goto L1a
                                java.lang.Object r0 = r8.f60091b
                                kotlin.f1 r0 = (kotlin.f1) r0
                                kotlin.d0.n(r9)
                                goto L95
                            L1a:
                                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                                r9.<init>(r0)
                                throw r9
                            L22:
                                java.lang.Object r1 = r8.f60093d
                                kotlinx.coroutines.flow.i r1 = (kotlinx.coroutines.flow.i) r1
                                java.lang.Object r3 = r8.f60092c
                                java.lang.Object r4 = r8.f60091b
                                kotlin.f1 r4 = (kotlin.f1) r4
                                kotlin.d0.n(r9)
                                goto L88
                            L30:
                                java.lang.Object r1 = r8.f60091b
                                kotlin.f1 r1 = (kotlin.f1) r1
                                kotlin.d0.n(r9)
                                r4 = r1
                                goto L51
                            L39:
                                kotlin.d0.n(r9)
                                kotlin.f1 r9 = r8.f60090a
                                kotlinx.coroutines.flow.internal.CombineKt$a$a$c$a r1 = r8.f60096g
                                kotlinx.coroutines.flow.internal.CombineKt$a$a$c r1 = kotlinx.coroutines.flow.internal.CombineKt.a.C1210a.c.this
                                kotlinx.coroutines.channels.d0 r1 = r1.f60088h
                                r8.f60091b = r9
                                r8.f60094e = r4
                                java.lang.Object r1 = kotlinx.coroutines.channels.r.F1(r1, r8)
                                if (r1 != r0) goto L4f
                                return r0
                            L4f:
                                r4 = r9
                                r9 = r1
                            L51:
                                if (r9 == 0) goto L98
                                kotlinx.coroutines.flow.internal.CombineKt$a$a$c$a r1 = r8.f60096g
                                kotlinx.coroutines.flow.internal.CombineKt$a$a$c r1 = kotlinx.coroutines.flow.internal.CombineKt.a.C1210a.c.this
                                kotlinx.coroutines.flow.internal.CombineKt$a$a r1 = kotlinx.coroutines.flow.internal.CombineKt.a.C1210a.this
                                kotlinx.coroutines.flow.i r5 = r1.f60071h
                                kotlinx.coroutines.flow.internal.CombineKt$a r1 = r1.f60072i
                                d2.q r1 = r1.f60063c
                                java.lang.Object r6 = r8.f60095f
                                kotlinx.coroutines.internal.j0 r7 = kotlinx.coroutines.flow.internal.r.f60167a
                                if (r9 != r7) goto L67
                                r7 = 0
                                goto L68
                            L67:
                                r7 = r9
                            L68:
                                r8.f60091b = r4
                                r8.f60092c = r9
                                r8.f60093d = r5
                                r8.f60094e = r3
                                r3 = 6
                                kotlin.jvm.internal.c0.e(r3)
                                kotlin.jvm.internal.c0.e(r3)
                                java.lang.Object r1 = r1.invoke(r6, r7, r8)
                                r3 = 7
                                kotlin.jvm.internal.c0.e(r3)
                                kotlin.jvm.internal.c0.e(r3)
                                if (r1 != r0) goto L85
                                return r0
                            L85:
                                r3 = r9
                                r9 = r1
                                r1 = r5
                            L88:
                                r8.f60091b = r4
                                r8.f60092c = r3
                                r8.f60094e = r2
                                java.lang.Object r9 = r1.emit(r9, r8)
                                if (r9 != r0) goto L95
                                return r0
                            L95:
                                kotlin.f1 r9 = kotlin.f1.f55527a
                                return r9
                            L98:
                                kotlinx.coroutines.flow.internal.AbortFlowException r9 = new kotlinx.coroutines.flow.internal.AbortFlowException
                                kotlinx.coroutines.flow.internal.CombineKt$a$a$c$a r0 = r8.f60096g
                                kotlinx.coroutines.flow.internal.CombineKt$a$a$c r0 = kotlinx.coroutines.flow.internal.CombineKt.a.C1210a.c.this
                                kotlinx.coroutines.flow.internal.CombineKt$a$a r0 = kotlinx.coroutines.flow.internal.CombineKt.a.C1210a.this
                                kotlinx.coroutines.flow.i r0 = r0.f60071h
                                r9.<init>(r0)
                                throw r9
                            */
                            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.internal.CombineKt.a.C1210a.c.C1213a.C1214a.invokeSuspend(java.lang.Object):java.lang.Object");
                        }
                    }

                    public C1213a() {
                    }

                    @Override // kotlinx.coroutines.flow.i
                    @Nullable
                    public Object emit(Object obj, @NotNull kotlin.coroutines.c cVar) {
                        Object h4;
                        c cVar2 = c.this;
                        kotlin.coroutines.f fVar = cVar2.f60086f;
                        f1 f1Var = f1.f55527a;
                        Object c4 = f.c(fVar, f1Var, cVar2.f60087g, new C1214a(obj, null, this), cVar);
                        h4 = kotlin.coroutines.intrinsics.b.h();
                        return c4 == h4 ? c4 : f1Var;
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                c(kotlin.coroutines.f fVar, Object obj, kotlinx.coroutines.channels.d0 d0Var, kotlin.coroutines.c cVar) {
                    super(2, cVar);
                    this.f60086f = fVar;
                    this.f60087g = obj;
                    this.f60088h = d0Var;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @NotNull
                public final kotlin.coroutines.c<f1> create(@Nullable Object obj, @NotNull kotlin.coroutines.c<?> cVar) {
                    c cVar2 = new c(this.f60086f, this.f60087g, this.f60088h, cVar);
                    cVar2.f60081a = (f1) obj;
                    return cVar2;
                }

                @Override // d2.p
                public final Object invoke(f1 f1Var, kotlin.coroutines.c<? super f1> cVar) {
                    return ((c) create(f1Var, cVar)).invokeSuspend(f1.f55527a);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @Nullable
                public final Object invokeSuspend(@NotNull Object obj) {
                    Object h4;
                    h4 = kotlin.coroutines.intrinsics.b.h();
                    int i4 = this.f60084d;
                    if (i4 == 0) {
                        d0.n(obj);
                        f1 f1Var = this.f60081a;
                        kotlinx.coroutines.flow.h hVar = C1210a.this.f60072i.f60062b;
                        C1213a c1213a = new C1213a();
                        this.f60082b = f1Var;
                        this.f60083c = hVar;
                        this.f60084d = 1;
                        if (hVar.e(c1213a, this) == h4) {
                            return h4;
                        }
                    } else if (i4 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        kotlinx.coroutines.flow.h hVar2 = (kotlinx.coroutines.flow.h) this.f60083c;
                        f1 f1Var2 = (f1) this.f60082b;
                        d0.n(obj);
                    }
                    return f1.f55527a;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C1210a(kotlinx.coroutines.flow.i iVar, kotlin.coroutines.c cVar, a aVar) {
                super(2, cVar);
                this.f60071h = iVar;
                this.f60072i = aVar;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final kotlin.coroutines.c<f1> create(@Nullable Object obj, @NotNull kotlin.coroutines.c<?> cVar) {
                C1210a c1210a = new C1210a(this.f60071h, cVar, this.f60072i);
                c1210a.f60064a = (q0) obj;
                return c1210a;
            }

            @Override // d2.p
            public final Object invoke(q0 q0Var, kotlin.coroutines.c<? super f1> cVar) {
                return ((C1210a) create(q0Var, cVar)).invokeSuspend(f1.f55527a);
            }

            /* JADX WARN: Code restructure failed: missing block: B:22:0x009d, code lost:
                if (r1.g() == false) goto L10;
             */
            /* JADX WARN: Code restructure failed: missing block: B:23:0x009f, code lost:
                kotlinx.coroutines.channels.d0.a.b(r1, null, 1, null);
             */
            /* JADX WARN: Code restructure failed: missing block: B:30:0x00b1, code lost:
                if (r1.g() == false) goto L10;
             */
            /* JADX WARN: Code restructure failed: missing block: B:33:0x00b6, code lost:
                return kotlin.f1.f55527a;
             */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r1v0, types: [int] */
            /* JADX WARN: Type inference failed for: r1v1, types: [kotlinx.coroutines.channels.d0] */
            /* JADX WARN: Type inference failed for: r1v5 */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @org.jetbrains.annotations.Nullable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r21) {
                /*
                    Method dump skipped, instructions count: 203
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.internal.CombineKt.a.C1210a.invokeSuspend(java.lang.Object):java.lang.Object");
            }
        }

        public a(kotlinx.coroutines.flow.h hVar, kotlinx.coroutines.flow.h hVar2, d2.q qVar) {
            this.f60061a = hVar;
            this.f60062b = hVar2;
            this.f60063c = qVar;
        }

        @Override // kotlinx.coroutines.flow.h
        @Nullable
        public Object e(@NotNull kotlinx.coroutines.flow.i iVar, @NotNull kotlin.coroutines.c cVar) {
            Object h4;
            Object g4 = r0.g(new C1210a(iVar, null, this), cVar);
            h4 = kotlin.coroutines.intrinsics.b.h();
            return g4 == h4 ? g4 : f1.f55527a;
        }
    }

    @PublishedApi
    @Nullable
    public static final <R, T> Object a(@NotNull kotlinx.coroutines.flow.i<? super R> iVar, @NotNull kotlinx.coroutines.flow.h<? extends T>[] hVarArr, @NotNull d2.a<T[]> aVar, @NotNull d2.q<? super kotlinx.coroutines.flow.i<? super R>, ? super T[], ? super kotlin.coroutines.c<? super f1>, ? extends Object> qVar, @NotNull kotlin.coroutines.c<? super f1> cVar) {
        Object h4;
        Object c4 = l.c(new CombineKt$combineInternal$2(iVar, hVarArr, aVar, qVar, null), cVar);
        h4 = kotlin.coroutines.intrinsics.b.h();
        return c4 == h4 ? c4 : f1.f55527a;
    }

    @NotNull
    public static final <T1, T2, R> kotlinx.coroutines.flow.h<R> b(@NotNull kotlinx.coroutines.flow.h<? extends T1> hVar, @NotNull kotlinx.coroutines.flow.h<? extends T2> hVar2, @NotNull d2.q<? super T1, ? super T2, ? super kotlin.coroutines.c<? super R>, ? extends Object> qVar) {
        return new a(hVar2, hVar, qVar);
    }
}

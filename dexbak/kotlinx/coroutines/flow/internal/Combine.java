package kotlinx.coroutines.flow.internal;

import androidx.exifinterface.media.ExifInterface;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import kotlin.C14294d0;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.InterfaceC14268c;
import kotlin.coroutines.intrinsics.C14287b;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.C15162r0;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.InterfaceC14686b0;
import kotlinx.coroutines.channels.InterfaceC14695d0;
import kotlinx.coroutines.channels.InterfaceC14704h0;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.InterfaceC14958h;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15269a;
import p617l1.InterfaceC15280l;
import p617l1.InterfaceC15284p;
import p617l1.InterfaceC15285q;

@Metadata(m12618bv = {}, m12617d1 = {"\u00008\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0092\u0001\u0010\u000e\u001a\u00020\n\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00022\u0014\u0010\u0005\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00028\u00010\u00040\u00032\u0016\u0010\u0007\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00018\u0001\u0018\u00010\u00030\u000629\u0010\r\u001a5\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\b¢\u0006\u0002\b\fH\u0081@ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001ap\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00020\u0004\"\u0004\b\u0000\u0010\u0010\"\u0004\b\u0001\u0010\u0011\"\u0004\b\u0002\u0010\u00002\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00010\u00042(\u0010\r\u001a$\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\bH\u0000ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015*\u001c\b\u0002\u0010\u0017\"\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u00162\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0016\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0018"}, m12616d2 = {"R", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/i;", "", "Lkotlinx/coroutines/flow/h;", "flows", "Lkotlin/Function0;", "arrayFactory", "Lkotlin/Function3;", "Lkotlin/coroutines/c;", "Lkotlin/f1;", "", "Lkotlin/ExtensionFunctionType;", "transform", "a", "(Lkotlinx/coroutines/flow/i;[Lkotlinx/coroutines/flow/h;Ll1/a;Ll1/q;Lkotlin/coroutines/c;)Ljava/lang/Object;", "T1", "T2", "flow", "flow2", "b", "(Lkotlinx/coroutines/flow/h;Lkotlinx/coroutines/flow/h;Ll1/q;)Lkotlinx/coroutines/flow/h;", "Lkotlin/collections/n0;", "Update", "kotlinx-coroutines-core"}, m12615k = 2, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.flow.internal.CombineKt */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class Combine {

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* compiled from: SafeCollector.common.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J!\u0010\u0005\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\u0000"}, m12616d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/h;", "Lkotlinx/coroutines/flow/i;", "collector", "Lkotlin/f1;", "e", "(Lkotlinx/coroutines/flow/i;Lkotlin/coroutines/c;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.flow.internal.CombineKt$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14966a<R> implements InterfaceC14958h<R> {

        /* renamed from: a */
        final /* synthetic */ InterfaceC14958h f42743a;

        /* renamed from: b */
        final /* synthetic */ InterfaceC14958h f42744b;

        /* renamed from: c */
        final /* synthetic */ InterfaceC15285q f42745c;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: Combine.kt */
        @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0010\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\b\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0002*\u00020\u0003H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, m12616d2 = {"T1", "T2", "R", "Lkotlinx/coroutines/q0;", "Lkotlin/f1;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx/coroutines/flow/internal/CombineKt$zipImpl$1$1", "<anonymous>"}, m12615k = 3, m12614mv = {1, 4, 0})
        /* renamed from: kotlinx.coroutines.flow.internal.CombineKt$a$a */
        /* loaded from: E:\fuckcool\tsn\5406560.dex */
        public static final class C14967a extends SuspendLambda implements InterfaceC15284p<CoroutineScope, InterfaceC14268c<? super Unit>, Object> {

            /* renamed from: a */
            private CoroutineScope f42746a;

            /* renamed from: b */
            Object f42747b;

            /* renamed from: c */
            Object f42748c;

            /* renamed from: d */
            Object f42749d;

            /* renamed from: e */
            Object f42750e;

            /* renamed from: f */
            Object f42751f;

            /* renamed from: g */
            int f42752g;

            /* renamed from: h */
            final /* synthetic */ FlowCollector f42753h;

            /* renamed from: i */
            final /* synthetic */ C14966a f42754i;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* compiled from: Combine.kt */
            @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0014\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\t\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0002*\b\u0012\u0004\u0012\u00020\u00040\u0003H\u008a@¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, m12616d2 = {"T1", "T2", "R", "Lkotlinx/coroutines/channels/b0;", "", "Lkotlin/f1;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx/coroutines/flow/internal/CombineKt$zipImpl$1$1$second$1", "<anonymous>"}, m12615k = 3, m12614mv = {1, 4, 0})
            /* renamed from: kotlinx.coroutines.flow.internal.CombineKt$a$a$a */
            /* loaded from: E:\fuckcool\tsn\5406560.dex */
            public static final class C14968a extends SuspendLambda implements InterfaceC15284p<InterfaceC14686b0<? super Object>, InterfaceC14268c<? super Unit>, Object> {

                /* renamed from: a */
                private InterfaceC14686b0 f42755a;

                /* renamed from: b */
                Object f42756b;

                /* renamed from: c */
                Object f42757c;

                /* renamed from: d */
                int f42758d;

                /* JADX INFO: Add missing generic type declarations: [T2] */
                /* compiled from: Collect.kt */
                @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006¸\u0006\u0007"}, m12616d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/i;", DomainCampaignEx.LOOPBACK_VALUE, "Lkotlin/f1;", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/c;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/internal/CombineKt$zipImpl$1$1$second$1$invokeSuspend$$inlined$collect$1"}, m12615k = 1, m12614mv = {1, 4, 0})
                /* renamed from: kotlinx.coroutines.flow.internal.CombineKt$a$a$a$a */
                /* loaded from: E:\fuckcool\tsn\5406560.dex */
                public static final class C14969a<T2> implements FlowCollector<T2> {

                    /* renamed from: a */
                    final /* synthetic */ InterfaceC14686b0 f42760a;

                    public C14969a(InterfaceC14686b0 interfaceC14686b0) {
                        this.f42760a = interfaceC14686b0;
                    }

                    @Override // kotlinx.coroutines.flow.FlowCollector
                    @Nullable
                    public Object emit(Object obj, @NotNull InterfaceC14268c interfaceC14268c) {
                        Object m8642h;
                        InterfaceC14704h0 channel = this.f42760a.getChannel();
                        if (obj == null) {
                            obj = NullSurrogate.f42850a;
                        }
                        Object mo5177P = channel.mo5177P(obj, interfaceC14268c);
                        m8642h = C14287b.m8642h();
                        return mo5177P == m8642h ? mo5177P : Unit.f41048a;
                    }
                }

                C14968a(InterfaceC14268c interfaceC14268c) {
                    super(2, interfaceC14268c);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @NotNull
                public final InterfaceC14268c<Unit> create(@Nullable Object obj, @NotNull InterfaceC14268c<?> interfaceC14268c) {
                    C14968a c14968a = new C14968a(interfaceC14268c);
                    c14968a.f42755a = (InterfaceC14686b0) obj;
                    return c14968a;
                }

                @Override // p617l1.InterfaceC15284p
                public final Object invoke(InterfaceC14686b0<? super Object> interfaceC14686b0, InterfaceC14268c<? super Unit> interfaceC14268c) {
                    return ((C14968a) create(interfaceC14686b0, interfaceC14268c)).invokeSuspend(Unit.f41048a);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @Nullable
                public final Object invokeSuspend(@NotNull Object obj) {
                    Object m8642h;
                    m8642h = C14287b.m8642h();
                    int i = this.f42758d;
                    if (i == 0) {
                        C14294d0.m8596n(obj);
                        InterfaceC14686b0 interfaceC14686b0 = this.f42755a;
                        InterfaceC14958h interfaceC14958h = C14967a.this.f42754i.f42743a;
                        C14969a c14969a = new C14969a(interfaceC14686b0);
                        this.f42756b = interfaceC14686b0;
                        this.f42757c = interfaceC14958h;
                        this.f42758d = 1;
                        if (interfaceC14958h.mo4470e(c14969a, this) == m8642h) {
                            return m8642h;
                        }
                    } else if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        InterfaceC14958h interfaceC14958h2 = (InterfaceC14958h) this.f42757c;
                        InterfaceC14686b0 interfaceC14686b02 = (InterfaceC14686b0) this.f42756b;
                        C14294d0.m8596n(obj);
                    }
                    return Unit.f41048a;
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* compiled from: Combine.kt */
            @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0012\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\t\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, m12616d2 = {"T1", "T2", "R", "", "it", "Lkotlin/f1;", "invoke", "(Ljava/lang/Throwable;)V", "kotlinx/coroutines/flow/internal/CombineKt$zipImpl$1$1$1", "<anonymous>"}, m12615k = 3, m12614mv = {1, 4, 0})
            /* renamed from: kotlinx.coroutines.flow.internal.CombineKt$a$a$b */
            /* loaded from: E:\fuckcool\tsn\5406560.dex */
            public static final class C14970b extends Lambda implements InterfaceC15280l<Throwable, Unit> {

                /* renamed from: b */
                final /* synthetic */ CompletableJob f42762b;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C14970b(CompletableJob completableJob) {
                    super(1);
                    this.f42762b = completableJob;
                }

                @Override // p617l1.InterfaceC15280l
                public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                    invoke2(th);
                    return Unit.f41048a;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(@Nullable Throwable th) {
                    if (this.f42762b.isActive()) {
                        this.f42762b.mo3827b(new FlowExceptions(C14967a.this.f42753h));
                    }
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* compiled from: Combine.kt */
            @Metadata(m12618bv = {}, m12617d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0010\b\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, m12616d2 = {"T1", "T2", "R", "Lkotlin/f1;", "it", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx/coroutines/flow/internal/CombineKt$zipImpl$1$1$2", "<anonymous>"}, m12615k = 3, m12614mv = {1, 4, 0})
            /* renamed from: kotlinx.coroutines.flow.internal.CombineKt$a$a$c */
            /* loaded from: E:\fuckcool\tsn\5406560.dex */
            public static final class C14971c extends SuspendLambda implements InterfaceC15284p<Unit, InterfaceC14268c<? super Unit>, Object> {

                /* renamed from: a */
                private Unit f42763a;

                /* renamed from: b */
                Object f42764b;

                /* renamed from: c */
                Object f42765c;

                /* renamed from: d */
                int f42766d;

                /* renamed from: f */
                final /* synthetic */ CoroutineContext f42768f;

                /* renamed from: g */
                final /* synthetic */ Object f42769g;

                /* renamed from: h */
                final /* synthetic */ InterfaceC14695d0 f42770h;

                /* JADX INFO: Add missing generic type declarations: [T1] */
                /* compiled from: Collect.kt */
                @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006¸\u0006\u0007"}, m12616d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/i;", DomainCampaignEx.LOOPBACK_VALUE, "Lkotlin/f1;", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/c;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/internal/CombineKt$zipImpl$1$1$2$invokeSuspend$$inlined$collect$1"}, m12615k = 1, m12614mv = {1, 4, 0})
                /* renamed from: kotlinx.coroutines.flow.internal.CombineKt$a$a$c$a */
                /* loaded from: E:\fuckcool\tsn\5406560.dex */
                public static final class C14972a<T1> implements FlowCollector<T1> {

                    /* compiled from: Combine.kt */
                    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0010\b\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, m12616d2 = {"T1", "T2", "R", "Lkotlin/f1;", "it", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx/coroutines/flow/internal/CombineKt$zipImpl$1$1$2$invokeSuspend$$inlined$collect$1$lambda$1", "<anonymous>"}, m12615k = 3, m12614mv = {1, 4, 0})
                    /* renamed from: kotlinx.coroutines.flow.internal.CombineKt$a$a$c$a$a */
                    /* loaded from: E:\fuckcool\tsn\5406560.dex */
                    static final class C14973a extends SuspendLambda implements InterfaceC15284p<Unit, InterfaceC14268c<? super Unit>, Object> {

                        /* renamed from: a */
                        private Unit f42772a;

                        /* renamed from: b */
                        Object f42773b;

                        /* renamed from: c */
                        Object f42774c;

                        /* renamed from: d */
                        Object f42775d;

                        /* renamed from: e */
                        int f42776e;

                        /* renamed from: f */
                        final /* synthetic */ Object f42777f;

                        /* renamed from: g */
                        final /* synthetic */ C14972a f42778g;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        C14973a(Object obj, InterfaceC14268c interfaceC14268c, C14972a c14972a) {
                            super(2, interfaceC14268c);
                            this.f42777f = obj;
                            this.f42778g = c14972a;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        @NotNull
                        public final InterfaceC14268c<Unit> create(@Nullable Object obj, @NotNull InterfaceC14268c<?> interfaceC14268c) {
                            C14973a c14973a = new C14973a(this.f42777f, interfaceC14268c, this.f42778g);
                            c14973a.f42772a = (Unit) obj;
                            return c14973a;
                        }

                        @Override // p617l1.InterfaceC15284p
                        public final Object invoke(Unit unit, InterfaceC14268c<? super Unit> interfaceC14268c) {
                            return ((C14973a) create(unit, interfaceC14268c)).invokeSuspend(Unit.f41048a);
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
                                java.lang.Object r0 = kotlin.coroutines.intrinsics.C14286a.m8643h()
                                int r1 = r8.f42776e
                                r2 = 3
                                r3 = 2
                                r4 = 1
                                if (r1 == 0) goto L39
                                if (r1 == r4) goto L30
                                if (r1 == r3) goto L22
                                if (r1 != r2) goto L1a
                                java.lang.Object r0 = r8.f42773b
                                kotlin.f1 r0 = (kotlin.Unit) r0
                                kotlin.C14294d0.m8596n(r9)
                                goto L95
                            L1a:
                                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                                r9.<init>(r0)
                                throw r9
                            L22:
                                java.lang.Object r1 = r8.f42775d
                                kotlinx.coroutines.flow.i r1 = (kotlinx.coroutines.flow.FlowCollector) r1
                                java.lang.Object r3 = r8.f42774c
                                java.lang.Object r4 = r8.f42773b
                                kotlin.f1 r4 = (kotlin.Unit) r4
                                kotlin.C14294d0.m8596n(r9)
                                goto L88
                            L30:
                                java.lang.Object r1 = r8.f42773b
                                kotlin.f1 r1 = (kotlin.Unit) r1
                                kotlin.C14294d0.m8596n(r9)
                                r4 = r1
                                goto L51
                            L39:
                                kotlin.C14294d0.m8596n(r9)
                                kotlin.f1 r9 = r8.f42772a
                                kotlinx.coroutines.flow.internal.CombineKt$a$a$c$a r1 = r8.f42778g
                                kotlinx.coroutines.flow.internal.CombineKt$a$a$c r1 = kotlinx.coroutines.flow.internal.Combine.C14966a.C14967a.C14971c.this
                                kotlinx.coroutines.channels.d0 r1 = r1.f42770h
                                r8.f42773b = r9
                                r8.f42776e = r4
                                java.lang.Object r1 = kotlinx.coroutines.channels.C14729r.m5364F1(r1, r8)
                                if (r1 != r0) goto L4f
                                return r0
                            L4f:
                                r4 = r9
                                r9 = r1
                            L51:
                                if (r9 == 0) goto L98
                                kotlinx.coroutines.flow.internal.CombineKt$a$a$c$a r1 = r8.f42778g
                                kotlinx.coroutines.flow.internal.CombineKt$a$a$c r1 = kotlinx.coroutines.flow.internal.Combine.C14966a.C14967a.C14971c.this
                                kotlinx.coroutines.flow.internal.CombineKt$a$a r1 = kotlinx.coroutines.flow.internal.Combine.C14966a.C14967a.this
                                kotlinx.coroutines.flow.i r5 = r1.f42753h
                                kotlinx.coroutines.flow.internal.CombineKt$a r1 = r1.f42754i
                                l1.q r1 = r1.f42745c
                                java.lang.Object r6 = r8.f42777f
                                kotlinx.coroutines.internal.j0 r7 = kotlinx.coroutines.flow.internal.NullSurrogate.f42850a
                                if (r9 != r7) goto L67
                                r7 = 0
                                goto L68
                            L67:
                                r7 = r9
                            L68:
                                r8.f42773b = r4
                                r8.f42774c = r9
                                r8.f42775d = r5
                                r8.f42776e = r3
                                r3 = 6
                                kotlin.jvm.internal.InlineMarker.m8227e(r3)
                                kotlin.jvm.internal.InlineMarker.m8227e(r3)
                                java.lang.Object r1 = r1.invoke(r6, r7, r8)
                                r3 = 7
                                kotlin.jvm.internal.InlineMarker.m8227e(r3)
                                kotlin.jvm.internal.InlineMarker.m8227e(r3)
                                if (r1 != r0) goto L85
                                return r0
                            L85:
                                r3 = r9
                                r9 = r1
                                r1 = r5
                            L88:
                                r8.f42773b = r4
                                r8.f42774c = r3
                                r8.f42776e = r2
                                java.lang.Object r9 = r1.emit(r9, r8)
                                if (r9 != r0) goto L95
                                return r0
                            L95:
                                kotlin.f1 r9 = kotlin.Unit.f41048a
                                return r9
                            L98:
                                kotlinx.coroutines.flow.internal.AbortFlowException r9 = new kotlinx.coroutines.flow.internal.AbortFlowException
                                kotlinx.coroutines.flow.internal.CombineKt$a$a$c$a r0 = r8.f42778g
                                kotlinx.coroutines.flow.internal.CombineKt$a$a$c r0 = kotlinx.coroutines.flow.internal.Combine.C14966a.C14967a.C14971c.this
                                kotlinx.coroutines.flow.internal.CombineKt$a$a r0 = kotlinx.coroutines.flow.internal.Combine.C14966a.C14967a.this
                                kotlinx.coroutines.flow.i r0 = r0.f42753h
                                r9.<init>(r0)
                                throw r9
                            */
                            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.internal.Combine.C14966a.C14967a.C14971c.C14972a.C14973a.invokeSuspend(java.lang.Object):java.lang.Object");
                        }
                    }

                    public C14972a() {
                    }

                    @Override // kotlinx.coroutines.flow.FlowCollector
                    @Nullable
                    public Object emit(Object obj, @NotNull InterfaceC14268c interfaceC14268c) {
                        Object m8642h;
                        C14971c c14971c = C14971c.this;
                        CoroutineContext coroutineContext = c14971c.f42768f;
                        Unit unit = Unit.f41048a;
                        Object m4778c = C14983f.m4778c(coroutineContext, unit, c14971c.f42769g, new C14973a(obj, null, this), interfaceC14268c);
                        m8642h = C14287b.m8642h();
                        return m4778c == m8642h ? m4778c : unit;
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C14971c(CoroutineContext coroutineContext, Object obj, InterfaceC14695d0 interfaceC14695d0, InterfaceC14268c interfaceC14268c) {
                    super(2, interfaceC14268c);
                    this.f42768f = coroutineContext;
                    this.f42769g = obj;
                    this.f42770h = interfaceC14695d0;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @NotNull
                public final InterfaceC14268c<Unit> create(@Nullable Object obj, @NotNull InterfaceC14268c<?> interfaceC14268c) {
                    C14971c c14971c = new C14971c(this.f42768f, this.f42769g, this.f42770h, interfaceC14268c);
                    c14971c.f42763a = (Unit) obj;
                    return c14971c;
                }

                @Override // p617l1.InterfaceC15284p
                public final Object invoke(Unit unit, InterfaceC14268c<? super Unit> interfaceC14268c) {
                    return ((C14971c) create(unit, interfaceC14268c)).invokeSuspend(Unit.f41048a);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @Nullable
                public final Object invokeSuspend(@NotNull Object obj) {
                    Object m8642h;
                    m8642h = C14287b.m8642h();
                    int i = this.f42766d;
                    if (i == 0) {
                        C14294d0.m8596n(obj);
                        Unit unit = this.f42763a;
                        InterfaceC14958h interfaceC14958h = C14967a.this.f42754i.f42744b;
                        C14972a c14972a = new C14972a();
                        this.f42764b = unit;
                        this.f42765c = interfaceC14958h;
                        this.f42766d = 1;
                        if (interfaceC14958h.mo4470e(c14972a, this) == m8642h) {
                            return m8642h;
                        }
                    } else if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        InterfaceC14958h interfaceC14958h2 = (InterfaceC14958h) this.f42765c;
                        Unit unit2 = (Unit) this.f42764b;
                        C14294d0.m8596n(obj);
                    }
                    return Unit.f41048a;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C14967a(FlowCollector flowCollector, InterfaceC14268c interfaceC14268c, C14966a c14966a) {
                super(2, interfaceC14268c);
                this.f42753h = flowCollector;
                this.f42754i = c14966a;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final InterfaceC14268c<Unit> create(@Nullable Object obj, @NotNull InterfaceC14268c<?> interfaceC14268c) {
                C14967a c14967a = new C14967a(this.f42753h, interfaceC14268c, this.f42754i);
                c14967a.f42746a = (CoroutineScope) obj;
                return c14967a;
            }

            @Override // p617l1.InterfaceC15284p
            public final Object invoke(CoroutineScope coroutineScope, InterfaceC14268c<? super Unit> interfaceC14268c) {
                return ((C14967a) create(coroutineScope, interfaceC14268c)).invokeSuspend(Unit.f41048a);
            }

            /* JADX WARN: Code restructure failed: missing block: B:22:0x009d, code lost:
                if (r1.mo5394h() == false) goto L10;
             */
            /* JADX WARN: Code restructure failed: missing block: B:23:0x009f, code lost:
                kotlinx.coroutines.channels.InterfaceC14695d0.C14696a.m5472b(r1, null, 1, null);
             */
            /* JADX WARN: Code restructure failed: missing block: B:30:0x00b1, code lost:
                if (r1.mo5394h() == false) goto L10;
             */
            /* JADX WARN: Code restructure failed: missing block: B:33:0x00b6, code lost:
                return kotlin.Unit.f41048a;
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
                throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.internal.Combine.C14966a.C14967a.invokeSuspend(java.lang.Object):java.lang.Object");
            }
        }

        public C14966a(InterfaceC14958h interfaceC14958h, InterfaceC14958h interfaceC14958h2, InterfaceC15285q interfaceC15285q) {
            this.f42743a = interfaceC14958h;
            this.f42744b = interfaceC14958h2;
            this.f42745c = interfaceC15285q;
        }

        @Override // kotlinx.coroutines.flow.InterfaceC14958h
        @Nullable
        /* renamed from: e */
        public Object mo4470e(@NotNull FlowCollector flowCollector, @NotNull InterfaceC14268c interfaceC14268c) {
            Object m8642h;
            Object m3840g = C15162r0.m3840g(new C14967a(flowCollector, null, this), interfaceC14268c);
            m8642h = C14287b.m8642h();
            return m3840g == m8642h ? m3840g : Unit.f41048a;
        }
    }

    @PublishedApi
    @Nullable
    /* renamed from: a */
    public static final <R, T> Object m4805a(@NotNull FlowCollector<? super R> flowCollector, @NotNull InterfaceC14958h<? extends T>[] interfaceC14958hArr, @NotNull InterfaceC15269a<T[]> interfaceC15269a, @NotNull InterfaceC15285q<? super FlowCollector<? super R>, ? super T[], ? super InterfaceC14268c<? super Unit>, ? extends Object> interfaceC15285q, @NotNull InterfaceC14268c<? super Unit> interfaceC14268c) {
        Object m8642h;
        Object m4765c = C14991l.m4765c(new CombineKt$combineInternal$2(flowCollector, interfaceC14958hArr, interfaceC15269a, interfaceC15285q, null), interfaceC14268c);
        m8642h = C14287b.m8642h();
        return m4765c == m8642h ? m4765c : Unit.f41048a;
    }

    @NotNull
    /* renamed from: b */
    public static final <T1, T2, R> InterfaceC14958h<R> m4804b(@NotNull InterfaceC14958h<? extends T1> interfaceC14958h, @NotNull InterfaceC14958h<? extends T2> interfaceC14958h2, @NotNull InterfaceC15285q<? super T1, ? super T2, ? super InterfaceC14268c<? super R>, ? extends Object> interfaceC15285q) {
        return new C14966a(interfaceC14958h2, interfaceC14958h, interfaceC15285q);
    }
}

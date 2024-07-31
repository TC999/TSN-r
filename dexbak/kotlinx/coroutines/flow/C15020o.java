package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import com.umeng.analytics.AnalyticsConfig;
import kotlin.C14294d0;
import kotlin.Metadata;
import kotlin.OverloadResolutionByLambdaReturnType;
import kotlin.Unit;
import kotlin.coroutines.InterfaceC14268c;
import kotlin.coroutines.intrinsics.C14287b;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlin.time.Duration;
import kotlin.time.ExperimentalTime;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Delay;
import kotlinx.coroutines.FlowPreview;
import kotlinx.coroutines.channels.C14739z;
import kotlinx.coroutines.channels.InterfaceC14686b0;
import kotlinx.coroutines.channels.InterfaceC14695d0;
import kotlinx.coroutines.flow.internal.C14991l;
import kotlinx.coroutines.flow.internal.ChildCancelledException;
import kotlinx.coroutines.flow.internal.NullSurrogate;
import kotlinx.coroutines.internal.Symbol;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15280l;
import p617l1.InterfaceC15284p;
import p617l1.InterfaceC15285q;

/* compiled from: Delay.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a&\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0007\u001a2\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00020\u0005H\u0007\u001a0\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\b\u001a\u00020\u0007H\u0007ø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u001a<\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00070\u0005H\u0007ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a9\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00020\u0005H\u0002¢\u0006\u0004\b\u000e\u0010\f\u001a&\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u000f\u001a\u00020\u0002H\u0007\u001a$\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00022\b\b\u0002\u0010\u0013\u001a\u00020\u0002H\u0000\u001a0\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0017\u001a\u00020\u0007H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\n\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0019"}, m12616d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/h;", "", "timeoutMillis", "a", "Lkotlin/Function1;", "b", "Lkotlin/time/d;", "timeout", "c", "(Lkotlinx/coroutines/flow/h;D)Lkotlinx/coroutines/flow/h;", "d", "(Lkotlinx/coroutines/flow/h;Ll1/l;)Lkotlinx/coroutines/flow/h;", "timeoutMillisSelector", "e", "periodMillis", "h", "Lkotlinx/coroutines/q0;", "delayMillis", "initialDelayMillis", "Lkotlinx/coroutines/channels/d0;", "Lkotlin/f1;", "f", AnalyticsConfig.RTD_PERIOD, "i", "kotlinx-coroutines-core"}, m12615k = 5, m12614mv = {1, 4, 0}, m12611xs = "kotlinx/coroutines/flow/FlowKt")
/* renamed from: kotlinx.coroutines.flow.o */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final /* synthetic */ class C15020o {

    /* compiled from: Delay.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0001\u001a\u00028\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, m12616d2 = {ExifInterface.GPS_DIRECTION_TRUE, "it", "", "a", "(Ljava/lang/Object;)J"}, m12615k = 3, m12614mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.flow.o$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15021a<T> extends Lambda implements InterfaceC15280l<T, Long> {

        /* renamed from: a */
        final /* synthetic */ long f42898a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C15021a(long j) {
            super(1);
            this.f42898a = j;
        }

        /* renamed from: a */
        public final long m4534a(T t) {
            return this.f42898a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // p617l1.InterfaceC15280l
        public /* bridge */ /* synthetic */ Long invoke(Object obj) {
            return Long.valueOf(m4534a(obj));
        }
    }

    /* compiled from: Delay.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0001\u001a\u00028\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, m12616d2 = {ExifInterface.GPS_DIRECTION_TRUE, "emittedItem", "", "a", "(Ljava/lang/Object;)J"}, m12615k = 3, m12614mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.flow.o$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15022b<T> extends Lambda implements InterfaceC15280l<T, Long> {

        /* renamed from: a */
        final /* synthetic */ InterfaceC15280l f42899a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C15022b(InterfaceC15280l interfaceC15280l) {
            super(1);
            this.f42899a = interfaceC15280l;
        }

        /* renamed from: a */
        public final long m4533a(T t) {
            return Delay.m5748e(((Duration) this.f42899a.invoke(t)).unbox-impl());
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // p617l1.InterfaceC15280l
        public /* bridge */ /* synthetic */ Long invoke(Object obj) {
            return Long.valueOf(m4533a(obj));
        }
    }

    /* compiled from: Delay.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006"}, m12616d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/q0;", "Lkotlinx/coroutines/flow/i;", "downstream", "Lkotlin/f1;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 4, 0})
    @DebugMetadata(m8639c = "kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1", m8638f = "Delay.kt", m8637i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1}, m8636l = {354, 358}, m8635m = "invokeSuspend", m8634n = {"$this$scopedFlow", "downstream", "values", "lastValue", "timeoutMillis", "$this$scopedFlow", "downstream", "values", "lastValue", "timeoutMillis"}, m8633s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4"})
    /* renamed from: kotlinx.coroutines.flow.o$c */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15023c<T> extends SuspendLambda implements InterfaceC15285q<CoroutineScope, FlowCollector<? super T>, InterfaceC14268c<? super Unit>, Object> {

        /* renamed from: a */
        private CoroutineScope f42900a;

        /* renamed from: b */
        private FlowCollector f42901b;

        /* renamed from: c */
        Object f42902c;

        /* renamed from: d */
        Object f42903d;

        /* renamed from: e */
        Object f42904e;

        /* renamed from: f */
        Object f42905f;

        /* renamed from: g */
        Object f42906g;

        /* renamed from: h */
        Object f42907h;

        /* renamed from: i */
        int f42908i;

        /* renamed from: j */
        final /* synthetic */ InterfaceC14958h f42909j;

        /* renamed from: k */
        final /* synthetic */ InterfaceC15280l f42910k;

        /* compiled from: Delay.kt */
        @Metadata(m12618bv = {}, m12617d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0005\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m12616d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/f1;", "invoke", "(Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__DelayKt$debounceInternal$1$3$1", "<anonymous>"}, m12615k = 3, m12614mv = {1, 4, 0})
        /* renamed from: kotlinx.coroutines.flow.o$c$a */
        /* loaded from: E:\fuckcool\tsn\5406560.dex */
        public static final class C15024a extends SuspendLambda implements InterfaceC15280l<InterfaceC14268c<? super Unit>, Object> {

            /* renamed from: a */
            int f42911a;

            /* renamed from: b */
            final /* synthetic */ Ref.ObjectRef f42912b;

            /* renamed from: c */
            final /* synthetic */ Ref.LongRef f42913c;

            /* renamed from: d */
            final /* synthetic */ FlowCollector f42914d;

            /* renamed from: e */
            final /* synthetic */ Ref.ObjectRef f42915e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C15024a(InterfaceC14268c interfaceC14268c, Ref.ObjectRef objectRef, Ref.LongRef longRef, FlowCollector flowCollector, Ref.ObjectRef objectRef2) {
                super(1, interfaceC14268c);
                this.f42912b = objectRef;
                this.f42913c = longRef;
                this.f42914d = flowCollector;
                this.f42915e = objectRef2;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final InterfaceC14268c<Unit> create(@NotNull InterfaceC14268c<?> interfaceC14268c) {
                return new C15024a(interfaceC14268c, this.f42912b, this.f42913c, this.f42914d, this.f42915e);
            }

            @Override // p617l1.InterfaceC15280l
            public final Object invoke(InterfaceC14268c<? super Unit> interfaceC14268c) {
                return ((C15024a) create(interfaceC14268c)).invokeSuspend(Unit.f41048a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                Object m8642h;
                m8642h = C14287b.m8642h();
                int i = this.f42911a;
                if (i == 0) {
                    C14294d0.m8596n(obj);
                    FlowCollector flowCollector = this.f42914d;
                    Symbol symbol = NullSurrogate.f42850a;
                    T t = this.f42912b.element;
                    if (t == symbol) {
                        t = null;
                    }
                    this.f42911a = 1;
                    if (flowCollector.emit(t, this) == m8642h) {
                        return m8642h;
                    }
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    C14294d0.m8596n(obj);
                }
                this.f42912b.element = null;
                return Unit.f41048a;
            }
        }

        /* compiled from: Delay.kt */
        @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m12616d2 = {ExifInterface.GPS_DIRECTION_TRUE, "", DomainCampaignEx.LOOPBACK_VALUE, "Lkotlin/f1;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__DelayKt$debounceInternal$1$3$2", "<anonymous>"}, m12615k = 3, m12614mv = {1, 4, 0})
        /* renamed from: kotlinx.coroutines.flow.o$c$b */
        /* loaded from: E:\fuckcool\tsn\5406560.dex */
        public static final class C15025b extends SuspendLambda implements InterfaceC15284p<Object, InterfaceC14268c<? super Unit>, Object> {

            /* renamed from: a */
            private Object f42916a;

            /* renamed from: b */
            Object f42917b;

            /* renamed from: c */
            int f42918c;

            /* renamed from: d */
            final /* synthetic */ Ref.ObjectRef f42919d;

            /* renamed from: e */
            final /* synthetic */ Ref.LongRef f42920e;

            /* renamed from: f */
            final /* synthetic */ FlowCollector f42921f;

            /* renamed from: g */
            final /* synthetic */ Ref.ObjectRef f42922g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C15025b(InterfaceC14268c interfaceC14268c, Ref.ObjectRef objectRef, Ref.LongRef longRef, FlowCollector flowCollector, Ref.ObjectRef objectRef2) {
                super(2, interfaceC14268c);
                this.f42919d = objectRef;
                this.f42920e = longRef;
                this.f42921f = flowCollector;
                this.f42922g = objectRef2;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final InterfaceC14268c<Unit> create(@Nullable Object obj, @NotNull InterfaceC14268c<?> interfaceC14268c) {
                C15025b c15025b = new C15025b(interfaceC14268c, this.f42919d, this.f42920e, this.f42921f, this.f42922g);
                c15025b.f42916a = obj;
                return c15025b;
            }

            @Override // p617l1.InterfaceC15284p
            public final Object invoke(Object obj, InterfaceC14268c<? super Unit> interfaceC14268c) {
                return ((C15025b) create(obj, interfaceC14268c)).invokeSuspend(Unit.f41048a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                Object m8642h;
                m8642h = C14287b.m8642h();
                int i = this.f42918c;
                if (i == 0) {
                    C14294d0.m8596n(obj);
                    T t = (T) this.f42916a;
                    if (t == null) {
                        T t2 = this.f42919d.element;
                        if (t2 != null) {
                            FlowCollector flowCollector = this.f42921f;
                            if (t2 == NullSurrogate.f42850a) {
                                t2 = null;
                            }
                            this.f42917b = t;
                            this.f42918c = 1;
                            if (flowCollector.emit(t2, this) == m8642h) {
                                return m8642h;
                            }
                        }
                    } else {
                        this.f42919d.element = t;
                        return Unit.f41048a;
                    }
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    C14294d0.m8596n(obj);
                }
                this.f42919d.element = (T) NullSurrogate.f42852c;
                return Unit.f41048a;
            }
        }

        /* compiled from: Delay.kt */
        @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, m12616d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/channels/b0;", "", "Lkotlin/f1;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 4, 0})
        @DebugMetadata(m8639c = "kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1$values$1", m8638f = "Delay.kt", m8637i = {0, 0}, m8636l = {352}, m8635m = "invokeSuspend", m8634n = {"$this$produce", "$this$collect$iv"}, m8633s = {"L$0", "L$1"})
        /* renamed from: kotlinx.coroutines.flow.o$c$c */
        /* loaded from: E:\fuckcool\tsn\5406560.dex */
        public static final class C15026c extends SuspendLambda implements InterfaceC15284p<InterfaceC14686b0<? super Object>, InterfaceC14268c<? super Unit>, Object> {

            /* renamed from: a */
            private InterfaceC14686b0 f42923a;

            /* renamed from: b */
            Object f42924b;

            /* renamed from: c */
            Object f42925c;

            /* renamed from: d */
            int f42926d;

            /* compiled from: Collect.kt */
            @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006¸\u0006\u0000"}, m12616d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/i;", DomainCampaignEx.LOOPBACK_VALUE, "Lkotlin/f1;", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/c;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
            /* renamed from: kotlinx.coroutines.flow.o$c$c$a */
            /* loaded from: E:\fuckcool\tsn\5406560.dex */
            public static final class C15027a implements FlowCollector<T> {

                /* renamed from: a */
                final /* synthetic */ InterfaceC14686b0 f42928a;

                public C15027a(InterfaceC14686b0 interfaceC14686b0) {
                    this.f42928a = interfaceC14686b0;
                }

                @Override // kotlinx.coroutines.flow.FlowCollector
                @Nullable
                public Object emit(Object obj, @NotNull InterfaceC14268c interfaceC14268c) {
                    Object m8642h;
                    InterfaceC14686b0 interfaceC14686b0 = this.f42928a;
                    if (obj == null) {
                        obj = NullSurrogate.f42850a;
                    }
                    Object mo5177P = interfaceC14686b0.mo5177P(obj, interfaceC14268c);
                    m8642h = C14287b.m8642h();
                    return mo5177P == m8642h ? mo5177P : Unit.f41048a;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C15026c(InterfaceC14268c interfaceC14268c) {
                super(2, interfaceC14268c);
                C15023c.this = r1;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final InterfaceC14268c<Unit> create(@Nullable Object obj, @NotNull InterfaceC14268c<?> interfaceC14268c) {
                C15026c c15026c = new C15026c(interfaceC14268c);
                c15026c.f42923a = (InterfaceC14686b0) obj;
                return c15026c;
            }

            @Override // p617l1.InterfaceC15284p
            public final Object invoke(InterfaceC14686b0<? super Object> interfaceC14686b0, InterfaceC14268c<? super Unit> interfaceC14268c) {
                return ((C15026c) create(interfaceC14686b0, interfaceC14268c)).invokeSuspend(Unit.f41048a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                Object m8642h;
                m8642h = C14287b.m8642h();
                int i = this.f42926d;
                if (i == 0) {
                    C14294d0.m8596n(obj);
                    InterfaceC14686b0 interfaceC14686b0 = this.f42923a;
                    InterfaceC14958h interfaceC14958h = C15023c.this.f42909j;
                    C15027a c15027a = new C15027a(interfaceC14686b0);
                    this.f42924b = interfaceC14686b0;
                    this.f42925c = interfaceC14958h;
                    this.f42926d = 1;
                    if (interfaceC14958h.mo4470e(c15027a, this) == m8642h) {
                        return m8642h;
                    }
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    InterfaceC14958h interfaceC14958h2 = (InterfaceC14958h) this.f42925c;
                    InterfaceC14686b0 interfaceC14686b02 = (InterfaceC14686b0) this.f42924b;
                    C14294d0.m8596n(obj);
                }
                return Unit.f41048a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C15023c(InterfaceC14958h interfaceC14958h, InterfaceC15280l interfaceC15280l, InterfaceC14268c interfaceC14268c) {
            super(3, interfaceC14268c);
            this.f42909j = interfaceC14958h;
            this.f42910k = interfaceC15280l;
        }

        @NotNull
        /* renamed from: d */
        public final InterfaceC14268c<Unit> m4532d(@NotNull CoroutineScope coroutineScope, @NotNull FlowCollector<? super T> flowCollector, @NotNull InterfaceC14268c<? super Unit> interfaceC14268c) {
            C15023c c15023c = new C15023c(this.f42909j, this.f42910k, interfaceC14268c);
            c15023c.f42900a = coroutineScope;
            c15023c.f42901b = flowCollector;
            return c15023c;
        }

        @Override // p617l1.InterfaceC15285q
        public final Object invoke(CoroutineScope coroutineScope, Object obj, InterfaceC14268c<? super Unit> interfaceC14268c) {
            return ((C15023c) m4532d(coroutineScope, (FlowCollector) obj, interfaceC14268c)).invokeSuspend(Unit.f41048a);
        }

        /* JADX WARN: Can't wrap try/catch for region: R(14:9|(5:11|(1:13)|14|(1:16)(1:30)|(2:28|29)(2:18|(5:20|(1:22)|23|(1:25)|27)))|31|32|33|34|(8:53|54|55|56|57|58|59|60)(1:36)|37|38|39|40|41|(1:43)|(1:45)(4:46|6|7|(2:70|71)(0))) */
        /* JADX WARN: Can't wrap try/catch for region: R(8:(1:53)|54|55|56|57|58|59|60) */
        /* JADX WARN: Can't wrap try/catch for region: R(8:53|54|55|56|57|58|59|60) */
        /* JADX WARN: Code restructure failed: missing block: B:121:0x0116, code lost:
            r0 = th;
         */
        /* JADX WARN: Code restructure failed: missing block: B:122:0x0117, code lost:
            r5 = r10;
         */
        /* JADX WARN: Code restructure failed: missing block: B:130:0x013a, code lost:
            r0 = th;
         */
        /* JADX WARN: Code restructure failed: missing block: B:132:0x013c, code lost:
            r0 = th;
         */
        /* JADX WARN: Code restructure failed: missing block: B:133:0x013d, code lost:
            r5 = r11;
         */
        /* JADX WARN: Code restructure failed: missing block: B:134:0x013f, code lost:
            r0 = th;
         */
        /* JADX WARN: Code restructure failed: missing block: B:135:0x0140, code lost:
            r5 = r10;
            r18 = r11;
         */
        /* JADX WARN: Code restructure failed: missing block: B:136:0x0143, code lost:
            r5.m3713n0(r0);
         */
        /* JADX WARN: Removed duplicated region for block: B:125:0x011f  */
        /* JADX WARN: Removed duplicated region for block: B:139:0x0150  */
        /* JADX WARN: Removed duplicated region for block: B:141:0x0155 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:142:0x0156  */
        /* JADX WARN: Removed duplicated region for block: B:144:0x0162  */
        /* JADX WARN: Removed duplicated region for block: B:150:0x00fa A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:91:0x0086  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:142:0x0156 -> B:143:0x015d). Please submit an issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r21) {
            /*
                Method dump skipped, instructions count: 357
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.C15020o.C15023c.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: Delay.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, m12616d2 = {"Lkotlinx/coroutines/channels/b0;", "Lkotlin/f1;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 4, 0})
    @DebugMetadata(m8639c = "kotlinx.coroutines.flow.FlowKt__DelayKt$fixedPeriodTicker$3", m8638f = "Delay.kt", m8637i = {0, 1, 2}, m8636l = {316, 318, 319}, m8635m = "invokeSuspend", m8634n = {"$this$produce", "$this$produce", "$this$produce"}, m8633s = {"L$0", "L$0", "L$0"})
    /* renamed from: kotlinx.coroutines.flow.o$d */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15028d extends SuspendLambda implements InterfaceC15284p<InterfaceC14686b0<? super Unit>, InterfaceC14268c<? super Unit>, Object> {

        /* renamed from: a */
        private InterfaceC14686b0 f42929a;

        /* renamed from: b */
        Object f42930b;

        /* renamed from: c */
        int f42931c;

        /* renamed from: d */
        final /* synthetic */ long f42932d;

        /* renamed from: e */
        final /* synthetic */ long f42933e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C15028d(long j, long j2, InterfaceC14268c interfaceC14268c) {
            super(2, interfaceC14268c);
            this.f42932d = j;
            this.f42933e = j2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final InterfaceC14268c<Unit> create(@Nullable Object obj, @NotNull InterfaceC14268c<?> interfaceC14268c) {
            C15028d c15028d = new C15028d(this.f42932d, this.f42933e, interfaceC14268c);
            c15028d.f42929a = (InterfaceC14686b0) obj;
            return c15028d;
        }

        @Override // p617l1.InterfaceC15284p
        public final Object invoke(InterfaceC14686b0<? super Unit> interfaceC14686b0, InterfaceC14268c<? super Unit> interfaceC14268c) {
            return ((C15028d) create(interfaceC14686b0, interfaceC14268c)).invokeSuspend(Unit.f41048a);
        }

        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:56)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:30)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:18)
            */
        /* JADX WARN: Removed duplicated region for block: B:38:0x004d A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:41:0x005a A[RETURN] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x0058 -> B:36:0x003d). Please submit an issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r8) {
            /*
                r7 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.C14286a.m8643h()
                int r1 = r7.f42931c
                r2 = 3
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L2a
                if (r1 == r4) goto L11
                if (r1 == r3) goto L21
                if (r1 != r2) goto L19
            L11:
                java.lang.Object r1 = r7.f42930b
                kotlinx.coroutines.channels.b0 r1 = (kotlinx.coroutines.channels.InterfaceC14686b0) r1
                kotlin.C14294d0.m8596n(r8)
                goto L3c
            L19:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r0)
                throw r8
            L21:
                java.lang.Object r1 = r7.f42930b
                kotlinx.coroutines.channels.b0 r1 = (kotlinx.coroutines.channels.InterfaceC14686b0) r1
                kotlin.C14294d0.m8596n(r8)
                r8 = r7
                goto L4e
            L2a:
                kotlin.C14294d0.m8596n(r8)
                kotlinx.coroutines.channels.b0 r1 = r7.f42929a
                long r5 = r7.f42932d
                r7.f42930b = r1
                r7.f42931c = r4
                java.lang.Object r8 = kotlinx.coroutines.Delay.m5751b(r5, r7)
                if (r8 != r0) goto L3c
                return r0
            L3c:
                r8 = r7
            L3d:
                kotlinx.coroutines.channels.h0 r4 = r1.getChannel()
                kotlin.f1 r5 = kotlin.Unit.f41048a
                r8.f42930b = r1
                r8.f42931c = r3
                java.lang.Object r4 = r4.mo5177P(r5, r8)
                if (r4 != r0) goto L4e
                return r0
            L4e:
                long r4 = r8.f42933e
                r8.f42930b = r1
                r8.f42931c = r2
                java.lang.Object r4 = kotlinx.coroutines.Delay.m5751b(r4, r8)
                if (r4 != r0) goto L3d
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.C15020o.C15028d.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: Delay.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006"}, m12616d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/q0;", "Lkotlinx/coroutines/flow/i;", "downstream", "Lkotlin/f1;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 4, 0})
    @DebugMetadata(m8639c = "kotlinx.coroutines.flow.FlowKt__DelayKt$sample$2", m8638f = "Delay.kt", m8637i = {0, 0, 0, 0, 0}, m8636l = {355}, m8635m = "invokeSuspend", m8634n = {"$this$scopedFlow", "downstream", "values", "lastValue", "ticker"}, m8633s = {"L$0", "L$1", "L$2", "L$3", "L$4"})
    /* renamed from: kotlinx.coroutines.flow.o$e */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15029e<T> extends SuspendLambda implements InterfaceC15285q<CoroutineScope, FlowCollector<? super T>, InterfaceC14268c<? super Unit>, Object> {

        /* renamed from: a */
        private CoroutineScope f42934a;

        /* renamed from: b */
        private FlowCollector f42935b;

        /* renamed from: c */
        Object f42936c;

        /* renamed from: d */
        Object f42937d;

        /* renamed from: e */
        Object f42938e;

        /* renamed from: f */
        Object f42939f;

        /* renamed from: g */
        Object f42940g;

        /* renamed from: h */
        Object f42941h;

        /* renamed from: i */
        int f42942i;

        /* renamed from: j */
        final /* synthetic */ InterfaceC14958h f42943j;

        /* renamed from: k */
        final /* synthetic */ long f42944k;

        /* compiled from: Delay.kt */
        @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m12616d2 = {ExifInterface.GPS_DIRECTION_TRUE, "", "it", "Lkotlin/f1;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__DelayKt$sample$2$1$1", "<anonymous>"}, m12615k = 3, m12614mv = {1, 4, 0})
        /* renamed from: kotlinx.coroutines.flow.o$e$a */
        /* loaded from: E:\fuckcool\tsn\5406560.dex */
        public static final class C15030a extends SuspendLambda implements InterfaceC15284p<Object, InterfaceC14268c<? super Unit>, Object> {

            /* renamed from: a */
            private Object f42945a;

            /* renamed from: b */
            int f42946b;

            /* renamed from: c */
            final /* synthetic */ Ref.ObjectRef f42947c;

            /* renamed from: d */
            final /* synthetic */ InterfaceC14695d0 f42948d;

            /* renamed from: e */
            final /* synthetic */ Ref.ObjectRef f42949e;

            /* renamed from: f */
            final /* synthetic */ FlowCollector f42950f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C15030a(InterfaceC14268c interfaceC14268c, Ref.ObjectRef objectRef, InterfaceC14695d0 interfaceC14695d0, Ref.ObjectRef objectRef2, FlowCollector flowCollector) {
                super(2, interfaceC14268c);
                this.f42947c = objectRef;
                this.f42948d = interfaceC14695d0;
                this.f42949e = objectRef2;
                this.f42950f = flowCollector;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final InterfaceC14268c<Unit> create(@Nullable Object obj, @NotNull InterfaceC14268c<?> interfaceC14268c) {
                C15030a c15030a = new C15030a(interfaceC14268c, this.f42947c, this.f42948d, this.f42949e, this.f42950f);
                c15030a.f42945a = obj;
                return c15030a;
            }

            @Override // p617l1.InterfaceC15284p
            public final Object invoke(Object obj, InterfaceC14268c<? super Unit> interfaceC14268c) {
                return ((C15030a) create(obj, interfaceC14268c)).invokeSuspend(Unit.f41048a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                C14287b.m8642h();
                if (this.f42946b == 0) {
                    C14294d0.m8596n(obj);
                    T t = (T) this.f42945a;
                    if (t == null) {
                        this.f42948d.mo5474b(new ChildCancelledException());
                        this.f42949e.element = (T) NullSurrogate.f42852c;
                    } else {
                        this.f42949e.element = t;
                    }
                    return Unit.f41048a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* compiled from: Delay.kt */
        @Metadata(m12618bv = {}, m12617d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0010\u0006\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, m12616d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/f1;", "it", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__DelayKt$sample$2$1$2", "<anonymous>"}, m12615k = 3, m12614mv = {1, 4, 0})
        /* renamed from: kotlinx.coroutines.flow.o$e$b */
        /* loaded from: E:\fuckcool\tsn\5406560.dex */
        public static final class C15031b extends SuspendLambda implements InterfaceC15284p<Unit, InterfaceC14268c<? super Unit>, Object> {

            /* renamed from: a */
            private Unit f42951a;

            /* renamed from: b */
            Object f42952b;

            /* renamed from: c */
            Object f42953c;

            /* renamed from: d */
            int f42954d;

            /* renamed from: e */
            final /* synthetic */ Ref.ObjectRef f42955e;

            /* renamed from: f */
            final /* synthetic */ InterfaceC14695d0 f42956f;

            /* renamed from: g */
            final /* synthetic */ Ref.ObjectRef f42957g;

            /* renamed from: h */
            final /* synthetic */ FlowCollector f42958h;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C15031b(InterfaceC14268c interfaceC14268c, Ref.ObjectRef objectRef, InterfaceC14695d0 interfaceC14695d0, Ref.ObjectRef objectRef2, FlowCollector flowCollector) {
                super(2, interfaceC14268c);
                this.f42955e = objectRef;
                this.f42956f = interfaceC14695d0;
                this.f42957g = objectRef2;
                this.f42958h = flowCollector;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final InterfaceC14268c<Unit> create(@Nullable Object obj, @NotNull InterfaceC14268c<?> interfaceC14268c) {
                C15031b c15031b = new C15031b(interfaceC14268c, this.f42955e, this.f42956f, this.f42957g, this.f42958h);
                c15031b.f42951a = (Unit) obj;
                return c15031b;
            }

            @Override // p617l1.InterfaceC15284p
            public final Object invoke(Unit unit, InterfaceC14268c<? super Unit> interfaceC14268c) {
                return ((C15031b) create(unit, interfaceC14268c)).invokeSuspend(Unit.f41048a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                Object m8642h;
                m8642h = C14287b.m8642h();
                int i = this.f42954d;
                if (i == 0) {
                    C14294d0.m8596n(obj);
                    Unit unit = this.f42951a;
                    Ref.ObjectRef objectRef = this.f42957g;
                    T t = objectRef.element;
                    if (t != null) {
                        objectRef.element = null;
                        FlowCollector flowCollector = this.f42958h;
                        T t2 = t != NullSurrogate.f42850a ? t : null;
                        this.f42952b = unit;
                        this.f42953c = t;
                        this.f42954d = 1;
                        if (flowCollector.emit(t2, this) == m8642h) {
                            return m8642h;
                        }
                    } else {
                        return Unit.f41048a;
                    }
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    Unit unit2 = (Unit) this.f42952b;
                    C14294d0.m8596n(obj);
                }
                return Unit.f41048a;
            }
        }

        /* compiled from: Delay.kt */
        @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, m12616d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/channels/b0;", "", "Lkotlin/f1;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 4, 0})
        @DebugMetadata(m8639c = "kotlinx.coroutines.flow.FlowKt__DelayKt$sample$2$values$1", m8638f = "Delay.kt", m8637i = {0, 0}, m8636l = {352}, m8635m = "invokeSuspend", m8634n = {"$this$produce", "$this$collect$iv"}, m8633s = {"L$0", "L$1"})
        /* renamed from: kotlinx.coroutines.flow.o$e$c */
        /* loaded from: E:\fuckcool\tsn\5406560.dex */
        public static final class C15032c extends SuspendLambda implements InterfaceC15284p<InterfaceC14686b0<? super Object>, InterfaceC14268c<? super Unit>, Object> {

            /* renamed from: a */
            private InterfaceC14686b0 f42959a;

            /* renamed from: b */
            Object f42960b;

            /* renamed from: c */
            Object f42961c;

            /* renamed from: d */
            int f42962d;

            /* compiled from: Collect.kt */
            @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006¸\u0006\u0000"}, m12616d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/i;", DomainCampaignEx.LOOPBACK_VALUE, "Lkotlin/f1;", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/c;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
            /* renamed from: kotlinx.coroutines.flow.o$e$c$a */
            /* loaded from: E:\fuckcool\tsn\5406560.dex */
            public static final class C15033a implements FlowCollector<T> {

                /* renamed from: a */
                final /* synthetic */ InterfaceC14686b0 f42964a;

                public C15033a(InterfaceC14686b0 interfaceC14686b0) {
                    this.f42964a = interfaceC14686b0;
                }

                @Override // kotlinx.coroutines.flow.FlowCollector
                @Nullable
                public Object emit(Object obj, @NotNull InterfaceC14268c interfaceC14268c) {
                    Object m8642h;
                    InterfaceC14686b0 interfaceC14686b0 = this.f42964a;
                    if (obj == null) {
                        obj = NullSurrogate.f42850a;
                    }
                    Object mo5177P = interfaceC14686b0.mo5177P(obj, interfaceC14268c);
                    m8642h = C14287b.m8642h();
                    return mo5177P == m8642h ? mo5177P : Unit.f41048a;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C15032c(InterfaceC14268c interfaceC14268c) {
                super(2, interfaceC14268c);
                C15029e.this = r1;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final InterfaceC14268c<Unit> create(@Nullable Object obj, @NotNull InterfaceC14268c<?> interfaceC14268c) {
                C15032c c15032c = new C15032c(interfaceC14268c);
                c15032c.f42959a = (InterfaceC14686b0) obj;
                return c15032c;
            }

            @Override // p617l1.InterfaceC15284p
            public final Object invoke(InterfaceC14686b0<? super Object> interfaceC14686b0, InterfaceC14268c<? super Unit> interfaceC14268c) {
                return ((C15032c) create(interfaceC14686b0, interfaceC14268c)).invokeSuspend(Unit.f41048a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                Object m8642h;
                m8642h = C14287b.m8642h();
                int i = this.f42962d;
                if (i == 0) {
                    C14294d0.m8596n(obj);
                    InterfaceC14686b0 interfaceC14686b0 = this.f42959a;
                    InterfaceC14958h interfaceC14958h = C15029e.this.f42943j;
                    C15033a c15033a = new C15033a(interfaceC14686b0);
                    this.f42960b = interfaceC14686b0;
                    this.f42961c = interfaceC14958h;
                    this.f42962d = 1;
                    if (interfaceC14958h.mo4470e(c15033a, this) == m8642h) {
                        return m8642h;
                    }
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    InterfaceC14958h interfaceC14958h2 = (InterfaceC14958h) this.f42961c;
                    InterfaceC14686b0 interfaceC14686b02 = (InterfaceC14686b0) this.f42960b;
                    C14294d0.m8596n(obj);
                }
                return Unit.f41048a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C15029e(InterfaceC14958h interfaceC14958h, long j, InterfaceC14268c interfaceC14268c) {
            super(3, interfaceC14268c);
            this.f42943j = interfaceC14958h;
            this.f42944k = j;
        }

        @NotNull
        /* renamed from: d */
        public final InterfaceC14268c<Unit> m4531d(@NotNull CoroutineScope coroutineScope, @NotNull FlowCollector<? super T> flowCollector, @NotNull InterfaceC14268c<? super Unit> interfaceC14268c) {
            C15029e c15029e = new C15029e(this.f42943j, this.f42944k, interfaceC14268c);
            c15029e.f42934a = coroutineScope;
            c15029e.f42935b = flowCollector;
            return c15029e;
        }

        @Override // p617l1.InterfaceC15285q
        public final Object invoke(CoroutineScope coroutineScope, Object obj, InterfaceC14268c<? super Unit> interfaceC14268c) {
            return ((C15029e) m4531d(coroutineScope, (FlowCollector) obj, interfaceC14268c)).invokeSuspend(Unit.f41048a);
        }

        /* JADX WARN: Can't wrap try/catch for region: R(12:8|(1:9)|10|11|12|13|14|(1:16)|(1:18)|5|6|(2:26|27)(0)) */
        /* JADX WARN: Code restructure failed: missing block: B:49:0x00af, code lost:
            r0 = th;
         */
        /* JADX WARN: Code restructure failed: missing block: B:53:0x00b3, code lost:
            r1.m3713n0(r0);
         */
        /* JADX WARN: Removed duplicated region for block: B:44:0x0071  */
        /* JADX WARN: Removed duplicated region for block: B:56:0x00c0  */
        /* JADX WARN: Removed duplicated region for block: B:58:0x00c5 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:60:0x00ca  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:57:0x00c3 -> B:59:0x00c6). Please submit an issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r17) {
            /*
                Method dump skipped, instructions count: 205
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.C15020o.C15029e.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @FlowPreview
    @NotNull
    /* renamed from: a */
    public static final <T> InterfaceC14958h<T> m4543a(@NotNull InterfaceC14958h<? extends T> interfaceC14958h, long j) {
        if (j >= 0) {
            return j == 0 ? interfaceC14958h : m4539e(interfaceC14958h, new C15021a(j));
        }
        throw new IllegalArgumentException("Debounce timeout should not be negative".toString());
    }

    @FlowPreview
    @OverloadResolutionByLambdaReturnType
    @NotNull
    /* renamed from: b */
    public static final <T> InterfaceC14958h<T> m4542b(@NotNull InterfaceC14958h<? extends T> interfaceC14958h, @NotNull InterfaceC15280l<? super T, Long> interfaceC15280l) {
        return m4539e(interfaceC14958h, interfaceC15280l);
    }

    @FlowPreview
    @ExperimentalTime
    @NotNull
    /* renamed from: c */
    public static final <T> InterfaceC14958h<T> m4541c(@NotNull InterfaceC14958h<? extends T> interfaceC14958h, double d) {
        return C15006k.m4648f0(interfaceC14958h, Delay.m5748e(d));
    }

    @FlowPreview
    @JvmName(name = "debounceDuration")
    @NotNull
    @OverloadResolutionByLambdaReturnType
    @ExperimentalTime
    /* renamed from: d */
    public static final <T> InterfaceC14958h<T> m4540d(@NotNull InterfaceC14958h<? extends T> interfaceC14958h, @NotNull InterfaceC15280l<? super T, Duration> interfaceC15280l) {
        return m4539e(interfaceC14958h, new C15022b(interfaceC15280l));
    }

    /* renamed from: e */
    private static final <T> InterfaceC14958h<T> m4539e(InterfaceC14958h<? extends T> interfaceC14958h, InterfaceC15280l<? super T, Long> interfaceC15280l) {
        return C14991l.m4764d(new C15023c(interfaceC14958h, interfaceC15280l, null));
    }

    @NotNull
    /* renamed from: f */
    public static final InterfaceC14695d0<Unit> m4538f(@NotNull CoroutineScope coroutineScope, long j, long j2) {
        if (!(j >= 0)) {
            throw new IllegalArgumentException(("Expected non-negative delay, but has " + j + " ms").toString());
        }
        if (j2 >= 0) {
            return C14739z.m5161h(coroutineScope, null, 0, new C15028d(j2, j, null), 1, null);
        }
        throw new IllegalArgumentException(("Expected non-negative initial delay, but has " + j2 + " ms").toString());
    }

    /* renamed from: g */
    public static /* synthetic */ InterfaceC14695d0 m4537g(CoroutineScope coroutineScope, long j, long j2, int i, Object obj) {
        if ((i & 2) != 0) {
            j2 = j;
        }
        return C15006k.m4740C0(coroutineScope, j, j2);
    }

    @FlowPreview
    @NotNull
    /* renamed from: h */
    public static final <T> InterfaceC14958h<T> m4536h(@NotNull InterfaceC14958h<? extends T> interfaceC14958h, long j) {
        if (j > 0) {
            return C14991l.m4764d(new C15029e(interfaceC14958h, j, null));
        }
        throw new IllegalArgumentException("Sample period should be positive".toString());
    }

    @FlowPreview
    @ExperimentalTime
    @NotNull
    /* renamed from: i */
    public static final <T> InterfaceC14958h<T> m4535i(@NotNull InterfaceC14958h<? extends T> interfaceC14958h, double d) {
        return C15006k.m4712L1(interfaceC14958h, Delay.m5748e(d));
    }
}

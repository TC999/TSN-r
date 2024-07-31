package kotlinx.coroutines.flow.internal;

import androidx.exifinterface.media.ExifInterface;
import kotlin.C14294d0;
import kotlin.Inference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.InterfaceC14268c;
import kotlin.coroutines.intrinsics.C14287b;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.InlineMarker;
import kotlinx.coroutines.C15117k0;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.channels.C14728q;
import kotlinx.coroutines.channels.InterfaceC14686b0;
import kotlinx.coroutines.channels.InterfaceC14695d0;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.InterfaceC14958h;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15284p;
import p617l1.InterfaceC15285q;
import p649u1.Undispatched;

/* compiled from: FlowCoroutine.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000F\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aD\u0010\u0007\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00002)\b\u0001\u0010\u0006\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0001¢\u0006\u0002\b\u0005H\u0080@ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\b\u001aU\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\f\"\u0004\b\u0000\u0010\u000025\b\u0001\u0010\u0006\u001a/\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\t¢\u0006\u0002\b\u0005H\u0000ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000e\u001ae\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015\"\u0004\b\u0000\u0010\u000f*\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0013\u001a\u00020\u00122/\b\u0001\u0010\u0006\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0001¢\u0006\u0002\b\u0005H\u0000ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0018"}, m12616d2 = {"R", "Lkotlin/Function2;", "Lkotlinx/coroutines/q0;", "Lkotlin/coroutines/c;", "", "Lkotlin/ExtensionFunctionType;", "block", "c", "(Ll1/p;Lkotlin/coroutines/c;)Ljava/lang/Object;", "Lkotlin/Function3;", "Lkotlinx/coroutines/flow/i;", "Lkotlin/f1;", "Lkotlinx/coroutines/flow/h;", "d", "(Ll1/q;)Lkotlinx/coroutines/flow/h;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/coroutines/f;", "context", "", "capacity", "Lkotlinx/coroutines/channels/b0;", "Lkotlinx/coroutines/channels/d0;", "a", "(Lkotlinx/coroutines/q0;Lkotlin/coroutines/f;ILl1/p;)Lkotlinx/coroutines/channels/d0;", "kotlinx-coroutines-core"}, m12615k = 2, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.flow.internal.l */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class C14991l {

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* compiled from: SafeCollector.common.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J!\u0010\u0005\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\u0000"}, m12616d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/h;", "Lkotlinx/coroutines/flow/i;", "collector", "Lkotlin/f1;", "e", "(Lkotlinx/coroutines/flow/i;Lkotlin/coroutines/c;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.flow.internal.l$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14992a<R> implements InterfaceC14958h<R> {

        /* renamed from: a */
        final /* synthetic */ InterfaceC15285q f42841a;

        /* compiled from: FlowCoroutine.kt */
        @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0006\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, m12616d2 = {"R", "Lkotlinx/coroutines/q0;", "Lkotlin/f1;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx/coroutines/flow/internal/FlowCoroutineKt$scopedFlow$1$1", "<anonymous>"}, m12615k = 3, m12614mv = {1, 4, 0})
        /* renamed from: kotlinx.coroutines.flow.internal.l$a$a */
        /* loaded from: E:\fuckcool\tsn\5406560.dex */
        static final class C14993a extends SuspendLambda implements InterfaceC15284p<CoroutineScope, InterfaceC14268c<? super Unit>, Object> {

            /* renamed from: a */
            private CoroutineScope f42842a;

            /* renamed from: b */
            Object f42843b;

            /* renamed from: c */
            int f42844c;

            /* renamed from: d */
            final /* synthetic */ FlowCollector f42845d;

            /* renamed from: e */
            final /* synthetic */ C14992a f42846e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C14993a(FlowCollector flowCollector, InterfaceC14268c interfaceC14268c, C14992a c14992a) {
                super(2, interfaceC14268c);
                this.f42845d = flowCollector;
                this.f42846e = c14992a;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final InterfaceC14268c<Unit> create(@Nullable Object obj, @NotNull InterfaceC14268c<?> interfaceC14268c) {
                C14993a c14993a = new C14993a(this.f42845d, interfaceC14268c, this.f42846e);
                c14993a.f42842a = (CoroutineScope) obj;
                return c14993a;
            }

            @Override // p617l1.InterfaceC15284p
            public final Object invoke(CoroutineScope coroutineScope, InterfaceC14268c<? super Unit> interfaceC14268c) {
                return ((C14993a) create(coroutineScope, interfaceC14268c)).invokeSuspend(Unit.f41048a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                Object m8642h;
                m8642h = C14287b.m8642h();
                int i = this.f42844c;
                if (i == 0) {
                    C14294d0.m8596n(obj);
                    CoroutineScope coroutineScope = this.f42842a;
                    InterfaceC15285q interfaceC15285q = this.f42846e.f42841a;
                    FlowCollector flowCollector = this.f42845d;
                    this.f42843b = coroutineScope;
                    this.f42844c = 1;
                    InlineMarker.m8227e(6);
                    Object invoke = interfaceC15285q.invoke(coroutineScope, flowCollector, this);
                    InlineMarker.m8227e(7);
                    if (invoke == m8642h) {
                        return m8642h;
                    }
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    CoroutineScope coroutineScope2 = (CoroutineScope) this.f42843b;
                    C14294d0.m8596n(obj);
                }
                return Unit.f41048a;
            }
        }

        public C14992a(InterfaceC15285q interfaceC15285q) {
            this.f42841a = interfaceC15285q;
        }

        @Override // kotlinx.coroutines.flow.InterfaceC14958h
        @Nullable
        /* renamed from: e */
        public Object mo4470e(@NotNull FlowCollector flowCollector, @NotNull InterfaceC14268c interfaceC14268c) {
            Object m8642h;
            Object m4765c = C14991l.m4765c(new C14993a(flowCollector, null, this), interfaceC14268c);
            m8642h = C14287b.m8642h();
            return m4765c == m8642h ? m4765c : Unit.f41048a;
        }
    }

    @NotNull
    /* renamed from: a */
    public static final <T> InterfaceC14695d0<T> m4767a(@NotNull CoroutineScope coroutineScope, @NotNull CoroutineContext coroutineContext, int i, @Inference @NotNull InterfaceC15284p<? super InterfaceC14686b0<? super T>, ? super InterfaceC14268c<? super Unit>, ? extends Object> interfaceC15284p) {
        C14995n c14995n = new C14995n(C15117k0.m4086d(coroutineScope, coroutineContext), C14728q.m5382d(i, null, null, 6, null));
        c14995n.m5758q1(CoroutineStart.ATOMIC, c14995n, interfaceC15284p);
        return c14995n;
    }

    /* renamed from: b */
    public static /* synthetic */ InterfaceC14695d0 m4766b(CoroutineScope coroutineScope, CoroutineContext coroutineContext, int i, InterfaceC15284p interfaceC15284p, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return m4767a(coroutineScope, coroutineContext, i, interfaceC15284p);
    }

    @Nullable
    /* renamed from: c */
    public static final <R> Object m4765c(@Inference @NotNull InterfaceC15284p<? super CoroutineScope, ? super InterfaceC14268c<? super R>, ? extends Object> interfaceC15284p, @NotNull InterfaceC14268c<? super R> interfaceC14268c) {
        Object m8642h;
        FlowCoroutine flowCoroutine = new FlowCoroutine(interfaceC14268c.getContext(), interfaceC14268c);
        Object m220f = Undispatched.m220f(flowCoroutine, flowCoroutine, interfaceC15284p);
        m8642h = C14287b.m8642h();
        if (m220f == m8642h) {
            DebugProbes.m8616c(interfaceC14268c);
        }
        return m220f;
    }

    @NotNull
    /* renamed from: d */
    public static final <R> InterfaceC14958h<R> m4764d(@Inference @NotNull InterfaceC15285q<? super CoroutineScope, ? super FlowCollector<? super R>, ? super InterfaceC14268c<? super Unit>, ? extends Object> interfaceC15285q) {
        return new C14992a(interfaceC15285q);
    }
}

package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import com.tencent.connect.common.Constants;
import com.umeng.ccg.CcgConstant;
import kotlin.C14294d0;
import kotlin.Inference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.InterfaceC14268c;
import kotlin.coroutines.intrinsics.C14287b;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.InlineMarker;
import kotlinx.coroutines.C15111j;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.internal.NopCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15284p;
import p617l1.InterfaceC15285q;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Collect.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001b\u0010\u0002\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u0000H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u001e\u0010\b\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0006\u001a\u00020\u0005\u001aX\u0010\u0010\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u00028\u00000\u000023\b\u0004\u0010\u000f\u001a-\b\u0001\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\tH\u0086Hø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u001am\u0010\u0015\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u00028\u00000\u00002H\b\u0004\u0010\u000f\u001aB\b\u0001\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u0012H\u0086Hø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u001aV\u0010\u0017\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u00028\u00000\u000021\u0010\u000f\u001a-\b\u0001\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\tH\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0011\u001a1\u0010\u001a\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u00028\u00000\u00182\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000H\u0087Hø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001b\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001c"}, m12616d2 = {"Lkotlinx/coroutines/flow/h;", "Lkotlin/f1;", "a", "(Lkotlinx/coroutines/flow/h;Lkotlin/coroutines/c;)Ljava/lang/Object;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/q0;", Constants.PARAM_SCOPE, "Lkotlinx/coroutines/e2;", "i", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", DomainCampaignEx.LOOPBACK_VALUE, "Lkotlin/coroutines/c;", "", CcgConstant.f38549t, "b", "(Lkotlinx/coroutines/flow/h;Ll1/p;Lkotlin/coroutines/c;)Ljava/lang/Object;", "Lkotlin/Function3;", "", "index", "d", "(Lkotlinx/coroutines/flow/h;Ll1/q;Lkotlin/coroutines/c;)Ljava/lang/Object;", "f", "Lkotlinx/coroutines/flow/i;", "flow", "g", "(Lkotlinx/coroutines/flow/i;Lkotlinx/coroutines/flow/h;Lkotlin/coroutines/c;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, m12615k = 5, m12614mv = {1, 4, 0}, m12611xs = "kotlinx/coroutines/flow/FlowKt")
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final /* synthetic */ class FlowKt__CollectKt {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Collect.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, m12616d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/q0;", "Lkotlin/f1;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 4, 0})
    @DebugMetadata(m8639c = "kotlinx.coroutines.flow.FlowKt__CollectKt$launchIn$1", m8638f = "Collect.kt", m8637i = {0}, m8636l = {50}, m8635m = "invokeSuspend", m8634n = {"$this$launch"}, m8633s = {"L$0"})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__CollectKt$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14794a extends SuspendLambda implements InterfaceC15284p<CoroutineScope, InterfaceC14268c<? super Unit>, Object> {

        /* renamed from: a */
        private CoroutineScope f42311a;

        /* renamed from: b */
        Object f42312b;

        /* renamed from: c */
        int f42313c;

        /* renamed from: d */
        final /* synthetic */ InterfaceC14958h f42314d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C14794a(InterfaceC14958h interfaceC14958h, InterfaceC14268c interfaceC14268c) {
            super(2, interfaceC14268c);
            this.f42314d = interfaceC14958h;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final InterfaceC14268c<Unit> create(@Nullable Object obj, @NotNull InterfaceC14268c<?> interfaceC14268c) {
            C14794a c14794a = new C14794a(this.f42314d, interfaceC14268c);
            c14794a.f42311a = (CoroutineScope) obj;
            return c14794a;
        }

        @Override // p617l1.InterfaceC15284p
        public final Object invoke(CoroutineScope coroutineScope, InterfaceC14268c<? super Unit> interfaceC14268c) {
            return ((C14794a) create(coroutineScope, interfaceC14268c)).invokeSuspend(Unit.f41048a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object m8642h;
            m8642h = C14287b.m8642h();
            int i = this.f42313c;
            if (i == 0) {
                C14294d0.m8596n(obj);
                CoroutineScope coroutineScope = this.f42311a;
                InterfaceC14958h interfaceC14958h = this.f42314d;
                this.f42312b = coroutineScope;
                this.f42313c = 1;
                if (C15006k.m4577z(interfaceC14958h, this) == m8642h) {
                    return m8642h;
                }
            } else if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                CoroutineScope coroutineScope2 = (CoroutineScope) this.f42312b;
                C14294d0.m8596n(obj);
            }
            return Unit.f41048a;
        }
    }

    @Nullable
    /* renamed from: a */
    public static final Object m5012a(@NotNull InterfaceC14958h<?> interfaceC14958h, @NotNull InterfaceC14268c<? super Unit> interfaceC14268c) {
        Object m8642h;
        Object mo4470e = interfaceC14958h.mo4470e(NopCollector.f42849a, interfaceC14268c);
        m8642h = C14287b.m8642h();
        return mo4470e == m8642h ? mo4470e : Unit.f41048a;
    }

    @Nullable
    /* renamed from: b */
    public static final <T> Object m5011b(@NotNull InterfaceC14958h<? extends T> interfaceC14958h, @NotNull InterfaceC15284p<? super T, ? super InterfaceC14268c<? super Unit>, ? extends Object> interfaceC15284p, @NotNull InterfaceC14268c<? super Unit> interfaceC14268c) {
        Object m8642h;
        Object mo4470e = interfaceC14958h.mo4470e(new FlowKt__CollectKt$collect$3(interfaceC15284p), interfaceC14268c);
        m8642h = C14287b.m8642h();
        return mo4470e == m8642h ? mo4470e : Unit.f41048a;
    }

    @Nullable
    /* renamed from: c */
    private static final Object m5010c(@NotNull InterfaceC14958h interfaceC14958h, @NotNull InterfaceC15284p interfaceC15284p, @NotNull InterfaceC14268c interfaceC14268c) {
        FlowKt__CollectKt$collect$3 flowKt__CollectKt$collect$3 = new FlowKt__CollectKt$collect$3(interfaceC15284p);
        InlineMarker.m8227e(0);
        Object mo4470e = interfaceC14958h.mo4470e(flowKt__CollectKt$collect$3, interfaceC14268c);
        InlineMarker.m8227e(2);
        InlineMarker.m8227e(1);
        return mo4470e;
    }

    @Nullable
    /* renamed from: d */
    public static final <T> Object m5009d(@NotNull InterfaceC14958h<? extends T> interfaceC14958h, @NotNull InterfaceC15285q<? super Integer, ? super T, ? super InterfaceC14268c<? super Unit>, ? extends Object> interfaceC15285q, @NotNull InterfaceC14268c<? super Unit> interfaceC14268c) {
        Object m8642h;
        Object mo4470e = interfaceC14958h.mo4470e(new FlowKt__CollectKt$collectIndexed$2(interfaceC15285q), interfaceC14268c);
        m8642h = C14287b.m8642h();
        return mo4470e == m8642h ? mo4470e : Unit.f41048a;
    }

    @Nullable
    /* renamed from: e */
    private static final Object m5008e(@NotNull InterfaceC14958h interfaceC14958h, @NotNull InterfaceC15285q interfaceC15285q, @NotNull InterfaceC14268c interfaceC14268c) {
        FlowKt__CollectKt$collectIndexed$2 flowKt__CollectKt$collectIndexed$2 = new FlowKt__CollectKt$collectIndexed$2(interfaceC15285q);
        InlineMarker.m8227e(0);
        Object mo4470e = interfaceC14958h.mo4470e(flowKt__CollectKt$collectIndexed$2, interfaceC14268c);
        InlineMarker.m8227e(2);
        InlineMarker.m8227e(1);
        return mo4470e;
    }

    @Nullable
    /* renamed from: f */
    public static final <T> Object m5007f(@NotNull InterfaceC14958h<? extends T> interfaceC14958h, @NotNull InterfaceC15284p<? super T, ? super InterfaceC14268c<? super Unit>, ? extends Object> interfaceC15284p, @NotNull InterfaceC14268c<? super Unit> interfaceC14268c) {
        InterfaceC14958h m4550d;
        Object m8642h;
        m4550d = C15016n.m4550d(C15006k.m4651e1(interfaceC14958h, interfaceC15284p), 0, null, 2, null);
        Object m4577z = C15006k.m4577z(m4550d, interfaceC14268c);
        m8642h = C14287b.m8642h();
        return m4577z == m8642h ? m4577z : Unit.f41048a;
    }

    @Inference
    @Nullable
    /* renamed from: g */
    public static final <T> Object m5006g(@NotNull FlowCollector<? super T> flowCollector, @NotNull InterfaceC14958h<? extends T> interfaceC14958h, @NotNull InterfaceC14268c<? super Unit> interfaceC14268c) {
        Object m8642h;
        Object mo4470e = interfaceC14958h.mo4470e(flowCollector, interfaceC14268c);
        m8642h = C14287b.m8642h();
        return mo4470e == m8642h ? mo4470e : Unit.f41048a;
    }

    @Inference
    @Nullable
    /* renamed from: h */
    private static final Object m5005h(@NotNull FlowCollector flowCollector, @NotNull InterfaceC14958h interfaceC14958h, @NotNull InterfaceC14268c interfaceC14268c) {
        InlineMarker.m8227e(0);
        Object mo4470e = interfaceC14958h.mo4470e(flowCollector, interfaceC14268c);
        InlineMarker.m8227e(2);
        InlineMarker.m8227e(1);
        return mo4470e;
    }

    @NotNull
    /* renamed from: i */
    public static final <T> Job m5004i(@NotNull InterfaceC14958h<? extends T> interfaceC14958h, @NotNull CoroutineScope coroutineScope) {
        Job m4126f;
        m4126f = C15111j.m4126f(coroutineScope, null, null, new C14794a(interfaceC14958h, null), 3, null);
        return m4126f;
    }
}

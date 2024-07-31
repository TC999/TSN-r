package kotlinx.coroutines.flow.internal;

import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.InterfaceC14268c;
import kotlin.coroutines.jvm.internal.InterfaceC14293i;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15285q;

/* compiled from: SafeCollector.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0002\n\u0000¨\u0006\u0000"}, m12616d2 = {"kotlinx-coroutines-core"}, m12615k = 2, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.flow.internal.s */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class C14999s {

    /* renamed from: a */
    private static final InterfaceC15285q<FlowCollector<Object>, Object, InterfaceC14268c<? super Unit>, Object> f42853a = (InterfaceC15285q) TypeIntrinsics.m8010q(new C15000a(), 3);

    /* compiled from: SafeCollector.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\b\u001a\u00020\u00072\u000e\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00002\u0017\u0010\u0006\u001a\u0013\u0018\u00010\u0001¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005H\u0086@¢\u0006\u0004\b\b\u0010\t"}, m12616d2 = {"Lkotlinx/coroutines/flow/i;", "", "p1", "Lkotlin/ParameterName;", "name", DomainCampaignEx.LOOPBACK_VALUE, "p2", "Lkotlin/f1;", "e", "(Lkotlinx/coroutines/flow/i;Ljava/lang/Object;Lkotlin/coroutines/c;)Ljava/lang/Object;"}, m12615k = 3, m12614mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.flow.internal.s$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static final /* synthetic */ class C15000a extends FunctionReferenceImpl implements InterfaceC15285q<FlowCollector<? super Object>, Object, InterfaceC14268c<? super Unit>, Object>, InterfaceC14293i {
        C15000a() {
            super(3, FlowCollector.class, "emit", "emit(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
        }

        @Override // p617l1.InterfaceC15285q
        @Nullable
        /* renamed from: e */
        public final Object invoke(@NotNull FlowCollector<Object> flowCollector, @Nullable Object obj, @NotNull InterfaceC14268c<? super Unit> interfaceC14268c) {
            InlineMarker.m8227e(0);
            Object emit = flowCollector.emit(obj, interfaceC14268c);
            InlineMarker.m8227e(2);
            InlineMarker.m8227e(1);
            return emit;
        }
    }

    /* renamed from: a */
    public static final /* synthetic */ InterfaceC15285q m4757a() {
        return f42853a;
    }

    /* renamed from: b */
    private static /* synthetic */ void m4756b() {
    }
}

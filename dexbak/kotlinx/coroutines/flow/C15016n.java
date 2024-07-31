package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import kotlin.Annotations;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.InterfaceC14268c;
import kotlin.coroutines.intrinsics.C14287b;
import kotlin.jvm.internal.C14342f0;
import kotlinx.coroutines.FlowPreview;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.internal.C14986h;
import kotlinx.coroutines.flow.internal.InterfaceC14996o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15280l;

/* compiled from: Context.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a0\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u001a(\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u0002H\u0007\u001a\u001c\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001\u001a$\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\n\u001a\u00020\t\u001a\u001c\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001\u001a[\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00010\u0001\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\r*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u000e\u001a\u00020\t2\b\b\u0002\u0010\u000f\u001a\u00020\u00022#\u0010\u0012\u001a\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00010\u0010¢\u0006\u0002\b\u0011H\u0007\u001a\u0017\u0010\u0015\u001a\u00020\u00142\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, m12616d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/h;", "", "capacity", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "b", "a", "g", "Lkotlin/coroutines/f;", "context", "h", "e", "R", "flowContext", "bufferSize", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "builder", "i", "Lkotlin/f1;", "f", "(Lkotlin/coroutines/f;)V", "kotlinx-coroutines-core"}, m12615k = 5, m12614mv = {1, 4, 0}, m12611xs = "kotlinx/coroutines/flow/FlowKt")
/* renamed from: kotlinx.coroutines.flow.n */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final /* synthetic */ class C15016n {

    /* compiled from: SafeCollector.common.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J!\u0010\u0005\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\u0000"}, m12616d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/h;", "Lkotlinx/coroutines/flow/i;", "collector", "Lkotlin/f1;", "e", "(Lkotlinx/coroutines/flow/i;Lkotlin/coroutines/c;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.flow.n$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15017a<R> implements InterfaceC14958h<R> {

        /* renamed from: a */
        final /* synthetic */ InterfaceC14958h f42892a;

        /* renamed from: b */
        final /* synthetic */ int f42893b;

        /* renamed from: c */
        final /* synthetic */ InterfaceC15280l f42894c;

        /* renamed from: d */
        final /* synthetic */ CoroutineContext f42895d;

        /* compiled from: Collect.kt */
        @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006¸\u0006\u0007"}, m12616d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/i;", DomainCampaignEx.LOOPBACK_VALUE, "Lkotlin/f1;", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/c;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__ContextKt$$special$$inlined$collect$1"}, m12615k = 1, m12614mv = {1, 4, 0})
        /* renamed from: kotlinx.coroutines.flow.n$a$a */
        /* loaded from: E:\fuckcool\tsn\5406560.dex */
        public static final class C15018a implements FlowCollector<R> {

            /* renamed from: a */
            final /* synthetic */ FlowCollector f42896a;

            public C15018a(FlowCollector flowCollector) {
                this.f42896a = flowCollector;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            @Nullable
            public Object emit(Object obj, @NotNull InterfaceC14268c interfaceC14268c) {
                Object m8642h;
                Object emit = this.f42896a.emit(obj, interfaceC14268c);
                m8642h = C14287b.m8642h();
                return emit == m8642h ? emit : Unit.f41048a;
            }
        }

        public C15017a(InterfaceC14958h interfaceC14958h, int i, InterfaceC15280l interfaceC15280l, CoroutineContext coroutineContext) {
            this.f42892a = interfaceC14958h;
            this.f42893b = i;
            this.f42894c = interfaceC15280l;
            this.f42895d = coroutineContext;
        }

        @Override // kotlinx.coroutines.flow.InterfaceC14958h
        @Nullable
        /* renamed from: e */
        public Object mo4470e(@NotNull FlowCollector flowCollector, @NotNull InterfaceC14268c interfaceC14268c) {
            InterfaceC14958h m4550d;
            InterfaceC14958h m4550d2;
            Object m8642h;
            m4550d = C15016n.m4550d(C15006k.m4692S0(this.f42892a, interfaceC14268c.getContext().minusKey(Job.f42281m0)), this.f42893b, null, 2, null);
            m4550d2 = C15016n.m4550d(C15006k.m4692S0((InterfaceC14958h) this.f42894c.invoke(m4550d), this.f42895d), this.f42893b, null, 2, null);
            Object mo4470e = m4550d2.mo4470e(new C15018a(flowCollector), interfaceC14268c);
            m8642h = C14287b.m8642h();
            return mo4470e == m8642h ? mo4470e : Unit.f41048a;
        }
    }

    @Annotations(level = DeprecationLevel.HIDDEN, message = "Since 1.4.0, binary compatibility with earlier versions")
    @NotNull
    /* renamed from: a */
    public static final /* synthetic */ <T> InterfaceC14958h<T> m4553a(@NotNull InterfaceC14958h<? extends T> interfaceC14958h, int i) {
        InterfaceC14958h<T> m4550d;
        m4550d = m4550d(interfaceC14958h, i, null, 2, null);
        return m4550d;
    }

    @NotNull
    /* renamed from: b */
    public static final <T> InterfaceC14958h<T> m4552b(@NotNull InterfaceC14958h<? extends T> interfaceC14958h, int i, @NotNull BufferOverflow bufferOverflow) {
        int i2;
        BufferOverflow bufferOverflow2;
        boolean z = true;
        if (i >= 0 || i == -2 || i == -1) {
            if (i == -1 && bufferOverflow != BufferOverflow.SUSPEND) {
                z = false;
            }
            if (z) {
                if (i == -1) {
                    bufferOverflow2 = BufferOverflow.DROP_OLDEST;
                    i2 = 0;
                } else {
                    i2 = i;
                    bufferOverflow2 = bufferOverflow;
                }
                return interfaceC14958h instanceof InterfaceC14996o ? InterfaceC14996o.C14997a.m4761a((InterfaceC14996o) interfaceC14958h, null, i2, bufferOverflow2, 1, null) : new C14986h(interfaceC14958h, null, i2, bufferOverflow2, 2, null);
            }
            throw new IllegalArgumentException("CONFLATED capacity cannot be used with non-default onBufferOverflow".toString());
        }
        throw new IllegalArgumentException(("Buffer size should be non-negative, BUFFERED, or CONFLATED, but was " + i).toString());
    }

    /* renamed from: c */
    public static /* synthetic */ InterfaceC14958h m4551c(InterfaceC14958h interfaceC14958h, int i, int i2, Object obj) {
        InterfaceC14958h m4553a;
        if ((i2 & 1) != 0) {
            i = -2;
        }
        m4553a = m4553a(interfaceC14958h, i);
        return m4553a;
    }

    /* renamed from: d */
    public static /* synthetic */ InterfaceC14958h m4550d(InterfaceC14958h interfaceC14958h, int i, BufferOverflow bufferOverflow, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = -2;
        }
        if ((i2 & 2) != 0) {
            bufferOverflow = BufferOverflow.SUSPEND;
        }
        return C15006k.m4605q(interfaceC14958h, i, bufferOverflow);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    /* renamed from: e */
    public static final <T> InterfaceC14958h<T> m4549e(@NotNull InterfaceC14958h<? extends T> interfaceC14958h) {
        return interfaceC14958h instanceof InterfaceC14945c ? interfaceC14958h : new C14946d(interfaceC14958h);
    }

    /* renamed from: f */
    private static final void m4548f(CoroutineContext coroutineContext) {
        if (coroutineContext.get(Job.f42281m0) == null) {
            return;
        }
        throw new IllegalArgumentException(("Flow context cannot contain job in it. Had " + coroutineContext).toString());
    }

    @NotNull
    /* renamed from: g */
    public static final <T> InterfaceC14958h<T> m4547g(@NotNull InterfaceC14958h<? extends T> interfaceC14958h) {
        InterfaceC14958h<T> m4550d;
        m4550d = m4550d(interfaceC14958h, -1, null, 2, null);
        return m4550d;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    /* renamed from: h */
    public static final <T> InterfaceC14958h<T> m4546h(@NotNull InterfaceC14958h<? extends T> interfaceC14958h, @NotNull CoroutineContext coroutineContext) {
        m4548f(coroutineContext);
        return C14342f0.m8193g(coroutineContext, EmptyCoroutineContext.INSTANCE) ? interfaceC14958h : interfaceC14958h instanceof InterfaceC14996o ? InterfaceC14996o.C14997a.m4761a((InterfaceC14996o) interfaceC14958h, coroutineContext, 0, null, 6, null) : new C14986h(interfaceC14958h, coroutineContext, 0, null, 12, null);
    }

    @Annotations(level = DeprecationLevel.ERROR, message = "flowWith is deprecated without replacement, please refer to its KDoc for an explanation")
    @FlowPreview
    @NotNull
    /* renamed from: i */
    public static final <T, R> InterfaceC14958h<R> m4545i(@NotNull InterfaceC14958h<? extends T> interfaceC14958h, @NotNull CoroutineContext coroutineContext, int i, @NotNull InterfaceC15280l<? super InterfaceC14958h<? extends T>, ? extends InterfaceC14958h<? extends R>> interfaceC15280l) {
        m4548f(coroutineContext);
        return new C15017a(interfaceC14958h, i, interfaceC15280l, coroutineContext);
    }

    /* renamed from: j */
    public static /* synthetic */ InterfaceC14958h m4544j(InterfaceC14958h interfaceC14958h, CoroutineContext coroutineContext, int i, InterfaceC15280l interfaceC15280l, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = -2;
        }
        return C15006k.m4683V0(interfaceC14958h, coroutineContext, i, interfaceC15280l);
    }
}

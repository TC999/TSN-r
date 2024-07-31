package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import com.kuaishou.weapon.p205p0.C7304t;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.tencent.connect.common.Constants;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.InterfaceC14268c;
import kotlin.coroutines.intrinsics.C14287b;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.channels.BroadcastChannel;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.InterfaceC14686b0;
import kotlinx.coroutines.channels.InterfaceC14695d0;
import kotlinx.coroutines.flow.internal.ChannelFlow;
import kotlinx.coroutines.flow.internal.SendingCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Channels.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B;\u0012\f\u0010'\u001a\b\u0012\u0004\u0012\u00028\u00000\u001b\u0012\u0006\u0010*\u001a\u00020(\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b+\u0010,J\u000f\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J-\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0014¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000f\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J!\u0010\u0013\u001a\u00020\u00032\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011H\u0094@ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014J%\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u00182\u0006\u0010\u0012\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u001d\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u001b2\u0006\u0010\u0012\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ!\u0010 \u001a\u00020\u00032\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000\u001eH\u0096@ø\u0001\u0000¢\u0006\u0004\b \u0010!J\u000f\u0010#\u001a\u00020\"H\u0014¢\u0006\u0004\b#\u0010$R\u001a\u0010'\u001a\b\u0012\u0004\u0012\u00028\u00000\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010*\u001a\u00020(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010)\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006-"}, m12616d2 = {"Lkotlinx/coroutines/flow/e;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/internal/e;", "Lkotlin/f1;", "p", "()V", "Lkotlin/coroutines/f;", "context", "", "capacity", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "k", "(Lkotlin/coroutines/f;ILkotlinx/coroutines/channels/BufferOverflow;)Lkotlinx/coroutines/flow/internal/e;", "Lkotlinx/coroutines/flow/h;", C7304t.f25048d, "()Lkotlinx/coroutines/flow/h;", "Lkotlinx/coroutines/channels/b0;", Constants.PARAM_SCOPE, "j", "(Lkotlinx/coroutines/channels/b0;Lkotlin/coroutines/c;)Ljava/lang/Object;", "Lkotlinx/coroutines/q0;", "Lkotlinx/coroutines/CoroutineStart;", CampaignEx.JSON_NATIVE_VIDEO_START, "Lkotlinx/coroutines/channels/j;", "h", "(Lkotlinx/coroutines/q0;Lkotlinx/coroutines/CoroutineStart;)Lkotlinx/coroutines/channels/j;", "Lkotlinx/coroutines/channels/d0;", "o", "(Lkotlinx/coroutines/q0;)Lkotlinx/coroutines/channels/d0;", "Lkotlinx/coroutines/flow/i;", "collector", "e", "(Lkotlinx/coroutines/flow/i;Lkotlin/coroutines/c;)Ljava/lang/Object;", "", "f", "()Ljava/lang/String;", "d", "Lkotlinx/coroutines/channels/d0;", "channel", "", "Z", "consume", "<init>", "(Lkotlinx/coroutines/channels/d0;ZLkotlin/coroutines/f;ILkotlinx/coroutines/channels/BufferOverflow;)V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.flow.e */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class C14950e<T> extends ChannelFlow<T> {

    /* renamed from: f */
    private static final AtomicIntegerFieldUpdater f42691f = AtomicIntegerFieldUpdater.newUpdater(C14950e.class, "consumed");
    private volatile int consumed;

    /* renamed from: d */
    private final InterfaceC14695d0<T> f42692d;

    /* renamed from: e */
    private final boolean f42693e;

    public /* synthetic */ C14950e(InterfaceC14695d0 interfaceC14695d0, boolean z, CoroutineContext coroutineContext, int i, BufferOverflow bufferOverflow, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(interfaceC14695d0, z, (i2 & 4) != 0 ? EmptyCoroutineContext.INSTANCE : coroutineContext, (i2 & 8) != 0 ? -3 : i, (i2 & 16) != 0 ? BufferOverflow.SUSPEND : bufferOverflow);
    }

    /* renamed from: p */
    private final void m4818p() {
        if (this.f42693e) {
            if (!(f42691f.getAndSet(this, 1) == 0)) {
                throw new IllegalStateException("ReceiveChannel.consumeAsFlow can be collected just once".toString());
            }
        }
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow, kotlinx.coroutines.flow.InterfaceC14958h
    @Nullable
    /* renamed from: e */
    public Object mo4470e(@NotNull FlowCollector<? super T> flowCollector, @NotNull InterfaceC14268c<? super Unit> interfaceC14268c) {
        Object m8642h;
        Object m8642h2;
        if (this.f42815b == -3) {
            m4818p();
            Object m4562f = C15008l.m4562f(flowCollector, this.f42692d, this.f42693e, interfaceC14268c);
            m8642h2 = C14287b.m8642h();
            if (m4562f == m8642h2) {
                return m4562f;
            }
        } else {
            Object mo4470e = super.mo4470e(flowCollector, interfaceC14268c);
            m8642h = C14287b.m8642h();
            if (mo4470e == m8642h) {
                return mo4470e;
            }
        }
        return Unit.f41048a;
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    @NotNull
    /* renamed from: f */
    protected String mo4785f() {
        return "channel=" + this.f42692d;
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    @NotNull
    /* renamed from: h */
    public BroadcastChannel<T> mo4784h(@NotNull CoroutineScope coroutineScope, @NotNull CoroutineStart coroutineStart) {
        m4818p();
        return super.mo4784h(coroutineScope, coroutineStart);
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    @Nullable
    /* renamed from: j */
    protected Object mo4770j(@NotNull InterfaceC14686b0<? super T> interfaceC14686b0, @NotNull InterfaceC14268c<? super Unit> interfaceC14268c) {
        Object m8642h;
        Object m4562f = C15008l.m4562f(new SendingCollector(interfaceC14686b0), this.f42692d, this.f42693e, interfaceC14268c);
        m8642h = C14287b.m8642h();
        return m4562f == m8642h ? m4562f : Unit.f41048a;
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    @NotNull
    /* renamed from: k */
    protected ChannelFlow<T> mo4769k(@NotNull CoroutineContext coroutineContext, int i, @NotNull BufferOverflow bufferOverflow) {
        return new C14950e(this.f42692d, this.f42693e, coroutineContext, i, bufferOverflow);
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    @Nullable
    /* renamed from: l */
    public InterfaceC14958h<T> mo4772l() {
        return new C14950e(this.f42692d, this.f42693e, null, 0, null, 28, null);
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    @NotNull
    /* renamed from: o */
    public InterfaceC14695d0<T> mo4768o(@NotNull CoroutineScope coroutineScope) {
        m4818p();
        if (this.f42815b == -3) {
            return this.f42692d;
        }
        return super.mo4768o(coroutineScope);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public C14950e(@NotNull InterfaceC14695d0<? extends T> interfaceC14695d0, boolean z, @NotNull CoroutineContext coroutineContext, int i, @NotNull BufferOverflow bufferOverflow) {
        super(coroutineContext, i, bufferOverflow);
        this.f42692d = interfaceC14695d0;
        this.f42693e = z;
        this.consumed = 0;
    }
}

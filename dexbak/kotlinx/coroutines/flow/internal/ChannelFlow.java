package kotlinx.coroutines.flow.internal;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kuaishou.weapon.p205p0.C7304t;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.tencent.connect.common.Constants;
import java.util.ArrayList;
import kotlin.C14294d0;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections._Collections;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.InterfaceC14268c;
import kotlin.coroutines.intrinsics.C14287b;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmPlatformAnnotations;
import kotlin.jvm.internal.C14342f0;
import kotlinx.coroutines.C15162r0;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.DebugStrings;
import kotlinx.coroutines.InternalCoroutinesApi;
import kotlinx.coroutines.channels.BroadcastChannel;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.C14715m;
import kotlinx.coroutines.channels.C14739z;
import kotlinx.coroutines.channels.InterfaceC14686b0;
import kotlinx.coroutines.channels.InterfaceC14695d0;
import kotlinx.coroutines.flow.C15006k;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.InterfaceC14958h;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15284p;

@InternalCoroutinesApi
@Metadata(m12618bv = {}, m12617d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\b'\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u001f\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b.\u0010/J\u0010\u0010\u0004\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0003H\u0016J&\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016J&\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH$J!\u0010\u0010\u001a\u00020\u000f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\rH¤@ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011J\u001e\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u00152\u0006\u0010\u000e\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\u0016\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u00172\u0006\u0010\u000e\u001a\u00020\u0012H\u0016J!\u0010\u001b\u001a\u00020\u000f2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00000\u0019H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001cJ\n\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0014J\b\u0010\u001f\u001a\u00020\u001dH\u0016R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010 R\u0014\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010'\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&R9\u0010-\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0)\u0012\u0006\u0012\u0004\u0018\u00010*0(8@X\u0080\u0004ø\u0001\u0000¢\u0006\u0006\u001a\u0004\b+\u0010,\u0082\u0002\u0004\n\u0002\b\u0019¨\u00060"}, m12616d2 = {"Lkotlinx/coroutines/flow/internal/e;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/internal/o;", "Lkotlinx/coroutines/flow/h;", C7304t.f25048d, "Lkotlin/coroutines/f;", "context", "", "capacity", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "a", "k", "Lkotlinx/coroutines/channels/b0;", Constants.PARAM_SCOPE, "Lkotlin/f1;", "j", "(Lkotlinx/coroutines/channels/b0;Lkotlin/coroutines/c;)Ljava/lang/Object;", "Lkotlinx/coroutines/q0;", "Lkotlinx/coroutines/CoroutineStart;", CampaignEx.JSON_NATIVE_VIDEO_START, "Lkotlinx/coroutines/channels/j;", "h", "Lkotlinx/coroutines/channels/d0;", "o", "Lkotlinx/coroutines/flow/i;", "collector", "e", "(Lkotlinx/coroutines/flow/i;Lkotlin/coroutines/c;)Ljava/lang/Object;", "", "f", "toString", "Lkotlin/coroutines/f;", "b", "I", "c", "Lkotlinx/coroutines/channels/BufferOverflow;", "n", "()I", "produceCapacity", "Lkotlin/Function2;", "Lkotlin/coroutines/c;", "", "m", "()Ll1/p;", "collectToFun", "<init>", "(Lkotlin/coroutines/f;ILkotlinx/coroutines/channels/BufferOverflow;)V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.flow.internal.e */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public abstract class ChannelFlow<T> implements InterfaceC14996o<T> {
    @JvmPlatformAnnotations
    @NotNull

    /* renamed from: a */
    public final CoroutineContext f42814a;
    @JvmPlatformAnnotations

    /* renamed from: b */
    public final int f42815b;
    @JvmPlatformAnnotations
    @NotNull

    /* renamed from: c */
    public final BufferOverflow f42816c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ChannelFlow.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, m12616d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/q0;", "Lkotlin/f1;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 4, 0})
    @DebugMetadata(m8639c = "kotlinx.coroutines.flow.internal.ChannelFlow$collect$2", m8638f = "ChannelFlow.kt", m8637i = {0}, m8636l = {TTDownloadField.CALL_DOWNLOAD_MODEL_SET_LOG_EXTRA}, m8635m = "invokeSuspend", m8634n = {"$this$coroutineScope"}, m8633s = {"L$0"})
    /* renamed from: kotlinx.coroutines.flow.internal.e$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14981a extends SuspendLambda implements InterfaceC15284p<CoroutineScope, InterfaceC14268c<? super Unit>, Object> {

        /* renamed from: a */
        private CoroutineScope f42817a;

        /* renamed from: b */
        Object f42818b;

        /* renamed from: c */
        int f42819c;

        /* renamed from: e */
        final /* synthetic */ FlowCollector f42821e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C14981a(FlowCollector flowCollector, InterfaceC14268c interfaceC14268c) {
            super(2, interfaceC14268c);
            this.f42821e = flowCollector;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final InterfaceC14268c<Unit> create(@Nullable Object obj, @NotNull InterfaceC14268c<?> interfaceC14268c) {
            C14981a c14981a = new C14981a(this.f42821e, interfaceC14268c);
            c14981a.f42817a = (CoroutineScope) obj;
            return c14981a;
        }

        @Override // p617l1.InterfaceC15284p
        public final Object invoke(CoroutineScope coroutineScope, InterfaceC14268c<? super Unit> interfaceC14268c) {
            return ((C14981a) create(coroutineScope, interfaceC14268c)).invokeSuspend(Unit.f41048a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object m8642h;
            m8642h = C14287b.m8642h();
            int i = this.f42819c;
            if (i == 0) {
                C14294d0.m8596n(obj);
                CoroutineScope coroutineScope = this.f42817a;
                FlowCollector flowCollector = this.f42821e;
                InterfaceC14695d0<T> mo4768o = ChannelFlow.this.mo4768o(coroutineScope);
                this.f42818b = coroutineScope;
                this.f42819c = 1;
                if (C15006k.m4604q0(flowCollector, mo4768o, this) == m8642h) {
                    return m8642h;
                }
            } else if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                CoroutineScope coroutineScope2 = (CoroutineScope) this.f42818b;
                C14294d0.m8596n(obj);
            }
            return Unit.f41048a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ChannelFlow.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00002\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, m12616d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/channels/b0;", "it", "Lkotlin/f1;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 4, 0})
    @DebugMetadata(m8639c = "kotlinx.coroutines.flow.internal.ChannelFlow$collectToFun$1", m8638f = "ChannelFlow.kt", m8637i = {0}, m8636l = {60}, m8635m = "invokeSuspend", m8634n = {"it"}, m8633s = {"L$0"})
    /* renamed from: kotlinx.coroutines.flow.internal.e$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14982b extends SuspendLambda implements InterfaceC15284p<InterfaceC14686b0<? super T>, InterfaceC14268c<? super Unit>, Object> {

        /* renamed from: a */
        private InterfaceC14686b0 f42822a;

        /* renamed from: b */
        Object f42823b;

        /* renamed from: c */
        int f42824c;

        C14982b(InterfaceC14268c interfaceC14268c) {
            super(2, interfaceC14268c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final InterfaceC14268c<Unit> create(@Nullable Object obj, @NotNull InterfaceC14268c<?> interfaceC14268c) {
            C14982b c14982b = new C14982b(interfaceC14268c);
            c14982b.f42822a = (InterfaceC14686b0) obj;
            return c14982b;
        }

        @Override // p617l1.InterfaceC15284p
        public final Object invoke(Object obj, InterfaceC14268c<? super Unit> interfaceC14268c) {
            return ((C14982b) create(obj, interfaceC14268c)).invokeSuspend(Unit.f41048a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object m8642h;
            m8642h = C14287b.m8642h();
            int i = this.f42824c;
            if (i == 0) {
                C14294d0.m8596n(obj);
                InterfaceC14686b0<? super T> interfaceC14686b0 = this.f42822a;
                ChannelFlow channelFlow = ChannelFlow.this;
                this.f42823b = interfaceC14686b0;
                this.f42824c = 1;
                if (channelFlow.mo4770j(interfaceC14686b0, this) == m8642h) {
                    return m8642h;
                }
            } else if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                InterfaceC14686b0 interfaceC14686b02 = (InterfaceC14686b0) this.f42823b;
                C14294d0.m8596n(obj);
            }
            return Unit.f41048a;
        }
    }

    public ChannelFlow(@NotNull CoroutineContext coroutineContext, int i, @NotNull BufferOverflow bufferOverflow) {
        this.f42814a = coroutineContext;
        this.f42815b = i;
        this.f42816c = bufferOverflow;
    }

    /* renamed from: i */
    static /* synthetic */ Object m4783i(ChannelFlow channelFlow, FlowCollector flowCollector, InterfaceC14268c interfaceC14268c) {
        Object m8642h;
        Object m3840g = C15162r0.m3840g(new C14981a(flowCollector, null), interfaceC14268c);
        m8642h = C14287b.m8642h();
        return m3840g == m8642h ? m3840g : Unit.f41048a;
    }

    /* renamed from: n */
    private final int m4781n() {
        int i = this.f42815b;
        if (i == -3) {
            return -2;
        }
        return i;
    }

    @Override // kotlinx.coroutines.flow.internal.InterfaceC14996o
    @NotNull
    /* renamed from: a */
    public InterfaceC14958h<T> mo4473a(@NotNull CoroutineContext coroutineContext, int i, @NotNull BufferOverflow bufferOverflow) {
        CoroutineContext plus = coroutineContext.plus(this.f42814a);
        if (bufferOverflow == BufferOverflow.SUSPEND) {
            int i2 = this.f42815b;
            if (i2 != -3) {
                if (i != -3) {
                    if (i2 != -2) {
                        if (i != -2 && (i2 = i2 + i) < 0) {
                            i = Integer.MAX_VALUE;
                        }
                    }
                }
                i = i2;
            }
            bufferOverflow = this.f42816c;
        }
        return (C14342f0.m8193g(plus, this.f42814a) && i == this.f42815b && bufferOverflow == this.f42816c) ? this : mo4769k(plus, i, bufferOverflow);
    }

    @Override // kotlinx.coroutines.flow.InterfaceC14958h
    @Nullable
    /* renamed from: e */
    public Object mo4470e(@NotNull FlowCollector<? super T> flowCollector, @NotNull InterfaceC14268c<? super Unit> interfaceC14268c) {
        return m4783i(this, flowCollector, interfaceC14268c);
    }

    @Nullable
    /* renamed from: f */
    protected String mo4785f() {
        return null;
    }

    @NotNull
    /* renamed from: h */
    public BroadcastChannel<T> mo4784h(@NotNull CoroutineScope coroutineScope, @NotNull CoroutineStart coroutineStart) {
        int m4781n;
        int i = C14980d.f42813a[this.f42816c.ordinal()];
        if (i == 1) {
            m4781n = m4781n();
        } else if (i != 2) {
            if (i != 3) {
                throw new NoWhenBranchMatchedException();
            }
            throw new IllegalArgumentException("Broadcast channel does not support BufferOverflow.DROP_LATEST");
        } else {
            m4781n = -1;
        }
        return C14715m.m5420c(coroutineScope, this.f42814a, m4781n, coroutineStart, null, m4782m(), 8, null);
    }

    @Nullable
    /* renamed from: j */
    protected abstract Object mo4770j(@NotNull InterfaceC14686b0<? super T> interfaceC14686b0, @NotNull InterfaceC14268c<? super Unit> interfaceC14268c);

    @NotNull
    /* renamed from: k */
    protected abstract ChannelFlow<T> mo4769k(@NotNull CoroutineContext coroutineContext, int i, @NotNull BufferOverflow bufferOverflow);

    @Nullable
    /* renamed from: l */
    public InterfaceC14958h<T> mo4772l() {
        return null;
    }

    @NotNull
    /* renamed from: m */
    public final InterfaceC15284p<InterfaceC14686b0<? super T>, InterfaceC14268c<? super Unit>, Object> m4782m() {
        return new C14982b(null);
    }

    @NotNull
    /* renamed from: o */
    public InterfaceC14695d0<T> mo4768o(@NotNull CoroutineScope coroutineScope) {
        return C14739z.m5162g(coroutineScope, this.f42814a, m4781n(), this.f42816c, CoroutineStart.ATOMIC, null, m4782m(), 16, null);
    }

    @NotNull
    public String toString() {
        String m12151Z2;
        ArrayList arrayList = new ArrayList(4);
        String mo4785f = mo4785f();
        if (mo4785f != null) {
            arrayList.add(mo4785f);
        }
        if (this.f42814a != EmptyCoroutineContext.INSTANCE) {
            arrayList.add("context=" + this.f42814a);
        }
        if (this.f42815b != -3) {
            arrayList.add("capacity=" + this.f42815b);
        }
        if (this.f42816c != BufferOverflow.SUSPEND) {
            arrayList.add("onBufferOverflow=" + this.f42816c);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(DebugStrings.m3554a(this));
        sb.append('[');
        m12151Z2 = _Collections.m12151Z2(arrayList, ", ", null, null, 0, null, null, 62, null);
        sb.append(m12151Z2);
        sb.append(']');
        return sb.toString();
    }
}

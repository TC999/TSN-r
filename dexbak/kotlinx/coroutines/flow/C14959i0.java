package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import com.umeng.analytics.pro.UMCommonContent;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsJVM;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.InterfaceC14268c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.C14342f0;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.internal.AbstractSharedFlow;
import kotlinx.coroutines.flow.internal.InterfaceC14996o;
import kotlinx.coroutines.flow.internal.NullSurrogate;
import kotlinx.coroutines.internal.Symbol;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: StateFlow.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\u0006\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0012\u0004\u0012\u00028\u00000\u00042\b\u0012\u0004\u0012\u00028\u00000\u00052\b\u0012\u0004\u0012\u00028\u00000\u0006B\u000f\u0012\u0006\u00106\u001a\u00020\u0007¢\u0006\u0004\b7\u00100J!\u0010\u000b\u001a\u00020\n2\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u000f\u001a\u00020\n2\u0006\u0010\r\u001a\u00028\u00002\u0006\u0010\u000e\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u000f\u0010\fJ\u0017\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u001b\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J!\u0010\u001a\u001a\u00020\u00132\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u0018H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u001c\u0010\u001dJ\u001f\u0010!\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030 2\u0006\u0010\u001f\u001a\u00020\u001eH\u0014¢\u0006\u0004\b!\u0010\"J-\u0010)\u001a\b\u0012\u0004\u0012\u00028\u00000(2\u0006\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020\u001e2\u0006\u0010'\u001a\u00020&H\u0016¢\u0006\u0004\b)\u0010*R\u0016\u0010,\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010+R*\u0010\u0010\u001a\u00028\u00002\u0006\u0010\u0010\u001a\u00028\u00008V@VX\u0096\u000e¢\u0006\u0012\u0012\u0004\b1\u0010\u0017\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001a\u00105\u001a\b\u0012\u0004\u0012\u00028\u0000028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b3\u00104\u0082\u0002\u0004\n\u0002\b\u0019¨\u00068"}, m12616d2 = {"Lkotlinx/coroutines/flow/i0;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/internal/a;", "Lkotlinx/coroutines/flow/k0;", "Lkotlinx/coroutines/flow/t;", "Lkotlinx/coroutines/flow/c;", "Lkotlinx/coroutines/flow/internal/o;", "", "expectedState", "newState", "", "v", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "expect", "update", "compareAndSet", DomainCampaignEx.LOOPBACK_VALUE, "b", "(Ljava/lang/Object;)Z", "Lkotlin/f1;", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/c;)Ljava/lang/Object;", "g", "()V", "Lkotlinx/coroutines/flow/i;", "collector", "e", "(Lkotlinx/coroutines/flow/i;Lkotlin/coroutines/c;)Ljava/lang/Object;", "s", "()Lkotlinx/coroutines/flow/k0;", "", "size", "", UMCommonContent.f37782aL, "(I)[Lkotlinx/coroutines/flow/k0;", "Lkotlin/coroutines/f;", "context", "capacity", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "Lkotlinx/coroutines/flow/h;", "a", "(Lkotlin/coroutines/f;ILkotlinx/coroutines/channels/BufferOverflow;)Lkotlinx/coroutines/flow/h;", "I", "sequence", "getValue", "()Ljava/lang/Object;", "setValue", "(Ljava/lang/Object;)V", "getValue$annotations", "", "d", "()Ljava/util/List;", "replayCache", "initialState", "<init>", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.flow.i0 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
final class C14959i0<T> extends AbstractSharedFlow<C15007k0> implements InterfaceC15044t<T>, InterfaceC14945c<T>, InterfaceC14996o<T> {
    private volatile Object _state;

    /* renamed from: e */
    private int f42706e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: StateFlow.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0007\u001a\u0004\u0018\u00010\u0006\"\u0004\b\u0000\u0010\u00002\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0096@"}, m12616d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/i;", "collector", "Lkotlin/coroutines/c;", "Lkotlin/f1;", "continuation", "", "collect"}, m12615k = 3, m12614mv = {1, 4, 0})
    @DebugMetadata(m8639c = "kotlinx.coroutines.flow.StateFlowImpl", m8638f = "StateFlow.kt", m8637i = {0, 0, 0, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2}, m8636l = {330, 388, 347}, m8635m = "collect", m8634n = {"this", "collector", "slot", "this", "collector", "slot", "collectorJob", "oldState", "newState", "this", "collector", "slot", "collectorJob", "oldState", "newState"}, m8633s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5"})
    /* renamed from: kotlinx.coroutines.flow.i0$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14960a extends ContinuationImpl {

        /* renamed from: a */
        /* synthetic */ Object f42707a;

        /* renamed from: b */
        int f42708b;

        /* renamed from: d */
        Object f42710d;

        /* renamed from: e */
        Object f42711e;

        /* renamed from: f */
        Object f42712f;

        /* renamed from: g */
        Object f42713g;

        /* renamed from: h */
        Object f42714h;

        /* renamed from: i */
        Object f42715i;

        C14960a(InterfaceC14268c interfaceC14268c) {
            super(interfaceC14268c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f42707a = obj;
            this.f42708b |= Integer.MIN_VALUE;
            return C14959i0.this.mo4470e(null, this);
        }
    }

    public C14959i0(@NotNull Object obj) {
        this._state = obj;
    }

    /* renamed from: u */
    public static /* synthetic */ void m4808u() {
    }

    /* renamed from: v */
    private final boolean m4807v(Object obj, Object obj2) {
        int i;
        C15007k0[] m4788q;
        m4788q();
        synchronized (this) {
            Object obj3 = this._state;
            if (obj != null && (!C14342f0.m8193g(obj3, obj))) {
                return false;
            }
            if (C14342f0.m8193g(obj3, obj2)) {
                return true;
            }
            this._state = obj2;
            int i2 = this.f42706e;
            if ((i2 & 1) == 0) {
                int i3 = i2 + 1;
                this.f42706e = i3;
                C15007k0[] m4788q2 = m4788q();
                Unit unit = Unit.f41048a;
                while (true) {
                    if (m4788q2 != null) {
                        for (C15007k0 c15007k0 : m4788q2) {
                            if (c15007k0 != null) {
                                c15007k0.m4569f();
                            }
                        }
                    }
                    synchronized (this) {
                        i = this.f42706e;
                        if (i == i3) {
                            this.f42706e = i3 + 1;
                            return true;
                        }
                        m4788q = m4788q();
                        Unit unit2 = Unit.f41048a;
                    }
                    m4788q2 = m4788q;
                    i3 = i;
                }
            } else {
                this.f42706e = i2 + 2;
                return true;
            }
        }
    }

    @Override // kotlinx.coroutines.flow.internal.InterfaceC14996o
    @NotNull
    /* renamed from: a */
    public InterfaceC14958h<T> mo4473a(@NotNull CoroutineContext coroutineContext, int i, @NotNull BufferOverflow bufferOverflow) {
        return C15005j0.m4751d(this, coroutineContext, i, bufferOverflow);
    }

    @Override // kotlinx.coroutines.flow.InterfaceC15043s
    /* renamed from: b */
    public boolean mo4472b(T t) {
        setValue(t);
        return true;
    }

    @Override // kotlinx.coroutines.flow.InterfaceC15044t
    public boolean compareAndSet(T t, T t2) {
        if (t == null) {
            t = (T) NullSurrogate.f42850a;
        }
        if (t2 == null) {
            t2 = (T) NullSurrogate.f42850a;
        }
        return m4807v(t, t2);
    }

    @Override // kotlinx.coroutines.flow.InterfaceC15048x
    @NotNull
    /* renamed from: d */
    public List<T> mo4471d() {
        List<T> m8965k;
        m8965k = CollectionsJVM.m8965k(getValue());
        return m8965k;
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x00b4, code lost:
        if ((!kotlin.jvm.internal.C14342f0.m8193g(r12, r13)) != false) goto L26;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00aa A[Catch: all -> 0x0073, TryCatch #0 {all -> 0x0073, blocks: (B:14:0x003e, B:34:0x00a6, B:36:0x00aa, B:38:0x00af, B:49:0x00d4, B:51:0x00da, B:40:0x00b6, B:44:0x00bd, B:19:0x005c, B:22:0x006f, B:33:0x0097), top: B:59:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00af A[Catch: all -> 0x0073, TryCatch #0 {all -> 0x0073, blocks: (B:14:0x003e, B:34:0x00a6, B:36:0x00aa, B:38:0x00af, B:49:0x00d4, B:51:0x00da, B:40:0x00b6, B:44:0x00bd, B:19:0x005c, B:22:0x006f, B:33:0x0097), top: B:59:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00d1 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00da A[Catch: all -> 0x0073, TRY_LEAVE, TryCatch #0 {all -> 0x0073, blocks: (B:14:0x003e, B:34:0x00a6, B:36:0x00aa, B:38:0x00af, B:49:0x00d4, B:51:0x00da, B:40:0x00b6, B:44:0x00bd, B:19:0x005c, B:22:0x006f, B:33:0x0097), top: B:59:0x0024 }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:50:0x00d8 -> B:34:0x00a6). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:52:0x00ec -> B:34:0x00a6). Please submit an issue!!! */
    @Override // kotlinx.coroutines.flow.InterfaceC14958h
    @org.jetbrains.annotations.Nullable
    /* renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object mo4470e(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.FlowCollector<? super T> r12, @org.jetbrains.annotations.NotNull kotlin.coroutines.InterfaceC14268c<? super kotlin.Unit> r13) {
        /*
            Method dump skipped, instructions count: 247
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.C14959i0.mo4470e(kotlinx.coroutines.flow.i, kotlin.coroutines.c):java.lang.Object");
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    @Nullable
    public Object emit(T t, @NotNull InterfaceC14268c<? super Unit> interfaceC14268c) {
        setValue(t);
        return Unit.f41048a;
    }

    @Override // kotlinx.coroutines.flow.InterfaceC15043s
    /* renamed from: g */
    public void mo4469g() {
        throw new UnsupportedOperationException("MutableStateFlow.resetReplayCache is not supported");
    }

    @Override // kotlinx.coroutines.flow.InterfaceC15044t, kotlinx.coroutines.flow.StateFlow
    public T getValue() {
        Symbol symbol = NullSurrogate.f42850a;
        T t = (T) this._state;
        if (t == symbol) {
            return null;
        }
        return t;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.flow.internal.AbstractSharedFlow
    @NotNull
    /* renamed from: s */
    public C15007k0 mo4468l() {
        return new C15007k0();
    }

    @Override // kotlinx.coroutines.flow.InterfaceC15044t
    public void setValue(T t) {
        if (t == null) {
            t = (T) NullSurrogate.f42850a;
        }
        m4807v(null, t);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.flow.internal.AbstractSharedFlow
    @NotNull
    /* renamed from: t */
    public C15007k0[] mo4467m(int i) {
        return new C15007k0[i];
    }
}

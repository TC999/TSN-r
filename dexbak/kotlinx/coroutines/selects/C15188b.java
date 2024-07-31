package kotlinx.coroutines.selects;

import com.baidu.mobads.sdk.api.IAdInterListener;
import com.kuaishou.weapon.p205p0.C7304t;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import com.umeng.analytics.pro.UMCommonContent;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import io.netty.channel.C13675a;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.C14294d0;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.InterfaceC14268c;
import kotlin.coroutines.intrinsics.C14287b;
import kotlin.coroutines.intrinsics.IntrinsicsJvm;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.JvmPlatformAnnotations;
import kotlin.jvm.internal.C14342f0;
import kotlinx.coroutines.AbstractC14779f2;
import kotlinx.coroutines.C15063i0;
import kotlinx.coroutines.C15137n0;
import kotlinx.coroutines.C15157q;
import kotlinx.coroutines.CompletionState;
import kotlinx.coroutines.Delay;
import kotlinx.coroutines.InterfaceC15064i1;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.internal.AbstractC15073c0;
import kotlinx.coroutines.internal.AbstractC15074d;
import kotlinx.coroutines.internal.Atomic;
import kotlinx.coroutines.internal.C15091q;
import kotlinx.coroutines.internal.C15094s;
import kotlinx.coroutines.selects.Select;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15269a;
import p617l1.InterfaceC15280l;
import p617l1.InterfaceC15284p;
import p649u1.C16231a;
import p649u1.Undispatched;

/* compiled from: Select.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\f\b\u0001\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00020\u00022\b\u0012\u0004\u0012\u00028\u00000\u00032\b\u0012\u0004\u0012\u00028\u00000\u00042\b\u0012\u0004\u0012\u00028\u00000\u00052\u00060\u0006j\u0002`\u0007:\u0004[@6FB\u0015\u0012\f\u0010H\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0004\bY\u0010ZJ.\u0010\r\u001a\u00020\u000b2\u000e\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\bH\u0082\b¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0011\u0010\u0010J\u0017\u0010\u0014\u001a\n\u0018\u00010\u0012j\u0004\u0018\u0001`\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J \u0010\u0018\u001a\u00020\u000b2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0016H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u0011\u0010\u001e\u001a\u0004\u0018\u00010\tH\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010!\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u001aH\u0001¢\u0006\u0004\b!\u0010\u001dJ\u0017\u0010$\u001a\u00020\u000b2\u0006\u0010#\u001a\u00020\"H\u0016¢\u0006\u0004\b$\u0010%J\u000f\u0010'\u001a\u00020&H\u0016¢\u0006\u0004\b'\u0010(J\u001b\u0010+\u001a\u0004\u0018\u00010\t2\b\u0010*\u001a\u0004\u0018\u00010)H\u0016¢\u0006\u0004\b+\u0010,J\u0019\u0010/\u001a\u0004\u0018\u00010\t2\u0006\u0010.\u001a\u00020-H\u0016¢\u0006\u0004\b/\u00100J\u000f\u00102\u001a\u000201H\u0016¢\u0006\u0004\b2\u00103J5\u00106\u001a\u00020\u000b*\u0002042\u001c\u0010\f\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0012\u0004\u0018\u00010\t05H\u0096\u0002ø\u0001\u0000¢\u0006\u0004\b6\u00107JG\u0010;\u001a\u00020\u000b\"\u0004\b\u0001\u00108*\b\u0012\u0004\u0012\u00028\u0001092\"\u0010\f\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0012\u0004\u0018\u00010\t0:H\u0096\u0002ø\u0001\u0000¢\u0006\u0004\b;\u0010<J[\u0010@\u001a\u00020\u000b\"\u0004\b\u0001\u0010=\"\u0004\b\u0002\u00108*\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020>2\u0006\u0010?\u001a\u00028\u00012\"\u0010\f\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0012\u0004\u0018\u00010\t0:H\u0096\u0002ø\u0001\u0000¢\u0006\u0004\b@\u0010AJ8\u0010D\u001a\u00020\u000b2\u0006\u0010C\u001a\u00020B2\u001c\u0010\f\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0012\u0004\u0018\u00010\t05H\u0016ø\u0001\u0000¢\u0006\u0004\bD\u0010ER\u001a\u0010H\u001a\b\u0012\u0004\u0012\u00028\u00000\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bF\u0010GR(\u0010L\u001a\u0004\u0018\u00010\"2\b\u0010\n\u001a\u0004\u0018\u00010\"8B@BX\u0082\u000e¢\u0006\f\u001a\u0004\bI\u0010J\"\u0004\bK\u0010%R\u001c\u0010O\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bM\u0010NR\u0014\u0010S\u001a\u00020P8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bQ\u0010RR\u001a\u0010V\u001a\b\u0012\u0004\u0012\u00028\u00000\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bT\u0010UR\u0014\u0010X\u001a\u00020&8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bW\u0010(\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\\"}, m12616d2 = {"Lkotlinx/coroutines/selects/b;", "R", "Lkotlinx/coroutines/internal/q;", "Lkotlinx/coroutines/selects/a;", "Lkotlinx/coroutines/selects/f;", "Lkotlin/coroutines/c;", "Lkotlin/coroutines/jvm/internal/c;", "Lkotlinx/coroutines/internal/CoroutineStackFrame;", "Lkotlin/Function0;", "", DomainCampaignEx.LOOPBACK_VALUE, "Lkotlin/f1;", "block", "k0", "(Ll1/a;Ll1/a;)V", "J", "()V", "j0", "Ljava/lang/StackTraceElement;", "Lkotlinx/coroutines/internal/StackTraceElement;", "getStackTraceElement", "()Ljava/lang/StackTraceElement;", "Lkotlin/Result;", CommonNetImpl.RESULT, "resumeWith", "(Ljava/lang/Object;)V", "", "exception", UMCommonContent.f37782aL, "(Ljava/lang/Throwable;)V", "m0", "()Ljava/lang/Object;", "e", "n0", "Lkotlinx/coroutines/i1;", "handle", "k", "(Lkotlinx/coroutines/i1;)V", "", "o", "()Z", "Lkotlinx/coroutines/internal/s$d;", "otherOp", C7304t.f25048d, "(Lkotlinx/coroutines/internal/s$d;)Ljava/lang/Object;", "Lkotlinx/coroutines/internal/b;", "desc", "u", "(Lkotlinx/coroutines/internal/b;)Ljava/lang/Object;", "", "toString", "()Ljava/lang/String;", "Lkotlinx/coroutines/selects/c;", "Lkotlin/Function1;", "c", "(Lkotlinx/coroutines/selects/c;Ll1/l;)V", "Q", "Lkotlinx/coroutines/selects/d;", "Lkotlin/Function2;", IAdInterListener.AdReqParam.WIDTH, "(Lkotlinx/coroutines/selects/d;Ll1/p;)V", "P", "Lkotlinx/coroutines/selects/e;", "param", "b", "(Lkotlinx/coroutines/selects/e;Ljava/lang/Object;Ll1/p;)V", "", "timeMillis", "m", "(JLl1/l;)V", "d", "Lkotlin/coroutines/c;", "uCont", "l0", "()Lkotlinx/coroutines/i1;", "o0", "parentHandle", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/c;", "callerFrame", "Lkotlin/coroutines/f;", "getContext", "()Lkotlin/coroutines/f;", "context", "s", "()Lkotlin/coroutines/c;", "completion", "i", "isSelected", "<init>", "(Lkotlin/coroutines/c;)V", "a", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
@PublishedApi
/* renamed from: kotlinx.coroutines.selects.b */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class C15188b<R> extends C15091q implements Select<R>, InterfaceC15197f<R>, InterfaceC14268c<R>, CoroutineStackFrame {

    /* renamed from: e */
    static final AtomicReferenceFieldUpdater f43314e = AtomicReferenceFieldUpdater.newUpdater(C15188b.class, Object.class, "_state");

    /* renamed from: f */
    static final AtomicReferenceFieldUpdater f43315f = AtomicReferenceFieldUpdater.newUpdater(C15188b.class, Object.class, "_result");

    /* renamed from: d */
    private final InterfaceC14268c<R> f43316d;
    volatile Object _state = C15198g.m3694f();
    volatile Object _result = C15198g.m3697c();
    private volatile Object _parentHandle = null;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Select.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u001b\u0012\n\u0010\u0016\u001a\u0006\u0012\u0002\b\u00030\u0013\u0012\u0006\u0010\u0019\u001a\u00020\u0017¢\u0006\u0004\b\u001a\u0010\u001bJ\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0002J\u0014\u0010\t\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016J\u001c\u0010\n\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016R\u001a\u0010\u0012\u001a\u00020\r8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0016\u001a\u0006\u0012\u0002\b\u00030\u00138\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0019\u001a\u00020\u00178\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u0018¨\u0006\u001c"}, m12616d2 = {"Lkotlinx/coroutines/selects/b$a;", "Lkotlinx/coroutines/internal/d;", "", "k", "Lkotlin/f1;", C7304t.f25048d, "failure", "j", "affected", "i", "d", "", "toString", "", "b", "J", "g", "()J", "opSequence", "Lkotlinx/coroutines/selects/b;", "c", "Lkotlinx/coroutines/selects/b;", "impl", "Lkotlinx/coroutines/internal/b;", "Lkotlinx/coroutines/internal/b;", "desc", "<init>", "(Lkotlinx/coroutines/selects/b;Lkotlinx/coroutines/internal/b;)V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.selects.b$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15189a extends AbstractC15074d<Object> {

        /* renamed from: b */
        private final long f43317b = C15198g.m3698b().m3684a();
        @JvmPlatformAnnotations
        @NotNull

        /* renamed from: c */
        public final C15188b<?> f43318c;
        @JvmPlatformAnnotations
        @NotNull

        /* renamed from: d */
        public final Atomic f43319d;

        public C15189a(@NotNull C15188b<?> c15188b, @NotNull Atomic atomic) {
            this.f43318c = c15188b;
            this.f43319d = atomic;
            atomic.m4381d(this);
        }

        /* renamed from: j */
        private final void m3710j(Object obj) {
            boolean z = obj == null;
            if (C13675a.m12692a(C15188b.f43314e, this.f43318c, this, z ? null : C15198g.m3694f()) && z) {
                this.f43318c.m3717j0();
            }
        }

        /* renamed from: k */
        private final Object m3709k() {
            C15188b<?> c15188b = this.f43318c;
            while (true) {
                Object obj = c15188b._state;
                if (obj == this) {
                    return null;
                }
                if (obj instanceof AbstractC15073c0) {
                    ((AbstractC15073c0) obj).mo3620c(this.f43318c);
                } else if (obj == C15198g.m3694f()) {
                    if (C13675a.m12692a(C15188b.f43314e, this.f43318c, C15198g.m3694f(), this)) {
                        return null;
                    }
                } else {
                    return C15198g.m3696d();
                }
            }
        }

        /* renamed from: l */
        private final void m3708l() {
            C13675a.m12692a(C15188b.f43314e, this.f43318c, this, C15198g.m3694f());
        }

        @Override // kotlinx.coroutines.internal.AbstractC15074d
        /* renamed from: d */
        public void mo3619d(@Nullable Object obj, @Nullable Object obj2) {
            m3710j(obj2);
            this.f43319d.mo3623a(this, obj2);
        }

        @Override // kotlinx.coroutines.internal.AbstractC15074d
        /* renamed from: g */
        public long mo3711g() {
            return this.f43317b;
        }

        @Override // kotlinx.coroutines.internal.AbstractC15074d
        @Nullable
        /* renamed from: i */
        public Object mo3615i(@Nullable Object obj) {
            Object m3709k;
            if (obj != null || (m3709k = m3709k()) == null) {
                try {
                    return this.f43319d.mo3622c(this);
                } catch (Throwable th) {
                    if (obj == null) {
                        m3708l();
                    }
                    throw th;
                }
            }
            return m3709k;
        }

        @Override // kotlinx.coroutines.internal.AbstractC15073c0
        @NotNull
        public String toString() {
            return "AtomicSelectOp(sequence=" + mo3711g() + ')';
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Select.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\b"}, m12616d2 = {"Lkotlinx/coroutines/selects/b$b;", "Lkotlinx/coroutines/internal/s;", "Lkotlinx/coroutines/i1;", "d", "Lkotlinx/coroutines/i1;", "handle", "<init>", "(Lkotlinx/coroutines/i1;)V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.selects.b$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15190b extends C15094s {
        @JvmPlatformAnnotations
        @NotNull

        /* renamed from: d */
        public final InterfaceC15064i1 f43320d;

        public C15190b(@NotNull InterfaceC15064i1 interfaceC15064i1) {
            this.f43320d = interfaceC15064i1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Select.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\f\u0010\rJ\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\u0014\u0010\b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u001a\u0010\u000b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\n¨\u0006\u000e"}, m12616d2 = {"Lkotlinx/coroutines/selects/b$c;", "Lkotlinx/coroutines/internal/c0;", "", "affected", "c", "Lkotlinx/coroutines/internal/s$d;", "a", "Lkotlinx/coroutines/internal/s$d;", "otherOp", "Lkotlinx/coroutines/internal/d;", "()Lkotlinx/coroutines/internal/d;", "atomicOp", "<init>", "(Lkotlinx/coroutines/internal/s$d;)V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.selects.b$c */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15191c extends AbstractC15073c0 {
        @JvmPlatformAnnotations
        @NotNull

        /* renamed from: a */
        public final C15094s.C15098d f43321a;

        public C15191c(@NotNull C15094s.C15098d c15098d) {
            this.f43321a = c15098d;
        }

        @Override // kotlinx.coroutines.internal.AbstractC15073c0
        @Nullable
        /* renamed from: a */
        public AbstractC15074d<?> mo3621a() {
            return this.f43321a.mo3621a();
        }

        @Override // kotlinx.coroutines.internal.AbstractC15073c0
        @Nullable
        /* renamed from: c */
        public Object mo3620c(@Nullable Object obj) {
            if (obj != null) {
                C15188b c15188b = (C15188b) obj;
                this.f43321a.m4199d();
                Object m4373e = this.f43321a.mo3621a().m4373e(null);
                C13675a.m12692a(C15188b.f43314e, c15188b, this, m4373e == null ? this.f43321a.f43093c : C15198g.m3694f());
                return m4373e;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.selects.SelectBuilderImpl<*>");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Select.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0013\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0096\u0002J\b\u0010\b\u001a\u00020\u0007H\u0016¨\u0006\f"}, m12616d2 = {"Lkotlinx/coroutines/selects/b$d;", "Lkotlinx/coroutines/f2;", "Lkotlinx/coroutines/e2;", "", "cause", "Lkotlin/f1;", "f0", "", "toString", "job", "<init>", "(Lkotlinx/coroutines/selects/b;Lkotlinx/coroutines/e2;)V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.selects.b$d */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public final class C15192d extends AbstractC14779f2<Job> {
        public C15192d(@NotNull Job job) {
            super(job);
        }

        @Override // kotlinx.coroutines.CompletionHandler
        /* renamed from: f0 */
        public void mo3495f0(@Nullable Throwable th) {
            if (C15188b.this.mo3703o()) {
                C15188b.this.mo3701t(this.f43146d.mo3825l());
            }
        }

        @Override // p617l1.InterfaceC15280l
        public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
            mo3495f0(th);
            return Unit.f41048a;
        }

        @Override // kotlinx.coroutines.internal.C15094s
        @NotNull
        public String toString() {
            return "SelectOnCancelling[" + C15188b.this + ']';
        }
    }

    /* compiled from: Runnable.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0004\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002¨\u0006\u0003"}, m12616d2 = {"Lkotlin/f1;", "run", "()V", "kotlinx/coroutines/a3$a", "<anonymous>"}, m12615k = 3, m12614mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.selects.b$e */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class RunnableC15193e implements Runnable {

        /* renamed from: b */
        final /* synthetic */ InterfaceC15280l f43324b;

        public RunnableC15193e(InterfaceC15280l interfaceC15280l) {
            this.f43324b = interfaceC15280l;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (C15188b.this.mo3703o()) {
                C16231a.m228c(this.f43324b, C15188b.this.mo3702s());
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public C15188b(@NotNull InterfaceC14268c<? super R> interfaceC14268c) {
        this.f43316d = interfaceC14268c;
    }

    /* renamed from: J */
    private final void m3719J() {
        Job job = (Job) getContext().get(Job.f42281m0);
        if (job != null) {
            InterfaceC15064i1 m5043f = Job.C14776a.m5043f(job, true, false, new C15192d(job), 2, null);
            m3712o0(m5043f);
            if (mo3706i()) {
                m5043f.dispose();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j0 */
    public final void m3717j0() {
        InterfaceC15064i1 m3715l0 = m3715l0();
        if (m3715l0 != null) {
            m3715l0.dispose();
        }
        Object m4219P = m4219P();
        if (m4219P != null) {
            for (C15094s c15094s = (C15094s) m4219P; !C14342f0.m8193g(c15094s, this); c15094s = c15094s.m4218Q()) {
                if (c15094s instanceof C15190b) {
                    ((C15190b) c15094s).f43320d.dispose();
                }
            }
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
    }

    /* renamed from: k0 */
    private final void m3716k0(InterfaceC15269a<? extends Object> interfaceC15269a, InterfaceC15269a<Unit> interfaceC15269a2) {
        Object m8642h;
        Object m8642h2;
        while (true) {
            Object obj = this._result;
            if (obj == C15198g.m3697c()) {
                if (C13675a.m12692a(f43315f, this, C15198g.m3697c(), interfaceC15269a.invoke())) {
                    return;
                }
            } else {
                m8642h = C14287b.m8642h();
                if (obj != m8642h) {
                    throw new IllegalStateException("Already resumed");
                }
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f43315f;
                m8642h2 = C14287b.m8642h();
                if (C13675a.m12692a(atomicReferenceFieldUpdater, this, m8642h2, C15198g.m3699a())) {
                    interfaceC15269a2.invoke();
                    return;
                }
            }
        }
    }

    /* renamed from: l0 */
    private final InterfaceC15064i1 m3715l0() {
        return (InterfaceC15064i1) this._parentHandle;
    }

    /* renamed from: o0 */
    private final void m3712o0(InterfaceC15064i1 interfaceC15064i1) {
        this._parentHandle = interfaceC15064i1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.selects.Select
    /* renamed from: b */
    public <P, Q> void mo3682b(@NotNull InterfaceC15196e<? super P, ? extends Q> interfaceC15196e, P p, @NotNull InterfaceC15284p<? super Q, ? super InterfaceC14268c<? super R>, ? extends Object> interfaceC15284p) {
        interfaceC15196e.mo3631d(this, p, interfaceC15284p);
    }

    @Override // kotlinx.coroutines.selects.Select
    /* renamed from: c */
    public void mo3681c(@NotNull InterfaceC15194c interfaceC15194c, @NotNull InterfaceC15280l<? super InterfaceC14268c<? super R>, ? extends Object> interfaceC15280l) {
        interfaceC15194c.mo3707u(this, interfaceC15280l);
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    @Nullable
    public CoroutineStackFrame getCallerFrame() {
        InterfaceC14268c<R> interfaceC14268c = this.f43316d;
        if (!(interfaceC14268c instanceof CoroutineStackFrame)) {
            interfaceC14268c = null;
        }
        return (CoroutineStackFrame) interfaceC14268c;
    }

    @Override // kotlin.coroutines.InterfaceC14268c
    @NotNull
    public CoroutineContext getContext() {
        return this.f43316d.getContext();
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    @Nullable
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override // kotlinx.coroutines.selects.InterfaceC15197f
    /* renamed from: i */
    public boolean mo3706i() {
        while (true) {
            Object obj = this._state;
            if (obj == C15198g.m3694f()) {
                return false;
            }
            if (!(obj instanceof AbstractC15073c0)) {
                return true;
            }
            ((AbstractC15073c0) obj).mo3620c(this);
        }
    }

    @Override // kotlinx.coroutines.selects.InterfaceC15197f
    /* renamed from: k */
    public void mo3705k(@NotNull InterfaceC15064i1 interfaceC15064i1) {
        C15190b c15190b = new C15190b(interfaceC15064i1);
        if (!mo3706i()) {
            m4230B(c15190b);
            if (!mo3706i()) {
                return;
            }
        }
        interfaceC15064i1.dispose();
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0031, code lost:
        m3717j0();
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0036, code lost:
        return kotlinx.coroutines.C15157q.f43218d;
     */
    @Override // kotlinx.coroutines.selects.InterfaceC15197f
    @org.jetbrains.annotations.Nullable
    /* renamed from: l */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object mo3704l(@org.jetbrains.annotations.Nullable kotlinx.coroutines.internal.C15094s.C15098d r4) {
        /*
            r3 = this;
        L0:
            java.lang.Object r0 = r3._state
            java.lang.Object r1 = kotlinx.coroutines.selects.C15198g.m3694f()
            r2 = 0
            if (r0 != r1) goto L37
            if (r4 != 0) goto L18
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = kotlinx.coroutines.selects.C15188b.f43314e
            java.lang.Object r1 = kotlinx.coroutines.selects.C15198g.m3694f()
            boolean r0 = io.netty.channel.C13675a.m12692a(r0, r3, r1, r2)
            if (r0 != 0) goto L31
            goto L0
        L18:
            kotlinx.coroutines.selects.b$c r0 = new kotlinx.coroutines.selects.b$c
            r0.<init>(r4)
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = kotlinx.coroutines.selects.C15188b.f43314e
            java.lang.Object r2 = kotlinx.coroutines.selects.C15198g.m3694f()
            boolean r1 = io.netty.channel.C13675a.m12692a(r1, r3, r2, r0)
            if (r1 != 0) goto L2a
            goto L0
        L2a:
            java.lang.Object r4 = r0.mo3620c(r3)
            if (r4 == 0) goto L31
            return r4
        L31:
            r3.m3717j0()
            kotlinx.coroutines.internal.j0 r4 = kotlinx.coroutines.C15157q.f43218d
            return r4
        L37:
            boolean r1 = r0 instanceof kotlinx.coroutines.internal.AbstractC15073c0
            if (r1 == 0) goto L6b
            if (r4 == 0) goto L65
            kotlinx.coroutines.internal.d r1 = r4.mo3621a()
            boolean r2 = r1 instanceof kotlinx.coroutines.selects.C15188b.C15189a
            if (r2 == 0) goto L59
            r2 = r1
            kotlinx.coroutines.selects.b$a r2 = (kotlinx.coroutines.selects.C15188b.C15189a) r2
            kotlinx.coroutines.selects.b<?> r2 = r2.f43318c
            if (r2 == r3) goto L4d
            goto L59
        L4d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r0 = "Cannot use matching select clauses on the same object"
            java.lang.String r0 = r0.toString()
            r4.<init>(r0)
            throw r4
        L59:
            r2 = r0
            kotlinx.coroutines.internal.c0 r2 = (kotlinx.coroutines.internal.AbstractC15073c0) r2
            boolean r1 = r1.m4374b(r2)
            if (r1 == 0) goto L65
            java.lang.Object r4 = kotlinx.coroutines.internal.C15072c.f43034b
            return r4
        L65:
            kotlinx.coroutines.internal.c0 r0 = (kotlinx.coroutines.internal.AbstractC15073c0) r0
            r0.mo3620c(r3)
            goto L0
        L6b:
            if (r4 != 0) goto L6e
            return r2
        L6e:
            kotlinx.coroutines.internal.s$a r4 = r4.f43093c
            if (r0 != r4) goto L75
            kotlinx.coroutines.internal.j0 r4 = kotlinx.coroutines.C15157q.f43218d
            return r4
        L75:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.selects.C15188b.mo3704l(kotlinx.coroutines.internal.s$d):java.lang.Object");
    }

    @Override // kotlinx.coroutines.selects.Select
    /* renamed from: m */
    public void mo3677m(long j, @NotNull InterfaceC15280l<? super InterfaceC14268c<? super R>, ? extends Object> interfaceC15280l) {
        if (j <= 0) {
            if (mo3703o()) {
                Undispatched.m223c(interfaceC15280l, mo3702s());
                return;
            }
            return;
        }
        mo3705k(Delay.m5749d(getContext()).mo3486e(j, new RunnableC15193e(interfaceC15280l), getContext()));
    }

    @PublishedApi
    @Nullable
    /* renamed from: m0 */
    public final Object m3714m0() {
        Object m8642h;
        Object m8642h2;
        if (!mo3706i()) {
            m3719J();
        }
        Object obj = this._result;
        if (obj == C15198g.m3697c()) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f43315f;
            Object m3697c = C15198g.m3697c();
            m8642h = C14287b.m8642h();
            if (C13675a.m12692a(atomicReferenceFieldUpdater, this, m3697c, m8642h)) {
                m8642h2 = C14287b.m8642h();
                return m8642h2;
            }
            obj = this._result;
        }
        if (obj != C15198g.m3699a()) {
            if (obj instanceof CompletionState) {
                throw ((CompletionState) obj).f42189a;
            }
            return obj;
        }
        throw new IllegalStateException("Already resumed");
    }

    @Override // kotlinx.coroutines.selects.Select
    /* renamed from: n */
    public <P, Q> void mo3676n(@NotNull InterfaceC15196e<? super P, ? extends Q> interfaceC15196e, @NotNull InterfaceC15284p<? super Q, ? super InterfaceC14268c<? super R>, ? extends Object> interfaceC15284p) {
        Select.C15187a.m3720a(this, interfaceC15196e, interfaceC15284p);
    }

    @PublishedApi
    /* renamed from: n0 */
    public final void m3713n0(@NotNull Throwable th) {
        if (mo3703o()) {
            Result.C14124a c14124a = Result.Companion;
            resumeWith(Result.m60148constructorimpl(C14294d0.m8609a(th)));
        } else if (th instanceof CancellationException) {
        } else {
            Object m3714m0 = m3714m0();
            if ((m3714m0 instanceof CompletionState) && ((CompletionState) m3714m0).f42189a == th) {
                return;
            }
            C15137n0.m3969b(getContext(), th);
        }
    }

    @Override // kotlinx.coroutines.selects.InterfaceC15197f
    /* renamed from: o */
    public boolean mo3703o() {
        Object mo3704l = mo3704l(null);
        if (mo3704l == C15157q.f43218d) {
            return true;
        }
        if (mo3704l == null) {
            return false;
        }
        throw new IllegalStateException(("Unexpected trySelectIdempotent result " + mo3704l).toString());
    }

    @Override // kotlin.coroutines.InterfaceC14268c
    public void resumeWith(@NotNull Object obj) {
        Object m8642h;
        Object m8642h2;
        while (true) {
            Object obj2 = this._result;
            if (obj2 == C15198g.m3697c()) {
                if (C13675a.m12692a(f43315f, this, C15198g.m3697c(), C15063i0.m4403d(obj, null, 1, null))) {
                    return;
                }
            } else {
                m8642h = C14287b.m8642h();
                if (obj2 != m8642h) {
                    throw new IllegalStateException("Already resumed");
                }
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f43315f;
                m8642h2 = C14287b.m8642h();
                if (C13675a.m12692a(atomicReferenceFieldUpdater, this, m8642h2, C15198g.m3699a())) {
                    if (Result.m60154isFailureimpl(obj)) {
                        InterfaceC14268c<R> interfaceC14268c = this.f43316d;
                        Throwable m60151exceptionOrNullimpl = Result.m60151exceptionOrNullimpl(obj);
                        C14342f0.m8187m(m60151exceptionOrNullimpl);
                        Result.C14124a c14124a = Result.Companion;
                        interfaceC14268c.resumeWith(Result.m60148constructorimpl(C14294d0.m8609a(m60151exceptionOrNullimpl)));
                        return;
                    }
                    this.f43316d.resumeWith(obj);
                    return;
                }
            }
        }
    }

    @Override // kotlinx.coroutines.selects.InterfaceC15197f
    @NotNull
    /* renamed from: s */
    public InterfaceC14268c<R> mo3702s() {
        return this;
    }

    @Override // kotlinx.coroutines.selects.InterfaceC15197f
    /* renamed from: t */
    public void mo3701t(@NotNull Throwable th) {
        Object m8642h;
        Object m8642h2;
        InterfaceC14268c m8650d;
        while (true) {
            Object obj = this._result;
            if (obj == C15198g.m3697c()) {
                if (C13675a.m12692a(f43315f, this, C15198g.m3697c(), new CompletionState(th, false, 2, null))) {
                    return;
                }
            } else {
                m8642h = C14287b.m8642h();
                if (obj != m8642h) {
                    throw new IllegalStateException("Already resumed");
                }
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f43315f;
                m8642h2 = C14287b.m8642h();
                if (C13675a.m12692a(atomicReferenceFieldUpdater, this, m8642h2, C15198g.m3699a())) {
                    m8650d = IntrinsicsJvm.m8650d(this.f43316d);
                    Result.C14124a c14124a = Result.Companion;
                    m8650d.resumeWith(Result.m60148constructorimpl(C14294d0.m8609a(th)));
                    return;
                }
            }
        }
    }

    @Override // kotlinx.coroutines.internal.C15094s
    @NotNull
    public String toString() {
        return "SelectInstance(state=" + this._state + ", result=" + this._result + ')';
    }

    @Override // kotlinx.coroutines.selects.InterfaceC15197f
    @Nullable
    /* renamed from: u */
    public Object mo3700u(@NotNull Atomic atomic) {
        return new C15189a(this, atomic).mo3620c(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.selects.Select
    /* renamed from: w */
    public <Q> void mo3675w(@NotNull InterfaceC15195d<? extends Q> interfaceC15195d, @NotNull InterfaceC15284p<? super Q, ? super InterfaceC14268c<? super R>, ? extends Object> interfaceC15284p) {
        interfaceC15195d.mo3491k(this, interfaceC15284p);
    }
}

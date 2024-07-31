package kotlinx.coroutines.internal;

import androidx.exifinterface.media.ExifInterface;
import com.kuaishou.weapon.p205p0.C7304t;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import com.umeng.analytics.pro.UMCommonContent;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import io.netty.channel.C13675a;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.C14294d0;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.InterfaceC14268c;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.JvmPlatformAnnotations;
import kotlin.jvm.internal.C14342f0;
import kotlin.jvm.internal.InlineMarker;
import kotlinx.coroutines.AbstractC15133m1;
import kotlinx.coroutines.C14774e0;
import kotlinx.coroutines.C15063i0;
import kotlinx.coroutines.C15120k3;
import kotlinx.coroutines.C15153p;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.DebugStrings;
import kotlinx.coroutines.DispatchedTask;
import kotlinx.coroutines.InterfaceC15146o;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15280l;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0000\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u00028\u00000\u00022\u00060\u0003j\u0002`\u00042\b\u0012\u0004\u0012\u00028\u00000\u0005B\u001d\u0012\u0006\u0010E\u001a\u00020B\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0004\bN\u0010OJ\u0017\u0010\b\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\r\u001a\u00020\f2\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\n¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u000f\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\n¢\u0006\u0004\b\u000f\u0010\u0010J\u001b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\n\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\u0011¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u0013¢\u0006\u0004\b\u0017\u0010\u0018J\u0011\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0010¢\u0006\u0004\b\u001a\u0010\u001bJ \u0010\u001f\u001a\u00020\u001e2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00000\u001cH\u0016ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 JH\u0010%\u001a\u00020\u001e2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00000\u001c2%\b\b\u0010$\u001a\u001f\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u001e\u0018\u00010!H\u0086\bø\u0001\u0000¢\u0006\u0004\b%\u0010&J!\u0010(\u001a\u00020\u001e2\b\u0010'\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0016\u001a\u00020\u0013H\u0010¢\u0006\u0004\b(\u0010)J\u001a\u0010+\u001a\u00020\f2\b\u0010*\u001a\u0004\u0018\u00010\u0019H\u0086\b¢\u0006\u0004\b+\u0010,J!\u0010-\u001a\u00020\u001e2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00000\u001cH\u0086\bø\u0001\u0000¢\u0006\u0004\b-\u0010 J\u001f\u00101\u001a\u00020\u001e2\u0006\u0010/\u001a\u00020.2\u0006\u00100\u001a\u00028\u0000H\u0000¢\u0006\u0004\b1\u00102J\u000f\u00104\u001a\u000203H\u0016¢\u0006\u0004\b4\u00105R\u001e\u0010:\u001a\u0004\u0018\u00010\u00198\u0000@\u0000X\u0081\u000e¢\u0006\f\n\u0004\b6\u00107\u0012\u0004\b8\u00109R\"\u0010?\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>R\u0014\u0010A\u001a\u00020\u00198\u0000X\u0081\u0004¢\u0006\u0006\n\u0004\b@\u00107R\u0014\u0010E\u001a\u00020B8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bC\u0010DR\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u00058\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bF\u0010GR\u0017\u0010I\u001a\b\u0012\u0002\b\u0003\u0018\u00010\n8F¢\u0006\u0006\u001a\u0004\bH\u0010\u0010R\u001a\u0010K\u001a\b\u0012\u0004\u0012\u00028\u00000\u00058PX\u0090\u0004¢\u0006\u0006\u001a\u0004\b6\u0010JR\u0014\u0010/\u001a\u00020.8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\bL\u0010M\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006P"}, m12616d2 = {"Lkotlinx/coroutines/internal/j;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/c1;", "Lkotlin/coroutines/jvm/internal/c;", "Lkotlinx/coroutines/internal/CoroutineStackFrame;", "Lkotlin/coroutines/c;", "Ljava/lang/StackTraceElement;", "Lkotlinx/coroutines/internal/StackTraceElement;", "getStackTraceElement", "()Ljava/lang/StackTraceElement;", "Lkotlinx/coroutines/p;", "requester", "", CampaignEx.JSON_KEY_AD_Q, "(Lkotlinx/coroutines/p;)Z", C7304t.f25048d, "()Lkotlinx/coroutines/p;", "Lkotlinx/coroutines/o;", "continuation", "", "k", "(Lkotlinx/coroutines/o;)Ljava/lang/Throwable;", "cause", "s", "(Ljava/lang/Throwable;)Z", "", "j", "()Ljava/lang/Object;", "Lkotlin/Result;", CommonNetImpl.RESULT, "Lkotlin/f1;", "resumeWith", "(Ljava/lang/Object;)V", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "onCancellation", UMCommonContent.f37782aL, "(Ljava/lang/Object;Ll1/l;)V", "takenState", "c", "(Ljava/lang/Object;Ljava/lang/Throwable;)V", "state", "u", "(Ljava/lang/Object;)Z", "v", "Lkotlin/coroutines/f;", "context", DomainCampaignEx.LOOPBACK_VALUE, "m", "(Lkotlin/coroutines/f;Ljava/lang/Object;)V", "", "toString", "()Ljava/lang/String;", "d", "Ljava/lang/Object;", "get_state$kotlinx_coroutines_core$annotations", "()V", "_state", "e", "Lkotlin/coroutines/jvm/internal/c;", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/c;", "callerFrame", "f", "countOrElement", "Lkotlinx/coroutines/l0;", "g", "Lkotlinx/coroutines/l0;", "dispatcher", "h", "Lkotlin/coroutines/c;", "n", "reusableCancellableContinuation", "()Lkotlin/coroutines/c;", "delegate", "getContext", "()Lkotlin/coroutines/f;", "<init>", "(Lkotlinx/coroutines/l0;Lkotlin/coroutines/c;)V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.internal.j */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class DispatchedContinuation<T> extends DispatchedTask<T> implements CoroutineStackFrame, InterfaceC14268c<T> {

    /* renamed from: i */
    private static final AtomicReferenceFieldUpdater f43051i = AtomicReferenceFieldUpdater.newUpdater(DispatchedContinuation.class, Object.class, "_reusableCancellableContinuation");
    private volatile Object _reusableCancellableContinuation;
    @JvmPlatformAnnotations
    @Nullable

    /* renamed from: d */
    public Object f43052d;
    @Nullable

    /* renamed from: e */
    private final CoroutineStackFrame f43053e;
    @JvmPlatformAnnotations
    @NotNull

    /* renamed from: f */
    public final Object f43054f;
    @JvmPlatformAnnotations
    @NotNull

    /* renamed from: g */
    public final CoroutineDispatcher f43055g;
    @JvmPlatformAnnotations
    @NotNull

    /* renamed from: h */
    public final InterfaceC14268c<T> f43056h;

    /* JADX WARN: Multi-variable type inference failed */
    public DispatchedContinuation(@NotNull CoroutineDispatcher coroutineDispatcher, @NotNull InterfaceC14268c<? super T> interfaceC14268c) {
        super(-1);
        Symbol symbol;
        this.f43055g = coroutineDispatcher;
        this.f43056h = interfaceC14268c;
        symbol = C15080k.f43058a;
        this.f43052d = symbol;
        this.f43053e = (CoroutineStackFrame) (interfaceC14268c instanceof CoroutineStackFrame ? interfaceC14268c : null);
        this.f43054f = ThreadContext.m4254b(getContext());
        this._reusableCancellableContinuation = null;
    }

    /* renamed from: o */
    public static /* synthetic */ void m4307o() {
    }

    @Override // kotlinx.coroutines.DispatchedTask
    /* renamed from: c */
    public void mo3904c(@Nullable Object obj, @NotNull Throwable th) {
        if (obj instanceof C14774e0) {
            ((C14774e0) obj).f42279b.invoke(th);
        }
    }

    @Override // kotlinx.coroutines.DispatchedTask
    @NotNull
    /* renamed from: d */
    public InterfaceC14268c<T> mo3903d() {
        return this;
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    @Nullable
    public CoroutineStackFrame getCallerFrame() {
        return this.f43053e;
    }

    @Override // kotlin.coroutines.InterfaceC14268c
    @NotNull
    public CoroutineContext getContext() {
        return this.f43056h.getContext();
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    @Nullable
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override // kotlinx.coroutines.DispatchedTask
    @Nullable
    /* renamed from: j */
    public Object mo3898j() {
        Symbol symbol;
        Object obj = this.f43052d;
        symbol = C15080k.f43058a;
        this.f43052d = symbol;
        return obj;
    }

    @Nullable
    /* renamed from: k */
    public final Throwable m4311k(@NotNull InterfaceC15146o<?> interfaceC15146o) {
        Symbol symbol;
        do {
            Object obj = this._reusableCancellableContinuation;
            symbol = C15080k.f43059b;
            if (obj != symbol) {
                if (obj == null) {
                    return null;
                }
                if (obj instanceof Throwable) {
                    if (C13675a.m12692a(f43051i, this, obj, null)) {
                        return (Throwable) obj;
                    }
                    throw new IllegalArgumentException("Failed requirement.".toString());
                }
                throw new IllegalStateException(("Inconsistent state " + obj).toString());
            }
        } while (!C13675a.m12692a(f43051i, this, symbol, interfaceC15146o));
        return null;
    }

    @Nullable
    /* renamed from: l */
    public final C15153p<T> m4310l() {
        Object obj;
        do {
            obj = this._reusableCancellableContinuation;
            if (obj == null) {
                this._reusableCancellableContinuation = C15080k.f43059b;
                return null;
            } else if (!(obj instanceof C15153p)) {
                throw new IllegalStateException(("Inconsistent state " + obj).toString());
            }
        } while (!C13675a.m12692a(f43051i, this, obj, C15080k.f43059b));
        return (C15153p) obj;
    }

    /* renamed from: m */
    public final void m4309m(@NotNull CoroutineContext coroutineContext, T t) {
        this.f43052d = t;
        this.f41725c = 1;
        this.f43055g.dispatchYield(coroutineContext, this);
    }

    @Nullable
    /* renamed from: n */
    public final C15153p<?> m4308n() {
        Object obj = this._reusableCancellableContinuation;
        if (!(obj instanceof C15153p)) {
            obj = null;
        }
        return (C15153p) obj;
    }

    /* renamed from: q */
    public final boolean m4306q(@NotNull C15153p<?> c15153p) {
        Object obj = this._reusableCancellableContinuation;
        if (obj != null) {
            return !(obj instanceof C15153p) || obj == c15153p;
        }
        return false;
    }

    @Override // kotlin.coroutines.InterfaceC14268c
    public void resumeWith(@NotNull Object obj) {
        CoroutineContext context = this.f43056h.getContext();
        Object m4403d = C15063i0.m4403d(obj, null, 1, null);
        if (this.f43055g.isDispatchNeeded(context)) {
            this.f43052d = m4403d;
            this.f41725c = 0;
            this.f43055g.dispatch(context, this);
            return;
        }
        AbstractC15133m1 m4083b = C15120k3.f43148b.m4083b();
        if (m4083b.m3994H()) {
            this.f43052d = m4403d;
            this.f41725c = 0;
            m4083b.m3988s(this);
            return;
        }
        m4083b.m3996C(true);
        try {
            CoroutineContext context2 = getContext();
            Object m4253c = ThreadContext.m4253c(context2, this.f43054f);
            this.f43056h.resumeWith(obj);
            Unit unit = Unit.f41048a;
            ThreadContext.m4255a(context2, m4253c);
            do {
            } while (m4083b.m3992K());
        } finally {
            try {
            } finally {
            }
        }
    }

    /* renamed from: s */
    public final boolean m4305s(@NotNull Throwable th) {
        while (true) {
            Object obj = this._reusableCancellableContinuation;
            Symbol symbol = C15080k.f43059b;
            if (C14342f0.m8193g(obj, symbol)) {
                if (C13675a.m12692a(f43051i, this, symbol, th)) {
                    return true;
                }
            } else if (obj instanceof Throwable) {
                return true;
            } else {
                if (C13675a.m12692a(f43051i, this, obj, null)) {
                    return false;
                }
            }
        }
    }

    /* renamed from: t */
    public final void m4304t(@NotNull Object obj, @Nullable InterfaceC15280l<? super Throwable, Unit> interfaceC15280l) {
        boolean z;
        Object m4404c = C15063i0.m4404c(obj, interfaceC15280l);
        if (this.f43055g.isDispatchNeeded(getContext())) {
            this.f43052d = m4404c;
            this.f41725c = 1;
            this.f43055g.dispatch(getContext(), this);
            return;
        }
        AbstractC15133m1 m4083b = C15120k3.f43148b.m4083b();
        if (m4083b.m3994H()) {
            this.f43052d = m4404c;
            this.f41725c = 1;
            m4083b.m3988s(this);
            return;
        }
        m4083b.m3996C(true);
        try {
            Job job = (Job) getContext().get(Job.f42281m0);
            if (job == null || job.isActive()) {
                z = false;
            } else {
                CancellationException mo3825l = job.mo3825l();
                mo3904c(m4404c, mo3825l);
                Result.C14124a c14124a = Result.Companion;
                resumeWith(Result.m60148constructorimpl(C14294d0.m8609a(mo3825l)));
                z = true;
            }
            if (!z) {
                CoroutineContext context = getContext();
                Object m4253c = ThreadContext.m4253c(context, this.f43054f);
                this.f43056h.resumeWith(obj);
                Unit unit = Unit.f41048a;
                InlineMarker.m8228d(1);
                ThreadContext.m4255a(context, m4253c);
                InlineMarker.m8229c(1);
            }
            do {
            } while (m4083b.m3992K());
            InlineMarker.m8228d(1);
        } catch (Throwable th) {
            try {
                m5701i(th, null);
                InlineMarker.m8228d(1);
            } catch (Throwable th2) {
                InlineMarker.m8228d(1);
                m4083b.m3991p(true);
                InlineMarker.m8229c(1);
                throw th2;
            }
        }
        m4083b.m3991p(true);
        InlineMarker.m8229c(1);
    }

    @NotNull
    public String toString() {
        return "DispatchedContinuation[" + this.f43055g + ", " + DebugStrings.m3552c(this.f43056h) + ']';
    }

    /* renamed from: u */
    public final boolean m4303u(@Nullable Object obj) {
        Job job = (Job) getContext().get(Job.f42281m0);
        if (job == null || job.isActive()) {
            return false;
        }
        CancellationException mo3825l = job.mo3825l();
        mo3904c(obj, mo3825l);
        Result.C14124a c14124a = Result.Companion;
        resumeWith(Result.m60148constructorimpl(C14294d0.m8609a(mo3825l)));
        return true;
    }

    /* renamed from: v */
    public final void m4302v(@NotNull Object obj) {
        CoroutineContext context = getContext();
        Object m4253c = ThreadContext.m4253c(context, this.f43054f);
        try {
            this.f43056h.resumeWith(obj);
            Unit unit = Unit.f41048a;
        } finally {
            InlineMarker.m8228d(1);
            ThreadContext.m4255a(context, m4253c);
            InlineMarker.m8229c(1);
        }
    }
}

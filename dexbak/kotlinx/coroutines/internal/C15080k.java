package kotlinx.coroutines.internal;

import androidx.exifinterface.media.ExifInterface;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.util.concurrent.CancellationException;
import kotlin.C14294d0;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.InterfaceC14268c;
import kotlin.jvm.JvmPlatformAnnotations;
import kotlin.jvm.internal.InlineMarker;
import kotlinx.coroutines.AbstractC15133m1;
import kotlinx.coroutines.C15063i0;
import kotlinx.coroutines.C15120k3;
import kotlinx.coroutines.InternalCoroutinesApi;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15269a;
import p617l1.InterfaceC15280l;

/* compiled from: DispatchedContinuation.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000L\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u001aW\u0010\u000b\u001a\u00020\t\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022%\b\u0002\u0010\n\u001a\u001f\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004H\u0007ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a\u0012\u0010\u000f\u001a\u00020\u000e*\b\u0012\u0004\u0012\u00020\t0\rH\u0000\u001a;\u0010\u0017\u001a\u00020\u000e*\u0006\u0012\u0002\b\u00030\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u0014\u001a\u00020\u000e2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\t0\u0015H\u0082\b\"\u001a\u0010\u001d\u001a\u00020\u00188\u0002X\u0083\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u0012\u0004\b\u001b\u0010\u001c\"\u001a\u0010\u001f\u001a\u00020\u00188\u0000X\u0081\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u001a\u0012\u0004\b\u001e\u0010\u001c\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006 "}, m12616d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/coroutines/c;", "Lkotlin/Result;", CommonNetImpl.RESULT, "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "cause", "Lkotlin/f1;", "onCancellation", "f", "(Lkotlin/coroutines/c;Ljava/lang/Object;Ll1/l;)V", "Lkotlinx/coroutines/internal/j;", "", "h", "", "contState", "", RtspHeaders.Values.MODE, "doYield", "Lkotlin/Function0;", "block", "b", "Lkotlinx/coroutines/internal/j0;", "a", "Lkotlinx/coroutines/internal/j0;", "getUNDEFINED$annotations", "()V", "UNDEFINED", "getREUSABLE_CLAIMED$annotations", "REUSABLE_CLAIMED", "kotlinx-coroutines-core"}, m12615k = 2, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.internal.k */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class C15080k {

    /* renamed from: a */
    private static final Symbol f43058a = new Symbol("UNDEFINED");
    @JvmPlatformAnnotations
    @NotNull

    /* renamed from: b */
    public static final Symbol f43059b = new Symbol("REUSABLE_CLAIMED");

    /* renamed from: b */
    private static final boolean m4298b(DispatchedContinuation<?> dispatchedContinuation, Object obj, int i, boolean z, InterfaceC15269a<Unit> interfaceC15269a) {
        AbstractC15133m1 m4083b = C15120k3.f43148b.m4083b();
        if (z && m4083b.m3993I()) {
            return false;
        }
        if (m4083b.m3994H()) {
            dispatchedContinuation.f43052d = obj;
            dispatchedContinuation.f41725c = i;
            m4083b.m3988s(dispatchedContinuation);
            return true;
        }
        m4083b.m3996C(true);
        try {
            interfaceC15269a.invoke();
            do {
            } while (m4083b.m3992K());
            InlineMarker.m8228d(1);
        } catch (Throwable th) {
            try {
                dispatchedContinuation.m5701i(th, null);
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
        return false;
    }

    /* renamed from: c */
    static /* synthetic */ boolean m4297c(DispatchedContinuation dispatchedContinuation, Object obj, int i, boolean z, InterfaceC15269a interfaceC15269a, int i2, Object obj2) {
        if ((i2 & 4) != 0) {
            z = false;
        }
        AbstractC15133m1 m4083b = C15120k3.f43148b.m4083b();
        if (z && m4083b.m3993I()) {
            return false;
        }
        if (m4083b.m3994H()) {
            dispatchedContinuation.f43052d = obj;
            dispatchedContinuation.f41725c = i;
            m4083b.m3988s(dispatchedContinuation);
            return true;
        }
        m4083b.m3996C(true);
        try {
            interfaceC15269a.invoke();
            do {
            } while (m4083b.m3992K());
            InlineMarker.m8228d(1);
        } catch (Throwable th) {
            try {
                dispatchedContinuation.m5701i(th, null);
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
        return false;
    }

    /* renamed from: d */
    public static /* synthetic */ void m4296d() {
    }

    /* renamed from: e */
    private static /* synthetic */ void m4295e() {
    }

    @InternalCoroutinesApi
    /* renamed from: f */
    public static final <T> void m4294f(@NotNull InterfaceC14268c<? super T> interfaceC14268c, @NotNull Object obj, @Nullable InterfaceC15280l<? super Throwable, Unit> interfaceC15280l) {
        boolean z;
        if (interfaceC14268c instanceof DispatchedContinuation) {
            DispatchedContinuation dispatchedContinuation = (DispatchedContinuation) interfaceC14268c;
            Object m4404c = C15063i0.m4404c(obj, interfaceC15280l);
            if (dispatchedContinuation.f43055g.isDispatchNeeded(dispatchedContinuation.getContext())) {
                dispatchedContinuation.f43052d = m4404c;
                dispatchedContinuation.f41725c = 1;
                dispatchedContinuation.f43055g.dispatch(dispatchedContinuation.getContext(), dispatchedContinuation);
                return;
            }
            AbstractC15133m1 m4083b = C15120k3.f43148b.m4083b();
            if (m4083b.m3994H()) {
                dispatchedContinuation.f43052d = m4404c;
                dispatchedContinuation.f41725c = 1;
                m4083b.m3988s(dispatchedContinuation);
                return;
            }
            m4083b.m3996C(true);
            try {
                Job job = (Job) dispatchedContinuation.getContext().get(Job.f42281m0);
                if (job == null || job.isActive()) {
                    z = false;
                } else {
                    CancellationException mo3825l = job.mo3825l();
                    dispatchedContinuation.mo3904c(m4404c, mo3825l);
                    Result.C14124a c14124a = Result.Companion;
                    dispatchedContinuation.resumeWith(Result.m60148constructorimpl(C14294d0.m8609a(mo3825l)));
                    z = true;
                }
                if (!z) {
                    CoroutineContext context = dispatchedContinuation.getContext();
                    Object m4253c = ThreadContext.m4253c(context, dispatchedContinuation.f43054f);
                    dispatchedContinuation.f43056h.resumeWith(obj);
                    Unit unit = Unit.f41048a;
                    ThreadContext.m4255a(context, m4253c);
                }
                do {
                } while (m4083b.m3992K());
            } finally {
                try {
                    return;
                } finally {
                }
            }
            return;
        }
        interfaceC14268c.resumeWith(obj);
    }

    /* renamed from: g */
    public static /* synthetic */ void m4293g(InterfaceC14268c interfaceC14268c, Object obj, InterfaceC15280l interfaceC15280l, int i, Object obj2) {
        if ((i & 2) != 0) {
            interfaceC15280l = null;
        }
        m4294f(interfaceC14268c, obj, interfaceC15280l);
    }

    /* renamed from: h */
    public static final boolean m4292h(@NotNull DispatchedContinuation<? super Unit> dispatchedContinuation) {
        Unit unit = Unit.f41048a;
        AbstractC15133m1 m4083b = C15120k3.f43148b.m4083b();
        if (m4083b.m3993I()) {
            return false;
        }
        if (m4083b.m3994H()) {
            dispatchedContinuation.f43052d = unit;
            dispatchedContinuation.f41725c = 1;
            m4083b.m3988s(dispatchedContinuation);
            return true;
        }
        m4083b.m3996C(true);
        try {
            dispatchedContinuation.run();
            do {
            } while (m4083b.m3992K());
        } finally {
            try {
                return false;
            } finally {
            }
        }
        return false;
    }
}

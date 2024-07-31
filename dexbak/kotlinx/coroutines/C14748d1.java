package kotlinx.coroutines;

import androidx.exifinterface.media.ExifInterface;
import io.netty.handler.codec.rtsp.RtspHeaders;
import kotlin.C14294d0;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.InterfaceC14268c;
import kotlin.jvm.internal.InlineMarker;
import kotlinx.coroutines.internal.DispatchedContinuation;
import kotlinx.coroutines.internal.ThreadContext;
import org.jetbrains.annotations.NotNull;
import p617l1.InterfaceC15269a;

/* compiled from: DispatchedTask.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0011\u001a \u0010\u0005\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0000\u001a.\u0010\n\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u00062\u0006\u0010\t\u001a\u00020\bH\u0000\u001a\u0010\u0010\u000b\u001a\u00020\u0004*\u0006\u0012\u0002\b\u00030\u0001H\u0002\u001a'\u0010\u0010\u001a\u00020\u0004*\u0006\u0012\u0002\b\u00030\u00012\u0006\u0010\r\u001a\u00020\f2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u000eH\u0080\b\u001a\u0019\u0010\u0013\u001a\u00020\u0004*\u0006\u0012\u0002\b\u00030\u00062\u0006\u0010\u0012\u001a\u00020\u0011H\u0080\b\"\u0014\u0010\u0015\u001a\u00020\u00028\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0014\"\u001a\u0010\u0019\u001a\u00020\u00028\u0000X\u0081T¢\u0006\f\n\u0004\b\u0016\u0010\u0014\u0012\u0004\b\u0017\u0010\u0018\"\u0014\u0010\u001b\u001a\u00020\u00028\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u001a\u0010\u0014\"\u0014\u0010\u001d\u001a\u00020\u00028\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u001c\u0010\u0014\"\u0014\u0010\u001e\u001a\u00020\u00028\u0000X\u0080T¢\u0006\u0006\n\u0004\b\n\u0010\u0014\"\u0018\u0010 \u001a\u00020\b*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001f\"\u0018\u0010!\u001a\u00020\b*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001f¨\u0006\""}, m12616d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/c1;", "", RtspHeaders.Values.MODE, "Lkotlin/f1;", "a", "Lkotlin/coroutines/c;", "delegate", "", "undispatched", "e", "f", "Lkotlinx/coroutines/m1;", "eventLoop", "Lkotlin/Function0;", "block", "h", "", "exception", "g", "I", "MODE_ATOMIC", "b", "getMODE_CANCELLABLE$annotations", "()V", "MODE_CANCELLABLE", "c", "MODE_CANCELLABLE_REUSABLE", "d", "MODE_UNDISPATCHED", "MODE_UNINITIALIZED", "(I)Z", "isCancellableMode", "isReusableMode", "kotlinx-coroutines-core"}, m12615k = 2, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.d1 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class C14748d1 {

    /* renamed from: a */
    public static final int f42190a = 0;

    /* renamed from: b */
    public static final int f42191b = 1;

    /* renamed from: c */
    public static final int f42192c = 2;

    /* renamed from: d */
    public static final int f42193d = 4;

    /* renamed from: e */
    public static final int f42194e = -1;

    /* renamed from: a */
    public static final <T> void m5154a(@NotNull DispatchedTask<? super T> dispatchedTask, int i) {
        InterfaceC14268c<? super T> mo3903d = dispatchedTask.mo3903d();
        boolean z = i == 4;
        if (!z && (mo3903d instanceof DispatchedContinuation) && m5152c(i) == m5152c(dispatchedTask.f41725c)) {
            CoroutineDispatcher coroutineDispatcher = ((DispatchedContinuation) mo3903d).f43055g;
            CoroutineContext context = mo3903d.getContext();
            if (coroutineDispatcher.isDispatchNeeded(context)) {
                coroutineDispatcher.dispatch(context, dispatchedTask);
                return;
            } else {
                m5149f(dispatchedTask);
                return;
            }
        }
        m5150e(dispatchedTask, mo3903d, z);
    }

    @PublishedApi
    /* renamed from: b */
    public static /* synthetic */ void m5153b() {
    }

    /* renamed from: c */
    public static final boolean m5152c(int i) {
        return i == 1 || i == 2;
    }

    /* renamed from: d */
    public static final boolean m5151d(int i) {
        return i == 2;
    }

    /* renamed from: e */
    public static final <T> void m5150e(@NotNull DispatchedTask<? super T> dispatchedTask, @NotNull InterfaceC14268c<? super T> interfaceC14268c, boolean z) {
        Object mo3899h;
        Object mo3898j = dispatchedTask.mo3898j();
        Throwable mo3900g = dispatchedTask.mo3900g(mo3898j);
        if (mo3900g != null) {
            Result.C14124a c14124a = Result.Companion;
            mo3899h = C14294d0.m8609a(mo3900g);
        } else {
            Result.C14124a c14124a2 = Result.Companion;
            mo3899h = dispatchedTask.mo3899h(mo3898j);
        }
        Object m60148constructorimpl = Result.m60148constructorimpl(mo3899h);
        if (!z) {
            interfaceC14268c.resumeWith(m60148constructorimpl);
        } else if (interfaceC14268c != null) {
            DispatchedContinuation dispatchedContinuation = (DispatchedContinuation) interfaceC14268c;
            CoroutineContext context = dispatchedContinuation.getContext();
            Object m4253c = ThreadContext.m4253c(context, dispatchedContinuation.f43054f);
            try {
                dispatchedContinuation.f43056h.resumeWith(m60148constructorimpl);
                Unit unit = Unit.f41048a;
            } finally {
                ThreadContext.m4255a(context, m4253c);
            }
        } else {
            throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<T>");
        }
    }

    /* renamed from: f */
    private static final void m5149f(DispatchedTask<?> dispatchedTask) {
        AbstractC15133m1 m4083b = C15120k3.f43148b.m4083b();
        if (m4083b.m3994H()) {
            m4083b.m3988s(dispatchedTask);
            return;
        }
        m4083b.m3996C(true);
        try {
            m5150e(dispatchedTask, dispatchedTask.mo3903d(), true);
            do {
            } while (m4083b.m3992K());
        } finally {
            try {
            } finally {
            }
        }
    }

    /* renamed from: g */
    public static final void m5148g(@NotNull InterfaceC14268c<?> interfaceC14268c, @NotNull Throwable th) {
        Result.C14124a c14124a = Result.Companion;
        interfaceC14268c.resumeWith(Result.m60148constructorimpl(C14294d0.m8609a(th)));
    }

    /* renamed from: h */
    public static final void m5147h(@NotNull DispatchedTask<?> dispatchedTask, @NotNull AbstractC15133m1 abstractC15133m1, @NotNull InterfaceC15269a<Unit> interfaceC15269a) {
        abstractC15133m1.m3996C(true);
        try {
            interfaceC15269a.invoke();
            do {
            } while (abstractC15133m1.m3992K());
            InlineMarker.m8228d(1);
        } catch (Throwable th) {
            try {
                dispatchedTask.m5701i(th, null);
                InlineMarker.m8228d(1);
            } catch (Throwable th2) {
                InlineMarker.m8228d(1);
                abstractC15133m1.m3991p(true);
                InlineMarker.m8229c(1);
                throw th2;
            }
        }
        abstractC15133m1.m3991p(true);
        InlineMarker.m8229c(1);
    }
}

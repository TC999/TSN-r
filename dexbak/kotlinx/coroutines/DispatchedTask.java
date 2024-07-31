package kotlinx.coroutines;

import androidx.exifinterface.media.ExifInterface;
import java.util.concurrent.CancellationException;
import kotlin.C14294d0;
import kotlin.C14305i;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.InterfaceC14268c;
import kotlin.jvm.JvmPlatformAnnotations;
import kotlin.jvm.internal.C14342f0;
import kotlinx.coroutines.internal.DispatchedContinuation;
import kotlinx.coroutines.internal.ThreadContext;
import kotlinx.coroutines.scheduling.AbstractRunnableC15181i;
import kotlinx.coroutines.scheduling.InterfaceC15182j;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(m12618bv = {}, m12617d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b \u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00060\u0002j\u0002`\u0003B\u000f\u0012\u0006\u0010\u0019\u001a\u00020\u0017¢\u0006\u0004\b\u001e\u0010\u001fJ\u0011\u0010\u0005\u001a\u0004\u0018\u00010\u0004H ¢\u0006\u0004\b\u0005\u0010\u0006J!\u0010\u000b\u001a\u00020\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\bH\u0010¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u000e\u001a\u00028\u0001\"\u0004\b\u0001\u0010\u00012\b\u0010\r\u001a\u0004\u0018\u00010\u0004H\u0010¢\u0006\u0004\b\u000e\u0010\u000fJ\u001b\u0010\u0010\u001a\u0004\u0018\u00010\b2\b\u0010\r\u001a\u0004\u0018\u00010\u0004H\u0010¢\u0006\u0004\b\u0010\u0010\u0011J\u0006\u0010\u0012\u001a\u00020\nJ#\u0010\u0015\u001a\u00020\n2\b\u0010\u0013\u001a\u0004\u0018\u00010\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\bH\u0000¢\u0006\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0019\u001a\u00020\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\u0018R\u001a\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00000\u001a8 X \u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c¨\u0006 "}, m12616d2 = {"Lkotlinx/coroutines/c1;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/scheduling/i;", "Lkotlinx/coroutines/SchedulerTask;", "", "j", "()Ljava/lang/Object;", "takenState", "", "cause", "Lkotlin/f1;", "c", "(Ljava/lang/Object;Ljava/lang/Throwable;)V", "state", "h", "(Ljava/lang/Object;)Ljava/lang/Object;", "g", "(Ljava/lang/Object;)Ljava/lang/Throwable;", "run", "exception", "finallyException", "i", "(Ljava/lang/Throwable;Ljava/lang/Throwable;)V", "", "I", "resumeMode", "Lkotlin/coroutines/c;", "d", "()Lkotlin/coroutines/c;", "delegate", "<init>", "(I)V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.c1 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public abstract class DispatchedTask<T> extends AbstractRunnableC15181i {
    @JvmPlatformAnnotations

    /* renamed from: c */
    public int f41725c;

    public DispatchedTask(int i) {
        this.f41725c = i;
    }

    /* renamed from: c */
    public void mo3904c(@Nullable Object obj, @NotNull Throwable th) {
    }

    @NotNull
    /* renamed from: d */
    public abstract InterfaceC14268c<T> mo3903d();

    @Nullable
    /* renamed from: g */
    public Throwable mo3900g(@Nullable Object obj) {
        if (!(obj instanceof CompletionState)) {
            obj = null;
        }
        CompletionState completionState = (CompletionState) obj;
        if (completionState != null) {
            return completionState.f42189a;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: h */
    public <T> T mo3899h(@Nullable Object obj) {
        return obj;
    }

    /* renamed from: i */
    public final void m5701i(@Nullable Throwable th, @Nullable Throwable th2) {
        if (th == null && th2 == null) {
            return;
        }
        if (th != null && th2 != null) {
            C14305i.m8548a(th, th2);
        }
        if (th == null) {
            th = th2;
        }
        C14342f0.m8187m(th);
        C15137n0.m3969b(mo3903d().getContext(), new CoroutinesInternalError("Fatal exception in coroutines machinery for " + this + ". Please read KDoc to 'handleFatalException' method and report this incident to maintainers", th));
    }

    @Nullable
    /* renamed from: j */
    public abstract Object mo3898j();

    @Override // java.lang.Runnable
    public final void run() {
        Object m60148constructorimpl;
        Object m60148constructorimpl2;
        InterfaceC15182j interfaceC15182j = this.f43292b;
        try {
            InterfaceC14268c<T> mo3903d = mo3903d();
            if (mo3903d != null) {
                DispatchedContinuation dispatchedContinuation = (DispatchedContinuation) mo3903d;
                InterfaceC14268c<T> interfaceC14268c = dispatchedContinuation.f43056h;
                CoroutineContext context = interfaceC14268c.getContext();
                Object mo3898j = mo3898j();
                Object m4253c = ThreadContext.m4253c(context, dispatchedContinuation.f43054f);
                Throwable mo3900g = mo3900g(mo3898j);
                Job job = (mo3900g == null && C14748d1.m5152c(this.f41725c)) ? (Job) context.get(Job.f42281m0) : null;
                if (job != null && !job.isActive()) {
                    CancellationException mo3825l = job.mo3825l();
                    mo3904c(mo3898j, mo3825l);
                    Result.C14124a c14124a = Result.Companion;
                    interfaceC14268c.resumeWith(Result.m60148constructorimpl(C14294d0.m8609a(mo3825l)));
                } else if (mo3900g != null) {
                    Result.C14124a c14124a2 = Result.Companion;
                    interfaceC14268c.resumeWith(Result.m60148constructorimpl(C14294d0.m8609a(mo3900g)));
                } else {
                    T mo3899h = mo3899h(mo3898j);
                    Result.C14124a c14124a3 = Result.Companion;
                    interfaceC14268c.resumeWith(Result.m60148constructorimpl(mo3899h));
                }
                Unit unit = Unit.f41048a;
                ThreadContext.m4255a(context, m4253c);
                try {
                    Result.C14124a c14124a4 = Result.Companion;
                    interfaceC15182j.mo3739f();
                    m60148constructorimpl2 = Result.m60148constructorimpl(unit);
                } catch (Throwable th) {
                    Result.C14124a c14124a5 = Result.Companion;
                    m60148constructorimpl2 = Result.m60148constructorimpl(C14294d0.m8609a(th));
                }
                m5701i(null, Result.m60151exceptionOrNullimpl(m60148constructorimpl2));
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<T>");
        } catch (Throwable th2) {
            try {
                Result.C14124a c14124a6 = Result.Companion;
                interfaceC15182j.mo3739f();
                m60148constructorimpl = Result.m60148constructorimpl(Unit.f41048a);
            } catch (Throwable th3) {
                Result.C14124a c14124a7 = Result.Companion;
                m60148constructorimpl = Result.m60148constructorimpl(C14294d0.m8609a(th3));
            }
            m5701i(th2, Result.m60151exceptionOrNullimpl(m60148constructorimpl));
        }
    }
}

package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.InterfaceC14268c;
import kotlin.coroutines.intrinsics.C14287b;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.internal.InlineMarker;
import kotlinx.coroutines.internal.C15079i;
import kotlinx.coroutines.internal.Scopes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15284p;
import p649u1.Undispatched;

/* compiled from: CoroutineScope.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\u001a\u0015\u0010\u0003\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0086\u0002\u001a\u0006\u0010\u0004\u001a\u00020\u0000\u001aO\u0010\u000b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00052'\u0010\n\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0006¢\u0006\u0002\b\tH\u0086@ø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\b\u000b\u0010\f\u001a\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001\u001a\u001c\u0010\u0012\u001a\u00020\u0011*\u00020\u00002\u0010\b\u0002\u0010\u0010\u001a\n\u0018\u00010\u000ej\u0004\u0018\u0001`\u000f\u001a\u001e\u0010\u0016\u001a\u00020\u0011*\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u00132\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0015\u001a\n\u0010\u0017\u001a\u00020\u0011*\u00020\u0000\u001a\u0013\u0010\u0018\u001a\u00020\u0001H\u0086Hø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019\"\u001b\u0010\u001f\u001a\u00020\u001a*\u00020\u00008F¢\u0006\f\u0012\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001b\u0010\u001c\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006 "}, m12616d2 = {"Lkotlinx/coroutines/q0;", "Lkotlin/coroutines/f;", "context", "m", "b", "R", "Lkotlin/Function2;", "Lkotlin/coroutines/c;", "", "Lkotlin/ExtensionFunctionType;", "block", "g", "(Ll1/p;Lkotlin/coroutines/c;)Ljava/lang/Object;", "a", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "cause", "Lkotlin/f1;", "d", "", "message", "", "c", "j", "h", "(Lkotlin/coroutines/c;)Ljava/lang/Object;", "", "k", "(Lkotlinx/coroutines/q0;)Z", "isActive$annotations", "(Lkotlinx/coroutines/q0;)V", "isActive", "kotlinx-coroutines-core"}, m12615k = 2, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.r0 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class C15162r0 {
    @NotNull
    /* renamed from: a */
    public static final CoroutineScope m3846a(@NotNull CoroutineContext coroutineContext) {
        CompletableJob m4118d;
        if (coroutineContext.get(Job.f42281m0) == null) {
            m4118d = C15113j2.m4118d(null, 1, null);
            coroutineContext = coroutineContext.plus(m4118d);
        }
        return new C15079i(coroutineContext);
    }

    @NotNull
    /* renamed from: b */
    public static final CoroutineScope m3845b() {
        return new C15079i(C15061h3.m4411c(null, 1, null).plus(Dispatchers.m5034e()));
    }

    /* renamed from: c */
    public static final void m3844c(@NotNull CoroutineScope coroutineScope, @NotNull String str, @Nullable Throwable th) {
        m3843d(coroutineScope, C15163r1.m3833a(str, th));
    }

    /* renamed from: d */
    public static final void m3843d(@NotNull CoroutineScope coroutineScope, @Nullable CancellationException cancellationException) {
        Job job = (Job) coroutineScope.getCoroutineContext().get(Job.f42281m0);
        if (job != null) {
            job.mo3827b(cancellationException);
            return;
        }
        throw new IllegalStateException(("Scope cannot be cancelled because it does not have a job: " + coroutineScope).toString());
    }

    /* renamed from: e */
    public static /* synthetic */ void m3842e(CoroutineScope coroutineScope, String str, Throwable th, int i, Object obj) {
        if ((i & 2) != 0) {
            th = null;
        }
        m3844c(coroutineScope, str, th);
    }

    /* renamed from: f */
    public static /* synthetic */ void m3841f(CoroutineScope coroutineScope, CancellationException cancellationException, int i, Object obj) {
        if ((i & 1) != 0) {
            cancellationException = null;
        }
        m3843d(coroutineScope, cancellationException);
    }

    @Nullable
    /* renamed from: g */
    public static final <R> Object m3840g(@NotNull InterfaceC15284p<? super CoroutineScope, ? super InterfaceC14268c<? super R>, ? extends Object> interfaceC15284p, @NotNull InterfaceC14268c<? super R> interfaceC14268c) {
        Object m8642h;
        Scopes scopes = new Scopes(interfaceC14268c.getContext(), interfaceC14268c);
        Object m220f = Undispatched.m220f(scopes, scopes, interfaceC15284p);
        m8642h = C14287b.m8642h();
        if (m220f == m8642h) {
            DebugProbes.m8616c(interfaceC14268c);
        }
        return m220f;
    }

    @Nullable
    /* renamed from: h */
    public static final Object m3839h(@NotNull InterfaceC14268c<? super CoroutineContext> interfaceC14268c) {
        return interfaceC14268c.getContext();
    }

    @Nullable
    /* renamed from: i */
    private static final Object m3838i(@NotNull InterfaceC14268c interfaceC14268c) {
        InlineMarker.m8227e(3);
        throw null;
    }

    /* renamed from: j */
    public static final void m3837j(@NotNull CoroutineScope coroutineScope) {
        C15060h2.m4443A(coroutineScope.getCoroutineContext());
    }

    /* renamed from: k */
    public static final boolean m3836k(@NotNull CoroutineScope coroutineScope) {
        Job job = (Job) coroutineScope.getCoroutineContext().get(Job.f42281m0);
        if (job != null) {
            return job.isActive();
        }
        return true;
    }

    /* renamed from: l */
    public static /* synthetic */ void m3835l(CoroutineScope coroutineScope) {
    }

    @NotNull
    /* renamed from: m */
    public static final CoroutineScope m3834m(@NotNull CoroutineScope coroutineScope, @NotNull CoroutineContext coroutineContext) {
        return new C15079i(coroutineScope.getCoroutineContext().plus(coroutineContext));
    }
}

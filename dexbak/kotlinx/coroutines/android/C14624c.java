package kotlinx.coroutines.android;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import androidx.annotation.VisibleForTesting;
import com.tencent.connect.common.Constants;
import kotlin.Annotations;
import kotlin.C14294d0;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.InterfaceC14268c;
import kotlin.coroutines.intrinsics.C14287b;
import kotlin.coroutines.intrinsics.IntrinsicsJvm;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmPlatformAnnotations;
import kotlin.jvm.internal.C14342f0;
import kotlinx.coroutines.C15153p;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.InterfaceC15146o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: HandlerDispatcher.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u001a\u001f\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0014\u0010\t\u001a\u00020\u0000*\u00020\u00062\u0006\u0010\b\u001a\u00020\u0007H\u0001\u001a\u0013\u0010\u000b\u001a\u00020\nH\u0086@ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a\u0016\u0010\u0010\u001a\u00020\u000f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\rH\u0002\u001a\u001e\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\rH\u0002\"\u0014\u0010\u0016\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015\"\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u00038\u0000X\u0081\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u0012\u0004\b\u0019\u0010\u001a\"\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u001c\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001d"}, m12616d2 = {"Landroid/os/Handler;", "", "name", "Lkotlinx/coroutines/android/b;", "f", "(Landroid/os/Handler;Ljava/lang/String;)Lkotlinx/coroutines/android/b;", "Landroid/os/Looper;", "", "async", "c", "", "d", "(Lkotlin/coroutines/c;)Ljava/lang/Object;", "Lkotlinx/coroutines/o;", "cont", "Lkotlin/f1;", "j", "Landroid/view/Choreographer;", "choreographer", "i", "a", "J", "MAX_DELAY", "b", "Lkotlinx/coroutines/android/b;", "getMain$annotations", "()V", "Main", "Landroid/view/Choreographer;", "kotlinx-coroutines-android"}, m12615k = 2, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.android.c */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class C14624c {

    /* renamed from: a */
    private static final long f41706a = 4611686018427387903L;
    @JvmPlatformAnnotations
    @Nullable

    /* renamed from: b */
    public static final AbstractC14623b f41707b;
    private static volatile Choreographer choreographer;

    /* compiled from: Runnable.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0004\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002¨\u0006\u0003"}, m12616d2 = {"Lkotlin/f1;", "run", "()V", "kotlinx/coroutines/a3$a", "<anonymous>"}, m12615k = 3, m12614mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.android.c$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class RunnableC14625a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ InterfaceC15146o f41708a;

        public RunnableC14625a(InterfaceC15146o interfaceC15146o) {
            this.f41708a = interfaceC15146o;
        }

        @Override // java.lang.Runnable
        public final void run() {
            C14624c.m5730j(this.f41708a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: HandlerDispatcher.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u000e\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, m12616d2 = {"", "nanos", "Lkotlin/f1;", "doFrame", "(J)V", "<anonymous>"}, m12615k = 3, m12614mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.android.c$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class Choreographer$FrameCallbackC14626b implements Choreographer.FrameCallback {

        /* renamed from: a */
        final /* synthetic */ InterfaceC15146o f41709a;

        Choreographer$FrameCallbackC14626b(InterfaceC15146o interfaceC15146o) {
            this.f41709a = interfaceC15146o;
        }

        @Override // android.view.Choreographer.FrameCallback
        public final void doFrame(long j) {
            this.f41709a.mo3916I(Dispatchers.m5034e(), Long.valueOf(j));
        }
    }

    static {
        Object m60148constructorimpl;
        try {
            Result.C14124a c14124a = Result.Companion;
            m60148constructorimpl = Result.m60148constructorimpl(new C14619a(m5737c(Looper.getMainLooper(), true), null, 2, null));
        } catch (Throwable th) {
            Result.C14124a c14124a2 = Result.Companion;
            m60148constructorimpl = Result.m60148constructorimpl(C14294d0.m8609a(th));
        }
        f41707b = Result.m60154isFailureimpl(m60148constructorimpl) ? null : m60148constructorimpl;
    }

    @VisibleForTesting
    @NotNull
    /* renamed from: c */
    public static final Handler m5737c(@NotNull Looper looper, boolean z) {
        if (z) {
            if (Build.VERSION.SDK_INT >= 28) {
                Object invoke = Handler.class.getDeclaredMethod("createAsync", Looper.class).invoke(null, looper);
                if (invoke != null) {
                    return (Handler) invoke;
                }
                throw new NullPointerException("null cannot be cast to non-null type android.os.Handler");
            }
            try {
                return (Handler) Handler.class.getDeclaredConstructor(Looper.class, Handler.Callback.class, Boolean.TYPE).newInstance(looper, null, Boolean.TRUE);
            } catch (NoSuchMethodException unused) {
                return new Handler(looper);
            }
        }
        return new Handler(looper);
    }

    @Nullable
    /* renamed from: d */
    public static final Object m5736d(@NotNull InterfaceC14268c<? super Long> interfaceC14268c) {
        InterfaceC14268c m8650d;
        Object m8642h;
        InterfaceC14268c m8650d2;
        Object m8642h2;
        Choreographer choreographer2 = choreographer;
        if (choreographer2 != null) {
            m8650d2 = IntrinsicsJvm.m8650d(interfaceC14268c);
            C15153p c15153p = new C15153p(m8650d2, 1);
            c15153p.mo3915J();
            m5731i(choreographer2, c15153p);
            Object m3883y = c15153p.m3883y();
            m8642h2 = C14287b.m8642h();
            if (m3883y == m8642h2) {
                DebugProbes.m8616c(interfaceC14268c);
            }
            return m3883y;
        }
        m8650d = IntrinsicsJvm.m8650d(interfaceC14268c);
        C15153p c15153p2 = new C15153p(m8650d, 1);
        c15153p2.mo3915J();
        Dispatchers.m5034e().dispatch(EmptyCoroutineContext.INSTANCE, new RunnableC14625a(c15153p2));
        Object m3883y2 = c15153p2.m3883y();
        m8642h = C14287b.m8642h();
        if (m3883y2 == m8642h) {
            DebugProbes.m8616c(interfaceC14268c);
        }
        return m3883y2;
    }

    @JvmOverloads
    @JvmName(name = Constants.FROM)
    @NotNull
    /* renamed from: e */
    public static final AbstractC14623b m5735e(@NotNull Handler handler) {
        return m5733g(handler, null, 1, null);
    }

    @JvmOverloads
    @JvmName(name = Constants.FROM)
    @NotNull
    /* renamed from: f */
    public static final AbstractC14623b m5734f(@NotNull Handler handler, @Nullable String str) {
        return new C14619a(handler, str);
    }

    /* renamed from: g */
    public static /* synthetic */ AbstractC14623b m5733g(Handler handler, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        return m5734f(handler, str);
    }

    @Annotations(level = DeprecationLevel.HIDDEN, message = "Use Dispatchers.Main instead")
    /* renamed from: h */
    public static /* synthetic */ void m5732h() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public static final void m5731i(Choreographer choreographer2, InterfaceC15146o<? super Long> interfaceC15146o) {
        choreographer2.postFrameCallback(new Choreographer$FrameCallbackC14626b(interfaceC15146o));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public static final void m5730j(InterfaceC15146o<? super Long> interfaceC15146o) {
        Choreographer choreographer2 = choreographer;
        if (choreographer2 == null) {
            choreographer2 = Choreographer.getInstance();
            C14342f0.m8187m(choreographer2);
            choreographer = choreographer2;
        }
        m5731i(choreographer2, interfaceC15146o);
    }
}

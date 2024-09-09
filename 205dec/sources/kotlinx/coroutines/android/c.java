package kotlinx.coroutines.android;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import androidx.annotation.VisibleForTesting;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.jvm.internal.e;
import kotlin.d0;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.f0;
import kotlinx.coroutines.f1;
import kotlinx.coroutines.o;
import kotlinx.coroutines.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: HandlerDispatcher.kt */
@Metadata(bv = {}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u001a\u001f\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0007\u00a2\u0006\u0004\b\u0004\u0010\u0005\u001a\u0014\u0010\t\u001a\u00020\u0000*\u00020\u00062\u0006\u0010\b\u001a\u00020\u0007H\u0001\u001a\u0013\u0010\u000b\u001a\u00020\nH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000b\u0010\f\u001a\u0016\u0010\u0010\u001a\u00020\u000f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\rH\u0002\u001a\u001e\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\rH\u0002\"\u0014\u0010\u0016\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015\"\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u00038\u0000X\u0081\u0004\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u0012\u0004\b\u0019\u0010\u001a\"\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u001c\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001d"}, d2 = {"Landroid/os/Handler;", "", "name", "Lkotlinx/coroutines/android/b;", "f", "(Landroid/os/Handler;Ljava/lang/String;)Lkotlinx/coroutines/android/b;", "Landroid/os/Looper;", "", "async", "c", "", "d", "(Lkotlin/coroutines/c;)Ljava/lang/Object;", "Lkotlinx/coroutines/o;", "cont", "Lkotlin/f1;", "j", "Landroid/view/Choreographer;", "choreographer", "i", "a", "J", "MAX_DELAY", "b", "Lkotlinx/coroutines/android/b;", "getMain$annotations", "()V", "Main", "Landroid/view/Choreographer;", "kotlinx-coroutines-android"}, k = 2, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    private static final long f59051a = 4611686018427387903L;
    @JvmField
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public static final kotlinx.coroutines.android.b f59052b;
    private static volatile Choreographer choreographer;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Runnable.kt */
    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0004\u001a\u00020\u0000H\n\u00a2\u0006\u0004\b\u0001\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lkotlin/f1;", "run", "()V", "kotlinx/coroutines/a3$a", "<anonymous>"}, k = 3, mv = {1, 4, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ o f59053a;

        public a(o oVar) {
            this.f59053a = oVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            c.j(this.f59053a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: HandlerDispatcher.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "nanos", "Lkotlin/f1;", "doFrame", "(J)V", "<anonymous>"}, k = 3, mv = {1, 4, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class b implements Choreographer.FrameCallback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ o f59054a;

        b(o oVar) {
            this.f59054a = oVar;
        }

        @Override // android.view.Choreographer.FrameCallback
        public final void doFrame(long j4) {
            this.f59054a.G(f1.e(), Long.valueOf(j4));
        }
    }

    static {
        Object m119constructorimpl;
        try {
            Result.a aVar = Result.Companion;
            m119constructorimpl = Result.m119constructorimpl(new kotlinx.coroutines.android.a(c(Looper.getMainLooper(), true), null, 2, null));
        } catch (Throwable th) {
            Result.a aVar2 = Result.Companion;
            m119constructorimpl = Result.m119constructorimpl(d0.a(th));
        }
        f59052b = Result.m125isFailureimpl(m119constructorimpl) ? null : m119constructorimpl;
    }

    @VisibleForTesting
    @NotNull
    public static final Handler c(@NotNull Looper looper, boolean z3) {
        if (z3) {
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
    public static final Object d(@NotNull kotlin.coroutines.c<? super Long> cVar) {
        kotlin.coroutines.c d4;
        Object h4;
        kotlin.coroutines.c d5;
        Object h5;
        Choreographer choreographer2 = choreographer;
        if (choreographer2 != null) {
            d5 = IntrinsicsKt__IntrinsicsJvmKt.d(cVar);
            p pVar = new p(d5, 1);
            pVar.H();
            i(choreographer2, pVar);
            Object y3 = pVar.y();
            h5 = kotlin.coroutines.intrinsics.b.h();
            if (y3 == h5) {
                e.c(cVar);
            }
            return y3;
        }
        d4 = IntrinsicsKt__IntrinsicsJvmKt.d(cVar);
        p pVar2 = new p(d4, 1);
        pVar2.H();
        f1.e().dispatch(EmptyCoroutineContext.INSTANCE, new a(pVar2));
        Object y4 = pVar2.y();
        h4 = kotlin.coroutines.intrinsics.b.h();
        if (y4 == h4) {
            e.c(cVar);
        }
        return y4;
    }

    @JvmOverloads
    @JvmName(name = "from")
    @NotNull
    public static final kotlinx.coroutines.android.b e(@NotNull Handler handler) {
        return g(handler, null, 1, null);
    }

    @JvmOverloads
    @JvmName(name = "from")
    @NotNull
    public static final kotlinx.coroutines.android.b f(@NotNull Handler handler, @Nullable String str) {
        return new kotlinx.coroutines.android.a(handler, str);
    }

    public static /* synthetic */ kotlinx.coroutines.android.b g(Handler handler, String str, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            str = null;
        }
        return f(handler, str);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use Dispatchers.Main instead")
    public static /* synthetic */ void h() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(Choreographer choreographer2, o<? super Long> oVar) {
        choreographer2.postFrameCallback(new b(oVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(o<? super Long> oVar) {
        Choreographer choreographer2 = choreographer;
        if (choreographer2 == null) {
            choreographer2 = Choreographer.getInstance();
            f0.m(choreographer2);
            choreographer = choreographer2;
        }
        i(choreographer2, oVar);
    }
}

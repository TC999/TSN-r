package kotlinx.coroutines.test;

import com.acse.ottn.f3;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import d2.l;
import d2.p;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.coroutines.d;
import kotlin.coroutines.f;
import kotlin.f1;
import kotlin.jvm.internal.u;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.i1;
import kotlinx.coroutines.internal.s0;
import kotlinx.coroutines.m1;
import kotlinx.coroutines.o;
import kotlinx.coroutines.u0;
import kotlinx.coroutines.z0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: TestCoroutineContext.kt */
@Deprecated(level = DeprecationLevel.WARNING, message = "This API has been deprecated to integrate with Structured Concurrency.", replaceWith = @ReplaceWith(expression = "TestCoroutineScope", imports = {"kotlin.coroutines.test"}))
@Metadata(bv = {}, d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0007\u0018\u00002\u00020\u0001:\u00012B\u0013\u0012\n\b\u0002\u0010C\u001a\u0004\u0018\u00010\"\u00a2\u0006\u0004\bG\u0010HJ\u0014\u0010\u0006\u001a\u00020\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0002J\u001c\u0010\n\u001a\u00020\t2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\u000b\u001a\u00020\u0007H\u0002J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0007H\u0002J7\u0010\u0013\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u000e2\u0006\u0010\u000f\u001a\u00028\u00002\u0018\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00028\u00000\u0010H\u0016\u00a2\u0006\u0004\b\u0013\u0010\u0014J*\u0010\u0018\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0015*\u00020\u00112\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0016H\u0096\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0014\u0010\u001a\u001a\u00020\u00012\n\u0010\u0017\u001a\u0006\u0012\u0002\b\u00030\u0016H\u0016J\u0010\u0010\u001d\u001a\u00020\u00072\b\b\u0002\u0010\u001c\u001a\u00020\u001bJ\u0018\u0010\u001e\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\u001c\u001a\u00020\u001bJ\u0018\u0010\u001f\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\u001c\u001a\u00020\u001bJ\u0006\u0010 \u001a\u00020\u0005J\u0006\u0010!\u001a\u00020\u0005J$\u0010(\u001a\u00020\u00052\b\b\u0002\u0010#\u001a\u00020\"2\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020&0$J$\u0010)\u001a\u00020\u00052\b\b\u0002\u0010#\u001a\u00020\"2\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020&0$J$\u0010*\u001a\u00020\u00052\b\b\u0002\u0010#\u001a\u00020\"2\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020&0$J*\u0010\u0015\u001a\u00020\u00052\b\b\u0002\u0010#\u001a\u00020\"2\u0018\u0010'\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020%0+\u0012\u0004\u0012\u00020&0$J\b\u0010,\u001a\u00020\"H\u0016R\u001a\u00100\u001a\b\u0012\u0004\u0012\u00020%0-8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0018\u00104\u001a\u000601R\u00020\u00008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0014\u00108\u001a\u0002058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b6\u00107R\u001a\u0010<\u001a\b\u0012\u0004\u0012\u00020\t098\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010>\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010\u0006R\u0016\u0010@\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010\u0006R\u0016\u0010C\u001a\u0004\u0018\u00010\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bA\u0010BR\u0017\u0010F\u001a\b\u0012\u0004\u0012\u00020%0+8F\u00a2\u0006\u0006\u001a\u0004\bD\u0010E\u00a8\u0006I"}, d2 = {"Lkotlinx/coroutines/test/a;", "Lkotlin/coroutines/f;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "block", "Lkotlin/f1;", "J", "", "delayTime", "Lkotlinx/coroutines/test/c;", "O", "P", "targetTime", "T", "R", "initial", "Lkotlin/Function2;", "Lkotlin/coroutines/f$b;", "operation", "fold", "(Ljava/lang/Object;Ld2/p;)Ljava/lang/Object;", "E", "Lkotlin/coroutines/f$c;", DomainCampaignEx.LOOPBACK_KEY, f3.f5657f, "(Lkotlin/coroutines/f$c;)Lkotlin/coroutines/f$b;", "minusKey", "Ljava/util/concurrent/TimeUnit;", "unit", "L", "p", "r", "S", "I", "", "message", "Lkotlin/Function1;", "", "", "predicate", "G", "w", "C", "", "toString", "", "a", "Ljava/util/List;", "uncaughtExceptions", "Lkotlinx/coroutines/test/a$b;", "b", "Lkotlinx/coroutines/test/a$b;", "ctxDispatcher", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "c", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "ctxHandler", "Lkotlinx/coroutines/internal/s0;", "d", "Lkotlinx/coroutines/internal/s0;", "queue", "e", "counter", "f", "time", "g", "Ljava/lang/String;", "name", "K", "()Ljava/util/List;", "exceptions", "<init>", "(Ljava/lang/String;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class a implements f {

    /* renamed from: a  reason: collision with root package name */
    private final List<Throwable> f60724a;

    /* renamed from: b  reason: collision with root package name */
    private final b f60725b;

    /* renamed from: c  reason: collision with root package name */
    private final CoroutineExceptionHandler f60726c;

    /* renamed from: d  reason: collision with root package name */
    private final s0<c> f60727d;

    /* renamed from: e  reason: collision with root package name */
    private long f60728e;

    /* renamed from: f  reason: collision with root package name */
    private long f60729f;

    /* renamed from: g  reason: collision with root package name */
    private final String f60730g;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: CoroutineExceptionHandler.kt */
    @Metadata(bv = {}, d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00a8\u0006\t\u00b8\u0006\u0000"}, d2 = {"kotlinx/coroutines/n0$a", "Lkotlin/coroutines/a;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "Lkotlin/coroutines/f;", "context", "", "exception", "Lkotlin/f1;", "handleException", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.test.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class C1225a extends kotlin.coroutines.a implements CoroutineExceptionHandler {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f60731a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1225a(f.c cVar, a aVar) {
            super(cVar);
            this.f60731a = aVar;
        }

        @Override // kotlinx.coroutines.CoroutineExceptionHandler
        public void handleException(@NotNull f fVar, @NotNull Throwable th) {
            this.f60731a.f60724a.add(th);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: TestCoroutineContext.kt */
    @Metadata(bv = {}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u001c\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\n\u0010\u0007\u001a\u00060\u0005j\u0002`\u0006H\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\u001e\u0010\u0010\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\f2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u000eH\u0016J$\u0010\u0012\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\f2\n\u0010\u0007\u001a\u00060\u0005j\u0002`\u00062\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0013\u001a\u00020\fH\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0016\u00a8\u0006\u0018"}, d2 = {"Lkotlinx/coroutines/test/a$b;", "Lkotlinx/coroutines/m1;", "Lkotlinx/coroutines/z0;", "Lkotlin/coroutines/f;", "context", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "block", "Lkotlin/f1;", "dispatch", "", "J", "", "timeMillis", "Lkotlinx/coroutines/o;", "continuation", "d", "Lkotlinx/coroutines/i1;", "f", "H", "", "toString", "<init>", "(Lkotlinx/coroutines/test/a;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    private final class b extends m1 implements z0 {

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
        /* compiled from: TestCoroutineContext.kt */
        @Metadata(bv = {}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"kotlinx/coroutines/test/a$b$a", "Lkotlinx/coroutines/i1;", "Lkotlin/f1;", "dispose", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
        /* renamed from: kotlinx.coroutines.test.a$b$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public static final class C1226a implements i1 {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ c f60734b;

            C1226a(c cVar) {
                this.f60734b = cVar;
            }

            @Override // kotlinx.coroutines.i1
            public void dispose() {
                a.this.f60727d.j(this.f60734b);
            }
        }

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
        /* compiled from: Runnable.kt */
        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0004\u001a\u00020\u0000H\n\u00a2\u0006\u0004\b\u0001\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lkotlin/f1;", "run", "()V", "kotlinx/coroutines/a3$a", "<anonymous>"}, k = 3, mv = {1, 4, 0})
        /* renamed from: kotlinx.coroutines.test.a$b$b  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public static final class RunnableC1227b implements Runnable {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ o f60736b;

            public RunnableC1227b(o oVar) {
                this.f60736b = oVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f60736b.G(b.this, f1.f55527a);
            }
        }

        public b() {
            m1.D(this, false, 1, null);
        }

        @Override // kotlinx.coroutines.m1
        public long H() {
            return a.this.P();
        }

        @Override // kotlinx.coroutines.m1
        public boolean J() {
            return true;
        }

        @Override // kotlinx.coroutines.z0
        public void d(long j4, @NotNull o<? super f1> oVar) {
            a.this.O(new RunnableC1227b(oVar), j4);
        }

        @Override // kotlinx.coroutines.l0
        public void dispatch(@NotNull f fVar, @NotNull Runnable runnable) {
            a.this.J(runnable);
        }

        @Override // kotlinx.coroutines.z0
        @NotNull
        public i1 f(long j4, @NotNull Runnable runnable, @NotNull f fVar) {
            return new C1226a(a.this.O(runnable, j4));
        }

        @Override // kotlinx.coroutines.z0
        @Nullable
        public Object o(long j4, @NotNull kotlin.coroutines.c<? super f1> cVar) {
            return z0.a.a(this, j4, cVar);
        }

        @Override // kotlinx.coroutines.l0
        @NotNull
        public String toString() {
            return "Dispatcher(" + a.this + ')';
        }
    }

    public a() {
        this(null, 1, null);
    }

    public a(@Nullable String str) {
        this.f60730g = str;
        this.f60724a = new ArrayList();
        this.f60725b = new b();
        this.f60726c = new C1225a(CoroutineExceptionHandler.f59029h0, this);
        this.f60727d = new s0<>();
    }

    public static /* synthetic */ void B(a aVar, String str, l lVar, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            str = "";
        }
        aVar.w(str, lVar);
    }

    public static /* synthetic */ void D(a aVar, String str, l lVar, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            str = "";
        }
        aVar.C(str, lVar);
    }

    public static /* synthetic */ void F(a aVar, String str, l lVar, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            str = "";
        }
        aVar.E(str, lVar);
    }

    public static /* synthetic */ void H(a aVar, String str, l lVar, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            str = "";
        }
        aVar.G(str, lVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void J(Runnable runnable) {
        s0<c> s0Var = this.f60727d;
        long j4 = this.f60728e;
        this.f60728e = 1 + j4;
        s0Var.b(new c(runnable, j4, 0L, 4, null));
    }

    public static /* synthetic */ long N(a aVar, TimeUnit timeUnit, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            timeUnit = TimeUnit.MILLISECONDS;
        }
        return aVar.L(timeUnit);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final c O(Runnable runnable, long j4) {
        long j5 = this.f60728e;
        this.f60728e = 1 + j5;
        c cVar = new c(runnable, j5, this.f60729f + TimeUnit.MILLISECONDS.toNanos(j4));
        this.f60727d.b(cVar);
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long P() {
        c h4 = this.f60727d.h();
        if (h4 != null) {
            T(h4.f60741e);
        }
        return this.f60727d.g() ? Long.MAX_VALUE : 0L;
    }

    private final void T(long j4) {
        c cVar;
        while (true) {
            s0<c> s0Var = this.f60727d;
            synchronized (s0Var) {
                c e4 = s0Var.e();
                if (e4 != null) {
                    cVar = (e4.f60741e > j4 ? 1 : (e4.f60741e == j4 ? 0 : -1)) <= 0 ? s0Var.k(0) : null;
                }
            }
            c cVar2 = cVar;
            if (cVar2 == null) {
                return;
            }
            long j5 = cVar2.f60741e;
            if (j5 != 0) {
                this.f60729f = j5;
            }
            cVar2.run();
        }
    }

    public static /* synthetic */ long q(a aVar, long j4, TimeUnit timeUnit, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            timeUnit = TimeUnit.MILLISECONDS;
        }
        return aVar.p(j4, timeUnit);
    }

    public static /* synthetic */ void t(a aVar, long j4, TimeUnit timeUnit, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            timeUnit = TimeUnit.MILLISECONDS;
        }
        aVar.r(j4, timeUnit);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void C(@NotNull String str, @NotNull l<? super Throwable, Boolean> lVar) {
        List<Throwable> list = this.f60724a;
        boolean z3 = false;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (lVar.invoke(it.next()).booleanValue()) {
                    z3 = true;
                    break;
                }
            }
        }
        if (z3) {
            this.f60724a.clear();
            return;
        }
        throw new AssertionError(str);
    }

    public final void E(@NotNull String str, @NotNull l<? super List<? extends Throwable>, Boolean> lVar) {
        if (lVar.invoke(this.f60724a).booleanValue()) {
            this.f60724a.clear();
            return;
        }
        throw new AssertionError(str);
    }

    public final void G(@NotNull String str, @NotNull l<? super Throwable, Boolean> lVar) {
        if (this.f60724a.size() == 1 && lVar.invoke(this.f60724a.get(0)).booleanValue()) {
            this.f60724a.clear();
            return;
        }
        throw new AssertionError(str);
    }

    public final void I() {
        if (this.f60727d.g()) {
            return;
        }
        this.f60727d.d();
    }

    @NotNull
    public final List<Throwable> K() {
        return this.f60724a;
    }

    public final long L(@NotNull TimeUnit timeUnit) {
        return timeUnit.convert(this.f60729f, TimeUnit.NANOSECONDS);
    }

    public final void S() {
        T(this.f60729f);
    }

    @Override // kotlin.coroutines.f
    public <R> R fold(R r3, @NotNull p<? super R, ? super f.b, ? extends R> pVar) {
        return pVar.invoke((R) pVar.invoke(r3, this.f60725b), this.f60726c);
    }

    @Override // kotlin.coroutines.f
    @Nullable
    public <E extends f.b> E get(@NotNull f.c<E> cVar) {
        if (cVar == d.f55503f0) {
            b bVar = this.f60725b;
            if (bVar != null) {
                return bVar;
            }
            throw new NullPointerException("null cannot be cast to non-null type E");
        } else if (cVar == CoroutineExceptionHandler.f59029h0) {
            CoroutineExceptionHandler coroutineExceptionHandler = this.f60726c;
            if (coroutineExceptionHandler != null) {
                return coroutineExceptionHandler;
            }
            throw new NullPointerException("null cannot be cast to non-null type E");
        } else {
            return null;
        }
    }

    @Override // kotlin.coroutines.f
    @NotNull
    public f minusKey(@NotNull f.c<?> cVar) {
        return cVar == d.f55503f0 ? this.f60726c : cVar == CoroutineExceptionHandler.f59029h0 ? this.f60725b : this;
    }

    public final long p(long j4, @NotNull TimeUnit timeUnit) {
        long j5 = this.f60729f;
        TimeUnit timeUnit2 = TimeUnit.NANOSECONDS;
        r(timeUnit.toNanos(j4) + j5, timeUnit2);
        return timeUnit.convert(this.f60729f - j5, timeUnit2);
    }

    @Override // kotlin.coroutines.f
    @NotNull
    public f plus(@NotNull f fVar) {
        return f.a.a(this, fVar);
    }

    public final void r(long j4, @NotNull TimeUnit timeUnit) {
        long nanos = timeUnit.toNanos(j4);
        T(nanos);
        if (nanos > this.f60729f) {
            this.f60729f = nanos;
        }
    }

    @NotNull
    public String toString() {
        String str = this.f60730g;
        if (str != null) {
            return str;
        }
        return "TestCoroutineContext@" + u0.b(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void w(@NotNull String str, @NotNull l<? super Throwable, Boolean> lVar) {
        List<Throwable> list = this.f60724a;
        boolean z3 = true;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (!lVar.invoke(it.next()).booleanValue()) {
                    z3 = false;
                    break;
                }
            }
        }
        if (z3) {
            this.f60724a.clear();
            return;
        }
        throw new AssertionError(str);
    }

    public /* synthetic */ a(String str, int i4, u uVar) {
        this((i4 & 1) != 0 ? null : str);
    }
}

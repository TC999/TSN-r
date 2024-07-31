package kotlinx.coroutines.test;

import androidx.exifinterface.media.ExifInterface;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import com.umeng.analytics.pro.UMCommonContent;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Annotations;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.coroutines.AbstractC14266a;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.InterfaceC14268c;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.AbstractC15133m1;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.DebugStrings;
import kotlinx.coroutines.InterfaceC15064i1;
import kotlinx.coroutines.InterfaceC15146o;
import kotlinx.coroutines.InterfaceC15263z0;
import kotlinx.coroutines.internal.ThreadSafeHeap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15280l;
import p617l1.InterfaceC15284p;

@Annotations(level = DeprecationLevel.WARNING, message = "This API has been deprecated to integrate with Structured Concurrency.", replaceWith = @ReplaceWith(expression = "TestCoroutineScope", imports = {"kotlin.coroutines.test"}))
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0007\u0018\u00002\u00020\u0001:\u00013B\u0013\u0012\n\b\u0002\u0010D\u001a\u0004\u0018\u00010\"¢\u0006\u0004\bH\u0010IJ\u0014\u0010\u0006\u001a\u00020\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0002J\u001c\u0010\n\u001a\u00020\t2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\u000b\u001a\u00020\u0007H\u0002J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0007H\u0002J7\u0010\u0013\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u000e2\u0006\u0010\u000f\u001a\u00028\u00002\u0018\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00028\u00000\u0010H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J*\u0010\u0018\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0015*\u00020\u00112\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0016H\u0096\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0014\u0010\u001a\u001a\u00020\u00012\n\u0010\u0017\u001a\u0006\u0012\u0002\b\u00030\u0016H\u0016J\u0010\u0010\u001d\u001a\u00020\u00072\b\b\u0002\u0010\u001c\u001a\u00020\u001bJ\u0018\u0010\u001e\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\u001c\u001a\u00020\u001bJ\u0018\u0010\u001f\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\u001c\u001a\u00020\u001bJ\u0006\u0010 \u001a\u00020\u0005J\u0006\u0010!\u001a\u00020\u0005J$\u0010(\u001a\u00020\u00052\b\b\u0002\u0010#\u001a\u00020\"2\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020&0$J$\u0010)\u001a\u00020\u00052\b\b\u0002\u0010#\u001a\u00020\"2\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020&0$J$\u0010*\u001a\u00020\u00052\b\b\u0002\u0010#\u001a\u00020\"2\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020&0$J*\u0010,\u001a\u00020\u00052\b\b\u0002\u0010#\u001a\u00020\"2\u0018\u0010'\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020%0+\u0012\u0004\u0012\u00020&0$J\b\u0010-\u001a\u00020\"H\u0016R\u001a\u00101\u001a\b\u0012\u0004\u0012\u00020%0.8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u0018\u00105\u001a\u000602R\u00020\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u0014\u00109\u001a\u0002068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b7\u00108R\u001a\u0010=\u001a\b\u0012\u0004\u0012\u00020\t0:8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010?\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u0010\u0006R\u0016\u0010A\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010\u0006R\u0016\u0010D\u001a\u0004\u0018\u00010\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bB\u0010CR\u0017\u0010G\u001a\b\u0012\u0004\u0012\u00020%0+8F¢\u0006\u0006\u001a\u0004\bE\u0010F¨\u0006J"}, m12616d2 = {"Lkotlinx/coroutines/test/a;", "Lkotlin/coroutines/f;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "block", "Lkotlin/f1;", "J", "", "delayTime", "Lkotlinx/coroutines/test/c;", "N", "P", "targetTime", ExifInterface.GPS_DIRECTION_TRUE, "R", "initial", "Lkotlin/Function2;", "Lkotlin/coroutines/f$b;", "operation", "fold", "(Ljava/lang/Object;Ll1/p;)Ljava/lang/Object;", ExifInterface.LONGITUDE_EAST, "Lkotlin/coroutines/f$c;", DomainCampaignEx.LOOPBACK_KEY, "get", "(Lkotlin/coroutines/f$c;)Lkotlin/coroutines/f$b;", "minusKey", "Ljava/util/concurrent/TimeUnit;", "unit", "L", "p", "r", "Q", "I", "", "message", "Lkotlin/Function1;", "", "", "predicate", "G", "u", UMCommonContent.f37777aG, "", "C", "toString", "", "a", "Ljava/util/List;", "uncaughtExceptions", "Lkotlinx/coroutines/test/a$b;", "b", "Lkotlinx/coroutines/test/a$b;", "ctxDispatcher", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "c", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "ctxHandler", "Lkotlinx/coroutines/internal/s0;", "d", "Lkotlinx/coroutines/internal/s0;", "queue", "e", "counter", "f", RtspHeaders.Values.TIME, "g", "Ljava/lang/String;", "name", "K", "()Ljava/util/List;", "exceptions", "<init>", "(Ljava/lang/String;)V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.test.a */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class TestCoroutineContext implements CoroutineContext {

    /* renamed from: a */
    private final List<Throwable> f43407a;

    /* renamed from: b */
    private final C15230b f43408b;

    /* renamed from: c */
    private final CoroutineExceptionHandler f43409c;

    /* renamed from: d */
    private final ThreadSafeHeap<RunnableC15234c> f43410d;

    /* renamed from: e */
    private long f43411e;

    /* renamed from: f */
    private long f43412f;

    /* renamed from: g */
    private final String f43413g;

    /* compiled from: CoroutineExceptionHandler.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¨\u0006\t¸\u0006\u0000"}, m12616d2 = {"kotlinx/coroutines/n0$a", "Lkotlin/coroutines/a;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "Lkotlin/coroutines/f;", "context", "", "exception", "Lkotlin/f1;", "handleException", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.test.a$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15229a extends AbstractC14266a implements CoroutineExceptionHandler {

        /* renamed from: a */
        final /* synthetic */ TestCoroutineContext f43414a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C15229a(CoroutineContext.InterfaceC14277c interfaceC14277c, TestCoroutineContext testCoroutineContext) {
            super(interfaceC14277c);
            this.f43414a = testCoroutineContext;
        }

        @Override // kotlinx.coroutines.CoroutineExceptionHandler
        public void handleException(@NotNull CoroutineContext coroutineContext, @NotNull Throwable th) {
            this.f43414a.f43407a.add(th);
        }
    }

    /* compiled from: TestCoroutineContext.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0016\u0010\u0017J\u001c\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\n\u0010\u0007\u001a\u00060\u0005j\u0002`\u0006H\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\u001e\u0010\u0010\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\f2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u000eH\u0016J$\u0010\u0012\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\f2\n\u0010\u0007\u001a\u00060\u0005j\u0002`\u00062\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0013\u001a\u00020\fH\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0016¨\u0006\u0018"}, m12616d2 = {"Lkotlinx/coroutines/test/a$b;", "Lkotlinx/coroutines/m1;", "Lkotlinx/coroutines/z0;", "Lkotlin/coroutines/f;", "context", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "block", "Lkotlin/f1;", "dispatch", "", "L", "", "timeMillis", "Lkotlinx/coroutines/o;", "continuation", "d", "Lkotlinx/coroutines/i1;", "e", "J", "", "toString", "<init>", "(Lkotlinx/coroutines/test/a;)V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.test.a$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    private final class C15230b extends AbstractC15133m1 implements InterfaceC15263z0 {

        /* compiled from: TestCoroutineContext.kt */
        @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0004"}, m12616d2 = {"kotlinx/coroutines/test/a$b$a", "Lkotlinx/coroutines/i1;", "Lkotlin/f1;", "dispose", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
        /* renamed from: kotlinx.coroutines.test.a$b$a */
        /* loaded from: E:\fuckcool\tsn\5406560.dex */
        public static final class C15231a implements InterfaceC15064i1 {

            /* renamed from: b */
            final /* synthetic */ RunnableC15234c f43417b;

            C15231a(RunnableC15234c runnableC15234c) {
                this.f43417b = runnableC15234c;
            }

            @Override // kotlinx.coroutines.InterfaceC15064i1
            public void dispose() {
                TestCoroutineContext.this.f43410d.m4178j(this.f43417b);
            }
        }

        /* compiled from: Runnable.kt */
        @Metadata(m12618bv = {}, m12617d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0004\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002¨\u0006\u0003"}, m12616d2 = {"Lkotlin/f1;", "run", "()V", "kotlinx/coroutines/a3$a", "<anonymous>"}, m12615k = 3, m12614mv = {1, 4, 0})
        /* renamed from: kotlinx.coroutines.test.a$b$b */
        /* loaded from: E:\fuckcool\tsn\5406560.dex */
        public static final class RunnableC15232b implements Runnable {

            /* renamed from: b */
            final /* synthetic */ InterfaceC15146o f43419b;

            public RunnableC15232b(InterfaceC15146o interfaceC15146o) {
                this.f43419b = interfaceC15146o;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f43419b.mo3916I(C15230b.this, Unit.f41048a);
            }
        }

        public C15230b() {
            AbstractC15133m1.m3995F(this, false, 1, null);
        }

        @Override // kotlinx.coroutines.AbstractC15133m1
        /* renamed from: J */
        public long mo3563J() {
            return TestCoroutineContext.this.m3578P();
        }

        @Override // kotlinx.coroutines.AbstractC15133m1
        /* renamed from: L */
        public boolean mo3562L() {
            return true;
        }

        @Override // kotlinx.coroutines.InterfaceC15263z0
        /* renamed from: d */
        public void mo3487d(long j, @NotNull InterfaceC15146o<? super Unit> interfaceC15146o) {
            TestCoroutineContext.this.m3579N(new RunnableC15232b(interfaceC15146o), j);
        }

        @Override // kotlinx.coroutines.CoroutineDispatcher
        public void dispatch(@NotNull CoroutineContext coroutineContext, @NotNull Runnable runnable) {
            TestCoroutineContext.this.m3583J(runnable);
        }

        @Override // kotlinx.coroutines.InterfaceC15263z0
        @NotNull
        /* renamed from: e */
        public InterfaceC15064i1 mo3486e(long j, @NotNull Runnable runnable, @NotNull CoroutineContext coroutineContext) {
            return new C15231a(TestCoroutineContext.this.m3579N(runnable, j));
        }

        @Override // kotlinx.coroutines.InterfaceC15263z0
        @Nullable
        /* renamed from: k */
        public Object mo3485k(long j, @NotNull InterfaceC14268c<? super Unit> interfaceC14268c) {
            return InterfaceC15263z0.C15264a.m3484a(this, j, interfaceC14268c);
        }

        @Override // kotlinx.coroutines.CoroutineDispatcher
        @NotNull
        public String toString() {
            return "Dispatcher(" + TestCoroutineContext.this + ')';
        }
    }

    public TestCoroutineContext() {
        this(null, 1, null);
    }

    public TestCoroutineContext(@Nullable String str) {
        this.f43413g = str;
        this.f43407a = new ArrayList();
        this.f43408b = new C15230b();
        this.f43409c = new C15229a(CoroutineExceptionHandler.f41684l0, this);
        this.f43410d = new ThreadSafeHeap<>();
    }

    /* renamed from: B */
    public static /* synthetic */ void m3589B(TestCoroutineContext testCoroutineContext, String str, InterfaceC15280l interfaceC15280l, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "";
        }
        testCoroutineContext.m3564z(str, interfaceC15280l);
    }

    /* renamed from: F */
    public static /* synthetic */ void m3587F(TestCoroutineContext testCoroutineContext, String str, InterfaceC15280l interfaceC15280l, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "";
        }
        testCoroutineContext.m3588C(str, interfaceC15280l);
    }

    /* renamed from: H */
    public static /* synthetic */ void m3585H(TestCoroutineContext testCoroutineContext, String str, InterfaceC15280l interfaceC15280l, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "";
        }
        testCoroutineContext.m3586G(str, interfaceC15280l);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: J */
    public final void m3583J(Runnable runnable) {
        ThreadSafeHeap<RunnableC15234c> threadSafeHeap = this.f43410d;
        long j = this.f43411e;
        this.f43411e = 1 + j;
        threadSafeHeap.m4186b(new RunnableC15234c(runnable, j, 0L, 4, null));
    }

    /* renamed from: M */
    public static /* synthetic */ long m3580M(TestCoroutineContext testCoroutineContext, TimeUnit timeUnit, int i, Object obj) {
        if ((i & 1) != 0) {
            timeUnit = TimeUnit.MILLISECONDS;
        }
        return testCoroutineContext.m3581L(timeUnit);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: N */
    public final RunnableC15234c m3579N(Runnable runnable, long j) {
        long j2 = this.f43411e;
        this.f43411e = 1 + j2;
        RunnableC15234c runnableC15234c = new RunnableC15234c(runnable, j2, this.f43412f + TimeUnit.MILLISECONDS.toNanos(j));
        this.f43410d.m4186b(runnableC15234c);
        return runnableC15234c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: P */
    public final long m3578P() {
        RunnableC15234c m4180h = this.f43410d.m4180h();
        if (m4180h != null) {
            m3576T(m4180h.f43424e);
        }
        return this.f43410d.m4181g() ? Long.MAX_VALUE : 0L;
    }

    /* renamed from: T */
    private final void m3576T(long j) {
        RunnableC15234c runnableC15234c;
        while (true) {
            ThreadSafeHeap<RunnableC15234c> threadSafeHeap = this.f43410d;
            synchronized (threadSafeHeap) {
                RunnableC15234c m4183e = threadSafeHeap.m4183e();
                if (m4183e != null) {
                    runnableC15234c = (m4183e.f43424e > j ? 1 : (m4183e.f43424e == j ? 0 : -1)) <= 0 ? threadSafeHeap.m4177k(0) : null;
                }
            }
            RunnableC15234c runnableC15234c2 = runnableC15234c;
            if (runnableC15234c2 == null) {
                return;
            }
            long j2 = runnableC15234c2.f43424e;
            if (j2 != 0) {
                this.f43412f = j2;
            }
            runnableC15234c2.run();
        }
    }

    /* renamed from: q */
    public static /* synthetic */ long m3569q(TestCoroutineContext testCoroutineContext, long j, TimeUnit timeUnit, int i, Object obj) {
        if ((i & 2) != 0) {
            timeUnit = TimeUnit.MILLISECONDS;
        }
        return testCoroutineContext.m3570p(j, timeUnit);
    }

    /* renamed from: s */
    public static /* synthetic */ void m3567s(TestCoroutineContext testCoroutineContext, long j, TimeUnit timeUnit, int i, Object obj) {
        if ((i & 2) != 0) {
            timeUnit = TimeUnit.MILLISECONDS;
        }
        testCoroutineContext.m3568r(j, timeUnit);
    }

    /* renamed from: v */
    public static /* synthetic */ void m3565v(TestCoroutineContext testCoroutineContext, String str, InterfaceC15280l interfaceC15280l, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "";
        }
        testCoroutineContext.m3566u(str, interfaceC15280l);
    }

    /* renamed from: C */
    public final void m3588C(@NotNull String str, @NotNull InterfaceC15280l<? super List<? extends Throwable>, Boolean> interfaceC15280l) {
        if (interfaceC15280l.invoke(this.f43407a).booleanValue()) {
            this.f43407a.clear();
            return;
        }
        throw new AssertionError(str);
    }

    /* renamed from: G */
    public final void m3586G(@NotNull String str, @NotNull InterfaceC15280l<? super Throwable, Boolean> interfaceC15280l) {
        if (this.f43407a.size() == 1 && interfaceC15280l.invoke(this.f43407a.get(0)).booleanValue()) {
            this.f43407a.clear();
            return;
        }
        throw new AssertionError(str);
    }

    /* renamed from: I */
    public final void m3584I() {
        if (this.f43410d.m4181g()) {
            return;
        }
        this.f43410d.m4184d();
    }

    @NotNull
    /* renamed from: K */
    public final List<Throwable> m3582K() {
        return this.f43407a;
    }

    /* renamed from: L */
    public final long m3581L(@NotNull TimeUnit timeUnit) {
        return timeUnit.convert(this.f43412f, TimeUnit.NANOSECONDS);
    }

    /* renamed from: Q */
    public final void m3577Q() {
        m3576T(this.f43412f);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public <R> R fold(R r, @NotNull InterfaceC15284p<? super R, ? super CoroutineContext.InterfaceC14275b, ? extends R> interfaceC15284p) {
        return interfaceC15284p.invoke((R) interfaceC15284p.invoke(r, this.f43408b), this.f43409c);
    }

    @Override // kotlin.coroutines.CoroutineContext
    @Nullable
    public <E extends CoroutineContext.InterfaceC14275b> E get(@NotNull CoroutineContext.InterfaceC14277c<E> interfaceC14277c) {
        if (interfaceC14277c == ContinuationInterceptor.f41024k0) {
            C15230b c15230b = this.f43408b;
            if (c15230b != null) {
                return c15230b;
            }
            throw new NullPointerException("null cannot be cast to non-null type E");
        } else if (interfaceC14277c == CoroutineExceptionHandler.f41684l0) {
            CoroutineExceptionHandler coroutineExceptionHandler = this.f43409c;
            if (coroutineExceptionHandler != null) {
                return coroutineExceptionHandler;
            }
            throw new NullPointerException("null cannot be cast to non-null type E");
        } else {
            return null;
        }
    }

    @Override // kotlin.coroutines.CoroutineContext
    @NotNull
    public CoroutineContext minusKey(@NotNull CoroutineContext.InterfaceC14277c<?> interfaceC14277c) {
        return interfaceC14277c == ContinuationInterceptor.f41024k0 ? this.f43409c : interfaceC14277c == CoroutineExceptionHandler.f41684l0 ? this.f43408b : this;
    }

    /* renamed from: p */
    public final long m3570p(long j, @NotNull TimeUnit timeUnit) {
        long j2 = this.f43412f;
        TimeUnit timeUnit2 = TimeUnit.NANOSECONDS;
        m3568r(timeUnit.toNanos(j) + j2, timeUnit2);
        return timeUnit.convert(this.f43412f - j2, timeUnit2);
    }

    @Override // kotlin.coroutines.CoroutineContext
    @NotNull
    public CoroutineContext plus(@NotNull CoroutineContext coroutineContext) {
        return CoroutineContext.C14273a.m8663a(this, coroutineContext);
    }

    /* renamed from: r */
    public final void m3568r(long j, @NotNull TimeUnit timeUnit) {
        long nanos = timeUnit.toNanos(j);
        m3576T(nanos);
        if (nanos > this.f43412f) {
            this.f43412f = nanos;
        }
    }

    @NotNull
    public String toString() {
        String str = this.f43413g;
        if (str != null) {
            return str;
        }
        return "TestCoroutineContext@" + DebugStrings.m3553b(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: u */
    public final void m3566u(@NotNull String str, @NotNull InterfaceC15280l<? super Throwable, Boolean> interfaceC15280l) {
        List<Throwable> list = this.f43407a;
        boolean z = true;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (!interfaceC15280l.invoke(it.next()).booleanValue()) {
                    z = false;
                    break;
                }
            }
        }
        if (z) {
            this.f43407a.clear();
            return;
        }
        throw new AssertionError(str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: z */
    public final void m3564z(@NotNull String str, @NotNull InterfaceC15280l<? super Throwable, Boolean> interfaceC15280l) {
        List<Throwable> list = this.f43407a;
        boolean z = false;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (interfaceC15280l.invoke(it.next()).booleanValue()) {
                    z = true;
                    break;
                }
            }
        }
        if (z) {
            this.f43407a.clear();
            return;
        }
        throw new AssertionError(str);
    }

    public /* synthetic */ TestCoroutineContext(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str);
    }
}

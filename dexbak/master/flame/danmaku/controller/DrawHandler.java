package master.flame.danmaku.controller;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.os.Handler;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.Choreographer;
import java.util.LinkedList;
import master.flame.danmaku.controller.IDrawTask;
import master.flame.danmaku.danmaku.model.AbsDanmakuSync;
import master.flame.danmaku.danmaku.model.AbsDisplayer;
import master.flame.danmaku.danmaku.model.BaseDanmaku;
import master.flame.danmaku.danmaku.model.DanmakuTimer;
import master.flame.danmaku.danmaku.model.IDanmakus;
import master.flame.danmaku.danmaku.model.IDisplayer;
import master.flame.danmaku.danmaku.model.android.DanmakuContext;
import master.flame.danmaku.danmaku.parser.BaseDanmakuParser;
import p014a2.IRenderer;
import p025b2.SystemClock;
import tv.cjump.jni.DeviceUtils;

/* renamed from: master.flame.danmaku.controller.c */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class DrawHandler extends Handler {

    /* renamed from: C */
    public static final int f43596C = 1;

    /* renamed from: D */
    public static final int f43597D = 2;

    /* renamed from: E */
    public static final int f43598E = 3;

    /* renamed from: F */
    public static final int f43599F = 4;

    /* renamed from: G */
    public static final int f43600G = 5;

    /* renamed from: H */
    private static final int f43601H = 6;

    /* renamed from: I */
    private static final int f43602I = 7;

    /* renamed from: J */
    private static final int f43603J = 8;

    /* renamed from: K */
    private static final int f43604K = 9;

    /* renamed from: L */
    private static final int f43605L = 10;

    /* renamed from: M */
    private static final int f43606M = 11;

    /* renamed from: N */
    private static final int f43607N = 12;

    /* renamed from: O */
    private static final int f43608O = 13;

    /* renamed from: P */
    private static final long f43609P = 10000000;

    /* renamed from: Q */
    private static final int f43610Q = 500;

    /* renamed from: A */
    private boolean f43611A;

    /* renamed from: B */
    private boolean f43612B;

    /* renamed from: a */
    private DanmakuContext f43613a;

    /* renamed from: b */
    private Choreographer$FrameCallbackC15332e f43614b;

    /* renamed from: c */
    private long f43615c;

    /* renamed from: d */
    private boolean f43616d;

    /* renamed from: e */
    private long f43617e;

    /* renamed from: f */
    private boolean f43618f;

    /* renamed from: g */
    private InterfaceC15331d f43619g;

    /* renamed from: h */
    private DanmakuTimer f43620h;

    /* renamed from: i */
    private BaseDanmakuParser f43621i;

    /* renamed from: j */
    public IDrawTask f43622j;

    /* renamed from: k */
    private IDanmakuViewController f43623k;

    /* renamed from: l */
    private boolean f43624l;

    /* renamed from: m */
    private AbsDisplayer f43625m;

    /* renamed from: n */
    private final IRenderer.C0025c f43626n;

    /* renamed from: o */
    private LinkedList<Long> f43627o;

    /* renamed from: p */
    private UpdateThread f43628p;

    /* renamed from: q */
    private boolean f43629q;

    /* renamed from: r */
    private long f43630r;

    /* renamed from: s */
    private long f43631s;

    /* renamed from: t */
    private long f43632t;

    /* renamed from: u */
    private long f43633u;

    /* renamed from: v */
    private long f43634v;

    /* renamed from: w */
    private boolean f43635w;

    /* renamed from: x */
    private long f43636x;

    /* renamed from: y */
    private long f43637y;

    /* renamed from: z */
    private boolean f43638z;

    /* compiled from: DrawHandler.java */
    /* renamed from: master.flame.danmaku.controller.c$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    class RunnableC15328a implements Runnable {
        RunnableC15328a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            DrawHandler.this.f43615c = 0L;
            DrawHandler.this.f43618f = true;
            if (DrawHandler.this.f43619g != null) {
                DrawHandler.this.f43619g.m3301c();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DrawHandler.java */
    /* renamed from: master.flame.danmaku.controller.c$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public class C15329b extends UpdateThread {
        C15329b(String str) {
            super(str);
        }

        @Override // master.flame.danmaku.controller.UpdateThread, java.lang.Thread, java.lang.Runnable
        public void run() {
            long m59951b = SystemClock.m59951b();
            while (!m3258a() && !DrawHandler.this.f43616d) {
                long m59951b2 = SystemClock.m59951b();
                if (DrawHandler.this.f43632t - (SystemClock.m59951b() - m59951b) > 1) {
                    SystemClock.m59952a(1L);
                } else {
                    long m3334a0 = DrawHandler.this.m3334a0(m59951b2);
                    if (m3334a0 < 0) {
                        SystemClock.m59952a(60 - m3334a0);
                    } else {
                        long mo2921l = DrawHandler.this.f43623k.mo2921l();
                        if (mo2921l > DrawHandler.this.f43631s) {
                            DrawHandler.this.f43620h.m3070a(mo2921l);
                            DrawHandler.this.f43627o.clear();
                        }
                        if (!DrawHandler.this.f43624l) {
                            DrawHandler.this.m3324f0(DrawHandler.f43609P);
                        } else if (DrawHandler.this.f43626n.f74p && DrawHandler.this.f43612B) {
                            long j = DrawHandler.this.f43626n.f73o - DrawHandler.this.f43620h.f43885a;
                            if (j > 500) {
                                DrawHandler.this.m3351K();
                                DrawHandler.this.m3324f0(j - 10);
                            }
                        }
                    }
                    m59951b = m59951b2;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DrawHandler.java */
    /* renamed from: master.flame.danmaku.controller.c$c */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public class C15330c implements IDrawTask.InterfaceC15341a {

        /* renamed from: a */
        final /* synthetic */ Runnable f43641a;

        C15330c(Runnable runnable) {
            this.f43641a = runnable;
        }

        @Override // master.flame.danmaku.controller.IDrawTask.InterfaceC15341a
        /* renamed from: a */
        public void mo3263a(BaseDanmaku baseDanmaku) {
            if (DrawHandler.this.f43619g != null) {
                DrawHandler.this.f43619g.m3300d(baseDanmaku);
            }
        }

        @Override // master.flame.danmaku.controller.IDrawTask.InterfaceC15341a
        /* renamed from: b */
        public void mo3262b(BaseDanmaku baseDanmaku) {
            if (baseDanmaku.m3073w()) {
                return;
            }
            long m3088b = baseDanmaku.m3088b() - DrawHandler.this.m3361A();
            if (m3088b < DrawHandler.this.f43613a.f43693D.f43792e && (DrawHandler.this.f43611A || DrawHandler.this.f43626n.f74p)) {
                DrawHandler.this.m3351K();
            } else if (m3088b <= 0 || m3088b > DrawHandler.this.f43613a.f43693D.f43792e) {
            } else {
                DrawHandler.this.sendEmptyMessageDelayed(11, m3088b);
            }
        }

        @Override // master.flame.danmaku.controller.IDrawTask.InterfaceC15341a
        /* renamed from: c */
        public void mo3261c() {
            DrawHandler.this.m3356F();
            this.f43641a.run();
        }

        @Override // master.flame.danmaku.controller.IDrawTask.InterfaceC15341a
        /* renamed from: d */
        public void mo3260d() {
            if (DrawHandler.this.f43619g != null) {
                DrawHandler.this.f43619g.m3303a();
            }
        }

        @Override // master.flame.danmaku.controller.IDrawTask.InterfaceC15341a
        /* renamed from: e */
        public void mo3259e() {
            DrawHandler.this.m3344R();
        }
    }

    /* compiled from: DrawHandler.java */
    /* renamed from: master.flame.danmaku.controller.c$d */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public interface InterfaceC15331d {
        /* renamed from: a */
        void m3303a();

        /* renamed from: b */
        void m3302b(DanmakuTimer danmakuTimer);

        /* renamed from: c */
        void m3301c();

        /* renamed from: d */
        void m3300d(BaseDanmaku baseDanmaku);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DrawHandler.java */
    @TargetApi(16)
    /* renamed from: master.flame.danmaku.controller.c$e */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public class Choreographer$FrameCallbackC15332e implements Choreographer.FrameCallback {
        private Choreographer$FrameCallbackC15332e() {
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long j) {
            DrawHandler.this.sendEmptyMessage(2);
        }

        /* synthetic */ Choreographer$FrameCallbackC15332e(DrawHandler drawHandler, RunnableC15328a runnableC15328a) {
            this();
        }
    }

    public DrawHandler(Looper looper, IDanmakuViewController iDanmakuViewController, boolean z) {
        super(looper);
        this.f43615c = 0L;
        this.f43616d = true;
        this.f43620h = new DanmakuTimer();
        this.f43624l = true;
        this.f43626n = new IRenderer.C0025c();
        this.f43627o = new LinkedList<>();
        this.f43630r = 30L;
        this.f43631s = 60L;
        this.f43632t = 16L;
        this.f43612B = true ^ DeviceUtils.m273g();
        m3309u(iDanmakuViewController);
        if (z) {
            m3336Z(null);
        } else {
            m3357E(false);
        }
        this.f43624l = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: F */
    public void m3356F() {
        long max = Math.max(33L, ((float) 16) * 2.5f);
        this.f43630r = max;
        this.f43631s = ((float) max) * 2.5f;
        long max2 = Math.max(16L, 15L);
        this.f43632t = max2;
        this.f43633u = max2 + 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: K */
    public void m3351K() {
        if (this.f43611A) {
            IDrawTask iDrawTask = this.f43622j;
            if (iDrawTask != null) {
                iDrawTask.mo3271f();
            }
            if (this.f43629q) {
                synchronized (this) {
                    this.f43627o.clear();
                }
                synchronized (this.f43622j) {
                    this.f43622j.notifyAll();
                }
            } else {
                this.f43627o.clear();
                removeMessages(2);
                sendEmptyMessage(2);
            }
            this.f43611A = false;
        }
    }

    /* renamed from: N */
    private void m3348N(Runnable runnable) {
        if (this.f43622j == null) {
            this.f43622j = m3307w(this.f43623k.mo2928e(), this.f43620h, this.f43623k.getContext(), this.f43623k.getWidth(), this.f43623k.getHeight(), this.f43623k.isHardwareAccelerated(), new C15330c(runnable));
        } else {
            runnable.run();
        }
    }

    /* renamed from: P */
    private void m3346P() {
        UpdateThread updateThread = this.f43628p;
        if (updateThread != null) {
            this.f43628p = null;
            synchronized (this.f43622j) {
                this.f43622j.notifyAll();
            }
            updateThread.m3257b();
            try {
                updateThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: Q */
    private synchronized void m3345Q() {
        this.f43627o.addLast(Long.valueOf(SystemClock.m59951b()));
        if (this.f43627o.size() > 500) {
            this.f43627o.removeFirst();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: R */
    public void m3344R() {
        if (this.f43616d && this.f43624l) {
            removeMessages(12);
            sendEmptyMessageDelayed(12, 100L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a0 */
    public final long m3334a0(long j) {
        long j2 = 0;
        if (!this.f43635w && !this.f43638z) {
            this.f43638z = true;
            long j3 = j - this.f43617e;
            if (this.f43624l && !this.f43626n.f74p && !this.f43611A) {
                long j4 = j3 - this.f43620h.f43885a;
                long max = Math.max(this.f43632t, m3305y());
                if (j4 <= 2000) {
                    long j5 = this.f43626n.f71m;
                    long j6 = this.f43630r;
                    if (j5 <= j6 && max <= j6) {
                        long j7 = this.f43632t;
                        long min = Math.min(this.f43630r, Math.max(j7, max + (j4 / j7)));
                        long j8 = this.f43634v;
                        long j9 = min - j8;
                        if (j9 > 3 && j9 < 8 && j8 >= this.f43632t && j8 <= this.f43630r) {
                            min = j8;
                        }
                        long j10 = j4 - min;
                        this.f43634v = min;
                        j4 = min;
                        j2 = j10;
                    }
                }
                this.f43637y = j2;
                this.f43620h.m3070a(j4);
                j2 = j4;
            } else {
                this.f43620h.update(j3);
                this.f43637y = 0L;
            }
            InterfaceC15331d interfaceC15331d = this.f43619g;
            if (interfaceC15331d != null) {
                interfaceC15331d.m3302b(this.f43620h);
            }
            this.f43638z = false;
        }
        return j2;
    }

    /* renamed from: b0 */
    private void m3332b0() {
        if (this.f43611A) {
            m3334a0(SystemClock.m59951b());
        }
    }

    @TargetApi(16)
    /* renamed from: c0 */
    private void m3330c0() {
        if (this.f43616d) {
            return;
        }
        Choreographer.getInstance().postFrameCallback(this.f43614b);
        if (m3334a0(SystemClock.m59951b()) < 0) {
            removeMessages(2);
            return;
        }
        long mo2921l = this.f43623k.mo2921l();
        removeMessages(2);
        if (mo2921l > this.f43631s) {
            this.f43620h.m3070a(mo2921l);
            this.f43627o.clear();
        }
        if (!this.f43624l) {
            m3324f0(f43609P);
            return;
        }
        IRenderer.C0025c c0025c = this.f43626n;
        if (c0025c.f74p && this.f43612B) {
            long j = c0025c.f73o - this.f43620h.f43885a;
            if (j > 500) {
                m3324f0(j - 10);
            }
        }
    }

    /* renamed from: d0 */
    private void m3328d0() {
        if (this.f43616d) {
            return;
        }
        long m3334a0 = m3334a0(SystemClock.m59951b());
        if (m3334a0 < 0) {
            removeMessages(2);
            sendEmptyMessageDelayed(2, 60 - m3334a0);
            return;
        }
        long mo2921l = this.f43623k.mo2921l();
        removeMessages(2);
        if (mo2921l > this.f43631s) {
            this.f43620h.m3070a(mo2921l);
            this.f43627o.clear();
        }
        if (!this.f43624l) {
            m3324f0(f43609P);
            return;
        }
        IRenderer.C0025c c0025c = this.f43626n;
        if (c0025c.f74p && this.f43612B) {
            long j = c0025c.f73o - this.f43620h.f43885a;
            if (j > 500) {
                m3324f0(j - 10);
                return;
            }
        }
        long j2 = this.f43632t;
        if (mo2921l < j2) {
            sendEmptyMessageDelayed(2, j2 - mo2921l);
        } else {
            sendEmptyMessage(2);
        }
    }

    /* renamed from: e0 */
    private void m3326e0() {
        if (this.f43628p != null) {
            return;
        }
        C15329b c15329b = new C15329b("DFM Update");
        this.f43628p = c15329b;
        c15329b.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f0 */
    public void m3324f0(long j) {
        if (m3353I() || !m3354H() || this.f43635w) {
            return;
        }
        this.f43626n.f75q = SystemClock.m59951b();
        this.f43611A = true;
        if (!this.f43629q) {
            if (j == f43609P) {
                removeMessages(11);
                removeMessages(2);
                return;
            }
            removeMessages(11);
            removeMessages(2);
            sendEmptyMessageDelayed(11, j);
        } else if (this.f43628p == null) {
        } else {
            try {
                synchronized (this.f43622j) {
                    if (j == f43609P) {
                        this.f43622j.wait();
                    } else {
                        this.f43622j.wait(j);
                    }
                    sendEmptyMessage(11);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: u */
    private void m3309u(IDanmakuViewController iDanmakuViewController) {
        this.f43623k = iDanmakuViewController;
    }

    /* renamed from: w */
    private IDrawTask m3307w(boolean z, DanmakuTimer danmakuTimer, Context context, int i, int i2, boolean z2, IDrawTask.InterfaceC15341a interfaceC15341a) {
        AbsDisplayer m3221g = this.f43613a.m3221g();
        this.f43625m = m3221g;
        m3221g.mo3038h(i, i2);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        this.f43625m.mo3042d(displayMetrics.density, displayMetrics.densityDpi, displayMetrics.scaledDensity);
        this.f43625m.mo3045a(this.f43613a.f43698c);
        this.f43625m.mo3029q(z2);
        IDrawTask cacheManagingDrawTask = z ? new CacheManagingDrawTask(danmakuTimer, this.f43613a, interfaceC15341a) : new DrawTask(danmakuTimer, this.f43613a, interfaceC15341a);
        cacheManagingDrawTask.mo3270g(this.f43621i);
        cacheManagingDrawTask.prepare();
        obtainMessage(10, Boolean.FALSE).sendToTarget();
        return cacheManagingDrawTask;
    }

    /* renamed from: y */
    private synchronized long m3305y() {
        int size = this.f43627o.size();
        if (size <= 0) {
            return 0L;
        }
        Long peekFirst = this.f43627o.peekFirst();
        Long peekLast = this.f43627o.peekLast();
        if (peekFirst != null && peekLast != null) {
            return (peekLast.longValue() - peekFirst.longValue()) / size;
        }
        return 0L;
    }

    /* renamed from: A */
    public long m3361A() {
        long j;
        long j2;
        if (this.f43618f) {
            if (this.f43635w) {
                return this.f43636x;
            }
            if (!this.f43616d && this.f43611A) {
                j = SystemClock.m59951b();
                j2 = this.f43617e;
            } else {
                j = this.f43620h.f43885a;
                j2 = this.f43637y;
            }
            return j - j2;
        }
        return 0L;
    }

    /* renamed from: B */
    public IDanmakus m3360B() {
        IDrawTask iDrawTask = this.f43622j;
        if (iDrawTask != null) {
            return iDrawTask.mo3272e(m3361A());
        }
        return null;
    }

    /* renamed from: C */
    public IDisplayer m3359C() {
        return this.f43625m;
    }

    /* renamed from: D */
    public boolean m3358D() {
        return this.f43624l;
    }

    /* renamed from: E */
    public long m3357E(boolean z) {
        if (!this.f43624l) {
            return this.f43620h.f43885a;
        }
        this.f43624l = false;
        removeMessages(8);
        removeMessages(9);
        obtainMessage(9, Boolean.valueOf(z)).sendToTarget();
        return this.f43620h.f43885a;
    }

    /* renamed from: G */
    public void m3355G(BaseDanmaku baseDanmaku, boolean z) {
        IDrawTask iDrawTask = this.f43622j;
        if (iDrawTask != null && baseDanmaku != null) {
            iDrawTask.mo3275b(baseDanmaku, z);
        }
        m3344R();
    }

    /* renamed from: H */
    public boolean m3354H() {
        return this.f43618f;
    }

    /* renamed from: I */
    public boolean m3353I() {
        return this.f43616d;
    }

    /* renamed from: J */
    public void m3352J(int i, int i2) {
        AbsDisplayer absDisplayer = this.f43625m;
        if (absDisplayer == null) {
            return;
        }
        if (absDisplayer.getWidth() == i && this.f43625m.getHeight() == i2) {
            return;
        }
        this.f43625m.mo3038h(i, i2);
        obtainMessage(10, Boolean.TRUE).sendToTarget();
    }

    /* renamed from: L */
    public void m3350L() {
        removeMessages(3);
        m3332b0();
        sendEmptyMessage(7);
    }

    /* renamed from: M */
    public void m3349M() {
        this.f43618f = false;
        if (this.f43613a.f43695F == 0) {
            this.f43614b = new Choreographer$FrameCallbackC15332e(this, null);
        }
        this.f43629q = this.f43613a.f43695F == 1;
        sendEmptyMessage(5);
    }

    /* renamed from: O */
    public void m3347O() {
        this.f43616d = true;
        sendEmptyMessage(6);
    }

    /* renamed from: S */
    public void m3343S(boolean z) {
        IDrawTask iDrawTask = this.f43622j;
        if (iDrawTask != null) {
            iDrawTask.mo3274c(z);
        }
    }

    /* renamed from: T */
    public void m3342T() {
        IDrawTask iDrawTask = this.f43622j;
        if (iDrawTask != null) {
            iDrawTask.mo3273d();
        }
    }

    /* renamed from: U */
    public void m3341U() {
        removeMessages(7);
        sendEmptyMessage(3);
    }

    /* renamed from: V */
    public void m3340V(Long l) {
        this.f43635w = true;
        this.f43636x = l.longValue();
        removeMessages(2);
        removeMessages(3);
        removeMessages(4);
        obtainMessage(4, l).sendToTarget();
    }

    /* renamed from: W */
    public void m3339W(InterfaceC15331d interfaceC15331d) {
        this.f43619g = interfaceC15331d;
    }

    /* renamed from: X */
    public void m3338X(DanmakuContext danmakuContext) {
        this.f43613a = danmakuContext;
    }

    /* renamed from: Y */
    public void m3337Y(BaseDanmakuParser baseDanmakuParser) {
        this.f43621i = baseDanmakuParser;
    }

    /* renamed from: Z */
    public void m3336Z(Long l) {
        if (this.f43624l) {
            return;
        }
        this.f43624l = true;
        removeMessages(8);
        removeMessages(9);
        obtainMessage(8, l).sendToTarget();
    }

    /* JADX WARN: Removed duplicated region for block: B:106:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:119:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01d9  */
    @Override // android.os.Handler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void handleMessage(android.os.Message r12) {
        /*
            Method dump skipped, instructions count: 508
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: master.flame.danmaku.controller.DrawHandler.handleMessage(android.os.Message):void");
    }

    /* renamed from: t */
    public void m3310t(BaseDanmaku baseDanmaku) {
        if (this.f43622j != null) {
            baseDanmaku.f43856I = this.f43613a.f43691B;
            baseDanmaku.m3091F(this.f43620h);
            this.f43622j.mo3276a(baseDanmaku);
            obtainMessage(11).sendToTarget();
        }
    }

    /* renamed from: v */
    public void m3308v() {
        obtainMessage(13).sendToTarget();
    }

    /* renamed from: x */
    public IRenderer.C0025c m3306x(Canvas canvas) {
        AbsDanmakuSync absDanmakuSync;
        boolean m3253d;
        if (this.f43622j == null) {
            return this.f43626n;
        }
        if (!this.f43611A && (absDanmakuSync = this.f43613a.f43710o) != null && ((m3253d = absDanmakuSync.m3253d()) || !this.f43616d)) {
            int m3256a = absDanmakuSync.m3256a();
            if (m3256a == 2) {
                long j = this.f43620h.f43885a;
                long m3254c = absDanmakuSync.m3254c();
                long j2 = m3254c - j;
                if (Math.abs(j2) > absDanmakuSync.m3255b()) {
                    if (m3253d && this.f43616d) {
                        m3341U();
                    }
                    this.f43622j.mo3264m(j, m3254c, j2);
                    this.f43620h.update(m3254c);
                    this.f43617e -= j2;
                    this.f43637y = 0L;
                }
            } else if (m3256a == 1 && m3253d && !this.f43616d) {
                m3350L();
            }
        }
        this.f43625m.mo3097z(canvas);
        this.f43626n.m60037f(this.f43622j.mo3267j(this.f43625m));
        m3345Q();
        return this.f43626n;
    }

    /* renamed from: z */
    public DanmakuContext m3304z() {
        return this.f43613a;
    }
}

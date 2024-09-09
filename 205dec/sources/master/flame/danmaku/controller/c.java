package master.flame.danmaku.controller;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.os.Handler;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.Choreographer;
import f3.a;
import java.util.LinkedList;
import master.flame.danmaku.controller.h;
import master.flame.danmaku.danmaku.model.android.DanmakuContext;
import master.flame.danmaku.danmaku.model.m;
import master.flame.danmaku.danmaku.model.n;
import tv.cjump.jni.DeviceUtils;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: DrawHandler.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class c extends Handler {
    public static final int C = 1;
    public static final int D = 2;
    public static final int E = 3;
    public static final int F = 4;
    public static final int G = 5;
    private static final int H = 6;
    private static final int I = 7;
    private static final int J = 8;
    private static final int K = 9;

    /* renamed from: L  reason: collision with root package name */
    private static final int f60928L = 10;
    private static final int M = 11;
    private static final int N = 12;
    private static final int O = 13;
    private static final long P = 10000000;
    private static final int Q = 500;
    private boolean A;
    private boolean B;

    /* renamed from: a  reason: collision with root package name */
    private DanmakuContext f60929a;

    /* renamed from: b  reason: collision with root package name */
    private e f60930b;

    /* renamed from: c  reason: collision with root package name */
    private long f60931c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f60932d;

    /* renamed from: e  reason: collision with root package name */
    private long f60933e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f60934f;

    /* renamed from: g  reason: collision with root package name */
    private d f60935g;

    /* renamed from: h  reason: collision with root package name */
    private master.flame.danmaku.danmaku.model.f f60936h;

    /* renamed from: i  reason: collision with root package name */
    private master.flame.danmaku.danmaku.parser.a f60937i;

    /* renamed from: j  reason: collision with root package name */
    public h f60938j;

    /* renamed from: k  reason: collision with root package name */
    private g f60939k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f60940l;

    /* renamed from: m  reason: collision with root package name */
    private master.flame.danmaku.danmaku.model.b f60941m;

    /* renamed from: n  reason: collision with root package name */
    private final a.c f60942n;

    /* renamed from: o  reason: collision with root package name */
    private LinkedList<Long> f60943o;

    /* renamed from: p  reason: collision with root package name */
    private i f60944p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f60945q;

    /* renamed from: r  reason: collision with root package name */
    private long f60946r;

    /* renamed from: s  reason: collision with root package name */
    private long f60947s;

    /* renamed from: t  reason: collision with root package name */
    private long f60948t;

    /* renamed from: u  reason: collision with root package name */
    private long f60949u;

    /* renamed from: v  reason: collision with root package name */
    private long f60950v;

    /* renamed from: w  reason: collision with root package name */
    private boolean f60951w;

    /* renamed from: x  reason: collision with root package name */
    private long f60952x;

    /* renamed from: y  reason: collision with root package name */
    private long f60953y;

    /* renamed from: z  reason: collision with root package name */
    private boolean f60954z;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: DrawHandler.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.f60931c = 0L;
            c.this.f60934f = true;
            if (c.this.f60935g != null) {
                c.this.f60935g.c();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: DrawHandler.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public class b extends i {
        b(String str) {
            super(str);
        }

        @Override // master.flame.danmaku.controller.i, java.lang.Thread, java.lang.Runnable
        public void run() {
            long b4 = g3.c.b();
            while (!a() && !c.this.f60932d) {
                long b5 = g3.c.b();
                if (c.this.f60948t - (g3.c.b() - b4) > 1) {
                    g3.c.a(1L);
                } else {
                    long a02 = c.this.a0(b5);
                    if (a02 < 0) {
                        g3.c.a(60 - a02);
                    } else {
                        long l4 = c.this.f60939k.l();
                        if (l4 > c.this.f60947s) {
                            c.this.f60936h.a(l4);
                            c.this.f60943o.clear();
                        }
                        if (!c.this.f60940l) {
                            c.this.f0(10000000L);
                        } else if (c.this.f60942n.f54695p && c.this.B) {
                            long j4 = c.this.f60942n.f54694o - c.this.f60936h.f61172a;
                            if (j4 > 500) {
                                c.this.K();
                                c.this.f0(j4 - 10);
                            }
                        }
                    }
                    b4 = b5;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: DrawHandler.java */
    /* renamed from: master.flame.danmaku.controller.c$c  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public class C1237c implements h.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Runnable f60957a;

        C1237c(Runnable runnable) {
            this.f60957a = runnable;
        }

        @Override // master.flame.danmaku.controller.h.a
        public void a(master.flame.danmaku.danmaku.model.d dVar) {
            if (c.this.f60935g != null) {
                c.this.f60935g.d(dVar);
            }
        }

        @Override // master.flame.danmaku.controller.h.a
        public void b(master.flame.danmaku.danmaku.model.d dVar) {
            if (dVar.w()) {
                return;
            }
            long b4 = dVar.b() - c.this.A();
            if (b4 < c.this.f60929a.D.f61100e && (c.this.A || c.this.f60942n.f54695p)) {
                c.this.K();
            } else if (b4 <= 0 || b4 > c.this.f60929a.D.f61100e) {
            } else {
                c.this.sendEmptyMessageDelayed(11, b4);
            }
        }

        @Override // master.flame.danmaku.controller.h.a
        public void c() {
            c.this.F();
            this.f60957a.run();
        }

        @Override // master.flame.danmaku.controller.h.a
        public void d() {
            if (c.this.f60935g != null) {
                c.this.f60935g.a();
            }
        }

        @Override // master.flame.danmaku.controller.h.a
        public void e() {
            c.this.R();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: DrawHandler.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public interface d {
        void a();

        void b(master.flame.danmaku.danmaku.model.f fVar);

        void c();

        void d(master.flame.danmaku.danmaku.model.d dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: DrawHandler.java */
    @TargetApi(16)
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public class e implements Choreographer.FrameCallback {
        private e() {
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long j4) {
            c.this.sendEmptyMessage(2);
        }

        /* synthetic */ e(c cVar, a aVar) {
            this();
        }
    }

    public c(Looper looper, g gVar, boolean z3) {
        super(looper);
        this.f60931c = 0L;
        this.f60932d = true;
        this.f60936h = new master.flame.danmaku.danmaku.model.f();
        this.f60940l = true;
        this.f60942n = new a.c();
        this.f60943o = new LinkedList<>();
        this.f60946r = 30L;
        this.f60947s = 60L;
        this.f60948t = 16L;
        this.B = true ^ DeviceUtils.g();
        u(gVar);
        if (z3) {
            Z(null);
        } else {
            E(false);
        }
        this.f60940l = z3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F() {
        long max = Math.max(33L, ((float) 16) * 2.5f);
        this.f60946r = max;
        this.f60947s = ((float) max) * 2.5f;
        long max2 = Math.max(16L, 15L);
        this.f60948t = max2;
        this.f60949u = max2 + 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K() {
        if (this.A) {
            h hVar = this.f60938j;
            if (hVar != null) {
                hVar.f();
            }
            if (this.f60945q) {
                synchronized (this) {
                    this.f60943o.clear();
                }
                synchronized (this.f60938j) {
                    this.f60938j.notifyAll();
                }
            } else {
                this.f60943o.clear();
                removeMessages(2);
                sendEmptyMessage(2);
            }
            this.A = false;
        }
    }

    private void N(Runnable runnable) {
        if (this.f60938j == null) {
            this.f60938j = w(this.f60939k.e(), this.f60936h, this.f60939k.getContext(), this.f60939k.getWidth(), this.f60939k.getHeight(), this.f60939k.isHardwareAccelerated(), new C1237c(runnable));
        } else {
            runnable.run();
        }
    }

    private void P() {
        i iVar = this.f60944p;
        if (iVar != null) {
            this.f60944p = null;
            synchronized (this.f60938j) {
                this.f60938j.notifyAll();
            }
            iVar.b();
            try {
                iVar.join();
            } catch (InterruptedException e4) {
                e4.printStackTrace();
            }
        }
    }

    private synchronized void Q() {
        this.f60943o.addLast(Long.valueOf(g3.c.b()));
        if (this.f60943o.size() > 500) {
            this.f60943o.removeFirst();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R() {
        if (this.f60932d && this.f60940l) {
            removeMessages(12);
            sendEmptyMessageDelayed(12, 100L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long a0(long j4) {
        long j5 = 0;
        if (!this.f60951w && !this.f60954z) {
            this.f60954z = true;
            long j6 = j4 - this.f60933e;
            if (this.f60940l && !this.f60942n.f54695p && !this.A) {
                long j7 = j6 - this.f60936h.f61172a;
                long max = Math.max(this.f60948t, y());
                if (j7 <= 2000) {
                    long j8 = this.f60942n.f54692m;
                    long j9 = this.f60946r;
                    if (j8 <= j9 && max <= j9) {
                        long j10 = this.f60948t;
                        long min = Math.min(this.f60946r, Math.max(j10, max + (j7 / j10)));
                        long j11 = this.f60950v;
                        long j12 = min - j11;
                        if (j12 > 3 && j12 < 8 && j11 >= this.f60948t && j11 <= this.f60946r) {
                            min = j11;
                        }
                        long j13 = j7 - min;
                        this.f60950v = min;
                        j7 = min;
                        j5 = j13;
                    }
                }
                this.f60953y = j5;
                this.f60936h.a(j7);
                j5 = j7;
            } else {
                this.f60936h.update(j6);
                this.f60953y = 0L;
            }
            d dVar = this.f60935g;
            if (dVar != null) {
                dVar.b(this.f60936h);
            }
            this.f60954z = false;
        }
        return j5;
    }

    private void b0() {
        if (this.A) {
            a0(g3.c.b());
        }
    }

    @TargetApi(16)
    private void c0() {
        if (this.f60932d) {
            return;
        }
        Choreographer.getInstance().postFrameCallback(this.f60930b);
        if (a0(g3.c.b()) < 0) {
            removeMessages(2);
            return;
        }
        long l4 = this.f60939k.l();
        removeMessages(2);
        if (l4 > this.f60947s) {
            this.f60936h.a(l4);
            this.f60943o.clear();
        }
        if (!this.f60940l) {
            f0(10000000L);
            return;
        }
        a.c cVar = this.f60942n;
        if (cVar.f54695p && this.B) {
            long j4 = cVar.f54694o - this.f60936h.f61172a;
            if (j4 > 500) {
                f0(j4 - 10);
            }
        }
    }

    private void d0() {
        if (this.f60932d) {
            return;
        }
        long a02 = a0(g3.c.b());
        if (a02 < 0) {
            removeMessages(2);
            sendEmptyMessageDelayed(2, 60 - a02);
            return;
        }
        long l4 = this.f60939k.l();
        removeMessages(2);
        if (l4 > this.f60947s) {
            this.f60936h.a(l4);
            this.f60943o.clear();
        }
        if (!this.f60940l) {
            f0(10000000L);
            return;
        }
        a.c cVar = this.f60942n;
        if (cVar.f54695p && this.B) {
            long j4 = cVar.f54694o - this.f60936h.f61172a;
            if (j4 > 500) {
                f0(j4 - 10);
                return;
            }
        }
        long j5 = this.f60948t;
        if (l4 < j5) {
            sendEmptyMessageDelayed(2, j5 - l4);
        } else {
            sendEmptyMessage(2);
        }
    }

    private void e0() {
        if (this.f60944p != null) {
            return;
        }
        b bVar = new b("DFM Update");
        this.f60944p = bVar;
        bVar.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f0(long j4) {
        if (I() || !H() || this.f60951w) {
            return;
        }
        this.f60942n.f54696q = g3.c.b();
        this.A = true;
        if (!this.f60945q) {
            if (j4 == 10000000) {
                removeMessages(11);
                removeMessages(2);
                return;
            }
            removeMessages(11);
            removeMessages(2);
            sendEmptyMessageDelayed(11, j4);
        } else if (this.f60944p == null) {
        } else {
            try {
                synchronized (this.f60938j) {
                    if (j4 == 10000000) {
                        this.f60938j.wait();
                    } else {
                        this.f60938j.wait(j4);
                    }
                    sendEmptyMessage(11);
                }
            } catch (InterruptedException e4) {
                e4.printStackTrace();
            }
        }
    }

    private void u(g gVar) {
        this.f60939k = gVar;
    }

    private h w(boolean z3, master.flame.danmaku.danmaku.model.f fVar, Context context, int i4, int i5, boolean z4, h.a aVar) {
        master.flame.danmaku.danmaku.model.b g4 = this.f60929a.g();
        this.f60941m = g4;
        g4.h(i4, i5);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        this.f60941m.d(displayMetrics.density, displayMetrics.densityDpi, displayMetrics.scaledDensity);
        this.f60941m.a(this.f60929a.f61008c);
        this.f60941m.q(z4);
        h aVar2 = z3 ? new master.flame.danmaku.controller.a(fVar, this.f60929a, aVar) : new master.flame.danmaku.controller.e(fVar, this.f60929a, aVar);
        aVar2.g(this.f60937i);
        aVar2.prepare();
        obtainMessage(10, Boolean.FALSE).sendToTarget();
        return aVar2;
    }

    private synchronized long y() {
        int size = this.f60943o.size();
        if (size <= 0) {
            return 0L;
        }
        Long peekFirst = this.f60943o.peekFirst();
        Long peekLast = this.f60943o.peekLast();
        if (peekFirst != null && peekLast != null) {
            return (peekLast.longValue() - peekFirst.longValue()) / size;
        }
        return 0L;
    }

    public long A() {
        long j4;
        long j5;
        if (this.f60934f) {
            if (this.f60951w) {
                return this.f60952x;
            }
            if (!this.f60932d && this.A) {
                j4 = g3.c.b();
                j5 = this.f60933e;
            } else {
                j4 = this.f60936h.f61172a;
                j5 = this.f60953y;
            }
            return j4 - j5;
        }
        return 0L;
    }

    public m B() {
        h hVar = this.f60938j;
        if (hVar != null) {
            return hVar.e(A());
        }
        return null;
    }

    public n C() {
        return this.f60941m;
    }

    public boolean D() {
        return this.f60940l;
    }

    public long E(boolean z3) {
        if (!this.f60940l) {
            return this.f60936h.f61172a;
        }
        this.f60940l = false;
        removeMessages(8);
        removeMessages(9);
        obtainMessage(9, Boolean.valueOf(z3)).sendToTarget();
        return this.f60936h.f61172a;
    }

    public void G(master.flame.danmaku.danmaku.model.d dVar, boolean z3) {
        h hVar = this.f60938j;
        if (hVar != null && dVar != null) {
            hVar.b(dVar, z3);
        }
        R();
    }

    public boolean H() {
        return this.f60934f;
    }

    public boolean I() {
        return this.f60932d;
    }

    public void J(int i4, int i5) {
        master.flame.danmaku.danmaku.model.b bVar = this.f60941m;
        if (bVar == null) {
            return;
        }
        if (bVar.getWidth() == i4 && this.f60941m.getHeight() == i5) {
            return;
        }
        this.f60941m.h(i4, i5);
        obtainMessage(10, Boolean.TRUE).sendToTarget();
    }

    public void L() {
        removeMessages(3);
        b0();
        sendEmptyMessage(7);
    }

    public void M() {
        this.f60934f = false;
        if (this.f60929a.F == 0) {
            this.f60930b = new e(this, null);
        }
        this.f60945q = this.f60929a.F == 1;
        sendEmptyMessage(5);
    }

    public void O() {
        this.f60932d = true;
        sendEmptyMessage(6);
    }

    public void S(boolean z3) {
        h hVar = this.f60938j;
        if (hVar != null) {
            hVar.c(z3);
        }
    }

    public void T() {
        h hVar = this.f60938j;
        if (hVar != null) {
            hVar.d();
        }
    }

    public void U() {
        removeMessages(7);
        sendEmptyMessage(3);
    }

    public void V(Long l4) {
        this.f60951w = true;
        this.f60952x = l4.longValue();
        removeMessages(2);
        removeMessages(3);
        removeMessages(4);
        obtainMessage(4, l4).sendToTarget();
    }

    public void W(d dVar) {
        this.f60935g = dVar;
    }

    public void X(DanmakuContext danmakuContext) {
        this.f60929a = danmakuContext;
    }

    public void Y(master.flame.danmaku.danmaku.parser.a aVar) {
        this.f60937i = aVar;
    }

    public void Z(Long l4) {
        if (this.f60940l) {
            return;
        }
        this.f60940l = true;
        removeMessages(8);
        removeMessages(9);
        obtainMessage(8, l4).sendToTarget();
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
        throw new UnsupportedOperationException("Method not decompiled: master.flame.danmaku.controller.c.handleMessage(android.os.Message):void");
    }

    public void t(master.flame.danmaku.danmaku.model.d dVar) {
        if (this.f60938j != null) {
            dVar.I = this.f60929a.B;
            dVar.F(this.f60936h);
            this.f60938j.a(dVar);
            obtainMessage(11).sendToTarget();
        }
    }

    public void v() {
        obtainMessage(13).sendToTarget();
    }

    public a.c x(Canvas canvas) {
        master.flame.danmaku.danmaku.model.a aVar;
        boolean d4;
        if (this.f60938j == null) {
            return this.f60942n;
        }
        if (!this.A && (aVar = this.f60929a.f61020o) != null && ((d4 = aVar.d()) || !this.f60932d)) {
            int a4 = aVar.a();
            if (a4 == 2) {
                long j4 = this.f60936h.f61172a;
                long c4 = aVar.c();
                long j5 = c4 - j4;
                if (Math.abs(j5) > aVar.b()) {
                    if (d4 && this.f60932d) {
                        U();
                    }
                    this.f60938j.m(j4, c4, j5);
                    this.f60936h.update(c4);
                    this.f60933e -= j5;
                    this.f60953y = 0L;
                }
            } else if (a4 == 1 && d4 && !this.f60932d) {
                L();
            }
        }
        this.f60941m.z(canvas);
        this.f60942n.f(this.f60938j.j(this.f60941m));
        Q();
        return this.f60942n;
    }

    public DanmakuContext z() {
        return this.f60929a;
    }
}

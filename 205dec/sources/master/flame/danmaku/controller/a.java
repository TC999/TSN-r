package master.flame.danmaku.controller;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import f3.a;
import master.flame.danmaku.controller.h;
import master.flame.danmaku.danmaku.model.android.DanmakuContext;
import master.flame.danmaku.danmaku.model.k;
import master.flame.danmaku.danmaku.model.m;
import master.flame.danmaku.danmaku.model.o;
import tv.cjump.jni.NativeBitmapFactory;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: CacheManagingDrawTask.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class a extends e {
    private static final int C = 3;
    static final /* synthetic */ boolean D = false;
    private final Object A;
    private int B;

    /* renamed from: x  reason: collision with root package name */
    private int f60832x;

    /* renamed from: y  reason: collision with root package name */
    private b f60833y;

    /* renamed from: z  reason: collision with root package name */
    private master.flame.danmaku.danmaku.model.f f60834z;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: CacheManagingDrawTask.java */
    /* renamed from: master.flame.danmaku.controller.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    class RunnableC1231a implements Runnable {
        RunnableC1231a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.f60970g.e();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: CacheManagingDrawTask.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public class b implements k {

        /* renamed from: k  reason: collision with root package name */
        private static final String f60836k = "CacheManager";

        /* renamed from: l  reason: collision with root package name */
        public static final byte f60837l = 0;

        /* renamed from: m  reason: collision with root package name */
        public static final byte f60838m = 1;

        /* renamed from: n  reason: collision with root package name */
        public static final byte f60839n = 2;

        /* renamed from: a  reason: collision with root package name */
        public HandlerThread f60840a;

        /* renamed from: b  reason: collision with root package name */
        master.flame.danmaku.danmaku.model.android.e f60841b = new master.flame.danmaku.danmaku.model.android.e();

        /* renamed from: c  reason: collision with root package name */
        master.flame.danmaku.danmaku.model.android.h f60842c;

        /* renamed from: d  reason: collision with root package name */
        master.flame.danmaku.danmaku.model.objectpool.b<master.flame.danmaku.danmaku.model.android.f> f60843d;

        /* renamed from: e  reason: collision with root package name */
        private int f60844e;

        /* renamed from: f  reason: collision with root package name */
        private int f60845f;

        /* renamed from: g  reason: collision with root package name */
        private int f60846g;

        /* renamed from: h  reason: collision with root package name */
        private e f60847h;

        /* renamed from: i  reason: collision with root package name */
        private boolean f60848i;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
        /* compiled from: CacheManagingDrawTask.java */
        /* renamed from: master.flame.danmaku.controller.a$b$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public class C1232a extends m.c<master.flame.danmaku.danmaku.model.d> {
            C1232a() {
            }

            @Override // master.flame.danmaku.danmaku.model.m.b
            /* renamed from: e */
            public int a(master.flame.danmaku.danmaku.model.d dVar) {
                b.this.s(true, dVar, null);
                return 0;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
        /* compiled from: CacheManagingDrawTask.java */
        /* renamed from: master.flame.danmaku.controller.a$b$b  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public class C1233b extends m.c<master.flame.danmaku.danmaku.model.d> {
            C1233b() {
            }

            @Override // master.flame.danmaku.danmaku.model.m.b
            /* renamed from: e */
            public int a(master.flame.danmaku.danmaku.model.d dVar) {
                if (dVar.s()) {
                    b.this.s(true, dVar, null);
                    return 2;
                }
                return 0;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
        /* compiled from: CacheManagingDrawTask.java */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public class c extends m.c<master.flame.danmaku.danmaku.model.d> {
            c() {
            }

            @Override // master.flame.danmaku.danmaku.model.m.b
            /* renamed from: e */
            public int a(master.flame.danmaku.danmaku.model.d dVar) {
                if (dVar.w()) {
                    o<?> oVar = dVar.f61170y;
                    if (a.this.f60966c.E.f61083c != -1 || oVar == null || oVar.hasReferences() || oVar.size() / a.this.f60832x >= a.this.f60966c.E.f61084d) {
                        synchronized (a.this.A) {
                            try {
                                a.this.A.wait(30L);
                            } catch (InterruptedException e4) {
                                e4.printStackTrace();
                                return 1;
                            }
                        }
                        b.this.s(false, dVar, null);
                        return 2;
                    }
                    return 0;
                }
                return 1;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
        /* compiled from: CacheManagingDrawTask.java */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public class d extends m.b<master.flame.danmaku.danmaku.model.d, master.flame.danmaku.danmaku.model.d> {

            /* renamed from: e  reason: collision with root package name */
            int f60853e = 0;

            /* renamed from: f  reason: collision with root package name */
            master.flame.danmaku.danmaku.model.d f60854f;

            /* renamed from: g  reason: collision with root package name */
            final /* synthetic */ int f60855g;

            /* renamed from: h  reason: collision with root package name */
            final /* synthetic */ master.flame.danmaku.danmaku.model.d f60856h;

            /* renamed from: i  reason: collision with root package name */
            final /* synthetic */ boolean f60857i;

            /* renamed from: j  reason: collision with root package name */
            final /* synthetic */ int f60858j;

            d(int i4, master.flame.danmaku.danmaku.model.d dVar, boolean z3, int i5) {
                this.f60855g = i4;
                this.f60856h = dVar;
                this.f60857i = z3;
                this.f60858j = i5;
            }

            @Override // master.flame.danmaku.danmaku.model.m.b
            /* renamed from: e */
            public int a(master.flame.danmaku.danmaku.model.d dVar) {
                int i4 = this.f60853e;
                this.f60853e = i4 + 1;
                if (i4 >= this.f60855g) {
                    return 1;
                }
                o<?> e4 = dVar.e();
                if (e4 != null && e4.get() != null) {
                    float f4 = dVar.f61161p;
                    master.flame.danmaku.danmaku.model.d dVar2 = this.f60856h;
                    if (f4 == dVar2.f61161p && dVar.f61162q == dVar2.f61162q && dVar.f61156k == dVar2.f61156k && dVar.f61158m == dVar2.f61158m && dVar.f61152g == dVar2.f61152g && dVar.f61148c.equals(dVar2.f61148c) && dVar.f61151f == this.f60856h.f61151f) {
                        this.f60854f = dVar;
                        return 1;
                    } else if (this.f60857i) {
                        return 0;
                    } else {
                        if (!dVar.w()) {
                            return 1;
                        }
                        if (e4.hasReferences()) {
                            return 0;
                        }
                        float g4 = e4.g() - this.f60856h.f61161p;
                        float b4 = e4.b() - this.f60856h.f61162q;
                        if (g4 >= 0.0f) {
                            int i5 = this.f60858j;
                            if (g4 <= i5 && b4 >= 0.0f && b4 <= i5) {
                                this.f60854f = dVar;
                                return 1;
                            }
                        }
                    }
                }
                return 0;
            }

            @Override // master.flame.danmaku.danmaku.model.m.b
            /* renamed from: f */
            public master.flame.danmaku.danmaku.model.d d() {
                return this.f60854f;
            }
        }

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
        /* compiled from: CacheManagingDrawTask.java */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public class e extends Handler {

            /* renamed from: f  reason: collision with root package name */
            private static final int f60860f = 1;

            /* renamed from: g  reason: collision with root package name */
            public static final int f60861g = 2;

            /* renamed from: h  reason: collision with root package name */
            public static final int f60862h = 3;

            /* renamed from: i  reason: collision with root package name */
            public static final int f60863i = 4;

            /* renamed from: j  reason: collision with root package name */
            public static final int f60864j = 5;

            /* renamed from: k  reason: collision with root package name */
            public static final int f60865k = 6;

            /* renamed from: l  reason: collision with root package name */
            public static final int f60866l = 7;

            /* renamed from: m  reason: collision with root package name */
            public static final int f60867m = 8;

            /* renamed from: n  reason: collision with root package name */
            public static final int f60868n = 9;

            /* renamed from: o  reason: collision with root package name */
            public static final int f60869o = 16;

            /* renamed from: p  reason: collision with root package name */
            public static final int f60870p = 17;

            /* renamed from: q  reason: collision with root package name */
            public static final int f60871q = 18;

            /* renamed from: a  reason: collision with root package name */
            private boolean f60872a;

            /* renamed from: b  reason: collision with root package name */
            private boolean f60873b;

            /* renamed from: c  reason: collision with root package name */
            private boolean f60874c;

            /* renamed from: d  reason: collision with root package name */
            private boolean f60875d;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
            /* compiled from: CacheManagingDrawTask.java */
            /* renamed from: master.flame.danmaku.controller.a$b$e$a  reason: collision with other inner class name */
            /* loaded from: E:\TSN-r\205dec\7343912.dex */
            public class C1234a extends m.c<master.flame.danmaku.danmaku.model.d> {
                C1234a() {
                }

                @Override // master.flame.danmaku.danmaku.model.m.b
                /* renamed from: e */
                public int a(master.flame.danmaku.danmaku.model.d dVar) {
                    if (e.this.f60872a || e.this.f60875d) {
                        return 1;
                    }
                    if (!dVar.m()) {
                        DanmakuContext danmakuContext = a.this.f60966c;
                        danmakuContext.C.b(dVar, 0, 0, null, true, danmakuContext);
                    }
                    if (dVar.n()) {
                        return 0;
                    }
                    if (!dVar.q()) {
                        dVar.z(a.this.f60967d, true);
                    }
                    if (!dVar.u()) {
                        dVar.A(a.this.f60967d, true);
                    }
                    return 0;
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
            /* compiled from: CacheManagingDrawTask.java */
            /* renamed from: master.flame.danmaku.controller.a$b$e$b  reason: collision with other inner class name */
            /* loaded from: E:\TSN-r\205dec\7343912.dex */
            public class C1235b extends m.c<master.flame.danmaku.danmaku.model.d> {

                /* renamed from: e  reason: collision with root package name */
                int f60878e = 0;

                /* renamed from: f  reason: collision with root package name */
                int f60879f = 0;

                /* renamed from: g  reason: collision with root package name */
                final /* synthetic */ master.flame.danmaku.danmaku.model.d f60880g;

                /* renamed from: h  reason: collision with root package name */
                final /* synthetic */ boolean f60881h;

                /* renamed from: i  reason: collision with root package name */
                final /* synthetic */ int f60882i;

                /* renamed from: j  reason: collision with root package name */
                final /* synthetic */ long f60883j;

                /* renamed from: k  reason: collision with root package name */
                final /* synthetic */ long f60884k;

                /* renamed from: l  reason: collision with root package name */
                final /* synthetic */ long f60885l;

                C1235b(master.flame.danmaku.danmaku.model.d dVar, boolean z3, int i4, long j4, long j5, long j6) {
                    this.f60880g = dVar;
                    this.f60881h = z3;
                    this.f60882i = i4;
                    this.f60883j = j4;
                    this.f60884k = j5;
                    this.f60885l = j6;
                }

                @Override // master.flame.danmaku.danmaku.model.m.b
                /* renamed from: e */
                public int a(master.flame.danmaku.danmaku.model.d dVar) {
                    b bVar;
                    if (e.this.f60872a || e.this.f60875d || this.f60880g.b() < a.this.f60972i.f61172a) {
                        return 1;
                    }
                    o<?> e4 = dVar.e();
                    if (e4 == null || e4.get() == null) {
                        if (this.f60881h || (!dVar.w() && dVar.s())) {
                            if (!dVar.m()) {
                                DanmakuContext danmakuContext = a.this.f60966c;
                                danmakuContext.C.b(dVar, this.f60878e, this.f60882i, null, true, danmakuContext);
                            }
                            if (dVar.f61160o == 0 && dVar.n()) {
                                return 0;
                            }
                            if (dVar.getType() == 1) {
                                int b4 = (int) ((dVar.b() - this.f60883j) / a.this.f60966c.D.f61100e);
                                if (this.f60879f == b4) {
                                    this.f60878e++;
                                } else {
                                    this.f60878e = 0;
                                    this.f60879f = b4;
                                }
                            }
                            if (!this.f60881h && !e.this.f60873b) {
                                try {
                                    synchronized (a.this.A) {
                                        a.this.A.wait(this.f60884k);
                                    }
                                } catch (InterruptedException e5) {
                                    e5.printStackTrace();
                                    return 1;
                                }
                            }
                            e.this.g(dVar, false);
                            if (!this.f60881h) {
                                master.flame.danmaku.danmaku.model.android.d dVar2 = a.this.f60966c.D;
                                if (g3.c.b() - this.f60885l >= bVar.f60846g * 3800) {
                                    return 1;
                                }
                            }
                            return 0;
                        }
                        return 0;
                    }
                    return 0;
                }
            }

            public e(Looper looper) {
                super(looper);
            }

            private final void e(master.flame.danmaku.danmaku.model.d dVar) {
                if (dVar.w()) {
                    return;
                }
                if (dVar.b() <= a.this.f60834z.f61172a + a.this.f60966c.D.f61100e || dVar.f61171z) {
                    if (dVar.f61160o == 0 && dVar.n()) {
                        return;
                    }
                    o<?> e4 = dVar.e();
                    if (e4 == null || e4.get() == null) {
                        g(dVar, true);
                    }
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public byte g(master.flame.danmaku.danmaku.model.d dVar, boolean z3) {
                if (!dVar.q()) {
                    dVar.z(a.this.f60967d, true);
                }
                master.flame.danmaku.danmaku.model.android.f fVar = null;
                try {
                    b bVar = b.this;
                    master.flame.danmaku.danmaku.model.d v3 = bVar.v(dVar, true, a.this.f60966c.E.f61086f);
                    master.flame.danmaku.danmaku.model.android.f fVar2 = v3 != null ? (master.flame.danmaku.danmaku.model.android.f) v3.f61170y : null;
                    try {
                        if (fVar2 != null) {
                            fVar2.j();
                            dVar.f61170y = fVar2;
                            a.this.f60833y.C(dVar, 0, z3);
                            return (byte) 0;
                        }
                        b bVar2 = b.this;
                        master.flame.danmaku.danmaku.model.d v4 = bVar2.v(dVar, false, a.this.f60966c.E.f61087g);
                        if (v4 != null) {
                            fVar2 = (master.flame.danmaku.danmaku.model.android.f) v4.f61170y;
                        }
                        if (fVar2 != null) {
                            v4.f61170y = null;
                            a aVar = a.this;
                            dVar.f61170y = g3.a.a(dVar, aVar.f60967d, fVar2, aVar.f60966c.E.f61081a);
                            a.this.f60833y.C(dVar, 0, z3);
                            return (byte) 0;
                        }
                        int f4 = g3.a.f((int) dVar.f61161p, (int) dVar.f61162q, a.this.f60966c.E.f61081a / 8);
                        if (f4 * 2 > a.this.f60832x) {
                            return (byte) 1;
                        }
                        if (!z3 && b.this.f60845f + f4 > b.this.f60844e) {
                            a.this.f60833y.p(f4, false);
                            return (byte) 1;
                        }
                        master.flame.danmaku.danmaku.model.android.f acquire = b.this.f60843d.acquire();
                        a aVar2 = a.this;
                        master.flame.danmaku.danmaku.model.android.f a4 = g3.a.a(dVar, aVar2.f60967d, acquire, aVar2.f60966c.E.f61081a);
                        dVar.f61170y = a4;
                        boolean C = a.this.f60833y.C(dVar, b.this.J(dVar), z3);
                        if (!C) {
                            o(dVar, a4);
                        }
                        return (!C ? 1 : 0) == 1 ? (byte) 1 : (byte) 0;
                    } catch (Exception unused) {
                        fVar = fVar2;
                        o(dVar, fVar);
                        return (byte) 1;
                    } catch (OutOfMemoryError unused2) {
                        fVar = fVar2;
                        o(dVar, fVar);
                        return (byte) 1;
                    }
                } catch (Exception unused3) {
                } catch (OutOfMemoryError unused4) {
                }
            }

            private long i() {
                long j4 = a.this.f60834z.f61172a;
                b bVar = b.this;
                a aVar = a.this;
                long j5 = aVar.f60972i.f61172a;
                DanmakuContext danmakuContext = aVar.f60966c;
                if (j4 <= j5 - danmakuContext.D.f61100e) {
                    if (danmakuContext.E.f61083c != -1) {
                        bVar.u();
                    }
                    a.this.f60834z.update(a.this.f60972i.f61172a);
                    sendEmptyMessage(3);
                    return 0L;
                }
                float x3 = bVar.x();
                master.flame.danmaku.danmaku.model.d first = b.this.f60841b.first();
                long b4 = first != null ? first.b() - a.this.f60972i.f61172a : 0L;
                a aVar2 = a.this;
                long j6 = aVar2.f60966c.D.f61100e;
                long j7 = 2 * j6;
                if (x3 < 0.6f && b4 > j6) {
                    aVar2.f60834z.update(a.this.f60972i.f61172a);
                    removeMessages(3);
                    sendEmptyMessage(3);
                    return 0L;
                } else if (x3 > 0.4f && b4 < (-j7)) {
                    removeMessages(4);
                    sendEmptyMessage(4);
                    return 0L;
                } else if (x3 >= 0.9f) {
                    return 0L;
                } else {
                    long j8 = aVar2.f60834z.f61172a - a.this.f60972i.f61172a;
                    if (first != null && first.w()) {
                        a aVar3 = a.this;
                        if (j8 < (-aVar3.f60966c.D.f61100e)) {
                            aVar3.f60834z.update(a.this.f60972i.f61172a);
                            sendEmptyMessage(8);
                            sendEmptyMessage(3);
                            return 0L;
                        }
                    }
                    if (j8 > j7) {
                        return 0L;
                    }
                    removeMessages(3);
                    sendEmptyMessage(3);
                    return 0L;
                }
            }

            private void m() {
                m mVar;
                try {
                    a aVar = a.this;
                    long j4 = aVar.f60972i.f61172a;
                    long j5 = aVar.f60966c.D.f61100e;
                    mVar = aVar.f60968e.d(j4 - j5, (2 * j5) + j4);
                } catch (Exception unused) {
                    mVar = null;
                }
                if (mVar == null || mVar.isEmpty()) {
                    return;
                }
                mVar.h(new C1234a());
            }

            /* JADX WARN: Code restructure failed: missing block: B:17:0x0069, code lost:
                r19.f60876e.f60849j.f60834z.update(r12);
             */
            /* JADX WARN: Code restructure failed: missing block: B:18:0x0074, code lost:
                return 0;
             */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            private long n(boolean r20) {
                /*
                    Method dump skipped, instructions count: 229
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: master.flame.danmaku.controller.a.b.e.n(boolean):long");
            }

            private void o(master.flame.danmaku.danmaku.model.d dVar, master.flame.danmaku.danmaku.model.android.f fVar) {
                if (fVar == null) {
                    fVar = (master.flame.danmaku.danmaku.model.android.f) dVar.f61170y;
                }
                dVar.f61170y = null;
                if (fVar == null) {
                    return;
                }
                fVar.destroy();
                b.this.f60843d.a(fVar);
            }

            public void f() {
                sendEmptyMessage(1);
                sendEmptyMessageDelayed(4, a.this.f60966c.D.f61100e);
            }

            public boolean h(master.flame.danmaku.danmaku.model.d dVar) {
                master.flame.danmaku.danmaku.model.android.f fVar;
                master.flame.danmaku.danmaku.model.android.f acquire;
                if (!dVar.q()) {
                    dVar.z(a.this.f60967d, true);
                }
                try {
                    acquire = b.this.f60843d.acquire();
                } catch (Exception unused) {
                    fVar = null;
                } catch (OutOfMemoryError unused2) {
                    fVar = null;
                }
                try {
                    a aVar = a.this;
                    fVar = g3.a.a(dVar, aVar.f60967d, acquire, aVar.f60966c.E.f61081a);
                    dVar.f61170y = fVar;
                    return true;
                } catch (Exception unused3) {
                    if (fVar != null) {
                        b.this.f60843d.a(fVar);
                    }
                    dVar.f61170y = null;
                    return false;
                } catch (OutOfMemoryError unused4) {
                    if (fVar != null) {
                        b.this.f60843d.a(fVar);
                    }
                    dVar.f61170y = null;
                    return false;
                }
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                int i4 = message.what;
                switch (i4) {
                    case 1:
                        b.this.u();
                        for (int i5 = 0; i5 < 300; i5++) {
                            b.this.f60843d.a(new master.flame.danmaku.danmaku.model.android.f());
                        }
                        break;
                    case 2:
                        e((master.flame.danmaku.danmaku.model.d) message.obj);
                        return;
                    case 3:
                        removeMessages(3);
                        a aVar = a.this;
                        boolean z3 = !(aVar.f60970g == null || aVar.f60977n) || this.f60874c;
                        n(z3);
                        if (z3) {
                            this.f60874c = false;
                        }
                        a aVar2 = a.this;
                        h.a aVar3 = aVar2.f60970g;
                        if (aVar3 == null || aVar2.f60977n) {
                            return;
                        }
                        aVar3.c();
                        a.this.f60977n = true;
                        return;
                    case 4:
                        b.this.q();
                        return;
                    case 5:
                        Long l4 = (Long) message.obj;
                        if (l4 != null) {
                            long longValue = l4.longValue();
                            long j4 = a.this.f60834z.f61172a;
                            a.this.f60834z.update(longValue);
                            this.f60874c = true;
                            long w3 = b.this.w();
                            if (longValue <= j4) {
                                b bVar = b.this;
                                if (w3 - longValue <= a.this.f60966c.D.f61100e) {
                                    bVar.q();
                                    n(true);
                                    r();
                                    return;
                                }
                            }
                            b.this.u();
                            n(true);
                            r();
                            return;
                        }
                        return;
                    case 6:
                        removeCallbacksAndMessages(null);
                        this.f60872a = true;
                        b.this.t();
                        b.this.o();
                        getLooper().quit();
                        return;
                    case 7:
                        b.this.t();
                        master.flame.danmaku.danmaku.model.f fVar = a.this.f60834z;
                        a aVar4 = a.this;
                        fVar.update(aVar4.f60972i.f61172a - aVar4.f60966c.D.f61100e);
                        this.f60874c = true;
                        return;
                    case 8:
                        b.this.u();
                        a.this.f60834z.update(a.this.f60972i.f61172a);
                        return;
                    case 9:
                        b.this.u();
                        a.this.f60834z.update(a.this.f60972i.f61172a);
                        a.this.f();
                        return;
                    default:
                        switch (i4) {
                            case 16:
                                break;
                            case 17:
                                master.flame.danmaku.danmaku.model.d dVar = (master.flame.danmaku.danmaku.model.d) message.obj;
                                if (dVar != null) {
                                    o<?> e4 = dVar.e();
                                    if (!((dVar.J & 1) != 0) && e4 != null && e4.get() != null && !e4.hasReferences()) {
                                        a aVar5 = a.this;
                                        dVar.f61170y = g3.a.a(dVar, aVar5.f60967d, (master.flame.danmaku.danmaku.model.android.f) dVar.f61170y, aVar5.f60966c.E.f61081a);
                                        b.this.C(dVar, 0, true);
                                        return;
                                    } else if (dVar.f61171z) {
                                        b.this.n(dVar);
                                        h(dVar);
                                        return;
                                    } else {
                                        if (e4 != null && e4.hasReferences()) {
                                            e4.destroy();
                                        }
                                        b.this.s(true, dVar, null);
                                        e(dVar);
                                        return;
                                    }
                                }
                                return;
                            case 18:
                                this.f60875d = false;
                                return;
                            default:
                                return;
                        }
                }
                long i6 = i();
                if (i6 <= 0) {
                    i6 = a.this.f60966c.D.f61100e / 2;
                }
                sendEmptyMessageDelayed(16, i6);
            }

            public boolean j() {
                return this.f60872a;
            }

            public void k(boolean z3) {
                this.f60873b = !z3;
            }

            public void l() {
                this.f60872a = true;
                removeCallbacksAndMessages(null);
                sendEmptyMessage(6);
            }

            public void p(long j4) {
                removeMessages(3);
                this.f60874c = true;
                sendEmptyMessage(18);
                a.this.f60834z.update(a.this.f60972i.f61172a + j4);
                sendEmptyMessage(3);
            }

            public void q() {
                this.f60875d = true;
            }

            public void r() {
                sendEmptyMessage(18);
                this.f60872a = false;
                removeMessages(16);
                sendEmptyMessage(16);
                sendEmptyMessageDelayed(4, a.this.f60966c.D.f61100e);
            }
        }

        public b(int i4, int i5) {
            master.flame.danmaku.danmaku.model.android.h hVar = new master.flame.danmaku.danmaku.model.android.h();
            this.f60842c = hVar;
            this.f60843d = master.flame.danmaku.danmaku.model.objectpool.e.a(hVar, 800);
            this.f60848i = false;
            this.f60845f = 0;
            this.f60844e = i4;
            this.f60846g = i5;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean C(master.flame.danmaku.danmaku.model.d dVar, int i4, boolean z3) {
            if (i4 > 0) {
                p(i4, z3);
            }
            this.f60841b.i(dVar);
            this.f60845f += i4;
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public long n(master.flame.danmaku.danmaku.model.d dVar) {
            o<?> oVar = dVar.f61170y;
            if (oVar == null) {
                return 0L;
            }
            if (oVar.hasReferences()) {
                oVar.e();
                dVar.f61170y = null;
                return 0L;
            }
            long J = J(dVar);
            oVar.destroy();
            dVar.f61170y = null;
            return J;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void o() {
            while (true) {
                master.flame.danmaku.danmaku.model.android.f acquire = this.f60843d.acquire();
                if (acquire == null) {
                    return;
                }
                acquire.destroy();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void p(int i4, boolean z3) {
            master.flame.danmaku.danmaku.model.d first = this.f60841b.first();
            while (this.f60845f + i4 > this.f60844e && first != null) {
                if (first.w() || first.n()) {
                    s(false, first, null);
                    this.f60841b.g(first);
                    first = this.f60841b.first();
                } else if (z3) {
                    return;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void q() {
            this.f60841b.h(new c());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void t() {
            master.flame.danmaku.danmaku.model.android.e eVar = this.f60841b;
            if (eVar != null) {
                eVar.h(new C1232a());
                this.f60841b.clear();
            }
            this.f60845f = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void u() {
            master.flame.danmaku.danmaku.model.android.e eVar = this.f60841b;
            if (eVar != null) {
                eVar.h(new C1233b());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public master.flame.danmaku.danmaku.model.d v(master.flame.danmaku.danmaku.model.d dVar, boolean z3, int i4) {
            d dVar2 = new d(i4, dVar, z3, (!z3 ? a.this.f60967d.b() * 2 : 0) + a.this.f60966c.E.f61085e);
            this.f60841b.h(dVar2);
            return dVar2.d();
        }

        public void A(int i4) {
            e eVar = this.f60847h;
            if (eVar != null) {
                eVar.k(i4 == 1);
            }
        }

        public void B(Runnable runnable) {
            e eVar = this.f60847h;
            if (eVar == null) {
                return;
            }
            eVar.post(runnable);
        }

        public void D(long j4) {
            e eVar = this.f60847h;
            if (eVar != null) {
                eVar.p(j4);
            }
        }

        public void E() {
            e eVar = this.f60847h;
            if (eVar == null) {
                return;
            }
            eVar.removeMessages(3);
            this.f60847h.removeMessages(18);
            this.f60847h.q();
            this.f60847h.removeMessages(7);
            this.f60847h.sendEmptyMessage(7);
        }

        public void F() {
            e eVar = this.f60847h;
            if (eVar == null) {
                return;
            }
            eVar.removeMessages(4);
            this.f60847h.sendEmptyMessage(4);
        }

        public void G() {
            e eVar = this.f60847h;
            if (eVar == null) {
                return;
            }
            eVar.removeMessages(9);
            this.f60847h.sendEmptyMessage(9);
        }

        public void H() {
            e eVar = this.f60847h;
            if (eVar != null) {
                eVar.r();
            } else {
                m();
            }
        }

        public void I(long j4) {
            e eVar = this.f60847h;
            if (eVar == null) {
                return;
            }
            eVar.q();
            this.f60847h.removeMessages(3);
            this.f60847h.obtainMessage(5, Long.valueOf(j4)).sendToTarget();
        }

        protected int J(master.flame.danmaku.danmaku.model.d dVar) {
            o<?> oVar = dVar.f61170y;
            if (oVar == null || oVar.hasReferences()) {
                return 0;
            }
            return dVar.f61170y.size();
        }

        @Override // master.flame.danmaku.danmaku.model.k
        public void a(master.flame.danmaku.danmaku.model.d dVar) {
            e eVar = this.f60847h;
            if (eVar != null) {
                if (dVar.f61171z && dVar.A) {
                    if (dVar.w()) {
                        return;
                    }
                    this.f60847h.h(dVar);
                    return;
                }
                eVar.obtainMessage(2, dVar).sendToTarget();
            }
        }

        public void m() {
            this.f60848i = false;
            if (this.f60840a == null) {
                HandlerThread handlerThread = new HandlerThread("DFM Cache-Building Thread");
                this.f60840a = handlerThread;
                handlerThread.start();
            }
            if (this.f60847h == null) {
                this.f60847h = new e(this.f60840a.getLooper());
            }
            this.f60847h.f();
        }

        public void r() {
            this.f60848i = true;
            synchronized (a.this.A) {
                a.this.A.notifyAll();
            }
            e eVar = this.f60847h;
            if (eVar != null) {
                eVar.l();
                this.f60847h = null;
            }
            HandlerThread handlerThread = this.f60840a;
            if (handlerThread != null) {
                try {
                    handlerThread.join();
                } catch (InterruptedException e4) {
                    e4.printStackTrace();
                }
                this.f60840a.quit();
                this.f60840a = null;
            }
        }

        protected void s(boolean z3, master.flame.danmaku.danmaku.model.d dVar, master.flame.danmaku.danmaku.model.d dVar2) {
            o<?> e4 = dVar.e();
            if (e4 != null) {
                long n4 = n(dVar);
                if (dVar.w()) {
                    a.this.f60966c.g().w().g(dVar);
                }
                if (n4 <= 0) {
                    return;
                }
                this.f60845f = (int) (this.f60845f - n4);
                this.f60843d.a((master.flame.danmaku.danmaku.model.android.f) e4);
            }
        }

        public long w() {
            master.flame.danmaku.danmaku.model.d first;
            master.flame.danmaku.danmaku.model.android.e eVar = this.f60841b;
            if (eVar == null || eVar.size() <= 0 || (first = this.f60841b.first()) == null) {
                return 0L;
            }
            return first.b();
        }

        public float x() {
            int i4 = this.f60844e;
            if (i4 == 0) {
                return 0.0f;
            }
            return this.f60845f / i4;
        }

        public void y(master.flame.danmaku.danmaku.model.d dVar, boolean z3) {
            e eVar = this.f60847h;
            if (eVar != null) {
                eVar.q();
                this.f60847h.obtainMessage(17, dVar).sendToTarget();
            }
        }

        public boolean z() {
            return this.f60845f + 5120 >= this.f60844e;
        }
    }

    public a(master.flame.danmaku.danmaku.model.f fVar, DanmakuContext danmakuContext, h.a aVar) {
        super(fVar, danmakuContext, aVar);
        this.f60832x = 2;
        this.A = new Object();
        NativeBitmapFactory.g();
        int max = (int) Math.max(4194304.0f, ((float) Runtime.getRuntime().maxMemory()) * danmakuContext.E.f61082b);
        this.f60832x = max;
        b bVar = new b(max, 3);
        this.f60833y = bVar;
        this.f60971h.d(bVar);
    }

    @Override // master.flame.danmaku.controller.e, master.flame.danmaku.controller.h
    public void a(master.flame.danmaku.danmaku.model.d dVar) {
        super.a(dVar);
        b bVar = this.f60833y;
        if (bVar == null) {
            return;
        }
        bVar.a(dVar);
    }

    @Override // master.flame.danmaku.controller.e, master.flame.danmaku.controller.h
    public void b(master.flame.danmaku.danmaku.model.d dVar, boolean z3) {
        b bVar = this.f60833y;
        if (bVar == null) {
            super.b(dVar, z3);
        } else {
            bVar.y(dVar, z3);
        }
    }

    @Override // master.flame.danmaku.controller.e, master.flame.danmaku.controller.h
    public void c(boolean z3) {
        super.c(z3);
        b bVar = this.f60833y;
        if (bVar != null) {
            bVar.E();
        }
    }

    @Override // master.flame.danmaku.controller.e, master.flame.danmaku.controller.h
    public void i() {
        super.i();
        reset();
        this.f60971h.d(null);
        b bVar = this.f60833y;
        if (bVar != null) {
            bVar.r();
            this.f60833y = null;
        }
        NativeBitmapFactory.i();
    }

    @Override // master.flame.danmaku.controller.e, master.flame.danmaku.controller.h
    public a.c j(master.flame.danmaku.danmaku.model.b bVar) {
        b bVar2;
        a.c j4 = super.j(bVar);
        synchronized (this.A) {
            this.A.notify();
        }
        if (j4 != null && (bVar2 = this.f60833y) != null && j4.f54690k - j4.f54691l < -20) {
            bVar2.F();
            this.f60833y.D(-this.f60966c.D.f61100e);
        }
        return j4;
    }

    @Override // master.flame.danmaku.controller.e, master.flame.danmaku.controller.h
    public void m(long j4, long j5, long j6) {
        super.m(j4, j5, j6);
        b bVar = this.f60833y;
        if (bVar != null) {
            bVar.I(j5);
        }
    }

    @Override // master.flame.danmaku.controller.e, master.flame.danmaku.controller.h
    public void onPlayStateChanged(int i4) {
        super.onPlayStateChanged(i4);
        b bVar = this.f60833y;
        if (bVar != null) {
            bVar.A(i4);
        }
    }

    @Override // master.flame.danmaku.controller.e, master.flame.danmaku.controller.h
    public void prepare() {
        s(this.f60969f);
        this.f60833y.m();
    }

    @Override // master.flame.danmaku.controller.e
    protected void r(master.flame.danmaku.danmaku.model.f fVar) {
        this.f60972i = fVar;
        master.flame.danmaku.danmaku.model.f fVar2 = new master.flame.danmaku.danmaku.model.f();
        this.f60834z = fVar2;
        fVar2.update(fVar.f61172a);
    }

    @Override // master.flame.danmaku.controller.e, master.flame.danmaku.controller.h
    public void seek(long j4) {
        super.seek(j4);
        if (this.f60833y == null) {
            start();
        }
        this.f60833y.I(j4);
    }

    @Override // master.flame.danmaku.controller.e, master.flame.danmaku.controller.h
    public void start() {
        super.start();
        NativeBitmapFactory.g();
        b bVar = this.f60833y;
        if (bVar == null) {
            b bVar2 = new b(this.f60832x, 3);
            this.f60833y = bVar2;
            bVar2.m();
            this.f60971h.d(this.f60833y);
            return;
        }
        bVar.H();
    }

    @Override // master.flame.danmaku.controller.e
    public boolean t(DanmakuContext danmakuContext, DanmakuContext.DanmakuConfigTag danmakuConfigTag, Object... objArr) {
        b bVar;
        b bVar2;
        if (!super.q(danmakuContext, danmakuConfigTag, objArr)) {
            if (DanmakuContext.DanmakuConfigTag.SCROLL_SPEED_FACTOR.equals(danmakuConfigTag)) {
                this.f60967d.a(this.f60966c.f61008c);
                f();
            } else if (danmakuConfigTag.isVisibilityRelatedTag()) {
                if (objArr != null && objArr.length > 0 && objArr[0] != null && ((!(objArr[0] instanceof Boolean) || ((Boolean) objArr[0]).booleanValue()) && (bVar2 = this.f60833y) != null)) {
                    bVar2.D(0L);
                }
                f();
            } else if (!DanmakuContext.DanmakuConfigTag.TRANSPARENCY.equals(danmakuConfigTag) && !DanmakuContext.DanmakuConfigTag.SCALE_TEXTSIZE.equals(danmakuConfigTag) && !DanmakuContext.DanmakuConfigTag.DANMAKU_STYLE.equals(danmakuConfigTag)) {
                b bVar3 = this.f60833y;
                if (bVar3 != null) {
                    bVar3.G();
                    this.f60833y.D(0L);
                }
            } else {
                if (DanmakuContext.DanmakuConfigTag.SCALE_TEXTSIZE.equals(danmakuConfigTag)) {
                    this.f60967d.a(this.f60966c.f61008c);
                }
                b bVar4 = this.f60833y;
                if (bVar4 != null) {
                    bVar4.E();
                    this.f60833y.D(-this.f60966c.D.f61100e);
                }
            }
        }
        if (this.f60970g == null || (bVar = this.f60833y) == null) {
            return true;
        }
        bVar.B(new RunnableC1231a());
        return true;
    }

    @Override // master.flame.danmaku.controller.e
    protected void u(master.flame.danmaku.danmaku.model.d dVar) {
        super.u(dVar);
        b bVar = this.f60833y;
        if (bVar != null) {
            int i4 = this.B + 1;
            this.B = i4;
            if (i4 > 5) {
                bVar.F();
                this.B = 0;
                return;
            }
            return;
        }
        o<?> e4 = dVar.e();
        if (e4 != null) {
            if (e4.hasReferences()) {
                e4.e();
            } else {
                e4.destroy();
            }
            dVar.f61170y = null;
        }
    }
}

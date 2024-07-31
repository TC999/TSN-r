package master.flame.danmaku.controller;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import master.flame.danmaku.controller.IDrawTask;
import master.flame.danmaku.danmaku.model.AbsDisplayer;
import master.flame.danmaku.danmaku.model.BaseDanmaku;
import master.flame.danmaku.danmaku.model.DanmakuTimer;
import master.flame.danmaku.danmaku.model.ICacheManager;
import master.flame.danmaku.danmaku.model.IDanmakus;
import master.flame.danmaku.danmaku.model.IDrawingCache;
import master.flame.danmaku.danmaku.model.android.DanmakuContext;
import master.flame.danmaku.danmaku.model.android.DanmakuFactory;
import master.flame.danmaku.danmaku.model.android.Danmakus;
import master.flame.danmaku.danmaku.model.android.DrawingCache;
import master.flame.danmaku.danmaku.model.android.DrawingCachePoolManager;
import master.flame.danmaku.danmaku.model.objectpool.Pool;
import master.flame.danmaku.danmaku.model.objectpool.Pools;
import p014a2.IRenderer;
import p025b2.DanmakuUtils;
import p025b2.SystemClock;
import tv.cjump.jni.NativeBitmapFactory;

/* renamed from: master.flame.danmaku.controller.a */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class CacheManagingDrawTask extends DrawTask {

    /* renamed from: C */
    private static final int f43496C = 3;

    /* renamed from: D */
    static final /* synthetic */ boolean f43497D = false;

    /* renamed from: A */
    private final Object f43498A;

    /* renamed from: B */
    private int f43499B;

    /* renamed from: x */
    private int f43500x;

    /* renamed from: y */
    private C15306b f43501y;

    /* renamed from: z */
    private DanmakuTimer f43502z;

    /* compiled from: CacheManagingDrawTask.java */
    /* renamed from: master.flame.danmaku.controller.a$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    class RunnableC15305a implements Runnable {
        RunnableC15305a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            CacheManagingDrawTask.this.f43654g.mo3259e();
        }
    }

    /* compiled from: CacheManagingDrawTask.java */
    /* renamed from: master.flame.danmaku.controller.a$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public class C15306b implements ICacheManager {

        /* renamed from: k */
        private static final String f43504k = "CacheManager";

        /* renamed from: l */
        public static final byte f43505l = 0;

        /* renamed from: m */
        public static final byte f43506m = 1;

        /* renamed from: n */
        public static final byte f43507n = 2;

        /* renamed from: a */
        public HandlerThread f43508a;

        /* renamed from: b */
        Danmakus f43509b = new Danmakus();

        /* renamed from: c */
        DrawingCachePoolManager f43510c;

        /* renamed from: d */
        Pool<DrawingCache> f43511d;

        /* renamed from: e */
        private int f43512e;

        /* renamed from: f */
        private int f43513f;

        /* renamed from: g */
        private int f43514g;

        /* renamed from: h */
        private HandlerC15311e f43515h;

        /* renamed from: i */
        private boolean f43516i;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: CacheManagingDrawTask.java */
        /* renamed from: master.flame.danmaku.controller.a$b$a */
        /* loaded from: E:\fuckcool\tsn\5406560.dex */
        public class C15307a extends IDanmakus.AbstractC15350c<BaseDanmaku> {
            C15307a() {
            }

            @Override // master.flame.danmaku.danmaku.model.IDanmakus.AbstractC15349b
            /* renamed from: e */
            public int mo2892a(BaseDanmaku baseDanmaku) {
                C15306b.this.m3426s(true, baseDanmaku, null);
                return 0;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: CacheManagingDrawTask.java */
        /* renamed from: master.flame.danmaku.controller.a$b$b */
        /* loaded from: E:\fuckcool\tsn\5406560.dex */
        public class C15308b extends IDanmakus.AbstractC15350c<BaseDanmaku> {
            C15308b() {
            }

            @Override // master.flame.danmaku.danmaku.model.IDanmakus.AbstractC15349b
            /* renamed from: e */
            public int mo2892a(BaseDanmaku baseDanmaku) {
                if (baseDanmaku.m3076s()) {
                    C15306b.this.m3426s(true, baseDanmaku, null);
                    return 2;
                }
                return 0;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: CacheManagingDrawTask.java */
        /* renamed from: master.flame.danmaku.controller.a$b$c */
        /* loaded from: E:\fuckcool\tsn\5406560.dex */
        public class C15309c extends IDanmakus.AbstractC15350c<BaseDanmaku> {
            C15309c() {
            }

            @Override // master.flame.danmaku.danmaku.model.IDanmakus.AbstractC15349b
            /* renamed from: e */
            public int mo2892a(BaseDanmaku baseDanmaku) {
                if (baseDanmaku.m3073w()) {
                    IDrawingCache<?> iDrawingCache = baseDanmaku.f43883y;
                    if (CacheManagingDrawTask.this.f43650c.f43694E.f43775c != -1 || iDrawingCache == null || iDrawingCache.hasReferences() || iDrawingCache.size() / CacheManagingDrawTask.this.f43500x >= CacheManagingDrawTask.this.f43650c.f43694E.f43776d) {
                        synchronized (CacheManagingDrawTask.this.f43498A) {
                            try {
                                CacheManagingDrawTask.this.f43498A.wait(30L);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                                return 1;
                            }
                        }
                        C15306b.this.m3426s(false, baseDanmaku, null);
                        return 2;
                    }
                    return 0;
                }
                return 1;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: CacheManagingDrawTask.java */
        /* renamed from: master.flame.danmaku.controller.a$b$d */
        /* loaded from: E:\fuckcool\tsn\5406560.dex */
        public class C15310d extends IDanmakus.AbstractC15349b<BaseDanmaku, BaseDanmaku> {

            /* renamed from: e */
            int f43521e = 0;

            /* renamed from: f */
            BaseDanmaku f43522f;

            /* renamed from: g */
            final /* synthetic */ int f43523g;

            /* renamed from: h */
            final /* synthetic */ BaseDanmaku f43524h;

            /* renamed from: i */
            final /* synthetic */ boolean f43525i;

            /* renamed from: j */
            final /* synthetic */ int f43526j;

            C15310d(int i, BaseDanmaku baseDanmaku, boolean z, int i2) {
                this.f43523g = i;
                this.f43524h = baseDanmaku;
                this.f43525i = z;
                this.f43526j = i2;
            }

            @Override // master.flame.danmaku.danmaku.model.IDanmakus.AbstractC15349b
            /* renamed from: e */
            public int mo2892a(BaseDanmaku baseDanmaku) {
                int i = this.f43521e;
                this.f43521e = i + 1;
                if (i >= this.f43523g) {
                    return 1;
                }
                IDrawingCache<?> m3086e = baseDanmaku.m3086e();
                if (m3086e != null && m3086e.get() != null) {
                    float f = baseDanmaku.f43874p;
                    BaseDanmaku baseDanmaku2 = this.f43524h;
                    if (f == baseDanmaku2.f43874p && baseDanmaku.f43875q == baseDanmaku2.f43875q && baseDanmaku.f43869k == baseDanmaku2.f43869k && baseDanmaku.f43871m == baseDanmaku2.f43871m && baseDanmaku.f43865g == baseDanmaku2.f43865g && baseDanmaku.f43861c.equals(baseDanmaku2.f43861c) && baseDanmaku.f43864f == this.f43524h.f43864f) {
                        this.f43522f = baseDanmaku;
                        return 1;
                    } else if (this.f43525i) {
                        return 0;
                    } else {
                        if (!baseDanmaku.m3073w()) {
                            return 1;
                        }
                        if (m3086e.hasReferences()) {
                            return 0;
                        }
                        float mo3022g = m3086e.mo3022g() - this.f43524h.f43874p;
                        float mo3025b = m3086e.mo3025b() - this.f43524h.f43875q;
                        if (mo3022g >= 0.0f) {
                            int i2 = this.f43526j;
                            if (mo3022g <= i2 && mo3025b >= 0.0f && mo3025b <= i2) {
                                this.f43522f = baseDanmaku;
                                return 1;
                            }
                        }
                    }
                }
                return 0;
            }

            @Override // master.flame.danmaku.danmaku.model.IDanmakus.AbstractC15349b
            /* renamed from: f */
            public BaseDanmaku mo2954d() {
                return this.f43522f;
            }
        }

        /* compiled from: CacheManagingDrawTask.java */
        /* renamed from: master.flame.danmaku.controller.a$b$e */
        /* loaded from: E:\fuckcool\tsn\5406560.dex */
        public class HandlerC15311e extends Handler {

            /* renamed from: f */
            private static final int f43528f = 1;

            /* renamed from: g */
            public static final int f43529g = 2;

            /* renamed from: h */
            public static final int f43530h = 3;

            /* renamed from: i */
            public static final int f43531i = 4;

            /* renamed from: j */
            public static final int f43532j = 5;

            /* renamed from: k */
            public static final int f43533k = 6;

            /* renamed from: l */
            public static final int f43534l = 7;

            /* renamed from: m */
            public static final int f43535m = 8;

            /* renamed from: n */
            public static final int f43536n = 9;

            /* renamed from: o */
            public static final int f43537o = 16;

            /* renamed from: p */
            public static final int f43538p = 17;

            /* renamed from: q */
            public static final int f43539q = 18;

            /* renamed from: a */
            private boolean f43540a;

            /* renamed from: b */
            private boolean f43541b;

            /* renamed from: c */
            private boolean f43542c;

            /* renamed from: d */
            private boolean f43543d;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* compiled from: CacheManagingDrawTask.java */
            /* renamed from: master.flame.danmaku.controller.a$b$e$a */
            /* loaded from: E:\fuckcool\tsn\5406560.dex */
            public class C15312a extends IDanmakus.AbstractC15350c<BaseDanmaku> {
                C15312a() {
                }

                @Override // master.flame.danmaku.danmaku.model.IDanmakus.AbstractC15349b
                /* renamed from: e */
                public int mo2892a(BaseDanmaku baseDanmaku) {
                    if (HandlerC15311e.this.f43540a || HandlerC15311e.this.f43543d) {
                        return 1;
                    }
                    if (!baseDanmaku.m3082m()) {
                        DanmakuContext danmakuContext = CacheManagingDrawTask.this.f43650c;
                        danmakuContext.f43692C.m3392b(baseDanmaku, 0, 0, null, true, danmakuContext);
                    }
                    if (baseDanmaku.m3081n()) {
                        return 0;
                    }
                    if (!baseDanmaku.m3078q()) {
                        baseDanmaku.mo3006z(CacheManagingDrawTask.this.f43651d, true);
                    }
                    if (!baseDanmaku.m3074u()) {
                        baseDanmaku.m3096A(CacheManagingDrawTask.this.f43651d, true);
                    }
                    return 0;
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* compiled from: CacheManagingDrawTask.java */
            /* renamed from: master.flame.danmaku.controller.a$b$e$b */
            /* loaded from: E:\fuckcool\tsn\5406560.dex */
            public class C15313b extends IDanmakus.AbstractC15350c<BaseDanmaku> {

                /* renamed from: e */
                int f43546e = 0;

                /* renamed from: f */
                int f43547f = 0;

                /* renamed from: g */
                final /* synthetic */ BaseDanmaku f43548g;

                /* renamed from: h */
                final /* synthetic */ boolean f43549h;

                /* renamed from: i */
                final /* synthetic */ int f43550i;

                /* renamed from: j */
                final /* synthetic */ long f43551j;

                /* renamed from: k */
                final /* synthetic */ long f43552k;

                /* renamed from: l */
                final /* synthetic */ long f43553l;

                C15313b(BaseDanmaku baseDanmaku, boolean z, int i, long j, long j2, long j3) {
                    this.f43548g = baseDanmaku;
                    this.f43549h = z;
                    this.f43550i = i;
                    this.f43551j = j;
                    this.f43552k = j2;
                    this.f43553l = j3;
                }

                @Override // master.flame.danmaku.danmaku.model.IDanmakus.AbstractC15349b
                /* renamed from: e */
                public int mo2892a(BaseDanmaku baseDanmaku) {
                    C15306b c15306b;
                    if (HandlerC15311e.this.f43540a || HandlerC15311e.this.f43543d || this.f43548g.m3088b() < CacheManagingDrawTask.this.f43656i.f43885a) {
                        return 1;
                    }
                    IDrawingCache<?> m3086e = baseDanmaku.m3086e();
                    if (m3086e == null || m3086e.get() == null) {
                        if (this.f43549h || (!baseDanmaku.m3073w() && baseDanmaku.m3076s())) {
                            if (!baseDanmaku.m3082m()) {
                                DanmakuContext danmakuContext = CacheManagingDrawTask.this.f43650c;
                                danmakuContext.f43692C.m3392b(baseDanmaku, this.f43546e, this.f43550i, null, true, danmakuContext);
                            }
                            if (baseDanmaku.f43873o == 0 && baseDanmaku.m3081n()) {
                                return 0;
                            }
                            if (baseDanmaku.getType() == 1) {
                                int m3088b = (int) ((baseDanmaku.m3088b() - this.f43551j) / CacheManagingDrawTask.this.f43650c.f43693D.f43792e);
                                if (this.f43547f == m3088b) {
                                    this.f43546e++;
                                } else {
                                    this.f43546e = 0;
                                    this.f43547f = m3088b;
                                }
                            }
                            if (!this.f43549h && !HandlerC15311e.this.f43541b) {
                                try {
                                    synchronized (CacheManagingDrawTask.this.f43498A) {
                                        CacheManagingDrawTask.this.f43498A.wait(this.f43552k);
                                    }
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                    return 1;
                                }
                            }
                            HandlerC15311e.this.m3407g(baseDanmaku, false);
                            if (!this.f43549h) {
                                DanmakuFactory danmakuFactory = CacheManagingDrawTask.this.f43650c.f43693D;
                                if (SystemClock.m59951b() - this.f43553l >= c15306b.f43514g * DanmakuFactory.f43784p) {
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

            public HandlerC15311e(Looper looper) {
                super(looper);
            }

            /* renamed from: e */
            private final void m3409e(BaseDanmaku baseDanmaku) {
                if (baseDanmaku.m3073w()) {
                    return;
                }
                if (baseDanmaku.m3088b() <= CacheManagingDrawTask.this.f43502z.f43885a + CacheManagingDrawTask.this.f43650c.f43693D.f43792e || baseDanmaku.f43884z) {
                    if (baseDanmaku.f43873o == 0 && baseDanmaku.m3081n()) {
                        return;
                    }
                    IDrawingCache<?> m3086e = baseDanmaku.m3086e();
                    if (m3086e == null || m3086e.get() == null) {
                        m3407g(baseDanmaku, true);
                    }
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* renamed from: g */
            public byte m3407g(BaseDanmaku baseDanmaku, boolean z) {
                if (!baseDanmaku.m3078q()) {
                    baseDanmaku.mo3006z(CacheManagingDrawTask.this.f43651d, true);
                }
                DrawingCache drawingCache = null;
                try {
                    C15306b c15306b = C15306b.this;
                    BaseDanmaku m3423v = c15306b.m3423v(baseDanmaku, true, CacheManagingDrawTask.this.f43650c.f43694E.f43778f);
                    DrawingCache drawingCache2 = m3423v != null ? (DrawingCache) m3423v.f43883y : null;
                    try {
                        if (drawingCache2 != null) {
                            drawingCache2.mo3020j();
                            baseDanmaku.f43883y = drawingCache2;
                            CacheManagingDrawTask.this.f43501y.m3451C(baseDanmaku, 0, z);
                            return (byte) 0;
                        }
                        C15306b c15306b2 = C15306b.this;
                        BaseDanmaku m3423v2 = c15306b2.m3423v(baseDanmaku, false, CacheManagingDrawTask.this.f43650c.f43694E.f43779g);
                        if (m3423v2 != null) {
                            drawingCache2 = (DrawingCache) m3423v2.f43883y;
                        }
                        if (drawingCache2 != null) {
                            m3423v2.f43883y = null;
                            CacheManagingDrawTask cacheManagingDrawTask = CacheManagingDrawTask.this;
                            baseDanmaku.f43883y = DanmakuUtils.m59965a(baseDanmaku, cacheManagingDrawTask.f43651d, drawingCache2, cacheManagingDrawTask.f43650c.f43694E.f43773a);
                            CacheManagingDrawTask.this.f43501y.m3451C(baseDanmaku, 0, z);
                            return (byte) 0;
                        }
                        int m59960f = DanmakuUtils.m59960f((int) baseDanmaku.f43874p, (int) baseDanmaku.f43875q, CacheManagingDrawTask.this.f43650c.f43694E.f43773a / 8);
                        if (m59960f * 2 > CacheManagingDrawTask.this.f43500x) {
                            return (byte) 1;
                        }
                        if (!z && C15306b.this.f43513f + m59960f > C15306b.this.f43512e) {
                            CacheManagingDrawTask.this.f43501y.m3429p(m59960f, false);
                            return (byte) 1;
                        }
                        DrawingCache acquire = C15306b.this.f43511d.acquire();
                        CacheManagingDrawTask cacheManagingDrawTask2 = CacheManagingDrawTask.this;
                        DrawingCache m59965a = DanmakuUtils.m59965a(baseDanmaku, cacheManagingDrawTask2.f43651d, acquire, cacheManagingDrawTask2.f43650c.f43694E.f43773a);
                        baseDanmaku.f43883y = m59965a;
                        boolean m3451C = CacheManagingDrawTask.this.f43501y.m3451C(baseDanmaku, C15306b.this.m3444J(baseDanmaku), z);
                        if (!m3451C) {
                            m3399o(baseDanmaku, m59965a);
                        }
                        return (!m3451C ? 1 : 0) == 1 ? (byte) 1 : (byte) 0;
                    } catch (Exception unused) {
                        drawingCache = drawingCache2;
                        m3399o(baseDanmaku, drawingCache);
                        return (byte) 1;
                    } catch (OutOfMemoryError unused2) {
                        drawingCache = drawingCache2;
                        m3399o(baseDanmaku, drawingCache);
                        return (byte) 1;
                    }
                } catch (Exception unused3) {
                } catch (OutOfMemoryError unused4) {
                }
            }

            /* renamed from: i */
            private long m3405i() {
                long j = CacheManagingDrawTask.this.f43502z.f43885a;
                C15306b c15306b = C15306b.this;
                CacheManagingDrawTask cacheManagingDrawTask = CacheManagingDrawTask.this;
                long j2 = cacheManagingDrawTask.f43656i.f43885a;
                DanmakuContext danmakuContext = cacheManagingDrawTask.f43650c;
                if (j <= j2 - danmakuContext.f43693D.f43792e) {
                    if (danmakuContext.f43694E.f43775c != -1) {
                        c15306b.m3424u();
                    }
                    CacheManagingDrawTask.this.f43502z.update(CacheManagingDrawTask.this.f43656i.f43885a);
                    sendEmptyMessage(3);
                    return 0L;
                }
                float m3421x = c15306b.m3421x();
                BaseDanmaku first = C15306b.this.f43509b.first();
                long m3088b = first != null ? first.m3088b() - CacheManagingDrawTask.this.f43656i.f43885a : 0L;
                CacheManagingDrawTask cacheManagingDrawTask2 = CacheManagingDrawTask.this;
                long j3 = cacheManagingDrawTask2.f43650c.f43693D.f43792e;
                long j4 = 2 * j3;
                if (m3421x < 0.6f && m3088b > j3) {
                    cacheManagingDrawTask2.f43502z.update(CacheManagingDrawTask.this.f43656i.f43885a);
                    removeMessages(3);
                    sendEmptyMessage(3);
                    return 0L;
                } else if (m3421x > 0.4f && m3088b < (-j4)) {
                    removeMessages(4);
                    sendEmptyMessage(4);
                    return 0L;
                } else if (m3421x >= 0.9f) {
                    return 0L;
                } else {
                    long j5 = cacheManagingDrawTask2.f43502z.f43885a - CacheManagingDrawTask.this.f43656i.f43885a;
                    if (first != null && first.m3073w()) {
                        CacheManagingDrawTask cacheManagingDrawTask3 = CacheManagingDrawTask.this;
                        if (j5 < (-cacheManagingDrawTask3.f43650c.f43693D.f43792e)) {
                            cacheManagingDrawTask3.f43502z.update(CacheManagingDrawTask.this.f43656i.f43885a);
                            sendEmptyMessage(8);
                            sendEmptyMessage(3);
                            return 0L;
                        }
                    }
                    if (j5 > j4) {
                        return 0L;
                    }
                    removeMessages(3);
                    sendEmptyMessage(3);
                    return 0L;
                }
            }

            /* renamed from: m */
            private void m3401m() {
                IDanmakus iDanmakus;
                try {
                    CacheManagingDrawTask cacheManagingDrawTask = CacheManagingDrawTask.this;
                    long j = cacheManagingDrawTask.f43656i.f43885a;
                    long j2 = cacheManagingDrawTask.f43650c.f43693D.f43792e;
                    iDanmakus = cacheManagingDrawTask.f43652e.mo3054d(j - j2, (2 * j2) + j);
                } catch (Exception unused) {
                    iDanmakus = null;
                }
                if (iDanmakus == null || iDanmakus.isEmpty()) {
                    return;
                }
                iDanmakus.mo3050h(new C15312a());
            }

            /* JADX WARN: Code restructure failed: missing block: B:17:0x0069, code lost:
                r19.f43544e.f43517j.f43502z.update(r12);
             */
            /* JADX WARN: Code restructure failed: missing block: B:18:0x0074, code lost:
                return 0;
             */
            /* renamed from: n */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            private long m3400n(boolean r20) {
                /*
                    Method dump skipped, instructions count: 229
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: master.flame.danmaku.controller.CacheManagingDrawTask.C15306b.HandlerC15311e.m3400n(boolean):long");
            }

            /* renamed from: o */
            private void m3399o(BaseDanmaku baseDanmaku, DrawingCache drawingCache) {
                if (drawingCache == null) {
                    drawingCache = (DrawingCache) baseDanmaku.f43883y;
                }
                baseDanmaku.f43883y = null;
                if (drawingCache == null) {
                    return;
                }
                drawingCache.destroy();
                C15306b.this.f43511d.mo3008a(drawingCache);
            }

            /* renamed from: f */
            public void m3408f() {
                sendEmptyMessage(1);
                sendEmptyMessageDelayed(4, CacheManagingDrawTask.this.f43650c.f43693D.f43792e);
            }

            /* renamed from: h */
            public boolean m3406h(BaseDanmaku baseDanmaku) {
                DrawingCache drawingCache;
                DrawingCache acquire;
                if (!baseDanmaku.m3078q()) {
                    baseDanmaku.mo3006z(CacheManagingDrawTask.this.f43651d, true);
                }
                try {
                    acquire = C15306b.this.f43511d.acquire();
                } catch (Exception unused) {
                    drawingCache = null;
                } catch (OutOfMemoryError unused2) {
                    drawingCache = null;
                }
                try {
                    CacheManagingDrawTask cacheManagingDrawTask = CacheManagingDrawTask.this;
                    drawingCache = DanmakuUtils.m59965a(baseDanmaku, cacheManagingDrawTask.f43651d, acquire, cacheManagingDrawTask.f43650c.f43694E.f43773a);
                    baseDanmaku.f43883y = drawingCache;
                    return true;
                } catch (Exception unused3) {
                    if (drawingCache != null) {
                        C15306b.this.f43511d.mo3008a(drawingCache);
                    }
                    baseDanmaku.f43883y = null;
                    return false;
                } catch (OutOfMemoryError unused4) {
                    if (drawingCache != null) {
                        C15306b.this.f43511d.mo3008a(drawingCache);
                    }
                    baseDanmaku.f43883y = null;
                    return false;
                }
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                int i = message.what;
                switch (i) {
                    case 1:
                        C15306b.this.m3424u();
                        for (int i2 = 0; i2 < 300; i2++) {
                            C15306b.this.f43511d.mo3008a(new DrawingCache());
                        }
                        break;
                    case 2:
                        m3409e((BaseDanmaku) message.obj);
                        return;
                    case 3:
                        removeMessages(3);
                        CacheManagingDrawTask cacheManagingDrawTask = CacheManagingDrawTask.this;
                        boolean z = !(cacheManagingDrawTask.f43654g == null || cacheManagingDrawTask.f43661n) || this.f43542c;
                        m3400n(z);
                        if (z) {
                            this.f43542c = false;
                        }
                        CacheManagingDrawTask cacheManagingDrawTask2 = CacheManagingDrawTask.this;
                        IDrawTask.InterfaceC15341a interfaceC15341a = cacheManagingDrawTask2.f43654g;
                        if (interfaceC15341a == null || cacheManagingDrawTask2.f43661n) {
                            return;
                        }
                        interfaceC15341a.mo3261c();
                        CacheManagingDrawTask.this.f43661n = true;
                        return;
                    case 4:
                        C15306b.this.m3428q();
                        return;
                    case 5:
                        Long l = (Long) message.obj;
                        if (l != null) {
                            long longValue = l.longValue();
                            long j = CacheManagingDrawTask.this.f43502z.f43885a;
                            CacheManagingDrawTask.this.f43502z.update(longValue);
                            this.f43542c = true;
                            long m3422w = C15306b.this.m3422w();
                            if (longValue <= j) {
                                C15306b c15306b = C15306b.this;
                                if (m3422w - longValue <= CacheManagingDrawTask.this.f43650c.f43693D.f43792e) {
                                    c15306b.m3428q();
                                    m3400n(true);
                                    m3396r();
                                    return;
                                }
                            }
                            C15306b.this.m3424u();
                            m3400n(true);
                            m3396r();
                            return;
                        }
                        return;
                    case 6:
                        removeCallbacksAndMessages(null);
                        this.f43540a = true;
                        C15306b.this.m3425t();
                        C15306b.this.m3430o();
                        getLooper().quit();
                        return;
                    case 7:
                        C15306b.this.m3425t();
                        DanmakuTimer danmakuTimer = CacheManagingDrawTask.this.f43502z;
                        CacheManagingDrawTask cacheManagingDrawTask3 = CacheManagingDrawTask.this;
                        danmakuTimer.update(cacheManagingDrawTask3.f43656i.f43885a - cacheManagingDrawTask3.f43650c.f43693D.f43792e);
                        this.f43542c = true;
                        return;
                    case 8:
                        C15306b.this.m3424u();
                        CacheManagingDrawTask.this.f43502z.update(CacheManagingDrawTask.this.f43656i.f43885a);
                        return;
                    case 9:
                        C15306b.this.m3424u();
                        CacheManagingDrawTask.this.f43502z.update(CacheManagingDrawTask.this.f43656i.f43885a);
                        CacheManagingDrawTask.this.mo3271f();
                        return;
                    default:
                        switch (i) {
                            case 16:
                                break;
                            case 17:
                                BaseDanmaku baseDanmaku = (BaseDanmaku) message.obj;
                                if (baseDanmaku != null) {
                                    IDrawingCache<?> m3086e = baseDanmaku.m3086e();
                                    if (!((baseDanmaku.f43857J & 1) != 0) && m3086e != null && m3086e.get() != null && !m3086e.hasReferences()) {
                                        CacheManagingDrawTask cacheManagingDrawTask4 = CacheManagingDrawTask.this;
                                        baseDanmaku.f43883y = DanmakuUtils.m59965a(baseDanmaku, cacheManagingDrawTask4.f43651d, (DrawingCache) baseDanmaku.f43883y, cacheManagingDrawTask4.f43650c.f43694E.f43773a);
                                        C15306b.this.m3451C(baseDanmaku, 0, true);
                                        return;
                                    } else if (baseDanmaku.f43884z) {
                                        C15306b.this.m3431n(baseDanmaku);
                                        m3406h(baseDanmaku);
                                        return;
                                    } else {
                                        if (m3086e != null && m3086e.hasReferences()) {
                                            m3086e.destroy();
                                        }
                                        C15306b.this.m3426s(true, baseDanmaku, null);
                                        m3409e(baseDanmaku);
                                        return;
                                    }
                                }
                                return;
                            case 18:
                                this.f43543d = false;
                                return;
                            default:
                                return;
                        }
                }
                long m3405i = m3405i();
                if (m3405i <= 0) {
                    m3405i = CacheManagingDrawTask.this.f43650c.f43693D.f43792e / 2;
                }
                sendEmptyMessageDelayed(16, m3405i);
            }

            /* renamed from: j */
            public boolean m3404j() {
                return this.f43540a;
            }

            /* renamed from: k */
            public void m3403k(boolean z) {
                this.f43541b = !z;
            }

            /* renamed from: l */
            public void m3402l() {
                this.f43540a = true;
                removeCallbacksAndMessages(null);
                sendEmptyMessage(6);
            }

            /* renamed from: p */
            public void m3398p(long j) {
                removeMessages(3);
                this.f43542c = true;
                sendEmptyMessage(18);
                CacheManagingDrawTask.this.f43502z.update(CacheManagingDrawTask.this.f43656i.f43885a + j);
                sendEmptyMessage(3);
            }

            /* renamed from: q */
            public void m3397q() {
                this.f43543d = true;
            }

            /* renamed from: r */
            public void m3396r() {
                sendEmptyMessage(18);
                this.f43540a = false;
                removeMessages(16);
                sendEmptyMessage(16);
                sendEmptyMessageDelayed(4, CacheManagingDrawTask.this.f43650c.f43693D.f43792e);
            }
        }

        public C15306b(int i, int i2) {
            DrawingCachePoolManager drawingCachePoolManager = new DrawingCachePoolManager();
            this.f43510c = drawingCachePoolManager;
            this.f43511d = Pools.m3012a(drawingCachePoolManager, 800);
            this.f43516i = false;
            this.f43513f = 0;
            this.f43512e = i;
            this.f43514g = i2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: C */
        public boolean m3451C(BaseDanmaku baseDanmaku, int i, boolean z) {
            if (i > 0) {
                m3429p(i, z);
            }
            this.f43509b.mo3049i(baseDanmaku);
            this.f43513f += i;
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: n */
        public long m3431n(BaseDanmaku baseDanmaku) {
            IDrawingCache<?> iDrawingCache = baseDanmaku.f43883y;
            if (iDrawingCache == null) {
                return 0L;
            }
            if (iDrawingCache.hasReferences()) {
                iDrawingCache.mo3024e();
                baseDanmaku.f43883y = null;
                return 0L;
            }
            long m3444J = m3444J(baseDanmaku);
            iDrawingCache.destroy();
            baseDanmaku.f43883y = null;
            return m3444J;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: o */
        public void m3430o() {
            while (true) {
                DrawingCache acquire = this.f43511d.acquire();
                if (acquire == null) {
                    return;
                }
                acquire.destroy();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: p */
        public void m3429p(int i, boolean z) {
            BaseDanmaku first = this.f43509b.first();
            while (this.f43513f + i > this.f43512e && first != null) {
                if (first.m3073w() || first.m3081n()) {
                    m3426s(false, first, null);
                    this.f43509b.mo3051g(first);
                    first = this.f43509b.first();
                } else if (z) {
                    return;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: q */
        public void m3428q() {
            this.f43509b.mo3050h(new C15309c());
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: t */
        public void m3425t() {
            Danmakus danmakus = this.f43509b;
            if (danmakus != null) {
                danmakus.mo3050h(new C15307a());
                this.f43509b.clear();
            }
            this.f43513f = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: u */
        public void m3424u() {
            Danmakus danmakus = this.f43509b;
            if (danmakus != null) {
                danmakus.mo3050h(new C15308b());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: v */
        public BaseDanmaku m3423v(BaseDanmaku baseDanmaku, boolean z, int i) {
            C15310d c15310d = new C15310d(i, baseDanmaku, z, (!z ? CacheManagingDrawTask.this.f43651d.mo3044b() * 2 : 0) + CacheManagingDrawTask.this.f43650c.f43694E.f43777e);
            this.f43509b.mo3050h(c15310d);
            return c15310d.mo2954d();
        }

        /* renamed from: A */
        public void m3453A(int i) {
            HandlerC15311e handlerC15311e = this.f43515h;
            if (handlerC15311e != null) {
                handlerC15311e.m3403k(i == 1);
            }
        }

        /* renamed from: B */
        public void m3452B(Runnable runnable) {
            HandlerC15311e handlerC15311e = this.f43515h;
            if (handlerC15311e == null) {
                return;
            }
            handlerC15311e.post(runnable);
        }

        /* renamed from: D */
        public void m3450D(long j) {
            HandlerC15311e handlerC15311e = this.f43515h;
            if (handlerC15311e != null) {
                handlerC15311e.m3398p(j);
            }
        }

        /* renamed from: E */
        public void m3449E() {
            HandlerC15311e handlerC15311e = this.f43515h;
            if (handlerC15311e == null) {
                return;
            }
            handlerC15311e.removeMessages(3);
            this.f43515h.removeMessages(18);
            this.f43515h.m3397q();
            this.f43515h.removeMessages(7);
            this.f43515h.sendEmptyMessage(7);
        }

        /* renamed from: F */
        public void m3448F() {
            HandlerC15311e handlerC15311e = this.f43515h;
            if (handlerC15311e == null) {
                return;
            }
            handlerC15311e.removeMessages(4);
            this.f43515h.sendEmptyMessage(4);
        }

        /* renamed from: G */
        public void m3447G() {
            HandlerC15311e handlerC15311e = this.f43515h;
            if (handlerC15311e == null) {
                return;
            }
            handlerC15311e.removeMessages(9);
            this.f43515h.sendEmptyMessage(9);
        }

        /* renamed from: H */
        public void m3446H() {
            HandlerC15311e handlerC15311e = this.f43515h;
            if (handlerC15311e != null) {
                handlerC15311e.m3396r();
            } else {
                m3432m();
            }
        }

        /* renamed from: I */
        public void m3445I(long j) {
            HandlerC15311e handlerC15311e = this.f43515h;
            if (handlerC15311e == null) {
                return;
            }
            handlerC15311e.m3397q();
            this.f43515h.removeMessages(3);
            this.f43515h.obtainMessage(5, Long.valueOf(j)).sendToTarget();
        }

        /* renamed from: J */
        protected int m3444J(BaseDanmaku baseDanmaku) {
            IDrawingCache<?> iDrawingCache = baseDanmaku.f43883y;
            if (iDrawingCache == null || iDrawingCache.hasReferences()) {
                return 0;
            }
            return baseDanmaku.f43883y.size();
        }

        @Override // master.flame.danmaku.danmaku.model.ICacheManager
        /* renamed from: a */
        public void mo3058a(BaseDanmaku baseDanmaku) {
            HandlerC15311e handlerC15311e = this.f43515h;
            if (handlerC15311e != null) {
                if (baseDanmaku.f43884z && baseDanmaku.f43848A) {
                    if (baseDanmaku.m3073w()) {
                        return;
                    }
                    this.f43515h.m3406h(baseDanmaku);
                    return;
                }
                handlerC15311e.obtainMessage(2, baseDanmaku).sendToTarget();
            }
        }

        /* renamed from: m */
        public void m3432m() {
            this.f43516i = false;
            if (this.f43508a == null) {
                HandlerThread handlerThread = new HandlerThread("DFM Cache-Building Thread");
                this.f43508a = handlerThread;
                handlerThread.start();
            }
            if (this.f43515h == null) {
                this.f43515h = new HandlerC15311e(this.f43508a.getLooper());
            }
            this.f43515h.m3408f();
        }

        /* renamed from: r */
        public void m3427r() {
            this.f43516i = true;
            synchronized (CacheManagingDrawTask.this.f43498A) {
                CacheManagingDrawTask.this.f43498A.notifyAll();
            }
            HandlerC15311e handlerC15311e = this.f43515h;
            if (handlerC15311e != null) {
                handlerC15311e.m3402l();
                this.f43515h = null;
            }
            HandlerThread handlerThread = this.f43508a;
            if (handlerThread != null) {
                try {
                    handlerThread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                this.f43508a.quit();
                this.f43508a = null;
            }
        }

        /* renamed from: s */
        protected void m3426s(boolean z, BaseDanmaku baseDanmaku, BaseDanmaku baseDanmaku2) {
            IDrawingCache<?> m3086e = baseDanmaku.m3086e();
            if (m3086e != null) {
                long m3431n = m3431n(baseDanmaku);
                if (baseDanmaku.m3073w()) {
                    CacheManagingDrawTask.this.f43650c.m3221g().mo3100w().mo3115g(baseDanmaku);
                }
                if (m3431n <= 0) {
                    return;
                }
                this.f43513f = (int) (this.f43513f - m3431n);
                this.f43511d.mo3008a((DrawingCache) m3086e);
            }
        }

        /* renamed from: w */
        public long m3422w() {
            BaseDanmaku first;
            Danmakus danmakus = this.f43509b;
            if (danmakus == null || danmakus.size() <= 0 || (first = this.f43509b.first()) == null) {
                return 0L;
            }
            return first.m3088b();
        }

        /* renamed from: x */
        public float m3421x() {
            int i = this.f43512e;
            if (i == 0) {
                return 0.0f;
            }
            return this.f43513f / i;
        }

        /* renamed from: y */
        public void m3420y(BaseDanmaku baseDanmaku, boolean z) {
            HandlerC15311e handlerC15311e = this.f43515h;
            if (handlerC15311e != null) {
                handlerC15311e.m3397q();
                this.f43515h.obtainMessage(17, baseDanmaku).sendToTarget();
            }
        }

        /* renamed from: z */
        public boolean m3419z() {
            return this.f43513f + 5120 >= this.f43512e;
        }
    }

    public CacheManagingDrawTask(DanmakuTimer danmakuTimer, DanmakuContext danmakuContext, IDrawTask.InterfaceC15341a interfaceC15341a) {
        super(danmakuTimer, danmakuContext, interfaceC15341a);
        this.f43500x = 2;
        this.f43498A = new Object();
        NativeBitmapFactory.m261g();
        int max = (int) Math.max(4194304.0f, ((float) Runtime.getRuntime().maxMemory()) * danmakuContext.f43694E.f43774b);
        this.f43500x = max;
        C15306b c15306b = new C15306b(max, 3);
        this.f43501y = c15306b;
        this.f43655h.mo2974c(c15306b);
    }

    @Override // master.flame.danmaku.controller.DrawTask, master.flame.danmaku.controller.IDrawTask
    /* renamed from: a */
    public void mo3276a(BaseDanmaku baseDanmaku) {
        super.mo3276a(baseDanmaku);
        C15306b c15306b = this.f43501y;
        if (c15306b == null) {
            return;
        }
        c15306b.mo3058a(baseDanmaku);
    }

    @Override // master.flame.danmaku.controller.DrawTask, master.flame.danmaku.controller.IDrawTask
    /* renamed from: b */
    public void mo3275b(BaseDanmaku baseDanmaku, boolean z) {
        C15306b c15306b = this.f43501y;
        if (c15306b == null) {
            super.mo3275b(baseDanmaku, z);
        } else {
            c15306b.m3420y(baseDanmaku, z);
        }
    }

    @Override // master.flame.danmaku.controller.DrawTask, master.flame.danmaku.controller.IDrawTask
    /* renamed from: c */
    public void mo3274c(boolean z) {
        super.mo3274c(z);
        C15306b c15306b = this.f43501y;
        if (c15306b != null) {
            c15306b.m3449E();
        }
    }

    @Override // master.flame.danmaku.controller.DrawTask, master.flame.danmaku.controller.IDrawTask
    /* renamed from: i */
    public void mo3268i() {
        super.mo3268i();
        reset();
        this.f43655h.mo2974c(null);
        C15306b c15306b = this.f43501y;
        if (c15306b != null) {
            c15306b.m3427r();
            this.f43501y = null;
        }
        NativeBitmapFactory.m259i();
    }

    @Override // master.flame.danmaku.controller.DrawTask, master.flame.danmaku.controller.IDrawTask
    /* renamed from: j */
    public IRenderer.C0025c mo3267j(AbsDisplayer absDisplayer) {
        C15306b c15306b;
        IRenderer.C0025c mo3267j = super.mo3267j(absDisplayer);
        synchronized (this.f43498A) {
            this.f43498A.notify();
        }
        if (mo3267j != null && (c15306b = this.f43501y) != null && mo3267j.f69k - mo3267j.f70l < -20) {
            c15306b.m3448F();
            this.f43501y.m3450D(-this.f43650c.f43693D.f43792e);
        }
        return mo3267j;
    }

    @Override // master.flame.danmaku.controller.DrawTask, master.flame.danmaku.controller.IDrawTask
    /* renamed from: m */
    public void mo3264m(long j, long j2, long j3) {
        super.mo3264m(j, j2, j3);
        C15306b c15306b = this.f43501y;
        if (c15306b != null) {
            c15306b.m3445I(j2);
        }
    }

    @Override // master.flame.danmaku.controller.DrawTask, master.flame.danmaku.controller.IDrawTask
    public void onPlayStateChanged(int i) {
        super.onPlayStateChanged(i);
        C15306b c15306b = this.f43501y;
        if (c15306b != null) {
            c15306b.m3453A(i);
        }
    }

    @Override // master.flame.danmaku.controller.DrawTask, master.flame.danmaku.controller.IDrawTask
    public void prepare() {
        m3288s(this.f43653f);
        this.f43501y.m3432m();
    }

    @Override // master.flame.danmaku.controller.DrawTask
    /* renamed from: r */
    protected void mo3289r(DanmakuTimer danmakuTimer) {
        this.f43656i = danmakuTimer;
        DanmakuTimer danmakuTimer2 = new DanmakuTimer();
        this.f43502z = danmakuTimer2;
        danmakuTimer2.update(danmakuTimer.f43885a);
    }

    @Override // master.flame.danmaku.controller.DrawTask, master.flame.danmaku.controller.IDrawTask
    public void seek(long j) {
        super.seek(j);
        if (this.f43501y == null) {
            start();
        }
        this.f43501y.m3445I(j);
    }

    @Override // master.flame.danmaku.controller.DrawTask, master.flame.danmaku.controller.IDrawTask
    public void start() {
        super.start();
        NativeBitmapFactory.m261g();
        C15306b c15306b = this.f43501y;
        if (c15306b == null) {
            C15306b c15306b2 = new C15306b(this.f43500x, 3);
            this.f43501y = c15306b2;
            c15306b2.m3432m();
            this.f43655h.mo2974c(this.f43501y);
            return;
        }
        c15306b.m3446H();
    }

    @Override // master.flame.danmaku.controller.DrawTask
    /* renamed from: t */
    public boolean mo3287t(DanmakuContext danmakuContext, DanmakuContext.DanmakuConfigTag danmakuConfigTag, Object... objArr) {
        C15306b c15306b;
        C15306b c15306b2;
        if (!super.m3290q(danmakuContext, danmakuConfigTag, objArr)) {
            if (DanmakuContext.DanmakuConfigTag.SCROLL_SPEED_FACTOR.equals(danmakuConfigTag)) {
                this.f43651d.mo3045a(this.f43650c.f43698c);
                mo3271f();
            } else if (danmakuConfigTag.isVisibilityRelatedTag()) {
                if (objArr != null && objArr.length > 0 && objArr[0] != null && ((!(objArr[0] instanceof Boolean) || ((Boolean) objArr[0]).booleanValue()) && (c15306b2 = this.f43501y) != null)) {
                    c15306b2.m3450D(0L);
                }
                mo3271f();
            } else if (!DanmakuContext.DanmakuConfigTag.TRANSPARENCY.equals(danmakuConfigTag) && !DanmakuContext.DanmakuConfigTag.SCALE_TEXTSIZE.equals(danmakuConfigTag) && !DanmakuContext.DanmakuConfigTag.DANMAKU_STYLE.equals(danmakuConfigTag)) {
                C15306b c15306b3 = this.f43501y;
                if (c15306b3 != null) {
                    c15306b3.m3447G();
                    this.f43501y.m3450D(0L);
                }
            } else {
                if (DanmakuContext.DanmakuConfigTag.SCALE_TEXTSIZE.equals(danmakuConfigTag)) {
                    this.f43651d.mo3045a(this.f43650c.f43698c);
                }
                C15306b c15306b4 = this.f43501y;
                if (c15306b4 != null) {
                    c15306b4.m3449E();
                    this.f43501y.m3450D(-this.f43650c.f43693D.f43792e);
                }
            }
        }
        if (this.f43654g == null || (c15306b = this.f43501y) == null) {
            return true;
        }
        c15306b.m3452B(new RunnableC15305a());
        return true;
    }

    @Override // master.flame.danmaku.controller.DrawTask
    /* renamed from: u */
    protected void mo3286u(BaseDanmaku baseDanmaku) {
        super.mo3286u(baseDanmaku);
        C15306b c15306b = this.f43501y;
        if (c15306b != null) {
            int i = this.f43499B + 1;
            this.f43499B = i;
            if (i > 5) {
                c15306b.m3448F();
                this.f43499B = 0;
                return;
            }
            return;
        }
        IDrawingCache<?> m3086e = baseDanmaku.m3086e();
        if (m3086e != null) {
            if (m3086e.hasReferences()) {
                m3086e.mo3024e();
            } else {
                m3086e.destroy();
            }
            baseDanmaku.f43883y = null;
        }
    }
}

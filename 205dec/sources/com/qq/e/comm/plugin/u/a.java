package com.qq.e.comm.plugin.u;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.nativ.ADSize;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADEventListener;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.compliance.DownloadConfirmListener;
import com.qq.e.comm.plugin.apkmanager.k;
import com.qq.e.comm.plugin.callback.biz.DialogStateCallback;
import com.qq.e.comm.plugin.g0.q;
import com.qq.e.comm.plugin.n0.v;
import com.qq.e.comm.plugin.nativeadunified.o;
import com.qq.e.comm.plugin.o0.g.b;
import com.qq.e.comm.plugin.o0.h.f;
import com.qq.e.comm.plugin.q0.l;
import com.qq.e.comm.plugin.r0.i;
import com.qq.e.comm.plugin.u.f;
import com.qq.e.comm.plugin.util.b1;
import com.qq.e.comm.plugin.util.d1;
import com.qq.e.comm.plugin.util.l1;
import com.qq.e.comm.plugin.util.l2;
import com.qq.e.comm.plugin.util.o1;
import com.qq.e.comm.plugin.util.r;
import com.qq.e.comm.plugin.util.r1;
import com.qq.e.comm.plugin.util.u0;
import com.qq.e.comm.plugin.util.w;
import java.io.File;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public abstract class a implements i, ADEventListener, com.qq.e.comm.plugin.apkmanager.w.a, com.qq.e.comm.plugin.e0.a, com.qq.e.comm.plugin.util.v2.e {
    private int A;
    private volatile boolean B;
    private Boolean D;
    private String E;
    private String F;
    private long G;
    private boolean H;
    private final com.qq.e.comm.plugin.util.v2.b I;

    /* renamed from: c  reason: collision with root package name */
    private Context f46241c;

    /* renamed from: d  reason: collision with root package name */
    protected q f46242d;

    /* renamed from: e  reason: collision with root package name */
    protected ADListener f46243e;

    /* renamed from: f  reason: collision with root package name */
    protected com.qq.e.comm.plugin.n0.c f46244f;

    /* renamed from: g  reason: collision with root package name */
    private Handler f46245g;

    /* renamed from: h  reason: collision with root package name */
    private int f46246h;

    /* renamed from: i  reason: collision with root package name */
    protected com.qq.e.comm.plugin.u.f f46247i;

    /* renamed from: j  reason: collision with root package name */
    public com.qq.e.comm.plugin.u.h f46248j;

    /* renamed from: k  reason: collision with root package name */
    protected boolean f46249k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f46250l;

    /* renamed from: n  reason: collision with root package name */
    private String f46252n;

    /* renamed from: o  reason: collision with root package name */
    private String f46253o;

    /* renamed from: q  reason: collision with root package name */
    private boolean f46255q;

    /* renamed from: r  reason: collision with root package name */
    private String f46256r;

    /* renamed from: s  reason: collision with root package name */
    private com.qq.e.comm.plugin.u.c f46257s;

    /* renamed from: t  reason: collision with root package name */
    private CountDownTimer f46258t;

    /* renamed from: u  reason: collision with root package name */
    private int f46259u;

    /* renamed from: x  reason: collision with root package name */
    private boolean f46262x;

    /* renamed from: y  reason: collision with root package name */
    private long f46263y;

    /* renamed from: z  reason: collision with root package name */
    private long f46264z;

    /* renamed from: m  reason: collision with root package name */
    private o f46251m = o.f44987c;

    /* renamed from: p  reason: collision with root package name */
    private AtomicBoolean f46254p = new AtomicBoolean(false);

    /* renamed from: v  reason: collision with root package name */
    private AtomicBoolean f46260v = new AtomicBoolean(false);

    /* renamed from: w  reason: collision with root package name */
    private AtomicBoolean f46261w = new AtomicBoolean(false);
    private final long C = System.currentTimeMillis();

    /* compiled from: A */
    /* renamed from: com.qq.e.comm.plugin.u.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class RunnableC0897a implements Runnable {

        /* compiled from: A */
        /* renamed from: com.qq.e.comm.plugin.u.a$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\2450172.dex */
        class C0898a implements f.a {

            /* renamed from: a  reason: collision with root package name */
            private boolean f46266a;

            C0898a() {
            }

            @Override // com.qq.e.comm.plugin.u.f.a
            public void a(com.qq.e.comm.plugin.u.h hVar) {
                a.this.D = Boolean.TRUE;
                long currentTimeMillis = System.currentTimeMillis();
                a.this.f46248j = hVar;
                hVar.a(new C0899a(currentTimeMillis));
                a aVar = a.this;
                aVar.a(109, aVar.f46248j.b());
                if (a.this.j()) {
                    a.this.a();
                    a.this.k();
                } else if (!TextUtils.isEmpty(a.this.f46253o) && a.this.f46254p.get() && a.this.f46242d.H() == 1.0d) {
                    a.this.k();
                }
                q qVar = a.this.f46242d;
                if (qVar != null && qVar.o() == com.qq.e.comm.plugin.b.g.NATIVEEXPRESSAD) {
                    a.this.s();
                }
                com.qq.e.comm.plugin.u.d.a(a.this.f46244f, 101, a.this.f46249k ? 2 : 1);
            }

            /* compiled from: A */
            /* renamed from: com.qq.e.comm.plugin.u.a$a$a$a  reason: collision with other inner class name */
            /* loaded from: E:\TSN-r\205dec\2450172.dex */
            class C0899a implements com.qq.e.comm.plugin.u.g {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ long f46268a;

                C0899a(long j4) {
                    this.f46268a = j4;
                }

                @Override // com.qq.e.comm.plugin.u.g
                public void a(com.qq.e.comm.plugin.i.f fVar) {
                    a.this.a(fVar);
                    com.qq.e.comm.plugin.u.d.a(a.this.f46244f, System.currentTimeMillis() - this.f46268a);
                }

                @Override // com.qq.e.comm.plugin.u.g
                public void b() {
                    a.this.c();
                }

                @Override // com.qq.e.comm.plugin.u.g
                public void c() {
                    a.this.a((View) null);
                }

                @Override // com.qq.e.comm.plugin.u.g
                public void a(String str) {
                    a.this.f46257s.a(str);
                    if (a.this.h()) {
                        a.this.c(true);
                    }
                    com.qq.e.comm.plugin.u.d.a(a.this.f46244f, System.currentTimeMillis() - this.f46268a);
                }

                @Override // com.qq.e.comm.plugin.u.g
                public void a(int i4, int... iArr) {
                    if (i4 == 210) {
                        if (iArr == null || iArr.length != 1) {
                            return;
                        }
                        r2 = -1;
                        for (int i5 : iArr) {
                        }
                        a.this.a(i4, Integer.valueOf(i5));
                    } else if (i4 == 1001) {
                        a.this.a(false);
                    } else if (i4 == 1008) {
                        int i6 = iArr[0];
                        int i7 = iArr[1];
                        d1.a(a.this.f46256r, "onFireMediaEvent\uff0c EVENT_PLAY_PROCESS currentPosition:%d, duration:%d, mVideoFileProgress:%d", Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(a.this.A));
                        a.this.I.a(i6, i7, a.this.A);
                    } else if (i4 != 1009) {
                        switch (i4) {
                            case 201:
                            case 203:
                                break;
                            case 202:
                                a.this.n();
                                a aVar = a.this;
                                aVar.b(aVar.A, a.this.f46264z, a.this.f46263y);
                                if (!C0898a.this.f46266a) {
                                    a.this.a(System.currentTimeMillis() - this.f46268a);
                                    C0898a.this.f46266a = true;
                                }
                                a.this.a(i4, new Object[0]);
                                a.this.B = true;
                                return;
                            case 207:
                                a.this.u();
                            case 204:
                            case 205:
                            case 206:
                                a.this.l();
                                break;
                            default:
                                return;
                        }
                        a.this.a(i4, new Object[0]);
                    } else {
                        int i8 = iArr[0];
                        f.t a4 = f.t.a(iArr[1]);
                        d1.a(a.this.f46256r, "onFireMediaEvent\uff0c EVENT_PLAY_PROCESS blockTime:%d, state:%s", Integer.valueOf(i8), a4);
                        a.this.I.a(i8, a4);
                    }
                }

                @Override // com.qq.e.comm.plugin.u.g
                public void a(boolean z3) {
                    a.this.a(106, Boolean.valueOf(z3));
                    a aVar = a.this;
                    com.qq.e.comm.plugin.u.d.a(aVar.f46244f, aVar.getVideoDuration(), System.currentTimeMillis() - this.f46268a);
                }

                @Override // com.qq.e.comm.plugin.u.g
                public void a() {
                    a.this.a(106, Boolean.TRUE);
                    a aVar = a.this;
                    com.qq.e.comm.plugin.u.d.a(aVar.f46244f, aVar.getVideoDuration(), System.currentTimeMillis() - this.f46268a);
                }
            }

            @Override // com.qq.e.comm.plugin.u.f.a
            public void a(int i4) {
                if (a.this.j()) {
                    a.this.a();
                }
                a.this.D = Boolean.FALSE;
                a.this.a(110, Integer.valueOf(i4));
                q qVar = a.this.f46242d;
                if (qVar != null && qVar.o() == com.qq.e.comm.plugin.b.g.NATIVEEXPRESSAD) {
                    a.this.b(i4);
                }
                com.qq.e.comm.plugin.u.d.a(a.this.f46244f, i4, a.this.f46249k ? 4 : 3);
            }
        }

        RunnableC0897a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f46247i == null) {
                C0898a c0898a = new C0898a();
                a aVar = a.this;
                Context context = aVar.f46241c;
                q qVar = a.this.f46242d;
                aVar.f46247i = aVar.a(context, qVar, qVar.p1(), c0898a, a.this.f46244f);
            }
            a aVar2 = a.this;
            aVar2.f46248j = aVar2.f46247i.b();
            a aVar3 = a.this;
            aVar3.f46247i.a(aVar3.I.e());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class b implements i.f {
        b() {
        }

        @Override // com.qq.e.comm.plugin.r0.i.f
        public void onComplainSuccess() {
            a.this.a(304, new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class c implements DialogInterface.OnDismissListener {
        c() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            ((DialogStateCallback) com.qq.e.comm.plugin.h.a.b(a.this.f46242d.l0(), DialogStateCallback.class)).onDismiss().b(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class d implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ View f46272c;

        d(View view) {
            this.f46272c = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.f46242d.c(System.currentTimeMillis());
            String c4 = com.qq.e.comm.plugin.e.a.a().c(this.f46272c);
            a aVar = a.this;
            com.qq.e.comm.plugin.l0.c.a(c4, aVar.f46242d, aVar.E, a.this.f46242d.u0(), null);
            l1.a(this.f46272c, a.this.f46242d);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class e implements com.qq.e.comm.plugin.b0.c {
        e() {
        }

        @Override // com.qq.e.comm.plugin.b0.c
        public void a(String str, int i4, Exception exc) {
        }

        @Override // com.qq.e.comm.plugin.b0.c
        public void a(String str, ImageView imageView, com.qq.e.comm.plugin.b0.f fVar) {
            if (fVar.a()) {
                return;
            }
            v.a(9130005, a.this.f46244f, 2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class g implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f46278c;

        /* compiled from: A */
        /* renamed from: com.qq.e.comm.plugin.u.a$g$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\2450172.dex */
        class CountDownTimerC0900a extends CountDownTimer {
            CountDownTimerC0900a(long j4, long j5) {
                super(j4, j5);
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                d1.a("gdt_tag_reward_video", "Express2 load video timeout");
                a.this.f46260v.set(true);
                a.this.a(207, new Object[0]);
                if (a.this.B) {
                    return;
                }
                a aVar = a.this;
                aVar.a(aVar.A, a.this.f46264z, a.this.f46263y);
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j4) {
            }
        }

        g(int i4) {
            this.f46278c = i4;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f46258t != null) {
                a.this.f46258t.cancel();
            }
            a aVar = a.this;
            long j4 = this.f46278c;
            aVar.f46258t = new CountDownTimerC0900a(j4, j4).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class h extends r1 {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f46281d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ Object[] f46282e;

        h(int i4, Object[] objArr) {
            this.f46281d = i4;
            this.f46282e = objArr;
        }

        @Override // com.qq.e.comm.plugin.util.r1
        public void b() {
            ADListener aDListener = a.this.f46243e;
            if (aDListener != null) {
                aDListener.onADEvent(new ADEvent(this.f46281d, this.f46282e));
            }
        }
    }

    public a(Context context, q qVar, int i4) {
        this.f46241c = context;
        this.F = qVar.q0();
        this.f46242d = qVar;
        this.G = com.qq.e.comm.plugin.util.c.b(qVar);
        String k4 = this.f46242d.k();
        this.f46256r = a.class.getSimpleName() + k4;
        this.f46244f = com.qq.e.comm.plugin.n0.c.a(qVar);
        this.f46245g = new Handler(Looper.getMainLooper());
        this.f46259u = i4;
        this.I = new com.qq.e.comm.plugin.util.v2.b(this.f46242d, this);
        if (this.f46242d.l1()) {
            g();
            if (!j()) {
                if (com.qq.e.comm.plugin.d0.a.d().f().a("Express2_Preload_Video", 1) == 1) {
                    b(true);
                }
            } else {
                com.qq.e.comm.plugin.u.d.c(this.f46244f);
            }
        }
        if (this.f46242d.X0()) {
            k.e().a(this.f46242d.q().e(), this);
        }
        if (com.qq.e.comm.plugin.d0.a.d().f().a("eimgp", this.F, 0) == 1) {
            l.d().a(this.f46242d.X(), (l.d) null);
        }
        this.f46257s = new com.qq.e.comm.plugin.u.c(this.f46241c, this, this.f46242d);
    }

    protected abstract com.qq.e.comm.plugin.u.f a(Context context, q qVar, VideoOption videoOption, f.a aVar, com.qq.e.comm.plugin.n0.c cVar);

    protected void a(int i4, long j4, long j5) {
    }

    @Override // com.qq.e.comm.plugin.u.i
    public void destroy() {
        if (this.f46247i != null) {
            com.qq.e.comm.plugin.u.h hVar = this.f46248j;
            if (hVar != null) {
                this.I.a(hVar.b());
            }
            this.f46247i.destroy();
        }
        if (this.f46242d.N() > 0 && !this.f46262x) {
            com.qq.e.comm.plugin.u.d.b(this.f46244f, System.currentTimeMillis() - this.f46242d.N());
        }
        if (this.D == null && !this.f46262x && this.f46261w.get()) {
            v.a(1404009, this.f46244f);
        }
        this.f46262x = true;
    }

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public String getApkInfoUrl() {
        q qVar = this.f46242d;
        if (qVar != null) {
            return qVar.r();
        }
        return null;
    }

    @Override // com.qq.e.comm.plugin.e0.a
    public String[] getCompetitionFailureUrls() {
        return new String[]{this.f46242d.S()};
    }

    @Override // com.qq.e.comm.plugin.e0.a
    public String[] getCompetitionWinUrls() {
        return new String[]{this.f46242d.U0()};
    }

    @Override // com.qq.e.comm.plugin.u.i
    public int getECPM() {
        return this.f46242d.J();
    }

    @Override // com.qq.e.comm.plugin.u.i
    public String getECPMLevel() {
        return this.f46242d.W0();
    }

    @Override // com.qq.e.comm.plugin.u.i
    public Map<String, Object> getExtraInfo() {
        return this.f46242d.R();
    }

    @Override // com.qq.e.comm.plugin.u.i
    public int getVideoDuration() {
        return this.f46242d.M0() * 1000;
    }

    @Override // com.qq.e.comm.plugin.u.i
    public boolean isValid() {
        return !r();
    }

    @Override // com.qq.e.comm.plugin.u.i
    public void preloadVideo() {
        b(true);
    }

    protected void q() {
    }

    @Override // com.qq.e.comm.plugin.u.i
    public void render() {
        if (this.f46261w.get()) {
            return;
        }
        this.f46261w.set(true);
        if (this.f46242d.o() == com.qq.e.comm.plugin.b.g.NATIVEEXPRESSAD) {
            p();
        }
        if (this.f46241c != null && com.qq.e.comm.plugin.b.g.NATIVEEXPRESSAD == this.f46242d.o()) {
            com.qq.e.comm.plugin.util.u2.e.b().a(this.f46242d.q0(), com.qq.e.comm.plugin.b.g.NATIVEEXPRESSAD.d());
        }
        if (com.qq.e.comm.plugin.b.g.NATIVEEXPRESSAD == this.f46242d.o() && r()) {
            a(110, new Object[0]);
        } else {
            this.f46245g.post(new RunnableC0897a());
        }
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void sendLossNotification(int i4, int i5, String str) {
        r.b(i4, i5, str, this.F, this.f46242d, this.f46244f, this);
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void sendWinNotification(int i4) {
        r.a(i4, this.f46242d, this.F, this.f46244f, this);
    }

    @Override // com.qq.e.comm.adevent.ADEventListener
    public void setAdListener(ADListener aDListener) {
        this.f46243e = aDListener;
        com.qq.e.comm.plugin.u.c cVar = this.f46257s;
        if (cVar != null) {
            cVar.a(aDListener);
        }
        if (this.H) {
            a();
            this.H = false;
        }
    }

    @Override // com.qq.e.comm.plugin.u.i
    public void setAdSize(ADSize aDSize) {
        this.f46242d.a(aDSize.getWidth(), aDSize.getHeight());
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void setBidECPM(int i4) {
        try {
            this.E = r.a(i4);
        } catch (o1.d unused) {
            d1.a("pack price error");
        }
    }

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public void setDownloadConfirmListener(DownloadConfirmListener downloadConfirmListener) {
        q qVar = this.f46242d;
        if (qVar != null && downloadConfirmListener != null) {
            String e02 = qVar.e0();
            String str = this.f46256r;
            d1.a(str, "setDownloadConfirmListener trace id:" + e02 + " listener:" + downloadConfirmListener);
            com.qq.e.comm.plugin.b.j.b().a(e02, downloadConfirmListener);
            return;
        }
        String str2 = this.f46256r;
        d1.b(str2, "setDownloadConfirmListener error mAdData:" + this.f46242d + " listener:" + downloadConfirmListener);
    }

    protected void t() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        File c4 = b1.c(this.f46242d.L0());
        if (c4 != null && c4.exists()) {
            this.f46251m = o.f44990f;
            this.f46252n = c4.getAbsolutePath();
        }
        if (this.f46251m == o.f44990f || !TextUtils.isEmpty(this.f46253o)) {
            return;
        }
        if (this.I.e()) {
            this.f46253o = com.qq.e.comm.plugin.p0.e.a().c(this.f46242d.L0(), this.f46242d.o().f42000e);
        } else {
            this.f46253o = com.qq.e.comm.plugin.p0.e.a().a(this.f46242d.L0());
        }
    }

    private boolean i() {
        return this.f46251m == o.f44991g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        if (this.f46248j != null) {
            if (j()) {
                this.f46248j.a(this.f46252n);
            } else {
                this.f46248j.a(this.f46253o);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        u0.a(this.f46242d.P0());
    }

    private void o() {
        w.a(this.f46244f, System.currentTimeMillis() - this.C);
    }

    private void p() {
        com.qq.e.comm.plugin.u.d.a(this.f46244f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        com.qq.e.comm.plugin.u.d.b(this.f46244f);
    }

    @Override // com.qq.e.comm.plugin.u.i
    public View e() {
        com.qq.e.comm.plugin.u.f fVar = this.f46247i;
        if (fVar != null) {
            return fVar.a();
        }
        return null;
    }

    public boolean h() {
        return this.f46242d.l1();
    }

    public boolean j() {
        return this.f46251m == o.f44990f && !TextUtils.isEmpty(this.f46252n);
    }

    protected void l() {
        c(false);
    }

    public boolean r() {
        return com.qq.e.comm.plugin.util.c.a(this.G);
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void sendLossNotification(Map<String, Object> map) {
        r.a(map, this.F, this.f46242d, this.f46244f, this);
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void sendWinNotification(Map<String, Object> map) {
        r.a(map, this.f46242d, this.F, this.f46244f, this);
    }

    protected void u() {
        if (!TextUtils.isEmpty(this.f46253o)) {
            com.qq.e.comm.plugin.u.d.a(this.f46244f, this.A, this.f46264z, this.f46263y);
        }
        this.I.f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        com.qq.e.comm.plugin.r0.i iVar = new com.qq.e.comm.plugin.r0.i(e(), this.f46242d);
        iVar.a(new b());
        iVar.a(new c());
        iVar.i();
        ((DialogStateCallback) com.qq.e.comm.plugin.h.a.b(this.f46242d.l0(), DialogStateCallback.class)).d().b(1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class f implements com.qq.e.comm.plugin.p.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ boolean f46275a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ boolean f46276b;

        f(boolean z3, boolean z4) {
            this.f46275a = z3;
            this.f46276b = z4;
        }

        @Override // com.qq.e.comm.plugin.p.b
        public void a() {
            a.this.f46251m = o.f44988d;
            com.qq.e.comm.plugin.u.h hVar = a.this.f46248j;
            if (hVar != null) {
                hVar.c();
            }
            d1.a(a.this.f46256r, "Video download onStarted: ");
        }

        @Override // com.qq.e.comm.plugin.p.b
        public void b() {
        }

        @Override // com.qq.e.comm.plugin.p.b
        public void a(long j4, boolean z3) {
            a.this.f46246h = (int) (j4 >> 10);
            a.this.f46254p.set(true);
            if (TextUtils.isEmpty(a.this.f46253o)) {
                return;
            }
            if ((a.this.f46242d.H() == 1.0d || !this.f46275a) && !this.f46276b) {
                a.this.k();
                a.this.t();
            }
        }

        @Override // com.qq.e.comm.plugin.p.b
        public void a(long j4, long j5, int i4) {
            String str = a.this.f46256r;
            d1.a(str, "Video download onProgress: " + i4);
            com.qq.e.comm.plugin.u.h hVar = a.this.f46248j;
            if (hVar != null) {
                hVar.a(j4, j5, i4);
            }
            a.this.f46263y = j5;
            a.this.f46264z = j4;
            a.this.A = i4;
        }

        @Override // com.qq.e.comm.plugin.p.b
        public void a(File file, long j4) {
            if (a.this.f46260v.get()) {
                d1.a(a.this.f46256r, "Video download onCompleted called, but timeout");
                return;
            }
            if (a.this.f46258t != null) {
                a.this.f46258t.cancel();
            }
            a.this.g();
            if (a.this.j()) {
                if (TextUtils.isEmpty(a.this.f46253o) || !a.this.B) {
                    a.this.k();
                }
                a.this.a();
            }
            l2.a(j4, a.this.f46246h, a.this.f46242d.L0(), a.this.f46244f);
            d1.a(a.this.f46256r, "Video download onCompleted: ");
        }

        @Override // com.qq.e.comm.plugin.p.b
        public void a(boolean z3) {
            a.this.f46251m = o.f44989e;
            String str = a.this.f46256r;
            d1.a(str, "Video download onPaused: " + z3);
            if (z3) {
                if (a.this.f46260v.get()) {
                    d1.a(a.this.f46256r, "Video download onCompleted called, but timeout");
                } else if (a.this.f46258t != null) {
                    a.this.f46258t.cancel();
                }
            }
        }

        @Override // com.qq.e.comm.plugin.p.b
        public void a(com.qq.e.comm.plugin.p.d dVar) {
            if (a.this.f46260v.get()) {
                d1.a(a.this.f46256r, "Video download onCompleted called, but timeout");
                return;
            }
            a.this.I.h();
            if (a.this.f46258t != null) {
                a.this.f46258t.cancel();
            }
            a.this.f46251m = o.f44991g;
            if (!a.this.f46250l || !this.f46275a) {
                a.this.a(207, new Object[0]);
            }
            a.this.f46255q = true;
            com.qq.e.comm.plugin.u.h hVar = a.this.f46248j;
            if (hVar != null) {
                hVar.a((String) null);
            }
            a.this.l();
            String str = a.this.f46256r;
            d1.a(str, "Video download onFailed e: " + dVar.b());
        }
    }

    private void b(boolean z3) {
        if (this.f46242d.l1() && !i()) {
            if (j()) {
                k();
                a();
                return;
            }
            boolean z4 = !TextUtils.isEmpty(this.f46253o);
            com.qq.e.comm.plugin.b0.b.a().a(this.f46242d.Y(), new e());
            double d4 = 1.0d;
            double H = this.f46242d.H();
            if (!z4) {
                d1.a(this.f46256r, "CDNVideoDownloadTrigger video cache not enable");
                this.I.h();
            } else if (z3) {
                if (com.qq.e.comm.plugin.util.v2.a.a(H)) {
                    if (this.f46243e != null) {
                        a();
                    } else {
                        this.H = true;
                    }
                    d1.a(this.f46256r, "CDNStrategyUtil Don't download ");
                    return;
                }
                d1.a(this.f46256r, "CDNStrategyUtil all download ");
                this.I.h();
            } else {
                d1.a(this.f46256r, "CDNVideoDownloadTrigger download");
                if (this.f46242d.u0() == 3) {
                    d4 = this.I.b();
                } else {
                    this.I.h();
                }
            }
            a(z3, z4, d4, false);
            a(this.f46259u, !z4);
        }
    }

    @Override // com.qq.e.comm.plugin.apkmanager.w.a
    public void a(String str, int i4, int i5, long j4) {
        String str2 = this.f46256r;
        d1.a(str2, "onAPKStatusUpdate: pkgName:" + str + ",status:" + i4 + ",progress:" + i5 + ",totalSize:" + j4);
        com.qq.e.comm.plugin.g0.b q3 = this.f46242d.q();
        if (q3 != null) {
            q3.a(i5);
            q3.c(i4);
        }
    }

    public void a(Activity activity) {
        com.qq.e.comm.plugin.u.f fVar = this.f46247i;
        if (fVar != null) {
            fVar.a(activity);
        }
    }

    protected void a(com.qq.e.comm.plugin.i.f fVar) {
        this.f46257s.a(fVar);
        if (h()) {
            c(true);
        }
    }

    public void a(View view) {
        if (this.f46249k) {
            return;
        }
        if (this.f46248j == null && view == null) {
            return;
        }
        if (view == null) {
            view = this.f46248j.a();
        }
        this.f46249k = true;
        com.qq.e.comm.plugin.e.a a4 = com.qq.e.comm.plugin.e.a.a();
        if (a4.d(view) == null) {
            a4.a(view, this.f46242d);
        }
        a(103, new Object[0]);
        view.post(new d(view));
        q();
        o();
    }

    protected void c(boolean z3) {
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int videoDuration = getVideoDuration();
        com.qq.e.comm.plugin.u.h hVar = this.f46248j;
        if (hVar != null) {
            i4 = hVar.g();
            int currentPosition = i4 == 0 ? this.f46248j.getCurrentPosition() : 0;
            if (this.f46248j.getDuration() > 0) {
                videoDuration = this.f46248j.getDuration();
            }
            int d4 = this.f46248j.d();
            int e4 = this.f46248j.e();
            i7 = this.f46248j.f();
            i5 = videoDuration;
            i9 = currentPosition;
            i8 = e4;
            i6 = d4;
        } else {
            i4 = 2;
            i5 = videoDuration;
            i6 = 1;
            i7 = 1;
            i8 = 1;
            i9 = 0;
        }
        com.qq.e.comm.plugin.l0.c.a(i6, i7, i8, z3 ? 3 : i4, i9, i5, this.f46242d, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        if (this.f46250l) {
            return;
        }
        a(201, new Object[0]);
        this.f46250l = true;
    }

    private void a(boolean z3, boolean z4, double d4, boolean z5) {
        d1.a(this.f46256r, "downloadVideoPartial isPreloadResource\uff1a%b, playWhileDownloading:%b, downloadRatio:%.2f", Boolean.valueOf(z3), Boolean.valueOf(z4), Double.valueOf(d4));
        com.qq.e.comm.plugin.o0.g.a.a().a(new b.C0867b().d(this.f46242d.L0()).a(b1.d(this.f46242d.L0())).a(b1.p()).d(!z4).a(d4).c(this.I.d()).a(this.f46244f).a(), new f(z3, z5));
    }

    @Override // com.qq.e.comm.plugin.util.v2.e
    public void a(com.qq.e.comm.plugin.util.v2.c cVar, double d4) {
        a(false, true, d4, true);
    }

    private void a(int i4, boolean z3) {
        if (i4 <= 0) {
            return;
        }
        if (!z3) {
            i4 *= 2;
        }
        this.f46245g.post(new g(i4));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i4, Object... objArr) {
        if (this.f46243e != null) {
            this.f46245g.post(new h(i4, objArr));
        }
    }

    public void a(boolean z3) {
        b(z3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i4) {
        com.qq.e.comm.plugin.u.d.a(i4, this.f46244f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j4) {
        com.qq.e.comm.plugin.u.d.c(this.f46244f, j4);
    }

    public q b() {
        return this.f46242d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i4) {
        com.qq.e.comm.plugin.u.d.b(this.f46244f, i4);
    }

    protected void b(int i4, long j4, long j5) {
        if (!TextUtils.isEmpty(this.f46253o)) {
            com.qq.e.comm.plugin.u.d.b(this.f46244f, i4, j4, j5);
        }
        this.I.g();
    }
}

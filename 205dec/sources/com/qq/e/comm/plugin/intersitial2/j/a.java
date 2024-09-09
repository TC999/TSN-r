package com.qq.e.comm.plugin.intersitial2.j;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.nativ.ADSize;
import com.qq.e.ads.rewardvideo.ServerSideVerificationOptions;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.compliance.DownloadConfirmCallBack;
import com.qq.e.comm.compliance.DownloadConfirmListener;
import com.qq.e.comm.plugin.b.g;
import com.qq.e.comm.plugin.b.j;
import com.qq.e.comm.plugin.b.l;
import com.qq.e.comm.plugin.b.m;
import com.qq.e.comm.plugin.dl.i;
import com.qq.e.comm.plugin.fs.FSCallback;
import com.qq.e.comm.plugin.fs.e.f;
import com.qq.e.comm.plugin.g0.l0.c;
import com.qq.e.comm.plugin.g0.l0.f.c;
import com.qq.e.comm.plugin.g0.v;
import com.qq.e.comm.plugin.h.f;
import com.qq.e.comm.plugin.intersitial2.h;
import com.qq.e.comm.plugin.rewardvideo.e;
import com.qq.e.comm.plugin.util.b1;
import com.qq.e.comm.plugin.util.d1;
import com.qq.e.comm.plugin.util.p0;
import com.qq.e.comm.util.GDTLogger;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class a extends h implements com.qq.e.comm.plugin.intersitial2.j.b, f {
    private static final g T = g.UNIFIED_INTERSTITIAL_FULLSCREEN;
    private static final e.a<v> U;
    private v H;
    private DownloadConfirmListener I;
    private ServerSideVerificationOptions J;
    private final boolean K;

    /* renamed from: L  reason: collision with root package name */
    private boolean f44484L;
    private boolean M;
    private final com.qq.e.comm.plugin.h.e N;
    private volatile com.qq.e.comm.plugin.g0.l0.c<v> O;
    private final m P;
    private final com.qq.e.comm.plugin.l0.b Q;
    private AtomicBoolean R;
    private long S;

    /* compiled from: A */
    /* renamed from: com.qq.e.comm.plugin.intersitial2.j.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    static class C0851a implements e.a<v> {
        C0851a() {
        }

        @Override // com.qq.e.comm.plugin.rewardvideo.e.a
        /* renamed from: b */
        public v a(String str, String str2, String str3, String str4, g gVar, JSONObject jSONObject, l lVar) {
            return new v(str, str2, str3, str4, jSONObject, lVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class c implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ v f44487c;

        c(v vVar) {
            this.f44487c = vVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.H == null) {
                return;
            }
            a.this.H.c(3);
            ((com.qq.e.comm.plugin.gdtnativead.g) a.this).f43793w.b(3);
            if (((com.qq.e.comm.plugin.gdtnativead.g) a.this).f43781k != null) {
                ((com.qq.e.comm.plugin.gdtnativead.g) a.this).f43781k.onADEvent(new ADEvent(100, a.this.H));
                com.qq.e.comm.plugin.l0.e.a(((com.qq.e.comm.plugin.gdtnativead.g) a.this).f43793w, 1, a.this.H);
                if (a.this.K) {
                    ((com.qq.e.comm.plugin.gdtnativead.g) a.this).f43781k.onADEvent(new ADEvent(109, new Object[0]));
                }
            }
            com.qq.e.comm.plugin.gdtnativead.d.a(a.this.H.q0(), new VideoOption.Builder().setAutoPlayMuted(!a.this.A()).setDetailPageMuted(false).setAutoPlayPolicy(1).build());
            a.this.a(this.f44487c, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class d implements f.c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ boolean f44489a;

        d(boolean z3) {
            this.f44489a = z3;
        }

        @Override // com.qq.e.comm.plugin.fs.e.f.c
        public void a() {
        }

        @Override // com.qq.e.comm.plugin.fs.e.f.c
        public void a(int i4, long j4, long j5) {
        }

        @Override // com.qq.e.comm.plugin.fs.e.f.c
        public void a(com.qq.e.comm.plugin.p.d dVar) {
        }

        @Override // com.qq.e.comm.plugin.fs.e.f.c
        public void a(String str) {
            if (this.f44489a) {
                return;
            }
            if (!a.this.f44484L) {
                ((com.qq.e.comm.plugin.gdtnativead.g) a.this).f43781k.onADEvent(new ADEvent(201, new Object[0]));
                a.this.f44484L = true;
            }
            if (a.this.K) {
                return;
            }
            ((com.qq.e.comm.plugin.gdtnativead.g) a.this).f43781k.onADEvent(new ADEvent(109, new Object[0]));
        }

        @Override // com.qq.e.comm.plugin.fs.e.f.c
        public void a(boolean z3) {
        }

        @Override // com.qq.e.comm.plugin.fs.e.f.c
        public void onCancel() {
        }

        @Override // com.qq.e.comm.plugin.fs.e.f.c
        public void onStart() {
        }
    }

    static {
        new AtomicBoolean();
        System.currentTimeMillis();
        i.a().b(T);
        U = new C0851a();
    }

    public a(Context context, ADSize aDSize, String str, String str2, String str3, l lVar, ADListener aDListener) {
        super(context, aDSize, str, str2, str3, lVar, aDListener, T);
        this.N = new com.qq.e.comm.plugin.h.e();
        this.R = new AtomicBoolean();
        this.f43790t = new com.qq.e.comm.plugin.gdtnativead.i(this, context, str, str2, str3, this.f43773c, lVar, aDSize, false, this.f43793w);
        this.K = com.qq.e.comm.plugin.d0.a.d().f().a("uirsd", str2, 1) == 1;
        this.Q = new com.qq.e.comm.plugin.l0.b(c(), l());
        this.P = new m(l(), c(), (com.qq.e.comm.plugin.b.f) null);
    }

    public boolean A() {
        return this.M;
    }

    public void B() {
        this.R.set(true);
        if (this.O != null) {
            this.O.a((com.qq.e.comm.plugin.g0.l0.c<v>) u(), a(this.f43782l), this.Q, this.P, (c.f) null, this.f43793w);
            this.O.b(a(this.f43782l), this.Q, this.P, this.f43793w);
        }
    }

    @Override // com.qq.e.comm.plugin.intersitial2.h, com.qq.e.comm.plugin.intersitial2.d
    public void close() {
        v vVar = this.H;
        if (vVar != null) {
            ((FSCallback) com.qq.e.comm.plugin.h.a.b(vVar.l0(), FSCallback.class)).B().a();
        }
    }

    @Override // com.qq.e.comm.plugin.intersitial2.h, com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public String getApkInfoUrl() {
        v vVar = this.H;
        if (vVar != null) {
            return vVar.r();
        }
        return null;
    }

    @Override // com.qq.e.comm.plugin.intersitial2.h, com.qq.e.comm.plugin.gdtnativead.g, com.qq.e.comm.plugin.e0.a
    public String[] getCompetitionFailureUrls() {
        v vVar = this.H;
        return vVar != null ? new String[]{vVar.S()} : super.getCompetitionFailureUrls();
    }

    @Override // com.qq.e.comm.plugin.intersitial2.h, com.qq.e.comm.plugin.gdtnativead.g, com.qq.e.comm.plugin.e0.a
    public String[] getCompetitionWinUrls() {
        v vVar = this.H;
        return vVar != null ? new String[]{vVar.U0()} : super.getCompetitionWinUrls();
    }

    @Override // com.qq.e.comm.plugin.h.f
    public boolean isDestroyed() {
        return false;
    }

    @Override // com.qq.e.comm.plugin.intersitial2.h, com.qq.e.comm.plugin.gdtnativead.g, com.qq.e.comm.pi.NEADI
    public void loadAd(int i4) {
        w();
        this.f43782l = i4;
        this.O.a(a(i4), this.Q, this.P, this.f43793w, new b(new AtomicLong(System.currentTimeMillis())));
    }

    @Override // com.qq.e.comm.compliance.DownloadConfirmListener
    public void onDownloadConfirm(Activity activity, int i4, String str, DownloadConfirmCallBack downloadConfirmCallBack) {
        DownloadConfirmListener downloadConfirmListener = this.I;
        if (downloadConfirmListener != null) {
            downloadConfirmListener.onDownloadConfirm(activity, i4, str, downloadConfirmCallBack);
        }
    }

    @Override // com.qq.e.comm.plugin.intersitial2.h, com.qq.e.comm.plugin.intersitial2.d
    public boolean r() {
        return com.qq.e.comm.plugin.util.c.a(this.S);
    }

    @Override // com.qq.e.comm.plugin.intersitial2.h, com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public void setDownloadConfirmListener(DownloadConfirmListener downloadConfirmListener) {
        this.I = downloadConfirmListener;
        v vVar = this.H;
        if (vVar != null && downloadConfirmListener != null) {
            String e02 = vVar.e0();
            d1.a("setDownloadConfirmListener fsd trace id:" + e02 + " listener:" + downloadConfirmListener, new Object[0]);
            j.b().a(e02, downloadConfirmListener);
            return;
        }
        GDTLogger.e("setDownloadConfirmListener\u9519\u8bef\u5e7f\u544a\u6570\u636e\u6216listener\u4e3a\u7a7a");
    }

    @Override // com.qq.e.comm.plugin.gdtnativead.g, com.qq.e.comm.pi.NEADI
    public void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions) {
        this.J = serverSideVerificationOptions;
    }

    @Override // com.qq.e.comm.plugin.intersitial2.h
    protected void w() {
        if (this.O != null) {
            return;
        }
        synchronized (this) {
            if (this.O != null) {
                return;
            }
            int a4 = com.qq.e.comm.plugin.t.c.a("ifcasi", g.UNIFIED_INTERSTITIAL_FULLSCREEN.b(), l(), 3);
            com.qq.e.comm.plugin.g0.l0.c<v> a5 = com.qq.e.comm.plugin.g0.l0.c.a(l(), this.f43793w, g.UNIFIED_INTERSTITIAL_FULLSCREEN);
            a5.a(TextUtils.isEmpty(n()) && a4 > 0 && com.qq.e.comm.plugin.edgeanalytics.e.d(g.UNIFIED_INTERSTITIAL_FULLSCREEN)).a(a4).b(com.qq.e.comm.plugin.t.c.a("ifreti", g.UNIFIED_INTERSTITIAL_FULLSCREEN.b(), l(), 250));
            this.O = a5;
        }
    }

    public l z() {
        return this.f43780j;
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class b implements c.h<v> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AtomicLong f44485a;

        b(AtomicLong atomicLong) {
            this.f44485a = atomicLong;
        }

        @Override // com.qq.e.comm.plugin.g0.l0.c.h
        /* renamed from: b */
        public v a(JSONObject jSONObject) {
            return (v) a.U.a(a.this.i(), a.this.l(), a.this.n(), a.this.b(), a.this.c(), jSONObject, a.this.z());
        }

        @Override // com.qq.e.comm.plugin.g0.l0.c.h
        public void a(v vVar) {
            vVar.h(this.f44485a.get());
            a.this.a(vVar);
        }

        @Override // com.qq.e.comm.plugin.g0.l0.c.h
        public void a(com.qq.e.comm.plugin.s.b bVar) {
            a.this.b(bVar.a());
        }
    }

    private void b(v vVar) {
        this.H = vVar;
        vVar.d(System.currentTimeMillis());
        if (vVar.i0() != null) {
            com.qq.e.comm.plugin.n0.v.a(9411011, com.qq.e.comm.plugin.n0.c.a(vVar), Integer.valueOf(vVar.Z0() ? 2 : 1));
        }
        this.f44484L = false;
        try {
            String c4 = com.qq.e.comm.plugin.d0.a.d().f().c("videoOptions", this.H.q0());
            if (c4 == null) {
                c4 = "{}";
            }
            this.M = true ^ new JSONObject(c4).optBoolean("autoPlayMuted", false);
        } catch (Exception e4) {
            d1.a("Get video options error: " + e4.getMessage());
        }
        p0.a((Runnable) new c(vVar));
        this.f43794x = System.currentTimeMillis();
        com.qq.e.comm.plugin.t.c.d().a(vVar, g.UNIFIED_INTERSTITIAL_FULLSCREEN.b(), "ifcasi", 3).a(vVar, g.UNIFIED_INTERSTITIAL_FULLSCREEN.b(), "ifreti", 250).a(this.H, g.UNIFIED_INTERSTITIAL_FULLSCREEN.b(), "iaraci", 0).a();
    }

    @Override // com.qq.e.comm.plugin.intersitial2.h, com.qq.e.comm.plugin.gdtnativead.g
    public g c() {
        return T;
    }

    @Override // com.qq.e.comm.plugin.intersitial2.h
    /* renamed from: d */
    public v u() {
        return this.H;
    }

    @Override // com.qq.e.comm.plugin.intersitial2.j.b
    public ServerSideVerificationOptions f() {
        return this.J;
    }

    @Override // com.qq.e.comm.plugin.h.f
    public com.qq.e.comm.plugin.h.e g() {
        return this.N;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(v vVar) {
        this.f43793w = com.qq.e.comm.plugin.n0.c.a(vVar);
        this.S = com.qq.e.comm.plugin.util.c.b(vVar);
        if (!vVar.a1()) {
            GDTLogger.e("\u5e7f\u544a\u6837\u5f0f\u6821\u9a8c\u5931\u8d25\uff1a\u63d2\u5c4f\u5168\u5c4f\u5e7f\u544a\u4f7f\u7528\u4e86\u63d2\u5c4f\u534a\u5c4f\u7684\u5e7f\u544a\u4f4d");
            b(5010);
            com.qq.e.comm.plugin.l0.e.a(5010, this.f43793w, 1);
            return;
        }
        com.qq.e.comm.plugin.l0.e.b(this.f43793w, 1);
        this.f44484L = false;
        b(vVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(v vVar, boolean z3) {
        String L0 = vVar.L0();
        File c4 = b1.c(L0);
        String a4 = com.qq.e.comm.plugin.p0.e.a().a(L0);
        if (!this.f44484L && !z3 && !TextUtils.isEmpty(a4) && com.qq.e.comm.plugin.util.v2.a.a(this.H.H())) {
            this.f43781k.onADEvent(new ADEvent(201, new Object[0]));
            this.f44484L = true;
            if (this.K) {
                return;
            }
            this.f43781k.onADEvent(new ADEvent(109, new Object[0]));
        } else if (c4 == null || !c4.exists()) {
            com.qq.e.comm.plugin.fs.e.f.a().a(L0, a4, new d(z3), vVar, true);
        } else if (z3) {
        } else {
            this.f43781k.onADEvent(new ADEvent(201, new Object[0]));
            if (this.K) {
                return;
            }
            this.f43781k.onADEvent(new ADEvent(109, new Object[0]));
        }
    }
}

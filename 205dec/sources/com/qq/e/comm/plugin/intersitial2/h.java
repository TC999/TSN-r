package com.qq.e.comm.plugin.intersitial2;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.qq.e.ads.nativ.ADSize;
import com.qq.e.ads.nativ.NativeExpressADView;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.compliance.DownloadConfirmListener;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.plugin.b.l;
import com.qq.e.comm.plugin.b.m;
import com.qq.e.comm.plugin.g0.l0.c;
import com.qq.e.comm.plugin.g0.l0.f.c;
import com.qq.e.comm.plugin.g0.q;
import com.qq.e.comm.plugin.gdtnativead.m;
import com.qq.e.comm.plugin.util.b1;
import com.qq.e.comm.plugin.util.d1;
import com.qq.e.comm.plugin.util.p0;
import com.qq.e.comm.util.GDTLogger;
import java.io.File;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class h extends com.qq.e.comm.plugin.gdtnativead.g implements com.qq.e.comm.plugin.e0.b, d {
    private com.qq.e.comm.plugin.z.c A;
    private com.qq.e.comm.plugin.z.c B;
    private volatile com.qq.e.comm.plugin.g0.l0.c<q> C;
    protected boolean D;
    private LoadAdParams E;
    private m F;
    private com.qq.e.comm.plugin.l0.b G;

    /* renamed from: y  reason: collision with root package name */
    private com.qq.e.comm.plugin.g0.e f44478y;

    /* renamed from: z  reason: collision with root package name */
    private com.qq.e.comm.plugin.intersitial2.a f44479z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class b implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ com.qq.e.comm.plugin.g0.e f44482c;

        b(com.qq.e.comm.plugin.g0.e eVar) {
            this.f44482c = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f44482c.l1()) {
                File c4 = b1.c(this.f44482c.L0());
                if ((c4 == null || !c4.exists()) && h.this.f44479z != null) {
                    h.this.f44479z.onADEvent(new ADEvent(211, new Object[0]));
                }
            }
        }
    }

    static {
        com.qq.e.comm.plugin.dl.i.a().b(com.qq.e.comm.plugin.b.g.UNIFIED_INTERSTITIAL);
    }

    public h(Context context, ADSize aDSize, String str, String str2, String str3, l lVar, ADListener aDListener) {
        this(context, aDSize, str, str2, str3, lVar, aDListener, com.qq.e.comm.plugin.b.g.UNIFIED_INTERSTITIAL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.qq.e.comm.plugin.z.c s() {
        return new com.qq.e.comm.plugin.z.c(j(), i(), l(), n(), new c(this.f44479z.e(), this.f44479z.c()));
    }

    private Activity t() {
        Context j4 = j();
        if (j4 instanceof Activity) {
            return (Activity) j4;
        }
        return null;
    }

    private void v() {
        int a4 = com.qq.e.comm.plugin.t.c.a("ihcasi", com.qq.e.comm.plugin.b.g.UNIFIED_INTERSTITIAL.b(), this.f43776f, 6);
        int a5 = com.qq.e.comm.plugin.t.c.a("ihreti", com.qq.e.comm.plugin.b.g.UNIFIED_INTERSTITIAL.b(), this.f43776f, 300);
        boolean z3 = TextUtils.isEmpty(this.f43777g) && a4 > 0 && com.qq.e.comm.plugin.edgeanalytics.e.d(com.qq.e.comm.plugin.b.g.UNIFIED_INTERSTITIAL);
        com.qq.e.comm.plugin.g0.l0.c<q> a6 = com.qq.e.comm.plugin.g0.l0.c.a(this.f43776f, this.f43793w, com.qq.e.comm.plugin.b.g.UNIFIED_INTERSTITIAL);
        a6.a(z3).a(a4).b(a5);
        this.C = a6;
    }

    private void x() {
        if (this.f44478y instanceof q) {
            this.C.a((com.qq.e.comm.plugin.g0.l0.c<q>) ((q) this.f44478y), a(this.f43782l), this.G, this.F, (c.f) null, this.f43793w);
        }
        this.C.b(a(this.f43782l), this.G, this.F, this.f43793w);
    }

    @Override // com.qq.e.comm.plugin.intersitial2.d
    public void close() {
        com.qq.e.comm.plugin.z.c cVar = this.B;
        if (cVar != null) {
            cVar.close();
        }
    }

    public void destroy() {
        com.qq.e.comm.plugin.z.c cVar = this.B;
        if (cVar != null) {
            cVar.destroy();
        }
    }

    public int getAdPatternType() {
        com.qq.e.comm.plugin.z.c cVar = this.A;
        if (cVar != null) {
            return cVar.getAdPatternType();
        }
        return 0;
    }

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public String getApkInfoUrl() {
        com.qq.e.comm.plugin.z.c cVar = this.A;
        return cVar != null ? cVar.getApkInfoUrl() : "";
    }

    @Override // com.qq.e.comm.plugin.gdtnativead.g, com.qq.e.comm.plugin.e0.a
    public String[] getCompetitionFailureUrls() {
        com.qq.e.comm.plugin.z.c cVar = this.A;
        return cVar != null ? cVar.getCompetitionFailureUrls() : new String[0];
    }

    @Override // com.qq.e.comm.plugin.gdtnativead.g, com.qq.e.comm.plugin.e0.a
    public String[] getCompetitionWinUrls() {
        com.qq.e.comm.plugin.z.c cVar = this.A;
        return cVar != null ? cVar.getCompetitionWinUrls() : new String[0];
    }

    @Override // com.qq.e.comm.plugin.gdtnativead.g, com.qq.e.comm.plugin.e0.b
    public int getMediationPrice() {
        return super.getMediationPrice();
    }

    public int getVideoDuration() {
        com.qq.e.comm.plugin.z.c cVar = this.A;
        if (cVar != null) {
            return cVar.getVideoDuration();
        }
        return 0;
    }

    @Override // com.qq.e.comm.plugin.gdtnativead.g, com.qq.e.comm.pi.NEADI
    public void loadAd(int i4) {
        w();
        f(i4);
    }

    @Override // com.qq.e.comm.plugin.gdtnativead.g
    public boolean o() {
        return super.o();
    }

    @Override // com.qq.e.comm.plugin.gdtnativead.g
    public boolean p() {
        return this.D;
    }

    @Override // com.qq.e.comm.plugin.intersitial2.d
    public boolean r() {
        com.qq.e.comm.plugin.z.c cVar = this.A;
        if (cVar != null) {
            return cVar.r();
        }
        return false;
    }

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public void setDownloadConfirmListener(DownloadConfirmListener downloadConfirmListener) {
        com.qq.e.comm.plugin.z.c cVar = this.A;
        if (cVar != null) {
            cVar.setDownloadConfirmListener(downloadConfirmListener);
        }
    }

    public void setLoadAdParams(LoadAdParams loadAdParams) {
        this.E = loadAdParams;
    }

    public void show() {
        Activity t3 = t();
        if (t3 == null) {
            GDTLogger.e("\u6784\u9020\u63d2\u5c4f\u5e7f\u544a\u65f6\u7684Activity\u5df2\u7ecf\u88ab\u7cfb\u7edf\u56de\u6536\uff0c\u5982\u679c\u9700\u8981\u8de8Activity\u5c55\u793a\u63d2\u5c4f\u5e7f\u544a\u8bf7\u5728show\u65b9\u6cd5\u4e2d\u6307\u5b9aActivity\u53c2\u6570");
        } else {
            show(t3);
        }
    }

    public com.qq.e.comm.plugin.g0.e u() {
        return this.f44478y;
    }

    protected void w() {
        if (this.C != null) {
            return;
        }
        synchronized (this) {
            if (this.C != null) {
                return;
            }
            this.F = new m(this.f43776f, com.qq.e.comm.plugin.b.g.UNIFIED_INTERSTITIAL, (com.qq.e.comm.plugin.b.f) null);
            this.G = new com.qq.e.comm.plugin.l0.b(com.qq.e.comm.plugin.b.g.UNIFIED_INTERSTITIAL, this.f43776f);
            v();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class a implements c.h<q> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AtomicLong f44480a;

        a(AtomicLong atomicLong) {
            this.f44480a = atomicLong;
        }

        @Override // com.qq.e.comm.plugin.g0.l0.c.h
        /* renamed from: b */
        public q a(JSONObject jSONObject) {
            h hVar = h.this;
            h hVar2 = h.this;
            ((com.qq.e.comm.plugin.gdtnativead.g) hVar).f43790t = new com.qq.e.comm.plugin.gdtnativead.m(false, hVar2, hVar2.j(), h.this.i(), ((com.qq.e.comm.plugin.gdtnativead.g) h.this).f43776f, com.qq.e.comm.plugin.b.g.UNIFIED_INTERSTITIAL, ((com.qq.e.comm.plugin.gdtnativead.g) h.this).f43780j, ((com.qq.e.comm.plugin.gdtnativead.g) h.this).f43779i, false, ((com.qq.e.comm.plugin.gdtnativead.g) h.this).f43793w);
            ((com.qq.e.comm.plugin.gdtnativead.g) h.this).f43790t.a(h.this);
            return ((com.qq.e.comm.plugin.gdtnativead.m) ((com.qq.e.comm.plugin.gdtnativead.g) h.this).f43790t).a(jSONObject);
        }

        @Override // com.qq.e.comm.plugin.g0.l0.c.h
        public void a(q qVar) {
            if (qVar == null) {
                h.this.b(5004);
                com.qq.e.comm.plugin.l0.e.a(5004, ((com.qq.e.comm.plugin.gdtnativead.g) h.this).f43793w, 1);
            } else if (!h.this.a(qVar)) {
                List<NativeExpressADView> b4 = ((com.qq.e.comm.plugin.gdtnativead.m) ((com.qq.e.comm.plugin.gdtnativead.g) h.this).f43790t).b();
                m.d a4 = ((com.qq.e.comm.plugin.gdtnativead.m) ((com.qq.e.comm.plugin.gdtnativead.g) h.this).f43790t).a();
                if (b4.isEmpty() || a4 == null) {
                    h.this.b(6000);
                    return;
                }
                h hVar = h.this;
                hVar.A = hVar.s();
                if (h.this.A.a(a4, false)) {
                    com.qq.e.comm.plugin.l0.e.b(((com.qq.e.comm.plugin.gdtnativead.g) h.this).f43793w, 1);
                    qVar.h(this.f44480a.get());
                    qVar.d(System.currentTimeMillis());
                    h.this.a(qVar, b4);
                    return;
                }
                h.this.b(6000);
            } else {
                h.this.b(5010);
            }
        }

        @Override // com.qq.e.comm.plugin.g0.l0.c.h
        public void a(com.qq.e.comm.plugin.s.b bVar) {
            d1.a("LoadGDTNativeExpressADFail", bVar);
            h.this.b(bVar.a());
        }
    }

    public h(Context context, ADSize aDSize, String str, String str2, String str3, l lVar, ADListener aDListener, com.qq.e.comm.plugin.b.g gVar) {
        super(context, aDSize, str, str2, lVar, aDListener, str3, gVar);
        this.D = false;
        if (aDListener instanceof com.qq.e.comm.plugin.intersitial2.a) {
            this.f44479z = (com.qq.e.comm.plugin.intersitial2.a) aDListener;
        }
    }

    private void f(int i4) {
        this.f44478y = null;
        this.f43782l = i4;
        this.C.a(a(i4, this.E), this.G, this.F, this.f43793w, new a(new AtomicLong(System.currentTimeMillis())));
    }

    public com.qq.e.comm.plugin.n0.c m() {
        return this.f43793w;
    }

    private void b(com.qq.e.comm.plugin.g0.e eVar) {
        p0.a((Runnable) new b(eVar));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.comm.plugin.gdtnativead.g
    public com.qq.e.comm.plugin.b.g c() {
        return com.qq.e.comm.plugin.b.g.UNIFIED_INTERSTITIAL;
    }

    public void loadAd() {
        com.qq.e.comm.plugin.intersitial2.a aVar = this.f44479z;
        if (aVar != null) {
            aVar.b();
        }
        loadAd(com.qq.e.comm.plugin.d0.a.d().f().a("ilat", com.qq.e.comm.plugin.b.g.UNIFIED_INTERSTITIAL.a()));
    }

    protected boolean a(com.qq.e.comm.plugin.g0.e eVar) {
        if (this.f43773c.h() && eVar.a1()) {
            GDTLogger.e("\u5e7f\u544a\u6837\u5f0f\u6821\u9a8c\u5931\u8d25\uff1a\u63d2\u5c4f\u534a\u5c4f\u5e7f\u544a\u4f7f\u7528\u4e86\u63d2\u5c4f\u5168\u5c4f\u7684\u5e7f\u544a\u4f4d");
            com.qq.e.comm.plugin.l0.e.a(5010, this.f43793w, 1);
            return true;
        }
        return false;
    }

    public void show(Activity activity) {
        com.qq.e.comm.plugin.z.c cVar = this.A;
        if (cVar != null) {
            this.B = cVar;
            cVar.show(activity);
            x();
        }
    }

    @Override // com.qq.e.comm.plugin.gdtnativead.g
    protected void a(com.qq.e.comm.plugin.b.d dVar) {
        dVar.a(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.qq.e.comm.plugin.g0.e eVar, List<NativeExpressADView> list) {
        this.f44478y = eVar;
        this.f43793w = com.qq.e.comm.plugin.n0.c.a(eVar);
        a(list, this.f44478y);
        b(eVar);
        com.qq.e.comm.plugin.t.c.d().a(eVar, com.qq.e.comm.plugin.b.g.UNIFIED_INTERSTITIAL.b(), "ihcasi", 6).a(eVar, com.qq.e.comm.plugin.b.g.UNIFIED_INTERSTITIAL.b(), "ihreti", 300).a(eVar, com.qq.e.comm.plugin.b.g.UNIFIED_INTERSTITIAL.b(), "iaraci", 0).a();
    }
}

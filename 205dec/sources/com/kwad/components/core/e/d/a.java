package com.kwad.components.core.e.d;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.components.core.page.AdWebViewVideoActivityProxy;
import com.kwad.components.core.webview.tachikoma.a.k;
import com.kwad.sdk.core.adlog.a;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.track.AdTrackLog;
import com.kwad.sdk.n.l;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ac;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class a {
    private static List<WeakReference<k.b>> Kq;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* renamed from: com.kwad.components.core.e.d.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class C0631a {
        private boolean KA;
        private boolean KB;
        private long KC;
        private boolean KD;
        private boolean KE;
        public String KG;
        public a.C0688a KH;
        private JSONObject KK;
        private boolean KM;
        private int KN;
        private int KO;
        private int KP;
        private int KQ;
        private Callable<String> KR;
        private String KS;
        private boolean Kr;
        private boolean Ks;
        private boolean Kt;
        private boolean Ku;
        private boolean Kv;
        private boolean Kw;
        private boolean Kx;
        private b Ky;
        private c Kz;
        private AdTemplate adTemplate;
        private final Context context;
        private int kj;
        private int kl;
        public ac.a kn;
        public long vz;
        public int KF = -1;
        public int KI = 0;
        public int KJ = -1;
        private boolean KL = false;

        public C0631a(Context context) {
            this.context = context;
        }

        public final C0631a a(@Nullable Callable<String> callable) {
            this.KR = callable;
            return this;
        }

        public final C0631a af(String str) {
            this.KS = str;
            return this;
        }

        public final C0631a ag(String str) {
            this.KG = str;
            return this;
        }

        public final void ak(boolean z3) {
            this.KB = true;
        }

        public final C0631a al(int i4) {
            this.KQ = i4;
            return this;
        }

        public final C0631a am(int i4) {
            this.kl = i4;
            return this;
        }

        public final C0631a an(boolean z3) {
            this.Kv = true;
            return this;
        }

        public final C0631a ao(boolean z3) {
            this.KA = z3;
            return this;
        }

        public final C0631a ap(boolean z3) {
            this.KD = z3;
            return this;
        }

        public final C0631a aq(AdTemplate adTemplate) {
            this.adTemplate = adTemplate;
            return this;
        }

        public final C0631a ar(boolean z3) {
            this.KL = z3;
            return this;
        }

        public final C0631a as(boolean z3) {
            this.Ks = z3;
            return this;
        }

        public final C0631a at(boolean z3) {
            this.Ku = true;
            return this;
        }

        public final C0631a au(boolean z3) {
            this.Kr = z3;
            return this;
        }

        public final C0631a av(boolean z3) {
            this.KM = z3;
            return this;
        }

        public final C0631a aw(boolean z3) {
            this.Kt = true;
            return this;
        }

        public final C0631a b(c cVar) {
            this.Kz = cVar;
            return this;
        }

        public final C0631a c(JSONObject jSONObject) {
            this.KK = jSONObject;
            return this;
        }

        public final int cU() {
            return this.kj;
        }

        public final int cX() {
            return this.kl;
        }

        public final C0631a d(ac.a aVar) {
            this.kn = aVar;
            return this;
        }

        public final c gZ() {
            return this.Kz;
        }

        public final AdTemplate getAdTemplate() {
            return this.adTemplate;
        }

        public final Context getContext() {
            return this.context;
        }

        public final JSONObject hn() {
            return this.KK;
        }

        public final boolean nA() {
            return this.KB;
        }

        public final int nB() {
            return this.KO;
        }

        public final b nC() {
            return this.Ky;
        }

        public final boolean nD() {
            return this.Kv;
        }

        public final int nE() {
            return this.KQ;
        }

        public final boolean nF() {
            return this.Kw;
        }

        public final boolean nG() {
            return this.Kx;
        }

        public final boolean nH() {
            return this.KA;
        }

        public final long nI() {
            return this.KC;
        }

        public final boolean nJ() {
            return this.KD;
        }

        public final boolean nK() {
            return this.KE;
        }

        public final com.kwad.sdk.core.adlog.c.a nL() {
            return com.kwad.sdk.core.adlog.c.a.Br().cE(this.kl).dc(this.KG).e(this.kn).cF(this.KI).cG(this.KJ).af(this.vz).a(this.KH).cH(this.KF);
        }

        public final boolean nM() {
            return this.KL;
        }

        public final boolean nN() {
            return this.Ks;
        }

        public final boolean nO() {
            return this.Ku;
        }

        public final boolean nP() {
            return this.Kr;
        }

        public final boolean nQ() {
            return this.KM;
        }

        public final int nR() {
            return this.KN;
        }

        public final int nS() {
            return this.KP;
        }

        public final boolean nT() {
            return this.Kt;
        }

        public final String ny() {
            return this.KS;
        }

        public final Callable<String> nz() {
            return this.KR;
        }

        public final C0631a v(long j4) {
            this.KC = j4;
            return this;
        }

        public final C0631a w(long j4) {
            this.vz = j4;
            return this;
        }

        public final C0631a a(b bVar) {
            this.Ky = bVar;
            return this;
        }

        public final void ak(int i4) {
            this.KO = i4;
        }

        public final C0631a al(boolean z3) {
            this.Kw = z3;
            return this;
        }

        public final C0631a am(boolean z3) {
            this.Kx = true;
            return this;
        }

        public final C0631a an(int i4) {
            this.kj = i4;
            return this;
        }

        public final C0631a ao(int i4) {
            this.KI = i4;
            return this;
        }

        public final C0631a ap(int i4) {
            this.KJ = i4;
            return this;
        }

        public final C0631a aq(boolean z3) {
            this.KE = z3;
            return this;
        }

        public final C0631a ar(int i4) {
            this.KP = i4;
            return this;
        }

        public final C0631a a(String str, String str2, com.kwad.sdk.g.a<AdTrackLog> aVar) {
            if (this.KH == null) {
                this.KH = new a.C0688a();
            }
            this.KH.a(this.adTemplate, null, null, null);
            return this;
        }

        public final C0631a aq(int i4) {
            this.KN = i4;
            return this;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public interface b {
        void onAdClicked();
    }

    public static int a(@NonNull Context context, @NonNull AdTemplate adTemplate, @NonNull b bVar, @Nullable c cVar, boolean z3, boolean z4, boolean z5, boolean z6) {
        com.kwad.sdk.commercial.d.a.f(adTemplate, true);
        adTemplate.converted = true;
        boolean z7 = false;
        d.ax(false);
        AdInfo dQ = com.kwad.sdk.core.response.b.e.dQ(adTemplate);
        com.kwad.sdk.components.c.f(com.kwad.components.a.a.a.class);
        C0631a ar = new C0631a(context).aq(adTemplate).a(bVar).b(cVar).ao(z3).ap(z4).al(z6).ar(false);
        int an = com.kwad.sdk.core.response.b.a.an(dQ);
        if (!((z5 || ar.nS() == 2 || ar.nS() == 1) ? true : true) && !TextUtils.isEmpty(com.kwad.sdk.core.response.b.a.aS(dQ)) && !ar.nO()) {
            if (an == 1) {
                if (com.kwad.sdk.core.response.b.a.bh(dQ)) {
                    return k(ar);
                }
                return l(ar);
            } else if (an == 2) {
                int h4 = h(ar);
                if (h4 == 1) {
                    return 13;
                }
                if (h4 == 2) {
                    return 16;
                }
                if (com.kwad.sdk.core.response.b.a.bh(dQ)) {
                    return k(ar);
                }
                return l(ar);
            }
        }
        int h5 = h(ar);
        if (h5 == 1) {
            return 13;
        }
        if (h5 == 2) {
            return 16;
        }
        if (!com.kwad.sdk.core.response.b.a.aF(dQ)) {
            if (j(ar)) {
                return 11;
            }
            return l(ar);
        }
        int m4 = m(ar);
        int i4 = dQ.status;
        if (i4 != 2 && i4 != 3) {
            e(ar);
        }
        return m4;
    }

    private static int b(C0631a c0631a) {
        Context context = c0631a.getContext();
        AdTemplate adTemplate = c0631a.getAdTemplate();
        AdInfo dQ = com.kwad.sdk.core.response.b.e.dQ(adTemplate);
        Activity dn = l.dn(context);
        if (dn != null && com.kwad.sdk.core.response.b.a.V(dQ) && !c0631a.nA() && !c0631a.nF()) {
            c0631a.ak(2);
            com.kwad.components.core.e.e.e.a(dn, c0631a);
            d(adTemplate, 19);
            return 19;
        }
        AdWebViewActivityProxy.launch(context, new AdWebViewActivityProxy.a.C0642a().at(com.kwad.sdk.core.response.b.b.cB(adTemplate)).as(adTemplate).aD(true).pl());
        d(adTemplate, 20);
        return 20;
    }

    private static boolean c(C0631a c0631a) {
        return com.kwad.sdk.core.response.b.a.aF(com.kwad.sdk.core.response.b.e.dQ(c0631a.getAdTemplate())) ? !c0631a.nQ() && c.A(c0631a) == 3 : d(c0631a) == 1;
    }

    private static int d(C0631a c0631a) {
        AdInfo dQ = com.kwad.sdk.core.response.b.e.dQ(c0631a.getAdTemplate());
        if (dQ.unDownloadConf.unDownloadRegionConf != null) {
            int cU = c0631a.cU();
            if (cU != 2) {
                if (cU != 3) {
                    return dQ.unDownloadConf.unDownloadRegionConf.actionBarType;
                }
                return dQ.unDownloadConf.unDownloadRegionConf.materialJumpType;
            }
            return dQ.unDownloadConf.unDownloadRegionConf.describeBarType;
        }
        return 0;
    }

    private static void e(C0631a c0631a) {
        if (c0631a.nA()) {
            return;
        }
        g(c0631a);
        f(c0631a);
        if (c0631a.nC() != null) {
            try {
                c0631a.nC().onAdClicked();
            } catch (Throwable th) {
                ServiceProvider.reportSdkCaughtException(th);
            }
        }
        com.kwad.sdk.commercial.d.a.bc(c0631a.getAdTemplate());
    }

    private static void f(C0631a c0631a) {
        if (c0631a.nK()) {
            com.kwad.sdk.core.adlog.c.a(c0631a.adTemplate, c0631a.nL(), c0631a.hn());
        }
    }

    private static void g(C0631a c0631a) {
        k.b bVar;
        List<WeakReference<k.b>> list = Kq;
        if (list == null || list.isEmpty() || c0631a.adTemplate == null) {
            return;
        }
        for (WeakReference<k.b> weakReference : Kq) {
            if (weakReference != null && (bVar = weakReference.get()) != null) {
                bVar.L(com.kwad.sdk.core.response.b.e.ea(c0631a.adTemplate));
            }
        }
    }

    private static int h(C0631a c0631a) {
        AdTemplate adTemplate = c0631a.getAdTemplate();
        AdInfo dQ = com.kwad.sdk.core.response.b.e.dQ(adTemplate);
        int a4 = d.a(c0631a, 1);
        if (a4 == 1) {
            d.ax(true);
            e(c0631a);
            if ((com.kwad.sdk.core.response.b.a.cK(dQ) || com.kwad.sdk.core.response.b.a.cL(dQ)) && !c0631a.nT()) {
                com.kwad.sdk.core.adlog.c.m(c0631a.getAdTemplate(), (int) Math.ceil(((float) c0631a.nI()) / 1000.0f));
            }
            d(adTemplate, 13);
        } else if (a4 == 2) {
            e(c0631a);
            d(adTemplate, 16);
        }
        return a4;
    }

    private static int i(C0631a c0631a) {
        Context context = c0631a.getContext();
        AdTemplate adTemplate = c0631a.getAdTemplate();
        AdInfo dQ = com.kwad.sdk.core.response.b.e.dQ(c0631a.getAdTemplate());
        Activity dn = l.dn(c0631a.getContext());
        if (dn != null && com.kwad.sdk.core.response.b.a.U(dQ) && !c0631a.nA() && e.E(dQ) && !c0631a.nF()) {
            c0631a.ak(1);
            com.kwad.components.core.e.e.e.a(dn, c0631a);
            e(c0631a);
            d(adTemplate, 17);
            return 2;
        }
        int d4 = e.d(context, adTemplate);
        if (d4 == 1) {
            e(c0631a);
            d(adTemplate, 12);
        }
        return d4;
    }

    private static boolean j(C0631a c0631a) {
        AdTemplate adTemplate = c0631a.getAdTemplate();
        boolean h4 = com.kwad.sdk.utils.d.h(c0631a.getContext(), adTemplate);
        if (h4) {
            e(c0631a);
            com.kwad.sdk.core.adlog.c.k(adTemplate, 0);
            d(adTemplate, 11);
        }
        return h4;
    }

    private static int k(C0631a c0631a) {
        e(c0631a);
        AdTemplate adTemplate = c0631a.getAdTemplate();
        AdInfo dQ = com.kwad.sdk.core.response.b.e.dQ(c0631a.getAdTemplate());
        Activity dn = l.dn(c0631a.getContext());
        if (dn != null && com.kwad.sdk.core.response.b.a.V(dQ) && !c0631a.nA() && !c0631a.nF()) {
            c0631a.ak(2);
            com.kwad.components.core.e.e.e.a(dn, c0631a);
            d(adTemplate, 19);
            return 19;
        }
        AdWebViewVideoActivityProxy.launch(c0631a.getContext(), adTemplate);
        d(adTemplate, 15);
        return 15;
    }

    private static int l(C0631a c0631a) {
        e(c0631a);
        Context context = c0631a.getContext();
        AdTemplate adTemplate = c0631a.getAdTemplate();
        AdInfo dQ = com.kwad.sdk.core.response.b.e.dQ(adTemplate);
        Activity dn = l.dn(context);
        if (dn != null && com.kwad.sdk.core.response.b.a.V(dQ) && !c0631a.nA() && !c0631a.nF()) {
            c0631a.ak(2);
            com.kwad.components.core.e.e.e.a(dn, c0631a);
            d(adTemplate, 19);
            return 19;
        }
        AdWebViewActivityProxy.launch(context, new AdWebViewActivityProxy.a.C0642a().at(com.kwad.sdk.core.response.b.b.cB(adTemplate)).as(adTemplate).aE(c0631a.nD()).az(1).pl());
        d(adTemplate, 14);
        return 14;
    }

    private static int m(C0631a c0631a) {
        c gZ = c0631a.gZ();
        if (gZ == null) {
            gZ = new c(c0631a.adTemplate);
            c0631a.b(gZ);
        }
        int r3 = gZ.r(c0631a);
        d(c0631a.getAdTemplate(), r3);
        return r3;
    }

    private static int n(C0631a c0631a) {
        AdTemplate adTemplate = c0631a.getAdTemplate();
        AdInfo dQ = com.kwad.sdk.core.response.b.e.dQ(adTemplate);
        if (j(c0631a)) {
            return 11;
        }
        if (com.kwad.sdk.core.response.b.a.b(dQ, com.kwad.sdk.core.config.d.BS()) && !adTemplate.mAdWebVideoPageShowing) {
            return k(c0631a);
        }
        return l(c0631a);
    }

    private static void d(AdTemplate adTemplate, int i4) {
        switch (i4) {
            case 0:
                com.kwad.sdk.commercial.d.a.bs(adTemplate);
                return;
            case 1:
                com.kwad.sdk.commercial.d.a.bh(adTemplate);
                return;
            case 2:
                com.kwad.sdk.commercial.d.a.br(adTemplate);
                return;
            case 3:
                com.kwad.sdk.commercial.d.a.bj(adTemplate);
                return;
            case 4:
                com.kwad.sdk.commercial.d.a.bp(adTemplate);
                return;
            case 5:
                com.kwad.sdk.commercial.d.a.bq(adTemplate);
                return;
            case 6:
                com.kwad.sdk.commercial.d.a.bk(adTemplate);
                return;
            case 7:
                com.kwad.sdk.commercial.d.a.bl(adTemplate);
                return;
            case 8:
                com.kwad.sdk.commercial.d.a.bm(adTemplate);
                return;
            case 9:
                com.kwad.sdk.commercial.d.a.bo(adTemplate);
                return;
            case 10:
                com.kwad.sdk.commercial.d.a.bn(adTemplate);
                return;
            case 11:
                com.kwad.sdk.commercial.d.a.bg(adTemplate);
                return;
            case 12:
                com.kwad.sdk.commercial.d.a.bf(adTemplate);
                return;
            case 13:
                com.kwad.sdk.commercial.d.a.be(adTemplate);
                return;
            case 14:
                com.kwad.sdk.commercial.d.a.bd(adTemplate);
                return;
            case 15:
                com.kwad.sdk.commercial.d.a.bi(adTemplate);
                return;
            case 16:
                com.kwad.sdk.commercial.d.a.bu(adTemplate);
                return;
            case 17:
                com.kwad.sdk.commercial.d.a.bx(adTemplate);
                return;
            case 18:
                com.kwad.sdk.commercial.d.a.bt(adTemplate);
                return;
            case 19:
                com.kwad.sdk.commercial.d.a.bv(adTemplate);
                return;
            case 20:
                com.kwad.sdk.commercial.d.a.bw(adTemplate);
                return;
            default:
                return;
        }
    }

    public static void b(k.b bVar) {
        if (Kq == null) {
            return;
        }
        int i4 = 0;
        while (true) {
            if (i4 >= Kq.size()) {
                i4 = -1;
                break;
            }
            WeakReference<k.b> weakReference = Kq.get(i4);
            if (weakReference != null && weakReference.get() != null && bVar == weakReference.get()) {
                break;
            }
            i4++;
        }
        if (i4 != -1) {
            Kq.remove(i4);
        }
    }

    public static int a(C0631a c0631a) {
        Context context = c0631a.getContext();
        AdTemplate adTemplate = c0631a.getAdTemplate();
        AdInfo dQ = com.kwad.sdk.core.response.b.e.dQ(adTemplate);
        d.ax(false);
        if (c0631a.nG()) {
            return b(c0631a);
        }
        if (c0631a.nP()) {
            return a(context, adTemplate, c0631a.nC(), c0631a.gZ(), c0631a.KA, c0631a.nJ(), false, c0631a.nF());
        }
        com.kwad.sdk.commercial.d.a.f(adTemplate, false);
        if (c(c0631a)) {
            d(adTemplate, 1);
            return 1;
        }
        adTemplate.converted = true;
        com.kwad.sdk.components.c.f(com.kwad.components.a.a.a.class);
        int an = com.kwad.sdk.core.response.b.a.an(dQ);
        if (!(c0631a.nS() == 2 || c0631a.nS() == 1) && !TextUtils.isEmpty(com.kwad.sdk.core.response.b.a.aS(dQ)) && !c0631a.nO()) {
            if (an == 1) {
                if (com.kwad.sdk.core.response.b.a.bh(dQ)) {
                    return k(c0631a);
                }
                return l(c0631a);
            } else if (an == 2) {
                int h4 = h(c0631a);
                if (h4 == 1) {
                    return 13;
                }
                if (h4 == 2) {
                    return 16;
                }
                if (com.kwad.sdk.core.response.b.a.bh(dQ)) {
                    return k(c0631a);
                }
                return l(c0631a);
            }
        }
        int h5 = h(c0631a);
        if (h5 == 1) {
            return 13;
        }
        if (h5 == 2) {
            return 16;
        }
        int i4 = i(c0631a);
        if (i4 == 1) {
            return 12;
        }
        if (i4 == 2) {
            return 17;
        }
        if (c0631a.nN() && !com.kwad.sdk.core.response.b.a.aF(dQ)) {
            return n(c0631a);
        }
        if (!com.kwad.sdk.core.response.b.a.aF(dQ)) {
            if (adTemplate.isWebViewDownload) {
                return m(c0631a);
            }
            if (j(c0631a)) {
                return 11;
            }
            return l(c0631a);
        } else if (c0631a.nS() != 2 && c0631a.nS() != 1) {
            if (c0631a.nN() && com.kwad.sdk.core.response.b.a.b(dQ, com.kwad.sdk.core.config.d.BS()) && !TextUtils.isEmpty(com.kwad.sdk.core.response.b.a.aS(dQ)) && !AdWebViewVideoActivityProxy.showingAdWebViewVideoActivity) {
                int q3 = c0631a.gZ().q(c0631a);
                if (q3 == 0) {
                    return k(c0631a);
                }
                e(c0631a);
                d(adTemplate, q3);
                return q3;
            }
            e(c0631a);
            c0631a.ar(true);
            return m(c0631a);
        } else {
            c0631a.ar(false);
            e(c0631a);
            return m(c0631a);
        }
    }

    public static void a(k.b bVar) {
        if (Kq == null) {
            Kq = new CopyOnWriteArrayList();
        }
        Kq.add(new WeakReference<>(bVar));
    }
}

package com.kwad.components.core.p289e.p293d;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.p289e.p294e.DialogFragmentC8639e;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.components.core.page.AdWebViewVideoActivityProxy;
import com.kwad.components.core.webview.tachikoma.p333a.C9208k;
import com.kwad.components.p206a.p207a.InterfaceC7326a;
import com.kwad.sdk.commercial.p375d.C9826a;
import com.kwad.sdk.components.C9861c;
import com.kwad.sdk.core.adlog.C9893a;
import com.kwad.sdk.core.adlog.C9908c;
import com.kwad.sdk.core.adlog.p388c.C9912a;
import com.kwad.sdk.core.config.C10251d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10484b;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.core.track.AdTrackLog;
import com.kwad.sdk.p434g.InterfaceC10761a;
import com.kwad.sdk.p445n.C10887l;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.C11008ac;
import com.kwad.sdk.utils.C11079d;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* renamed from: com.kwad.components.core.e.d.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8615a {

    /* renamed from: Kq */
    private static List<WeakReference<C9208k.InterfaceC9212b>> f28209Kq;

    /* renamed from: com.kwad.components.core.e.d.a$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C8616a {

        /* renamed from: KA */
        private boolean f28210KA;

        /* renamed from: KB */
        private boolean f28211KB;

        /* renamed from: KC */
        private long f28212KC;

        /* renamed from: KD */
        private boolean f28213KD;

        /* renamed from: KE */
        private boolean f28214KE;

        /* renamed from: KG */
        public String f28216KG;

        /* renamed from: KH */
        public C9893a.C9894a f28217KH;

        /* renamed from: KK */
        private JSONObject f28220KK;

        /* renamed from: KM */
        private boolean f28222KM;

        /* renamed from: KN */
        private int f28223KN;

        /* renamed from: KO */
        private int f28224KO;

        /* renamed from: KP */
        private int f28225KP;

        /* renamed from: KQ */
        private int f28226KQ;

        /* renamed from: KR */
        private Callable<String> f28227KR;

        /* renamed from: KS */
        private String f28228KS;

        /* renamed from: Kr */
        private boolean f28229Kr;

        /* renamed from: Ks */
        private boolean f28230Ks;

        /* renamed from: Kt */
        private boolean f28231Kt;

        /* renamed from: Ku */
        private boolean f28232Ku;

        /* renamed from: Kv */
        private boolean f28233Kv;

        /* renamed from: Kw */
        private boolean f28234Kw;

        /* renamed from: Kx */
        private boolean f28235Kx;

        /* renamed from: Ky */
        private InterfaceC8617b f28236Ky;

        /* renamed from: Kz */
        private C8619c f28237Kz;
        private AdTemplate adTemplate;
        private final Context context;

        /* renamed from: kj */
        private int f28238kj;

        /* renamed from: kl */
        private int f28239kl;

        /* renamed from: kn */
        public C11008ac.C11009a f28240kn;

        /* renamed from: vz */
        public long f28241vz;

        /* renamed from: KF */
        public int f28215KF = -1;

        /* renamed from: KI */
        public int f28218KI = 0;

        /* renamed from: KJ */
        public int f28219KJ = -1;

        /* renamed from: KL */
        private boolean f28221KL = false;

        public C8616a(Context context) {
            this.context = context;
        }

        /* renamed from: a */
        public final C8616a m30214a(@Nullable Callable<String> callable) {
            this.f28227KR = callable;
            return this;
        }

        /* renamed from: af */
        public final C8616a m30213af(String str) {
            this.f28228KS = str;
            return this;
        }

        /* renamed from: ag */
        public final C8616a m30212ag(String str) {
            this.f28216KG = str;
            return this;
        }

        /* renamed from: ak */
        public final void m30210ak(boolean z) {
            this.f28211KB = true;
        }

        /* renamed from: al */
        public final C8616a m30209al(int i) {
            this.f28226KQ = i;
            return this;
        }

        /* renamed from: am */
        public final C8616a m30207am(int i) {
            this.f28239kl = i;
            return this;
        }

        /* renamed from: an */
        public final C8616a m30204an(boolean z) {
            this.f28233Kv = true;
            return this;
        }

        /* renamed from: ao */
        public final C8616a m30202ao(boolean z) {
            this.f28210KA = z;
            return this;
        }

        /* renamed from: ap */
        public final C8616a m30200ap(boolean z) {
            this.f28213KD = z;
            return this;
        }

        /* renamed from: aq */
        public final C8616a m30198aq(AdTemplate adTemplate) {
            this.adTemplate = adTemplate;
            return this;
        }

        /* renamed from: ar */
        public final C8616a m30195ar(boolean z) {
            this.f28221KL = z;
            return this;
        }

        /* renamed from: as */
        public final C8616a m30194as(boolean z) {
            this.f28230Ks = z;
            return this;
        }

        /* renamed from: at */
        public final C8616a m30193at(boolean z) {
            this.f28232Ku = true;
            return this;
        }

        /* renamed from: au */
        public final C8616a m30192au(boolean z) {
            this.f28229Kr = z;
            return this;
        }

        /* renamed from: av */
        public final C8616a m30191av(boolean z) {
            this.f28222KM = z;
            return this;
        }

        /* renamed from: aw */
        public final C8616a m30190aw(boolean z) {
            this.f28231Kt = true;
            return this;
        }

        /* renamed from: b */
        public final C8616a m30189b(C8619c c8619c) {
            this.f28237Kz = c8619c;
            return this;
        }

        /* renamed from: c */
        public final C8616a m30188c(JSONObject jSONObject) {
            this.f28220KK = jSONObject;
            return this;
        }

        /* renamed from: cU */
        public final int m30187cU() {
            return this.f28238kj;
        }

        /* renamed from: cX */
        public final int m30186cX() {
            return this.f28239kl;
        }

        /* renamed from: d */
        public final C8616a m30185d(C11008ac.C11009a c11009a) {
            this.f28240kn = c11009a;
            return this;
        }

        /* renamed from: gZ */
        public final C8619c m30184gZ() {
            return this.f28237Kz;
        }

        public final AdTemplate getAdTemplate() {
            return this.adTemplate;
        }

        public final Context getContext() {
            return this.context;
        }

        /* renamed from: hn */
        public final JSONObject m30183hn() {
            return this.f28220KK;
        }

        /* renamed from: nA */
        public final boolean m30182nA() {
            return this.f28211KB;
        }

        /* renamed from: nB */
        public final int m30181nB() {
            return this.f28224KO;
        }

        /* renamed from: nC */
        public final InterfaceC8617b m30180nC() {
            return this.f28236Ky;
        }

        /* renamed from: nD */
        public final boolean m30179nD() {
            return this.f28233Kv;
        }

        /* renamed from: nE */
        public final int m30178nE() {
            return this.f28226KQ;
        }

        /* renamed from: nF */
        public final boolean m30177nF() {
            return this.f28234Kw;
        }

        /* renamed from: nG */
        public final boolean m30176nG() {
            return this.f28235Kx;
        }

        /* renamed from: nH */
        public final boolean m30175nH() {
            return this.f28210KA;
        }

        /* renamed from: nI */
        public final long m30174nI() {
            return this.f28212KC;
        }

        /* renamed from: nJ */
        public final boolean m30173nJ() {
            return this.f28213KD;
        }

        /* renamed from: nK */
        public final boolean m30172nK() {
            return this.f28214KE;
        }

        /* renamed from: nL */
        public final C9912a m30171nL() {
            return C9912a.m27285Br().m27279cE(this.f28239kl).m27273dc(this.f28216KG).m27271e(this.f28240kn).m27278cF(this.f28218KI).m27277cG(this.f28219KJ).m27282af(this.f28241vz).m27284a(this.f28217KH).m27276cH(this.f28215KF);
        }

        /* renamed from: nM */
        public final boolean m30170nM() {
            return this.f28221KL;
        }

        /* renamed from: nN */
        public final boolean m30169nN() {
            return this.f28230Ks;
        }

        /* renamed from: nO */
        public final boolean m30168nO() {
            return this.f28232Ku;
        }

        /* renamed from: nP */
        public final boolean m30167nP() {
            return this.f28229Kr;
        }

        /* renamed from: nQ */
        public final boolean m30166nQ() {
            return this.f28222KM;
        }

        /* renamed from: nR */
        public final int m30165nR() {
            return this.f28223KN;
        }

        /* renamed from: nS */
        public final int m30164nS() {
            return this.f28225KP;
        }

        /* renamed from: nT */
        public final boolean m30163nT() {
            return this.f28231Kt;
        }

        /* renamed from: ny */
        public final String m30162ny() {
            return this.f28228KS;
        }

        /* renamed from: nz */
        public final Callable<String> m30161nz() {
            return this.f28227KR;
        }

        /* renamed from: v */
        public final C8616a m30158v(long j) {
            this.f28212KC = j;
            return this;
        }

        /* renamed from: w */
        public final C8616a m30157w(long j) {
            this.f28241vz = j;
            return this;
        }

        /* renamed from: a */
        public final C8616a m30216a(InterfaceC8617b interfaceC8617b) {
            this.f28236Ky = interfaceC8617b;
            return this;
        }

        /* renamed from: ak */
        public final void m30211ak(int i) {
            this.f28224KO = i;
        }

        /* renamed from: al */
        public final C8616a m30208al(boolean z) {
            this.f28234Kw = z;
            return this;
        }

        /* renamed from: am */
        public final C8616a m30206am(boolean z) {
            this.f28235Kx = true;
            return this;
        }

        /* renamed from: an */
        public final C8616a m30205an(int i) {
            this.f28238kj = i;
            return this;
        }

        /* renamed from: ao */
        public final C8616a m30203ao(int i) {
            this.f28218KI = i;
            return this;
        }

        /* renamed from: ap */
        public final C8616a m30201ap(int i) {
            this.f28219KJ = i;
            return this;
        }

        /* renamed from: aq */
        public final C8616a m30197aq(boolean z) {
            this.f28214KE = z;
            return this;
        }

        /* renamed from: ar */
        public final C8616a m30196ar(int i) {
            this.f28225KP = i;
            return this;
        }

        /* renamed from: a */
        public final C8616a m30215a(String str, String str2, InterfaceC10761a<AdTrackLog> interfaceC10761a) {
            if (this.f28217KH == null) {
                this.f28217KH = new C9893a.C9894a();
            }
            this.f28217KH.m27412a(this.adTemplate, null, null, null);
            return this;
        }

        /* renamed from: aq */
        public final C8616a m30199aq(int i) {
            this.f28223KN = i;
            return this;
        }
    }

    /* renamed from: com.kwad.components.core.e.d.a$b */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC8617b {
        void onAdClicked();
    }

    /* renamed from: a */
    public static int m30234a(@NonNull Context context, @NonNull AdTemplate adTemplate, @NonNull InterfaceC8617b interfaceC8617b, @Nullable C8619c c8619c, boolean z, boolean z2, boolean z3, boolean z4) {
        C9826a.m27597f(adTemplate, true);
        adTemplate.converted = true;
        boolean z5 = false;
        C8629d.m30110ax(false);
        AdInfo m25641dQ = C10487e.m25641dQ(adTemplate);
        C9861c.m27501f(InterfaceC7326a.class);
        C8616a m30195ar = new C8616a(context).m30198aq(adTemplate).m30216a(interfaceC8617b).m30189b(c8619c).m30202ao(z).m30200ap(z2).m30208al(z4).m30195ar(false);
        int m25922an = C10483a.m25922an(m25641dQ);
        if (!((z3 || m30195ar.m30164nS() == 2 || m30195ar.m30164nS() == 1) ? true : true) && !TextUtils.isEmpty(C10483a.m25943aS(m25641dQ)) && !m30195ar.m30168nO()) {
            if (m25922an == 1) {
                if (C10483a.m25872bh(m25641dQ)) {
                    return m30220k(m30195ar);
                }
                return m30219l(m30195ar);
            } else if (m25922an == 2) {
                int m30223h = m30223h(m30195ar);
                if (m30223h == 1) {
                    return 13;
                }
                if (m30223h == 2) {
                    return 16;
                }
                if (C10483a.m25872bh(m25641dQ)) {
                    return m30220k(m30195ar);
                }
                return m30219l(m30195ar);
            }
        }
        int m30223h2 = m30223h(m30195ar);
        if (m30223h2 == 1) {
            return 13;
        }
        if (m30223h2 == 2) {
            return 16;
        }
        if (!C10483a.m25956aF(m25641dQ)) {
            if (m30221j(m30195ar)) {
                return 11;
            }
            return m30219l(m30195ar);
        }
        int m30218m = m30218m(m30195ar);
        int i = m25641dQ.status;
        if (i != 2 && i != 3) {
            m30226e(m30195ar);
        }
        return m30218m;
    }

    /* renamed from: b */
    private static int m30231b(C8616a c8616a) {
        Context context = c8616a.getContext();
        AdTemplate adTemplate = c8616a.getAdTemplate();
        AdInfo m25641dQ = C10487e.m25641dQ(adTemplate);
        Activity m24559dn = C10887l.m24559dn(context);
        if (m24559dn != null && C10483a.m25966V(m25641dQ) && !c8616a.m30182nA() && !c8616a.m30177nF()) {
            c8616a.m30211ak(2);
            DialogFragmentC8639e.m30093a(m24559dn, c8616a);
            m30227d(adTemplate, 19);
            return 19;
        }
        AdWebViewActivityProxy.launch(context, new AdWebViewActivityProxy.C8777a.C8778a().m29854at(C10484b.m25790cB(adTemplate)).m29856as(adTemplate).m29858aD(true).m29851pl());
        m30227d(adTemplate, 20);
        return 20;
    }

    /* renamed from: c */
    private static boolean m30229c(C8616a c8616a) {
        return C10483a.m25956aF(C10487e.m25641dQ(c8616a.getAdTemplate())) ? !c8616a.m30166nQ() && C8619c.m30156A(c8616a) == 3 : m30228d(c8616a) == 1;
    }

    /* renamed from: d */
    private static int m30228d(C8616a c8616a) {
        AdInfo m25641dQ = C10487e.m25641dQ(c8616a.getAdTemplate());
        if (m25641dQ.unDownloadConf.unDownloadRegionConf != null) {
            int m30187cU = c8616a.m30187cU();
            if (m30187cU != 2) {
                if (m30187cU != 3) {
                    return m25641dQ.unDownloadConf.unDownloadRegionConf.actionBarType;
                }
                return m25641dQ.unDownloadConf.unDownloadRegionConf.materialJumpType;
            }
            return m25641dQ.unDownloadConf.unDownloadRegionConf.describeBarType;
        }
        return 0;
    }

    /* renamed from: e */
    private static void m30226e(C8616a c8616a) {
        if (c8616a.m30182nA()) {
            return;
        }
        m30224g(c8616a);
        m30225f(c8616a);
        if (c8616a.m30180nC() != null) {
            try {
                c8616a.m30180nC().onAdClicked();
            } catch (Throwable th) {
                ServiceProvider.reportSdkCaughtException(th);
            }
        }
        C9826a.m27619bc(c8616a.getAdTemplate());
    }

    /* renamed from: f */
    private static void m30225f(C8616a c8616a) {
        if (c8616a.m30172nK()) {
            C9908c.m27342a(c8616a.adTemplate, c8616a.m30171nL(), c8616a.m30183hn());
        }
    }

    /* renamed from: g */
    private static void m30224g(C8616a c8616a) {
        C9208k.InterfaceC9212b interfaceC9212b;
        List<WeakReference<C9208k.InterfaceC9212b>> list = f28209Kq;
        if (list == null || list.isEmpty() || c8616a.adTemplate == null) {
            return;
        }
        for (WeakReference<C9208k.InterfaceC9212b> weakReference : f28209Kq) {
            if (weakReference != null && (interfaceC9212b = weakReference.get()) != null) {
                interfaceC9212b.mo29183L(C10487e.m25631ea(c8616a.adTemplate));
            }
        }
    }

    /* renamed from: h */
    private static int m30223h(C8616a c8616a) {
        AdTemplate adTemplate = c8616a.getAdTemplate();
        AdInfo m25641dQ = C10487e.m25641dQ(adTemplate);
        int m30119a = C8629d.m30119a(c8616a, 1);
        if (m30119a == 1) {
            C8629d.m30110ax(true);
            m30226e(c8616a);
            if ((C10483a.m25843cK(m25641dQ) || C10483a.m25842cL(m25641dQ)) && !c8616a.m30163nT()) {
                C9908c.m27291m(c8616a.getAdTemplate(), (int) Math.ceil(((float) c8616a.m30174nI()) / 1000.0f));
            }
            m30227d(adTemplate, 13);
        } else if (m30119a == 2) {
            m30226e(c8616a);
            m30227d(adTemplate, 16);
        }
        return m30119a;
    }

    /* renamed from: i */
    private static int m30222i(C8616a c8616a) {
        Context context = c8616a.getContext();
        AdTemplate adTemplate = c8616a.getAdTemplate();
        AdInfo m25641dQ = C10487e.m25641dQ(c8616a.getAdTemplate());
        Activity m24559dn = C10887l.m24559dn(c8616a.getContext());
        if (m24559dn != null && C10483a.m25967U(m25641dQ) && !c8616a.m30182nA() && C8633e.m30102E(m25641dQ) && !c8616a.m30177nF()) {
            c8616a.m30211ak(1);
            DialogFragmentC8639e.m30093a(m24559dn, c8616a);
            m30226e(c8616a);
            m30227d(adTemplate, 17);
            return 2;
        }
        int m30097d = C8633e.m30097d(context, adTemplate);
        if (m30097d == 1) {
            m30226e(c8616a);
            m30227d(adTemplate, 12);
        }
        return m30097d;
    }

    /* renamed from: j */
    private static boolean m30221j(C8616a c8616a) {
        AdTemplate adTemplate = c8616a.getAdTemplate();
        boolean m23835h = C11079d.m23835h(c8616a.getContext(), adTemplate);
        if (m23835h) {
            m30226e(c8616a);
            C9908c.m27295k(adTemplate, 0);
            m30227d(adTemplate, 11);
        }
        return m23835h;
    }

    /* renamed from: k */
    private static int m30220k(C8616a c8616a) {
        m30226e(c8616a);
        AdTemplate adTemplate = c8616a.getAdTemplate();
        AdInfo m25641dQ = C10487e.m25641dQ(c8616a.getAdTemplate());
        Activity m24559dn = C10887l.m24559dn(c8616a.getContext());
        if (m24559dn != null && C10483a.m25966V(m25641dQ) && !c8616a.m30182nA() && !c8616a.m30177nF()) {
            c8616a.m30211ak(2);
            DialogFragmentC8639e.m30093a(m24559dn, c8616a);
            m30227d(adTemplate, 19);
            return 19;
        }
        AdWebViewVideoActivityProxy.launch(c8616a.getContext(), adTemplate);
        m30227d(adTemplate, 15);
        return 15;
    }

    /* renamed from: l */
    private static int m30219l(C8616a c8616a) {
        m30226e(c8616a);
        Context context = c8616a.getContext();
        AdTemplate adTemplate = c8616a.getAdTemplate();
        AdInfo m25641dQ = C10487e.m25641dQ(adTemplate);
        Activity m24559dn = C10887l.m24559dn(context);
        if (m24559dn != null && C10483a.m25966V(m25641dQ) && !c8616a.m30182nA() && !c8616a.m30177nF()) {
            c8616a.m30211ak(2);
            DialogFragmentC8639e.m30093a(m24559dn, c8616a);
            m30227d(adTemplate, 19);
            return 19;
        }
        AdWebViewActivityProxy.launch(context, new AdWebViewActivityProxy.C8777a.C8778a().m29854at(C10484b.m25790cB(adTemplate)).m29856as(adTemplate).m29857aE(c8616a.m30179nD()).m29853az(1).m29851pl());
        m30227d(adTemplate, 14);
        return 14;
    }

    /* renamed from: m */
    private static int m30218m(C8616a c8616a) {
        C8619c m30184gZ = c8616a.m30184gZ();
        if (m30184gZ == null) {
            m30184gZ = new C8619c(c8616a.adTemplate);
            c8616a.m30189b(m30184gZ);
        }
        int m30128r = m30184gZ.m30128r(c8616a);
        m30227d(c8616a.getAdTemplate(), m30128r);
        return m30128r;
    }

    /* renamed from: n */
    private static int m30217n(C8616a c8616a) {
        AdTemplate adTemplate = c8616a.getAdTemplate();
        AdInfo m25641dQ = C10487e.m25641dQ(adTemplate);
        if (m30221j(c8616a)) {
            return 11;
        }
        if (C10483a.m25908b(m25641dQ, C10251d.m26575BS()) && !adTemplate.mAdWebVideoPageShowing) {
            return m30220k(c8616a);
        }
        return m30219l(c8616a);
    }

    /* renamed from: d */
    private static void m30227d(AdTemplate adTemplate, int i) {
        switch (i) {
            case 0:
                C9826a.m27603bs(adTemplate);
                return;
            case 1:
                C9826a.m27614bh(adTemplate);
                return;
            case 2:
                C9826a.m27604br(adTemplate);
                return;
            case 3:
                C9826a.m27612bj(adTemplate);
                return;
            case 4:
                C9826a.m27606bp(adTemplate);
                return;
            case 5:
                C9826a.m27605bq(adTemplate);
                return;
            case 6:
                C9826a.m27611bk(adTemplate);
                return;
            case 7:
                C9826a.m27610bl(adTemplate);
                return;
            case 8:
                C9826a.m27609bm(adTemplate);
                return;
            case 9:
                C9826a.m27607bo(adTemplate);
                return;
            case 10:
                C9826a.m27608bn(adTemplate);
                return;
            case 11:
                C9826a.m27615bg(adTemplate);
                return;
            case 12:
                C9826a.m27616bf(adTemplate);
                return;
            case 13:
                C9826a.m27617be(adTemplate);
                return;
            case 14:
                C9826a.m27618bd(adTemplate);
                return;
            case 15:
                C9826a.m27613bi(adTemplate);
                return;
            case 16:
                C9826a.m27601bu(adTemplate);
                return;
            case 17:
                C9826a.m27598bx(adTemplate);
                return;
            case 18:
                C9826a.m27602bt(adTemplate);
                return;
            case 19:
                C9826a.m27600bv(adTemplate);
                return;
            case 20:
                C9826a.m27599bw(adTemplate);
                return;
            default:
                return;
        }
    }

    /* renamed from: b */
    public static void m30230b(C9208k.InterfaceC9212b interfaceC9212b) {
        if (f28209Kq == null) {
            return;
        }
        int i = 0;
        while (true) {
            if (i >= f28209Kq.size()) {
                i = -1;
                break;
            }
            WeakReference<C9208k.InterfaceC9212b> weakReference = f28209Kq.get(i);
            if (weakReference != null && weakReference.get() != null && interfaceC9212b == weakReference.get()) {
                break;
            }
            i++;
        }
        if (i != -1) {
            f28209Kq.remove(i);
        }
    }

    /* renamed from: a */
    public static int m30233a(C8616a c8616a) {
        Context context = c8616a.getContext();
        AdTemplate adTemplate = c8616a.getAdTemplate();
        AdInfo m25641dQ = C10487e.m25641dQ(adTemplate);
        C8629d.m30110ax(false);
        if (c8616a.m30176nG()) {
            return m30231b(c8616a);
        }
        if (c8616a.m30167nP()) {
            return m30234a(context, adTemplate, c8616a.m30180nC(), c8616a.m30184gZ(), c8616a.f28210KA, c8616a.m30173nJ(), false, c8616a.m30177nF());
        }
        C9826a.m27597f(adTemplate, false);
        if (m30229c(c8616a)) {
            m30227d(adTemplate, 1);
            return 1;
        }
        adTemplate.converted = true;
        C9861c.m27501f(InterfaceC7326a.class);
        int m25922an = C10483a.m25922an(m25641dQ);
        if (!(c8616a.m30164nS() == 2 || c8616a.m30164nS() == 1) && !TextUtils.isEmpty(C10483a.m25943aS(m25641dQ)) && !c8616a.m30168nO()) {
            if (m25922an == 1) {
                if (C10483a.m25872bh(m25641dQ)) {
                    return m30220k(c8616a);
                }
                return m30219l(c8616a);
            } else if (m25922an == 2) {
                int m30223h = m30223h(c8616a);
                if (m30223h == 1) {
                    return 13;
                }
                if (m30223h == 2) {
                    return 16;
                }
                if (C10483a.m25872bh(m25641dQ)) {
                    return m30220k(c8616a);
                }
                return m30219l(c8616a);
            }
        }
        int m30223h2 = m30223h(c8616a);
        if (m30223h2 == 1) {
            return 13;
        }
        if (m30223h2 == 2) {
            return 16;
        }
        int m30222i = m30222i(c8616a);
        if (m30222i == 1) {
            return 12;
        }
        if (m30222i == 2) {
            return 17;
        }
        if (c8616a.m30169nN() && !C10483a.m25956aF(m25641dQ)) {
            return m30217n(c8616a);
        }
        if (!C10483a.m25956aF(m25641dQ)) {
            if (adTemplate.isWebViewDownload) {
                return m30218m(c8616a);
            }
            if (m30221j(c8616a)) {
                return 11;
            }
            return m30219l(c8616a);
        } else if (c8616a.m30164nS() != 2 && c8616a.m30164nS() != 1) {
            if (c8616a.m30169nN() && C10483a.m25908b(m25641dQ, C10251d.m26575BS()) && !TextUtils.isEmpty(C10483a.m25943aS(m25641dQ)) && !AdWebViewVideoActivityProxy.showingAdWebViewVideoActivity) {
                int m30129q = c8616a.m30184gZ().m30129q(c8616a);
                if (m30129q == 0) {
                    return m30220k(c8616a);
                }
                m30226e(c8616a);
                m30227d(adTemplate, m30129q);
                return m30129q;
            }
            m30226e(c8616a);
            c8616a.m30195ar(true);
            return m30218m(c8616a);
        } else {
            c8616a.m30195ar(false);
            m30226e(c8616a);
            return m30218m(c8616a);
        }
    }

    /* renamed from: a */
    public static void m30232a(C9208k.InterfaceC9212b interfaceC9212b) {
        if (f28209Kq == null) {
            f28209Kq = new CopyOnWriteArrayList();
        }
        f28209Kq.add(new WeakReference<>(interfaceC9212b));
    }
}

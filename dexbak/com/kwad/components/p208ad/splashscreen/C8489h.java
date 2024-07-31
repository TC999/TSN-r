package com.kwad.components.p208ad.splashscreen;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.p289e.p292c.AlertDialogC8602b;
import com.kwad.components.core.p289e.p293d.C8615a;
import com.kwad.components.core.p289e.p293d.C8619c;
import com.kwad.components.core.p330s.C8934b;
import com.kwad.components.core.webview.tachikoma.p336d.C9279a;
import com.kwad.components.offline.api.p341tk.model.StyleTemplate;
import com.kwad.components.p208ad.splashscreen.local.C8493a;
import com.kwad.components.p208ad.splashscreen.monitor.C8495a;
import com.kwad.components.p208ad.splashscreen.monitor.C8497b;
import com.kwad.components.p208ad.splashscreen.monitor.C8498c;
import com.kwad.components.p208ad.splashscreen.monitor.SplashMonitorInfo;
import com.kwad.components.p208ad.splashscreen.p283e.C8478a;
import com.kwad.sdk.api.KsSplashScreenAd;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.commercial.C9815b;
import com.kwad.sdk.commercial.p375d.C9828c;
import com.kwad.sdk.core.adlog.C9893a;
import com.kwad.sdk.core.adlog.C9908c;
import com.kwad.sdk.core.adlog.p388c.C9913b;
import com.kwad.sdk.core.config.C10251d;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.p403h.InterfaceC10383a;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10484b;
import com.kwad.sdk.core.response.p409b.C10485c;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.mvp.AbstractC10868a;
import com.kwad.sdk.p364a.p365a.C9679c;
import com.kwad.sdk.utils.AbstractRunnableC11033ay;
import com.kwad.sdk.utils.C11063bm;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.kwad.components.ad.splashscreen.h */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8489h extends AbstractC10868a {

    /* renamed from: CB */
    public int f27869CB;

    /* renamed from: CC */
    public int f27870CC;

    /* renamed from: CD */
    public long f27871CD;

    /* renamed from: CE */
    public long f27872CE;

    /* renamed from: CF */
    public long f27873CF;

    /* renamed from: CG */
    public long f27874CG;

    /* renamed from: CH */
    public long f27875CH;

    /* renamed from: CI */
    public long f27876CI;

    /* renamed from: CJ */
    public long f27877CJ;

    /* renamed from: Ce */
    private KsSplashScreenAd.SplashScreenAdInteractionListener f27878Ce;
    @Nullable

    /* renamed from: Cq */
    public C8478a f27879Cq;

    /* renamed from: Cr */
    public StyleTemplate f27880Cr;

    /* renamed from: Cs */
    public InterfaceC10383a f27881Cs;
    public AdResultData mAdResultData;
    @NonNull
    public SceneImpl mAdScene;
    public C8619c mApkDownloadHelper;
    @NonNull
    public AdBaseFrameLayout mRootContainer;
    public C11063bm mTimerHelper;
    @NonNull
    public KsVideoPlayConfig mVideoPlayConfig;

    /* renamed from: Ct */
    private List<InterfaceC8488g> f27882Ct = new CopyOnWriteArrayList();

    /* renamed from: Cu */
    private List<InterfaceC8482f> f27883Cu = new CopyOnWriteArrayList();

    /* renamed from: Cv */
    public boolean f27884Cv = false;

    /* renamed from: Cw */
    private boolean f27885Cw = false;

    /* renamed from: Cx */
    public boolean f27886Cx = false;

    /* renamed from: Cy */
    public boolean f27887Cy = false;

    /* renamed from: Cz */
    public boolean f27888Cz = false;

    /* renamed from: CA */
    public long f27868CA = SystemClock.elapsedRealtime();
    public boolean isWebTimeout = false;

    /* renamed from: com.kwad.components.ad.splashscreen.h$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC8492a {
        /* renamed from: b */
        void mo30595b(@NonNull C9913b c9913b);
    }

    /* renamed from: U */
    public static boolean m30626U(AdTemplate adTemplate) {
        AdMatrixInfo.SplashPlayCardTKInfo m25715dd;
        return C10251d.m26572BV() && (m25715dd = C10484b.m25715dd(adTemplate)) != null && !TextUtils.isEmpty(m25715dd.templateId) && m25715dd.renderType == 1;
    }

    /* renamed from: kP */
    private void m30601kP() {
        m30600kQ();
        for (InterfaceC8488g interfaceC8488g : this.f27882Ct) {
            interfaceC8488g.mo30628kA();
        }
    }

    /* renamed from: kQ */
    private void m30600kQ() {
        long m25700dl;
        AdInfo m25641dQ = C10487e.m25641dQ(this.mAdTemplate);
        SplashMonitorInfo elementTypes = new SplashMonitorInfo().setStatus(8).setElementTypes(C9279a.m29119sY().m29118sZ());
        C11063bm c11063bm = this.mTimerHelper;
        SplashMonitorInfo rotateComposeTimeout = elementTypes.setShowEndTime(c11063bm != null ? c11063bm.getTime() : -1L).setRotateComposeTimeout(this.f27888Cz);
        if (m30626U(this.mAdTemplate)) {
            m25700dl = C10484b.m25713de(this.mAdTemplate);
        } else {
            m25700dl = C10484b.m25700dl(C10487e.m25641dQ(this.mAdTemplate));
        }
        C9815b.m27660k(rotateComposeTimeout.setTkDefaultTimeout(m25700dl).setSoSource(this.f27869CB).setSoLoadTime(this.f27871CD).setOfflineSource(this.f27870CC).setOfflineLoadTime(this.f27872CE).setTkFileLoadTime(this.f27873CF).setTkInitTime(this.f27874CG).setTkRenderTime(this.f27875CH).setNativeLoadTime(this.f27876CI).setWebTimeout(this.isWebTimeout).setWebLoadTime(this.f27877CJ).setInteractiveStyle(C10484b.m25680dv(m25641dQ)).setInteractivityDefaultStyle(C10484b.m25678dw(m25641dQ)).setCreativeId(C10483a.m25978J(m25641dQ)).setAdTemplate(this.mAdTemplate));
        C9279a.m29119sY().m29117ta();
    }

    /* renamed from: kR */
    private void m30599kR() {
        for (InterfaceC8482f interfaceC8482f : this.f27883Cu) {
            interfaceC8482f.mo30643kw();
        }
    }

    /* renamed from: n */
    public static boolean m30597n(@NonNull AdInfo adInfo) {
        return adInfo.adSplashInfo.fullScreenClickSwitch == 1;
    }

    /* renamed from: r */
    public static boolean m30596r(AdInfo adInfo) {
        return C10484b.m25714de(adInfo) && C10483a.m25876bd(adInfo);
    }

    /* renamed from: Q */
    public final void m30627Q(Context context) {
        if (this.mAdTemplate.mPvReported) {
            return;
        }
        C8493a.m30594R(context);
        C8934b.m29570qY().m29571a(this.mAdTemplate, null, null);
        C9828c.m27588bz(this.mAdTemplate);
        m30614kC();
    }

    /* renamed from: X */
    public final void m30625X(int i) {
        for (InterfaceC8488g interfaceC8488g : this.f27882Ct) {
            interfaceC8488g.mo30629W(i);
        }
    }

    /* renamed from: a */
    public final void m30624a(int i, Context context, final int i2, int i3, final InterfaceC8492a interfaceC8492a) {
        C10487e.m25641dQ(this.mAdTemplate);
        C8615a.m30233a(new C8615a.C8616a(context).m30198aq(this.mAdTemplate).m30189b(this.mApkDownloadHelper).m30205an(i3).m30202ao(i3 == 1).m30207am(i2).m30209al(i).m30216a(new C8615a.InterfaceC8617b() { // from class: com.kwad.components.ad.splashscreen.h.1
            @Override // com.kwad.components.core.p289e.p293d.C8615a.InterfaceC8617b
            public final void onAdClicked() {
                C8495a.m30585kT().m30588Y(C8489h.this.mAdTemplate);
                if (C8489h.this.f27878Ce != null) {
                    C8489h.this.f27878Ce.onAdClicked();
                }
                C8495a.m30585kT().m30590W(C8489h.this.mAdTemplate);
                JSONObject jSONObject = new JSONObject();
                try {
                    C8478a c8478a = C8489h.this.f27879Cq;
                    if (c8478a != null) {
                        jSONObject.put("duration", c8478a.getCurrentPosition());
                    }
                } catch (JSONException e) {
                    C10331c.printStackTrace(e);
                }
                C9913b m27247f = new C9913b().m27266cK(i2).m27247f(C8489h.this.mRootContainer.getTouchCoords());
                C9908c.m27340a(C8489h.this.mAdTemplate, m27247f, jSONObject);
                InterfaceC8492a interfaceC8492a2 = interfaceC8492a;
                if (interfaceC8492a2 != null) {
                    interfaceC8492a2.mo30595b(m27247f);
                }
            }
        }));
    }

    /* renamed from: c */
    public final void m30618c(int i, Context context, int i2, int i3) {
        m30624a(i, context, i2, i3, null);
    }

    /* renamed from: d */
    public final void m30617d(AdResultData adResultData) {
        this.mAdResultData = adResultData;
        this.mAdTemplate = C10485c.m25661n(adResultData);
    }

    @MainThread
    /* renamed from: i */
    public final void m30616i(int i, String str) {
        KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.f27878Ce;
        if (splashScreenAdInteractionListener != null) {
            splashScreenAdInteractionListener.onAdShowError(i, str);
        }
        C8497b.m30550kV();
        C8497b.m30555e(this.mAdTemplate, i, String.valueOf(str));
        m30601kP();
    }

    @MainThread
    /* renamed from: kB */
    public final void m30615kB() {
        this.mAdTemplate.converted = true;
        C8495a.m30585kT().m30588Y(this.mAdTemplate);
        KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.f27878Ce;
        if (splashScreenAdInteractionListener != null) {
            splashScreenAdInteractionListener.onAdClicked();
        }
        C8495a.m30585kT().m30590W(this.mAdTemplate);
    }

    @MainThread
    /* renamed from: kC */
    public final void m30614kC() {
        KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.f27878Ce;
        if (splashScreenAdInteractionListener != null) {
            splashScreenAdInteractionListener.onAdShowStart();
        }
        if (this.f27885Cw) {
            return;
        }
        this.f27885Cw = true;
        C8497b.m30550kV();
        C8497b.m30552f(this.mAdTemplate, SystemClock.elapsedRealtime() - this.mAdTemplate.showStartTime);
        C8498c.m30546af(this.mAdTemplate);
        C8495a.m30585kT().m30583m(this.mAdTemplate);
        C9679c.m28040zM().m28044bj(true);
        C11063bm c11063bm = this.mTimerHelper;
        if (c11063bm != null) {
            c11063bm.startTiming();
        }
    }

    @MainThread
    /* renamed from: kD */
    public final void m30613kD() {
        C8495a.m30585kT().m30584l(this.mAdTemplate);
        KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.f27878Ce;
        if (splashScreenAdInteractionListener != null) {
            splashScreenAdInteractionListener.onAdShowEnd();
        }
        C8495a.m30585kT().m30582n(this.mAdTemplate);
    }

    /* renamed from: kE */
    public final void m30612kE() {
        KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.f27878Ce;
        if (splashScreenAdInteractionListener != null) {
            splashScreenAdInteractionListener.onAdShowError(0, "onMediaPlayError");
        }
    }

    /* renamed from: kF */
    public final void m30611kF() {
        KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.f27878Ce;
        if (splashScreenAdInteractionListener != null) {
            splashScreenAdInteractionListener.onAdShowStart();
        }
    }

    /* renamed from: kG */
    public final void m30610kG() {
        KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.f27878Ce;
        if (splashScreenAdInteractionListener != null) {
            splashScreenAdInteractionListener.onAdShowEnd();
        }
    }

    /* renamed from: kH */
    public final void m30609kH() {
        KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.f27878Ce;
        if (splashScreenAdInteractionListener != null) {
            splashScreenAdInteractionListener.onSkippedAd();
        }
    }

    /* renamed from: kI */
    public final void m30608kI() {
        KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.f27878Ce;
        if (splashScreenAdInteractionListener != null) {
            splashScreenAdInteractionListener.onAdClicked();
        }
    }

    /* renamed from: kJ */
    public final void m30607kJ() {
        KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.f27878Ce;
        if (splashScreenAdInteractionListener != null) {
            splashScreenAdInteractionListener.onDownloadTipsDialogShow();
        }
    }

    /* renamed from: kK */
    public final void m30606kK() {
        KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.f27878Ce;
        if (splashScreenAdInteractionListener != null) {
            splashScreenAdInteractionListener.onDownloadTipsDialogCancel();
        }
    }

    /* renamed from: kL */
    public final void m30605kL() {
        KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.f27878Ce;
        if (splashScreenAdInteractionListener != null) {
            splashScreenAdInteractionListener.onDownloadTipsDialogDismiss();
        }
    }

    @MainThread
    /* renamed from: kM */
    public final void m30604kM() {
        if (this.f27884Cv) {
            return;
        }
        this.f27884Cv = true;
        if (m30596r(C10487e.m25641dQ(this.mAdTemplate)) && !this.mAdTemplate.converted) {
            m30599kR();
        } else {
            C9893a.C9894a c9894a = new C9893a.C9894a();
            C11063bm c11063bm = this.mTimerHelper;
            if (c11063bm != null) {
                c9894a.duration = c11063bm.getTime();
            }
            C9908c.m27334b(this.mAdTemplate, new C9913b().m27265cL(14).m27257cT(22).m27268b(c9894a), (JSONObject) null);
            C8495a.m30585kT().m30584l(this.mAdTemplate);
            KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.f27878Ce;
            if (splashScreenAdInteractionListener != null) {
                splashScreenAdInteractionListener.onAdShowEnd();
            }
            C8495a.m30585kT().m30582n(this.mAdTemplate);
        }
        m30601kP();
    }

    @MainThread
    /* renamed from: kN */
    public final void m30603kN() {
        C8495a.m30585kT().m30584l(this.mAdTemplate);
        KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.f27878Ce;
        if (splashScreenAdInteractionListener != null) {
            splashScreenAdInteractionListener.onAdShowEnd();
        }
        C8495a.m30585kT().m30582n(this.mAdTemplate);
    }

    @MainThread
    /* renamed from: kO */
    public final void m30602kO() {
        KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.f27878Ce;
        if (splashScreenAdInteractionListener != null) {
            splashScreenAdInteractionListener.onSkippedAd();
        }
        C8495a.m30585kT().m30582n(this.mAdTemplate);
        m30601kP();
    }

    /* renamed from: kS */
    public final void m30598kS() {
        this.mRootContainer.post(new AbstractRunnableC11033ay() { // from class: com.kwad.components.ad.splashscreen.h.2
            @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
            public final void doTask() {
                if (AlertDialogC8602b.m30267nr()) {
                    C8489h.this.mRootContainer.postDelayed(this, 1000L);
                } else {
                    C8489h.this.m30603kN();
                }
            }
        });
    }

    @Override // com.kwad.sdk.mvp.AbstractC10868a
    public final void release() {
        C8478a c8478a = this.f27879Cq;
        if (c8478a != null) {
            c8478a.release();
        }
        InterfaceC10383a interfaceC10383a = this.f27881Cs;
        if (interfaceC10383a != null) {
            interfaceC10383a.release();
        }
    }

    public final void setSplashScreenAdListener(KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener) {
        this.f27878Ce = splashScreenAdInteractionListener;
    }

    /* renamed from: b */
    public final void m30620b(InterfaceC8488g interfaceC8488g) {
        this.f27882Ct.remove(interfaceC8488g);
    }

    /* renamed from: b */
    public final void m30621b(InterfaceC8482f interfaceC8482f) {
        if (interfaceC8482f == null) {
            return;
        }
        this.f27883Cu.remove(interfaceC8482f);
    }

    /* renamed from: a */
    public final void m30622a(InterfaceC8488g interfaceC8488g) {
        this.f27882Ct.add(interfaceC8488g);
    }

    /* renamed from: a */
    public final void m30623a(InterfaceC8482f interfaceC8482f) {
        if (interfaceC8482f == null) {
            return;
        }
        this.f27883Cu.add(interfaceC8482f);
    }
}

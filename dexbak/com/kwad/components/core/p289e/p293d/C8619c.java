package com.kwad.components.core.p289e.p293d;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import com.kwad.components.core.p289e.p290a.C8583e;
import com.kwad.components.core.p289e.p292c.AlertDialogC8602b;
import com.kwad.components.core.p289e.p293d.C8615a;
import com.kwad.components.core.p289e.p294e.DialogFragmentC8639e;
import com.kwad.components.core.p300k.C8687b;
import com.kwad.components.core.p317o.C8766a;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.components.core.page.AdWebViewVideoActivityProxy;
import com.kwad.components.core.page.DownloadLandPageActivity;
import com.kwad.components.p206a.p207a.InterfaceC7326a;
import com.kwad.sdk.api.KsApkDownloadListener;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.commercial.p372a.C9813a;
import com.kwad.sdk.components.C9861c;
import com.kwad.sdk.core.C9882a;
import com.kwad.sdk.core.NetworkMonitor;
import com.kwad.sdk.core.adlog.C9908c;
import com.kwad.sdk.core.config.C10251d;
import com.kwad.sdk.core.diskcache.ApkCacheManager;
import com.kwad.sdk.core.download.C10296a;
import com.kwad.sdk.core.download.C10303b;
import com.kwad.sdk.core.download.C10327e;
import com.kwad.sdk.core.download.InterfaceC10325c;
import com.kwad.sdk.core.download.p395a.AbstractC10298a;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10484b;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.core.webview.InterfaceC10600a;
import com.kwad.sdk.p364a.p365a.C9674b;
import com.kwad.sdk.p364a.p365a.C9679c;
import com.kwad.sdk.p445n.C10887l;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.AbstractRunnableC11033ay;
import com.kwad.sdk.utils.C11010ad;
import com.kwad.sdk.utils.C11013ag;
import com.kwad.sdk.utils.C11017ak;
import com.kwad.sdk.utils.C11079d;
import com.kwad.sdk.utils.C11095g;
import com.kwad.sdk.utils.C11128v;
import com.kwad.sdk.utils.C11130w;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* renamed from: com.kwad.components.core.e.d.c */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8619c implements NetworkMonitor.InterfaceC9881a, InterfaceC10325c, InterfaceC10600a {
    @NonNull

    /* renamed from: KT */
    private AdTemplate f28242KT;

    /* renamed from: KU */
    private boolean f28243KU;

    /* renamed from: KV */
    private InterfaceC8628a f28244KV;

    /* renamed from: KW */
    private DialogInterface.OnShowListener f28245KW;

    /* renamed from: KX */
    private List<KsAppDownloadListener> f28246KX;
    private boolean downloadPauseEnable;

    /* renamed from: fS */
    private Handler f28247fS;
    @NonNull
    private AdInfo mAdInfo;
    private DialogInterface.OnDismissListener mOnDismissListener;
    private JSONObject mReportExtData;

    /* renamed from: com.kwad.components.core.e.d.c$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC8628a {
        boolean handleDownloadDialog(DialogInterface.OnClickListener onClickListener);
    }

    public C8619c(@NonNull AdTemplate adTemplate, JSONObject jSONObject, KsAppDownloadListener ksAppDownloadListener) {
        this.f28247fS = new Handler(Looper.getMainLooper());
        this.f28246KX = new ArrayList();
        this.f28242KT = adTemplate;
        this.mAdInfo = C10487e.m25641dQ(adTemplate);
        this.mReportExtData = jSONObject;
        if (ksAppDownloadListener != null) {
            m30151b(ksAppDownloadListener);
        }
        m30142nV();
        this.downloadPauseEnable = C10483a.m25852cB(C10487e.m25641dQ(this.f28242KT));
        m30143nU();
        C9679c.m28040zM().m28051aN(this.f28242KT);
    }

    /* renamed from: A */
    public static int m30156A(C8615a.C8616a c8616a) {
        AdInfo m25641dQ = C10487e.m25641dQ(c8616a.getAdTemplate());
        if (m25641dQ.downloadSafeInfo.complianceInfo != null) {
            int m30187cU = c8616a.m30187cU();
            if (m30187cU != 2) {
                if (m30187cU != 3) {
                    return m25641dQ.downloadSafeInfo.complianceInfo.actionBarType;
                }
                return m25641dQ.downloadSafeInfo.complianceInfo.materialJumpType;
            }
            return m25641dQ.downloadSafeInfo.complianceInfo.describeBarType;
        }
        return 0;
    }

    /* renamed from: nV */
    private void m30142nV() {
        C10303b.m26364De();
        int m26341dz = C10303b.m26341dz(mo26271nX());
        if (m26341dz != 0) {
            this.mAdInfo.status = m26341dz;
        }
        m30138ob();
        m30139oa();
    }

    /* renamed from: nZ */
    private boolean m30140nZ() {
        if (Build.VERSION.SDK_INT < 29) {
            if (this.f28242KT.mIsFromContent && C10251d.m26567Bu()) {
                r1 = m30134of();
                if (r1) {
                    C9908c.m27326bI(this.f28242KT);
                }
            } else if (!this.f28242KT.mIsFromContent && C10251d.m26569BY()) {
                boolean m30014aa = C8687b.m30014aa(ServiceProvider.getContext());
                C10331c.m26254d("ApkDownloadHelper", "handleForceOpenApp enableForceOpen: " + m30014aa);
                r1 = m30014aa ? m30134of() : false;
                if (r1) {
                    C9908c.m27325bJ(this.f28242KT);
                }
            }
        }
        return r1;
    }

    /* renamed from: oa */
    private void m30139oa() {
        this.f28247fS.post(new AbstractRunnableC11033ay() { // from class: com.kwad.components.core.e.d.c.3
            @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
            public final void doTask() {
                ArrayList<KsAppDownloadListener> arrayList = new ArrayList(C8619c.this.f28246KX.size());
                arrayList.addAll(C8619c.this.f28246KX);
                for (KsAppDownloadListener ksAppDownloadListener : arrayList) {
                    if (ksAppDownloadListener != null) {
                        C8619c.this.m30153a(ksAppDownloadListener);
                    }
                }
            }
        });
    }

    /* renamed from: od */
    private boolean m30136od() {
        InterfaceC8628a interfaceC8628a = this.f28244KV;
        if (interfaceC8628a != null) {
            return interfaceC8628a.handleDownloadDialog(new DialogInterface.OnClickListener() { // from class: com.kwad.components.core.e.d.c.4
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    if (i == -1) {
                        switch (C8619c.this.mAdInfo.status) {
                            case 0:
                            case 1:
                            case 4:
                            case 5:
                            case 6:
                            case 7:
                                C8619c.this.m30132oh();
                                return;
                            case 2:
                            case 3:
                            case 10:
                            default:
                                return;
                            case 8:
                            case 9:
                            case 11:
                                C8619c.this.m30133og();
                                return;
                            case 12:
                                C8619c.this.m30135oe();
                                return;
                        }
                    }
                }
            });
        }
        return false;
    }

    /* renamed from: of */
    private boolean m30134of() {
        Context context = ServiceProvider.getContext();
        if (C8629d.m30119a(new C8615a.C8616a(context).m30198aq(this.f28242KT), 1) == 1) {
            return true;
        }
        boolean m24112ap = C11017ak.m24112ap(context, C10483a.m25911ay(this.mAdInfo));
        if (m24112ap) {
            C9908c.m27327bH(this.f28242KT);
        }
        return m24112ap;
    }

    /* renamed from: t */
    private boolean m30126t(C8615a.C8616a c8616a) {
        boolean m23835h = C11079d.m23835h(c8616a.getContext(), this.f28242KT);
        if (m23835h) {
            C9908c.m27295k(this.f28242KT, 0);
        }
        return m23835h;
    }

    /* renamed from: u */
    private int m30125u(C8615a.C8616a c8616a) {
        Context context = c8616a.getContext();
        if (C11079d.m23838a(context, C10483a.m25837cQ(this.mAdInfo), this.f28242KT)) {
            C9908c.m27295k(this.f28242KT, 1);
            return 11;
        } else if (m30126t(c8616a)) {
            return 11;
        } else {
            if (m30136od()) {
                return 10;
            }
            if (!C11013ag.isNetworkConnected(context)) {
                C11128v.m23672O(context, C11130w.m23665bY(context));
                return 2;
            } else if (c8616a.m30166nQ() && C10251d.m26582BL()) {
                return m30124v(c8616a);
            } else {
                if (C10487e.m25626ef(this.f28242KT) && c8616a.m30164nS() != 2) {
                    return m30150c(c8616a.getContext(), c8616a.getAdTemplate());
                }
                if (c8616a.m30170nM()) {
                    return m30123w(c8616a);
                }
                if (m30122x(c8616a)) {
                    return 8;
                }
                return m30132oh();
            }
        }
    }

    /* renamed from: v */
    private int m30124v(C8615a.C8616a c8616a) {
        Context context = c8616a.getContext();
        AdTemplate adTemplate = c8616a.getAdTemplate();
        int m30165nR = c8616a.m30165nR();
        if (m30165nR != 1) {
            if (m30165nR != 2) {
                return 1;
            }
            if (C10484b.m25768cX(adTemplate)) {
                AlertDialogC8602b.m30269a(context, new AlertDialogC8602b.C8604a().m30261ap(adTemplate).m30262ae(C10484b.m25769cW(adTemplate)).m30264a(this.f28245KW).m30259c(this.mOnDismissListener).m30256nu());
                return 8;
            }
            return 8;
        }
        return m30132oh();
    }

    /* renamed from: w */
    private int m30123w(C8615a.C8616a c8616a) {
        Context context = c8616a.getContext();
        AdTemplate adTemplate = c8616a.getAdTemplate();
        int m30156A = m30156A(c8616a);
        if (m30156A == 1) {
            if (C10484b.m25768cX(adTemplate)) {
                AlertDialogC8602b.m30269a(context, new AlertDialogC8602b.C8604a().m30261ap(adTemplate).m30262ae(C10484b.m25769cW(adTemplate)).m30264a(this.f28245KW).m30259c(this.mOnDismissListener).m30256nu());
            }
            return 8;
        } else if (m30156A != 2) {
            if (m30156A != 3) {
                if (m30122x(c8616a)) {
                    return 8;
                }
                return m30132oh();
            }
            return 1;
        } else {
            return m30150c(c8616a.getContext(), c8616a.getAdTemplate());
        }
    }

    /* renamed from: x */
    private boolean m30122x(C8615a.C8616a c8616a) {
        if (c8616a.m30173nJ() || this.mAdInfo.status == 4 || !C10484b.m25718da(this.f28242KT) || !m30121y(c8616a)) {
            return false;
        }
        return AlertDialogC8602b.m30269a(c8616a.getContext(), new AlertDialogC8602b.C8604a().m30261ap(this.f28242KT).m30262ae(C10484b.m25766cZ(this.f28242KT)).m30264a(this.f28245KW).m30259c(this.mOnDismissListener).m30256nu());
    }

    /* renamed from: y */
    private static boolean m30121y(C8615a.C8616a c8616a) {
        AdInfo m25641dQ = C10487e.m25641dQ(c8616a.getAdTemplate());
        if (C10483a.m25860bt(m25641dQ) && (DownloadLandPageActivity.showingAdWebViewLandPage || AdWebViewVideoActivityProxy.showingAdWebViewVideoActivity || c8616a.getAdTemplate().isWebViewDownload)) {
            return true;
        }
        return C10483a.m25859bu(m25641dQ) && !C11013ag.isWifiConnected(c8616a.getContext());
    }

    /* renamed from: z */
    private int m30120z(C8615a.C8616a c8616a) {
        Activity m24559dn = C10887l.m24559dn(c8616a.getContext());
        if (m24559dn != null && C10483a.m25967U(this.mAdInfo) && !c8616a.m30182nA() && !c8616a.m30177nF()) {
            c8616a.m30211ak(1);
            DialogFragmentC8639e.m30093a(m24559dn, c8616a);
            return 18;
        }
        return m30135oe();
    }

    /* renamed from: as */
    public final void m30152as(int i) {
        this.f28242KT.downloadSource = i;
    }

    @Override // com.kwad.sdk.core.download.InterfaceC10325c
    /* renamed from: b */
    public final void mo26278b(String str, C10327e c10327e) {
        if (this.mAdInfo.downloadId.equals(str)) {
            if (this.mAdInfo.status != 4 && c10327e.m26268Di()) {
                C9908c.m27338a(this.f28242KT, this.mReportExtData);
                c10327e.m26269Dh();
                C9813a.m27716aU(this.f28242KT);
            }
            this.mAdInfo.status = 4;
            m30139oa();
        }
    }

    public final void clear() {
        mo25351ok();
        C10303b.m26364De().m26357a(this);
        if (C10251d.m26544Ck()) {
            NetworkMonitor.getInstance().m27464a(this);
        }
    }

    @Override // com.kwad.sdk.core.download.InterfaceC10325c
    /* renamed from: f */
    public final void mo26273f(String str, C10327e c10327e) {
        if (this.mAdInfo.downloadId.equals(str)) {
            m30138ob();
            if (c10327e.m26268Di()) {
                c10327e.m26269Dh();
                C9813a.m27710ba(this.f28242KT);
            }
        }
    }

    @Override // com.kwad.sdk.core.download.InterfaceC10325c
    /* renamed from: g */
    public final void mo26272g(String str, C10327e c10327e) {
        if (this.mAdInfo.downloadId.equals(str) && c10327e.m26268Di()) {
            c10327e.m26269Dh();
            C9908c.m27328bG(this.f28242KT);
            C9813a.m27713aX(this.f28242KT);
        }
    }

    /* renamed from: nU */
    public final void m30143nU() {
        C10303b.m26364De().m26356a(this, this.f28242KT);
        if (C10251d.m26544Ck()) {
            NetworkMonitor.getInstance().m27465a(ServiceProvider.getContext(), this);
        }
    }

    /* renamed from: nW */
    public final int m30141nW() {
        m30138ob();
        int i = this.mAdInfo.status;
        if (i == 3) {
            return 2;
        }
        return i;
    }

    @Override // com.kwad.sdk.core.download.InterfaceC10325c
    /* renamed from: nX */
    public final String mo26271nX() {
        return this.mAdInfo.downloadId;
    }

    @Override // com.kwad.sdk.core.download.InterfaceC10325c
    /* renamed from: nY */
    public final String mo26270nY() {
        return this.mAdInfo.adBaseInfo.appPackageName;
    }

    /* renamed from: ob */
    public final void m30138ob() {
        if (C11017ak.m24114an(ServiceProvider.getContext(), this.mAdInfo.adBaseInfo.appPackageName)) {
            this.mAdInfo.status = 12;
            return;
        }
        AdInfo adInfo = this.mAdInfo;
        if (adInfo.status == 12) {
            adInfo.status = 0;
            adInfo.progress = 0;
        }
        int i = adInfo.status;
        if (i == 8 || i == 9) {
            String str = adInfo.downloadFilePath;
            if (TextUtils.isEmpty(str) || !new File(str).exists()) {
                AdInfo adInfo2 = this.mAdInfo;
                adInfo2.status = 0;
                adInfo2.progress = 0;
            }
        }
        AdInfo adInfo3 = this.mAdInfo;
        if (adInfo3.status == 0) {
            String m26382H = C10296a.m26382H(adInfo3);
            if (TextUtils.isEmpty(m26382H) || !new File(m26382H).exists()) {
                return;
            }
            AdInfo adInfo4 = this.mAdInfo;
            adInfo4.downloadFilePath = m26382H;
            adInfo4.status = 8;
        }
    }

    @NonNull
    /* renamed from: oc */
    public final AdTemplate m30137oc() {
        return this.f28242KT;
    }

    /* renamed from: oe */
    public final int m30135oe() {
        C11095g.execute(new AbstractRunnableC11033ay() { // from class: com.kwad.components.core.e.d.c.5
            @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
            public final void doTask() {
                C9861c.m27501f(InterfaceC7326a.class);
            }
        });
        if (C11017ak.m24112ap(ServiceProvider.getContext(), C10483a.m25911ay(this.mAdInfo))) {
            C9908c.m27327bH(this.f28242KT);
            return 6;
        }
        return 6;
    }

    /* renamed from: og */
    public final int m30133og() {
        C11017ak.m24115a(this.mAdInfo.downloadFilePath, new C11017ak.InterfaceC11018a() { // from class: com.kwad.components.core.e.d.c.6
            @Override // com.kwad.sdk.utils.C11017ak.InterfaceC11018a
            /* renamed from: d */
            public final void mo24107d(Throwable th) {
                C9813a.m27708i(C8619c.this.f28242KT, 100003, Log.getStackTraceString(th));
            }

            @Override // com.kwad.sdk.utils.C11017ak.InterfaceC11018a
            /* renamed from: ol */
            public final void mo24106ol() {
                C9908c.m27302h(C8619c.this.f28242KT, 1);
                C9813a.m27712aY(C8619c.this.f28242KT);
            }
        });
        return 7;
    }

    /* renamed from: oh */
    public final int m30132oh() {
        C10296a.m26381I(this.mAdInfo);
        return 3;
    }

    /* renamed from: oi */
    public final int m30131oi() {
        C10296a.m26371dw(this.mAdInfo.downloadId);
        return 4;
    }

    /* renamed from: oj */
    public final int m30130oj() {
        m30132oh();
        return 5;
    }

    @Override // com.kwad.sdk.core.webview.InterfaceC10600a
    /* renamed from: ok */
    public final void mo25351ok() {
        List<KsAppDownloadListener> list = this.f28246KX;
        if (list != null) {
            list.clear();
        }
    }

    /* renamed from: q */
    public final int m30129q(C8615a.C8616a c8616a) {
        int i = this.mAdInfo.status;
        if (i != 0 && i != 1) {
            switch (i) {
                case 4:
                case 5:
                case 6:
                case 7:
                    break;
                case 8:
                case 9:
                case 10:
                case 11:
                    return m30133og();
                case 12:
                    return m30120z(c8616a);
                default:
                    return 0;
            }
        }
        return m30126t(c8616a) ? 11 : 0;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* renamed from: r */
    public final int m30128r(C8615a.C8616a c8616a) {
        this.f28243KU = false;
        m30138ob();
        switch (this.mAdInfo.status) {
            case 0:
            case 1:
            case 5:
            case 6:
            case 7:
                return m30125u(c8616a);
            case 2:
            case 3:
                if (c8616a.m30175nH() && this.downloadPauseEnable) {
                    return m30131oi();
                }
                break;
            case 4:
                return m30130oj();
            case 8:
            case 9:
            case 11:
                return m30133og();
            case 12:
                return m30120z(c8616a);
        }
        return 0;
    }

    /* renamed from: s */
    public final boolean m30127s(C8615a.C8616a c8616a) {
        return this.mAdInfo.status == 0 && m30126t(c8616a);
    }

    public final void setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        this.mOnDismissListener = onDismissListener;
    }

    public final void setOnShowListener(DialogInterface.OnShowListener onShowListener) {
        this.f28245KW = onShowListener;
    }

    @Override // com.kwad.sdk.core.download.InterfaceC10325c
    /* renamed from: a */
    public final void mo26281a(String str, C10327e c10327e) {
        if (this.mAdInfo.downloadId.equals(str)) {
            this.mAdInfo.status = 1;
            m30139oa();
            if (c10327e.m26268Di()) {
                this.mAdInfo.mStartDownloadTime = SystemClock.elapsedRealtime();
                C9908c.m27329bF(this.f28242KT);
                c10327e.m26269Dh();
                C9813a.m27706o(this.f28242KT);
            }
        }
    }

    @Override // com.kwad.sdk.core.download.InterfaceC10325c
    /* renamed from: c */
    public final void mo26276c(String str, C10327e c10327e) {
        if (this.mAdInfo.downloadId.equals(str)) {
            if (this.mAdInfo.status != 2 && c10327e.m26268Di()) {
                C9908c.m27332b(this.f28242KT, this.mReportExtData);
                c10327e.m26269Dh();
                C9813a.m27715aV(this.f28242KT);
            }
            this.mAdInfo.status = 2;
            m30139oa();
        }
    }

    /* renamed from: d */
    public final void m30145d(JSONObject jSONObject) {
        this.mReportExtData = jSONObject;
    }

    @Override // com.kwad.sdk.core.download.InterfaceC10325c
    /* renamed from: e */
    public final void mo26274e(String str, C10327e c10327e) {
        if (this.mAdInfo.downloadId.equals(str)) {
            this.mAdInfo.status = 9;
            m30139oa();
            if (c10327e.m26268Di()) {
                C9908c.m27302h(this.f28242KT, 2);
                c10327e.m26269Dh();
                C9813a.m27712aY(this.f28242KT);
            }
        }
    }

    @Override // com.kwad.sdk.core.download.InterfaceC10325c
    /* renamed from: d */
    public final void mo26275d(String str, C10327e c10327e) {
        if (this.mAdInfo.downloadId.equals(str)) {
            if (this.mAdInfo.status != 5 && c10327e.m26268Di()) {
                C9908c.m27310d(this.f28242KT, this.mReportExtData);
                c10327e.m26269Dh();
                C9813a.m27714aW(this.f28242KT);
            }
            C9679c.m28040zM().m28050aO(this.f28242KT);
            C9674b.m28065zJ().m28071aJ(this.f28242KT);
            this.mAdInfo.status = 5;
            m30139oa();
        }
    }

    @Override // com.kwad.sdk.core.download.InterfaceC10325c
    /* renamed from: b */
    public final void mo26277b(String str, String str2, C10327e c10327e) {
        final boolean z;
        this.mAdInfo.status = 12;
        m30139oa();
        if (c10327e.m26268Di()) {
            C9908c.m27307e(this.f28242KT, this.mReportExtData);
            c10327e.m26269Dh();
            C9813a.m27711aZ(this.f28242KT);
            z = m30140nZ();
            C9679c.m28040zM().m28048aQ(this.f28242KT);
            C9679c.m28040zM().m28050aO(this.f28242KT);
            C9674b.m28065zJ().m28071aJ(this.f28242KT);
            C8583e.m30309nf().m30317am(this.f28242KT);
            C9882a.m27460Bc().m27455cW(mo26271nX());
        } else {
            z = false;
        }
        C11095g.execute(new AbstractRunnableC11033ay() { // from class: com.kwad.components.core.e.d.c.2
            @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
            public final void doTask() {
                C9861c.m27501f(InterfaceC7326a.class);
            }
        });
    }

    /* renamed from: c */
    public final void m30148c(final KsAppDownloadListener ksAppDownloadListener) {
        if (ksAppDownloadListener == null) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            this.f28246KX.remove(ksAppDownloadListener);
        } else {
            this.f28247fS.post(new AbstractRunnableC11033ay() { // from class: com.kwad.components.core.e.d.c.8
                @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
                public final void doTask() {
                    C8619c.this.f28246KX.remove(ksAppDownloadListener);
                }
            });
        }
    }

    @Override // com.kwad.sdk.core.download.InterfaceC10325c
    /* renamed from: a */
    public final void mo26283a(String str, int i, int i2, int i3) {
        if (this.mAdInfo.downloadId.equals(str)) {
            AdInfo adInfo = this.mAdInfo;
            adInfo.status = 3;
            adInfo.progress = i;
            adInfo.soFarBytes = i2;
            adInfo.totalBytes = i3;
            m30139oa();
        }
    }

    /* renamed from: c */
    private static int m30150c(Context context, AdTemplate adTemplate) {
        if (context == null || adTemplate == null) {
            return 9;
        }
        DownloadLandPageActivity.launch(context, adTemplate, false);
        return 9;
    }

    /* renamed from: d */
    public final void m30146d(KsAppDownloadListener ksAppDownloadListener) {
        if (ksAppDownloadListener == null) {
            return;
        }
        m30138ob();
        m30153a(ksAppDownloadListener);
    }

    public C8619c(@NonNull AdTemplate adTemplate, @NonNull KsAppDownloadListener ksAppDownloadListener) {
        this(adTemplate, null, ksAppDownloadListener);
    }

    public C8619c(@NonNull AdTemplate adTemplate, JSONObject jSONObject) {
        this(adTemplate, jSONObject, null);
    }

    public C8619c(@NonNull AdTemplate adTemplate) {
        this(adTemplate, null, null);
    }

    public C8619c(@NonNull AdTemplate adTemplate, KsAppDownloadListener ksAppDownloadListener, String str, String str2) {
        this(adTemplate, null, null);
        AdInfo adInfo = this.mAdInfo;
        adInfo.adConversionInfo.appDownloadUrl = str;
        adInfo.adBaseInfo.appPackageName = str2;
        adInfo.downloadId = C11010ad.m24144bu(str);
    }

    @Override // com.kwad.sdk.core.download.InterfaceC10325c
    /* renamed from: a */
    public final void mo26280a(String str, String str2, C10327e c10327e) {
        if (this.mAdInfo.downloadId.equals(str)) {
            AdInfo adInfo = this.mAdInfo;
            adInfo.downloadFilePath = str2;
            adInfo.progress = 100;
            adInfo.status = 8;
            m30139oa();
            if (c10327e.m26268Di()) {
                c10327e.m26269Dh();
                C9908c.m27314c(this.f28242KT, this.mReportExtData);
                C9813a.m27707j(this.f28242KT, SystemClock.elapsedRealtime() - this.mAdInfo.mStartDownloadTime);
                C9882a.m27460Bc().m27454e(str, this.f28242KT);
                C11095g.execute(new Runnable() { // from class: com.kwad.components.core.e.d.c.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        C9861c.m27501f(InterfaceC7326a.class);
                    }
                });
                C9679c.m28040zM().m28049aP(this.f28242KT);
                C9679c.m28040zM().m28051aN(this.f28242KT);
                C9674b.m28065zJ().m28072aI(this.f28242KT);
                ApkCacheManager.getInstance().m26462CR();
            }
        }
    }

    @UiThread
    /* renamed from: b */
    public final void m30151b(final KsAppDownloadListener ksAppDownloadListener) {
        if (ksAppDownloadListener == null) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            if (!this.f28246KX.contains(ksAppDownloadListener)) {
                this.f28246KX.add(0, ksAppDownloadListener);
            }
        } else {
            this.f28247fS.post(new AbstractRunnableC11033ay() { // from class: com.kwad.components.core.e.d.c.7
                @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
                public final void doTask() {
                    if (C8619c.this.f28246KX.contains(ksAppDownloadListener)) {
                        return;
                    }
                    C8619c.this.f28246KX.add(0, ksAppDownloadListener);
                }
            });
        }
        m30138ob();
        m30153a(ksAppDownloadListener);
    }

    @Override // com.kwad.sdk.core.download.InterfaceC10325c
    /* renamed from: a */
    public final void mo26282a(String str, int i, String str2, C10327e c10327e) {
        if (this.mAdInfo.downloadId.equals(str)) {
            this.mAdInfo.status = 7;
            m30139oa();
            if (c10327e.m26268Di()) {
                C9908c.C9911a c9911a = new C9908c.C9911a(i, str2);
                C9908c.m27345a(this.f28242KT, c9911a);
                C8766a.m29888qi().m29913a(this.f28242KT, this.mAdInfo.adConversionInfo.appDownloadUrl, c9911a.toJson().toString());
                c10327e.m26269Dh();
                C9813a.m27709h(this.f28242KT, i, str2);
            }
            if (this.mAdInfo.adConversionInfo.retryH5TimeStep <= 0 || this.f28243KU) {
                return;
            }
            long elapsedRealtime = SystemClock.elapsedRealtime();
            AdInfo adInfo = this.mAdInfo;
            if (elapsedRealtime - adInfo.mStartDownloadTime >= adInfo.adConversionInfo.retryH5TimeStep || TextUtils.isEmpty(C10483a.m25943aS(adInfo))) {
                return;
            }
            AdWebViewActivityProxy.launch(ServiceProvider.getContext(), this.f28242KT);
            this.f28243KU = true;
        }
    }

    @Override // com.kwad.sdk.core.download.InterfaceC10325c
    /* renamed from: a */
    public final void mo26279a(String str, Throwable th, C10327e c10327e) {
        if (this.mAdInfo.downloadId.equals(str)) {
            this.mAdInfo.status = 11;
            m30139oa();
            if (c10327e.m26268Di()) {
                c10327e.m26269Dh();
                C9813a.m27708i(this.f28242KT, 100003, Log.getStackTraceString(th));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m30153a(@NonNull KsAppDownloadListener ksAppDownloadListener) {
        AdInfo adInfo = this.mAdInfo;
        int i = adInfo.progress;
        switch (adInfo.status) {
            case 0:
            case 5:
                ksAppDownloadListener.onIdle();
                return;
            case 1:
                ksAppDownloadListener.onProgressUpdate(0);
                if (ksAppDownloadListener instanceof AbstractC10298a) {
                    ((AbstractC10298a) ksAppDownloadListener).onDownloadStarted();
                    return;
                }
                try {
                    ksAppDownloadListener.onDownloadStarted();
                    return;
                } catch (Throwable th) {
                    C10331c.printStackTraceOnly(th);
                    return;
                }
            case 2:
            case 3:
                ksAppDownloadListener.onProgressUpdate(i);
                return;
            case 4:
                if (ksAppDownloadListener instanceof AbstractC10298a) {
                    ((AbstractC10298a) ksAppDownloadListener).onPaused(i);
                }
                try {
                    if (ksAppDownloadListener instanceof KsApkDownloadListener) {
                        ((KsApkDownloadListener) ksAppDownloadListener).onPaused(i);
                        return;
                    }
                    return;
                } catch (Throwable unused) {
                    return;
                }
            case 6:
            case 10:
            case 11:
            default:
                return;
            case 7:
                ksAppDownloadListener.onDownloadFailed();
                return;
            case 8:
            case 9:
                ksAppDownloadListener.onDownloadFinished();
                return;
            case 12:
                ksAppDownloadListener.onInstalled();
                return;
        }
    }

    /* renamed from: a */
    public final void m30155a(InterfaceC8628a interfaceC8628a) {
        this.f28244KV = interfaceC8628a;
    }

    @Override // com.kwad.sdk.core.NetworkMonitor.InterfaceC9881a
    /* renamed from: a */
    public final void mo24766a(NetworkMonitor.NetworkState networkState) {
        if (this.mAdInfo.status == 7 && networkState == NetworkMonitor.NetworkState.NETWORK_WIFI) {
            m30132oh();
        }
    }
}

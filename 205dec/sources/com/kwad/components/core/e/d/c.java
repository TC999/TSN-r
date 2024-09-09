package com.kwad.components.core.e.d;

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
import com.kwad.components.core.e.c.b;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.components.core.page.AdWebViewVideoActivityProxy;
import com.kwad.components.core.page.DownloadLandPageActivity;
import com.kwad.sdk.api.KsApkDownloadListener;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.NetworkMonitor;
import com.kwad.sdk.core.adlog.c;
import com.kwad.sdk.core.diskcache.ApkCacheManager;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.n.l;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ad;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.ak;
import com.kwad.sdk.utils.ay;
import com.kwad.sdk.utils.g;
import com.kwad.sdk.utils.v;
import com.kwad.sdk.utils.w;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class c implements NetworkMonitor.a, com.kwad.sdk.core.download.c, com.kwad.sdk.core.webview.a {
    @NonNull
    private AdTemplate KT;
    private boolean KU;
    private a KV;
    private DialogInterface.OnShowListener KW;
    private List<KsAppDownloadListener> KX;
    private boolean downloadPauseEnable;
    private Handler fS;
    @NonNull
    private AdInfo mAdInfo;
    private DialogInterface.OnDismissListener mOnDismissListener;
    private JSONObject mReportExtData;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public interface a {
        boolean handleDownloadDialog(DialogInterface.OnClickListener onClickListener);
    }

    public c(@NonNull AdTemplate adTemplate, JSONObject jSONObject, KsAppDownloadListener ksAppDownloadListener) {
        this.fS = new Handler(Looper.getMainLooper());
        this.KX = new ArrayList();
        this.KT = adTemplate;
        this.mAdInfo = com.kwad.sdk.core.response.b.e.dQ(adTemplate);
        this.mReportExtData = jSONObject;
        if (ksAppDownloadListener != null) {
            b(ksAppDownloadListener);
        }
        nV();
        this.downloadPauseEnable = com.kwad.sdk.core.response.b.a.cB(com.kwad.sdk.core.response.b.e.dQ(this.KT));
        nU();
        com.kwad.sdk.a.a.c.zM().aN(this.KT);
    }

    public static int A(a.C0631a c0631a) {
        AdInfo dQ = com.kwad.sdk.core.response.b.e.dQ(c0631a.getAdTemplate());
        if (dQ.downloadSafeInfo.complianceInfo != null) {
            int cU = c0631a.cU();
            if (cU != 2) {
                if (cU != 3) {
                    return dQ.downloadSafeInfo.complianceInfo.actionBarType;
                }
                return dQ.downloadSafeInfo.complianceInfo.materialJumpType;
            }
            return dQ.downloadSafeInfo.complianceInfo.describeBarType;
        }
        return 0;
    }

    private void nV() {
        com.kwad.sdk.core.download.b.De();
        int dz = com.kwad.sdk.core.download.b.dz(nX());
        if (dz != 0) {
            this.mAdInfo.status = dz;
        }
        ob();
        oa();
    }

    private boolean nZ() {
        if (Build.VERSION.SDK_INT < 29) {
            if (this.KT.mIsFromContent && com.kwad.sdk.core.config.d.Bu()) {
                r1 = of();
                if (r1) {
                    com.kwad.sdk.core.adlog.c.bI(this.KT);
                }
            } else if (!this.KT.mIsFromContent && com.kwad.sdk.core.config.d.BY()) {
                boolean aa = com.kwad.components.core.k.b.aa(ServiceProvider.getContext());
                com.kwad.sdk.core.e.c.d("ApkDownloadHelper", "handleForceOpenApp enableForceOpen: " + aa);
                r1 = aa ? of() : false;
                if (r1) {
                    com.kwad.sdk.core.adlog.c.bJ(this.KT);
                }
            }
        }
        return r1;
    }

    private void oa() {
        this.fS.post(new ay() { // from class: com.kwad.components.core.e.d.c.3
            @Override // com.kwad.sdk.utils.ay
            public final void doTask() {
                ArrayList<KsAppDownloadListener> arrayList = new ArrayList(c.this.KX.size());
                arrayList.addAll(c.this.KX);
                for (KsAppDownloadListener ksAppDownloadListener : arrayList) {
                    if (ksAppDownloadListener != null) {
                        c.this.a(ksAppDownloadListener);
                    }
                }
            }
        });
    }

    private boolean od() {
        a aVar = this.KV;
        if (aVar != null) {
            return aVar.handleDownloadDialog(new DialogInterface.OnClickListener() { // from class: com.kwad.components.core.e.d.c.4
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i4) {
                    if (i4 == -1) {
                        switch (c.this.mAdInfo.status) {
                            case 0:
                            case 1:
                            case 4:
                            case 5:
                            case 6:
                            case 7:
                                c.this.oh();
                                return;
                            case 2:
                            case 3:
                            case 10:
                            default:
                                return;
                            case 8:
                            case 9:
                            case 11:
                                c.this.og();
                                return;
                            case 12:
                                c.this.oe();
                                return;
                        }
                    }
                }
            });
        }
        return false;
    }

    private boolean of() {
        Context context = ServiceProvider.getContext();
        if (d.a(new a.C0631a(context).aq(this.KT), 1) == 1) {
            return true;
        }
        boolean ap = ak.ap(context, com.kwad.sdk.core.response.b.a.ay(this.mAdInfo));
        if (ap) {
            com.kwad.sdk.core.adlog.c.bH(this.KT);
        }
        return ap;
    }

    private boolean t(a.C0631a c0631a) {
        boolean h4 = com.kwad.sdk.utils.d.h(c0631a.getContext(), this.KT);
        if (h4) {
            com.kwad.sdk.core.adlog.c.k(this.KT, 0);
        }
        return h4;
    }

    private int u(a.C0631a c0631a) {
        Context context = c0631a.getContext();
        if (com.kwad.sdk.utils.d.a(context, com.kwad.sdk.core.response.b.a.cQ(this.mAdInfo), this.KT)) {
            com.kwad.sdk.core.adlog.c.k(this.KT, 1);
            return 11;
        } else if (t(c0631a)) {
            return 11;
        } else {
            if (od()) {
                return 10;
            }
            if (!ag.isNetworkConnected(context)) {
                v.O(context, w.bY(context));
                return 2;
            } else if (c0631a.nQ() && com.kwad.sdk.core.config.d.BL()) {
                return v(c0631a);
            } else {
                if (com.kwad.sdk.core.response.b.e.ef(this.KT) && c0631a.nS() != 2) {
                    return c(c0631a.getContext(), c0631a.getAdTemplate());
                }
                if (c0631a.nM()) {
                    return w(c0631a);
                }
                if (x(c0631a)) {
                    return 8;
                }
                return oh();
            }
        }
    }

    private int v(a.C0631a c0631a) {
        Context context = c0631a.getContext();
        AdTemplate adTemplate = c0631a.getAdTemplate();
        int nR = c0631a.nR();
        if (nR != 1) {
            if (nR != 2) {
                return 1;
            }
            if (com.kwad.sdk.core.response.b.b.cX(adTemplate)) {
                com.kwad.components.core.e.c.b.a(context, new b.a().ap(adTemplate).ae(com.kwad.sdk.core.response.b.b.cW(adTemplate)).a(this.KW).c(this.mOnDismissListener).nu());
                return 8;
            }
            return 8;
        }
        return oh();
    }

    private int w(a.C0631a c0631a) {
        Context context = c0631a.getContext();
        AdTemplate adTemplate = c0631a.getAdTemplate();
        int A = A(c0631a);
        if (A == 1) {
            if (com.kwad.sdk.core.response.b.b.cX(adTemplate)) {
                com.kwad.components.core.e.c.b.a(context, new b.a().ap(adTemplate).ae(com.kwad.sdk.core.response.b.b.cW(adTemplate)).a(this.KW).c(this.mOnDismissListener).nu());
            }
            return 8;
        } else if (A != 2) {
            if (A != 3) {
                if (x(c0631a)) {
                    return 8;
                }
                return oh();
            }
            return 1;
        } else {
            return c(c0631a.getContext(), c0631a.getAdTemplate());
        }
    }

    private boolean x(a.C0631a c0631a) {
        if (c0631a.nJ() || this.mAdInfo.status == 4 || !com.kwad.sdk.core.response.b.b.da(this.KT) || !y(c0631a)) {
            return false;
        }
        return com.kwad.components.core.e.c.b.a(c0631a.getContext(), new b.a().ap(this.KT).ae(com.kwad.sdk.core.response.b.b.cZ(this.KT)).a(this.KW).c(this.mOnDismissListener).nu());
    }

    private static boolean y(a.C0631a c0631a) {
        AdInfo dQ = com.kwad.sdk.core.response.b.e.dQ(c0631a.getAdTemplate());
        if (com.kwad.sdk.core.response.b.a.bt(dQ) && (DownloadLandPageActivity.showingAdWebViewLandPage || AdWebViewVideoActivityProxy.showingAdWebViewVideoActivity || c0631a.getAdTemplate().isWebViewDownload)) {
            return true;
        }
        return com.kwad.sdk.core.response.b.a.bu(dQ) && !ag.isWifiConnected(c0631a.getContext());
    }

    private int z(a.C0631a c0631a) {
        Activity dn = l.dn(c0631a.getContext());
        if (dn != null && com.kwad.sdk.core.response.b.a.U(this.mAdInfo) && !c0631a.nA() && !c0631a.nF()) {
            c0631a.ak(1);
            com.kwad.components.core.e.e.e.a(dn, c0631a);
            return 18;
        }
        return oe();
    }

    public final void as(int i4) {
        this.KT.downloadSource = i4;
    }

    @Override // com.kwad.sdk.core.download.c
    public final void b(String str, com.kwad.sdk.core.download.e eVar) {
        if (this.mAdInfo.downloadId.equals(str)) {
            if (this.mAdInfo.status != 4 && eVar.Di()) {
                com.kwad.sdk.core.adlog.c.a(this.KT, this.mReportExtData);
                eVar.Dh();
                com.kwad.sdk.commercial.a.a.aU(this.KT);
            }
            this.mAdInfo.status = 4;
            oa();
        }
    }

    public final void clear() {
        ok();
        com.kwad.sdk.core.download.b.De().a(this);
        if (com.kwad.sdk.core.config.d.Ck()) {
            NetworkMonitor.getInstance().a(this);
        }
    }

    @Override // com.kwad.sdk.core.download.c
    public final void f(String str, com.kwad.sdk.core.download.e eVar) {
        if (this.mAdInfo.downloadId.equals(str)) {
            ob();
            if (eVar.Di()) {
                eVar.Dh();
                com.kwad.sdk.commercial.a.a.ba(this.KT);
            }
        }
    }

    @Override // com.kwad.sdk.core.download.c
    public final void g(String str, com.kwad.sdk.core.download.e eVar) {
        if (this.mAdInfo.downloadId.equals(str) && eVar.Di()) {
            eVar.Dh();
            com.kwad.sdk.core.adlog.c.bG(this.KT);
            com.kwad.sdk.commercial.a.a.aX(this.KT);
        }
    }

    public final void nU() {
        com.kwad.sdk.core.download.b.De().a(this, this.KT);
        if (com.kwad.sdk.core.config.d.Ck()) {
            NetworkMonitor.getInstance().a(ServiceProvider.getContext(), this);
        }
    }

    public final int nW() {
        ob();
        int i4 = this.mAdInfo.status;
        if (i4 == 3) {
            return 2;
        }
        return i4;
    }

    @Override // com.kwad.sdk.core.download.c
    public final String nX() {
        return this.mAdInfo.downloadId;
    }

    @Override // com.kwad.sdk.core.download.c
    public final String nY() {
        return this.mAdInfo.adBaseInfo.appPackageName;
    }

    public final void ob() {
        if (ak.an(ServiceProvider.getContext(), this.mAdInfo.adBaseInfo.appPackageName)) {
            this.mAdInfo.status = 12;
            return;
        }
        AdInfo adInfo = this.mAdInfo;
        if (adInfo.status == 12) {
            adInfo.status = 0;
            adInfo.progress = 0;
        }
        int i4 = adInfo.status;
        if (i4 == 8 || i4 == 9) {
            String str = adInfo.downloadFilePath;
            if (TextUtils.isEmpty(str) || !new File(str).exists()) {
                AdInfo adInfo2 = this.mAdInfo;
                adInfo2.status = 0;
                adInfo2.progress = 0;
            }
        }
        AdInfo adInfo3 = this.mAdInfo;
        if (adInfo3.status == 0) {
            String H = com.kwad.sdk.core.download.a.H(adInfo3);
            if (TextUtils.isEmpty(H) || !new File(H).exists()) {
                return;
            }
            AdInfo adInfo4 = this.mAdInfo;
            adInfo4.downloadFilePath = H;
            adInfo4.status = 8;
        }
    }

    @NonNull
    public final AdTemplate oc() {
        return this.KT;
    }

    public final int oe() {
        g.execute(new ay() { // from class: com.kwad.components.core.e.d.c.5
            @Override // com.kwad.sdk.utils.ay
            public final void doTask() {
                com.kwad.sdk.components.c.f(com.kwad.components.a.a.a.class);
            }
        });
        if (ak.ap(ServiceProvider.getContext(), com.kwad.sdk.core.response.b.a.ay(this.mAdInfo))) {
            com.kwad.sdk.core.adlog.c.bH(this.KT);
            return 6;
        }
        return 6;
    }

    public final int og() {
        ak.a(this.mAdInfo.downloadFilePath, new ak.a() { // from class: com.kwad.components.core.e.d.c.6
            @Override // com.kwad.sdk.utils.ak.a
            public final void d(Throwable th) {
                com.kwad.sdk.commercial.a.a.i(c.this.KT, 100003, Log.getStackTraceString(th));
            }

            @Override // com.kwad.sdk.utils.ak.a
            public final void ol() {
                com.kwad.sdk.core.adlog.c.h(c.this.KT, 1);
                com.kwad.sdk.commercial.a.a.aY(c.this.KT);
            }
        });
        return 7;
    }

    public final int oh() {
        com.kwad.sdk.core.download.a.I(this.mAdInfo);
        return 3;
    }

    public final int oi() {
        com.kwad.sdk.core.download.a.dw(this.mAdInfo.downloadId);
        return 4;
    }

    public final int oj() {
        oh();
        return 5;
    }

    @Override // com.kwad.sdk.core.webview.a
    public final void ok() {
        List<KsAppDownloadListener> list = this.KX;
        if (list != null) {
            list.clear();
        }
    }

    public final int q(a.C0631a c0631a) {
        int i4 = this.mAdInfo.status;
        if (i4 != 0 && i4 != 1) {
            switch (i4) {
                case 4:
                case 5:
                case 6:
                case 7:
                    break;
                case 8:
                case 9:
                case 10:
                case 11:
                    return og();
                case 12:
                    return z(c0631a);
                default:
                    return 0;
            }
        }
        return t(c0631a) ? 11 : 0;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final int r(a.C0631a c0631a) {
        this.KU = false;
        ob();
        switch (this.mAdInfo.status) {
            case 0:
            case 1:
            case 5:
            case 6:
            case 7:
                return u(c0631a);
            case 2:
            case 3:
                if (c0631a.nH() && this.downloadPauseEnable) {
                    return oi();
                }
                break;
            case 4:
                return oj();
            case 8:
            case 9:
            case 11:
                return og();
            case 12:
                return z(c0631a);
        }
        return 0;
    }

    public final boolean s(a.C0631a c0631a) {
        return this.mAdInfo.status == 0 && t(c0631a);
    }

    public final void setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        this.mOnDismissListener = onDismissListener;
    }

    public final void setOnShowListener(DialogInterface.OnShowListener onShowListener) {
        this.KW = onShowListener;
    }

    @Override // com.kwad.sdk.core.download.c
    public final void a(String str, com.kwad.sdk.core.download.e eVar) {
        if (this.mAdInfo.downloadId.equals(str)) {
            this.mAdInfo.status = 1;
            oa();
            if (eVar.Di()) {
                this.mAdInfo.mStartDownloadTime = SystemClock.elapsedRealtime();
                com.kwad.sdk.core.adlog.c.bF(this.KT);
                eVar.Dh();
                com.kwad.sdk.commercial.a.a.o(this.KT);
            }
        }
    }

    @Override // com.kwad.sdk.core.download.c
    public final void c(String str, com.kwad.sdk.core.download.e eVar) {
        if (this.mAdInfo.downloadId.equals(str)) {
            if (this.mAdInfo.status != 2 && eVar.Di()) {
                com.kwad.sdk.core.adlog.c.b(this.KT, this.mReportExtData);
                eVar.Dh();
                com.kwad.sdk.commercial.a.a.aV(this.KT);
            }
            this.mAdInfo.status = 2;
            oa();
        }
    }

    public final void d(JSONObject jSONObject) {
        this.mReportExtData = jSONObject;
    }

    @Override // com.kwad.sdk.core.download.c
    public final void e(String str, com.kwad.sdk.core.download.e eVar) {
        if (this.mAdInfo.downloadId.equals(str)) {
            this.mAdInfo.status = 9;
            oa();
            if (eVar.Di()) {
                com.kwad.sdk.core.adlog.c.h(this.KT, 2);
                eVar.Dh();
                com.kwad.sdk.commercial.a.a.aY(this.KT);
            }
        }
    }

    @Override // com.kwad.sdk.core.download.c
    public final void d(String str, com.kwad.sdk.core.download.e eVar) {
        if (this.mAdInfo.downloadId.equals(str)) {
            if (this.mAdInfo.status != 5 && eVar.Di()) {
                com.kwad.sdk.core.adlog.c.d(this.KT, this.mReportExtData);
                eVar.Dh();
                com.kwad.sdk.commercial.a.a.aW(this.KT);
            }
            com.kwad.sdk.a.a.c.zM().aO(this.KT);
            com.kwad.sdk.a.a.b.zJ().aJ(this.KT);
            this.mAdInfo.status = 5;
            oa();
        }
    }

    @Override // com.kwad.sdk.core.download.c
    public final void b(String str, String str2, com.kwad.sdk.core.download.e eVar) {
        final boolean z3;
        this.mAdInfo.status = 12;
        oa();
        if (eVar.Di()) {
            com.kwad.sdk.core.adlog.c.e(this.KT, this.mReportExtData);
            eVar.Dh();
            com.kwad.sdk.commercial.a.a.aZ(this.KT);
            z3 = nZ();
            com.kwad.sdk.a.a.c.zM().aQ(this.KT);
            com.kwad.sdk.a.a.c.zM().aO(this.KT);
            com.kwad.sdk.a.a.b.zJ().aJ(this.KT);
            com.kwad.components.core.e.a.e.nf().am(this.KT);
            com.kwad.sdk.core.a.Bc().cW(nX());
        } else {
            z3 = false;
        }
        g.execute(new ay() { // from class: com.kwad.components.core.e.d.c.2
            @Override // com.kwad.sdk.utils.ay
            public final void doTask() {
                com.kwad.sdk.components.c.f(com.kwad.components.a.a.a.class);
            }
        });
    }

    public final void c(final KsAppDownloadListener ksAppDownloadListener) {
        if (ksAppDownloadListener == null) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            this.KX.remove(ksAppDownloadListener);
        } else {
            this.fS.post(new ay() { // from class: com.kwad.components.core.e.d.c.8
                @Override // com.kwad.sdk.utils.ay
                public final void doTask() {
                    c.this.KX.remove(ksAppDownloadListener);
                }
            });
        }
    }

    @Override // com.kwad.sdk.core.download.c
    public final void a(String str, int i4, int i5, int i6) {
        if (this.mAdInfo.downloadId.equals(str)) {
            AdInfo adInfo = this.mAdInfo;
            adInfo.status = 3;
            adInfo.progress = i4;
            adInfo.soFarBytes = i5;
            adInfo.totalBytes = i6;
            oa();
        }
    }

    private static int c(Context context, AdTemplate adTemplate) {
        if (context == null || adTemplate == null) {
            return 9;
        }
        DownloadLandPageActivity.launch(context, adTemplate, false);
        return 9;
    }

    public final void d(KsAppDownloadListener ksAppDownloadListener) {
        if (ksAppDownloadListener == null) {
            return;
        }
        ob();
        a(ksAppDownloadListener);
    }

    public c(@NonNull AdTemplate adTemplate, @NonNull KsAppDownloadListener ksAppDownloadListener) {
        this(adTemplate, null, ksAppDownloadListener);
    }

    public c(@NonNull AdTemplate adTemplate, JSONObject jSONObject) {
        this(adTemplate, jSONObject, null);
    }

    public c(@NonNull AdTemplate adTemplate) {
        this(adTemplate, null, null);
    }

    public c(@NonNull AdTemplate adTemplate, KsAppDownloadListener ksAppDownloadListener, String str, String str2) {
        this(adTemplate, null, null);
        AdInfo adInfo = this.mAdInfo;
        adInfo.adConversionInfo.appDownloadUrl = str;
        adInfo.adBaseInfo.appPackageName = str2;
        adInfo.downloadId = ad.bu(str);
    }

    @Override // com.kwad.sdk.core.download.c
    public final void a(String str, String str2, com.kwad.sdk.core.download.e eVar) {
        if (this.mAdInfo.downloadId.equals(str)) {
            AdInfo adInfo = this.mAdInfo;
            adInfo.downloadFilePath = str2;
            adInfo.progress = 100;
            adInfo.status = 8;
            oa();
            if (eVar.Di()) {
                eVar.Dh();
                com.kwad.sdk.core.adlog.c.c(this.KT, this.mReportExtData);
                com.kwad.sdk.commercial.a.a.j(this.KT, SystemClock.elapsedRealtime() - this.mAdInfo.mStartDownloadTime);
                com.kwad.sdk.core.a.Bc().e(str, this.KT);
                g.execute(new Runnable() { // from class: com.kwad.components.core.e.d.c.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        com.kwad.sdk.components.c.f(com.kwad.components.a.a.a.class);
                    }
                });
                com.kwad.sdk.a.a.c.zM().aP(this.KT);
                com.kwad.sdk.a.a.c.zM().aN(this.KT);
                com.kwad.sdk.a.a.b.zJ().aI(this.KT);
                ApkCacheManager.getInstance().CR();
            }
        }
    }

    @UiThread
    public final void b(final KsAppDownloadListener ksAppDownloadListener) {
        if (ksAppDownloadListener == null) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            if (!this.KX.contains(ksAppDownloadListener)) {
                this.KX.add(0, ksAppDownloadListener);
            }
        } else {
            this.fS.post(new ay() { // from class: com.kwad.components.core.e.d.c.7
                @Override // com.kwad.sdk.utils.ay
                public final void doTask() {
                    if (c.this.KX.contains(ksAppDownloadListener)) {
                        return;
                    }
                    c.this.KX.add(0, ksAppDownloadListener);
                }
            });
        }
        ob();
        a(ksAppDownloadListener);
    }

    @Override // com.kwad.sdk.core.download.c
    public final void a(String str, int i4, String str2, com.kwad.sdk.core.download.e eVar) {
        if (this.mAdInfo.downloadId.equals(str)) {
            this.mAdInfo.status = 7;
            oa();
            if (eVar.Di()) {
                c.a aVar = new c.a(i4, str2);
                com.kwad.sdk.core.adlog.c.a(this.KT, aVar);
                com.kwad.components.core.o.a.qi().a(this.KT, this.mAdInfo.adConversionInfo.appDownloadUrl, aVar.toJson().toString());
                eVar.Dh();
                com.kwad.sdk.commercial.a.a.h(this.KT, i4, str2);
            }
            if (this.mAdInfo.adConversionInfo.retryH5TimeStep <= 0 || this.KU) {
                return;
            }
            long elapsedRealtime = SystemClock.elapsedRealtime();
            AdInfo adInfo = this.mAdInfo;
            if (elapsedRealtime - adInfo.mStartDownloadTime >= adInfo.adConversionInfo.retryH5TimeStep || TextUtils.isEmpty(com.kwad.sdk.core.response.b.a.aS(adInfo))) {
                return;
            }
            AdWebViewActivityProxy.launch(ServiceProvider.getContext(), this.KT);
            this.KU = true;
        }
    }

    @Override // com.kwad.sdk.core.download.c
    public final void a(String str, Throwable th, com.kwad.sdk.core.download.e eVar) {
        if (this.mAdInfo.downloadId.equals(str)) {
            this.mAdInfo.status = 11;
            oa();
            if (eVar.Di()) {
                eVar.Dh();
                com.kwad.sdk.commercial.a.a.i(this.KT, 100003, Log.getStackTraceString(th));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@NonNull KsAppDownloadListener ksAppDownloadListener) {
        AdInfo adInfo = this.mAdInfo;
        int i4 = adInfo.progress;
        switch (adInfo.status) {
            case 0:
            case 5:
                ksAppDownloadListener.onIdle();
                return;
            case 1:
                ksAppDownloadListener.onProgressUpdate(0);
                if (ksAppDownloadListener instanceof com.kwad.sdk.core.download.a.a) {
                    ((com.kwad.sdk.core.download.a.a) ksAppDownloadListener).onDownloadStarted();
                    return;
                }
                try {
                    ksAppDownloadListener.onDownloadStarted();
                    return;
                } catch (Throwable th) {
                    com.kwad.sdk.core.e.c.printStackTraceOnly(th);
                    return;
                }
            case 2:
            case 3:
                ksAppDownloadListener.onProgressUpdate(i4);
                return;
            case 4:
                if (ksAppDownloadListener instanceof com.kwad.sdk.core.download.a.a) {
                    ((com.kwad.sdk.core.download.a.a) ksAppDownloadListener).onPaused(i4);
                }
                try {
                    if (ksAppDownloadListener instanceof KsApkDownloadListener) {
                        ((KsApkDownloadListener) ksAppDownloadListener).onPaused(i4);
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

    public final void a(a aVar) {
        this.KV = aVar;
    }

    @Override // com.kwad.sdk.core.NetworkMonitor.a
    public final void a(NetworkMonitor.NetworkState networkState) {
        if (this.mAdInfo.status == 7 && networkState == NetworkMonitor.NetworkState.NETWORK_WIFI) {
            oh();
        }
    }
}

package com.qq.e.comm.plugin.banner2;

import android.app.Activity;
import android.view.View;
import android.widget.FrameLayout;
import com.qq.e.ads.banner2.UnifiedBannerView;
import com.qq.e.ads.rewardvideo.ServerSideVerificationOptions;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.compliance.DownloadConfirmListener;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.pi.UBVI;
import com.qq.e.comm.plugin.util.d1;
import com.qq.e.comm.plugin.util.n2;
import com.qq.e.comm.plugin.util.o2;
import com.qq.e.comm.plugin.util.p0;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.mediation.interfaces.BaseBannerAd;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import qa.fg.ck;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
class g extends com.qq.e.comm.plugin.e0.d.a<BaseBannerAd> implements UBVI {
    private final List<Integer> A;
    private volatile boolean B;
    private String C;
    private final Runnable D;

    /* renamed from: t  reason: collision with root package name */
    private final UnifiedBannerView f42103t;

    /* renamed from: u  reason: collision with root package name */
    private final ADListener f42104u;

    /* renamed from: v  reason: collision with root package name */
    private final Activity f42105v;

    /* renamed from: w  reason: collision with root package name */
    private BaseBannerAd f42106w;

    /* renamed from: x  reason: collision with root package name */
    private LoadAdParams f42107x;

    /* renamed from: y  reason: collision with root package name */
    private int f42108y;

    /* renamed from: z  reason: collision with root package name */
    private final List<BaseBannerAd> f42109z;

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            g.this.fetchAd();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class b implements ADListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ BaseBannerAd f42111a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f42112b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ long f42113c;

        b(BaseBannerAd baseBannerAd, int i4, long j4) {
            this.f42111a = baseBannerAd;
            this.f42112b = i4;
            this.f42113c = j4;
        }

        @Override // com.qq.e.comm.adevent.ADListener
        public void onADEvent(ADEvent aDEvent) {
            int type = aDEvent.getType();
            if (type == 100) {
                if (this.f42111a.getAdView() != null) {
                    n2.a(this.f42111a.getAdView());
                }
                g.this.a(com.qq.e.comm.plugin.b.g.UNIFIED_BANNER, this.f42112b, this.f42113c, (long) this.f42111a);
                g.this.f(this.f42111a);
            } else if (type == 101) {
                if (((Integer) aDEvent.getParam(Integer.class)) != null) {
                    if (this.f42111a.getAdView() != null) {
                        n2.a(this.f42111a.getAdView());
                    }
                    g.this.a(com.qq.e.comm.plugin.b.g.UNIFIED_BANNER, this.f42112b, this.f42113c, (long) this.f42111a);
                    g.this.a((g) this.f42111a, aDEvent);
                }
            } else if (type == 103) {
                if (g.this.B) {
                    g.this.A.add(Integer.valueOf(this.f42111a.hashCode()));
                } else {
                    g.this.e2(this.f42111a);
                }
            } else if (type != 105) {
                switch (type) {
                    case 401:
                    case 402:
                    case 403:
                    case 404:
                    case 405:
                    case 406:
                        com.qq.e.comm.plugin.e0.d.g.a(aDEvent, g.this.C, com.qq.e.comm.plugin.b.g.UNIFIED_BANNER, this.f42111a);
                        return;
                    case 407:
                        com.qq.e.comm.plugin.e0.d.g.a(this.f42111a, 1143007);
                        return;
                    default:
                        if (g.this.f42104u != null) {
                            g.this.f42104u.onADEvent(aDEvent);
                            return;
                        }
                        return;
                }
            } else {
                g.this.c(this.f42111a, 70642);
                if (g.this.f42104u != null) {
                    g.this.f42104u.onADEvent(aDEvent);
                }
            }
        }
    }

    public g(UnifiedBannerView unifiedBannerView, Activity activity, String str, String str2, ADListener aDListener) {
        super(activity, str2);
        this.f42108y = 20;
        this.f42109z = new ArrayList();
        this.A = new ArrayList();
        this.B = false;
        this.D = new a();
        this.f42103t = unifiedBannerView;
        this.f42104u = aDListener;
        this.f42105v = activity;
        this.C = str2;
    }

    private void o() {
        ADListener aDListener = this.f42104u;
        if (aDListener != null) {
            aDListener.onADEvent(new ADEvent(101, 5004));
        }
    }

    private void p() {
        View adView = this.f42106w.getAdView();
        if (adView == null) {
            o();
            return;
        }
        ADListener aDListener = this.f42104u;
        if (aDListener != null) {
            aDListener.onADEvent(new ADEvent(100, new Object[0]));
        }
        this.f42103t.removeAllViews();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.f42103t.addView(adView, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.comm.plugin.e0.d.a
    /* renamed from: a */
    public void b(BaseBannerAd baseBannerAd, int i4, String str) {
    }

    @Override // com.qq.e.comm.pi.UBVI
    public void destroy() {
        this.f42103t.removeAllViews();
        BaseBannerAd baseBannerAd = this.f42106w;
        if (baseBannerAd != null) {
            baseBannerAd.destroy();
        }
        p0.e(this.D);
    }

    @Override // com.qq.e.comm.pi.UBVI
    public void fetchAd() {
        d1.a("UnifiedBannerViewMediator fetchAd start", new Object[0]);
        if (o2.a(this.f42771f, this.f42103t, 1)) {
            this.B = true;
            d1.a("UnifiedBannerViewMediator fetchAd loadAdInternal", new Object[0]);
            l();
        } else {
            GDTLogger.w("UnifiedBannerView is invisible, fetchAd delay");
        }
        if (this.f42108y > 0) {
            p0.e(this.D);
            p0.a(this.D, this.f42108y * 1000);
        }
    }

    @Override // com.qq.e.comm.pi.UBVI
    public String getAdNetWorkName() {
        return k();
    }

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public String getApkInfoUrl() {
        return null;
    }

    @Override // com.qq.e.comm.pi.LADI
    public int getECPM() {
        BaseBannerAd baseBannerAd = this.f42106w;
        if (baseBannerAd != null) {
            return baseBannerAd.getECPM();
        }
        return -1;
    }

    @Override // com.qq.e.comm.pi.LADI
    public Map<String, Object> getExtraInfo() {
        BaseBannerAd baseBannerAd = this.f42106w;
        if (baseBannerAd != null) {
            return c((g) baseBannerAd);
        }
        return new HashMap();
    }

    @Override // com.qq.e.comm.pi.LADI
    public boolean isValid() {
        BaseBannerAd baseBannerAd = this.f42106w;
        if (baseBannerAd != null) {
            baseBannerAd.isValid();
            return false;
        }
        return false;
    }

    @Override // com.qq.e.comm.pi.UBVI
    public void onWindowFocusChanged(boolean z3) {
        BaseBannerAd baseBannerAd = this.f42106w;
        if (baseBannerAd instanceof ANUnifiedBannerAdapter) {
            ((ANUnifiedBannerAdapter) baseBannerAd).onWindowFocusChanged(z3);
        }
    }

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public void setDownloadConfirmListener(DownloadConfirmListener downloadConfirmListener) {
    }

    @Override // com.qq.e.comm.pi.UBVI
    public void setLoadAdParams(LoadAdParams loadAdParams) {
        this.f42107x = loadAdParams;
    }

    @Override // com.qq.e.comm.pi.UBVI
    public void setRefresh(int i4) {
        if ((i4 > 0 && i4 < 10) || i4 < 0) {
            this.f42108y = 10;
        } else if (i4 > 150) {
            this.f42108y = 150;
        } else {
            this.f42108y = i4;
        }
    }

    @Override // com.qq.e.comm.pi.UBVI
    public void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions) {
        BaseBannerAd baseBannerAd = this.f42106w;
        if (baseBannerAd != null) {
            baseBannerAd.setServerSideVerificationOptions(serverSideVerificationOptions);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e  reason: avoid collision after fix types in other method */
    public void e2(BaseBannerAd baseBannerAd) {
        d(baseBannerAd, 70632);
        ADListener aDListener = this.f42104u;
        if (aDListener != null) {
            aDListener.onADEvent(new ADEvent(103, new Object[0]));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.comm.plugin.e0.d.a
    /* renamed from: c */
    public BaseBannerAd b(com.qq.e.comm.plugin.e0.e.d dVar) {
        if (dVar != null) {
            try {
                BaseBannerAd a4 = c.a(dVar.e(), this.f42105v, dVar.b(), dVar.p(), dVar.j());
                this.f42109z.add(a4);
                return a4;
            } catch (Exception unused) {
                a(70652, dVar);
                return null;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.comm.plugin.e0.d.a
    /* renamed from: d  reason: avoid collision after fix types in other method */
    public void e(BaseBannerAd baseBannerAd) {
        a(com.qq.e.comm.plugin.b.g.UNIFIED_BANNER);
        this.B = false;
        a2(baseBannerAd);
        BaseBannerAd baseBannerAd2 = this.f42106w;
        if (baseBannerAd2 != null) {
            n2.a(baseBannerAd2.getAdView());
            this.f42106w.destroy();
        }
        this.f42106w = baseBannerAd;
        if (baseBannerAd != null) {
            p();
            if (this.A.contains(Integer.valueOf(this.f42106w.hashCode()))) {
                e2(this.f42106w);
            }
            this.A.clear();
            return;
        }
        o();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.comm.plugin.e0.d.a
    /* renamed from: b */
    public int a(BaseBannerAd baseBannerAd) {
        return baseBannerAd.getECPM();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.comm.plugin.e0.d.a
    /* renamed from: a */
    public void b(BaseBannerAd baseBannerAd, int i4) {
        LoadAdParams loadAdParams;
        if ((baseBannerAd instanceof ANUnifiedBannerAdapter) && (loadAdParams = this.f42107x) != null) {
            ((ANUnifiedBannerAdapter) baseBannerAd).setLoadAdParams(loadAdParams);
        }
        baseBannerAd.setAdSize(this.f42103t.getWidth(), this.f42103t.getHeight());
        baseBannerAd.setAdListener(new b(baseBannerAd, i4, System.currentTimeMillis()));
        if (baseBannerAd.getAdView() != null) {
            this.f42103t.addView(baseBannerAd.getAdView());
        }
        ck.a(baseBannerAd);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.comm.plugin.e0.d.a
    /* renamed from: c */
    public String d(BaseBannerAd baseBannerAd) {
        if (b()) {
            return baseBannerAd.getReqId();
        }
        return null;
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private void a2(BaseBannerAd baseBannerAd) {
        for (BaseBannerAd baseBannerAd2 : this.f42109z) {
            if (baseBannerAd2 != baseBannerAd) {
                baseBannerAd2.destroy();
            }
        }
        this.f42109z.clear();
    }
}

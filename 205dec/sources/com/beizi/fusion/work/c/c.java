package com.beizi.fusion.work.c;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.View;
import com.beizi.fusion.d.e;
import com.beizi.fusion.d.h;
import com.beizi.fusion.d.k;
import com.beizi.fusion.g.af;
import com.beizi.fusion.g.al;
import com.beizi.fusion.g.aw;
import com.beizi.fusion.g.n;
import com.beizi.fusion.g.v;
import com.beizi.fusion.model.AdSpacesBean;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.interstitial2.UnifiedInterstitialAD;
import com.qq.e.ads.interstitial2.UnifiedInterstitialADListener;
import com.qq.e.comm.managers.status.SDKStatus;
import com.qq.e.comm.util.AdError;
import java.util.Map;
import xyz.adscope.amps.common.AMPSConstants;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: GdtFullScreenVideoWorker.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class c extends com.beizi.fusion.work.a implements com.beizi.fusion.d.c {

    /* renamed from: n  reason: collision with root package name */
    private Context f15495n;

    /* renamed from: o  reason: collision with root package name */
    private String f15496o;

    /* renamed from: p  reason: collision with root package name */
    private long f15497p;

    /* renamed from: q  reason: collision with root package name */
    private long f15498q;

    /* renamed from: r  reason: collision with root package name */
    private boolean f15499r;

    /* renamed from: s  reason: collision with root package name */
    private UnifiedInterstitialAD f15500s;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: GdtFullScreenVideoWorker.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public class a implements UnifiedInterstitialADListener {

        /* renamed from: a  reason: collision with root package name */
        boolean f15502a;

        /* renamed from: b  reason: collision with root package name */
        boolean f15503b;

        private a() {
            this.f15502a = false;
            this.f15503b = false;
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public void onADClicked() {
            Log.d("BeiZis", "showGdtFullScreenVideo onADClicked()");
            if (((com.beizi.fusion.work.a) c.this).f15367d != null && ((com.beizi.fusion.work.a) c.this).f15367d.s() != 2) {
                ((com.beizi.fusion.work.a) c.this).f15367d.d(c.this.g());
            }
            if (this.f15503b) {
                return;
            }
            this.f15503b = true;
            c.this.E();
            c.this.ai();
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public void onADClosed() {
            Log.d("BeiZis", "showGdtFullScreenVideo onADClosed()");
            if (((com.beizi.fusion.work.a) c.this).f15367d != null && ((com.beizi.fusion.work.a) c.this).f15367d.s() != 2) {
                ((com.beizi.fusion.work.a) c.this).f15367d.c(c.this.g());
            }
            c.this.G();
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public void onADExposure() {
            Log.d("BeiZis", "showGdtFullScreenVideo onADExposure()");
            ((com.beizi.fusion.work.a) c.this).f15373j = com.beizi.fusion.f.a.ADSHOW;
            if (((com.beizi.fusion.work.a) c.this).f15367d != null && ((com.beizi.fusion.work.a) c.this).f15367d.s() != 2) {
                ((com.beizi.fusion.work.a) c.this).f15367d.b(c.this.g());
            }
            if (this.f15502a) {
                return;
            }
            this.f15502a = true;
            c.this.az();
            c.this.C();
            c.this.D();
            c.this.ah();
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public void onADLeftApplication() {
            Log.d("BeiZis", "showGdtFullScreenVideo onADLeftApplication()");
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public void onADOpened() {
            Log.d("BeiZis", "showGdtFullScreenVideo onADOpened()");
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public void onADReceive() {
            Log.d("BeiZis", "showGdtFullScreenVideo onADReceive()");
            if (c.this.f15500s.getECPM() > 0) {
                c cVar = c.this;
                cVar.a(cVar.f15500s.getECPM());
            }
            if (v.f14982a) {
                c.this.f15500s.setDownloadConfirmListener(v.f14983b);
            }
            ((com.beizi.fusion.work.a) c.this).f15373j = com.beizi.fusion.f.a.ADLOAD;
            c.this.y();
            if (c.this.Y()) {
                c.this.b();
            } else {
                c.this.O();
            }
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public void onNoAD(AdError adError) {
            Log.d("BeiZis", "showGdtFullScreenVideo onError:" + adError.getErrorMsg());
            c.this.a(adError.getErrorMsg(), adError.getErrorCode());
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public void onRenderFail() {
            Log.d("BeiZis", "showGdtFullScreenVideo onRenderFail()");
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public void onRenderSuccess() {
            Log.d("BeiZis", "showGdtFullScreenVideo onRenderSuccess()");
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public void onVideoCached() {
            Log.d("BeiZis", "showGdtFullScreenVideo onVideoCached()");
        }
    }

    public c(Context context, String str, long j4, long j5, AdSpacesBean.BuyerBean buyerBean, AdSpacesBean.ForwardBean forwardBean, e eVar) {
        this.f15495n = context;
        this.f15496o = str;
        this.f15497p = j4;
        this.f15498q = j5;
        this.f15368e = buyerBean;
        this.f15367d = eVar;
        this.f15369f = forwardBean;
        r();
    }

    @Override // com.beizi.fusion.work.a
    protected void A() {
        if (!z() || this.f15500s == null) {
            return;
        }
        al();
        int a4 = al.a(this.f15368e.getPriceDict(), this.f15500s.getECPMLevel());
        if (a4 == -1 || a4 == -2) {
            if (a4 == -2) {
                L();
                return;
            }
            return;
        }
        Log.d("BeiZisBid", "gdt realPrice = " + a4);
        a((double) a4);
    }

    @Override // com.beizi.fusion.work.a
    public void az() {
        UnifiedInterstitialAD unifiedInterstitialAD = this.f15500s;
        if (unifiedInterstitialAD == null || unifiedInterstitialAD.getECPM() <= 0 || this.f15499r) {
            return;
        }
        this.f15499r = true;
        af.a("BeiZis", "channel == GDT\u7ade\u4ef7\u6210\u529f");
        af.a("BeiZis", "channel == sendWinNoticeECPM" + this.f15500s.getECPM());
        UnifiedInterstitialAD unifiedInterstitialAD2 = this.f15500s;
        k.a(unifiedInterstitialAD2, unifiedInterstitialAD2.getECPM());
    }

    @Override // com.beizi.fusion.work.a
    public void f() {
    }

    @Override // com.beizi.fusion.work.a
    public String g() {
        return AMPSConstants.AMPS_CHANNEL_NETWORK_NAME_GDT;
    }

    @Override // com.beizi.fusion.work.a
    public void d() {
        if (this.f15367d == null) {
            return;
        }
        this.f15371h = this.f15368e.getAppId();
        this.f15372i = this.f15368e.getSpaceId();
        this.f15366c = this.f15368e.getBuyerSpaceUuId();
        com.beizi.fusion.b.d dVar = this.f15364a;
        if (dVar != null) {
            com.beizi.fusion.b.b a4 = dVar.a().a(this.f15366c);
            this.f15365b = a4;
            if (a4 != null) {
                s();
                if (!aw.a(AMPSConstants.CHANNEL_SDK_GDT_CLASSNAME)) {
                    t();
                    this.f15376m.postDelayed(new Runnable() { // from class: com.beizi.fusion.work.c.c.1
                        @Override // java.lang.Runnable
                        public void run() {
                            c.this.c(10151);
                        }
                    }, 10L);
                    Log.e("BeiZis", "GDT sdk not import , will do nothing");
                    return;
                }
                u();
                k.a(this.f15495n, this.f15371h);
                this.f15365b.s(SDKStatus.getIntegrationSDKVersion());
                au();
                v();
            }
        }
        v.f14982a = !n.a(this.f15368e.getDirectDownload());
        Log.d("BeiZis", g() + ":requestAd:" + this.f15371h + "====" + this.f15372i + "===" + this.f15498q);
        long j4 = this.f15498q;
        if (j4 > 0) {
            this.f15376m.sendEmptyMessageDelayed(1, j4);
            return;
        }
        e eVar = this.f15367d;
        if (eVar == null || eVar.t() >= 1 || this.f15367d.s() == 2) {
            return;
        }
        l();
    }

    @Override // com.beizi.fusion.work.a
    public com.beizi.fusion.f.a i() {
        return this.f15373j;
    }

    @Override // com.beizi.fusion.work.a
    public String j() {
        UnifiedInterstitialAD unifiedInterstitialAD = this.f15500s;
        if (unifiedInterstitialAD != null) {
            int a4 = al.a(this.f15368e.getPriceDict(), unifiedInterstitialAD.getECPMLevel());
            if (a4 == -1 || a4 == -2) {
                return null;
            }
            return a4 + "";
        }
        return null;
    }

    @Override // com.beizi.fusion.work.a
    public AdSpacesBean.BuyerBean k() {
        return this.f15368e;
    }

    @Override // com.beizi.fusion.work.a
    protected void l() {
        w();
        ag();
        Activity activity = (Activity) this.f15495n;
        if (AMPSConstants.BiddingType.BIDDING_TYPE_S2S.equalsIgnoreCase(this.f15368e.getBidType())) {
            this.f15500s = new UnifiedInterstitialAD(activity, this.f15372i, new a(), null, aC());
        } else {
            this.f15500s = new UnifiedInterstitialAD(activity, this.f15372i, new a());
        }
        this.f15500s.setVideoOption(new VideoOption.Builder().setAutoPlayMuted(true).build());
        this.f15500s.loadFullScreenAD();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        e eVar = this.f15367d;
        if (eVar == null) {
            return;
        }
        Map<String, com.beizi.fusion.work.a> r3 = eVar.r();
        Log.d("BeiZis", g() + " FullScreenVideoWorkers:" + r3.toString());
        Z();
        h hVar = this.f15370g;
        if (hVar == h.SUCCESS) {
            e eVar2 = this.f15367d;
            if (eVar2 != null) {
                eVar2.a(g(), (View) null);
            }
        } else if (hVar == h.FAIL) {
            Log.d("BeiZis", "other worker shown," + g() + " remove");
        }
    }

    @Override // com.beizi.fusion.work.a
    public void a(Activity activity) {
        UnifiedInterstitialAD unifiedInterstitialAD = this.f15500s;
        if (unifiedInterstitialAD != null && unifiedInterstitialAD.isValid() && activity != null) {
            this.f15500s.showFullScreenAD(activity);
            return;
        }
        e eVar = this.f15367d;
        if (eVar != null) {
            eVar.a(10140);
        }
    }

    @Override // com.beizi.fusion.work.a
    public void d(int i4) {
        UnifiedInterstitialAD unifiedInterstitialAD = this.f15500s;
        if (unifiedInterstitialAD == null || unifiedInterstitialAD.getECPM() <= 0 || this.f15499r) {
            return;
        }
        this.f15499r = true;
        af.a("BeiZis", "channel == GDT\u7ade\u4ef7\u5931\u8d25:" + i4);
        k.b(this.f15500s, i4 != 1 ? 10001 : 1);
    }
}

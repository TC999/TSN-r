package com.beizi.fusion.work.nativead;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import com.baidu.mobads.sdk.api.AdSettings;
import com.baidu.mobads.sdk.api.BaiduNativeManager;
import com.baidu.mobads.sdk.api.ExpressResponse;
import com.beizi.fusion.g.af;
import com.beizi.fusion.g.av;
import com.beizi.fusion.model.AdSpacesBean;
import com.stub.StubApp;
import java.util.List;
import java.util.Map;
import xyz.adscope.amps.common.AMPSConstants;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: BaiduNativeAdWorker.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class a extends com.beizi.fusion.work.a implements com.beizi.fusion.d.c {

    /* renamed from: n  reason: collision with root package name */
    private Context f15775n;

    /* renamed from: o  reason: collision with root package name */
    private String f15776o;

    /* renamed from: p  reason: collision with root package name */
    private long f15777p;

    /* renamed from: q  reason: collision with root package name */
    private long f15778q;

    /* renamed from: r  reason: collision with root package name */
    private boolean f15779r;

    /* renamed from: s  reason: collision with root package name */
    private BaiduNativeManager f15780s;

    /* renamed from: t  reason: collision with root package name */
    private ExpressResponse f15781t;

    /* renamed from: u  reason: collision with root package name */
    private float f15782u;

    /* renamed from: v  reason: collision with root package name */
    private float f15783v;

    /* renamed from: w  reason: collision with root package name */
    private View f15784w;

    public a(Context context, String str, long j4, long j5, AdSpacesBean.BuyerBean buyerBean, AdSpacesBean.ForwardBean forwardBean, com.beizi.fusion.d.e eVar, float f4, float f5) {
        this.f15775n = context;
        this.f15776o = str;
        this.f15777p = j4;
        this.f15778q = j5;
        this.f15368e = buyerBean;
        this.f15367d = eVar;
        this.f15369f = forwardBean;
        this.f15782u = f4;
        this.f15783v = f5;
        r();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aG() {
        ExpressResponse expressResponse = this.f15781t;
        if (expressResponse != null) {
            expressResponse.setInteractionListener(new ExpressResponse.ExpressInteractionListener() { // from class: com.beizi.fusion.work.nativead.a.3

                /* renamed from: a  reason: collision with root package name */
                boolean f15787a = false;

                /* renamed from: b  reason: collision with root package name */
                boolean f15788b = false;

                @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressInteractionListener
                public void onAdClick() {
                    Log.d("BeiZis", "showBdNativeAd Callback --> onAdClick()");
                    if (((com.beizi.fusion.work.a) a.this).f15367d != null && ((com.beizi.fusion.work.a) a.this).f15367d.s() != 2) {
                        ((com.beizi.fusion.work.a) a.this).f15367d.d(a.this.g());
                    }
                    if (this.f15788b) {
                        return;
                    }
                    this.f15788b = true;
                    a.this.E();
                    a.this.ai();
                }

                @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressInteractionListener
                public void onAdExposed() {
                    Log.d("BeiZis", "showBdNativeAd Callback --> onAdExposed()");
                    ((com.beizi.fusion.work.a) a.this).f15373j = com.beizi.fusion.f.a.ADSHOW;
                    if (((com.beizi.fusion.work.a) a.this).f15367d != null && ((com.beizi.fusion.work.a) a.this).f15367d.s() != 2) {
                        ((com.beizi.fusion.work.a) a.this).f15367d.b(a.this.g());
                    }
                    if (this.f15787a) {
                        return;
                    }
                    this.f15787a = true;
                    a.this.az();
                    a.this.C();
                    a.this.D();
                    a.this.ah();
                }

                @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressInteractionListener
                public void onAdRenderFail(View view, String str, int i4) {
                    Log.d("BeiZis", "showBdNativeAd Callback --> onAdRenderFail() error:" + str + ";code:" + i4);
                    a.this.a(str, i4);
                }

                @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressInteractionListener
                public void onAdRenderSuccess(View view, float f4, float f5) {
                    Log.d("BeiZis", "showBdNativeAd Callback --> onAdRenderSuccess()");
                    a aVar = a.this;
                    aVar.f15784w = aVar.f15781t.getExpressAdView();
                    if (a.this.Y()) {
                        a.this.b();
                    } else {
                        a.this.O();
                    }
                }

                @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressInteractionListener
                public void onAdUnionClick() {
                    Log.d("BeiZis", "showBdNativeAd Callback --> onAdUnionClick()");
                }
            });
            this.f15781t.setAdPrivacyListener(new ExpressResponse.ExpressAdDownloadWindowListener() { // from class: com.beizi.fusion.work.nativead.a.4
                @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressAdDownloadWindowListener
                public void adDownloadWindowClose() {
                    Log.d("BeiZis", "showBdNativeAd Callback --> adDownloadWindowClose()");
                }

                @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressAdDownloadWindowListener
                public void adDownloadWindowShow() {
                    Log.d("BeiZis", "showBdNativeAd Callback --> adDownloadWindowShow()");
                }

                @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressAdDownloadWindowListener
                public void onADFunctionClick() {
                    Log.d("BeiZis", "showBdNativeAd Callback --> onADFunctionClick()");
                }

                @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressAdDownloadWindowListener
                public void onADPermissionClose() {
                    Log.d("BeiZis", "showBdNativeAd Callback --> onADPermissionClose()");
                }

                @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressAdDownloadWindowListener
                public void onADPermissionShow() {
                    Log.d("BeiZis", "showBdNativeAd Callback --> onADPermissionShow()");
                }

                @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressAdDownloadWindowListener
                public void onADPrivacyClick() {
                    Log.d("BeiZis", "showBdNativeAd Callback --> onADPrivacyClick()");
                }
            });
            this.f15781t.setAdDislikeListener(new ExpressResponse.ExpressDislikeListener() { // from class: com.beizi.fusion.work.nativead.a.5
                @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressDislikeListener
                public void onDislikeItemClick(String str) {
                    Log.d("BeiZis", "showBdNativeAd Callback --> onDislikeItemClick()");
                    Log.d("BeiZis", "showCsjNativeAd Callback --> onSelected()");
                    if (((com.beizi.fusion.work.a) a.this).f15367d != null && ((com.beizi.fusion.work.a) a.this).f15367d.s() != 2) {
                        ((com.beizi.fusion.work.a) a.this).f15367d.b(a.this.g(), a.this.f15784w);
                    }
                    a.this.G();
                }

                @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressDislikeListener
                public void onDislikeWindowClose() {
                    Log.d("BeiZis", "showBdNativeAd Callback --> onDislikeWindowClose()");
                }

                @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressDislikeListener
                public void onDislikeWindowShow() {
                    Log.d("BeiZis", "showBdNativeAd Callback --> onDislikeWindowShow()");
                }
            });
        }
    }

    @Override // com.beizi.fusion.work.a
    protected void A() {
        if (!z() || this.f15781t == null) {
            return;
        }
        al();
    }

    @Override // com.beizi.fusion.work.a
    public void az() {
        ExpressResponse expressResponse;
        if (!an() || (expressResponse = this.f15781t) == null || TextUtils.isEmpty(expressResponse.getECPMLevel()) || this.f15779r) {
            return;
        }
        this.f15779r = true;
        af.a("BeiZis", "showBdNativeAd channel == Baidu\u7ade\u4ef7\u6210\u529f");
        af.a("BeiZis", "showBdNativeAd channel == sendWinNoticeECPM:" + this.f15781t.getECPMLevel());
        ExpressResponse expressResponse2 = this.f15781t;
        expressResponse2.biddingSuccess(expressResponse2.getECPMLevel());
    }

    @Override // com.beizi.fusion.work.a
    public void f() {
    }

    @Override // com.beizi.fusion.work.a
    public String g() {
        return "BAIDU";
    }

    @Override // com.beizi.fusion.work.a
    public void m() {
    }

    @Override // com.beizi.fusion.work.a
    public void d() {
        if (this.f15367d == null) {
            return;
        }
        this.f15371h = this.f15368e.getAppId();
        this.f15372i = this.f15368e.getSpaceId();
        this.f15366c = this.f15368e.getBuyerSpaceUuId();
        af.b("BeiZis", "AdWorker chanel = " + this.f15366c);
        com.beizi.fusion.b.d dVar = this.f15364a;
        if (dVar != null) {
            com.beizi.fusion.b.b a4 = dVar.a().a(this.f15366c);
            this.f15365b = a4;
            if (a4 != null) {
                s();
                if (!av.a(AMPSConstants.CHANNEL_SDK_BAIDU_CLASSNAME)) {
                    t();
                    this.f15376m.postDelayed(new Runnable() { // from class: com.beizi.fusion.work.nativead.a.1
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.c(10151);
                        }
                    }, 10L);
                    Log.e("BeiZis", "BAIDU sdk not import , will do nothing");
                    return;
                }
                u();
                this.f15365b.v(String.valueOf(AdSettings.getSDKVersion()));
                au();
                com.beizi.fusion.d.f.a(this.f15775n, this.f15371h);
                v();
            }
        }
        Log.d("BeiZis", g() + ":requestAd:" + this.f15371h + "====" + this.f15372i + "===" + this.f15778q);
        long j4 = this.f15778q;
        if (j4 > 0) {
            this.f15376m.sendEmptyMessageDelayed(1, j4);
            return;
        }
        com.beizi.fusion.d.e eVar = this.f15367d;
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
        if (an() && this.f15781t != null) {
            return this.f15781t.getECPMLevel() + "";
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
        BaiduNativeManager baiduNativeManager = new BaiduNativeManager(StubApp.getOrigApplicationContext(this.f15775n.getApplicationContext()), this.f15372i);
        this.f15780s = baiduNativeManager;
        baiduNativeManager.loadExpressAd(null, new BaiduNativeManager.ExpressAdListener() { // from class: com.beizi.fusion.work.nativead.a.2
            @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.ExpressAdListener
            public void onLpClosed() {
                Log.d("BeiZis", "showBdNativeAd Callback --> onLpClosed()");
            }

            @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.ExpressAdListener
            public void onNativeFail(int i4, String str) {
                Log.d("BeiZis", "showBdNativeAd Callback --> onNativeFail() code:" + i4 + " message:" + str);
                a.this.a(str, i4);
            }

            @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.ExpressAdListener
            public void onNativeLoad(List<ExpressResponse> list) {
                Log.d("BeiZis", "showBdNativeAd Callback --> onNativeLoad()");
                ((com.beizi.fusion.work.a) a.this).f15373j = com.beizi.fusion.f.a.ADLOAD;
                a.this.y();
                if (list == null || list.size() == 0) {
                    a.this.c(-991);
                    return;
                }
                a.this.f15781t = list.get(0);
                try {
                    if (a.this.f15781t != null && !TextUtils.isEmpty(a.this.f15781t.getECPMLevel())) {
                        Log.d("BeiZis", "showBdNativeAd getECPMLevel:" + a.this.f15781t.getECPMLevel());
                        a aVar = a.this;
                        aVar.a(Double.parseDouble(aVar.f15781t.getECPMLevel()));
                    }
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
                a.this.aG();
                a.this.f15781t.render();
            }

            @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.ExpressAdListener
            public void onNoAd(int i4, String str) {
                Log.d("BeiZis", "showBdNativeAd  Callback --> onNoAd() code:" + i4 + " message:" + str);
                a.this.a(str, i4);
            }

            @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.ExpressAdListener
            public void onVideoDownloadFailed() {
                Log.d("BeiZis", "showBdNativeAd Callback --> onVideoDownloadFailed()");
            }

            @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.ExpressAdListener
            public void onVideoDownloadSuccess() {
                Log.d("BeiZis", "showBdNativeAd Callback --> onVideoDownloadSuccess()");
            }
        });
    }

    @Override // com.beizi.fusion.work.a
    public View o() {
        return this.f15784w;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        com.beizi.fusion.d.e eVar = this.f15367d;
        if (eVar == null) {
            return;
        }
        Map<String, com.beizi.fusion.work.a> r3 = eVar.r();
        Log.d("BeiZis", g() + " NativeAdWorkers:" + r3.toString());
        Z();
        com.beizi.fusion.d.h hVar = this.f15370g;
        if (hVar == com.beizi.fusion.d.h.SUCCESS) {
            if (this.f15781t != null && this.f15784w != null) {
                this.f15367d.a(g(), this.f15784w);
            } else {
                this.f15367d.a(10140);
            }
        } else if (hVar == com.beizi.fusion.d.h.FAIL) {
            Log.d("BeiZis", "other worker shown," + g() + " remove");
        }
    }

    @Override // com.beizi.fusion.work.a
    public void d(int i4) {
        ExpressResponse expressResponse = this.f15781t;
        if (expressResponse == null || TextUtils.isEmpty(expressResponse.getECPMLevel()) || this.f15779r) {
            return;
        }
        this.f15779r = true;
        af.a("BeiZis", "showBdNativeAd channel == Baidu\u7ade\u4ef7\u5931\u8d25:" + i4);
        this.f15781t.biddingFail(i4 != 1 ? i4 != 2 ? "900" : "100" : "203");
    }
}

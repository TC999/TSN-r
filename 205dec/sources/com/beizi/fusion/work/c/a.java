package com.beizi.fusion.work.c;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import com.baidu.mobads.sdk.api.AdSettings;
import com.baidu.mobads.sdk.api.FullScreenVideoAd;
import com.beizi.fusion.d.e;
import com.beizi.fusion.d.f;
import com.beizi.fusion.d.h;
import com.beizi.fusion.g.af;
import com.beizi.fusion.g.aw;
import com.beizi.fusion.model.AdSpacesBean;
import java.util.Map;
import xyz.adscope.amps.common.AMPSConstants;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: BaiduFullScreenVideoWorker.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class a extends com.beizi.fusion.work.a implements com.beizi.fusion.d.c {

    /* renamed from: n  reason: collision with root package name */
    private Context f15473n;

    /* renamed from: o  reason: collision with root package name */
    private String f15474o;

    /* renamed from: p  reason: collision with root package name */
    private long f15475p;

    /* renamed from: q  reason: collision with root package name */
    private long f15476q;

    /* renamed from: r  reason: collision with root package name */
    private FullScreenVideoAd f15477r;

    /* renamed from: s  reason: collision with root package name */
    private boolean f15478s;

    public a(Context context, String str, long j4, long j5, AdSpacesBean.BuyerBean buyerBean, AdSpacesBean.ForwardBean forwardBean, e eVar) {
        this.f15473n = context;
        this.f15474o = str;
        this.f15475p = j4;
        this.f15476q = j5;
        this.f15368e = buyerBean;
        this.f15367d = eVar;
        this.f15369f = forwardBean;
        r();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aG() {
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
    public void az() {
        FullScreenVideoAd fullScreenVideoAd;
        if (!an() || (fullScreenVideoAd = this.f15477r) == null || TextUtils.isEmpty(fullScreenVideoAd.getECPMLevel()) || this.f15478s) {
            return;
        }
        this.f15478s = true;
        af.a("BeiZis", "showBdFullScreenVideo channel == Baidu\u7ade\u4ef7\u6210\u529f");
        af.a("BeiZis", "showBdFullScreenVideo channel == sendWinNoticeECPM:" + this.f15477r.getECPMLevel());
        FullScreenVideoAd fullScreenVideoAd2 = this.f15477r;
        fullScreenVideoAd2.biddingSuccess(fullScreenVideoAd2.getECPMLevel());
    }

    public String b() {
        return AMPSConstants.ChannelName.CHANNEL_NAME_BD;
    }

    @Override // com.beizi.fusion.work.a
    public void f() {
    }

    @Override // com.beizi.fusion.work.a
    public String g() {
        return "BAIDU";
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
                if (!aw.a(AMPSConstants.CHANNEL_SDK_BAIDU_CLASSNAME)) {
                    t();
                    this.f15376m.postDelayed(new Runnable() { // from class: com.beizi.fusion.work.c.a.1
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
                f.a(this.f15473n, this.f15371h);
                v();
            }
        }
        Log.d("BeiZis", g() + ":requestAd:" + this.f15371h + "====" + this.f15372i + "===" + this.f15476q);
        long j4 = this.f15476q;
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
        FullScreenVideoAd fullScreenVideoAd;
        if (an() && (fullScreenVideoAd = this.f15477r) != null) {
            return fullScreenVideoAd.getECPMLevel();
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
        FullScreenVideoAd fullScreenVideoAd = new FullScreenVideoAd(this.f15473n, this.f15372i, new FullScreenVideoAd.FullScreenVideoAdListener() { // from class: com.beizi.fusion.work.c.a.2

            /* renamed from: a  reason: collision with root package name */
            boolean f15480a = false;

            /* renamed from: b  reason: collision with root package name */
            boolean f15481b = false;

            @Override // com.baidu.mobads.sdk.api.FullScreenVideoAd.FullScreenVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
            public void onAdClick() {
                Log.d("BeiZis", "showBdFullScreenVideo Callback --> onAdClick()");
                if (((com.beizi.fusion.work.a) a.this).f15367d != null && ((com.beizi.fusion.work.a) a.this).f15367d.s() != 2) {
                    ((com.beizi.fusion.work.a) a.this).f15367d.d(a.this.g());
                }
                if (this.f15481b) {
                    return;
                }
                this.f15481b = true;
                a.this.E();
                a.this.ai();
            }

            @Override // com.baidu.mobads.sdk.api.FullScreenVideoAd.FullScreenVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
            public void onAdClose(float f4) {
                Log.d("BeiZis", "showBdFullScreenVideo Callback --> onAdClose()");
                if (((com.beizi.fusion.work.a) a.this).f15367d != null && ((com.beizi.fusion.work.a) a.this).f15367d.s() != 2) {
                    ((com.beizi.fusion.work.a) a.this).f15367d.c(a.this.b());
                }
                a.this.G();
            }

            @Override // com.baidu.mobads.sdk.api.FullScreenVideoAd.FullScreenVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
            public void onAdFailed(String str) {
                Log.d("BeiZis", "showBdFullScreenVideo Callback --> onAdFailed: " + str);
                a.this.a(str, 3793);
            }

            @Override // com.baidu.mobads.sdk.api.ScreenVideoAdListener
            public void onAdLoaded() {
                Log.d("BeiZis", "showBdFullScreenVideo Callback --> onAdLoaded()");
            }

            @Override // com.baidu.mobads.sdk.api.FullScreenVideoAd.FullScreenVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
            public void onAdShow() {
                Log.d("BeiZis", "showBdFullScreenVideo Callback --> onAdShow()");
                ((com.beizi.fusion.work.a) a.this).f15373j = com.beizi.fusion.f.a.ADSHOW;
                if (((com.beizi.fusion.work.a) a.this).f15367d != null && ((com.beizi.fusion.work.a) a.this).f15367d.s() != 2) {
                    ((com.beizi.fusion.work.a) a.this).f15367d.b(a.this.g());
                }
                if (this.f15480a) {
                    return;
                }
                this.f15480a = true;
                a.this.C();
                a.this.az();
                a.this.D();
                a.this.ah();
            }

            @Override // com.baidu.mobads.sdk.api.FullScreenVideoAd.FullScreenVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
            public void onAdSkip(float f4) {
                Log.d("BeiZis", "showBdFullScreenVideo Callback --> onAdSkip()");
            }

            @Override // com.baidu.mobads.sdk.api.FullScreenVideoAd.FullScreenVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
            public void onVideoDownloadFailed() {
                Log.d("BeiZis", "showBdFullScreenVideo Callback --> onVideoDownloadFailed()");
                a.this.a("sdk custom error ".concat("onVideoDownloadFailed"), 99991);
            }

            @Override // com.baidu.mobads.sdk.api.FullScreenVideoAd.FullScreenVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
            public void onVideoDownloadSuccess() {
                Log.d("BeiZis", "showBdFullScreenVideo Callback --> onVideoDownloadSuccess()");
                ((com.beizi.fusion.work.a) a.this).f15373j = com.beizi.fusion.f.a.ADLOAD;
                a.this.y();
                if (a.this.Y()) {
                    a.this.aG();
                } else {
                    a.this.O();
                }
            }

            @Override // com.baidu.mobads.sdk.api.FullScreenVideoAd.FullScreenVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
            public void playCompletion() {
                Log.d("BeiZis", "showBdFullScreenVideo Callback --> playCompletion()");
            }
        }, false);
        this.f15477r = fullScreenVideoAd;
        fullScreenVideoAd.setAppSid(this.f15371h);
        this.f15477r.load();
    }

    @Override // com.beizi.fusion.work.a
    public void a(Activity activity) {
        FullScreenVideoAd fullScreenVideoAd = this.f15477r;
        if (fullScreenVideoAd != null && fullScreenVideoAd.isReady()) {
            this.f15477r.show();
            return;
        }
        e eVar = this.f15367d;
        if (eVar != null) {
            eVar.a(10140);
        }
    }

    @Override // com.beizi.fusion.work.a
    public void d(int i4) {
        FullScreenVideoAd fullScreenVideoAd = this.f15477r;
        if (fullScreenVideoAd == null || TextUtils.isEmpty(fullScreenVideoAd.getECPMLevel()) || this.f15478s) {
            return;
        }
        this.f15478s = true;
        af.a("BeiZis", "showBdFullScreenVideo channel == Baidu\u7ade\u4ef7\u5931\u8d25:" + i4);
        this.f15477r.biddingFail(i4 != 1 ? i4 != 2 ? "900" : "100" : "203");
    }
}

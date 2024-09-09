package com.beizi.fusion.work.g;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.View;
import com.beizi.fusion.d.h;
import com.beizi.fusion.d.k;
import com.beizi.fusion.g.af;
import com.beizi.fusion.g.al;
import com.beizi.fusion.g.aw;
import com.beizi.fusion.g.n;
import com.beizi.fusion.g.v;
import com.beizi.fusion.model.AdSpacesBean;
import com.qq.e.ads.rewardvideo.RewardVideoAD;
import com.qq.e.ads.rewardvideo.RewardVideoADListener;
import com.qq.e.ads.rewardvideo.ServerSideVerificationOptions;
import com.qq.e.comm.managers.status.SDKStatus;
import com.qq.e.comm.util.AdError;
import java.util.Map;
import xyz.adscope.amps.common.AMPSConstants;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: GdtRewardVideoWorker.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class c extends com.beizi.fusion.work.a implements com.beizi.fusion.d.c {

    /* renamed from: n  reason: collision with root package name */
    private Context f15594n;

    /* renamed from: o  reason: collision with root package name */
    private String f15595o;

    /* renamed from: p  reason: collision with root package name */
    private long f15596p;

    /* renamed from: q  reason: collision with root package name */
    private long f15597q;

    /* renamed from: r  reason: collision with root package name */
    private boolean f15598r;

    /* renamed from: s  reason: collision with root package name */
    private RewardVideoAD f15599s;

    /* renamed from: t  reason: collision with root package name */
    private String f15600t;

    /* renamed from: u  reason: collision with root package name */
    private String f15601u;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: GdtRewardVideoWorker.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public class a implements RewardVideoADListener {

        /* renamed from: a  reason: collision with root package name */
        boolean f15603a;

        /* renamed from: b  reason: collision with root package name */
        boolean f15604b;

        private a() {
            this.f15603a = false;
            this.f15604b = false;
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public void onADClick() {
            Log.d("BeiZis", "showGdtRewardVideo onADClick()");
            if (((com.beizi.fusion.work.a) c.this).f15367d != null && ((com.beizi.fusion.work.a) c.this).f15367d.s() != 2) {
                ((com.beizi.fusion.work.a) c.this).f15367d.d(c.this.g());
            }
            if (this.f15604b) {
                return;
            }
            this.f15604b = true;
            c.this.E();
            c.this.ai();
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public void onADClose() {
            Log.d("BeiZis", "showGdtRewardVideo onADClose()");
            if (((com.beizi.fusion.work.a) c.this).f15367d != null && ((com.beizi.fusion.work.a) c.this).f15367d.s() != 2) {
                ((com.beizi.fusion.work.a) c.this).f15367d.c(c.this.g());
            }
            c.this.G();
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public void onADExpose() {
            Log.d("BeiZis", "showGdtRewardVideo onADExposure()");
            ((com.beizi.fusion.work.a) c.this).f15373j = com.beizi.fusion.f.a.ADSHOW;
            if (((com.beizi.fusion.work.a) c.this).f15367d != null && ((com.beizi.fusion.work.a) c.this).f15367d.s() != 2) {
                ((com.beizi.fusion.work.a) c.this).f15367d.b(c.this.g());
            }
            if (this.f15603a) {
                return;
            }
            this.f15603a = true;
            c.this.az();
            c.this.D();
            c.this.ah();
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public void onADLoad() {
            Log.d("BeiZis", "showGdtRewardVideo onADLoad()");
            if (c.this.f15599s.getECPM() > 0) {
                c cVar = c.this;
                cVar.a(cVar.f15599s.getECPM());
            }
            if (v.f14982a) {
                c.this.f15599s.setDownloadConfirmListener(v.f14983b);
            }
            ((com.beizi.fusion.work.a) c.this).f15373j = com.beizi.fusion.f.a.ADLOAD;
            c.this.y();
            if (c.this.Y()) {
                c.this.b();
            } else {
                c.this.O();
            }
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public void onADShow() {
            Log.d("BeiZis", "showGdtRewardVideo onADShow()");
            c.this.C();
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public void onError(AdError adError) {
            Log.d("BeiZis", "showGdtRewardVideo onError:" + adError.getErrorMsg());
            c.this.a(adError.getErrorMsg(), adError.getErrorCode());
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public void onReward(Map<String, Object> map) {
            Log.d("BeiZis", "showGdtRewardVideo onReward()");
            if (map != null) {
                Log.i("BeiZis", "onReward transID = " + map.get("transId"));
            }
            c.this.J();
            if (((com.beizi.fusion.work.a) c.this).f15367d != null) {
                ((com.beizi.fusion.work.a) c.this).f15367d.k();
            }
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public void onVideoCached() {
            Log.d("BeiZis", "showGdtRewardVideo onVideoCached()");
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public void onVideoComplete() {
            Log.d("BeiZis", "showGdtRewardVideo onVideoComplete()");
            if (((com.beizi.fusion.work.a) c.this).f15367d != null) {
                ((com.beizi.fusion.work.a) c.this).f15367d.l();
            }
        }
    }

    public c(Context context, String str, String str2, String str3, long j4, long j5, AdSpacesBean.BuyerBean buyerBean, AdSpacesBean.ForwardBean forwardBean, com.beizi.fusion.d.e eVar) {
        this.f15594n = context;
        this.f15595o = str;
        this.f15596p = j4;
        this.f15597q = j5;
        this.f15368e = buyerBean;
        this.f15367d = eVar;
        this.f15369f = forwardBean;
        this.f15600t = str2;
        this.f15601u = str3;
        r();
    }

    @Override // com.beizi.fusion.work.a
    protected void A() {
        if (!z() || this.f15599s == null) {
            return;
        }
        al();
        int a4 = al.a(this.f15368e.getPriceDict(), this.f15599s.getECPMLevel());
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
        RewardVideoAD rewardVideoAD = this.f15599s;
        if (rewardVideoAD == null || rewardVideoAD.getECPM() <= 0 || this.f15598r) {
            return;
        }
        this.f15598r = true;
        af.a("BeiZis", "channel == GDT\u7ade\u4ef7\u6210\u529f");
        af.a("BeiZis", "channel == sendWinNoticeECPM" + this.f15599s.getECPM());
        RewardVideoAD rewardVideoAD2 = this.f15599s;
        k.a(rewardVideoAD2, rewardVideoAD2.getECPM());
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
                    this.f15376m.postDelayed(new Runnable() { // from class: com.beizi.fusion.work.g.c.1
                        @Override // java.lang.Runnable
                        public void run() {
                            c.this.c(10151);
                        }
                    }, 10L);
                    Log.e("BeiZis", "GDT sdk not import , will do nothing");
                    return;
                }
                u();
                k.a(this.f15594n, this.f15371h);
                this.f15365b.s(SDKStatus.getIntegrationSDKVersion());
                au();
                v();
            }
        }
        v.f14982a = !n.a(this.f15368e.getDirectDownload());
        Log.d("BeiZis", g() + ":requestAd:" + this.f15371h + "====" + this.f15372i + "===" + this.f15597q);
        long j4 = this.f15597q;
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
        RewardVideoAD rewardVideoAD = this.f15599s;
        if (rewardVideoAD != null) {
            int a4 = al.a(this.f15368e.getPriceDict(), rewardVideoAD.getECPMLevel());
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
        if (AMPSConstants.BiddingType.BIDDING_TYPE_S2S.equalsIgnoreCase(this.f15368e.getBidType())) {
            this.f15599s = new RewardVideoAD(this.f15594n, this.f15372i, new a(), false, aC());
        } else {
            this.f15599s = new RewardVideoAD(this.f15594n, this.f15372i, new a(), false);
        }
        this.f15599s.setServerSideVerificationOptions(new ServerSideVerificationOptions.Builder().setCustomData(this.f15601u).setUserId(this.f15600t).build());
        this.f15599s.loadAD();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        com.beizi.fusion.d.e eVar = this.f15367d;
        if (eVar == null) {
            return;
        }
        Map<String, com.beizi.fusion.work.a> r3 = eVar.r();
        Log.d("BeiZis", g() + " RewardVideoWorkers:" + r3.toString());
        Z();
        h hVar = this.f15370g;
        if (hVar == h.SUCCESS) {
            com.beizi.fusion.d.e eVar2 = this.f15367d;
            if (eVar2 != null) {
                eVar2.a(g(), (View) null);
            }
        } else if (hVar == h.FAIL) {
            Log.d("BeiZis", "other worker shown," + g() + " remove");
        }
    }

    @Override // com.beizi.fusion.work.a
    public void a(Activity activity) {
        RewardVideoAD rewardVideoAD = this.f15599s;
        if (rewardVideoAD != null) {
            boolean z3 = !rewardVideoAD.hasShown();
            boolean isValid = this.f15599s.isValid();
            if (z3 && isValid) {
                this.f15599s.showAD();
                return;
            }
            com.beizi.fusion.d.e eVar = this.f15367d;
            if (eVar == null || isValid) {
                return;
            }
            eVar.a(10140);
            return;
        }
        com.beizi.fusion.d.e eVar2 = this.f15367d;
        if (eVar2 != null) {
            eVar2.a(10140);
        }
    }

    @Override // com.beizi.fusion.work.a
    public void d(int i4) {
        RewardVideoAD rewardVideoAD = this.f15599s;
        if (rewardVideoAD == null || rewardVideoAD.getECPM() <= 0 || this.f15598r) {
            return;
        }
        this.f15598r = true;
        af.a("BeiZis", "channel == GDT\u7ade\u4ef7\u5931\u8d25:" + i4);
        k.b(this.f15599s, i4 != 1 ? 10001 : 1);
    }
}

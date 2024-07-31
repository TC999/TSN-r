package com.beizi.fusion.work.p082g;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.View;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.p064b.EventBean;
import com.beizi.fusion.p064b.ObserverAdStatus;
import com.beizi.fusion.p066d.AdShowObserver;
import com.beizi.fusion.p066d.BaseManager;
import com.beizi.fusion.p066d.CompeteStatus;
import com.beizi.fusion.p066d.GDTAdManagerHolder;
import com.beizi.fusion.p071f.AdStatus;
import com.beizi.fusion.p072g.C3116af;
import com.beizi.fusion.p072g.C3138av;
import com.beizi.fusion.p072g.CheckDirectDownload;
import com.beizi.fusion.p072g.DownloadConfirmHelper;
import com.beizi.fusion.p072g.PriceUtil;
import com.beizi.fusion.work.AdWorker;
import com.p518qq.p519e.ads.rewardvideo.RewardVideoAD;
import com.p518qq.p519e.ads.rewardvideo.RewardVideoADListener;
import com.p518qq.p519e.ads.rewardvideo.ServerSideVerificationOptions;
import com.p518qq.p519e.comm.managers.status.SDKStatus;
import com.p518qq.p519e.comm.util.AdError;
import java.util.Map;

/* renamed from: com.beizi.fusion.work.g.c */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class GdtRewardVideoWorker extends AdWorker implements AdShowObserver {

    /* renamed from: n */
    private Context f12033n;

    /* renamed from: o */
    private String f12034o;

    /* renamed from: p */
    private long f12035p;

    /* renamed from: q */
    private long f12036q;

    /* renamed from: r */
    private boolean f12037r;

    /* renamed from: s */
    private RewardVideoAD f12038s;

    /* renamed from: t */
    private String f12039t;

    /* renamed from: u */
    private String f12040u;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: GdtRewardVideoWorker.java */
    /* renamed from: com.beizi.fusion.work.g.c$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public class C3316a implements RewardVideoADListener {

        /* renamed from: a */
        boolean f12042a;

        /* renamed from: b */
        boolean f12043b;

        private C3316a() {
            this.f12042a = false;
            this.f12043b = false;
        }

        @Override // com.p518qq.p519e.ads.rewardvideo.RewardVideoADListener
        public void onADClick() {
            Log.d("BeiZis", "showGdtRewardVideo onADClick()");
            if (((AdWorker) GdtRewardVideoWorker.this).f11797d != null && ((AdWorker) GdtRewardVideoWorker.this).f11797d.m48668s() != 2) {
                ((AdWorker) GdtRewardVideoWorker.this).f11797d.m48700d(GdtRewardVideoWorker.this.mo46059g());
            }
            if (this.f12043b) {
                return;
            }
            this.f12043b = true;
            GdtRewardVideoWorker.this.m47990E();
            GdtRewardVideoWorker.this.m47941ai();
        }

        @Override // com.p518qq.p519e.ads.rewardvideo.RewardVideoADListener
        public void onADClose() {
            Log.d("BeiZis", "showGdtRewardVideo onADClose()");
            if (((AdWorker) GdtRewardVideoWorker.this).f11797d != null && ((AdWorker) GdtRewardVideoWorker.this).f11797d.m48668s() != 2) {
                ((AdWorker) GdtRewardVideoWorker.this).f11797d.m48704c(GdtRewardVideoWorker.this.mo46059g());
            }
            GdtRewardVideoWorker.this.m47988G();
        }

        @Override // com.p518qq.p519e.ads.rewardvideo.RewardVideoADListener
        public void onADExpose() {
            Log.d("BeiZis", "showGdtRewardVideo onADExposure()");
            ((AdWorker) GdtRewardVideoWorker.this).f11803j = AdStatus.ADSHOW;
            if (((AdWorker) GdtRewardVideoWorker.this).f11797d != null && ((AdWorker) GdtRewardVideoWorker.this).f11797d.m48668s() != 2) {
                ((AdWorker) GdtRewardVideoWorker.this).f11797d.m48710b(GdtRewardVideoWorker.this.mo46059g());
            }
            if (this.f12042a) {
                return;
            }
            this.f12042a = true;
            GdtRewardVideoWorker.this.mo46072az();
            GdtRewardVideoWorker.this.m47991D();
            GdtRewardVideoWorker.this.m47942ah();
        }

        @Override // com.p518qq.p519e.ads.rewardvideo.RewardVideoADListener
        public void onADLoad() {
            Log.d("BeiZis", "showGdtRewardVideo onADLoad()");
            if (GdtRewardVideoWorker.this.f12038s.getECPM() > 0) {
                GdtRewardVideoWorker gdtRewardVideoWorker = GdtRewardVideoWorker.this;
                gdtRewardVideoWorker.m47967a(gdtRewardVideoWorker.f12038s.getECPM());
            }
            if (DownloadConfirmHelper.f11427a) {
                GdtRewardVideoWorker.this.f12038s.setDownloadConfirmListener(DownloadConfirmHelper.f11428b);
            }
            ((AdWorker) GdtRewardVideoWorker.this).f11803j = AdStatus.ADLOAD;
            GdtRewardVideoWorker.this.m47910y();
            if (GdtRewardVideoWorker.this.m47970Y()) {
                GdtRewardVideoWorker.this.m47429b();
            } else {
                GdtRewardVideoWorker.this.m47980O();
            }
        }

        @Override // com.p518qq.p519e.ads.rewardvideo.RewardVideoADListener
        public void onADShow() {
            Log.d("BeiZis", "showGdtRewardVideo onADShow()");
            GdtRewardVideoWorker.this.m47992C();
        }

        @Override // com.p518qq.p519e.ads.rewardvideo.RewardVideoADListener
        public void onError(AdError adError) {
            Log.d("BeiZis", "showGdtRewardVideo onError:" + adError.getErrorMsg());
            GdtRewardVideoWorker.this.m47961a(adError.getErrorMsg(), adError.getErrorCode());
        }

        @Override // com.p518qq.p519e.ads.rewardvideo.RewardVideoADListener
        public void onReward(Map<String, Object> map) {
            Log.d("BeiZis", "showGdtRewardVideo onReward()");
            if (map != null) {
                Log.i("BeiZis", "onReward transID = " + map.get("transId"));
            }
            GdtRewardVideoWorker.this.m47985J();
            if (((AdWorker) GdtRewardVideoWorker.this).f11797d != null) {
                ((AdWorker) GdtRewardVideoWorker.this).f11797d.m48679k();
            }
        }

        @Override // com.p518qq.p519e.ads.rewardvideo.RewardVideoADListener
        public void onVideoCached() {
            Log.d("BeiZis", "showGdtRewardVideo onVideoCached()");
        }

        @Override // com.p518qq.p519e.ads.rewardvideo.RewardVideoADListener
        public void onVideoComplete() {
            Log.d("BeiZis", "showGdtRewardVideo onVideoComplete()");
            if (((AdWorker) GdtRewardVideoWorker.this).f11797d != null) {
                ((AdWorker) GdtRewardVideoWorker.this).f11797d.m48676l();
            }
        }
    }

    public GdtRewardVideoWorker(Context context, String str, String str2, String str3, long j, long j2, AdSpacesBean.BuyerBean buyerBean, AdSpacesBean.ForwardBean forwardBean, BaseManager baseManager) {
        this.f12033n = context;
        this.f12034o = str;
        this.f12035p = j;
        this.f12036q = j2;
        this.f11798e = buyerBean;
        this.f11797d = baseManager;
        this.f11799f = forwardBean;
        this.f12039t = str2;
        this.f12040u = str3;
        m47917r();
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: A */
    protected void mo46197A() {
        if (!m47909z() || this.f12038s == null) {
            return;
        }
        m47938al();
        int m48440a = PriceUtil.m48440a(this.f11798e.getPriceDict(), this.f12038s.getECPMLevel());
        if (m48440a == -1 || m48440a == -2) {
            if (m48440a == -2) {
                m47983L();
                return;
            }
            return;
        }
        Log.d("BeiZisBid", "gdt realPrice = " + m48440a);
        m47967a((double) m48440a);
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: az */
    public void mo46072az() {
        RewardVideoAD rewardVideoAD = this.f12038s;
        if (rewardVideoAD == null || rewardVideoAD.getECPM() <= 0 || this.f12037r) {
            return;
        }
        this.f12037r = true;
        C3116af.m48496a("BeiZis", "channel == GDT竞价成功");
        C3116af.m48496a("BeiZis", "channel == sendWinNoticeECPM" + this.f12038s.getECPM());
        RewardVideoAD rewardVideoAD2 = this.f12038s;
        GDTAdManagerHolder.m48636a(rewardVideoAD2, rewardVideoAD2.getECPM());
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: f */
    public void mo46061f() {
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: g */
    public String mo46059g() {
        return "GDT";
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: d */
    public void mo46065d() {
        if (this.f11797d == null) {
            return;
        }
        this.f11801h = this.f11798e.getAppId();
        this.f11802i = this.f11798e.getSpaceId();
        this.f11796c = this.f11798e.getBuyerSpaceUuId();
        ObserverAdStatus observerAdStatus = this.f11794a;
        if (observerAdStatus != null) {
            EventBean m48977a = observerAdStatus.m48860a().m48977a(this.f11796c);
            this.f11795b = m48977a;
            if (m48977a != null) {
                m47916s();
                if (!C3138av.m48301a("com.qq.e.comm.managers.GDTAdSdk")) {
                    m47915t();
                    this.f11806m.postDelayed(new Runnable() { // from class: com.beizi.fusion.work.g.c.1
                        @Override // java.lang.Runnable
                        public void run() {
                            GdtRewardVideoWorker.this.m47921c(10151);
                        }
                    }, 10L);
                    Log.e("BeiZis", "GDT sdk not import , will do nothing");
                    return;
                }
                m47914u();
                GDTAdManagerHolder.m48638a(this.f12033n, this.f11801h);
                this.f11795b.m48885s(SDKStatus.getIntegrationSDKVersion());
                m47929au();
                m47913v();
            }
        }
        DownloadConfirmHelper.f11427a = !CheckDirectDownload.m48236a(this.f11798e.getDirectDownload());
        Log.d("BeiZis", mo46059g() + ":requestAd:" + this.f11801h + "====" + this.f11802i + "===" + this.f12036q);
        long j = this.f12036q;
        if (j > 0) {
            this.f11806m.sendEmptyMessageDelayed(1, j);
            return;
        }
        BaseManager baseManager = this.f11797d;
        if (baseManager == null || baseManager.m48667t() >= 1 || this.f11797d.m48668s() == 2) {
            return;
        }
        mo46050l();
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: i */
    public AdStatus mo46056i() {
        return this.f11803j;
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: j */
    public String mo46054j() {
        RewardVideoAD rewardVideoAD = this.f12038s;
        if (rewardVideoAD != null) {
            int m48440a = PriceUtil.m48440a(this.f11798e.getPriceDict(), rewardVideoAD.getECPMLevel());
            if (m48440a == -1 || m48440a == -2) {
                return null;
            }
            return m48440a + "";
        }
        return null;
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: k */
    public AdSpacesBean.BuyerBean mo46052k() {
        return this.f11798e;
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: l */
    protected void mo46050l() {
        m47912w();
        m47943ag();
        if ("S2S".equalsIgnoreCase(this.f11798e.getBidType())) {
            this.f12038s = new RewardVideoAD(this.f12033n, this.f11802i, new C3316a(), false, m47957aC());
        } else {
            this.f12038s = new RewardVideoAD(this.f12033n, this.f11802i, new C3316a(), false);
        }
        this.f12038s.setServerSideVerificationOptions(new ServerSideVerificationOptions.Builder().setCustomData(this.f12040u).setUserId(this.f12039t).build());
        this.f12038s.loadAD();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m47429b() {
        BaseManager baseManager = this.f11797d;
        if (baseManager == null) {
            return;
        }
        Map<String, AdWorker> m48669r = baseManager.m48669r();
        Log.d("BeiZis", mo46059g() + " RewardVideoWorkers:" + m48669r.toString());
        m47969Z();
        CompeteStatus competeStatus = this.f11800g;
        if (competeStatus == CompeteStatus.SUCCESS) {
            BaseManager baseManager2 = this.f11797d;
            if (baseManager2 != null) {
                baseManager2.m48726a(mo46059g(), (View) null);
            }
        } else if (competeStatus == CompeteStatus.FAIL) {
            Log.d("BeiZis", "other worker shown," + mo46059g() + " remove");
        }
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: a */
    public void mo47063a(Activity activity) {
        RewardVideoAD rewardVideoAD = this.f12038s;
        if (rewardVideoAD != null) {
            boolean z = !rewardVideoAD.hasShown();
            boolean isValid = this.f12038s.isValid();
            if (z && isValid) {
                this.f12038s.showAD();
                return;
            }
            BaseManager baseManager = this.f11797d;
            if (baseManager == null || isValid) {
                return;
            }
            baseManager.m48754a(10140);
            return;
        }
        BaseManager baseManager2 = this.f11797d;
        if (baseManager2 != null) {
            baseManager2.m48754a(10140);
        }
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: d */
    public void mo46064d(int i) {
        RewardVideoAD rewardVideoAD = this.f12038s;
        if (rewardVideoAD == null || rewardVideoAD.getECPM() <= 0 || this.f12037r) {
            return;
        }
        this.f12037r = true;
        C3116af.m48496a("BeiZis", "channel == GDT竞价失败:" + i);
        GDTAdManagerHolder.m48634b(this.f12038s, i != 1 ? 10001 : 1);
    }
}

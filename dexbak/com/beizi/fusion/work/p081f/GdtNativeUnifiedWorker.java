package com.beizi.fusion.work.p081f;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.internal.view.SupportMenu;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.p066d.BaseManager;
import com.beizi.fusion.p066d.GDTAdManagerHolder;
import com.beizi.fusion.p071f.AdStatus;
import com.beizi.fusion.p072g.C3116af;
import com.beizi.fusion.p072g.C3138av;
import com.beizi.fusion.p072g.CheckDirectDownload;
import com.beizi.fusion.p072g.DownloadConfirmHelper;
import com.beizi.fusion.p072g.PriceUtil;
import com.beizi.fusion.work.AdWorker;
import com.p518qq.p519e.ads.cfg.VideoOption;
import com.p518qq.p519e.ads.nativ.MediaView;
import com.p518qq.p519e.ads.nativ.NativeADEventListener;
import com.p518qq.p519e.ads.nativ.NativeADMediaListener;
import com.p518qq.p519e.ads.nativ.NativeADUnifiedListener;
import com.p518qq.p519e.ads.nativ.NativeUnifiedAD;
import com.p518qq.p519e.ads.nativ.NativeUnifiedADData;
import com.p518qq.p519e.ads.nativ.widget.NativeAdContainer;
import com.p518qq.p519e.comm.managers.status.SDKStatus;
import com.p518qq.p519e.comm.util.AdError;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.beizi.fusion.work.f.d */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class GdtNativeUnifiedWorker extends BaseNativeUnifiedWorker {

    /* renamed from: v */
    private NativeUnifiedAD f11995v;

    /* renamed from: w */
    private NativeUnifiedADData f11996w;

    /* renamed from: x */
    private NativeADMediaListener f11997x;

    /* renamed from: y */
    private MediaView f11998y;

    /* renamed from: z */
    private boolean f11999z;

    /* compiled from: GdtNativeUnifiedWorker.java */
    /* renamed from: com.beizi.fusion.work.f.d$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    private class C3304a implements NativeADUnifiedListener {
        private C3304a() {
        }

        @Override // com.p518qq.p519e.ads.nativ.NativeADUnifiedListener
        public void onADLoaded(List<NativeUnifiedADData> list) {
            Log.d("BeiZis", "ShowGdtNativeUnifiedAd onADLoaded()");
            ((AdWorker) GdtNativeUnifiedWorker.this).f11803j = AdStatus.ADLOAD;
            GdtNativeUnifiedWorker.this.m47910y();
            if (list == null || list.size() == 0) {
                GdtNativeUnifiedWorker.this.m47921c(-991);
                return;
            }
            GdtNativeUnifiedWorker.this.f11996w = list.get(0);
            if (GdtNativeUnifiedWorker.this.f11996w != null) {
                if (GdtNativeUnifiedWorker.this.f11996w.getECPM() > 0) {
                    GdtNativeUnifiedWorker gdtNativeUnifiedWorker = GdtNativeUnifiedWorker.this;
                    gdtNativeUnifiedWorker.m47967a(gdtNativeUnifiedWorker.f11996w.getECPM());
                }
                if (DownloadConfirmHelper.f11427a) {
                    GdtNativeUnifiedWorker.this.f11996w.setDownloadConfirmListener(DownloadConfirmHelper.f11428b);
                }
                GdtNativeUnifiedWorker.this.m47535aU();
                GdtNativeUnifiedWorker.this.m47588aT();
                return;
            }
            GdtNativeUnifiedWorker.this.m47921c(-991);
        }

        @Override // com.p518qq.p519e.ads.NativeAbstractAD.BasicADListener
        public void onNoAD(AdError adError) {
            Log.d("BeiZis", "ShowGdtNativeUnifiedAd onNoAD: " + adError.getErrorMsg());
            GdtNativeUnifiedWorker.this.m47961a(adError.getErrorMsg(), adError.getErrorCode());
        }
    }

    public GdtNativeUnifiedWorker(Context context, long j, AdSpacesBean.BuyerBean buyerBean, AdSpacesBean.ForwardBean forwardBean, BaseManager baseManager, int i) {
        super(context, j, buyerBean, forwardBean, baseManager, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: aU */
    public void m47535aU() {
        this.f11997x = new NativeADMediaListener() { // from class: com.beizi.fusion.work.f.d.2
            @Override // com.p518qq.p519e.ads.nativ.NativeADMediaListener
            public void onVideoClicked() {
                Log.d("BeiZis", "ShowGdtNativeUnifiedAd MediaView onVideoClicked()");
            }

            @Override // com.p518qq.p519e.ads.nativ.NativeADMediaListener
            public void onVideoCompleted() {
                Log.d("BeiZis", "ShowGdtNativeUnifiedAd MediaView onVideoCompleted()");
            }

            @Override // com.p518qq.p519e.ads.nativ.NativeADMediaListener
            public void onVideoError(AdError adError) {
                Log.d("BeiZis", "ShowGdtNativeUnifiedAd MediaView onVideoError: " + adError.getErrorMsg());
                GdtNativeUnifiedWorker.this.m47961a(adError.getErrorMsg(), adError.getErrorCode());
            }

            @Override // com.p518qq.p519e.ads.nativ.NativeADMediaListener
            public void onVideoInit() {
                Log.d("BeiZis", "ShowGdtNativeUnifiedAd MediaView onVideoInit()");
            }

            @Override // com.p518qq.p519e.ads.nativ.NativeADMediaListener
            public void onVideoLoaded(int i) {
                Log.d("BeiZis", "ShowGdtNativeUnifiedAd MediaView onVideoLoaded()");
            }

            @Override // com.p518qq.p519e.ads.nativ.NativeADMediaListener
            public void onVideoLoading() {
                Log.d("BeiZis", "ShowGdtNativeUnifiedAd MediaView onVideoLoading()");
            }

            @Override // com.p518qq.p519e.ads.nativ.NativeADMediaListener
            public void onVideoPause() {
                Log.d("BeiZis", "ShowGdtNativeUnifiedAd MediaView onVideoPause()");
            }

            @Override // com.p518qq.p519e.ads.nativ.NativeADMediaListener
            public void onVideoReady() {
                Log.d("BeiZis", "ShowGdtNativeUnifiedAd MediaView onVideoReady()");
            }

            @Override // com.p518qq.p519e.ads.nativ.NativeADMediaListener
            public void onVideoResume() {
                Log.d("BeiZis", "ShowGdtNativeUnifiedAd MediaView onVideoResume()");
            }

            @Override // com.p518qq.p519e.ads.nativ.NativeADMediaListener
            public void onVideoStart() {
                Log.d("BeiZis", "ShowGdtNativeUnifiedAd MediaView onVideoStart()");
            }

            @Override // com.p518qq.p519e.ads.nativ.NativeADMediaListener
            public void onVideoStop() {
                Log.d("BeiZis", "ShowGdtNativeUnifiedAd MediaView onVideoStop()");
            }
        };
        this.f11996w.setNativeAdEventListener(new NativeADEventListener() { // from class: com.beizi.fusion.work.f.d.3
            @Override // com.p518qq.p519e.ads.nativ.NativeADEventListener
            public void onADClicked() {
                GdtNativeUnifiedWorker.this.m47584b();
            }

            @Override // com.p518qq.p519e.ads.nativ.NativeADEventListener
            public void onADError(AdError adError) {
                Log.d("BeiZis", "ShowGdtNativeUnifiedAd onADError: " + adError.getErrorMsg());
                GdtNativeUnifiedWorker.this.m47961a(adError.getErrorMsg(), adError.getErrorCode());
            }

            @Override // com.p518qq.p519e.ads.nativ.NativeADEventListener
            public void onADExposed() {
                Log.d("BeiZis", "ShowGdtNativeUnifiedAd onADExposed()");
                GdtNativeUnifiedWorker.this.mo47585ab();
                VideoOption.Builder builder = new VideoOption.Builder();
                builder.setAutoPlayPolicy(1);
                VideoOption build = builder.build();
                if (GdtNativeUnifiedWorker.this.mo47510aP()) {
                    GdtNativeUnifiedWorker.this.f11996w.bindMediaView(GdtNativeUnifiedWorker.this.f11998y, build, GdtNativeUnifiedWorker.this.f11997x);
                }
            }

            @Override // com.p518qq.p519e.ads.nativ.NativeADEventListener
            public void onADStatusChanged() {
                Log.d("BeiZis", "ShowGdtNativeUnifiedAd onADStatusChanged()");
            }
        });
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: A */
    protected void mo46197A() {
        if (!m47909z() || this.f11996w == null) {
            return;
        }
        m47938al();
        int m48440a = PriceUtil.m48440a(this.f11798e.getPriceDict(), this.f11996w.getECPMLevel());
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

    @Override // com.beizi.fusion.work.p081f.BaseNativeUnifiedWorker
    /* renamed from: aG */
    public void mo47519aG() {
        if (!C3138av.m48301a("com.qq.e.comm.managers.GDTAdSdk")) {
            m47915t();
            this.f11806m.postDelayed(new Runnable() { // from class: com.beizi.fusion.work.f.d.1
                @Override // java.lang.Runnable
                public void run() {
                    GdtNativeUnifiedWorker.this.m47921c(10151);
                }
            }, 10L);
            Log.e("BeiZis", "GDT sdk not import , will do nothing");
            return;
        }
        m47914u();
        GDTAdManagerHolder.m48638a(((BaseNativeUnifiedWorker) this).f11955n, this.f11801h);
        this.f11795b.m48885s(SDKStatus.getIntegrationSDKVersion());
        m47929au();
        m47913v();
        DownloadConfirmHelper.f11427a = !CheckDirectDownload.m48236a(this.f11798e.getDirectDownload());
        Log.d("BeiZis", mo46059g() + ":requestAd:" + this.f11801h + "====" + this.f11802i + "===" + ((BaseNativeUnifiedWorker) this).f11956o);
        long j = ((BaseNativeUnifiedWorker) this).f11956o;
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

    @Override // com.beizi.fusion.work.p081f.BaseNativeUnifiedWorker
    /* renamed from: aH */
    public void mo47518aH() {
        ((BaseNativeUnifiedWorker) this).f11960s = new NativeAdContainer(((BaseNativeUnifiedWorker) this).f11955n);
        if ("S2S".equalsIgnoreCase(this.f11798e.getBidType())) {
            this.f11995v = new NativeUnifiedAD(((BaseNativeUnifiedWorker) this).f11955n, this.f11802i, new C3304a(), m47957aC());
        } else {
            this.f11995v = new NativeUnifiedAD(((BaseNativeUnifiedWorker) this).f11955n, this.f11802i, new C3304a());
        }
        this.f11995v.loadData(1);
    }

    @Override // com.beizi.fusion.work.p081f.BaseNativeUnifiedWorker
    /* renamed from: aI */
    public String mo47517aI() {
        NativeUnifiedADData nativeUnifiedADData = this.f11996w;
        if (nativeUnifiedADData == null || TextUtils.isEmpty(nativeUnifiedADData.getTitle())) {
            return null;
        }
        return this.f11996w.getTitle();
    }

    @Override // com.beizi.fusion.work.p081f.BaseNativeUnifiedWorker
    /* renamed from: aJ */
    public String mo47516aJ() {
        NativeUnifiedADData nativeUnifiedADData = this.f11996w;
        if (nativeUnifiedADData == null || TextUtils.isEmpty(nativeUnifiedADData.getDesc())) {
            return null;
        }
        return this.f11996w.getDesc();
    }

    @Override // com.beizi.fusion.work.p081f.BaseNativeUnifiedWorker
    /* renamed from: aK */
    public String mo47515aK() {
        NativeUnifiedADData nativeUnifiedADData = this.f11996w;
        if (nativeUnifiedADData == null || TextUtils.isEmpty(nativeUnifiedADData.getIconUrl())) {
            return null;
        }
        return this.f11996w.getIconUrl();
    }

    @Override // com.beizi.fusion.work.p081f.BaseNativeUnifiedWorker
    /* renamed from: aL */
    public String mo47514aL() {
        NativeUnifiedADData nativeUnifiedADData = this.f11996w;
        if (nativeUnifiedADData != null) {
            String imgUrl = nativeUnifiedADData.getImgUrl();
            if (TextUtils.isEmpty(imgUrl)) {
                List<String> imgList = this.f11996w.getImgList();
                return !TextUtils.isEmpty(imgList.get(0)) ? imgList.get(0) : imgUrl;
            }
            return imgUrl;
        }
        return null;
    }

    @Override // com.beizi.fusion.work.p081f.BaseNativeUnifiedWorker
    /* renamed from: aM */
    public List<String> mo47513aM() {
        NativeUnifiedADData nativeUnifiedADData = this.f11996w;
        if (nativeUnifiedADData != null) {
            if ((nativeUnifiedADData.getImgList() != null) & (this.f11996w.getImgList().size() > 0)) {
                ArrayList arrayList = new ArrayList();
                List<String> imgList = this.f11996w.getImgList();
                for (int i = 0; i < imgList.size(); i++) {
                    String str = imgList.get(i);
                    if (!TextUtils.isEmpty(str)) {
                        arrayList.add(str);
                    }
                }
                if (arrayList.size() > 0) {
                    return arrayList;
                }
            }
        }
        return null;
    }

    @Override // com.beizi.fusion.work.p081f.BaseNativeUnifiedWorker
    /* renamed from: aN */
    public int mo47512aN() {
        NativeUnifiedADData nativeUnifiedADData = this.f11996w;
        if (nativeUnifiedADData != null) {
            int adPatternType = nativeUnifiedADData.getAdPatternType();
            if (adPatternType != 1) {
                if (adPatternType == 2) {
                    return 2;
                }
                if (adPatternType == 3 || adPatternType == 4) {
                }
            }
            return 1;
        }
        return 0;
    }

    @Override // com.beizi.fusion.work.p081f.BaseNativeUnifiedWorker
    /* renamed from: aO */
    public String mo47511aO() {
        NativeUnifiedADData nativeUnifiedADData = this.f11996w;
        if (nativeUnifiedADData == null || TextUtils.isEmpty(nativeUnifiedADData.getButtonText())) {
            return null;
        }
        return this.f11996w.getButtonText();
    }

    @Override // com.beizi.fusion.work.p081f.BaseNativeUnifiedWorker
    /* renamed from: aP */
    public boolean mo47510aP() {
        NativeUnifiedADData nativeUnifiedADData = this.f11996w;
        return nativeUnifiedADData != null && nativeUnifiedADData.getAdPatternType() == 2;
    }

    @Override // com.beizi.fusion.work.p081f.BaseNativeUnifiedWorker
    /* renamed from: aQ */
    public ViewGroup mo47509aQ() {
        return ((BaseNativeUnifiedWorker) this).f11960s;
    }

    @Override // com.beizi.fusion.work.p081f.BaseNativeUnifiedWorker
    /* renamed from: aR */
    public View mo47508aR() {
        if (mo47510aP()) {
            MediaView mediaView = new MediaView(((BaseNativeUnifiedWorker) this).f11955n);
            this.f11998y = mediaView;
            mediaView.setBackgroundColor(SupportMenu.CATEGORY_MASK);
            return this.f11998y;
        }
        return null;
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: az */
    public void mo46072az() {
        NativeUnifiedADData nativeUnifiedADData = this.f11996w;
        if (nativeUnifiedADData == null || nativeUnifiedADData.getECPM() <= 0 || this.f11999z) {
            return;
        }
        this.f11999z = true;
        C3116af.m48496a("BeiZis", "channel == GDT竞价成功");
        C3116af.m48496a("BeiZis", "channel == sendWinNoticeECPM" + this.f11996w.getECPM());
        NativeUnifiedADData nativeUnifiedADData2 = this.f11996w;
        GDTAdManagerHolder.m48636a(nativeUnifiedADData2, nativeUnifiedADData2.getECPM());
    }

    @Override // com.beizi.fusion.work.p081f.BaseNativeUnifiedWorker, com.beizi.fusion.work.AdWorker
    /* renamed from: g */
    public String mo46059g() {
        return "GDT";
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: j */
    public String mo46054j() {
        NativeUnifiedADData nativeUnifiedADData = this.f11996w;
        if (nativeUnifiedADData != null) {
            int m48440a = PriceUtil.m48440a(this.f11798e.getPriceDict(), nativeUnifiedADData.getECPMLevel());
            if (m48440a == -1 || m48440a == -2) {
                return null;
            }
            return m48440a + "";
        }
        return null;
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: m */
    public void mo46173m() {
        NativeUnifiedADData nativeUnifiedADData = this.f11996w;
        if (nativeUnifiedADData != null) {
            nativeUnifiedADData.destroy();
        }
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: n */
    public void mo46703n() {
        if (this.f11996w == null || !mo47510aP()) {
            return;
        }
        this.f11996w.resumeVideo();
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: d */
    public void mo46064d(int i) {
        NativeUnifiedADData nativeUnifiedADData = this.f11996w;
        if (nativeUnifiedADData == null || nativeUnifiedADData.getECPM() <= 0 || this.f11999z) {
            return;
        }
        this.f11999z = true;
        C3116af.m48496a("BeiZis", "channel == GDT竞价失败:" + i);
        GDTAdManagerHolder.m48634b(this.f11996w, i != 1 ? 10001 : 1);
    }

    @Override // com.beizi.fusion.work.p081f.BaseNativeUnifiedWorker
    /* renamed from: a */
    public void mo47520a(List<View> list) {
        this.f11996w.bindAdToView(((BaseNativeUnifiedWorker) this).f11955n, (NativeAdContainer) ((BaseNativeUnifiedWorker) this).f11960s, null, list);
    }
}

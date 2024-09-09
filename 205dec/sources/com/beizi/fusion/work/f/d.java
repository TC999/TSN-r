package com.beizi.fusion.work.f;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import com.beizi.fusion.d.k;
import com.beizi.fusion.g.af;
import com.beizi.fusion.g.al;
import com.beizi.fusion.g.aw;
import com.beizi.fusion.g.n;
import com.beizi.fusion.g.v;
import com.beizi.fusion.model.AdSpacesBean;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.nativ.MediaView;
import com.qq.e.ads.nativ.NativeADEventListener;
import com.qq.e.ads.nativ.NativeADMediaListener;
import com.qq.e.ads.nativ.NativeADUnifiedListener;
import com.qq.e.ads.nativ.NativeUnifiedAD;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import com.qq.e.ads.nativ.widget.NativeAdContainer;
import com.qq.e.comm.managers.status.SDKStatus;
import com.qq.e.comm.util.AdError;
import java.util.ArrayList;
import java.util.List;
import xyz.adscope.amps.common.AMPSConstants;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: GdtNativeUnifiedWorker.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class d extends com.beizi.fusion.work.f.a {

    /* renamed from: v  reason: collision with root package name */
    private NativeUnifiedAD f15556v;

    /* renamed from: w  reason: collision with root package name */
    private NativeUnifiedADData f15557w;

    /* renamed from: x  reason: collision with root package name */
    private NativeADMediaListener f15558x;

    /* renamed from: y  reason: collision with root package name */
    private MediaView f15559y;

    /* renamed from: z  reason: collision with root package name */
    private boolean f15560z;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: GdtNativeUnifiedWorker.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    private class a implements NativeADUnifiedListener {
        private a() {
        }

        @Override // com.qq.e.ads.nativ.NativeADUnifiedListener
        public void onADLoaded(List<NativeUnifiedADData> list) {
            Log.d("BeiZis", "ShowGdtNativeUnifiedAd onADLoaded()");
            ((com.beizi.fusion.work.a) d.this).f15373j = com.beizi.fusion.f.a.ADLOAD;
            d.this.y();
            if (list == null || list.size() == 0) {
                d.this.c(-991);
                return;
            }
            d.this.f15557w = list.get(0);
            if (d.this.f15557w != null) {
                if (d.this.f15557w.getECPM() > 0) {
                    d dVar = d.this;
                    dVar.a(dVar.f15557w.getECPM());
                }
                if (v.f14982a) {
                    d.this.f15557w.setDownloadConfirmListener(v.f14983b);
                }
                d.this.aU();
                d.this.aT();
                return;
            }
            d.this.c(-991);
        }

        @Override // com.qq.e.ads.NativeAbstractAD.BasicADListener
        public void onNoAD(AdError adError) {
            Log.d("BeiZis", "ShowGdtNativeUnifiedAd onNoAD: " + adError.getErrorMsg());
            d.this.a(adError.getErrorMsg(), adError.getErrorCode());
        }
    }

    public d(Context context, long j4, AdSpacesBean.BuyerBean buyerBean, AdSpacesBean.ForwardBean forwardBean, com.beizi.fusion.d.e eVar, int i4) {
        super(context, j4, buyerBean, forwardBean, eVar, i4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aU() {
        this.f15558x = new NativeADMediaListener() { // from class: com.beizi.fusion.work.f.d.2
            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            public void onVideoClicked() {
                Log.d("BeiZis", "ShowGdtNativeUnifiedAd MediaView onVideoClicked()");
            }

            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            public void onVideoCompleted() {
                Log.d("BeiZis", "ShowGdtNativeUnifiedAd MediaView onVideoCompleted()");
            }

            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            public void onVideoError(AdError adError) {
                Log.d("BeiZis", "ShowGdtNativeUnifiedAd MediaView onVideoError: " + adError.getErrorMsg());
                d.this.a(adError.getErrorMsg(), adError.getErrorCode());
            }

            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            public void onVideoInit() {
                Log.d("BeiZis", "ShowGdtNativeUnifiedAd MediaView onVideoInit()");
            }

            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            public void onVideoLoaded(int i4) {
                Log.d("BeiZis", "ShowGdtNativeUnifiedAd MediaView onVideoLoaded()");
            }

            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            public void onVideoLoading() {
                Log.d("BeiZis", "ShowGdtNativeUnifiedAd MediaView onVideoLoading()");
            }

            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            public void onVideoPause() {
                Log.d("BeiZis", "ShowGdtNativeUnifiedAd MediaView onVideoPause()");
            }

            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            public void onVideoReady() {
                Log.d("BeiZis", "ShowGdtNativeUnifiedAd MediaView onVideoReady()");
            }

            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            public void onVideoResume() {
                Log.d("BeiZis", "ShowGdtNativeUnifiedAd MediaView onVideoResume()");
            }

            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            public void onVideoStart() {
                Log.d("BeiZis", "ShowGdtNativeUnifiedAd MediaView onVideoStart()");
            }

            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            public void onVideoStop() {
                Log.d("BeiZis", "ShowGdtNativeUnifiedAd MediaView onVideoStop()");
            }
        };
        this.f15557w.setNativeAdEventListener(new NativeADEventListener() { // from class: com.beizi.fusion.work.f.d.3
            @Override // com.qq.e.ads.nativ.NativeADEventListener
            public void onADClicked() {
                d.this.b();
            }

            @Override // com.qq.e.ads.nativ.NativeADEventListener
            public void onADError(AdError adError) {
                Log.d("BeiZis", "ShowGdtNativeUnifiedAd onADError: " + adError.getErrorMsg());
                d.this.a(adError.getErrorMsg(), adError.getErrorCode());
            }

            @Override // com.qq.e.ads.nativ.NativeADEventListener
            public void onADExposed() {
                Log.d("BeiZis", "ShowGdtNativeUnifiedAd onADExposed()");
                d.this.ab();
                VideoOption.Builder builder = new VideoOption.Builder();
                builder.setAutoPlayPolicy(1);
                VideoOption build = builder.build();
                if (d.this.aP()) {
                    d.this.f15557w.bindMediaView(d.this.f15559y, build, d.this.f15558x);
                }
            }

            @Override // com.qq.e.ads.nativ.NativeADEventListener
            public void onADStatusChanged() {
                Log.d("BeiZis", "ShowGdtNativeUnifiedAd onADStatusChanged()");
            }
        });
    }

    @Override // com.beizi.fusion.work.a
    protected void A() {
        if (!z() || this.f15557w == null) {
            return;
        }
        al();
        int a4 = al.a(this.f15368e.getPriceDict(), this.f15557w.getECPMLevel());
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

    @Override // com.beizi.fusion.work.f.a
    public void aG() {
        if (!aw.a(AMPSConstants.CHANNEL_SDK_GDT_CLASSNAME)) {
            t();
            this.f15376m.postDelayed(new Runnable() { // from class: com.beizi.fusion.work.f.d.1
                @Override // java.lang.Runnable
                public void run() {
                    d.this.c(10151);
                }
            }, 10L);
            Log.e("BeiZis", "GDT sdk not import , will do nothing");
            return;
        }
        u();
        k.a(((com.beizi.fusion.work.f.a) this).f15525n, this.f15371h);
        this.f15365b.s(SDKStatus.getIntegrationSDKVersion());
        au();
        v();
        v.f14982a = !n.a(this.f15368e.getDirectDownload());
        Log.d("BeiZis", g() + ":requestAd:" + this.f15371h + "====" + this.f15372i + "===" + ((com.beizi.fusion.work.f.a) this).f15526o);
        long j4 = ((com.beizi.fusion.work.f.a) this).f15526o;
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

    @Override // com.beizi.fusion.work.f.a
    public void aH() {
        ((com.beizi.fusion.work.f.a) this).f15530s = new NativeAdContainer(((com.beizi.fusion.work.f.a) this).f15525n);
        if (AMPSConstants.BiddingType.BIDDING_TYPE_S2S.equalsIgnoreCase(this.f15368e.getBidType())) {
            this.f15556v = new NativeUnifiedAD(((com.beizi.fusion.work.f.a) this).f15525n, this.f15372i, new a(), aC());
        } else {
            this.f15556v = new NativeUnifiedAD(((com.beizi.fusion.work.f.a) this).f15525n, this.f15372i, new a());
        }
        this.f15556v.loadData(1);
    }

    @Override // com.beizi.fusion.work.f.a
    public String aI() {
        NativeUnifiedADData nativeUnifiedADData = this.f15557w;
        if (nativeUnifiedADData == null || TextUtils.isEmpty(nativeUnifiedADData.getTitle())) {
            return null;
        }
        return this.f15557w.getTitle();
    }

    @Override // com.beizi.fusion.work.f.a
    public String aJ() {
        NativeUnifiedADData nativeUnifiedADData = this.f15557w;
        if (nativeUnifiedADData == null || TextUtils.isEmpty(nativeUnifiedADData.getDesc())) {
            return null;
        }
        return this.f15557w.getDesc();
    }

    @Override // com.beizi.fusion.work.f.a
    public String aK() {
        NativeUnifiedADData nativeUnifiedADData = this.f15557w;
        if (nativeUnifiedADData == null || TextUtils.isEmpty(nativeUnifiedADData.getIconUrl())) {
            return null;
        }
        return this.f15557w.getIconUrl();
    }

    @Override // com.beizi.fusion.work.f.a
    public String aL() {
        NativeUnifiedADData nativeUnifiedADData = this.f15557w;
        if (nativeUnifiedADData != null) {
            String imgUrl = nativeUnifiedADData.getImgUrl();
            if (TextUtils.isEmpty(imgUrl)) {
                List<String> imgList = this.f15557w.getImgList();
                return !TextUtils.isEmpty(imgList.get(0)) ? imgList.get(0) : imgUrl;
            }
            return imgUrl;
        }
        return null;
    }

    @Override // com.beizi.fusion.work.f.a
    public List<String> aM() {
        NativeUnifiedADData nativeUnifiedADData = this.f15557w;
        if (nativeUnifiedADData != null) {
            if ((nativeUnifiedADData.getImgList() != null) & (this.f15557w.getImgList().size() > 0)) {
                ArrayList arrayList = new ArrayList();
                List<String> imgList = this.f15557w.getImgList();
                for (int i4 = 0; i4 < imgList.size(); i4++) {
                    String str = imgList.get(i4);
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

    @Override // com.beizi.fusion.work.f.a
    public int aN() {
        NativeUnifiedADData nativeUnifiedADData = this.f15557w;
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

    @Override // com.beizi.fusion.work.f.a
    public String aO() {
        NativeUnifiedADData nativeUnifiedADData = this.f15557w;
        if (nativeUnifiedADData == null || TextUtils.isEmpty(nativeUnifiedADData.getButtonText())) {
            return null;
        }
        return this.f15557w.getButtonText();
    }

    @Override // com.beizi.fusion.work.f.a
    public boolean aP() {
        NativeUnifiedADData nativeUnifiedADData = this.f15557w;
        return nativeUnifiedADData != null && nativeUnifiedADData.getAdPatternType() == 2;
    }

    @Override // com.beizi.fusion.work.f.a
    public ViewGroup aQ() {
        return ((com.beizi.fusion.work.f.a) this).f15530s;
    }

    @Override // com.beizi.fusion.work.f.a
    public View aR() {
        if (aP()) {
            MediaView mediaView = new MediaView(((com.beizi.fusion.work.f.a) this).f15525n);
            this.f15559y = mediaView;
            mediaView.setBackgroundColor(-65536);
            return this.f15559y;
        }
        return null;
    }

    @Override // com.beizi.fusion.work.a
    public void az() {
        NativeUnifiedADData nativeUnifiedADData = this.f15557w;
        if (nativeUnifiedADData == null || nativeUnifiedADData.getECPM() <= 0 || this.f15560z) {
            return;
        }
        this.f15560z = true;
        af.a("BeiZis", "channel == GDT\u7ade\u4ef7\u6210\u529f");
        af.a("BeiZis", "channel == sendWinNoticeECPM" + this.f15557w.getECPM());
        NativeUnifiedADData nativeUnifiedADData2 = this.f15557w;
        k.a(nativeUnifiedADData2, nativeUnifiedADData2.getECPM());
    }

    @Override // com.beizi.fusion.work.f.a, com.beizi.fusion.work.a
    public String g() {
        return AMPSConstants.AMPS_CHANNEL_NETWORK_NAME_GDT;
    }

    @Override // com.beizi.fusion.work.a
    public String j() {
        NativeUnifiedADData nativeUnifiedADData = this.f15557w;
        if (nativeUnifiedADData != null) {
            int a4 = al.a(this.f15368e.getPriceDict(), nativeUnifiedADData.getECPMLevel());
            if (a4 == -1 || a4 == -2) {
                return null;
            }
            return a4 + "";
        }
        return null;
    }

    @Override // com.beizi.fusion.work.a
    public void m() {
        NativeUnifiedADData nativeUnifiedADData = this.f15557w;
        if (nativeUnifiedADData != null) {
            nativeUnifiedADData.destroy();
        }
    }

    @Override // com.beizi.fusion.work.a
    public void n() {
        if (this.f15557w == null || !aP()) {
            return;
        }
        this.f15557w.resumeVideo();
    }

    @Override // com.beizi.fusion.work.a
    public void d(int i4) {
        NativeUnifiedADData nativeUnifiedADData = this.f15557w;
        if (nativeUnifiedADData == null || nativeUnifiedADData.getECPM() <= 0 || this.f15560z) {
            return;
        }
        this.f15560z = true;
        af.a("BeiZis", "channel == GDT\u7ade\u4ef7\u5931\u8d25:" + i4);
        k.b(this.f15557w, i4 != 1 ? 10001 : 1);
    }

    @Override // com.beizi.fusion.work.f.a
    public void a(List<View> list) {
        this.f15557w.bindAdToView(((com.beizi.fusion.work.f.a) this).f15525n, (NativeAdContainer) ((com.beizi.fusion.work.f.a) this).f15530s, null, list);
    }
}

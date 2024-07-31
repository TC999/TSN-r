package com.beizi.fusion.work.p083h;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.autonavi.amap.mapcore.tools.GlMapUtil;
import com.beizi.fusion.C3025R;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.p066d.BaseManager;
import com.beizi.fusion.p066d.TTAdManagerHolder;
import com.beizi.fusion.p071f.AdStatus;
import com.beizi.fusion.p072g.BeiZiImageUtils;
import com.beizi.fusion.p072g.C3138av;
import com.beizi.fusion.work.AdWorker;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import com.bytedance.sdk.openadsdk.TTImage;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import java.util.List;

/* renamed from: com.beizi.fusion.work.h.c */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class CsjUnifiedCustomWorker extends BaseUnifiedCustomWorker {

    /* renamed from: W */
    private ViewGroup f12133W;

    /* renamed from: X */
    private ImageView f12134X;

    /* renamed from: Y */
    private TextView f12135Y;

    /* renamed from: Z */
    private boolean f12136Z;

    /* renamed from: aa */
    private TTAdNative f12137aa;

    /* renamed from: ab */
    private TTFeedAd f12138ab;

    public CsjUnifiedCustomWorker(Context context, long j, AdSpacesBean.BuyerBean buyerBean, AdSpacesBean.ForwardBean forwardBean, BaseManager baseManager, int i) {
        super(context, j, buyerBean, forwardBean, baseManager, i);
    }

    @Override // com.beizi.fusion.work.p083h.BaseUnifiedCustomWorker
    /* renamed from: aG */
    public int mo47251aG() {
        return C3025R.C3029layout.csj_layout_unified_view;
    }

    @Override // com.beizi.fusion.work.p083h.BaseUnifiedCustomWorker
    /* renamed from: aH */
    public void mo47250aH() {
        super.mo47250aH();
        this.f12133W = (ViewGroup) ((BaseUnifiedCustomWorker) this).f12091o.findViewById(C3025R.C3028id.ll_ad_source_container);
        this.f12134X = (ImageView) ((BaseUnifiedCustomWorker) this).f12091o.findViewById(C3025R.C3028id.ad_source_logo_iv);
        this.f12135Y = (TextView) ((BaseUnifiedCustomWorker) this).f12091o.findViewById(C3025R.C3028id.ad_source_logo_tv);
    }

    @Override // com.beizi.fusion.work.p083h.BaseUnifiedCustomWorker
    /* renamed from: aI */
    public void mo47249aI() {
        if (!C3138av.m48301a("com.bytedance.sdk.openadsdk.TTAdNative")) {
            m47915t();
            this.f11806m.postDelayed(new Runnable() { // from class: com.beizi.fusion.work.h.c.1
                @Override // java.lang.Runnable
                public void run() {
                    CsjUnifiedCustomWorker.this.m47921c(10151);
                }
            }, 10L);
            Log.e("BeiZis", "CSJ sdk not import , will do nothing");
            return;
        }
        m47914u();
        TTAdManagerHolder.m48592a(this, this.f12081N, this.f11801h, this.f11798e.getDirectDownload());
        this.f11795b.m48883t(TTAdSdk.getAdManager().getSDKVersion());
        m47929au();
    }

    @Override // com.beizi.fusion.work.p083h.BaseUnifiedCustomWorker
    /* renamed from: aJ */
    public void mo47248aJ() {
        if (m47928av()) {
            return;
        }
        this.f12137aa = TTAdManagerHolder.m48594a().createAdNative(this.f12081N);
        this.f12137aa.loadFeedAd(new AdSlot.Builder().setCodeId(this.f11802i).setSupportDeepLink(true).setAdCount(1).setImageAcceptedSize(640, GlMapUtil.DEVICE_DISPLAY_DPI_HIGH).build(), new TTAdNative.FeedAdListener() { // from class: com.beizi.fusion.work.h.c.2
            @Override // com.bytedance.sdk.openadsdk.TTAdNative.FeedAdListener
            public void onError(int i, String str) {
                Log.d("BeiZis", "showCsjUnifiedAd Callback --> onError:" + str);
                CsjUnifiedCustomWorker.this.m47961a(str, i);
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.FeedAdListener
            public void onFeedAdLoad(List<TTFeedAd> list) {
                Log.d("BeiZis", "showCsjUnifiedAd Callback --> onFeedAdLoad()");
                ((AdWorker) CsjUnifiedCustomWorker.this).f11803j = AdStatus.ADLOAD;
                CsjUnifiedCustomWorker.this.m47910y();
                if (list == null || list.size() == 0) {
                    CsjUnifiedCustomWorker.this.m47921c(-991);
                    return;
                }
                boolean z = false;
                CsjUnifiedCustomWorker.this.f12138ab = list.get(0);
                if (CsjUnifiedCustomWorker.this.f12138ab == null) {
                    CsjUnifiedCustomWorker.this.m47921c(-991);
                    return;
                }
                CsjUnifiedCustomWorker csjUnifiedCustomWorker = CsjUnifiedCustomWorker.this;
                csjUnifiedCustomWorker.f12136Z = (csjUnifiedCustomWorker.f12138ab.getImageMode() == 5 || CsjUnifiedCustomWorker.this.f12138ab.getImageMode() == 15 || CsjUnifiedCustomWorker.this.f12138ab.getImageMode() == 166) ? true : true;
                CsjUnifiedCustomWorker.this.m47325aM();
            }
        });
    }

    @Override // com.beizi.fusion.work.p083h.BaseUnifiedCustomWorker
    /* renamed from: aO */
    public void mo47247aO() {
        m47322aY();
    }

    @Override // com.beizi.fusion.work.p083h.BaseUnifiedCustomWorker
    /* renamed from: aQ */
    public void mo47246aQ() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(12, -1);
        layoutParams.addRule(11, -1);
        layoutParams.rightMargin = (((BaseUnifiedCustomWorker) this).f12095s.getLayoutParams().width - ((BaseUnifiedCustomWorker) this).f12096t.getLayoutParams().width) / 2;
        layoutParams.bottomMargin = ((BaseUnifiedCustomWorker) this).f12095s.getLayoutParams().height - ((BaseUnifiedCustomWorker) this).f12096t.getLayoutParams().height;
        this.f12133W.setLayoutParams(layoutParams);
        if (this.f12138ab.getAdLogo() != null) {
            this.f12134X.setImageBitmap(this.f12138ab.getAdLogo());
        }
        if (TextUtils.isEmpty(this.f12138ab.getSource())) {
            return;
        }
        this.f12135Y.setText(this.f12138ab.getSource());
    }

    @Override // com.beizi.fusion.work.p083h.BaseUnifiedCustomWorker
    /* renamed from: aR */
    public void mo47245aR() {
        View adView;
        if (this.f12136Z) {
            this.f12138ab.setVideoAdListener(new TTFeedAd.VideoAdListener() { // from class: com.beizi.fusion.work.h.c.3
                @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
                public void onProgressUpdate(long j, long j2) {
                }

                @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
                public void onVideoAdComplete(TTFeedAd tTFeedAd) {
                }

                @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
                public void onVideoAdContinuePlay(TTFeedAd tTFeedAd) {
                }

                @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
                public void onVideoAdPaused(TTFeedAd tTFeedAd) {
                }

                @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
                public void onVideoAdStartPlay(TTFeedAd tTFeedAd) {
                }

                @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
                public void onVideoError(int i, int i2) {
                    Log.d("BeiZis", "showCsjUnifiedVideo Callback --> onVideoError()");
                    CsjUnifiedCustomWorker.this.m47961a("sdk custom error ".concat("onVideoError"), 99991);
                }

                @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
                public void onVideoLoad(TTFeedAd tTFeedAd) {
                }
            });
            if (((BaseUnifiedCustomWorker) this).f12096t == null || (adView = this.f12138ab.getAdView()) == null || adView.getParent() != null) {
                return;
            }
            ((BaseUnifiedCustomWorker) this).f12096t.removeAllViews();
            ((BaseUnifiedCustomWorker) this).f12096t.addView(adView);
            return;
        }
        TTImage tTImage = null;
        if (this.f12138ab.getVideoCoverImage() != null) {
            tTImage = this.f12138ab.getVideoCoverImage();
        } else if (this.f12138ab.getImageList() != null && !this.f12138ab.getImageList().isEmpty()) {
            tTImage = this.f12138ab.getImageList().get(0);
        }
        if (tTImage == null || !tTImage.isValid()) {
            return;
        }
        BeiZiImageUtils.m48258a(this.f12081N).m48255a(tTImage.getImageUrl(), new BeiZiImageUtils.InterfaceC3151a() { // from class: com.beizi.fusion.work.h.c.4
            @Override // com.beizi.fusion.p072g.BeiZiImageUtils.InterfaceC3151a
            /* renamed from: a */
            public void mo47232a() {
            }

            @Override // com.beizi.fusion.p072g.BeiZiImageUtils.InterfaceC3151a
            /* renamed from: a */
            public void mo47231a(Bitmap bitmap) {
                ((BaseUnifiedCustomWorker) CsjUnifiedCustomWorker.this).f12101y.setImageBitmap(bitmap);
            }
        });
    }

    @Override // com.beizi.fusion.work.p083h.BaseUnifiedCustomWorker
    /* renamed from: aS */
    public String mo47244aS() {
        return this.f12138ab.getTitle();
    }

    @Override // com.beizi.fusion.work.p083h.BaseUnifiedCustomWorker
    /* renamed from: aT */
    public String mo47243aT() {
        return this.f12138ab.getDescription();
    }

    @Override // com.beizi.fusion.work.p083h.BaseUnifiedCustomWorker
    /* renamed from: aU */
    public String mo47242aU() {
        return this.f12138ab.getIcon().getImageUrl();
    }

    @Override // com.beizi.fusion.work.p083h.BaseUnifiedCustomWorker
    /* renamed from: aV */
    public String mo47241aV() {
        return this.f12138ab.getButtonText();
    }

    @Override // com.beizi.fusion.work.p083h.BaseUnifiedCustomWorker
    /* renamed from: aX */
    public void mo47240aX() {
        if (this.f12137aa == null) {
            m47921c(-991);
        } else {
            m47324aN();
        }
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: ay */
    public void mo46297ay() {
        m47913v();
        mo46389e();
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: e */
    public void mo46389e() {
        Log.d("BeiZis", mo46059g() + ":requestAd:" + this.f11801h + "====" + this.f11802i + "===" + ((BaseUnifiedCustomWorker) this).f12075H);
        long j = ((BaseUnifiedCustomWorker) this).f12075H;
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

    @Override // com.beizi.fusion.work.p083h.BaseUnifiedCustomWorker, com.beizi.fusion.work.AdWorker
    /* renamed from: g */
    public String mo46059g() {
        return "CSJ";
    }

    @Override // com.beizi.fusion.work.p083h.BaseUnifiedCustomWorker, com.beizi.fusion.work.AdWorker
    /* renamed from: m */
    public void mo46173m() {
        TTFeedAd tTFeedAd = this.f12138ab;
        if (tTFeedAd != null) {
            tTFeedAd.destroy();
        }
    }

    @Override // com.beizi.fusion.work.p083h.BaseUnifiedCustomWorker
    /* renamed from: b */
    public void mo47236b(boolean z) {
        m47322aY();
    }

    @Override // com.beizi.fusion.work.p083h.BaseUnifiedCustomWorker
    /* renamed from: a */
    public void mo47252a(List<View> list) {
        this.f12138ab.registerViewForInteraction(((BaseUnifiedCustomWorker) this).f12095s, null, list, null, null, new TTNativeAd.AdInteractionListener() { // from class: com.beizi.fusion.work.h.c.5
            @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
            public void onAdClicked(View view, TTNativeAd tTNativeAd) {
                CsjUnifiedCustomWorker.this.m47327aK();
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
            public void onAdCreativeClick(View view, TTNativeAd tTNativeAd) {
                CsjUnifiedCustomWorker.this.m47327aK();
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
            public void onAdShow(TTNativeAd tTNativeAd) {
                CsjUnifiedCustomWorker.this.m47326aL();
            }
        });
    }
}

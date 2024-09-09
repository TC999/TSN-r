package com.beizi.fusion.work.h;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.beizi.fusion.R;
import com.beizi.fusion.d.u;
import com.beizi.fusion.g.aw;
import com.beizi.fusion.g.i;
import com.beizi.fusion.model.AdSpacesBean;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import com.bytedance.sdk.openadsdk.TTImage;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import java.util.List;
import xyz.adscope.amps.common.AMPSConstants;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: CsjUnifiedCustomWorker.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class c extends a {
    private ViewGroup W;
    private ImageView X;
    private TextView Y;
    private boolean Z;
    private TTAdNative aa;
    private TTFeedAd ab;

    public c(Context context, long j4, AdSpacesBean.BuyerBean buyerBean, AdSpacesBean.ForwardBean forwardBean, com.beizi.fusion.d.e eVar, int i4) {
        super(context, j4, buyerBean, forwardBean, eVar, i4);
    }

    @Override // com.beizi.fusion.work.h.a
    public int aG() {
        return R.layout.csj_layout_unified_view;
    }

    @Override // com.beizi.fusion.work.h.a
    public void aH() {
        super.aH();
        this.W = (ViewGroup) ((a) this).f15631o.findViewById(R.id.ll_ad_source_container);
        this.X = (ImageView) ((a) this).f15631o.findViewById(R.id.ad_source_logo_iv);
        this.Y = (TextView) ((a) this).f15631o.findViewById(R.id.ad_source_logo_tv);
    }

    @Override // com.beizi.fusion.work.h.a
    public void aI() {
        if (!aw.a("com.bytedance.sdk.openadsdk.TTAdNative")) {
            t();
            this.f15376m.postDelayed(new Runnable() { // from class: com.beizi.fusion.work.h.c.1
                @Override // java.lang.Runnable
                public void run() {
                    c.this.c(10151);
                }
            }, 10L);
            Log.e("BeiZis", "CSJ sdk not import , will do nothing");
            return;
        }
        u();
        u.a(this, this.N, this.f15371h, this.f15368e.getDirectDownload());
        this.f15365b.t(TTAdSdk.getAdManager().getSDKVersion());
        au();
    }

    @Override // com.beizi.fusion.work.h.a
    public void aJ() {
        if (av()) {
            return;
        }
        this.aa = u.a().createAdNative(this.N);
        this.aa.loadFeedAd(new AdSlot.Builder().setCodeId(this.f15372i).setSupportDeepLink(true).setAdCount(1).setImageAcceptedSize(640, 320).build(), new TTAdNative.FeedAdListener() { // from class: com.beizi.fusion.work.h.c.2
            @Override // com.bytedance.sdk.openadsdk.TTAdNative.FeedAdListener
            public void onError(int i4, String str) {
                Log.d("BeiZis", "showCsjUnifiedAd Callback --> onError:" + str);
                c.this.a(str, i4);
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.FeedAdListener
            public void onFeedAdLoad(List<TTFeedAd> list) {
                Log.d("BeiZis", "showCsjUnifiedAd Callback --> onFeedAdLoad()");
                ((com.beizi.fusion.work.a) c.this).f15373j = com.beizi.fusion.f.a.ADLOAD;
                c.this.y();
                if (list == null || list.size() == 0) {
                    c.this.c(-991);
                    return;
                }
                boolean z3 = false;
                c.this.ab = list.get(0);
                if (c.this.ab == null) {
                    c.this.c(-991);
                    return;
                }
                c cVar = c.this;
                cVar.Z = (cVar.ab.getImageMode() == 5 || c.this.ab.getImageMode() == 15 || c.this.ab.getImageMode() == 166) ? true : true;
                c.this.aM();
            }
        });
    }

    @Override // com.beizi.fusion.work.h.a
    public void aO() {
        aY();
    }

    @Override // com.beizi.fusion.work.h.a
    public void aQ() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(12, -1);
        layoutParams.addRule(11, -1);
        layoutParams.rightMargin = (((a) this).f15635s.getLayoutParams().width - ((a) this).f15636t.getLayoutParams().width) / 2;
        layoutParams.bottomMargin = ((a) this).f15635s.getLayoutParams().height - ((a) this).f15636t.getLayoutParams().height;
        this.W.setLayoutParams(layoutParams);
        if (this.ab.getAdLogo() != null) {
            this.X.setImageBitmap(this.ab.getAdLogo());
        }
        if (TextUtils.isEmpty(this.ab.getSource())) {
            return;
        }
        this.Y.setText(this.ab.getSource());
    }

    @Override // com.beizi.fusion.work.h.a
    public void aR() {
        View adView;
        if (this.Z) {
            this.ab.setVideoAdListener(new TTFeedAd.VideoAdListener() { // from class: com.beizi.fusion.work.h.c.3
                @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
                public void onProgressUpdate(long j4, long j5) {
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
                public void onVideoError(int i4, int i5) {
                    Log.d("BeiZis", "showCsjUnifiedVideo Callback --> onVideoError()");
                    c.this.a("sdk custom error ".concat("onVideoError"), 99991);
                }

                @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
                public void onVideoLoad(TTFeedAd tTFeedAd) {
                }
            });
            if (((a) this).f15636t == null || (adView = this.ab.getAdView()) == null || adView.getParent() != null) {
                return;
            }
            ((a) this).f15636t.removeAllViews();
            ((a) this).f15636t.addView(adView);
            return;
        }
        TTImage tTImage = null;
        if (this.ab.getVideoCoverImage() != null) {
            tTImage = this.ab.getVideoCoverImage();
        } else if (this.ab.getImageList() != null && !this.ab.getImageList().isEmpty()) {
            tTImage = this.ab.getImageList().get(0);
        }
        if (tTImage == null || !tTImage.isValid()) {
            return;
        }
        i.a(this.N).a(tTImage.getImageUrl(), new i.a() { // from class: com.beizi.fusion.work.h.c.4
            @Override // com.beizi.fusion.g.i.a
            public void a() {
            }

            @Override // com.beizi.fusion.g.i.a
            public void a(Bitmap bitmap) {
                ((a) c.this).f15641y.setImageBitmap(bitmap);
            }
        });
    }

    @Override // com.beizi.fusion.work.h.a
    public String aS() {
        return this.ab.getTitle();
    }

    @Override // com.beizi.fusion.work.h.a
    public String aT() {
        return this.ab.getDescription();
    }

    @Override // com.beizi.fusion.work.h.a
    public String aU() {
        return this.ab.getIcon().getImageUrl();
    }

    @Override // com.beizi.fusion.work.h.a
    public String aV() {
        return this.ab.getButtonText();
    }

    @Override // com.beizi.fusion.work.h.a
    public void aX() {
        if (this.aa == null) {
            c(-991);
        } else {
            aN();
        }
    }

    @Override // com.beizi.fusion.work.a
    public void ay() {
        v();
        e();
    }

    @Override // com.beizi.fusion.work.a
    public void e() {
        Log.d("BeiZis", g() + ":requestAd:" + this.f15371h + "====" + this.f15372i + "===" + ((a) this).H);
        long j4 = ((a) this).H;
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

    @Override // com.beizi.fusion.work.h.a, com.beizi.fusion.work.a
    public String g() {
        return AMPSConstants.AMPS_CHANNEL_NETWORK_NAME_CSJ;
    }

    @Override // com.beizi.fusion.work.h.a, com.beizi.fusion.work.a
    public void m() {
        TTFeedAd tTFeedAd = this.ab;
        if (tTFeedAd != null) {
            tTFeedAd.destroy();
        }
    }

    @Override // com.beizi.fusion.work.h.a
    public void b(boolean z3) {
        aY();
    }

    @Override // com.beizi.fusion.work.h.a
    public void a(List<View> list) {
        this.ab.registerViewForInteraction(((a) this).f15635s, null, list, null, null, new TTNativeAd.AdInteractionListener() { // from class: com.beizi.fusion.work.h.c.5
            @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
            public void onAdClicked(View view, TTNativeAd tTNativeAd) {
                c.this.aK();
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
            public void onAdCreativeClick(View view, TTNativeAd tTNativeAd) {
                c.this.aK();
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
            public void onAdShow(TTNativeAd tTNativeAd) {
                c.this.aL();
            }
        });
    }
}

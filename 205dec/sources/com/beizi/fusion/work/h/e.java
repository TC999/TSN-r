package com.beizi.fusion.work.h;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.beizi.fusion.R;
import com.beizi.fusion.d.n;
import com.beizi.fusion.g.aw;
import com.beizi.fusion.g.i;
import com.beizi.fusion.model.AdSpacesBean;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.api.KsImage;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsNativeAd;
import com.kwad.sdk.api.KsScene;
import java.util.HashMap;
import java.util.List;
import xyz.adscope.amps.common.AMPSConstants;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: KsUnifiedCustomWorker.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class e extends a {
    private ViewGroup W;
    private ImageView X;
    private TextView Y;
    private KsNativeAd Z;

    public e(Context context, long j4, AdSpacesBean.BuyerBean buyerBean, AdSpacesBean.ForwardBean forwardBean, com.beizi.fusion.d.e eVar, int i4) {
        super(context, j4, buyerBean, forwardBean, eVar, i4);
    }

    @Override // com.beizi.fusion.work.h.a
    public int aG() {
        return R.layout.ks_layout_unified_view;
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
        if (!aw.a(AMPSConstants.CHANNEL_SDK_KS_CLASSNAME)) {
            t();
            this.f15376m.postDelayed(new Runnable() { // from class: com.beizi.fusion.work.h.e.1
                @Override // java.lang.Runnable
                public void run() {
                    e.this.c(10151);
                }
            }, 10L);
            Log.e("BeiZis", "ks sdk not import , will do nothing");
            return;
        }
        u();
        n.a(this.N, this.f15371h);
        this.f15365b.u(KsAdSDK.getSDKVersion());
        au();
        v();
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

    @Override // com.beizi.fusion.work.h.a
    public void aJ() {
        KsScene build = new KsScene.Builder(Long.parseLong(this.f15372i)).width((int) this.I).adNum(1).build();
        KsLoadManager loadManager = KsAdSDK.getLoadManager();
        if (loadManager == null) {
            Log.d("BeiZis", "showKsUnifiedCustomAd onError:\u6e20\u9053\u5e7f\u544a\u8bf7\u6c42\u5bf9\u8c61\u4e3a\u7a7a");
            a("\u6e20\u9053\u5e7f\u544a\u8bf7\u6c42\u5f02\u5e38", 10160);
            return;
        }
        if (AMPSConstants.BiddingType.BIDDING_TYPE_S2S.equalsIgnoreCase(this.f15368e.getBidType())) {
            build.setBidResponse(aC());
        }
        loadManager.loadNativeAd(build, new KsLoadManager.NativeAdListener() { // from class: com.beizi.fusion.work.h.e.2
            @Override // com.kwad.sdk.api.KsLoadManager.NativeAdListener
            public void onError(int i4, String str) {
                Log.d("BeiZis", "showKsUnifiedCustomAd Callback --> onError: code = " + i4 + " \uff0cmessage= " + str);
                e.this.a(str, i4);
            }

            @Override // com.kwad.sdk.api.KsLoadManager.NativeAdListener
            public void onNativeAdLoad(@Nullable List<KsNativeAd> list) {
                Log.d("BeiZis", "showKsUnifiedCustomAd Callback --> onFeedAdLoad()");
                ((com.beizi.fusion.work.a) e.this).f15373j = com.beizi.fusion.f.a.ADLOAD;
                e.this.y();
                if (list == null || list.size() == 0) {
                    e.this.c(-991);
                    return;
                }
                e.this.Z = list.get(0);
                if (e.this.Z == null) {
                    e.this.c(-991);
                    return;
                }
                e eVar = e.this;
                eVar.a(eVar.Z.getECPM());
                e.this.b();
                e.this.aX();
                e.this.aM();
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
        if (!TextUtils.isEmpty(this.Z.getAdSourceLogoUrl(0))) {
            i.a(this.N).a(this.Z.getAdSourceLogoUrl(1), new i.a() { // from class: com.beizi.fusion.work.h.e.6
                @Override // com.beizi.fusion.g.i.a
                public void a() {
                }

                @Override // com.beizi.fusion.g.i.a
                public void a(Bitmap bitmap) {
                    e.this.X.setImageBitmap(bitmap);
                }
            });
        }
        if (TextUtils.isEmpty(this.Z.getAdSource())) {
            return;
        }
        this.Y.setText(this.Z.getAdSource());
    }

    @Override // com.beizi.fusion.work.h.a
    public void aR() {
        KsImage ksImage;
        if (this.Z.getMaterialType() != 2 && this.Z.getMaterialType() != 3) {
            if (this.Z.getMaterialType() == 1) {
                View videoView = this.Z.getVideoView(this.N, new KsAdVideoPlayConfig.Builder().build());
                ((a) this).f15636t.removeAllViews();
                ((a) this).f15636t.addView(videoView);
            }
        } else if (this.Z.getImageList() == null || this.Z.getImageList().isEmpty() || (ksImage = this.Z.getImageList().get(0)) == null || !ksImage.isValid()) {
        } else {
            i.a(this.N).a(ksImage.getImageUrl(), new i.a() { // from class: com.beizi.fusion.work.h.e.5
                @Override // com.beizi.fusion.g.i.a
                public void a() {
                }

                @Override // com.beizi.fusion.g.i.a
                public void a(Bitmap bitmap) {
                    ((a) e.this).f15641y.setImageBitmap(bitmap);
                }
            });
        }
    }

    @Override // com.beizi.fusion.work.h.a
    public String aS() {
        KsNativeAd ksNativeAd = this.Z;
        return ksNativeAd != null ? ksNativeAd.getInteractionType() == 1 ? !TextUtils.isEmpty(this.Z.getAppName()) ? this.Z.getAppName() : "" : !TextUtils.isEmpty(this.Z.getProductName()) ? this.Z.getProductName() : "" : "";
    }

    @Override // com.beizi.fusion.work.h.a
    public String aT() {
        return this.Z.getAdDescription();
    }

    @Override // com.beizi.fusion.work.h.a
    public String aU() {
        return this.Z.getAppIconUrl();
    }

    @Override // com.beizi.fusion.work.h.a
    public String aV() {
        return this.Z.getActionDescription();
    }

    @Override // com.beizi.fusion.work.h.a
    public void aX() {
        if (this.Z == null) {
            c(-991);
        } else {
            aN();
        }
    }

    @Override // com.beizi.fusion.work.h.a, com.beizi.fusion.work.a
    public String g() {
        return "KUAISHOU";
    }

    @Override // com.beizi.fusion.work.h.a, com.beizi.fusion.work.a
    public void m() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        this.Z.setVideoPlayListener(new KsNativeAd.VideoPlayListener() { // from class: com.beizi.fusion.work.h.e.3
            @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
            public void onVideoPlayComplete() {
                Log.d("BeiZis", "showKsUnifiedCustomAd Callback --> onVideoPlayComplete()");
            }

            @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
            public void onVideoPlayError(int i4, int i5) {
                Log.d("BeiZis", "showKsUnifiedCustomAd Callback --> onVideoPlayError()");
            }

            @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
            public void onVideoPlayPause() {
                Log.d("BeiZis", "showKsUnifiedCustomAd Callback --> onVideoPlayPause()");
            }

            @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
            public void onVideoPlayReady() {
                Log.d("BeiZis", "showKsUnifiedCustomAd Callback --> onVideoPlayReady()");
            }

            @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
            public void onVideoPlayResume() {
                Log.d("BeiZis", "showKsUnifiedCustomAd Callback --> onVideoPlayResume()");
            }

            @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
            public void onVideoPlayStart() {
                Log.d("BeiZis", "showKsUnifiedCustomAd Callback --> onVideoPlayStart()");
            }
        });
        if (this.Z.getInteractionType() == 1) {
            this.Z.setDownloadListener(new KsAppDownloadListener() { // from class: com.beizi.fusion.work.h.e.4
                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onDownloadFailed() {
                    Log.d("BeiZis", "showKsUnifiedCustomAd Callback --> onDownloadFailed()");
                    String actionDescription = e.this.Z.getActionDescription();
                    if (TextUtils.isEmpty(actionDescription)) {
                        return;
                    }
                    ((a) e.this).F.setText(actionDescription);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onDownloadFinished() {
                    ((a) e.this).F.setText("\u7acb\u5373\u5b89\u88c5");
                    Log.d("BeiZis", "showKsUnifiedCustomAd Callback --> onDownloadFinished()");
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onDownloadStarted() {
                    Log.d("BeiZis", "showKsUnifiedCustomAd Callback --> onDownloadStarted()");
                    ((a) e.this).F.setText("\u5f00\u59cb\u4e0b\u8f7d");
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onIdle() {
                    Log.d("BeiZis", "showKsUnifiedCustomAd Callback --> onIdle()");
                    String actionDescription = e.this.Z.getActionDescription();
                    if (TextUtils.isEmpty(actionDescription)) {
                        return;
                    }
                    ((a) e.this).F.setText(actionDescription);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onInstalled() {
                    ((a) e.this).F.setText("\u7acb\u5373\u6253\u5f00");
                    Log.d("BeiZis", "showKsUnifiedCustomAd Callback --> onInstalled()");
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onProgressUpdate(int i4) {
                    Log.d("BeiZis", "showKsUnifiedCustomAd Callback --> onProgressUpdate()");
                    ((a) e.this).F.setText(String.format("%s/100", Integer.valueOf(i4)));
                }
            });
        }
    }

    @Override // com.beizi.fusion.work.h.a
    public void b(boolean z3) {
        aY();
    }

    @Override // com.beizi.fusion.work.h.a
    public void a(List<View> list) {
        int i4 = this.Z.getInteractionType() == 1 ? 2 : 1;
        HashMap hashMap = new HashMap();
        if (list != null && list.size() > 0) {
            for (View view : list) {
                hashMap.put(view, Integer.valueOf(i4));
            }
        }
        this.Z.registerViewForInteraction((Activity) this.N, ((a) this).f15635s, hashMap, new KsNativeAd.AdInteractionListener() { // from class: com.beizi.fusion.work.h.e.7
            @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
            public boolean handleDownloadDialog(DialogInterface.OnClickListener onClickListener) {
                return false;
            }

            @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
            public void onAdClicked(View view2, KsNativeAd ksNativeAd) {
                e.this.aK();
            }

            @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
            public void onAdShow(KsNativeAd ksNativeAd) {
                e.this.aL();
            }

            @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
            public void onDownloadTipsDialogDismiss() {
                Log.d("BeiZis", "showKsUnifiedCustomAd Callback --> onDownloadTipsDialogDismiss()");
            }

            @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
            public void onDownloadTipsDialogShow() {
                Log.d("BeiZis", "showKsUnifiedCustomAd Callback --> onDownloadTipsDialogShow()");
            }
        });
    }
}

package com.bytedance.msdk.adapter.gdt;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.api.GDTExtraOption;
import com.bytedance.msdk.api.TTVideoOption;
import com.bytedance.msdk.api.format.TTMediaView;
import com.bytedance.msdk.api.format.TTNativeAdView;
import com.bytedance.msdk.api.nativeAd.TTViewBinder;
import com.bytedance.msdk.base.TTBaseAd;
import com.github.mikephil.charting.utils.Utils;
import com.p518qq.p519e.ads.cfg.VideoOption;
import com.p518qq.p519e.ads.nativ.MediaView;
import com.p518qq.p519e.ads.nativ.NativeADEventListener;
import com.p518qq.p519e.ads.nativ.NativeADMediaListener;
import com.p518qq.p519e.ads.nativ.NativeUnifiedAD;
import com.p518qq.p519e.ads.nativ.NativeUnifiedADAppMiitInfo;
import com.p518qq.p519e.ads.nativ.NativeUnifiedADData;
import com.p518qq.p519e.ads.nativ.VideoPreloadListener;
import com.p518qq.p519e.ads.nativ.widget.NativeAdContainer;
import com.p518qq.p519e.comm.util.AdError;
import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class GdtNativeLoader {

    /* renamed from: a */
    private NativeUnifiedADData f21379a;

    /* renamed from: b */
    private NativeUnifiedAD f21380b;

    /* renamed from: c */
    private String f21381c;

    /* renamed from: d */
    private int f21382d;

    /* renamed from: e */
    private int f21383e;

    /* renamed from: f */
    private int f21384f;

    /* renamed from: g */
    private Context f21385g;

    /* renamed from: h */
    private TTVideoOption f21386h;

    /* renamed from: i */
    private GDTExtraOption f21387i;

    /* renamed from: j */
    private boolean f21388j;

    /* renamed from: k */
    private VideoOption f21389k;

    /* renamed from: l */
    private FrameLayout.LayoutParams f21390l;

    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class GdtNativeAd extends TTBaseAd {

        /* renamed from: a */
        NativeUnifiedADData f21393a;

        /* renamed from: b */
        NativeADMediaListener f21394b = new NativeADMediaListener() { // from class: com.bytedance.msdk.adapter.gdt.GdtNativeLoader.GdtNativeAd.3
            @Override // com.p518qq.p519e.ads.nativ.NativeADMediaListener
            public void onVideoClicked() {
                if (((TTBaseAd) GdtNativeAd.this).mTTNativeAdListener != null) {
                    ((TTBaseAd) GdtNativeAd.this).mTTNativeAdListener.onAdClick();
                }
                Log.d("GdtNativeLoader", "onVideoClicked");
            }

            @Override // com.p518qq.p519e.ads.nativ.NativeADMediaListener
            public void onVideoCompleted() {
                if (((TTBaseAd) GdtNativeAd.this).mTTVideoListener != null) {
                    ((TTBaseAd) GdtNativeAd.this).mTTVideoListener.onVideoCompleted();
                }
            }

            @Override // com.p518qq.p519e.ads.nativ.NativeADMediaListener
            public void onVideoError(AdError adError) {
                if (((TTBaseAd) GdtNativeAd.this).mTTVideoListener != null) {
                    ((TTBaseAd) GdtNativeAd.this).mTTVideoListener.onVideoError(new com.bytedance.msdk.api.AdError(adError.getErrorCode(), adError.getErrorMsg()));
                }
            }

            @Override // com.p518qq.p519e.ads.nativ.NativeADMediaListener
            public void onVideoInit() {
                Log.d("GdtNativeLoader", "onVideoInit: ");
            }

            @Override // com.p518qq.p519e.ads.nativ.NativeADMediaListener
            public void onVideoLoaded(int i) {
                Log.d("GdtNativeLoader", "onVideoLoaded: ");
            }

            @Override // com.p518qq.p519e.ads.nativ.NativeADMediaListener
            public void onVideoLoading() {
                Log.d("GdtNativeLoader", "onVideoLoading: ");
            }

            @Override // com.p518qq.p519e.ads.nativ.NativeADMediaListener
            public void onVideoPause() {
                if (((TTBaseAd) GdtNativeAd.this).mTTVideoListener != null) {
                    ((TTBaseAd) GdtNativeAd.this).mTTVideoListener.onVideoPause();
                }
            }

            @Override // com.p518qq.p519e.ads.nativ.NativeADMediaListener
            public void onVideoReady() {
                Log.d("GdtNativeLoader", "onVideoReady");
            }

            @Override // com.p518qq.p519e.ads.nativ.NativeADMediaListener
            public void onVideoResume() {
                if (((TTBaseAd) GdtNativeAd.this).mTTVideoListener != null) {
                    ((TTBaseAd) GdtNativeAd.this).mTTVideoListener.onVideoResume();
                }
            }

            @Override // com.p518qq.p519e.ads.nativ.NativeADMediaListener
            public void onVideoStart() {
                Log.d("GdtNativeLoader", "onVideoStart");
                if (((TTBaseAd) GdtNativeAd.this).mTTVideoListener != null) {
                    ((TTBaseAd) GdtNativeAd.this).mTTVideoListener.onVideoStart();
                }
            }

            @Override // com.p518qq.p519e.ads.nativ.NativeADMediaListener
            public void onVideoStop() {
                Log.d("GdtNativeLoader", "onVideoStop");
            }
        };

        GdtNativeAd(NativeUnifiedADData nativeUnifiedADData) {
            this.f21393a = nativeUnifiedADData;
            NativeUnifiedADAppMiitInfo appMiitInfo = nativeUnifiedADData.getAppMiitInfo();
            if (appMiitInfo != null) {
                setAppName(appMiitInfo.getAppName());
                setAuthorName(appMiitInfo.getAuthorName());
                setPackageSizeBytes(appMiitInfo.getPackageSizeBytes());
                setPermissionsUrl(appMiitInfo.getPermissionsUrl());
                setPrivacyAgreement(appMiitInfo.getPrivacyAgreement());
                setVersionName(appMiitInfo.getVersionName());
            }
            setTitle(nativeUnifiedADData.getTitle());
            setAdDescription(nativeUnifiedADData.getDesc());
            setActionText(nativeUnifiedADData.getCTAText());
            setIconUrl(nativeUnifiedADData.getIconUrl());
            setImageUrl(nativeUnifiedADData.getImgUrl());
            setImageWidth(nativeUnifiedADData.getPictureWidth());
            setImageHeight(nativeUnifiedADData.getPictureHeight());
            setImages(nativeUnifiedADData.getImgList());
            setRating(nativeUnifiedADData.getAppScore());
            setAdType(5);
            setSource(nativeUnifiedADData.getTitle());
            setIsAppDownload(nativeUnifiedADData.isAppAd());
            if (GdtNativeLoader.this.f21388j) {
                setCpm(nativeUnifiedADData.getECPM() != -1 ? nativeUnifiedADData.getECPM() : Utils.DOUBLE_EPSILON);
                Logger.m37562d("TTMediationSDK_ECMP", "GDT 原生Native 返回的 cpm价格：" + getCpm());
            }
            if (nativeUnifiedADData.getAdPatternType() == 2) {
                setImageMode(5);
                nativeUnifiedADData.preloadVideo(new VideoPreloadListener(this, GdtNativeLoader.this) { // from class: com.bytedance.msdk.adapter.gdt.GdtNativeLoader.GdtNativeAd.1
                    @Override // com.p518qq.p519e.ads.nativ.VideoPreloadListener
                    public void onVideoCacheFailed(int i, String str) {
                    }

                    @Override // com.p518qq.p519e.ads.nativ.VideoPreloadListener
                    public void onVideoCached() {
                    }
                });
            } else if (nativeUnifiedADData.getAdPatternType() == 4 || nativeUnifiedADData.getAdPatternType() == 1) {
                setImageMode(3);
            } else if (nativeUnifiedADData.getAdPatternType() == 3) {
                setImageMode(4);
            }
            if (nativeUnifiedADData.isAppAd()) {
                setInteractionType(4);
            } else {
                setInteractionType(3);
            }
        }

        /* renamed from: b */
        private void m37781b(Context context, @NonNull ViewGroup viewGroup, List<View> list, List<View> list2, TTViewBinder tTViewBinder) {
            NativeAdContainer nativeAdContainer;
            Object tag;
            if (this.f21393a == null || !(viewGroup instanceof TTNativeAdView)) {
                return;
            }
            TTNativeAdView tTNativeAdView = (TTNativeAdView) viewGroup;
            int i = 0;
            if (tTNativeAdView.getChildAt(0) instanceof NativeAdContainer) {
                nativeAdContainer = (NativeAdContainer) tTNativeAdView.getChildAt(0);
                while (i < nativeAdContainer.getChildCount()) {
                    View childAt = nativeAdContainer.getChildAt(i);
                    if (childAt == null || ((tag = childAt.getTag(C5988R.C5989id.tt_mediation_gdt_developer_view_tag_key)) != null && (tag instanceof String) && ((String) tag).equals("tt_gdt_developer_view"))) {
                        i++;
                    } else {
                        nativeAdContainer.removeView(childAt);
                    }
                }
            } else {
                nativeAdContainer = new NativeAdContainer(GdtNativeLoader.this.f21385g);
                nativeAdContainer.setTag(C5988R.C5989id.tt_mediation_gdt_developer_view_root_tag_key, "tt_gdt_developer_view_root");
                while (tTNativeAdView.getChildCount() > 0) {
                    View childAt2 = tTNativeAdView.getChildAt(0);
                    childAt2.setTag(C5988R.C5989id.tt_mediation_gdt_developer_view_tag_key, "tt_gdt_developer_view");
                    int indexOfChild = tTNativeAdView.indexOfChild(childAt2);
                    tTNativeAdView.removeViewInLayout(childAt2);
                    nativeAdContainer.addView(childAt2, indexOfChild, childAt2.getLayoutParams());
                }
                tTNativeAdView.removeAllViews();
                tTNativeAdView.addView(nativeAdContainer, -1, -1);
            }
            NativeAdContainer nativeAdContainer2 = nativeAdContainer;
            TTMediaView tTMediaView = (TTMediaView) tTNativeAdView.findViewById(tTViewBinder.mediaViewId);
            this.f21393a.bindAdToView(context, nativeAdContainer2, GdtNativeLoader.this.f21390l, list, list2);
            if (tTMediaView != null && getImageMode() == 5) {
                MediaView mediaView = new MediaView(GdtNativeLoader.this.f21385g);
                tTMediaView.removeAllViews();
                tTMediaView.addView(mediaView, -1, -1);
                this.f21393a.bindMediaView(mediaView, GdtNativeLoader.this.f21389k, this.f21394b);
            }
            if (!TextUtils.isEmpty(this.f21393a.getCTAText())) {
                View findViewById = tTNativeAdView.findViewById(tTViewBinder.callToActionId);
                ArrayList arrayList = new ArrayList();
                arrayList.add(findViewById);
                this.f21393a.bindCTAViews(arrayList);
            }
            this.f21393a.setNativeAdEventListener(new NativeADEventListener() { // from class: com.bytedance.msdk.adapter.gdt.GdtNativeLoader.GdtNativeAd.2
                @Override // com.p518qq.p519e.ads.nativ.NativeADEventListener
                public void onADClicked() {
                    if (((TTBaseAd) GdtNativeAd.this).mTTNativeAdListener != null) {
                        ((TTBaseAd) GdtNativeAd.this).mTTNativeAdListener.onAdClick();
                    }
                    Log.d("GdtNativeLoader", "Native GDT --- onADClicked。。。。");
                }

                @Override // com.p518qq.p519e.ads.nativ.NativeADEventListener
                public void onADError(AdError adError) {
                    Log.d("TTMediationSDK", "GDT --- onADError error code :" + adError.getErrorCode() + "  error msg: " + adError.getErrorMsg());
                }

                @Override // com.p518qq.p519e.ads.nativ.NativeADEventListener
                public void onADExposed() {
                    if (((TTBaseAd) GdtNativeAd.this).mTTNativeAdListener != null) {
                        ((TTBaseAd) GdtNativeAd.this).mTTNativeAdListener.onAdShow();
                    }
                    Log.d("GdtNativeLoader", "Native GDT --- onADExposed。。。。");
                }

                @Override // com.p518qq.p519e.ads.nativ.NativeADEventListener
                public void onADStatusChanged() {
                }
            });
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public int getAdType() {
            return 5;
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public boolean hasDestroyed() {
            return this.f21393a == null;
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public void onDestroy() {
            NativeUnifiedADData nativeUnifiedADData = this.f21393a;
            if (nativeUnifiedADData != null) {
                nativeUnifiedADData.destroy();
                this.f21393a = null;
            }
            super.onDestroy();
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public void onPause() {
            super.onPause();
            NativeUnifiedADData nativeUnifiedADData = this.f21393a;
            if (nativeUnifiedADData != null) {
                nativeUnifiedADData.pauseVideo();
            }
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public void onResume() {
            super.onResume();
            NativeUnifiedADData nativeUnifiedADData = this.f21393a;
            if (nativeUnifiedADData != null) {
                nativeUnifiedADData.resume();
            }
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public void registerViewForInteraction(@NonNull Activity activity, @NonNull ViewGroup viewGroup, List<View> list, List<View> list2, TTViewBinder tTViewBinder) {
            super.registerViewForInteraction(viewGroup, list, list2, tTViewBinder);
            m37781b(activity, viewGroup, list, list2, tTViewBinder);
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public void registerViewForInteraction(@NonNull ViewGroup viewGroup, List<View> list, TTViewBinder tTViewBinder) {
            registerViewForInteraction(viewGroup, list, null, tTViewBinder);
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public void registerViewForInteraction(@NonNull ViewGroup viewGroup, List<View> list, List<View> list2, TTViewBinder tTViewBinder) {
            super.registerViewForInteraction(viewGroup, list, list2, tTViewBinder);
            m37781b(GdtNativeLoader.this.f21385g, viewGroup, list, list2, tTViewBinder);
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public void unregisterView() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public GdtNativeLoader m37790a(int i) {
        this.f21382d = i;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public GdtNativeLoader m37789b(FrameLayout.LayoutParams layoutParams) {
        this.f21390l = layoutParams;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public GdtNativeLoader m37788c(TTVideoOption tTVideoOption) {
        this.f21386h = tTVideoOption;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: d */
    public GdtNativeLoader m37787d(String str) {
        this.f21381c = str;
        return this;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x009a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void loadAd(android.content.Context r3, boolean r4, final com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter r5) {
        /*
            r2 = this;
            r2.f21385g = r3
            r2.f21388j = r4
            com.qq.e.ads.nativ.NativeUnifiedAD r4 = new com.qq.e.ads.nativ.NativeUnifiedAD
            java.lang.String r0 = r2.f21381c
            com.bytedance.msdk.adapter.gdt.GdtNativeLoader$1 r1 = new com.bytedance.msdk.adapter.gdt.GdtNativeLoader$1
            r1.<init>()
            r4.<init>(r3, r0, r1)
            r2.f21380b = r4
            com.bytedance.msdk.api.TTVideoOption r3 = r2.f21386h
            if (r3 == 0) goto L1c
            com.bytedance.msdk.api.GDTExtraOption r3 = r3.getGDTExtraOption()
            r2.f21387i = r3
        L1c:
            com.bytedance.msdk.api.GDTExtraOption r3 = r2.f21387i
            if (r3 == 0) goto L2e
            int r3 = r3.getGDTMaxVideoDuration()
            r2.f21384f = r3
            com.bytedance.msdk.api.GDTExtraOption r3 = r2.f21387i
            int r3 = r3.getGDTMinVideoDuration()
            r2.f21383e = r3
        L2e:
            int r3 = r2.f21383e
            if (r3 <= 0) goto L37
            com.qq.e.ads.nativ.NativeUnifiedAD r4 = r2.f21380b
            r4.setMinVideoDuration(r3)
        L37:
            int r3 = r2.f21384f
            if (r3 <= 0) goto L40
            com.qq.e.ads.nativ.NativeUnifiedAD r4 = r2.f21380b
            r4.setMaxVideoDuration(r3)
        L40:
            com.bytedance.msdk.api.GDTExtraOption r3 = r2.f21387i
            com.qq.e.ads.cfg.VideoOption r3 = com.bytedance.msdk.adapter.gdt.GDTAdapterUtils.getVideoOption(r3)
            r2.f21389k = r3
            com.qq.e.ads.nativ.NativeUnifiedAD r4 = r2.f21380b
            int r3 = r3.getAutoPlayPolicy()
            android.content.Context r5 = r2.f21385g
            int r3 = com.bytedance.msdk.adapter.gdt.GDTAdapterUtils.getVideoPlayPolicy(r3, r5)
            r4.setVideoPlayPolicy(r3)
            com.qq.e.ads.nativ.NativeUnifiedAD r3 = r2.f21380b
            r4 = 1
            r3.setVideoADContainerRender(r4)
            com.bytedance.msdk.api.GDTExtraOption r3 = r2.f21387i
            if (r3 == 0) goto La7
            int r3 = r3.getBrowserType()
            if (r3 != 0) goto L6f
            com.qq.e.ads.nativ.NativeUnifiedAD r3 = r2.f21380b
            com.qq.e.ads.cfg.BrowserType r5 = com.qq.e.ads.cfg.BrowserType.Default
        L6b:
            r3.setBrowserType(r5)
            goto L8a
        L6f:
            com.bytedance.msdk.api.GDTExtraOption r3 = r2.f21387i
            int r3 = r3.getBrowserType()
            if (r3 != r4) goto L7c
            com.qq.e.ads.nativ.NativeUnifiedAD r3 = r2.f21380b
            com.qq.e.ads.cfg.BrowserType r5 = com.qq.e.ads.cfg.BrowserType.Inner
            goto L6b
        L7c:
            com.bytedance.msdk.api.GDTExtraOption r3 = r2.f21387i
            int r3 = r3.getBrowserType()
            r5 = 2
            if (r3 != r5) goto L8a
            com.qq.e.ads.nativ.NativeUnifiedAD r3 = r2.f21380b
            com.qq.e.ads.cfg.BrowserType r5 = com.qq.e.ads.cfg.BrowserType.Sys
            goto L6b
        L8a:
            com.bytedance.msdk.api.GDTExtraOption r3 = r2.f21387i
            int r3 = r3.getDownAPPConfirmPolicy()
            if (r3 != 0) goto L9a
            com.qq.e.ads.nativ.NativeUnifiedAD r3 = r2.f21380b
            com.qq.e.ads.cfg.DownAPPConfirmPolicy r4 = com.p518qq.p519e.ads.cfg.DownAPPConfirmPolicy.Default
        L96:
            r3.setDownAPPConfirmPolicy(r4)
            goto La7
        L9a:
            com.bytedance.msdk.api.GDTExtraOption r3 = r2.f21387i
            int r3 = r3.getDownAPPConfirmPolicy()
            if (r3 != r4) goto La7
            com.qq.e.ads.nativ.NativeUnifiedAD r3 = r2.f21380b
            com.qq.e.ads.cfg.DownAPPConfirmPolicy r4 = com.p518qq.p519e.ads.cfg.DownAPPConfirmPolicy.NOConfirm
            goto L96
        La7:
            com.qq.e.ads.nativ.NativeUnifiedADData r3 = r2.f21379a
            if (r3 == 0) goto Lb1
            r3.destroy()
            r3 = 0
            r2.f21379a = r3
        Lb1:
            com.qq.e.ads.nativ.NativeUnifiedAD r3 = r2.f21380b
            if (r3 == 0) goto Lba
            int r4 = r2.f21382d
            r3.loadData(r4)
        Lba:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.adapter.gdt.GdtNativeLoader.loadAd(android.content.Context, boolean, com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter):void");
    }
}

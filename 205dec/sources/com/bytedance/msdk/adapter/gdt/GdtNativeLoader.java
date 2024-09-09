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
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.nativ.MediaView;
import com.qq.e.ads.nativ.NativeADEventListener;
import com.qq.e.ads.nativ.NativeADMediaListener;
import com.qq.e.ads.nativ.NativeUnifiedAD;
import com.qq.e.ads.nativ.NativeUnifiedADAppMiitInfo;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import com.qq.e.ads.nativ.VideoPreloadListener;
import com.qq.e.ads.nativ.widget.NativeAdContainer;
import com.qq.e.comm.util.AdError;
import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class GdtNativeLoader {

    /* renamed from: a  reason: collision with root package name */
    private NativeUnifiedADData f26989a;

    /* renamed from: b  reason: collision with root package name */
    private NativeUnifiedAD f26990b;

    /* renamed from: c  reason: collision with root package name */
    private String f26991c;

    /* renamed from: d  reason: collision with root package name */
    private int f26992d;

    /* renamed from: e  reason: collision with root package name */
    private int f26993e;

    /* renamed from: f  reason: collision with root package name */
    private int f26994f;

    /* renamed from: g  reason: collision with root package name */
    private Context f26995g;

    /* renamed from: h  reason: collision with root package name */
    private TTVideoOption f26996h;

    /* renamed from: i  reason: collision with root package name */
    private GDTExtraOption f26997i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f26998j;

    /* renamed from: k  reason: collision with root package name */
    private VideoOption f26999k;

    /* renamed from: l  reason: collision with root package name */
    private FrameLayout.LayoutParams f27000l;

    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class GdtNativeAd extends TTBaseAd {

        /* renamed from: a  reason: collision with root package name */
        NativeUnifiedADData f27003a;

        /* renamed from: b  reason: collision with root package name */
        NativeADMediaListener f27004b = new NativeADMediaListener() { // from class: com.bytedance.msdk.adapter.gdt.GdtNativeLoader.GdtNativeAd.3
            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            public void onVideoClicked() {
                if (((TTBaseAd) GdtNativeAd.this).mTTNativeAdListener != null) {
                    ((TTBaseAd) GdtNativeAd.this).mTTNativeAdListener.onAdClick();
                }
                Log.d("GdtNativeLoader", "onVideoClicked");
            }

            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            public void onVideoCompleted() {
                if (((TTBaseAd) GdtNativeAd.this).mTTVideoListener != null) {
                    ((TTBaseAd) GdtNativeAd.this).mTTVideoListener.onVideoCompleted();
                }
            }

            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            public void onVideoError(AdError adError) {
                if (((TTBaseAd) GdtNativeAd.this).mTTVideoListener != null) {
                    ((TTBaseAd) GdtNativeAd.this).mTTVideoListener.onVideoError(new com.bytedance.msdk.api.AdError(adError.getErrorCode(), adError.getErrorMsg()));
                }
            }

            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            public void onVideoInit() {
                Log.d("GdtNativeLoader", "onVideoInit: ");
            }

            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            public void onVideoLoaded(int i4) {
                Log.d("GdtNativeLoader", "onVideoLoaded: ");
            }

            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            public void onVideoLoading() {
                Log.d("GdtNativeLoader", "onVideoLoading: ");
            }

            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            public void onVideoPause() {
                if (((TTBaseAd) GdtNativeAd.this).mTTVideoListener != null) {
                    ((TTBaseAd) GdtNativeAd.this).mTTVideoListener.onVideoPause();
                }
            }

            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            public void onVideoReady() {
                Log.d("GdtNativeLoader", "onVideoReady");
            }

            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            public void onVideoResume() {
                if (((TTBaseAd) GdtNativeAd.this).mTTVideoListener != null) {
                    ((TTBaseAd) GdtNativeAd.this).mTTVideoListener.onVideoResume();
                }
            }

            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            public void onVideoStart() {
                Log.d("GdtNativeLoader", "onVideoStart");
                if (((TTBaseAd) GdtNativeAd.this).mTTVideoListener != null) {
                    ((TTBaseAd) GdtNativeAd.this).mTTVideoListener.onVideoStart();
                }
            }

            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            public void onVideoStop() {
                Log.d("GdtNativeLoader", "onVideoStop");
            }
        };

        GdtNativeAd(NativeUnifiedADData nativeUnifiedADData) {
            this.f27003a = nativeUnifiedADData;
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
            if (GdtNativeLoader.this.f26998j) {
                setCpm(nativeUnifiedADData.getECPM() != -1 ? nativeUnifiedADData.getECPM() : 0.0d);
                Logger.d("TTMediationSDK_ECMP", "GDT \u539f\u751fNative \u8fd4\u56de\u7684 cpm\u4ef7\u683c\uff1a" + getCpm());
            }
            if (nativeUnifiedADData.getAdPatternType() == 2) {
                setImageMode(5);
                nativeUnifiedADData.preloadVideo(new VideoPreloadListener(this, GdtNativeLoader.this) { // from class: com.bytedance.msdk.adapter.gdt.GdtNativeLoader.GdtNativeAd.1
                    @Override // com.qq.e.ads.nativ.VideoPreloadListener
                    public void onVideoCacheFailed(int i4, String str) {
                    }

                    @Override // com.qq.e.ads.nativ.VideoPreloadListener
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

        private void b(Context context, @NonNull ViewGroup viewGroup, List<View> list, List<View> list2, TTViewBinder tTViewBinder) {
            NativeAdContainer nativeAdContainer;
            Object tag;
            if (this.f27003a == null || !(viewGroup instanceof TTNativeAdView)) {
                return;
            }
            TTNativeAdView tTNativeAdView = (TTNativeAdView) viewGroup;
            int i4 = 0;
            if (tTNativeAdView.getChildAt(0) instanceof NativeAdContainer) {
                nativeAdContainer = (NativeAdContainer) tTNativeAdView.getChildAt(0);
                while (i4 < nativeAdContainer.getChildCount()) {
                    View childAt = nativeAdContainer.getChildAt(i4);
                    if (childAt == null || ((tag = childAt.getTag(R.id.tt_mediation_gdt_developer_view_tag_key)) != null && (tag instanceof String) && ((String) tag).equals("tt_gdt_developer_view"))) {
                        i4++;
                    } else {
                        nativeAdContainer.removeView(childAt);
                    }
                }
            } else {
                nativeAdContainer = new NativeAdContainer(GdtNativeLoader.this.f26995g);
                nativeAdContainer.setTag(R.id.tt_mediation_gdt_developer_view_root_tag_key, "tt_gdt_developer_view_root");
                while (tTNativeAdView.getChildCount() > 0) {
                    View childAt2 = tTNativeAdView.getChildAt(0);
                    childAt2.setTag(R.id.tt_mediation_gdt_developer_view_tag_key, "tt_gdt_developer_view");
                    int indexOfChild = tTNativeAdView.indexOfChild(childAt2);
                    tTNativeAdView.removeViewInLayout(childAt2);
                    nativeAdContainer.addView(childAt2, indexOfChild, childAt2.getLayoutParams());
                }
                tTNativeAdView.removeAllViews();
                tTNativeAdView.addView(nativeAdContainer, -1, -1);
            }
            NativeAdContainer nativeAdContainer2 = nativeAdContainer;
            TTMediaView tTMediaView = (TTMediaView) tTNativeAdView.findViewById(tTViewBinder.mediaViewId);
            this.f27003a.bindAdToView(context, nativeAdContainer2, GdtNativeLoader.this.f27000l, list, list2);
            if (tTMediaView != null && getImageMode() == 5) {
                MediaView mediaView = new MediaView(GdtNativeLoader.this.f26995g);
                tTMediaView.removeAllViews();
                tTMediaView.addView(mediaView, -1, -1);
                this.f27003a.bindMediaView(mediaView, GdtNativeLoader.this.f26999k, this.f27004b);
            }
            if (!TextUtils.isEmpty(this.f27003a.getCTAText())) {
                View findViewById = tTNativeAdView.findViewById(tTViewBinder.callToActionId);
                ArrayList arrayList = new ArrayList();
                arrayList.add(findViewById);
                this.f27003a.bindCTAViews(arrayList);
            }
            this.f27003a.setNativeAdEventListener(new NativeADEventListener() { // from class: com.bytedance.msdk.adapter.gdt.GdtNativeLoader.GdtNativeAd.2
                @Override // com.qq.e.ads.nativ.NativeADEventListener
                public void onADClicked() {
                    if (((TTBaseAd) GdtNativeAd.this).mTTNativeAdListener != null) {
                        ((TTBaseAd) GdtNativeAd.this).mTTNativeAdListener.onAdClick();
                    }
                    Log.d("GdtNativeLoader", "Native GDT --- onADClicked\u3002\u3002\u3002\u3002");
                }

                @Override // com.qq.e.ads.nativ.NativeADEventListener
                public void onADError(AdError adError) {
                    Log.d("TTMediationSDK", "GDT --- onADError error code :" + adError.getErrorCode() + "  error msg: " + adError.getErrorMsg());
                }

                @Override // com.qq.e.ads.nativ.NativeADEventListener
                public void onADExposed() {
                    if (((TTBaseAd) GdtNativeAd.this).mTTNativeAdListener != null) {
                        ((TTBaseAd) GdtNativeAd.this).mTTNativeAdListener.onAdShow();
                    }
                    Log.d("GdtNativeLoader", "Native GDT --- onADExposed\u3002\u3002\u3002\u3002");
                }

                @Override // com.qq.e.ads.nativ.NativeADEventListener
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
            return this.f27003a == null;
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public void onDestroy() {
            NativeUnifiedADData nativeUnifiedADData = this.f27003a;
            if (nativeUnifiedADData != null) {
                nativeUnifiedADData.destroy();
                this.f27003a = null;
            }
            super.onDestroy();
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public void onPause() {
            super.onPause();
            NativeUnifiedADData nativeUnifiedADData = this.f27003a;
            if (nativeUnifiedADData != null) {
                nativeUnifiedADData.pauseVideo();
            }
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public void onResume() {
            super.onResume();
            NativeUnifiedADData nativeUnifiedADData = this.f27003a;
            if (nativeUnifiedADData != null) {
                nativeUnifiedADData.resume();
            }
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public void registerViewForInteraction(@NonNull Activity activity, @NonNull ViewGroup viewGroup, List<View> list, List<View> list2, TTViewBinder tTViewBinder) {
            super.registerViewForInteraction(viewGroup, list, list2, tTViewBinder);
            b(activity, viewGroup, list, list2, tTViewBinder);
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public void registerViewForInteraction(@NonNull ViewGroup viewGroup, List<View> list, TTViewBinder tTViewBinder) {
            registerViewForInteraction(viewGroup, list, null, tTViewBinder);
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public void registerViewForInteraction(@NonNull ViewGroup viewGroup, List<View> list, List<View> list2, TTViewBinder tTViewBinder) {
            super.registerViewForInteraction(viewGroup, list, list2, tTViewBinder);
            b(GdtNativeLoader.this.f26995g, viewGroup, list, list2, tTViewBinder);
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public void unregisterView() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GdtNativeLoader a(int i4) {
        this.f26992d = i4;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GdtNativeLoader b(FrameLayout.LayoutParams layoutParams) {
        this.f27000l = layoutParams;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GdtNativeLoader c(TTVideoOption tTVideoOption) {
        this.f26996h = tTVideoOption;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GdtNativeLoader d(String str) {
        this.f26991c = str;
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
            r2.f26995g = r3
            r2.f26998j = r4
            com.qq.e.ads.nativ.NativeUnifiedAD r4 = new com.qq.e.ads.nativ.NativeUnifiedAD
            java.lang.String r0 = r2.f26991c
            com.bytedance.msdk.adapter.gdt.GdtNativeLoader$1 r1 = new com.bytedance.msdk.adapter.gdt.GdtNativeLoader$1
            r1.<init>()
            r4.<init>(r3, r0, r1)
            r2.f26990b = r4
            com.bytedance.msdk.api.TTVideoOption r3 = r2.f26996h
            if (r3 == 0) goto L1c
            com.bytedance.msdk.api.GDTExtraOption r3 = r3.getGDTExtraOption()
            r2.f26997i = r3
        L1c:
            com.bytedance.msdk.api.GDTExtraOption r3 = r2.f26997i
            if (r3 == 0) goto L2e
            int r3 = r3.getGDTMaxVideoDuration()
            r2.f26994f = r3
            com.bytedance.msdk.api.GDTExtraOption r3 = r2.f26997i
            int r3 = r3.getGDTMinVideoDuration()
            r2.f26993e = r3
        L2e:
            int r3 = r2.f26993e
            if (r3 <= 0) goto L37
            com.qq.e.ads.nativ.NativeUnifiedAD r4 = r2.f26990b
            r4.setMinVideoDuration(r3)
        L37:
            int r3 = r2.f26994f
            if (r3 <= 0) goto L40
            com.qq.e.ads.nativ.NativeUnifiedAD r4 = r2.f26990b
            r4.setMaxVideoDuration(r3)
        L40:
            com.bytedance.msdk.api.GDTExtraOption r3 = r2.f26997i
            com.qq.e.ads.cfg.VideoOption r3 = com.bytedance.msdk.adapter.gdt.GDTAdapterUtils.getVideoOption(r3)
            r2.f26999k = r3
            com.qq.e.ads.nativ.NativeUnifiedAD r4 = r2.f26990b
            int r3 = r3.getAutoPlayPolicy()
            android.content.Context r5 = r2.f26995g
            int r3 = com.bytedance.msdk.adapter.gdt.GDTAdapterUtils.getVideoPlayPolicy(r3, r5)
            r4.setVideoPlayPolicy(r3)
            com.qq.e.ads.nativ.NativeUnifiedAD r3 = r2.f26990b
            r4 = 1
            r3.setVideoADContainerRender(r4)
            com.bytedance.msdk.api.GDTExtraOption r3 = r2.f26997i
            if (r3 == 0) goto La7
            int r3 = r3.getBrowserType()
            if (r3 != 0) goto L6f
            com.qq.e.ads.nativ.NativeUnifiedAD r3 = r2.f26990b
            com.qq.e.ads.cfg.BrowserType r5 = com.qq.e.ads.cfg.BrowserType.Default
        L6b:
            r3.setBrowserType(r5)
            goto L8a
        L6f:
            com.bytedance.msdk.api.GDTExtraOption r3 = r2.f26997i
            int r3 = r3.getBrowserType()
            if (r3 != r4) goto L7c
            com.qq.e.ads.nativ.NativeUnifiedAD r3 = r2.f26990b
            com.qq.e.ads.cfg.BrowserType r5 = com.qq.e.ads.cfg.BrowserType.Inner
            goto L6b
        L7c:
            com.bytedance.msdk.api.GDTExtraOption r3 = r2.f26997i
            int r3 = r3.getBrowserType()
            r5 = 2
            if (r3 != r5) goto L8a
            com.qq.e.ads.nativ.NativeUnifiedAD r3 = r2.f26990b
            com.qq.e.ads.cfg.BrowserType r5 = com.qq.e.ads.cfg.BrowserType.Sys
            goto L6b
        L8a:
            com.bytedance.msdk.api.GDTExtraOption r3 = r2.f26997i
            int r3 = r3.getDownAPPConfirmPolicy()
            if (r3 != 0) goto L9a
            com.qq.e.ads.nativ.NativeUnifiedAD r3 = r2.f26990b
            com.qq.e.ads.cfg.DownAPPConfirmPolicy r4 = com.qq.e.ads.cfg.DownAPPConfirmPolicy.Default
        L96:
            r3.setDownAPPConfirmPolicy(r4)
            goto La7
        L9a:
            com.bytedance.msdk.api.GDTExtraOption r3 = r2.f26997i
            int r3 = r3.getDownAPPConfirmPolicy()
            if (r3 != r4) goto La7
            com.qq.e.ads.nativ.NativeUnifiedAD r3 = r2.f26990b
            com.qq.e.ads.cfg.DownAPPConfirmPolicy r4 = com.qq.e.ads.cfg.DownAPPConfirmPolicy.NOConfirm
            goto L96
        La7:
            com.qq.e.ads.nativ.NativeUnifiedADData r3 = r2.f26989a
            if (r3 == 0) goto Lb1
            r3.destroy()
            r3 = 0
            r2.f26989a = r3
        Lb1:
            com.qq.e.ads.nativ.NativeUnifiedAD r3 = r2.f26990b
            if (r3 == 0) goto Lba
            int r4 = r2.f26992d
            r3.loadData(r4)
        Lba:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.adapter.gdt.GdtNativeLoader.loadAd(android.content.Context, boolean, com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter):void");
    }
}

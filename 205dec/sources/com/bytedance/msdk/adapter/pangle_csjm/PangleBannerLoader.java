package com.bytedance.msdk.adapter.pangle_csjm;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.msdk.adapter.c;
import com.bytedance.msdk.adapter.sr.f;
import com.bytedance.msdk.adapter.sr.r;
import com.bytedance.msdk.c.ux;
import com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract;
import com.bytedance.sdk.openadsdk.core.wv;
import com.bytedance.sdk.openadsdk.ls.c.w.c.w;
import com.bytedance.sdk.openadsdk.ys.w.w.bk;
import com.bytedance.sdk.openadsdk.ys.w.w.ev;
import com.bytedance.sdk.openadsdk.ys.w.w.k;
import com.bytedance.sdk.openadsdk.ys.w.w.sr;
import com.bytedance.sdk.openadsdk.ys.w.w.t;
import com.bytedance.sdk.openadsdk.ys.w.w.xv;
import com.bytedance.sdk.openadsdk.ys.w.w.ys;
import com.bytedance.sdk.openadsdk.ys.w.xv.w;
import com.mbridge.msdk.mbbid.out.BidResponsed;
import com.stub.StubApp;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class PangleBannerLoader extends c {

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    class PangleNativeAd extends ux {
        private Context sr;
        private boolean ux;
        private k xv;

        /* renamed from: t  reason: collision with root package name */
        private volatile boolean f27115t = false;

        /* renamed from: c  reason: collision with root package name */
        com.bytedance.sdk.openadsdk.j.c.w.c.c f27114c = new com.bytedance.sdk.openadsdk.j.c.w.c.c(null) { // from class: com.bytedance.msdk.adapter.pangle_csjm.PangleBannerLoader.PangleNativeAd.3
            @Override // com.bytedance.sdk.openadsdk.j.c.w.c.c
            public void onAdClicked(View view, t tVar) {
                if (((ux) PangleNativeAd.this).f27667a instanceof com.bytedance.msdk.adapter.w.c) {
                    PangleNativeAd.this.c().j_();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.j.c.w.c.c
            public void onAdCreativeClick(View view, t tVar) {
                if (((ux) PangleNativeAd.this).f27667a instanceof com.bytedance.msdk.adapter.w.c) {
                    PangleNativeAd.this.c().j_();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.j.c.w.c.c
            public void onAdShow(t tVar) {
                if (((ux) PangleNativeAd.this).f27667a instanceof com.bytedance.msdk.adapter.w.c) {
                    PangleNativeAd.this.c().k_();
                }
            }
        };

        PangleNativeAd(Context context, k kVar) {
            Map<String, Object> q3;
            this.xv = kVar;
            this.sr = context;
            xv fz = kVar.fz();
            if (fz != null) {
                setAppName(fz.c());
                setAuthorName(fz.xv());
                setPrivacyAgreement(fz.sr());
                setVersionName(fz.w());
                HashMap hashMap = new HashMap();
                Map<String, String> ux = fz.ux();
                if (ux != null && ux.size() > 0) {
                    hashMap.putAll(ux);
                }
                setPermissionsMap(hashMap);
                if (PangleAdapterUtils.currentSdkVerGreaterThanOrEqual(PangleAdapterUtils.VERSION_5403)) {
                    setFunctionDescUrl(fz.r());
                }
            }
            setTitle(kVar.r());
            setAdDescription(kVar.ev());
            setActionText(kVar.gd());
            setIconUrl(kVar.t() != null ? kVar.t().xv() : null);
            setImageMode(kVar.ia());
            setInteractionType(kVar.fp());
            setSource(kVar.bk());
            setRating(kVar.p());
            setIsAppDownload(kVar.fp() == 4);
            setExpressAd(false);
            if (kVar.ia() != 16 && kVar.ia() != 3 && kVar.ia() != 2) {
                if (kVar.ia() == 4 && kVar.ys() != null && kVar.ys().size() > 0) {
                    ArrayList arrayList = new ArrayList();
                    for (bk bkVar : kVar.ys()) {
                        arrayList.add(bkVar.xv());
                    }
                    setImages(arrayList);
                }
            } else if (kVar.ys() != null && !kVar.ys().isEmpty() && kVar.ys().get(0) != null) {
                bk bkVar2 = kVar.ys().get(0);
                setImageUrl(bkVar2.xv());
                setImageHeight(bkVar2.c());
                setImageWidth(bkVar2.w());
            }
            setImageMode(kVar.ia());
            if (!PangleBannerLoader.this.isClientBidding() || (q3 = kVar.q()) == null) {
                return;
            }
            double value = PangleAdapterUtils.getValue(q3.get(BidResponsed.KEY_PRICE));
            com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK_ECMP", "pangle native \u8fd4\u56de\u7684 cpm\u4ef7\u683c\uff1a" + value);
            setCpm(value <= 0.0d ? 0.0d : value);
        }

        @Override // com.bytedance.msdk.c.ux
        public long getAdId() {
            k kVar = this.xv;
            if (kVar != null) {
                return PangleAdapterUtils.getAdId(kVar.q());
            }
            return 0L;
        }

        @Override // com.bytedance.msdk.c.ux
        public long getCreativeId() {
            k kVar = this.xv;
            if (kVar != null) {
                return PangleAdapterUtils.getCreativeId(kVar.q());
            }
            return 0L;
        }

        @Override // com.bytedance.msdk.c.ux, com.bytedance.msdk.c.xv
        public ev getDislikeDialog(Activity activity) {
            if (this.xv != null) {
                com.bytedance.msdk.adapter.sr.xv.w("TTMediationSDK", "pangle banner native: getDislikeDialog = " + activity);
                return this.xv.c(activity);
            }
            return null;
        }

        @Override // com.bytedance.msdk.c.ux, com.bytedance.msdk.c.xv
        public sr getDislikeInfo() {
            if (this.xv != null) {
                com.bytedance.msdk.adapter.sr.xv.w("TTMediationSDK", "pangle banner native : getDislikeInfo");
                return this.xv.s();
            }
            return null;
        }

        @Override // com.bytedance.msdk.c.ux
        public Map<String, Object> getMediaExtraInfo() {
            Map<String, Object> q3;
            k kVar = this.xv;
            if (kVar == null || (q3 = kVar.q()) == null) {
                return null;
            }
            HashMap hashMap = new HashMap();
            hashMap.put(PangleAdapterUtils.MEDIA_EXTRA_COUPON, q3.get(PangleAdapterUtils.MEDIA_EXTRA_COUPON));
            hashMap.put(PangleAdapterUtils.MEDIA_EXTRA_LIVE_ROOM, q3.get(PangleAdapterUtils.MEDIA_EXTRA_LIVE_ROOM));
            hashMap.put(PangleAdapterUtils.MEDIA_EXTRA_PRODUCT, q3.get(PangleAdapterUtils.MEDIA_EXTRA_PRODUCT));
            setMediaExtraInfo(hashMap);
            return super.getMediaExtraInfo();
        }

        @Override // com.bytedance.msdk.c.ux
        public String getReqId() {
            k kVar = this.xv;
            return kVar != null ? PangleAdapterUtils.getReqId(kVar.q()) : "";
        }

        @Override // com.bytedance.msdk.c.ux
        public int getVideoHeight() {
            k kVar = this.xv;
            if (kVar != null) {
                return kVar.sr();
            }
            return 0;
        }

        @Override // com.bytedance.msdk.c.ux
        public int getVideoWidth() {
            k kVar = this.xv;
            if (kVar != null) {
                return kVar.xv();
            }
            return 0;
        }

        @Override // com.bytedance.msdk.c.ux
        public boolean hasDestroyed() {
            return this.f27115t;
        }

        @Override // com.bytedance.msdk.c.ux
        public boolean hasDislike() {
            return true;
        }

        @Override // com.bytedance.msdk.c.ux
        public void onDestroy() {
            this.f27115t = true;
            f.xv(new Runnable() { // from class: com.bytedance.msdk.adapter.pangle_csjm.PangleBannerLoader.PangleNativeAd.2
                @Override // java.lang.Runnable
                public void run() {
                    if (PangleNativeAd.this.xv != null) {
                        PangleNativeAd.this.xv.c((com.bytedance.sdk.openadsdk.i.c.w.c.c) null);
                        PangleNativeAd.this.xv.ls();
                    }
                }
            });
        }

        @Override // com.bytedance.msdk.c.ux
        public void registerViewForInteraction(Activity activity, ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, com.bytedance.msdk.api.sr.c.r.k kVar) {
            FrameLayout frameLayout;
            k kVar2;
            View i4;
            View findViewById;
            super.registerViewForInteraction(activity, viewGroup, list, list2, list3, kVar);
            if (viewGroup instanceof FrameLayout) {
                k kVar3 = this.xv;
                if (kVar3 != null) {
                    kVar3.c(viewGroup, (List<View>) null, list, list2, list3, (View) null, this.f27114c);
                    this.xv.c(activity, new com.bytedance.sdk.openadsdk.s.c.w.c.c(null) { // from class: com.bytedance.msdk.adapter.pangle_csjm.PangleBannerLoader.PangleNativeAd.1
                        @Override // com.bytedance.sdk.openadsdk.s.c.w.c.c
                        public void onCancel() {
                        }

                        @Override // com.bytedance.sdk.openadsdk.s.c.w.c.c
                        public void onSelected(int i5, String str, boolean z3) {
                            if (PangleNativeAd.this.ux) {
                                return;
                            }
                            PangleNativeAd.this.ux = true;
                            if (((ux) PangleNativeAd.this).f27667a instanceof com.bytedance.msdk.adapter.w.c) {
                                com.bytedance.msdk.core.w.c.c(PangleBannerLoader.this.getAdapterRit());
                                PangleNativeAd.this.c().i_();
                            }
                        }

                        @Override // com.bytedance.sdk.openadsdk.s.c.w.c.c
                        public void onShow() {
                        }
                    });
                }
                k kVar4 = this.xv;
                if (kVar4 != null && kVar4.f() != null && kVar != null && (findViewById = viewGroup.findViewById(kVar.f27511a)) != null) {
                    findViewById.setVisibility(0);
                    if (findViewById instanceof ViewGroup) {
                        ViewGroup viewGroup2 = (ViewGroup) findViewById;
                        viewGroup2.removeAllViews();
                        ImageView imageView = new ImageView(this.sr);
                        imageView.setImageBitmap(this.xv.f());
                        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                        ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
                        layoutParams.width = r.w(this.sr, 38.0f);
                        layoutParams.height = r.w(this.sr, 38.0f);
                        findViewById.setLayoutParams(layoutParams);
                        viewGroup2.addView(imageView, -1, -1);
                    } else if (findViewById instanceof ImageView) {
                        ((ImageView) findViewById).setImageBitmap(this.xv.f());
                    }
                }
                if (kVar == null || (frameLayout = (FrameLayout) viewGroup.findViewById(kVar.f27516r)) == null || (kVar2 = this.xv) == null || (i4 = kVar2.i()) == null) {
                    return;
                }
                removeSelfFromParent(i4);
                frameLayout.removeAllViews();
                frameLayout.addView(i4, -1, -1);
            }
        }

        @Override // com.bytedance.msdk.c.ux, com.bytedance.msdk.c.xv
        public void setDislikeCallback(Activity activity, final com.bytedance.sdk.openadsdk.s.c.w.c.c cVar) {
            if (this.xv != null) {
                com.bytedance.msdk.adapter.sr.xv.w("TTMediationSDK", "pangle banner native:  activity = " + activity + " pluginDislikeInteractionCallback:" + cVar);
                this.xv.c(activity, new com.bytedance.sdk.openadsdk.s.c.w.c.c(null) { // from class: com.bytedance.msdk.adapter.pangle_csjm.PangleBannerLoader.PangleNativeAd.4
                    @Override // com.bytedance.sdk.openadsdk.s.c.w.c.c
                    public void onCancel() {
                        com.bytedance.sdk.openadsdk.s.c.w.c.c cVar2 = cVar;
                        if (cVar2 != null) {
                            cVar2.onCancel();
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.s.c.w.c.c
                    public void onSelected(int i4, String str, boolean z3) {
                        if (PangleNativeAd.this.ux) {
                            return;
                        }
                        PangleNativeAd.this.ux = true;
                        com.bytedance.msdk.core.w.c.c(PangleBannerLoader.this.getAdapterRit());
                        com.bytedance.sdk.openadsdk.s.c.w.c.c cVar2 = cVar;
                        if (cVar2 != null) {
                            cVar2.onSelected(i4, str, z3);
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.s.c.w.c.c
                    public void onShow() {
                        com.bytedance.sdk.openadsdk.s.c.w.c.c cVar2 = cVar;
                        if (cVar2 != null) {
                            cVar2.onShow();
                        }
                    }
                });
            }
        }

        @Override // com.bytedance.msdk.c.ux, com.bytedance.msdk.c.xv
        public void setDislikeDialog(Dialog dialog) {
            if (this.xv != null) {
                com.bytedance.msdk.adapter.sr.xv.w("TTMediationSDK", "pangle banner native:  ttDislikeDialogAbstract = " + dialog);
                if (dialog instanceof TTDislikeDialogAbstract) {
                    this.xv.w((TTDislikeDialogAbstract) dialog);
                }
            }
        }

        @Override // com.bytedance.msdk.c.ux, com.bytedance.msdk.c.xv
        public void uploadDislikeEvent(String str) {
            com.bytedance.msdk.adapter.sr.xv.w("TTMediationSDK", "pangle banner native: uploadDislikeEvent event = " + str);
            k kVar = this.xv;
            if (kVar != null) {
                kVar.c(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public com.bytedance.msdk.adapter.w.c c() {
            return (com.bytedance.msdk.adapter.w.c) this.f27667a;
        }

        @Override // com.bytedance.msdk.c.ux, com.bytedance.msdk.c.xv
        public ev getDislikeDialog(TTDislikeDialogAbstract tTDislikeDialogAbstract) {
            if (this.xv != null) {
                com.bytedance.msdk.adapter.sr.xv.w("TTMediationSDK", "pangle banner native : getDislikeDialog = " + tTDislikeDialogAbstract);
                return this.xv.c(tTDislikeDialogAbstract);
            }
            return null;
        }
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    class PangleNativeExpressAd extends ux {

        /* renamed from: c  reason: collision with root package name */
        ys f27122c;
        private volatile boolean sr = false;
        private final w ux;
        private boolean xv;

        PangleNativeExpressAd(Context context, ys ysVar) {
            Map<String, Object> r3;
            w wVar = new w(null) { // from class: com.bytedance.msdk.adapter.pangle_csjm.PangleBannerLoader.PangleNativeExpressAd.3
                @Override // com.bytedance.sdk.openadsdk.ls.c.w.c.w
                public void onAdClicked(View view, int i4) {
                    if (((ux) PangleNativeExpressAd.this).f27667a instanceof com.bytedance.msdk.adapter.w.c) {
                        PangleNativeExpressAd.this.c().j_();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.ls.c.w.c.w
                public void onAdShow(View view, int i4) {
                    if (((ux) PangleNativeExpressAd.this).f27667a instanceof com.bytedance.msdk.adapter.w.c) {
                        PangleNativeExpressAd.this.c().k_();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.ls.c.w.c.w
                public void onRenderFail(View view, String str, int i4) {
                    PangleBannerLoader.this.notifyAdFailed(new com.bytedance.msdk.api.c(i4, str));
                }

                @Override // com.bytedance.sdk.openadsdk.ls.c.w.c.w
                public void onRenderSuccess(View view, float f4, float f5) {
                    PangleNativeExpressAd pangleNativeExpressAd = PangleNativeExpressAd.this;
                    PangleBannerLoader.this.notifyAdLoaded(pangleNativeExpressAd);
                }
            };
            this.ux = wVar;
            this.f27122c = ysVar;
            setImageMode(ysVar.w());
            setInteractionType(this.f27122c.xv());
            setExpressAd(true);
            this.f27122c.c(wVar);
            if (context instanceof Activity) {
                this.f27122c.c((Activity) context, new com.bytedance.sdk.openadsdk.s.c.w.c.c(null) { // from class: com.bytedance.msdk.adapter.pangle_csjm.PangleBannerLoader.PangleNativeExpressAd.1
                    @Override // com.bytedance.sdk.openadsdk.s.c.w.c.c
                    public void onCancel() {
                    }

                    @Override // com.bytedance.sdk.openadsdk.s.c.w.c.c
                    public void onSelected(int i4, String str, boolean z3) {
                        if (PangleNativeExpressAd.this.xv) {
                            return;
                        }
                        PangleNativeExpressAd.this.xv = true;
                        if (((ux) PangleNativeExpressAd.this).f27667a instanceof com.bytedance.msdk.adapter.w.c) {
                            com.bytedance.msdk.core.w.c.c(PangleBannerLoader.this.getAdapterRit());
                            PangleNativeExpressAd.this.c().i_();
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.s.c.w.c.c
                    public void onShow() {
                    }
                });
            }
            if (!PangleBannerLoader.this.isClientBidding() || (r3 = this.f27122c.r()) == null) {
                return;
            }
            double value = PangleAdapterUtils.getValue(r3.get(BidResponsed.KEY_PRICE));
            com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK_ECMP", "banner\u6df7\u5b58 pangle \u6a21\u677fnative \u8fd4\u56de\u7684 cpm\u4ef7\u683c\uff1a" + value);
            setCpm(value <= 0.0d ? 0.0d : value);
        }

        @Override // com.bytedance.msdk.c.ux
        public long getAdId() {
            ys ysVar = this.f27122c;
            if (ysVar != null) {
                return PangleAdapterUtils.getAdId(ysVar.r());
            }
            return 0L;
        }

        @Override // com.bytedance.msdk.c.ux
        public View getAdView() {
            ys ysVar = this.f27122c;
            if (ysVar != null) {
                return ysVar.c();
            }
            return null;
        }

        @Override // com.bytedance.msdk.c.ux
        public long getCreativeId() {
            ys ysVar = this.f27122c;
            if (ysVar != null) {
                return PangleAdapterUtils.getCreativeId(ysVar.r());
            }
            return 0L;
        }

        @Override // com.bytedance.msdk.c.ux, com.bytedance.msdk.c.xv
        public ev getDislikeDialog(Activity activity) {
            ys ysVar = this.f27122c;
            if (ysVar != null) {
                return ysVar.c(activity);
            }
            return super.getDislikeDialog(activity);
        }

        @Override // com.bytedance.msdk.c.ux, com.bytedance.msdk.c.xv
        public sr getDislikeInfo() {
            ys ysVar = this.f27122c;
            if (ysVar != null) {
                return ysVar.f();
            }
            return super.getDislikeInfo();
        }

        @Override // com.bytedance.msdk.c.ux
        public Map<String, Object> getMediaExtraInfo() {
            Map<String, Object> r3;
            ys ysVar = this.f27122c;
            if (ysVar == null || (r3 = ysVar.r()) == null) {
                return null;
            }
            HashMap hashMap = new HashMap();
            hashMap.put(PangleAdapterUtils.MEDIA_EXTRA_COUPON, r3.get(PangleAdapterUtils.MEDIA_EXTRA_COUPON));
            hashMap.put(PangleAdapterUtils.MEDIA_EXTRA_LIVE_ROOM, r3.get(PangleAdapterUtils.MEDIA_EXTRA_LIVE_ROOM));
            hashMap.put(PangleAdapterUtils.MEDIA_EXTRA_PRODUCT, r3.get(PangleAdapterUtils.MEDIA_EXTRA_PRODUCT));
            setMediaExtraInfo(hashMap);
            return super.getMediaExtraInfo();
        }

        @Override // com.bytedance.msdk.c.ux
        public String getReqId() {
            ys ysVar = this.f27122c;
            return ysVar != null ? PangleAdapterUtils.getReqId(ysVar.r()) : "";
        }

        @Override // com.bytedance.msdk.c.ux
        public boolean hasDestroyed() {
            return this.sr;
        }

        @Override // com.bytedance.msdk.c.ux
        public void onDestroy() {
            this.sr = true;
            f.xv(new Runnable() { // from class: com.bytedance.msdk.adapter.pangle_csjm.PangleBannerLoader.PangleNativeExpressAd.2
                @Override // java.lang.Runnable
                public void run() {
                    ys ysVar = PangleNativeExpressAd.this.f27122c;
                    if (ysVar != null) {
                        ysVar.ux();
                    }
                }
            });
        }

        @Override // com.bytedance.msdk.c.ux
        public void render() {
            ys ysVar = this.f27122c;
            if (ysVar != null) {
                ysVar.sr();
            }
        }

        @Override // com.bytedance.msdk.c.ux, com.bytedance.msdk.c.xv
        public void setDislikeCallback(Activity activity, final com.bytedance.sdk.openadsdk.s.c.w.c.c cVar) {
            if (this.f27122c != null) {
                com.bytedance.msdk.adapter.sr.xv.w("TTMediationSDK", "pangle banner-native express:  activity = " + activity + " pluginDislikeInteractionCallback:" + cVar);
                this.f27122c.c(activity, new com.bytedance.sdk.openadsdk.s.c.w.c.c(null) { // from class: com.bytedance.msdk.adapter.pangle_csjm.PangleBannerLoader.PangleNativeExpressAd.4
                    @Override // com.bytedance.sdk.openadsdk.s.c.w.c.c
                    public void onCancel() {
                        com.bytedance.sdk.openadsdk.s.c.w.c.c cVar2 = cVar;
                        if (cVar2 != null) {
                            cVar2.onCancel();
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.s.c.w.c.c
                    public void onSelected(int i4, String str, boolean z3) {
                        if (PangleNativeExpressAd.this.xv) {
                            return;
                        }
                        PangleNativeExpressAd.this.xv = true;
                        com.bytedance.msdk.core.w.c.c(PangleBannerLoader.this.getAdapterRit());
                        com.bytedance.sdk.openadsdk.s.c.w.c.c cVar2 = cVar;
                        if (cVar2 != null) {
                            cVar2.onSelected(i4, str, z3);
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.s.c.w.c.c
                    public void onShow() {
                        com.bytedance.sdk.openadsdk.s.c.w.c.c cVar2 = cVar;
                        if (cVar2 != null) {
                            cVar2.onShow();
                        }
                    }
                });
            }
        }

        @Override // com.bytedance.msdk.c.ux, com.bytedance.msdk.c.xv
        public void setDislikeDialog(Dialog dialog) {
            if (this.f27122c != null) {
                com.bytedance.msdk.adapter.sr.xv.w("TTMediationSDK", "pangle banner-native express:  ttDislikeDialogAbstract = " + dialog);
                if (dialog instanceof TTDislikeDialogAbstract) {
                    this.f27122c.c((TTDislikeDialogAbstract) dialog);
                }
            }
        }

        @Override // com.bytedance.msdk.c.ux, com.bytedance.msdk.c.xv
        public void uploadDislikeEvent(String str) {
            com.bytedance.msdk.adapter.sr.xv.w("TTMediationSDK", "pangle banner express: uploadDislikeEvent event = " + str);
            ys ysVar = this.f27122c;
            if (ysVar != null) {
                ysVar.c(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public com.bytedance.msdk.adapter.w.c c() {
            return (com.bytedance.msdk.adapter.w.c) this.f27667a;
        }
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    class TTBannerView extends ux {

        /* renamed from: c  reason: collision with root package name */
        ys f27130c;

        /* renamed from: t  reason: collision with root package name */
        private boolean f27131t;
        private boolean ux;

        /* renamed from: w  reason: collision with root package name */
        SoftReference<FrameLayout> f27132w;
        final Object xv = new Object();
        private volatile boolean ys = false;
        private final w fp = new w(null) { // from class: com.bytedance.msdk.adapter.pangle_csjm.PangleBannerLoader.TTBannerView.4
            @Override // com.bytedance.sdk.openadsdk.ls.c.w.c.w
            public void onAdClicked(View view, int i4) {
                if (((ux) TTBannerView.this).f27667a instanceof com.bytedance.msdk.adapter.w.c) {
                    TTBannerView.this.c().j_();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.ls.c.w.c.w
            public void onAdShow(View view, int i4) {
                if (((ux) TTBannerView.this).f27667a instanceof com.bytedance.msdk.adapter.w.c) {
                    TTBannerView.this.c().k_();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.ls.c.w.c.w
            public void onRenderFail(View view, String str, int i4) {
                TTBannerView.this.f27131t = false;
                com.bytedance.msdk.adapter.sr.xv.sr("TTMediationSDK_banner", com.bytedance.msdk.adapter.sr.ux.w(PangleBannerLoader.this.getAdapterRit(), PangleBannerLoader.this.getAdSlotId()) + "TTBannerView onRenderFail -> code=" + i4 + ",msg=" + str);
            }

            @Override // com.bytedance.sdk.openadsdk.ls.c.w.c.w
            public void onRenderSuccess(View view, float f4, float f5) {
                com.bytedance.msdk.adapter.sr.xv.sr("TTMediationSDK_banner", com.bytedance.msdk.adapter.sr.ux.w(PangleBannerLoader.this.getAdapterRit(), PangleBannerLoader.this.getAdSlotId()) + "TTBannerView onRenderSuccess \u6e32\u67d3\u6210\u529f\uff01\uff01mBannerViewRef = " + TTBannerView.this.f27132w);
                SoftReference<FrameLayout> softReference = TTBannerView.this.f27132w;
                if (softReference != null) {
                    FrameLayout frameLayout = softReference.get();
                    if (frameLayout != null) {
                        PangleBannerLoader.this.removeFromParent(view);
                        frameLayout.addView(view, new ViewGroup.LayoutParams(-1, -1));
                    }
                    TTBannerView.this.f27131t = true;
                }
            }
        };

        TTBannerView() {
        }

        @Override // com.bytedance.msdk.c.ux
        public long getAdId() {
            ys ysVar = this.f27130c;
            if (ysVar != null) {
                return PangleAdapterUtils.getAdId(ysVar.r());
            }
            return 0L;
        }

        @Override // com.bytedance.msdk.c.ux
        public synchronized View getAdView() {
            SoftReference<FrameLayout> softReference = this.f27132w;
            if (softReference == null) {
                return null;
            }
            FrameLayout frameLayout = softReference.get();
            synchronized (this.xv) {
                if (frameLayout == null) {
                    try {
                        long uptimeMillis = SystemClock.uptimeMillis();
                        long j4 = 2000 + uptimeMillis;
                        while (!this.f27131t && uptimeMillis < j4) {
                            this.xv.wait(j4 - uptimeMillis);
                            uptimeMillis = SystemClock.uptimeMillis();
                        }
                    } catch (InterruptedException e4) {
                        e4.printStackTrace();
                    }
                }
            }
            return frameLayout;
        }

        @Override // com.bytedance.msdk.c.ux
        public long getCreativeId() {
            ys ysVar = this.f27130c;
            if (ysVar != null) {
                return PangleAdapterUtils.getCreativeId(ysVar.r());
            }
            return 0L;
        }

        @Override // com.bytedance.msdk.c.ux, com.bytedance.msdk.c.xv
        public ev getDislikeDialog(Activity activity) {
            if (this.f27130c != null) {
                com.bytedance.msdk.adapter.sr.xv.w("TTMediationSDK", "pangle banner : getDislikeDialog = " + activity);
                return this.f27130c.c(activity);
            }
            return null;
        }

        @Override // com.bytedance.msdk.c.ux, com.bytedance.msdk.c.xv
        public sr getDislikeInfo() {
            if (this.f27130c != null) {
                com.bytedance.msdk.adapter.sr.xv.w("TTMediationSDK", "pangle banner : getDislikeInfo");
                return this.f27130c.f();
            }
            return null;
        }

        @Override // com.bytedance.msdk.c.ux
        public Map<String, Object> getMediaExtraInfo() {
            Map<String, Object> r3;
            ys ysVar = this.f27130c;
            if (ysVar == null || (r3 = ysVar.r()) == null) {
                return null;
            }
            HashMap hashMap = new HashMap();
            hashMap.put(PangleAdapterUtils.MEDIA_EXTRA_COUPON, r3.get(PangleAdapterUtils.MEDIA_EXTRA_COUPON));
            hashMap.put(PangleAdapterUtils.MEDIA_EXTRA_LIVE_ROOM, r3.get(PangleAdapterUtils.MEDIA_EXTRA_LIVE_ROOM));
            hashMap.put(PangleAdapterUtils.MEDIA_EXTRA_PRODUCT, r3.get(PangleAdapterUtils.MEDIA_EXTRA_PRODUCT));
            setMediaExtraInfo(hashMap);
            return super.getMediaExtraInfo();
        }

        @Override // com.bytedance.msdk.c.ux
        public String getReqId() {
            ys ysVar = this.f27130c;
            return ysVar != null ? PangleAdapterUtils.getReqId(ysVar.r()) : "";
        }

        @Override // com.bytedance.msdk.c.ux
        public boolean hasDestroyed() {
            return this.ys;
        }

        public void loadAd(final Context context) {
            wv pluginCSJLoader = PangleBannerLoader.this.getPluginCSJLoader(context);
            if (pluginCSJLoader == null) {
                return;
            }
            w.c buildPangleAdSlot = PangleAdapterUtils.buildPangleAdSlot(((c) PangleBannerLoader.this).xv, PangleBannerLoader.this.getAdSlotId(), ((c) PangleBannerLoader.this).f26913c, PangleBannerLoader.this.getClientReqId(), PangleBannerLoader.this.getAdm(), false);
            float bk = ((c) PangleBannerLoader.this).xv.bk();
            buildPangleAdSlot.c(bk).w(((c) PangleBannerLoader.this).xv.t());
            pluginCSJLoader.xv(buildPangleAdSlot.c(), new com.bytedance.sdk.openadsdk.fz.c.w.c.f(null) { // from class: com.bytedance.msdk.adapter.pangle_csjm.PangleBannerLoader.TTBannerView.1
                @Override // com.bytedance.sdk.openadsdk.fz.c.w.c.f
                public void onError(int i4, String str) {
                    PangleBannerLoader.this.notifyAdFailed(new com.bytedance.msdk.api.c(i4, str));
                }

                @Override // com.bytedance.sdk.openadsdk.fz.c.w.c.f
                public void onNativeExpressAdLoad(List<ys> list) {
                    Map<String, Object> r3;
                    if (list != null && list.size() != 0 && context != null) {
                        TTBannerView.this.f27130c = list.get(0);
                        Context context2 = context;
                        if (context2 instanceof Activity) {
                            TTBannerView.this.f27130c.c((Activity) context2, new com.bytedance.sdk.openadsdk.s.c.w.c.c(null) { // from class: com.bytedance.msdk.adapter.pangle_csjm.PangleBannerLoader.TTBannerView.1.1
                                @Override // com.bytedance.sdk.openadsdk.s.c.w.c.c
                                public void onCancel() {
                                }

                                @Override // com.bytedance.sdk.openadsdk.s.c.w.c.c
                                public void onSelected(int i4, String str, boolean z3) {
                                    if (TTBannerView.this.ux) {
                                        return;
                                    }
                                    TTBannerView.this.ux = true;
                                    if (((ux) TTBannerView.this).f27667a instanceof com.bytedance.msdk.adapter.w.c) {
                                        com.bytedance.msdk.core.w.c.c(PangleBannerLoader.this.getAdapterRit());
                                        TTBannerView.this.c().i_();
                                    }
                                }

                                @Override // com.bytedance.sdk.openadsdk.s.c.w.c.c
                                public void onShow() {
                                }
                            });
                        }
                        TTBannerView.this.setExpressAd(true);
                        TTBannerView tTBannerView = TTBannerView.this;
                        tTBannerView.setInteractionType(tTBannerView.f27130c.xv());
                        TTBannerView tTBannerView2 = TTBannerView.this;
                        tTBannerView2.setImageMode(tTBannerView2.f27130c.w());
                        if (PangleBannerLoader.this.isClientBidding() && (r3 = TTBannerView.this.f27130c.r()) != null) {
                            double value = PangleAdapterUtils.getValue(r3.get(BidResponsed.KEY_PRICE));
                            com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK_ECMP", com.bytedance.msdk.adapter.sr.ux.w(PangleBannerLoader.this.getAdapterRit(), PangleBannerLoader.this.getAdSlotId()) + "pangle banner \u8fd4\u56de\u7684 cpm\u4ef7\u683c\uff1a" + value);
                            TTBannerView tTBannerView3 = TTBannerView.this;
                            if (value <= 0.0d) {
                                value = 0.0d;
                            }
                            tTBannerView3.setCpm(value);
                        }
                        TTBannerView tTBannerView4 = TTBannerView.this;
                        tTBannerView4.f27130c.c(tTBannerView4.fp);
                        TTBannerView.this.f27132w = new SoftReference<>(new FrameLayout(context));
                        TTBannerView.this.f27130c.sr();
                        TTBannerView tTBannerView5 = TTBannerView.this;
                        PangleBannerLoader.this.notifyAdLoaded(tTBannerView5);
                        return;
                    }
                    PangleBannerLoader.this.notifyAdFailed(new com.bytedance.msdk.api.c(80001, "load list is null or empty"));
                }
            });
        }

        @Override // com.bytedance.msdk.c.ux
        public void onDestroy() {
            this.ys = true;
            f.xv(new Runnable() { // from class: com.bytedance.msdk.adapter.pangle_csjm.PangleBannerLoader.TTBannerView.2
                @Override // java.lang.Runnable
                public void run() {
                    ys ysVar = TTBannerView.this.f27130c;
                    if (ysVar != null) {
                        ysVar.c((com.bytedance.sdk.openadsdk.ls.c.w.c.c) null);
                        TTBannerView.this.f27130c.ux();
                    }
                }
            });
        }

        @Override // com.bytedance.msdk.c.ux, com.bytedance.msdk.c.xv
        public void setDislikeCallback(Activity activity, final com.bytedance.sdk.openadsdk.s.c.w.c.c cVar) {
            if (this.f27130c != null) {
                com.bytedance.msdk.adapter.sr.xv.w("TTMediationSDK", "pangle banner : activity = " + activity + " pluginDislikeInteractionCallback:" + cVar);
                this.f27130c.c(activity, new com.bytedance.sdk.openadsdk.s.c.w.c.c(null) { // from class: com.bytedance.msdk.adapter.pangle_csjm.PangleBannerLoader.TTBannerView.3
                    @Override // com.bytedance.sdk.openadsdk.s.c.w.c.c
                    public void onCancel() {
                        com.bytedance.sdk.openadsdk.s.c.w.c.c cVar2 = cVar;
                        if (cVar2 != null) {
                            cVar2.onCancel();
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.s.c.w.c.c
                    public void onSelected(int i4, String str, boolean z3) {
                        if (TTBannerView.this.ux) {
                            return;
                        }
                        TTBannerView.this.ux = true;
                        com.bytedance.msdk.core.w.c.c(PangleBannerLoader.this.getAdapterRit());
                        com.bytedance.sdk.openadsdk.s.c.w.c.c cVar2 = cVar;
                        if (cVar2 != null) {
                            cVar2.onSelected(i4, str, z3);
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.s.c.w.c.c
                    public void onShow() {
                        com.bytedance.sdk.openadsdk.s.c.w.c.c cVar2 = cVar;
                        if (cVar2 != null) {
                            cVar2.onShow();
                        }
                    }
                });
            }
        }

        @Override // com.bytedance.msdk.c.ux, com.bytedance.msdk.c.xv
        public void setDislikeDialog(Dialog dialog) {
            if (this.f27130c != null) {
                com.bytedance.msdk.adapter.sr.xv.w("TTMediationSDK", "pangle banner :  ttDislikeDialogAbstract = " + dialog);
                if (dialog instanceof TTDislikeDialogAbstract) {
                    this.f27130c.c((TTDislikeDialogAbstract) dialog);
                }
            }
        }

        @Override // com.bytedance.msdk.c.ux, com.bytedance.msdk.c.xv
        public void uploadDislikeEvent(String str) {
            com.bytedance.msdk.adapter.sr.xv.w("TTMediationSDK", "pangle banner : uploadDislikeEvent event = " + str);
            ys ysVar = this.f27130c;
            if (ysVar != null) {
                ysVar.c(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public com.bytedance.msdk.adapter.w.c c() {
            return (com.bytedance.msdk.adapter.w.c) this.f27667a;
        }
    }

    @Override // com.bytedance.msdk.adapter.c
    public void destroy() {
    }

    @Override // com.bytedance.msdk.adapter.c
    public String getAdNetWorkName() {
        return "pangle";
    }

    @Override // com.bytedance.msdk.adapter.c
    public String getSdkVersion() {
        try {
            return com.bytedance.sdk.gromore.init.c.xv();
        } catch (Exception unused) {
            return "0.0";
        }
    }

    @Override // com.bytedance.msdk.adapter.c
    public void loadAd(Context context, Map<String, Object> map) {
        if (this.xv == null) {
            notifyAdFailed(new com.bytedance.msdk.api.c("load ad fail adSlot is null"));
        } else if (map != null) {
            Object obj = map.get("tt_ad_sub_type");
            if (obj != null && ((Integer) obj).intValue() == 4) {
                Object obj2 = map.get("tt_ad_origin_type");
                if (obj2 != null) {
                    int intValue = ((Integer) obj2).intValue();
                    if (intValue == 1) {
                        c(context);
                        return;
                    } else if (intValue == 2) {
                        w(StubApp.getOrigApplicationContext(context.getApplicationContext()));
                        return;
                    } else {
                        notifyAdFailed(new com.bytedance.msdk.api.c(80001, "originType is mismatch"));
                        return;
                    }
                }
                return;
            }
            new TTBannerView().loadAd(context);
        }
    }

    private void c(final Context context) {
        wv pluginCSJLoader = getPluginCSJLoader(context);
        if (pluginCSJLoader == null) {
            return;
        }
        w.c w3 = PangleAdapterUtils.buildPangleAdSlot(this.xv, getAdSlotId(), this.f26913c, getClientReqId(), getAdm(), false).c(this.xv.q()).w(this.xv.j());
        float bk = this.xv.bk();
        float t3 = this.xv.t();
        boolean isExpressNativeAutoHeight = PangleAdapterUtils.isExpressNativeAutoHeight(this.xv);
        com.bytedance.msdk.adapter.sr.xv.w("TTMediationSDK", "pangle banner native express autoHeight:" + isExpressNativeAutoHeight + " width:" + bk + "  height:" + t3);
        if (t3 > 0.0f && !isExpressNativeAutoHeight) {
            w3.c(bk).w(t3);
        } else {
            w3.c(bk).w(0.0f);
        }
        pluginCSJLoader.c(w3.c(), new com.bytedance.sdk.openadsdk.fz.c.w.c.f(null) { // from class: com.bytedance.msdk.adapter.pangle_csjm.PangleBannerLoader.1
            @Override // com.bytedance.sdk.openadsdk.fz.c.w.c.f
            public void onError(int i4, String str) {
                PangleBannerLoader.this.notifyAdFailed(new com.bytedance.msdk.api.c(i4, str));
            }

            @Override // com.bytedance.sdk.openadsdk.fz.c.w.c.f
            public void onNativeExpressAdLoad(List<ys> list) {
                if (list != null && list.size() != 0) {
                    for (ys ysVar : list) {
                        if (ysVar != null) {
                            new PangleNativeExpressAd(context, ysVar).render();
                            return;
                        }
                    }
                    return;
                }
                PangleBannerLoader.this.notifyAdFailed(new com.bytedance.msdk.api.c(80001, "load list is null or empty"));
            }
        });
    }

    private void w(final Context context) {
        wv pluginCSJLoader = getPluginCSJLoader(context);
        if (pluginCSJLoader == null) {
            return;
        }
        w.c buildPangleAdSlot = PangleAdapterUtils.buildPangleAdSlot(this.xv, getAdSlotId(), this.f26913c, getClientReqId(), getAdm(), false);
        buildPangleAdSlot.c(this.xv.q()).w(this.xv.j());
        pluginCSJLoader.c(buildPangleAdSlot.c(), new com.bytedance.sdk.openadsdk.fz.c.w.c.xv(null) { // from class: com.bytedance.msdk.adapter.pangle_csjm.PangleBannerLoader.2
            @Override // com.bytedance.sdk.openadsdk.fz.c.w.c.xv
            public void onError(int i4, String str) {
                PangleBannerLoader.this.notifyAdFailed(new com.bytedance.msdk.api.c(i4, str));
            }

            @Override // com.bytedance.sdk.openadsdk.fz.c.w.c.xv
            public void onFeedAdLoad(List<k> list) {
                if (list != null && !list.isEmpty()) {
                    PangleBannerLoader pangleBannerLoader = PangleBannerLoader.this;
                    pangleBannerLoader.notifyAdLoaded(new PangleNativeAd(context, list.get(0)));
                    return;
                }
                PangleBannerLoader.this.notifyAdFailed(new com.bytedance.msdk.api.c(80001, "load list is null or empty"));
            }
        });
    }
}

package com.bytedance.msdk.adapter.pangle_csjm;

import android.app.Activity;
import android.app.Dialog;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.bytedance.msdk.adapter.sr.r;
import com.bytedance.msdk.api.sr.c.r.gd;
import com.bytedance.msdk.c.ux;
import com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract;
import com.bytedance.sdk.openadsdk.core.wv;
import com.bytedance.sdk.openadsdk.j.c.w.c.c;
import com.bytedance.sdk.openadsdk.ys.w.c.w;
import com.bytedance.sdk.openadsdk.ys.w.w.bk;
import com.bytedance.sdk.openadsdk.ys.w.w.ev;
import com.bytedance.sdk.openadsdk.ys.w.w.k;
import com.bytedance.sdk.openadsdk.ys.w.w.sr;
import com.bytedance.sdk.openadsdk.ys.w.w.t;
import com.bytedance.sdk.openadsdk.ys.w.w.xv;
import com.mbridge.msdk.mbbid.out.BidResponsed;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class PangleNativeAd {

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    private static class PangleNative extends ux {
        private k sr;
        private int ux;

        /* renamed from: c  reason: collision with root package name */
        c f27164c = new c(null) { // from class: com.bytedance.msdk.adapter.pangle_csjm.PangleNativeAd.PangleNative.2
            @Override // com.bytedance.sdk.openadsdk.j.c.w.c.c
            public void onAdClicked(View view, t tVar) {
                if (((ux) PangleNative.this).f27671f != null) {
                    ((ux) PangleNative.this).f27671f.c();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.j.c.w.c.c
            public void onAdCreativeClick(View view, t tVar) {
                if (((ux) PangleNative.this).f27671f != null) {
                    ((ux) PangleNative.this).f27671f.c();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.j.c.w.c.c
            public void onAdShow(t tVar) {
                if (((ux) PangleNative.this).f27671f != null) {
                    ((ux) PangleNative.this).f27671f.w();
                }
            }
        };

        /* renamed from: w  reason: collision with root package name */
        com.bytedance.sdk.openadsdk.i.c.w.c.c f27165w = new com.bytedance.sdk.openadsdk.i.c.w.c.c(null) { // from class: com.bytedance.msdk.adapter.pangle_csjm.PangleNativeAd.PangleNative.3
            @Override // com.bytedance.sdk.openadsdk.i.c.w.c.c
            public void onProgressUpdate(long j4, long j5) {
                if (((ux) PangleNative.this).f27681r != null) {
                    ((ux) PangleNative.this).f27681r.c(j4, j5);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.i.c.w.c.c
            public void onVideoAdComplete(k kVar) {
                if (((ux) PangleNative.this).f27681r != null) {
                    ((ux) PangleNative.this).f27681r.vc();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.i.c.w.c.c
            public void onVideoAdContinuePlay(k kVar) {
                if (((ux) PangleNative.this).f27681r != null) {
                    ((ux) PangleNative.this).f27681r.gw();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.i.c.w.c.c
            public void onVideoAdPaused(k kVar) {
                if (((ux) PangleNative.this).f27681r != null) {
                    ((ux) PangleNative.this).f27681r.m();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.i.c.w.c.c
            public void onVideoAdStartPlay(k kVar) {
                if (((ux) PangleNative.this).f27681r != null) {
                    ((ux) PangleNative.this).f27681r.x();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.i.c.w.c.c
            public void onVideoError(int i4, int i5) {
                if (((ux) PangleNative.this).f27681r != null) {
                    gd gdVar = ((ux) PangleNative.this).f27681r;
                    gdVar.c(new com.bytedance.msdk.api.c(i4, "Android MediaPlay Error Code :" + i5));
                }
            }

            @Override // com.bytedance.sdk.openadsdk.i.c.w.c.c
            public void onVideoLoad(k kVar) {
            }
        };
        w xv = new w(null) { // from class: com.bytedance.msdk.adapter.pangle_csjm.PangleNativeAd.PangleNative.4
            @Override // com.bytedance.sdk.openadsdk.ys.w.c.w
            public void onDownloadActive(long j4, long j5, String str, String str2) {
                PangleNative.this.ux = 2;
                if (((ux) PangleNative.this).ev != null) {
                    ((ux) PangleNative.this).ev.c(j4, j5, (int) (j4 != 0 ? j5 / j4 : 0L), -1);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.ys.w.c.w
            public void onDownloadFailed(long j4, long j5, String str, String str2) {
                PangleNative.this.ux = 4;
                if (((ux) PangleNative.this).ev != null) {
                    ((ux) PangleNative.this).ev.w(j4, j5, str, str2);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.ys.w.c.w
            public void onDownloadFinished(long j4, String str, String str2) {
                PangleNative.this.ux = 5;
                if (((ux) PangleNative.this).ev != null) {
                    ((ux) PangleNative.this).ev.c(j4, str, str2);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.ys.w.c.w
            public void onDownloadPaused(long j4, long j5, String str, String str2) {
                PangleNative.this.ux = 3;
                if (((ux) PangleNative.this).ev != null) {
                    ((ux) PangleNative.this).ev.c(j4, j5, str, str2);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.ys.w.c.w
            public void onIdle() {
                PangleNative.this.ux = 0;
                if (((ux) PangleNative.this).ev != null) {
                    ((ux) PangleNative.this).ev.c();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.ys.w.c.w
            public void onInstalled(String str, String str2) {
                PangleNative.this.ux = 6;
                if (((ux) PangleNative.this).ev != null) {
                    ((ux) PangleNative.this).ev.c(str, str2);
                }
            }
        };

        PangleNative(k kVar, boolean z3, boolean z4) {
            Map<String, Object> q3;
            this.sr = kVar;
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
                if (PangleAdapterUtils.currentSdkVerGreaterThanOrEqual(PangleAdapterUtils.VERSION_5100)) {
                    setPermissionsUrl(fz.f());
                }
                if (PangleAdapterUtils.currentSdkVerGreaterThanOrEqual(PangleAdapterUtils.VERSION_5403)) {
                    setFunctionDescUrl(fz.r());
                }
            }
            setSupportRender(z4 ? 1 : 0);
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
                if (kVar.ia() == 4) {
                    if (kVar.ys() != null && kVar.ys().size() > 0) {
                        ArrayList arrayList = new ArrayList();
                        for (bk bkVar : kVar.ys()) {
                            arrayList.add(bkVar.xv());
                        }
                        setImages(arrayList);
                    }
                } else {
                    bk ux2 = kVar.ux();
                    if (ux2 == null && kVar.ys() != null && !kVar.ys().isEmpty() && kVar.ys().get(0) != null) {
                        ux2 = kVar.ys().get(0);
                    }
                    if (ux2 != null) {
                        setImageUrl(ux2.xv());
                        setImageHeight(ux2.c());
                        setImageWidth(ux2.w());
                    }
                }
            } else if (kVar.ys() != null && !kVar.ys().isEmpty() && kVar.ys().get(0) != null) {
                bk bkVar2 = kVar.ys().get(0);
                setImageUrl(bkVar2.xv());
                setImageHeight(bkVar2.c());
                setImageWidth(bkVar2.w());
            }
            if (z3 && (q3 = kVar.q()) != null) {
                double value = PangleAdapterUtils.getValue(q3.get(BidResponsed.KEY_PRICE));
                com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK_ECMP", "pangle native \u8fd4\u56de\u7684 cpm\u4ef7\u683c\uff1a" + value);
                setCpm(value <= 0.0d ? 0.0d : value);
            }
            this.sr.c(this.f27165w);
            this.sr.c(this.xv);
            new HashMap();
            putExtraMsg("ad_id", Long.valueOf(getAdId()));
            putExtraMsg("c_id", Long.valueOf(getCreativeId()));
            putExtraMsg("duration", Double.valueOf(this.sr.c()));
            Map<String, Object> q4 = this.sr.q();
            if (q4 != null) {
                putExtraMsg(q4);
                putExtraMsg("log_extra", q4.toString());
            }
        }

        @Override // com.bytedance.msdk.c.ux
        public void cancelDownload() {
            k kVar = this.sr;
            if (kVar == null || kVar.u() == null) {
                return;
            }
            this.sr.u().w();
        }

        @Override // com.bytedance.msdk.c.ux
        public long getAdId() {
            k kVar = this.sr;
            if (kVar != null) {
                return PangleAdapterUtils.getAdId(kVar.q());
            }
            return 0L;
        }

        @Override // com.bytedance.msdk.c.ux
        public long getCreativeId() {
            k kVar = this.sr;
            if (kVar != null) {
                return PangleAdapterUtils.getCreativeId(kVar.q());
            }
            return 0L;
        }

        @Override // com.bytedance.msdk.c.ux, com.bytedance.msdk.c.xv
        public ev getDislikeDialog(Activity activity) {
            if (this.sr != null) {
                com.bytedance.msdk.adapter.sr.xv.w("TTMediationSDK", "pangle native : getDislikeDialog = " + activity);
                return this.sr.c(activity);
            }
            return null;
        }

        @Override // com.bytedance.msdk.c.ux, com.bytedance.msdk.c.xv
        public sr getDislikeInfo() {
            if (this.sr != null) {
                com.bytedance.msdk.adapter.sr.xv.w("TTMediationSDK", "pangle native : getDislikeInfo");
                return this.sr.s();
            }
            return null;
        }

        @Override // com.bytedance.msdk.c.ux
        public int getDownloadStatus() {
            return this.ux;
        }

        @Override // com.bytedance.msdk.c.ux
        public Map<String, Object> getMediaExtraInfo() {
            Map<String, Object> q3;
            k kVar = this.sr;
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
            k kVar = this.sr;
            if (kVar != null) {
                return PangleAdapterUtils.getReqId(kVar.q());
            }
            return null;
        }

        @Override // com.bytedance.msdk.c.ux
        public int getVideoHeight() {
            k kVar = this.sr;
            if (kVar != null) {
                return kVar.sr();
            }
            return 0;
        }

        @Override // com.bytedance.msdk.c.ux
        public String getVideoUrl() {
            k kVar;
            if (!isUseCustomVideo() || (kVar = this.sr) == null || kVar.w() == null) {
                return null;
            }
            return this.sr.w().c();
        }

        @Override // com.bytedance.msdk.c.ux
        public int getVideoWidth() {
            k kVar = this.sr;
            if (kVar != null) {
                return kVar.xv();
            }
            return 0;
        }

        @Override // com.bytedance.msdk.c.ux
        public boolean hasDestroyed() {
            return this.sr == null;
        }

        @Override // com.bytedance.msdk.c.ux
        public boolean hasDislike() {
            return true;
        }

        @Override // com.bytedance.msdk.c.ux
        public void onDestroy() {
            k kVar = this.sr;
            if (kVar != null) {
                kVar.c((com.bytedance.sdk.openadsdk.i.c.w.c.c) null);
                this.sr.ls();
                this.sr = null;
            }
        }

        @Override // com.bytedance.msdk.c.ux
        public void pauseAppDownload() {
            k kVar = this.sr;
            if (kVar == null || kVar.u() == null || this.ux != 2) {
                return;
            }
            this.sr.u().c();
        }

        @Override // com.bytedance.msdk.c.ux
        public void registerViewForInteraction(Activity activity, @NonNull ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, com.bytedance.msdk.api.sr.c.r.k kVar) {
            FrameLayout frameLayout;
            k kVar2;
            View i4;
            k kVar3;
            View findViewById;
            super.registerViewForInteraction(activity, viewGroup, list, list2, list3, kVar);
            if (viewGroup instanceof FrameLayout) {
                k kVar4 = this.sr;
                if (kVar4 != null) {
                    kVar4.c(this.xv);
                    try {
                        this.sr.c(new com.bytedance.sdk.openadsdk.i.c.w.c.w(null) { // from class: com.bytedance.msdk.adapter.pangle_csjm.PangleNativeAd.PangleNative.1
                            @Override // com.bytedance.sdk.openadsdk.i.c.w.c.w
                            public void onFeedRewardCountDown(int i5) {
                                if (((ux) PangleNative.this).f27679p != null) {
                                    ((ux) PangleNative.this).f27679p.c(i5);
                                }
                            }
                        });
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                    this.sr.c(viewGroup, (List<View>) null, list, list2, list3, (View) null, this.f27164c);
                }
                k kVar5 = this.sr;
                if (kVar5 != null && kVar5.f() != null && kVar != null && (findViewById = viewGroup.findViewById(kVar.f27511a)) != null) {
                    findViewById.setVisibility(0);
                    if (findViewById instanceof ViewGroup) {
                        ViewGroup viewGroup2 = (ViewGroup) findViewById;
                        viewGroup2.removeAllViews();
                        ImageView imageView = new ImageView(viewGroup.getContext());
                        imageView.setImageBitmap(this.sr.f());
                        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                        ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
                        layoutParams.width = r.w(viewGroup.getContext(), 38.0f);
                        layoutParams.height = r.w(viewGroup.getContext(), 38.0f);
                        findViewById.setLayoutParams(layoutParams);
                        viewGroup2.addView(imageView, -1, -1);
                    } else if (findViewById instanceof ImageView) {
                        ((ImageView) findViewById).setImageBitmap(this.sr.f());
                    }
                }
                if ((isUseCustomVideo() && (kVar3 = this.sr) != null && kVar3.w() != null && !TextUtils.isEmpty(this.sr.w().c())) || kVar == null || (frameLayout = (FrameLayout) viewGroup.findViewById(kVar.f27516r)) == null || (kVar2 = this.sr) == null || (i4 = kVar2.i()) == null) {
                    return;
                }
                removeSelfFromParent(i4);
                frameLayout.removeAllViews();
                frameLayout.addView(i4, -1, -1);
            }
        }

        @Override // com.bytedance.msdk.c.ux
        public void resumeAppDownload() {
            k kVar = this.sr;
            if (kVar == null || kVar.u() == null || this.ux != 3) {
                return;
            }
            this.sr.u().c();
        }

        @Override // com.bytedance.msdk.c.ux, com.bytedance.msdk.c.xv
        public void setDislikeCallback(Activity activity, com.bytedance.sdk.openadsdk.s.c.w.c.c cVar) {
            if (this.sr != null) {
                com.bytedance.msdk.adapter.sr.xv.w("TTMediationSDK", "pangle native:  activity = " + activity + " pluginDislikeInteractionCallback:" + cVar);
                this.sr.c(activity, cVar);
            }
        }

        @Override // com.bytedance.msdk.c.ux, com.bytedance.msdk.c.xv
        public void setDislikeDialog(Dialog dialog) {
            if (this.sr != null) {
                com.bytedance.msdk.adapter.sr.xv.w("TTMediationSDK", "pangle native:  ttDislikeDialogAbstract = " + dialog);
                if (dialog instanceof TTDislikeDialogAbstract) {
                    this.sr.w((TTDislikeDialogAbstract) dialog);
                }
            }
        }

        @Override // com.bytedance.msdk.c.ux, com.bytedance.msdk.c.xv
        public void uploadDislikeEvent(String str) {
            if (this.sr != null) {
                com.bytedance.msdk.adapter.sr.xv.w("TTMediationSDK", "pangle native : uploadDislikeEvent event = " + str);
                this.sr.c(str);
            }
        }

        @Override // com.bytedance.msdk.c.ux, com.bytedance.msdk.c.xv
        public ev getDislikeDialog(TTDislikeDialogAbstract tTDislikeDialogAbstract) {
            if (this.sr != null) {
                com.bytedance.msdk.adapter.sr.xv.w("TTMediationSDK", "pangle native : getDislikeDialog = " + tTDislikeDialogAbstract);
                return this.sr.c(tTDislikeDialogAbstract);
            }
            return null;
        }
    }

    public void loadAd(final boolean z3, wv wvVar, final com.bytedance.sdk.openadsdk.ys.w.xv.w wVar, final com.bytedance.msdk.adapter.c cVar) {
        if (wvVar == null || cVar == null || wVar == null) {
            return;
        }
        wvVar.c(wVar, new com.bytedance.sdk.openadsdk.fz.c.w.c.xv(null) { // from class: com.bytedance.msdk.adapter.pangle_csjm.PangleNativeAd.1
            @Override // com.bytedance.sdk.openadsdk.fz.c.w.c.xv
            public void onError(int i4, String str) {
                cVar.notifyAdFailed(new com.bytedance.msdk.api.c(i4, str));
            }

            @Override // com.bytedance.sdk.openadsdk.fz.c.w.c.xv
            public void onFeedAdLoad(List<k> list) {
                com.bytedance.msdk.adapter.sr.xv.w("TTMediationSDK", "PangleNativeAd_onFeedAdLoad_SupportRenderControl:" + wVar.bk());
                if (list != null && !list.isEmpty()) {
                    if (wVar.bk()) {
                        PangleNativeAd.this.c(list, cVar, z3);
                        return;
                    }
                    ArrayList arrayList = new ArrayList();
                    for (k kVar : list) {
                        arrayList.add(new PangleNative(kVar, z3, false));
                    }
                    cVar.notifyAdLoaded(arrayList);
                    return;
                }
                cVar.notifyAdFailed(new com.bytedance.msdk.api.c(80001, "load\u6210\u529f\u4f46\u8fd4\u56de\u5e7f\u544a\u662f\u7a7a"));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(List<k> list, final com.bytedance.msdk.adapter.c cVar, final boolean z3) {
        int size = list.size();
        com.bytedance.msdk.adapter.sr.xv.w("TTMediationSDK", "PangleNativeAd_nativeSupportRenderControl_adNum:" + size);
        final AtomicInteger atomicInteger = new AtomicInteger();
        final ArrayList arrayList = new ArrayList();
        for (final k kVar : list) {
            final long currentTimeMillis = System.currentTimeMillis();
            final int i4 = size;
            kVar.c(new com.bytedance.sdk.openadsdk.j.c.w.c.w(null) { // from class: com.bytedance.msdk.adapter.pangle_csjm.PangleNativeAd.2
                @Override // com.bytedance.sdk.openadsdk.j.c.w.c.w
                public void onRenderSuccess(View view, float f4, float f5, boolean z4) {
                    com.bytedance.msdk.adapter.sr.xv.w("TTMediationSDK", "PangleNativeAd_nativeSupportRenderControl_onRenderSuccess:" + z4 + " duration:" + (System.currentTimeMillis() - currentTimeMillis));
                    arrayList.add(new PangleNative(kVar, z3, z4));
                    if (atomicInteger.incrementAndGet() != i4 || cVar == null) {
                        return;
                    }
                    com.bytedance.msdk.adapter.sr.xv.w("TTMediationSDK", "PangleNativeAd_nativeSupportRenderControl_notifyAdSuccess!!!!!");
                    cVar.notifyAdLoaded(arrayList);
                }
            });
            kVar.j();
            size = size;
        }
    }
}

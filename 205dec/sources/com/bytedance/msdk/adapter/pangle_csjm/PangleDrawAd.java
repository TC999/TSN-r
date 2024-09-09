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
import com.bytedance.msdk.api.sr.c.r.f;
import com.bytedance.msdk.api.sr.c.r.gd;
import com.bytedance.msdk.c.ux;
import com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract;
import com.bytedance.sdk.openadsdk.core.wv;
import com.bytedance.sdk.openadsdk.j.c.w.c.c;
import com.bytedance.sdk.openadsdk.ys.w.c.w;
import com.bytedance.sdk.openadsdk.ys.w.w.bk;
import com.bytedance.sdk.openadsdk.ys.w.w.ev;
import com.bytedance.sdk.openadsdk.ys.w.w.k;
import com.bytedance.sdk.openadsdk.ys.w.w.p;
import com.bytedance.sdk.openadsdk.ys.w.w.sr;
import com.bytedance.sdk.openadsdk.ys.w.w.t;
import com.bytedance.sdk.openadsdk.ys.w.w.xv;
import com.mbridge.msdk.mbbid.out.BidResponsed;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class PangleDrawAd {

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    private static class PangleDraw extends ux {
        private p sr;
        private int ux;

        /* renamed from: c  reason: collision with root package name */
        c f27142c = new c(null) { // from class: com.bytedance.msdk.adapter.pangle_csjm.PangleDrawAd.PangleDraw.2
            @Override // com.bytedance.sdk.openadsdk.j.c.w.c.c
            public void onAdClicked(View view, t tVar) {
                if (((ux) PangleDraw.this).f27676k != null) {
                    ((ux) PangleDraw.this).f27676k.c();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.j.c.w.c.c
            public void onAdCreativeClick(View view, t tVar) {
                if (((ux) PangleDraw.this).f27676k != null) {
                    ((ux) PangleDraw.this).f27676k.c();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.j.c.w.c.c
            public void onAdShow(t tVar) {
                if (((ux) PangleDraw.this).f27676k != null) {
                    ((ux) PangleDraw.this).f27676k.w();
                }
            }
        };

        /* renamed from: w  reason: collision with root package name */
        com.bytedance.sdk.openadsdk.i.c.w.c.c f27143w = new com.bytedance.sdk.openadsdk.i.c.w.c.c(null) { // from class: com.bytedance.msdk.adapter.pangle_csjm.PangleDrawAd.PangleDraw.3
            @Override // com.bytedance.sdk.openadsdk.i.c.w.c.c
            public void onProgressUpdate(long j4, long j5) {
                if (((ux) PangleDraw.this).f27681r != null) {
                    ((ux) PangleDraw.this).f27681r.c(j4, j5);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.i.c.w.c.c
            public void onVideoAdComplete(k kVar) {
                if (((ux) PangleDraw.this).f27681r != null) {
                    ((ux) PangleDraw.this).f27681r.vc();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.i.c.w.c.c
            public void onVideoAdContinuePlay(k kVar) {
                if (((ux) PangleDraw.this).f27681r != null) {
                    ((ux) PangleDraw.this).f27681r.gw();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.i.c.w.c.c
            public void onVideoAdPaused(k kVar) {
                if (((ux) PangleDraw.this).f27681r != null) {
                    ((ux) PangleDraw.this).f27681r.m();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.i.c.w.c.c
            public void onVideoAdStartPlay(k kVar) {
                if (((ux) PangleDraw.this).f27681r != null) {
                    ((ux) PangleDraw.this).f27681r.x();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.i.c.w.c.c
            public void onVideoError(int i4, int i5) {
                if (((ux) PangleDraw.this).f27681r != null) {
                    gd gdVar = ((ux) PangleDraw.this).f27681r;
                    gdVar.c(new com.bytedance.msdk.api.c(i4, "Android MediaPlay Error Code :" + i5));
                }
            }

            @Override // com.bytedance.sdk.openadsdk.i.c.w.c.c
            public void onVideoLoad(k kVar) {
            }
        };
        w xv = new w(null) { // from class: com.bytedance.msdk.adapter.pangle_csjm.PangleDrawAd.PangleDraw.4
            @Override // com.bytedance.sdk.openadsdk.ys.w.c.w
            public void onDownloadActive(long j4, long j5, String str, String str2) {
                PangleDraw.this.ux = 2;
                if (((ux) PangleDraw.this).ev != null) {
                    ((ux) PangleDraw.this).ev.c(j4, j5, (int) (j4 != 0 ? j5 / j4 : 0L), -1);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.ys.w.c.w
            public void onDownloadFailed(long j4, long j5, String str, String str2) {
                PangleDraw.this.ux = 4;
                if (((ux) PangleDraw.this).ev != null) {
                    ((ux) PangleDraw.this).ev.w(j4, j5, str, str2);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.ys.w.c.w
            public void onDownloadFinished(long j4, String str, String str2) {
                PangleDraw.this.ux = 5;
                if (((ux) PangleDraw.this).ev != null) {
                    ((ux) PangleDraw.this).ev.c(j4, str, str2);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.ys.w.c.w
            public void onDownloadPaused(long j4, long j5, String str, String str2) {
                PangleDraw.this.ux = 3;
                if (((ux) PangleDraw.this).ev != null) {
                    ((ux) PangleDraw.this).ev.c(j4, j5, str, str2);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.ys.w.c.w
            public void onIdle() {
                PangleDraw.this.ux = 0;
                if (((ux) PangleDraw.this).ev != null) {
                    ((ux) PangleDraw.this).ev.c();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.ys.w.c.w
            public void onInstalled(String str, String str2) {
                PangleDraw.this.ux = 6;
                if (((ux) PangleDraw.this).ev != null) {
                    ((ux) PangleDraw.this).ev.c(str, str2);
                }
            }
        };

        PangleDraw(p pVar, boolean z3) {
            Map<String, Object> q3;
            this.sr = pVar;
            xv fz = pVar.fz();
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
            setTitle(pVar.r());
            setAdDescription(pVar.ev());
            setActionText(pVar.gd());
            setIconUrl(pVar.t() != null ? pVar.t().xv() : null);
            setImageMode(pVar.ia());
            setInteractionType(pVar.fp());
            setSource(pVar.bk());
            setRating(pVar.p());
            setIsAppDownload(pVar.fp() == 4);
            setExpressAd(false);
            if (pVar.ia() != 16 && pVar.ia() != 3 && pVar.ia() != 2) {
                if (pVar.ia() == 4) {
                    if (pVar.ys() != null && pVar.ys().size() > 0) {
                        ArrayList arrayList = new ArrayList();
                        for (bk bkVar : pVar.ys()) {
                            arrayList.add(bkVar.xv());
                        }
                        setImages(arrayList);
                    }
                } else {
                    bk ux2 = pVar.ux();
                    if (ux2 == null && pVar.ys() != null && !pVar.ys().isEmpty() && pVar.ys().get(0) != null) {
                        ux2 = pVar.ys().get(0);
                    }
                    if (ux2 != null) {
                        setImageUrl(ux2.xv());
                        setImageHeight(ux2.c());
                        setImageWidth(ux2.w());
                    }
                }
            } else if (pVar.ys() != null && !pVar.ys().isEmpty() && pVar.ys().get(0) != null) {
                bk bkVar2 = pVar.ys().get(0);
                setImageUrl(bkVar2.xv());
                setImageHeight(bkVar2.c());
                setImageWidth(bkVar2.w());
            }
            if (z3 && (q3 = pVar.q()) != null) {
                double value = PangleAdapterUtils.getValue(q3.get(BidResponsed.KEY_PRICE));
                com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK_ECMP", "pangle draw \u8fd4\u56de\u7684 cpm\u4ef7\u683c\uff1a" + value);
                setCpm(value <= 0.0d ? 0.0d : value);
            }
            this.sr.c(this.f27143w);
            this.sr.c(this.xv);
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
            p pVar = this.sr;
            if (pVar == null || pVar.u() == null) {
                return;
            }
            this.sr.u().w();
        }

        @Override // com.bytedance.msdk.c.ux
        public long getAdId() {
            p pVar = this.sr;
            if (pVar != null) {
                return PangleAdapterUtils.getAdId(pVar.q());
            }
            return 0L;
        }

        @Override // com.bytedance.msdk.c.ux
        public long getCreativeId() {
            p pVar = this.sr;
            if (pVar != null) {
                return PangleAdapterUtils.getCreativeId(pVar.q());
            }
            return 0L;
        }

        @Override // com.bytedance.msdk.c.ux, com.bytedance.msdk.c.xv
        public ev getDislikeDialog(Activity activity) {
            if (this.sr != null) {
                com.bytedance.msdk.adapter.sr.xv.w("TTMediationSDK", "pangle draw : getDislikeDialog = " + activity);
                return this.sr.c(activity);
            }
            return super.getDislikeDialog(activity);
        }

        @Override // com.bytedance.msdk.c.ux, com.bytedance.msdk.c.xv
        public sr getDislikeInfo() {
            if (this.sr != null) {
                com.bytedance.msdk.adapter.sr.xv.w("TTMediationSDK", "pangle draw : getDislikeInfo");
                return this.sr.s();
            }
            return null;
        }

        @Override // com.bytedance.msdk.c.ux
        public int getDownloadStatus() {
            return this.ux;
        }

        @Override // com.bytedance.msdk.c.ux
        public f getGMNativeCustomVideoReporter() {
            if (isUseCustomVideo()) {
                return new f() { // from class: com.bytedance.msdk.adapter.pangle_csjm.PangleDrawAd.PangleDraw.1
                    @Override // com.bytedance.msdk.api.sr.c.r.f
                    public void reportVideoAutoStart() {
                        if (PangleDraw.this.sr == null || PangleDraw.this.sr.w() == null) {
                            return;
                        }
                        PangleDraw.this.sr.w().sr();
                    }

                    @Override // com.bytedance.msdk.api.sr.c.r.f
                    public void reportVideoBreak(long j4) {
                        if (PangleDraw.this.sr == null || PangleDraw.this.sr.w() == null) {
                            return;
                        }
                        PangleDraw.this.sr.w().xv(j4);
                    }

                    @Override // com.bytedance.msdk.api.sr.c.r.f
                    public void reportVideoContinue(long j4) {
                        if (PangleDraw.this.sr == null || PangleDraw.this.sr.w() == null) {
                            return;
                        }
                        PangleDraw.this.sr.w().w(j4);
                    }

                    @Override // com.bytedance.msdk.api.sr.c.r.f
                    public void reportVideoError(long j4, int i4, int i5) {
                        if (PangleDraw.this.sr == null || PangleDraw.this.sr.w() == null) {
                            return;
                        }
                        PangleDraw.this.sr.w().c(j4, i4, i5);
                    }

                    @Override // com.bytedance.msdk.api.sr.c.r.f
                    public void reportVideoFinish() {
                        if (PangleDraw.this.sr == null || PangleDraw.this.sr.w() == null) {
                            return;
                        }
                        PangleDraw.this.sr.w().xv();
                    }

                    @Override // com.bytedance.msdk.api.sr.c.r.f
                    public void reportVideoPause(long j4) {
                        if (PangleDraw.this.sr == null || PangleDraw.this.sr.w() == null) {
                            return;
                        }
                        PangleDraw.this.sr.w().c(j4);
                    }

                    @Override // com.bytedance.msdk.api.sr.c.r.f
                    public void reportVideoStart() {
                        if (PangleDraw.this.sr == null || PangleDraw.this.sr.w() == null) {
                            return;
                        }
                        PangleDraw.this.sr.w().w();
                    }

                    @Override // com.bytedance.msdk.api.sr.c.r.f
                    public void reportVideoStartError(int i4, int i5) {
                        if (PangleDraw.this.sr == null || PangleDraw.this.sr.w() == null) {
                            return;
                        }
                        PangleDraw.this.sr.w().c(i4, i5);
                    }
                };
            }
            return null;
        }

        @Override // com.bytedance.msdk.c.ux
        public Map<String, Object> getMediaExtraInfo() {
            Map<String, Object> q3;
            p pVar = this.sr;
            if (pVar == null || (q3 = pVar.q()) == null) {
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
            p pVar = this.sr;
            return pVar != null ? PangleAdapterUtils.getReqId(pVar.q()) : "";
        }

        @Override // com.bytedance.msdk.c.ux
        public int getVideoHeight() {
            p pVar = this.sr;
            if (pVar != null) {
                return pVar.sr();
            }
            return 0;
        }

        @Override // com.bytedance.msdk.c.ux
        public String getVideoUrl() {
            p pVar;
            if (!isUseCustomVideo() || (pVar = this.sr) == null || pVar.w() == null) {
                return null;
            }
            return this.sr.w().c();
        }

        @Override // com.bytedance.msdk.c.ux
        public int getVideoWidth() {
            p pVar = this.sr;
            if (pVar != null) {
                return pVar.xv();
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
            p pVar = this.sr;
            if (pVar != null) {
                pVar.c((com.bytedance.sdk.openadsdk.i.c.w.c.c) null);
                this.sr = null;
            }
        }

        @Override // com.bytedance.msdk.c.ux
        public void pauseAppDownload() {
            p pVar = this.sr;
            if (pVar == null || pVar.u() == null || this.ux != 2) {
                return;
            }
            this.sr.u().c();
        }

        @Override // com.bytedance.msdk.c.ux
        public void registerViewForInteraction(Activity activity, @NonNull ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, com.bytedance.msdk.api.sr.c.r.k kVar) {
            FrameLayout frameLayout;
            p pVar;
            View i4;
            p pVar2;
            View findViewById;
            super.registerViewForInteraction(activity, viewGroup, list, list2, list3, kVar);
            if (viewGroup instanceof FrameLayout) {
                p pVar3 = this.sr;
                if (pVar3 != null) {
                    pVar3.c(this.xv);
                    this.sr.c(viewGroup, (List<View>) null, list, list2, list3, (View) null, this.f27142c);
                }
                p pVar4 = this.sr;
                if (pVar4 != null && pVar4.f() != null && kVar != null && (findViewById = viewGroup.findViewById(kVar.f27511a)) != null) {
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
                if ((isUseCustomVideo() && (pVar2 = this.sr) != null && pVar2.w() != null && !TextUtils.isEmpty(this.sr.w().c())) || kVar == null || (frameLayout = (FrameLayout) viewGroup.findViewById(kVar.f27516r)) == null || (pVar = this.sr) == null || (i4 = pVar.i()) == null) {
                    return;
                }
                removeSelfFromParent(i4);
                frameLayout.removeAllViews();
                frameLayout.addView(i4, -1, -1);
            }
        }

        @Override // com.bytedance.msdk.c.ux
        public void resumeAppDownload() {
            p pVar = this.sr;
            if (pVar == null || pVar.u() == null || this.ux != 3) {
                return;
            }
            this.sr.u().c();
        }

        @Override // com.bytedance.msdk.c.ux, com.bytedance.msdk.c.xv
        public void setDislikeCallback(Activity activity, com.bytedance.sdk.openadsdk.s.c.w.c.c cVar) {
            if (this.sr != null) {
                com.bytedance.msdk.adapter.sr.xv.w("TTMediationSDK", "pangle draw :  activity = " + activity + " pluginDislikeInteractionCallback:" + cVar);
                this.sr.c(activity, cVar);
            }
        }

        @Override // com.bytedance.msdk.c.ux, com.bytedance.msdk.c.xv
        public void setDislikeDialog(Dialog dialog) {
            if (this.sr != null) {
                com.bytedance.msdk.adapter.sr.xv.w("TTMediationSDK", "pangle draw :  ttDislikeDialogAbstract = " + dialog);
                if (dialog instanceof TTDislikeDialogAbstract) {
                    this.sr.w((TTDislikeDialogAbstract) dialog);
                }
            }
        }

        @Override // com.bytedance.msdk.c.ux, com.bytedance.msdk.c.xv
        public void uploadDislikeEvent(String str) {
            if (this.sr != null) {
                com.bytedance.msdk.adapter.sr.xv.w("TTMediationSDK", "pangle draw : uploadDislikeEvent event = " + str);
                this.sr.c(str);
            }
        }

        @Override // com.bytedance.msdk.c.ux, com.bytedance.msdk.c.xv
        public ev getDislikeDialog(TTDislikeDialogAbstract tTDislikeDialogAbstract) {
            if (this.sr != null) {
                com.bytedance.msdk.adapter.sr.xv.w("TTMediationSDK", "pangle draw : getDislikeDialog = " + tTDislikeDialogAbstract);
                return this.sr.c(tTDislikeDialogAbstract);
            }
            return null;
        }
    }

    public void loadAd(final boolean z3, wv wvVar, com.bytedance.sdk.openadsdk.ys.w.xv.w wVar, final com.bytedance.msdk.adapter.c cVar) {
        if (wvVar == null || cVar == null) {
            return;
        }
        wvVar.c(wVar, new com.bytedance.sdk.openadsdk.fz.c.w.c.w(null) { // from class: com.bytedance.msdk.adapter.pangle_csjm.PangleDrawAd.1
            @Override // com.bytedance.sdk.openadsdk.fz.c.w.c.w
            public void onDrawFeedAdLoad(List<p> list) {
                if (list != null && !list.isEmpty()) {
                    ArrayList arrayList = new ArrayList();
                    for (p pVar : list) {
                        arrayList.add(new PangleDraw(pVar, z3));
                    }
                    cVar.notifyAdLoaded(arrayList);
                    return;
                }
                cVar.notifyAdFailed(new com.bytedance.msdk.api.c(80001, "load\u6210\u529f\u4f46\u8fd4\u56de\u5e7f\u544a\u662f\u7a7a"));
            }

            @Override // com.bytedance.sdk.openadsdk.fz.c.w.c.w
            public void onError(int i4, String str) {
                cVar.notifyAdFailed(new com.bytedance.msdk.api.c(i4, str));
            }
        });
    }
}

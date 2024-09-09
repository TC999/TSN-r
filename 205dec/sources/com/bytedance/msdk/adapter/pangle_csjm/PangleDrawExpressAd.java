package com.bytedance.msdk.adapter.pangle_csjm;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import com.bytedance.msdk.api.c;
import com.bytedance.msdk.api.sr.c.r.gd;
import com.bytedance.msdk.c.ux;
import com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract;
import com.bytedance.sdk.openadsdk.core.wv;
import com.bytedance.sdk.openadsdk.fz.c.w.c.f;
import com.bytedance.sdk.openadsdk.ls.c.w.c.w;
import com.bytedance.sdk.openadsdk.ls.c.w.c.xv;
import com.bytedance.sdk.openadsdk.ys.w.w.ev;
import com.bytedance.sdk.openadsdk.ys.w.w.sr;
import com.bytedance.sdk.openadsdk.ys.w.w.ys;
import com.mbridge.msdk.mbbid.out.BidResponsed;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class PangleDrawExpressAd {

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    private static class PangleDrawExpressedAd extends ux {

        /* renamed from: c  reason: collision with root package name */
        w f27150c = new w(null) { // from class: com.bytedance.msdk.adapter.pangle_csjm.PangleDrawExpressAd.PangleDrawExpressedAd.1
            @Override // com.bytedance.sdk.openadsdk.ls.c.w.c.w
            public void onAdClicked(View view, int i4) {
                if (((ux) PangleDrawExpressedAd.this).f27676k != null) {
                    ((ux) PangleDrawExpressedAd.this).f27676k.c();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.ls.c.w.c.w
            public void onAdShow(View view, int i4) {
                if (((ux) PangleDrawExpressedAd.this).f27676k != null) {
                    ((ux) PangleDrawExpressedAd.this).f27676k.w();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.ls.c.w.c.w
            public void onRenderFail(View view, String str, int i4) {
                if (((ux) PangleDrawExpressedAd.this).f27676k instanceof com.bytedance.msdk.api.sr.c.xv.ux) {
                    ((com.bytedance.msdk.api.sr.c.xv.ux) ((ux) PangleDrawExpressedAd.this).f27676k).c(view, str, i4);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.ls.c.w.c.w
            public void onRenderSuccess(View view, float f4, float f5) {
                if (((ux) PangleDrawExpressedAd.this).f27676k instanceof com.bytedance.msdk.api.sr.c.xv.ux) {
                    ((com.bytedance.msdk.api.sr.c.xv.ux) ((ux) PangleDrawExpressedAd.this).f27676k).c(f4, f5);
                }
            }
        };

        /* renamed from: w  reason: collision with root package name */
        xv f27151w = new xv(null) { // from class: com.bytedance.msdk.adapter.pangle_csjm.PangleDrawExpressAd.PangleDrawExpressedAd.2
            @Override // com.bytedance.sdk.openadsdk.ls.c.w.c.xv
            public void onClickRetry() {
            }

            @Override // com.bytedance.sdk.openadsdk.ls.c.w.c.xv
            public void onProgressUpdate(long j4, long j5) {
                if (((ux) PangleDrawExpressedAd.this).f27681r != null) {
                    ((ux) PangleDrawExpressedAd.this).f27681r.c(j4, j5);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.ls.c.w.c.xv
            public void onVideoAdComplete() {
                if (((ux) PangleDrawExpressedAd.this).f27681r != null) {
                    ((ux) PangleDrawExpressedAd.this).f27681r.vc();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.ls.c.w.c.xv
            public void onVideoAdContinuePlay() {
                if (((ux) PangleDrawExpressedAd.this).f27681r != null) {
                    ((ux) PangleDrawExpressedAd.this).f27681r.gw();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.ls.c.w.c.xv
            public void onVideoAdPaused() {
                if (((ux) PangleDrawExpressedAd.this).f27681r != null) {
                    ((ux) PangleDrawExpressedAd.this).f27681r.m();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.ls.c.w.c.xv
            public void onVideoAdStartPlay() {
                if (((ux) PangleDrawExpressedAd.this).f27681r != null) {
                    ((ux) PangleDrawExpressedAd.this).f27681r.x();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.ls.c.w.c.xv
            public void onVideoError(int i4, int i5) {
                if (((ux) PangleDrawExpressedAd.this).f27681r != null) {
                    gd gdVar = ((ux) PangleDrawExpressedAd.this).f27681r;
                    gdVar.c(new c(i4, "MediaPlayer inter error code:" + i5));
                }
            }

            @Override // com.bytedance.sdk.openadsdk.ls.c.w.c.xv
            public void onVideoLoad() {
            }
        };
        private ys xv;

        PangleDrawExpressedAd(ys ysVar, boolean z3) {
            Map<String, Object> r3;
            this.xv = ysVar;
            setImageMode(ysVar.w());
            setInteractionType(this.xv.xv());
            setExpressAd(true);
            if (z3 && (r3 = ysVar.r()) != null) {
                double value = PangleAdapterUtils.getValue(r3.get(BidResponsed.KEY_PRICE));
                com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK_ECMP", "pangle \u6a21\u677fdraw \u8fd4\u56de\u7684 cpm\u4ef7\u683c\uff1a" + value);
                setCpm(value <= 0.0d ? 0.0d : value);
            }
            this.xv.c(this.f27150c);
            this.xv.c(this.f27151w);
            putExtraMsg("ad_id", Long.valueOf(getAdId()));
            putExtraMsg("c_id", Long.valueOf(getCreativeId()));
            Map<String, Object> r4 = this.xv.r();
            if (r4 != null) {
                putExtraMsg(r4);
                putExtraMsg("log_extra", r4.toString());
            }
        }

        @Override // com.bytedance.msdk.c.ux
        public long getAdId() {
            ys ysVar = this.xv;
            if (ysVar != null) {
                return PangleAdapterUtils.getAdId(ysVar.r());
            }
            return 0L;
        }

        @Override // com.bytedance.msdk.c.ux
        public View getAdView() {
            ys ysVar = this.xv;
            if (ysVar != null) {
                return ysVar.c();
            }
            return null;
        }

        @Override // com.bytedance.msdk.c.ux
        public long getCreativeId() {
            ys ysVar = this.xv;
            if (ysVar != null) {
                return PangleAdapterUtils.getCreativeId(ysVar.r());
            }
            return 0L;
        }

        @Override // com.bytedance.msdk.c.ux, com.bytedance.msdk.c.xv
        public ev getDislikeDialog(Activity activity) {
            ys ysVar = this.xv;
            if (ysVar != null) {
                return ysVar.c(activity);
            }
            return super.getDislikeDialog(activity);
        }

        @Override // com.bytedance.msdk.c.ux, com.bytedance.msdk.c.xv
        public sr getDislikeInfo() {
            ys ysVar = this.xv;
            if (ysVar != null) {
                return ysVar.f();
            }
            return super.getDislikeInfo();
        }

        @Override // com.bytedance.msdk.c.ux
        public Map<String, Object> getMediaExtraInfo() {
            Map<String, Object> r3;
            ys ysVar = this.xv;
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
            ys ysVar = this.xv;
            return ysVar != null ? PangleAdapterUtils.getReqId(ysVar.r()) : "";
        }

        @Override // com.bytedance.msdk.c.ux
        public boolean hasDestroyed() {
            return this.xv == null;
        }

        @Override // com.bytedance.msdk.c.ux
        public boolean hasDislike() {
            return true;
        }

        @Override // com.bytedance.msdk.c.ux
        public void onDestroy() {
            ys ysVar = this.xv;
            if (ysVar != null) {
                ysVar.ux();
                this.xv = null;
            }
        }

        @Override // com.bytedance.msdk.c.ux
        public void render() {
            ys ysVar = this.xv;
            if (ysVar != null) {
                ysVar.sr();
            }
        }

        @Override // com.bytedance.msdk.c.ux, com.bytedance.msdk.c.xv
        public void setDislikeCallback(Activity activity, com.bytedance.sdk.openadsdk.s.c.w.c.c cVar) {
            if (this.xv != null) {
                com.bytedance.msdk.adapter.sr.xv.w("TTMediationSDK", "pangle draw express:  activity = " + activity + " pluginDislikeInteractionCallback:" + cVar);
                this.xv.c(activity, cVar);
            }
        }

        @Override // com.bytedance.msdk.c.ux, com.bytedance.msdk.c.xv
        public void setDislikeDialog(Dialog dialog) {
            if (this.xv != null) {
                com.bytedance.msdk.adapter.sr.xv.w("TTMediationSDK", "pangle draw express:  ttDislikeDialogAbstract = " + dialog);
                if (dialog instanceof TTDislikeDialogAbstract) {
                    this.xv.c((TTDislikeDialogAbstract) dialog);
                }
            }
        }

        @Override // com.bytedance.msdk.c.ux, com.bytedance.msdk.c.xv
        public void uploadDislikeEvent(String str) {
            if (this.xv != null) {
                com.bytedance.msdk.adapter.sr.xv.w("TTMediationSDK", "pangle draw express: uploadDislikeEvent event = " + str);
                this.xv.c(str);
            }
        }
    }

    public void loadAd(final boolean z3, wv wvVar, com.bytedance.sdk.openadsdk.ys.w.xv.w wVar, final com.bytedance.msdk.adapter.c cVar) {
        if (wvVar == null || cVar == null) {
            return;
        }
        wvVar.w(wVar, new f(null) { // from class: com.bytedance.msdk.adapter.pangle_csjm.PangleDrawExpressAd.1
            @Override // com.bytedance.sdk.openadsdk.fz.c.w.c.f
            public void onError(int i4, String str) {
                cVar.notifyAdFailed(new c(i4, str));
            }

            @Override // com.bytedance.sdk.openadsdk.fz.c.w.c.f
            public void onNativeExpressAdLoad(List<ys> list) {
                if (list != null && list.size() != 0) {
                    ArrayList arrayList = new ArrayList();
                    for (ys ysVar : list) {
                        if (ysVar != null) {
                            arrayList.add(new PangleDrawExpressedAd(ysVar, z3));
                        }
                    }
                    cVar.notifyAdLoaded(arrayList);
                    return;
                }
                cVar.notifyAdFailed(new c(80001, "load\u6210\u529f\u4f46\u8fd4\u56de\u5e7f\u544a\u662f\u7a7a"));
            }
        });
    }
}

package com.bytedance.msdk.adapter.pangle_csjm;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import com.bytedance.msdk.adapter.c;
import com.bytedance.msdk.adapter.sr.f;
import com.bytedance.msdk.api.sr.c.r.gd;
import com.bytedance.msdk.api.sr.c.r.r;
import com.bytedance.msdk.c.ux;
import com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract;
import com.bytedance.sdk.openadsdk.core.wv;
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
public class PangleNativeExpressAd {

    /* renamed from: c  reason: collision with root package name */
    private boolean f27170c;

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    class PangleNativeExpressedAd extends ux {

        /* renamed from: c  reason: collision with root package name */
        ys f27173c;

        /* renamed from: w  reason: collision with root package name */
        c f27175w;

        /* renamed from: t  reason: collision with root package name */
        private volatile boolean f27174t = false;
        w xv = new w(null) { // from class: com.bytedance.msdk.adapter.pangle_csjm.PangleNativeExpressAd.PangleNativeExpressedAd.2
            @Override // com.bytedance.sdk.openadsdk.ls.c.w.c.w
            public void onAdClicked(View view, int i4) {
                if (((ux) PangleNativeExpressedAd.this).f27671f != null) {
                    ((ux) PangleNativeExpressedAd.this).f27671f.c();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.ls.c.w.c.w
            public void onAdShow(View view, int i4) {
                if (((ux) PangleNativeExpressedAd.this).f27671f != null) {
                    ((ux) PangleNativeExpressedAd.this).f27671f.w();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.ls.c.w.c.w
            public void onRenderFail(View view, String str, int i4) {
                if (((ux) PangleNativeExpressedAd.this).f27671f instanceof r) {
                    ((r) ((ux) PangleNativeExpressedAd.this).f27671f).c(view, str, i4);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.ls.c.w.c.w
            public void onRenderSuccess(View view, float f4, float f5) {
                if (((ux) PangleNativeExpressedAd.this).f27671f instanceof r) {
                    ((r) ((ux) PangleNativeExpressedAd.this).f27671f).c(f4, f5);
                }
            }
        };
        xv sr = new xv(null) { // from class: com.bytedance.msdk.adapter.pangle_csjm.PangleNativeExpressAd.PangleNativeExpressedAd.3
            @Override // com.bytedance.sdk.openadsdk.ls.c.w.c.xv
            public void onClickRetry() {
            }

            @Override // com.bytedance.sdk.openadsdk.ls.c.w.c.xv
            public void onProgressUpdate(long j4, long j5) {
                if (((ux) PangleNativeExpressedAd.this).f27681r != null) {
                    ((ux) PangleNativeExpressedAd.this).f27681r.c(j4, j5);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.ls.c.w.c.xv
            public void onVideoAdComplete() {
                if (((ux) PangleNativeExpressedAd.this).f27681r != null) {
                    ((ux) PangleNativeExpressedAd.this).f27681r.vc();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.ls.c.w.c.xv
            public void onVideoAdContinuePlay() {
                if (((ux) PangleNativeExpressedAd.this).f27681r != null) {
                    ((ux) PangleNativeExpressedAd.this).f27681r.gw();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.ls.c.w.c.xv
            public void onVideoAdPaused() {
                if (((ux) PangleNativeExpressedAd.this).f27681r != null) {
                    ((ux) PangleNativeExpressedAd.this).f27681r.m();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.ls.c.w.c.xv
            public void onVideoAdStartPlay() {
                if (((ux) PangleNativeExpressedAd.this).f27681r != null) {
                    ((ux) PangleNativeExpressedAd.this).f27681r.x();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.ls.c.w.c.xv
            public void onVideoError(int i4, int i5) {
                if (((ux) PangleNativeExpressedAd.this).f27681r != null) {
                    gd gdVar = ((ux) PangleNativeExpressedAd.this).f27681r;
                    gdVar.c(new com.bytedance.msdk.api.c(i4, "MediaPlayer inter error code:" + i5));
                }
            }

            @Override // com.bytedance.sdk.openadsdk.ls.c.w.c.xv
            public void onVideoLoad() {
            }
        };

        PangleNativeExpressedAd(ys ysVar, c cVar) {
            Map<String, Object> r3;
            this.f27173c = ysVar;
            this.f27175w = cVar;
            setImageMode(ysVar.w());
            setInteractionType(this.f27173c.xv());
            setExpressAd(true);
            if (PangleNativeExpressAd.this.f27170c && (r3 = ysVar.r()) != null) {
                double value = PangleAdapterUtils.getValue(r3.get(BidResponsed.KEY_PRICE));
                com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK_ECMP", "pangle \u6a21\u677fnative \u8fd4\u56de\u7684 cpm\u4ef7\u683c\uff1a" + value);
                setCpm(value <= 0.0d ? 0.0d : value);
            }
            putExtraMsg("ad_id", Long.valueOf(getAdId()));
            putExtraMsg("c_id", Long.valueOf(getCreativeId()));
            Map<String, Object> r4 = this.f27173c.r();
            if (r4 != null) {
                putExtraMsg(r4);
                putExtraMsg("log_extra", r4.toString());
            }
            this.f27173c.c(this.xv);
            this.f27173c.c(this.sr);
        }

        @Override // com.bytedance.msdk.c.ux
        public long getAdId() {
            ys ysVar = this.f27173c;
            if (ysVar != null) {
                return PangleAdapterUtils.getAdId(ysVar.r());
            }
            return 0L;
        }

        @Override // com.bytedance.msdk.c.ux
        public View getAdView() {
            ys ysVar = this.f27173c;
            if (ysVar != null) {
                return ysVar.c();
            }
            return null;
        }

        @Override // com.bytedance.msdk.c.ux
        public long getCreativeId() {
            ys ysVar = this.f27173c;
            if (ysVar != null) {
                return PangleAdapterUtils.getCreativeId(ysVar.r());
            }
            return 0L;
        }

        @Override // com.bytedance.msdk.c.ux, com.bytedance.msdk.c.xv
        public ev getDislikeDialog(Activity activity) {
            ys ysVar = this.f27173c;
            if (ysVar != null) {
                return ysVar.c(activity);
            }
            return super.getDislikeDialog(activity);
        }

        @Override // com.bytedance.msdk.c.ux, com.bytedance.msdk.c.xv
        public sr getDislikeInfo() {
            ys ysVar = this.f27173c;
            if (ysVar != null) {
                return ysVar.f();
            }
            return super.getDislikeInfo();
        }

        @Override // com.bytedance.msdk.c.ux
        public Map<String, Object> getMediaExtraInfo() {
            Map<String, Object> r3;
            ys ysVar = this.f27173c;
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
            ys ysVar = this.f27173c;
            if (ysVar != null) {
                return PangleAdapterUtils.getReqId(ysVar.r());
            }
            return null;
        }

        @Override // com.bytedance.msdk.c.ux
        public boolean hasDestroyed() {
            return this.f27174t;
        }

        @Override // com.bytedance.msdk.c.ux
        public boolean hasDislike() {
            return true;
        }

        @Override // com.bytedance.msdk.c.ux
        public void onDestroy() {
            this.f27174t = true;
            f.xv(new Runnable() { // from class: com.bytedance.msdk.adapter.pangle_csjm.PangleNativeExpressAd.PangleNativeExpressedAd.1
                @Override // java.lang.Runnable
                public void run() {
                    ys ysVar = PangleNativeExpressedAd.this.f27173c;
                    if (ysVar != null) {
                        ysVar.ux();
                    }
                }
            });
        }

        @Override // com.bytedance.msdk.c.ux
        public void render() {
            ys ysVar = this.f27173c;
            if (ysVar != null) {
                ysVar.sr();
            }
        }

        @Override // com.bytedance.msdk.c.ux, com.bytedance.msdk.c.xv
        public void setDislikeCallback(Activity activity, com.bytedance.sdk.openadsdk.s.c.w.c.c cVar) {
            if (this.f27173c != null) {
                com.bytedance.msdk.adapter.sr.xv.w("TTMediationSDK", "pangle native express:  activity = " + activity + " pluginDislikeInteractionCallback:" + cVar);
                this.f27173c.c(activity, cVar);
            }
        }

        @Override // com.bytedance.msdk.c.ux, com.bytedance.msdk.c.xv
        public void setDislikeDialog(Dialog dialog) {
            if (this.f27173c != null) {
                com.bytedance.msdk.adapter.sr.xv.w("TTMediationSDK", "pangle native express:  ttDislikeDialogAbstract = " + dialog);
                if (dialog instanceof TTDislikeDialogAbstract) {
                    this.f27173c.c((TTDislikeDialogAbstract) dialog);
                }
            }
        }

        @Override // com.bytedance.msdk.c.ux, com.bytedance.msdk.c.xv
        public void uploadDislikeEvent(String str) {
            if (this.f27173c != null) {
                com.bytedance.msdk.adapter.sr.xv.w("TTMediationSDK", "pangle native express: uploadDislikeEvent event = " + str);
                this.f27173c.c(str);
            }
        }
    }

    public void loadAd(boolean z3, wv wvVar, com.bytedance.sdk.openadsdk.ys.w.xv.w wVar, final c cVar) {
        if (wvVar == null || cVar == null) {
            return;
        }
        this.f27170c = z3;
        wvVar.c(wVar, new com.bytedance.sdk.openadsdk.fz.c.w.c.f(null) { // from class: com.bytedance.msdk.adapter.pangle_csjm.PangleNativeExpressAd.1
            @Override // com.bytedance.sdk.openadsdk.fz.c.w.c.f
            public void onError(int i4, String str) {
                cVar.notifyAdFailed(new com.bytedance.msdk.api.c(i4, str));
            }

            @Override // com.bytedance.sdk.openadsdk.fz.c.w.c.f
            public void onNativeExpressAdLoad(List<ys> list) {
                if (list != null && list.size() != 0) {
                    ArrayList arrayList = new ArrayList();
                    for (ys ysVar : list) {
                        if (ysVar != null) {
                            arrayList.add(new PangleNativeExpressedAd(ysVar, cVar));
                        }
                    }
                    cVar.notifyAdLoaded(arrayList);
                    return;
                }
                cVar.notifyAdFailed(new com.bytedance.msdk.api.c(80001, "load\u6210\u529f\u4f46\u8fd4\u56de\u5e7f\u544a\u662f\u7a7a"));
            }
        });
    }
}

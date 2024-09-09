package com.bytedance.msdk.adapter.pangle_csjm;

import android.app.Activity;
import android.content.Context;
import com.bytedance.msdk.adapter.c;
import com.bytedance.msdk.adapter.sr.xv;
import com.bytedance.msdk.adapter.w.w;
import com.bytedance.msdk.c.ux;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.core.wv;
import com.bytedance.sdk.openadsdk.fz.c.w.c.sr;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.bytedance.sdk.openadsdk.ys.w.w.a;
import com.bytedance.sdk.openadsdk.ys.w.xv.w;
import com.mbridge.msdk.mbbid.out.BidResponsed;
import com.stub.StubApp;
import java.util.HashMap;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class PangleFullVideoLoader extends c {
    public static final String TAG = "PangleFullVideoAdapter";

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    class PangleFullVideoAd extends ux {

        /* renamed from: c  reason: collision with root package name */
        sr f27154c = new sr(null) { // from class: com.bytedance.msdk.adapter.pangle_csjm.PangleFullVideoLoader.PangleFullVideoAd.1
            @Override // com.bytedance.sdk.openadsdk.fz.c.w.c.sr
            public void onError(int i4, String str) {
                PangleFullVideoAd.this.sr = false;
                PangleFullVideoLoader.this.notifyAdFailed(new com.bytedance.msdk.api.c(i4, str));
            }

            @Override // com.bytedance.sdk.openadsdk.fz.c.w.c.sr
            public void onFullScreenVideoAdLoad(a aVar) {
                if (aVar == null) {
                    PangleFullVideoLoader.this.notifyAdFailed(new com.bytedance.msdk.api.c(80001, "\u8bf7\u6c42\u6210\u529f\uff0c\u4f46\u65e0\u5e7f\u544a\u53ef\u7528"));
                    return;
                }
                PangleFullVideoAd.this.xv = aVar;
                PangleFullVideoAd.this.setExpressAd(true);
                PangleFullVideoAd pangleFullVideoAd = PangleFullVideoAd.this;
                pangleFullVideoAd.setInteractionType(pangleFullVideoAd.xv.c());
                Map<String, Object> w3 = PangleFullVideoAd.this.xv.w();
                if (PangleFullVideoLoader.this.isClientBidding() && w3 != null) {
                    double value = PangleAdapterUtils.getValue(w3.get(BidResponsed.KEY_PRICE));
                    xv.c("TTMediationSDK_ECMP", com.bytedance.msdk.adapter.sr.ux.w(PangleFullVideoLoader.this.getAdapterRit(), PangleFullVideoLoader.this.getAdSlotId()) + "pangle \u5168\u5c4f \u8fd4\u56de\u7684 cpm\u4ef7\u683c\uff1a" + value);
                    PangleFullVideoAd pangleFullVideoAd2 = PangleFullVideoAd.this;
                    if (value <= 0.0d) {
                        value = 0.0d;
                    }
                    pangleFullVideoAd2.setCpm(value);
                }
                if (w3 != null) {
                    Object obj = w3.get("materialMetaIsFromPreload");
                    if (obj instanceof Boolean) {
                        PangleFullVideoAd.this.ux = ((Boolean) obj).booleanValue();
                        xv.c("TTMediationSDK", "pangle \u5168\u5c4f \u8fd4\u56de\u7684adnPreload\uff1a" + PangleFullVideoAd.this.ux);
                    }
                }
                PangleFullVideoAd.this.xv.c(new com.bytedance.sdk.openadsdk.q.c.w.c.c(null) { // from class: com.bytedance.msdk.adapter.pangle_csjm.PangleFullVideoLoader.PangleFullVideoAd.1.1
                    @Override // com.bytedance.sdk.openadsdk.q.c.w.c.c
                    public void onAdClose() {
                        if (((ux) PangleFullVideoAd.this).f27667a instanceof w) {
                            PangleFullVideoAd.this.c().p_();
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.q.c.w.c.c
                    public void onAdShow() {
                        if (((ux) PangleFullVideoAd.this).f27667a instanceof w) {
                            PangleFullVideoAd.this.c().c();
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.q.c.w.c.c
                    public void onAdVideoBarClick() {
                        if (((ux) PangleFullVideoAd.this).f27667a instanceof w) {
                            PangleFullVideoAd.this.c().o_();
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.q.c.w.c.c
                    public void onSkippedVideo() {
                        if (((ux) PangleFullVideoAd.this).f27667a instanceof w) {
                            PangleFullVideoAd.this.c().f();
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.q.c.w.c.c
                    public void onVideoComplete() {
                        if (((ux) PangleFullVideoAd.this).f27667a instanceof w) {
                            PangleFullVideoAd.this.c().q_();
                        }
                    }
                });
                PangleFullVideoAd.this.sr = true;
                PangleFullVideoAd pangleFullVideoAd3 = PangleFullVideoAd.this;
                PangleFullVideoLoader.this.notifyAdLoaded(pangleFullVideoAd3);
            }

            @Override // com.bytedance.sdk.openadsdk.fz.c.w.c.sr
            public void onFullScreenVideoCached() {
                xv.c("TMe", "pangle full cached");
            }

            @Override // com.bytedance.sdk.openadsdk.fz.c.w.c.sr
            public void onFullScreenVideoCached(a aVar) {
                xv.c("TMe", "pangle full cached 2");
                PangleFullVideoAd.this.sr = true;
                PangleFullVideoAd pangleFullVideoAd = PangleFullVideoAd.this;
                PangleFullVideoLoader.this.notifyAdVideoCache(pangleFullVideoAd, (com.bytedance.msdk.api.c) null);
            }
        };
        private boolean sr;
        private boolean ux;
        private a xv;

        PangleFullVideoAd() {
        }

        @Override // com.bytedance.msdk.c.ux
        public boolean adnHasAdVideoCachedApi() {
            return true;
        }

        @Override // com.bytedance.msdk.c.ux
        public long getAdId() {
            a aVar = this.xv;
            if (aVar != null) {
                return PangleAdapterUtils.getAdId(aVar.w());
            }
            return 0L;
        }

        @Override // com.bytedance.msdk.c.ux
        public long getCreativeId() {
            a aVar = this.xv;
            if (aVar != null) {
                return PangleAdapterUtils.getCreativeId(aVar.w());
            }
            return 0L;
        }

        @Override // com.bytedance.msdk.c.ux
        public Map<String, Object> getMediaExtraInfo() {
            Map<String, Object> w3;
            a aVar = this.xv;
            if (aVar == null || (w3 = aVar.w()) == null) {
                return null;
            }
            HashMap hashMap = new HashMap();
            hashMap.put(PangleAdapterUtils.MEDIA_EXTRA_COUPON, w3.get(PangleAdapterUtils.MEDIA_EXTRA_COUPON));
            hashMap.put(PangleAdapterUtils.MEDIA_EXTRA_LIVE_ROOM, w3.get(PangleAdapterUtils.MEDIA_EXTRA_LIVE_ROOM));
            hashMap.put(PangleAdapterUtils.MEDIA_EXTRA_PRODUCT, w3.get(PangleAdapterUtils.MEDIA_EXTRA_PRODUCT));
            setMediaExtraInfo(hashMap);
            return super.getMediaExtraInfo();
        }

        @Override // com.bytedance.msdk.c.ux
        public String getReqId() {
            a aVar = this.xv;
            return aVar != null ? PangleAdapterUtils.getReqId(aVar.w()) : "";
        }

        @Override // com.bytedance.msdk.c.ux
        public boolean hasDestroyed() {
            return this.xv == null;
        }

        @Override // com.bytedance.msdk.c.ux
        public boolean isAdnPreload() {
            return this.ux;
        }

        @Override // com.bytedance.msdk.c.ux
        public MediationConstant.AdIsReadyStatus isReadyStatus() {
            a aVar = this.xv;
            if (aVar != null && aVar.sr() > System.currentTimeMillis()) {
                return MediationConstant.AdIsReadyStatus.AD_IS_READY;
            }
            return MediationConstant.AdIsReadyStatus.AD_IS_EXPIRED;
        }

        public void loadAd(Context context) {
            wv pluginCSJLoader = PangleFullVideoLoader.this.getPluginCSJLoader(context);
            if (pluginCSJLoader == null) {
                return;
            }
            w.c buildPangleAdSlot = PangleAdapterUtils.buildPangleAdSlot(((c) PangleFullVideoLoader.this).xv, PangleFullVideoLoader.this.getAdSlotId(), ((c) PangleFullVideoLoader.this).f26913c, PangleFullVideoLoader.this.getClientReqId(), PangleFullVideoLoader.this.getAdm(), false);
            buildPangleAdSlot.c(1080).w(1920).sr(((c) PangleFullVideoLoader.this).xv.eq());
            pluginCSJLoader.c(buildPangleAdSlot.c(), this.f27154c);
        }

        @Override // com.bytedance.msdk.c.ux
        public void onDestroy() {
            a aVar = this.xv;
            if (aVar != null) {
                aVar.c((com.bytedance.sdk.openadsdk.q.c.w.c.c) null);
                this.xv.c((com.bytedance.sdk.openadsdk.ys.w.c.w) null);
                this.xv = null;
            }
        }

        @Override // com.bytedance.msdk.c.ux
        public void showAd(Activity activity, TTAdConstant.RitScenes ritScenes, String str) {
            a aVar = this.xv;
            if (aVar != null) {
                if (ritScenes != null) {
                    aVar.c(activity, ritScenes, str);
                } else {
                    aVar.c(activity);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public com.bytedance.msdk.adapter.w.w c() {
            return (com.bytedance.msdk.adapter.w.w) this.f27667a;
        }
    }

    @Override // com.bytedance.msdk.adapter.c
    public void destroy() {
    }

    @Override // com.bytedance.msdk.adapter.c
    public String getAdNetWorkName() {
        return null;
    }

    @Override // com.bytedance.msdk.adapter.c
    public String getSdkVersion() {
        return null;
    }

    @Override // com.bytedance.msdk.adapter.c
    public void loadAd(Context context, Map<String, Object> map) {
        if (this.xv == null) {
            notifyLoadFailBecauseGMAdSlotIsNull();
        } else {
            new PangleFullVideoAd().loadAd(StubApp.getOrigApplicationContext(context.getApplicationContext()));
        }
    }

    public void notifyLoadFailBecauseGMAdSlotIsNull() {
        notifyAdFailed(new com.bytedance.msdk.api.c("load ad fail adSlot is null"));
    }
}

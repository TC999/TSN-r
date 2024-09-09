package com.bytedance.msdk.adapter.pangle_csjm;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import androidx.annotation.MainThread;
import com.bytedance.msdk.adapter.c;
import com.bytedance.msdk.api.TTRequestExtraParams;
import com.bytedance.msdk.c.ux;
import com.bytedance.sdk.openadsdk.core.wv;
import com.bytedance.sdk.openadsdk.sr.c.w.c.xv;
import com.bytedance.sdk.openadsdk.ys.w.w.w;
import com.bytedance.sdk.openadsdk.ys.w.xv.w;
import com.mbridge.msdk.mbbid.out.BidResponsed;
import com.stub.StubApp;
import java.util.HashMap;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class PangleSplashLoader extends c {
    public static final String VERSION_00 = "0.0";

    /* renamed from: f  reason: collision with root package name */
    private int f27194f = 3000;

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    class PangleSplashAd extends ux {

        /* renamed from: c  reason: collision with root package name */
        boolean f27195c;
        private Map<String, Object> sr;
        private w xv;

        PangleSplashAd(Map<String, Object> map) {
            this.sr = map;
        }

        @Override // com.bytedance.msdk.c.ux
        public long getAdId() {
            w wVar = this.xv;
            if (wVar != null) {
                return PangleAdapterUtils.getAdId(wVar.ux());
            }
            return 0L;
        }

        @Override // com.bytedance.msdk.c.ux
        public long getCreativeId() {
            w wVar = this.xv;
            if (wVar != null) {
                return PangleAdapterUtils.getCreativeId(wVar.ux());
            }
            return 0L;
        }

        @Override // com.bytedance.msdk.c.ux
        public Map<String, Object> getMediaExtraInfo() {
            Map<String, Object> ux;
            w wVar = this.xv;
            if (wVar == null || (ux = wVar.ux()) == null) {
                return null;
            }
            HashMap hashMap = new HashMap();
            hashMap.put(PangleAdapterUtils.MEDIA_EXTRA_COUPON, ux.get(PangleAdapterUtils.MEDIA_EXTRA_COUPON));
            hashMap.put(PangleAdapterUtils.MEDIA_EXTRA_LIVE_ROOM, ux.get(PangleAdapterUtils.MEDIA_EXTRA_LIVE_ROOM));
            hashMap.put(PangleAdapterUtils.MEDIA_EXTRA_PRODUCT, ux.get(PangleAdapterUtils.MEDIA_EXTRA_PRODUCT));
            setMediaExtraInfo(hashMap);
            return super.getMediaExtraInfo();
        }

        @Override // com.bytedance.msdk.c.ux
        public int[] getMinWindowSize() {
            w wVar = this.xv;
            if (wVar != null) {
                return wVar.f();
            }
            return null;
        }

        @Override // com.bytedance.msdk.c.ux
        public String getReqId() {
            w wVar = this.xv;
            return wVar != null ? PangleAdapterUtils.getReqId(wVar.ux()) : "";
        }

        @Override // com.bytedance.msdk.c.ux
        public boolean hasDestroyed() {
            return this.xv == null;
        }

        @Override // com.bytedance.msdk.c.ux
        public void onDestroy() {
            w wVar = this.xv;
            if (wVar != null) {
                wVar.c((com.bytedance.sdk.openadsdk.sr.c.w.c.c) null);
                this.xv.c((com.bytedance.sdk.openadsdk.ys.w.c.w) null);
                this.xv.c((com.bytedance.sdk.openadsdk.sr.c.w.c.w) null);
                this.xv.c((xv) null);
                this.xv = null;
            }
        }

        @Override // com.bytedance.msdk.c.ux
        public void showSplashAd(ViewGroup viewGroup) {
            w wVar = this.xv;
            if (wVar == null || viewGroup == null) {
                return;
            }
            wVar.c(viewGroup);
        }

        @Override // com.bytedance.msdk.c.ux
        public void showSplashCardView(ViewGroup viewGroup, Activity activity) {
            w wVar = this.xv;
            if (wVar != null) {
                wVar.c(viewGroup, activity);
            }
        }

        @Override // com.bytedance.msdk.c.ux
        public void showSplashClickEyeView(ViewGroup viewGroup) {
            w wVar = this.xv;
            if (wVar != null) {
                wVar.w(viewGroup);
            }
        }

        @Override // com.bytedance.msdk.c.ux
        public void splashMinWindowAnimationFinish() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public com.bytedance.msdk.adapter.w.ux c() {
            return (com.bytedance.msdk.adapter.w.ux) this.f27667a;
        }

        void c(Context context) {
            wv pluginCSJLoader = PangleSplashLoader.this.getPluginCSJLoader(context);
            if (pluginCSJLoader == null) {
                return;
            }
            Map<String, Object> map = this.sr;
            if (map == null) {
                PangleSplashLoader.this.f27194f = 3000;
            } else {
                PangleSplashLoader.this.f27194f = map.get(TTRequestExtraParams.PARAM_AD_LOAD_TIMEOUT) != null ? ((Integer) this.sr.get(TTRequestExtraParams.PARAM_AD_LOAD_TIMEOUT)).intValue() : 3000;
            }
            w.c buildPangleAdSlot = PangleAdapterUtils.buildPangleAdSlot(((c) PangleSplashLoader.this).xv, PangleSplashLoader.this.getAdSlotId(), ((c) PangleSplashLoader.this).f26913c, PangleSplashLoader.this.getClientReqId(), PangleSplashLoader.this.getAdm(), false);
            buildPangleAdSlot.c(((c) PangleSplashLoader.this).xv.q()).w(((c) PangleSplashLoader.this).xv.j()).c(((c) PangleSplashLoader.this).xv.bk()).w(((c) PangleSplashLoader.this).xv.t());
            c(pluginCSJLoader, buildPangleAdSlot.c());
        }

        private void c(wv wvVar, com.bytedance.sdk.openadsdk.ys.w.xv.w wVar) {
            wvVar.c(wVar, new com.bytedance.sdk.openadsdk.fz.c.w.c.c(null) { // from class: com.bytedance.msdk.adapter.pangle_csjm.PangleSplashLoader.PangleSplashAd.1
                @Override // com.bytedance.sdk.openadsdk.fz.c.w.c.c
                @MainThread
                public void onSplashLoadFail(com.bytedance.sdk.openadsdk.ys.w.w.c cVar) {
                    com.bytedance.msdk.adapter.sr.xv.sr("TTMediationSDK", "new api onSplashLoadFail");
                    if (cVar != null) {
                        PangleSplashLoader.this.notifyAdFailed(new com.bytedance.msdk.api.c(cVar.c(), cVar.w()));
                    } else {
                        PangleSplashLoader.this.notifyAdFailed(new com.bytedance.msdk.api.c(80001, "csjAdError is null"));
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.fz.c.w.c.c
                public void onSplashLoadSuccess(com.bytedance.sdk.openadsdk.ys.w.w.w wVar2) {
                    com.bytedance.msdk.adapter.sr.xv.sr("TTMediationSDK", "new api onSplashLoadSuccess 111");
                }

                @Override // com.bytedance.sdk.openadsdk.fz.c.w.c.c
                @MainThread
                public void onSplashRenderFail(com.bytedance.sdk.openadsdk.ys.w.w.w wVar2, com.bytedance.sdk.openadsdk.ys.w.w.c cVar) {
                    com.bytedance.msdk.adapter.sr.xv.sr("TTMediationSDK", "new api onSplashRenderFail");
                    if (cVar != null) {
                        PangleSplashLoader.this.notifyAdFailed(new com.bytedance.msdk.api.c(cVar.c(), cVar.w()));
                    } else {
                        PangleSplashLoader.this.notifyAdFailed(new com.bytedance.msdk.api.c(80001, "csjAdError is null"));
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.fz.c.w.c.c
                @MainThread
                public void onSplashRenderSuccess(com.bytedance.sdk.openadsdk.ys.w.w.w wVar2) {
                    Map<String, Object> ux;
                    com.bytedance.msdk.adapter.sr.xv.sr("TTMediationSDK", "new api onSplashRenderSuccess");
                    if (wVar2 == null) {
                        PangleSplashLoader.this.notifyAdFailed(new com.bytedance.msdk.api.c(80001, "\u6e32\u67d3\u6210\u529f\u4f46\u5e7f\u544a\u662f\u7a7a"));
                        return;
                    }
                    PangleSplashAd.this.xv = wVar2;
                    PangleSplashAd.this.setExpressAd(true);
                    PangleSplashAd pangleSplashAd = PangleSplashAd.this;
                    pangleSplashAd.setInteractionType(pangleSplashAd.xv.sr());
                    if (PangleSplashLoader.this.isClientBidding() && (ux = PangleSplashAd.this.xv.ux()) != null) {
                        double value = PangleAdapterUtils.getValue(ux.get(BidResponsed.KEY_PRICE));
                        com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK_ECMP", com.bytedance.msdk.adapter.sr.ux.w(PangleSplashLoader.this.getAdapterRit(), PangleSplashLoader.this.getAdSlotId()) + "pangle Splash \u8fd4\u56de\u7684 cpm\u4ef7\u683c\uff1a" + value);
                        PangleSplashAd pangleSplashAd2 = PangleSplashAd.this;
                        if (value <= 0.0d) {
                            value = 0.0d;
                        }
                        pangleSplashAd2.setCpm(value);
                    }
                    PangleSplashAd.this.xv.c(new com.bytedance.sdk.openadsdk.sr.c.w.c.c(null) { // from class: com.bytedance.msdk.adapter.pangle_csjm.PangleSplashLoader.PangleSplashAd.1.1
                        @Override // com.bytedance.sdk.openadsdk.sr.c.w.c.c
                        public void onSplashAdClick(com.bytedance.sdk.openadsdk.ys.w.w.w wVar3) {
                            com.bytedance.msdk.adapter.sr.xv.sr("TTMediationSDK", "new api onSplashAdClick");
                            if (((ux) PangleSplashAd.this).f27667a instanceof com.bytedance.msdk.adapter.w.ux) {
                                PangleSplashAd.this.c().r();
                            }
                        }

                        @Override // com.bytedance.sdk.openadsdk.sr.c.w.c.c
                        public void onSplashAdClose(com.bytedance.sdk.openadsdk.ys.w.w.w wVar3, int i4) {
                            com.bytedance.msdk.adapter.sr.xv.sr("TTMediationSDK", "new api onSplashAdClose closeType = " + i4);
                            if (i4 == 1 || i4 == 3) {
                                if (((ux) PangleSplashAd.this).f27667a instanceof com.bytedance.msdk.adapter.w.ux) {
                                    PangleSplashAd.this.c().c(i4);
                                }
                            } else if (((ux) PangleSplashAd.this).f27667a instanceof com.bytedance.msdk.adapter.w.ux) {
                                PangleSplashAd.this.c().w(i4);
                            }
                        }

                        @Override // com.bytedance.sdk.openadsdk.sr.c.w.c.c
                        public void onSplashAdShow(com.bytedance.sdk.openadsdk.ys.w.w.w wVar3) {
                            com.bytedance.msdk.adapter.sr.xv.sr("TTMediationSDK", "new api onSplashAdShow");
                            if (((ux) PangleSplashAd.this).f27667a instanceof com.bytedance.msdk.adapter.w.ux) {
                                PangleSplashAd.this.c().u_();
                            }
                        }
                    });
                    PangleSplashAd.this.xv.c(new com.bytedance.sdk.openadsdk.sr.c.w.c.w(null) { // from class: com.bytedance.msdk.adapter.pangle_csjm.PangleSplashLoader.PangleSplashAd.1.2
                        @Override // com.bytedance.sdk.openadsdk.sr.c.w.c.w
                        public void onSplashCardClick() {
                            com.bytedance.msdk.adapter.sr.xv.sr("TTMediationSDK", "new api onSplashCardClick");
                            try {
                                if (((ux) PangleSplashAd.this).f27667a instanceof com.bytedance.msdk.adapter.w.ux) {
                                    PangleSplashAd.this.c().ux();
                                }
                            } catch (Throwable th) {
                                th.printStackTrace();
                            }
                        }

                        @Override // com.bytedance.sdk.openadsdk.sr.c.w.c.w
                        public void onSplashCardClose() {
                            com.bytedance.msdk.adapter.sr.xv.sr("TTMediationSDK", "new api onSplashCardClose");
                            if (((ux) PangleSplashAd.this).f27667a instanceof com.bytedance.msdk.adapter.w.ux) {
                                PangleSplashAd.this.c().x_();
                            }
                        }

                        @Override // com.bytedance.sdk.openadsdk.sr.c.w.c.w
                        public void onSplashCardReadyToShow(com.bytedance.sdk.openadsdk.ys.w.w.w wVar3) {
                            if (wVar3 != null) {
                                com.bytedance.msdk.adapter.sr.xv.sr("TTMediationSDK", "new api onSplashCardReadyToShow csjSplashAd.getSplashCardView()" + wVar3.xv());
                            }
                            if (((ux) PangleSplashAd.this).f27667a instanceof com.bytedance.msdk.adapter.w.ux) {
                                PangleSplashAd.this.c().c(true);
                            }
                            if (((ux) PangleSplashAd.this).f27667a instanceof com.bytedance.msdk.adapter.w.ux) {
                                PangleSplashAd.this.c().w_();
                            }
                        }
                    });
                    PangleSplashAd.this.xv.c(new xv(null) { // from class: com.bytedance.msdk.adapter.pangle_csjm.PangleSplashLoader.PangleSplashAd.1.3
                        @Override // com.bytedance.sdk.openadsdk.sr.c.w.c.xv
                        public void onSplashClickEyeClick() {
                            com.bytedance.msdk.adapter.sr.xv.sr("TTMediationSDK", "new api onSplashClickEyeClick");
                            if (((ux) PangleSplashAd.this).f27667a instanceof com.bytedance.msdk.adapter.w.ux) {
                                PangleSplashAd.this.c().f();
                            }
                        }

                        @Override // com.bytedance.sdk.openadsdk.sr.c.w.c.xv
                        public void onSplashClickEyeClose() {
                            com.bytedance.msdk.adapter.sr.xv.sr("TTMediationSDK", "new api onSplashClickEyeClose");
                            if (((ux) PangleSplashAd.this).f27667a instanceof com.bytedance.msdk.adapter.w.ux) {
                                PangleSplashAd.this.c().v_();
                            }
                        }

                        @Override // com.bytedance.sdk.openadsdk.sr.c.w.c.xv
                        public void onSplashClickEyeReadyToShow(com.bytedance.sdk.openadsdk.ys.w.w.w wVar3) {
                            com.bytedance.msdk.adapter.sr.xv.sr("TTMediationSDK", "new api onSplashClickEyeReadyToShow");
                            PangleSplashAd pangleSplashAd3 = PangleSplashAd.this;
                            pangleSplashAd3.f27195c = true;
                            if (((ux) pangleSplashAd3).f27667a instanceof com.bytedance.msdk.adapter.w.ux) {
                                PangleSplashAd.this.c().c();
                            }
                        }
                    });
                    PangleSplashAd pangleSplashAd3 = PangleSplashAd.this;
                    PangleSplashLoader.this.notifyAdLoaded(pangleSplashAd3);
                }
            }, PangleSplashLoader.this.f27194f);
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
        } else {
            new PangleSplashAd(map).c(context != null ? StubApp.getOrigApplicationContext(context.getApplicationContext()) : com.bytedance.msdk.core.c.getContext());
        }
    }
}

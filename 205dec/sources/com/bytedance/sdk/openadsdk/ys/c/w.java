package com.bytedance.sdk.openadsdk.ys.c;

import android.util.Pair;
import android.view.View;
import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.CSJAdError;
import com.bytedance.sdk.openadsdk.CSJSplashAd;
import com.bytedance.sdk.openadsdk.ISplashCardListener;
import com.bytedance.sdk.openadsdk.ISplashClickEyeListener;
import com.bytedance.sdk.openadsdk.TTAdInteractionListener;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.bytedance.sdk.openadsdk.TTSplashAd;
import com.bytedance.sdk.openadsdk.fz.c.c.c.f;
import com.bytedance.sdk.openadsdk.mediation.bridge.MediationAdClassLoader;
import com.bytedance.sdk.openadsdk.mediation.c.c.sr;
import com.bytedance.sdk.openadsdk.mediation.c.c.ux;
import com.bytedance.sdk.openadsdk.mediation.manager.MediationSplashManager;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public abstract class w {

    /* loaded from: E:\TSN-r\205dec\6241084.dex */
    public static class c implements TTAdNative {

        /* renamed from: c  reason: collision with root package name */
        private final w f36423c;

        protected c(w wVar) {
            this.f36423c = wVar;
        }

        private ValueSet c(AdSlot adSlot) {
            b k4 = b.k(com.bytedance.sdk.openadsdk.ys.c.xv.w.w(adSlot));
            k4.h(8302, MediationAdClassLoader.getInstance());
            if (adSlot.getMediationAdSlot() != null) {
                k4.h(8260028, new ux(adSlot.getMediationAdSlot()));
                k4.h(260027, adSlot.getMediationAdSlot());
            }
            return k4.l();
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadBannerExpressAd(AdSlot adSlot, TTAdNative.NativeExpressAdListener nativeExpressAdListener) {
            try {
                this.f36423c.gd(c(adSlot), new com.bytedance.sdk.openadsdk.fz.c.c.c.ux(nativeExpressAdListener));
            } catch (Exception e4) {
                if (nativeExpressAdListener != null) {
                    Pair<Integer, String> c4 = this.f36423c.c(e4);
                    nativeExpressAdListener.onError(((Integer) c4.first).intValue(), (String) c4.second);
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadDrawFeedAd(AdSlot adSlot, TTAdNative.DrawFeedAdListener drawFeedAdListener) {
            try {
                this.f36423c.xv(c(adSlot), new com.bytedance.sdk.openadsdk.mediation.c.c.w(drawFeedAdListener));
            } catch (Exception e4) {
                if (drawFeedAdListener != null) {
                    Pair<Integer, String> c4 = this.f36423c.c(e4);
                    drawFeedAdListener.onError(((Integer) c4.first).intValue(), (String) c4.second);
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadExpressDrawFeedAd(AdSlot adSlot, TTAdNative.NativeExpressAdListener nativeExpressAdListener) {
            try {
                this.f36423c.ev(c(adSlot), new com.bytedance.sdk.openadsdk.fz.c.c.c.ux(nativeExpressAdListener));
            } catch (Exception e4) {
                if (nativeExpressAdListener != null) {
                    Pair<Integer, String> c4 = this.f36423c.c(e4);
                    nativeExpressAdListener.onError(((Integer) c4.first).intValue(), (String) c4.second);
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadFeedAd(AdSlot adSlot, TTAdNative.FeedAdListener feedAdListener) {
            try {
                this.f36423c.c(c(adSlot), new com.bytedance.sdk.openadsdk.mediation.c.c.xv(feedAdListener));
            } catch (Exception e4) {
                if (feedAdListener != null) {
                    Pair<Integer, String> c4 = this.f36423c.c(e4);
                    feedAdListener.onError(((Integer) c4.first).intValue(), (String) c4.second);
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadFullScreenVideoAd(AdSlot adSlot, TTAdNative.FullScreenVideoAdListener fullScreenVideoAdListener) {
            try {
                this.f36423c.f(c(adSlot), new sr(fullScreenVideoAdListener));
            } catch (Exception e4) {
                if (fullScreenVideoAdListener != null) {
                    Pair<Integer, String> c4 = this.f36423c.c(e4);
                    fullScreenVideoAdListener.onError(((Integer) c4.first).intValue(), (String) c4.second);
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadInteractionExpressAd(AdSlot adSlot, TTAdNative.NativeExpressAdListener nativeExpressAdListener) {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadNativeAd(AdSlot adSlot, TTAdNative.NativeAdListener nativeAdListener) {
            try {
                this.f36423c.sr(c(adSlot), new com.bytedance.sdk.openadsdk.fz.c.c.c.sr(nativeAdListener));
            } catch (Exception e4) {
                if (nativeAdListener != null) {
                    Pair<Integer, String> c4 = this.f36423c.c(e4);
                    nativeAdListener.onError(((Integer) c4.first).intValue(), (String) c4.second);
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadNativeExpressAd(AdSlot adSlot, TTAdNative.NativeExpressAdListener nativeExpressAdListener) {
            try {
                this.f36423c.r(c(adSlot), new com.bytedance.sdk.openadsdk.fz.c.c.c.ux(nativeExpressAdListener));
            } catch (Exception e4) {
                if (nativeExpressAdListener != null) {
                    Pair<Integer, String> c4 = this.f36423c.c(e4);
                    nativeExpressAdListener.onError(((Integer) c4.first).intValue(), (String) c4.second);
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadRewardVideoAd(AdSlot adSlot, TTAdNative.RewardVideoAdListener rewardVideoAdListener) {
            try {
                this.f36423c.ux(c(adSlot), new f(rewardVideoAdListener));
            } catch (Exception e4) {
                if (rewardVideoAdListener != null) {
                    Pair<Integer, String> c4 = this.f36423c.c(e4);
                    rewardVideoAdListener.onError(((Integer) c4.first).intValue(), (String) c4.second);
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadSplashAd(AdSlot adSlot, TTAdNative.SplashAdListener splashAdListener, int i4) {
            c(adSlot, splashAdListener, i4);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadStream(AdSlot adSlot, TTAdNative.FeedAdListener feedAdListener) {
            try {
                this.f36423c.w(c(adSlot), new com.bytedance.sdk.openadsdk.mediation.c.c.xv(feedAdListener));
            } catch (Exception e4) {
                if (feedAdListener != null) {
                    Pair<Integer, String> c4 = this.f36423c.c(e4);
                    feedAdListener.onError(((Integer) c4.first).intValue(), (String) c4.second);
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadSplashAd(AdSlot adSlot, TTAdNative.CSJSplashAdListener cSJSplashAdListener, int i4) {
            try {
                this.f36423c.c(c(adSlot), new xv(cSJSplashAdListener), i4);
            } catch (Exception e4) {
                if (cSJSplashAdListener != null) {
                    final Pair<Integer, String> c4 = this.f36423c.c(e4);
                    cSJSplashAdListener.onSplashLoadFail(new CSJAdError() { // from class: com.bytedance.sdk.openadsdk.ys.c.w.c.1
                        @Override // com.bytedance.sdk.openadsdk.CSJAdError
                        public int getCode() {
                            return ((Integer) c4.first).intValue();
                        }

                        @Override // com.bytedance.sdk.openadsdk.CSJAdError
                        public String getMsg() {
                            return (String) c4.second;
                        }
                    });
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadSplashAd(AdSlot adSlot, TTAdNative.SplashAdListener splashAdListener) {
            c(adSlot, splashAdListener, -1);
        }

        private void c(AdSlot adSlot, final TTAdNative.SplashAdListener splashAdListener, int i4) {
            loadSplashAd(adSlot, new TTAdNative.CSJSplashAdListener() { // from class: com.bytedance.sdk.openadsdk.ys.c.w.c.2
                @Override // com.bytedance.sdk.openadsdk.TTAdNative.CSJSplashAdListener
                public void onSplashLoadFail(CSJAdError cSJAdError) {
                    String str;
                    if (splashAdListener != null) {
                        int i5 = -1;
                        if (cSJAdError != null) {
                            i5 = cSJAdError.getCode();
                            str = cSJAdError.getMsg();
                        } else {
                            str = "splash load fail";
                        }
                        if (i5 == 23) {
                            splashAdListener.onTimeout();
                        } else {
                            splashAdListener.onError(i5, str);
                        }
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.TTAdNative.CSJSplashAdListener
                public void onSplashLoadSuccess(CSJSplashAd cSJSplashAd) {
                }

                @Override // com.bytedance.sdk.openadsdk.TTAdNative.CSJSplashAdListener
                public void onSplashRenderFail(CSJSplashAd cSJSplashAd, CSJAdError cSJAdError) {
                    String str;
                    if (splashAdListener != null) {
                        int i5 = -1;
                        if (cSJAdError != null) {
                            i5 = cSJAdError.getCode();
                            str = cSJAdError.getMsg();
                        } else {
                            str = "splash render fail";
                        }
                        if (i5 == 23) {
                            splashAdListener.onTimeout();
                        } else {
                            splashAdListener.onError(i5, str);
                        }
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.TTAdNative.CSJSplashAdListener
                public void onSplashRenderSuccess(CSJSplashAd cSJSplashAd) {
                    if (splashAdListener == null) {
                        return;
                    }
                    splashAdListener.onSplashAdLoad(c.this.c(cSJSplashAd));
                }
            }, i4);
        }

        public TTSplashAd c(final CSJSplashAd cSJSplashAd) {
            if (cSJSplashAd == null) {
                return null;
            }
            final TTSplashAd.AdInteractionListener[] adInteractionListenerArr = new TTSplashAd.AdInteractionListener[1];
            return new TTSplashAd() { // from class: com.bytedance.sdk.openadsdk.ys.c.w.c.3
                @Override // com.bytedance.sdk.openadsdk.TTSplashAd
                public int getInteractionType() {
                    CSJSplashAd cSJSplashAd2 = cSJSplashAd;
                    if (cSJSplashAd2 == null) {
                        return 0;
                    }
                    return cSJSplashAd2.getInteractionType();
                }

                @Override // com.bytedance.sdk.openadsdk.TTSplashAd
                public Map<String, Object> getMediaExtraInfo() {
                    return cSJSplashAd.getMediaExtraInfo();
                }

                @Override // com.bytedance.sdk.openadsdk.TTSplashAd
                public MediationSplashManager getMediationManager() {
                    return cSJSplashAd.getMediationManager();
                }

                @Override // com.bytedance.sdk.openadsdk.TTSplashAd
                public int[] getSplashClickEyeSizeToDp() {
                    return cSJSplashAd.getSplashClickEyeSizeToDp();
                }

                @Override // com.bytedance.sdk.openadsdk.TTSplashAd
                public View getSplashView() {
                    CSJSplashAd cSJSplashAd2 = cSJSplashAd;
                    if (cSJSplashAd2 == null) {
                        return null;
                    }
                    return cSJSplashAd2.getSplashView();
                }

                @Override // com.bytedance.sdk.openadsdk.TTClientBidding
                public void loss(Double d4, String str, String str2) {
                    cSJSplashAd.loss(d4, str, str2);
                }

                @Override // com.bytedance.sdk.openadsdk.TTSplashAd
                public void renderExpressAd(TTNativeExpressAd.ExpressAdInteractionListener expressAdInteractionListener) {
                }

                @Override // com.bytedance.sdk.openadsdk.TTClientBidding
                public void setAdInteractionListener(TTAdInteractionListener tTAdInteractionListener) {
                    cSJSplashAd.setAdInteractionListener(tTAdInteractionListener);
                }

                @Override // com.bytedance.sdk.openadsdk.TTSplashAd
                public void setDownloadListener(TTAppDownloadListener tTAppDownloadListener) {
                    if (tTAppDownloadListener == null) {
                        return;
                    }
                    cSJSplashAd.setDownloadListener(tTAppDownloadListener);
                }

                @Override // com.bytedance.sdk.openadsdk.TTSplashAd
                public void setNotAllowSdkCountdown() {
                    cSJSplashAd.hideSkipButton();
                }

                @Override // com.bytedance.sdk.openadsdk.TTClientBidding
                public void setPrice(Double d4) {
                    cSJSplashAd.setPrice(d4);
                }

                @Override // com.bytedance.sdk.openadsdk.TTSplashAd
                public void setSplashCardListener(final ISplashCardListener iSplashCardListener) {
                    if (iSplashCardListener == null) {
                        return;
                    }
                    cSJSplashAd.setSplashCardListener(new CSJSplashAd.SplashCardListener() { // from class: com.bytedance.sdk.openadsdk.ys.c.w.c.3.3
                        @Override // com.bytedance.sdk.openadsdk.CSJSplashAd.SplashCardListener
                        public void onSplashCardClick() {
                            AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                            TTSplashAd.AdInteractionListener[] adInteractionListenerArr2 = adInteractionListenerArr;
                            if (adInteractionListenerArr2[0] != null) {
                                adInteractionListenerArr2[0].onAdClicked(cSJSplashAd.getSplashView(), cSJSplashAd.getInteractionType());
                            }
                        }

                        @Override // com.bytedance.sdk.openadsdk.CSJSplashAd.SplashCardListener
                        public void onSplashCardClose() {
                            iSplashCardListener.onSplashClickEyeClose();
                        }

                        @Override // com.bytedance.sdk.openadsdk.CSJSplashAd.SplashCardListener
                        public void onSplashCardReadyToShow(CSJSplashAd cSJSplashAd2) {
                            iSplashCardListener.setSupportSplashClickEye(true);
                            iSplashCardListener.onSplashEyeReady();
                        }
                    });
                }

                @Override // com.bytedance.sdk.openadsdk.TTSplashAd
                public void setSplashClickEyeListener(final ISplashClickEyeListener iSplashClickEyeListener) {
                    if (iSplashClickEyeListener == null) {
                        return;
                    }
                    cSJSplashAd.setSplashClickEyeListener(new CSJSplashAd.SplashClickEyeListener() { // from class: com.bytedance.sdk.openadsdk.ys.c.w.c.3.2
                        @Override // com.bytedance.sdk.openadsdk.CSJSplashAd.SplashClickEyeListener
                        public void onSplashClickEyeClick() {
                            AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                            TTSplashAd.AdInteractionListener[] adInteractionListenerArr2 = adInteractionListenerArr;
                            if (adInteractionListenerArr2[0] != null) {
                                adInteractionListenerArr2[0].onAdClicked(cSJSplashAd.getSplashView(), cSJSplashAd.getInteractionType());
                            }
                        }

                        @Override // com.bytedance.sdk.openadsdk.CSJSplashAd.SplashClickEyeListener
                        public void onSplashClickEyeClose() {
                            iSplashClickEyeListener.onSplashClickEyeAnimationFinish();
                        }

                        @Override // com.bytedance.sdk.openadsdk.CSJSplashAd.SplashClickEyeListener
                        public void onSplashClickEyeReadyToShow(CSJSplashAd cSJSplashAd2) {
                            iSplashClickEyeListener.isSupportSplashClickEye(true);
                            iSplashClickEyeListener.onSplashClickEyeAnimationStart();
                        }
                    });
                }

                @Override // com.bytedance.sdk.openadsdk.TTSplashAd
                public void setSplashInteractionListener(final TTSplashAd.AdInteractionListener adInteractionListener) {
                    CSJSplashAd cSJSplashAd2;
                    if (adInteractionListener == null || (cSJSplashAd2 = cSJSplashAd) == null) {
                        return;
                    }
                    adInteractionListenerArr[0] = adInteractionListener;
                    cSJSplashAd2.setSplashAdListener(new CSJSplashAd.SplashAdListener() { // from class: com.bytedance.sdk.openadsdk.ys.c.w.c.3.1
                        @Override // com.bytedance.sdk.openadsdk.CSJSplashAd.SplashAdListener
                        public void onSplashAdClick(CSJSplashAd cSJSplashAd3) {
                            if (cSJSplashAd3 == null) {
                                adInteractionListener.onAdClicked(null, -1);
                            } else {
                                adInteractionListener.onAdClicked(cSJSplashAd3.getSplashView(), cSJSplashAd3.getInteractionType());
                            }
                        }

                        @Override // com.bytedance.sdk.openadsdk.CSJSplashAd.SplashAdListener
                        public void onSplashAdClose(CSJSplashAd cSJSplashAd3, int i4) {
                            if (i4 == 1) {
                                adInteractionListener.onAdSkip();
                            } else if (i4 == 2 || i4 == 4) {
                                adInteractionListener.onAdTimeOver();
                            }
                        }

                        @Override // com.bytedance.sdk.openadsdk.CSJSplashAd.SplashAdListener
                        public void onSplashAdShow(CSJSplashAd cSJSplashAd3) {
                            if (cSJSplashAd3 == null) {
                                adInteractionListener.onAdShow(null, -1);
                            } else {
                                adInteractionListener.onAdShow(cSJSplashAd3.getSplashView(), cSJSplashAd3.getInteractionType());
                            }
                        }
                    });
                }

                @Override // com.bytedance.sdk.openadsdk.TTSplashAd
                public void splashClickEyeAnimationFinish() {
                    cSJSplashAd.showSplashClickEyeView(null);
                }

                @Override // com.bytedance.sdk.openadsdk.TTSplashAd
                public void startClickEye(boolean z3) {
                    cSJSplashAd.startClickEye();
                }

                @Override // com.bytedance.sdk.openadsdk.TTClientBidding
                public void win(Double d4) {
                    cSJSplashAd.win(d4);
                }

                @Override // com.bytedance.sdk.openadsdk.TTSplashAd
                public void startClickEye() {
                    cSJSplashAd.startClickEye();
                }
            };
        }
    }

    public abstract Pair<Integer, String> c(Exception exc);

    public TTAdNative c() {
        return new c(this);
    }

    public abstract void c(ValueSet valueSet, Bridge bridge);

    public abstract void c(ValueSet valueSet, Bridge bridge, int i4);

    public abstract void ev(ValueSet valueSet, Bridge bridge);

    public abstract void f(ValueSet valueSet, Bridge bridge);

    public abstract void gd(ValueSet valueSet, Bridge bridge);

    public abstract void r(ValueSet valueSet, Bridge bridge);

    public abstract void sr(ValueSet valueSet, Bridge bridge);

    public abstract void ux(ValueSet valueSet, Bridge bridge);

    public abstract void w(ValueSet valueSet, Bridge bridge);

    public abstract void xv(ValueSet valueSet, Bridge bridge);
}

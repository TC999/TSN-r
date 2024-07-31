package com.bytedance.sdk.openadsdk.p138bl.p139ok;

import android.util.Pair;
import android.view.View;
import com.bykv.p106ok.p107ok.p108ok.p109ok.C5930a;
import com.bykv.p110vk.openvk.api.proto.Bridge;
import com.bykv.p110vk.openvk.api.proto.ValueSet;
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
import com.bytedance.sdk.openadsdk.mediation.bridge.MediationAdClassLoader;
import com.bytedance.sdk.openadsdk.mediation.manager.MediationSplashManager;
import com.bytedance.sdk.openadsdk.mediation.p170ok.p171ok.C6475a;
import com.bytedance.sdk.openadsdk.mediation.p170ok.p171ok.C6481bl;
import com.bytedance.sdk.openadsdk.mediation.p170ok.p171ok.C6486n;
import com.bytedance.sdk.openadsdk.mediation.p170ok.p171ok.C6494s;
import com.bytedance.sdk.openadsdk.p138bl.p139ok.p141bl.C6342a;
import com.bytedance.sdk.openadsdk.p143h.p144ok.p145ok.p146ok.C6415kf;
import com.bytedance.sdk.openadsdk.p143h.p144ok.p145ok.p146ok.C6416n;
import com.bytedance.sdk.openadsdk.p143h.p144ok.p145ok.p146ok.C6418s;
import java.util.Map;

/* renamed from: com.bytedance.sdk.openadsdk.bl.ok.ok */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public abstract class AbstractC6364ok {

    /* renamed from: com.bytedance.sdk.openadsdk.bl.ok.ok$ok */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static class C6365ok implements TTAdNative {

        /* renamed from: ok */
        private final AbstractC6364ok f22499ok;

        protected C6365ok(AbstractC6364ok abstractC6364ok) {
            this.f22499ok = abstractC6364ok;
        }

        /* renamed from: ok */
        private ValueSet m36501ok(AdSlot adSlot) {
            C5930a m37916k = C5930a.m37916k(C6342a.m36536a(adSlot));
            m37916k.m37919h(8302, MediationAdClassLoader.getInstance());
            if (adSlot.getMediationAdSlot() != null) {
                m37916k.m37919h(260026, new C6486n(adSlot.getMediationAdSlot()));
                m37916k.m37919h(260027, adSlot.getMediationAdSlot());
            }
            return m37916k.m37926a();
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadBannerExpressAd(AdSlot adSlot, TTAdNative.NativeExpressAdListener nativeExpressAdListener) {
            try {
                this.f22499ok.mo36504q(m36501ok(adSlot), new C6416n(nativeExpressAdListener));
            } catch (Exception e) {
                if (nativeExpressAdListener != null) {
                    Pair<Integer, String> mo36506ok = this.f22499ok.mo36506ok(e);
                    nativeExpressAdListener.onError(((Integer) mo36506ok.first).intValue(), (String) mo36506ok.second);
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadDrawFeedAd(AdSlot adSlot, TTAdNative.DrawFeedAdListener drawFeedAdListener) {
            try {
                this.f22499ok.mo36513bl(m36501ok(adSlot), new C6475a(drawFeedAdListener));
            } catch (Exception e) {
                if (drawFeedAdListener != null) {
                    Pair<Integer, String> mo36506ok = this.f22499ok.mo36506ok(e);
                    drawFeedAdListener.onError(((Integer) mo36506ok.first).intValue(), (String) mo36506ok.second);
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadExpressDrawFeedAd(AdSlot adSlot, TTAdNative.NativeExpressAdListener nativeExpressAdListener) {
            try {
                this.f22499ok.mo36505p(m36501ok(adSlot), new C6416n(nativeExpressAdListener));
            } catch (Exception e) {
                if (nativeExpressAdListener != null) {
                    Pair<Integer, String> mo36506ok = this.f22499ok.mo36506ok(e);
                    nativeExpressAdListener.onError(((Integer) mo36506ok.first).intValue(), (String) mo36506ok.second);
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadFeedAd(AdSlot adSlot, TTAdNative.FeedAdListener feedAdListener) {
            try {
                this.f22499ok.mo36508ok(m36501ok(adSlot), new C6481bl(feedAdListener));
            } catch (Exception e) {
                if (feedAdListener != null) {
                    Pair<Integer, String> mo36506ok = this.f22499ok.mo36506ok(e);
                    feedAdListener.onError(((Integer) mo36506ok.first).intValue(), (String) mo36506ok.second);
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadFullScreenVideoAd(AdSlot adSlot, TTAdNative.FullScreenVideoAdListener fullScreenVideoAdListener) {
            try {
                this.f22499ok.mo36511kf(m36501ok(adSlot), new C6494s(fullScreenVideoAdListener));
            } catch (Exception e) {
                if (fullScreenVideoAdListener != null) {
                    Pair<Integer, String> mo36506ok = this.f22499ok.mo36506ok(e);
                    fullScreenVideoAdListener.onError(((Integer) mo36506ok.first).intValue(), (String) mo36506ok.second);
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadInteractionExpressAd(AdSlot adSlot, TTAdNative.NativeExpressAdListener nativeExpressAdListener) {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadNativeAd(AdSlot adSlot, TTAdNative.NativeAdListener nativeAdListener) {
            try {
                this.f22499ok.mo36503s(m36501ok(adSlot), new C6418s(nativeAdListener));
            } catch (Exception e) {
                if (nativeAdListener != null) {
                    Pair<Integer, String> mo36506ok = this.f22499ok.mo36506ok(e);
                    nativeAdListener.onError(((Integer) mo36506ok.first).intValue(), (String) mo36506ok.second);
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadNativeExpressAd(AdSlot adSlot, TTAdNative.NativeExpressAdListener nativeExpressAdListener) {
            try {
                this.f22499ok.mo36512h(m36501ok(adSlot), new C6416n(nativeExpressAdListener));
            } catch (Exception e) {
                if (nativeExpressAdListener != null) {
                    Pair<Integer, String> mo36506ok = this.f22499ok.mo36506ok(e);
                    nativeExpressAdListener.onError(((Integer) mo36506ok.first).intValue(), (String) mo36506ok.second);
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadRewardVideoAd(AdSlot adSlot, TTAdNative.RewardVideoAdListener rewardVideoAdListener) {
            try {
                this.f22499ok.mo36510n(m36501ok(adSlot), new C6415kf(rewardVideoAdListener));
            } catch (Exception e) {
                if (rewardVideoAdListener != null) {
                    Pair<Integer, String> mo36506ok = this.f22499ok.mo36506ok(e);
                    rewardVideoAdListener.onError(((Integer) mo36506ok.first).intValue(), (String) mo36506ok.second);
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadSplashAd(AdSlot adSlot, TTAdNative.SplashAdListener splashAdListener, int i) {
            m36500ok(adSlot, splashAdListener, i);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadStream(AdSlot adSlot, TTAdNative.FeedAdListener feedAdListener) {
            try {
                this.f22499ok.mo36514a(m36501ok(adSlot), new C6481bl(feedAdListener));
            } catch (Exception e) {
                if (feedAdListener != null) {
                    Pair<Integer, String> mo36506ok = this.f22499ok.mo36506ok(e);
                    feedAdListener.onError(((Integer) mo36506ok.first).intValue(), (String) mo36506ok.second);
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadSplashAd(AdSlot adSlot, TTAdNative.CSJSplashAdListener cSJSplashAdListener, int i) {
            try {
                this.f22499ok.mo36507ok(m36501ok(adSlot), new C6339a(cSJSplashAdListener), i);
            } catch (Exception e) {
                if (cSJSplashAdListener != null) {
                    final Pair<Integer, String> mo36506ok = this.f22499ok.mo36506ok(e);
                    cSJSplashAdListener.onSplashLoadFail(new CSJAdError() { // from class: com.bytedance.sdk.openadsdk.bl.ok.ok.ok.1
                        @Override // com.bytedance.sdk.openadsdk.CSJAdError
                        public int getCode() {
                            return ((Integer) mo36506ok.first).intValue();
                        }

                        @Override // com.bytedance.sdk.openadsdk.CSJAdError
                        public String getMsg() {
                            return (String) mo36506ok.second;
                        }
                    });
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadSplashAd(AdSlot adSlot, TTAdNative.SplashAdListener splashAdListener) {
            m36500ok(adSlot, splashAdListener, -1);
        }

        /* renamed from: ok */
        private void m36500ok(AdSlot adSlot, final TTAdNative.SplashAdListener splashAdListener, int i) {
            loadSplashAd(adSlot, new TTAdNative.CSJSplashAdListener() { // from class: com.bytedance.sdk.openadsdk.bl.ok.ok.ok.2
                @Override // com.bytedance.sdk.openadsdk.TTAdNative.CSJSplashAdListener
                public void onSplashLoadFail(CSJAdError cSJAdError) {
                    String str;
                    if (splashAdListener != null) {
                        int i2 = -1;
                        if (cSJAdError != null) {
                            i2 = cSJAdError.getCode();
                            str = cSJAdError.getMsg();
                        } else {
                            str = "splash load fail";
                        }
                        if (i2 == 23) {
                            splashAdListener.onTimeout();
                        } else {
                            splashAdListener.onError(i2, str);
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
                        int i2 = -1;
                        if (cSJAdError != null) {
                            i2 = cSJAdError.getCode();
                            str = cSJAdError.getMsg();
                        } else {
                            str = "splash render fail";
                        }
                        if (i2 == 23) {
                            splashAdListener.onTimeout();
                        } else {
                            splashAdListener.onError(i2, str);
                        }
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.TTAdNative.CSJSplashAdListener
                public void onSplashRenderSuccess(CSJSplashAd cSJSplashAd) {
                    if (splashAdListener == null) {
                        return;
                    }
                    splashAdListener.onSplashAdLoad(C6365ok.this.m36499ok(cSJSplashAd));
                }
            }, i);
        }

        /* renamed from: ok */
        public TTSplashAd m36499ok(final CSJSplashAd cSJSplashAd) {
            if (cSJSplashAd == null) {
                return null;
            }
            final TTSplashAd.AdInteractionListener[] adInteractionListenerArr = new TTSplashAd.AdInteractionListener[1];
            return new TTSplashAd() { // from class: com.bytedance.sdk.openadsdk.bl.ok.ok.ok.3
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
                public void loss(Double d, String str, String str2) {
                    cSJSplashAd.loss(d, str, str2);
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
                public void setPrice(Double d) {
                    cSJSplashAd.setPrice(d);
                }

                @Override // com.bytedance.sdk.openadsdk.TTSplashAd
                public void setSplashCardListener(final ISplashCardListener iSplashCardListener) {
                    if (iSplashCardListener == null) {
                        return;
                    }
                    cSJSplashAd.setSplashCardListener(new CSJSplashAd.SplashCardListener() { // from class: com.bytedance.sdk.openadsdk.bl.ok.ok.ok.3.3
                        @Override // com.bytedance.sdk.openadsdk.CSJSplashAd.SplashCardListener
                        public void onSplashCardClick() {
                            C63683 c63683 = C63683.this;
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
                    cSJSplashAd.setSplashClickEyeListener(new CSJSplashAd.SplashClickEyeListener() { // from class: com.bytedance.sdk.openadsdk.bl.ok.ok.ok.3.2
                        @Override // com.bytedance.sdk.openadsdk.CSJSplashAd.SplashClickEyeListener
                        public void onSplashClickEyeClick() {
                            C63683 c63683 = C63683.this;
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
                    cSJSplashAd2.setSplashAdListener(new CSJSplashAd.SplashAdListener() { // from class: com.bytedance.sdk.openadsdk.bl.ok.ok.ok.3.1
                        @Override // com.bytedance.sdk.openadsdk.CSJSplashAd.SplashAdListener
                        public void onSplashAdClick(CSJSplashAd cSJSplashAd3) {
                            if (cSJSplashAd3 == null) {
                                adInteractionListener.onAdClicked(null, -1);
                            } else {
                                adInteractionListener.onAdClicked(cSJSplashAd3.getSplashView(), cSJSplashAd3.getInteractionType());
                            }
                        }

                        @Override // com.bytedance.sdk.openadsdk.CSJSplashAd.SplashAdListener
                        public void onSplashAdClose(CSJSplashAd cSJSplashAd3, int i) {
                            if (i == 1) {
                                adInteractionListener.onAdSkip();
                            } else if (i == 2 || i == 4) {
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
                public void startClickEye(boolean z) {
                    cSJSplashAd.startClickEye();
                }

                @Override // com.bytedance.sdk.openadsdk.TTClientBidding
                public void win(Double d) {
                    cSJSplashAd.win(d);
                }

                @Override // com.bytedance.sdk.openadsdk.TTSplashAd
                public void startClickEye() {
                    cSJSplashAd.startClickEye();
                }
            };
        }
    }

    /* renamed from: a */
    public abstract void mo36514a(ValueSet valueSet, Bridge bridge);

    /* renamed from: bl */
    public abstract void mo36513bl(ValueSet valueSet, Bridge bridge);

    /* renamed from: h */
    public abstract void mo36512h(ValueSet valueSet, Bridge bridge);

    /* renamed from: kf */
    public abstract void mo36511kf(ValueSet valueSet, Bridge bridge);

    /* renamed from: n */
    public abstract void mo36510n(ValueSet valueSet, Bridge bridge);

    /* renamed from: ok */
    public abstract Pair<Integer, String> mo36506ok(Exception exc);

    /* renamed from: ok */
    public TTAdNative m36509ok() {
        return new C6365ok(this);
    }

    /* renamed from: ok */
    public abstract void mo36508ok(ValueSet valueSet, Bridge bridge);

    /* renamed from: ok */
    public abstract void mo36507ok(ValueSet valueSet, Bridge bridge, int i);

    /* renamed from: p */
    public abstract void mo36505p(ValueSet valueSet, Bridge bridge);

    /* renamed from: q */
    public abstract void mo36504q(ValueSet valueSet, Bridge bridge);

    /* renamed from: s */
    public abstract void mo36503s(ValueSet valueSet, Bridge bridge);
}

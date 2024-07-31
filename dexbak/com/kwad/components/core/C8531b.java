package com.kwad.components.core;

import android.app.Activity;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.kwad.components.p208ad.p210b.InterfaceC7340a;
import com.kwad.components.p208ad.p210b.InterfaceC7344b;
import com.kwad.components.p208ad.p210b.InterfaceC7345c;
import com.kwad.components.p208ad.p210b.InterfaceC7346d;
import com.kwad.components.p208ad.p210b.InterfaceC7347e;
import com.kwad.components.p208ad.p210b.InterfaceC7348f;
import com.kwad.components.p208ad.p210b.InterfaceC7349g;
import com.kwad.components.p208ad.p210b.InterfaceC7350h;
import com.kwad.components.p208ad.p220e.C7414a;
import com.kwad.sdk.api.KsDrawAd;
import com.kwad.sdk.api.KsExitInstallListener;
import com.kwad.sdk.api.KsFeedAd;
import com.kwad.sdk.api.KsFullScreenVideoAd;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsNativeAd;
import com.kwad.sdk.api.KsRewardVideoAd;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.KsSplashScreenAd;
import com.kwad.sdk.components.C9861c;
import com.kwad.sdk.core.network.C10419e;
import com.kwad.sdk.p439j.C10819a;
import com.kwad.sdk.service.ServiceProvider;
import java.util.List;

/* renamed from: com.kwad.components.core.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8531b implements KsLoadManager {
    @Override // com.kwad.sdk.api.KsLoadManager
    public final String getBidRequestToken(KsScene ksScene) {
        InterfaceC7340a interfaceC7340a = (InterfaceC7340a) C9861c.m27501f(InterfaceC7340a.class);
        return interfaceC7340a != null ? interfaceC7340a.getBidRequestToken(ksScene) : "";
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public final String getBidRequestTokenV2(KsScene ksScene) {
        InterfaceC7340a interfaceC7340a = (InterfaceC7340a) C9861c.m27501f(InterfaceC7340a.class);
        return interfaceC7340a != null ? interfaceC7340a.getBidRequestTokenV2(ksScene) : "";
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public final void loadConfigFeedAd(KsScene ksScene, @NonNull final KsLoadManager.FeedAdListener feedAdListener) {
        C10819a.m24739ak("feed", "request");
        InterfaceC7345c interfaceC7345c = (InterfaceC7345c) C9861c.m27501f(InterfaceC7345c.class);
        if (interfaceC7345c != null) {
            interfaceC7345c.loadConfigFeedAd(ksScene, new KsLoadManager.FeedAdListener() { // from class: com.kwad.components.core.b.4
                @Override // com.kwad.sdk.api.KsLoadManager.FeedAdListener
                public final void onError(int i, String str) {
                    feedAdListener.onError(i, str);
                }

                @Override // com.kwad.sdk.api.KsLoadManager.FeedAdListener
                public final void onFeedAdLoad(@Nullable List<KsFeedAd> list) {
                    feedAdListener.onFeedAdLoad(list);
                }
            });
            C10819a.m24738al("feed", "request");
        } else if (C7414a.f25415md.booleanValue()) {
            C10419e c10419e = C10419e.avv;
            feedAdListener.onError(c10419e.errorCode, c10419e.msg);
        }
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public final void loadDrawAd(KsScene ksScene, @NonNull final KsLoadManager.DrawAdListener drawAdListener) {
        C10819a.m24739ak(MediationConstant.RIT_TYPE_DRAW, "request");
        InterfaceC7344b interfaceC7344b = (InterfaceC7344b) C9861c.m27501f(InterfaceC7344b.class);
        if (interfaceC7344b != null) {
            interfaceC7344b.loadDrawAd(ksScene, new KsLoadManager.DrawAdListener() { // from class: com.kwad.components.core.b.5
                @Override // com.kwad.sdk.api.KsLoadManager.DrawAdListener
                public final void onDrawAdLoad(@Nullable List<KsDrawAd> list) {
                    drawAdListener.onDrawAdLoad(list);
                }

                @Override // com.kwad.sdk.api.KsLoadManager.DrawAdListener
                public final void onError(int i, String str) {
                    drawAdListener.onError(i, str);
                }
            });
            C10819a.m24738al(MediationConstant.RIT_TYPE_DRAW, "request");
        } else if (C7414a.f25415md.booleanValue()) {
            C10419e c10419e = C10419e.avv;
            drawAdListener.onError(c10419e.errorCode, c10419e.msg);
        }
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public final void loadFeedAd(KsScene ksScene, @NonNull final KsLoadManager.FeedAdListener feedAdListener) {
        C10819a.m24739ak("feed", "request");
        InterfaceC7345c interfaceC7345c = (InterfaceC7345c) C9861c.m27501f(InterfaceC7345c.class);
        if (interfaceC7345c != null) {
            interfaceC7345c.loadFeedAd(ksScene, new KsLoadManager.FeedAdListener() { // from class: com.kwad.components.core.b.3
                @Override // com.kwad.sdk.api.KsLoadManager.FeedAdListener
                public final void onError(int i, String str) {
                    feedAdListener.onError(i, str);
                }

                @Override // com.kwad.sdk.api.KsLoadManager.FeedAdListener
                public final void onFeedAdLoad(@Nullable List<KsFeedAd> list) {
                    feedAdListener.onFeedAdLoad(list);
                }
            });
            C10819a.m24738al("feed", "request");
        } else if (C7414a.f25415md.booleanValue()) {
            C10419e c10419e = C10419e.avv;
            feedAdListener.onError(c10419e.errorCode, c10419e.msg);
        }
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public final void loadFullScreenVideoAd(KsScene ksScene, @NonNull final KsLoadManager.FullScreenVideoAdListener fullScreenVideoAdListener) {
        C10819a.m24739ak("fullscreen", "request");
        InterfaceC7346d interfaceC7346d = (InterfaceC7346d) C9861c.m27501f(InterfaceC7346d.class);
        if (interfaceC7346d != null) {
            interfaceC7346d.loadFullScreenVideoAd(ksScene, new KsLoadManager.FullScreenVideoAdListener() { // from class: com.kwad.components.core.b.1
                @Override // com.kwad.sdk.api.KsLoadManager.FullScreenVideoAdListener
                public final void onError(int i, String str) {
                    fullScreenVideoAdListener.onError(i, str);
                }

                @Override // com.kwad.sdk.api.KsLoadManager.FullScreenVideoAdListener
                public final void onFullScreenVideoAdLoad(@Nullable List<KsFullScreenVideoAd> list) {
                    fullScreenVideoAdListener.onFullScreenVideoAdLoad(list);
                }

                @Override // com.kwad.sdk.api.KsLoadManager.FullScreenVideoAdListener
                public final void onFullScreenVideoResult(@Nullable List<KsFullScreenVideoAd> list) {
                    fullScreenVideoAdListener.onFullScreenVideoResult(list);
                }
            });
            C10819a.m24738al("fullscreen", "request");
        } else if (C7414a.f25415md.booleanValue()) {
            C10419e c10419e = C10419e.avv;
            fullScreenVideoAdListener.onError(c10419e.errorCode, c10419e.msg);
        }
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public final void loadInterstitialAd(@NonNull KsScene ksScene, @NonNull final KsLoadManager.InterstitialAdListener interstitialAdListener) {
        C10819a.m24739ak(MediationConstant.RIT_TYPE_INTERSTITIAL, "request");
        InterfaceC7347e interfaceC7347e = (InterfaceC7347e) C9861c.m27501f(InterfaceC7347e.class);
        if (interfaceC7347e != null) {
            interfaceC7347e.loadInterstitialAd(ksScene, new KsLoadManager.InterstitialAdListener() { // from class: com.kwad.components.core.b.8
                @Override // com.kwad.sdk.api.KsLoadManager.InterstitialAdListener
                public final void onError(int i, String str) {
                    interstitialAdListener.onError(i, str);
                }

                @Override // com.kwad.sdk.api.KsLoadManager.InterstitialAdListener
                public final void onInterstitialAdLoad(@Nullable List<KsInterstitialAd> list) {
                    interstitialAdListener.onInterstitialAdLoad(list);
                }

                @Override // com.kwad.sdk.api.KsLoadManager.InterstitialAdListener
                public final void onRequestResult(int i) {
                    interstitialAdListener.onRequestResult(i);
                }
            });
            C10819a.m24738al(MediationConstant.RIT_TYPE_INTERSTITIAL, "request");
        } else if (C7414a.f25415md.booleanValue()) {
            C10419e c10419e = C10419e.avv;
            interstitialAdListener.onError(c10419e.errorCode, c10419e.msg);
        }
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public final void loadNativeAd(KsScene ksScene, @NonNull final KsLoadManager.NativeAdListener nativeAdListener) {
        C10819a.m24739ak("native", "request");
        InterfaceC7348f interfaceC7348f = (InterfaceC7348f) C9861c.m27501f(InterfaceC7348f.class);
        if (interfaceC7348f != null) {
            interfaceC7348f.loadNativeAd(ksScene, new KsLoadManager.NativeAdListener() { // from class: com.kwad.components.core.b.6
                @Override // com.kwad.sdk.api.KsLoadManager.NativeAdListener
                public final void onError(int i, String str) {
                    nativeAdListener.onError(i, str);
                }

                @Override // com.kwad.sdk.api.KsLoadManager.NativeAdListener
                public final void onNativeAdLoad(@Nullable List<KsNativeAd> list) {
                    nativeAdListener.onNativeAdLoad(list);
                }
            });
            C10819a.m24738al("native", "request");
        } else if (C7414a.f25415md.booleanValue()) {
            C10419e c10419e = C10419e.avv;
            nativeAdListener.onError(c10419e.errorCode, c10419e.msg);
        }
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public final void loadRewardVideoAd(KsScene ksScene, @NonNull final KsLoadManager.RewardVideoAdListener rewardVideoAdListener) {
        C10819a.m24739ak("reward", "request");
        InterfaceC7349g interfaceC7349g = (InterfaceC7349g) C9861c.m27501f(InterfaceC7349g.class);
        if (interfaceC7349g != null) {
            interfaceC7349g.loadRewardVideoAd(ksScene, new KsLoadManager.RewardVideoAdListener() { // from class: com.kwad.components.core.b.2
                @Override // com.kwad.sdk.api.KsLoadManager.RewardVideoAdListener
                public final void onError(int i, String str) {
                    rewardVideoAdListener.onError(i, str);
                }

                @Override // com.kwad.sdk.api.KsLoadManager.RewardVideoAdListener
                public final void onRewardVideoAdLoad(@Nullable List<KsRewardVideoAd> list) {
                    rewardVideoAdListener.onRewardVideoAdLoad(list);
                }

                @Override // com.kwad.sdk.api.KsLoadManager.RewardVideoAdListener
                public final void onRewardVideoResult(@Nullable List<KsRewardVideoAd> list) {
                    rewardVideoAdListener.onRewardVideoResult(list);
                }
            });
        } else if (C7414a.f25415md.booleanValue()) {
            C10419e c10419e = C10419e.avv;
            rewardVideoAdListener.onError(c10419e.errorCode, c10419e.msg);
        }
        C10819a.m24738al("reward", "request");
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public final void loadSplashScreenAd(@NonNull KsScene ksScene, @NonNull final KsLoadManager.SplashScreenAdListener splashScreenAdListener) {
        try {
            C10819a.m24739ak(MediationConstant.RIT_TYPE_SPLASH, "request");
            InterfaceC7350h interfaceC7350h = (InterfaceC7350h) C9861c.m27501f(InterfaceC7350h.class);
            if (interfaceC7350h != null) {
                interfaceC7350h.loadSplashScreenAd(ksScene, new KsLoadManager.SplashScreenAdListener() { // from class: com.kwad.components.core.b.7
                    @Override // com.kwad.sdk.api.KsLoadManager.SplashScreenAdListener
                    public final void onError(int i, String str) {
                        splashScreenAdListener.onError(i, str);
                    }

                    @Override // com.kwad.sdk.api.KsLoadManager.SplashScreenAdListener
                    public final void onRequestResult(int i) {
                        splashScreenAdListener.onRequestResult(i);
                    }

                    @Override // com.kwad.sdk.api.KsLoadManager.SplashScreenAdListener
                    public final void onSplashScreenAdLoad(@Nullable KsSplashScreenAd ksSplashScreenAd) {
                        splashScreenAdListener.onSplashScreenAdLoad(ksSplashScreenAd);
                    }
                });
                C10819a.m24738al(MediationConstant.RIT_TYPE_SPLASH, "request");
            } else if (C7414a.f25415md.booleanValue()) {
                C10419e c10419e = C10419e.avv;
                splashScreenAdListener.onError(c10419e.errorCode, c10419e.msg);
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
            C10419e c10419e2 = C10419e.avD;
            splashScreenAdListener.onError(c10419e2.errorCode, c10419e2.msg);
        }
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public final boolean showInstallDialog(Activity activity, KsExitInstallListener ksExitInstallListener) {
        InterfaceC7340a interfaceC7340a = (InterfaceC7340a) C9861c.m27501f(InterfaceC7340a.class);
        if (interfaceC7340a != null) {
            return interfaceC7340a.showInstallDialog(activity, ksExitInstallListener);
        }
        return false;
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public final void loadNativeAd(String str, @NonNull KsLoadManager.NativeAdListener nativeAdListener) {
        InterfaceC7348f interfaceC7348f = (InterfaceC7348f) C9861c.m27501f(InterfaceC7348f.class);
        if (interfaceC7348f != null) {
            interfaceC7348f.loadNativeAd(str, nativeAdListener);
        } else if (C7414a.f25415md.booleanValue()) {
            C10419e c10419e = C10419e.avv;
            nativeAdListener.onError(c10419e.errorCode, c10419e.msg);
        }
    }
}

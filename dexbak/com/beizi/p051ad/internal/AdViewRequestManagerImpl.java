package com.beizi.p051ad.internal;

import android.app.Activity;
import android.util.Log;
import com.beizi.p051ad.C2750R;
import com.beizi.p051ad.NativeAdResponse;
import com.beizi.p051ad.internal.network.AdRequestImpl;
import com.beizi.p051ad.internal.network.AdResponse;
import com.beizi.p051ad.internal.network.ServerResponse;
import com.beizi.p051ad.internal.p057a.MediationAd;
import com.beizi.p051ad.internal.p057a.MediationAdViewController;
import com.beizi.p051ad.internal.p057a.MediationBannerAdViewController;
import com.beizi.p051ad.internal.p057a.MediationInterstitialAdViewController;
import com.beizi.p051ad.internal.p057a.MediationSplashAdViewController;
import com.beizi.p051ad.internal.utilities.HaoboLog;
import com.beizi.p051ad.internal.view.AdViewImpl;
import com.beizi.p051ad.internal.view.AdWebView;
import com.beizi.p051ad.internal.view.BannerAdViewImpl;
import com.beizi.p051ad.internal.view.Displayable;
import com.beizi.p051ad.lance.p062a.BeiZiExecutor;
import com.beizi.p051ad.p055b.MediationAdRequest;
import java.lang.ref.SoftReference;
import java.util.LinkedList;
import java.util.concurrent.RejectedExecutionException;

/* renamed from: com.beizi.ad.internal.g */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
class AdViewRequestManagerImpl extends RequestManager {

    /* renamed from: a */
    private final SoftReference<AdViewImpl> f10107a;

    /* renamed from: b */
    private MediationAdViewController f10108b;

    /* renamed from: c */
    private AdRequestImpl f10109c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AdViewRequestManagerImpl(AdViewImpl adViewImpl) {
        this.f10107a = new SoftReference<>(adViewImpl);
    }

    @Override // com.beizi.p051ad.internal.AdRequestDelegate
    /* renamed from: c */
    public AdParameters mo49370c() {
        AdViewImpl adViewImpl = this.f10107a.get();
        if (adViewImpl != null) {
            return adViewImpl.getAdParameters();
        }
        return null;
    }

    @Override // com.beizi.p051ad.internal.AdRequestDelegate
    /* renamed from: d */
    public MediationAdRequest mo49369d() {
        AdRequestImpl.C2918a m49493f = m49493f();
        if (m49493f != null) {
            return m49493f.m49320e();
        }
        return null;
    }

    @Override // com.beizi.p051ad.internal.RequestManager
    /* renamed from: e */
    public void mo49368e() {
        AdRequestImpl adRequestImpl = this.f10109c;
        if (adRequestImpl != null) {
            adRequestImpl.cancel(true);
            this.f10109c = null;
        }
        m49459a((LinkedList<MediationAd>) null);
        MediationAdViewController mediationAdViewController = this.f10108b;
        if (mediationAdViewController != null) {
            mediationAdViewController.m49769a(true);
            this.f10108b = null;
        }
    }

    /* renamed from: f */
    protected AdRequestImpl.C2918a m49493f() {
        if (this.f10107a.get() != null) {
            return this.f10107a.get().getAdRequest();
        }
        return null;
    }

    @Override // com.beizi.p051ad.internal.AdRequestDelegate
    /* renamed from: a */
    public void mo49374a() {
        if (m49493f() == null) {
            HaoboLog.m49290e(HaoboLog.baseLogTag, "Before execute request manager, you should set ad request!");
            return;
        }
        this.f10109c = new AdRequestImpl(m49493f());
        m49457g();
        try {
            this.f10109c.m49345a(this);
            this.f10109c.executeOnExecutor(BeiZiExecutor.m49087b().m49086c(), new Void[0]);
            AdViewImpl adViewImpl = this.f10107a.get();
            if (adViewImpl != null) {
                adViewImpl.getAdDispatcher().mo49211e();
            }
        } catch (IllegalStateException e) {
            Log.d("lance", "ignored:" + e.getMessage());
        } catch (RejectedExecutionException e2) {
            String str = HaoboLog.baseLogTag;
            HaoboLog.m49290e(str, "Concurrent Thread Exception while firing new ad request: " + e2.getMessage());
        }
    }

    @Override // com.beizi.p051ad.internal.AdRequestDelegate
    /* renamed from: a */
    public void mo49373a(int i) {
        m49456h();
        AdViewImpl adViewImpl = this.f10107a.get();
        if (adViewImpl != null) {
            adViewImpl.getAdDispatcher().mo49221a(i);
        }
    }

    @Override // com.beizi.p051ad.internal.AdRequestDelegate
    /* renamed from: a */
    public void mo49372a(final ServerResponse serverResponse) {
        final AdViewImpl adViewImpl = this.f10107a.get();
        if (adViewImpl != null) {
            adViewImpl.getMyHandler().post(new Runnable() { // from class: com.beizi.ad.internal.g.1
                @Override // java.lang.Runnable
                public void run() {
                    ServerResponse serverResponse2;
                    ServerResponse serverResponse3 = serverResponse;
                    boolean z = false;
                    boolean z2 = serverResponse3 != null && serverResponse3.containsAds();
                    if (AdViewRequestManagerImpl.this.mo49458b() != null && !AdViewRequestManagerImpl.this.mo49458b().isEmpty()) {
                        z = true;
                    }
                    Log.d("lance", z2 + "=====" + z);
                    if (!z2 && !z) {
                        HaoboLog.m49284w(HaoboLog.httpRespLogTag, HaoboLog.getString(C2750R.C2755string.response_no_ads));
                        adViewImpl.getAdDispatcher().mo49221a(3);
                        return;
                    }
                    Log.d("lance", "getMediaType:" + adViewImpl.getMediaType());
                    EnumC2888k mediaType = adViewImpl.getMediaType();
                    EnumC2888k enumC2888k = EnumC2888k.BANNER;
                    if (mediaType.equals(enumC2888k)) {
                        ((BannerAdViewImpl) adViewImpl).resetContainerIfNeeded();
                    }
                    if (z2) {
                        AdViewRequestManagerImpl.this.m49459a(serverResponse.getMediationAds());
                    }
                    if (AdViewRequestManagerImpl.this.mo49458b() != null && !AdViewRequestManagerImpl.this.mo49458b().isEmpty()) {
                        MediationAd m49455i = AdViewRequestManagerImpl.this.m49455i();
                        if (m49455i != null && (serverResponse2 = serverResponse) != null) {
                            m49455i.m49782a(serverResponse2.getExtras());
                        }
                        if (adViewImpl.getMediaType().equals(EnumC2888k.SPLASH)) {
                            AdViewRequestManagerImpl.this.f10108b = MediationSplashAdViewController.m49752a((Activity) adViewImpl.getContext(), AdViewRequestManagerImpl.this, m49455i, adViewImpl.getAdDispatcher(), adViewImpl.getSplashParent(), serverResponse);
                        } else if (adViewImpl.getMediaType().equals(enumC2888k)) {
                            AdViewRequestManagerImpl.this.f10108b = MediationBannerAdViewController.m49759a((Activity) adViewImpl.getContext(), AdViewRequestManagerImpl.this, m49455i, adViewImpl.getAdDispatcher(), serverResponse);
                        } else if (adViewImpl.getMediaType().equals(EnumC2888k.INTERSTITIAL)) {
                            AdViewRequestManagerImpl.this.f10108b = MediationInterstitialAdViewController.m49755a((Activity) adViewImpl.getContext(), AdViewRequestManagerImpl.this, m49455i, adViewImpl.getAdDispatcher(), serverResponse);
                        } else {
                            HaoboLog.m49290e(HaoboLog.baseLogTag, "Request type can not be identified.");
                            adViewImpl.getAdDispatcher().mo49221a(1);
                        }
                    } else if (serverResponse != null) {
                        Log.d("lance", "handleStandardAds");
                        AdViewRequestManagerImpl.this.m49494a(adViewImpl, serverResponse);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m49494a(final AdViewImpl adViewImpl, final ServerResponse serverResponse) {
        try {
            adViewImpl.getAdParameters().m49515a(false);
            final AdWebView adWebView = new AdWebView(adViewImpl);
            if (adViewImpl.getMediaType().equals(EnumC2888k.SPLASH) || adViewImpl.getMediaType().equals(EnumC2888k.BANNER)) {
                adWebView.loadAd(serverResponse);
            }
            adViewImpl.createAdLogo(serverResponse.getAdUrl(), serverResponse.getLogoUrl());
            if (adViewImpl.getMediaType().equals(EnumC2888k.BANNER)) {
                adViewImpl.addBannerCloseBtn();
                BannerAdViewImpl bannerAdViewImpl = (BannerAdViewImpl) adViewImpl;
                if (bannerAdViewImpl.getExpandsToFitScreenWidth()) {
                    bannerAdViewImpl.expandToFitScreenWidth(serverResponse.getWidth(), serverResponse.getHeight(), adWebView);
                }
            }
            adViewImpl.serverResponse = serverResponse;
            m49495a(new AdResponse() { // from class: com.beizi.ad.internal.g.2
                @Override // com.beizi.p051ad.internal.network.AdResponse
                /* renamed from: a */
                public EnumC2888k mo49313a() {
                    return adViewImpl.getMediaType();
                }

                @Override // com.beizi.p051ad.internal.network.AdResponse
                /* renamed from: b */
                public boolean mo49312b() {
                    return false;
                }

                @Override // com.beizi.p051ad.internal.network.AdResponse
                /* renamed from: c */
                public Displayable mo49311c() {
                    if (adViewImpl.getMediaType() != EnumC2888k.INTERSTITIAL && adViewImpl.getMediaType() != EnumC2888k.REWARDEDVIDEO) {
                        return adWebView.getRealDisplayable();
                    }
                    return adWebView;
                }

                @Override // com.beizi.p051ad.internal.network.AdResponse
                /* renamed from: d */
                public NativeAdResponse mo49310d() {
                    return null;
                }

                @Override // com.beizi.p051ad.internal.network.AdResponse
                /* renamed from: e */
                public String mo49309e() {
                    return serverResponse.getAdExtInfo();
                }

                @Override // com.beizi.p051ad.internal.network.AdResponse
                /* renamed from: f */
                public String mo49308f() {
                    return serverResponse.getPrice();
                }

                @Override // com.beizi.p051ad.internal.network.AdResponse
                /* renamed from: g */
                public String mo49307g() {
                    return serverResponse.getAdId();
                }

                @Override // com.beizi.p051ad.internal.network.AdResponse
                /* renamed from: h */
                public void mo49306h() {
                    adWebView.destroy();
                }
            });
        } catch (Exception e) {
            Log.d("lance", "========Exception=========:" + e);
            String str = HaoboLog.baseLogTag;
            HaoboLog.m49290e(str, "Exception initializing the view: " + e.getMessage());
            mo49373a(0);
        }
    }

    /* renamed from: a */
    public void m49495a(AdResponse adResponse) {
        m49456h();
        if (this.f10108b != null) {
            this.f10108b = null;
        }
        AdViewImpl adViewImpl = this.f10107a.get();
        if (adViewImpl != null) {
            adViewImpl.getAdDispatcher().mo49219a(adResponse);
        } else {
            adResponse.mo49306h();
        }
    }
}

package com.beizi.ad.internal;

import android.app.Activity;
import android.util.Log;
import com.beizi.ad.NativeAdResponse;
import com.beizi.ad.R;
import com.beizi.ad.internal.network.ServerResponse;
import com.beizi.ad.internal.network.a;
import com.beizi.ad.internal.utilities.HaoboLog;
import com.beizi.ad.internal.view.AdViewImpl;
import com.beizi.ad.internal.view.AdWebView;
import com.beizi.ad.internal.view.BannerAdViewImpl;
import java.lang.ref.SoftReference;
import java.util.LinkedList;
import java.util.concurrent.RejectedExecutionException;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: AdViewRequestManagerImpl.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
class g extends m {

    /* renamed from: a  reason: collision with root package name */
    private final SoftReference<AdViewImpl> f13785a;

    /* renamed from: b  reason: collision with root package name */
    private com.beizi.ad.internal.a.b f13786b;

    /* renamed from: c  reason: collision with root package name */
    private com.beizi.ad.internal.network.a f13787c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(AdViewImpl adViewImpl) {
        this.f13785a = new SoftReference<>(adViewImpl);
    }

    @Override // com.beizi.ad.internal.f
    public e c() {
        AdViewImpl adViewImpl = this.f13785a.get();
        if (adViewImpl != null) {
            return adViewImpl.getAdParameters();
        }
        return null;
    }

    @Override // com.beizi.ad.internal.f
    public com.beizi.ad.b.a d() {
        a.C0126a f4 = f();
        if (f4 != null) {
            return f4.e();
        }
        return null;
    }

    @Override // com.beizi.ad.internal.m
    public void e() {
        com.beizi.ad.internal.network.a aVar = this.f13787c;
        if (aVar != null) {
            aVar.cancel(true);
            this.f13787c = null;
        }
        a((LinkedList<com.beizi.ad.internal.a.a>) null);
        com.beizi.ad.internal.a.b bVar = this.f13786b;
        if (bVar != null) {
            bVar.a(true);
            this.f13786b = null;
        }
    }

    protected a.C0126a f() {
        if (this.f13785a.get() != null) {
            return this.f13785a.get().getAdRequest();
        }
        return null;
    }

    @Override // com.beizi.ad.internal.f
    public void a() {
        if (f() == null) {
            HaoboLog.e(HaoboLog.baseLogTag, "Before execute request manager, you should set ad request!");
            return;
        }
        this.f13787c = new com.beizi.ad.internal.network.a(f());
        g();
        try {
            this.f13787c.a(this);
            this.f13787c.executeOnExecutor(com.beizi.ad.lance.a.c.b().c(), new Void[0]);
            AdViewImpl adViewImpl = this.f13785a.get();
            if (adViewImpl != null) {
                adViewImpl.getAdDispatcher().e();
            }
        } catch (IllegalStateException e4) {
            Log.d("lance", "ignored:" + e4.getMessage());
        } catch (RejectedExecutionException e5) {
            String str = HaoboLog.baseLogTag;
            HaoboLog.e(str, "Concurrent Thread Exception while firing new ad request: " + e5.getMessage());
        }
    }

    @Override // com.beizi.ad.internal.f
    public void a(int i4) {
        h();
        AdViewImpl adViewImpl = this.f13785a.get();
        if (adViewImpl != null) {
            adViewImpl.getAdDispatcher().a(i4);
        }
    }

    @Override // com.beizi.ad.internal.f
    public void a(final ServerResponse serverResponse) {
        final AdViewImpl adViewImpl = this.f13785a.get();
        if (adViewImpl != null) {
            adViewImpl.getMyHandler().post(new Runnable() { // from class: com.beizi.ad.internal.g.1
                @Override // java.lang.Runnable
                public void run() {
                    ServerResponse serverResponse2;
                    ServerResponse serverResponse3 = serverResponse;
                    boolean z3 = false;
                    boolean z4 = serverResponse3 != null && serverResponse3.containsAds();
                    if (g.this.b() != null && !g.this.b().isEmpty()) {
                        z3 = true;
                    }
                    Log.d("lance", z4 + "=====" + z3);
                    if (!z4 && !z3) {
                        HaoboLog.w(HaoboLog.httpRespLogTag, HaoboLog.getString(R.string.response_no_ads));
                        adViewImpl.getAdDispatcher().a(3);
                        return;
                    }
                    Log.d("lance", "getMediaType:" + adViewImpl.getMediaType());
                    k mediaType = adViewImpl.getMediaType();
                    k kVar = k.BANNER;
                    if (mediaType.equals(kVar)) {
                        ((BannerAdViewImpl) adViewImpl).resetContainerIfNeeded();
                    }
                    if (z4) {
                        g.this.a(serverResponse.getMediationAds());
                    }
                    if (g.this.b() != null && !g.this.b().isEmpty()) {
                        com.beizi.ad.internal.a.a i4 = g.this.i();
                        if (i4 != null && (serverResponse2 = serverResponse) != null) {
                            i4.a(serverResponse2.getExtras());
                        }
                        if (adViewImpl.getMediaType().equals(k.SPLASH)) {
                            g.this.f13786b = com.beizi.ad.internal.a.h.a((Activity) adViewImpl.getContext(), g.this, i4, adViewImpl.getAdDispatcher(), adViewImpl.getSplashParent(), serverResponse);
                        } else if (adViewImpl.getMediaType().equals(kVar)) {
                            g.this.f13786b = com.beizi.ad.internal.a.c.a((Activity) adViewImpl.getContext(), g.this, i4, adViewImpl.getAdDispatcher(), serverResponse);
                        } else if (adViewImpl.getMediaType().equals(k.INTERSTITIAL)) {
                            g.this.f13786b = com.beizi.ad.internal.a.f.a((Activity) adViewImpl.getContext(), g.this, i4, adViewImpl.getAdDispatcher(), serverResponse);
                        } else {
                            HaoboLog.e(HaoboLog.baseLogTag, "Request type can not be identified.");
                            adViewImpl.getAdDispatcher().a(1);
                        }
                    } else if (serverResponse != null) {
                        Log.d("lance", "handleStandardAds");
                        g.this.a(adViewImpl, serverResponse);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final AdViewImpl adViewImpl, final ServerResponse serverResponse) {
        try {
            adViewImpl.getAdParameters().a(false);
            final AdWebView adWebView = new AdWebView(adViewImpl);
            if (adViewImpl.getMediaType().equals(k.SPLASH) || adViewImpl.getMediaType().equals(k.BANNER)) {
                adWebView.loadAd(serverResponse);
            }
            adViewImpl.createAdLogo(serverResponse.getAdUrl(), serverResponse.getLogoUrl());
            if (adViewImpl.getMediaType().equals(k.BANNER)) {
                adViewImpl.addBannerCloseBtn();
                BannerAdViewImpl bannerAdViewImpl = (BannerAdViewImpl) adViewImpl;
                if (bannerAdViewImpl.getExpandsToFitScreenWidth()) {
                    bannerAdViewImpl.expandToFitScreenWidth(serverResponse.getWidth(), serverResponse.getHeight(), adWebView);
                }
            }
            adViewImpl.serverResponse = serverResponse;
            a(new com.beizi.ad.internal.network.b() { // from class: com.beizi.ad.internal.g.2
                @Override // com.beizi.ad.internal.network.b
                public k a() {
                    return adViewImpl.getMediaType();
                }

                @Override // com.beizi.ad.internal.network.b
                public boolean b() {
                    return false;
                }

                @Override // com.beizi.ad.internal.network.b
                public com.beizi.ad.internal.view.c c() {
                    if (adViewImpl.getMediaType() != k.INTERSTITIAL && adViewImpl.getMediaType() != k.REWARDEDVIDEO) {
                        return adWebView.getRealDisplayable();
                    }
                    return adWebView;
                }

                @Override // com.beizi.ad.internal.network.b
                public NativeAdResponse d() {
                    return null;
                }

                @Override // com.beizi.ad.internal.network.b
                public String e() {
                    return serverResponse.getAdExtInfo();
                }

                @Override // com.beizi.ad.internal.network.b
                public String f() {
                    return serverResponse.getPrice();
                }

                @Override // com.beizi.ad.internal.network.b
                public String g() {
                    return serverResponse.getAdId();
                }

                @Override // com.beizi.ad.internal.network.b
                public void h() {
                    adWebView.destroy();
                }

                @Override // com.beizi.ad.internal.network.b
                public boolean i() {
                    return serverResponse.isDownloadApp();
                }
            });
        } catch (Exception e4) {
            Log.d("lance", "========Exception=========:" + e4);
            String str = HaoboLog.baseLogTag;
            HaoboLog.e(str, "Exception initializing the view: " + e4.getMessage());
            a(0);
        }
    }

    public void a(com.beizi.ad.internal.network.b bVar) {
        h();
        if (this.f13786b != null) {
            this.f13786b = null;
        }
        AdViewImpl adViewImpl = this.f13785a.get();
        if (adViewImpl != null) {
            adViewImpl.getAdDispatcher().a(bVar);
        } else {
            bVar.h();
        }
    }
}

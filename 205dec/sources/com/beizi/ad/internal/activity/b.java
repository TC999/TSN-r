package com.beizi.ad.internal.activity;

import android.app.Activity;
import android.content.MutableContextWrapper;
import android.os.Build;
import android.util.Log;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.FrameLayout;
import com.beizi.ad.AdActivity;
import com.beizi.ad.R;
import com.beizi.ad.internal.h;
import com.beizi.ad.internal.utilities.HaoboLog;
import com.beizi.ad.internal.utilities.ViewUtil;
import com.beizi.ad.internal.video.AdVideoView;
import com.beizi.ad.internal.view.AdWebView;
import com.beizi.ad.internal.view.InterstitialAdViewImpl;
import com.beizi.ad.internal.view.e;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: InterstitialAdActivity.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class b implements AdActivity.a {

    /* renamed from: a  reason: collision with root package name */
    private Activity f13668a;

    /* renamed from: b  reason: collision with root package name */
    private AdWebView f13669b;

    /* renamed from: c  reason: collision with root package name */
    private com.beizi.ad.internal.view.c f13670c;

    /* renamed from: d  reason: collision with root package name */
    private FrameLayout f13671d;

    /* renamed from: e  reason: collision with root package name */
    private long f13672e;

    /* renamed from: f  reason: collision with root package name */
    private InterstitialAdViewImpl f13673f;

    public b(Activity activity) {
        this.f13668a = activity;
    }

    private void h() {
        if (this.f13668a != null) {
            InterstitialAdViewImpl interstitialAdViewImpl = this.f13673f;
            if (interstitialAdViewImpl != null && interstitialAdViewImpl.getAdDispatcher() != null) {
                this.f13673f.getAdDispatcher().b();
            }
            this.f13668a.finish();
        }
    }

    @Override // com.beizi.ad.AdActivity.a
    public void a() {
        InterstitialAdViewImpl interstitialAdViewImpl = InterstitialAdViewImpl.INTERSTITIALADVIEW_TO_USE;
        if (interstitialAdViewImpl == null || interstitialAdViewImpl.getAdQueue().peek() == null || !(InterstitialAdViewImpl.INTERSTITIALADVIEW_TO_USE.getAdQueue().peek().d() instanceof AdWebView)) {
            return;
        }
        this.f13668a.setTheme(R.style.BeiZiDialogStyle);
        AdWebView adWebView = (AdWebView) InterstitialAdViewImpl.INTERSTITIALADVIEW_TO_USE.getAdQueue().peek().d();
        adWebView.getSettings().setLoadsImagesAutomatically(true);
        if (adWebView.isVideoFullScreen()) {
            this.f13668a.setTheme(R.style.BeiZiTheme_Transparent);
            this.f13668a.requestWindowFeature(1);
            this.f13668a.getWindow().setFlags(1024, 1024);
        }
        this.f13671d = new FrameLayout(this.f13668a);
        this.f13671d.setLayoutParams(new FrameLayout.LayoutParams(-1, -1, 17));
        this.f13668a.setContentView(this.f13671d);
        try {
            this.f13672e = this.f13668a.getIntent().getLongExtra("TIME", System.currentTimeMillis());
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        a(InterstitialAdViewImpl.INTERSTITIALADVIEW_TO_USE);
    }

    @Override // com.beizi.ad.AdActivity.a
    public void b() {
        InterstitialAdViewImpl interstitialAdViewImpl = this.f13673f;
        if (interstitialAdViewImpl == null || interstitialAdViewImpl.getAdDispatcher() == null || this.f13673f.isRewardedVideo() || this.f13668a == null) {
            return;
        }
        this.f13673f.getAdDispatcher().b();
        this.f13668a.finish();
    }

    @Override // com.beizi.ad.AdActivity.a
    public void c() {
        AdWebView adWebView = this.f13669b;
        if (adWebView != null) {
            ViewUtil.removeChildFromParent(adWebView);
            this.f13669b.destroy();
            AdVideoView adVideoView = this.f13669b.mAdVideoView;
            if (adVideoView != null) {
                adVideoView.destroy();
            }
        }
        InterstitialAdViewImpl interstitialAdViewImpl = this.f13673f;
        if (interstitialAdViewImpl != null) {
            interstitialAdViewImpl.setAdImplementation(null);
        }
        this.f13668a.finish();
    }

    @Override // com.beizi.ad.AdActivity.a
    public void d() {
    }

    @Override // com.beizi.ad.AdActivity.a
    public void e() {
        InterstitialAdViewImpl interstitialAdViewImpl = this.f13673f;
        if (interstitialAdViewImpl == null || !interstitialAdViewImpl.shouldDismissOnClick()) {
            return;
        }
        h();
    }

    @Override // com.beizi.ad.AdActivity.a
    public WebView f() {
        return this.f13669b;
    }

    public void g() {
        com.beizi.ad.internal.view.c realDisplayable;
        com.beizi.ad.internal.view.c cVar;
        AdWebView adWebView = this.f13669b;
        if (adWebView == null || (realDisplayable = adWebView.getRealDisplayable()) == (cVar = this.f13670c)) {
            return;
        }
        this.f13671d.removeView(cVar.getView());
        if (realDisplayable instanceof AdVideoView) {
            this.f13671d.addView(realDisplayable.getView(), new ViewGroup.LayoutParams(-1, -1));
        } else {
            this.f13671d.addView(realDisplayable.getView(), new ViewGroup.LayoutParams(-1, -1));
        }
        this.f13670c = realDisplayable;
        realDisplayable.visible();
    }

    private void a(InterstitialAdViewImpl interstitialAdViewImpl) {
        this.f13673f = interstitialAdViewImpl;
        if (interstitialAdViewImpl == null) {
            return;
        }
        interstitialAdViewImpl.setAdImplementation(this);
        this.f13671d.setBackgroundColor(this.f13673f.getBackgroundColor());
        this.f13671d.removeAllViews();
        if (this.f13673f.getParent() != null) {
            ((ViewGroup) this.f13673f.getParent()).removeAllViews();
        }
        e poll = this.f13673f.getAdQueue().poll();
        while (poll != null && (this.f13672e - poll.a() > 270000 || this.f13672e - poll.a() < 0)) {
            HaoboLog.w(HaoboLog.baseLogTag, HaoboLog.getString(R.string.too_old));
            poll = this.f13673f.getAdQueue().poll();
        }
        if (poll == null || !(poll.d() instanceof AdWebView)) {
            return;
        }
        AdWebView adWebView = (AdWebView) poll.d();
        this.f13669b = adWebView;
        if (adWebView.getContext() instanceof MutableContextWrapper) {
            ((MutableContextWrapper) this.f13669b.getContext()).setBaseContext(this.f13668a);
            AdVideoView adVideoView = this.f13669b.mAdVideoView;
            if (adVideoView != null) {
                ((MutableContextWrapper) adVideoView.getContext()).setBaseContext(this.f13668a);
            }
        }
        if ((this.f13669b.getCreativeWidth() != 1 || this.f13669b.getCreativeHeight() != 1) && this.f13668a.getResources().getConfiguration().orientation != 2) {
            int i4 = 0;
            try {
                i4 = this.f13673f.getAdParameters().b().getApplicationInfo().targetSdkVersion;
            } catch (Exception e4) {
                e4.printStackTrace();
            }
            if (i4 > 26 && Build.VERSION.SDK_INT == 26) {
                Log.d("lance", "Only fullscreen activities can request orientation");
            } else {
                AdActivity.a(this.f13668a, this.f13669b.getOrientation());
            }
        }
        this.f13670c = this.f13669b.getRealDisplayable();
        AdWebView adWebView2 = this.f13669b;
        if (adWebView2.mAdVideoView != null) {
            this.f13671d.addView(adWebView2.getRealDisplayable().getView(), new FrameLayout.LayoutParams(-2, -2, 17));
        } else if (this.f13668a.getRequestedOrientation() == 0) {
            this.f13671d.addView(this.f13669b.getRealDisplayable().getView(), new FrameLayout.LayoutParams((int) (this.f13669b.getCreativeHeight() * h.a().f13809k), (int) (this.f13669b.getCreativeWidth() * h.a().f13810l), 17));
        } else if (this.f13668a.getRequestedOrientation() == 1) {
            this.f13671d.addView(this.f13669b.getRealDisplayable().getView(), new FrameLayout.LayoutParams((int) (this.f13669b.getCreativeWidth() * h.a().f13809k), (int) (this.f13669b.getCreativeHeight() * h.a().f13810l), 17));
        } else {
            this.f13671d.addView(this.f13669b.getRealDisplayable().getView(), new FrameLayout.LayoutParams((int) (this.f13669b.getCreativeWidth() * h.a().f13809k), (int) (this.f13669b.getCreativeHeight() * h.a().f13810l), 17));
        }
        this.f13670c.visible();
    }
}

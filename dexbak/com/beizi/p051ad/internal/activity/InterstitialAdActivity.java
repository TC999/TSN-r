package com.beizi.p051ad.internal.activity;

import android.app.Activity;
import android.content.MutableContextWrapper;
import android.os.Build;
import android.util.Log;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.FrameLayout;
import com.beizi.p051ad.AdActivity;
import com.beizi.p051ad.C2750R;
import com.beizi.p051ad.internal.BeiZiImpl;
import com.beizi.p051ad.internal.utilities.HaoboLog;
import com.beizi.p051ad.internal.utilities.ViewUtil;
import com.beizi.p051ad.internal.video.AdVideoView;
import com.beizi.p051ad.internal.view.AdWebView;
import com.beizi.p051ad.internal.view.Displayable;
import com.beizi.p051ad.internal.view.InterstitialAdQueueEntry;
import com.beizi.p051ad.internal.view.InterstitialAdViewImpl;

/* renamed from: com.beizi.ad.internal.activity.b */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class InterstitialAdActivity implements AdActivity.InterfaceC2741a {

    /* renamed from: a */
    private Activity f9990a;

    /* renamed from: b */
    private AdWebView f9991b;

    /* renamed from: c */
    private Displayable f9992c;

    /* renamed from: d */
    private FrameLayout f9993d;

    /* renamed from: e */
    private long f9994e;

    /* renamed from: f */
    private InterstitialAdViewImpl f9995f;

    public InterstitialAdActivity(Activity activity) {
        this.f9990a = activity;
    }

    /* renamed from: h */
    private void m49657h() {
        if (this.f9990a != null) {
            InterstitialAdViewImpl interstitialAdViewImpl = this.f9995f;
            if (interstitialAdViewImpl != null && interstitialAdViewImpl.getAdDispatcher() != null) {
                this.f9995f.getAdDispatcher().mo49214b();
            }
            this.f9990a.finish();
        }
    }

    @Override // com.beizi.p051ad.AdActivity.InterfaceC2741a
    /* renamed from: a */
    public void mo49656a() {
        InterstitialAdViewImpl interstitialAdViewImpl = InterstitialAdViewImpl.INTERSTITIALADVIEW_TO_USE;
        if (interstitialAdViewImpl == null || interstitialAdViewImpl.getAdQueue().peek() == null || !(InterstitialAdViewImpl.INTERSTITIALADVIEW_TO_USE.getAdQueue().peek().mo49124d() instanceof AdWebView)) {
            return;
        }
        this.f9990a.setTheme(C2750R.C2756style.BeiZiDialogStyle);
        AdWebView adWebView = (AdWebView) InterstitialAdViewImpl.INTERSTITIALADVIEW_TO_USE.getAdQueue().peek().mo49124d();
        adWebView.getSettings().setLoadsImagesAutomatically(true);
        if (adWebView.isVideoFullScreen()) {
            this.f9990a.setTheme(C2750R.C2756style.BeiZiTheme_Transparent);
            this.f9990a.requestWindowFeature(1);
            this.f9990a.getWindow().setFlags(1024, 1024);
        }
        this.f9993d = new FrameLayout(this.f9990a);
        this.f9993d.setLayoutParams(new FrameLayout.LayoutParams(-1, -1, 17));
        this.f9990a.setContentView(this.f9993d);
        try {
            this.f9994e = this.f9990a.getIntent().getLongExtra(InterstitialAdViewImpl.INTENT_KEY_TIME, System.currentTimeMillis());
        } catch (Exception e) {
            e.printStackTrace();
        }
        m49659a(InterstitialAdViewImpl.INTERSTITIALADVIEW_TO_USE);
    }

    @Override // com.beizi.p051ad.AdActivity.InterfaceC2741a
    /* renamed from: b */
    public void mo49655b() {
        InterstitialAdViewImpl interstitialAdViewImpl = this.f9995f;
        if (interstitialAdViewImpl == null || interstitialAdViewImpl.getAdDispatcher() == null || this.f9995f.isRewardedVideo() || this.f9990a == null) {
            return;
        }
        this.f9995f.getAdDispatcher().mo49214b();
        this.f9990a.finish();
    }

    @Override // com.beizi.p051ad.AdActivity.InterfaceC2741a
    /* renamed from: c */
    public void mo49654c() {
        AdWebView adWebView = this.f9991b;
        if (adWebView != null) {
            ViewUtil.removeChildFromParent(adWebView);
            this.f9991b.destroy();
            AdVideoView adVideoView = this.f9991b.mAdVideoView;
            if (adVideoView != null) {
                adVideoView.destroy();
            }
        }
        InterstitialAdViewImpl interstitialAdViewImpl = this.f9995f;
        if (interstitialAdViewImpl != null) {
            interstitialAdViewImpl.setAdImplementation(null);
        }
        this.f9990a.finish();
    }

    @Override // com.beizi.p051ad.AdActivity.InterfaceC2741a
    /* renamed from: d */
    public void mo49653d() {
    }

    @Override // com.beizi.p051ad.AdActivity.InterfaceC2741a
    /* renamed from: e */
    public void mo49652e() {
        InterstitialAdViewImpl interstitialAdViewImpl = this.f9995f;
        if (interstitialAdViewImpl == null || !interstitialAdViewImpl.shouldDismissOnClick()) {
            return;
        }
        m49657h();
    }

    @Override // com.beizi.p051ad.AdActivity.InterfaceC2741a
    /* renamed from: f */
    public WebView mo49651f() {
        return this.f9991b;
    }

    /* renamed from: g */
    public void m49658g() {
        Displayable realDisplayable;
        Displayable displayable;
        AdWebView adWebView = this.f9991b;
        if (adWebView == null || (realDisplayable = adWebView.getRealDisplayable()) == (displayable = this.f9992c)) {
            return;
        }
        this.f9993d.removeView(displayable.getView());
        if (realDisplayable instanceof AdVideoView) {
            this.f9993d.addView(realDisplayable.getView(), new ViewGroup.LayoutParams(-1, -1));
        } else {
            this.f9993d.addView(realDisplayable.getView(), new ViewGroup.LayoutParams(-1, -1));
        }
        this.f9992c = realDisplayable;
        realDisplayable.visible();
    }

    /* renamed from: a */
    private void m49659a(InterstitialAdViewImpl interstitialAdViewImpl) {
        this.f9995f = interstitialAdViewImpl;
        if (interstitialAdViewImpl == null) {
            return;
        }
        interstitialAdViewImpl.setAdImplementation(this);
        this.f9993d.setBackgroundColor(this.f9995f.getBackgroundColor());
        this.f9993d.removeAllViews();
        if (this.f9995f.getParent() != null) {
            ((ViewGroup) this.f9995f.getParent()).removeAllViews();
        }
        InterstitialAdQueueEntry poll = this.f9995f.getAdQueue().poll();
        while (poll != null && (this.f9994e - poll.mo49127a() > InterstitialAdViewImpl.MAX_AGE || this.f9994e - poll.mo49127a() < 0)) {
            HaoboLog.m49284w(HaoboLog.baseLogTag, HaoboLog.getString(C2750R.C2755string.too_old));
            poll = this.f9995f.getAdQueue().poll();
        }
        if (poll == null || !(poll.mo49124d() instanceof AdWebView)) {
            return;
        }
        AdWebView adWebView = (AdWebView) poll.mo49124d();
        this.f9991b = adWebView;
        if (adWebView.getContext() instanceof MutableContextWrapper) {
            ((MutableContextWrapper) this.f9991b.getContext()).setBaseContext(this.f9990a);
            AdVideoView adVideoView = this.f9991b.mAdVideoView;
            if (adVideoView != null) {
                ((MutableContextWrapper) adVideoView.getContext()).setBaseContext(this.f9990a);
            }
        }
        if ((this.f9991b.getCreativeWidth() != 1 || this.f9991b.getCreativeHeight() != 1) && this.f9990a.getResources().getConfiguration().orientation != 2) {
            int i = 0;
            try {
                i = this.f9995f.getAdParameters().m49514b().getApplicationInfo().targetSdkVersion;
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (i > 26 && Build.VERSION.SDK_INT == 26) {
                Log.d("lance", "Only fullscreen activities can request orientation");
            } else {
                AdActivity.m50213a(this.f9990a, this.f9991b.getOrientation());
            }
        }
        this.f9992c = this.f9991b.getRealDisplayable();
        AdWebView adWebView2 = this.f9991b;
        if (adWebView2.mAdVideoView != null) {
            this.f9993d.addView(adWebView2.getRealDisplayable().getView(), new FrameLayout.LayoutParams(-2, -2, 17));
        } else if (this.f9990a.getRequestedOrientation() == 0) {
            this.f9993d.addView(this.f9991b.getRealDisplayable().getView(), new FrameLayout.LayoutParams((int) (this.f9991b.getCreativeHeight() * BeiZiImpl.m49492a().f10140j), (int) (this.f9991b.getCreativeWidth() * BeiZiImpl.m49492a().f10141k), 17));
        } else if (this.f9990a.getRequestedOrientation() == 1) {
            this.f9993d.addView(this.f9991b.getRealDisplayable().getView(), new FrameLayout.LayoutParams((int) (this.f9991b.getCreativeWidth() * BeiZiImpl.m49492a().f10140j), (int) (this.f9991b.getCreativeHeight() * BeiZiImpl.m49492a().f10141k), 17));
        } else {
            this.f9993d.addView(this.f9991b.getRealDisplayable().getView(), new FrameLayout.LayoutParams((int) (this.f9991b.getCreativeWidth() * BeiZiImpl.m49492a().f10140j), (int) (this.f9991b.getCreativeHeight() * BeiZiImpl.m49492a().f10141k), 17));
        }
        this.f9992c.visible();
    }
}

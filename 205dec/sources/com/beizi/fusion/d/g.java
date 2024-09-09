package com.beizi.fusion.d;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import com.beizi.fusion.SplashAd;
import com.beizi.fusion.g.aw;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.work.splash.c;
import com.bytedance.sdk.openadsdk.CSJSplashAd;
import com.stub.StubApp;
import java.lang.ref.SoftReference;
import java.util.List;
import xyz.adscope.amps.common.AMPSConstants;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: ClickEyeManager.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    private static volatile g f14647a;

    /* renamed from: c  reason: collision with root package name */
    private static SplashAd.SplashClickEyeListener f14648c;

    /* renamed from: b  reason: collision with root package name */
    private Context f14649b;

    /* renamed from: d  reason: collision with root package name */
    private boolean f14650d = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: ClickEyeManager.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class a implements CSJSplashAd.SplashClickEyeListener {

        /* renamed from: a  reason: collision with root package name */
        boolean f14655a = true;

        /* renamed from: b  reason: collision with root package name */
        private SoftReference<View> f14656b;

        /* renamed from: c  reason: collision with root package name */
        private SoftReference<CSJSplashAd> f14657c;

        /* renamed from: d  reason: collision with root package name */
        private Context f14658d;

        public a(Context context, View view, CSJSplashAd cSJSplashAd) {
            this.f14656b = new SoftReference<>(view);
            this.f14657c = new SoftReference<>(cSJSplashAd);
            this.f14658d = context;
        }

        @Override // com.bytedance.sdk.openadsdk.CSJSplashAd.SplashClickEyeListener
        public void onSplashClickEyeClick() {
            Log.d("BeiZis", "showCsjSplash ClickEye onSplashClickEyeClick() ");
        }

        @Override // com.bytedance.sdk.openadsdk.CSJSplashAd.SplashClickEyeListener
        public void onSplashClickEyeClose() {
            Log.d("BeiZis", "showCsjSplash ClickEye onSplashClickEyeClose() ");
            SoftReference<View> softReference = this.f14656b;
            if (softReference != null && softReference.get() != null) {
                this.f14656b.get().setVisibility(8);
                aw.a(this.f14656b.get());
                this.f14656b = null;
                this.f14657c = null;
            }
            if (g.f14648c != null && this.f14655a) {
                g.f14648c.onSplashClickEyeAnimationFinish();
                this.f14655a = false;
            }
            com.beizi.fusion.work.splash.c.a(this.f14658d).a();
        }

        @Override // com.bytedance.sdk.openadsdk.CSJSplashAd.SplashClickEyeListener
        public void onSplashClickEyeReadyToShow(CSJSplashAd cSJSplashAd) {
            Log.d("BeiZis", "showCsjSplash ClickEye onSplashClickEyeReadyToShow() ");
        }
    }

    private g() {
    }

    public static g a() {
        if (f14647a == null) {
            synchronized (g.class) {
                if (f14647a == null) {
                    f14647a = new g();
                }
            }
        }
        return f14647a;
    }

    public boolean b() {
        return this.f14650d;
    }

    private View b(final Activity activity) {
        final com.beizi.fusion.work.splash.c a4 = com.beizi.fusion.work.splash.c.a(this.f14649b);
        final CSJSplashAd b4 = a4.b();
        return a4.a((ViewGroup) activity.getWindow().getDecorView(), (ViewGroup) activity.findViewById(16908290), new c.a() { // from class: com.beizi.fusion.d.g.1
            @Override // com.beizi.fusion.work.splash.c.a
            public void a() {
                CSJSplashAd cSJSplashAd = b4;
                if (cSJSplashAd != null) {
                    cSJSplashAd.showSplashClickEyeView((ViewGroup) activity.findViewById(16908290));
                    a4.a();
                }
            }

            @Override // com.beizi.fusion.work.splash.c.a
            public void a(int i4) {
            }
        });
    }

    public void a(SplashAd.SplashClickEyeListener splashClickEyeListener) {
        f14648c = splashClickEyeListener;
    }

    public void a(String str, boolean z3, boolean z4) {
        this.f14650d = z3;
        SplashAd.SplashClickEyeListener splashClickEyeListener = f14648c;
        if (splashClickEyeListener == null || !z4) {
            return;
        }
        splashClickEyeListener.isSupportSplashClickEye(z3);
    }

    public void a(Activity activity, String str) {
        if (activity == null) {
            return;
        }
        Context origApplicationContext = StubApp.getOrigApplicationContext(activity.getApplicationContext());
        this.f14649b = origApplicationContext;
        AdSpacesBean a4 = com.beizi.fusion.c.a.a(origApplicationContext, str, "2");
        if (a4 != null) {
            AdSpacesBean.ComponentBean component = a4.getComponent();
            List<AdSpacesBean.BuyerBean> buyer = a4.getBuyer();
            List<AdSpacesBean.ForwardBean> a5 = com.beizi.fusion.f.b.a(component, buyer, str);
            if (a5.size() > 0) {
                for (int i4 = 0; i4 < a5.size(); i4++) {
                    AdSpacesBean.ForwardBean forwardBean = a5.get(i4);
                    String buyerId = forwardBean.getBuyerId();
                    if (com.beizi.fusion.f.b.a(buyerId, buyer, forwardBean.getBuyerSpaceUuId()) != null && buyerId.equalsIgnoreCase(AMPSConstants.AMPS_CHANNEL_NETWORK_NAME_CSJ)) {
                        a(activity);
                        return;
                    }
                }
            }
        }
    }

    private void a(Activity activity) {
        if (activity == null) {
            return;
        }
        Context origApplicationContext = StubApp.getOrigApplicationContext(activity.getApplicationContext());
        this.f14649b = origApplicationContext;
        com.beizi.fusion.work.splash.c a4 = com.beizi.fusion.work.splash.c.a(origApplicationContext);
        if (!b()) {
            Log.d("BeiZis", "showCsjSplash is not Support Splash Click Eye");
            return;
        }
        View b4 = b(activity);
        CSJSplashAd b5 = a4.b();
        a aVar = new a(this.f14649b, b4, b5);
        if (b5 != null) {
            b5.setSplashClickEyeListener(aVar);
        }
    }
}

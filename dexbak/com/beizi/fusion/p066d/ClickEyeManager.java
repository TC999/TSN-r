package com.beizi.fusion.p066d;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import com.beizi.fusion.SplashAd;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.p065c.ChannelUtil;
import com.beizi.fusion.p071f.AdStrategy;
import com.beizi.fusion.p072g.C3138av;
import com.beizi.fusion.work.splash.CsjClickEyeManager;
import com.bytedance.sdk.openadsdk.CSJSplashAd;
import com.stub.StubApp;
import java.lang.ref.SoftReference;
import java.util.List;

/* renamed from: com.beizi.fusion.d.g */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class ClickEyeManager {

    /* renamed from: a */
    private static volatile ClickEyeManager f11130a;

    /* renamed from: c */
    private static SplashAd.SplashClickEyeListener f11131c;

    /* renamed from: b */
    private Context f11132b;

    /* renamed from: d */
    private boolean f11133d = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ClickEyeManager.java */
    /* renamed from: com.beizi.fusion.d.g$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class C3084a implements CSJSplashAd.SplashClickEyeListener {

        /* renamed from: a */
        boolean f11138a = true;

        /* renamed from: b */
        private SoftReference<View> f11139b;

        /* renamed from: c */
        private SoftReference<CSJSplashAd> f11140c;

        /* renamed from: d */
        private Context f11141d;

        public C3084a(Context context, View view, CSJSplashAd cSJSplashAd) {
            this.f11139b = new SoftReference<>(view);
            this.f11140c = new SoftReference<>(cSJSplashAd);
            this.f11141d = context;
        }

        @Override // com.bytedance.sdk.openadsdk.CSJSplashAd.SplashClickEyeListener
        public void onSplashClickEyeClick() {
            Log.d("BeiZis", "showCsjSplash ClickEye onSplashClickEyeClick() ");
        }

        @Override // com.bytedance.sdk.openadsdk.CSJSplashAd.SplashClickEyeListener
        public void onSplashClickEyeClose() {
            Log.d("BeiZis", "showCsjSplash ClickEye onSplashClickEyeClose() ");
            SoftReference<View> softReference = this.f11139b;
            if (softReference != null && softReference.get() != null) {
                this.f11139b.get().setVisibility(8);
                C3138av.m48302a(this.f11139b.get());
                this.f11139b = null;
                this.f11140c = null;
            }
            if (ClickEyeManager.f11131c != null && this.f11138a) {
                ClickEyeManager.f11131c.onSplashClickEyeAnimationFinish();
                this.f11138a = false;
            }
            CsjClickEyeManager.m46515a(this.f11141d).m46516a();
        }

        @Override // com.bytedance.sdk.openadsdk.CSJSplashAd.SplashClickEyeListener
        public void onSplashClickEyeReadyToShow(CSJSplashAd cSJSplashAd) {
            Log.d("BeiZis", "showCsjSplash ClickEye onSplashClickEyeReadyToShow() ");
        }
    }

    private ClickEyeManager() {
    }

    /* renamed from: a */
    public static ClickEyeManager m48654a() {
        if (f11130a == null) {
            synchronized (ClickEyeManager.class) {
                if (f11130a == null) {
                    f11130a = new ClickEyeManager();
                }
            }
        }
        return f11130a;
    }

    /* renamed from: b */
    public boolean m48649b() {
        return this.f11133d;
    }

    /* renamed from: b */
    private View m48648b(final Activity activity) {
        final CsjClickEyeManager m46515a = CsjClickEyeManager.m46515a(this.f11132b);
        final CSJSplashAd m46510b = m46515a.m46510b();
        return m46515a.m46512a((ViewGroup) activity.getWindow().getDecorView(), (ViewGroup) activity.findViewById(16908290), new CsjClickEyeManager.InterfaceC3447a() { // from class: com.beizi.fusion.d.g.1
            @Override // com.beizi.fusion.work.splash.CsjClickEyeManager.InterfaceC3447a
            /* renamed from: a */
            public void mo46506a() {
                CSJSplashAd cSJSplashAd = m46510b;
                if (cSJSplashAd != null) {
                    cSJSplashAd.showSplashClickEyeView((ViewGroup) activity.findViewById(16908290));
                    m46515a.m46516a();
                }
            }

            @Override // com.beizi.fusion.work.splash.CsjClickEyeManager.InterfaceC3447a
            /* renamed from: a */
            public void mo46505a(int i) {
            }
        });
    }

    /* renamed from: a */
    public void m48651a(SplashAd.SplashClickEyeListener splashClickEyeListener) {
        f11131c = splashClickEyeListener;
    }

    /* renamed from: a */
    public void m48650a(String str, boolean z, boolean z2) {
        this.f11133d = z;
        SplashAd.SplashClickEyeListener splashClickEyeListener = f11131c;
        if (splashClickEyeListener == null || !z2) {
            return;
        }
        splashClickEyeListener.isSupportSplashClickEye(z);
    }

    /* renamed from: a */
    public void m48652a(Activity activity, String str) {
        if (activity == null) {
            return;
        }
        Context origApplicationContext = StubApp.getOrigApplicationContext(activity.getApplicationContext());
        this.f11132b = origApplicationContext;
        AdSpacesBean m48854a = ChannelUtil.m48854a(origApplicationContext, str, "2");
        if (m48854a != null) {
            AdSpacesBean.ComponentBean component = m48854a.getComponent();
            List<AdSpacesBean.BuyerBean> buyer = m48854a.getBuyer();
            List<AdSpacesBean.ForwardBean> m48528a = AdStrategy.m48528a(component, buyer, str);
            if (m48528a.size() > 0) {
                for (int i = 0; i < m48528a.size(); i++) {
                    AdSpacesBean.ForwardBean forwardBean = m48528a.get(i);
                    String buyerId = forwardBean.getBuyerId();
                    if (AdStrategy.m48524a(buyerId, buyer, forwardBean.getBuyerSpaceUuId()) != null && buyerId.equalsIgnoreCase("CSJ")) {
                        m48653a(activity);
                        return;
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private void m48653a(Activity activity) {
        if (activity == null) {
            return;
        }
        Context origApplicationContext = StubApp.getOrigApplicationContext(activity.getApplicationContext());
        this.f11132b = origApplicationContext;
        CsjClickEyeManager m46515a = CsjClickEyeManager.m46515a(origApplicationContext);
        if (!m48649b()) {
            Log.d("BeiZis", "showCsjSplash is not Support Splash Click Eye");
            return;
        }
        View m48648b = m48648b(activity);
        CSJSplashAd m46510b = m46515a.m46510b();
        C3084a c3084a = new C3084a(this.f11132b, m48648b, m46510b);
        if (m46510b != null) {
            m46510b.setSplashClickEyeListener(c3084a);
        }
    }
}

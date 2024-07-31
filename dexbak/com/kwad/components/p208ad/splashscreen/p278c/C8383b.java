package com.kwad.components.p208ad.splashscreen.p278c;

import android.util.DisplayMetrics;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.components.p208ad.splashscreen.p284f.C8486c;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.p430d.p431a.C10751a;
import com.kwad.sdk.utils.AbstractRunnableC11033ay;

/* renamed from: com.kwad.components.ad.splashscreen.c.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8383b extends C8421e {
    private KsLogoView mLogoView;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public void m30850i(ViewGroup viewGroup) {
        if (!C8486c.m30630z(C10487e.m25641dQ(this.f27734Dg.mAdTemplate))) {
            if (C8486c.m30632a(getContext(), this.f27734Dg.mRootContainer.getWidth(), this.f27734Dg.mRootContainer.getHeight())) {
                C8486c.m30631a(findViewById(C9659R.C9662id.ksad_splash_logo_container), -1, 16, 16, -1);
                return;
            }
            return;
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) viewGroup.getLayoutParams();
        layoutParams.gravity = 51;
        viewGroup.setLayoutParams(layoutParams);
        DisplayMetrics displayMetrics = viewGroup.getContext().getResources().getDisplayMetrics();
        double d = displayMetrics.heightPixels;
        double d2 = displayMetrics.widthPixels;
        Double.isNaN(d);
        Double.isNaN(d2);
        if (d / d2 > 1.7777777910232544d) {
            ViewGroup.LayoutParams layoutParams2 = viewGroup.getLayoutParams();
            if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams2;
                marginLayoutParams.leftMargin = C10751a.m24924a(viewGroup.getContext(), 12.0f);
                marginLayoutParams.topMargin = C10751a.m24924a(viewGroup.getContext(), 12.0f);
            }
        }
    }

    @Override // com.kwad.components.p208ad.splashscreen.p278c.C8421e, com.kwad.sdk.mvp.Presenter
    /* renamed from: aj */
    public final void mo24610aj() {
        AdInfo.AdSplashInfo adSplashInfo;
        super.mo24610aj();
        KsLogoView ksLogoView = (KsLogoView) findViewById(C9659R.C9662id.ksad_splash_logo_container);
        this.mLogoView = ksLogoView;
        ksLogoView.post(new AbstractRunnableC11033ay() { // from class: com.kwad.components.ad.splashscreen.c.b.1
            @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
            public final void doTask() {
                C8383b c8383b = C8383b.this;
                c8383b.m30850i(c8383b.mLogoView);
            }
        });
        if (this.f27734Dg.mAdTemplate.adInfoList.isEmpty() || (adSplashInfo = this.f27734Dg.mAdTemplate.adInfoList.get(0).adSplashInfo) == null) {
            return;
        }
        if (adSplashInfo.logoPosition != 0) {
            this.mLogoView.setVisibility(0);
            this.mLogoView.m28912aD(this.f27734Dg.mAdTemplate);
            return;
        }
        this.mLogoView.setVisibility(8);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
    }
}

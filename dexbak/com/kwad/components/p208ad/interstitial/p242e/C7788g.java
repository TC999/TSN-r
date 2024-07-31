package com.kwad.components.p208ad.interstitial.p242e;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.kwad.components.core.widget.C9374e;
import com.kwad.components.p208ad.interstitial.p239b.C7721b;
import com.kwad.components.p208ad.p213d.C7355b;
import com.kwad.components.p208ad.widget.KsPriceView;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdProductInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10487e;

/* renamed from: com.kwad.components.ad.interstitial.e.g */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C7788g extends C7760b {

    /* renamed from: kS */
    private static int f26288kS = 4;

    /* renamed from: jK */
    private C7761c f26289jK;

    /* renamed from: kQ */
    private C7789a f26290kQ = new C7789a();

    /* renamed from: kR */
    private C7790b f26291kR = new C7790b();
    private AdInfo mAdInfo;
    private AdTemplate mAdTemplate;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kwad.components.ad.interstitial.e.g$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C7789a {

        /* renamed from: kT */
        private ImageView f26292kT;

        /* renamed from: kU */
        private TextView f26293kU;

        /* renamed from: kV */
        private TextView f26294kV;

        /* renamed from: kW */
        private KsPriceView f26295kW;

        C7789a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kwad.components.ad.interstitial.e.g$b */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C7790b {
        private String appIconUrl;

        /* renamed from: kX */
        private String f26296kX;

        /* renamed from: kY */
        private CharSequence f26297kY;

        /* renamed from: kZ */
        private String f26298kZ;

        /* renamed from: la */
        private String f26299la;
        private String price;

        C7790b() {
        }

        /* renamed from: a */
        public final void m32376a(CharSequence charSequence) {
            this.f26297kY = charSequence;
        }

        /* renamed from: dA */
        public final String m32375dA() {
            return this.f26299la;
        }

        /* renamed from: dx */
        public final String m32374dx() {
            return this.f26296kX;
        }

        /* renamed from: dy */
        public final CharSequence m32373dy() {
            return this.f26297kY;
        }

        /* renamed from: dz */
        public final String m32372dz() {
            return this.f26298kZ;
        }

        public final String getAppIconUrl() {
            return this.appIconUrl;
        }

        public final String getPrice() {
            return this.price;
        }

        /* renamed from: r */
        public final void m32371r(String str) {
            this.appIconUrl = str;
        }

        /* renamed from: s */
        public final void m32370s(String str) {
            this.f26296kX = str;
        }

        /* renamed from: t */
        public final void m32369t(String str) {
            this.f26298kZ = str;
        }

        /* renamed from: u */
        public final void m32368u(String str) {
            this.price = str;
        }

        /* renamed from: v */
        public final void m32367v(String str) {
            this.f26299la = str;
        }
    }

    /* renamed from: a */
    private void m32387a(C7789a c7789a, C7790b c7790b, AdInfo adInfo, AdTemplate adTemplate) {
        ImageView imageView = c7789a.f26292kT;
        if (!TextUtils.isEmpty(c7790b.getAppIconUrl())) {
            imageView.setVisibility(0);
            if (C10483a.m25881bZ(adInfo) == 2) {
                KSImageLoader.loadCircleIcon(imageView, c7790b.getAppIconUrl(), getContext().getResources().getDrawable(C9659R.C9661drawable.ksad_default_app_icon));
            } else {
                imageView.setImageResource(C9659R.C9661drawable.ksad_default_app_icon);
                KSImageLoader.loadWithRadius(imageView, c7790b.getAppIconUrl(), adTemplate, f26288kS);
            }
        } else {
            imageView.setVisibility(8);
        }
        c7789a.f26293kU.setText(c7790b.m32374dx());
        if (C7721b.m32568cL() && C10483a.m25881bZ(adInfo) == 3) {
            c7789a.f26295kW.m30441d(c7790b.getPrice(), c7790b.m32372dz(), true);
            c7789a.f26295kW.setVisibility(0);
            c7789a.f26294kV.setVisibility(8);
            m32385dw();
        } else {
            c7789a.f26294kV.setText(c7790b.m32373dy());
        }
        this.f26289jK.f26203jL.m32333g(c7790b.m32375dA(), 0);
    }

    /* renamed from: d */
    private void m32386d(AdInfo adInfo) {
        if (C10483a.m25881bZ(adInfo) == 2) {
            this.f26291kR.m32371r(C10483a.m25845cI(adInfo));
            this.f26291kR.m32370s(C10483a.m25821ce(adInfo));
            CharSequence m25909b = C10483a.m25909b(adInfo, C9374e.acq);
            if (TextUtils.isEmpty(m25909b)) {
                m25909b = C10483a.m25846cH(adInfo);
            }
            this.f26291kR.m32376a(m25909b);
            if (C10483a.m25849cE(adInfo)) {
                this.f26291kR.m32367v(C7355b.m33444X());
            } else {
                this.f26291kR.m32367v(C7355b.m33441aa());
            }
        } else if (C7721b.m32568cL() && C10483a.m25881bZ(adInfo) == 3) {
            AdProductInfo m25838cP = C10483a.m25838cP(adInfo);
            this.f26291kR.m32371r(m25838cP.icon);
            this.f26291kR.m32370s(m25838cP.name);
            this.f26291kR.m32369t(m25838cP.originPrice);
            this.f26291kR.m32368u(m25838cP.price);
            this.f26291kR.m32367v(C7355b.m33443Y());
        } else if (C10483a.m25956aF(adInfo)) {
            this.f26291kR.m32371r(C10483a.m25820cf(adInfo));
            if (!TextUtils.isEmpty(C10483a.m25914av(adInfo))) {
                this.f26291kR.m32370s(C10483a.m25914av(adInfo));
            } else if (!TextUtils.isEmpty(adInfo.advertiserInfo.adAuthorText)) {
                this.f26291kR.m32370s(adInfo.advertiserInfo.adAuthorText);
            } else {
                this.f26291kR.m32370s(getContext().getString(C9659R.C9664string.ksad_ad_default_username_normal));
            }
            this.f26291kR.m32376a(C10483a.m25915au(adInfo));
            this.f26291kR.m32367v(C10483a.m25957aE(adInfo));
        } else {
            this.f26291kR.m32371r(C10483a.m25820cf(adInfo));
            if (!TextUtils.isEmpty(C10483a.m25912ax(adInfo))) {
                this.f26291kR.m32370s(C10483a.m25912ax(adInfo));
            } else if (!TextUtils.isEmpty(adInfo.advertiserInfo.adAuthorText)) {
                this.f26291kR.m32370s(adInfo.advertiserInfo.adAuthorText);
            } else {
                this.f26291kR.m32370s(getContext().getString(C9659R.C9664string.ksad_ad_default_username_normal));
            }
            this.f26291kR.m32376a(C10483a.m25915au(adInfo));
            this.f26291kR.m32367v(C10483a.m25957aE(adInfo));
        }
    }

    /* renamed from: dw */
    private void m32385dw() {
        View findViewById = this.f26289jK.f26203jL.findViewById(C9659R.C9662id.ksad_ad_desc_layout);
        View findViewById2 = this.f26289jK.f26203jL.findViewById(C9659R.C9662id.ksad_space);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
        layoutParams.weight = 2.68f;
        findViewById.setLayoutParams(layoutParams);
        findViewById2.setVisibility(8);
    }

    @Override // com.kwad.components.p208ad.interstitial.p242e.C7760b, com.kwad.sdk.mvp.Presenter
    /* renamed from: aj */
    public final void mo24610aj() {
        super.mo24610aj();
        C7761c c7761c = (C7761c) m24613Jx();
        this.f26289jK = c7761c;
        AdTemplate adTemplate = c7761c.mAdTemplate;
        this.mAdTemplate = adTemplate;
        this.mAdInfo = C10487e.m25641dQ(adTemplate);
        this.f26290kQ.f26292kT = (ImageView) this.f26289jK.f26203jL.findViewById(C9659R.C9662id.ksad_app_icon);
        this.f26290kQ.f26293kU = (TextView) this.f26289jK.f26203jL.findViewById(C9659R.C9662id.ksad_app_title);
        this.f26290kQ.f26294kV = (TextView) this.f26289jK.f26203jL.findViewById(C9659R.C9662id.ksad_app_desc);
        this.f26290kQ.f26295kW = (KsPriceView) this.f26289jK.f26203jL.findViewById(C9659R.C9662id.ksad_product_price);
        m32386d(this.mAdInfo);
        m32387a(this.f26290kQ, this.f26291kR, this.mAdInfo, this.mAdTemplate);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
    }
}

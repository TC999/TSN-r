package com.kwad.components.p208ad.splashscreen.p278c.p279a;

import android.view.View;
import android.widget.TextView;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.components.p208ad.splashscreen.p278c.C8421e;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.utils.C11053bg;

/* renamed from: com.kwad.components.ad.splashscreen.c.a.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class View$OnClickListenerC8370b extends C8421e implements View.OnClickListener {

    /* renamed from: EA */
    private AdInfo.DownloadSafeInfo f27643EA;

    /* renamed from: Ev */
    private TextView f27644Ev;

    /* renamed from: Ew */
    private TextView f27645Ew;

    /* renamed from: Ex */
    private TextView f27646Ex;

    /* renamed from: Ey */
    private TextView f27647Ey;

    /* renamed from: Ez */
    private TextView f27648Ez;

    private void initView() {
        this.f27644Ev = (TextView) findViewById(C9659R.C9662id.ksad_ad_endcard_appversion);
        this.f27645Ew = (TextView) findViewById(C9659R.C9662id.ksad_ad_permission_text);
        this.f27646Ex = (TextView) findViewById(C9659R.C9662id.ksad_ad_introduction_text);
        this.f27647Ey = (TextView) findViewById(C9659R.C9662id.ksad_ad_privacy_text);
        this.f27648Ez = (TextView) findViewById(C9659R.C9662id.ksad_ad_developer_text);
    }

    /* renamed from: lB */
    private void m30874lB() {
        if (C10483a.m25946aP(C10487e.m25641dQ(this.f27734Dg.mAdTemplate))) {
            StringBuilder sb = new StringBuilder();
            String str = this.f27643EA.appVersion;
            if (C11053bg.m23925gP(str)) {
                sb.append("版本号 ");
                sb.append(str);
            }
            if (C11053bg.m23925gP(sb.toString())) {
                this.f27644Ev.setText(sb);
            }
            String str2 = this.f27643EA.introductionInfoUrl;
            if (C11053bg.m23925gP(str2)) {
                this.f27646Ex.setText("功能");
                this.f27646Ex.setOnClickListener(this);
            }
            AdInfo.DownloadSafeInfo downloadSafeInfo = this.f27643EA;
            String str3 = downloadSafeInfo.appPermissionInfoUrl;
            String str4 = downloadSafeInfo.appPrivacyUrl;
            if (C11053bg.m23925gP(str3)) {
                StringBuilder sb2 = new StringBuilder();
                if (C11053bg.m23925gP(str2)) {
                    sb2.append(" | ");
                }
                sb2.append("权限");
                this.f27645Ew.setText(sb2);
                this.f27645Ew.setOnClickListener(this);
            }
            if (C11053bg.m23925gP(str4)) {
                StringBuilder sb3 = new StringBuilder();
                if (C11053bg.m23925gP(str3) || C11053bg.m23925gP(str2)) {
                    sb3.append(" | ");
                }
                sb3.append("隐私");
                this.f27647Ey.setText(sb3);
                this.f27647Ey.setOnClickListener(this);
            }
            StringBuilder sb4 = new StringBuilder();
            String str5 = this.f27643EA.appName;
            if (C11053bg.m23925gP(str5)) {
                sb4.append(str5);
            }
            String str6 = this.f27643EA.corporationName;
            if (C11053bg.m23925gP(str6)) {
                if (C11053bg.m23925gP(str5)) {
                    sb4.append(" ");
                }
                sb4.append(str6);
            }
            if (C11053bg.m23925gP(sb4.toString())) {
                this.f27648Ez.setText(sb4);
            }
        }
    }

    @Override // com.kwad.components.p208ad.splashscreen.p278c.C8421e, com.kwad.sdk.mvp.Presenter
    /* renamed from: aj */
    public final void mo24610aj() {
        super.mo24610aj();
        this.f27643EA = C10487e.m25641dQ(this.f27734Dg.mAdTemplate).downloadSafeInfo;
        m30874lB();
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view == this.f27647Ey) {
            AdWebViewActivityProxy.launch(getContext(), new AdWebViewActivityProxy.C8777a.C8778a().m29855as("隐私政策").m29854at(this.f27643EA.appPrivacyUrl).m29859aC(true).m29856as(this.f27734Dg.mAdTemplate).m29851pl());
        } else if (view == this.f27645Ew) {
            AdWebViewActivityProxy.launch(getContext(), new AdWebViewActivityProxy.C8777a.C8778a().m29855as("权限信息").m29859aC(true).m29854at(this.f27643EA.appPermissionInfoUrl).m29856as(this.f27734Dg.mAdTemplate).m29851pl());
        } else if (view == this.f27646Ex) {
            AdWebViewActivityProxy.launch(getContext(), new AdWebViewActivityProxy.C8777a.C8778a().m29855as("功能介绍").m29859aC(true).m29854at(this.f27643EA.introductionInfoUrl).m29856as(this.f27734Dg.mAdTemplate).m29851pl());
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        initView();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
    }
}

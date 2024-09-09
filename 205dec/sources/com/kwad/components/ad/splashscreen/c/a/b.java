package com.kwad.components.ad.splashscreen.c.a;

import android.view.View;
import android.widget.TextView;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.bg;

/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class b extends com.kwad.components.ad.splashscreen.c.e implements View.OnClickListener {
    private AdInfo.DownloadSafeInfo EA;
    private TextView Ev;
    private TextView Ew;
    private TextView Ex;
    private TextView Ey;
    private TextView Ez;

    private void initView() {
        this.Ev = (TextView) findViewById(R.id.ksad_ad_endcard_appversion);
        this.Ew = (TextView) findViewById(R.id.ksad_ad_permission_text);
        this.Ex = (TextView) findViewById(R.id.ksad_ad_introduction_text);
        this.Ey = (TextView) findViewById(R.id.ksad_ad_privacy_text);
        this.Ez = (TextView) findViewById(R.id.ksad_ad_developer_text);
    }

    private void lB() {
        if (com.kwad.sdk.core.response.b.a.aP(com.kwad.sdk.core.response.b.e.dQ(this.Dg.mAdTemplate))) {
            StringBuilder sb = new StringBuilder();
            String str = this.EA.appVersion;
            if (bg.gP(str)) {
                sb.append("\u7248\u672c\u53f7 ");
                sb.append(str);
            }
            if (bg.gP(sb.toString())) {
                this.Ev.setText(sb);
            }
            String str2 = this.EA.introductionInfoUrl;
            if (bg.gP(str2)) {
                this.Ex.setText("\u529f\u80fd");
                this.Ex.setOnClickListener(this);
            }
            AdInfo.DownloadSafeInfo downloadSafeInfo = this.EA;
            String str3 = downloadSafeInfo.appPermissionInfoUrl;
            String str4 = downloadSafeInfo.appPrivacyUrl;
            if (bg.gP(str3)) {
                StringBuilder sb2 = new StringBuilder();
                if (bg.gP(str2)) {
                    sb2.append(" | ");
                }
                sb2.append("\u6743\u9650");
                this.Ew.setText(sb2);
                this.Ew.setOnClickListener(this);
            }
            if (bg.gP(str4)) {
                StringBuilder sb3 = new StringBuilder();
                if (bg.gP(str3) || bg.gP(str2)) {
                    sb3.append(" | ");
                }
                sb3.append("\u9690\u79c1");
                this.Ey.setText(sb3);
                this.Ey.setOnClickListener(this);
            }
            StringBuilder sb4 = new StringBuilder();
            String str5 = this.EA.appName;
            if (bg.gP(str5)) {
                sb4.append(str5);
            }
            String str6 = this.EA.corporationName;
            if (bg.gP(str6)) {
                if (bg.gP(str5)) {
                    sb4.append(" ");
                }
                sb4.append(str6);
            }
            if (bg.gP(sb4.toString())) {
                this.Ez.setText(sb4);
            }
        }
    }

    @Override // com.kwad.components.ad.splashscreen.c.e, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        this.EA = com.kwad.sdk.core.response.b.e.dQ(this.Dg.mAdTemplate).downloadSafeInfo;
        lB();
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view == this.Ey) {
            AdWebViewActivityProxy.launch(getContext(), new AdWebViewActivityProxy.a.C0642a().as("\u9690\u79c1\u653f\u7b56").at(this.EA.appPrivacyUrl).aC(true).as(this.Dg.mAdTemplate).pl());
        } else if (view == this.Ew) {
            AdWebViewActivityProxy.launch(getContext(), new AdWebViewActivityProxy.a.C0642a().as("\u6743\u9650\u4fe1\u606f").aC(true).at(this.EA.appPermissionInfoUrl).as(this.Dg.mAdTemplate).pl());
        } else if (view == this.Ex) {
            AdWebViewActivityProxy.launch(getContext(), new AdWebViewActivityProxy.a.C0642a().as("\u529f\u80fd\u4ecb\u7ecd").aC(true).at(this.EA.introductionInfoUrl).as(this.Dg.mAdTemplate).pl());
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

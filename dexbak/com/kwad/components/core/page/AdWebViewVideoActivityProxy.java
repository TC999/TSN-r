package com.kwad.components.core.page;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.components.core.p286b.C8542b;
import com.kwad.components.core.p286b.View$OnClickListenerC8540a;
import com.kwad.components.core.p289e.p293d.C8615a;
import com.kwad.components.core.p289e.p293d.C8619c;
import com.kwad.components.core.p330s.C8939d;
import com.kwad.components.core.page.splitLandingPage.C8853a;
import com.kwad.components.core.page.widget.DialogC8867a;
import com.kwad.components.core.proxy.AbstractC8889f;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.api.core.KsAdSdkDynamicImpl;
import com.kwad.sdk.api.proxy.app.AdWebViewActivity;
import com.kwad.sdk.api.proxy.app.BaseFragmentActivity;
import com.kwad.sdk.core.adlog.C9908c;
import com.kwad.sdk.core.config.C10251d;
import com.kwad.sdk.core.download.p395a.AbstractC10298a;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.p445n.C10887l;
import com.kwad.sdk.service.C10973b;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.C11008ac;
import com.kwad.sdk.utils.C11015ai;
import com.kwad.sdk.widget.DownloadProgressBar;
import java.util.List;
import org.json.JSONObject;

@KsAdSdkDynamicImpl(AdWebViewActivity.class)
@Keep
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class AdWebViewVideoActivityProxy extends AbstractC8889f {
    public static final String KEY_REPORTED = "key_reported";
    public static final String KEY_TEMPLATE = "key_template_json";
    public static boolean showingAdWebViewVideoActivity;
    private AdTemplate mAdTemplate;
    private C8619c mApkDownloadHelper;
    private C8793b mFragment;
    private Dialog mKsExitInterceptDialog;
    private DownloadProgressBar mProgressbar;
    private C8853a mSplitLandingPage;
    private View$OnClickListenerC8540a mTitleBarHelper;
    private ViewGroup mWebDownloadContainer;

    private DialogC8867a buildDialog() {
        return new DialogC8867a(getActivity(), new DialogC8867a.InterfaceC8872a() { // from class: com.kwad.components.core.page.AdWebViewVideoActivityProxy.4
            @Override // com.kwad.components.core.page.widget.DialogC8867a.InterfaceC8872a
            /* renamed from: a */
            public final void mo29705a(DialogInterface dialogInterface) {
                C9908c.m27287p(AdWebViewVideoActivityProxy.this.mAdTemplate, 104);
                dialogInterface.dismiss();
            }

            @Override // com.kwad.components.core.page.widget.DialogC8867a.InterfaceC8872a
            /* renamed from: b */
            public final void mo29704b(DialogInterface dialogInterface) {
                AdWebViewVideoActivityProxy.super.onBackPressed();
                C9908c.m27287p(AdWebViewVideoActivityProxy.this.mAdTemplate, 105);
            }

            @Override // com.kwad.components.core.page.widget.DialogC8867a.InterfaceC8872a
            /* renamed from: c */
            public final void mo29703c(DialogInterface dialogInterface) {
                C9908c.m27287p(AdWebViewVideoActivityProxy.this.mAdTemplate, 106);
                dialogInterface.dismiss();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public C8615a.C8616a getAdClickConfig(boolean z) {
        return new C8615a.C8616a(getActivity()).m30202ao(z).m30193at(true).m30200ap(false).m30198aq(this.mAdTemplate).m30195ar(false);
    }

    private void initView() {
        this.mProgressbar = (DownloadProgressBar) findViewById(C9659R.C9662id.ksad_web_download_progress);
        this.mWebDownloadContainer = (ViewGroup) findViewById(C9659R.C9662id.ksad_web_download_container);
        final AdInfo m25641dQ = C10487e.m25641dQ(this.mAdTemplate);
        if (C10483a.m25956aF(m25641dQ)) {
            this.mWebDownloadContainer.setVisibility(0);
            this.mApkDownloadHelper = new C8619c(this.mAdTemplate, new AbstractC10298a() { // from class: com.kwad.components.core.page.AdWebViewVideoActivityProxy.1
                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onDownloadFailed() {
                    AdWebViewVideoActivityProxy.this.mProgressbar.setProgress(100.0f);
                    AdWebViewVideoActivityProxy.this.mProgressbar.setText(C10483a.m25957aE(m25641dQ));
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onDownloadFinished() {
                    AdWebViewVideoActivityProxy.this.mProgressbar.setProgress(100.0f);
                    AdWebViewVideoActivityProxy.this.mProgressbar.setText(C10483a.m25882bY(AdWebViewVideoActivityProxy.this.mAdTemplate));
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onIdle() {
                    AdWebViewVideoActivityProxy.this.mProgressbar.setProgress(100.0f);
                    AdWebViewVideoActivityProxy.this.mProgressbar.setText(C10483a.m25957aE(m25641dQ));
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onInstalled() {
                    AdWebViewVideoActivityProxy.this.mProgressbar.setProgress(100.0f);
                    AdWebViewVideoActivityProxy.this.mProgressbar.setText(C10483a.m25933ac(m25641dQ));
                }

                @Override // com.kwad.sdk.core.download.p395a.AbstractC10298a
                public final void onPaused(int i) {
                    AdWebViewVideoActivityProxy.this.mProgressbar.setProgress(i);
                    AdWebViewVideoActivityProxy.this.mProgressbar.setText(C10483a.m25794dn(i));
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onProgressUpdate(int i) {
                    AdWebViewVideoActivityProxy.this.mProgressbar.setProgress(i);
                    AdWebViewVideoActivityProxy.this.mProgressbar.setText(C10483a.m25795dm(i));
                }
            });
            this.mProgressbar.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.page.AdWebViewVideoActivityProxy.2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    C9908c.m27349a(AdWebViewVideoActivityProxy.this.mAdTemplate, 50, (C11008ac.C11009a) null);
                    C8615a.m30233a(AdWebViewVideoActivityProxy.this.getAdClickConfig(true));
                }
            });
        } else {
            this.mWebDownloadContainer.setVisibility(8);
        }
        List<AdInfo> list = this.mAdTemplate.adInfoList;
        String m25823cc = (list == null || list.size() <= 0 || this.mAdTemplate.adInfoList.get(0) == null) ? "详情页面" : C10483a.m25823cc(C10487e.m25641dQ(this.mAdTemplate));
        View$OnClickListenerC8540a view$OnClickListenerC8540a = new View$OnClickListenerC8540a((ViewGroup) findViewById(C9659R.C9662id.ksad_kwad_web_title_bar));
        this.mTitleBarHelper = view$OnClickListenerC8540a;
        view$OnClickListenerC8540a.m30412a(new View$OnClickListenerC8540a.InterfaceC8541a() { // from class: com.kwad.components.core.page.AdWebViewVideoActivityProxy.3
            @Override // com.kwad.components.core.p286b.View$OnClickListenerC8540a.InterfaceC8541a
            /* renamed from: u */
            public final void mo29634u(View view) {
                AdWebViewVideoActivityProxy.this.onBackPressed();
            }

            @Override // com.kwad.components.core.p286b.View$OnClickListenerC8540a.InterfaceC8541a
            /* renamed from: v */
            public final void mo29633v(View view) {
                AdWebViewVideoActivityProxy.this.finish();
            }
        });
        this.mTitleBarHelper.m30411a(new C8542b(m25823cc));
        C11015ai.m24120cm(getActivity());
        C8939d.m29564a(getActivity(), 0, true);
        int i = C9659R.C9662id.ksad_recycler_container;
        if (C10251d.m26566Bv() != 0) {
            C8853a m29735at = C8853a.m29735at(this.mAdTemplate);
            this.mSplitLandingPage = m29735at;
            m29735at.setApkDownloadHelper(this.mApkDownloadHelper);
            getSupportFragmentManager().beginTransaction().replace(i, this.mSplitLandingPage).commitAllowingStateLoss();
            return;
        }
        C8793b m29842ar = C8793b.m29842ar(this.mAdTemplate);
        this.mFragment = m29842ar;
        m29842ar.setApkDownloadHelper(this.mApkDownloadHelper);
        getSupportFragmentManager().beginTransaction().replace(i, this.mFragment).commitAllowingStateLoss();
    }

    private boolean isFormAdExitInterceptEnable() {
        if (this.mAdTemplate == null) {
            return false;
        }
        if (C10251d.m26552Cc() && this.mAdTemplate.mIsFromContent) {
            return true;
        }
        return C10251d.m26551Cd() && !this.mAdTemplate.mIsFromContent;
    }

    public static void launch(Context context, AdTemplate adTemplate) {
        if (context == null || adTemplate == null) {
            return;
        }
        Intent intent = new Intent(context, BaseFragmentActivity.FragmentActivity3.class);
        intent.addFlags(268435456);
        intent.putExtra("key_template_json", adTemplate.toJson().toString());
        intent.putExtra(KEY_REPORTED, adTemplate.mPvReported);
        context.startActivity(intent);
        Activity m24559dn = C10887l.m24559dn(context);
        if (m24559dn != null) {
            m24559dn.overridePendingTransition(0, 0);
        }
    }

    @InvokeBy(invokerClass = C10973b.class, methodId = "initComponentProxyForInvoker")
    public static void register() {
        C10973b.m24291a(BaseFragmentActivity.FragmentActivity3.class, AdWebViewVideoActivityProxy.class);
    }

    private void showDialog() {
        if (this.mKsExitInterceptDialog == null) {
            this.mKsExitInterceptDialog = buildDialog();
        }
        C9908c.m27337b(this.mAdTemplate, 103, (JSONObject) null);
        this.mKsExitInterceptDialog.show();
    }

    private void showWaitDialog() {
        if (isFormAdExitInterceptEnable()) {
            showDialog();
        } else {
            finish();
        }
    }

    @Override // com.kwad.components.core.proxy.AbstractC8889f
    public String getPageName() {
        return "AdWebViewVideoActivityProxy";
    }

    @Override // com.kwad.components.core.proxy.AbstractC8889f, com.kwad.sdk.api.proxy.IActivityProxy
    public void onBackPressed() {
        C8853a c8853a = this.mSplitLandingPage;
        if (c8853a == null || !c8853a.onBackPressed()) {
            C8853a c8853a2 = this.mSplitLandingPage;
            if (c8853a2 != null) {
                c8853a2.m29726pW();
            }
            C8793b c8793b = this.mFragment;
            if (c8793b != null && c8793b.onBackPressed()) {
                super.onBackPressed();
            } else {
                showWaitDialog();
            }
        }
    }

    @Override // com.kwad.components.core.proxy.AbstractC8889f, com.kwad.sdk.api.proxy.IActivityProxy
    public void onCreate(Bundle bundle) {
        try {
            super.onCreate(bundle);
            setContentView(C9659R.C9663layout.ksad_activity_ad_video_webview);
            showingAdWebViewVideoActivity = true;
            String stringExtra = getIntent().getStringExtra("key_template_json");
            AdTemplate adTemplate = new AdTemplate();
            adTemplate.parseJson(new JSONObject(stringExtra));
            this.mAdTemplate = adTemplate;
            AdTemplate adTemplate2 = this.mAdTemplate;
            if (adTemplate2 != null) {
                adTemplate2.mPvReported = getIntent().getBooleanExtra(KEY_REPORTED, false);
                initView();
                return;
            }
            finish();
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    @Override // com.kwad.components.core.proxy.AbstractC8889f, com.kwad.sdk.api.proxy.IActivityProxy
    public void onDestroy() {
        try {
            Dialog dialog = this.mKsExitInterceptDialog;
            if (dialog != null && dialog.isShowing()) {
                this.mKsExitInterceptDialog.dismiss();
            }
            super.onDestroy();
            showingAdWebViewVideoActivity = false;
            C8619c c8619c = this.mApkDownloadHelper;
            if (c8619c != null) {
                c8619c.clear();
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onPause() {
        showingAdWebViewVideoActivity = false;
        overridePendingTransition(0, 0);
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onPreCreate(@Nullable Bundle bundle) {
        super.onPreCreate(bundle);
        try {
            getIntent().removeExtra("key_template");
        } catch (Throwable unused) {
        }
    }

    @Override // com.kwad.components.core.proxy.AbstractC8889f, com.kwad.sdk.api.proxy.IActivityProxy
    public void onResume() {
        super.onResume();
        showingAdWebViewVideoActivity = true;
    }
}

package com.kwad.components.core.page;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewGroup;
import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.components.core.c.f;
import com.kwad.components.core.page.widget.a;
import com.kwad.components.core.webview.tachikoma.c.e;
import com.kwad.sdk.R;
import com.kwad.sdk.api.core.KsAdSdkDynamicImpl;
import com.kwad.sdk.api.proxy.app.AdWebViewActivity;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.k;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.bn;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
@KsAdSdkDynamicImpl(AdWebViewActivity.class)
@Keep
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class AdWebViewActivityProxy extends com.kwad.components.core.proxy.c {
    public static final String KEY_AD_RESULT_CACHE_IDX = "key_ad_result_cache_idx";
    private static final String KEY_IS_AUTO_SHOW = "key_is_auto_show";
    private static final String KEY_LANDING_PAGE_TYPE = "key_landing_page_type";
    private static final String KEY_PAGE_TITLE = "key_page_title";
    private static final String KEY_PAGE_URL = "key_page_url";
    private static final String KEY_SHOW_PERMISSION = "key_show_permission";
    private static final String KEY_SHOW_TK_CONFIRM_DIALOG = "key_show_tk_confirm_dialog";
    public static final String KEY_TEMPLATE = "key_template_json";
    private AdResultData mAdResultData;
    private AdTemplate mAdTemplate;
    private boolean mAutoShow;
    private com.kwad.components.core.q.b mDialogFragment;
    private boolean mDisableShowConfirmDialog;
    private boolean mHasShowShowConfirmDialog;
    private Dialog mKsExitInterceptDialog;
    private Dialog mKsExitInterceptDialogV2;
    private int mLandingPageType;
    private c mLandingPageView;
    private String mPageTitle;
    private String mPageUrl;
    private boolean mShowPermission;
    private volatile boolean destroyed = false;
    private com.kwad.sdk.core.webview.d.a.b mWebCardCloseListener = new com.kwad.sdk.core.webview.d.a.b() { // from class: com.kwad.components.core.page.AdWebViewActivityProxy.1
        @Override // com.kwad.sdk.core.webview.d.a.b
        public final void b(WebCloseStatus webCloseStatus) {
            AdWebViewActivityProxy.this.finish();
        }
    };
    private com.kwad.components.core.page.a.a mLandPageViewListener = new com.kwad.components.core.page.a.a() { // from class: com.kwad.components.core.page.AdWebViewActivityProxy.2
        @Override // com.kwad.components.core.page.a.a
        public final void pd() {
            AdWebViewActivityProxy.this.onBackPressed();
        }

        @Override // com.kwad.components.core.page.a.a
        public final void pe() {
            if (AdWebViewActivityProxy.this.mLandingPageView != null && AdWebViewActivityProxy.this.mLandingPageView.getCanInterceptBackClick()) {
                AdWebViewActivityProxy.this.mLandingPageView.pn();
            } else if (AdWebViewActivityProxy.this.mDisableShowConfirmDialog) {
                AdWebViewActivityProxy.this.finish();
            } else if (AdWebViewActivityProxy.this.handleMiddlePageDialog()) {
            } else {
                if (AdWebViewActivityProxy.this.mAdTemplate.mIsForceJumpLandingPage) {
                    AdWebViewActivityProxy.this.finish();
                } else if (com.kwad.sdk.core.response.b.a.aO(e.dQ(AdWebViewActivityProxy.this.mAdTemplate)) && com.kwad.components.core.q.a.qH().qI() == 1 && com.kwad.components.core.q.a.qH().qN() && !com.kwad.components.core.q.a.qH().qK()) {
                    if (!com.kwad.components.core.q.a.qH().qJ() && com.kwad.sdk.core.config.d.BV()) {
                        AdWebViewActivityProxy adWebViewActivityProxy = AdWebViewActivityProxy.this;
                        adWebViewActivityProxy.mDialogFragment = adWebViewActivityProxy.getTkDialogFragment();
                        com.kwad.components.core.q.b.a(AdWebViewActivityProxy.this.mDialogFragment, AdWebViewActivityProxy.this.getActivity(), AdWebViewActivityProxy.this.mBaseDialogListener);
                        return;
                    }
                    AdWebViewActivityProxy.this.finish();
                } else if (AdWebViewActivityProxy.this.isFormAdExitInterceptEnable()) {
                    AdWebViewActivityProxy.this.showDialog();
                } else {
                    AdWebViewActivityProxy.this.finish();
                }
            }
        }
    };
    private com.kwad.components.core.webview.tachikoma.e.c mBaseDialogListener = new com.kwad.components.core.webview.tachikoma.e.c() { // from class: com.kwad.components.core.page.AdWebViewActivityProxy.3
        @Override // com.kwad.components.core.webview.tachikoma.e.c
        public final void F(boolean z3) {
        }

        @Override // com.kwad.components.core.webview.tachikoma.e.c
        public final void fR() {
            com.kwad.components.core.q.a.qH().aL(true);
        }

        @Override // com.kwad.components.core.webview.tachikoma.e.c
        public final void fZ() {
            com.kwad.components.core.q.a.qH().aL(false);
        }

        @Override // com.kwad.components.core.webview.tachikoma.e.c
        public final void ga() {
        }
    };

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class a {
        private String Oh;
        private String Oi;
        private AdResultData Oj;
        private boolean Ok;
        private boolean Ol;
        private int Om;
        private boolean On;
        private AdTemplate adTemplate;

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
        /* renamed from: com.kwad.components.core.page.AdWebViewActivityProxy$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\6520572.dex */
        public static class C0642a {
            private String Oh;
            private String Oi;
            private AdResultData Oj;
            private boolean Ol;
            private int Om = 0;
            private boolean On;
            private boolean Oo;
            private AdTemplate adTemplate;

            public final C0642a aC(boolean z3) {
                this.Oo = z3;
                return this;
            }

            public final C0642a aD(boolean z3) {
                this.Ol = z3;
                return this;
            }

            public final C0642a aE(boolean z3) {
                this.On = z3;
                return this;
            }

            public final C0642a as(String str) {
                this.Oh = str;
                return this;
            }

            public final C0642a at(String str) {
                this.Oi = str;
                return this;
            }

            public final C0642a az(int i4) {
                this.Om = i4;
                return this;
            }

            public final C0642a m(AdResultData adResultData) {
                this.Oj = adResultData;
                return this;
            }

            public final a pl() {
                AdResultData adResultData = this.Oj;
                if (adResultData != null) {
                    return new a(this.Oh, this.Oi, adResultData, this.Oo, this.Ol, this.On, this.Om, (byte) 0);
                }
                return new a(this.Oh, this.Oi, this.adTemplate, this.Oo, this.Ol, this.On, this.Om, (byte) 0);
            }

            public final C0642a as(AdTemplate adTemplate) {
                this.adTemplate = adTemplate;
                return this;
            }
        }

        /* synthetic */ a(String str, String str2, AdResultData adResultData, boolean z3, boolean z4, boolean z5, int i4, byte b4) {
            this(str, str2, adResultData, z3, z4, z5, i4);
        }

        public final AdTemplate getAdTemplate() {
            return this.adTemplate;
        }

        public final String pf() {
            return this.Oh;
        }

        public final String pg() {
            return this.Oi;
        }

        public final int ph() {
            return this.Om;
        }

        public final boolean pi() {
            return this.Ok;
        }

        public final boolean pj() {
            return this.On;
        }

        public final boolean pk() {
            return this.Ol;
        }

        /* synthetic */ a(String str, String str2, AdTemplate adTemplate, boolean z3, boolean z4, boolean z5, int i4, byte b4) {
            this(str, str2, adTemplate, z3, z4, z5, i4);
        }

        private a(String str, String str2, AdTemplate adTemplate, boolean z3, boolean z4, boolean z5, int i4) {
            this(str, str2, z3, z4, z5, i4);
            this.adTemplate = adTemplate;
        }

        private a(String str, String str2, AdResultData adResultData, boolean z3, boolean z4, boolean z5, int i4) {
            this(str, str2, z3, z4, z5, i4);
            this.Oj = adResultData;
            this.adTemplate = com.kwad.sdk.core.response.b.c.n(adResultData);
        }

        private a(String str, String str2, boolean z3, boolean z4, boolean z5, int i4) {
            this.Oh = str;
            this.Oi = str2;
            this.Ok = z3;
            this.Ol = z4;
            this.On = z5;
            this.Om = i4;
        }
    }

    private com.kwad.components.core.page.widget.a buildDialog() {
        return new com.kwad.components.core.page.widget.a(getActivity(), new a.InterfaceC0646a() { // from class: com.kwad.components.core.page.AdWebViewActivityProxy.5
            @Override // com.kwad.components.core.page.widget.a.InterfaceC0646a
            public final void a(DialogInterface dialogInterface) {
                com.kwad.sdk.core.adlog.c.p(AdWebViewActivityProxy.this.mAdTemplate, 104);
                dialogInterface.dismiss();
            }

            @Override // com.kwad.components.core.page.widget.a.InterfaceC0646a
            public final void b(DialogInterface dialogInterface) {
                try {
                    AdWebViewActivityProxy.super.onBackPressed();
                } catch (Throwable unused) {
                }
                com.kwad.sdk.core.adlog.c.p(AdWebViewActivityProxy.this.mAdTemplate, 105);
            }

            @Override // com.kwad.components.core.page.widget.a.InterfaceC0646a
            public final void c(DialogInterface dialogInterface) {
                com.kwad.sdk.core.adlog.c.p(AdWebViewActivityProxy.this.mAdTemplate, 106);
                dialogInterface.dismiss();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.kwad.components.core.q.b getTkDialogFragment() {
        e.b bVar = new e.b();
        bVar.d(this.mAdResultData);
        bVar.aU(com.kwad.sdk.core.response.b.b.dw(this.mAdTemplate));
        bVar.aW(false);
        bVar.aX(true);
        return com.kwad.components.core.q.b.a(bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean handleMiddlePageDialog() {
        boolean z3 = false;
        if (this.mAdTemplate != null && com.kwad.sdk.core.config.d.BV()) {
            if (!bg.isNullString(com.kwad.sdk.core.response.b.a.ca(this.mAdTemplate)) && com.kwad.sdk.core.response.b.a.bZ(this.mAdTemplate)) {
                z3 = true;
                if (this.mHasShowShowConfirmDialog) {
                    try {
                        super.onBackPressed();
                    } catch (Throwable th) {
                        com.kwad.sdk.core.e.c.printStackTrace(th);
                    }
                } else {
                    com.kwad.components.core.q.b tkDialogFragment = getTkDialogFragment();
                    this.mDialogFragment = tkDialogFragment;
                    com.kwad.components.core.q.b.a(tkDialogFragment, getActivity(), this.mBaseDialogListener);
                    this.mHasShowShowConfirmDialog = true;
                }
            }
            return z3;
        }
        return false;
    }

    private void initContentView() {
        c a4 = c.a(this.mContext, new a.C0642a().as(this.mPageTitle).at(this.mPageUrl).as(this.mAdTemplate).aC(this.mShowPermission).aD(this.mAutoShow).az(this.mLandingPageType).aE(this.mDisableShowConfirmDialog).pl());
        this.mLandingPageView = a4;
        a4.setLandPageViewListener(this.mLandPageViewListener);
        this.mLandingPageView.setWebCardCloseListener(this.mWebCardCloseListener);
        ((ViewGroup) findViewById(R.id.ksad_land_page_root)).addView(this.mLandingPageView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isFormAdExitInterceptEnable() {
        AdTemplate adTemplate;
        if (this.mShowPermission || (adTemplate = this.mAdTemplate) == null || com.kwad.sdk.core.response.b.e.F(adTemplate)) {
            return false;
        }
        if (com.kwad.sdk.core.config.d.Cc() && this.mAdTemplate.mIsFromContent) {
            return true;
        }
        return com.kwad.sdk.core.config.d.Cd() && !this.mAdTemplate.mIsFromContent;
    }

    public static void launch(Context context, a aVar) {
        if (context == null || TextUtils.isEmpty(aVar.Oi)) {
            return;
        }
        try {
            com.kwad.sdk.commercial.g.a.j(aVar.getAdTemplate(), aVar.ph(), aVar.pg());
            com.kwad.sdk.service.b.a(AdWebViewActivity.class, AdWebViewActivityProxy.class);
            Intent intent = new Intent(context, AdWebViewActivity.class);
            intent.addFlags(268435456);
            intent.putExtra("key_page_title", aVar.Oh);
            intent.putExtra("key_landing_page_type", aVar.Om);
            intent.putExtra("key_page_url", aVar.Oi);
            intent.putExtra("key_is_auto_show", aVar.Ol);
            intent.putExtra("key_show_permission", aVar.Ok);
            intent.putExtra("key_show_tk_confirm_dialog", aVar.pj());
            AdResultData adResultData = aVar.Oj;
            if (adResultData == null) {
                adResultData = com.kwad.sdk.core.response.b.c.dB(aVar.adTemplate);
            }
            intent.putExtra("key_ad_result_cache_idx", f.mE().i(adResultData));
            context.startActivity(intent);
        } catch (Throwable th) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(th);
            com.kwad.sdk.commercial.g.a.a(aVar.getAdTemplate(), aVar.ph(), aVar.pg(), bn.t(th));
            if (k.zd().yp()) {
                ServiceProvider.reportSdkCaughtException(th);
                return;
            }
            throw th;
        }
    }

    @InvokeBy(invokerClass = com.kwad.sdk.service.b.class, methodId = "initComponentProxyForInvoker")
    public static void register() {
        com.kwad.sdk.service.b.a(AdWebViewActivity.class, AdWebViewActivityProxy.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialog() {
        if (this.mKsExitInterceptDialog == null) {
            this.mKsExitInterceptDialog = buildDialog();
        }
        com.kwad.sdk.core.adlog.c.b(this.mAdTemplate, 103, (JSONObject) null);
        this.mKsExitInterceptDialog.show();
    }

    @Override // com.kwad.components.core.proxy.c
    public boolean checkIntentData(@Nullable Intent intent) {
        AdResultData d4 = f.mE().d(getIntent().getIntExtra("key_ad_result_cache_idx", 0), true);
        this.mAdResultData = d4;
        if (d4 == null) {
            return false;
        }
        AdTemplate n4 = com.kwad.sdk.core.response.b.c.n(d4);
        this.mAdTemplate = n4;
        return n4 != null;
    }

    @Override // com.kwad.components.core.proxy.c
    public int getLayoutId() {
        return 0;
    }

    @Override // com.kwad.components.core.proxy.c
    public String getPageName() {
        return "AdWebViewActivityProxy";
    }

    @Override // com.kwad.components.core.proxy.c
    public void initData() {
        this.destroyed = false;
        this.mPageTitle = getIntent().getStringExtra("key_page_title");
        this.mLandingPageType = getIntent().getIntExtra("key_landing_page_type", 0);
        this.mPageUrl = getIntent().getStringExtra("key_page_url");
        this.mAutoShow = getIntent().getBooleanExtra("key_is_auto_show", false);
        this.mShowPermission = getIntent().getBooleanExtra("key_show_permission", false);
        this.mDisableShowConfirmDialog = getIntent().getBooleanExtra("key_show_tk_confirm_dialog", false);
    }

    @Override // com.kwad.components.core.proxy.c
    public void initView() {
        setContentView(R.layout.ksad_activity_landpage);
        initContentView();
    }

    @Override // com.kwad.components.core.proxy.c
    public void onActivityCreate() {
        super.onActivityCreate();
        com.kwad.sdk.commercial.g.a.k(this.mAdTemplate, this.mLandingPageType, this.mPageUrl);
    }

    @Override // com.kwad.components.core.proxy.c, com.kwad.sdk.api.proxy.IActivityProxy
    public void onBackPressed() {
        c cVar = this.mLandingPageView;
        if (cVar != null && cVar.getCanInterceptBackClick()) {
            this.mLandingPageView.pn();
        } else if (this.mDisableShowConfirmDialog) {
            finish();
        } else if (handleMiddlePageDialog()) {
        } else {
            AdTemplate adTemplate = this.mAdTemplate;
            if (adTemplate != null && !adTemplate.mIsForceJumpLandingPage) {
                if (com.kwad.sdk.core.response.b.a.aO(com.kwad.sdk.core.response.b.e.dQ(adTemplate)) && com.kwad.components.core.q.a.qH().qI() == 1 && com.kwad.components.core.q.a.qH().qN() && !com.kwad.components.core.q.a.qH().qK()) {
                    if (!com.kwad.components.core.q.a.qH().qJ() && com.kwad.sdk.core.config.d.BV()) {
                        com.kwad.components.core.q.b tkDialogFragment = getTkDialogFragment();
                        this.mDialogFragment = tkDialogFragment;
                        com.kwad.components.core.q.b.a(tkDialogFragment, getActivity(), this.mBaseDialogListener);
                        return;
                    }
                    super.onBackPressed();
                    return;
                }
                if (isFormAdExitInterceptEnable()) {
                    try {
                        if (this.mKsExitInterceptDialogV2 == null) {
                            this.mKsExitInterceptDialogV2 = new com.kwad.components.core.page.widget.a(getActivity(), new a.InterfaceC0646a() { // from class: com.kwad.components.core.page.AdWebViewActivityProxy.4
                                @Override // com.kwad.components.core.page.widget.a.InterfaceC0646a
                                public final void a(DialogInterface dialogInterface) {
                                    com.kwad.sdk.core.adlog.c.p(AdWebViewActivityProxy.this.mAdTemplate, 104);
                                    dialogInterface.dismiss();
                                }

                                @Override // com.kwad.components.core.page.widget.a.InterfaceC0646a
                                public final void b(DialogInterface dialogInterface) {
                                    if (!AdWebViewActivityProxy.this.destroyed) {
                                        try {
                                            AdWebViewActivityProxy.super.onBackPressed();
                                        } catch (Throwable th) {
                                            com.kwad.sdk.core.e.c.printStackTrace(th);
                                        }
                                    }
                                    com.kwad.sdk.core.adlog.c.p(AdWebViewActivityProxy.this.mAdTemplate, 105);
                                }

                                @Override // com.kwad.components.core.page.widget.a.InterfaceC0646a
                                public final void c(DialogInterface dialogInterface) {
                                    com.kwad.sdk.core.adlog.c.p(AdWebViewActivityProxy.this.mAdTemplate, 106);
                                    dialogInterface.dismiss();
                                }
                            });
                        }
                        com.kwad.sdk.core.adlog.c.b(this.mAdTemplate, 103, (JSONObject) null);
                        this.mKsExitInterceptDialogV2.show();
                        return;
                    } catch (Throwable th) {
                        com.kwad.sdk.core.e.c.printStackTraceOnly(th);
                    }
                }
                super.onBackPressed();
                return;
            }
            super.onBackPressed();
        }
    }

    @Override // com.kwad.components.core.proxy.c, com.kwad.sdk.api.proxy.IActivityProxy
    public void onDestroy() {
        try {
            this.destroyed = true;
            com.kwad.components.core.q.b bVar = this.mDialogFragment;
            if (bVar != null) {
                bVar.dismiss();
                this.mDialogFragment = null;
            }
            Dialog dialog = this.mKsExitInterceptDialog;
            if (dialog != null && dialog.isShowing()) {
                this.mKsExitInterceptDialog.dismiss();
            }
            Dialog dialog2 = this.mKsExitInterceptDialogV2;
            if (dialog2 != null && dialog2.isShowing()) {
                this.mKsExitInterceptDialogV2.dismiss();
            }
            super.onDestroy();
            AdTemplate adTemplate = this.mAdTemplate;
            if (adTemplate != null) {
                adTemplate.interactLandingPageShowing = false;
                adTemplate.mIsForceJumpLandingPage = false;
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    @Override // com.kwad.components.core.proxy.c, com.kwad.sdk.api.proxy.IActivityProxy
    public void onPause() {
        super.onPause();
        overridePendingTransition(0, 0);
    }

    @Override // com.kwad.components.core.proxy.c, com.kwad.sdk.api.proxy.IActivityProxy
    public void onPreCreate(@Nullable Bundle bundle) {
        super.onPreCreate(bundle);
        try {
            getIntent().removeExtra("key_template");
        } catch (Throwable unused) {
        }
    }

    @Override // com.kwad.components.core.proxy.c, com.kwad.sdk.api.proxy.IActivityProxy
    public void onResume() {
        super.onResume();
    }

    public static void launch(Context context, AdTemplate adTemplate) {
        launch(context, new a.C0642a().at(com.kwad.sdk.core.response.b.b.cB(adTemplate)).as(adTemplate).pl());
    }
}

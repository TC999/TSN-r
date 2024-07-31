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
import com.kwad.components.core.p287c.C8552f;
import com.kwad.components.core.p326q.C8898a;
import com.kwad.components.core.p326q.DialogFragmentC8899b;
import com.kwad.components.core.page.p319a.InterfaceC8792a;
import com.kwad.components.core.page.widget.DialogC8867a;
import com.kwad.components.core.proxy.AbstractC8886c;
import com.kwad.components.core.webview.tachikoma.p335c.DialogFragmentC9274e;
import com.kwad.components.core.webview.tachikoma.p337e.InterfaceC9291c;
import com.kwad.sdk.C10829k;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.api.core.KsAdSdkDynamicImpl;
import com.kwad.sdk.api.proxy.app.AdWebViewActivity;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.commercial.p378g.C9835a;
import com.kwad.sdk.core.adlog.C9908c;
import com.kwad.sdk.core.config.C10251d;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10484b;
import com.kwad.sdk.core.response.p409b.C10485c;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.core.webview.p423d.p424a.InterfaceC10636b;
import com.kwad.sdk.service.C10973b;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.C11053bg;
import com.kwad.sdk.utils.C11064bn;
import org.json.JSONObject;

@KsAdSdkDynamicImpl(AdWebViewActivity.class)
@Keep
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class AdWebViewActivityProxy extends AbstractC8886c {
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
    private DialogFragmentC8899b mDialogFragment;
    private boolean mDisableShowConfirmDialog;
    private boolean mHasShowShowConfirmDialog;
    private Dialog mKsExitInterceptDialog;
    private Dialog mKsExitInterceptDialogV2;
    private int mLandingPageType;
    private C8798c mLandingPageView;
    private String mPageTitle;
    private String mPageUrl;
    private boolean mShowPermission;
    private volatile boolean destroyed = false;
    private InterfaceC10636b mWebCardCloseListener = new InterfaceC10636b() { // from class: com.kwad.components.core.page.AdWebViewActivityProxy.1
        @Override // com.kwad.sdk.core.webview.p423d.p424a.InterfaceC10636b
        /* renamed from: b */
        public final void mo25244b(WebCloseStatus webCloseStatus) {
            AdWebViewActivityProxy.this.finish();
        }
    };
    private InterfaceC8792a mLandPageViewListener = new InterfaceC8792a() { // from class: com.kwad.components.core.page.AdWebViewActivityProxy.2
        @Override // com.kwad.components.core.page.p319a.InterfaceC8792a
        /* renamed from: pd */
        public final void mo29848pd() {
            AdWebViewActivityProxy.this.onBackPressed();
        }

        @Override // com.kwad.components.core.page.p319a.InterfaceC8792a
        /* renamed from: pe */
        public final void mo29847pe() {
            if (AdWebViewActivityProxy.this.mLandingPageView != null && AdWebViewActivityProxy.this.mLandingPageView.getCanInterceptBackClick()) {
                AdWebViewActivityProxy.this.mLandingPageView.m29835pn();
            } else if (AdWebViewActivityProxy.this.mDisableShowConfirmDialog) {
                AdWebViewActivityProxy.this.finish();
            } else if (AdWebViewActivityProxy.this.handleMiddlePageDialog()) {
            } else {
                if (AdWebViewActivityProxy.this.mAdTemplate.mIsForceJumpLandingPage) {
                    AdWebViewActivityProxy.this.finish();
                } else if (C10483a.m25947aO(C10487e.m25641dQ(AdWebViewActivityProxy.this.mAdTemplate)) && C8898a.m29651qH().m29650qI() == 1 && C8898a.m29651qH().m29645qN() && !C8898a.m29651qH().m29648qK()) {
                    if (!C8898a.m29651qH().m29649qJ() && C10251d.m26572BV()) {
                        AdWebViewActivityProxy adWebViewActivityProxy = AdWebViewActivityProxy.this;
                        adWebViewActivityProxy.mDialogFragment = adWebViewActivityProxy.getTkDialogFragment();
                        DialogFragmentC8899b.m29643a(AdWebViewActivityProxy.this.mDialogFragment, AdWebViewActivityProxy.this.getActivity(), AdWebViewActivityProxy.this.mBaseDialogListener);
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
    private InterfaceC9291c mBaseDialogListener = new InterfaceC9291c() { // from class: com.kwad.components.core.page.AdWebViewActivityProxy.3
        @Override // com.kwad.components.core.webview.tachikoma.p337e.InterfaceC9291c
        /* renamed from: F */
        public final void mo29100F(boolean z) {
        }

        @Override // com.kwad.components.core.webview.tachikoma.p337e.InterfaceC9291c
        /* renamed from: fR */
        public final void mo29099fR() {
            C8898a.m29651qH().m29653aL(true);
        }

        @Override // com.kwad.components.core.webview.tachikoma.p337e.InterfaceC9291c
        /* renamed from: fZ */
        public final void mo29098fZ() {
            C8898a.m29651qH().m29653aL(false);
        }

        @Override // com.kwad.components.core.webview.tachikoma.p337e.InterfaceC9291c
        /* renamed from: ga */
        public final void mo29097ga() {
        }
    };

    /* renamed from: com.kwad.components.core.page.AdWebViewActivityProxy$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C8777a {

        /* renamed from: Oh */
        private String f28496Oh;

        /* renamed from: Oi */
        private String f28497Oi;

        /* renamed from: Oj */
        private AdResultData f28498Oj;

        /* renamed from: Ok */
        private boolean f28499Ok;

        /* renamed from: Ol */
        private boolean f28500Ol;

        /* renamed from: Om */
        private int f28501Om;

        /* renamed from: On */
        private boolean f28502On;
        private AdTemplate adTemplate;

        /* renamed from: com.kwad.components.core.page.AdWebViewActivityProxy$a$a */
        /* loaded from: E:\fuckcool\tsn\6520572.dex */
        public static class C8778a {

            /* renamed from: Oh */
            private String f28503Oh;

            /* renamed from: Oi */
            private String f28504Oi;

            /* renamed from: Oj */
            private AdResultData f28505Oj;

            /* renamed from: Ol */
            private boolean f28506Ol;

            /* renamed from: Om */
            private int f28507Om = 0;

            /* renamed from: On */
            private boolean f28508On;

            /* renamed from: Oo */
            private boolean f28509Oo;
            private AdTemplate adTemplate;

            /* renamed from: aC */
            public final C8778a m29859aC(boolean z) {
                this.f28509Oo = z;
                return this;
            }

            /* renamed from: aD */
            public final C8778a m29858aD(boolean z) {
                this.f28506Ol = z;
                return this;
            }

            /* renamed from: aE */
            public final C8778a m29857aE(boolean z) {
                this.f28508On = z;
                return this;
            }

            /* renamed from: as */
            public final C8778a m29855as(String str) {
                this.f28503Oh = str;
                return this;
            }

            /* renamed from: at */
            public final C8778a m29854at(String str) {
                this.f28504Oi = str;
                return this;
            }

            /* renamed from: az */
            public final C8778a m29853az(int i) {
                this.f28507Om = i;
                return this;
            }

            /* renamed from: m */
            public final C8778a m29852m(AdResultData adResultData) {
                this.f28505Oj = adResultData;
                return this;
            }

            /* renamed from: pl */
            public final C8777a m29851pl() {
                AdResultData adResultData = this.f28505Oj;
                if (adResultData != null) {
                    return new C8777a(this.f28503Oh, this.f28504Oi, adResultData, this.f28509Oo, this.f28506Ol, this.f28508On, this.f28507Om, (byte) 0);
                }
                return new C8777a(this.f28503Oh, this.f28504Oi, this.adTemplate, this.f28509Oo, this.f28506Ol, this.f28508On, this.f28507Om, (byte) 0);
            }

            /* renamed from: as */
            public final C8778a m29856as(AdTemplate adTemplate) {
                this.adTemplate = adTemplate;
                return this;
            }
        }

        /* synthetic */ C8777a(String str, String str2, AdResultData adResultData, boolean z, boolean z2, boolean z3, int i, byte b) {
            this(str, str2, adResultData, z, z2, z3, i);
        }

        public final AdTemplate getAdTemplate() {
            return this.adTemplate;
        }

        /* renamed from: pf */
        public final String m29865pf() {
            return this.f28496Oh;
        }

        /* renamed from: pg */
        public final String m29864pg() {
            return this.f28497Oi;
        }

        /* renamed from: ph */
        public final int m29863ph() {
            return this.f28501Om;
        }

        /* renamed from: pi */
        public final boolean m29862pi() {
            return this.f28499Ok;
        }

        /* renamed from: pj */
        public final boolean m29861pj() {
            return this.f28502On;
        }

        /* renamed from: pk */
        public final boolean m29860pk() {
            return this.f28500Ol;
        }

        /* synthetic */ C8777a(String str, String str2, AdTemplate adTemplate, boolean z, boolean z2, boolean z3, int i, byte b) {
            this(str, str2, adTemplate, z, z2, z3, i);
        }

        private C8777a(String str, String str2, AdTemplate adTemplate, boolean z, boolean z2, boolean z3, int i) {
            this(str, str2, z, z2, z3, i);
            this.adTemplate = adTemplate;
        }

        private C8777a(String str, String str2, AdResultData adResultData, boolean z, boolean z2, boolean z3, int i) {
            this(str, str2, z, z2, z3, i);
            this.f28498Oj = adResultData;
            this.adTemplate = C10485c.m25661n(adResultData);
        }

        private C8777a(String str, String str2, boolean z, boolean z2, boolean z3, int i) {
            this.f28496Oh = str;
            this.f28497Oi = str2;
            this.f28499Ok = z;
            this.f28500Ol = z2;
            this.f28502On = z3;
            this.f28501Om = i;
        }
    }

    private DialogC8867a buildDialog() {
        return new DialogC8867a(getActivity(), new DialogC8867a.InterfaceC8872a() { // from class: com.kwad.components.core.page.AdWebViewActivityProxy.5
            @Override // com.kwad.components.core.page.widget.DialogC8867a.InterfaceC8872a
            /* renamed from: a */
            public final void mo29705a(DialogInterface dialogInterface) {
                C9908c.m27287p(AdWebViewActivityProxy.this.mAdTemplate, 104);
                dialogInterface.dismiss();
            }

            @Override // com.kwad.components.core.page.widget.DialogC8867a.InterfaceC8872a
            /* renamed from: b */
            public final void mo29704b(DialogInterface dialogInterface) {
                try {
                    AdWebViewActivityProxy.super.onBackPressed();
                } catch (Throwable unused) {
                }
                C9908c.m27287p(AdWebViewActivityProxy.this.mAdTemplate, 105);
            }

            @Override // com.kwad.components.core.page.widget.DialogC8867a.InterfaceC8872a
            /* renamed from: c */
            public final void mo29703c(DialogInterface dialogInterface) {
                C9908c.m27287p(AdWebViewActivityProxy.this.mAdTemplate, 106);
                dialogInterface.dismiss();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DialogFragmentC8899b getTkDialogFragment() {
        DialogFragmentC9274e.C9277b c9277b = new DialogFragmentC9274e.C9277b();
        c9277b.m29132d(this.mAdResultData);
        c9277b.m29138aU(C10484b.m25677dw(this.mAdTemplate));
        c9277b.m29137aW(false);
        c9277b.m29136aX(true);
        return DialogFragmentC8899b.m29642a(c9277b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean handleMiddlePageDialog() {
        boolean z = false;
        if (this.mAdTemplate != null && C10251d.m26572BV()) {
            if (!C11053bg.isNullString(C10483a.m25826ca(this.mAdTemplate)) && C10483a.m25880bZ(this.mAdTemplate)) {
                z = true;
                if (this.mHasShowShowConfirmDialog) {
                    try {
                        super.onBackPressed();
                    } catch (Throwable th) {
                        C10331c.printStackTrace(th);
                    }
                } else {
                    DialogFragmentC8899b tkDialogFragment = getTkDialogFragment();
                    this.mDialogFragment = tkDialogFragment;
                    DialogFragmentC8899b.m29643a(tkDialogFragment, getActivity(), this.mBaseDialogListener);
                    this.mHasShowShowConfirmDialog = true;
                }
            }
            return z;
        }
        return false;
    }

    private void initContentView() {
        C8798c m29840a = C8798c.m29840a(this.mContext, new C8777a.C8778a().m29855as(this.mPageTitle).m29854at(this.mPageUrl).m29856as(this.mAdTemplate).m29859aC(this.mShowPermission).m29858aD(this.mAutoShow).m29853az(this.mLandingPageType).m29857aE(this.mDisableShowConfirmDialog).m29851pl());
        this.mLandingPageView = m29840a;
        m29840a.setLandPageViewListener(this.mLandPageViewListener);
        this.mLandingPageView.setWebCardCloseListener(this.mWebCardCloseListener);
        ((ViewGroup) findViewById(C9659R.C9662id.ksad_land_page_root)).addView(this.mLandingPageView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isFormAdExitInterceptEnable() {
        AdTemplate adTemplate;
        if (this.mShowPermission || (adTemplate = this.mAdTemplate) == null || C10487e.m25654F(adTemplate)) {
            return false;
        }
        if (C10251d.m26552Cc() && this.mAdTemplate.mIsFromContent) {
            return true;
        }
        return C10251d.m26551Cd() && !this.mAdTemplate.mIsFromContent;
    }

    public static void launch(Context context, C8777a c8777a) {
        if (context == null || TextUtils.isEmpty(c8777a.f28497Oi)) {
            return;
        }
        try {
            C9835a.m27554j(c8777a.getAdTemplate(), c8777a.m29863ph(), c8777a.m29864pg());
            C10973b.m24291a(AdWebViewActivity.class, AdWebViewActivityProxy.class);
            Intent intent = new Intent(context, AdWebViewActivity.class);
            intent.addFlags(268435456);
            intent.putExtra(KEY_PAGE_TITLE, c8777a.f28496Oh);
            intent.putExtra(KEY_LANDING_PAGE_TYPE, c8777a.f28501Om);
            intent.putExtra(KEY_PAGE_URL, c8777a.f28497Oi);
            intent.putExtra(KEY_IS_AUTO_SHOW, c8777a.f28500Ol);
            intent.putExtra(KEY_SHOW_PERMISSION, c8777a.f28499Ok);
            intent.putExtra(KEY_SHOW_TK_CONFIRM_DIALOG, c8777a.m29861pj());
            AdResultData adResultData = c8777a.f28498Oj;
            if (adResultData == null) {
                adResultData = C10485c.m25662dB(c8777a.adTemplate);
            }
            intent.putExtra("key_ad_result_cache_idx", C8552f.m30378mE().m30379i(adResultData));
            context.startActivity(intent);
        } catch (Throwable th) {
            C10331c.printStackTraceOnly(th);
            C9835a.m27557a(c8777a.getAdTemplate(), c8777a.m29863ph(), c8777a.m29864pg(), C11064bn.m23856t(th));
            if (C10829k.m24699zd().m24703yp()) {
                ServiceProvider.reportSdkCaughtException(th);
                return;
            }
            throw th;
        }
    }

    @InvokeBy(invokerClass = C10973b.class, methodId = "initComponentProxyForInvoker")
    public static void register() {
        C10973b.m24291a(AdWebViewActivity.class, AdWebViewActivityProxy.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialog() {
        if (this.mKsExitInterceptDialog == null) {
            this.mKsExitInterceptDialog = buildDialog();
        }
        C9908c.m27337b(this.mAdTemplate, 103, (JSONObject) null);
        this.mKsExitInterceptDialog.show();
    }

    @Override // com.kwad.components.core.proxy.AbstractC8886c
    public boolean checkIntentData(@Nullable Intent intent) {
        AdResultData m30380d = C8552f.m30378mE().m30380d(getIntent().getIntExtra("key_ad_result_cache_idx", 0), true);
        this.mAdResultData = m30380d;
        if (m30380d == null) {
            return false;
        }
        AdTemplate m25661n = C10485c.m25661n(m30380d);
        this.mAdTemplate = m25661n;
        return m25661n != null;
    }

    @Override // com.kwad.components.core.proxy.AbstractC8886c
    public int getLayoutId() {
        return 0;
    }

    @Override // com.kwad.components.core.proxy.AbstractC8886c
    public String getPageName() {
        return "AdWebViewActivityProxy";
    }

    @Override // com.kwad.components.core.proxy.AbstractC8886c
    public void initData() {
        this.destroyed = false;
        this.mPageTitle = getIntent().getStringExtra(KEY_PAGE_TITLE);
        this.mLandingPageType = getIntent().getIntExtra(KEY_LANDING_PAGE_TYPE, 0);
        this.mPageUrl = getIntent().getStringExtra(KEY_PAGE_URL);
        this.mAutoShow = getIntent().getBooleanExtra(KEY_IS_AUTO_SHOW, false);
        this.mShowPermission = getIntent().getBooleanExtra(KEY_SHOW_PERMISSION, false);
        this.mDisableShowConfirmDialog = getIntent().getBooleanExtra(KEY_SHOW_TK_CONFIRM_DIALOG, false);
    }

    @Override // com.kwad.components.core.proxy.AbstractC8886c
    public void initView() {
        setContentView(C9659R.C9663layout.ksad_activity_landpage);
        initContentView();
    }

    @Override // com.kwad.components.core.proxy.AbstractC8886c
    public void onActivityCreate() {
        super.onActivityCreate();
        C9835a.m27553k(this.mAdTemplate, this.mLandingPageType, this.mPageUrl);
    }

    @Override // com.kwad.components.core.proxy.AbstractC8886c, com.kwad.sdk.api.proxy.IActivityProxy
    public void onBackPressed() {
        C8798c c8798c = this.mLandingPageView;
        if (c8798c != null && c8798c.getCanInterceptBackClick()) {
            this.mLandingPageView.m29835pn();
        } else if (this.mDisableShowConfirmDialog) {
            finish();
        } else if (handleMiddlePageDialog()) {
        } else {
            AdTemplate adTemplate = this.mAdTemplate;
            if (adTemplate != null && !adTemplate.mIsForceJumpLandingPage) {
                if (C10483a.m25947aO(C10487e.m25641dQ(adTemplate)) && C8898a.m29651qH().m29650qI() == 1 && C8898a.m29651qH().m29645qN() && !C8898a.m29651qH().m29648qK()) {
                    if (!C8898a.m29651qH().m29649qJ() && C10251d.m26572BV()) {
                        DialogFragmentC8899b tkDialogFragment = getTkDialogFragment();
                        this.mDialogFragment = tkDialogFragment;
                        DialogFragmentC8899b.m29643a(tkDialogFragment, getActivity(), this.mBaseDialogListener);
                        return;
                    }
                    super.onBackPressed();
                    return;
                }
                if (isFormAdExitInterceptEnable()) {
                    try {
                        if (this.mKsExitInterceptDialogV2 == null) {
                            this.mKsExitInterceptDialogV2 = new DialogC8867a(getActivity(), new DialogC8867a.InterfaceC8872a() { // from class: com.kwad.components.core.page.AdWebViewActivityProxy.4
                                @Override // com.kwad.components.core.page.widget.DialogC8867a.InterfaceC8872a
                                /* renamed from: a */
                                public final void mo29705a(DialogInterface dialogInterface) {
                                    C9908c.m27287p(AdWebViewActivityProxy.this.mAdTemplate, 104);
                                    dialogInterface.dismiss();
                                }

                                @Override // com.kwad.components.core.page.widget.DialogC8867a.InterfaceC8872a
                                /* renamed from: b */
                                public final void mo29704b(DialogInterface dialogInterface) {
                                    if (!AdWebViewActivityProxy.this.destroyed) {
                                        try {
                                            AdWebViewActivityProxy.super.onBackPressed();
                                        } catch (Throwable th) {
                                            C10331c.printStackTrace(th);
                                        }
                                    }
                                    C9908c.m27287p(AdWebViewActivityProxy.this.mAdTemplate, 105);
                                }

                                @Override // com.kwad.components.core.page.widget.DialogC8867a.InterfaceC8872a
                                /* renamed from: c */
                                public final void mo29703c(DialogInterface dialogInterface) {
                                    C9908c.m27287p(AdWebViewActivityProxy.this.mAdTemplate, 106);
                                    dialogInterface.dismiss();
                                }
                            });
                        }
                        C9908c.m27337b(this.mAdTemplate, 103, (JSONObject) null);
                        this.mKsExitInterceptDialogV2.show();
                        return;
                    } catch (Throwable th) {
                        C10331c.printStackTraceOnly(th);
                    }
                }
                super.onBackPressed();
                return;
            }
            super.onBackPressed();
        }
    }

    @Override // com.kwad.components.core.proxy.AbstractC8886c, com.kwad.sdk.api.proxy.IActivityProxy
    public void onDestroy() {
        try {
            this.destroyed = true;
            DialogFragmentC8899b dialogFragmentC8899b = this.mDialogFragment;
            if (dialogFragmentC8899b != null) {
                dialogFragmentC8899b.dismiss();
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

    @Override // com.kwad.components.core.proxy.AbstractC8886c, com.kwad.sdk.api.proxy.IActivityProxy
    public void onPause() {
        super.onPause();
        overridePendingTransition(0, 0);
    }

    @Override // com.kwad.components.core.proxy.AbstractC8886c, com.kwad.sdk.api.proxy.IActivityProxy
    public void onPreCreate(@Nullable Bundle bundle) {
        super.onPreCreate(bundle);
        try {
            getIntent().removeExtra("key_template");
        } catch (Throwable unused) {
        }
    }

    @Override // com.kwad.components.core.proxy.AbstractC8886c, com.kwad.sdk.api.proxy.IActivityProxy
    public void onResume() {
        super.onResume();
    }

    public static void launch(Context context, AdTemplate adTemplate) {
        launch(context, new C8777a.C8778a().m29854at(C10484b.m25790cB(adTemplate)).m29856as(adTemplate).m29851pl());
    }
}

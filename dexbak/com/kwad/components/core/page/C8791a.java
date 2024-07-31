package com.kwad.components.core.page;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.Nullable;
import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.components.core.p286b.C8542b;
import com.kwad.components.core.p286b.View$OnClickListenerC8540a;
import com.kwad.components.core.p289e.p293d.C8619c;
import com.kwad.components.core.playable.C8874a;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.components.core.proxy.AbstractC8889f;
import com.kwad.components.core.webview.jshandler.C9092aq;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.api.proxy.app.BaseFragmentActivity;
import com.kwad.sdk.core.adlog.C9908c;
import com.kwad.sdk.core.adlog.p388c.C9913b;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.service.C10973b;
import com.kwad.sdk.service.ServiceProvider;
import org.json.JSONObject;

/* renamed from: com.kwad.components.core.page.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C8791a extends AbstractC8889f implements View$OnClickListenerC8540a.InterfaceC8541a, C9092aq.InterfaceC9095b {

    /* renamed from: NX */
    private boolean f28525NX = true;
    private AdTemplate mAdTemplate;
    private C8619c mApkDownloadHelper;
    private AdBaseFrameLayout mRootContainer;
    private View$OnClickListenerC8540a mTitleBarHelper;

    /* renamed from: oL */
    private C8874a f28526oL;

    /* renamed from: b */
    private void m29850b(Intent intent) {
        String stringExtra = intent.getStringExtra("key_template_json");
        if (TextUtils.isEmpty(stringExtra)) {
            return;
        }
        try {
            this.mAdTemplate = new AdTemplate();
            this.mAdTemplate.parseJson(new JSONObject(stringExtra));
            this.mApkDownloadHelper = new C8619c(this.mAdTemplate);
        } catch (Exception e) {
            C10331c.printStackTraceOnly(e);
        }
    }

    public static void launch(Context context, AdTemplate adTemplate) {
        C10973b.m24291a(BaseFragmentActivity.FragmentActivity8.class, C8791a.class);
        Intent intent = new Intent(context, BaseFragmentActivity.FragmentActivity8.class);
        intent.putExtra("key_template_json", adTemplate.toJson().toString());
        context.startActivity(intent);
    }

    /* renamed from: pb */
    private void m29849pb() {
        View$OnClickListenerC8540a view$OnClickListenerC8540a = new View$OnClickListenerC8540a(this.mRootContainer);
        this.mTitleBarHelper = view$OnClickListenerC8540a;
        view$OnClickListenerC8540a.m30412a(this);
        this.mTitleBarHelper.m30411a(new C8542b(""));
    }

    @InvokeBy(invokerClass = C10973b.class, methodId = "initComponentProxyForInvoker")
    public static void register() {
        C10973b.m24291a(BaseFragmentActivity.FragmentActivity8.class, C8791a.class);
    }

    @Override // com.kwad.components.core.webview.jshandler.C9092aq.InterfaceC9095b
    /* renamed from: a */
    public final void mo28994a(C9092aq.C9094a c9094a) {
        C8874a c8874a;
        C10331c.m26254d("AdPlayableActivityProxy", "updatePageStatus status: " + c9094a);
        if (c9094a.status != 1 || (c8874a = this.f28526oL) == null) {
            return;
        }
        c8874a.m29687e(PlayableSource.UNKNOWN_TRYPLAY_ENTRY_SOURCE);
    }

    @Override // com.kwad.components.core.proxy.AbstractC8889f
    public String getPageName() {
        return "AdPlayableActivityProxy";
    }

    @Override // com.kwad.components.core.proxy.AbstractC8889f, com.kwad.sdk.api.proxy.IActivityProxy
    public void onCreate(@Nullable Bundle bundle) {
        try {
            super.onCreate(bundle);
            getActivity().setTheme(C9659R.C9665style.Theme_AppCompat_Light_NoActionBar);
            setContentView(C9659R.C9663layout.ksad_activity_playable);
            m29850b(getIntent());
            this.mRootContainer = (AdBaseFrameLayout) findViewById(C9659R.C9662id.ksad_playable_activity_root);
            m29849pb();
            C8874a c8874a = new C8874a((KsAdWebView) findViewById(C9659R.C9662id.ksad_playable_webview));
            this.f28526oL = c8874a;
            c8874a.m29698a(this.mAdTemplate, this.mRootContainer, this.mApkDownloadHelper);
            this.f28526oL.m29699a(this);
            this.f28526oL.m29682qe();
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    @Override // com.kwad.components.core.proxy.AbstractC8889f, com.kwad.sdk.api.proxy.IActivityProxy
    public void onDestroy() {
        try {
            super.onDestroy();
            this.f28526oL.m29690b(this);
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onPause() {
        super.onPause();
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onRestart() {
        super.onRestart();
    }

    @Override // com.kwad.components.core.proxy.AbstractC8889f, com.kwad.sdk.api.proxy.IActivityProxy
    public void onResume() {
        super.onResume();
    }

    @Override // com.kwad.components.core.p286b.View$OnClickListenerC8540a.InterfaceC8541a
    /* renamed from: u */
    public final void mo29634u(View view) {
        onBackPressed();
    }

    @Override // com.kwad.components.core.p286b.View$OnClickListenerC8540a.InterfaceC8541a
    /* renamed from: v */
    public final void mo29633v(View view) {
        C9908c.m27334b(this.mAdTemplate, new C9913b().m27265cL(6), (JSONObject) null);
        finish();
    }
}

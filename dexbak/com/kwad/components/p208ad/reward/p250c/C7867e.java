package com.kwad.components.p208ad.reward.p250c;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.response.p408a.C10482a;
import com.kwad.sdk.core.webview.p422c.InterfaceC10625a;
import com.kwad.sdk.core.webview.p422c.InterfaceC10627c;

/* renamed from: com.kwad.components.ad.reward.c.e */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C7867e implements InterfaceC10625a {
    private String TAG;

    /* renamed from: ns */
    private InterfaceC10627c f26486ns;

    @KsJson
    /* renamed from: com.kwad.components.ad.reward.c.e$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C7868a extends C10482a {

        /* renamed from: rq */
        public String f26487rq;
    }

    public C7867e() {
        String str = "ExtraDialogListener" + hashCode();
        this.TAG = str;
        C10331c.m26254d(str, "create: ");
    }

    /* renamed from: E */
    private void m32125E(String str) {
        if (TextUtils.isEmpty(str) || this.f26486ns == null) {
            return;
        }
        C7868a c7868a = new C7868a();
        c7868a.f26487rq = str;
        this.f26486ns.mo25251a(c7868a);
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    /* renamed from: a */
    public final void mo25241a(String str, @NonNull InterfaceC10627c interfaceC10627c) {
        String str2 = this.TAG;
        C10331c.m26254d(str2, "handleJsCall: " + interfaceC10627c);
        this.f26486ns = interfaceC10627c;
    }

    /* renamed from: gQ */
    public final void m32124gQ() {
        C10331c.m26254d(this.TAG, "notifyDialogClose: ");
        m32125E("close");
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    @NonNull
    public final String getKey() {
        return "registerExtraDialogListener";
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    public final void onDestroy() {
        C10331c.m26254d(this.TAG, "onDestroy: ");
        this.f26486ns = null;
    }
}

package com.kwad.components.core.webview.jshandler;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.components.core.webview.jshandler.C9174s;
import com.kwad.sdk.core.webview.p422c.InterfaceC10625a;
import com.kwad.sdk.core.webview.p422c.InterfaceC10627c;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.C11137y;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.kwad.components.core.webview.jshandler.r */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9173r implements InterfaceC10625a {
    /* renamed from: aJ */
    private static boolean m29218aJ(String str) {
        C9174s.C9175a c9175a = new C9174s.C9175a();
        try {
            c9175a.parseJson(new JSONObject(str));
        } catch (JSONException unused) {
        }
        if (TextUtils.isEmpty(c9175a.key)) {
            return false;
        }
        C11137y.m23574h(ServiceProvider.getContext(), "ksadsdk_js_storage_cache_name", c9175a.key);
        return true;
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    /* renamed from: a */
    public final void mo25241a(String str, @NonNull InterfaceC10627c interfaceC10627c) {
        if (!TextUtils.isEmpty(str)) {
            if (m29218aJ(str)) {
                interfaceC10627c.mo25251a(null);
                return;
            } else {
                interfaceC10627c.onError(-1, "");
                return;
            }
        }
        interfaceC10627c.onError(-1, "data is empty");
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    @NonNull
    public final String getKey() {
        return "removeStorageItem";
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    public final void onDestroy() {
    }
}

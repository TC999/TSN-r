package com.kwad.components.core.webview.jshandler;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.response.p408a.C10482a;
import com.kwad.sdk.core.webview.p422c.InterfaceC10625a;
import com.kwad.sdk.core.webview.p422c.InterfaceC10627c;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.C11137y;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.kwad.components.core.webview.jshandler.s */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9174s implements InterfaceC10625a {

    @KsJson
    /* renamed from: com.kwad.components.core.webview.jshandler.s$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C9175a extends C10482a {
        public String key;
        public String value;
    }

    /* renamed from: aK */
    private static boolean m29217aK(String str) {
        C9175a c9175a = new C9175a();
        try {
            c9175a.parseJson(new JSONObject(str));
        } catch (JSONException unused) {
        }
        if (TextUtils.isEmpty(c9175a.key) || TextUtils.isEmpty(c9175a.value)) {
            return false;
        }
        C11137y.m23614a(ServiceProvider.getContext(), "ksadsdk_js_storage_cache_name", c9175a.key, c9175a.value);
        return true;
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    /* renamed from: a */
    public final void mo25241a(String str, @NonNull InterfaceC10627c interfaceC10627c) {
        if (!TextUtils.isEmpty(str)) {
            if (m29217aK(str)) {
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
        return "setStorageItem";
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    public final void onDestroy() {
    }
}

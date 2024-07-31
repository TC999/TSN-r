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

/* renamed from: com.kwad.components.core.webview.jshandler.i */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9154i implements InterfaceC10625a {
    /* renamed from: aI */
    private static String m29231aI(String str) {
        C9174s.C9175a c9175a = new C9174s.C9175a();
        try {
            c9175a.parseJson(new JSONObject(str));
        } catch (JSONException unused) {
        }
        return TextUtils.isEmpty(c9175a.key) ? "" : C11137y.m23592b(ServiceProvider.getContext(), "ksadsdk_js_storage_cache_name", c9175a.key, "");
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    /* renamed from: a */
    public final void mo25241a(String str, @NonNull InterfaceC10627c interfaceC10627c) {
        if (!TextUtils.isEmpty(str)) {
            String m29231aI = m29231aI(str);
            C9174s.C9175a c9175a = new C9174s.C9175a();
            c9175a.value = m29231aI;
            interfaceC10627c.mo25251a(c9175a);
            return;
        }
        interfaceC10627c.onError(-1, "data is empty");
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    @NonNull
    public final String getKey() {
        return "getStorageItem";
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    public final void onDestroy() {
    }
}

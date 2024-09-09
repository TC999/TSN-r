package com.kwad.components.core.webview.jshandler;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.components.core.webview.jshandler.s;
import com.kwad.sdk.service.ServiceProvider;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class r implements com.kwad.sdk.core.webview.c.a {
    private static boolean aJ(String str) {
        s.a aVar = new s.a();
        try {
            aVar.parseJson(new JSONObject(str));
        } catch (JSONException unused) {
        }
        if (TextUtils.isEmpty(aVar.key)) {
            return false;
        }
        com.kwad.sdk.utils.y.h(ServiceProvider.getContext(), "ksadsdk_js_storage_cache_name", aVar.key);
        return true;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        if (!TextUtils.isEmpty(str)) {
            if (aJ(str)) {
                cVar.a(null);
                return;
            } else {
                cVar.onError(-1, "");
                return;
            }
        }
        cVar.onError(-1, "data is empty");
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "removeStorageItem";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }
}

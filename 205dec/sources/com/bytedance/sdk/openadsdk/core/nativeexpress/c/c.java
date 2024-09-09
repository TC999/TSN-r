package com.bytedance.sdk.openadsdk.core.nativeexpress.c;

import android.os.Build;
import android.text.TextUtils;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.bytedance.sdk.component.adexpress.sr.r;
import com.bytedance.sdk.component.utils.a;
import com.bytedance.sdk.openadsdk.core.u.gb;
import com.bytedance.sdk.openadsdk.core.u.me;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class c {

    /* renamed from: com.bytedance.sdk.openadsdk.core.nativeexpress.c.c$c  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public interface InterfaceC0500c {
        com.bytedance.sdk.component.adexpress.c.w.c c(String str, r.c cVar, String str2);

        boolean c();
    }

    public static com.bytedance.sdk.component.adexpress.c.w.c c(WebView webView, me meVar, String str, InterfaceC0500c interfaceC0500c) {
        gb gbVar;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        r.c c4 = r.c(str);
        boolean z3 = interfaceC0500c != null && interfaceC0500c.c();
        if (c4 != r.c.IMAGE && z3 && meVar != null) {
            Iterator<gb> it = meVar.nc().iterator();
            while (it.hasNext()) {
                gbVar = it.next();
                if (!TextUtils.isEmpty(gbVar.c()) && !TextUtils.isEmpty(str)) {
                    String c5 = gbVar.c();
                    if (c5.startsWith("https")) {
                        c5 = c5.replaceFirst("https", "http");
                    }
                    if ((str.startsWith("https") ? str.replaceFirst("https", "http") : str).equals(c5)) {
                        break;
                    }
                }
            }
        }
        gbVar = null;
        if (c4 == r.c.IMAGE) {
            com.bytedance.sdk.component.adexpress.c.w.c cVar = new com.bytedance.sdk.component.adexpress.c.w.c();
            cVar.c(5);
            cVar.c(c(str, w.c(meVar, str)));
            return cVar;
        } else if (gbVar == null) {
            if (interfaceC0500c == null) {
                return null;
            }
            return interfaceC0500c.c(str, c4, "");
        } else {
            com.bytedance.sdk.component.adexpress.c.w.c cVar2 = new com.bytedance.sdk.component.adexpress.c.w.c();
            cVar2.c(c(str, gbVar.r()));
            cVar2.c(5);
            return cVar2;
        }
    }

    private static WebResourceResponse c(String str, String str2) {
        WebResourceResponse webResourceResponse = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            InputStream c4 = com.bytedance.sdk.openadsdk.r.w.c(str, str2);
            if (c4 != null) {
                WebResourceResponse webResourceResponse2 = new WebResourceResponse(r.c.IMAGE.getType(), "utf-8", c4);
                try {
                    if (Build.VERSION.SDK_INT >= 21) {
                        Map<String, String> responseHeaders = webResourceResponse2.getResponseHeaders();
                        if (responseHeaders == null) {
                            responseHeaders = new HashMap<>();
                        }
                        responseHeaders.put("Access-Control-Allow-Origin", "*");
                        webResourceResponse2.setResponseHeaders(responseHeaders);
                    }
                    return webResourceResponse2;
                } catch (Throwable th) {
                    th = th;
                    webResourceResponse = webResourceResponse2;
                    a.xv("CacheInterceptUtil", "get image WebResourceResponse error", th);
                    return webResourceResponse;
                }
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
        }
    }
}

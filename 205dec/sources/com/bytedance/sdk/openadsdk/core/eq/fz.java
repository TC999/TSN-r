package com.bytedance.sdk.openadsdk.core.eq;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.WebView;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class fz {
    public static void c(final Uri uri, final com.bytedance.sdk.openadsdk.core.xk xkVar) {
        if (xkVar == null || !xkVar.c(uri)) {
            return;
        }
        try {
            com.bytedance.sdk.component.utils.ev.c().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.eq.fz.1
                @Override // java.lang.Runnable
                public void run() {
                    com.bytedance.sdk.openadsdk.core.xk.this.w(uri);
                }
            });
        } catch (Exception e4) {
            com.bytedance.sdk.component.utils.a.sr("WebView", "TTAndroidObj handleUri exception: " + e4);
        }
    }

    public static String c(WebView webView, int i4, boolean z3) {
        if (webView == null) {
            return "";
        }
        String userAgentString = webView.getSettings().getUserAgentString();
        if (TextUtils.isEmpty(userAgentString)) {
            return "";
        }
        StringBuilder sb = new StringBuilder(userAgentString);
        sb.append(" open_news");
        sb.append(" open_news_u_s/");
        sb.append(i4);
        if (z3) {
            sb.append(TTPathConst.sSeparator);
            sb.append(wv.ev());
        }
        return sb.toString();
    }
}

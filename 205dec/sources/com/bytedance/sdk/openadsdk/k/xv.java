package com.bytedance.sdk.openadsdk.k;

import android.os.Build;
import android.text.TextUtils;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.bytedance.sdk.component.utils.a;
import com.bytedance.sdk.openadsdk.core.ls;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.mbridge.msdk.mbbid.common.BidResponsedEx;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class xv implements w {

    /* renamed from: c  reason: collision with root package name */
    private c f35944c;

    private xv(String str, String str2, String str3, String str4) {
        if (c()) {
            sr srVar = new sr(this, str, str2, str3, str4);
            this.f35944c = srVar;
            srVar.w();
        }
    }

    public static boolean c() {
        return Build.VERSION.SDK_INT >= 21;
    }

    public void w() {
        c cVar;
        if (c()) {
            a.w("weblp", "destroy.");
            if (ls.w().eq() != 1 || (cVar = this.f35944c) == null) {
                return;
            }
            cVar.ux();
        }
    }

    public static xv c(me meVar, String str) {
        if (c() && meVar != null) {
            String cf = meVar.cf();
            if (!TextUtils.isEmpty(cf)) {
                try {
                    JSONObject jSONObject = new JSONObject(cf);
                    String optString = jSONObject.optString(BidResponsedEx.KEY_CID);
                    if (TextUtils.isEmpty(optString)) {
                        return null;
                    }
                    String optString2 = jSONObject.optString("req_id");
                    if (TextUtils.isEmpty(optString2)) {
                        return null;
                    }
                    return new xv(optString, optString2, cf, str);
                } catch (JSONException e4) {
                    e4.printStackTrace();
                }
            }
        }
        return null;
    }

    public WebResourceResponse c(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        c cVar;
        return (!c() || (cVar = this.f35944c) == null) ? webResourceResponse : cVar.c(webView, webResourceRequest, webResourceResponse);
    }

    public void c(WebView webView, String str) {
        c cVar;
        if (!c() || (cVar = this.f35944c) == null) {
            return;
        }
        cVar.c(webView, str);
    }
}

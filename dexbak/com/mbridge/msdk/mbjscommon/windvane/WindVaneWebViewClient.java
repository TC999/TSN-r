package com.mbridge.msdk.mbjscommon.windvane;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.mbridge.msdk.foundation.controller.MBSDKContext;
import com.mbridge.msdk.foundation.same.p476c.CommonBitmapUtil;
import com.mbridge.msdk.foundation.same.p476c.CommonImageLoader;
import com.mbridge.msdk.foundation.tools.SameLogTool;
import com.mbridge.msdk.mbjscommon.base.BaseWebViewClient;

/* renamed from: com.mbridge.msdk.mbjscommon.windvane.m */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class WindVaneWebViewClient extends BaseWebViewClient {

    /* renamed from: b */
    public static boolean f31593b = true;

    /* renamed from: a */
    protected String f31594a = null;

    /* renamed from: c */
    private int f31595c = 0;

    /* renamed from: d */
    private IWebViewListener f31596d;

    /* renamed from: a */
    private WebResourceResponse m21371a(String str) {
        try {
            if (TextUtils.isEmpty(str) || !WindVaneUtil.m21375d(str)) {
                return null;
            }
            SameLogTool.m21736b("WindVaneWebViewClient", "is image " + str);
            Bitmap m22341a = CommonImageLoader.m22343a(MBSDKContext.m22865f().m22861j()).m22341a(str);
            SameLogTool.m21736b("WindVaneWebViewClient", "find image from cache " + str);
            if (m22341a == null || m22341a.isRecycled()) {
                return null;
            }
            return new WebResourceResponse(WindVaneUtil.m21374e(str), "utf-8", CommonBitmapUtil.m22346a(m22341a));
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        this.f31594a = str;
        IWebViewListener iWebViewListener = this.f31596d;
        if (iWebViewListener != null) {
            iWebViewListener.mo21400a(webView, str, bitmap);
        }
    }

    @Override // android.webkit.WebViewClient
    public final WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        WebResourceResponse m21371a = m21371a(str);
        if (m21371a != null) {
            SameLogTool.m21736b("WindVaneWebViewClient", "find WebResourceResponse url is " + str);
            return m21371a;
        }
        return super.shouldInterceptRequest(webView, str);
    }
}

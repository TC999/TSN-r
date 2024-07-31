package com.mbridge.msdk.mbjscommon.windvane;

import android.text.TextUtils;

/* renamed from: com.mbridge.msdk.mbjscommon.windvane.e */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class MVCallJs {

    /* renamed from: a */
    private static MVCallJs f31561a = new MVCallJs();

    private MVCallJs() {
    }

    /* renamed from: a */
    public static MVCallJs m21396a() {
        return f31561a;
    }

    /* renamed from: a */
    public final void m21395a(Object obj, String str) {
        if (obj instanceof CallMethodContext) {
            CallMethodContext callMethodContext = (CallMethodContext) obj;
            String format = TextUtils.isEmpty(str) ? String.format("javascript:window.OfferWall.onSuccess(%s,'');", callMethodContext.f31560g) : String.format("javascript:window.OfferWall.onSuccess(%s,'%s');", callMethodContext.f31560g, WindVaneUtil.m21376c(str));
            WindVaneWebView windVaneWebView = callMethodContext.f31554a;
            if (windVaneWebView != null) {
                try {
                    windVaneWebView.loadUrl(format);
                } catch (Exception e) {
                    e.printStackTrace();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    }
}

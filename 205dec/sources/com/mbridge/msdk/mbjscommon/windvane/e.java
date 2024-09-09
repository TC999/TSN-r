package com.mbridge.msdk.mbjscommon.windvane;

import android.text.TextUtils;

/* compiled from: MVCallJs.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    private static e f40333a = new e();

    private e() {
    }

    public static e a() {
        return f40333a;
    }

    public final void a(Object obj, String str) {
        if (obj instanceof a) {
            a aVar = (a) obj;
            String format = TextUtils.isEmpty(str) ? String.format("javascript:window.OfferWall.onSuccess(%s,'');", aVar.f40332g) : String.format("javascript:window.OfferWall.onSuccess(%s,'%s');", aVar.f40332g, k.c(str));
            WindVaneWebView windVaneWebView = aVar.f40326a;
            if (windVaneWebView != null) {
                try {
                    windVaneWebView.loadUrl(format);
                } catch (Exception e4) {
                    e4.printStackTrace();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    }
}

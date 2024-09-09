package com.kwad.sdk.core.network.a;

import android.util.Log;
import com.kwad.sdk.export.proxy.AdHttpProxy;
import com.kwad.sdk.export.proxy.AdHttpResponseListener;
import com.kwad.sdk.f;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.h;
import java.io.OutputStream;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class a {
    private static AdHttpProxy awt;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* renamed from: com.kwad.sdk.core.network.a.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class C0699a {
        public String msg;
    }

    private static boolean DR() {
        h hVar = (h) ServiceProvider.get(h.class);
        if (hVar != null) {
            return hVar.yP();
        }
        return false;
    }

    public static boolean a(String str, OutputStream outputStream, C0699a c0699a, long j4, AdHttpResponseListener adHttpResponseListener) {
        AdHttpProxy aVar;
        boolean DR = DR();
        AdHttpProxy adHttpProxy = awt;
        if (adHttpProxy == null) {
            com.kwad.sdk.core.e.c.d("VideoCacheHelper", "isAdCacheEnable:" + DR);
            if (DR) {
                aVar = f.xT();
            } else {
                aVar = new com.kwad.sdk.core.network.c.a();
            }
            adHttpProxy = aVar;
            awt = adHttpProxy;
        }
        AdHttpProxy adHttpProxy2 = adHttpProxy;
        if (com.kwad.framework.b.a.md.booleanValue()) {
            if (adHttpProxy2 instanceof com.kwad.sdk.core.network.c.b) {
                com.kwad.sdk.core.e.c.d("VideoCacheHelper", "okHttp");
            } else {
                com.kwad.sdk.core.e.c.d("VideoCacheHelper", "Http");
            }
        }
        try {
            com.kwad.sdk.core.e.c.d("VideoCacheHelper", "downloadUrlToStream success size:" + j4 + " url:" + str);
            adHttpProxy2.downloadUrlToStream(str, outputStream, j4, adHttpResponseListener);
            return true;
        } catch (Exception e4) {
            com.kwad.sdk.core.e.c.d("VideoCacheHelper", Log.getStackTraceString(e4));
            c0699a.msg = e4.getMessage();
            return false;
        }
    }
}

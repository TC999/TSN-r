package com.kwad.sdk.core.network.p404a;

import android.util.Log;
import com.kwad.framework.p347b.C9426a;
import com.kwad.sdk.C10756f;
import com.kwad.sdk.core.network.p406c.C10416a;
import com.kwad.sdk.core.network.p406c.C10417b;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.export.proxy.AdHttpProxy;
import com.kwad.sdk.export.proxy.AdHttpResponseListener;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.p449a.InterfaceC10970h;
import java.io.OutputStream;

/* renamed from: com.kwad.sdk.core.network.a.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10404a {
    private static AdHttpProxy awt;

    /* renamed from: com.kwad.sdk.core.network.a.a$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C10405a {
        public String msg;
    }

    /* renamed from: DR */
    private static boolean m26174DR() {
        InterfaceC10970h interfaceC10970h = (InterfaceC10970h) ServiceProvider.get(InterfaceC10970h.class);
        if (interfaceC10970h != null) {
            return interfaceC10970h.mo24308yP();
        }
        return false;
    }

    /* renamed from: a */
    public static boolean m26173a(String str, OutputStream outputStream, C10405a c10405a, long j, AdHttpResponseListener adHttpResponseListener) {
        AdHttpProxy c10416a;
        boolean m26174DR = m26174DR();
        AdHttpProxy adHttpProxy = awt;
        if (adHttpProxy == null) {
            C10331c.m26254d("VideoCacheHelper", "isAdCacheEnable:" + m26174DR);
            if (m26174DR) {
                c10416a = C10756f.m24902xT();
            } else {
                c10416a = new C10416a();
            }
            adHttpProxy = c10416a;
            awt = adHttpProxy;
        }
        AdHttpProxy adHttpProxy2 = adHttpProxy;
        if (C9426a.f29474md.booleanValue()) {
            if (adHttpProxy2 instanceof C10417b) {
                C10331c.m26254d("VideoCacheHelper", "okHttp");
            } else {
                C10331c.m26254d("VideoCacheHelper", "Http");
            }
        }
        try {
            C10331c.m26254d("VideoCacheHelper", "downloadUrlToStream success size:" + j + " url:" + str);
            adHttpProxy2.downloadUrlToStream(str, outputStream, j, adHttpResponseListener);
            return true;
        } catch (Exception e) {
            C10331c.m26254d("VideoCacheHelper", Log.getStackTraceString(e));
            c10405a.msg = e.getMessage();
            return false;
        }
    }
}

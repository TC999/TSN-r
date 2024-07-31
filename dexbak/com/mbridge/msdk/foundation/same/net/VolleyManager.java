package com.mbridge.msdk.foundation.same.net;

import android.content.Context;
import com.mbridge.msdk.foundation.controller.MBSDKContext;
import com.mbridge.msdk.foundation.same.net.p483d.FileDownloader;
import com.stub.StubApp;

/* renamed from: com.mbridge.msdk.foundation.same.net.n */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class VolleyManager {

    /* renamed from: c */
    private static VolleyManager f30871c;

    /* renamed from: a */
    private RequestQueue f30872a;

    /* renamed from: b */
    private FileDownloader f30873b;

    private VolleyManager() {
    }

    /* renamed from: a */
    public static void m22159a(Context context) {
        if (f30871c == null) {
            VolleyManager volleyManager = new VolleyManager();
            f30871c = volleyManager;
            volleyManager.f30872a = new RequestQueue(StubApp.getOrigApplicationContext(context.getApplicationContext()));
            f30871c.f30873b = new FileDownloader(m22157b(), 3);
        }
    }

    /* renamed from: b */
    private static RequestQueue m22157b() {
        VolleyManager volleyManager = f30871c;
        if (volleyManager != null) {
            RequestQueue requestQueue = volleyManager.f30872a;
            if (requestQueue != null) {
                return requestQueue;
            }
            volleyManager.f30872a = new RequestQueue(MBSDKContext.m22865f().m22861j());
            return f30871c.f30872a;
        }
        VolleyManager volleyManager2 = new VolleyManager();
        f30871c = volleyManager2;
        if (volleyManager2.f30872a == null) {
            volleyManager2.f30872a = new RequestQueue(MBSDKContext.m22865f().m22861j());
        }
        return f30871c.f30872a;
    }

    /* renamed from: a */
    public static void m22158a(AbstractC11354i abstractC11354i) {
        m22157b().m22180a(abstractC11354i);
    }

    /* renamed from: a */
    public static FileDownloader m22160a() {
        VolleyManager volleyManager = f30871c;
        if (volleyManager != null) {
            FileDownloader fileDownloader = volleyManager.f30873b;
            if (fileDownloader != null) {
                return fileDownloader;
            }
            volleyManager.f30873b = new FileDownloader(m22157b(), 3);
            return f30871c.f30873b;
        }
        VolleyManager volleyManager2 = new VolleyManager();
        f30871c = volleyManager2;
        if (volleyManager2.f30873b == null) {
            volleyManager2.f30873b = new FileDownloader(m22157b(), 3);
        }
        return f30871c.f30873b;
    }
}

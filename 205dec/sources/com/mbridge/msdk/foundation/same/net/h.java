package com.mbridge.msdk.foundation.same.net;

import android.content.Context;
import android.os.Process;
import com.mbridge.msdk.foundation.same.net.stack.OkHttpStack;
import com.mbridge.msdk.foundation.tools.x;
import javax.net.ssl.SSLSocketFactory;

/* compiled from: NetworkDispatcher.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    private static final String f39606a = "h";

    /* renamed from: b  reason: collision with root package name */
    private com.mbridge.msdk.foundation.same.net.stack.a f39607b = new OkHttpStack();

    /* renamed from: c  reason: collision with root package name */
    private g f39608c;

    /* renamed from: d  reason: collision with root package name */
    private c f39609d;

    public h(Context context, SSLSocketFactory sSLSocketFactory, c cVar) {
        this.f39608c = new com.mbridge.msdk.foundation.same.net.e.a(this.f39607b, cVar);
        this.f39609d = cVar;
    }

    public final void a(i iVar) {
        Process.setThreadPriority(10);
        try {
            String str = f39606a;
            x.b(str, "network-queue-take request=" + iVar.b());
            this.f39609d.c(iVar);
            if (iVar.c()) {
                iVar.a("network-discard-cancelled");
                this.f39609d.b(iVar);
                this.f39609d.a(iVar);
            } else {
                this.f39609d.d(iVar);
                com.mbridge.msdk.foundation.same.net.e.c a4 = this.f39608c.a(iVar);
                x.b(str, "network-http-complete networkResponse=" + a4.f39545a);
                k<?> a5 = iVar.a(a4);
                x.b(str, "network-parse-complete response=" + a5.f39628a);
                this.f39609d.a(iVar, a5);
            }
        } catch (com.mbridge.msdk.foundation.same.net.a.a e4) {
            this.f39609d.a(iVar, e4);
        } catch (Exception e5) {
            String str2 = f39606a;
            x.d(str2, "Unhandled exception " + e5.getMessage());
            this.f39609d.a(iVar, new com.mbridge.msdk.foundation.same.net.a.a(4, null));
        }
    }
}

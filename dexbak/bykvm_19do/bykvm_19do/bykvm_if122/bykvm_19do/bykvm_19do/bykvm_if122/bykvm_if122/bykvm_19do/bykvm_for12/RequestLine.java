package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12;

import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.HttpUrl;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.Request;
import io.netty.handler.codec.http.HttpConstants;
import java.net.Proxy;

/* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12.i */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class RequestLine {
    /* renamed from: a */
    public static String m58748a(Request request, Proxy.Type type) {
        StringBuilder sb = new StringBuilder();
        sb.append(request.m58207e());
        sb.append(HttpConstants.SP_CHAR);
        if (m58747b(request, type)) {
            sb.append(request.m58205g());
        } else {
            sb.append(m58749a(request.m58205g()));
        }
        sb.append(" HTTP/1.1");
        return sb.toString();
    }

    /* renamed from: b */
    private static boolean m58747b(Request request, Proxy.Type type) {
        return !request.m58208d() && type == Proxy.Type.HTTP;
    }

    /* renamed from: a */
    public static String m58749a(HttpUrl httpUrl) {
        String m58314c = httpUrl.m58314c();
        String m58310e = httpUrl.m58310e();
        if (m58310e != null) {
            return m58314c + '?' + m58310e;
        }
        return m58314c;
    }
}

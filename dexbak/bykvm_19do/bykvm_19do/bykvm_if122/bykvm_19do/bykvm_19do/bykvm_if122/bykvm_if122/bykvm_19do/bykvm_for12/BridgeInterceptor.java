package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12;

import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.GzipSource;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.Okio;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.Cookie;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.CookieJar;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.Interceptor;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.MediaType;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.Request;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.RequestBody;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.Response;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.C1061c;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.Version;
import io.netty.handler.codec.http.HttpHeaders;
import java.io.IOException;
import java.util.List;

/* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12.a */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class BridgeInterceptor implements Interceptor {

    /* renamed from: a */
    private final CookieJar f930a;

    public BridgeInterceptor(CookieJar cookieJar) {
        this.f930a = cookieJar;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.Interceptor
    /* renamed from: a */
    public Response mo58275a(Interceptor.InterfaceC1079a interfaceC1079a) throws IOException {
        Request mo58272b = interfaceC1079a.mo58272b();
        Request.C1083a m58206f = mo58272b.m58206f();
        RequestBody m58212a = mo58272b.m58212a();
        if (m58212a != null) {
            MediaType mo58187b = m58212a.mo58187b();
            if (mo58187b != null) {
                m58206f.m58193b("Content-Type", mo58187b.toString());
            }
            long mo58189a = m58212a.mo58189a();
            if (mo58189a != -1) {
                m58206f.m58193b("Content-Length", Long.toString(mo58189a));
                m58206f.m58198a(HttpHeaders.Names.TRANSFER_ENCODING);
            } else {
                m58206f.m58193b(HttpHeaders.Names.TRANSFER_ENCODING, HttpHeaders.Values.CHUNKED);
                m58206f.m58198a("Content-Length");
            }
        }
        boolean z = false;
        if (mo58272b.m58211a("Host") == null) {
            m58206f.m58193b("Host", C1061c.m58476a(mo58272b.m58205g(), false));
        }
        if (mo58272b.m58211a("Connection") == null) {
            m58206f.m58193b("Connection", "Keep-Alive");
        }
        if (mo58272b.m58211a("Accept-Encoding") == null && mo58272b.m58211a("Range") == null) {
            z = true;
            m58206f.m58193b("Accept-Encoding", "gzip");
        }
        List<Cookie> mo58379a = this.f930a.mo58379a(mo58272b.m58205g());
        if (!mo58379a.isEmpty()) {
            m58206f.m58193b(HttpHeaders.Names.COOKIE, m58774a(mo58379a));
        }
        if (mo58272b.m58211a("User-Agent") == null) {
            m58206f.m58193b("User-Agent", Version.m58447a());
        }
        Response mo58273a = interfaceC1079a.mo58273a(m58206f.m58204a());
        HttpHeaders.m58770a(this.f930a, mo58272b.m58205g(), mo58273a.m58844e());
        Response.C1017a m58828a = mo58273a.m58841h().m58828a(mo58272b);
        if (z && "gzip".equalsIgnoreCase(mo58273a.m58849a("Content-Encoding")) && HttpHeaders.m58765b(mo58273a)) {
            GzipSource gzipSource = new GzipSource(mo58273a.m58850a().mo58750c());
            m58828a.m58830a(mo58273a.m58844e().m58342a().m58332b("Content-Encoding").m58332b("Content-Length").m58335a());
            m58828a.m58832a(new RealResponseBody(mo58273a.m58849a("Content-Type"), -1L, Okio.m58926a(gzipSource)));
        }
        return m58828a.m58836a();
    }

    /* renamed from: a */
    private String m58774a(List<Cookie> list) {
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                sb.append("; ");
            }
            Cookie cookie = list.get(i);
            sb.append(cookie.m58390a());
            sb.append('=');
            sb.append(cookie.m58381b());
        }
        return sb.toString();
    }
}

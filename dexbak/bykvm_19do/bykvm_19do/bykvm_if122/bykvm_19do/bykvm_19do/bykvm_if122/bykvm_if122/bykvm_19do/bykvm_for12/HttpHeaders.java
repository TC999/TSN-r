package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12;

import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.Cookie;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.CookieJar;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.Headers;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.HttpUrl;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.Response;
import io.netty.handler.codec.http.HttpHeaders;
import java.util.List;
import java.util.regex.Pattern;

/* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12.e */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class HttpHeaders {
    static {
        Pattern.compile(" +([^ \"=]*)=(:?\"([^\"]*)\"|([^ \"=]*)) *(:?,|$)");
    }

    /* renamed from: a */
    public static long m58771a(Response response) {
        return m58769a(response.m58844e());
    }

    /* renamed from: b */
    public static boolean m58765b(Response response) {
        if (response.m58838k().m58207e().equals("HEAD")) {
            return false;
        }
        int m58846c = response.m58846c();
        return (((m58846c >= 100 && m58846c < 200) || m58846c == 204 || m58846c == 304) && m58771a(response) == -1 && !HttpHeaders.Values.CHUNKED.equalsIgnoreCase(response.m58849a(HttpHeaders.Names.TRANSFER_ENCODING))) ? false : true;
    }

    /* renamed from: a */
    public static long m58769a(Headers headers) {
        return m58768a(headers.m58340a("Content-Length"));
    }

    /* renamed from: a */
    private static long m58768a(String str) {
        if (str == null) {
            return -1L;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return -1L;
        }
    }

    /* renamed from: a */
    public static void m58770a(CookieJar cookieJar, HttpUrl httpUrl, Headers headers) {
        if (cookieJar == CookieJar.f1342a) {
            return;
        }
        List<Cookie> m58388a = Cookie.m58388a(httpUrl, headers);
        if (m58388a.isEmpty()) {
            return;
        }
        cookieJar.mo58378a(httpUrl, m58388a);
    }

    /* renamed from: b */
    public static int m58764b(String str, int i) {
        char charAt;
        while (i < str.length() && ((charAt = str.charAt(i)) == ' ' || charAt == '\t')) {
            i++;
        }
        return i;
    }

    /* renamed from: a */
    public static int m58766a(String str, int i, String str2) {
        while (i < str.length() && str2.indexOf(str.charAt(i)) == -1) {
            i++;
        }
        return i;
    }

    /* renamed from: a */
    public static int m58767a(String str, int i) {
        try {
            long parseLong = Long.parseLong(str);
            if (parseLong > 2147483647L) {
                return Integer.MAX_VALUE;
            }
            if (parseLong < 0) {
                return 0;
            }
            return (int) parseLong;
        } catch (NumberFormatException unused) {
            return i;
        }
    }
}

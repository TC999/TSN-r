package okhttp3.internal.tls;

import java.security.cert.Certificate;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.f0;
import kotlin.text.w;
import kotlin.text.x;
import okhttp3.internal.HostnamesKt;
import okhttp3.internal.Util;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: OkHostnameVerifier.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\nJ\u001e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0004H\u0002J\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0018\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u001c\u0010\u0012\u001a\u00020\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\bH\u0002J\u0018\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lokhttp3/internal/tls/OkHostnameVerifier;", "Ljavax/net/ssl/HostnameVerifier;", "()V", "ALT_DNS_NAME", "", "ALT_IPA_NAME", "allSubjectAltNames", "", "", "certificate", "Ljava/security/cert/X509Certificate;", "getSubjectAltNames", "type", "verify", "", "host", "session", "Ljavax/net/ssl/SSLSession;", "verifyHostname", "hostname", "pattern", "verifyIpAddress", "ipAddress", "okhttp"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class OkHostnameVerifier implements HostnameVerifier {
    private static final int ALT_DNS_NAME = 2;
    private static final int ALT_IPA_NAME = 7;
    public static final OkHostnameVerifier INSTANCE = new OkHostnameVerifier();

    private OkHostnameVerifier() {
    }

    private final List<String> getSubjectAltNames(X509Certificate x509Certificate, int i4) {
        List<String> F;
        List<String> F2;
        Object obj;
        try {
            Collection<List<?>> subjectAlternativeNames = x509Certificate.getSubjectAlternativeNames();
            if (subjectAlternativeNames != null) {
                ArrayList arrayList = new ArrayList();
                for (List<?> list : subjectAlternativeNames) {
                    if (list != null && list.size() >= 2 && !(!f0.g(list.get(0), Integer.valueOf(i4))) && (obj = list.get(1)) != null) {
                        arrayList.add((String) obj);
                    }
                }
                return arrayList;
            }
            F2 = CollectionsKt__CollectionsKt.F();
            return F2;
        } catch (CertificateParsingException unused) {
            F = CollectionsKt__CollectionsKt.F();
            return F;
        }
    }

    private final boolean verifyHostname(String str, X509Certificate x509Certificate) {
        Locale locale = Locale.US;
        f0.o(locale, "Locale.US");
        if (str != null) {
            String lowerCase = str.toLowerCase(locale);
            f0.o(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
            List<String> subjectAltNames = getSubjectAltNames(x509Certificate, 2);
            if ((subjectAltNames instanceof Collection) && subjectAltNames.isEmpty()) {
                return false;
            }
            for (String str2 : subjectAltNames) {
                if (INSTANCE.verifyHostname(lowerCase, str2)) {
                    return true;
                }
            }
            return false;
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    private final boolean verifyIpAddress(String str, X509Certificate x509Certificate) {
        String canonicalHost = HostnamesKt.toCanonicalHost(str);
        List<String> subjectAltNames = getSubjectAltNames(x509Certificate, 7);
        if ((subjectAltNames instanceof Collection) && subjectAltNames.isEmpty()) {
            return false;
        }
        for (String str2 : subjectAltNames) {
            if (f0.g(canonicalHost, HostnamesKt.toCanonicalHost(str2))) {
                return true;
            }
        }
        return false;
    }

    @NotNull
    public final List<String> allSubjectAltNames(@NotNull X509Certificate certificate) {
        List<String> o4;
        f0.p(certificate, "certificate");
        o4 = kotlin.collections.f0.o4(getSubjectAltNames(certificate, 7), getSubjectAltNames(certificate, 2));
        return o4;
    }

    @Override // javax.net.ssl.HostnameVerifier
    public boolean verify(@NotNull String host, @NotNull SSLSession session) {
        f0.p(host, "host");
        f0.p(session, "session");
        try {
            Certificate certificate = session.getPeerCertificates()[0];
            if (certificate != null) {
                return verify(host, (X509Certificate) certificate);
            }
            throw new NullPointerException("null cannot be cast to non-null type java.security.cert.X509Certificate");
        } catch (SSLException unused) {
            return false;
        }
    }

    public final boolean verify(@NotNull String host, @NotNull X509Certificate certificate) {
        f0.p(host, "host");
        f0.p(certificate, "certificate");
        return Util.canParseAsIpAddress(host) ? verifyIpAddress(host, certificate) : verifyHostname(host, certificate);
    }

    private final boolean verifyHostname(String str, String str2) {
        boolean u22;
        boolean J1;
        boolean u23;
        boolean J12;
        boolean J13;
        boolean J14;
        boolean V2;
        boolean u24;
        int q3;
        boolean J15;
        int E3;
        if (!(str == null || str.length() == 0)) {
            u22 = w.u2(str, ".", false, 2, null);
            if (!u22) {
                J1 = w.J1(str, "..", false, 2, null);
                if (!J1) {
                    if (!(str2 == null || str2.length() == 0)) {
                        u23 = w.u2(str2, ".", false, 2, null);
                        if (!u23) {
                            J12 = w.J1(str2, "..", false, 2, null);
                            if (!J12) {
                                J13 = w.J1(str, ".", false, 2, null);
                                if (!J13) {
                                    str = str + ".";
                                }
                                String str3 = str;
                                J14 = w.J1(str2, ".", false, 2, null);
                                if (!J14) {
                                    str2 = str2 + ".";
                                }
                                Locale locale = Locale.US;
                                f0.o(locale, "Locale.US");
                                if (str2 != null) {
                                    String lowerCase = str2.toLowerCase(locale);
                                    f0.o(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                                    V2 = x.V2(lowerCase, "*", false, 2, null);
                                    if (!V2) {
                                        return f0.g(str3, lowerCase);
                                    }
                                    u24 = w.u2(lowerCase, "*.", false, 2, null);
                                    if (u24) {
                                        q3 = x.q3(lowerCase, '*', 1, false, 4, null);
                                        if (q3 == -1 && str3.length() >= lowerCase.length() && !f0.g("*.", lowerCase)) {
                                            String substring = lowerCase.substring(1);
                                            f0.o(substring, "(this as java.lang.String).substring(startIndex)");
                                            J15 = w.J1(str3, substring, false, 2, null);
                                            if (J15) {
                                                int length = str3.length() - substring.length();
                                                if (length > 0) {
                                                    E3 = x.E3(str3, '.', length - 1, false, 4, null);
                                                    if (E3 != -1) {
                                                        return false;
                                                    }
                                                }
                                                return true;
                                            }
                                            return false;
                                        }
                                        return false;
                                    }
                                    return false;
                                }
                                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
}

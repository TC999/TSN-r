package okhttp3.internal.tls;

import com.umeng.analytics.pro.UContent;
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
import kotlin.collections._Collections;
import kotlin.jvm.internal.C14342f0;
import kotlin.text.C14579x;
import kotlin.text.StringsJVM;
import okhttp3.internal.Util;
import okhttp3.internal.hostnames;
import org.jetbrains.annotations.NotNull;

/* compiled from: OkHostnameVerifier.kt */
@Metadata(m12618bv = {1, 0, 3}, m12617d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\nJ\u001e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0004H\u0002J\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0018\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u001c\u0010\u0012\u001a\u00020\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\bH\u0002J\u0018\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0017"}, m12616d2 = {"Lokhttp3/internal/tls/OkHostnameVerifier;", "Ljavax/net/ssl/HostnameVerifier;", "()V", "ALT_DNS_NAME", "", "ALT_IPA_NAME", "allSubjectAltNames", "", "", "certificate", "Ljava/security/cert/X509Certificate;", "getSubjectAltNames", "type", "verify", "", "host", UContent.f38099aC, "Ljavax/net/ssl/SSLSession;", "verifyHostname", "hostname", "pattern", "verifyIpAddress", "ipAddress", "okhttp"}, m12615k = 1, m12614mv = {1, 4, 0})
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class OkHostnameVerifier implements HostnameVerifier {
    private static final int ALT_DNS_NAME = 2;
    private static final int ALT_IPA_NAME = 7;
    public static final OkHostnameVerifier INSTANCE = new OkHostnameVerifier();

    private OkHostnameVerifier() {
    }

    private final List<String> getSubjectAltNames(X509Certificate x509Certificate, int i) {
        List<String> m12478E;
        List<String> m12478E2;
        Object obj;
        try {
            Collection<List<?>> subjectAlternativeNames = x509Certificate.getSubjectAlternativeNames();
            if (subjectAlternativeNames != null) {
                ArrayList arrayList = new ArrayList();
                for (List<?> list : subjectAlternativeNames) {
                    if (list != null && list.size() >= 2 && !(!C14342f0.m8193g(list.get(0), Integer.valueOf(i))) && (obj = list.get(1)) != null) {
                        arrayList.add((String) obj);
                    }
                }
                return arrayList;
            }
            m12478E2 = CollectionsKt__CollectionsKt.m12478E();
            return m12478E2;
        } catch (CertificateParsingException unused) {
            m12478E = CollectionsKt__CollectionsKt.m12478E();
            return m12478E;
        }
    }

    private final boolean verifyHostname(String str, X509Certificate x509Certificate) {
        Locale locale = Locale.US;
        C14342f0.m8185o(locale, "Locale.US");
        if (str != null) {
            String lowerCase = str.toLowerCase(locale);
            C14342f0.m8185o(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
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
        String canonicalHost = hostnames.toCanonicalHost(str);
        List<String> subjectAltNames = getSubjectAltNames(x509Certificate, 7);
        if ((subjectAltNames instanceof Collection) && subjectAltNames.isEmpty()) {
            return false;
        }
        for (String str2 : subjectAltNames) {
            if (C14342f0.m8193g(canonicalHost, hostnames.toCanonicalHost(str2))) {
                return true;
            }
        }
        return false;
    }

    @NotNull
    public final List<String> allSubjectAltNames(@NotNull X509Certificate certificate) {
        List<String> m12072q4;
        C14342f0.m8184p(certificate, "certificate");
        m12072q4 = _Collections.m12072q4(getSubjectAltNames(certificate, 7), getSubjectAltNames(certificate, 2));
        return m12072q4;
    }

    @Override // javax.net.ssl.HostnameVerifier
    public boolean verify(@NotNull String host, @NotNull SSLSession session) {
        C14342f0.m8184p(host, "host");
        C14342f0.m8184p(session, "session");
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
        C14342f0.m8184p(host, "host");
        C14342f0.m8184p(certificate, "certificate");
        return Util.canParseAsIpAddress(host) ? verifyIpAddress(host, certificate) : verifyHostname(host, certificate);
    }

    private final boolean verifyHostname(String str, String str2) {
        boolean m6548u2;
        boolean m6606J1;
        boolean m6548u22;
        boolean m6606J12;
        boolean m6606J13;
        boolean m6606J14;
        boolean m6465V2;
        boolean m6548u23;
        int m6401q3;
        boolean m6606J15;
        int m6525E3;
        if (!(str == null || str.length() == 0)) {
            m6548u2 = StringsJVM.m6548u2(str, ".", false, 2, null);
            if (!m6548u2) {
                m6606J1 = StringsJVM.m6606J1(str, "..", false, 2, null);
                if (!m6606J1) {
                    if (!(str2 == null || str2.length() == 0)) {
                        m6548u22 = StringsJVM.m6548u2(str2, ".", false, 2, null);
                        if (!m6548u22) {
                            m6606J12 = StringsJVM.m6606J1(str2, "..", false, 2, null);
                            if (!m6606J12) {
                                m6606J13 = StringsJVM.m6606J1(str, ".", false, 2, null);
                                if (!m6606J13) {
                                    str = str + ".";
                                }
                                String str3 = str;
                                m6606J14 = StringsJVM.m6606J1(str2, ".", false, 2, null);
                                if (!m6606J14) {
                                    str2 = str2 + ".";
                                }
                                Locale locale = Locale.US;
                                C14342f0.m8185o(locale, "Locale.US");
                                if (str2 != null) {
                                    String lowerCase = str2.toLowerCase(locale);
                                    C14342f0.m8185o(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                                    m6465V2 = C14579x.m6465V2(lowerCase, "*", false, 2, null);
                                    if (!m6465V2) {
                                        return C14342f0.m8193g(str3, lowerCase);
                                    }
                                    m6548u23 = StringsJVM.m6548u2(lowerCase, "*.", false, 2, null);
                                    if (m6548u23) {
                                        m6401q3 = C14579x.m6401q3(lowerCase, '*', 1, false, 4, null);
                                        if (m6401q3 == -1 && str3.length() >= lowerCase.length() && !C14342f0.m8193g("*.", lowerCase)) {
                                            String substring = lowerCase.substring(1);
                                            C14342f0.m8185o(substring, "(this as java.lang.String).substring(startIndex)");
                                            m6606J15 = StringsJVM.m6606J1(str3, substring, false, 2, null);
                                            if (m6606J15) {
                                                int length = str3.length() - substring.length();
                                                if (length > 0) {
                                                    m6525E3 = C14579x.m6525E3(str3, '.', length - 1, false, 4, null);
                                                    if (m6525E3 != -1) {
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

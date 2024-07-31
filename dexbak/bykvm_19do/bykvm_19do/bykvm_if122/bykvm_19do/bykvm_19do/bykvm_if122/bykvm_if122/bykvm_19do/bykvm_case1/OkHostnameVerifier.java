package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_case1;

import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.C1061c;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;

/* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_case1.e */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class OkHostnameVerifier implements HostnameVerifier {

    /* renamed from: a */
    public static final OkHostnameVerifier f929a = new OkHostnameVerifier();

    private OkHostnameVerifier() {
    }

    /* renamed from: b */
    private boolean m58776b(String str, X509Certificate x509Certificate) {
        String m58786a;
        String lowerCase = str.toLowerCase(Locale.US);
        List<String> m58777a = m58777a(x509Certificate, 2);
        int size = m58777a.size();
        int i = 0;
        boolean z = false;
        while (i < size) {
            if (m58780a(lowerCase, m58777a.get(i))) {
                return true;
            }
            i++;
            z = true;
        }
        if (z || (m58786a = new DistinguishedNameParser(x509Certificate.getSubjectX500Principal()).m58786a("cn")) == null) {
            return false;
        }
        return m58780a(lowerCase, m58786a);
    }

    /* renamed from: c */
    private boolean m58775c(String str, X509Certificate x509Certificate) {
        List<String> m58777a = m58777a(x509Certificate, 7);
        int size = m58777a.size();
        for (int i = 0; i < size; i++) {
            if (str.equalsIgnoreCase(m58777a.get(i))) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public boolean m58779a(String str, X509Certificate x509Certificate) {
        if (C1061c.m58450d(str)) {
            return m58775c(str, x509Certificate);
        }
        return m58776b(str, x509Certificate);
    }

    @Override // javax.net.ssl.HostnameVerifier
    public boolean verify(String str, SSLSession sSLSession) {
        try {
            return m58779a(str, (X509Certificate) sSLSession.getPeerCertificates()[0]);
        } catch (SSLException unused) {
            return false;
        }
    }

    /* renamed from: a */
    public static List<String> m58778a(X509Certificate x509Certificate) {
        List<String> m58777a = m58777a(x509Certificate, 7);
        List<String> m58777a2 = m58777a(x509Certificate, 2);
        ArrayList arrayList = new ArrayList(m58777a.size() + m58777a2.size());
        arrayList.addAll(m58777a);
        arrayList.addAll(m58777a2);
        return arrayList;
    }

    /* renamed from: a */
    private static List<String> m58777a(X509Certificate x509Certificate, int i) {
        Integer num;
        String str;
        ArrayList arrayList = new ArrayList();
        try {
            Collection<List<?>> subjectAlternativeNames = x509Certificate.getSubjectAlternativeNames();
            if (subjectAlternativeNames == null) {
                return Collections.emptyList();
            }
            for (List<?> list : subjectAlternativeNames) {
                if (list != null && list.size() >= 2 && (num = (Integer) list.get(0)) != null && num.intValue() == i && (str = (String) list.get(1)) != null) {
                    arrayList.add(str);
                }
            }
            return arrayList;
        } catch (CertificateParsingException unused) {
            return Collections.emptyList();
        }
    }

    /* renamed from: a */
    public boolean m58780a(String str, String str2) {
        if (str != null && str.length() != 0 && !str.startsWith(".") && !str.endsWith("..") && str2 != null && str2.length() != 0 && !str2.startsWith(".") && !str2.endsWith("..")) {
            if (!str.endsWith(".")) {
                str = str + '.';
            }
            if (!str2.endsWith(".")) {
                str2 = str2 + '.';
            }
            String lowerCase = str2.toLowerCase(Locale.US);
            if (!lowerCase.contains("*")) {
                return str.equals(lowerCase);
            }
            if (!lowerCase.startsWith("*.") || lowerCase.indexOf(42, 1) != -1 || str.length() < lowerCase.length() || "*.".equals(lowerCase)) {
                return false;
            }
            String substring = lowerCase.substring(1);
            if (str.endsWith(substring)) {
                int length = str.length() - substring.length();
                return length <= 0 || str.lastIndexOf(46, length - 1) == -1;
            }
            return false;
        }
        return false;
    }
}

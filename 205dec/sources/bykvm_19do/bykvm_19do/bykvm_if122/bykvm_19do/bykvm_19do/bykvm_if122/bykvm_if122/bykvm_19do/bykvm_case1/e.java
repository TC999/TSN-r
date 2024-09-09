package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_case1;

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

/* compiled from: OkHostnameVerifier.java */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public final class e implements HostnameVerifier {

    /* renamed from: a  reason: collision with root package name */
    public static final e f922a = new e();

    private e() {
    }

    private boolean b(String str, X509Certificate x509Certificate) {
        String a4;
        String lowerCase = str.toLowerCase(Locale.US);
        List<String> a5 = a(x509Certificate, 2);
        int size = a5.size();
        int i4 = 0;
        boolean z3 = false;
        while (i4 < size) {
            if (a(lowerCase, a5.get(i4))) {
                return true;
            }
            i4++;
            z3 = true;
        }
        if (z3 || (a4 = new d(x509Certificate.getSubjectX500Principal()).a("cn")) == null) {
            return false;
        }
        return a(lowerCase, a4);
    }

    private boolean c(String str, X509Certificate x509Certificate) {
        List<String> a4 = a(x509Certificate, 7);
        int size = a4.size();
        for (int i4 = 0; i4 < size; i4++) {
            if (str.equalsIgnoreCase(a4.get(i4))) {
                return true;
            }
        }
        return false;
    }

    public boolean a(String str, X509Certificate x509Certificate) {
        if (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.d(str)) {
            return c(str, x509Certificate);
        }
        return b(str, x509Certificate);
    }

    @Override // javax.net.ssl.HostnameVerifier
    public boolean verify(String str, SSLSession sSLSession) {
        try {
            return a(str, (X509Certificate) sSLSession.getPeerCertificates()[0]);
        } catch (SSLException unused) {
            return false;
        }
    }

    public static List<String> a(X509Certificate x509Certificate) {
        List<String> a4 = a(x509Certificate, 7);
        List<String> a5 = a(x509Certificate, 2);
        ArrayList arrayList = new ArrayList(a4.size() + a5.size());
        arrayList.addAll(a4);
        arrayList.addAll(a5);
        return arrayList;
    }

    private static List<String> a(X509Certificate x509Certificate, int i4) {
        Integer num;
        String str;
        ArrayList arrayList = new ArrayList();
        try {
            Collection<List<?>> subjectAlternativeNames = x509Certificate.getSubjectAlternativeNames();
            if (subjectAlternativeNames == null) {
                return Collections.emptyList();
            }
            for (List<?> list : subjectAlternativeNames) {
                if (list != null && list.size() >= 2 && (num = (Integer) list.get(0)) != null && num.intValue() == i4 && (str = (String) list.get(1)) != null) {
                    arrayList.add(str);
                }
            }
            return arrayList;
        } catch (CertificateParsingException unused) {
            return Collections.emptyList();
        }
    }

    public boolean a(String str, String str2) {
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

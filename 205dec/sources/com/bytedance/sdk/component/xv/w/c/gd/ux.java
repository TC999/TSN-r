package com.bytedance.sdk.component.xv.w.c.gd;

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

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class ux implements HostnameVerifier {

    /* renamed from: c  reason: collision with root package name */
    public static final ux f30782c = new ux();

    private ux() {
    }

    private boolean w(String str, X509Certificate x509Certificate) {
        List<String> c4 = c(x509Certificate, 7);
        int size = c4.size();
        for (int i4 = 0; i4 < size; i4++) {
            if (str.equalsIgnoreCase(c4.get(i4))) {
                return true;
            }
        }
        return false;
    }

    private boolean xv(String str, X509Certificate x509Certificate) {
        String c4;
        String lowerCase = str.toLowerCase(Locale.US);
        List<String> c5 = c(x509Certificate, 2);
        int size = c5.size();
        int i4 = 0;
        boolean z3 = false;
        while (i4 < size) {
            if (c(lowerCase, c5.get(i4))) {
                return true;
            }
            i4++;
            z3 = true;
        }
        if (z3 || (c4 = new sr(x509Certificate.getSubjectX500Principal()).c("cn")) == null) {
            return false;
        }
        return c(lowerCase, c4);
    }

    public boolean c(String str, X509Certificate x509Certificate) {
        if (com.bytedance.sdk.component.xv.w.c.xv.xv(str)) {
            return w(str, x509Certificate);
        }
        return xv(str, x509Certificate);
    }

    @Override // javax.net.ssl.HostnameVerifier
    public boolean verify(String str, SSLSession sSLSession) {
        try {
            return c(str, (X509Certificate) sSLSession.getPeerCertificates()[0]);
        } catch (SSLException unused) {
            return false;
        }
    }

    public static List<String> c(X509Certificate x509Certificate) {
        List<String> c4 = c(x509Certificate, 7);
        List<String> c5 = c(x509Certificate, 2);
        ArrayList arrayList = new ArrayList(c4.size() + c5.size());
        arrayList.addAll(c4);
        arrayList.addAll(c5);
        return arrayList;
    }

    private static List<String> c(X509Certificate x509Certificate, int i4) {
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

    public boolean c(String str, String str2) {
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

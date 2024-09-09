package com.bytedance.sdk.openadsdk.api.plugin.a;

import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;

/* loaded from: E:\TSN-r\205dec\5141176.dex */
public final class ok implements HostnameVerifier {
    public static final ok ok = new ok();

    /* renamed from: a  reason: collision with root package name */
    private static final Pattern f31445a = Pattern.compile("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");

    private ok() {
    }

    private boolean a(String str, X509Certificate x509Certificate) {
        List<String> ok2 = ok(x509Certificate, 7);
        int size = ok2.size();
        for (int i4 = 0; i4 < size; i4++) {
            if (str.equalsIgnoreCase(ok2.get(i4))) {
                return true;
            }
        }
        return false;
    }

    private boolean bl(String str, X509Certificate x509Certificate) {
        String ok2;
        String lowerCase = str.toLowerCase(Locale.US);
        List<String> ok3 = ok(x509Certificate, 2);
        int size = ok3.size();
        int i4 = 0;
        boolean z3 = false;
        while (i4 < size) {
            if (ok(lowerCase, ok3.get(i4))) {
                return true;
            }
            i4++;
            z3 = true;
        }
        if (z3 || (ok2 = new a(x509Certificate.getSubjectX500Principal()).ok("cn")) == null) {
            return false;
        }
        return ok(lowerCase, ok2);
    }

    private boolean ok(String str, X509Certificate x509Certificate) {
        if (ok(str)) {
            return a(str, x509Certificate);
        }
        return bl(str, x509Certificate);
    }

    @Override // javax.net.ssl.HostnameVerifier
    public boolean verify(String str, SSLSession sSLSession) {
        try {
            return ok(str, (X509Certificate) sSLSession.getPeerCertificates()[0]);
        } catch (SSLException unused) {
            return false;
        }
    }

    private static boolean ok(String str) {
        return f31445a.matcher(str).matches();
    }

    private static List<String> ok(X509Certificate x509Certificate, int i4) {
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

    private boolean ok(String str, String str2) {
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

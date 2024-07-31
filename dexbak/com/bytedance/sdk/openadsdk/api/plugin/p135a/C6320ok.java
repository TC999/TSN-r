package com.bytedance.sdk.openadsdk.api.plugin.p135a;

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

/* renamed from: com.bytedance.sdk.openadsdk.api.plugin.a.ok */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class C6320ok implements HostnameVerifier {

    /* renamed from: ok */
    public static final C6320ok f22441ok = new C6320ok();

    /* renamed from: a */
    private static final Pattern f22440a = Pattern.compile("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");

    private C6320ok() {
    }

    /* renamed from: a */
    private boolean m36613a(String str, X509Certificate x509Certificate) {
        List<String> m36608ok = m36608ok(x509Certificate, 7);
        int size = m36608ok.size();
        for (int i = 0; i < size; i++) {
            if (str.equalsIgnoreCase(m36608ok.get(i))) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: bl */
    private boolean m36612bl(String str, X509Certificate x509Certificate) {
        String m36622ok;
        String lowerCase = str.toLowerCase(Locale.US);
        List<String> m36608ok = m36608ok(x509Certificate, 2);
        int size = m36608ok.size();
        int i = 0;
        boolean z = false;
        while (i < size) {
            if (m36610ok(lowerCase, m36608ok.get(i))) {
                return true;
            }
            i++;
            z = true;
        }
        if (z || (m36622ok = new C6316a(x509Certificate.getSubjectX500Principal()).m36622ok("cn")) == null) {
            return false;
        }
        return m36610ok(lowerCase, m36622ok);
    }

    /* renamed from: ok */
    private boolean m36609ok(String str, X509Certificate x509Certificate) {
        if (m36611ok(str)) {
            return m36613a(str, x509Certificate);
        }
        return m36612bl(str, x509Certificate);
    }

    @Override // javax.net.ssl.HostnameVerifier
    public boolean verify(String str, SSLSession sSLSession) {
        try {
            return m36609ok(str, (X509Certificate) sSLSession.getPeerCertificates()[0]);
        } catch (SSLException unused) {
            return false;
        }
    }

    /* renamed from: ok */
    private static boolean m36611ok(String str) {
        return f22440a.matcher(str).matches();
    }

    /* renamed from: ok */
    private static List<String> m36608ok(X509Certificate x509Certificate, int i) {
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

    /* renamed from: ok */
    private boolean m36610ok(String str, String str2) {
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

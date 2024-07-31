package com.baidu.mobads.sdk.internal;

import android.text.TextUtils;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;

/* renamed from: com.baidu.mobads.sdk.internal.cp */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class C2670cp {

    /* renamed from: a */
    private static volatile C2670cp f8892a;

    /* renamed from: b */
    private boolean f8893b;

    /* renamed from: c */
    private boolean f8894c;

    private C2670cp() {
    }

    /* renamed from: a */
    public static C2670cp m50608a() {
        if (f8892a == null) {
            synchronized (C2670cp.class) {
                if (f8892a == null) {
                    f8892a = new C2670cp();
                }
            }
        }
        return f8892a;
    }

    /* renamed from: b */
    public boolean m50601b() {
        return this.f8894c;
    }

    /* renamed from: c */
    public String m50598c(String str) {
        return (this.f8893b && m50607a(str).booleanValue()) ? str.replaceFirst("(?i)http", "https") : str;
    }

    /* renamed from: d */
    public Boolean m50597d(String str) {
        return Boolean.valueOf(m50606a(str, "sms:").booleanValue() || m50606a(str, "smsto:").booleanValue() || m50606a(str, "mms:").booleanValue());
    }

    /* renamed from: e */
    public String m50596e(String str) {
        try {
            String path = new URI(str).getPath();
            return path.substring(path.lastIndexOf(47) + 1, path.length());
        } catch (URISyntaxException unused) {
            return "";
        }
    }

    /* renamed from: f */
    public boolean m50595f(String str) {
        return TextUtils.isEmpty(str) || !str.contains("/thefatherofsalmon.com");
    }

    /* renamed from: g */
    public String m50594g(String str) {
        if (str == null) {
            return null;
        }
        return (m50607a(str).booleanValue() || m50600b(str).booleanValue()) ? str.split("\\?")[0] : str;
    }

    /* renamed from: h */
    public String m50593h(String str) {
        if (str == null) {
            return null;
        }
        String[] split = (m50607a(str).booleanValue() || m50600b(str).booleanValue()) ? str.split("\\?") : null;
        if (split == null || split.length < 2) {
            return null;
        }
        return split[1];
    }

    /* renamed from: i */
    public void m50592i(String str) {
        new C2594an(str).m51005b();
    }

    /* renamed from: b */
    public void m50599b(boolean z) {
        this.f8893b = z;
    }

    /* renamed from: b */
    public Boolean m50600b(String str) {
        return m50606a(str, "https:");
    }

    /* renamed from: a */
    public void m50602a(boolean z) {
        this.f8894c = z;
    }

    /* renamed from: a */
    public Boolean m50607a(String str) {
        return m50606a(str, "http:");
    }

    /* renamed from: a */
    private Boolean m50606a(String str, String str2) {
        boolean z = false;
        if (str != null && str.trim().toLowerCase(Locale.getDefault()).indexOf(str2) == 0) {
            z = true;
        }
        return Boolean.valueOf(z);
    }

    /* renamed from: a */
    public HttpURLConnection m50603a(URL url) {
        if (url.getProtocol().toLowerCase().equals("https")) {
            return (HttpsURLConnection) url.openConnection();
        }
        return (HttpURLConnection) url.openConnection();
    }

    /* renamed from: a */
    public String m50605a(String str, HashMap<String, String> hashMap) {
        StringBuilder sb = new StringBuilder(str);
        if (hashMap != null && !hashMap.isEmpty()) {
            sb.append("?");
            for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                try {
                    sb.append(entry.getKey());
                    sb.append("=");
                    sb.append(entry.getValue());
                    sb.append("&");
                } catch (Exception e) {
                    C2634bs.m50744a().m50729c(e);
                }
            }
            String sb2 = sb.toString();
            return sb2.substring(0, sb2.length() - 1);
        }
        return sb.toString();
    }

    /* renamed from: a */
    public void m50604a(HttpURLConnection httpURLConnection) {
        if (httpURLConnection != null) {
            try {
                httpURLConnection.getInputStream().close();
            } catch (Throwable unused) {
            }
            try {
                httpURLConnection.getOutputStream().close();
            } catch (Throwable unused2) {
            }
            try {
                httpURLConnection.disconnect();
            } catch (Throwable unused3) {
            }
        }
    }
}

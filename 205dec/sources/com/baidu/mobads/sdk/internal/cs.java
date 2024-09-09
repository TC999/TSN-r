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

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class cs {

    /* renamed from: a  reason: collision with root package name */
    private static volatile cs f12712a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f12713b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f12714c;

    private cs() {
    }

    public static cs a() {
        if (f12712a == null) {
            synchronized (cs.class) {
                if (f12712a == null) {
                    f12712a = new cs();
                }
            }
        }
        return f12712a;
    }

    public boolean b() {
        return this.f12714c;
    }

    public String c(String str) {
        return (this.f12713b && a(str).booleanValue()) ? str.replaceFirst("(?i)http", "https") : str;
    }

    public Boolean d(String str) {
        return Boolean.valueOf(a(str, "sms:").booleanValue() || a(str, "smsto:").booleanValue() || a(str, "mms:").booleanValue());
    }

    public String e(String str) {
        try {
            String path = new URI(str).getPath();
            return path.substring(path.lastIndexOf(47) + 1, path.length());
        } catch (URISyntaxException unused) {
            return "";
        }
    }

    public boolean f(String str) {
        return TextUtils.isEmpty(str) || !str.contains("/thefatherofsalmon.com");
    }

    public String g(String str) {
        if (str == null) {
            return null;
        }
        return (a(str).booleanValue() || b(str).booleanValue()) ? str.split("\\?")[0] : str;
    }

    public String h(String str) {
        if (str == null) {
            return null;
        }
        String[] split = (a(str).booleanValue() || b(str).booleanValue()) ? str.split("\\?") : null;
        if (split == null || split.length < 2) {
            return null;
        }
        return split[1];
    }

    public void i(String str) {
        new an(str).b();
    }

    public void b(boolean z3) {
        this.f12713b = z3;
    }

    public Boolean b(String str) {
        return a(str, "https:");
    }

    public void a(boolean z3) {
        this.f12714c = z3;
    }

    public Boolean a(String str) {
        return a(str, "http:");
    }

    private Boolean a(String str, String str2) {
        boolean z3 = false;
        if (str != null && str.trim().toLowerCase(Locale.getDefault()).indexOf(str2) == 0) {
            z3 = true;
        }
        return Boolean.valueOf(z3);
    }

    public HttpURLConnection a(URL url) {
        if (url.getProtocol().toLowerCase().equals("https")) {
            return (HttpsURLConnection) url.openConnection();
        }
        return (HttpURLConnection) url.openConnection();
    }

    public String a(String str, HashMap<String, String> hashMap) {
        StringBuilder sb = new StringBuilder(str);
        if (hashMap != null && !hashMap.isEmpty()) {
            sb.append("?");
            for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                try {
                    sb.append(entry.getKey());
                    sb.append("=");
                    sb.append(entry.getValue());
                    sb.append("&");
                } catch (Exception e4) {
                    bv.a().c(e4);
                }
            }
            String sb2 = sb.toString();
            return sb2.substring(0, sb2.length() - 1);
        }
        return sb.toString();
    }

    public void a(HttpURLConnection httpURLConnection) {
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

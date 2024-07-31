package com.kuaishou.weapon.p205p0;

import android.content.Context;
import android.text.TextUtils;
import com.clj.fastble.BleManager;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

/* renamed from: com.kuaishou.weapon.p0.l */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C7289l {

    /* renamed from: a */
    static TrustManager[] f24966a = {new X509TrustManager() { // from class: com.kuaishou.weapon.p0.l.1
        @Override // javax.net.ssl.X509TrustManager
        public final void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
        }

        @Override // javax.net.ssl.X509TrustManager
        public final void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
            try {
                C7289l.m33836b(x509CertificateArr);
            } catch (Throwable unused) {
            }
        }

        @Override // javax.net.ssl.X509TrustManager
        public final X509Certificate[] getAcceptedIssuers() {
            return null;
        }
    }};

    /* renamed from: b */
    static SSLSocketFactory f24967b = null;

    /* renamed from: c */
    private static final String f24968c = "gzip";

    /* renamed from: d */
    private static final int f24969d = 1024;

    /* renamed from: f */
    private static volatile C7289l f24970f;

    /* renamed from: g */
    private static Context f24971g;

    /* renamed from: e */
    private boolean f24972e = false;

    private C7289l(Context context) {
        f24971g = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static void m33836b(X509Certificate[] x509CertificateArr) {
        if (x509CertificateArr != null) {
            try {
                if (x509CertificateArr.length == 0) {
                    return;
                }
                String name = x509CertificateArr[0].getIssuerX500Principal().getName();
                if (Pattern.compile(".*(GeoTrust|VeriSign|Symantec|GlobalSign|Entrust|Thawte|DigiCert).*", 2).matcher(name).matches()) {
                    return;
                }
                m33844a(name);
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: a */
    public static C7289l m33849a(Context context) {
        if (f24970f == null) {
            synchronized (C7289l.class) {
                if (f24970f == null) {
                    f24970f = new C7289l(context);
                }
            }
        }
        return f24970f;
    }

    /* renamed from: b */
    public void m33837b(C7291m c7291m, InterfaceC7285j interfaceC7285j) {
        m33846a(c7291m, interfaceC7285j, "POST");
    }

    /* renamed from: a */
    public void m33847a(C7291m c7291m, InterfaceC7285j interfaceC7285j) {
        m33846a(c7291m, interfaceC7285j, "GET");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v5, types: [java.net.HttpURLConnection] */
    /* renamed from: a */
    public HttpURLConnection m33842a(String str, String str2) {
        HttpsURLConnection httpsURLConnection;
        try {
            URL url = new URL(str);
            if ("https".equals(url.getProtocol())) {
                HttpsURLConnection httpsURLConnection2 = (HttpsURLConnection) url.openConnection();
                m33839a(httpsURLConnection2);
                httpsURLConnection = httpsURLConnection2;
            } else {
                httpsURLConnection = (HttpURLConnection) url.openConnection();
            }
            try {
                httpsURLConnection.setRequestMethod(str2);
                httpsURLConnection.setAllowUserInteraction(true);
                httpsURLConnection.setInstanceFollowRedirects(true);
                httpsURLConnection.setChunkedStreamingMode(0);
                httpsURLConnection.setConnectTimeout(BleManager.f22896l);
                httpsURLConnection.setReadTimeout(5000);
                httpsURLConnection.setRequestProperty("Charset", "UTF-8");
                httpsURLConnection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
                if (str2.equalsIgnoreCase("post")) {
                    httpsURLConnection.setDoInput(true);
                    httpsURLConnection.setDoOutput(true);
                    httpsURLConnection.setUseCaches(false);
                    return httpsURLConnection;
                }
                return httpsURLConnection;
            } catch (Exception unused) {
                return httpsURLConnection;
            }
        } catch (Exception unused2) {
            return null;
        }
    }

    /* renamed from: a */
    private static void m33844a(String str) {
        try {
            new C7283h(f24971g).m33870c(C7262df.f24901m, str, true);
        } catch (Exception unused) {
        }
    }

    /* renamed from: a */
    private synchronized void m33839a(HttpsURLConnection httpsURLConnection) {
        if (httpsURLConnection != null) {
            try {
                if (f24967b == null) {
                    SSLContext sSLContext = SSLContext.getInstance("TLS");
                    sSLContext.init(null, f24966a, new SecureRandom());
                    f24967b = sSLContext.getSocketFactory();
                }
                SSLSocketFactory sSLSocketFactory = f24967b;
                if (sSLSocketFactory != null) {
                    httpsURLConnection.setSSLSocketFactory(sSLSocketFactory);
                }
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x00f5 A[Catch: Exception -> 0x00fd, TryCatch #4 {Exception -> 0x00fd, blocks: (B:54:0x00f0, B:56:0x00f5, B:58:0x00fa), top: B:77:0x00f0 }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00fa A[Catch: Exception -> 0x00fd, TRY_LEAVE, TryCatch #4 {Exception -> 0x00fd, blocks: (B:54:0x00f0, B:56:0x00f5, B:58:0x00fa), top: B:77:0x00f0 }] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00f0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m33846a(com.kuaishou.weapon.p205p0.C7291m r10, com.kuaishou.weapon.p205p0.InterfaceC7285j r11, java.lang.String r12) {
        /*
            Method dump skipped, instructions count: 273
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kuaishou.weapon.p205p0.C7289l.m33846a(com.kuaishou.weapon.p0.m, com.kuaishou.weapon.p0.j, java.lang.String):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x00e0 A[Catch: Exception -> 0x00e3, TRY_LEAVE, TryCatch #8 {Exception -> 0x00e3, blocks: (B:47:0x00db, B:49:0x00e0), top: B:72:0x00db }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00f3 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00f4 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00db A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String m33848a(com.kuaishou.weapon.p205p0.C7291m r11) {
        /*
            Method dump skipped, instructions count: 245
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kuaishou.weapon.p205p0.C7289l.m33848a(com.kuaishou.weapon.p0.m):java.lang.String");
    }

    /* renamed from: a */
    public boolean m33843a(String str, File file) {
        HttpURLConnection httpURLConnection;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        InputStream inputStream = null;
        try {
            httpURLConnection = m33842a(str, "GET");
            try {
                inputStream = m33841a(httpURLConnection);
                boolean m33845a = m33845a(inputStream, file);
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Throwable unused) {
                        return false;
                    }
                }
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                return m33845a;
            } catch (Throwable unused2) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Throwable unused3) {
                        return false;
                    }
                }
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                return false;
            }
        } catch (Throwable unused4) {
            httpURLConnection = null;
        }
    }

    /* renamed from: a */
    private InputStream m33841a(HttpURLConnection httpURLConnection) {
        if (httpURLConnection == null) {
            return null;
        }
        try {
            if ("gzip".equalsIgnoreCase(httpURLConnection.getContentEncoding())) {
                this.f24972e = true;
            } else {
                this.f24972e = false;
            }
            return httpURLConnection.getInputStream();
        } catch (IOException unused) {
            return null;
        }
    }

    /* renamed from: a */
    private boolean m33845a(InputStream inputStream, File file) {
        BufferedOutputStream bufferedOutputStream;
        if (this.f24972e) {
            try {
                inputStream = new GZIPInputStream(inputStream);
            } catch (IOException unused) {
            }
        }
        if (inputStream == null) {
            return false;
        }
        try {
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
        } catch (Throwable unused2) {
            bufferedOutputStream = null;
        }
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    bufferedOutputStream.write(bArr, 0, read);
                    bufferedOutputStream.flush();
                } else {
                    try {
                        bufferedOutputStream.close();
                        return true;
                    } catch (IOException unused3) {
                        return true;
                    }
                }
            }
        } catch (Throwable unused4) {
            if (bufferedOutputStream != null) {
                try {
                    bufferedOutputStream.close();
                } catch (IOException unused5) {
                }
            }
            return false;
        }
    }

    /* renamed from: a */
    public String m33840a(Map<String, String> map) {
        String str = "";
        for (Map.Entry<String, String> entry : map.entrySet()) {
            str = str + "&" + entry.getKey() + "=" + entry.getValue();
        }
        return str.substring(1);
    }
}

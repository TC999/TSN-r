package com.bytedance.sdk.openadsdk.a;

import com.bytedance.sdk.component.utils.a;
import com.bytedance.sdk.openadsdk.n.sr;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.KeyStore;
import java.util.Arrays;
import java.util.UUID;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c {

    /* renamed from: com.bytedance.sdk.openadsdk.a.c$c  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public interface InterfaceC0465c {
        void c(int i4, String str);

        void c(String str);
    }

    private static SSLSocketFactory c(X509TrustManager x509TrustManager) {
        try {
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            sSLContext.init(null, new TrustManager[]{x509TrustManager}, null);
            return sSLContext.getSocketFactory();
        } catch (Throwable th) {
            throw new RuntimeException("No System TLS", th);
        }
    }

    private static X509TrustManager c() {
        try {
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init((KeyStore) null);
            TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
            if (trustManagers.length == 1 && (trustManagers[0] instanceof X509TrustManager)) {
                return (X509TrustManager) trustManagers[0];
            }
            throw new IllegalStateException("Unexpected default trust managers:" + Arrays.toString(trustManagers));
        } catch (Throwable th) {
            a.xv("Https", th);
            return null;
        }
    }

    private static StringBuilder c(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder();
        sb.append("--");
        sb.append(str3);
        sb.append("\r\n");
        sb.append("Content-Disposition: form-data; name=\"");
        sb.append(str);
        sb.append("\"");
        sb.append("\r\n");
        sb.append("Content-Length: ");
        sb.append(str2.length());
        sb.append("\r\n");
        sb.append("\r\n");
        sb.append(str2);
        sb.append("\r\n");
        return sb;
    }

    public void c(String str, File file, String str2, InterfaceC0465c interfaceC0465c) {
        DataOutputStream dataOutputStream;
        String uuid;
        HttpsURLConnection httpsURLConnection = null;
        try {
            HttpsURLConnection httpsURLConnection2 = (HttpsURLConnection) new URL(str).openConnection();
            try {
                httpsURLConnection2.setRequestMethod("POST");
                httpsURLConnection2.setReadTimeout(20000);
                httpsURLConnection2.setConnectTimeout(10000);
                httpsURLConnection2.setDoOutput(true);
                httpsURLConnection2.setDoInput(true);
                httpsURLConnection2.setUseCaches(false);
                uuid = UUID.randomUUID().toString();
                httpsURLConnection2.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + uuid);
                httpsURLConnection2.setSSLSocketFactory(c(c()));
                httpsURLConnection2.connect();
                dataOutputStream = new DataOutputStream(httpsURLConnection2.getOutputStream());
            } catch (Throwable th) {
                th = th;
                dataOutputStream = null;
            }
            try {
                dataOutputStream.writeBytes("--" + uuid + "\r\nContent-Disposition: form-data; name=\"logFile\"; filename=\"" + file.getName() + "\"\r\nContent-Type: multipart/form-data\r\nContent-Length: " + file.length() + "\r\n\r\n");
                dataOutputStream.flush();
                sr.c(dataOutputStream, file);
                dataOutputStream.writeBytes("\r\n");
                dataOutputStream.writeBytes(c("deviceInfo", str2, uuid).toString());
                StringBuilder sb = new StringBuilder();
                sb.append("--");
                sb.append(uuid);
                sb.append("--");
                sb.append("\r\n");
                dataOutputStream.writeBytes(sb.toString());
                dataOutputStream.flush();
                dataOutputStream.close();
                c(httpsURLConnection2, interfaceC0465c);
                httpsURLConnection2.disconnect();
            } catch (Throwable th2) {
                th = th2;
                httpsURLConnection = httpsURLConnection2;
                try {
                    a.xv("Https", th);
                    if (interfaceC0465c != null) {
                        interfaceC0465c.c(-1, th.getMessage());
                    }
                } finally {
                    if (httpsURLConnection != null) {
                        httpsURLConnection.disconnect();
                    }
                    sr.c(dataOutputStream);
                }
            }
        } catch (Throwable th3) {
            th = th3;
            dataOutputStream = null;
        }
    }

    private void c(HttpURLConnection httpURLConnection, InterfaceC0465c interfaceC0465c) throws IOException {
        int responseCode = httpURLConnection.getResponseCode();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                break;
            }
            sb.append(readLine);
        }
        if (responseCode == 200) {
            if (interfaceC0465c != null) {
                interfaceC0465c.c(sb.toString());
            }
        } else if (interfaceC0465c != null) {
            interfaceC0465c.c(responseCode, sb.toString());
        }
    }
}

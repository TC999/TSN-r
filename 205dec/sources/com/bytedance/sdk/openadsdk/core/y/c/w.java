package com.bytedance.sdk.openadsdk.core.y.c;

import android.net.Network;
import java.io.Closeable;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import javax.net.ssl.HttpsURLConnection;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class w {

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public interface c {
        void c();

        void c(String str);
    }

    public static void c(Network network, String str, String str2, c cVar) {
        Closeable closeable;
        OutputStream outputStream;
        HttpsURLConnection httpsURLConnection;
        if (str == null) {
            cVar.c();
            return;
        }
        HttpsURLConnection httpsURLConnection2 = null;
        InputStream inputStream = null;
        try {
            if (network == null) {
                httpsURLConnection = (HttpsURLConnection) new URL(str).openConnection();
            } else {
                httpsURLConnection = (HttpsURLConnection) network.openConnection(new URL(str));
            }
            try {
                if (httpsURLConnection == null) {
                    cVar.c();
                    if (httpsURLConnection != null) {
                        httpsURLConnection.disconnect();
                    }
                    com.bytedance.sdk.openadsdk.n.sr.c((Closeable) null);
                    com.bytedance.sdk.openadsdk.n.sr.c((Closeable) null);
                    return;
                }
                httpsURLConnection.setRequestMethod("POST");
                httpsURLConnection.setConnectTimeout(10000);
                httpsURLConnection.setReadTimeout(10000);
                httpsURLConnection.setDoInput(true);
                httpsURLConnection.setDefaultUseCaches(false);
                if (str2 != null) {
                    httpsURLConnection.setDoOutput(true);
                    outputStream = httpsURLConnection.getOutputStream();
                    try {
                        outputStream.write(str2.getBytes());
                        outputStream.flush();
                    } catch (Throwable unused) {
                        httpsURLConnection2 = httpsURLConnection;
                        closeable = null;
                        try {
                            cVar.c();
                            return;
                        } finally {
                            if (httpsURLConnection2 != null) {
                                httpsURLConnection2.disconnect();
                            }
                            com.bytedance.sdk.openadsdk.n.sr.c(outputStream);
                            com.bytedance.sdk.openadsdk.n.sr.c(closeable);
                        }
                    }
                } else {
                    outputStream = null;
                }
                httpsURLConnection.connect();
                if (httpsURLConnection.getResponseCode() == 200) {
                    inputStream = httpsURLConnection.getInputStream();
                    byte[] bArr = new byte[2048];
                    StringBuilder sb = new StringBuilder();
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (read <= 0) {
                            break;
                        }
                        sb.append(new String(bArr, 0, read, StandardCharsets.UTF_8));
                    }
                    cVar.c(sb.toString());
                } else {
                    cVar.c();
                }
                httpsURLConnection.disconnect();
                com.bytedance.sdk.openadsdk.n.sr.c(outputStream);
                com.bytedance.sdk.openadsdk.n.sr.c(inputStream);
            } catch (Throwable unused2) {
                outputStream = null;
                httpsURLConnection2 = httpsURLConnection;
                closeable = null;
            }
        } catch (Throwable unused3) {
            closeable = null;
            outputStream = null;
        }
    }
}

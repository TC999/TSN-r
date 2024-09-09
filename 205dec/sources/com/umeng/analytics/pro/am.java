package com.umeng.analytics.pro;

import android.text.TextUtils;
import android.util.Log;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.security.SecureRandom;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: HttpManager.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class am {

    /* renamed from: a  reason: collision with root package name */
    private static HostnameVerifier f52538a;

    private static HostnameVerifier a() {
        if (f52538a == null) {
            f52538a = new HostnameVerifier() { // from class: com.umeng.analytics.pro.am.1
                @Override // javax.net.ssl.HostnameVerifier
                public boolean verify(String str, SSLSession sSLSession) {
                    if (TextUtils.isEmpty(str)) {
                        return false;
                    }
                    return "pre-ucc.umeng.com".equalsIgnoreCase(str) || "ucc.umeng.com".equalsIgnoreCase(str) || "aspect-upush.umeng.com".equalsIgnoreCase(str) || "pre-msg.umengcloud.com".equalsIgnoreCase(str);
                }
            };
        }
        return f52538a;
    }

    public static void b(String str, byte[] bArr) {
        byte[] bArr2;
        HttpsURLConnection httpsURLConnection = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                at.a(bArr, byteArrayOutputStream);
                bArr2 = at.a(byteArrayOutputStream.toByteArray(), UMConfigure.sAppkey.getBytes());
            } catch (Throwable unused) {
                bArr2 = null;
            }
            httpsURLConnection = a(str, "appkey", bArr2);
            if (httpsURLConnection != null) {
                int responseCode = httpsURLConnection.getResponseCode();
                if (responseCode != 200) {
                    Log.e("MobclickRT", "SC event report error, http error code: " + responseCode);
                } else {
                    UMRTLog.i("MobclickRT", "SC event report successful.");
                }
            }
            if (httpsURLConnection == null) {
                return;
            }
        } catch (Throwable th) {
            try {
                th.printStackTrace();
                if (0 == 0) {
                    return;
                }
            } catch (Throwable th2) {
                if (0 != 0) {
                    try {
                        httpsURLConnection.disconnect();
                    } catch (Throwable unused2) {
                    }
                }
                throw th2;
            }
        }
        try {
            httpsURLConnection.disconnect();
        } catch (Throwable unused3) {
        }
    }

    public static byte[] a(String str, String str2) {
        return a(str, str2.getBytes());
    }

    public static byte[] a(String str, byte[] bArr) {
        byte[] readStreamToByteArray;
        byte[] bArr2 = null;
        try {
            HttpsURLConnection a4 = a(str, "ak", at.a(bArr, UMConfigure.sAppkey.getBytes()));
            if (a4 != null && a4.getResponseCode() == 200) {
                InputStream inputStream = a4.getInputStream();
                try {
                    readStreamToByteArray = HelperUtils.readStreamToByteArray(inputStream);
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    String headerField = a4.getHeaderField("ak");
                    if (!TextUtils.isEmpty(headerField)) {
                        bArr2 = at.a(readStreamToByteArray, headerField.getBytes());
                    } else {
                        UMRTLog.e("MobclickRT", "ccg \u5e94\u7b54\u4e0d\u5305\u542bak!");
                    }
                    HelperUtils.safeClose(inputStream);
                } catch (Throwable th2) {
                    th = th2;
                    HelperUtils.safeClose(inputStream);
                    throw th;
                }
            }
        } catch (Throwable unused) {
        }
        return bArr2;
    }

    private static HttpsURLConnection a(String str, String str2, byte[] bArr) {
        HttpsURLConnection httpsURLConnection = null;
        try {
            HttpsURLConnection httpsURLConnection2 = (HttpsURLConnection) new URL(str).openConnection();
            try {
                SSLContext sSLContext = SSLContext.getInstance("TLS");
                sSLContext.init(null, null, new SecureRandom());
                httpsURLConnection2.setSSLSocketFactory(sSLContext.getSocketFactory());
                httpsURLConnection2.setHostnameVerifier(a());
                httpsURLConnection2.setRequestMethod("POST");
                httpsURLConnection2.setConnectTimeout(15000);
                httpsURLConnection2.setDoOutput(true);
                httpsURLConnection2.setDoInput(true);
                httpsURLConnection2.setReadTimeout(15000);
                httpsURLConnection2.addRequestProperty("Content-Type", "application/octet-stream");
                httpsURLConnection2.addRequestProperty(str2, UMConfigure.sAppkey);
                httpsURLConnection2.setRequestProperty("User-Agent", DeviceConfig.getCustomAgt());
                httpsURLConnection2.connect();
                OutputStream outputStream = httpsURLConnection2.getOutputStream();
                outputStream.write(bArr);
                outputStream.flush();
                outputStream.close();
                return httpsURLConnection2;
            } catch (Exception e4) {
                e = e4;
                httpsURLConnection = httpsURLConnection2;
                e.printStackTrace();
                return httpsURLConnection;
            }
        } catch (Exception e5) {
            e = e5;
        }
    }
}

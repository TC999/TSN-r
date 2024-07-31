package com.umeng.analytics.pro;

import android.text.TextUtils;
import android.util.Log;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import io.netty.handler.codec.http.multipart.HttpPostBodyUtil;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.security.SecureRandom;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;

/* renamed from: com.umeng.analytics.pro.am */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class HttpManager {

    /* renamed from: a */
    private static HostnameVerifier f37646a;

    /* renamed from: a */
    private static HostnameVerifier m14719a() {
        if (f37646a == null) {
            f37646a = new HostnameVerifier() { // from class: com.umeng.analytics.pro.am.1
                @Override // javax.net.ssl.HostnameVerifier
                public boolean verify(String str, SSLSession sSLSession) {
                    if (TextUtils.isEmpty(str)) {
                        return false;
                    }
                    return "pre-ucc.umeng.com".equalsIgnoreCase(str) || "ucc.umeng.com".equalsIgnoreCase(str) || "aspect-upush.umeng.com".equalsIgnoreCase(str) || "pre-msg.umengcloud.com".equalsIgnoreCase(str);
                }
            };
        }
        return f37646a;
    }

    /* renamed from: b */
    public static void m14715b(String str, byte[] bArr) {
        byte[] bArr2;
        HttpsURLConnection httpsURLConnection = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                ZipUtils.m14700a(bArr, byteArrayOutputStream);
                bArr2 = ZipUtils.m14699a(byteArrayOutputStream.toByteArray(), UMConfigure.sAppkey.getBytes());
            } catch (Throwable unused) {
                bArr2 = null;
            }
            httpsURLConnection = m14717a(str, "appkey", bArr2);
            if (httpsURLConnection != null) {
                int responseCode = httpsURLConnection.getResponseCode();
                if (responseCode != 200) {
                    Log.e(UMRTLog.RTLOG_TAG, "SC event report error, http error code: " + responseCode);
                } else {
                    UMRTLog.m14008i(UMRTLog.RTLOG_TAG, "SC event report successful.");
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

    /* renamed from: a */
    public static byte[] m14718a(String str, String str2) {
        return m14716a(str, str2.getBytes());
    }

    /* renamed from: a */
    public static byte[] m14716a(String str, byte[] bArr) {
        byte[] readStreamToByteArray;
        byte[] bArr2 = null;
        try {
            HttpsURLConnection m14717a = m14717a(str, SocializeProtocolConstants.PROTOCOL_KEY_AK, ZipUtils.m14699a(bArr, UMConfigure.sAppkey.getBytes()));
            if (m14717a != null && m14717a.getResponseCode() == 200) {
                InputStream inputStream = m14717a.getInputStream();
                try {
                    readStreamToByteArray = HelperUtils.readStreamToByteArray(inputStream);
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    String headerField = m14717a.getHeaderField(SocializeProtocolConstants.PROTOCOL_KEY_AK);
                    if (!TextUtils.isEmpty(headerField)) {
                        bArr2 = ZipUtils.m14699a(readStreamToByteArray, headerField.getBytes());
                    } else {
                        UMRTLog.m14009e(UMRTLog.RTLOG_TAG, "ccg 应答不包含ak!");
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

    /* renamed from: a */
    private static HttpsURLConnection m14717a(String str, String str2, byte[] bArr) {
        HttpsURLConnection httpsURLConnection = null;
        try {
            HttpsURLConnection httpsURLConnection2 = (HttpsURLConnection) new URL(str).openConnection();
            try {
                SSLContext sSLContext = SSLContext.getInstance("TLS");
                sSLContext.init(null, null, new SecureRandom());
                httpsURLConnection2.setSSLSocketFactory(sSLContext.getSocketFactory());
                httpsURLConnection2.setHostnameVerifier(m14719a());
                httpsURLConnection2.setRequestMethod("POST");
                httpsURLConnection2.setConnectTimeout(15000);
                httpsURLConnection2.setDoOutput(true);
                httpsURLConnection2.setDoInput(true);
                httpsURLConnection2.setReadTimeout(15000);
                httpsURLConnection2.addRequestProperty("Content-Type", HttpPostBodyUtil.DEFAULT_BINARY_CONTENT_TYPE);
                httpsURLConnection2.addRequestProperty(str2, UMConfigure.sAppkey);
                httpsURLConnection2.setRequestProperty("User-Agent", DeviceConfig.getCustomAgt());
                httpsURLConnection2.connect();
                OutputStream outputStream = httpsURLConnection2.getOutputStream();
                outputStream.write(bArr);
                outputStream.flush();
                outputStream.close();
                return httpsURLConnection2;
            } catch (Exception e) {
                e = e;
                httpsURLConnection = httpsURLConnection2;
                e.printStackTrace();
                return httpsURLConnection;
            }
        } catch (Exception e2) {
            e = e2;
        }
    }
}

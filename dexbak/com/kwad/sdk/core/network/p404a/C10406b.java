package com.kwad.sdk.core.network.p404a;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.mobads.sdk.internal.C2594an;
import com.clj.fastble.BleManager;
import com.kwad.framework.p346a.C9425a;
import com.kwad.sdk.core.network.C10415c;
import com.kwad.sdk.core.network.C10419e;
import com.kwad.sdk.core.network.C10440p;
import com.kwad.sdk.core.network.C10442r;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.crash.utils.C10738b;
import com.kwad.sdk.crash.utils.C10747h;
import com.kwad.sdk.export.proxy.AdHttpResponseHelper;
import com.kwad.sdk.export.proxy.AdHttpResponseListener;
import com.kwad.sdk.utils.C11064bn;
import io.netty.handler.codec.http.HttpHeaders;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.network.a.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10406b {
    /* renamed from: a */
    public static C10415c m26169a(String str, Map<String, String> map, boolean z) {
        InputStream inputStream;
        HttpURLConnection httpURLConnection;
        C10415c c10415c = new C10415c();
        HttpURLConnection httpURLConnection2 = null;
        r1 = null;
        r1 = null;
        InputStream inputStream2 = null;
        httpURLConnection2 = null;
        try {
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        } catch (Exception e) {
            e = e;
            inputStream = null;
        } catch (Throwable th) {
            th = th;
            inputStream = null;
        }
        try {
            C10442r.wrapHttpURLConnection(httpURLConnection);
            m26168a(httpURLConnection, map);
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setRequestProperty("Accept", C2594an.f8583d);
            C10440p.m26066b(httpURLConnection);
            int responseCode = httpURLConnection.getResponseCode();
            c10415c.code = responseCode;
            c10415c.avq = responseCode;
            StringBuilder sb = new StringBuilder();
            if (z) {
                inputStream2 = httpURLConnection.getInputStream();
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = inputStream2.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    sb.append(new String(bArr, 0, read));
                }
            }
            c10415c.avs = sb.toString();
            C10738b.m25007a(httpURLConnection);
            C10738b.closeQuietly(inputStream2);
        } catch (Exception e2) {
            e = e2;
            InputStream inputStream3 = inputStream2;
            httpURLConnection2 = httpURLConnection;
            inputStream = inputStream3;
            try {
                m26172a(c10415c, e);
                C10738b.m25007a(httpURLConnection2);
                C10738b.closeQuietly(inputStream);
                return c10415c;
            } catch (Throwable th2) {
                th = th2;
                C10738b.m25007a(httpURLConnection2);
                C10738b.closeQuietly(inputStream);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            InputStream inputStream4 = inputStream2;
            httpURLConnection2 = httpURLConnection;
            inputStream = inputStream4;
            C10738b.m25007a(httpURLConnection2);
            C10738b.closeQuietly(inputStream);
            throw th;
        }
        return c10415c;
    }

    /* renamed from: c */
    private static long m26167c(HttpURLConnection httpURLConnection) {
        for (Map.Entry<String, List<String>> entry : httpURLConnection.getHeaderFields().entrySet()) {
            String key = entry.getKey();
            if (key != null && "content-length".equals(key.toLowerCase())) {
                try {
                    return Long.parseLong(entry.getValue().get(0));
                } catch (Throwable unused) {
                }
            }
        }
        return -1L;
    }

    public static C10415c doGet(String str, Map<String, String> map) {
        return m26169a(str, map, true);
    }

    public static C10415c doPost(String str, Map<String, String> map, Map<String, String> map2) {
        String str2;
        if (map2 != null) {
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<String, String> entry : map2.entrySet()) {
                String encode = encode(entry.getValue());
                sb.append(entry.getKey());
                sb.append("=");
                sb.append(encode);
                sb.append("&");
            }
            str2 = sb.substring(0, sb.length() - 1);
        } else {
            str2 = null;
        }
        return m26170a(str, map, str2, false);
    }

    public static boolean downloadUrlToStream(String str, OutputStream outputStream, long j, AdHttpResponseListener adHttpResponseListener) {
        HttpURLConnection httpURLConnection;
        BufferedInputStream bufferedInputStream;
        long m26167c;
        try {
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            try {
                C10442r.wrapHttpURLConnection(httpURLConnection);
                AdHttpResponseHelper.notifyResponseStart(adHttpResponseListener);
                httpURLConnection.setRequestProperty("Accept-Language", "zh-CN");
                httpURLConnection.setConnectTimeout(BleManager.f22896l);
                httpURLConnection.setReadTimeout(120000);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setRequestProperty("Connection", "keep-alive");
                httpURLConnection.setRequestProperty("Charset", "UTF-8");
                C10440p.m26066b(httpURLConnection);
                m26167c = m26167c(httpURLConnection);
                bufferedInputStream = new BufferedInputStream(httpURLConnection.getInputStream());
            } catch (Throwable th) {
                th = th;
                bufferedInputStream = null;
            }
            try {
                byte[] bArr = new byte[1024];
                long j2 = 0;
                if (j > 0) {
                    do {
                        int read = bufferedInputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        j2 += read;
                        AdHttpResponseHelper.notifyResponseProgress(adHttpResponseListener, j2, m26167c);
                    } while (j2 <= j);
                } else if (j < 0) {
                    r2 = outputStream != null ? new BufferedOutputStream(outputStream) : null;
                    while (true) {
                        int read2 = bufferedInputStream.read(bArr);
                        if (read2 != -1) {
                            if (r2 != null) {
                                r2.write(bArr, 0, read2);
                            }
                            j2 += read2;
                            if (AdHttpResponseHelper.notifyResponseProgress(adHttpResponseListener, j2, m26167c)) {
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                    if (r2 != null) {
                        r2.flush();
                    }
                }
                AdHttpResponseHelper.notifyResponseEnd(adHttpResponseListener);
                C10738b.closeQuietly(r2);
                C10738b.closeQuietly(bufferedInputStream);
                httpURLConnection.disconnect();
                return true;
            } catch (Throwable th2) {
                th = th2;
                C10738b.closeQuietly(r2);
                C10738b.closeQuietly(bufferedInputStream);
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            httpURLConnection = null;
            bufferedInputStream = null;
        }
    }

    private static String encode(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            C10331c.printStackTrace(e);
            return "";
        }
    }

    public static C10415c doPost(String str, Map<String, String> map, JSONObject jSONObject) {
        return m26170a(str, map, jSONObject != null ? jSONObject.toString() : null, true);
    }

    /* renamed from: a */
    private static void m26168a(HttpURLConnection httpURLConnection, Map<String, String> map) {
        if (map == null || httpURLConnection == null) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
        }
    }

    /* renamed from: a */
    private static C10415c m26170a(String str, Map<String, String> map, String str2, boolean z) {
        OutputStream outputStream;
        HttpURLConnection httpURLConnection;
        C10415c c10415c = new C10415c();
        HttpURLConnection httpURLConnection2 = null;
        r1 = null;
        r1 = null;
        OutputStream outputStream2 = null;
        httpURLConnection2 = null;
        try {
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        } catch (Exception e) {
            e = e;
            outputStream = null;
        } catch (Throwable th) {
            th = th;
            outputStream = null;
        }
        try {
            C10442r.wrapHttpURLConnection(httpURLConnection);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setRequestMethod("POST");
            if (z) {
                httpURLConnection.setRequestProperty("Content-Type", C2594an.f8583d);
            } else {
                httpURLConnection.setRequestProperty("Content-Type", HttpHeaders.Values.APPLICATION_X_WWW_FORM_URLENCODED);
            }
            C10440p.m26066b(httpURLConnection);
            m26168a(httpURLConnection, map);
            httpURLConnection.setConnectTimeout(5000);
            httpURLConnection.setReadTimeout(5000);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.connect();
            if (!TextUtils.isEmpty(str2)) {
                outputStream2 = httpURLConnection.getOutputStream();
                outputStream2.write(str2.getBytes());
                outputStream2.flush();
            }
            int responseCode = httpURLConnection.getResponseCode();
            c10415c.code = responseCode;
            c10415c.avq = responseCode;
            if (responseCode == 200) {
                c10415c.avs = m26171a(httpURLConnection.getInputStream());
            }
            C10738b.m25007a(httpURLConnection);
            C10738b.closeQuietly(outputStream2);
        } catch (Exception e2) {
            e = e2;
            OutputStream outputStream3 = outputStream2;
            httpURLConnection2 = httpURLConnection;
            outputStream = outputStream3;
            try {
                m26172a(c10415c, e);
                C10738b.m25007a(httpURLConnection2);
                C10738b.closeQuietly(outputStream);
                return c10415c;
            } catch (Throwable th2) {
                th = th2;
                C10738b.m25007a(httpURLConnection2);
                C10738b.closeQuietly(outputStream);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            OutputStream outputStream4 = outputStream2;
            httpURLConnection2 = httpURLConnection;
            outputStream = outputStream4;
            C10738b.m25007a(httpURLConnection2);
            C10738b.closeQuietly(outputStream);
            throw th;
        }
        return c10415c;
    }

    /* renamed from: a */
    private static void m26172a(@NonNull C10415c c10415c, Exception exc) {
        int i = c10415c.code;
        if (i == 0) {
            i = -1;
        }
        c10415c.avq = i;
        c10415c.avr = exc;
        if (exc instanceof SocketTimeoutException) {
            C10419e c10419e = C10419e.avt;
            c10415c.code = c10419e.errorCode;
            c10415c.avs = c10419e.msg;
        } else {
            c10415c.code = C10419e.avu.errorCode;
            c10415c.avs = C10419e.avu.msg + "/" + C11064bn.m23856t(exc);
        }
        if (C9425a.f29473md.booleanValue()) {
            C10331c.printStackTraceOnly(exc);
        }
    }

    /* renamed from: a */
    private static String m26171a(InputStream inputStream) {
        try {
            try {
                return C10747h.m24943c(inputStream);
            } catch (IOException e) {
                C10331c.printStackTraceOnly(e);
                C10738b.closeQuietly(inputStream);
                return null;
            }
        } finally {
            C10738b.closeQuietly(inputStream);
        }
    }
}

package com.kwad.sdk.core.network.a;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
import com.kwad.sdk.core.network.e;
import com.kwad.sdk.core.network.p;
import com.kwad.sdk.core.network.r;
import com.kwad.sdk.crash.utils.h;
import com.kwad.sdk.export.proxy.AdHttpResponseHelper;
import com.kwad.sdk.export.proxy.AdHttpResponseListener;
import com.kwad.sdk.utils.bn;
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

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class b {
    public static com.kwad.sdk.core.network.c a(String str, Map<String, String> map, boolean z3) {
        InputStream inputStream;
        HttpURLConnection httpURLConnection;
        com.kwad.sdk.core.network.c cVar = new com.kwad.sdk.core.network.c();
        HttpURLConnection httpURLConnection2 = null;
        r1 = null;
        r1 = null;
        InputStream inputStream2 = null;
        httpURLConnection2 = null;
        try {
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        } catch (Exception e4) {
            e = e4;
            inputStream = null;
        } catch (Throwable th) {
            th = th;
            inputStream = null;
        }
        try {
            r.wrapHttpURLConnection(httpURLConnection);
            a(httpURLConnection, map);
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setRequestProperty("Accept", "application/json");
            p.b(httpURLConnection);
            int responseCode = httpURLConnection.getResponseCode();
            cVar.code = responseCode;
            cVar.avq = responseCode;
            StringBuilder sb = new StringBuilder();
            if (z3) {
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
            cVar.avs = sb.toString();
            com.kwad.sdk.crash.utils.b.a(httpURLConnection);
            com.kwad.sdk.crash.utils.b.closeQuietly(inputStream2);
        } catch (Exception e5) {
            e = e5;
            InputStream inputStream3 = inputStream2;
            httpURLConnection2 = httpURLConnection;
            inputStream = inputStream3;
            try {
                a(cVar, e);
                com.kwad.sdk.crash.utils.b.a(httpURLConnection2);
                com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
                return cVar;
            } catch (Throwable th2) {
                th = th2;
                com.kwad.sdk.crash.utils.b.a(httpURLConnection2);
                com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            InputStream inputStream4 = inputStream2;
            httpURLConnection2 = httpURLConnection;
            inputStream = inputStream4;
            com.kwad.sdk.crash.utils.b.a(httpURLConnection2);
            com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
            throw th;
        }
        return cVar;
    }

    private static long c(HttpURLConnection httpURLConnection) {
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

    public static com.kwad.sdk.core.network.c doGet(String str, Map<String, String> map) {
        return a(str, map, true);
    }

    public static com.kwad.sdk.core.network.c doPost(String str, Map<String, String> map, Map<String, String> map2) {
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
        return a(str, map, str2, false);
    }

    public static boolean downloadUrlToStream(String str, OutputStream outputStream, long j4, AdHttpResponseListener adHttpResponseListener) {
        HttpURLConnection httpURLConnection;
        BufferedInputStream bufferedInputStream;
        long c4;
        try {
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            try {
                r.wrapHttpURLConnection(httpURLConnection);
                AdHttpResponseHelper.notifyResponseStart(adHttpResponseListener);
                httpURLConnection.setRequestProperty("Accept-Language", "zh-CN");
                httpURLConnection.setConnectTimeout(10000);
                httpURLConnection.setReadTimeout(120000);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setRequestProperty("Connection", "keep-alive");
                httpURLConnection.setRequestProperty("Charset", "UTF-8");
                p.b(httpURLConnection);
                c4 = c(httpURLConnection);
                bufferedInputStream = new BufferedInputStream(httpURLConnection.getInputStream());
            } catch (Throwable th) {
                th = th;
                bufferedInputStream = null;
            }
            try {
                byte[] bArr = new byte[1024];
                long j5 = 0;
                if (j4 > 0) {
                    do {
                        int read = bufferedInputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        j5 += read;
                        AdHttpResponseHelper.notifyResponseProgress(adHttpResponseListener, j5, c4);
                    } while (j5 <= j4);
                } else if (j4 < 0) {
                    r2 = outputStream != null ? new BufferedOutputStream(outputStream) : null;
                    while (true) {
                        int read2 = bufferedInputStream.read(bArr);
                        if (read2 != -1) {
                            if (r2 != null) {
                                r2.write(bArr, 0, read2);
                            }
                            j5 += read2;
                            if (AdHttpResponseHelper.notifyResponseProgress(adHttpResponseListener, j5, c4)) {
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
                com.kwad.sdk.crash.utils.b.closeQuietly(r2);
                com.kwad.sdk.crash.utils.b.closeQuietly(bufferedInputStream);
                httpURLConnection.disconnect();
                return true;
            } catch (Throwable th2) {
                th = th2;
                com.kwad.sdk.crash.utils.b.closeQuietly(r2);
                com.kwad.sdk.crash.utils.b.closeQuietly(bufferedInputStream);
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
        } catch (UnsupportedEncodingException e4) {
            com.kwad.sdk.core.e.c.printStackTrace(e4);
            return "";
        }
    }

    public static com.kwad.sdk.core.network.c doPost(String str, Map<String, String> map, JSONObject jSONObject) {
        return a(str, map, jSONObject != null ? jSONObject.toString() : null, true);
    }

    private static void a(HttpURLConnection httpURLConnection, Map<String, String> map) {
        if (map == null || httpURLConnection == null) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
        }
    }

    private static com.kwad.sdk.core.network.c a(String str, Map<String, String> map, String str2, boolean z3) {
        OutputStream outputStream;
        HttpURLConnection httpURLConnection;
        com.kwad.sdk.core.network.c cVar = new com.kwad.sdk.core.network.c();
        HttpURLConnection httpURLConnection2 = null;
        r1 = null;
        r1 = null;
        OutputStream outputStream2 = null;
        httpURLConnection2 = null;
        try {
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        } catch (Exception e4) {
            e = e4;
            outputStream = null;
        } catch (Throwable th) {
            th = th;
            outputStream = null;
        }
        try {
            r.wrapHttpURLConnection(httpURLConnection);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setRequestMethod("POST");
            if (z3) {
                httpURLConnection.setRequestProperty("Content-Type", "application/json");
            } else {
                httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            }
            p.b(httpURLConnection);
            a(httpURLConnection, map);
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
            cVar.code = responseCode;
            cVar.avq = responseCode;
            if (responseCode == 200) {
                cVar.avs = a(httpURLConnection.getInputStream());
            }
            com.kwad.sdk.crash.utils.b.a(httpURLConnection);
            com.kwad.sdk.crash.utils.b.closeQuietly(outputStream2);
        } catch (Exception e5) {
            e = e5;
            OutputStream outputStream3 = outputStream2;
            httpURLConnection2 = httpURLConnection;
            outputStream = outputStream3;
            try {
                a(cVar, e);
                com.kwad.sdk.crash.utils.b.a(httpURLConnection2);
                com.kwad.sdk.crash.utils.b.closeQuietly(outputStream);
                return cVar;
            } catch (Throwable th2) {
                th = th2;
                com.kwad.sdk.crash.utils.b.a(httpURLConnection2);
                com.kwad.sdk.crash.utils.b.closeQuietly(outputStream);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            OutputStream outputStream4 = outputStream2;
            httpURLConnection2 = httpURLConnection;
            outputStream = outputStream4;
            com.kwad.sdk.crash.utils.b.a(httpURLConnection2);
            com.kwad.sdk.crash.utils.b.closeQuietly(outputStream);
            throw th;
        }
        return cVar;
    }

    private static void a(@NonNull com.kwad.sdk.core.network.c cVar, Exception exc) {
        int i4 = cVar.code;
        if (i4 == 0) {
            i4 = -1;
        }
        cVar.avq = i4;
        cVar.avr = exc;
        if (exc instanceof SocketTimeoutException) {
            e eVar = e.avt;
            cVar.code = eVar.errorCode;
            cVar.avs = eVar.msg;
        } else {
            cVar.code = e.avu.errorCode;
            cVar.avs = e.avu.msg + TTPathConst.sSeparator + bn.t(exc);
        }
        if (com.kwad.framework.a.a.md.booleanValue()) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(exc);
        }
    }

    private static String a(InputStream inputStream) {
        try {
            try {
                return h.c(inputStream);
            } catch (IOException e4) {
                com.kwad.sdk.core.e.c.printStackTraceOnly(e4);
                com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
                return null;
            }
        } finally {
            com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
        }
    }
}

package com.kwad.sdk.core.network.p404a;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.framework.p346a.C9425a;
import com.kwad.sdk.core.network.C10415c;
import com.kwad.sdk.core.network.C10419e;
import com.kwad.sdk.core.network.C10440p;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.crash.utils.C10738b;
import com.kwad.sdk.export.proxy.AdHttpBodyBuilder;
import com.kwad.sdk.export.proxy.AdHttpFormDataBuilder;
import com.kwad.sdk.export.proxy.AdHttpResponseHelper;
import com.kwad.sdk.export.proxy.AdHttpResponseListener;
import com.kwad.sdk.utils.C11064bn;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.SocketTimeoutException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.GZIPInputStream;
import okhttp3.ConnectionSpec;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.network.a.c */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10407c {
    private static final Pattern awu = Pattern.compile("Unexpected response code for CONNECT: ([0-9]+)", 2);
    public static String awv = "UTF-8";
    private static OkHttpClient aww = null;
    public static OkHttpClient awx = m26165DT();

    /* renamed from: DS */
    public static OkHttpClient m26166DS() {
        if (C9425a.f29473md.booleanValue()) {
            if (aww == null) {
                aww = awx.newBuilder().build();
            }
            return aww;
        }
        return awx;
    }

    /* renamed from: DT */
    private static OkHttpClient m26165DT() {
        if (awx == null) {
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            OkHttpClient.Builder connectionSpecs = builder.connectTimeout(3000L, timeUnit).readTimeout(6000L, timeUnit).connectionSpecs(Arrays.asList(ConnectionSpec.MODERN_TLS, ConnectionSpec.COMPATIBLE_TLS, ConnectionSpec.CLEARTEXT));
            try {
                connectionSpecs.dns(new C10409d());
            } catch (Throwable th) {
                C10331c.printStackTrace(th);
            }
            awx = connectionSpecs.build();
        }
        return awx;
    }

    /* renamed from: a */
    public static C10415c m26163a(String str, @Nullable Map<String, String> map, boolean z) {
        C10415c c10415c = new C10415c();
        try {
            Request.Builder url = new Request.Builder().url(str);
            m26162a(url);
            m26161a(url, map);
            Response execute = m26166DS().newCall(url.build()).execute();
            int code = execute.code();
            c10415c.code = code;
            c10415c.avq = code;
            c10415c.avs = z ? m26159a(execute) : "";
        } catch (Exception e) {
            m26164a(c10415c, e);
        }
        return c10415c;
    }

    /* renamed from: b */
    private static void m26157b(Request.Builder builder, Map<String, String> map) {
        FormBody formBody;
        if (map == null || map.isEmpty()) {
            formBody = null;
        } else {
            FormBody.Builder builder2 = new FormBody.Builder();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (entry != null) {
                    try {
                        builder2.addEncoded(entry.getKey(), encode(entry.getValue()));
                    } catch (Exception unused) {
                    }
                }
            }
            formBody = builder2.build();
        }
        if (builder == null || formBody == null) {
            return;
        }
        builder.post(formBody);
    }

    public static C10415c doGet(String str, @Nullable Map<String, String> map) {
        return m26163a(str, map, true);
    }

    public static C10415c doPost(String str, Map<String, String> map, JSONObject jSONObject) {
        C10415c c10415c = new C10415c();
        try {
            Request.Builder url = new Request.Builder().url(str);
            m26162a(url);
            m26161a(url, map);
            m26160a(url, jSONObject);
            Response execute = m26166DS().newCall(url.build()).execute();
            int code = execute.code();
            c10415c.code = code;
            c10415c.avq = code;
            c10415c.avs = m26159a(execute);
        } catch (Exception e) {
            m26164a(c10415c, e);
        }
        return c10415c;
    }

    public static boolean downloadUrlToStream(String str, OutputStream outputStream, long j, @Nullable AdHttpResponseListener adHttpResponseListener) {
        C10415c c10415c = new C10415c();
        Request.Builder url = new Request.Builder().url(str);
        HashMap hashMap = new HashMap();
        hashMap.put("Accept-Language", "zh-CN");
        hashMap.put("Connection", "keep-alive");
        hashMap.put("Charset", "UTF-8");
        m26162a(url);
        m26161a(url, hashMap);
        Response execute = m26166DS().newCall(url.build()).execute();
        int code = execute.code();
        c10415c.code = code;
        c10415c.avq = code;
        if (execute.code() == 200) {
            m26158a(execute, outputStream, j, adHttpResponseListener);
            return true;
        }
        throw new FileNotFoundException(str);
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

    /* renamed from: b */
    private static long m26156b(Response response) {
        try {
            return Long.parseLong(response.header("content-length"));
        } catch (Throwable unused) {
            return -1L;
        }
    }

    /* renamed from: a */
    private static void m26162a(Request.Builder builder) {
        builder.addHeader("User-Agent", C10440p.getUserAgent());
        builder.addHeader("BrowserUa", C10440p.m26067DP());
        builder.addHeader("SystemUa", C10440p.m26068DO());
    }

    public static C10415c doPost(String str, Map<String, String> map, Map<String, String> map2) {
        C10415c c10415c = new C10415c();
        try {
            Request.Builder url = new Request.Builder().url(str);
            m26162a(url);
            m26161a(url, map);
            m26157b(url, map2);
            Response execute = m26166DS().newCall(url.build()).execute();
            int code = execute.code();
            c10415c.code = code;
            c10415c.avq = code;
            c10415c.avs = m26159a(execute);
        } catch (Exception e) {
            m26164a(c10415c, e);
        }
        return c10415c;
    }

    /* renamed from: a */
    private static void m26164a(@NonNull C10415c c10415c, Exception exc) {
        String message;
        c10415c.avr = exc;
        if (c10415c.avq == -1 && (exc instanceof IOException) && (message = exc.getMessage()) != null) {
            Matcher matcher = awu.matcher(message);
            if (matcher.find()) {
                try {
                    c10415c.avq = Integer.parseInt(matcher.group(1));
                } catch (Exception unused) {
                }
            }
        }
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

    public static C10415c doPost(String str, Map<String, String> map, AdHttpBodyBuilder adHttpBodyBuilder) {
        C10415c c10415c = new C10415c();
        try {
            final MultipartBody.Builder type = new MultipartBody.Builder().setType(MultipartBody.FORM);
            if (adHttpBodyBuilder != null) {
                adHttpBodyBuilder.buildFormData(new AdHttpFormDataBuilder() { // from class: com.kwad.sdk.core.network.a.c.1
                    @Override // com.kwad.sdk.export.proxy.AdHttpFormDataBuilder
                    public final void addFormDataPart(String str2, String str3) {
                        MultipartBody.Builder.this.addFormDataPart(str2, str3);
                    }

                    @Override // com.kwad.sdk.export.proxy.AdHttpFormDataBuilder
                    public final void addFormDataPart(String str2, String str3, String str4, byte[] bArr) {
                        MultipartBody.Builder.this.addFormDataPart(str2, str3, RequestBody.create(MediaType.parse(str4), bArr));
                    }
                });
            }
            Request.Builder post = new Request.Builder().url(str).post(type.build());
            m26161a(post, map);
            Response execute = m26166DS().newCall(post.build()).execute();
            int code = execute.code();
            c10415c.code = code;
            c10415c.avq = code;
            c10415c.avs = m26159a(execute);
        } catch (Exception e) {
            m26164a(c10415c, e);
        }
        return c10415c;
    }

    /* renamed from: a */
    private static void m26161a(Request.Builder builder, @Nullable Map<String, String> map) {
        if (builder == null || map == null || map.isEmpty()) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry != null) {
                try {
                    builder.removeHeader(entry.getKey());
                    builder.addHeader(entry.getKey(), entry.getValue());
                } catch (Exception unused) {
                }
            }
        }
    }

    /* renamed from: a */
    private static void m26160a(Request.Builder builder, JSONObject jSONObject) {
        builder.post(RequestBody.create(MediaType.parse("application/json; charset=utf-8"), jSONObject.toString()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.io.Closeable, java.io.Reader, java.io.InputStreamReader] */
    /* renamed from: a */
    private static String m26159a(Response response) {
        InputStream inputStream;
        InputStream inputStream2;
        ?? r4;
        InputStream inputStream3;
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader = null;
        try {
            inputStream = response.body().byteStream();
            try {
                List<String> headers = response.headers("Content-Encoding");
                boolean z = false;
                if (headers != null) {
                    Iterator<String> it = headers.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        } else if ("gzip".equalsIgnoreCase(it.next())) {
                            z = true;
                            break;
                        }
                    }
                }
                if (z) {
                    inputStream3 = new GZIPInputStream(inputStream);
                    inputStream2 = inputStream3;
                } else {
                    inputStream2 = null;
                    inputStream3 = inputStream;
                }
                try {
                    r4 = new InputStreamReader(inputStream3, awv);
                    try {
                        BufferedReader bufferedReader2 = new BufferedReader(r4, 8);
                        while (true) {
                            try {
                                String readLine = bufferedReader2.readLine();
                                if (readLine != null) {
                                    sb.append(readLine);
                                } else {
                                    C10738b.closeQuietly(bufferedReader2);
                                    C10738b.closeQuietly((Closeable) r4);
                                    C10738b.closeQuietly(inputStream2);
                                    C10738b.closeQuietly(inputStream);
                                    return sb.toString();
                                }
                            } catch (Throwable th) {
                                bufferedReader = bufferedReader2;
                                th = th;
                                C10738b.closeQuietly(bufferedReader);
                                C10738b.closeQuietly((Closeable) r4);
                                C10738b.closeQuietly(inputStream2);
                                C10738b.closeQuietly(inputStream);
                                throw th;
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    r4 = 0;
                }
            } catch (Throwable th4) {
                th = th4;
                inputStream2 = null;
                r4 = inputStream2;
                C10738b.closeQuietly(bufferedReader);
                C10738b.closeQuietly((Closeable) r4);
                C10738b.closeQuietly(inputStream2);
                C10738b.closeQuietly(inputStream);
                throw th;
            }
        } catch (Throwable th5) {
            th = th5;
            inputStream = null;
            inputStream2 = null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    private static boolean m26158a(Response response, OutputStream outputStream, long j, AdHttpResponseListener adHttpResponseListener) {
        Throwable th;
        Closeable closeable;
        InputStream inputStream;
        InputStream inputStream2;
        boolean z;
        InputStream inputStream3;
        BufferedInputStream bufferedInputStream;
        try {
            AdHttpResponseHelper.notifyResponseStart(adHttpResponseListener);
            inputStream = response.body().byteStream();
            try {
                List<String> headers = response.headers("Content-Encoding");
                long m26156b = m26156b(response);
                if (headers != null) {
                    for (String str : headers) {
                        if ("gzip".equalsIgnoreCase(str)) {
                            z = true;
                            break;
                        }
                    }
                }
                z = false;
                if (z) {
                    inputStream3 = new GZIPInputStream(inputStream);
                    inputStream2 = inputStream3;
                } else {
                    inputStream2 = null;
                    inputStream3 = inputStream;
                }
                try {
                    bufferedInputStream = new BufferedInputStream(inputStream3);
                } catch (Throwable th2) {
                    th = th2;
                    closeable = null;
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
                            AdHttpResponseHelper.notifyResponseProgress(adHttpResponseListener, j2, m26156b);
                        } while (j2 <= j);
                    } else if (j < 0) {
                        r2 = outputStream != null ? new BufferedOutputStream(outputStream) : null;
                        while (true) {
                            int read2 = bufferedInputStream.read(bArr);
                            if (read2 == -1) {
                                break;
                            }
                            if (r2 != null) {
                                r2.write(bArr, 0, read2);
                            }
                            j2 += read2;
                            if (AdHttpResponseHelper.notifyResponseProgress(adHttpResponseListener, j2, m26156b)) {
                                break;
                            }
                        }
                        if (r2 != null) {
                            r2.flush();
                        }
                    }
                    C10738b.closeQuietly(bufferedInputStream);
                    C10738b.closeQuietly(r2);
                    C10738b.closeQuietly(inputStream2);
                    C10738b.closeQuietly(inputStream);
                    return true;
                } catch (Throwable th3) {
                    th = th3;
                    closeable = null;
                    r2 = bufferedInputStream;
                    C10738b.closeQuietly(r2);
                    C10738b.closeQuietly(closeable);
                    C10738b.closeQuietly(inputStream2);
                    C10738b.closeQuietly(inputStream);
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                closeable = null;
                inputStream2 = null;
            }
        } catch (Throwable th5) {
            th = th5;
            closeable = null;
            inputStream = null;
            inputStream2 = null;
        }
    }
}

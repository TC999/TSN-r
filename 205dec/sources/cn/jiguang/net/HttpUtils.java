package cn.jiguang.net;

import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import cn.jiguang.cn.d;
import cn.jiguang.f.i;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class HttpUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final String f3742a = d.b(new byte[]{32, 0, 14, 41, 38, 38, 63, 1, 23, 43});

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public static abstract class HttpListener {
        protected void a() {
        }

        protected void a(HttpResponse httpResponse) {
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    private static class a extends AsyncTask<HttpRequest, Void, HttpResponse> {

        /* renamed from: a  reason: collision with root package name */
        private HttpListener f3743a;

        /* renamed from: b  reason: collision with root package name */
        private Context f3744b;

        public a(Context context, HttpListener httpListener) {
            this.f3743a = httpListener;
            this.f3744b = context;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public HttpResponse doInBackground(HttpRequest... httpRequestArr) {
            if (httpRequestArr == null || httpRequestArr.length == 0) {
                return null;
            }
            return HttpUtils.httpGet(this.f3744b, httpRequestArr[0]);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public void onPostExecute(HttpResponse httpResponse) {
            HttpListener httpListener = this.f3743a;
            if (httpListener != null) {
                httpListener.a(httpResponse);
            }
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            HttpListener httpListener = this.f3743a;
            if (httpListener != null) {
                httpListener.a();
            }
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    private static class b extends AsyncTask<String, Void, HttpResponse> {

        /* renamed from: a  reason: collision with root package name */
        private HttpListener f3745a;

        /* renamed from: b  reason: collision with root package name */
        private Context f3746b;

        public b(HttpListener httpListener, Context context) {
            this.f3745a = httpListener;
            this.f3746b = context;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public HttpResponse doInBackground(String... strArr) {
            if (strArr == null || strArr.length == 0) {
                return null;
            }
            return HttpUtils.httpGet(this.f3746b, strArr[0]);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public void onPostExecute(HttpResponse httpResponse) {
            HttpListener httpListener = this.f3745a;
            if (httpListener != null) {
                httpListener.a(httpResponse);
            }
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            HttpListener httpListener = this.f3745a;
            if (httpListener != null) {
                httpListener.a();
            }
        }
    }

    private static void a(HttpRequest httpRequest, HttpURLConnection httpURLConnection) {
        if (httpRequest == null || httpURLConnection == null) {
            return;
        }
        setURLConnection(httpRequest.getRequestProperties(), httpURLConnection);
        if (httpRequest.getConnectTimeout() >= 0) {
            httpURLConnection.setConnectTimeout(httpRequest.getConnectTimeout());
        }
        if (httpRequest.getReadTimeout() >= 0) {
            httpURLConnection.setReadTimeout(httpRequest.getReadTimeout());
        }
    }

    private static void a(HttpURLConnection httpURLConnection, HttpResponse httpResponse) {
        if (httpResponse == null || httpURLConnection == null) {
            return;
        }
        httpResponse.setResponseCode(httpURLConnection.getResponseCode());
        httpResponse.setStatusCode(httpURLConnection.getResponseCode());
        httpResponse.setResponseHeader("expires", httpURLConnection.getHeaderField("Expires"));
        httpResponse.setResponseHeader("cache-control", httpURLConnection.getHeaderField("Cache-Control"));
    }

    public static String appendParaToUrl(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        StringBuilder sb = new StringBuilder(str);
        if (str.contains("?")) {
            sb.append("&");
        } else {
            sb.append("?");
        }
        sb.append(str2);
        sb.append("=");
        sb.append(str3);
        return sb.toString();
    }

    public static HttpURLConnection getHttpURLConnectionWithProxy(Context context, String str) {
        return (HttpURLConnection) new URL(str).openConnection();
    }

    public static String getUrlWithParas(String str, Map<String, String> map) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        StringBuilder sb = new StringBuilder(str);
        String joinParas = joinParas(map);
        if (!TextUtils.isEmpty(joinParas)) {
            sb.append("?");
            sb.append(joinParas);
        }
        return sb.toString();
    }

    public static String getUrlWithValueEncodeParas(String str, Map<String, String> map) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        StringBuilder sb = new StringBuilder(str);
        String joinParasWithEncodedValue = joinParasWithEncodedValue(map);
        if (!TextUtils.isEmpty(joinParasWithEncodedValue)) {
            sb.append("?");
            sb.append(joinParasWithEncodedValue);
        }
        return sb.toString();
    }

    public static HttpResponse httpGet(Context context, HttpRequest httpRequest) {
        return httpResponse(context, httpRequest, false);
    }

    public static HttpResponse httpGet(Context context, String str) {
        return httpGet(context, new HttpRequest(str));
    }

    public static void httpGet(Context context, HttpRequest httpRequest, HttpListener httpListener) {
        new a(context, httpListener).execute(httpRequest);
    }

    public static void httpGet(Context context, String str, HttpListener httpListener) {
        new b(httpListener, context).execute(str);
    }

    public static String httpGetString(Context context, HttpRequest httpRequest) {
        HttpResponse httpGet = httpGet(context, httpRequest);
        if (httpGet == null) {
            return null;
        }
        return httpGet.getResponseBody();
    }

    public static String httpGetString(Context context, String str) {
        HttpResponse httpGet = httpGet(context, new HttpRequest(str));
        if (httpGet == null) {
            return null;
        }
        return httpGet.getResponseBody();
    }

    public static HttpResponse httpPost(Context context, HttpRequest httpRequest) {
        return httpResponse(context, httpRequest, true, false);
    }

    public static HttpResponse httpPost(Context context, String str) {
        return httpPost(context, new HttpRequest(str));
    }

    public static String httpPostString(Context context, String str) {
        HttpResponse httpPost = httpPost(context, new HttpRequest(str));
        if (httpPost == null) {
            return null;
        }
        return httpPost.getResponseBody();
    }

    public static String httpPostString(Context context, String str, Map<String, String> map) {
        HttpResponse httpPost = httpPost(context, new HttpRequest(str, map));
        if (httpPost == null) {
            return null;
        }
        return httpPost.getResponseBody();
    }

    public static HttpResponse httpResponse(Context context, HttpRequest httpRequest, boolean z3) {
        return httpResponse(context, httpRequest, z3, false);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(20:15|(3:16|17|(4:18|19|20|(5:22|(1:24)|25|(1:27)(1:29)|28)))|(3:(1:122)(1:135)|123|(4:125|127|128|(15:39|40|41|42|43|44|(10:47|48|(3:64|65|(1:67))|(1:55)|(1:57)|58|59|60|61|62)|72|(3:51|53|55)|(0)|58|59|60|61|62)(3:36|37|38)))|32|(1:34)|39|40|41|42|43|44|(10:47|48|(0)|(0)|(0)|58|59|60|61|62)|72|(0)|(0)|58|59|60|61|62) */
    /* JADX WARN: Can't wrap try/catch for region: R(25:15|16|17|18|19|20|(5:22|(1:24)|25|(1:27)(1:29)|28)|(3:(1:122)(1:135)|123|(4:125|127|128|(15:39|40|41|42|43|44|(10:47|48|(3:64|65|(1:67))|(1:55)|(1:57)|58|59|60|61|62)|72|(3:51|53|55)|(0)|58|59|60|61|62)(3:36|37|38)))|32|(1:34)|39|40|41|42|43|44|(10:47|48|(0)|(0)|(0)|58|59|60|61|62)|72|(0)|(0)|58|59|60|61|62) */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x0238, code lost:
        r5.setResponseCode(3001);
        r7 = "\u8bf7\u6c42\u8d85\u65f6";
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x0246, code lost:
        if ((r0 instanceof java.net.UnknownHostException) != false) goto L102;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x0248, code lost:
        r5.setResponseCode(3003);
        r7 = "\u57df\u540d\u65e0\u6548";
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x0253, code lost:
        if ((r0 instanceof javax.net.ssl.SSLHandshakeException) != false) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x0255, code lost:
        r5.setResponseCode(3005);
        r7 = "SSL\u5931\u8d25";
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x0280, code lost:
        r4.disconnect();
     */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x02b8, code lost:
        if (r10 != null) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0157, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0159, code lost:
        cn.jiguang.bq.d.c("HttpUtils", "get input stream error:" + r0.getMessage());
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0171, code lost:
        r12 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x01bc, code lost:
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x01bd, code lost:
        r7 = r4;
        r4 = r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x01c0, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x01c1, code lost:
        r6 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x01c3, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x01c4, code lost:
        r6 = r4;
        r4 = r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x021e, code lost:
        if (r10 != null) goto L60;
     */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0238 A[Catch: all -> 0x0284, TryCatch #4 {all -> 0x0284, blocks: (B:105:0x022b, B:107:0x0238, B:108:0x0240, B:115:0x025d, B:109:0x0244, B:111:0x0248, B:112:0x0251, B:114:0x0255), top: B:140:0x022b }] */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0244 A[Catch: all -> 0x0284, TryCatch #4 {all -> 0x0284, blocks: (B:105:0x022b, B:107:0x0238, B:108:0x0240, B:115:0x025d, B:109:0x0244, B:111:0x0248, B:112:0x0251, B:114:0x0255), top: B:140:0x022b }] */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0280  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x02d9  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0180 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01a4 A[Catch: all -> 0x01bc, IOException -> 0x01c0, MalformedURLException -> 0x01c3, TryCatch #13 {MalformedURLException -> 0x01c3, IOException -> 0x01c0, all -> 0x01bc, blocks: (B:54:0x0172, B:68:0x0194, B:70:0x019a, B:72:0x01a4, B:73:0x01ae), top: B:154:0x0172 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static cn.jiguang.net.HttpResponse httpResponse(android.content.Context r15, cn.jiguang.net.HttpRequest r16, boolean r17, boolean r18) {
        /*
            Method dump skipped, instructions count: 735
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.net.HttpUtils.httpResponse(android.content.Context, cn.jiguang.net.HttpRequest, boolean, boolean):cn.jiguang.net.HttpResponse");
    }

    public static String joinParas(Map<String, String> map) {
        if (map == null || map.size() == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, String> next = it.next();
            sb.append(next.getKey());
            sb.append("=");
            sb.append(next.getValue());
            if (it.hasNext()) {
                sb.append("&");
            }
        }
        return sb.toString();
    }

    public static String joinParasWithEncodedValue(Map<String, String> map) {
        StringBuilder sb = new StringBuilder("");
        if (map != null && map.size() > 0) {
            Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                try {
                    Map.Entry<String, String> next = it.next();
                    sb.append(next.getKey());
                    sb.append("=");
                    sb.append(URLEncoder.encode(next.getValue(), "UTF-8"));
                    if (it.hasNext()) {
                        sb.append("&");
                    }
                } catch (Exception unused) {
                }
            }
        }
        return sb.toString();
    }

    public static long parseGmtTime(String str) {
        try {
            return cn.jiguang.f.b.a("EEE, d MMM yyyy HH:mm:ss z").parse(str).getTime();
        } catch (Exception unused) {
            return -1L;
        }
    }

    public static byte[] readInputStream(InputStream inputStream) {
        return i.b(inputStream);
    }

    public static void setURLConnection(Map<String, String> map, HttpURLConnection httpURLConnection) {
        if (map == null || map.size() == 0 || httpURLConnection == null) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (!TextUtils.isEmpty(entry.getKey())) {
                httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
            }
        }
    }
}

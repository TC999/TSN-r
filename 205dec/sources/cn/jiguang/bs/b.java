package cn.jiguang.bs;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import cn.jiguang.api.JCoreManager;
import cn.jiguang.f.i;
import cn.jiguang.net.HttpRequest;
import cn.jiguang.net.HttpResponse;
import cn.jiguang.net.HttpUtils;
import cn.jiguang.net.SSLTrustManager;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Set;
import javax.net.ssl.X509TrustManager;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static SSLTrustManager f2843a;

    public static g a(Context context, String str, byte[] bArr, int i4, int i5, int i6, Set<String> set) {
        try {
            HttpRequest httpRequest = new HttpRequest(str);
            httpRequest.setType(set.toString());
            a(httpRequest, context, bArr, i4, i6);
            while (i5 > 0) {
                i5--;
                HttpResponse httpPost = HttpUtils.httpPost(context, httpRequest);
                int responseCode = httpPost.getResponseCode();
                cn.jiguang.bq.d.d("HttpHelper", "status code:" + responseCode + " retry left:" + i5);
                if (responseCode == 200) {
                    return new g(0, httpPost.getResponseBody());
                }
                if (responseCode == 401) {
                    return new g(-3, httpPost.getResponseBody());
                }
                if (responseCode == 404 || responseCode == 410 || responseCode == 429) {
                    return new g(-1, httpPost.getResponseBody());
                }
                if (responseCode == 503) {
                    return new g(-2, httpPost.getResponseBody());
                }
                if (responseCode != 3005) {
                    return responseCode >= 500 ? new g(-1, httpPost.getResponseBody()) : new g(-2, httpPost.getResponseBody());
                }
            }
            return new g(-2, "Failed - retry enough");
        } catch (AssertionError e4) {
            return new g(-2, "Catch AssertionError to avoid http close crash - " + e4.getMessage());
        } catch (Exception e5) {
            return new g(-2, "Exception - " + e5.getMessage());
        } catch (Throwable th) {
            return new g(-2, "Exception - " + th.getMessage());
        }
    }

    public static g a(String str, String str2, Context context, boolean z3, int i4, int i5) {
        try {
            try {
                byte[] bytes = str2.getBytes("UTF-8");
                if (z3) {
                    try {
                        bytes = i.a(bytes);
                    } catch (IOException e4) {
                        return new g(-2, "zip err:" + e4.getMessage());
                    }
                }
                HttpRequest httpRequest = new HttpRequest(str);
                a(httpRequest, context, bytes, i5);
                while (i4 > 0) {
                    i4--;
                    HttpResponse httpPost = HttpUtils.httpPost(context, httpRequest);
                    int responseCode = httpPost.getResponseCode();
                    cn.jiguang.bq.d.d("HttpHelper", "status code:" + responseCode + " retry left:" + i4);
                    if (responseCode == 200) {
                        return new g(0, httpPost.getResponseBody());
                    }
                    if (responseCode == 401) {
                        return new g(-3, httpPost.getResponseBody());
                    }
                    if (responseCode == 404 || responseCode == 410 || responseCode == 429) {
                        return new g(-1, httpPost.getResponseBody());
                    }
                    if (responseCode == 503) {
                        return new g(-2, httpPost.getResponseBody());
                    }
                    if (responseCode != 3005) {
                        return responseCode != 3006 ? responseCode >= 500 ? new g(-1, httpPost.getResponseBody()) : new g(-2, httpPost.getResponseBody()) : new g(3006, httpPost.getResponseBody());
                    }
                }
                return new g(-2, "Failed - retry enough");
            } catch (AssertionError e5) {
                return new g(-2, "Catch AssertionError to avoid http close crash - " + e5.getMessage());
            } catch (Exception e6) {
                return new g(-2, "Exception - " + e6.getMessage());
            } catch (Throwable th) {
                return new g(-2, "Exception - " + th.getMessage());
            }
        } catch (UnsupportedEncodingException e7) {
            return new g(-2, "Exception - " + e7.getMessage());
        }
    }

    private static void a(HttpRequest httpRequest, Context context, byte[] bArr, int i4) {
        String a4;
        httpRequest.setConnectTimeout(30000);
        httpRequest.setReadTimeout(30000);
        httpRequest.setDoOutPut(true);
        httpRequest.setDoInPut(true);
        httpRequest.setUseCaches(false);
        String a5 = cn.jiguang.cn.g.a(cn.jiguang.cn.g.a());
        byte[] a6 = cn.jiguang.cn.g.a(bArr, a5, (i4 == 2 || i4 == 3) ? f.f2864a : f.f2865b, true);
        httpRequest.setBody(a6);
        httpRequest.setRequestProperty("Content-Length", String.valueOf(a6.length));
        httpRequest.setNeedRetryIfHttpsFailed(true);
        if (f2843a == null) {
            try {
                if (!TextUtils.isEmpty("")) {
                    f2843a = new SSLTrustManager("");
                }
            } catch (Throwable unused) {
            }
        }
        X509TrustManager x509TrustManager = f2843a;
        if (x509TrustManager != null) {
            httpRequest.setSslTrustManager(x509TrustManager);
        }
        httpRequest.setRequestProperty("Accept", "application/jason");
        httpRequest.setRequestProperty("Accept-Encoding", "gzip");
        httpRequest.setRequestProperty("X-App-Key", cn.jiguang.d.a.e(context));
        if (i4 == 2 || i4 == 3) {
            httpRequest.setHaveRspData(true);
            httpRequest.setRspDatazip(true);
            httpRequest.setNeedErrorInput(true);
            httpRequest.setRequestProperty("FillType", "1");
            if (i4 == 3) {
                httpRequest.setRequestProperty("X-Real-IP", "jcore");
                a4 = f.b(a5);
            } else {
                a4 = f.a(a5);
            }
        } else {
            boolean z3 = i4 == 4;
            httpRequest.setHaveRspData(z3);
            httpRequest.setRspDatazip(z3);
            a4 = "Basic " + f.a(context, cn.jiguang.f.g.b(a6), a5, z3);
        }
        httpRequest.setRequestProperty("Authorization", a4);
        httpRequest.setRequestProperty("Charset", "UTF-8");
    }

    private static void a(HttpRequest httpRequest, Context context, byte[] bArr, int i4, int i5) {
        String str;
        httpRequest.setConnectTimeout(30000);
        httpRequest.setReadTimeout(30000);
        httpRequest.setDoOutPut(true);
        httpRequest.setDoInPut(true);
        httpRequest.setUseCaches(false);
        httpRequest.setBody(bArr);
        httpRequest.setRequestProperty("Content-Length", String.valueOf(bArr.length));
        httpRequest.setNeedRetryIfHttpsFailed(true);
        if (f2843a == null) {
            try {
                if (!TextUtils.isEmpty("")) {
                    f2843a = new SSLTrustManager("");
                }
            } catch (Throwable unused) {
            }
        }
        SSLTrustManager sSLTrustManager = f2843a;
        if (sSLTrustManager != null) {
            httpRequest.setSslTrustManager(sSLTrustManager);
        }
        httpRequest.setRequestProperty("Accept", "application/jason");
        httpRequest.setRequestProperty("Accept-Encoding", "gzip");
        httpRequest.setRequestProperty("X-App-Key", cn.jiguang.d.a.e(context));
        httpRequest.setRequestProperty("Charset", "UTF-8");
        String url = httpRequest.getUrl();
        String str2 = url.contains("ipv6") ? f.f2869f : f.f2868e;
        if (JCoreManager.isTestEnv()) {
            str2 = Uri.parse(url).getHost();
        }
        httpRequest.setRequestProperty("Host", str2);
        String a4 = cn.jiguang.cn.g.a(i4);
        if (i5 == 2) {
            httpRequest.setHaveRspData(true);
            httpRequest.setRspDatazip(true);
            httpRequest.setNeedErrorInput(true);
            httpRequest.setRequestProperty("FillType", "1");
            str = f.a(a4);
        } else {
            httpRequest.setHaveRspData(false);
            httpRequest.setRspDatazip(false);
            str = "Basic " + f.a(context, cn.jiguang.f.g.b(bArr), a4);
        }
        httpRequest.setRequestProperty("Authorization", str);
    }
}

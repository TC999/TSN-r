package cn.jiguang.bl;

import android.content.Context;
import android.os.Bundle;
import android.util.Pair;
import cn.jiguang.bq.d;
import cn.jiguang.cd.h;
import cn.jiguang.internal.JConstants;
import cn.jiguang.net.HttpRequest;
import cn.jiguang.net.HttpResponse;
import cn.jiguang.net.HttpUtils;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.repo.AdLogEventRepo;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.X509TrustManager;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class c {
    public static byte a(Context context) {
        return cn.jiguang.bx.b.a().a(context);
    }

    private static <T> cn.jiguang.g.a a(Bundle bundle, Object obj) {
        return new cn.jiguang.g.a(bundle.getString("file"), bundle.getString("name"), obj, bundle.getBoolean("multiProcess"), bundle.getBoolean(AdLogEventRepo.COL_ENCRYPT_TYPE));
    }

    private static HttpRequest a(Bundle bundle, Object... objArr) {
        try {
            String string = bundle.getString("url");
            int i4 = bundle.getInt("connectTimeout");
            int i5 = bundle.getInt("readTimeout");
            boolean z3 = bundle.getBoolean("doOutPut");
            boolean z4 = bundle.getBoolean("doInPut");
            boolean z5 = bundle.getBoolean("UseCaches");
            boolean z6 = bundle.getBoolean("haveRspData");
            boolean z7 = bundle.getBoolean("rspDatazip");
            boolean z8 = bundle.getBoolean("needErrorInput");
            boolean z9 = bundle.getBoolean("needRetryIfHttpsFailed");
            Object obj = objArr[0];
            Map<String, String> map = (Map) objArr[1];
            Map<String, String> map2 = (Map) objArr[2];
            X509TrustManager x509TrustManager = (X509TrustManager) objArr[3];
            HostnameVerifier hostnameVerifier = (HostnameVerifier) objArr[4];
            HttpRequest httpRequest = new HttpRequest(string);
            if (i4 >= 0) {
                httpRequest.setConnectTimeout(i4);
            }
            if (i5 >= 0) {
                httpRequest.setReadTimeout(i5);
            }
            httpRequest.setDoOutPut(z3);
            httpRequest.setDoInPut(z4);
            httpRequest.setUseCaches(z5);
            httpRequest.setHaveRspData(z6);
            httpRequest.setRspDatazip(z7);
            httpRequest.setNeedErrorInput(z8);
            httpRequest.setNeedRetryIfHttpsFailed(z9);
            httpRequest.setBody(obj);
            httpRequest.setParasMap(map);
            httpRequest.setRequestProperties(map2);
            httpRequest.setSslTrustManager(x509TrustManager);
            httpRequest.setHostnameVerifier(hostnameVerifier);
            return httpRequest;
        } catch (Throwable th) {
            d.m("JCommonToJCoreImp", "getHttpRequest:" + th);
            return null;
        }
    }

    public static <T> T a(Context context, Bundle bundle, Object... objArr) {
        return (T) cn.jiguang.g.b.a(context, a(bundle, objArr[0]));
    }

    public static Object a(Context context, String str, int i4) {
        return cn.jiguang.bx.b.a().a(context, str, i4);
    }

    public static String a(int i4) {
        return cn.jiguang.bx.b.a().b(i4);
    }

    public static void a(Context context, Bundle bundle) {
        cn.jiguang.g.b.a(context, bundle.getString("file"));
    }

    public static void a(Context context, JSONObject jSONObject) {
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("content");
            if (optJSONObject != null) {
                int optInt = optJSONObject.optInt("log_enable");
                int optInt2 = optJSONObject.optInt("log_print");
                if (optJSONObject.optInt("upload_enable") == 1) {
                    cn.jiguang.bq.a.a(context);
                }
                cn.jiguang.g.b.a(context, cn.jiguang.g.a.au().a((cn.jiguang.g.a<Integer>) Integer.valueOf(optInt)));
                JConstants.CMD_TO_PRINT_ALL_LOG = optInt2 == 1;
                cn.jiguang.g.b.a(context, cn.jiguang.g.a.av().a((cn.jiguang.g.a<Integer>) Integer.valueOf(optInt2)));
                int optInt3 = optJSONObject.optInt("expire");
                if (optInt3 <= 0) {
                    optInt3 = 7;
                }
                cn.jiguang.g.b.a(context, cn.jiguang.g.a.aw().a((cn.jiguang.g.a<Long>) Long.valueOf(cn.jiguang.f.b.a(optInt3))));
                if (optInt != 1) {
                    cn.jiguang.a.a.f2015g = false;
                    cn.jiguang.cm.d.a("FUTURE_TASK", new cn.jiguang.cm.b() { // from class: cn.jiguang.bl.c.1
                        @Override // cn.jiguang.cm.b
                        public void a() {
                            cn.jiguang.bq.c.a();
                        }
                    });
                    return;
                }
                cn.jiguang.a.a.f2015g = true;
                int optInt4 = optJSONObject.optInt("delay_upload");
                if (optInt4 <= 10) {
                    optInt4 = 10;
                }
                cn.jiguang.g.b.a(context, cn.jiguang.g.a.ax().a((cn.jiguang.g.a<Integer>) Integer.valueOf(optInt4)));
            }
        } catch (Throwable unused) {
        }
    }

    public static void a(Context context, Object... objArr) {
        if (objArr == null || objArr.length <= 1) {
            d.m("JCommonToJCoreImp", "sp_set null");
            return;
        }
        Bundle[] bundleArr = (Bundle[]) objArr[0];
        Object[] objArr2 = (Object[]) objArr[1];
        cn.jiguang.g.a[] aVarArr = new cn.jiguang.g.a[bundleArr.length];
        for (int i4 = 0; i4 < bundleArr.length; i4++) {
            aVarArr[i4] = a(bundleArr[i4], objArr2[i4]);
        }
        cn.jiguang.g.b.a(context, aVarArr);
    }

    public static void a(Thread thread, Throwable th) {
        h.a().a(thread, th);
    }

    public static boolean a() {
        return cn.jiguang.bt.b.f2891a;
    }

    private static Object[] a(HttpResponse httpResponse) {
        if (httpResponse == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        Object[] objArr = {bundle, httpResponse.getResponseHeaders()};
        bundle.putString("url", httpResponse.getUrl());
        bundle.putString("responseBody", httpResponse.getResponseBody());
        bundle.putInt("type", httpResponse.getType());
        bundle.putLong("expiredTime", httpResponse.getExpiredTime());
        bundle.putBoolean("isInCache", httpResponse.isInCache());
        bundle.putInt("responseCode", httpResponse.getResponseCode());
        bundle.putInt("statusCode", httpResponse.getStatusCode());
        return objArr;
    }

    public static <T> T b(Context context, Bundle bundle, Object... objArr) {
        return (T) cn.jiguang.g.b.b(context, a(bundle, objArr[0]));
    }

    public static String b(Context context) {
        return cn.jiguang.bx.b.a().b(context);
    }

    public static void b(Context context, JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject("content");
            d.c("JCommonToJCoreImp", "jsonContent:" + jSONObject2);
            int optInt = jSONObject2.optInt("state", -1);
            if (optInt == -1) {
                d.i("JCommonToJCoreImp", "unknow state");
            } else if (optInt == 0) {
                d.c("JCommonToJCoreImp", "turn on share process");
                cn.jiguang.bt.b.a(context, optInt);
            } else if (optInt == 1) {
                d.c("JCommonToJCoreImp", "turn off share process");
                cn.jiguang.bt.b.a(context, optInt);
                cn.jiguang.e.a.b().a(context, cn.jiguang.d.a.f(context));
                cn.jiguang.e.a.a(context, context.getPackageName());
            } else {
                d.i("JCommonToJCoreImp", "#exception - unsupport state:" + optInt);
            }
        } catch (Exception e4) {
            d.i("JCommonToJCoreImp", "configReportRunningApp exception:" + e4.getMessage());
        }
    }

    public static void b(Context context, Object... objArr) {
        if (objArr == null || objArr.length <= 1) {
            d.m("JCommonToJCoreImp", "sp_sync_set null");
            return;
        }
        Bundle[] bundleArr = (Bundle[]) objArr[0];
        Object[] objArr2 = (Object[]) objArr[1];
        cn.jiguang.g.a[] aVarArr = new cn.jiguang.g.a[bundleArr.length];
        for (int i4 = 0; i4 < bundleArr.length; i4++) {
            aVarArr[i4] = a(bundleArr[i4], objArr2[i4]);
        }
        cn.jiguang.g.b.b(context, aVarArr);
    }

    public static boolean b() {
        Integer num;
        Boolean bool = cn.jiguang.a.a.f2013e;
        return (bool != null && bool.booleanValue()) || ((num = cn.jiguang.a.a.f2014f) != null && num.intValue() == 0);
    }

    public static long c() {
        return cn.jiguang.bx.b.a().b();
    }

    public static Pair<String, Long> c(Context context) {
        return cn.jiguang.c.b.c(context);
    }

    public static void c(Context context, Object... objArr) {
        if (objArr == null || objArr.length <= 1) {
            d.m("JCommonToJCoreImp", "sp_sync_set null");
            return;
        }
        Bundle[] bundleArr = (Bundle[]) objArr[0];
        Object[] objArr2 = (Object[]) objArr[1];
        cn.jiguang.g.a[] aVarArr = new cn.jiguang.g.a[bundleArr.length];
        for (int i4 = 0; i4 < bundleArr.length; i4++) {
            aVarArr[i4] = a(bundleArr[i4], objArr2[i4]);
        }
        cn.jiguang.g.b.c(context, aVarArr);
    }

    public static Object[] c(Context context, Bundle bundle, Object... objArr) {
        try {
            return a(HttpUtils.httpResponse(context, a(bundle, objArr), bundle.getBoolean("isHttpPost")));
        } catch (Throwable th) {
            d.m("JCommonToJCoreImp", "httpResponse:" + th);
            return null;
        }
    }

    public static Map<Integer, Bundle> d() {
        return cn.jiguang.bx.b.a().d();
    }
}

package com.kwad.sdk.core.webview.p418b;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebResourceResponse;
import androidx.annotation.Nullable;
import com.baidu.mobads.sdk.internal.C2640by;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.webview.p418b.p419a.C10614b;
import com.kwad.sdk.core.webview.p418b.p421c.C10620a;
import com.kwad.sdk.core.webview.p418b.p421c.C10621b;
import com.kwad.sdk.core.webview.p418b.p421c.C10623c;
import com.kwad.sdk.crash.utils.C10738b;
import com.kwad.sdk.crash.utils.C10747h;
import com.kwad.sdk.p435h.p436a.C10772b;
import com.kwad.sdk.utils.C11122q;
import io.netty.handler.codec.http.HttpHeaders;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.webview.b.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10615b {
    private static final Map<String, C10614b> aEo = new ConcurrentHashMap();
    private static final Map<String, String> aEp = new ConcurrentHashMap();

    @Nullable
    /* renamed from: a */
    public static WebResourceResponse m25292a(Context context, String str, C10772b c10772b, C10621b.C10622a c10622a, boolean z) {
        C10614b c10614b;
        try {
            c10614b = m25293a(context, c10772b, str, c10622a);
        } catch (Exception e) {
            C10331c.printStackTraceOnly(e);
            c10622a.msg = "获取配置文件失败 崩溃" + Log.getStackTraceString(e);
            c10614b = null;
        }
        if (c10614b == null) {
            m25287b(z, c10622a.msg);
            if (TextUtils.isEmpty(c10622a.msg)) {
                c10622a.msg = "获取配置文件失败";
            }
            return null;
        } else if (TextUtils.isEmpty(c10614b.aEw)) {
            m25287b(z, "getResource [" + str + "] getFilePath from url fail");
            c10622a.msg = "getFilePath from url fail";
            return null;
        } else if (!C10623c.m25253eX(c10614b.aEs)) {
            m25287b(z, "mimetype为: " + c10614b.aEs + "不在拦截范围的文件");
            c10622a.msg = "mimetype为: " + c10614b.aEs + "不在拦截范围的文件";
            return null;
        } else {
            BufferedInputStream m23719gr = C11122q.m23719gr(c10614b.aEw);
            if (m23719gr == null) {
                m25287b(z, "getResource [" + str + "] inputStream is null");
                StringBuilder sb = new StringBuilder("inputStream is null,本地加载路径：");
                sb.append(c10614b.aEw);
                c10622a.msg = sb.toString();
                return null;
            }
            return m25291a(m23719gr, c10614b);
        }
    }

    /* renamed from: ac */
    private static String m25289ac(String str, String str2) {
        return str + Uri.parse(str2).getPath();
    }

    /* renamed from: ad */
    private static void m25288ad(String str, String str2) {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            return;
        }
        aEp.put(str, str2);
    }

    /* renamed from: b */
    private static void m25287b(boolean z, String str) {
        if (z) {
            return;
        }
        C10331c.m26254d("HybridResourceManager", str);
    }

    /* renamed from: eP */
    private static C10614b m25286eP(String str) {
        return aEo.get(String.valueOf(str.hashCode()));
    }

    /* renamed from: eQ */
    private static String m25285eQ(String str) {
        return aEp.get(str);
    }

    /* renamed from: a */
    private static WebResourceResponse m25291a(InputStream inputStream, C10614b c10614b) {
        String str = c10614b.aEs;
        if (Build.VERSION.SDK_INT >= 21) {
            HashMap hashMap = new HashMap();
            hashMap.put(HttpHeaders.Names.ACCESS_CONTROL_ALLOW_ORIGIN, c10614b.aEv.aEq);
            hashMap.put(HttpHeaders.Names.ACCESS_CONTROL_ALLOW_CREDENTIALS, "true");
            hashMap.put("Timing-Allow-Origin", c10614b.aEv.aEr);
            hashMap.put("content-type", str);
            hashMap.put("Date", c10614b.aEv.aEt);
            hashMap.put("union-cache ", "1");
            return new WebResourceResponse(c10614b.aEs, "", c10614b.status, C2640by.f8773k, hashMap, inputStream);
        }
        return new WebResourceResponse(str, "UTF-8", inputStream);
    }

    /* renamed from: a */
    private static C10614b m25293a(Context context, C10772b c10772b, String str, C10621b.C10622a c10622a) {
        InputStreamReader inputStreamReader;
        FileInputStream fileInputStream = null;
        try {
            String m25285eQ = m25285eQ(c10772b.aHX);
            C10614b m25286eP = !TextUtils.isEmpty(m25285eQ) ? m25286eP(m25289ac(m25285eQ, str)) : null;
            if (m25286eP != null) {
                C10738b.closeQuietly((Closeable) null);
                C10738b.closeQuietly((Closeable) null);
                return m25286eP;
            }
            String m25274I = C10620a.m25274I(context, c10772b.aHY);
            if (m25274I == null) {
                c10622a.msg = "获取配置文件失败 offlinepackage 为空";
                C10738b.closeQuietly((Closeable) null);
                C10738b.closeQuietly((Closeable) null);
                return null;
            }
            File file = new File(m25274I);
            if (!file.exists()) {
                c10622a.msg = "获取配置文件失败 下载文件路径不存在 " + m25274I;
                C10738b.closeQuietly((Closeable) null);
                C10738b.closeQuietly((Closeable) null);
                return null;
            }
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                inputStreamReader = new InputStreamReader(fileInputStream2);
            } catch (Throwable th) {
                th = th;
                inputStreamReader = null;
            }
            try {
                String m24945b = C10747h.m24945b(inputStreamReader);
                if (TextUtils.isEmpty(m24945b)) {
                    c10622a.msg = "获取配置文件失败 mainfest文件不存在";
                    C10738b.closeQuietly(fileInputStream2);
                    C10738b.closeQuietly(inputStreamReader);
                    return null;
                }
                JSONObject jSONObject = new JSONObject(m24945b);
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    JSONObject jSONObject2 = jSONObject.getJSONObject(next);
                    C10614b c10614b = new C10614b();
                    c10614b.parseJson(jSONObject2);
                    String host = Uri.parse("https://" + next).getHost();
                    c10614b.aEx = host;
                    c10614b.aEw = C10620a.m25275H(context, c10772b.aHY) + "/" + next;
                    if (TextUtils.isEmpty(c10614b.aEs)) {
                        c10614b.aEs = URLConnection.getFileNameMap().getContentTypeFor(c10614b.aEw);
                    }
                    m25290a(next, c10614b);
                    m25285eQ = host;
                }
                m25288ad(c10772b.aHX, m25285eQ);
                C10614b m25286eP2 = m25286eP(m25289ac(m25285eQ, str));
                C10738b.closeQuietly(fileInputStream2);
                C10738b.closeQuietly(inputStreamReader);
                return m25286eP2;
            } catch (Throwable th2) {
                th = th2;
                fileInputStream = fileInputStream2;
                C10738b.closeQuietly(fileInputStream);
                C10738b.closeQuietly(inputStreamReader);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            inputStreamReader = null;
        }
    }

    /* renamed from: a */
    private static void m25290a(String str, C10614b c10614b) {
        aEo.put(String.valueOf(str.hashCode()), c10614b);
    }
}

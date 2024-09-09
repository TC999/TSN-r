package com.kwad.sdk.core.webview.b;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebResourceResponse;
import androidx.annotation.Nullable;
import cn.jpush.android.local.JPushConstants;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
import com.kwad.sdk.core.e.c;
import com.kwad.sdk.core.webview.b.c.b;
import com.kwad.sdk.crash.utils.h;
import com.kwad.sdk.utils.q;
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

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class b {
    private static final Map<String, com.kwad.sdk.core.webview.b.a.b> aEo = new ConcurrentHashMap();
    private static final Map<String, String> aEp = new ConcurrentHashMap();

    @Nullable
    public static WebResourceResponse a(Context context, String str, com.kwad.sdk.h.a.b bVar, b.a aVar, boolean z3) {
        com.kwad.sdk.core.webview.b.a.b bVar2;
        try {
            bVar2 = a(context, bVar, str, aVar);
        } catch (Exception e4) {
            c.printStackTraceOnly(e4);
            aVar.msg = "\u83b7\u53d6\u914d\u7f6e\u6587\u4ef6\u5931\u8d25 \u5d29\u6e83" + Log.getStackTraceString(e4);
            bVar2 = null;
        }
        if (bVar2 == null) {
            b(z3, aVar.msg);
            if (TextUtils.isEmpty(aVar.msg)) {
                aVar.msg = "\u83b7\u53d6\u914d\u7f6e\u6587\u4ef6\u5931\u8d25";
            }
            return null;
        } else if (TextUtils.isEmpty(bVar2.aEw)) {
            b(z3, "getResource [" + str + "] getFilePath from url fail");
            aVar.msg = "getFilePath from url fail";
            return null;
        } else if (!com.kwad.sdk.core.webview.b.c.c.eX(bVar2.aEs)) {
            b(z3, "mimetype\u4e3a: " + bVar2.aEs + "\u4e0d\u5728\u62e6\u622a\u8303\u56f4\u7684\u6587\u4ef6");
            aVar.msg = "mimetype\u4e3a: " + bVar2.aEs + "\u4e0d\u5728\u62e6\u622a\u8303\u56f4\u7684\u6587\u4ef6";
            return null;
        } else {
            BufferedInputStream gr = q.gr(bVar2.aEw);
            if (gr == null) {
                b(z3, "getResource [" + str + "] inputStream is null");
                StringBuilder sb = new StringBuilder("inputStream is null,\u672c\u5730\u52a0\u8f7d\u8def\u5f84\uff1a");
                sb.append(bVar2.aEw);
                aVar.msg = sb.toString();
                return null;
            }
            return a(gr, bVar2);
        }
    }

    private static String ac(String str, String str2) {
        return str + Uri.parse(str2).getPath();
    }

    private static void ad(String str, String str2) {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            return;
        }
        aEp.put(str, str2);
    }

    private static void b(boolean z3, String str) {
        if (z3) {
            return;
        }
        c.d("HybridResourceManager", str);
    }

    private static com.kwad.sdk.core.webview.b.a.b eP(String str) {
        return aEo.get(String.valueOf(str.hashCode()));
    }

    private static String eQ(String str) {
        return aEp.get(str);
    }

    private static WebResourceResponse a(InputStream inputStream, com.kwad.sdk.core.webview.b.a.b bVar) {
        String str = bVar.aEs;
        if (Build.VERSION.SDK_INT >= 21) {
            HashMap hashMap = new HashMap();
            hashMap.put("Access-Control-Allow-Origin", bVar.aEv.aEq);
            hashMap.put("Access-Control-Allow-Credentials", "true");
            hashMap.put("Timing-Allow-Origin", bVar.aEv.aEr);
            hashMap.put("content-type", str);
            hashMap.put("Date", bVar.aEv.aEt);
            hashMap.put("union-cache ", "1");
            return new WebResourceResponse(bVar.aEs, "", bVar.status, "OK", hashMap, inputStream);
        }
        return new WebResourceResponse(str, "UTF-8", inputStream);
    }

    private static com.kwad.sdk.core.webview.b.a.b a(Context context, com.kwad.sdk.h.a.b bVar, String str, b.a aVar) {
        InputStreamReader inputStreamReader;
        FileInputStream fileInputStream = null;
        try {
            String eQ = eQ(bVar.aHX);
            com.kwad.sdk.core.webview.b.a.b eP = !TextUtils.isEmpty(eQ) ? eP(ac(eQ, str)) : null;
            if (eP != null) {
                com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) null);
                com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) null);
                return eP;
            }
            String I = com.kwad.sdk.core.webview.b.c.a.I(context, bVar.aHY);
            if (I == null) {
                aVar.msg = "\u83b7\u53d6\u914d\u7f6e\u6587\u4ef6\u5931\u8d25 offlinepackage \u4e3a\u7a7a";
                com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) null);
                com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) null);
                return null;
            }
            File file = new File(I);
            if (!file.exists()) {
                aVar.msg = "\u83b7\u53d6\u914d\u7f6e\u6587\u4ef6\u5931\u8d25 \u4e0b\u8f7d\u6587\u4ef6\u8def\u5f84\u4e0d\u5b58\u5728 " + I;
                com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) null);
                com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) null);
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
                String b4 = h.b(inputStreamReader);
                if (TextUtils.isEmpty(b4)) {
                    aVar.msg = "\u83b7\u53d6\u914d\u7f6e\u6587\u4ef6\u5931\u8d25 mainfest\u6587\u4ef6\u4e0d\u5b58\u5728";
                    com.kwad.sdk.crash.utils.b.closeQuietly(fileInputStream2);
                    com.kwad.sdk.crash.utils.b.closeQuietly(inputStreamReader);
                    return null;
                }
                JSONObject jSONObject = new JSONObject(b4);
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    JSONObject jSONObject2 = jSONObject.getJSONObject(next);
                    com.kwad.sdk.core.webview.b.a.b bVar2 = new com.kwad.sdk.core.webview.b.a.b();
                    bVar2.parseJson(jSONObject2);
                    String host = Uri.parse(JPushConstants.HTTPS_PRE + next).getHost();
                    bVar2.aEx = host;
                    bVar2.aEw = com.kwad.sdk.core.webview.b.c.a.H(context, bVar.aHY) + TTPathConst.sSeparator + next;
                    if (TextUtils.isEmpty(bVar2.aEs)) {
                        bVar2.aEs = URLConnection.getFileNameMap().getContentTypeFor(bVar2.aEw);
                    }
                    a(next, bVar2);
                    eQ = host;
                }
                ad(bVar.aHX, eQ);
                com.kwad.sdk.core.webview.b.a.b eP2 = eP(ac(eQ, str));
                com.kwad.sdk.crash.utils.b.closeQuietly(fileInputStream2);
                com.kwad.sdk.crash.utils.b.closeQuietly(inputStreamReader);
                return eP2;
            } catch (Throwable th2) {
                th = th2;
                fileInputStream = fileInputStream2;
                com.kwad.sdk.crash.utils.b.closeQuietly(fileInputStream);
                com.kwad.sdk.crash.utils.b.closeQuietly(inputStreamReader);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            inputStreamReader = null;
        }
    }

    private static void a(String str, com.kwad.sdk.core.webview.b.a.b bVar) {
        aEo.put(String.valueOf(str.hashCode()), bVar);
    }
}

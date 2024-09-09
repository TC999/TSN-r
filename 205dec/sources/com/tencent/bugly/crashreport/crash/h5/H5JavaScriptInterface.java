package com.tencent.bugly.crashreport.crash.h5;

import android.webkit.JavascriptInterface;
import com.tencent.bugly.crashreport.CrashReport;
import com.tencent.bugly.crashreport.inner.InnerApi;
import com.tencent.bugly.proguard.al;
import com.tencent.bugly.proguard.ap;
import com.tencent.bugly.proguard.bb;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: BUGLY */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class H5JavaScriptInterface {

    /* renamed from: a  reason: collision with root package name */
    private static HashSet<Integer> f50800a = new HashSet<>();

    /* renamed from: b  reason: collision with root package name */
    private String f50801b = null;

    /* renamed from: c  reason: collision with root package name */
    private Thread f50802c = null;

    /* renamed from: d  reason: collision with root package name */
    private String f50803d = null;

    /* renamed from: e  reason: collision with root package name */
    private Map<String, String> f50804e = null;

    private H5JavaScriptInterface() {
    }

    private static bb a(String str) {
        String string;
        if (str != null && str.length() > 0) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                bb bbVar = new bb();
                String string2 = jSONObject.getString("projectRoot");
                bbVar.f51076a = string2;
                if (string2 == null) {
                    return null;
                }
                String string3 = jSONObject.getString("context");
                bbVar.f51077b = string3;
                if (string3 == null) {
                    return null;
                }
                String string4 = jSONObject.getString("url");
                bbVar.f51078c = string4;
                if (string4 == null) {
                    return null;
                }
                String string5 = jSONObject.getString("userAgent");
                bbVar.f51079d = string5;
                if (string5 == null) {
                    return null;
                }
                String string6 = jSONObject.getString("language");
                bbVar.f51080e = string6;
                if (string6 == null) {
                    return null;
                }
                String string7 = jSONObject.getString("name");
                bbVar.f51081f = string7;
                if (string7 == null || string7.equals("null") || (string = jSONObject.getString("stacktrace")) == null) {
                    return null;
                }
                int indexOf = string.indexOf("\n");
                if (indexOf < 0) {
                    al.d("H5 crash stack's format is wrong!", new Object[0]);
                    return null;
                }
                bbVar.f51083h = string.substring(indexOf + 1);
                String substring = string.substring(0, indexOf);
                bbVar.f51082g = substring;
                int indexOf2 = substring.indexOf(":");
                if (indexOf2 > 0) {
                    bbVar.f51082g = bbVar.f51082g.substring(indexOf2 + 1);
                }
                bbVar.f51084i = jSONObject.getString("file");
                if (bbVar.f51081f == null) {
                    return null;
                }
                long j4 = jSONObject.getLong("lineNumber");
                bbVar.f51085j = j4;
                if (j4 < 0) {
                    return null;
                }
                long j5 = jSONObject.getLong("columnNumber");
                bbVar.f51086k = j5;
                if (j5 < 0) {
                    return null;
                }
                al.a("H5 crash information is following: ", new Object[0]);
                al.a("[projectRoot]: " + bbVar.f51076a, new Object[0]);
                al.a("[context]: " + bbVar.f51077b, new Object[0]);
                al.a("[url]: " + bbVar.f51078c, new Object[0]);
                al.a("[userAgent]: " + bbVar.f51079d, new Object[0]);
                al.a("[language]: " + bbVar.f51080e, new Object[0]);
                al.a("[name]: " + bbVar.f51081f, new Object[0]);
                al.a("[message]: " + bbVar.f51082g, new Object[0]);
                al.a("[stacktrace]: \n" + bbVar.f51083h, new Object[0]);
                al.a("[file]: " + bbVar.f51084i, new Object[0]);
                al.a("[lineNumber]: " + bbVar.f51085j, new Object[0]);
                al.a("[columnNumber]: " + bbVar.f51086k, new Object[0]);
                return bbVar;
            } catch (Throwable th) {
                if (!al.a(th)) {
                    th.printStackTrace();
                }
            }
        }
        return null;
    }

    public static H5JavaScriptInterface getInstance(CrashReport.a aVar) {
        String str = null;
        if (aVar == null || f50800a.contains(Integer.valueOf(aVar.hashCode()))) {
            return null;
        }
        H5JavaScriptInterface h5JavaScriptInterface = new H5JavaScriptInterface();
        f50800a.add(Integer.valueOf(aVar.hashCode()));
        Thread currentThread = Thread.currentThread();
        h5JavaScriptInterface.f50802c = currentThread;
        if (currentThread != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("\n");
            for (int i4 = 2; i4 < currentThread.getStackTrace().length; i4++) {
                StackTraceElement stackTraceElement = currentThread.getStackTrace()[i4];
                if (!stackTraceElement.toString().contains("crashreport")) {
                    sb.append(stackTraceElement.toString());
                    sb.append("\n");
                }
            }
            str = sb.toString();
        }
        h5JavaScriptInterface.f50803d = str;
        HashMap hashMap = new HashMap();
        StringBuilder sb2 = new StringBuilder();
        sb2.append((Object) aVar.c());
        hashMap.put("[WebView] ContentDescription", sb2.toString());
        h5JavaScriptInterface.f50804e = hashMap;
        return h5JavaScriptInterface;
    }

    @JavascriptInterface
    public void printLog(String str) {
        al.d("Log from js: %s", str);
    }

    @JavascriptInterface
    public void reportJSException(String str) {
        if (str == null) {
            al.d("Payload from JS is null.", new Object[0]);
            return;
        }
        String c4 = ap.c(str.getBytes());
        String str2 = this.f50801b;
        if (str2 != null && str2.equals(c4)) {
            al.d("Same payload from js. Please check whether you've injected bugly.js more than one times.", new Object[0]);
            return;
        }
        this.f50801b = c4;
        al.d("Handling JS exception ...", new Object[0]);
        bb a4 = a(str);
        if (a4 == null) {
            al.d("Failed to parse payload.", new Object[0]);
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        String str3 = a4.f51076a;
        if (str3 != null) {
            linkedHashMap2.put("[JS] projectRoot", str3);
        }
        String str4 = a4.f51077b;
        if (str4 != null) {
            linkedHashMap2.put("[JS] context", str4);
        }
        String str5 = a4.f51078c;
        if (str5 != null) {
            linkedHashMap2.put("[JS] url", str5);
        }
        String str6 = a4.f51079d;
        if (str6 != null) {
            linkedHashMap2.put("[JS] userAgent", str6);
        }
        String str7 = a4.f51084i;
        if (str7 != null) {
            linkedHashMap2.put("[JS] file", str7);
        }
        long j4 = a4.f51085j;
        if (j4 != 0) {
            linkedHashMap2.put("[JS] lineNumber", Long.toString(j4));
        }
        linkedHashMap.putAll(linkedHashMap2);
        linkedHashMap.putAll(this.f50804e);
        linkedHashMap.put("Java Stack", this.f50803d);
        InnerApi.postH5CrashAsync(this.f50802c, a4.f51081f, a4.f51082g, a4.f51083h, linkedHashMap);
    }
}

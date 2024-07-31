package com.tencent.bugly.crashreport.crash.p560h5;

import android.webkit.JavascriptInterface;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.snail.antifake.deviceid.ShellAdbUtils;
import com.tencent.bugly.crashreport.CrashReport;
import com.tencent.bugly.crashreport.inner.InnerApi;
import com.tencent.bugly.proguard.C12820al;
import com.tencent.bugly.proguard.C12828ap;
import com.tencent.bugly.proguard.C12868bb;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import master.flame.danmaku.danmaku.parser.IDataSource;
import org.json.JSONObject;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.crashreport.crash.h5.H5JavaScriptInterface */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class H5JavaScriptInterface {

    /* renamed from: a */
    private static HashSet<Integer> f36376a = new HashSet<>();

    /* renamed from: b */
    private String f36377b = null;

    /* renamed from: c */
    private Thread f36378c = null;

    /* renamed from: d */
    private String f36379d = null;

    /* renamed from: e */
    private Map<String, String> f36380e = null;

    private H5JavaScriptInterface() {
    }

    /* renamed from: a */
    private static C12868bb m16032a(String str) {
        String string;
        if (str != null && str.length() > 0) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                C12868bb c12868bb = new C12868bb();
                String string2 = jSONObject.getString("projectRoot");
                c12868bb.f36706a = string2;
                if (string2 == null) {
                    return null;
                }
                String string3 = jSONObject.getString("context");
                c12868bb.f36707b = string3;
                if (string3 == null) {
                    return null;
                }
                String string4 = jSONObject.getString("url");
                c12868bb.f36708c = string4;
                if (string4 == null) {
                    return null;
                }
                String string5 = jSONObject.getString(TTDownloadField.TT_USERAGENT);
                c12868bb.f36709d = string5;
                if (string5 == null) {
                    return null;
                }
                String string6 = jSONObject.getString("language");
                c12868bb.f36710e = string6;
                if (string6 == null) {
                    return null;
                }
                String string7 = jSONObject.getString("name");
                c12868bb.f36711f = string7;
                if (string7 == null || string7.equals("null") || (string = jSONObject.getString("stacktrace")) == null) {
                    return null;
                }
                int indexOf = string.indexOf(ShellAdbUtils.f33810d);
                if (indexOf < 0) {
                    C12820al.m15873d("H5 crash stack's format is wrong!", new Object[0]);
                    return null;
                }
                c12868bb.f36713h = string.substring(indexOf + 1);
                String substring = string.substring(0, indexOf);
                c12868bb.f36712g = substring;
                int indexOf2 = substring.indexOf(":");
                if (indexOf2 > 0) {
                    c12868bb.f36712g = c12868bb.f36712g.substring(indexOf2 + 1);
                }
                c12868bb.f36714i = jSONObject.getString(IDataSource.f43973c);
                if (c12868bb.f36711f == null) {
                    return null;
                }
                long j = jSONObject.getLong("lineNumber");
                c12868bb.f36715j = j;
                if (j < 0) {
                    return null;
                }
                long j2 = jSONObject.getLong("columnNumber");
                c12868bb.f36716k = j2;
                if (j2 < 0) {
                    return null;
                }
                C12820al.m15878a("H5 crash information is following: ", new Object[0]);
                C12820al.m15878a("[projectRoot]: " + c12868bb.f36706a, new Object[0]);
                C12820al.m15878a("[context]: " + c12868bb.f36707b, new Object[0]);
                C12820al.m15878a("[url]: " + c12868bb.f36708c, new Object[0]);
                C12820al.m15878a("[userAgent]: " + c12868bb.f36709d, new Object[0]);
                C12820al.m15878a("[language]: " + c12868bb.f36710e, new Object[0]);
                C12820al.m15878a("[name]: " + c12868bb.f36711f, new Object[0]);
                C12820al.m15878a("[message]: " + c12868bb.f36712g, new Object[0]);
                C12820al.m15878a("[stacktrace]: \n" + c12868bb.f36713h, new Object[0]);
                C12820al.m15878a("[file]: " + c12868bb.f36714i, new Object[0]);
                C12820al.m15878a("[lineNumber]: " + c12868bb.f36715j, new Object[0]);
                C12820al.m15878a("[columnNumber]: " + c12868bb.f36716k, new Object[0]);
                return c12868bb;
            } catch (Throwable th) {
                if (!C12820al.m15877a(th)) {
                    th.printStackTrace();
                }
            }
        }
        return null;
    }

    public static H5JavaScriptInterface getInstance(CrashReport.InterfaceC12772a interfaceC12772a) {
        String str = null;
        if (interfaceC12772a == null || f36376a.contains(Integer.valueOf(interfaceC12772a.hashCode()))) {
            return null;
        }
        H5JavaScriptInterface h5JavaScriptInterface = new H5JavaScriptInterface();
        f36376a.add(Integer.valueOf(interfaceC12772a.hashCode()));
        Thread currentThread = Thread.currentThread();
        h5JavaScriptInterface.f36378c = currentThread;
        if (currentThread != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(ShellAdbUtils.f33810d);
            for (int i = 2; i < currentThread.getStackTrace().length; i++) {
                StackTraceElement stackTraceElement = currentThread.getStackTrace()[i];
                if (!stackTraceElement.toString().contains("crashreport")) {
                    sb.append(stackTraceElement.toString());
                    sb.append(ShellAdbUtils.f33810d);
                }
            }
            str = sb.toString();
        }
        h5JavaScriptInterface.f36379d = str;
        HashMap hashMap = new HashMap();
        StringBuilder sb2 = new StringBuilder();
        sb2.append((Object) interfaceC12772a.mo16039c());
        hashMap.put("[WebView] ContentDescription", sb2.toString());
        h5JavaScriptInterface.f36380e = hashMap;
        return h5JavaScriptInterface;
    }

    @JavascriptInterface
    public void printLog(String str) {
        C12820al.m15873d("Log from js: %s", str);
    }

    @JavascriptInterface
    public void reportJSException(String str) {
        if (str == null) {
            C12820al.m15873d("Payload from JS is null.", new Object[0]);
            return;
        }
        String m15810c = C12828ap.m15810c(str.getBytes());
        String str2 = this.f36377b;
        if (str2 != null && str2.equals(m15810c)) {
            C12820al.m15873d("Same payload from js. Please check whether you've injected bugly.js more than one times.", new Object[0]);
            return;
        }
        this.f36377b = m15810c;
        C12820al.m15873d("Handling JS exception ...", new Object[0]);
        C12868bb m16032a = m16032a(str);
        if (m16032a == null) {
            C12820al.m15873d("Failed to parse payload.", new Object[0]);
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        String str3 = m16032a.f36706a;
        if (str3 != null) {
            linkedHashMap2.put("[JS] projectRoot", str3);
        }
        String str4 = m16032a.f36707b;
        if (str4 != null) {
            linkedHashMap2.put("[JS] context", str4);
        }
        String str5 = m16032a.f36708c;
        if (str5 != null) {
            linkedHashMap2.put("[JS] url", str5);
        }
        String str6 = m16032a.f36709d;
        if (str6 != null) {
            linkedHashMap2.put("[JS] userAgent", str6);
        }
        String str7 = m16032a.f36714i;
        if (str7 != null) {
            linkedHashMap2.put("[JS] file", str7);
        }
        long j = m16032a.f36715j;
        if (j != 0) {
            linkedHashMap2.put("[JS] lineNumber", Long.toString(j));
        }
        linkedHashMap.putAll(linkedHashMap2);
        linkedHashMap.putAll(this.f36380e);
        linkedHashMap.put("Java Stack", this.f36379d);
        InnerApi.postH5CrashAsync(this.f36378c, m16032a.f36711f, m16032a.f36712g, m16032a.f36713h, linkedHashMap);
    }
}

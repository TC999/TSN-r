package com.umeng.analytics.pro;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.analytics.CoreProtocol;
import com.umeng.analytics.pro.i;
import com.umeng.analytics.vshelper.PageNameMonitor;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.service.UMGlobalContext;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: ViewPageTracker.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class v {

    /* renamed from: c  reason: collision with root package name */
    private static final int f53138c = 5;

    /* renamed from: d  reason: collision with root package name */
    private static JSONArray f53139d = new JSONArray();

    /* renamed from: e  reason: collision with root package name */
    private static Object f53140e = new Object();

    /* renamed from: f  reason: collision with root package name */
    private final Map<String, Long> f53143f = new HashMap();

    /* renamed from: a  reason: collision with root package name */
    Stack<String> f53141a = new Stack<>();

    /* renamed from: b  reason: collision with root package name */
    com.umeng.analytics.vshelper.a f53142b = PageNameMonitor.getInstance();

    public static void a(Context context) {
        String jSONArray;
        if (context != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                synchronized (f53140e) {
                    jSONArray = f53139d.toString();
                    f53139d = new JSONArray();
                }
                if (jSONArray.length() > 0) {
                    jSONObject.put("__a", new JSONArray(jSONArray));
                    if (jSONObject.length() > 0) {
                        i.a(context).a(u.a().c(), jSONObject, i.a.PAGE);
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    protected int a() {
        return 2;
    }

    public void b(String str) {
        Long l4;
        Context appContext;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (this.f53143f.containsKey(str)) {
            synchronized (this.f53143f) {
                l4 = this.f53143f.get(str);
                this.f53143f.remove(str);
            }
            if (l4 == null) {
                return;
            }
            if (UMConfigure.isDebugLog() && this.f53141a.size() > 0 && str.equals(this.f53141a.peek())) {
                this.f53141a.pop();
            }
            long currentTimeMillis = System.currentTimeMillis() - l4.longValue();
            synchronized (f53140e) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("page_name", str);
                    jSONObject.put("duration", currentTimeMillis);
                    jSONObject.put("page_start", l4);
                    jSONObject.put("type", a());
                    f53139d.put(jSONObject);
                    if (f53139d.length() >= 5 && (appContext = UMGlobalContext.getAppContext(null)) != null) {
                        UMWorkDispatch.sendEvent(appContext, 4099, CoreProtocol.getInstance(appContext), null);
                    }
                } catch (Throwable unused) {
                }
            }
            if (!UMConfigure.isDebugLog() || this.f53141a.size() == 0) {
                return;
            }
            UMLog.aq(j.E, 0, "\\|", new String[]{"@"}, new String[]{str}, null, null);
        } else if (UMConfigure.isDebugLog() && this.f53141a.size() == 0) {
            UMLog.aq(j.G, 0, "\\|", new String[]{"@"}, new String[]{str}, null, null);
        }
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (UMConfigure.isDebugLog() && this.f53141a.size() != 0) {
            UMLog.aq(j.F, 0, "\\|", new String[]{"@"}, new String[]{this.f53141a.peek()}, null, null);
        }
        this.f53142b.customPageBegin(str);
        synchronized (this.f53143f) {
            this.f53143f.put(str, Long.valueOf(System.currentTimeMillis()));
            if (UMConfigure.isDebugLog()) {
                this.f53141a.push(str);
            }
        }
    }

    public void b() {
        String str;
        synchronized (this.f53143f) {
            str = null;
            long j4 = 0;
            for (Map.Entry<String, Long> entry : this.f53143f.entrySet()) {
                if (entry.getValue().longValue() > j4) {
                    long longValue = entry.getValue().longValue();
                    str = entry.getKey();
                    j4 = longValue;
                }
            }
        }
        if (str != null) {
            b(str);
        }
    }
}

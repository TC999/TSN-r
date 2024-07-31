package com.umeng.analytics.pro;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.analytics.CoreProtocol;
import com.umeng.analytics.pro.UMStoreManager;
import com.umeng.analytics.vshelper.PageLifeCycle;
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

/* renamed from: com.umeng.analytics.pro.v */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class ViewPageTracker {

    /* renamed from: c */
    private static final int f38467c = 5;

    /* renamed from: d */
    private static JSONArray f38468d = new JSONArray();

    /* renamed from: e */
    private static Object f38469e = new Object();

    /* renamed from: f */
    private final Map<String, Long> f38472f = new HashMap();

    /* renamed from: a */
    Stack<String> f38470a = new Stack<>();

    /* renamed from: b */
    PageLifeCycle f38471b = PageNameMonitor.getInstance();

    /* renamed from: a */
    public static void m14168a(Context context) {
        String jSONArray;
        if (context != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                synchronized (f38469e) {
                    jSONArray = f38468d.toString();
                    f38468d = new JSONArray();
                }
                if (jSONArray.length() > 0) {
                    jSONObject.put("__a", new JSONArray(jSONArray));
                    if (jSONObject.length() > 0) {
                        UMStoreManager.m14345a(context).m14339a(SessionTracker.m14188a().m14176c(), jSONObject, UMStoreManager.EnumC13161a.PAGE);
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: a */
    protected int mo14169a() {
        return 2;
    }

    /* renamed from: b */
    public void m14165b(String str) {
        Long l;
        Context appContext;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (this.f38472f.containsKey(str)) {
            synchronized (this.f38472f) {
                l = this.f38472f.get(str);
                this.f38472f.remove(str);
            }
            if (l == null) {
                return;
            }
            if (UMConfigure.isDebugLog() && this.f38470a.size() > 0 && str.equals(this.f38470a.peek())) {
                this.f38470a.pop();
            }
            long currentTimeMillis = System.currentTimeMillis() - l.longValue();
            synchronized (f38469e) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(UContent.f38157v, str);
                    jSONObject.put("duration", currentTimeMillis);
                    jSONObject.put(UContent.f38159x, l);
                    jSONObject.put("type", mo14169a());
                    f38468d.put(jSONObject);
                    if (f38468d.length() >= 5 && (appContext = UMGlobalContext.getAppContext(null)) != null) {
                        UMWorkDispatch.sendEvent(appContext, 4099, CoreProtocol.getInstance(appContext), null);
                    }
                } catch (Throwable unused) {
                }
            }
            if (!UMConfigure.isDebugLog() || this.f38470a.size() == 0) {
                return;
            }
            UMLog.m14013aq(UMLogAnalytics.f38273E, 0, "\\|", new String[]{"@"}, new String[]{str}, null, null);
        } else if (UMConfigure.isDebugLog() && this.f38470a.size() == 0) {
            UMLog.m14013aq(UMLogAnalytics.f38275G, 0, "\\|", new String[]{"@"}, new String[]{str}, null, null);
        }
    }

    /* renamed from: a */
    public void m14167a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (UMConfigure.isDebugLog() && this.f38470a.size() != 0) {
            UMLog.m14013aq(UMLogAnalytics.f38274F, 0, "\\|", new String[]{"@"}, new String[]{this.f38470a.peek()}, null, null);
        }
        this.f38471b.customPageBegin(str);
        synchronized (this.f38472f) {
            this.f38472f.put(str, Long.valueOf(System.currentTimeMillis()));
            if (UMConfigure.isDebugLog()) {
                this.f38470a.push(str);
            }
        }
    }

    /* renamed from: b */
    public void m14166b() {
        String str;
        synchronized (this.f38472f) {
            str = null;
            long j = 0;
            for (Map.Entry<String, Long> entry : this.f38472f.entrySet()) {
                if (entry.getValue().longValue() > j) {
                    long longValue = entry.getValue().longValue();
                    str = entry.getKey();
                    j = longValue;
                }
            }
        }
        if (str != null) {
            m14165b(str);
        }
    }
}

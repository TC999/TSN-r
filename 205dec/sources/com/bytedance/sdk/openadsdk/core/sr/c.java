package com.bytedance.sdk.openadsdk.core.sr;

import android.text.TextUtils;
import com.bytedance.sdk.component.ev.w.sr;
import com.bytedance.sdk.component.ev.w.xv;
import com.bytedance.sdk.component.gd.ev;
import com.bytedance.sdk.component.gd.p;
import com.bytedance.sdk.component.utils.a;
import com.bytedance.sdk.openadsdk.core.eq;
import com.bytedance.sdk.openadsdk.core.eq.c;
import com.bytedance.sdk.openadsdk.core.eq.wv;
import com.bytedance.sdk.openadsdk.core.k;
import com.bytedance.sdk.openadsdk.core.ls;
import com.bytedance.sdk.openadsdk.core.q.ux;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.IOException;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c implements c.w {

    /* renamed from: c  reason: collision with root package name */
    private static volatile c f34571c = null;

    /* renamed from: f  reason: collision with root package name */
    private static final HashSet f34572f;
    private static final String sr = "com.bytedance.sdk.openadsdk.core.sr.c";
    private static HashMap<String, Long> ux;

    /* renamed from: w  reason: collision with root package name */
    private CopyOnWriteArrayList<JSONObject> f34573w = new CopyOnWriteArrayList<>();
    private com.bytedance.sdk.openadsdk.core.eq.c xv;

    static {
        String name = c.class.getName();
        ux = new HashMap<>();
        f34572f = new HashSet(Arrays.asList("dalvik.system.VMStack.getThreadStackTrace", "java.lang.Thread.getStackTrace", name));
    }

    private c() {
        com.bytedance.sdk.openadsdk.core.eq.c xv = k.sr().xv();
        this.xv = xv;
        if (xv != null) {
            xv.xv(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sr() {
        CopyOnWriteArrayList<JSONObject> copyOnWriteArrayList = this.f34573w;
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.size() <= 0) {
            return;
        }
        JSONArray jSONArray = new JSONArray();
        Iterator<JSONObject> it = this.f34573w.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next());
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("stats_list", jSONArray);
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
        this.f34573w.clear();
        String ev = wv.ev("/api/ad/union/sdk/callstack/batch/");
        a.w("CallChainStatistic", "params:" + jSONObject);
        JSONObject c4 = com.bytedance.sdk.component.utils.c.c(jSONObject);
        sr w3 = ux.c().w().w();
        w3.c(ev);
        w3.xv(c4.toString());
        w3.c(new com.bytedance.sdk.component.ev.c.c() { // from class: com.bytedance.sdk.openadsdk.core.sr.c.2
            @Override // com.bytedance.sdk.component.ev.c.c
            public void c(xv xvVar, com.bytedance.sdk.component.ev.w wVar) {
                if (wVar != null) {
                    a.w("CallChainStatistic", Boolean.valueOf(wVar.ev()), wVar.sr());
                } else {
                    a.xv("CallChainStatistic", "NetResponse is null");
                }
            }

            @Override // com.bytedance.sdk.component.ev.c.c
            public void c(xv xvVar, IOException iOException) {
                a.xv("CallChainStatistic", iOException.getMessage());
            }
        });
    }

    public static c xv() {
        if (f34571c == null) {
            synchronized (c.class) {
                if (f34571c == null) {
                    f34571c = new c();
                }
            }
        }
        return f34571c;
    }

    @Override // com.bytedance.sdk.openadsdk.core.eq.c.w
    public void w() {
    }

    public void c(int i4, com.bytedance.sdk.openadsdk.ys.w.xv.w wVar) {
        if (wVar == null) {
            return;
        }
        c(i4, wVar.f());
    }

    private boolean c(Long l4) {
        return !c(new Date(), new Date(l4.longValue()));
    }

    private boolean c(Date date, Date date2) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(date2);
        return ((calendar.get(1) == calendar2.get(1)) && calendar.get(2) == calendar2.get(2)) && calendar.get(5) == calendar2.get(5);
    }

    private boolean c(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            Long l4 = ux.get(str);
            if (l4 != null && l4.longValue() != 0) {
                if (!c(l4)) {
                    return false;
                }
            } else {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis > 0) {
                    ux.put(str, Long.valueOf(currentTimeMillis));
                }
            }
            return true;
        } catch (Throwable th) {
            a.xv("callstack error:" + th.getMessage());
            return true;
        }
    }

    public void c(final int i4, final String str) {
        if (w.c() && c(str)) {
            final StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            ev.c(new p("callChainStatistic") { // from class: com.bytedance.sdk.openadsdk.core.sr.c.1
                @Override // java.lang.Runnable
                public void run() {
                    c.this.f34573w.add(c.this.c(i4, str, stackTrace));
                    if (c.this.f34573w.size() < 3) {
                        return;
                    }
                    try {
                        c.this.sr();
                    } catch (OutOfMemoryError e4) {
                        e4.printStackTrace();
                    }
                }
            }, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject c(int i4, String str, StackTraceElement[] stackTraceElementArr) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("rit", str);
            jSONObject.put("appid", k.sr().ev());
            jSONObject.put("app_version", wv.p());
            jSONObject.put("ad_sdk_version", eq.xv);
            jSONObject.put("plugin_version", "6.1.0.6");
            jSONObject.put("adtype", i4);
            jSONObject.put(CampaignEx.JSON_KEY_TIMESTAMP, System.currentTimeMillis());
            jSONObject.put("callstack", c(stackTraceElementArr));
            jSONObject.put("type", "callstack");
            jSONObject.put("device_info", com.bytedance.sdk.openadsdk.core.xv.c.c(ls.getContext(), i4));
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
        return jSONObject;
    }

    private JSONArray c(StackTraceElement[] stackTraceElementArr) {
        JSONArray jSONArray = new JSONArray();
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            if (stackTraceElement != null) {
                if (!f34572f.contains(stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName())) {
                    String className = stackTraceElement.getClassName();
                    if (className != null && className.startsWith(MBridgeConstans.APPLICATION_STACK_ANDROID_APP)) {
                        break;
                    }
                    jSONArray.put(stackTraceElement.toString());
                } else {
                    continue;
                }
            }
        }
        return jSONArray;
    }

    @Override // com.bytedance.sdk.openadsdk.core.eq.c.w
    public void c() {
        sr();
    }
}

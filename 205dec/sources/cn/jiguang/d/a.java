package cn.jiguang.d;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import cn.jiguang.analytics.page.ActivityLifecycle;
import cn.jiguang.analytics.page.JOperateActivityLifecycle;
import cn.jiguang.api.JCoreManager;
import cn.jiguang.bq.d;
import cn.jiguang.f.c;
import cn.jiguang.f.g;
import cn.jiguang.internal.ActionManager;
import cn.jiguang.internal.JConstants;
import com.stub.StubApp;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static ActivityLifecycle f3570a = new ActivityLifecycle();

    public static ActivityLifecycle a() {
        return f3570a;
    }

    public static JSONObject a(Context context, String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                d.c("JBridgeHelper", "file_name is null , give up read ");
                return null;
            }
            String d4 = c.d(c.a(context, str));
            if (g.a(d4)) {
                d.c("JBridgeHelper", "read String is empty");
                return null;
            }
            return new JSONObject(d4.trim());
        } catch (Throwable th) {
            d.c("JBridgeHelper", "can't build " + str + " into JsonObject, give up read :" + th);
            return null;
        }
    }

    public static JSONObject a(Context context, JSONObject jSONObject, String str) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        try {
            jSONObject.put("itime", b.b(context));
            jSONObject.put("type", str);
            jSONObject.put("account_id", cn.jiguang.g.b.a(context, cn.jiguang.g.a.K()));
        } catch (JSONException e4) {
            d.i("JBridgeHelper", "fillBase exception:" + e4);
        }
        return jSONObject;
    }

    public static void a(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        f3570a.addActivityLifecycleCallbacks(activityLifecycleCallbacks);
    }

    public static synchronized void a(Context context) {
        String str;
        String str2;
        synchronized (a.class) {
            try {
            } finally {
            }
            if (JConstants.isInstrumentationHookFailed) {
                Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
                String a4 = cn.jiguang.f.a.a(origApplicationContext);
                String packageName = origApplicationContext.getPackageName();
                if (a4 == null || packageName == null || !packageName.equals(a4)) {
                    str = "JBridgeHelper";
                    str2 = "need not registerActivityLifecycleCallbacks in other process :" + a4;
                } else {
                    JConstants.isInstrumentationHookFailed = false;
                    ((Application) origApplicationContext).registerActivityLifecycleCallbacks(f3570a);
                    ((Application) origApplicationContext).registerActivityLifecycleCallbacks(new JOperateActivityLifecycle());
                    d.c("JBridgeHelper", "registerActivityLifecycleCallbacks in main process,packageName:" + packageName + ",currentProcessName:" + a4);
                }
            } else {
                str = "JBridgeHelper";
                str2 = "need not registerActivityLifecycleCallbacks";
            }
            d.c(str, str2);
        }
    }

    public static void a(Context context, Intent intent) {
        if (intent != null) {
            try {
                if ("asm".equals(intent.getAction())) {
                    JCoreManager.onEvent(context, JConstants.SDK_TYPE, 3, "asm", intent.getExtras(), new Object[0]);
                    return;
                }
            } catch (Throwable th) {
                d.i("JBridgeHelper", "shareActionRun error:" + th.getMessage());
                return;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("shareActionRun intent error:");
        sb.append(intent == null ? "null" : intent.getAction());
        d.c("JBridgeHelper", sb.toString());
    }

    public static void a(Context context, Object obj) {
        JCoreManager.onEvent(context, JConstants.SDK_TYPE, 14, null, null, obj);
    }

    public static void a(String str, String str2) {
        ActionManager.addAction(str, str2);
    }

    public static Object b() {
        return ActionManager.getActionMap();
    }

    public static String b(Context context) {
        return (String) cn.jiguang.g.b.a(context, cn.jiguang.g.a.y());
    }

    public static void b(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        f3570a.removeActivityLifecycleCallbacks(activityLifecycleCallbacks);
    }

    public static String c(Context context) {
        return (String) cn.jiguang.g.b.b(context, cn.jiguang.g.a.J());
    }

    public static String d(Context context) {
        return (String) cn.jiguang.g.b.a(context, cn.jiguang.g.a.K());
    }

    public static String e(Context context) {
        return cn.jiguang.bk.a.a(context);
    }

    public static long f(Context context) {
        return ((Long) cn.jiguang.g.b.a(context, cn.jiguang.g.a.x())).longValue();
    }

    public static String g(Context context) {
        return cn.jiguang.bk.a.c(context);
    }

    public static String h(Context context) {
        return cn.jiguang.cn.c.b(context);
    }

    public static String i(Context context) {
        String str = (String) cn.jiguang.g.b.a(context, cn.jiguang.g.a.A());
        return TextUtils.isEmpty(str) ? (String) cn.jiguang.g.b.a(context, cn.jiguang.g.a.B()) : str;
    }

    public static Object j(Context context) {
        HashMap hashMap = new HashMap();
        long longValue = ((Long) cn.jiguang.g.b.a(context, cn.jiguang.g.a.H())).longValue();
        int intValue = ((Integer) cn.jiguang.g.b.a(context, cn.jiguang.g.a.I())).intValue();
        hashMap.put("uuid", (String) cn.jiguang.g.b.a(context, cn.jiguang.g.a.G()));
        hashMap.put("ct", Long.valueOf(longValue));
        hashMap.put("state", Integer.valueOf(intValue));
        return hashMap;
    }

    public static int k(Context context) {
        return ((Integer) cn.jiguang.g.b.a(context, cn.jiguang.g.a.C())).intValue();
    }

    public static boolean l(Context context) {
        d.c("JBridgeHelper", "canShowLbsPermissionDialog");
        Boolean bool = (Boolean) cn.jiguang.g.b.a(context, cn.jiguang.g.a.Y());
        if (bool != null && !bool.booleanValue()) {
            d.d("JBridgeHelper", "lbs disable");
            return false;
        }
        long longValue = ((Long) cn.jiguang.g.b.a(context, cn.jiguang.g.a.X())).longValue();
        long longValue2 = ((Long) cn.jiguang.g.b.a(context, cn.jiguang.g.a.V())).longValue();
        d.c("JBridgeHelper", "lbs permission dialog shield, firstInit=" + longValue2 + ", delay=" + longValue);
        if (longValue2 > 0) {
            return longValue <= 0 || System.currentTimeMillis() > longValue2 + longValue;
        }
        cn.jiguang.g.b.a(context, cn.jiguang.g.a.V().a((cn.jiguang.g.a<Long>) Long.valueOf(System.currentTimeMillis())));
        return longValue <= 0;
    }

    public static int m(Context context) {
        return ((Integer) cn.jiguang.g.b.a(context, cn.jiguang.g.a.I())).intValue();
    }
}

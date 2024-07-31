package com.kuaishou.weapon.p205p0;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import java.lang.reflect.Proxy;
import org.json.JSONObject;

/* renamed from: com.kuaishou.weapon.p0.ah */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C7164ah {

    /* renamed from: a */
    private static final String f24476a = "YW5kcm9pZC5hcHAuQWN0aXZpdHlUaHJlYWQ=";

    /* renamed from: b */
    private final String f24477b = "YW5kcm9pZC5hcHAuQWN0aXZpdHlNYW5hZ2Vy";

    /* renamed from: c */
    private final String f24478c = "YW5kcm9pZC5hcHAuQWN0aXZpdHlNYW5hZ2VyTmF0aXZl";

    /* renamed from: d */
    private final String f24479d = "YW5kcm9pZC5hcHAuQWN0aXZpdHlUYXNrTWFuYWdlcg==";

    /* renamed from: e */
    private final String f24480e = "SUFjdGl2aXR5VGFza01hbmFnZXJTaW5nbGV0b24=";

    /* renamed from: b */
    private void m34416b(JSONObject jSONObject, int i) {
        try {
            Object m33967a = C7264dh.m33967a(new String(C7212c.m34109a(f24476a.getBytes(), 2)), (Object) null, "getPackageManager", new Object[0]);
            if (m33967a != null) {
                m34418a(m33967a, jSONObject, i);
            }
        } catch (Exception unused) {
        }
    }

    /* renamed from: c */
    private void m34415c(JSONObject jSONObject, int i) {
        Object m33966a;
        Object m33967a;
        try {
            if (Build.VERSION.SDK_INT < 29 || (m33966a = C7264dh.m33966a(new String(C7212c.m34109a("YW5kcm9pZC5hcHAuQWN0aXZpdHlUYXNrTWFuYWdlcg==".getBytes(), 2)), new String(C7212c.m34109a("SUFjdGl2aXR5VGFza01hbmFnZXJTaW5nbGV0b24=".getBytes(), 2)))) == null || (m33967a = C7264dh.m33967a("android.util.Singleton", m33966a, "get", new Object[0])) == null) {
                return;
            }
            m34418a(m33967a, jSONObject, i);
        } catch (Exception unused) {
        }
    }

    /* renamed from: d */
    private void m34414d(JSONObject jSONObject, int i) {
        Object m33970a;
        try {
            Object m33967a = C7264dh.m33967a(new String(C7212c.m34109a(f24476a.getBytes(), 2)), (Object) null, "currentActivityThread", new Object[0]);
            if (m33967a == null || (m33970a = C7264dh.m33970a(m33967a.getClass(), m33967a, "mInstrumentation")) == null) {
                return;
            }
            m34418a(m33970a, jSONObject, i);
        } catch (Exception unused) {
        }
    }

    /* renamed from: a */
    public JSONObject m34420a() {
        try {
            JSONObject jSONObject = new JSONObject();
            m34416b(jSONObject, 0);
            m34417a(jSONObject, 1);
            m34415c(jSONObject, 2);
            m34414d(jSONObject, 3);
            if (jSONObject.length() > 0) {
                return jSONObject;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: a */
    private void m34417a(JSONObject jSONObject, int i) {
        Object m33966a;
        Object m33967a;
        try {
            String str = new String(C7212c.m34109a("YW5kcm9pZC5hcHAuQWN0aXZpdHlNYW5hZ2Vy".getBytes(), 2));
            String str2 = new String(C7212c.m34109a("YW5kcm9pZC5hcHAuQWN0aXZpdHlNYW5hZ2VyTmF0aXZl".getBytes(), 2));
            if (Build.VERSION.SDK_INT >= 26) {
                m33966a = C7264dh.m33966a(str, "IActivityManagerSingleton");
            } else {
                m33966a = C7264dh.m33966a(str2, "gDefault");
            }
            if (m33966a == null || (m33967a = C7264dh.m33967a("android.util.Singleton", m33966a, "get", new Object[0])) == null) {
                return;
            }
            m34418a(m33967a, jSONObject, i);
        } catch (Exception unused) {
        }
    }

    /* renamed from: a */
    private boolean m34418a(Object obj, JSONObject jSONObject, int i) {
        if (jSONObject != null) {
            try {
                boolean isProxyClass = Proxy.isProxyClass(obj.getClass());
                String name = obj.getClass().getName();
                int i2 = 1;
                if (isProxyClass) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(i);
                    String sb2 = sb.toString();
                    if (!isProxyClass) {
                        i2 = 0;
                    }
                    jSONObject.put(sb2, i2);
                    jSONObject.put(i + "-c", name);
                } else if (i == 3 && !name.contains("Instrumentation")) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(i);
                    String sb4 = sb3.toString();
                    if (!isProxyClass) {
                        i2 = 0;
                    }
                    jSONObject.put(sb4, i2);
                    jSONObject.put(i + "-c", name);
                }
                return isProxyClass;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    /* renamed from: a */
    public JSONObject m34419a(Context context) {
        try {
            JSONObject jSONObject = new JSONObject();
            PackageManager packageManager = context.getPackageManager();
            Object m33970a = C7264dh.m33970a(packageManager.getClass(), packageManager, "mPM");
            if (m33970a != null) {
                if (m34418a(m33970a, jSONObject, 0)) {
                    return jSONObject;
                }
                return null;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }
}

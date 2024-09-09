package com.kuaishou.weapon.p0;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import com.acse.ottn.f3;
import java.lang.reflect.Proxy;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class ah {

    /* renamed from: a  reason: collision with root package name */
    private static final String f37995a = "YW5kcm9pZC5hcHAuQWN0aXZpdHlUaHJlYWQ=";

    /* renamed from: b  reason: collision with root package name */
    private final String f37996b = "YW5kcm9pZC5hcHAuQWN0aXZpdHlNYW5hZ2Vy";

    /* renamed from: c  reason: collision with root package name */
    private final String f37997c = "YW5kcm9pZC5hcHAuQWN0aXZpdHlNYW5hZ2VyTmF0aXZl";

    /* renamed from: d  reason: collision with root package name */
    private final String f37998d = "YW5kcm9pZC5hcHAuQWN0aXZpdHlUYXNrTWFuYWdlcg==";

    /* renamed from: e  reason: collision with root package name */
    private final String f37999e = "SUFjdGl2aXR5VGFza01hbmFnZXJTaW5nbGV0b24=";

    private void b(JSONObject jSONObject, int i4) {
        try {
            Object a4 = dh.a(new String(c.a("YW5kcm9pZC5hcHAuQWN0aXZpdHlUaHJlYWQ=".getBytes(), 2)), (Object) null, "getPackageManager", new Object[0]);
            if (a4 != null) {
                a(a4, jSONObject, i4);
            }
        } catch (Exception unused) {
        }
    }

    private void c(JSONObject jSONObject, int i4) {
        Object a4;
        Object a5;
        try {
            if (Build.VERSION.SDK_INT < 29 || (a4 = dh.a(new String(c.a("YW5kcm9pZC5hcHAuQWN0aXZpdHlUYXNrTWFuYWdlcg==".getBytes(), 2)), new String(c.a("SUFjdGl2aXR5VGFza01hbmFnZXJTaW5nbGV0b24=".getBytes(), 2)))) == null || (a5 = dh.a("android.util.Singleton", a4, f3.f5657f, new Object[0])) == null) {
                return;
            }
            a(a5, jSONObject, i4);
        } catch (Exception unused) {
        }
    }

    private void d(JSONObject jSONObject, int i4) {
        Object a4;
        try {
            Object a5 = dh.a(new String(c.a("YW5kcm9pZC5hcHAuQWN0aXZpdHlUaHJlYWQ=".getBytes(), 2)), (Object) null, "currentActivityThread", new Object[0]);
            if (a5 == null || (a4 = dh.a(a5.getClass(), a5, "mInstrumentation")) == null) {
                return;
            }
            a(a4, jSONObject, i4);
        } catch (Exception unused) {
        }
    }

    public JSONObject a() {
        try {
            JSONObject jSONObject = new JSONObject();
            b(jSONObject, 0);
            a(jSONObject, 1);
            c(jSONObject, 2);
            d(jSONObject, 3);
            if (jSONObject.length() > 0) {
                return jSONObject;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    private void a(JSONObject jSONObject, int i4) {
        Object a4;
        Object a5;
        try {
            String str = new String(c.a("YW5kcm9pZC5hcHAuQWN0aXZpdHlNYW5hZ2Vy".getBytes(), 2));
            String str2 = new String(c.a("YW5kcm9pZC5hcHAuQWN0aXZpdHlNYW5hZ2VyTmF0aXZl".getBytes(), 2));
            if (Build.VERSION.SDK_INT >= 26) {
                a4 = dh.a(str, "IActivityManagerSingleton");
            } else {
                a4 = dh.a(str2, "gDefault");
            }
            if (a4 == null || (a5 = dh.a("android.util.Singleton", a4, f3.f5657f, new Object[0])) == null) {
                return;
            }
            a(a5, jSONObject, i4);
        } catch (Exception unused) {
        }
    }

    private boolean a(Object obj, JSONObject jSONObject, int i4) {
        if (jSONObject != null) {
            try {
                boolean isProxyClass = Proxy.isProxyClass(obj.getClass());
                String name = obj.getClass().getName();
                int i5 = 1;
                if (isProxyClass) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(i4);
                    String sb2 = sb.toString();
                    if (!isProxyClass) {
                        i5 = 0;
                    }
                    jSONObject.put(sb2, i5);
                    jSONObject.put(i4 + "-c", name);
                } else if (i4 == 3 && !name.contains("Instrumentation")) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(i4);
                    String sb4 = sb3.toString();
                    if (!isProxyClass) {
                        i5 = 0;
                    }
                    jSONObject.put(sb4, i5);
                    jSONObject.put(i4 + "-c", name);
                }
                return isProxyClass;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public JSONObject a(Context context) {
        try {
            JSONObject jSONObject = new JSONObject();
            PackageManager packageManager = context.getPackageManager();
            Object a4 = dh.a(packageManager.getClass(), packageManager, "mPM");
            if (a4 != null) {
                if (a(a4, jSONObject, 0)) {
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

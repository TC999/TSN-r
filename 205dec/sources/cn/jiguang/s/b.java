package cn.jiguang.s;

import android.content.Context;
import android.os.Bundle;
import android.util.Pair;
import cn.jiguang.api.JCoreManager;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.repo.AdLogEventRepo;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class b {
    public static byte a(Context context) {
        try {
            Object onEvent = JCoreManager.onEvent(context, null, 100, "getPluginPlatformType", null, new Object[0]);
            if (onEvent instanceof Byte) {
                return ((Byte) onEvent).byteValue();
            }
        } catch (Throwable unused) {
        }
        return (byte) 0;
    }

    private static <T> Bundle a(cn.jiguang.ai.a<T> aVar) {
        String f4 = aVar.f();
        String g4 = aVar.g();
        boolean i4 = aVar.i();
        boolean j4 = aVar.j();
        Bundle bundle = new Bundle();
        bundle.putString("file", f4);
        bundle.putString("name", g4);
        bundle.putBoolean("multiProcess", i4);
        bundle.putBoolean(AdLogEventRepo.COL_ENCRYPT_TYPE, j4);
        return bundle;
    }

    private static Bundle a(cn.jiguang.ak.a aVar, boolean z3) {
        String a4 = aVar.a();
        int b4 = aVar.b();
        int c4 = aVar.c();
        boolean e4 = aVar.e();
        boolean f4 = aVar.f();
        boolean g4 = aVar.g();
        boolean n4 = aVar.n();
        boolean o4 = aVar.o();
        boolean h4 = aVar.h();
        boolean j4 = aVar.j();
        Bundle bundle = new Bundle();
        bundle.putString("url", a4);
        bundle.putInt("connectTimeout", b4);
        bundle.putInt("readTimeout", c4);
        bundle.putBoolean("doOutPut", e4);
        bundle.putBoolean("doInPut", f4);
        bundle.putBoolean("UseCaches", g4);
        bundle.putBoolean("haveRspData", n4);
        bundle.putBoolean("rspDatazip", o4);
        bundle.putBoolean("needErrorInput", h4);
        bundle.putBoolean("needRetryIfHttpsFailed", j4);
        bundle.putBoolean("isHttpPost", z3);
        return bundle;
    }

    public static cn.jiguang.ak.b a(Context context, cn.jiguang.ak.a aVar, boolean z3) {
        if (aVar == null) {
            return null;
        }
        try {
            Object onEvent = JCoreManager.onEvent(context, null, 100, "httpResponse", a(aVar, z3), aVar.d(), aVar.l(), aVar.m(), aVar.i(), aVar.k());
            if (onEvent instanceof Object[]) {
                return a((Object[]) onEvent);
            }
        } catch (Throwable th) {
            cn.jiguang.w.a.i("JPortraitToJcore", "httpResponse:" + th);
        }
        return null;
    }

    private static cn.jiguang.ak.b a(Object... objArr) {
        Bundle bundle = (Bundle) objArr[0];
        String string = bundle.getString("url");
        String string2 = bundle.getString("responseBody");
        int i4 = bundle.getInt("type");
        long j4 = bundle.getLong("expiredTime");
        boolean z3 = bundle.getBoolean("isInCache");
        int i5 = bundle.getInt("responseCode");
        int i6 = bundle.getInt("statusCode");
        cn.jiguang.ak.b bVar = new cn.jiguang.ak.b(string);
        bVar.a(string2);
        bVar.a((Map) objArr[1]);
        bVar.c(i4);
        if (0 != j4) {
            bVar.a(j4);
        }
        bVar.a(z3);
        bVar.a(i5);
        bVar.b(i6);
        return bVar;
    }

    public static <T> T a(Context context, cn.jiguang.ai.a<T> aVar) {
        try {
            return (T) JCoreManager.onEvent(context, null, 100, "sp_get", a(aVar), aVar.h());
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Object a(Context context, String str, int i4) {
        try {
            Bundle bundle = new Bundle();
            bundle.putString("sdkType", str);
            bundle.putInt("cmd", i4);
            return JCoreManager.onEvent(context, null, 100, "getSdkDataByCmd", bundle, new Object[0]);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String a(int i4) {
        try {
            Bundle bundle = new Bundle();
            bundle.putInt("regProperty", i4);
            Object onEvent = JCoreManager.onEvent(null, null, 100, "getSdkVersionByRegProperty", bundle, new Object[0]);
            return onEvent instanceof String ? (String) onEvent : "";
        } catch (Throwable unused) {
            return "";
        }
    }

    public static void a(Context context, JSONObject jSONObject) {
        try {
            JCoreManager.onEvent(context, null, 100, "dealCommandInternalDebug", null, jSONObject);
        } catch (Throwable unused) {
        }
    }

    public static void a(Context context, cn.jiguang.ai.a<?>... aVarArr) {
        if (aVarArr == null || aVarArr.length <= 0) {
            return;
        }
        Bundle[] bundleArr = new Bundle[aVarArr.length];
        Object[] objArr = new Object[aVarArr.length];
        for (int i4 = 0; i4 < aVarArr.length; i4++) {
            Object h4 = aVarArr[i4].h();
            Bundle a4 = a(aVarArr[i4]);
            objArr[i4] = h4;
            bundleArr[i4] = a4;
        }
        try {
            JCoreManager.onEvent(context, null, 100, "sp_set", null, bundleArr, objArr);
        } catch (Throwable unused) {
        }
    }

    public static void a(Thread thread, Throwable th) {
        try {
            JCoreManager.onEvent(null, null, 100, "uncaughtException", null, thread, th);
        } catch (Throwable unused) {
        }
    }

    public static boolean a() {
        try {
            Object onEvent = JCoreManager.onEvent(null, null, 100, "isForeGround", null, new Object[0]);
            if (onEvent instanceof Boolean) {
                return ((Boolean) onEvent).booleanValue();
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static <T> T b(Context context, cn.jiguang.ai.a<T> aVar) {
        try {
            return (T) JCoreManager.onEvent(context, null, 100, "sp_getWithNull", a(aVar), aVar.h());
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String b(Context context) {
        try {
            Object onEvent = JCoreManager.onEvent(context, null, 100, "getPluginPlatformRegId", null, new Object[0]);
            return onEvent instanceof String ? (String) onEvent : "";
        } catch (Throwable unused) {
            return "";
        }
    }

    public static void b(Context context, JSONObject jSONObject) {
        try {
            JCoreManager.onEvent(context, null, 100, "configShareProcess", null, jSONObject);
        } catch (Throwable unused) {
        }
    }

    public static boolean b() {
        try {
            Object onEvent = JCoreManager.onEvent(null, null, 100, "isOnlyVerifiSDK", null, new Object[0]);
            if (onEvent instanceof Boolean) {
                return ((Boolean) onEvent).booleanValue();
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static Pair<String, Long> c(Context context) {
        try {
            Object onEvent = JCoreManager.onEvent(context, null, 100, "getAppVersion", null, new Object[0]);
            if (onEvent instanceof Pair) {
                return (Pair) onEvent;
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static boolean c() {
        try {
            Object onEvent = JCoreManager.onEvent(null, null, 100, "isSDKInit", null, new Object[0]);
            if (onEvent instanceof Boolean) {
                return ((Boolean) onEvent).booleanValue();
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static long d() {
        try {
            Object onEvent = JCoreManager.onEvent(null, null, 100, "getRegBussiness", null, new Object[0]);
            if (onEvent instanceof Long) {
                return ((Long) onEvent).longValue();
            }
            return 0L;
        } catch (Throwable unused) {
            return 0L;
        }
    }

    public static Map<Integer, Bundle> e() {
        try {
            Object onEvent = JCoreManager.onEvent(null, null, 100, "loadPInfo", null, new Object[0]);
            if (onEvent instanceof Map) {
                return (Map) onEvent;
            }
        } catch (Throwable unused) {
        }
        return new HashMap();
    }
}

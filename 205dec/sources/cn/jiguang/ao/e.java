package cn.jiguang.ao;

import android.content.Context;
import android.text.TextUtils;
import cn.jiguang.api.JCoreManager;
import java.io.File;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class e {
    public static JSONObject a(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                synchronized (str) {
                    Object onEvent = JCoreManager.onEvent(context, "JCOMMON", 42, null, null, str);
                    if (onEvent instanceof JSONObject) {
                        return (JSONObject) onEvent;
                    }
                    return null;
                }
            } catch (Throwable th) {
                cn.jiguang.w.a.f("JCommonFileHelper", "readJson throwable:" + th.getMessage());
            }
        }
        return null;
    }

    public static void a(File file) {
        if (file != null) {
            try {
                if (file.exists()) {
                    file.delete();
                }
            } catch (Throwable th) {
                cn.jiguang.w.a.f("JCommonFileHelper", "delete throwable:" + th.getMessage());
            }
        }
    }

    public static boolean a(Context context, String str, String str2) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                synchronized (str) {
                    File g4 = cn.jiguang.ah.d.g(context, str);
                    if (g4 == null) {
                        return false;
                    }
                    return cn.jiguang.ah.d.a(g4, str2);
                }
            } catch (Throwable th) {
                cn.jiguang.w.a.f("JCommonFileHelper", "writeString throwable:" + th.getMessage());
            }
        }
        return false;
    }

    public static boolean a(Context context, String str, JSONObject jSONObject) {
        boolean booleanValue;
        if (context != null && !TextUtils.isEmpty(str) && jSONObject != null) {
            try {
                synchronized (str) {
                    Object onEvent = JCoreManager.onEvent(context, "JCOMMON", 41, null, null, str, jSONObject);
                    booleanValue = onEvent instanceof Boolean ? ((Boolean) onEvent).booleanValue() : false;
                }
                return booleanValue;
            } catch (Throwable th) {
                cn.jiguang.w.a.f("JCommonFileHelper", "writeJson throwable:" + th.getMessage());
            }
        }
        return false;
    }

    public static void b(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            if (a(context, str, (JSONObject) null)) {
                return;
            }
            synchronized (str) {
                context.deleteFile(str);
            }
        } catch (Throwable th) {
            cn.jiguang.w.a.f("JCommonFileHelper", "cleanJson throwable:" + th.getMessage());
        }
    }

    public static boolean b(Context context, String str, String str2) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                synchronized (str) {
                    if (cn.jiguang.ah.d.g(context, str) == null) {
                        return false;
                    }
                    return ((Boolean) JCoreManager.onEvent(context, "JCOMMON", 79, null, null, str, str2)).booleanValue();
                }
            } catch (Throwable th) {
                cn.jiguang.w.a.f("JCommonFileHelper", "writeString throwable:" + th.getMessage());
            }
        }
        return false;
    }

    public static String c(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                synchronized (str) {
                    File g4 = cn.jiguang.ah.d.g(context, str);
                    if (g4 == null) {
                        return null;
                    }
                    return cn.jiguang.ah.d.a(g4);
                }
            } catch (Throwable th) {
                cn.jiguang.w.a.f("JCommonFileHelper", "readString throwable:" + th.getMessage());
            }
        }
        return null;
    }

    public static void d(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            synchronized (str) {
                File g4 = cn.jiguang.ah.d.g(context, str);
                if (g4 == null) {
                    return;
                }
                cn.jiguang.ah.d.a(g4, "");
            }
        } catch (Throwable th) {
            cn.jiguang.w.a.f("JCommonFileHelper", "cleanString throwable:" + th.getMessage());
        }
    }

    public static void e(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            synchronized (str) {
                File g4 = cn.jiguang.ah.d.g(context, str);
                if (g4 == null) {
                    return;
                }
                a(g4);
            }
        } catch (Throwable th) {
            cn.jiguang.w.a.f("JCommonFileHelper", "cleanString throwable:" + th.getMessage());
        }
    }
}

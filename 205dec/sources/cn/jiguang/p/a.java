package cn.jiguang.p;

import android.content.Context;
import android.os.Build;
import cn.jiguang.ah.d;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static String f3762a;

    /* renamed from: b  reason: collision with root package name */
    private static String f3763b;

    /* renamed from: c  reason: collision with root package name */
    private static String f3764c;

    private static Class<?> a(Context context, String str) {
        if (str == null || str.trim().length() == 0) {
            throw new ClassNotFoundException("class is empty");
        }
        boolean z3 = context != null;
        if (z3 && Build.VERSION.SDK_INT >= 29) {
            try {
                return context.getClassLoader().loadClass(str);
            } catch (ClassNotFoundException e4) {
                cn.jiguang.w.a.f("IdProvider", "loadClass error, " + e4.getMessage());
            }
        }
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e5) {
            cn.jiguang.w.a.f("IdProvider", String.format("loadClass fail hasContext= %s, errMsg = %s", Boolean.valueOf(z3), e5.getLocalizedMessage()));
            throw new ClassNotFoundException("loadClass fail ", e5);
        }
    }

    public static String a(Context context) {
        try {
            if (f3763b == null) {
                f3764c = "";
                f3762a = "";
                f3763b = "";
                Class<?> a4 = a(context, d.f("KIHhQylffktk79IAY9r8iabG5YlYSM/WswW6fWtc2r2WbTdKR65l5atPPp2u96wd"));
                Object invoke = a4.getMethod(d.f("Oi3ZFT8+schQHSyFZbsdUg=="), Context.class).invoke(a4.newInstance(), context);
                if (invoke instanceof String) {
                    f3763b = (String) invoke;
                }
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("joad", f3763b);
            return jSONObject.toString();
        } catch (Throwable th) {
            cn.jiguang.w.a.g("IdProvider", "getIds failed:" + th.getMessage());
            return "";
        }
    }
}

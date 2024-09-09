package cn.jpush.android.h;

import android.content.Context;
import android.text.TextUtils;
import cn.jpush.android.e.c;
import cn.jpush.android.f.f;
import cn.jpush.android.i.b;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public final class a {
    public static void a(Context context, String str, c cVar) {
        if (TextUtils.isEmpty(str)) {
            b.g("PushPlatformManager", "appId is empty");
            if (cVar != null) {
                cVar.a(new cn.jpush.android.e.b(f.f4198b, "", "appId is empty"));
            }
        } else if (str.length() != 24) {
            b.g("PushPlatformManager", "Invalid appId : " + str + ", Please check your appId again!");
            if (cVar != null) {
                cVar.a(new cn.jpush.android.e.b(f.f4198b, "", "Invalid appId"));
            }
        } else {
            try {
                String b4 = cn.jpush.android.a.b.b(context);
                if (!TextUtils.isEmpty(b4)) {
                    b.d("PushPlatformManager", "has register,token:" + b4);
                    if (cVar != null) {
                        cVar.a(new cn.jpush.android.e.b(0, b4, "has register"));
                        return;
                    }
                    return;
                }
                cn.jpush.android.f.c.f4185b = str;
                b.b("PushPlatformManager", "register: appId - " + str);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("JPUSH_APPKEY", str);
                jSONObject.put("FIRST_REQUESTA", cn.jpush.android.a.b.c(context));
                cn.jpush.android.a.b.d(context);
                long a4 = cn.jpush.android.f.c.a();
                cn.jpush.android.f.a.a(new cn.jpush.android.f.b("ups.register", a4), cVar);
                cn.jpush.android.f.c.a(context, "ups.register", a4, jSONObject);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }
}

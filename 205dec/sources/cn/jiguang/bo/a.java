package cn.jiguang.bo;

import android.content.Context;
import android.os.Bundle;
import cn.jiguang.bm.i;
import cn.jiguang.bp.g;
import cn.jiguang.bp.h;
import java.util.Iterator;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    private static a f2807b;

    /* renamed from: a  reason: collision with root package name */
    private JSONObject f2808a;

    public static a a() {
        if (f2807b == null) {
            synchronized (a.class) {
                if (f2807b == null) {
                    f2807b = new a();
                }
            }
        }
        return f2807b;
    }

    public void a(Context context) {
        if (this.f2808a == null) {
            synchronized (a.class) {
                this.f2808a = new JSONObject(g.f(context));
            }
        }
    }

    public void a(Context context, Bundle bundle) {
        a(context);
        try {
            String string = bundle.getString("properties");
            if (string == null) {
                return;
            }
            JSONObject jSONObject = new JSONObject(string);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                if (keys.next().trim().startsWith("jg")) {
                    h.g("JOperateSuperProperties", "attribute key not starts with 'jg'");
                    return;
                }
            }
            JSONObject a4 = i.a(jSONObject, this.f2808a);
            this.f2808a = a4;
            g.d(context, a4.toString());
        } catch (Throwable unused) {
        }
    }

    public JSONObject b(Context context) {
        a(context);
        return this.f2808a;
    }

    public void b(Context context, Bundle bundle) {
        JSONObject jSONObject = new JSONObject();
        this.f2808a = jSONObject;
        g.d(context, jSONObject.toString());
    }

    public JSONObject c(Context context) {
        try {
            return (JSONObject) Class.forName("cn.jiguang.joperate.api.JOperateInterface").getDeclaredMethod("getDynamicProperty", Context.class).invoke(null, context);
        } catch (Throwable unused) {
            return new JSONObject();
        }
    }

    public void c(Context context, Bundle bundle) {
        a(context);
        try {
            String string = bundle.getString("property_name");
            if (string == null) {
                return;
            }
            this.f2808a.remove(string);
            g.d(context, this.f2808a.toString());
        } catch (Throwable unused) {
        }
    }
}

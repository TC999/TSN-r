package com.kuaishou.weapon.p0.jni;

import android.content.Context;
import com.kuaishou.weapon.p0.dp;
import com.kuaishou.weapon.p0.w;
import org.json.JSONArray;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class A {
    private static int flag;
    private static JSONArray jsonObject;

    public A(Context context, int i4) {
        flag = i4;
        if (Engine.loadSuccess) {
            Engine.getInstance(context).qrs();
        } else {
            setA(context);
        }
    }

    public static String getE(String str) {
        try {
            dp a4 = dp.a();
            if (a4 != null) {
                return a4.a(str, "");
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public static JSONArray getJsonObject() {
        return jsonObject;
    }

    public static void setA(Context context) {
        if (context != null) {
            jsonObject = new w(context).b(flag);
        }
    }

    public static void setE(String str, String str2) {
        try {
            dp a4 = dp.a();
            if (a4 != null) {
                a4.b(str, str2);
            }
        } catch (Exception unused) {
        }
    }

    public static void setJsonObject(JSONArray jSONArray) {
        jsonObject = jSONArray;
    }
}

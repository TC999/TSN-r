package com.kuaishou.weapon.p205p0.jni;

import android.content.Context;
import com.kuaishou.weapon.p205p0.C7278dp;
import com.kuaishou.weapon.p205p0.C7309w;
import org.json.JSONArray;

/* renamed from: com.kuaishou.weapon.p0.jni.A */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C7286A {
    private static int flag;
    private static JSONArray jsonObject;

    public C7286A(Context context, int i) {
        flag = i;
        if (Engine.loadSuccess) {
            Engine.getInstance(context).qrs();
        } else {
            setA(context);
        }
    }

    public static String getE(String str) {
        try {
            C7278dp m33921a = C7278dp.m33921a();
            if (m33921a != null) {
                return m33921a.m33914a(str, "");
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
            jsonObject = new C7309w(context).m33725b(flag);
        }
    }

    public static void setE(String str, String str2) {
        try {
            C7278dp m33921a = C7278dp.m33921a();
            if (m33921a != null) {
                m33921a.m33912b(str, str2);
            }
        } catch (Exception unused) {
        }
    }

    public static void setJsonObject(JSONArray jSONArray) {
        jsonObject = jSONArray;
    }
}

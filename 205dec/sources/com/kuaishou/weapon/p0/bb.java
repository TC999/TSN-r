package com.kuaishou.weapon.p0;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.jni.Engine;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class bb {

    /* renamed from: a  reason: collision with root package name */
    private JSONObject f38055a;

    public bb(Context context, int i4, String str, boolean z3) {
        if (Engine.loadSuccess && z3) {
            try {
                String pqr = Engine.getInstance(context).pqr(Integer.valueOf(ck.f38170f).intValue(), 0, i4, str);
                if (TextUtils.isEmpty(pqr)) {
                    return;
                }
                this.f38055a = new JSONObject(pqr);
            } catch (Throwable unused) {
            }
        }
    }

    public static boolean a(Context context) {
        try {
            if (Build.VERSION.SDK_INT >= 23) {
                return g.a(context, "android.permission.READ_EXTERNAL_STORAGE") != -1;
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public String a(String str) {
        JSONObject jSONObject = this.f38055a;
        if (jSONObject != null) {
            try {
                return jSONObject.getString(str);
            } catch (Exception unused) {
                return null;
            }
        }
        return null;
    }

    public JSONObject a() {
        return this.f38055a;
    }
}

package com.kuaishou.weapon.p205p0;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.kuaishou.weapon.p205p0.jni.Engine;
import org.json.JSONObject;

/* renamed from: com.kuaishou.weapon.p0.bb */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C7185bb {

    /* renamed from: a */
    private JSONObject f24547a;

    public C7185bb(Context context, int i, String str, boolean z) {
        if (Engine.loadSuccess && z) {
            try {
                String pqr = Engine.getInstance(context).pqr(Integer.valueOf(C7227ck.f24674f).intValue(), 0, i, str);
                if (TextUtils.isEmpty(pqr)) {
                    return;
                }
                this.f24547a = new JSONObject(pqr);
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: a */
    public static boolean m34294a(Context context) {
        try {
            if (Build.VERSION.SDK_INT >= 23) {
                return C7282g.m33892a(context, C7282g.f24951i) != -1;
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    /* renamed from: a */
    public String m34293a(String str) {
        JSONObject jSONObject = this.f24547a;
        if (jSONObject != null) {
            try {
                return jSONObject.getString(str);
            } catch (Exception unused) {
                return null;
            }
        }
        return null;
    }

    /* renamed from: a */
    public JSONObject m34295a() {
        return this.f24547a;
    }
}

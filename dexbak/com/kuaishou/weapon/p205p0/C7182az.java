package com.kuaishou.weapon.p205p0;

import android.content.Context;
import android.text.TextUtils;
import com.kuaishou.weapon.p205p0.jni.Engine;
import org.json.JSONObject;

/* renamed from: com.kuaishou.weapon.p0.az */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C7182az {

    /* renamed from: a */
    private JSONObject f24539a;

    public C7182az(Context context, int i) {
        if (Engine.loadSuccess) {
            try {
                String pqr = Engine.getInstance(context).pqr(Integer.valueOf(C7227ck.f24671c).intValue(), 2, i < 10 ? 10 : i, "");
                if (TextUtils.isEmpty(pqr)) {
                    return;
                }
                this.f24539a = new JSONObject(pqr);
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: b */
    private String m34308b(String str) {
        JSONObject jSONObject = this.f24539a;
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
    public JSONObject m34309a(String str) {
        try {
            String m34308b = m34308b(str);
            if (TextUtils.isEmpty(m34308b)) {
                return null;
            }
            return new JSONObject(m34308b);
        } catch (Exception unused) {
            return null;
        }
    }
}

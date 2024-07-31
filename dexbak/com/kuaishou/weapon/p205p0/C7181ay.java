package com.kuaishou.weapon.p205p0;

import android.content.Context;
import android.text.TextUtils;
import com.kuaishou.weapon.p205p0.jni.Engine;
import org.json.JSONObject;

/* renamed from: com.kuaishou.weapon.p0.ay */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C7181ay {

    /* renamed from: a */
    private JSONObject f24538a;

    public C7181ay(Context context, int i) {
        if (Engine.loadSuccess) {
            try {
                String pqr = Engine.getInstance(context).pqr(Integer.valueOf(C7227ck.f24671c).intValue(), 2, i, "");
                if (TextUtils.isEmpty(pqr)) {
                    return;
                }
                this.f24538a = new JSONObject(pqr);
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: a */
    public String m34310a(String str) {
        JSONObject jSONObject = this.f24538a;
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
    public JSONObject m34311a() {
        return this.f24538a;
    }
}

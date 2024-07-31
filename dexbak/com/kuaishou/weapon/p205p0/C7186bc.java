package com.kuaishou.weapon.p205p0;

import android.content.Context;
import android.text.TextUtils;
import com.kuaishou.weapon.p205p0.jni.Engine;
import org.json.JSONObject;

/* renamed from: com.kuaishou.weapon.p0.bc */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C7186bc {

    /* renamed from: a */
    private JSONObject f24548a;

    public C7186bc(Context context, String str, int i) {
        if (Engine.loadSuccess) {
            try {
                String pqr = Engine.getInstance(context).pqr(i, 0, C7239cu.m34032a() ? 1 : 0, str);
                if (TextUtils.isEmpty(pqr)) {
                    return;
                }
                this.f24548a = new JSONObject(pqr);
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: a */
    public String m34292a(String str) {
        JSONObject jSONObject = this.f24548a;
        if (jSONObject != null) {
            try {
                return jSONObject.getString(str);
            } catch (Exception unused) {
                return null;
            }
        }
        return null;
    }
}

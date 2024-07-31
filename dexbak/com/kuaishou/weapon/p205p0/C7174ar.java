package com.kuaishou.weapon.p205p0;

import android.content.Context;
import android.text.TextUtils;
import com.kuaishou.weapon.p205p0.jni.Engine;
import org.json.JSONObject;

/* renamed from: com.kuaishou.weapon.p0.ar */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C7174ar {

    /* renamed from: a */
    private JSONObject f24528a;

    public C7174ar(Context context) {
        if (Engine.loadSuccess) {
            try {
                String klm = Engine.getInstance(context).klm(56, context.getPackageName());
                if (TextUtils.isEmpty(klm)) {
                    return;
                }
                this.f24528a = new JSONObject(klm);
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: a */
    public String m34341a(String str) {
        JSONObject jSONObject = this.f24528a;
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

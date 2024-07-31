package com.kuaishou.weapon.p205p0;

import android.content.Context;
import android.text.TextUtils;
import com.kuaishou.weapon.p205p0.jni.Engine;
import org.json.JSONObject;

/* renamed from: com.kuaishou.weapon.p0.ca */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C7216ca {

    /* renamed from: a */
    private JSONObject f24654a;

    public C7216ca(Context context) {
        if (Engine.loadSuccess) {
            String efg = Engine.getInstance(context).efg();
            if (TextUtils.isEmpty(efg)) {
                return;
            }
            try {
                this.f24654a = new JSONObject(efg);
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: a */
    public String m34099a(String str) {
        JSONObject jSONObject = this.f24654a;
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

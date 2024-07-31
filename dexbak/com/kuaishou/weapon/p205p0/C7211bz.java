package com.kuaishou.weapon.p205p0;

import android.content.Context;
import android.text.TextUtils;
import com.kuaishou.weapon.p205p0.jni.Engine;
import org.json.JSONObject;

/* renamed from: com.kuaishou.weapon.p0.bz */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C7211bz {

    /* renamed from: a */
    private JSONObject f24625a;

    public C7211bz(Context context) {
        if (Engine.loadSuccess) {
            String fgh = Engine.getInstance(context).fgh();
            if (TextUtils.isEmpty(fgh)) {
                return;
            }
            try {
                this.f24625a = new JSONObject(fgh);
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: a */
    public String m34113a(String str) {
        JSONObject jSONObject = this.f24625a;
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

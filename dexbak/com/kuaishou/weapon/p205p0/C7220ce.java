package com.kuaishou.weapon.p205p0;

import android.content.Context;
import android.text.TextUtils;
import com.kuaishou.weapon.p205p0.jni.Engine;
import org.json.JSONObject;

/* renamed from: com.kuaishou.weapon.p0.ce */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C7220ce {

    /* renamed from: a */
    private JSONObject f24658a;

    public C7220ce(Context context) {
        if (Engine.loadSuccess) {
            Engine.getInstance(context);
            String abc = Engine.abc();
            if (TextUtils.isEmpty(abc)) {
                return;
            }
            try {
                this.f24658a = new JSONObject(abc);
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: a */
    public String m34095a(String str) {
        JSONObject jSONObject = this.f24658a;
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

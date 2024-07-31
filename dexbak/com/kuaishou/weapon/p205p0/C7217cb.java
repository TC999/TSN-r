package com.kuaishou.weapon.p205p0;

import android.content.Context;
import android.text.TextUtils;
import com.kuaishou.weapon.p205p0.jni.Engine;
import org.json.JSONObject;

/* renamed from: com.kuaishou.weapon.p0.cb */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C7217cb {

    /* renamed from: a */
    private JSONObject f24655a;

    public C7217cb(Context context) {
        if (Engine.loadSuccess) {
            String ghi = Engine.getInstance(context).ghi();
            if (TextUtils.isEmpty(ghi)) {
                return;
            }
            try {
                this.f24655a = new JSONObject(ghi);
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: a */
    public String m34098a(String str) {
        JSONObject jSONObject = this.f24655a;
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

package com.kuaishou.weapon.p205p0;

import android.content.Context;
import android.text.TextUtils;
import com.kuaishou.weapon.p205p0.jni.Engine;
import org.json.JSONObject;

/* renamed from: com.kuaishou.weapon.p0.cd */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C7219cd {

    /* renamed from: a */
    private JSONObject f24657a;

    public C7219cd(Context context) {
        if (Engine.loadSuccess) {
            String hij = Engine.getInstance(context).hij();
            if (TextUtils.isEmpty(hij)) {
                return;
            }
            try {
                this.f24657a = new JSONObject(hij);
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: a */
    public String m34096a(String str) {
        JSONObject jSONObject = this.f24657a;
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

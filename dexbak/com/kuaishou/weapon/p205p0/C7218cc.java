package com.kuaishou.weapon.p205p0;

import android.content.Context;
import android.text.TextUtils;
import com.kuaishou.weapon.p205p0.jni.Engine;
import org.json.JSONObject;

/* renamed from: com.kuaishou.weapon.p0.cc */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C7218cc {

    /* renamed from: a */
    private JSONObject f24656a;

    public C7218cc(Context context) {
        if (Engine.loadSuccess) {
            Engine.getInstance(context);
            String bcd = Engine.bcd();
            if (TextUtils.isEmpty(bcd) || bcd.length() <= 2) {
                return;
            }
            try {
                this.f24656a = new JSONObject(bcd);
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: a */
    public String m34097a(String str) {
        JSONObject jSONObject = this.f24656a;
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

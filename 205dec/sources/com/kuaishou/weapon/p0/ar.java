package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.jni.Engine;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class ar {

    /* renamed from: a  reason: collision with root package name */
    private JSONObject f38036a;

    public ar(Context context) {
        if (Engine.loadSuccess) {
            try {
                String klm = Engine.getInstance(context).klm(56, context.getPackageName());
                if (TextUtils.isEmpty(klm)) {
                    return;
                }
                this.f38036a = new JSONObject(klm);
            } catch (Throwable unused) {
            }
        }
    }

    public String a(String str) {
        JSONObject jSONObject = this.f38036a;
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

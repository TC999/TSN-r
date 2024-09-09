package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.jni.Engine;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class ce {

    /* renamed from: a  reason: collision with root package name */
    private JSONObject f38157a;

    public ce(Context context) {
        if (Engine.loadSuccess) {
            Engine.getInstance(context);
            String abc = Engine.abc();
            if (TextUtils.isEmpty(abc)) {
                return;
            }
            try {
                this.f38157a = new JSONObject(abc);
            } catch (Exception unused) {
            }
        }
    }

    public String a(String str) {
        JSONObject jSONObject = this.f38157a;
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

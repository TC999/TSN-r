package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.jni.Engine;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class cd {

    /* renamed from: a  reason: collision with root package name */
    private JSONObject f38156a;

    public cd(Context context) {
        if (Engine.loadSuccess) {
            String hij = Engine.getInstance(context).hij();
            if (TextUtils.isEmpty(hij)) {
                return;
            }
            try {
                this.f38156a = new JSONObject(hij);
            } catch (Exception unused) {
            }
        }
    }

    public String a(String str) {
        JSONObject jSONObject = this.f38156a;
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

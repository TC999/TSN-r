package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.jni.Engine;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class cb {

    /* renamed from: a  reason: collision with root package name */
    private JSONObject f38154a;

    public cb(Context context) {
        if (Engine.loadSuccess) {
            String ghi = Engine.getInstance(context).ghi();
            if (TextUtils.isEmpty(ghi)) {
                return;
            }
            try {
                this.f38154a = new JSONObject(ghi);
            } catch (Exception unused) {
            }
        }
    }

    public String a(String str) {
        JSONObject jSONObject = this.f38154a;
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

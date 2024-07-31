package com.kuaishou.weapon.p205p0;

import android.content.Context;
import android.text.TextUtils;
import com.kuaishou.weapon.p205p0.jni.Engine;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.kuaishou.weapon.p0.au */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C7177au {

    /* renamed from: a */
    private JSONObject f24533a;

    /* renamed from: b */
    private boolean f24534b;

    public C7177au(Context context) {
        if (Engine.loadSuccess) {
            try {
                String pqr = Engine.getInstance(context).pqr(Integer.valueOf(C7227ck.f24675g).intValue(), 0, 200, "");
                if (TextUtils.isEmpty(pqr)) {
                    return;
                }
                this.f24533a = new JSONObject(pqr);
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: a */
    public String m34324a(String str) {
        JSONObject jSONObject = this.f24533a;
        if (jSONObject != null) {
            try {
                return jSONObject.getString(str);
            } catch (Exception unused) {
                return null;
            }
        }
        return null;
    }

    /* renamed from: b */
    public List m34323b(String str) {
        JSONObject jSONObject = this.f24533a;
        if (jSONObject != null) {
            try {
                String string = jSONObject.getString(str);
                if (TextUtils.isEmpty(string) || string.length() <= 3) {
                    return null;
                }
                String m33864a = C7284i.m33864a("98bb0a15913e0654348b", "0805");
                JSONArray jSONArray = new JSONArray(string);
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < jSONArray.length(); i++) {
                    String string2 = jSONArray.getString(i);
                    if (string2.contains(m33864a)) {
                        this.f24534b = true;
                    } else {
                        arrayList.add(string2);
                    }
                }
                if (arrayList.size() > 0) {
                    return arrayList;
                }
                return null;
            } catch (Exception unused) {
                return null;
            }
        }
        return null;
    }

    /* renamed from: a */
    public boolean m34325a() {
        return this.f24534b;
    }
}

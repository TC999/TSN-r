package com.kuaishou.weapon.p205p0;

import android.content.Context;
import android.text.TextUtils;
import com.kuaishou.weapon.p205p0.jni.Engine;
import java.util.Iterator;
import org.json.JSONObject;

/* renamed from: com.kuaishou.weapon.p0.aw */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C7179aw {

    /* renamed from: a */
    private JSONObject f24536a;

    public C7179aw(Context context) {
        if (Engine.loadSuccess) {
            try {
                String pqr = Engine.getInstance(context).pqr(Integer.valueOf(C7227ck.f24679k).intValue(), 0, 1, "");
                if (TextUtils.isEmpty(pqr)) {
                    return;
                }
                this.f24536a = new JSONObject(pqr);
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: a */
    public JSONObject m34321a() {
        return this.f24536a;
    }

    /* renamed from: b */
    public JSONObject m34318b(Context context) {
        try {
            if (Engine.loadSuccess) {
                String pqr = Engine.getInstance(context).pqr(Integer.valueOf(C7227ck.f24678j).intValue(), 1, 2, "");
                if (TextUtils.isEmpty(pqr) || pqr.length() <= 2) {
                    return null;
                }
                return new JSONObject(pqr);
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: c */
    public JSONObject m34317c(Context context) {
        try {
            if (Engine.loadSuccess) {
                String pqr = Engine.getInstance(context).pqr(Integer.valueOf(C7227ck.f24678j).intValue(), 2, 1, "");
                if (TextUtils.isEmpty(pqr)) {
                    return null;
                }
                return new JSONObject(pqr);
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: d */
    public JSONObject m34316d(Context context) {
        JSONObject jSONObject = null;
        try {
            if (Engine.loadSuccess) {
                String pqr = Engine.getInstance(context).pqr(Integer.valueOf(C7227ck.f24678j).intValue(), 1, 3, "");
                if (!TextUtils.isEmpty(pqr)) {
                    jSONObject = new JSONObject(pqr);
                }
            }
            if (C7191bh.m34265a(context, "com.freeze.kusr")) {
                if (jSONObject == null) {
                    jSONObject = new JSONObject();
                }
                jSONObject.put("com.freeze.kusr", 1);
            }
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    /* renamed from: a */
    public void m34319a(JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = this.f24536a;
            if (jSONObject2 != null) {
                Iterator<String> keys = jSONObject2.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    String string = this.f24536a.getString(next);
                    if (!TextUtils.isEmpty(string)) {
                        jSONObject.put(next, string);
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    /* renamed from: a */
    public JSONObject m34320a(Context context) {
        try {
            if (Engine.loadSuccess) {
                String pqr = Engine.getInstance(context).pqr(Integer.valueOf(C7227ck.f24678j).intValue(), 1, 0, "");
                if (TextUtils.isEmpty(pqr)) {
                    return null;
                }
                return new JSONObject(pqr);
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }
}

package com.kuaishou.weapon.p205p0;

import android.content.Context;
import android.text.TextUtils;
import com.kuaishou.weapon.p205p0.jni.Engine;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONObject;

/* renamed from: com.kuaishou.weapon.p0.bd */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C7187bd extends C7263dg {

    /* renamed from: a */
    private JSONObject f24549a;

    public C7187bd(Context context) {
        if (Engine.loadSuccess) {
            try {
                String pqr = Engine.getInstance(context).pqr(Integer.valueOf(C7227ck.f24671c).intValue(), 5, 5, "");
                if (TextUtils.isEmpty(pqr)) {
                    return;
                }
                this.f24549a = new JSONObject(pqr);
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: a */
    public String m34290a(String str) {
        JSONObject jSONObject = this.f24549a;
        if (jSONObject != null) {
            try {
                return jSONObject.getString(str);
            } catch (Exception unused) {
                return null;
            }
        }
        return null;
    }

    /* renamed from: a */
    public boolean m34288a(Set set, String str) {
        try {
            Iterator it = set.iterator();
            while (it.hasNext()) {
                String str2 = (String) it.next();
                if (!str2.equals(str) && str2.contains(str)) {
                    return true;
                }
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    /* renamed from: a */
    public Set m34289a(Set set) {
        if (set != null) {
            try {
                if (set.size() > 0) {
                    HashSet hashSet = new HashSet();
                    Iterator it = set.iterator();
                    while (it.hasNext()) {
                        String str = (String) it.next();
                        if (!m34288a(set, str)) {
                            hashSet.add(str);
                        }
                    }
                    return hashSet;
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }

    /* renamed from: a */
    public JSONObject m34291a() {
        return this.f24549a;
    }
}

package com.qq.e.comm.plugin.g0.l0.f;

import com.qq.e.comm.plugin.b.g;
import com.qq.e.comm.plugin.util.d1;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
class e extends a {
    public e(String str, g gVar) {
        super(str, gVar);
    }

    @Override // com.qq.e.comm.plugin.g0.l0.f.b
    public int a() {
        int size = this.f43689a.size();
        if (size <= 0) {
            return this.f43695g;
        }
        return this.f43695g % size;
    }

    @Override // com.qq.e.comm.plugin.g0.l0.f.b
    public void b(JSONObject jSONObject) {
        this.f43689a.add(a(), jSONObject);
    }

    @Override // com.qq.e.comm.plugin.g0.l0.f.a
    public JSONObject d() {
        d1.a(a.f43688i, "next, \u5f00\u59cb\u53d6\u6570\u636e");
        JSONObject jSONObject = this.f43690b;
        JSONObject jSONObject2 = null;
        if (jSONObject != null) {
            this.f43690b = null;
            if (d(jSONObject)) {
                return jSONObject;
            }
        }
        boolean z3 = false;
        while (true) {
            if (this.f43689a.isEmpty()) {
                break;
            }
            JSONObject jSONObject3 = this.f43689a.get(a());
            if (d(jSONObject3)) {
                d1.a(a.f43688i, "next, \u5f53\u524d\u6570\u636e\u6709\u6548");
                this.f43695g++;
                jSONObject2 = jSONObject3;
                break;
            }
            z3 |= this.f43689a.remove(jSONObject3);
            d1.a(a.f43688i, "next, \u5f53\u524d\u6570\u636e\u65e0\u6548");
        }
        if (z3) {
            d1.a(a.f43688i, "\u83b7\u53d6\u6570\u636e\u65f6\u53d1\u73b0\u8fc7\u671f\u6570\u636e, \u66f4\u65b0\u672c\u5730\u6587\u4ef6");
            c();
        }
        String str = a.f43688i;
        Object[] objArr = new Object[1];
        objArr[0] = jSONObject2 == null ? "null" : "\u4e0d\u4e3a\u7a7a";
        d1.a(str, "next, \u8fd4\u56de\u6570\u636e%s", objArr);
        return jSONObject2;
    }

    @Override // com.qq.e.comm.plugin.g0.l0.f.a
    protected boolean e(JSONObject jSONObject) {
        int indexOf = this.f43689a.indexOf(jSONObject);
        int a4 = a();
        boolean remove = this.f43689a.remove(jSONObject);
        if (remove) {
            if (indexOf < a4) {
                this.f43695g--;
            }
            if (this.f43689a.isEmpty()) {
                this.f43695g = 0;
            }
        }
        return remove;
    }
}

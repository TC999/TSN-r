package com.qq.e.comm.plugin.util.u2;

import android.util.Pair;
import com.qq.e.comm.plugin.n0.v;
import com.qq.e.comm.plugin.util.d1;
import com.qq.e.comm.plugin.util.j0;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
class d extends b {
    public d(boolean z3) {
        super(z3);
    }

    @Override // com.qq.e.comm.plugin.util.u2.b
    protected int a() {
        return 1130012;
    }

    @Override // com.qq.e.comm.plugin.util.u2.b
    protected Map<String, Integer> b() {
        HashMap hashMap = new HashMap();
        JSONObject a4 = new j0(com.qq.e.comm.plugin.d0.a.d().f().c("mcNewImpPackNa")).a();
        if (a4.length() > 0) {
            Iterator<String> keys = a4.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                try {
                    int parseInt = Integer.parseInt(next);
                    JSONArray jSONArray = a4.getJSONArray(next);
                    int length = jSONArray.length();
                    for (int i4 = 0; i4 < length; i4++) {
                        String string = jSONArray.getString(i4);
                        int i5 = (parseInt * 100) + i4;
                        hashMap.put(string, Integer.valueOf(i5));
                        String str = this.f46623d;
                        d1.a(str, "doCheckImportantPkg: " + string + ", index: " + i5);
                    }
                } catch (Exception e4) {
                    d1.a(this.f46623d, "parse msdk index error", e4);
                }
            }
        }
        return hashMap;
    }

    int b(String str) {
        Pair<String, Integer> a4 = a(str);
        if (a4 != null) {
            v.a(1130040, null, 0, new com.qq.e.comm.plugin.n0.d().a("package", a4.first).a("trace", str));
            return ((Integer) a4.second).intValue();
        }
        return -1;
    }
}

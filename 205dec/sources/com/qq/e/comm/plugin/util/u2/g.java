package com.qq.e.comm.plugin.util.u2;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
class g extends b {
    public g(boolean z3) {
        super(z3);
    }

    @Override // com.qq.e.comm.plugin.util.u2.b
    protected int a() {
        return 1130004;
    }

    @Override // com.qq.e.comm.plugin.util.u2.b
    protected Map<String, Integer> b() {
        HashMap hashMap = new HashMap();
        String c4 = com.qq.e.comm.plugin.d0.a.d().f().c("mcPackNa");
        String[] split = !TextUtils.isEmpty(c4) ? c4.split(",") : null;
        if (split != null && split.length > 0) {
            int i4 = 0;
            for (String str : split) {
                hashMap.put(str, Integer.valueOf(i4));
                i4++;
            }
        }
        return hashMap;
    }
}

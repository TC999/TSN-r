package com.qq.e.comm.plugin.fs.d.d;

import com.qq.e.comm.plugin.b.g;
import com.qq.e.comm.plugin.util.d1;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class b {
    public static a a(com.qq.e.comm.plugin.g0.e eVar) {
        g o4 = eVar.o();
        if (o4.j()) {
            if (eVar.i0() != null && eVar.i0().y()) {
                return new e(eVar);
            }
            return new d(eVar);
        } else if (o4.g()) {
            return new c(eVar);
        } else {
            d1.b("FSBizFactory", "\u5168\u5c4f\u914d\u7f6e\u53c2\u6570\u751f\u6210\u5931\u8d25\uff0c\u5e7f\u544a\u7c7b\u578b\u9519\u8bef\uff01");
            return null;
        }
    }
}

package com.bytedance.msdk.f.sr;

import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.Bridge;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class w {

    /* renamed from: c  reason: collision with root package name */
    private static Bridge f28358c;

    public static void c(Bridge bridge) {
        f28358c = bridge;
    }

    private static void w(com.bytedance.msdk.xv.c cVar, boolean z3) {
        if (f28358c != null) {
            b a4 = b.a();
            if (z3) {
                a4.i(20003, cVar.xv());
                f28358c.call(10002, a4.l(), Void.class);
                return;
            }
            a4.i(20002, cVar.xv());
            f28358c.call(10002, a4.l(), Void.class);
        }
    }

    public static void c(com.bytedance.msdk.xv.c cVar, boolean z3) {
        if (cVar != null && com.bytedance.msdk.core.w.k().n()) {
            w(cVar, z3);
        }
    }

    public static void c(com.bytedance.msdk.xv.xv.c cVar, boolean z3) {
        if (cVar != null && com.bytedance.msdk.core.w.k().n()) {
            w(cVar, z3);
        }
    }

    private static void w(com.bytedance.msdk.xv.xv.c cVar, boolean z3) {
        if (f28358c != null) {
            b a4 = b.a();
            if (z3) {
                a4.i(20003, cVar.c());
                f28358c.call(10002, a4.l(), Void.class);
                return;
            }
            a4.i(20002, cVar.c());
            f28358c.call(10002, a4.l(), Void.class);
        }
    }
}

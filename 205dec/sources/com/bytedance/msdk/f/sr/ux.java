package com.bytedance.msdk.f.sr;

import com.bykv.vk.openvk.api.proto.Bridge;
import java.io.PrintStream;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ux {
    public static void c(com.bytedance.sdk.gromore.c.w.c cVar) {
        Map map;
        Boolean bool;
        if (cVar == null) {
            return;
        }
        Bridge n4 = cVar.n();
        if (n4 != null && (bool = (Boolean) n4.call(10001, null, Boolean.class)) != null) {
            c.c(bool.booleanValue());
        }
        Bridge z3 = cVar.z();
        if (z3 != null && (map = (Map) z3.call(10003, null, Map.class)) != null) {
            PrintStream printStream = System.out;
            printStream.println("onetap " + map.toString());
            xv.c(map);
        }
        w.c(cVar.ck());
        sr.c(cVar.ba());
    }
}

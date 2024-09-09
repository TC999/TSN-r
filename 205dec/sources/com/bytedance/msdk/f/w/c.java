package com.bytedance.msdk.f.w;

import com.bytedance.msdk.core.k.w;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c {
    public static boolean c(w wVar) {
        if (wVar == null) {
            return false;
        }
        int yu = wVar.yu();
        Map<String, Integer> mt = com.bytedance.msdk.core.c.w().mt();
        if (mt == null) {
            return false;
        }
        Integer num = mt.get(String.valueOf(yu));
        if (num != null) {
            return num.intValue() == 1;
        }
        Integer num2 = mt.get("-1");
        return num2 != null && num2.intValue() == 1;
    }

    public static boolean w(w wVar) {
        if (wVar == null) {
            return false;
        }
        int yu = wVar.yu();
        Map<String, Integer> oo = com.bytedance.msdk.core.c.w().oo();
        if (oo == null) {
            return false;
        }
        Integer num = oo.get(String.valueOf(yu));
        if (num != null) {
            return num.intValue() == 1;
        }
        Integer num2 = oo.get("-1");
        return num2 != null && num2.intValue() == 1;
    }
}

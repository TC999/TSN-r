package com.bytedance.msdk.core.ia;

import android.text.TextUtils;
import com.bytedance.msdk.core.k.p;
import com.bytedance.msdk.core.k.w;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c {
    public static w c(w wVar, String str) {
        if (wVar == null || TextUtils.isEmpty(str) || wVar.up() == null || wVar.up().size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<p> it = wVar.up().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            p next = it.next();
            if (str.equals(next.ia())) {
                arrayList.add(next.sr());
                break;
            }
        }
        if (arrayList.size() == 0) {
            return null;
        }
        p pVar = arrayList.get(0);
        if (pVar != null && pVar.ba() && !"pangle".equals(pVar.t())) {
            Iterator<p> it2 = wVar.up().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                p next2 = it2.next();
                if (next2.ba() && "pangle".equals(next2.t())) {
                    arrayList.add(next2.sr());
                    break;
                }
            }
        }
        w ys = wVar.ys();
        if (ys.k()) {
            ys.w(arrayList);
        } else {
            ys.c(arrayList);
        }
        p pVar2 = arrayList.get(0);
        pVar2.sr(0);
        if (pVar2.s() == 0) {
            ys.sr(pVar2.q());
        }
        if (pVar2.s() == 2) {
            ys.c(true);
        }
        if (pVar2.s() == 1 || pVar2.s() == 3) {
            ys.w(true);
        }
        ys.a(0);
        return ys;
    }

    public static String c(String str) {
        try {
            if (!TextUtils.isEmpty(str) && str.startsWith("gm_test_slot_")) {
                return str.substring(13);
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }
}

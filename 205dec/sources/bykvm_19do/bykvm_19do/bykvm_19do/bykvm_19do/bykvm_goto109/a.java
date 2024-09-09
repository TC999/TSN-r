package bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_goto109;

import android.text.TextUtils;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.c;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.h;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: TTTestToolUtil.java */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class a {
    public static c a(c cVar, String str) {
        if (cVar == null || TextUtils.isEmpty(str) || cVar.s() == null || cVar.s().size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<h> it = cVar.s().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            h next = it.next();
            if (str.equals(next.c())) {
                arrayList.add(next.a());
                break;
            }
        }
        if (arrayList.size() == 0) {
            return null;
        }
        c a4 = cVar.a();
        a4.a(arrayList);
        h hVar = arrayList.get(0);
        hVar.e(0);
        if (hVar.e() == 0) {
            a4.a(hVar.f());
        }
        if (hVar.e() == 1 || hVar.e() == 2) {
            a4.a(true);
            a4.a(hVar.e());
        }
        a4.e(0);
        return a4;
    }
}

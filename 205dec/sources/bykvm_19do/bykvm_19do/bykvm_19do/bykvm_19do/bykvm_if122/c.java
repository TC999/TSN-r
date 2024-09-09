package bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122;

import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.h;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.y;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: BiddingUtil.java */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class c {
    public static Map<Integer, List<h>> a(List<h> list) {
        int i4;
        List list2;
        if (list == null || list.size() == 0) {
            return null;
        }
        y.a(list);
        HashMap hashMap = new HashMap();
        int i5 = -1000;
        for (int i6 = 0; i6 < list.size(); i6++) {
            h hVar = list.get(i6);
            if (hVar != null) {
                if (hVar.l() != i5) {
                    list2 = new ArrayList();
                    i4 = hVar.l();
                } else {
                    i4 = i5;
                    list2 = (List) hashMap.get(Integer.valueOf(i5));
                }
                if (list2 != null) {
                    list2.add(hVar);
                    hashMap.put(Integer.valueOf(i4), list2);
                }
                i5 = i4;
            }
        }
        return hashMap;
    }
}

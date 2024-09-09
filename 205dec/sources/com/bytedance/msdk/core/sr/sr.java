package com.bytedance.msdk.core.sr;

import com.bytedance.msdk.core.k.p;
import com.bytedance.msdk.f.bw;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class sr {
    public static Map<Integer, List<p>> c(List<p> list) {
        int i4;
        List list2;
        if (list == null || list.size() == 0) {
            return null;
        }
        bw.c(list);
        HashMap hashMap = new HashMap();
        int i5 = -1000;
        for (int i6 = 0; i6 < list.size(); i6++) {
            p pVar = list.get(i6);
            if (pVar != null) {
                if (pVar.j() != i5) {
                    list2 = new ArrayList();
                    i4 = pVar.j();
                } else {
                    i4 = i5;
                    list2 = (List) hashMap.get(Integer.valueOf(i5));
                }
                if (list2 != null) {
                    list2.add(pVar);
                    hashMap.put(Integer.valueOf(i4), list2);
                }
                i5 = i4;
            }
        }
        return hashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v7, types: [java.util.List] */
    public static Map<Integer, List<p>> w(List<p> list) {
        ArrayList arrayList;
        int ls;
        if (list == null || list.size() == 0) {
            return null;
        }
        bw.c(list);
        HashMap hashMap = new HashMap();
        int i4 = -1000;
        for (int i5 = 0; i5 < list.size(); i5++) {
            p pVar = list.get(i5);
            if (pVar != null) {
                if (pVar.s() != 100 && pVar.s() != 0) {
                    if (pVar.j() != i4) {
                        arrayList = new ArrayList();
                        ls = pVar.j();
                    } else {
                        ls = i4;
                        arrayList = (List) hashMap.get(Integer.valueOf(i4));
                    }
                } else {
                    arrayList = new ArrayList();
                    ls = pVar.ls();
                }
                if (arrayList != null) {
                    arrayList.add(pVar);
                    hashMap.put(Integer.valueOf(ls), arrayList);
                }
                i4 = ls;
            }
        }
        return hashMap;
    }
}

package com.qq.e.comm.plugin.e0.d;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class b {

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    static class a implements Comparator<com.qq.e.comm.plugin.e0.e.d> {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(com.qq.e.comm.plugin.e0.e.d dVar, com.qq.e.comm.plugin.e0.e.d dVar2) {
            return dVar2.q() - dVar.q();
        }
    }

    public static List<com.qq.e.comm.plugin.e0.e.d> a(List<com.qq.e.comm.plugin.e0.e.d> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list);
        Collections.sort(arrayList, new a());
        return arrayList;
    }
}

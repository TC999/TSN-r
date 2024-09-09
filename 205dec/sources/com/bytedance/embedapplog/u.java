package com.bytedance.embedapplog;

import java.util.LinkedList;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class u {

    /* renamed from: c  reason: collision with root package name */
    private static final LinkedList<up> f26806c = new LinkedList<>();

    /* renamed from: w  reason: collision with root package name */
    private static final LinkedList<up> f26807w = new LinkedList<>();

    public static void c(up upVar) {
        LinkedList<up> linkedList = f26806c;
        synchronized (linkedList) {
            if (linkedList.size() > 200) {
                be.w("drop event in cache", null);
                f26807w.add(linkedList.poll());
            }
            linkedList.add(upVar);
        }
    }

    public static void c() {
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        LinkedList<up> linkedList3 = f26806c;
        synchronized (linkedList3) {
            linkedList.addAll(linkedList3);
            LinkedList<up> linkedList4 = f26807w;
            linkedList2.addAll(linkedList4);
            linkedList3.clear();
            linkedList4.clear();
        }
        while (!linkedList.isEmpty()) {
            ys.c((up) linkedList.poll());
        }
    }
}

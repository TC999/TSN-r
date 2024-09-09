package com.bumptech.glide.repackaged.com.google.common.collect;

import java.util.Iterator;
import java.util.Set;

/* compiled from: Sets.java */
/* loaded from: E:\TSN-r\205dec\4499832.dex */
public final class b0 {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(Set<?> set, Object obj) {
        if (set == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set2 = (Set) obj;
            try {
                if (set.size() == set2.size()) {
                    if (set.containsAll(set2)) {
                        return true;
                    }
                }
                return false;
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(Set<?> set) {
        Iterator<?> it = set.iterator();
        int i4 = 0;
        while (it.hasNext()) {
            Object next = it.next();
            i4 = ((i4 + (next != null ? next.hashCode() : 0)) ^ (-1)) ^ (-1);
        }
        return i4;
    }
}

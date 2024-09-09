package com.bxkj.base.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: RandomUtils.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class w {
    public static List<Integer> a(int i4, int i5) {
        Random random = new Random();
        HashSet hashSet = new HashSet();
        while (hashSet.size() < i5) {
            hashSet.add(Integer.valueOf(random.nextInt(i4) + 1));
        }
        com.orhanobut.logger.j.c("\u968f\u673a\u8f93\u5165\u7684\u5341\u4e2a\u6570\uff1a" + hashSet);
        ArrayList arrayList = new ArrayList(hashSet);
        Collections.sort(arrayList);
        com.orhanobut.logger.j.c("\u6392\u597d\u5e8f\u4e4b\u540e\u7684\u5217\u8868\uff1a" + arrayList);
        return arrayList;
    }
}

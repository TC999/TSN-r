package com.bxkj.base.util;

import com.orhanobut.logger.C11792j;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

/* compiled from: RandomUtils.java */
/* renamed from: com.bxkj.base.util.w */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class C3916w {
    /* renamed from: a */
    public static List<Integer> m44020a(int i, int i2) {
        Random random = new Random();
        HashSet hashSet = new HashSet();
        while (hashSet.size() < i2) {
            hashSet.add(Integer.valueOf(random.nextInt(i) + 1));
        }
        C11792j.m20470c("随机输入的十个数：" + hashSet);
        ArrayList arrayList = new ArrayList(hashSet);
        Collections.sort(arrayList);
        C11792j.m20470c("排好序之后的列表：" + arrayList);
        return arrayList;
    }
}

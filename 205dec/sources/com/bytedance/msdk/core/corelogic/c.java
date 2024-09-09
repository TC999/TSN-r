package com.bytedance.msdk.core.corelogic;

import java.util.List;

/* compiled from: SortAlgorithm.java */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class c {
    public static void a(List<Integer> list) {
        if (list != null) {
            if (list.size() <= 1) {
                return;
            }
            int size = list.size();
            int[] iArr = new int[size];
            for (int i4 = 0; i4 < size; i4++) {
                iArr[i4] = list.get(i4).intValue();
            }
            for (int i5 = 1; i5 < size; i5++) {
                int i6 = iArr[i5];
                int i7 = i5;
                while (i7 > 0) {
                    int i8 = i7 - 1;
                    if (iArr[i8] > i6) {
                        iArr[i7] = iArr[i8];
                        i7--;
                    }
                }
                iArr[i7] = i6;
            }
            list.clear();
            for (int i9 = 0; i9 < size; i9++) {
                list.add(Integer.valueOf(iArr[i9]));
            }
        }
    }
}

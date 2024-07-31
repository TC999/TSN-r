package com.bytedance.msdk.core.corelogic;

import java.util.List;

/* renamed from: com.bytedance.msdk.core.corelogic.c */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class SortAlgorithm {
    /* renamed from: a */
    public static void m37364a(List<Integer> list) {
        if (list != null) {
            if (list.size() <= 1) {
                return;
            }
            int size = list.size();
            int[] iArr = new int[size];
            for (int i = 0; i < size; i++) {
                iArr[i] = list.get(i).intValue();
            }
            for (int i2 = 1; i2 < size; i2++) {
                int i3 = iArr[i2];
                int i4 = i2;
                while (i4 > 0) {
                    int i5 = i4 - 1;
                    if (iArr[i5] > i3) {
                        iArr[i4] = iArr[i5];
                        i4--;
                    }
                }
                iArr[i4] = i3;
            }
            list.clear();
            for (int i6 = 0; i6 < size; i6++) {
                list.add(Integer.valueOf(iArr[i6]));
            }
        }
    }
}

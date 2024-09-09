package com.bytedance.msdk.f;

import androidx.annotation.NonNull;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class bw {
    public static <T> void c(List<T> list, @NonNull Comparator<T> comparator) {
        if (list == null || list.size() <= 1) {
            return;
        }
        try {
            Collections.sort(list, comparator);
        } catch (Throwable unused) {
            List asList = Arrays.asList(list.toArray());
            Collections.sort(asList, comparator);
            list.clear();
            list.addAll(asList);
        }
    }

    public static <T extends Comparable<? super T>> void c(List<T> list) {
        if (list == null || list.size() <= 1) {
            return;
        }
        try {
            Collections.sort(list);
        } catch (Throwable unused) {
            List asList = Arrays.asList(list.toArray());
            Collections.sort(asList);
            list.clear();
            list.addAll(asList);
        }
    }
}

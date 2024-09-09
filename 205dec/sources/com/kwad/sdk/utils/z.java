package com.kwad.sdk.utils;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class z {
    @NonNull
    public static <T> List<List<T>> d(List<T> list, int i4) {
        ArrayList arrayList = new ArrayList();
        if (list == null) {
            return arrayList;
        }
        int i5 = 0;
        while (i5 < list.size()) {
            int i6 = i5 + 200;
            arrayList.add(list.subList(i5, i6 > list.size() ? list.size() : i6));
            i5 = i6;
        }
        return arrayList;
    }
}

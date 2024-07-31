package com.kwad.sdk.utils;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.kwad.sdk.utils.z */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C11139z {
    @NonNull
    /* renamed from: d */
    public static <T> List<List<T>> m23566d(List<T> list, int i) {
        ArrayList arrayList = new ArrayList();
        if (list == null) {
            return arrayList;
        }
        int i2 = 0;
        while (i2 < list.size()) {
            int i3 = i2 + 200;
            arrayList.add(list.subList(i2, i3 > list.size() ? list.size() : i3));
            i2 = i3;
        }
        return arrayList;
    }
}

package bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1;

import androidx.annotation.NonNull;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* compiled from: TTSortUtil.java */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class y {
    public static <T> void a(List<T> list, @NonNull Comparator<T> comparator) {
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

    public static <T extends Comparable<? super T>> void a(List<T> list) {
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

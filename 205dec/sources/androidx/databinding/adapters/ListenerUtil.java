package androidx.databinding.adapters;

import android.util.SparseArray;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class ListenerUtil {
    private static final SparseArray<WeakHashMap<View, WeakReference<?>>> sListeners = new SparseArray<>();

    public static <T> T getListener(View view, int i4) {
        return (T) view.getTag(i4);
    }

    public static <T> T trackListener(View view, T t3, int i4) {
        T t4 = (T) view.getTag(i4);
        view.setTag(i4, t3);
        return t4;
    }
}

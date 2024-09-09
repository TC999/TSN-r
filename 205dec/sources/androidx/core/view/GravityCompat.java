package androidx.core.view;

import android.graphics.Rect;
import android.view.Gravity;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public final class GravityCompat {
    public static final int END = 8388613;
    public static final int RELATIVE_HORIZONTAL_GRAVITY_MASK = 8388615;
    public static final int RELATIVE_LAYOUT_DIRECTION = 8388608;
    public static final int START = 8388611;

    private GravityCompat() {
    }

    public static void apply(int i4, int i5, int i6, Rect rect, Rect rect2, int i7) {
        Gravity.apply(i4, i5, i6, rect, rect2, i7);
    }

    public static void applyDisplay(int i4, Rect rect, Rect rect2, int i5) {
        Gravity.applyDisplay(i4, rect, rect2, i5);
    }

    public static int getAbsoluteGravity(int i4, int i5) {
        return Gravity.getAbsoluteGravity(i4, i5);
    }

    public static void apply(int i4, int i5, int i6, Rect rect, int i7, int i8, Rect rect2, int i9) {
        Gravity.apply(i4, i5, i6, rect, i7, i8, rect2, i9);
    }
}

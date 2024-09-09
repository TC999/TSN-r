package androidx.core.view;

import androidx.annotation.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public interface NestedScrollingChild {
    boolean dispatchNestedFling(float f4, float f5, boolean z3);

    boolean dispatchNestedPreFling(float f4, float f5);

    boolean dispatchNestedPreScroll(int i4, int i5, @Nullable int[] iArr, @Nullable int[] iArr2);

    boolean dispatchNestedScroll(int i4, int i5, int i6, int i7, @Nullable int[] iArr);

    boolean hasNestedScrollingParent();

    boolean isNestedScrollingEnabled();

    void setNestedScrollingEnabled(boolean z3);

    boolean startNestedScroll(int i4);

    void stopNestedScroll();
}

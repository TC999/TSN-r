package androidx.core.view;

import androidx.annotation.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public interface NestedScrollingChild2 extends NestedScrollingChild {
    boolean dispatchNestedPreScroll(int i4, int i5, @Nullable int[] iArr, @Nullable int[] iArr2, int i6);

    boolean dispatchNestedScroll(int i4, int i5, int i6, int i7, @Nullable int[] iArr, int i8);

    boolean hasNestedScrollingParent(int i4);

    boolean startNestedScroll(int i4, int i5);

    void stopNestedScroll(int i4);
}

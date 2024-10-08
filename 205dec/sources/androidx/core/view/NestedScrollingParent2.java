package androidx.core.view;

import android.view.View;
import androidx.annotation.NonNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public interface NestedScrollingParent2 extends NestedScrollingParent {
    void onNestedPreScroll(@NonNull View view, int i4, int i5, @NonNull int[] iArr, int i6);

    void onNestedScroll(@NonNull View view, int i4, int i5, int i6, int i7, int i8);

    void onNestedScrollAccepted(@NonNull View view, @NonNull View view2, int i4, int i5);

    boolean onStartNestedScroll(@NonNull View view, @NonNull View view2, int i4, int i5);

    void onStopNestedScroll(@NonNull View view, int i4);
}

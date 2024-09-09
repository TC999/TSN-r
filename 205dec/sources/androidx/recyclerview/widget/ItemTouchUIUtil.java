package androidx.recyclerview.widget;

import android.graphics.Canvas;
import android.view.View;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public interface ItemTouchUIUtil {
    void clearView(View view);

    void onDraw(Canvas canvas, RecyclerView recyclerView, View view, float f4, float f5, int i4, boolean z3);

    void onDrawOver(Canvas canvas, RecyclerView recyclerView, View view, float f4, float f5, int i4, boolean z3);

    void onSelected(View view);
}

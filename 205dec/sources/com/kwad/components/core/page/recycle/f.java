package com.kwad.components.core.page.recycle;

import android.view.View;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.kwad.sdk.utils.ap;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class f {
    final RecyclerView PU;
    final RecyclerView.LayoutManager PV;

    private f(RecyclerView recyclerView) {
        this.PU = recyclerView;
        this.PV = recyclerView.getLayoutManager();
    }

    private View a(int i4, int i5, boolean z3, boolean z4) {
        OrientationHelper createHorizontalHelper;
        if (this.PV.canScrollVertically()) {
            createHorizontalHelper = OrientationHelper.createVerticalHelper(this.PV);
        } else {
            createHorizontalHelper = OrientationHelper.createHorizontalHelper(this.PV);
        }
        int startAfterPadding = createHorizontalHelper.getStartAfterPadding();
        int endAfterPadding = createHorizontalHelper.getEndAfterPadding();
        int i6 = i5 > i4 ? 1 : -1;
        while (i4 != i5) {
            View childAt = this.PV.getChildAt(i4);
            int decoratedStart = createHorizontalHelper.getDecoratedStart(childAt);
            int decoratedEnd = createHorizontalHelper.getDecoratedEnd(childAt);
            if (decoratedStart < endAfterPadding && decoratedEnd > startAfterPadding) {
                return childAt;
            }
            i4 += i6;
        }
        return null;
    }

    public static f b(RecyclerView recyclerView) {
        ap.checkNotNull(recyclerView);
        return new f(recyclerView);
    }

    public final int findFirstVisibleItemPosition() {
        View a4 = a(0, this.PV.getChildCount(), false, true);
        if (a4 == null) {
            return -1;
        }
        return this.PU.getChildAdapterPosition(a4);
    }

    public final int findLastVisibleItemPosition() {
        View a4 = a(this.PV.getChildCount() - 1, -1, false, true);
        if (a4 == null) {
            return -1;
        }
        return this.PU.getChildAdapterPosition(a4);
    }
}

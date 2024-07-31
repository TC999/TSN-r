package com.kwad.components.core.page.recycle;

import android.view.View;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.kwad.sdk.utils.C11023ap;

/* renamed from: com.kwad.components.core.page.recycle.f */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8851f {

    /* renamed from: PU */
    final RecyclerView f28663PU;

    /* renamed from: PV */
    final RecyclerView.LayoutManager f28664PV;

    private C8851f(RecyclerView recyclerView) {
        this.f28663PU = recyclerView;
        this.f28664PV = recyclerView.getLayoutManager();
    }

    /* renamed from: a */
    private View m29739a(int i, int i2, boolean z, boolean z2) {
        OrientationHelper createHorizontalHelper;
        if (this.f28664PV.canScrollVertically()) {
            createHorizontalHelper = OrientationHelper.createVerticalHelper(this.f28664PV);
        } else {
            createHorizontalHelper = OrientationHelper.createHorizontalHelper(this.f28664PV);
        }
        int startAfterPadding = createHorizontalHelper.getStartAfterPadding();
        int endAfterPadding = createHorizontalHelper.getEndAfterPadding();
        int i3 = i2 > i ? 1 : -1;
        while (i != i2) {
            View childAt = this.f28664PV.getChildAt(i);
            int decoratedStart = createHorizontalHelper.getDecoratedStart(childAt);
            int decoratedEnd = createHorizontalHelper.getDecoratedEnd(childAt);
            if (decoratedStart < endAfterPadding && decoratedEnd > startAfterPadding) {
                return childAt;
            }
            i += i3;
        }
        return null;
    }

    /* renamed from: b */
    public static C8851f m29738b(RecyclerView recyclerView) {
        C11023ap.checkNotNull(recyclerView);
        return new C8851f(recyclerView);
    }

    public final int findFirstVisibleItemPosition() {
        View m29739a = m29739a(0, this.f28664PV.getChildCount(), false, true);
        if (m29739a == null) {
            return -1;
        }
        return this.f28663PU.getChildAdapterPosition(m29739a);
    }

    public final int findLastVisibleItemPosition() {
        View m29739a = m29739a(this.f28664PV.getChildCount() - 1, -1, false, true);
        if (m29739a == null) {
            return -1;
        }
        return this.f28663PU.getChildAdapterPosition(m29739a);
    }
}

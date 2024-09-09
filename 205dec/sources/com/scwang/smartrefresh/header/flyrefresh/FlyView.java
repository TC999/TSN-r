package com.scwang.smartrefresh.header.flyrefresh;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.scwang.smartrefresh.layout.internal.pathview.PathsView;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class FlyView extends PathsView {
    public FlyView(Context context) {
        super(context);
        a(context, null, 0);
    }

    private void a(Context context, AttributeSet attributeSet, int i4) {
        b(-1);
        c("M2.01,21L23,12 2.01,3 2,10l15,2 -15,2z");
        setMinimumWidth(com.scwang.smartrefresh.layout.util.c.b(25.0f));
        setMinimumHeight(com.scwang.smartrefresh.layout.util.c.b(25.0f));
    }

    @Override // com.scwang.smartrefresh.layout.internal.pathview.PathsView, android.view.View
    protected void onMeasure(int i4, int i5) {
        setMeasuredDimension(View.resolveSize(getSuggestedMinimumWidth(), i4), View.resolveSize(getSuggestedMinimumHeight(), i5));
    }

    public FlyView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet, 0);
    }

    public FlyView(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        a(context, attributeSet, i4);
    }
}

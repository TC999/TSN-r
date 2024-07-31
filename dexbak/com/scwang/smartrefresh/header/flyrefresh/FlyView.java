package com.scwang.smartrefresh.header.flyrefresh;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.scwang.smartrefresh.layout.internal.pathview.PathsView;
import com.scwang.smartrefresh.layout.util.C11925c;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class FlyView extends PathsView {
    public FlyView(Context context) {
        super(context);
        m20127a(context, null, 0);
    }

    /* renamed from: a */
    private void m20127a(Context context, AttributeSet attributeSet, int i) {
        m19828b(-1);
        m19827c("M2.01,21L23,12 2.01,3 2,10l15,2 -15,2z");
        setMinimumWidth(C11925c.m19766b(25.0f));
        setMinimumHeight(C11925c.m19766b(25.0f));
    }

    @Override // com.scwang.smartrefresh.layout.internal.pathview.PathsView, android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(View.resolveSize(getSuggestedMinimumWidth(), i), View.resolveSize(getSuggestedMinimumHeight(), i2));
    }

    public FlyView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m20127a(context, attributeSet, 0);
    }

    public FlyView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m20127a(context, attributeSet, i);
    }
}

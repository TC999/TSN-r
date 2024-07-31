package com.bxkj.base.p085v2.common.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ListView;

/* renamed from: com.bxkj.base.v2.common.view.ListViewFullHeight */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class ListViewFullHeight extends ListView {
    public ListViewFullHeight(Context context) {
        super(context);
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
    }

    public ListViewFullHeight(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ListViewFullHeight(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}

package com.bxkj.base.v2.common.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ListView;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class ListViewFullHeight extends ListView {
    public ListViewFullHeight(Context context) {
        super(context);
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View
    protected void onMeasure(int i4, int i5) {
        super.onMeasure(i4, View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
    }

    public ListViewFullHeight(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ListViewFullHeight(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
    }
}

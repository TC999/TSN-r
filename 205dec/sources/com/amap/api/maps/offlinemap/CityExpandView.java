package com.amap.api.maps.offlinemap;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class CityExpandView extends ExpandableListView {
    public CityExpandView(Context context) {
        this(context, null);
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View
    protected void onMeasure(int i4, int i5) {
        System.currentTimeMillis();
        super.onMeasure(i4, View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
        System.currentTimeMillis();
    }

    public CityExpandView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, -1);
        setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
    }
}

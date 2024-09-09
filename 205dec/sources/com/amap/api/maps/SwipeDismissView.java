package com.amap.api.maps;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.amap.api.maps.WearMapView;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
@SuppressLint({"ViewConstructor"})
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class SwipeDismissView extends RelativeLayout {
    protected WearMapView.OnDismissCallback onDismissCallback;

    public SwipeDismissView(Context context, View view) {
        super(context);
        this.onDismissCallback = null;
        setOnTouchListener(view);
    }

    public void setCallback(WearMapView.OnDismissCallback onDismissCallback) {
        this.onDismissCallback = onDismissCallback;
    }

    protected void setOnTouchListener(View view) {
        setOnTouchListener(new SwipeDismissTouchListener(view, new Object(), new SwipeDismissCallBack(this)));
    }

    public SwipeDismissView(Context context, AttributeSet attributeSet, View view) {
        super(context, attributeSet);
        this.onDismissCallback = null;
        setOnTouchListener(view);
    }

    public SwipeDismissView(Context context, AttributeSet attributeSet, int i4, View view) {
        super(context, attributeSet, i4);
        this.onDismissCallback = null;
        setOnTouchListener(view);
    }
}

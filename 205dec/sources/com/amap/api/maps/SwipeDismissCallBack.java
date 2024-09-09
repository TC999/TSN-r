package com.amap.api.maps;

import android.view.View;
import com.amap.api.maps.SwipeDismissTouchListener;
import com.amap.api.maps.WearMapView;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class SwipeDismissCallBack implements SwipeDismissTouchListener.DismissCallbacks {

    /* renamed from: a  reason: collision with root package name */
    SwipeDismissView f10720a;

    public SwipeDismissCallBack(SwipeDismissView swipeDismissView) {
        this.f10720a = swipeDismissView;
    }

    @Override // com.amap.api.maps.SwipeDismissTouchListener.DismissCallbacks
    public boolean canDismiss(Object obj) {
        return true;
    }

    @Override // com.amap.api.maps.SwipeDismissTouchListener.DismissCallbacks
    public void onDismiss(View view, Object obj) {
        WearMapView.OnDismissCallback onDismissCallback = this.f10720a.onDismissCallback;
        if (onDismissCallback != null) {
            onDismissCallback.onDismiss();
        }
    }

    @Override // com.amap.api.maps.SwipeDismissTouchListener.DismissCallbacks
    public void onNotifySwipe() {
        WearMapView.OnDismissCallback onDismissCallback = this.f10720a.onDismissCallback;
        if (onDismissCallback != null) {
            onDismissCallback.onNotifySwipe();
        }
    }
}

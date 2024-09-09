package com.amap.api.maps.model;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public interface AMapGestureListener {
    void onDoubleTap(float f4, float f5);

    void onDown(float f4, float f5);

    void onFling(float f4, float f5);

    void onLongPress(float f4, float f5);

    void onMapStable();

    void onScroll(float f4, float f5);

    void onSingleTap(float f4, float f5);

    void onUp(float f4, float f5);
}

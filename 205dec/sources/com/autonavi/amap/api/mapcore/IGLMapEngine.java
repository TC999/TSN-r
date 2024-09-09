package com.autonavi.amap.api.mapcore;

import com.amap.api.maps.AMap;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public interface IGLMapEngine {
    void addGroupAnimation(int i4, int i5, float f4, int i6, int i7, int i8, int i9, AMap.CancelableCallback cancelableCallback);

    IGLMapState getNewMapState(int i4);
}

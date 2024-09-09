package com.amap.api.trace;

import com.amap.api.maps.model.LatLng;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public interface TraceListener {
    void onFinished(int i4, List<LatLng> list, int i5, int i6);

    void onRequestFailed(int i4, String str);

    void onTraceProcessing(int i4, int i5, List<LatLng> list);
}

package com.amap.api.trace;

import com.amap.api.maps.model.LatLng;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public interface TraceStatusListener {
    void onTraceStatus(List<TraceLocation> list, List<LatLng> list2, String str);
}

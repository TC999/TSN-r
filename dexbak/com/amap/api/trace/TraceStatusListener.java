package com.amap.api.trace;

import com.amap.api.maps.model.LatLng;
import java.util.List;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public interface TraceStatusListener {
    void onTraceStatus(List<TraceLocation> list, List<LatLng> list2, String str);
}

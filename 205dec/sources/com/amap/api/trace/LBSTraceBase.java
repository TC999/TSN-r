package com.amap.api.trace;

import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public interface LBSTraceBase {
    void destroy();

    void queryProcessedTrace(int i4, List<TraceLocation> list, int i5, TraceListener traceListener);

    void setLocationInterval(long j4);

    void setTraceStatusInterval(int i4);

    void startTrace(TraceStatusListener traceStatusListener);

    void stopTrace();
}

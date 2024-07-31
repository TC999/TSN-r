package com.amap.api.trace;

import java.util.List;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public interface LBSTraceBase {
    void destroy();

    void queryProcessedTrace(int i, List<TraceLocation> list, int i2, TraceListener traceListener);

    void setLocationInterval(long j);

    void setTraceStatusInterval(int i);

    void startTrace(TraceStatusListener traceStatusListener);

    void stopTrace();
}

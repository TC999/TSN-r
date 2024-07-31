package com.amap.api.trace;

import android.content.Context;
import com.amap.api.col.p0463l.C1732a3;
import com.amap.api.col.p0463l.Privacy;
import com.amap.api.col.p0463l.PrivacyError;
import com.amap.api.col.p0463l.TraceManager;
import com.stub.StubApp;
import java.util.List;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class LBSTraceClient {
    public static final String LOCATE_TIMEOUT_ERROR = "定位超时";
    public static final String MIN_GRASP_POINT_ERROR = "轨迹点太少或距离太近,轨迹纠偏失败";
    public static final String TRACE_SUCCESS = "纠偏成功";
    public static final int TYPE_AMAP = 1;
    public static final int TYPE_BAIDU = 3;
    public static final int TYPE_GPS = 2;

    /* renamed from: a */
    private static LBSTraceBase f7963a;

    /* renamed from: b */
    private static volatile LBSTraceClient f7964b;

    public LBSTraceClient(Context context) throws Exception {
        m51740a(context);
    }

    /* renamed from: a */
    private static void m51740a(Context context) throws Exception {
        PrivacyError m54995a = Privacy.m54995a(context, C1732a3.m55691s());
        if (m54995a.f4676a != Privacy.EnumC1812c.SuccessCode) {
            throw new Exception(m54995a.f4677b);
        }
        if (context != null) {
            f7963a = new TraceManager(StubApp.getOrigApplicationContext(context.getApplicationContext()));
        }
    }

    public static LBSTraceClient getInstance(Context context) throws Exception {
        if (f7964b == null) {
            synchronized (LBSTraceClient.class) {
                if (f7964b == null) {
                    m51740a(context);
                    f7964b = new LBSTraceClient();
                }
            }
        }
        return f7964b;
    }

    public void destroy() {
        LBSTraceBase lBSTraceBase = f7963a;
        if (lBSTraceBase != null) {
            lBSTraceBase.destroy();
            m51741a();
        }
    }

    public void queryProcessedTrace(int i, List<TraceLocation> list, int i2, TraceListener traceListener) {
        LBSTraceBase lBSTraceBase = f7963a;
        if (lBSTraceBase != null) {
            lBSTraceBase.queryProcessedTrace(i, list, i2, traceListener);
        }
    }

    public void startTrace(TraceStatusListener traceStatusListener) {
        LBSTraceBase lBSTraceBase = f7963a;
        if (lBSTraceBase != null) {
            lBSTraceBase.startTrace(traceStatusListener);
        }
    }

    public void stopTrace() {
        LBSTraceBase lBSTraceBase = f7963a;
        if (lBSTraceBase != null) {
            lBSTraceBase.stopTrace();
        }
    }

    private LBSTraceClient() {
    }

    /* renamed from: a */
    private static void m51741a() {
        f7963a = null;
        f7964b = null;
    }
}

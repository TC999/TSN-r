package com.amap.api.trace;

import android.content.Context;
import com.amap.api.col.p0003l.a3;
import com.amap.api.col.p0003l.b4;
import com.amap.api.col.p0003l.ft;
import com.amap.api.col.p0003l.n4;
import com.stub.StubApp;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class LBSTraceClient {
    public static final String LOCATE_TIMEOUT_ERROR = "\u5b9a\u4f4d\u8d85\u65f6";
    public static final String MIN_GRASP_POINT_ERROR = "\u8f68\u8ff9\u70b9\u592a\u5c11\u6216\u8ddd\u79bb\u592a\u8fd1,\u8f68\u8ff9\u7ea0\u504f\u5931\u8d25";
    public static final String TRACE_SUCCESS = "\u7ea0\u504f\u6210\u529f";
    public static final int TYPE_AMAP = 1;
    public static final int TYPE_BAIDU = 3;
    public static final int TYPE_GPS = 2;

    /* renamed from: a  reason: collision with root package name */
    private static LBSTraceBase f11657a;

    /* renamed from: b  reason: collision with root package name */
    private static volatile LBSTraceClient f11658b;

    public LBSTraceClient(Context context) throws Exception {
        a(context);
    }

    private static void a(Context context) throws Exception {
        n4 a4 = ft.a(context, a3.s());
        if (a4.f8385a != ft.c.SuccessCode) {
            throw new Exception(a4.f8386b);
        }
        if (context != null) {
            f11657a = new b4(StubApp.getOrigApplicationContext(context.getApplicationContext()));
        }
    }

    public static LBSTraceClient getInstance(Context context) throws Exception {
        if (f11658b == null) {
            synchronized (LBSTraceClient.class) {
                if (f11658b == null) {
                    a(context);
                    f11658b = new LBSTraceClient();
                }
            }
        }
        return f11658b;
    }

    public void destroy() {
        LBSTraceBase lBSTraceBase = f11657a;
        if (lBSTraceBase != null) {
            lBSTraceBase.destroy();
            a();
        }
    }

    public void queryProcessedTrace(int i4, List<TraceLocation> list, int i5, TraceListener traceListener) {
        LBSTraceBase lBSTraceBase = f11657a;
        if (lBSTraceBase != null) {
            lBSTraceBase.queryProcessedTrace(i4, list, i5, traceListener);
        }
    }

    public void startTrace(TraceStatusListener traceStatusListener) {
        LBSTraceBase lBSTraceBase = f11657a;
        if (lBSTraceBase != null) {
            lBSTraceBase.startTrace(traceStatusListener);
        }
    }

    public void stopTrace() {
        LBSTraceBase lBSTraceBase = f11657a;
        if (lBSTraceBase != null) {
            lBSTraceBase.stopTrace();
        }
    }

    private LBSTraceClient() {
    }

    private static void a() {
        f11657a = null;
        f11658b = null;
    }
}

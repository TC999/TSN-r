package com.amap.api.col.p0463l;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.amap.api.maps.CoordinateConverter;
import com.amap.api.maps.LocationSource;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.MyLocationStyle;
import com.amap.api.trace.LBSTraceBase;
import com.amap.api.trace.LBSTraceClient;
import com.amap.api.trace.TraceListener;
import com.amap.api.trace.TraceLocation;
import com.amap.api.trace.TraceStatusListener;
import com.github.mikephil.charting.utils.Utils;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/* renamed from: com.amap.api.col.3l.b4 */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class TraceManager implements LocationSource.OnLocationChangedListener, LBSTraceBase {

    /* renamed from: a */
    private Context f3650a;

    /* renamed from: b */
    private CoordinateConverter f3651b;

    /* renamed from: c */
    private ThreadPool f3652c;

    /* renamed from: d */
    private ThreadPool f3653d;

    /* renamed from: g */
    private TraceStatusListener f3656g;

    /* renamed from: h */
    private AMapReflectionLocationSource f3657h;

    /* renamed from: m */
    private HandlerC1752c f3662m;

    /* renamed from: e */
    private long f3654e = 2000;

    /* renamed from: f */
    private int f3655f = 5;

    /* renamed from: i */
    private List<TraceLocation> f3658i = new ArrayList();

    /* renamed from: j */
    private int f3659j = 0;

    /* renamed from: k */
    private int f3660k = 0;

    /* renamed from: l */
    private long f3661l = 0;

    /* renamed from: n */
    private TraceLocation f3663n = null;

    /* renamed from: o */
    private List<LatLng> f3664o = new ArrayList();

    /* renamed from: p */
    private List<LatLng> f3665p = new ArrayList();

    /* renamed from: q */
    private List<LatLng> f3666q = new ArrayList();

    /* renamed from: r */
    int f3667r = Runtime.getRuntime().availableProcessors();

    /* renamed from: s */
    private BlockingQueue<Runnable> f3668s = new LinkedBlockingQueue();

    /* renamed from: t */
    private BlockingQueue<Runnable> f3669t = new LinkedBlockingQueue();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TraceManager.java */
    /* renamed from: com.amap.api.col.3l.b4$a */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public class C1749a extends ThreadTask {

        /* renamed from: b */
        private int f3671b;

        /* renamed from: c */
        private int f3672c;

        /* renamed from: d */
        private List<TraceLocation> f3673d;

        /* renamed from: g */
        private TraceListener f3675g;

        /* renamed from: a */
        private List<TraceLocation> f3670a = new ArrayList();

        /* renamed from: e */
        private String f3674e = RandomUtil.m54009a();

        /* compiled from: TraceManager.java */
        /* renamed from: com.amap.api.col.3l.b4$a$a */
        /* loaded from: E:\fuckcool\tsn\6276784.dex */
        final class C1750a extends ThreadTask {

            /* renamed from: a */
            final /* synthetic */ TraceHandlerAbstract f3677a;

            C1750a(TraceHandlerAbstract traceHandlerAbstract) {
                this.f3677a = traceHandlerAbstract;
            }

            @Override // com.amap.api.col.p0463l.ThreadTask
            public final void runTask() {
                this.f3677a.run();
            }
        }

        public C1749a(int i, List<TraceLocation> list, int i2, TraceListener traceListener) {
            this.f3671b = i2;
            this.f3672c = i;
            this.f3673d = list;
            this.f3675g = traceListener;
        }

        /* renamed from: d */
        private int m55548d() {
            List<TraceLocation> list = this.f3673d;
            int i = 0;
            if (list != null && list.size() != 0) {
                ArrayList arrayList = new ArrayList();
                for (TraceLocation traceLocation : this.f3673d) {
                    if (traceLocation != null) {
                        if (traceLocation.getSpeed() < 0.01d) {
                            arrayList.add(traceLocation);
                        } else {
                            i += m55547e(arrayList);
                            arrayList.clear();
                        }
                    }
                }
            }
            return i;
        }

        /* renamed from: e */
        private static int m55547e(List<TraceLocation> list) {
            int size = list.size();
            if (size <= 1) {
                return 0;
            }
            TraceLocation traceLocation = list.get(0);
            TraceLocation traceLocation2 = list.get(size - 1);
            if (traceLocation == null || traceLocation2 == null) {
                return 0;
            }
            return (int) ((traceLocation2.getTime() - traceLocation.getTime()) / 1000);
        }

        @Override // com.amap.api.col.p0463l.ThreadTask
        public final void runTask() {
            try {
                TraceManager.this.f3662m.m55545a(this.f3675g);
                int m55548d = m55548d();
                List<TraceLocation> list = this.f3673d;
                if (list != null && list.size() >= 2) {
                    for (TraceLocation traceLocation : this.f3673d) {
                        TraceLocation copy = traceLocation.copy();
                        if (copy != null && copy.getLatitude() > Utils.DOUBLE_EPSILON && copy.getLongitude() > Utils.DOUBLE_EPSILON) {
                            this.f3670a.add(copy);
                        }
                    }
                    int size = (this.f3670a.size() - 2) / 500;
                    TraceResultPool.m55478b().m55476d(this.f3674e, this.f3672c, size, m55548d);
                    int i = 500;
                    int i2 = 0;
                    while (i2 <= size) {
                        if (i2 == size) {
                            i = this.f3670a.size();
                        }
                        int i3 = i;
                        ArrayList arrayList = new ArrayList();
                        for (int i4 = 0; i4 < i3; i4++) {
                            TraceLocation remove = this.f3670a.remove(0);
                            if (remove != null) {
                                int i5 = this.f3671b;
                                if (i5 != 1) {
                                    if (i5 == 3) {
                                        TraceManager.this.f3651b.from(CoordinateConverter.CoordType.BAIDU);
                                    } else if (i5 == 2) {
                                        TraceManager.this.f3651b.from(CoordinateConverter.CoordType.GPS);
                                    }
                                    TraceManager.this.f3651b.coord(new LatLng(remove.getLatitude(), remove.getLongitude()));
                                    LatLng convert = TraceManager.this.f3651b.convert();
                                    if (convert != null) {
                                        remove.setLatitude(convert.latitude);
                                        remove.setLongitude(convert.longitude);
                                    }
                                }
                                arrayList.add(remove);
                            }
                        }
                        if (arrayList.size() >= 2 && arrayList.size() <= 500) {
                            TraceManager.this.f3653d.m55654b(new C1750a(new TraceHandlerAbstract(TraceManager.this.f3650a, TraceManager.this.f3662m, arrayList, this.f3674e, this.f3672c, i2)));
                            i2++;
                            try {
                                Thread.sleep(50L);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        i = i3;
                    }
                    return;
                }
                TraceResultPool.m55478b();
                TraceResultPool.m55477c(TraceManager.this.f3662m, this.f3672c, LBSTraceClient.MIN_GRASP_POINT_ERROR);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TraceManager.java */
    /* renamed from: com.amap.api.col.3l.b4$b */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public class C1751b implements TraceListener {

        /* renamed from: a */
        private final List<TraceLocation> f3679a;

        public C1751b(List<TraceLocation> list) {
            this.f3679a = list;
        }

        /* renamed from: a */
        private void m55546a(int i, List<LatLng> list) {
            try {
                synchronized (TraceManager.this.f3666q) {
                    TraceManager.this.f3666q.clear();
                    TraceManager.this.f3666q.addAll(list);
                }
                TraceManager.this.f3665p.clear();
                if (i == 0) {
                    TraceManager.this.f3665p.addAll(TraceManager.this.f3666q);
                } else {
                    TraceManager.this.f3665p.addAll(TraceManager.this.f3664o);
                    TraceManager.this.f3665p.addAll(TraceManager.this.f3666q);
                }
                TraceManager.this.f3656g.onTraceStatus(TraceManager.this.f3658i, TraceManager.this.f3665p, LBSTraceClient.TRACE_SUCCESS);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        @Override // com.amap.api.trace.TraceListener
        public final void onFinished(int i, List<LatLng> list, int i2, int i3) {
            m55546a(i, list);
        }

        @Override // com.amap.api.trace.TraceListener
        public final void onRequestFailed(int i, String str) {
            ArrayList arrayList = new ArrayList();
            if (TraceManager.this.f3666q != null) {
                arrayList.addAll(TraceManager.this.f3666q);
            }
            List<TraceLocation> list = this.f3679a;
            if (list != null) {
                int size = list.size();
                if (this.f3679a.size() > TraceManager.this.f3655f) {
                    for (int i2 = size - TraceManager.this.f3655f; i2 < size; i2++) {
                        TraceLocation traceLocation = this.f3679a.get(i2);
                        if (traceLocation != null) {
                            arrayList.add(new LatLng(traceLocation.getLatitude(), traceLocation.getLongitude()));
                        }
                    }
                }
            }
            m55546a(i, arrayList);
        }

        @Override // com.amap.api.trace.TraceListener
        public final void onTraceProcessing(int i, int i2, List<LatLng> list) {
        }
    }

    /* compiled from: TraceManager.java */
    /* renamed from: com.amap.api.col.3l.b4$c */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    static class HandlerC1752c extends Handler {

        /* renamed from: a */
        private TraceListener f3681a;

        public HandlerC1752c(Looper looper) {
            super(looper);
        }

        /* renamed from: a */
        public final void m55545a(TraceListener traceListener) {
            this.f3681a = traceListener;
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            Bundle data;
            try {
                if (this.f3681a == null || (data = message.getData()) == null) {
                    return;
                }
                int i = data.getInt("lineID");
                switch (message.what) {
                    case 100:
                        this.f3681a.onTraceProcessing(i, message.arg1, (List) message.obj);
                        return;
                    case 101:
                        this.f3681a.onFinished(i, (List) message.obj, message.arg1, message.arg2);
                        return;
                    case 102:
                        this.f3681a.onRequestFailed(i, (String) message.obj);
                        return;
                    default:
                        return;
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public TraceManager(Context context) {
        Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.f3650a = origApplicationContext;
        this.f3651b = new CoordinateConverter(origApplicationContext);
        this.f3662m = new HandlerC1752c(Looper.getMainLooper());
        HttpsDecisionUtil.m54673a().m54671c(this.f3650a);
        this.f3652c = ThreadUtilPoolFactory.m53337a(this.f3667r * 2, this.f3668s, "AMapTraceManagerProcess");
        this.f3653d = ThreadUtilPoolFactory.m53337a(this.f3667r * 2, this.f3669t, "AMapTraceManagerRequest");
    }

    /* renamed from: a */
    private static double m55564a(double d, double d2, double d3, double d4) {
        double d5 = d > d3 ? d - d3 : d3 - d;
        double d6 = d2 > d4 ? d2 - d4 : d4 - d2;
        return Math.sqrt((d5 * d5) + (d6 * d6));
    }

    /* renamed from: c */
    private void m55562c() {
        int size = this.f3658i.size();
        if (size < this.f3655f) {
            return;
        }
        if (size <= 50) {
            ArrayList arrayList = new ArrayList(this.f3658i);
            queryProcessedTrace(0, arrayList, 1, new C1751b(arrayList));
            return;
        }
        int i = size - 50;
        if (i < 0) {
            return;
        }
        m55561d(new ArrayList(this.f3658i.subList(i - this.f3655f, i)));
        ArrayList arrayList2 = new ArrayList(this.f3658i.subList(i, size));
        queryProcessedTrace(i, arrayList2, 1, new C1751b(arrayList2));
    }

    /* renamed from: d */
    private void m55561d(List<TraceLocation> list) {
        TraceManager traceManager = this;
        synchronized (traceManager.f3666q) {
            try {
                if (list.size() <= 0) {
                    return;
                }
                if (traceManager.f3666q.size() <= 0) {
                    return;
                }
                LatLng latLng = null;
                double d = Utils.DOUBLE_EPSILON;
                TraceLocation traceLocation = null;
                double d2 = 0.0d;
                for (TraceLocation traceLocation2 : list) {
                    if (traceLocation2 != null) {
                        if (traceLocation != null) {
                            double m55564a = m55564a(traceLocation.getLatitude(), traceLocation.getLongitude(), traceLocation2.getLatitude(), traceLocation2.getLongitude());
                            if (m55564a <= 100.0d) {
                                d2 += m55564a;
                            }
                        }
                        traceLocation = traceLocation2;
                    }
                }
                Iterator<LatLng> it = traceManager.f3666q.iterator();
                while (it.hasNext()) {
                    LatLng next = it.next();
                    if (next == null) {
                        it.remove();
                    } else {
                        if (latLng == null) {
                            traceManager.f3664o.add(next);
                            it.remove();
                        } else {
                            Iterator<LatLng> it2 = it;
                            try {
                                d += m55564a(latLng.latitude, latLng.longitude, next.latitude, next.longitude);
                                if (d >= d2) {
                                    break;
                                }
                                traceManager = this;
                                traceManager.f3664o.add(next);
                                it2.remove();
                                it = it2;
                            } catch (Throwable th) {
                                th = th;
                                throw th;
                            }
                        }
                        latLng = next;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    /* renamed from: e */
    private static boolean m55560e(TraceLocation traceLocation, TraceLocation traceLocation2) {
        return traceLocation != null && traceLocation.getLatitude() == traceLocation2.getLatitude() && traceLocation.getLongitude() == traceLocation2.getLongitude();
    }

    /* renamed from: g */
    private void m55558g() {
        AMapReflectionLocationSource aMapReflectionLocationSource = this.f3657h;
        if (aMapReflectionLocationSource != null) {
            aMapReflectionLocationSource.deactivate();
            this.f3657h = null;
        }
    }

    /* renamed from: i */
    private void m55556i() {
        this.f3668s.clear();
        this.f3669t.clear();
        List<TraceLocation> list = this.f3658i;
        if (list != null) {
            synchronized (list) {
                List<TraceLocation> list2 = this.f3658i;
                if (list2 != null) {
                    list2.clear();
                }
                this.f3660k = 0;
                this.f3659j = 0;
                this.f3661l = 0L;
                this.f3663n = null;
            }
        }
    }

    @Override // com.amap.api.trace.LBSTraceBase
    public final void destroy() {
        try {
            stopTrace();
            ThreadPool threadPool = this.f3652c;
            if (threadPool != null) {
                threadPool.m55649g();
                this.f3652c = null;
            }
            ThreadPool threadPool2 = this.f3653d;
            if (threadPool2 != null) {
                threadPool2.m55649g();
                this.f3653d = null;
            }
            this.f3658i = null;
            this.f3656g = null;
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.f3650a = null;
        this.f3651b = null;
    }

    @Override // com.amap.api.maps.LocationSource.OnLocationChangedListener
    public final void onLocationChanged(Location location) {
        Bundle extras;
        TraceStatusListener traceStatusListener;
        if (this.f3656g != null) {
            try {
                if (System.currentTimeMillis() - this.f3661l >= 30000 && (traceStatusListener = this.f3656g) != null) {
                    traceStatusListener.onTraceStatus(null, null, LBSTraceClient.LOCATE_TIMEOUT_ERROR);
                }
                this.f3661l = System.currentTimeMillis();
                int i = location.getExtras().getInt("errorCode");
                if (i != 0) {
                    Log.w("LBSTraceClient", "Locate failed [errorCode:\"" + i + "\"  errorInfo:" + extras.getString(MyLocationStyle.ERROR_INFO) + "\"]");
                    return;
                }
                synchronized (this.f3658i) {
                    TraceLocation traceLocation = new TraceLocation(location.getLatitude(), location.getLongitude(), location.getSpeed(), location.getBearing(), location.getTime());
                    if (m55560e(this.f3663n, traceLocation)) {
                        return;
                    }
                    this.f3658i.add(traceLocation);
                    this.f3663n = traceLocation;
                    int i2 = this.f3659j + 1;
                    this.f3659j = i2;
                    if (i2 == this.f3655f) {
                        this.f3660k += i2;
                        m55562c();
                        this.f3659j = 0;
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    @Override // com.amap.api.trace.LBSTraceBase
    public final void queryProcessedTrace(int i, List<TraceLocation> list, int i2, TraceListener traceListener) {
        try {
            this.f3652c.m55654b(new C1749a(i, list, i2, traceListener));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.trace.LBSTraceBase
    public final void setLocationInterval(long j) {
        this.f3654e = j;
    }

    @Override // com.amap.api.trace.LBSTraceBase
    public final void setTraceStatusInterval(int i) {
        this.f3655f = Math.max(i, 2);
    }

    @Override // com.amap.api.trace.LBSTraceBase
    public final void startTrace(TraceStatusListener traceStatusListener) {
        if (this.f3650a == null) {
            Log.w("LBSTraceClient", "Context need to be initialized");
            return;
        }
        this.f3661l = System.currentTimeMillis();
        this.f3656g = traceStatusListener;
        if (this.f3657h == null) {
            AMapReflectionLocationSource aMapReflectionLocationSource = new AMapReflectionLocationSource(this.f3650a);
            this.f3657h = aMapReflectionLocationSource;
            aMapReflectionLocationSource.m55775d(this.f3654e);
            this.f3657h.activate(this);
        }
    }

    @Override // com.amap.api.trace.LBSTraceBase
    public final void stopTrace() {
        m55558g();
        m55556i();
    }
}

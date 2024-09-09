package com.amap.api.col.p0003l;

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
import com.amap.api.trace.LBSTraceBase;
import com.amap.api.trace.TraceListener;
import com.amap.api.trace.TraceLocation;
import com.amap.api.trace.TraceStatusListener;
import com.bytedance.pangle.sdk.component.log.impl.event.policy.PolicyConfig;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: TraceManager.java */
/* renamed from: com.amap.api.col.3l.b4  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class b4 implements LocationSource.OnLocationChangedListener, LBSTraceBase {

    /* renamed from: a  reason: collision with root package name */
    private Context f7211a;

    /* renamed from: b  reason: collision with root package name */
    private CoordinateConverter f7212b;

    /* renamed from: c  reason: collision with root package name */
    private z7 f7213c;

    /* renamed from: d  reason: collision with root package name */
    private z7 f7214d;

    /* renamed from: g  reason: collision with root package name */
    private TraceStatusListener f7217g;

    /* renamed from: h  reason: collision with root package name */
    private a0 f7218h;

    /* renamed from: m  reason: collision with root package name */
    private c f7223m;

    /* renamed from: e  reason: collision with root package name */
    private long f7215e = 2000;

    /* renamed from: f  reason: collision with root package name */
    private int f7216f = 5;

    /* renamed from: i  reason: collision with root package name */
    private List<TraceLocation> f7219i = new ArrayList();

    /* renamed from: j  reason: collision with root package name */
    private int f7220j = 0;

    /* renamed from: k  reason: collision with root package name */
    private int f7221k = 0;

    /* renamed from: l  reason: collision with root package name */
    private long f7222l = 0;

    /* renamed from: n  reason: collision with root package name */
    private TraceLocation f7224n = null;

    /* renamed from: o  reason: collision with root package name */
    private List<LatLng> f7225o = new ArrayList();

    /* renamed from: p  reason: collision with root package name */
    private List<LatLng> f7226p = new ArrayList();

    /* renamed from: q  reason: collision with root package name */
    private List<LatLng> f7227q = new ArrayList();

    /* renamed from: r  reason: collision with root package name */
    int f7228r = Runtime.getRuntime().availableProcessors();

    /* renamed from: s  reason: collision with root package name */
    private BlockingQueue<Runnable> f7229s = new LinkedBlockingQueue();

    /* renamed from: t  reason: collision with root package name */
    private BlockingQueue<Runnable> f7230t = new LinkedBlockingQueue();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* compiled from: TraceManager.java */
    /* renamed from: com.amap.api.col.3l.b4$a */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public class a extends a8 {

        /* renamed from: b  reason: collision with root package name */
        private int f7232b;

        /* renamed from: c  reason: collision with root package name */
        private int f7233c;

        /* renamed from: d  reason: collision with root package name */
        private List<TraceLocation> f7234d;

        /* renamed from: g  reason: collision with root package name */
        private TraceListener f7236g;

        /* renamed from: a  reason: collision with root package name */
        private List<TraceLocation> f7231a = new ArrayList();

        /* renamed from: e  reason: collision with root package name */
        private String f7235e = s2.a();

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
        /* compiled from: TraceManager.java */
        /* renamed from: com.amap.api.col.3l.b4$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\7502512.dex */
        final class C0100a extends a8 {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ a4 f7238a;

            C0100a(a4 a4Var) {
                this.f7238a = a4Var;
            }

            @Override // com.amap.api.col.p0003l.a8
            public final void runTask() {
                this.f7238a.run();
            }
        }

        public a(int i4, List<TraceLocation> list, int i5, TraceListener traceListener) {
            this.f7232b = i5;
            this.f7233c = i4;
            this.f7234d = list;
            this.f7236g = traceListener;
        }

        private int d() {
            List<TraceLocation> list = this.f7234d;
            int i4 = 0;
            if (list != null && list.size() != 0) {
                ArrayList arrayList = new ArrayList();
                for (TraceLocation traceLocation : this.f7234d) {
                    if (traceLocation != null) {
                        if (traceLocation.getSpeed() < 0.01d) {
                            arrayList.add(traceLocation);
                        } else {
                            i4 += e(arrayList);
                            arrayList.clear();
                        }
                    }
                }
            }
            return i4;
        }

        private static int e(List<TraceLocation> list) {
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

        @Override // com.amap.api.col.p0003l.a8
        public final void runTask() {
            try {
                b4.this.f7223m.a(this.f7236g);
                int d4 = d();
                List<TraceLocation> list = this.f7234d;
                if (list != null && list.size() >= 2) {
                    for (TraceLocation traceLocation : this.f7234d) {
                        TraceLocation copy = traceLocation.copy();
                        if (copy != null && copy.getLatitude() > 0.0d && copy.getLongitude() > 0.0d) {
                            this.f7231a.add(copy);
                        }
                    }
                    int size = (this.f7231a.size() - 2) / 500;
                    c4.b().d(this.f7235e, this.f7233c, size, d4);
                    int i4 = 500;
                    int i5 = 0;
                    while (i5 <= size) {
                        if (i5 == size) {
                            i4 = this.f7231a.size();
                        }
                        int i6 = i4;
                        ArrayList arrayList = new ArrayList();
                        for (int i7 = 0; i7 < i6; i7++) {
                            TraceLocation remove = this.f7231a.remove(0);
                            if (remove != null) {
                                int i8 = this.f7232b;
                                if (i8 != 1) {
                                    if (i8 == 3) {
                                        b4.this.f7212b.from(CoordinateConverter.CoordType.BAIDU);
                                    } else if (i8 == 2) {
                                        b4.this.f7212b.from(CoordinateConverter.CoordType.GPS);
                                    }
                                    b4.this.f7212b.coord(new LatLng(remove.getLatitude(), remove.getLongitude()));
                                    LatLng convert = b4.this.f7212b.convert();
                                    if (convert != null) {
                                        remove.setLatitude(convert.latitude);
                                        remove.setLongitude(convert.longitude);
                                    }
                                }
                                arrayList.add(remove);
                            }
                        }
                        if (arrayList.size() >= 2 && arrayList.size() <= 500) {
                            b4.this.f7214d.b(new C0100a(new a4(b4.this.f7211a, b4.this.f7223m, arrayList, this.f7235e, this.f7233c, i5)));
                            i5++;
                            try {
                                Thread.sleep(50L);
                            } catch (InterruptedException e4) {
                                e4.printStackTrace();
                            }
                        }
                        i4 = i6;
                    }
                    return;
                }
                c4.b();
                c4.c(b4.this.f7223m, this.f7233c, "\u8f68\u8ff9\u70b9\u592a\u5c11\u6216\u8ddd\u79bb\u592a\u8fd1,\u8f68\u8ff9\u7ea0\u504f\u5931\u8d25");
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* compiled from: TraceManager.java */
    /* renamed from: com.amap.api.col.3l.b4$b */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public class b implements TraceListener {

        /* renamed from: a  reason: collision with root package name */
        private final List<TraceLocation> f7240a;

        public b(List<TraceLocation> list) {
            this.f7240a = list;
        }

        private void a(int i4, List<LatLng> list) {
            try {
                synchronized (b4.this.f7227q) {
                    b4.this.f7227q.clear();
                    b4.this.f7227q.addAll(list);
                }
                b4.this.f7226p.clear();
                if (i4 == 0) {
                    b4.this.f7226p.addAll(b4.this.f7227q);
                } else {
                    b4.this.f7226p.addAll(b4.this.f7225o);
                    b4.this.f7226p.addAll(b4.this.f7227q);
                }
                b4.this.f7217g.onTraceStatus(b4.this.f7219i, b4.this.f7226p, "\u7ea0\u504f\u6210\u529f");
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        @Override // com.amap.api.trace.TraceListener
        public final void onFinished(int i4, List<LatLng> list, int i5, int i6) {
            a(i4, list);
        }

        @Override // com.amap.api.trace.TraceListener
        public final void onRequestFailed(int i4, String str) {
            ArrayList arrayList = new ArrayList();
            if (b4.this.f7227q != null) {
                arrayList.addAll(b4.this.f7227q);
            }
            List<TraceLocation> list = this.f7240a;
            if (list != null) {
                int size = list.size();
                if (this.f7240a.size() > b4.this.f7216f) {
                    for (int i5 = size - b4.this.f7216f; i5 < size; i5++) {
                        TraceLocation traceLocation = this.f7240a.get(i5);
                        if (traceLocation != null) {
                            arrayList.add(new LatLng(traceLocation.getLatitude(), traceLocation.getLongitude()));
                        }
                    }
                }
            }
            a(i4, arrayList);
        }

        @Override // com.amap.api.trace.TraceListener
        public final void onTraceProcessing(int i4, int i5, List<LatLng> list) {
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* compiled from: TraceManager.java */
    /* renamed from: com.amap.api.col.3l.b4$c */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    static class c extends Handler {

        /* renamed from: a  reason: collision with root package name */
        private TraceListener f7242a;

        public c(Looper looper) {
            super(looper);
        }

        public final void a(TraceListener traceListener) {
            this.f7242a = traceListener;
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            Bundle data;
            try {
                if (this.f7242a == null || (data = message.getData()) == null) {
                    return;
                }
                int i4 = data.getInt("lineID");
                switch (message.what) {
                    case 100:
                        this.f7242a.onTraceProcessing(i4, message.arg1, (List) message.obj);
                        return;
                    case 101:
                        this.f7242a.onFinished(i4, (List) message.obj, message.arg1, message.arg2);
                        return;
                    case 102:
                        this.f7242a.onRequestFailed(i4, (String) message.obj);
                        return;
                    default:
                        return;
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public b4(Context context) {
        Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.f7211a = origApplicationContext;
        this.f7212b = new CoordinateConverter(origApplicationContext);
        this.f7223m = new c(Looper.getMainLooper());
        k4.a().c(this.f7211a);
        this.f7213c = z2.a(this.f7228r * 2, this.f7229s, "AMapTraceManagerProcess");
        this.f7214d = z2.a(this.f7228r * 2, this.f7230t, "AMapTraceManagerRequest");
    }

    private static double a(double d4, double d5, double d6, double d7) {
        double d8 = d4 > d6 ? d4 - d6 : d6 - d4;
        double d9 = d5 > d7 ? d5 - d7 : d7 - d5;
        return Math.sqrt((d8 * d8) + (d9 * d9));
    }

    private void c() {
        int size = this.f7219i.size();
        if (size < this.f7216f) {
            return;
        }
        if (size <= 50) {
            ArrayList arrayList = new ArrayList(this.f7219i);
            queryProcessedTrace(0, arrayList, 1, new b(arrayList));
            return;
        }
        int i4 = size - 50;
        if (i4 < 0) {
            return;
        }
        d(new ArrayList(this.f7219i.subList(i4 - this.f7216f, i4)));
        ArrayList arrayList2 = new ArrayList(this.f7219i.subList(i4, size));
        queryProcessedTrace(i4, arrayList2, 1, new b(arrayList2));
    }

    private void d(List<TraceLocation> list) {
        b4 b4Var = this;
        synchronized (b4Var.f7227q) {
            try {
                if (list.size() <= 0) {
                    return;
                }
                if (b4Var.f7227q.size() <= 0) {
                    return;
                }
                LatLng latLng = null;
                double d4 = 0.0d;
                TraceLocation traceLocation = null;
                double d5 = 0.0d;
                for (TraceLocation traceLocation2 : list) {
                    if (traceLocation2 != null) {
                        if (traceLocation != null) {
                            double a4 = a(traceLocation.getLatitude(), traceLocation.getLongitude(), traceLocation2.getLatitude(), traceLocation2.getLongitude());
                            if (a4 <= 100.0d) {
                                d5 += a4;
                            }
                        }
                        traceLocation = traceLocation2;
                    }
                }
                Iterator<LatLng> it = b4Var.f7227q.iterator();
                while (it.hasNext()) {
                    LatLng next = it.next();
                    if (next == null) {
                        it.remove();
                    } else {
                        if (latLng == null) {
                            b4Var.f7225o.add(next);
                            it.remove();
                        } else {
                            Iterator<LatLng> it2 = it;
                            try {
                                d4 += a(latLng.latitude, latLng.longitude, next.latitude, next.longitude);
                                if (d4 >= d5) {
                                    break;
                                }
                                b4Var = this;
                                b4Var.f7225o.add(next);
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

    private static boolean e(TraceLocation traceLocation, TraceLocation traceLocation2) {
        return traceLocation != null && traceLocation.getLatitude() == traceLocation2.getLatitude() && traceLocation.getLongitude() == traceLocation2.getLongitude();
    }

    private void g() {
        a0 a0Var = this.f7218h;
        if (a0Var != null) {
            a0Var.deactivate();
            this.f7218h = null;
        }
    }

    private void i() {
        this.f7229s.clear();
        this.f7230t.clear();
        List<TraceLocation> list = this.f7219i;
        if (list != null) {
            synchronized (list) {
                List<TraceLocation> list2 = this.f7219i;
                if (list2 != null) {
                    list2.clear();
                }
                this.f7221k = 0;
                this.f7220j = 0;
                this.f7222l = 0L;
                this.f7224n = null;
            }
        }
    }

    @Override // com.amap.api.trace.LBSTraceBase
    public final void destroy() {
        try {
            stopTrace();
            z7 z7Var = this.f7213c;
            if (z7Var != null) {
                z7Var.g();
                this.f7213c = null;
            }
            z7 z7Var2 = this.f7214d;
            if (z7Var2 != null) {
                z7Var2.g();
                this.f7214d = null;
            }
            this.f7219i = null;
            this.f7217g = null;
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.f7211a = null;
        this.f7212b = null;
    }

    @Override // com.amap.api.maps.LocationSource.OnLocationChangedListener
    public final void onLocationChanged(Location location) {
        Bundle extras;
        TraceStatusListener traceStatusListener;
        if (this.f7217g != null) {
            try {
                if (System.currentTimeMillis() - this.f7222l >= PolicyConfig.mServerBusyRetryBaseInternal && (traceStatusListener = this.f7217g) != null) {
                    traceStatusListener.onTraceStatus(null, null, "\u5b9a\u4f4d\u8d85\u65f6");
                }
                this.f7222l = System.currentTimeMillis();
                int i4 = location.getExtras().getInt("errorCode");
                if (i4 != 0) {
                    Log.w("LBSTraceClient", "Locate failed [errorCode:\"" + i4 + "\"  errorInfo:" + extras.getString("errorInfo") + "\"]");
                    return;
                }
                synchronized (this.f7219i) {
                    TraceLocation traceLocation = new TraceLocation(location.getLatitude(), location.getLongitude(), location.getSpeed(), location.getBearing(), location.getTime());
                    if (e(this.f7224n, traceLocation)) {
                        return;
                    }
                    this.f7219i.add(traceLocation);
                    this.f7224n = traceLocation;
                    int i5 = this.f7220j + 1;
                    this.f7220j = i5;
                    if (i5 == this.f7216f) {
                        this.f7221k += i5;
                        c();
                        this.f7220j = 0;
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    @Override // com.amap.api.trace.LBSTraceBase
    public final void queryProcessedTrace(int i4, List<TraceLocation> list, int i5, TraceListener traceListener) {
        try {
            this.f7213c.b(new a(i4, list, i5, traceListener));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.trace.LBSTraceBase
    public final void setLocationInterval(long j4) {
        this.f7215e = j4;
    }

    @Override // com.amap.api.trace.LBSTraceBase
    public final void setTraceStatusInterval(int i4) {
        this.f7216f = Math.max(i4, 2);
    }

    @Override // com.amap.api.trace.LBSTraceBase
    public final void startTrace(TraceStatusListener traceStatusListener) {
        if (this.f7211a == null) {
            Log.w("LBSTraceClient", "Context need to be initialized");
            return;
        }
        this.f7222l = System.currentTimeMillis();
        this.f7217g = traceStatusListener;
        if (this.f7218h == null) {
            a0 a0Var = new a0(this.f7211a);
            this.f7218h = a0Var;
            a0Var.d(this.f7215e);
            this.f7218h.activate(this);
        }
    }

    @Override // com.amap.api.trace.LBSTraceBase
    public final void stopTrace() {
        g();
        i();
    }
}

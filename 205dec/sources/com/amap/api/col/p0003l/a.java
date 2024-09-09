package com.amap.api.col.p0003l;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import com.amap.api.fence.GeoFence;
import com.amap.api.fence.GeoFenceListener;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.location.DPoint;
import com.autonavi.aps.amapapi.utils.h;
import com.autonavi.aps.amapapi.utils.j;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: GeoFenceManager.java */
@SuppressLint({"NewApi"})
/* renamed from: com.amap.api.col.3l.a  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class a {
    private static boolean A;

    /* renamed from: b  reason: collision with root package name */
    Context f7027b;

    /* renamed from: a  reason: collision with root package name */
    h f7026a = null;

    /* renamed from: c  reason: collision with root package name */
    PendingIntent f7028c = null;

    /* renamed from: d  reason: collision with root package name */
    String f7029d = null;

    /* renamed from: e  reason: collision with root package name */
    GeoFenceListener f7030e = null;

    /* renamed from: f  reason: collision with root package name */
    private Object f7031f = new Object();

    /* renamed from: g  reason: collision with root package name */
    volatile int f7032g = 1;

    /* renamed from: h  reason: collision with root package name */
    ArrayList<GeoFence> f7033h = new ArrayList<>();

    /* renamed from: i  reason: collision with root package name */
    d f7034i = null;

    /* renamed from: j  reason: collision with root package name */
    Object f7035j = new Object();

    /* renamed from: k  reason: collision with root package name */
    Object f7036k = new Object();

    /* renamed from: l  reason: collision with root package name */
    b f7037l = null;

    /* renamed from: m  reason: collision with root package name */
    c f7038m = null;

    /* renamed from: n  reason: collision with root package name */
    volatile boolean f7039n = false;

    /* renamed from: o  reason: collision with root package name */
    volatile boolean f7040o = false;

    /* renamed from: p  reason: collision with root package name */
    volatile boolean f7041p = false;

    /* renamed from: q  reason: collision with root package name */
    d0 f7042q = null;

    /* renamed from: r  reason: collision with root package name */
    d1 f7043r = null;

    /* renamed from: s  reason: collision with root package name */
    AMapLocationClient f7044s = null;

    /* renamed from: t  reason: collision with root package name */
    volatile AMapLocation f7045t = null;

    /* renamed from: u  reason: collision with root package name */
    long f7046u = 0;

    /* renamed from: v  reason: collision with root package name */
    AMapLocationClientOption f7047v = null;

    /* renamed from: w  reason: collision with root package name */
    int f7048w = 0;

    /* renamed from: x  reason: collision with root package name */
    AMapLocationListener f7049x = new C0098a();

    /* renamed from: y  reason: collision with root package name */
    final int f7050y = 3;

    /* renamed from: z  reason: collision with root package name */
    volatile boolean f7051z = false;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* compiled from: GeoFenceManager.java */
    /* renamed from: com.amap.api.col.3l.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    final class C0098a implements AMapLocationListener {
        C0098a() {
        }

        @Override // com.amap.api.location.AMapLocationListener
        public final void onLocationChanged(AMapLocation aMapLocation) {
            boolean z3;
            int i4;
            try {
                if (!a.this.f7051z && a.this.f7041p) {
                    a.this.f7045t = aMapLocation;
                    if (aMapLocation != null) {
                        i4 = aMapLocation.getErrorCode();
                        if (aMapLocation.getErrorCode() == 0) {
                            a.this.f7046u = j.b();
                            a.this.j(5, null, 0L);
                            z3 = true;
                        } else {
                            int errorCode = aMapLocation.getErrorCode();
                            String errorInfo = aMapLocation.getErrorInfo();
                            a.p("\u5b9a\u4f4d\u5931\u8d25", errorCode, errorInfo, "locationDetail:" + aMapLocation.getLocationDetail());
                            z3 = false;
                        }
                    } else {
                        z3 = false;
                        i4 = 8;
                    }
                    if (z3) {
                        a aVar = a.this;
                        aVar.f7048w = 0;
                        aVar.j(6, null, 0L);
                        return;
                    }
                    Bundle bundle = new Bundle();
                    if (!a.this.f7039n) {
                        a.this.D(7);
                        bundle.putLong("interval", 2000L);
                        a.this.j(8, bundle, 2000L);
                    }
                    a aVar2 = a.this;
                    int i5 = aVar2.f7048w + 1;
                    aVar2.f7048w = i5;
                    if (i5 >= 3) {
                        bundle.putInt("location_errorcode", i4);
                        a.this.i(1002, bundle);
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* compiled from: GeoFenceManager.java */
    /* renamed from: com.amap.api.col.3l.a$b */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public class b extends Handler {
        public b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            try {
                switch (message.what) {
                    case 0:
                        a.this.F(message.getData());
                        return;
                    case 1:
                        a.this.M(message.getData());
                        return;
                    case 2:
                        a.this.S(message.getData());
                        return;
                    case 3:
                        a.this.P(message.getData());
                        return;
                    case 4:
                        a.this.U(message.getData());
                        return;
                    case 5:
                        a.this.R();
                        return;
                    case 6:
                        a aVar = a.this;
                        aVar.m(aVar.f7045t);
                        return;
                    case 7:
                        a.this.O();
                        return;
                    case 8:
                        a.this.c0(message.getData());
                        return;
                    case 9:
                        a.this.k(message.getData());
                        return;
                    case 10:
                        a.this.K();
                        return;
                    case 11:
                        a.this.Y(message.getData());
                        return;
                    case 12:
                        a.this.W(message.getData());
                        return;
                    case 13:
                        a.this.V();
                        return;
                    default:
                        return;
                }
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* compiled from: GeoFenceManager.java */
    /* renamed from: com.amap.api.col.3l.a$c */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class c extends HandlerThread {
        public c(String str) {
            super(str);
        }

        @Override // android.os.HandlerThread, java.lang.Thread, java.lang.Runnable
        public final void run() {
            try {
                super.run();
            } catch (Throwable unused) {
            }
        }
    }

    public a(Context context) {
        this.f7027b = null;
        try {
            this.f7027b = StubApp.getOrigApplicationContext(context.getApplicationContext());
            b0();
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "GeoFenceManger", "<init>");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float A(DPoint dPoint, List<DPoint> list) {
        float f4 = Float.MIN_VALUE;
        if (dPoint != null && list != null && !list.isEmpty()) {
            for (DPoint dPoint2 : list) {
                f4 = Math.max(f4, j.a(dPoint, dPoint2));
            }
        }
        return f4;
    }

    private static DPoint B(List<DPoint> list) {
        DPoint dPoint = new DPoint();
        if (list != null) {
            try {
                double d4 = 0.0d;
                double d5 = 0.0d;
                for (DPoint dPoint2 : list) {
                    d4 += dPoint2.getLatitude();
                    d5 += dPoint2.getLongitude();
                }
                double size = list.size();
                Double.isNaN(size);
                double b4 = j.b(d4 / size);
                double size2 = list.size();
                Double.isNaN(size2);
                return new DPoint(b4, j.b(d5 / size2));
            } catch (Throwable th) {
                com.autonavi.aps.amapapi.utils.b.a(th, "GeoFenceUtil", "getPolygonCenter");
                return dPoint;
            }
        }
        return dPoint;
    }

    private void E(int i4, Bundle bundle) {
        String str;
        int i5;
        String str2;
        int i6;
        String str3;
        String str4;
        String b4;
        Bundle bundle2 = new Bundle();
        try {
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
            if (bundle == null || bundle.isEmpty()) {
                str2 = "errorCode";
                i6 = 1;
            } else {
                List<GeoFence> arrayList2 = new ArrayList<>();
                String string = bundle.getString("customId");
                String string2 = bundle.getString("keyWords");
                String string3 = bundle.getString("city");
                String string4 = bundle.getString("poiType");
                DPoint dPoint = (DPoint) bundle.getParcelable("centerPoint");
                int i7 = bundle.getInt("searchSize", 10);
                float f4 = bundle.getFloat("aroundRadius", 3000.0f);
                if (v(i4, string2, string4, dPoint)) {
                    Bundle bundle3 = new Bundle();
                    bundle3.putString("customId", string);
                    bundle3.putString("pendingIntentAction", this.f7029d);
                    str3 = "customId";
                    str4 = "errorCode";
                    try {
                        bundle3.putLong("expiration", -1L);
                        bundle3.putInt("activatesAction", this.f7032g);
                        if (i4 == 1) {
                            bundle3.putFloat("fenceRadius", 1000.0f);
                            b4 = this.f7042q.b(this.f7027b, "http://restsdk.amap.com/v3/place/text?", string2, string4, string3, String.valueOf(i7));
                        } else if (i4 != 2) {
                            b4 = i4 != 3 ? null : this.f7042q.a(this.f7027b, "http://restsdk.amap.com/v3/config/district?", string2);
                        } else {
                            double b5 = j.b(dPoint.getLatitude());
                            double b6 = j.b(dPoint.getLongitude());
                            int intValue = Float.valueOf(f4).intValue();
                            bundle3.putFloat("fenceRadius", 200.0f);
                            b4 = this.f7042q.c(this.f7027b, "http://restsdk.amap.com/v3/place/around?", string2, string4, String.valueOf(i7), String.valueOf(b5), String.valueOf(b6), String.valueOf(intValue));
                        }
                        if (b4 != null) {
                            int b7 = 1 == i4 ? d1.b(b4, arrayList2, bundle3) : 0;
                            if (2 == i4) {
                                b7 = d1.e(b4, arrayList2, bundle3);
                            }
                            if (3 == i4) {
                                b7 = this.f7043r.f(b4, arrayList2, bundle3);
                            }
                            if (b7 == 10000) {
                                if (arrayList2.isEmpty()) {
                                    i5 = 16;
                                } else {
                                    i5 = c(arrayList2);
                                    if (i5 == 0) {
                                        try {
                                            arrayList.addAll(arrayList2);
                                        } catch (Throwable th) {
                                            th = th;
                                            str = str4;
                                            try {
                                                com.autonavi.aps.amapapi.utils.b.a(th, "GeoFenceManager", "doAddGeoFenceNearby");
                                                bundle2.putInt(str, 8);
                                                i(1000, bundle2);
                                                return;
                                            } catch (Throwable th2) {
                                                bundle2.putInt(str, i5);
                                                i(1000, bundle2);
                                                throw th2;
                                            }
                                        }
                                    }
                                }
                            } else {
                                i5 = N(b7);
                            }
                        } else {
                            i5 = 4;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        str = str4;
                        i5 = 0;
                        com.autonavi.aps.amapapi.utils.b.a(th, "GeoFenceManager", "doAddGeoFenceNearby");
                        bundle2.putInt(str, 8);
                        i(1000, bundle2);
                        return;
                    }
                } else {
                    str3 = "customId";
                    str4 = "errorCode";
                    i5 = 1;
                }
                bundle2.putString(str3, string);
                bundle2.putParcelableArrayList("resultList", arrayList);
                i6 = i5;
                str2 = str4;
            }
            bundle2.putInt(str2, i6);
            i(1000, bundle2);
        } catch (Throwable th4) {
            th = th4;
            str = "errorCode";
        }
    }

    private static boolean H(AMapLocation aMapLocation, GeoFence geoFence) {
        boolean z3 = true;
        try {
            if (y(aMapLocation, geoFence)) {
                if (geoFence.getEnterTime() == -1) {
                    if (geoFence.getStatus() != 1) {
                        geoFence.setEnterTime(j.b());
                        geoFence.setStatus(1);
                    }
                    z3 = false;
                } else {
                    if (geoFence.getStatus() != 3 && j.b() - geoFence.getEnterTime() > 600000) {
                        geoFence.setStatus(3);
                    }
                    z3 = false;
                }
            } else {
                if (geoFence.getStatus() != 2) {
                    try {
                        geoFence.setStatus(2);
                        geoFence.setEnterTime(-1L);
                    } catch (Throwable th) {
                        th = th;
                        com.autonavi.aps.amapapi.utils.b.a(th, "Utils", "isFenceStatusChanged");
                        return z3;
                    }
                }
                z3 = false;
            }
        } catch (Throwable th2) {
            th = th2;
            z3 = false;
        }
        return z3;
    }

    private static boolean I(AMapLocation aMapLocation, List<DPoint> list) {
        if (list.size() < 3) {
            return false;
        }
        return com.autonavi.aps.amapapi.utils.b.a(new DPoint(aMapLocation.getLatitude(), aMapLocation.getLongitude()), list);
    }

    private int J(GeoFence geoFence) {
        try {
            if (this.f7033h == null) {
                this.f7033h = new ArrayList<>();
            }
            if (this.f7033h.contains(geoFence)) {
                return 17;
            }
            this.f7033h.add(geoFence);
            return 0;
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "GeoFenceManager", "addGeoFence2List");
            p("\u6dfb\u52a0\u56f4\u680f\u5931\u8d25", 8, th.getMessage(), new String[0]);
            return 8;
        }
    }

    private static int N(int i4) {
        if (i4 != 1 && i4 != 7 && i4 != 4 && i4 != 5 && i4 != 16 && i4 != 17) {
            switch (i4) {
                case 10000:
                    i4 = 0;
                    break;
                case 10001:
                case 10002:
                case 10007:
                case 10008:
                case 10009:
                case 10012:
                case 10013:
                    i4 = 7;
                    break;
                case 10003:
                case 10004:
                case 10005:
                case 10006:
                case 10010:
                case 10011:
                case 10014:
                case 10015:
                case 10016:
                case 10017:
                    i4 = 4;
                    break;
                default:
                    switch (i4) {
                        case 20000:
                        case 20001:
                        case 20002:
                            i4 = 1;
                            break;
                        case 20003:
                        default:
                            i4 = 8;
                            break;
                    }
            }
        }
        if (i4 != 0) {
            p("\u6dfb\u52a0\u56f4\u680f\u5931\u8d25", i4, "searchErrCode is ".concat(String.valueOf(i4)), new String[0]);
        }
        return i4;
    }

    private void Q(GeoFence geoFence) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("geoFence", geoFence);
        i(1001, bundle);
    }

    private static float a(AMapLocation aMapLocation, List<GeoFence> list) {
        float f4 = Float.MAX_VALUE;
        if (aMapLocation != null && aMapLocation.getErrorCode() == 0 && list != null && !list.isEmpty()) {
            DPoint dPoint = new DPoint(aMapLocation.getLatitude(), aMapLocation.getLongitude());
            for (GeoFence geoFence : list) {
                if (geoFence.isAble()) {
                    float a4 = j.a(dPoint, geoFence.getCenter());
                    if (a4 > geoFence.getMinDis2Center() && a4 < geoFence.getMaxDis2Center()) {
                        return 0.0f;
                    }
                    if (a4 > geoFence.getMaxDis2Center()) {
                        f4 = Math.min(f4, a4 - geoFence.getMaxDis2Center());
                    }
                    if (a4 < geoFence.getMinDis2Center()) {
                        f4 = Math.min(f4, geoFence.getMinDis2Center() - a4);
                    }
                }
            }
        }
        return f4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float b(DPoint dPoint, List<DPoint> list) {
        float f4 = Float.MAX_VALUE;
        if (dPoint != null && list != null && !list.isEmpty()) {
            for (DPoint dPoint2 : list) {
                f4 = Math.min(f4, j.a(dPoint, dPoint2));
            }
        }
        return f4;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x002b -> B:38:0x0030). Please submit an issue!!! */
    private void b0() {
        if (!this.f7041p) {
            this.f7041p = true;
        }
        if (this.f7040o) {
            return;
        }
        try {
            if (Looper.myLooper() == null) {
                this.f7034i = new d(this.f7027b.getMainLooper());
            } else {
                this.f7034i = new d();
            }
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "GeoFenceManger", "init 1");
        }
        try {
            c cVar = new c("fenceActionThread");
            this.f7038m = cVar;
            cVar.setPriority(5);
            this.f7038m.start();
            this.f7037l = new b(this.f7038m.getLooper());
        } catch (Throwable th2) {
            com.autonavi.aps.amapapi.utils.b.a(th2, "GeoFenceManger", "init 2");
        }
        try {
            this.f7042q = new d0(this.f7027b);
            this.f7043r = new d1();
            this.f7047v = new AMapLocationClientOption();
            AMapLocationClient aMapLocationClient = new AMapLocationClient(this.f7027b);
            this.f7044s = aMapLocationClient;
            aMapLocationClient.setLocationListener(this.f7049x);
            if (this.f7026a == null) {
                this.f7026a = new h();
            }
        } catch (Throwable th3) {
            com.autonavi.aps.amapapi.utils.b.a(th3, "GeoFenceManger", "initBase");
        }
        this.f7040o = true;
        try {
            String str = this.f7029d;
            if (str != null && this.f7028c == null) {
                d(str);
            }
        } catch (Throwable th4) {
            com.autonavi.aps.amapapi.utils.b.a(th4, "GeoFenceManger", "init 4");
        }
        if (A) {
            return;
        }
        A = true;
        h.a(this.f7027b, "O020", (JSONObject) null);
    }

    private int c(List<GeoFence> list) {
        try {
            if (this.f7033h == null) {
                this.f7033h = new ArrayList<>();
            }
            for (GeoFence geoFence : list) {
                J(geoFence);
            }
            return 0;
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "GeoFenceManager", "addGeoFenceList");
            p("\u6dfb\u52a0\u56f4\u680f\u5931\u8d25", 8, th.getMessage(), new String[0]);
            return 8;
        }
    }

    private boolean d0() {
        ArrayList<GeoFence> arrayList = this.f7033h;
        if (arrayList == null || arrayList.isEmpty()) {
            return true;
        }
        Iterator<GeoFence> it = this.f7033h.iterator();
        while (it.hasNext()) {
            if (it.next().isAble()) {
                return false;
            }
        }
        return true;
    }

    private static Bundle e(GeoFence geoFence, String str, String str2, int i4, int i5) {
        Bundle bundle = new Bundle();
        if (str == null) {
            str = "";
        }
        bundle.putString("fenceid", str);
        bundle.putString("customId", str2);
        bundle.putInt("event", i4);
        bundle.putInt("location_errorcode", i5);
        bundle.putParcelable("fence", geoFence);
        return bundle;
    }

    private void e0() {
        try {
            synchronized (this.f7036k) {
                d dVar = this.f7034i;
                if (dVar != null) {
                    dVar.removeCallbacksAndMessages(null);
                }
                this.f7034i = null;
            }
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "GeoFenceManager", "destroyResultHandler");
        }
    }

    private GeoFence f(Bundle bundle, boolean z3) {
        GeoFence geoFence = new GeoFence();
        ArrayList arrayList = new ArrayList();
        DPoint dPoint = new DPoint();
        if (z3) {
            geoFence.setType(1);
            arrayList = bundle.getParcelableArrayList("pointList");
            if (arrayList != null) {
                dPoint = B(arrayList);
            }
            geoFence.setMaxDis2Center(A(dPoint, arrayList));
            geoFence.setMinDis2Center(b(dPoint, arrayList));
        } else {
            geoFence.setType(0);
            dPoint = (DPoint) bundle.getParcelable("centerPoint");
            if (dPoint != null) {
                arrayList.add(dPoint);
            }
            float f4 = bundle.getFloat("fenceRadius", 1000.0f);
            float f5 = f4 > 0.0f ? f4 : 1000.0f;
            geoFence.setRadius(f5);
            geoFence.setMinDis2Center(f5);
            geoFence.setMaxDis2Center(f5);
        }
        geoFence.setActivatesAction(this.f7032g);
        geoFence.setCustomId(bundle.getString("customId"));
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(arrayList);
        geoFence.setPointList(arrayList2);
        geoFence.setCenter(dPoint);
        geoFence.setPendingIntentAction(this.f7029d);
        geoFence.setExpiration(-1L);
        geoFence.setPendingIntent(this.f7028c);
        StringBuilder sb = new StringBuilder();
        sb.append(d1.c());
        geoFence.setFenceId(sb.toString());
        h hVar = this.f7026a;
        if (hVar != null) {
            hVar.a(this.f7027b, 2);
        }
        return geoFence;
    }

    private void f0() {
        try {
            synchronized (this.f7035j) {
                b bVar = this.f7037l;
                if (bVar != null) {
                    bVar.removeCallbacksAndMessages(null);
                }
                this.f7037l = null;
            }
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "GeoFenceManager", "destroyActionHandler");
        }
    }

    private void g0() {
        if (this.f7051z || this.f7037l == null) {
            return;
        }
        if (i0()) {
            j(6, null, 0L);
            j(5, null, 0L);
            return;
        }
        D(7);
        j(7, null, 0L);
    }

    private void h0() {
        try {
            if (this.f7039n) {
                D(8);
            }
            AMapLocationClient aMapLocationClient = this.f7044s;
            if (aMapLocationClient != null) {
                aMapLocationClient.stopLocation();
            }
            this.f7039n = false;
        } catch (Throwable unused) {
        }
    }

    private boolean i0() {
        return this.f7045t != null && j.a(this.f7045t) && j.b() - this.f7046u < ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT;
    }

    static void p(String str, int i4, String str2, String... strArr) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("===========================================\n");
        stringBuffer.append("              " + str + "                ");
        stringBuffer.append("\n");
        stringBuffer.append("-------------------------------------------\n");
        stringBuffer.append("errorCode:".concat(String.valueOf(i4)));
        stringBuffer.append("\n");
        stringBuffer.append("\u9519\u8bef\u4fe1\u606f:".concat(String.valueOf(str2)));
        stringBuffer.append("\n");
        if (strArr.length > 0) {
            for (String str3 : strArr) {
                stringBuffer.append(str3);
                stringBuffer.append("\n");
            }
        }
        stringBuffer.append("===========================================\n");
        Log.i("fenceErrLog", stringBuffer.toString());
    }

    private static boolean v(int i4, String str, String str2, DPoint dPoint) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (i4 != 1) {
            if (i4 == 2) {
                if (dPoint == null) {
                    return false;
                }
                if (dPoint.getLatitude() > 90.0d || dPoint.getLatitude() < -90.0d || dPoint.getLongitude() > 180.0d || dPoint.getLongitude() < -180.0d) {
                    p("\u6dfb\u52a0\u56f4\u680f\u5931\u8d25", 0, "\u7ecf\u7eac\u5ea6\u9519\u8bef\uff0c\u4f20\u5165\u7684\u7eac\u5ea6\uff1a" + dPoint.getLatitude() + "\u4f20\u5165\u7684\u7ecf\u5ea6:" + dPoint.getLongitude(), new String[0]);
                    return false;
                }
            }
        } else if (TextUtils.isEmpty(str2)) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0025, code lost:
        if (r4.getStatus() == 3) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean x(com.amap.api.fence.GeoFence r4, int r5) {
        /*
            r0 = r5 & 1
            r1 = 1
            r2 = 0
            if (r0 != r1) goto L10
            int r0 = r4.getStatus()     // Catch: java.lang.Throwable -> Le
            if (r0 != r1) goto L10
            r2 = 1
            goto L10
        Le:
            r4 = move-exception
            goto L28
        L10:
            r0 = r5 & 2
            r3 = 2
            if (r0 != r3) goto L1c
            int r0 = r4.getStatus()     // Catch: java.lang.Throwable -> Le
            if (r0 != r3) goto L1c
            r2 = 1
        L1c:
            r0 = 4
            r5 = r5 & r0
            if (r5 != r0) goto L30
            int r4 = r4.getStatus()     // Catch: java.lang.Throwable -> Le
            r5 = 3
            if (r4 != r5) goto L30
            goto L31
        L28:
            java.lang.String r5 = "Utils"
            java.lang.String r0 = "remindStatus"
            com.autonavi.aps.amapapi.utils.b.a(r4, r5, r0)
            goto L32
        L30:
            r1 = r2
        L31:
            r2 = r1
        L32:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003l.a.x(com.amap.api.fence.GeoFence, int):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0056, code lost:
        if (z(r4, r5.getCenter(), r5.getRadius()) != false) goto L31;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean y(com.amap.api.location.AMapLocation r4, com.amap.api.fence.GeoFence r5) {
        /*
            r0 = 1
            r1 = 0
            boolean r2 = com.autonavi.aps.amapapi.utils.j.a(r4)     // Catch: java.lang.Throwable -> L5b
            if (r2 == 0) goto L59
            if (r5 == 0) goto L59
            java.util.List r2 = r5.getPointList()     // Catch: java.lang.Throwable -> L5b
            if (r2 == 0) goto L59
            java.util.List r2 = r5.getPointList()     // Catch: java.lang.Throwable -> L5b
            boolean r2 = r2.isEmpty()     // Catch: java.lang.Throwable -> L5b
            if (r2 != 0) goto L59
            int r2 = r5.getType()     // Catch: java.lang.Throwable -> L5b
            if (r2 == 0) goto L4a
            if (r2 == r0) goto L29
            r3 = 2
            if (r2 == r3) goto L4a
            r3 = 3
            if (r2 == r3) goto L29
            goto L59
        L29:
            java.util.List r5 = r5.getPointList()     // Catch: java.lang.Throwable -> L5b
            java.util.Iterator r5 = r5.iterator()     // Catch: java.lang.Throwable -> L5b
        L31:
            boolean r2 = r5.hasNext()     // Catch: java.lang.Throwable -> L47
            if (r2 == 0) goto L45
            java.lang.Object r2 = r5.next()     // Catch: java.lang.Throwable -> L47
            java.util.List r2 = (java.util.List) r2     // Catch: java.lang.Throwable -> L47
            boolean r2 = I(r4, r2)     // Catch: java.lang.Throwable -> L47
            if (r2 == 0) goto L31
            r1 = 1
            goto L31
        L45:
            r0 = r1
            goto L64
        L47:
            r4 = move-exception
            r0 = r1
            goto L5d
        L4a:
            com.amap.api.location.DPoint r2 = r5.getCenter()     // Catch: java.lang.Throwable -> L5b
            float r5 = r5.getRadius()     // Catch: java.lang.Throwable -> L5b
            boolean r4 = z(r4, r2, r5)     // Catch: java.lang.Throwable -> L5b
            if (r4 == 0) goto L59
            goto L64
        L59:
            r0 = 0
            goto L64
        L5b:
            r4 = move-exception
            r0 = 0
        L5d:
            java.lang.String r5 = "Utils"
            java.lang.String r1 = "isInGeoFence"
            com.autonavi.aps.amapapi.utils.b.a(r4, r5, r1)
        L64:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003l.a.y(com.amap.api.location.AMapLocation, com.amap.api.fence.GeoFence):boolean");
    }

    private static boolean z(AMapLocation aMapLocation, DPoint dPoint, float f4) {
        return j.a(new double[]{dPoint.getLatitude(), dPoint.getLongitude(), aMapLocation.getLatitude(), aMapLocation.getLongitude()}) <= f4;
    }

    public final List<GeoFence> C() {
        try {
            if (this.f7033h == null) {
                this.f7033h = new ArrayList<>();
            }
            return (ArrayList) this.f7033h.clone();
        } catch (Throwable unused) {
            return new ArrayList();
        }
    }

    final void D(int i4) {
        try {
            synchronized (this.f7035j) {
                b bVar = this.f7037l;
                if (bVar != null) {
                    bVar.removeMessages(i4);
                }
            }
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "GeoFenceManager", "removeActionHandlerMessage");
        }
    }

    final void F(Bundle bundle) {
        String str;
        try {
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
            String str2 = "";
            int i4 = 1;
            if (bundle != null && !bundle.isEmpty()) {
                DPoint dPoint = (DPoint) bundle.getParcelable("centerPoint");
                str = bundle.getString("customId");
                if (dPoint != null) {
                    if (dPoint.getLatitude() <= 90.0d && dPoint.getLatitude() >= -90.0d && dPoint.getLongitude() <= 180.0d && dPoint.getLongitude() >= -180.0d) {
                        GeoFence f4 = f(bundle, false);
                        i4 = J(f4);
                        if (i4 == 0) {
                            arrayList.add(f4);
                        }
                        Bundle bundle2 = new Bundle();
                        bundle2.putInt("errorCode", i4);
                        bundle2.putParcelableArrayList("resultList", arrayList);
                        bundle2.putString("customId", str);
                        i(1000, bundle2);
                    }
                    p("\u6dfb\u52a0\u56f4\u680f\u5931\u8d25", 1, "\u7ecf\u7eac\u5ea6\u9519\u8bef\uff0c\u4f20\u5165\u7684\u7eac\u5ea6\uff1a" + dPoint.getLatitude() + "\u4f20\u5165\u7684\u7ecf\u5ea6:" + dPoint.getLongitude(), new String[0]);
                    Bundle bundle22 = new Bundle();
                    bundle22.putInt("errorCode", i4);
                    bundle22.putParcelableArrayList("resultList", arrayList);
                    bundle22.putString("customId", str);
                    i(1000, bundle22);
                }
                str2 = str;
            }
            str = str2;
            Bundle bundle222 = new Bundle();
            bundle222.putInt("errorCode", i4);
            bundle222.putParcelableArrayList("resultList", arrayList);
            bundle222.putString("customId", str);
            i(1000, bundle222);
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "GeoFenceManager", "doAddGeoFenceRound");
        }
    }

    final void G(GeoFence geoFence) {
        try {
            synchronized (this.f7031f) {
                if (this.f7027b != null) {
                    if (this.f7028c == null && geoFence.getPendingIntent() == null) {
                        return;
                    }
                    Intent intent = new Intent();
                    intent.putExtras(e(geoFence, geoFence.getFenceId(), geoFence.getCustomId(), geoFence.getStatus(), 0));
                    String str = this.f7029d;
                    if (str != null) {
                        intent.setAction(str);
                    }
                    intent.setPackage(e4.g(this.f7027b));
                    if (geoFence.getPendingIntent() != null) {
                        geoFence.getPendingIntent().send(this.f7027b, 0, intent);
                    } else {
                        this.f7028c.send(this.f7027b, 0, intent);
                    }
                }
            }
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "GeoFenceManager", "resultTriggerGeoFence");
        }
    }

    final void K() {
        if (this.f7040o) {
            ArrayList<GeoFence> arrayList = this.f7033h;
            if (arrayList != null) {
                arrayList.clear();
                this.f7033h = null;
            }
            if (this.f7041p) {
                return;
            }
            f0();
            AMapLocationClient aMapLocationClient = this.f7044s;
            if (aMapLocationClient != null) {
                aMapLocationClient.stopLocation();
                this.f7044s.onDestroy();
            }
            this.f7044s = null;
            c cVar = this.f7038m;
            if (cVar != null) {
                if (Build.VERSION.SDK_INT >= 18) {
                    cVar.quitSafely();
                } else {
                    cVar.quit();
                }
            }
            this.f7038m = null;
            this.f7042q = null;
            synchronized (this.f7031f) {
                PendingIntent pendingIntent = this.f7028c;
                if (pendingIntent != null) {
                    pendingIntent.cancel();
                }
                this.f7028c = null;
            }
            e0();
            h hVar = this.f7026a;
            if (hVar != null) {
                hVar.b(this.f7027b);
            }
            this.f7039n = false;
            this.f7040o = false;
        }
    }

    final void L(int i4) {
        try {
            if (this.f7027b != null) {
                synchronized (this.f7031f) {
                    if (this.f7028c == null) {
                        return;
                    }
                    Intent intent = new Intent();
                    intent.putExtras(e(null, null, null, 4, i4));
                    this.f7028c.send(this.f7027b, 0, intent);
                }
            }
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "GeoFenceManager", "resultRemindLocationError");
        }
    }

    final void M(Bundle bundle) {
        GeoFence f4;
        try {
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
            String str = "";
            int i4 = 1;
            if (bundle != null && !bundle.isEmpty()) {
                ArrayList parcelableArrayList = bundle.getParcelableArrayList("pointList");
                String string = bundle.getString("customId");
                if (parcelableArrayList != null && parcelableArrayList.size() > 2 && (i4 = J((f4 = f(bundle, true)))) == 0) {
                    arrayList.add(f4);
                }
                str = string;
            }
            Bundle bundle2 = new Bundle();
            bundle2.putString("customId", str);
            bundle2.putInt("errorCode", i4);
            bundle2.putParcelableArrayList("resultList", arrayList);
            i(1000, bundle2);
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "GeoFenceManager", "doAddGeoFencePolygon");
        }
    }

    final void O() {
        try {
            if (this.f7044s != null) {
                h0();
                this.f7047v.setLocationCacheEnable(true);
                this.f7047v.setNeedAddress(false);
                this.f7047v.setOnceLocation(true);
                this.f7044s.setLocationOption(this.f7047v);
                this.f7044s.startLocation();
            }
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "GeoFenceManager", "doStartOnceLocation");
        }
    }

    final void P(Bundle bundle) {
        E(2, bundle);
    }

    final void R() {
        try {
            if (!this.f7051z && j.a(this.f7045t)) {
                float a4 = a(this.f7045t, this.f7033h);
                if (a4 == Float.MAX_VALUE) {
                    return;
                }
                if (a4 < 1000.0f) {
                    D(7);
                    Bundle bundle = new Bundle();
                    bundle.putLong("interval", 2000L);
                    j(8, bundle, 500L);
                } else if (a4 < 5000.0f) {
                    h0();
                    D(7);
                    j(7, null, ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT);
                } else {
                    h0();
                    D(7);
                    j(7, null, ((a4 - 4000.0f) / 100.0f) * 1000.0f);
                }
            }
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "GeoFenceManager", "doCheckLocationPolicy");
        }
    }

    final void S(Bundle bundle) {
        E(1, bundle);
    }

    public final void T() {
        try {
            b0();
            this.f7051z = true;
            j(13, null, 0L);
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "GeoFenceManager", "pauseGeoFence");
        }
    }

    final void U(Bundle bundle) {
        E(3, bundle);
    }

    final void V() {
        try {
            D(7);
            D(8);
            AMapLocationClient aMapLocationClient = this.f7044s;
            if (aMapLocationClient != null) {
                aMapLocationClient.stopLocation();
            }
            this.f7039n = false;
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "GeoFenceManager", "doPauseGeoFence");
        }
    }

    final void W(Bundle bundle) {
        if (bundle != null) {
            try {
                if (bundle.isEmpty()) {
                    return;
                }
                String string = bundle.getString("fid");
                if (TextUtils.isEmpty(string)) {
                    return;
                }
                boolean z3 = bundle.getBoolean("ab", true);
                ArrayList<GeoFence> arrayList = this.f7033h;
                if (arrayList != null && !arrayList.isEmpty()) {
                    Iterator<GeoFence> it = this.f7033h.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        GeoFence next = it.next();
                        if (next.getFenceId().equals(string)) {
                            next.setAble(z3);
                            break;
                        }
                    }
                }
                if (!z3) {
                    if (d0()) {
                        V();
                        return;
                    }
                    return;
                }
                g0();
            } catch (Throwable th) {
                com.autonavi.aps.amapapi.utils.b.a(th, "GeoFenceManager", "doSetGeoFenceAble");
            }
        }
    }

    public final void X() {
        try {
            b0();
            if (this.f7051z) {
                this.f7051z = false;
                g0();
            }
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "GeoFenceManager", "resumeGeoFence");
        }
    }

    final void Y(Bundle bundle) {
        try {
            if (this.f7033h != null) {
                GeoFence geoFence = (GeoFence) bundle.getParcelable("fc");
                if (this.f7033h.contains(geoFence)) {
                    this.f7033h.remove(geoFence);
                }
                if (this.f7033h.size() <= 0) {
                    K();
                } else {
                    g0();
                }
            }
        } catch (Throwable unused) {
        }
    }

    final void Z(Bundle bundle) {
        if (bundle != null) {
            try {
                if (bundle.isEmpty()) {
                    return;
                }
                int i4 = bundle.getInt("errorCode");
                ArrayList parcelableArrayList = bundle.getParcelableArrayList("resultList");
                if (parcelableArrayList == null) {
                    parcelableArrayList = new ArrayList();
                }
                String string = bundle.getString("customId");
                if (string == null) {
                    string = "";
                }
                GeoFenceListener geoFenceListener = this.f7030e;
                if (geoFenceListener != null) {
                    geoFenceListener.onGeoFenceCreateFinished((ArrayList) parcelableArrayList.clone(), i4, string);
                }
                if (i4 == 0) {
                    g0();
                }
            } catch (Throwable th) {
                com.autonavi.aps.amapapi.utils.b.a(th, "GeoFenceManager", "resultAddGeoFenceFinished");
            }
        }
    }

    public final boolean a0() {
        return this.f7051z;
    }

    final void c0(Bundle bundle) {
        try {
            if (this.f7044s != null) {
                long j4 = 2000;
                if (bundle != null && !bundle.isEmpty()) {
                    j4 = bundle.getLong("interval", 2000L);
                }
                this.f7047v.setOnceLocation(false);
                this.f7047v.setInterval(j4);
                this.f7047v.setLocationCacheEnable(true);
                this.f7047v.setNeedAddress(false);
                this.f7044s.setLocationOption(this.f7047v);
                if (this.f7039n) {
                    return;
                }
                this.f7044s.stopLocation();
                this.f7044s.startLocation();
                this.f7039n = true;
            }
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "GeoFenceManager", "doStartContinueLocation");
        }
    }

    public final PendingIntent d(String str) {
        synchronized (this.f7031f) {
            try {
                Intent intent = new Intent(str);
                intent.setPackage(e4.g(this.f7027b));
                if (Build.VERSION.SDK_INT >= 31 && this.f7027b.getApplicationInfo().targetSdkVersion >= 31) {
                    this.f7028c = PendingIntent.getBroadcast(this.f7027b, 0, intent, 33554432);
                } else {
                    this.f7028c = PendingIntent.getBroadcast(this.f7027b, 0, intent, 0);
                }
                this.f7029d = str;
                ArrayList<GeoFence> arrayList = this.f7033h;
                if (arrayList != null && !arrayList.isEmpty()) {
                    Iterator<GeoFence> it = this.f7033h.iterator();
                    while (it.hasNext()) {
                        GeoFence next = it.next();
                        next.setPendingIntent(this.f7028c);
                        next.setPendingIntentAction(this.f7029d);
                    }
                }
            }
        }
        return this.f7028c;
    }

    public final void g() {
        try {
            this.f7041p = false;
            j(10, null, 0L);
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "GeoFenceManager", "removeGeoFence");
        }
    }

    public final void h(int i4) {
        try {
            b0();
            i4 = (i4 > 7 || i4 <= 0) ? 1 : 1;
            Bundle bundle = new Bundle();
            bundle.putInt("activatesAction", i4);
            j(9, bundle, 0L);
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "GeoFenceManager", "setActivateAction");
        }
    }

    final void i(int i4, Bundle bundle) {
        try {
            synchronized (this.f7036k) {
                d dVar = this.f7034i;
                if (dVar != null) {
                    Message obtainMessage = dVar.obtainMessage();
                    obtainMessage.what = i4;
                    obtainMessage.setData(bundle);
                    this.f7034i.sendMessage(obtainMessage);
                }
            }
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "GeoFenceManager", "sendResultHandlerMessage");
        }
    }

    final void j(int i4, Bundle bundle, long j4) {
        try {
            synchronized (this.f7035j) {
                b bVar = this.f7037l;
                if (bVar != null) {
                    Message obtainMessage = bVar.obtainMessage();
                    obtainMessage.what = i4;
                    obtainMessage.setData(bundle);
                    this.f7037l.sendMessageDelayed(obtainMessage, j4);
                }
            }
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "GeoFenceManager", "sendActionHandlerMessage");
        }
    }

    final void k(Bundle bundle) {
        int i4 = 1;
        if (bundle != null) {
            try {
                i4 = bundle.getInt("activatesAction", 1);
            } catch (Throwable th) {
                com.autonavi.aps.amapapi.utils.b.a(th, "GeoFenceManager", "doSetActivatesAction");
                return;
            }
        }
        if (this.f7032g != i4) {
            ArrayList<GeoFence> arrayList = this.f7033h;
            if (arrayList != null && !arrayList.isEmpty()) {
                Iterator<GeoFence> it = this.f7033h.iterator();
                while (it.hasNext()) {
                    GeoFence next = it.next();
                    next.setStatus(0);
                    next.setEnterTime(-1L);
                }
            }
            g0();
        }
        this.f7032g = i4;
    }

    public final void l(GeoFenceListener geoFenceListener) {
        try {
            this.f7030e = geoFenceListener;
        } catch (Throwable unused) {
        }
    }

    final void m(AMapLocation aMapLocation) {
        ArrayList<GeoFence> arrayList;
        try {
            if (this.f7051z || (arrayList = this.f7033h) == null || arrayList.isEmpty() || aMapLocation == null || aMapLocation.getErrorCode() != 0) {
                return;
            }
            Iterator<GeoFence> it = this.f7033h.iterator();
            while (it.hasNext()) {
                GeoFence next = it.next();
                if (next.isAble() && H(aMapLocation, next) && x(next, this.f7032g)) {
                    next.setCurrentLocation(aMapLocation);
                    Q(next);
                }
            }
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "GeoFenceManager", "doCheckFence");
        }
    }

    public final void n(AMapLocationClientOption aMapLocationClientOption) {
        try {
            this.f7047v = aMapLocationClientOption.m16clone();
        } catch (Throwable unused) {
        }
    }

    public final void o(DPoint dPoint, float f4, String str) {
        try {
            b0();
            Bundle bundle = new Bundle();
            bundle.putParcelable("centerPoint", dPoint);
            bundle.putFloat("fenceRadius", f4);
            bundle.putString("customId", str);
            j(0, bundle, 0L);
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "GeoFenceManager", "addRoundGeoFence");
        }
    }

    public final void q(String str, String str2) {
        try {
            b0();
            Bundle bundle = new Bundle();
            bundle.putString("keyWords", str);
            bundle.putString("customId", str2);
            j(4, bundle, 0L);
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "GeoFenceManager", "addDistricetGeoFence");
        }
    }

    public final void r(String str, String str2, DPoint dPoint, float f4, int i4, String str3) {
        try {
            b0();
            f4 = (f4 <= 0.0f || f4 > 50000.0f) ? 3000.0f : 3000.0f;
            if (i4 <= 0) {
                i4 = 10;
            }
            if (i4 > 25) {
                i4 = 25;
            }
            Bundle bundle = new Bundle();
            bundle.putString("keyWords", str);
            bundle.putString("poiType", str2);
            bundle.putParcelable("centerPoint", dPoint);
            bundle.putFloat("aroundRadius", f4);
            bundle.putInt("searchSize", i4);
            bundle.putString("customId", str3);
            j(3, bundle, 0L);
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "GeoFenceManager", "addNearbyGeoFence");
        }
    }

    public final void s(String str, String str2, String str3, int i4, String str4) {
        try {
            b0();
            if (i4 <= 0) {
                i4 = 10;
            }
            if (i4 > 25) {
                i4 = 25;
            }
            Bundle bundle = new Bundle();
            bundle.putString("keyWords", str);
            bundle.putString("poiType", str2);
            bundle.putString("city", str3);
            bundle.putInt("searchSize", i4);
            bundle.putString("customId", str4);
            j(2, bundle, 0L);
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "GeoFenceManager", "addKeywordGeoFence");
        }
    }

    public final void t(String str, boolean z3) {
        try {
            b0();
            Bundle bundle = new Bundle();
            bundle.putString("fid", str);
            bundle.putBoolean("ab", z3);
            j(12, bundle, 0L);
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "GeoFenceManager", "setGeoFenceAble");
        }
    }

    public final void u(List<DPoint> list, String str) {
        try {
            b0();
            Bundle bundle = new Bundle();
            bundle.putParcelableArrayList("pointList", new ArrayList<>(list));
            bundle.putString("customId", str);
            j(1, bundle, 0L);
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "GeoFenceManager", "addPolygonGeoFence");
        }
    }

    public final boolean w(GeoFence geoFence) {
        try {
            ArrayList<GeoFence> arrayList = this.f7033h;
            if (arrayList != null && !arrayList.isEmpty()) {
                if (this.f7033h.contains(geoFence)) {
                    if (this.f7033h.size() == 1) {
                        this.f7041p = false;
                    }
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("fc", geoFence);
                    j(11, bundle, 0L);
                    return true;
                }
                return false;
            }
            this.f7041p = false;
            j(10, null, 0L);
            return true;
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "GeoFenceManager", "removeGeoFence(GeoFence)");
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* compiled from: GeoFenceManager.java */
    /* renamed from: com.amap.api.col.3l.a$d */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public class d extends Handler {
        public d(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            try {
                Bundle data = message.getData();
                switch (message.what) {
                    case 1000:
                        a.this.Z(data);
                        return;
                    case 1001:
                        a.this.G((GeoFence) data.getParcelable("geoFence"));
                        return;
                    case 1002:
                        a.this.L(data.getInt("location_errorcode"));
                        return;
                    default:
                        return;
                }
            } catch (Throwable unused) {
            }
        }

        public d() {
        }
    }
}

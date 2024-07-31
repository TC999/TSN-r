package com.amap.api.col.p0463l;

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
import com.amap.api.services.district.DistrictSearchQuery;
import com.autonavi.aps.amapapi.utils.C2428b;
import com.autonavi.aps.amapapi.utils.C2432j;
import com.autonavi.aps.amapapi.utils.ReportUtil;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.clj.fastble.BleManager;
import com.github.mikephil.charting.utils.Utils;
import com.snail.antifake.deviceid.ShellAdbUtils;
import com.stub.StubApp;
import com.umeng.analytics.pro.UMCommonContent;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IMediaPlayer;

@SuppressLint({"NewApi"})
/* renamed from: com.amap.api.col.3l.a */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class GeoFenceManager {

    /* renamed from: A */
    private static boolean f3448A;

    /* renamed from: b */
    Context f3450b;

    /* renamed from: a */
    ReportUtil f3449a = null;

    /* renamed from: c */
    PendingIntent f3451c = null;

    /* renamed from: d */
    String f3452d = null;

    /* renamed from: e */
    GeoFenceListener f3453e = null;

    /* renamed from: f */
    private Object f3454f = new Object();

    /* renamed from: g */
    volatile int f3455g = 1;

    /* renamed from: h */
    ArrayList<GeoFence> f3456h = new ArrayList<>();

    /* renamed from: i */
    HandlerC1730d f3457i = null;

    /* renamed from: j */
    Object f3458j = new Object();

    /* renamed from: k */
    Object f3459k = new Object();

    /* renamed from: l */
    HandlerC1728b f3460l = null;

    /* renamed from: m */
    HandlerThreadC1729c f3461m = null;

    /* renamed from: n */
    volatile boolean f3462n = false;

    /* renamed from: o */
    volatile boolean f3463o = false;

    /* renamed from: p */
    volatile boolean f3464p = false;

    /* renamed from: q */
    GeoFenceNetManager f3465q = null;

    /* renamed from: r */
    GeoFenceSearchResultParser f3466r = null;

    /* renamed from: s */
    AMapLocationClient f3467s = null;

    /* renamed from: t */
    volatile AMapLocation f3468t = null;

    /* renamed from: u */
    long f3469u = 0;

    /* renamed from: v */
    AMapLocationClientOption f3470v = null;

    /* renamed from: w */
    int f3471w = 0;

    /* renamed from: x */
    AMapLocationListener f3472x = new C1727a();

    /* renamed from: y */
    final int f3473y = 3;

    /* renamed from: z */
    volatile boolean f3474z = false;

    /* compiled from: GeoFenceManager.java */
    /* renamed from: com.amap.api.col.3l.a$a */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    final class C1727a implements AMapLocationListener {
        C1727a() {
        }

        @Override // com.amap.api.location.AMapLocationListener
        public final void onLocationChanged(AMapLocation aMapLocation) {
            boolean z;
            int i;
            try {
                if (!GeoFenceManager.this.f3474z && GeoFenceManager.this.f3464p) {
                    GeoFenceManager.this.f3468t = aMapLocation;
                    if (aMapLocation != null) {
                        i = aMapLocation.getErrorCode();
                        if (aMapLocation.getErrorCode() == 0) {
                            GeoFenceManager.this.f3469u = C2432j.m51186b();
                            GeoFenceManager.this.m55796j(5, null, 0L);
                            z = true;
                        } else {
                            int errorCode = aMapLocation.getErrorCode();
                            String errorInfo = aMapLocation.getErrorInfo();
                            GeoFenceManager.m55790p("定位失败", errorCode, errorInfo, "locationDetail:" + aMapLocation.getLocationDetail());
                            z = false;
                        }
                    } else {
                        z = false;
                        i = 8;
                    }
                    if (z) {
                        GeoFenceManager geoFenceManager = GeoFenceManager.this;
                        geoFenceManager.f3471w = 0;
                        geoFenceManager.m55796j(6, null, 0L);
                        return;
                    }
                    Bundle bundle = new Bundle();
                    if (!GeoFenceManager.this.f3462n) {
                        GeoFenceManager.this.m55837D(7);
                        bundle.putLong(UMCommonContent.f37794aX, 2000L);
                        GeoFenceManager.this.m55796j(8, bundle, 2000L);
                    }
                    GeoFenceManager geoFenceManager2 = GeoFenceManager.this;
                    int i2 = geoFenceManager2.f3471w + 1;
                    geoFenceManager2.f3471w = i2;
                    if (i2 >= 3) {
                        bundle.putInt(GeoFence.BUNDLE_KEY_LOCERRORCODE, i);
                        GeoFenceManager.this.m55798i(1002, bundle);
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: GeoFenceManager.java */
    /* renamed from: com.amap.api.col.3l.a$b */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public class HandlerC1728b extends Handler {
        public HandlerC1728b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            try {
                switch (message.what) {
                    case 0:
                        GeoFenceManager.this.m55835F(message.getData());
                        return;
                    case 1:
                        GeoFenceManager.this.m55828M(message.getData());
                        return;
                    case 2:
                        GeoFenceManager.this.m55822S(message.getData());
                        return;
                    case 3:
                        GeoFenceManager.this.m55825P(message.getData());
                        return;
                    case 4:
                        GeoFenceManager.this.m55820U(message.getData());
                        return;
                    case 5:
                        GeoFenceManager.this.m55823R();
                        return;
                    case 6:
                        GeoFenceManager geoFenceManager = GeoFenceManager.this;
                        geoFenceManager.m55793m(geoFenceManager.f3468t);
                        return;
                    case 7:
                        GeoFenceManager.this.m55826O();
                        return;
                    case 8:
                        GeoFenceManager.this.m55809c0(message.getData());
                        return;
                    case 9:
                        GeoFenceManager.this.m55795k(message.getData());
                        return;
                    case 10:
                        GeoFenceManager.this.m55830K();
                        return;
                    case 11:
                        GeoFenceManager.this.m55816Y(message.getData());
                        return;
                    case 12:
                        GeoFenceManager.this.m55818W(message.getData());
                        return;
                    case 13:
                        GeoFenceManager.this.m55819V();
                        return;
                    default:
                        return;
                }
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: GeoFenceManager.java */
    /* renamed from: com.amap.api.col.3l.a$c */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public static class HandlerThreadC1729c extends HandlerThread {
        public HandlerThreadC1729c(String str) {
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

    public GeoFenceManager(Context context) {
        this.f3450b = null;
        try {
            this.f3450b = StubApp.getOrigApplicationContext(context.getApplicationContext());
            m55811b0();
        } catch (Throwable th) {
            C2428b.m51299a(th, "GeoFenceManger", "<init>");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: A */
    public static float m55840A(DPoint dPoint, List<DPoint> list) {
        float f = Float.MIN_VALUE;
        if (dPoint != null && list != null && !list.isEmpty()) {
            for (DPoint dPoint2 : list) {
                f = Math.max(f, C2432j.m51195a(dPoint, dPoint2));
            }
        }
        return f;
    }

    /* renamed from: B */
    private static DPoint m55839B(List<DPoint> list) {
        DPoint dPoint = new DPoint();
        if (list != null) {
            try {
                double d = Utils.DOUBLE_EPSILON;
                double d2 = 0.0d;
                for (DPoint dPoint2 : list) {
                    d += dPoint2.getLatitude();
                    d2 += dPoint2.getLongitude();
                }
                double size = list.size();
                Double.isNaN(size);
                double m51185b = C2432j.m51185b(d / size);
                double size2 = list.size();
                Double.isNaN(size2);
                return new DPoint(m51185b, C2432j.m51185b(d2 / size2));
            } catch (Throwable th) {
                C2428b.m51299a(th, "GeoFenceUtil", "getPolygonCenter");
                return dPoint;
            }
        }
        return dPoint;
    }

    /* renamed from: E */
    private void m55836E(int i, Bundle bundle) {
        String str;
        int i2;
        String str2;
        int i3;
        String str3;
        String str4;
        String m55421b;
        Bundle bundle2 = new Bundle();
        try {
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
            if (bundle == null || bundle.isEmpty()) {
                str2 = "errorCode";
                i3 = 1;
            } else {
                List<GeoFence> arrayList2 = new ArrayList<>();
                String string = bundle.getString(GeoFence.BUNDLE_KEY_CUSTOMID);
                String string2 = bundle.getString("keyWords");
                String string3 = bundle.getString(DistrictSearchQuery.KEYWORDS_CITY);
                String string4 = bundle.getString("poiType");
                DPoint dPoint = (DPoint) bundle.getParcelable("centerPoint");
                int i4 = bundle.getInt("searchSize", 10);
                float f = bundle.getFloat("aroundRadius", 3000.0f);
                if (m55784v(i, string2, string4, dPoint)) {
                    Bundle bundle3 = new Bundle();
                    bundle3.putString(GeoFence.BUNDLE_KEY_CUSTOMID, string);
                    bundle3.putString("pendingIntentAction", this.f3452d);
                    str3 = GeoFence.BUNDLE_KEY_CUSTOMID;
                    str4 = "errorCode";
                    try {
                        bundle3.putLong("expiration", -1L);
                        bundle3.putInt("activatesAction", this.f3455g);
                        if (i == 1) {
                            bundle3.putFloat("fenceRadius", 1000.0f);
                            m55421b = this.f3465q.m55421b(this.f3450b, "http://restsdk.amap.com/v3/place/text?", string2, string4, string3, String.valueOf(i4));
                        } else if (i != 2) {
                            m55421b = i != 3 ? null : this.f3465q.m55422a(this.f3450b, "http://restsdk.amap.com/v3/config/district?", string2);
                        } else {
                            double m51185b = C2432j.m51185b(dPoint.getLatitude());
                            double m51185b2 = C2432j.m51185b(dPoint.getLongitude());
                            int intValue = Float.valueOf(f).intValue();
                            bundle3.putFloat("fenceRadius", 200.0f);
                            m55421b = this.f3465q.m55420c(this.f3450b, "http://restsdk.amap.com/v3/place/around?", string2, string4, String.valueOf(i4), String.valueOf(m51185b), String.valueOf(m51185b2), String.valueOf(intValue));
                        }
                        if (m55421b != null) {
                            int m55416b = 1 == i ? GeoFenceSearchResultParser.m55416b(m55421b, arrayList2, bundle3) : 0;
                            if (2 == i) {
                                m55416b = GeoFenceSearchResultParser.m55413e(m55421b, arrayList2, bundle3);
                            }
                            if (3 == i) {
                                m55416b = this.f3466r.m55412f(m55421b, arrayList2, bundle3);
                            }
                            if (m55416b == 10000) {
                                if (arrayList2.isEmpty()) {
                                    i2 = 16;
                                } else {
                                    i2 = m55810c(arrayList2);
                                    if (i2 == 0) {
                                        try {
                                            arrayList.addAll(arrayList2);
                                        } catch (Throwable th) {
                                            th = th;
                                            str = str4;
                                            try {
                                                C2428b.m51299a(th, "GeoFenceManager", "doAddGeoFenceNearby");
                                                bundle2.putInt(str, 8);
                                                m55798i(1000, bundle2);
                                                return;
                                            } catch (Throwable th2) {
                                                bundle2.putInt(str, i2);
                                                m55798i(1000, bundle2);
                                                throw th2;
                                            }
                                        }
                                    }
                                }
                            } else {
                                i2 = m55827N(m55416b);
                            }
                        } else {
                            i2 = 4;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        str = str4;
                        i2 = 0;
                        C2428b.m51299a(th, "GeoFenceManager", "doAddGeoFenceNearby");
                        bundle2.putInt(str, 8);
                        m55798i(1000, bundle2);
                        return;
                    }
                } else {
                    str3 = GeoFence.BUNDLE_KEY_CUSTOMID;
                    str4 = "errorCode";
                    i2 = 1;
                }
                bundle2.putString(str3, string);
                bundle2.putParcelableArrayList("resultList", arrayList);
                i3 = i2;
                str2 = str4;
            }
            bundle2.putInt(str2, i3);
            m55798i(1000, bundle2);
        } catch (Throwable th4) {
            th = th4;
            str = "errorCode";
        }
    }

    /* renamed from: H */
    private static boolean m55833H(AMapLocation aMapLocation, GeoFence geoFence) {
        boolean z = true;
        try {
            if (m55781y(aMapLocation, geoFence)) {
                if (geoFence.getEnterTime() == -1) {
                    if (geoFence.getStatus() != 1) {
                        geoFence.setEnterTime(C2432j.m51186b());
                        geoFence.setStatus(1);
                    }
                    z = false;
                } else {
                    if (geoFence.getStatus() != 3 && C2432j.m51186b() - geoFence.getEnterTime() > TTAdConstant.AD_MAX_EVENT_TIME) {
                        geoFence.setStatus(3);
                    }
                    z = false;
                }
            } else {
                if (geoFence.getStatus() != 2) {
                    try {
                        geoFence.setStatus(2);
                        geoFence.setEnterTime(-1L);
                    } catch (Throwable th) {
                        th = th;
                        C2428b.m51299a(th, "Utils", "isFenceStatusChanged");
                        return z;
                    }
                }
                z = false;
            }
        } catch (Throwable th2) {
            th = th2;
            z = false;
        }
        return z;
    }

    /* renamed from: I */
    private static boolean m55832I(AMapLocation aMapLocation, List<DPoint> list) {
        if (list.size() < 3) {
            return false;
        }
        return C2428b.m51301a(new DPoint(aMapLocation.getLatitude(), aMapLocation.getLongitude()), list);
    }

    /* renamed from: J */
    private int m55831J(GeoFence geoFence) {
        try {
            if (this.f3456h == null) {
                this.f3456h = new ArrayList<>();
            }
            if (this.f3456h.contains(geoFence)) {
                return 17;
            }
            this.f3456h.add(geoFence);
            return 0;
        } catch (Throwable th) {
            C2428b.m51299a(th, "GeoFenceManager", "addGeoFence2List");
            m55790p("添加围栏失败", 8, th.getMessage(), new String[0]);
            return 8;
        }
    }

    /* renamed from: N */
    private static int m55827N(int i) {
        if (i != 1 && i != 7 && i != 4 && i != 5 && i != 16 && i != 17) {
            switch (i) {
                case BleManager.f22896l /* 10000 */:
                    i = 0;
                    break;
                case 10001:
                case 10002:
                case 10007:
                case IMediaPlayer.MEDIA_INFO_VIDEO_SEEK_RENDERING_START /* 10008 */:
                case IMediaPlayer.MEDIA_INFO_AUDIO_SEEK_RENDERING_START /* 10009 */:
                case 10012:
                case 10013:
                    i = 7;
                    break;
                case 10003:
                case IMediaPlayer.MEDIA_INFO_VIDEO_DECODED_START /* 10004 */:
                case IMediaPlayer.MEDIA_INFO_OPEN_INPUT /* 10005 */:
                case IMediaPlayer.MEDIA_INFO_FIND_STREAM_INFO /* 10006 */:
                case 10010:
                case 10011:
                case 10014:
                case 10015:
                case 10016:
                case 10017:
                    i = 4;
                    break;
                default:
                    switch (i) {
                        case 20000:
                        case 20001:
                        case 20002:
                            i = 1;
                            break;
                        case 20003:
                        default:
                            i = 8;
                            break;
                    }
            }
        }
        if (i != 0) {
            m55790p("添加围栏失败", i, "searchErrCode is ".concat(String.valueOf(i)), new String[0]);
        }
        return i;
    }

    /* renamed from: Q */
    private void m55824Q(GeoFence geoFence) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("geoFence", geoFence);
        m55798i(1001, bundle);
    }

    /* renamed from: a */
    private static float m55814a(AMapLocation aMapLocation, List<GeoFence> list) {
        float f = Float.MAX_VALUE;
        if (aMapLocation != null && aMapLocation.getErrorCode() == 0 && list != null && !list.isEmpty()) {
            DPoint dPoint = new DPoint(aMapLocation.getLatitude(), aMapLocation.getLongitude());
            for (GeoFence geoFence : list) {
                if (geoFence.isAble()) {
                    float m51195a = C2432j.m51195a(dPoint, geoFence.getCenter());
                    if (m51195a > geoFence.getMinDis2Center() && m51195a < geoFence.getMaxDis2Center()) {
                        return 0.0f;
                    }
                    if (m51195a > geoFence.getMaxDis2Center()) {
                        f = Math.min(f, m51195a - geoFence.getMaxDis2Center());
                    }
                    if (m51195a < geoFence.getMinDis2Center()) {
                        f = Math.min(f, geoFence.getMinDis2Center() - m51195a);
                    }
                }
            }
        }
        return f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public static float m55812b(DPoint dPoint, List<DPoint> list) {
        float f = Float.MAX_VALUE;
        if (dPoint != null && list != null && !list.isEmpty()) {
            for (DPoint dPoint2 : list) {
                f = Math.min(f, C2432j.m51195a(dPoint, dPoint2));
            }
        }
        return f;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x002b -> B:38:0x0030). Please submit an issue!!! */
    /* renamed from: b0 */
    private void m55811b0() {
        if (!this.f3464p) {
            this.f3464p = true;
        }
        if (this.f3463o) {
            return;
        }
        try {
            if (Looper.myLooper() == null) {
                this.f3457i = new HandlerC1730d(this.f3450b.getMainLooper());
            } else {
                this.f3457i = new HandlerC1730d();
            }
        } catch (Throwable th) {
            C2428b.m51299a(th, "GeoFenceManger", "init 1");
        }
        try {
            HandlerThreadC1729c handlerThreadC1729c = new HandlerThreadC1729c("fenceActionThread");
            this.f3461m = handlerThreadC1729c;
            handlerThreadC1729c.setPriority(5);
            this.f3461m.start();
            this.f3460l = new HandlerC1728b(this.f3461m.getLooper());
        } catch (Throwable th2) {
            C2428b.m51299a(th2, "GeoFenceManger", "init 2");
        }
        try {
            this.f3465q = new GeoFenceNetManager(this.f3450b);
            this.f3466r = new GeoFenceSearchResultParser();
            this.f3470v = new AMapLocationClientOption();
            AMapLocationClient aMapLocationClient = new AMapLocationClient(this.f3450b);
            this.f3467s = aMapLocationClient;
            aMapLocationClient.setLocationListener(this.f3472x);
            if (this.f3449a == null) {
                this.f3449a = new ReportUtil();
            }
        } catch (Throwable th3) {
            C2428b.m51299a(th3, "GeoFenceManger", "initBase");
        }
        this.f3463o = true;
        try {
            String str = this.f3452d;
            if (str != null && this.f3451c == null) {
                m55808d(str);
            }
        } catch (Throwable th4) {
            C2428b.m51299a(th4, "GeoFenceManger", "init 4");
        }
        if (f3448A) {
            return;
        }
        f3448A = true;
        ReportUtil.m51236a(this.f3450b, "O020", (JSONObject) null);
    }

    /* renamed from: c */
    private int m55810c(List<GeoFence> list) {
        try {
            if (this.f3456h == null) {
                this.f3456h = new ArrayList<>();
            }
            for (GeoFence geoFence : list) {
                m55831J(geoFence);
            }
            return 0;
        } catch (Throwable th) {
            C2428b.m51299a(th, "GeoFenceManager", "addGeoFenceList");
            m55790p("添加围栏失败", 8, th.getMessage(), new String[0]);
            return 8;
        }
    }

    /* renamed from: d0 */
    private boolean m55807d0() {
        ArrayList<GeoFence> arrayList = this.f3456h;
        if (arrayList == null || arrayList.isEmpty()) {
            return true;
        }
        Iterator<GeoFence> it = this.f3456h.iterator();
        while (it.hasNext()) {
            if (it.next().isAble()) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: e */
    private static Bundle m55806e(GeoFence geoFence, String str, String str2, int i, int i2) {
        Bundle bundle = new Bundle();
        if (str == null) {
            str = "";
        }
        bundle.putString(GeoFence.BUNDLE_KEY_FENCEID, str);
        bundle.putString(GeoFence.BUNDLE_KEY_CUSTOMID, str2);
        bundle.putInt("event", i);
        bundle.putInt(GeoFence.BUNDLE_KEY_LOCERRORCODE, i2);
        bundle.putParcelable(GeoFence.BUNDLE_KEY_FENCE, geoFence);
        return bundle;
    }

    /* renamed from: e0 */
    private void m55805e0() {
        try {
            synchronized (this.f3459k) {
                HandlerC1730d handlerC1730d = this.f3457i;
                if (handlerC1730d != null) {
                    handlerC1730d.removeCallbacksAndMessages(null);
                }
                this.f3457i = null;
            }
        } catch (Throwable th) {
            C2428b.m51299a(th, "GeoFenceManager", "destroyResultHandler");
        }
    }

    /* renamed from: f */
    private GeoFence m55804f(Bundle bundle, boolean z) {
        GeoFence geoFence = new GeoFence();
        ArrayList arrayList = new ArrayList();
        DPoint dPoint = new DPoint();
        if (z) {
            geoFence.setType(1);
            arrayList = bundle.getParcelableArrayList("pointList");
            if (arrayList != null) {
                dPoint = m55839B(arrayList);
            }
            geoFence.setMaxDis2Center(m55840A(dPoint, arrayList));
            geoFence.setMinDis2Center(m55812b(dPoint, arrayList));
        } else {
            geoFence.setType(0);
            dPoint = (DPoint) bundle.getParcelable("centerPoint");
            if (dPoint != null) {
                arrayList.add(dPoint);
            }
            float f = bundle.getFloat("fenceRadius", 1000.0f);
            float f2 = f > 0.0f ? f : 1000.0f;
            geoFence.setRadius(f2);
            geoFence.setMinDis2Center(f2);
            geoFence.setMaxDis2Center(f2);
        }
        geoFence.setActivatesAction(this.f3455g);
        geoFence.setCustomId(bundle.getString(GeoFence.BUNDLE_KEY_CUSTOMID));
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(arrayList);
        geoFence.setPointList(arrayList2);
        geoFence.setCenter(dPoint);
        geoFence.setPendingIntentAction(this.f3452d);
        geoFence.setExpiration(-1L);
        geoFence.setPendingIntent(this.f3451c);
        StringBuilder sb = new StringBuilder();
        sb.append(GeoFenceSearchResultParser.m55415c());
        geoFence.setFenceId(sb.toString());
        ReportUtil reportUtil = this.f3449a;
        if (reportUtil != null) {
            reportUtil.m51246a(this.f3450b, 2);
        }
        return geoFence;
    }

    /* renamed from: f0 */
    private void m55803f0() {
        try {
            synchronized (this.f3458j) {
                HandlerC1728b handlerC1728b = this.f3460l;
                if (handlerC1728b != null) {
                    handlerC1728b.removeCallbacksAndMessages(null);
                }
                this.f3460l = null;
            }
        } catch (Throwable th) {
            C2428b.m51299a(th, "GeoFenceManager", "destroyActionHandler");
        }
    }

    /* renamed from: g0 */
    private void m55801g0() {
        if (this.f3474z || this.f3460l == null) {
            return;
        }
        if (m55797i0()) {
            m55796j(6, null, 0L);
            m55796j(5, null, 0L);
            return;
        }
        m55837D(7);
        m55796j(7, null, 0L);
    }

    /* renamed from: h0 */
    private void m55799h0() {
        try {
            if (this.f3462n) {
                m55837D(8);
            }
            AMapLocationClient aMapLocationClient = this.f3467s;
            if (aMapLocationClient != null) {
                aMapLocationClient.stopLocation();
            }
            this.f3462n = false;
        } catch (Throwable unused) {
        }
    }

    /* renamed from: i0 */
    private boolean m55797i0() {
        return this.f3468t != null && C2432j.m51197a(this.f3468t) && C2432j.m51186b() - this.f3469u < 10000;
    }

    /* renamed from: p */
    static void m55790p(String str, int i, String str2, String... strArr) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("===========================================\n");
        stringBuffer.append("              " + str + "                ");
        stringBuffer.append(ShellAdbUtils.f33810d);
        stringBuffer.append("-------------------------------------------\n");
        stringBuffer.append("errorCode:".concat(String.valueOf(i)));
        stringBuffer.append(ShellAdbUtils.f33810d);
        stringBuffer.append("错误信息:".concat(String.valueOf(str2)));
        stringBuffer.append(ShellAdbUtils.f33810d);
        if (strArr.length > 0) {
            for (String str3 : strArr) {
                stringBuffer.append(str3);
                stringBuffer.append(ShellAdbUtils.f33810d);
            }
        }
        stringBuffer.append("===========================================\n");
        Log.i("fenceErrLog", stringBuffer.toString());
    }

    /* renamed from: v */
    private static boolean m55784v(int i, String str, String str2, DPoint dPoint) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (i != 1) {
            if (i == 2) {
                if (dPoint == null) {
                    return false;
                }
                if (dPoint.getLatitude() > 90.0d || dPoint.getLatitude() < -90.0d || dPoint.getLongitude() > 180.0d || dPoint.getLongitude() < -180.0d) {
                    m55790p("添加围栏失败", 0, "经纬度错误，传入的纬度：" + dPoint.getLatitude() + "传入的经度:" + dPoint.getLongitude(), new String[0]);
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
    /* renamed from: x */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean m55782x(com.amap.api.fence.GeoFence r4, int r5) {
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
            com.autonavi.aps.amapapi.utils.C2428b.m51299a(r4, r5, r0)
            goto L32
        L30:
            r1 = r2
        L31:
            r2 = r1
        L32:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0463l.GeoFenceManager.m55782x(com.amap.api.fence.GeoFence, int):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0056, code lost:
        if (m55780z(r4, r5.getCenter(), r5.getRadius()) != false) goto L31;
     */
    /* renamed from: y */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean m55781y(com.amap.api.location.AMapLocation r4, com.amap.api.fence.GeoFence r5) {
        /*
            r0 = 1
            r1 = 0
            boolean r2 = com.autonavi.aps.amapapi.utils.C2432j.m51197a(r4)     // Catch: java.lang.Throwable -> L5b
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
            boolean r2 = m55832I(r4, r2)     // Catch: java.lang.Throwable -> L47
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
            boolean r4 = m55780z(r4, r2, r5)     // Catch: java.lang.Throwable -> L5b
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
            com.autonavi.aps.amapapi.utils.C2428b.m51299a(r4, r5, r1)
        L64:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0463l.GeoFenceManager.m55781y(com.amap.api.location.AMapLocation, com.amap.api.fence.GeoFence):boolean");
    }

    /* renamed from: z */
    private static boolean m55780z(AMapLocation aMapLocation, DPoint dPoint, float f) {
        return C2432j.m51187a(new double[]{dPoint.getLatitude(), dPoint.getLongitude(), aMapLocation.getLatitude(), aMapLocation.getLongitude()}) <= f;
    }

    /* renamed from: C */
    public final List<GeoFence> m55838C() {
        try {
            if (this.f3456h == null) {
                this.f3456h = new ArrayList<>();
            }
            return (ArrayList) this.f3456h.clone();
        } catch (Throwable unused) {
            return new ArrayList();
        }
    }

    /* renamed from: D */
    final void m55837D(int i) {
        try {
            synchronized (this.f3458j) {
                HandlerC1728b handlerC1728b = this.f3460l;
                if (handlerC1728b != null) {
                    handlerC1728b.removeMessages(i);
                }
            }
        } catch (Throwable th) {
            C2428b.m51299a(th, "GeoFenceManager", "removeActionHandlerMessage");
        }
    }

    /* renamed from: F */
    final void m55835F(Bundle bundle) {
        String str;
        try {
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
            String str2 = "";
            int i = 1;
            if (bundle != null && !bundle.isEmpty()) {
                DPoint dPoint = (DPoint) bundle.getParcelable("centerPoint");
                str = bundle.getString(GeoFence.BUNDLE_KEY_CUSTOMID);
                if (dPoint != null) {
                    if (dPoint.getLatitude() <= 90.0d && dPoint.getLatitude() >= -90.0d && dPoint.getLongitude() <= 180.0d && dPoint.getLongitude() >= -180.0d) {
                        GeoFence m55804f = m55804f(bundle, false);
                        i = m55831J(m55804f);
                        if (i == 0) {
                            arrayList.add(m55804f);
                        }
                        Bundle bundle2 = new Bundle();
                        bundle2.putInt("errorCode", i);
                        bundle2.putParcelableArrayList("resultList", arrayList);
                        bundle2.putString(GeoFence.BUNDLE_KEY_CUSTOMID, str);
                        m55798i(1000, bundle2);
                    }
                    m55790p("添加围栏失败", 1, "经纬度错误，传入的纬度：" + dPoint.getLatitude() + "传入的经度:" + dPoint.getLongitude(), new String[0]);
                    Bundle bundle22 = new Bundle();
                    bundle22.putInt("errorCode", i);
                    bundle22.putParcelableArrayList("resultList", arrayList);
                    bundle22.putString(GeoFence.BUNDLE_KEY_CUSTOMID, str);
                    m55798i(1000, bundle22);
                }
                str2 = str;
            }
            str = str2;
            Bundle bundle222 = new Bundle();
            bundle222.putInt("errorCode", i);
            bundle222.putParcelableArrayList("resultList", arrayList);
            bundle222.putString(GeoFence.BUNDLE_KEY_CUSTOMID, str);
            m55798i(1000, bundle222);
        } catch (Throwable th) {
            C2428b.m51299a(th, "GeoFenceManager", "doAddGeoFenceRound");
        }
    }

    /* renamed from: G */
    final void m55834G(GeoFence geoFence) {
        try {
            synchronized (this.f3454f) {
                if (this.f3450b != null) {
                    if (this.f3451c == null && geoFence.getPendingIntent() == null) {
                        return;
                    }
                    Intent intent = new Intent();
                    intent.putExtras(m55806e(geoFence, geoFence.getFenceId(), geoFence.getCustomId(), geoFence.getStatus(), 0));
                    String str = this.f3452d;
                    if (str != null) {
                        intent.setAction(str);
                    }
                    intent.setPackage(C1780e4.m55243g(this.f3450b));
                    if (geoFence.getPendingIntent() != null) {
                        geoFence.getPendingIntent().send(this.f3450b, 0, intent);
                    } else {
                        this.f3451c.send(this.f3450b, 0, intent);
                    }
                }
            }
        } catch (Throwable th) {
            C2428b.m51299a(th, "GeoFenceManager", "resultTriggerGeoFence");
        }
    }

    /* renamed from: K */
    final void m55830K() {
        if (this.f3463o) {
            ArrayList<GeoFence> arrayList = this.f3456h;
            if (arrayList != null) {
                arrayList.clear();
                this.f3456h = null;
            }
            if (this.f3464p) {
                return;
            }
            m55803f0();
            AMapLocationClient aMapLocationClient = this.f3467s;
            if (aMapLocationClient != null) {
                aMapLocationClient.stopLocation();
                this.f3467s.onDestroy();
            }
            this.f3467s = null;
            HandlerThreadC1729c handlerThreadC1729c = this.f3461m;
            if (handlerThreadC1729c != null) {
                if (Build.VERSION.SDK_INT >= 18) {
                    handlerThreadC1729c.quitSafely();
                } else {
                    handlerThreadC1729c.quit();
                }
            }
            this.f3461m = null;
            this.f3465q = null;
            synchronized (this.f3454f) {
                PendingIntent pendingIntent = this.f3451c;
                if (pendingIntent != null) {
                    pendingIntent.cancel();
                }
                this.f3451c = null;
            }
            m55805e0();
            ReportUtil reportUtil = this.f3449a;
            if (reportUtil != null) {
                reportUtil.m51229b(this.f3450b);
            }
            this.f3462n = false;
            this.f3463o = false;
        }
    }

    /* renamed from: L */
    final void m55829L(int i) {
        try {
            if (this.f3450b != null) {
                synchronized (this.f3454f) {
                    if (this.f3451c == null) {
                        return;
                    }
                    Intent intent = new Intent();
                    intent.putExtras(m55806e(null, null, null, 4, i));
                    this.f3451c.send(this.f3450b, 0, intent);
                }
            }
        } catch (Throwable th) {
            C2428b.m51299a(th, "GeoFenceManager", "resultRemindLocationError");
        }
    }

    /* renamed from: M */
    final void m55828M(Bundle bundle) {
        GeoFence m55804f;
        try {
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
            String str = "";
            int i = 1;
            if (bundle != null && !bundle.isEmpty()) {
                ArrayList parcelableArrayList = bundle.getParcelableArrayList("pointList");
                String string = bundle.getString(GeoFence.BUNDLE_KEY_CUSTOMID);
                if (parcelableArrayList != null && parcelableArrayList.size() > 2 && (i = m55831J((m55804f = m55804f(bundle, true)))) == 0) {
                    arrayList.add(m55804f);
                }
                str = string;
            }
            Bundle bundle2 = new Bundle();
            bundle2.putString(GeoFence.BUNDLE_KEY_CUSTOMID, str);
            bundle2.putInt("errorCode", i);
            bundle2.putParcelableArrayList("resultList", arrayList);
            m55798i(1000, bundle2);
        } catch (Throwable th) {
            C2428b.m51299a(th, "GeoFenceManager", "doAddGeoFencePolygon");
        }
    }

    /* renamed from: O */
    final void m55826O() {
        try {
            if (this.f3467s != null) {
                m55799h0();
                this.f3470v.setLocationCacheEnable(true);
                this.f3470v.setNeedAddress(false);
                this.f3470v.setOnceLocation(true);
                this.f3467s.setLocationOption(this.f3470v);
                this.f3467s.startLocation();
            }
        } catch (Throwable th) {
            C2428b.m51299a(th, "GeoFenceManager", "doStartOnceLocation");
        }
    }

    /* renamed from: P */
    final void m55825P(Bundle bundle) {
        m55836E(2, bundle);
    }

    /* renamed from: R */
    final void m55823R() {
        try {
            if (!this.f3474z && C2432j.m51197a(this.f3468t)) {
                float m55814a = m55814a(this.f3468t, this.f3456h);
                if (m55814a == Float.MAX_VALUE) {
                    return;
                }
                if (m55814a < 1000.0f) {
                    m55837D(7);
                    Bundle bundle = new Bundle();
                    bundle.putLong(UMCommonContent.f37794aX, 2000L);
                    m55796j(8, bundle, 500L);
                } else if (m55814a < 5000.0f) {
                    m55799h0();
                    m55837D(7);
                    m55796j(7, null, 10000L);
                } else {
                    m55799h0();
                    m55837D(7);
                    m55796j(7, null, ((m55814a - 4000.0f) / 100.0f) * 1000.0f);
                }
            }
        } catch (Throwable th) {
            C2428b.m51299a(th, "GeoFenceManager", "doCheckLocationPolicy");
        }
    }

    /* renamed from: S */
    final void m55822S(Bundle bundle) {
        m55836E(1, bundle);
    }

    /* renamed from: T */
    public final void m55821T() {
        try {
            m55811b0();
            this.f3474z = true;
            m55796j(13, null, 0L);
        } catch (Throwable th) {
            C2428b.m51299a(th, "GeoFenceManager", "pauseGeoFence");
        }
    }

    /* renamed from: U */
    final void m55820U(Bundle bundle) {
        m55836E(3, bundle);
    }

    /* renamed from: V */
    final void m55819V() {
        try {
            m55837D(7);
            m55837D(8);
            AMapLocationClient aMapLocationClient = this.f3467s;
            if (aMapLocationClient != null) {
                aMapLocationClient.stopLocation();
            }
            this.f3462n = false;
        } catch (Throwable th) {
            C2428b.m51299a(th, "GeoFenceManager", "doPauseGeoFence");
        }
    }

    /* renamed from: W */
    final void m55818W(Bundle bundle) {
        if (bundle != null) {
            try {
                if (bundle.isEmpty()) {
                    return;
                }
                String string = bundle.getString("fid");
                if (TextUtils.isEmpty(string)) {
                    return;
                }
                boolean z = bundle.getBoolean("ab", true);
                ArrayList<GeoFence> arrayList = this.f3456h;
                if (arrayList != null && !arrayList.isEmpty()) {
                    Iterator<GeoFence> it = this.f3456h.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        GeoFence next = it.next();
                        if (next.getFenceId().equals(string)) {
                            next.setAble(z);
                            break;
                        }
                    }
                }
                if (!z) {
                    if (m55807d0()) {
                        m55819V();
                        return;
                    }
                    return;
                }
                m55801g0();
            } catch (Throwable th) {
                C2428b.m51299a(th, "GeoFenceManager", "doSetGeoFenceAble");
            }
        }
    }

    /* renamed from: X */
    public final void m55817X() {
        try {
            m55811b0();
            if (this.f3474z) {
                this.f3474z = false;
                m55801g0();
            }
        } catch (Throwable th) {
            C2428b.m51299a(th, "GeoFenceManager", "resumeGeoFence");
        }
    }

    /* renamed from: Y */
    final void m55816Y(Bundle bundle) {
        try {
            if (this.f3456h != null) {
                GeoFence geoFence = (GeoFence) bundle.getParcelable("fc");
                if (this.f3456h.contains(geoFence)) {
                    this.f3456h.remove(geoFence);
                }
                if (this.f3456h.size() <= 0) {
                    m55830K();
                } else {
                    m55801g0();
                }
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: Z */
    final void m55815Z(Bundle bundle) {
        if (bundle != null) {
            try {
                if (bundle.isEmpty()) {
                    return;
                }
                int i = bundle.getInt("errorCode");
                ArrayList parcelableArrayList = bundle.getParcelableArrayList("resultList");
                if (parcelableArrayList == null) {
                    parcelableArrayList = new ArrayList();
                }
                String string = bundle.getString(GeoFence.BUNDLE_KEY_CUSTOMID);
                if (string == null) {
                    string = "";
                }
                GeoFenceListener geoFenceListener = this.f3453e;
                if (geoFenceListener != null) {
                    geoFenceListener.onGeoFenceCreateFinished((ArrayList) parcelableArrayList.clone(), i, string);
                }
                if (i == 0) {
                    m55801g0();
                }
            } catch (Throwable th) {
                C2428b.m51299a(th, "GeoFenceManager", "resultAddGeoFenceFinished");
            }
        }
    }

    /* renamed from: a0 */
    public final boolean m55813a0() {
        return this.f3474z;
    }

    /* renamed from: c0 */
    final void m55809c0(Bundle bundle) {
        try {
            if (this.f3467s != null) {
                long j = 2000;
                if (bundle != null && !bundle.isEmpty()) {
                    j = bundle.getLong(UMCommonContent.f37794aX, 2000L);
                }
                this.f3470v.setOnceLocation(false);
                this.f3470v.setInterval(j);
                this.f3470v.setLocationCacheEnable(true);
                this.f3470v.setNeedAddress(false);
                this.f3467s.setLocationOption(this.f3470v);
                if (this.f3462n) {
                    return;
                }
                this.f3467s.stopLocation();
                this.f3467s.startLocation();
                this.f3462n = true;
            }
        } catch (Throwable th) {
            C2428b.m51299a(th, "GeoFenceManager", "doStartContinueLocation");
        }
    }

    /* renamed from: d */
    public final PendingIntent m55808d(String str) {
        synchronized (this.f3454f) {
            try {
                Intent intent = new Intent(str);
                intent.setPackage(C1780e4.m55243g(this.f3450b));
                if (Build.VERSION.SDK_INT >= 31 && this.f3450b.getApplicationInfo().targetSdkVersion >= 31) {
                    this.f3451c = PendingIntent.getBroadcast(this.f3450b, 0, intent, CommonNetImpl.FLAG_SHARE_JUMP);
                } else {
                    this.f3451c = PendingIntent.getBroadcast(this.f3450b, 0, intent, 0);
                }
                this.f3452d = str;
                ArrayList<GeoFence> arrayList = this.f3456h;
                if (arrayList != null && !arrayList.isEmpty()) {
                    Iterator<GeoFence> it = this.f3456h.iterator();
                    while (it.hasNext()) {
                        GeoFence next = it.next();
                        next.setPendingIntent(this.f3451c);
                        next.setPendingIntentAction(this.f3452d);
                    }
                }
            }
        }
        return this.f3451c;
    }

    /* renamed from: g */
    public final void m55802g() {
        try {
            this.f3464p = false;
            m55796j(10, null, 0L);
        } catch (Throwable th) {
            C2428b.m51299a(th, "GeoFenceManager", "removeGeoFence");
        }
    }

    /* renamed from: h */
    public final void m55800h(int i) {
        try {
            m55811b0();
            i = (i > 7 || i <= 0) ? 1 : 1;
            Bundle bundle = new Bundle();
            bundle.putInt("activatesAction", i);
            m55796j(9, bundle, 0L);
        } catch (Throwable th) {
            C2428b.m51299a(th, "GeoFenceManager", "setActivateAction");
        }
    }

    /* renamed from: i */
    final void m55798i(int i, Bundle bundle) {
        try {
            synchronized (this.f3459k) {
                HandlerC1730d handlerC1730d = this.f3457i;
                if (handlerC1730d != null) {
                    Message obtainMessage = handlerC1730d.obtainMessage();
                    obtainMessage.what = i;
                    obtainMessage.setData(bundle);
                    this.f3457i.sendMessage(obtainMessage);
                }
            }
        } catch (Throwable th) {
            C2428b.m51299a(th, "GeoFenceManager", "sendResultHandlerMessage");
        }
    }

    /* renamed from: j */
    final void m55796j(int i, Bundle bundle, long j) {
        try {
            synchronized (this.f3458j) {
                HandlerC1728b handlerC1728b = this.f3460l;
                if (handlerC1728b != null) {
                    Message obtainMessage = handlerC1728b.obtainMessage();
                    obtainMessage.what = i;
                    obtainMessage.setData(bundle);
                    this.f3460l.sendMessageDelayed(obtainMessage, j);
                }
            }
        } catch (Throwable th) {
            C2428b.m51299a(th, "GeoFenceManager", "sendActionHandlerMessage");
        }
    }

    /* renamed from: k */
    final void m55795k(Bundle bundle) {
        int i = 1;
        if (bundle != null) {
            try {
                i = bundle.getInt("activatesAction", 1);
            } catch (Throwable th) {
                C2428b.m51299a(th, "GeoFenceManager", "doSetActivatesAction");
                return;
            }
        }
        if (this.f3455g != i) {
            ArrayList<GeoFence> arrayList = this.f3456h;
            if (arrayList != null && !arrayList.isEmpty()) {
                Iterator<GeoFence> it = this.f3456h.iterator();
                while (it.hasNext()) {
                    GeoFence next = it.next();
                    next.setStatus(0);
                    next.setEnterTime(-1L);
                }
            }
            m55801g0();
        }
        this.f3455g = i;
    }

    /* renamed from: l */
    public final void m55794l(GeoFenceListener geoFenceListener) {
        try {
            this.f3453e = geoFenceListener;
        } catch (Throwable unused) {
        }
    }

    /* renamed from: m */
    final void m55793m(AMapLocation aMapLocation) {
        ArrayList<GeoFence> arrayList;
        try {
            if (this.f3474z || (arrayList = this.f3456h) == null || arrayList.isEmpty() || aMapLocation == null || aMapLocation.getErrorCode() != 0) {
                return;
            }
            Iterator<GeoFence> it = this.f3456h.iterator();
            while (it.hasNext()) {
                GeoFence next = it.next();
                if (next.isAble() && m55833H(aMapLocation, next) && m55782x(next, this.f3455g)) {
                    next.setCurrentLocation(aMapLocation);
                    m55824Q(next);
                }
            }
        } catch (Throwable th) {
            C2428b.m51299a(th, "GeoFenceManager", "doCheckFence");
        }
    }

    /* renamed from: n */
    public final void m55792n(AMapLocationClientOption aMapLocationClientOption) {
        try {
            this.f3470v = aMapLocationClientOption.m60095clone();
        } catch (Throwable unused) {
        }
    }

    /* renamed from: o */
    public final void m55791o(DPoint dPoint, float f, String str) {
        try {
            m55811b0();
            Bundle bundle = new Bundle();
            bundle.putParcelable("centerPoint", dPoint);
            bundle.putFloat("fenceRadius", f);
            bundle.putString(GeoFence.BUNDLE_KEY_CUSTOMID, str);
            m55796j(0, bundle, 0L);
        } catch (Throwable th) {
            C2428b.m51299a(th, "GeoFenceManager", "addRoundGeoFence");
        }
    }

    /* renamed from: q */
    public final void m55789q(String str, String str2) {
        try {
            m55811b0();
            Bundle bundle = new Bundle();
            bundle.putString("keyWords", str);
            bundle.putString(GeoFence.BUNDLE_KEY_CUSTOMID, str2);
            m55796j(4, bundle, 0L);
        } catch (Throwable th) {
            C2428b.m51299a(th, "GeoFenceManager", "addDistricetGeoFence");
        }
    }

    /* renamed from: r */
    public final void m55788r(String str, String str2, DPoint dPoint, float f, int i, String str3) {
        try {
            m55811b0();
            f = (f <= 0.0f || f > 50000.0f) ? 3000.0f : 3000.0f;
            if (i <= 0) {
                i = 10;
            }
            if (i > 25) {
                i = 25;
            }
            Bundle bundle = new Bundle();
            bundle.putString("keyWords", str);
            bundle.putString("poiType", str2);
            bundle.putParcelable("centerPoint", dPoint);
            bundle.putFloat("aroundRadius", f);
            bundle.putInt("searchSize", i);
            bundle.putString(GeoFence.BUNDLE_KEY_CUSTOMID, str3);
            m55796j(3, bundle, 0L);
        } catch (Throwable th) {
            C2428b.m51299a(th, "GeoFenceManager", "addNearbyGeoFence");
        }
    }

    /* renamed from: s */
    public final void m55787s(String str, String str2, String str3, int i, String str4) {
        try {
            m55811b0();
            if (i <= 0) {
                i = 10;
            }
            if (i > 25) {
                i = 25;
            }
            Bundle bundle = new Bundle();
            bundle.putString("keyWords", str);
            bundle.putString("poiType", str2);
            bundle.putString(DistrictSearchQuery.KEYWORDS_CITY, str3);
            bundle.putInt("searchSize", i);
            bundle.putString(GeoFence.BUNDLE_KEY_CUSTOMID, str4);
            m55796j(2, bundle, 0L);
        } catch (Throwable th) {
            C2428b.m51299a(th, "GeoFenceManager", "addKeywordGeoFence");
        }
    }

    /* renamed from: t */
    public final void m55786t(String str, boolean z) {
        try {
            m55811b0();
            Bundle bundle = new Bundle();
            bundle.putString("fid", str);
            bundle.putBoolean("ab", z);
            m55796j(12, bundle, 0L);
        } catch (Throwable th) {
            C2428b.m51299a(th, "GeoFenceManager", "setGeoFenceAble");
        }
    }

    /* renamed from: u */
    public final void m55785u(List<DPoint> list, String str) {
        try {
            m55811b0();
            Bundle bundle = new Bundle();
            bundle.putParcelableArrayList("pointList", new ArrayList<>(list));
            bundle.putString(GeoFence.BUNDLE_KEY_CUSTOMID, str);
            m55796j(1, bundle, 0L);
        } catch (Throwable th) {
            C2428b.m51299a(th, "GeoFenceManager", "addPolygonGeoFence");
        }
    }

    /* renamed from: w */
    public final boolean m55783w(GeoFence geoFence) {
        try {
            ArrayList<GeoFence> arrayList = this.f3456h;
            if (arrayList != null && !arrayList.isEmpty()) {
                if (this.f3456h.contains(geoFence)) {
                    if (this.f3456h.size() == 1) {
                        this.f3464p = false;
                    }
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("fc", geoFence);
                    m55796j(11, bundle, 0L);
                    return true;
                }
                return false;
            }
            this.f3464p = false;
            m55796j(10, null, 0L);
            return true;
        } catch (Throwable th) {
            C2428b.m51299a(th, "GeoFenceManager", "removeGeoFence(GeoFence)");
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: GeoFenceManager.java */
    /* renamed from: com.amap.api.col.3l.a$d */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public class HandlerC1730d extends Handler {
        public HandlerC1730d(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            try {
                Bundle data = message.getData();
                switch (message.what) {
                    case 1000:
                        GeoFenceManager.this.m55815Z(data);
                        return;
                    case 1001:
                        GeoFenceManager.this.m55834G((GeoFence) data.getParcelable("geoFence"));
                        return;
                    case 1002:
                        GeoFenceManager.this.m55829L(data.getInt(GeoFence.BUNDLE_KEY_LOCERRORCODE));
                        return;
                    default:
                        return;
                }
            } catch (Throwable unused) {
            }
        }

        public HandlerC1730d() {
        }
    }
}

package com.amap.api.col.p0463l;

import android.app.Application;
import android.app.Notification;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebView;
import androidx.core.view.PointerIconCompat;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.location.AMapLocationQualityReport;
import com.amap.api.location.APSService;
import com.amap.api.location.UmidtokenInfo;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.autonavi.aps.amapapi.AMapLocationStaticsEntity;
import com.autonavi.aps.amapapi.Aps;
import com.autonavi.aps.amapapi.model.AMapLocationServer;
import com.autonavi.aps.amapapi.storage.LastLocationInfo;
import com.autonavi.aps.amapapi.utils.AuthUtil;
import com.autonavi.aps.amapapi.utils.C2428b;
import com.autonavi.aps.amapapi.utils.C2432j;
import com.autonavi.aps.amapapi.utils.DebugUtils;
import com.autonavi.aps.amapapi.utils.Reflect;
import com.autonavi.aps.amapapi.utils.ReportRecorder;
import com.autonavi.aps.amapapi.utils.ReportUtil;
import com.autonavi.base.amap.mapcore.tools.GLMapStaticValue;
import com.github.mikephil.charting.utils.Utils;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.amap.api.col.3l.d2 */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class AmapLocationManager {

    /* renamed from: L */
    private static boolean f3791L = true;

    /* renamed from: M */
    public static volatile boolean f3792M;

    /* renamed from: N */
    private static boolean f3793N;

    /* renamed from: O */
    private static AtomicBoolean f3794O = new AtomicBoolean(false);

    /* renamed from: a */
    AMapLocationServer f3806a;

    /* renamed from: b */
    private Context f3807b;

    /* renamed from: d */
    public HandlerC1767f f3809d;

    /* renamed from: f */
    private CoarseLocation f3811f;

    /* renamed from: n */
    LastLocationManager f3819n;

    /* renamed from: q */
    Intent f3822q;

    /* renamed from: c */
    AMapLocationClientOption f3808c = new AMapLocationClientOption();

    /* renamed from: e */
    GpsLocation f3810e = null;

    /* renamed from: g */
    private boolean f3812g = false;

    /* renamed from: h */
    private volatile boolean f3813h = false;

    /* renamed from: i */
    ArrayList<AMapLocationListener> f3814i = new ArrayList<>();

    /* renamed from: j */
    boolean f3815j = false;

    /* renamed from: k */
    public boolean f3816k = true;

    /* renamed from: l */
    public boolean f3817l = true;

    /* renamed from: m */
    public boolean f3818m = true;

    /* renamed from: o */
    Messenger f3820o = null;

    /* renamed from: p */
    Messenger f3821p = null;

    /* renamed from: r */
    int f3823r = 0;

    /* renamed from: s */
    private boolean f3824s = true;

    /* renamed from: t */
    HandlerThreadC1766e f3825t = null;

    /* renamed from: u */
    boolean f3826u = false;

    /* renamed from: v */
    AMapLocationClientOption.AMapLocationMode f3827v = AMapLocationClientOption.AMapLocationMode.Hight_Accuracy;

    /* renamed from: w */
    Object f3828w = new Object();

    /* renamed from: x */
    ReportUtil f3829x = null;

    /* renamed from: y */
    boolean f3830y = false;

    /* renamed from: z */
    ApsManager f3831z = null;

    /* renamed from: A */
    private AMapLocationClientOption f3795A = new AMapLocationClientOption();

    /* renamed from: B */
    private H5LocationClient f3796B = null;

    /* renamed from: C */
    String f3797C = null;

    /* renamed from: D */
    private ServiceConnection f3798D = new ServiceConnectionC1763b();

    /* renamed from: E */
    AMapLocationQualityReport f3799E = null;

    /* renamed from: F */
    boolean f3800F = false;

    /* renamed from: G */
    boolean f3801G = false;

    /* renamed from: H */
    private volatile boolean f3802H = false;

    /* renamed from: I */
    HandlerC1765d f3803I = null;

    /* renamed from: J */
    String f3804J = null;

    /* renamed from: K */
    boolean f3805K = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AmapLocationManager.java */
    /* renamed from: com.amap.api.col.3l.d2$a */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public static class C1762a extends ThreadTask {

        /* renamed from: a */
        final /* synthetic */ Context f3832a;

        C1762a(Context context) {
            this.f3832a = context;
        }

        @Override // com.amap.api.col.p0463l.ThreadTask
        public final void runTask() {
            DeviceInfo.m54804R();
            DeviceInfo.m54769o(this.f3832a);
            DeviceInfo.m54816F(this.f3832a);
        }
    }

    /* compiled from: AmapLocationManager.java */
    /* renamed from: com.amap.api.col.3l.d2$b */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    final class ServiceConnectionC1763b implements ServiceConnection {
        ServiceConnectionC1763b() {
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                AmapLocationManager.this.f3820o = new Messenger(iBinder);
                AmapLocationManager.this.f3812g = true;
                AmapLocationManager.this.f3830y = true;
            } catch (Throwable th) {
                C2428b.m51299a(th, "ALManager", "onServiceConnected");
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
            AmapLocationManager amapLocationManager = AmapLocationManager.this;
            amapLocationManager.f3820o = null;
            amapLocationManager.f3812g = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AmapLocationManager.java */
    /* renamed from: com.amap.api.col.3l.d2$c */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public static /* synthetic */ class C1764c {

        /* renamed from: a */
        static final /* synthetic */ int[] f3834a;

        static {
            int[] iArr = new int[AMapLocationClientOption.AMapLocationMode.values().length];
            f3834a = iArr;
            try {
                iArr[AMapLocationClientOption.AMapLocationMode.Battery_Saving.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3834a[AMapLocationClientOption.AMapLocationMode.Device_Sensors.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3834a[AMapLocationClientOption.AMapLocationMode.Hight_Accuracy.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* compiled from: AmapLocationManager.java */
    /* renamed from: com.amap.api.col.3l.d2$d */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public class HandlerC1765d extends Handler {
        public HandlerC1765d(Looper looper) {
            super(looper);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v0 */
        /* JADX WARN: Type inference failed for: r0v1 */
        /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r0v3, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r0v7 */
        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            ?? r0 = 0;
            try {
                super.handleMessage(message);
                if (AuthUtil.f8347h) {
                    Log.e("AMapLocationClient", "SERVICE_NOT_AVAILABLE");
                    return;
                }
                int i = message.what;
                if (i == 11) {
                    AmapLocationManager.this.m55364k(message.getData());
                } else if (i == 12) {
                    AmapLocationManager.this.m55402I(message);
                } else if (i != 1011) {
                    try {
                        switch (i) {
                            case 1002:
                                AmapLocationManager.this.m55389V((AMapLocationListener) message.obj);
                                return;
                            case 1003:
                                AmapLocationManager.this.m55353p0();
                                AmapLocationManager.this.m55374f(13, null);
                                return;
                            case 1004:
                                AmapLocationManager.this.m55347s0();
                                AmapLocationManager.this.m55374f(14, null);
                                return;
                            case 1005:
                                AmapLocationManager.this.m55381b0((AMapLocationListener) message.obj);
                                return;
                            default:
                                switch (i) {
                                    case PointerIconCompat.TYPE_HORIZONTAL_DOUBLE_ARROW /* 1014 */:
                                        AmapLocationManager.this.m55362l(message);
                                        return;
                                    case PointerIconCompat.TYPE_VERTICAL_DOUBLE_ARROW /* 1015 */:
                                        AmapLocationManager amapLocationManager = AmapLocationManager.this;
                                        amapLocationManager.f3810e.m53940p(amapLocationManager.f3808c);
                                        AmapLocationManager.this.m55372g(1025, null, 300000L);
                                        return;
                                    case PointerIconCompat.TYPE_TOP_RIGHT_DIAGONAL_DOUBLE_ARROW /* 1016 */:
                                        if (C2432j.m51154m(AmapLocationManager.this.f3807b)) {
                                            DebugUtils.m51285a();
                                            AmapLocationManager.this.m55335y0();
                                            return;
                                        } else if (AmapLocationManager.this.f3810e.m53934v()) {
                                            AmapLocationManager.this.m55372g(PointerIconCompat.TYPE_TOP_RIGHT_DIAGONAL_DOUBLE_ARROW, null, 1000L);
                                            return;
                                        } else {
                                            AmapLocationManager.this.m55343u0();
                                            return;
                                        }
                                    case PointerIconCompat.TYPE_TOP_LEFT_DIAGONAL_DOUBLE_ARROW /* 1017 */:
                                        AmapLocationManager.this.f3810e.m53953c();
                                        AmapLocationManager.this.m55378d(1025);
                                        return;
                                    case PointerIconCompat.TYPE_ZOOM_IN /* 1018 */:
                                        AmapLocationManager amapLocationManager2 = AmapLocationManager.this;
                                        AMapLocationClientOption aMapLocationClientOption = (AMapLocationClientOption) message.obj;
                                        amapLocationManager2.f3808c = aMapLocationClientOption;
                                        if (aMapLocationClientOption != null) {
                                            amapLocationManager2.m55333z0();
                                            return;
                                        }
                                        return;
                                    default:
                                        switch (i) {
                                            case 1023:
                                                AmapLocationManager.this.m55392S(message);
                                                return;
                                            case 1024:
                                                AmapLocationManager.this.m55387X(message);
                                                return;
                                            case 1025:
                                                if (AmapLocationManager.this.f3810e.m53968F()) {
                                                    AmapLocationManager.this.f3810e.m53953c();
                                                    AmapLocationManager amapLocationManager3 = AmapLocationManager.this;
                                                    amapLocationManager3.f3810e.m53940p(amapLocationManager3.f3808c);
                                                }
                                                AmapLocationManager.this.m55372g(1025, null, 300000L);
                                                return;
                                            case 1026:
                                                DebugUtils.m51283b();
                                                AmapLocationManager.this.f3811f.m53989l(AmapLocationManager.this.f3808c);
                                                return;
                                            case 1027:
                                                AmapLocationManager.this.f3811f.m53999b();
                                                return;
                                            case 1028:
                                                AmapLocationManager.this.m55363k0((AMapLocation) message.obj);
                                                return;
                                            case 1029:
                                                Bundle bundle = new Bundle();
                                                bundle.putString("objHash", Integer.toString(System.identityHashCode(this)));
                                                AmapLocationManager.this.m55374f(16, bundle);
                                                return;
                                            case GLMapStaticValue.MAP_PARAMETERNAME_SCENIC /* 1030 */:
                                                Bundle bundle2 = new Bundle();
                                                bundle2.putString("objHash", Integer.toString(System.identityHashCode(this)));
                                                AmapLocationManager.this.m55374f(17, bundle2);
                                                return;
                                            default:
                                                return;
                                        }
                                }
                        }
                    } catch (Throwable th) {
                        r0 = message;
                        th = th;
                        if (r0 == 0) {
                            r0 = "handleMessage";
                        }
                        C2428b.m51299a(th, "AMapLocationManage$MHandlerr", r0);
                    }
                } else {
                    AmapLocationManager.this.m55374f(14, null);
                    AmapLocationManager.this.m55367i0();
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AmapLocationManager.java */
    /* renamed from: com.amap.api.col.3l.d2$e */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public static class HandlerThreadC1766e extends HandlerThread {

        /* renamed from: a */
        AmapLocationManager f3836a;

        public HandlerThreadC1766e(String str, AmapLocationManager amapLocationManager) {
            super(str);
            this.f3836a = amapLocationManager;
        }

        @Override // android.os.HandlerThread
        protected final void onLooperPrepared() {
            try {
                this.f3836a.f3819n.m54033b();
                ReportRecorder.m51255a(this.f3836a.f3807b);
                this.f3836a.m55339w0();
                AmapLocationManager amapLocationManager = this.f3836a;
                if (amapLocationManager != null && amapLocationManager.f3807b != null) {
                    AuthUtil.m51340b(this.f3836a.f3807b);
                    AuthUtil.m51347a(this.f3836a.f3807b);
                }
                super.onLooperPrepared();
            } catch (Throwable unused) {
            }
        }

        @Override // android.os.HandlerThread, java.lang.Thread, java.lang.Runnable
        public final void run() {
            try {
                super.run();
            } catch (Throwable unused) {
            }
        }
    }

    public AmapLocationManager(Context context, Intent intent, Looper looper) {
        this.f3822q = null;
        this.f3807b = context;
        this.f3822q = intent;
        m55403H(looper);
    }

    /* renamed from: A */
    private static void m55411A(Aps aps, AMapLocationServer aMapLocationServer) {
        if (aMapLocationServer != null) {
            try {
                if (aMapLocationServer.getErrorCode() == 0) {
                    aps.m51699b(aMapLocationServer);
                }
            } catch (Throwable th) {
                C2428b.m51299a(th, "ALManager", "apsLocation:doFirstAddCache");
            }
        }
    }

    /* renamed from: A0 */
    private boolean m55410A0() {
        if (C2432j.m51157j(this.f3807b)) {
            int i = -1;
            try {
                i = Reflect.m51258b(((Application) StubApp.getOrigApplicationContext(this.f3807b.getApplicationContext())).getBaseContext(), "checkSelfPermission", "android.permission.FOREGROUND_SERVICE");
            } catch (Throwable unused) {
            }
            if (i != 0) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(28:1|2|3|4|(1:6)|7|(1:9)|10|11|12|(3:14|(2:16|(2:87|(2:89|(1:93)))(1:18))|94)(1:95)|19|(18:(1:22)(1:85)|23|24|(2:26|(1:28))|30|(3:74|75|76)(1:32)|33|(1:37)|38|39|(1:43)|45|(1:47)|48|(1:50)|(1:55)|69|70)(1:86)|81|(0)(0)|33|(2:35|37)|38|39|(2:41|43)|45|(0)|48|(0)|(2:53|55)|69|70|(2:(0)|(1:71))) */
    /* JADX WARN: Removed duplicated region for block: B:110:0x00c2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0107 A[Catch: all -> 0x0123, TryCatch #7 {all -> 0x00ce, blocks: (B:56:0x00c2, B:85:0x012d, B:87:0x0131, B:74:0x0100, B:76:0x0107, B:77:0x011a, B:79:0x011f, B:61:0x00d2, B:63:0x00da, B:65:0x00de), top: B:110:0x00c2 }] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x011f A[Catch: all -> 0x0123, TRY_LEAVE, TryCatch #7 {all -> 0x00ce, blocks: (B:56:0x00c2, B:85:0x012d, B:87:0x0131, B:74:0x0100, B:76:0x0107, B:77:0x011a, B:79:0x011f, B:61:0x00d2, B:63:0x00da, B:65:0x00de), top: B:110:0x00c2 }] */
    /* renamed from: F */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.autonavi.aps.amapapi.model.AMapLocationServer m55405F(com.autonavi.aps.amapapi.Aps r14) {
        /*
            Method dump skipped, instructions count: 331
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0463l.AmapLocationManager.m55405F(com.autonavi.aps.amapapi.b):com.autonavi.aps.amapapi.model.a");
    }

    /* renamed from: H */
    private void m55403H(Looper looper) {
        try {
            if (looper == null) {
                if (Looper.myLooper() == null) {
                    this.f3809d = new HandlerC1767f(this.f3807b.getMainLooper());
                } else {
                    this.f3809d = new HandlerC1767f();
                }
            } else {
                this.f3809d = new HandlerC1767f(looper);
            }
        } catch (Throwable th) {
            C2428b.m51299a(th, "ALManager", "init 1");
        }
        try {
            this.f3819n = new LastLocationManager(this.f3807b);
            HandlerThreadC1766e handlerThreadC1766e = new HandlerThreadC1766e("amapLocManagerThread", this);
            this.f3825t = handlerThreadC1766e;
            handlerThreadC1766e.setPriority(5);
            this.f3825t.start();
            this.f3803I = m55384a(this.f3825t.getLooper());
            try {
                this.f3810e = new GpsLocation(this.f3807b, this.f3809d);
                this.f3811f = new CoarseLocation(this.f3807b, this.f3809d);
            } catch (Throwable th2) {
                C2428b.m51299a(th2, "ALManager", "init 3");
            }
            if (this.f3829x == null) {
                this.f3829x = new ReportUtil();
            }
            m55370h(this.f3807b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: I */
    public void m55402I(Message message) {
        try {
            AMapLocation aMapLocation = (AMapLocation) message.obj;
            if (this.f3816k && this.f3820o != null) {
                Bundle bundle = new Bundle();
                bundle.putBundle("optBundle", C2428b.m51302a(this.f3808c));
                m55374f(0, bundle);
                if (this.f3813h) {
                    m55374f(13, null);
                }
                this.f3816k = false;
            }
            m55344u(aMapLocation, null);
            m55378d(1025);
            m55372g(1025, null, 300000L);
        } catch (Throwable th) {
            C2428b.m51299a(th, "ALManager", "resultGpsLocationSuccess");
        }
    }

    /* renamed from: M */
    private static void m55398M(AMapLocation aMapLocation) {
        if (aMapLocation == null) {
            return;
        }
        try {
            if (2 == aMapLocation.getLocationType() || 4 == aMapLocation.getLocationType()) {
                long time = aMapLocation.getTime();
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis > time) {
                    aMapLocation.setTime(currentTimeMillis);
                }
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: S */
    public void m55392S(Message message) {
        if (message == null) {
            return;
        }
        try {
            Bundle data = message.getData();
            if (data == null) {
                return;
            }
            int i = data.getInt("i", 0);
            Intent m55337x0 = m55337x0();
            m55337x0.putExtra("i", i);
            m55337x0.putExtra("h", (Notification) data.getParcelable("h"));
            m55337x0.putExtra("g", 1);
            m55366j(m55337x0, true);
        } catch (Throwable th) {
            C2428b.m51299a(th, "ALManager", "doEnableBackgroundLocation");
        }
    }

    /* renamed from: U */
    private void m55390U(AMapLocation aMapLocation) {
        StringBuilder sb;
        if (aMapLocation != null) {
            try {
                String locationDetail = aMapLocation.getLocationDetail();
                if (TextUtils.isEmpty(locationDetail)) {
                    sb = new StringBuilder();
                } else {
                    sb = new StringBuilder(locationDetail);
                }
                boolean m51174c = C2432j.m51174c(this.f3807b, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19XSUZJX1NUQVRF");
                boolean m51174c2 = C2432j.m51174c(this.f3807b, "WYW5kcm9pZC5wZXJtaXNzaW9uLkNIQU5HRV9XSUZJX1NUQVRF");
                boolean m51174c3 = C2432j.m51174c(this.f3807b, "WYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19MT0NBVElPTl9FWFRSQV9DT01NQU5EUw==");
                boolean m51174c4 = C2432j.m51174c(this.f3807b, "EYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU=");
                boolean m51174c5 = C2432j.m51174c(this.f3807b, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19GSU5FX0xPQ0FUSU9O");
                boolean m51174c6 = C2432j.m51174c(this.f3807b, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19DT0FSU0VfTE9DQVRJT04=");
                sb.append(m51174c ? "#pm1" : "#pm0");
                String str = "1";
                sb.append(m51174c2 ? "1" : "0");
                sb.append(m51174c3 ? "1" : "0");
                sb.append(m51174c4 ? "1" : "0");
                sb.append(m51174c5 ? "1" : "0");
                if (!m51174c6) {
                    str = "0";
                }
                sb.append(str);
                aMapLocation.setLocationDetail(sb.toString());
            } catch (Throwable unused) {
                DebugUtils.m51283b();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: V */
    public void m55389V(AMapLocationListener aMapLocationListener) {
        if (aMapLocationListener != null) {
            if (this.f3814i == null) {
                this.f3814i = new ArrayList<>();
            }
            if (this.f3814i.contains(aMapLocationListener)) {
                return;
            }
            this.f3814i.add(aMapLocationListener);
            return;
        }
        throw new IllegalArgumentException("listener参数不能为null");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: X */
    public void m55387X(Message message) {
        if (message == null) {
            return;
        }
        try {
            Bundle data = message.getData();
            if (data == null) {
                return;
            }
            boolean z = data.getBoolean("j", true);
            Intent m55337x0 = m55337x0();
            m55337x0.putExtra("j", z);
            m55337x0.putExtra("g", 2);
            m55366j(m55337x0, false);
        } catch (Throwable th) {
            C2428b.m51299a(th, "ALManager", "doDisableBackgroundLocation");
        }
    }

    /* renamed from: a */
    private HandlerC1765d m55384a(Looper looper) {
        HandlerC1765d handlerC1765d;
        synchronized (this.f3828w) {
            handlerC1765d = new HandlerC1765d(looper);
            this.f3803I = handlerC1765d;
        }
        return handlerC1765d;
    }

    /* renamed from: a0 */
    private void m55383a0(AMapLocation aMapLocation) {
        Message obtainMessage = this.f3809d.obtainMessage();
        obtainMessage.what = 10;
        obtainMessage.obj = aMapLocation;
        this.f3809d.sendMessage(obtainMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b0 */
    public void m55381b0(AMapLocationListener aMapLocationListener) {
        if (!this.f3814i.isEmpty() && this.f3814i.contains(aMapLocationListener)) {
            this.f3814i.remove(aMapLocationListener);
        }
        if (this.f3814i.isEmpty()) {
            m55347s0();
        }
    }

    /* renamed from: c */
    private AMapLocationServer m55380c(Aps aps, boolean z) {
        if (this.f3808c.isLocationCacheEnable()) {
            try {
                return aps.m51698b(z);
            } catch (Throwable th) {
                C2428b.m51299a(th, "ALManager", "doFirstCacheLoc");
                return null;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m55378d(int i) {
        synchronized (this.f3828w) {
            HandlerC1765d handlerC1765d = this.f3803I;
            if (handlerC1765d != null) {
                handlerC1765d.removeMessages(i);
            }
        }
    }

    /* renamed from: e0 */
    private synchronized void m55375e0(AMapLocation aMapLocation) {
        if (aMapLocation == null) {
            try {
                aMapLocation = new AMapLocation("");
                aMapLocation.setErrorCode(8);
                aMapLocation.setLocationDetail("coarse amapLocation is null#2005");
            } catch (Throwable th) {
                C2428b.m51299a(th, "ALManager", "handlerCoarseLocation part2");
                return;
            }
        }
        if (this.f3799E == null) {
            this.f3799E = new AMapLocationQualityReport();
        }
        this.f3799E.setLocationMode(this.f3808c.getLocationMode());
        if (this.f3811f != null) {
            this.f3799E.setGPSSatellites(aMapLocation.getSatellites());
            this.f3799E.setGpsStatus(this.f3811f.m53987n());
        }
        this.f3799E.setWifiAble(C2432j.m51162g(this.f3807b));
        this.f3799E.setNetworkType(C2432j.m51160h(this.f3807b));
        this.f3799E.setNetUseTime(0L);
        this.f3799E.setInstallHighDangerMockApp(f3793N);
        aMapLocation.setLocationQualityReport(this.f3799E);
        if (this.f3813h) {
            ReportUtil.m51242a(this.f3807b, aMapLocation);
            m55383a0(aMapLocation.m60094clone());
            ReportRecorder.m51255a(this.f3807b).m51254a(aMapLocation);
            ReportRecorder.m51255a(this.f3807b).m51253b();
        }
        if (this.f3826u) {
            return;
        }
        if (this.f3811f != null) {
            m55347s0();
        }
        m55374f(14, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public void m55374f(int i, Bundle bundle) {
        if (bundle == null) {
            try {
                bundle = new Bundle();
            } catch (Throwable th) {
                boolean z = (th instanceof IllegalStateException) && th.getMessage().contains("sending message to a Handler on a dead thread");
                if ((th instanceof RemoteException) || z) {
                    this.f3820o = null;
                    this.f3812g = false;
                }
                C2428b.m51299a(th, "ALManager", "sendLocMessage");
                return;
            }
        }
        if (TextUtils.isEmpty(this.f3797C)) {
            this.f3797C = C2428b.m51296b(this.f3807b);
        }
        bundle.putString("c", this.f3797C);
        Message obtain = Message.obtain();
        obtain.what = i;
        obtain.setData(bundle);
        obtain.replyTo = this.f3821p;
        Messenger messenger = this.f3820o;
        if (messenger != null) {
            messenger.send(obtain);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public void m55372g(int i, Object obj, long j) {
        synchronized (this.f3828w) {
            if (this.f3803I != null) {
                Message obtain = Message.obtain();
                obtain.what = i;
                if (obj instanceof Bundle) {
                    obtain.setData((Bundle) obj);
                } else {
                    obtain.obj = obj;
                }
                this.f3803I.sendMessageDelayed(obtain, j);
            }
        }
    }

    /* renamed from: h */
    private static void m55370h(Context context) {
        if (f3794O.compareAndSet(false, true)) {
            ThreadPool.m53398h().m55654b(new C1762a(context));
        }
    }

    /* renamed from: h0 */
    private void m55369h0(AMapLocation aMapLocation) {
        if (aMapLocation == null) {
            return;
        }
        AMapLocation aMapLocation2 = null;
        try {
            LastLocationInfo lastLocationInfo = LastLocationManager.f5190g;
            if (lastLocationInfo == null) {
                LastLocationManager lastLocationManager = this.f3819n;
                if (lastLocationManager != null) {
                    aMapLocation2 = lastLocationManager.m54031d();
                }
            } else {
                aMapLocation2 = lastLocationInfo.m51421a();
            }
            ReportUtil.m51234a(aMapLocation2, aMapLocation);
        } catch (Throwable unused) {
        }
    }

    /* renamed from: i */
    private void m55368i(Intent intent) {
        try {
            this.f3807b.bindService(intent, this.f3798D, 1);
        } catch (Throwable th) {
            C2428b.m51299a(th, "ALManager", "startServiceImpl");
        }
    }

    /* renamed from: j */
    private void m55366j(Intent intent, boolean z) {
        Context context = this.f3807b;
        if (context != null) {
            if (Build.VERSION.SDK_INT >= 26 && z) {
                if (!m55410A0()) {
                    Log.e("amapapi", "-------------调用后台定位服务，缺少权限：android.permission.FOREGROUND_SERVICE--------------");
                    return;
                } else {
                    try {
                        this.f3807b.getClass().getMethod("startForegroundService", Intent.class).invoke(this.f3807b, intent);
                    } catch (Throwable unused) {
                        this.f3807b.startService(intent);
                    }
                }
            } else {
                context.startService(intent);
            }
            this.f3805K = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k */
    public void m55364k(Bundle bundle) {
        AMapLocationStaticsEntity aMapLocationStaticsEntity;
        AMapLocation aMapLocation;
        GpsLocation gpsLocation;
        AMapLocation aMapLocation2 = null;
        if (bundle != null) {
            try {
                bundle.setClassLoader(AMapLocation.class.getClassLoader());
                aMapLocation = (AMapLocation) bundle.getParcelable("loc");
                this.f3804J = bundle.getString("nb");
                aMapLocationStaticsEntity = (AMapLocationStaticsEntity) bundle.getParcelable("statics");
                if (aMapLocation != null) {
                    try {
                        if (aMapLocation.getErrorCode() == 0 && (gpsLocation = this.f3810e) != null) {
                            gpsLocation.m53932x();
                            if (!TextUtils.isEmpty(aMapLocation.getAdCode())) {
                                GpsLocation.f5254J = aMapLocation;
                            }
                        }
                    } catch (Throwable th) {
                        th = th;
                        C2428b.m51299a(th, "AmapLocationManager", "resultLbsLocationSuccess");
                        m55344u(aMapLocation2, aMapLocationStaticsEntity);
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                aMapLocationStaticsEntity = null;
                C2428b.m51299a(th, "AmapLocationManager", "resultLbsLocationSuccess");
                m55344u(aMapLocation2, aMapLocationStaticsEntity);
            }
        } else {
            aMapLocationStaticsEntity = null;
            aMapLocation = null;
        }
        GpsLocation gpsLocation2 = this.f3810e;
        aMapLocation2 = gpsLocation2 != null ? gpsLocation2.m53954b(aMapLocation, this.f3804J) : aMapLocation;
        m55344u(aMapLocation2, aMapLocationStaticsEntity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k0 */
    public void m55363k0(AMapLocation aMapLocation) {
        try {
            if (this.f3817l && this.f3820o != null) {
                Bundle bundle = new Bundle();
                bundle.putBundle("optBundle", C2428b.m51302a(this.f3808c));
                m55374f(0, bundle);
                if (this.f3813h) {
                    m55374f(13, null);
                }
                this.f3817l = false;
            }
            m55375e0(aMapLocation);
        } catch (Throwable th) {
            C2428b.m51299a(th, "ALManager", "resultGpsLocationSuccess");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l */
    public void m55362l(Message message) {
        try {
            Bundle data = message.getData();
            AMapLocation aMapLocation = (AMapLocation) data.getParcelable("loc");
            String string = data.getString("lastLocNb");
            m55369h0(aMapLocation);
            if (this.f3819n.m54032c(aMapLocation, string)) {
                this.f3819n.m54029f();
            }
        } catch (Throwable th) {
            C2428b.m51299a(th, "ALManager", "doSaveLastLocation");
        }
    }

    /* renamed from: l0 */
    private void m55361l0() {
        synchronized (this.f3828w) {
            HandlerC1765d handlerC1765d = this.f3803I;
            if (handlerC1765d != null) {
                handlerC1765d.removeCallbacksAndMessages(null);
            }
            this.f3803I = null;
        }
    }

    /* renamed from: o0 */
    private boolean m55355o0() {
        boolean z = false;
        int i = 0;
        do {
            try {
                if (this.f3820o != null) {
                    break;
                }
                Thread.sleep(100L);
                i++;
            } catch (Throwable th) {
                C2428b.m51299a(th, "ALManager", "checkAPSManager");
            }
        } while (i < 50);
        if (this.f3820o == null) {
            Message obtain = Message.obtain();
            Bundle bundle = new Bundle();
            AMapLocation aMapLocation = new AMapLocation("");
            aMapLocation.setErrorCode(10);
            if (!C2432j.m51156k(StubApp.getOrigApplicationContext(this.f3807b.getApplicationContext()))) {
                aMapLocation.setLocationDetail("请检查配置文件是否配置服务，并且manifest中service标签是否配置在application标签内#1003");
            } else {
                aMapLocation.setLocationDetail("启动ApsServcie失败#1001");
            }
            bundle.putParcelable("loc", aMapLocation);
            obtain.setData(bundle);
            obtain.what = 1;
            this.f3809d.sendMessage(obtain);
        } else {
            z = true;
        }
        if (!z) {
            if (!C2432j.m51156k(StubApp.getOrigApplicationContext(this.f3807b.getApplicationContext()))) {
                ReportUtil.m51233a((String) null, 2103);
            } else {
                ReportUtil.m51233a((String) null, (int) AMapException.CODE_AMAP_NEARBY_KEY_NOT_BIND);
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p0 */
    public synchronized void m55353p0() {
        int i = Build.VERSION.SDK_INT;
        if ((i < 29 && i >= 23 && !C2432j.m51174c(this.f3807b, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19DT0FSU0VfTE9DQVRJT04=") && !C2432j.m51174c(this.f3807b, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19GSU5FX0xPQ0FUSU9O")) || ((i < 31 && i >= 29 && this.f3807b.getApplicationInfo().targetSdkVersion >= 29 && !C2432j.m51174c(this.f3807b, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19GSU5FX0xPQ0FUSU9O")) || ((i < 31 && i >= 29 && this.f3807b.getApplicationInfo().targetSdkVersion < 29 && !C2432j.m51174c(this.f3807b, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19DT0FSU0VfTE9DQVRJT04=") && !C2432j.m51174c(this.f3807b, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19GSU5FX0xPQ0FUSU9O")) || (i >= 31 && !C2432j.m51174c(this.f3807b, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19DT0FSU0VfTE9DQVRJT04=") && !C2432j.m51174c(this.f3807b, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19GSU5FX0xPQ0FUSU9O"))))) {
            m55349r0();
            return;
        }
        if (this.f3808c == null) {
            this.f3808c = new AMapLocationClientOption();
        }
        if (this.f3813h) {
            return;
        }
        this.f3813h = true;
        long j = 0;
        m55372g(1029, null, 0L);
        int i2 = C1764c.f3834a[this.f3808c.getLocationMode().ordinal()];
        if (i2 == 1) {
            m55372g(1027, null, 0L);
            m55372g(PointerIconCompat.TYPE_TOP_LEFT_DIAGONAL_DOUBLE_ARROW, null, 0L);
            m55372g(PointerIconCompat.TYPE_TOP_RIGHT_DIAGONAL_DOUBLE_ARROW, null, 0L);
        } else if (i2 == 2) {
            if (C2432j.m51154m(this.f3807b)) {
                m55378d(PointerIconCompat.TYPE_TOP_RIGHT_DIAGONAL_DOUBLE_ARROW);
                m55372g(PointerIconCompat.TYPE_TOP_LEFT_DIAGONAL_DOUBLE_ARROW, null, 0L);
                m55372g(1026, null, 0L);
                return;
            }
            m55378d(PointerIconCompat.TYPE_TOP_RIGHT_DIAGONAL_DOUBLE_ARROW);
            m55372g(1027, null, 0L);
            m55372g(PointerIconCompat.TYPE_VERTICAL_DOUBLE_ARROW, null, 0L);
        } else {
            if (i2 == 3) {
                if (C2432j.m51154m(this.f3807b)) {
                    m55378d(PointerIconCompat.TYPE_TOP_RIGHT_DIAGONAL_DOUBLE_ARROW);
                    m55372g(PointerIconCompat.TYPE_TOP_LEFT_DIAGONAL_DOUBLE_ARROW, null, 0L);
                    m55372g(1026, null, 0L);
                    return;
                }
                m55372g(1027, null, 0L);
                m55372g(PointerIconCompat.TYPE_VERTICAL_DOUBLE_ARROW, null, 0L);
                if (this.f3808c.isGpsFirst() && this.f3808c.isOnceLocation()) {
                    j = this.f3808c.getGpsFirstTimeout();
                }
                m55372g(PointerIconCompat.TYPE_TOP_RIGHT_DIAGONAL_DOUBLE_ARROW, null, j);
            }
        }
    }

    /* renamed from: r0 */
    private void m55349r0() {
        AMapLocation aMapLocation = new AMapLocation("");
        aMapLocation.setErrorCode(12);
        aMapLocation.setLocationDetail("定位权限被禁用,请授予应用定位权限 #1201");
        if (this.f3799E == null) {
            this.f3799E = new AMapLocationQualityReport();
        }
        AMapLocationQualityReport aMapLocationQualityReport = new AMapLocationQualityReport();
        this.f3799E = aMapLocationQualityReport;
        aMapLocationQualityReport.setGpsStatus(4);
        this.f3799E.setGPSSatellites(0);
        this.f3799E.setLocationMode(this.f3808c.getLocationMode());
        this.f3799E.setWifiAble(C2432j.m51162g(this.f3807b));
        this.f3799E.setNetworkType(C2432j.m51160h(this.f3807b));
        this.f3799E.setNetUseTime(0L);
        aMapLocation.setLocationQualityReport(this.f3799E);
        ReportUtil.m51233a((String) null, 2121);
        m55383a0(aMapLocation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: s0 */
    public void m55347s0() {
        try {
            m55378d(1025);
            GpsLocation gpsLocation = this.f3810e;
            if (gpsLocation != null) {
                gpsLocation.m53953c();
            }
            CoarseLocation coarseLocation = this.f3811f;
            if (coarseLocation != null) {
                coarseLocation.m53999b();
            }
            m55378d(PointerIconCompat.TYPE_TOP_RIGHT_DIAGONAL_DOUBLE_ARROW);
            m55372g(GLMapStaticValue.MAP_PARAMETERNAME_SCENIC, null, 0L);
            this.f3813h = false;
            this.f3823r = 0;
        } catch (Throwable th) {
            C2428b.m51299a(th, "ALManager", "stopLocation");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: t */
    public void m55346t(AMapLocation aMapLocation) {
        try {
            if (aMapLocation.getErrorCode() != 0) {
                aMapLocation.setLocationType(0);
            }
            if (aMapLocation.getErrorCode() == 0) {
                double latitude = aMapLocation.getLatitude();
                double longitude = aMapLocation.getLongitude();
                if ((latitude == Utils.DOUBLE_EPSILON && longitude == Utils.DOUBLE_EPSILON) || latitude < -90.0d || latitude > 90.0d || longitude < -180.0d || longitude > 180.0d) {
                    ReportUtil.m51232a("errorLatLng", aMapLocation.toStr());
                    aMapLocation.setLocationType(0);
                    aMapLocation.setErrorCode(8);
                    aMapLocation.setLocationDetail("LatLng is error#0802");
                }
            }
            if (GeocodeSearch.GPS.equalsIgnoreCase(aMapLocation.getProvider()) || !this.f3810e.m53934v()) {
                aMapLocation.setAltitude(C2432j.m51176c(aMapLocation.getAltitude()));
                aMapLocation.setBearing(C2432j.m51209a(aMapLocation.getBearing()));
                aMapLocation.setSpeed(C2432j.m51209a(aMapLocation.getSpeed()));
                m55390U(aMapLocation);
                m55398M(aMapLocation);
                Iterator<AMapLocationListener> it = this.f3814i.iterator();
                while (it.hasNext()) {
                    try {
                        it.next().onLocationChanged(aMapLocation);
                    } catch (Throwable unused) {
                    }
                }
            }
        } catch (Throwable unused2) {
        }
    }

    /* renamed from: t0 */
    private void m55345t0() {
        AMapLocationServer m55405F = m55405F(new Aps(true));
        if (m55355o0()) {
            Bundle bundle = new Bundle();
            String str = (m55405F == null || !(m55405F.getLocationType() == 2 || m55405F.getLocationType() == 4)) ? "0" : "1";
            bundle.putBundle("optBundle", C2428b.m51302a(this.f3808c));
            bundle.putString("isCacheLoc", str);
            m55374f(0, bundle);
            if (this.f3813h) {
                m55374f(13, null);
            }
        }
    }

    /* renamed from: u */
    private synchronized void m55344u(AMapLocation aMapLocation, AMapLocationStaticsEntity aMapLocationStaticsEntity) {
        if (aMapLocation == null) {
            try {
                aMapLocation = new AMapLocation("");
                aMapLocation.setErrorCode(8);
                aMapLocation.setLocationDetail("amapLocation is null#0801");
            } catch (Throwable th) {
                C2428b.m51299a(th, "ALManager", "handlerLocation part3");
                return;
            }
        }
        if (!GeocodeSearch.GPS.equalsIgnoreCase(aMapLocation.getProvider())) {
            aMapLocation.setProvider("lbs");
        }
        if (this.f3799E == null) {
            this.f3799E = new AMapLocationQualityReport();
        }
        this.f3799E.setLocationMode(this.f3808c.getLocationMode());
        GpsLocation gpsLocation = this.f3810e;
        if (gpsLocation != null) {
            this.f3799E.setGPSSatellites(gpsLocation.m53971C());
            this.f3799E.setGpsStatus(this.f3810e.m53973A());
        }
        this.f3799E.setWifiAble(C2432j.m51162g(this.f3807b));
        this.f3799E.setNetworkType(C2432j.m51160h(this.f3807b));
        if (aMapLocation.getLocationType() == 1 || GeocodeSearch.GPS.equalsIgnoreCase(aMapLocation.getProvider())) {
            this.f3799E.setNetUseTime(0L);
        }
        if (aMapLocationStaticsEntity != null) {
            this.f3799E.setNetUseTime(aMapLocationStaticsEntity.m51737a());
        }
        this.f3799E.setInstallHighDangerMockApp(f3793N);
        aMapLocation.setLocationQualityReport(this.f3799E);
        if (this.f3813h) {
            m55342v(aMapLocation, this.f3804J);
            if (aMapLocationStaticsEntity != null) {
                aMapLocationStaticsEntity.m51727d(C2432j.m51186b());
            }
            ReportUtil.m51241a(this.f3807b, aMapLocation, aMapLocationStaticsEntity);
            ReportUtil.m51242a(this.f3807b, aMapLocation);
            m55383a0(aMapLocation.m60094clone());
            ReportRecorder.m51255a(this.f3807b).m51254a(aMapLocation);
            ReportRecorder.m51255a(this.f3807b).m51253b();
        }
        if (this.f3826u) {
            return;
        }
        if (this.f3808c.isOnceLocation()) {
            m55347s0();
            m55374f(14, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u0 */
    public void m55343u0() {
        try {
            if (!f3791L && (this.f3830y || this.f3802H)) {
                if (this.f3830y && !m55408C() && !this.f3801G) {
                    this.f3801G = true;
                    m55339w0();
                }
                if (m55355o0()) {
                    this.f3801G = false;
                    Bundle bundle = new Bundle();
                    bundle.putBundle("optBundle", C2428b.m51302a(this.f3808c));
                    bundle.putString("d", UmidtokenInfo.getUmidtoken());
                    if (!this.f3810e.m53934v()) {
                        m55374f(1, bundle);
                    }
                }
            } else {
                f3791L = false;
                this.f3802H = true;
                m55345t0();
            }
        } catch (Throwable th) {
            try {
                C2428b.m51299a(th, "ALManager", "doLBSLocation");
                try {
                    if (this.f3808c.isOnceLocation()) {
                        return;
                    }
                    m55341v0();
                } catch (Throwable unused) {
                }
            } finally {
                try {
                    if (!this.f3808c.isOnceLocation()) {
                        m55341v0();
                    }
                } catch (Throwable unused2) {
                }
            }
        }
    }

    /* renamed from: v */
    private void m55342v(AMapLocation aMapLocation, String str) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("loc", aMapLocation);
        bundle.putString("lastLocNb", str);
        m55372g(PointerIconCompat.TYPE_HORIZONTAL_DOUBLE_ARROW, bundle, 0L);
    }

    /* renamed from: v0 */
    private void m55341v0() {
        if (this.f3808c.getLocationMode() != AMapLocationClientOption.AMapLocationMode.Device_Sensors) {
            m55372g(PointerIconCompat.TYPE_TOP_RIGHT_DIAGONAL_DOUBLE_ARROW, null, this.f3808c.getInterval() >= 1000 ? this.f3808c.getInterval() : 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: w0 */
    public void m55339w0() {
        try {
            if (this.f3821p == null) {
                this.f3821p = new Messenger(this.f3809d);
            }
            m55368i(m55337x0());
        } catch (Throwable unused) {
        }
    }

    /* renamed from: x0 */
    private Intent m55337x0() {
        String str;
        if (this.f3822q == null) {
            this.f3822q = new Intent(this.f3807b, APSService.class);
        }
        try {
            if (!TextUtils.isEmpty(AMapLocationClientOption.getAPIKEY())) {
                str = AMapLocationClientOption.getAPIKEY();
            } else {
                str = C1780e4.m55240j(this.f3807b);
            }
        } catch (Throwable th) {
            C2428b.m51299a(th, "ALManager", "startServiceImpl p2");
            str = "";
        }
        this.f3822q.putExtra("a", str);
        this.f3822q.putExtra("b", C1780e4.m55243g(this.f3807b));
        this.f3822q.putExtra("d", UmidtokenInfo.getUmidtoken());
        return this.f3822q;
    }

    /* renamed from: y */
    private static void m55336y(Aps aps) {
        try {
            aps.m51693d();
            aps.m51710a(new AMapLocationClientOption().setNeedAddress(false));
            aps.m51703a(true, new AMapLocationStaticsEntity());
        } catch (Throwable th) {
            C2428b.m51299a(th, "ALManager", "apsLocation:doFirstNetLocate 2");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: y0 */
    public void m55335y0() {
        try {
            StringBuilder sb = new StringBuilder();
            new AMapLocationStaticsEntity().m51722f("#2001");
            sb.append("模糊权限下不支持低功耗定位#2001");
            ReportUtil.m51233a((String) null, 2153);
            AMapLocationServer aMapLocationServer = new AMapLocationServer("");
            aMapLocationServer.setErrorCode(20);
            aMapLocationServer.setLocationDetail(sb.toString());
            m55363k0(aMapLocationServer);
        } catch (Throwable th) {
            C2428b.m51299a(th, "ALManager", "apsLocation:callback");
        }
    }

    /* renamed from: z */
    private void m55334z(Aps aps, AMapLocationStaticsEntity aMapLocationStaticsEntity) {
        try {
            aps.m51713a(this.f3807b);
            aps.m51710a(this.f3808c);
            aps.m51700b(aMapLocationStaticsEntity);
        } catch (Throwable th) {
            C2428b.m51299a(th, "ALManager", "initApsBase");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: z0 */
    public void m55333z0() {
        this.f3810e.m53935u(this.f3808c);
        this.f3811f.m53984q(this.f3808c);
        if (this.f3813h && !this.f3808c.getLocationMode().equals(this.f3827v)) {
            m55347s0();
            m55353p0();
        }
        this.f3827v = this.f3808c.getLocationMode();
        if (this.f3829x != null) {
            if (this.f3808c.isOnceLocation()) {
                this.f3829x.m51246a(this.f3807b, 0);
            } else {
                this.f3829x.m51246a(this.f3807b, 1);
            }
            this.f3829x.m51240a(this.f3807b, this.f3808c);
        }
    }

    /* renamed from: B */
    public final void m55409B(boolean z) {
        try {
            Bundle bundle = new Bundle();
            bundle.putBoolean("j", z);
            m55372g(1024, bundle, 0L);
        } catch (Throwable th) {
            C2428b.m51299a(th, "ALManager", "disableBackgroundLocation");
        }
    }

    /* renamed from: C */
    public final boolean m55408C() {
        return this.f3812g;
    }

    /* renamed from: G */
    public final void m55404G() {
        HandlerC1767f handlerC1767f;
        try {
            if (this.f3795A.getCacheCallBack() && (handlerC1767f = this.f3809d) != null) {
                handlerC1767f.sendEmptyMessageDelayed(13, this.f3795A.getCacheCallBackTime());
            }
        } catch (Throwable unused) {
        }
        try {
            m55372g(1003, null, 0L);
        } catch (Throwable th) {
            C2428b.m51299a(th, "ALManager", "startLocation");
        }
    }

    /* renamed from: N */
    public final void m55397N(AMapLocationListener aMapLocationListener) {
        try {
            m55372g(1005, aMapLocationListener, 0L);
        } catch (Throwable th) {
            C2428b.m51299a(th, "ALManager", "unRegisterLocationListener");
        }
    }

    /* renamed from: R */
    public final void m55393R() {
        try {
            m55372g(1004, null, 0L);
        } catch (Throwable th) {
            C2428b.m51299a(th, "ALManager", "stopLocation");
        }
    }

    /* renamed from: W */
    public final void m55388W() {
        try {
            H5LocationClient h5LocationClient = this.f3796B;
            if (h5LocationClient != null) {
                h5LocationClient.m54037h();
                this.f3796B = null;
            }
            m55372g(1011, null, 0L);
            this.f3826u = true;
        } catch (Throwable th) {
            C2428b.m51299a(th, "ALManager", "onDestroy");
        }
    }

    /* renamed from: c0 */
    public final AMapLocation m55379c0() {
        AMapLocation aMapLocation = null;
        try {
            LastLocationManager lastLocationManager = this.f3819n;
            if (lastLocationManager != null && (aMapLocation = lastLocationManager.m54031d()) != null) {
                aMapLocation.setTrustedLevel(3);
            }
        } catch (Throwable th) {
            C2428b.m51299a(th, "ALManager", "getLastKnownLocation");
        }
        return aMapLocation;
    }

    /* renamed from: e */
    public final void m55376e(int i, Notification notification) {
        if (i == 0 || notification == null) {
            return;
        }
        try {
            if (this.f3818m && this.f3820o != null) {
                Bundle bundle = new Bundle();
                bundle.putBundle("optBundle", C2428b.m51302a(this.f3808c));
                m55374f(0, bundle);
                this.f3818m = false;
            }
            Bundle bundle2 = new Bundle();
            bundle2.putInt("i", i);
            bundle2.putParcelable("h", notification);
            m55372g(1023, bundle2, 0L);
        } catch (Throwable th) {
            C2428b.m51299a(th, "ALManager", "disableBackgroundLocation");
        }
    }

    /* renamed from: f0 */
    public final void m55373f0() {
        try {
            H5LocationClient h5LocationClient = this.f3796B;
            if (h5LocationClient != null) {
                h5LocationClient.m54037h();
                this.f3796B = null;
            }
        } catch (Throwable th) {
            C2428b.m51299a(th, "ALManager", "stopAssistantLocation");
        }
    }

    /* renamed from: i0 */
    final void m55367i0() {
        m55374f(12, null);
        this.f3816k = true;
        this.f3817l = true;
        this.f3818m = true;
        this.f3812g = false;
        this.f3830y = false;
        m55347s0();
        ReportUtil reportUtil = this.f3829x;
        if (reportUtil != null) {
            reportUtil.m51229b(this.f3807b);
        }
        ReportRecorder.m51255a(this.f3807b).m51256a();
        ReportUtil.m51247a(this.f3807b);
        ApsManager apsManager = this.f3831z;
        if (apsManager != null) {
            apsManager.m55307s().sendEmptyMessage(11);
        } else {
            ServiceConnection serviceConnection = this.f3798D;
            if (serviceConnection != null) {
                this.f3807b.unbindService(serviceConnection);
            }
        }
        try {
            if (this.f3805K) {
                this.f3807b.stopService(m55337x0());
            }
        } catch (Throwable unused) {
        }
        this.f3805K = false;
        ArrayList<AMapLocationListener> arrayList = this.f3814i;
        if (arrayList != null) {
            arrayList.clear();
            this.f3814i = null;
        }
        this.f3798D = null;
        m55361l0();
        HandlerThreadC1766e handlerThreadC1766e = this.f3825t;
        if (handlerThreadC1766e != null) {
            if (Build.VERSION.SDK_INT >= 18) {
                try {
                    Reflect.m51262a(handlerThreadC1766e, HandlerThread.class, "quitSafely", new Object[0]);
                } catch (Throwable unused2) {
                    this.f3825t.quit();
                }
            } else {
                handlerThreadC1766e.quit();
            }
        }
        this.f3825t = null;
        HandlerC1767f handlerC1767f = this.f3809d;
        if (handlerC1767f != null) {
            handlerC1767f.removeCallbacksAndMessages(null);
        }
        LastLocationManager lastLocationManager = this.f3819n;
        if (lastLocationManager != null) {
            lastLocationManager.m54030e();
            this.f3819n = null;
        }
    }

    /* renamed from: m */
    public final void m55360m(WebView webView) {
        if (this.f3796B == null) {
            this.f3796B = new H5LocationClient(this.f3807b, webView);
        }
        this.f3796B.m54042c();
    }

    /* renamed from: w */
    public final void m55340w(AMapLocationClientOption aMapLocationClientOption) {
        try {
            this.f3795A = aMapLocationClientOption.m60095clone();
            m55372g(PointerIconCompat.TYPE_ZOOM_IN, aMapLocationClientOption.m60095clone(), 0L);
        } catch (Throwable th) {
            C2428b.m51299a(th, "ALManager", "setLocationOption");
        }
    }

    /* renamed from: x */
    public final void m55338x(AMapLocationListener aMapLocationListener) {
        try {
            m55372g(1002, aMapLocationListener, 0L);
        } catch (Throwable th) {
            C2428b.m51299a(th, "ALManager", "setLocationListener");
        }
    }

    /* compiled from: AmapLocationManager.java */
    /* renamed from: com.amap.api.col.3l.d2$f */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public class HandlerC1767f extends Handler {
        public HandlerC1767f(Looper looper) {
            super(looper);
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            HandlerC1767f handlerC1767f;
            HandlerC1767f handlerC1767f2;
            try {
                super.handleMessage(message);
                AmapLocationManager amapLocationManager = AmapLocationManager.this;
                if (amapLocationManager.f3826u) {
                    return;
                }
                int i = message.what;
                if (i != 1) {
                    if (i != 2) {
                        if (i != 13) {
                            switch (i) {
                                case 5:
                                    Bundle data = message.getData();
                                    data.putBundle("optBundle", C2428b.m51302a(AmapLocationManager.this.f3808c));
                                    AmapLocationManager.this.m55374f(10, data);
                                    return;
                                case 6:
                                    Bundle data2 = message.getData();
                                    GpsLocation gpsLocation = AmapLocationManager.this.f3810e;
                                    if (gpsLocation != null) {
                                        gpsLocation.m53948h(data2);
                                        return;
                                    }
                                    return;
                                case 7:
                                    AmapLocationManager.this.f3824s = message.getData().getBoolean("ngpsAble");
                                    return;
                                case 8:
                                    ReportUtil.m51233a((String) null, 2141);
                                    break;
                                case 9:
                                    boolean unused = AmapLocationManager.f3793N = message.getData().getBoolean("installMockApp");
                                    return;
                                case 10:
                                    amapLocationManager.m55346t((AMapLocation) message.obj);
                                    return;
                                default:
                                    switch (i) {
                                        case 100:
                                            ReportUtil.m51233a((String) null, 2155);
                                            break;
                                        case 101:
                                            break;
                                        case 102:
                                            Bundle data3 = message.getData();
                                            data3.putBundle("optBundle", C2428b.m51302a(AmapLocationManager.this.f3808c));
                                            AmapLocationManager.this.m55374f(15, data3);
                                            return;
                                        case 103:
                                            Bundle data4 = message.getData();
                                            if (AmapLocationManager.this.f3811f != null) {
                                                AmapLocationManager.this.f3811f.m53995f(data4);
                                                return;
                                            }
                                            return;
                                        default:
                                            return;
                                    }
                                    Message obtain = Message.obtain();
                                    obtain.what = 1028;
                                    obtain.obj = message.obj;
                                    AmapLocationManager.this.f3803I.sendMessage(obtain);
                                    if (AmapLocationManager.this.f3795A == null || !AmapLocationManager.this.f3795A.getCacheCallBack() || (handlerC1767f2 = AmapLocationManager.this.f3809d) == null) {
                                        return;
                                    }
                                    handlerC1767f2.removeMessages(13);
                                    return;
                            }
                        } else {
                            AMapLocationServer aMapLocationServer = amapLocationManager.f3806a;
                            if (aMapLocationServer != null) {
                                amapLocationManager.m55346t(aMapLocationServer);
                                return;
                            }
                            AMapLocation aMapLocation = new AMapLocation("LBS");
                            aMapLocation.setErrorCode(33);
                            AmapLocationManager.this.m55346t(aMapLocation);
                            return;
                        }
                    }
                    Message obtain2 = Message.obtain();
                    obtain2.what = 12;
                    obtain2.obj = message.obj;
                    AmapLocationManager.this.f3803I.sendMessage(obtain2);
                    if (AmapLocationManager.this.f3795A == null || !AmapLocationManager.this.f3795A.getCacheCallBack() || (handlerC1767f = AmapLocationManager.this.f3809d) == null) {
                        return;
                    }
                    handlerC1767f.removeMessages(13);
                    return;
                }
                Message obtainMessage = amapLocationManager.f3803I.obtainMessage();
                obtainMessage.what = 11;
                obtainMessage.setData(message.getData());
                AmapLocationManager.this.f3803I.sendMessage(obtainMessage);
            } catch (Throwable th) {
                C2428b.m51299a(th, "AmapLocationManager$MainHandler", 0 == 0 ? "handleMessage" : null);
            }
        }

        public HandlerC1767f() {
        }
    }
}

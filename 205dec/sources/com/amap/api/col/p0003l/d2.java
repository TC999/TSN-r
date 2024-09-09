package com.amap.api.col.p0003l;

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
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.location.AMapLocationQualityReport;
import com.amap.api.location.APSService;
import com.amap.api.location.UmidtokenInfo;
import com.autonavi.aps.amapapi.utils.g;
import com.autonavi.aps.amapapi.utils.h;
import com.autonavi.aps.amapapi.utils.j;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: AmapLocationManager.java */
/* renamed from: com.amap.api.col.3l.d2  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class d2 {

    /* renamed from: L  reason: collision with root package name */
    private static boolean f7361L = true;
    public static volatile boolean M;
    private static boolean N;
    private static AtomicBoolean O = new AtomicBoolean(false);

    /* renamed from: a  reason: collision with root package name */
    com.autonavi.aps.amapapi.model.a f7362a;

    /* renamed from: b  reason: collision with root package name */
    private Context f7363b;

    /* renamed from: d  reason: collision with root package name */
    public f f7365d;

    /* renamed from: f  reason: collision with root package name */
    private t4 f7367f;

    /* renamed from: n  reason: collision with root package name */
    s7 f7375n;

    /* renamed from: q  reason: collision with root package name */
    Intent f7378q;

    /* renamed from: c  reason: collision with root package name */
    AMapLocationClientOption f7364c = new AMapLocationClientOption();

    /* renamed from: e  reason: collision with root package name */
    t5 f7366e = null;

    /* renamed from: g  reason: collision with root package name */
    private boolean f7368g = false;

    /* renamed from: h  reason: collision with root package name */
    private volatile boolean f7369h = false;

    /* renamed from: i  reason: collision with root package name */
    ArrayList<AMapLocationListener> f7370i = new ArrayList<>();

    /* renamed from: j  reason: collision with root package name */
    boolean f7371j = false;

    /* renamed from: k  reason: collision with root package name */
    public boolean f7372k = true;

    /* renamed from: l  reason: collision with root package name */
    public boolean f7373l = true;

    /* renamed from: m  reason: collision with root package name */
    public boolean f7374m = true;

    /* renamed from: o  reason: collision with root package name */
    Messenger f7376o = null;

    /* renamed from: p  reason: collision with root package name */
    Messenger f7377p = null;

    /* renamed from: r  reason: collision with root package name */
    int f7379r = 0;

    /* renamed from: s  reason: collision with root package name */
    private boolean f7380s = true;

    /* renamed from: t  reason: collision with root package name */
    e f7381t = null;

    /* renamed from: u  reason: collision with root package name */
    boolean f7382u = false;

    /* renamed from: v  reason: collision with root package name */
    AMapLocationClientOption.AMapLocationMode f7383v = AMapLocationClientOption.AMapLocationMode.Hight_Accuracy;

    /* renamed from: w  reason: collision with root package name */
    Object f7384w = new Object();

    /* renamed from: x  reason: collision with root package name */
    h f7385x = null;

    /* renamed from: y  reason: collision with root package name */
    boolean f7386y = false;

    /* renamed from: z  reason: collision with root package name */
    d3 f7387z = null;
    private AMapLocationClientOption A = new AMapLocationClientOption();
    private s6 B = null;
    String C = null;
    private ServiceConnection D = new b();
    AMapLocationQualityReport E = null;
    boolean F = false;
    boolean G = false;
    private volatile boolean H = false;
    d I = null;
    String J = null;
    boolean K = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* compiled from: AmapLocationManager.java */
    /* renamed from: com.amap.api.col.3l.d2$a */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class a extends a8 {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f7388a;

        a(Context context) {
            this.f7388a = context;
        }

        @Override // com.amap.api.col.p0003l.a8
        public final void runTask() {
            i4.R();
            i4.o(this.f7388a);
            i4.F(this.f7388a);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* compiled from: AmapLocationManager.java */
    /* renamed from: com.amap.api.col.3l.d2$b */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    final class b implements ServiceConnection {
        b() {
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                d2.this.f7376o = new Messenger(iBinder);
                d2.this.f7368g = true;
                d2.this.f7386y = true;
            } catch (Throwable th) {
                com.autonavi.aps.amapapi.utils.b.a(th, "ALManager", "onServiceConnected");
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
            d2 d2Var = d2.this;
            d2Var.f7376o = null;
            d2Var.f7368g = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* compiled from: AmapLocationManager.java */
    /* renamed from: com.amap.api.col.3l.d2$c */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static /* synthetic */ class c {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f7390a;

        static {
            int[] iArr = new int[AMapLocationClientOption.AMapLocationMode.values().length];
            f7390a = iArr;
            try {
                iArr[AMapLocationClientOption.AMapLocationMode.Battery_Saving.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f7390a[AMapLocationClientOption.AMapLocationMode.Device_Sensors.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f7390a[AMapLocationClientOption.AMapLocationMode.Hight_Accuracy.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* compiled from: AmapLocationManager.java */
    /* renamed from: com.amap.api.col.3l.d2$d */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public class d extends Handler {
        public d(Looper looper) {
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
            ?? r02 = 0;
            try {
                super.handleMessage(message);
                if (com.autonavi.aps.amapapi.utils.a.f11985h) {
                    Log.e("AMapLocationClient", "SERVICE_NOT_AVAILABLE");
                    return;
                }
                int i4 = message.what;
                if (i4 == 11) {
                    d2.this.k(message.getData());
                } else if (i4 == 12) {
                    d2.this.I(message);
                } else if (i4 != 1011) {
                    try {
                        switch (i4) {
                            case 1002:
                                d2.this.V((AMapLocationListener) message.obj);
                                return;
                            case 1003:
                                d2.this.p0();
                                d2.this.f(13, null);
                                return;
                            case 1004:
                                d2.this.s0();
                                d2.this.f(14, null);
                                return;
                            case 1005:
                                d2.this.b0((AMapLocationListener) message.obj);
                                return;
                            default:
                                switch (i4) {
                                    case 1014:
                                        d2.this.l(message);
                                        return;
                                    case 1015:
                                        d2 d2Var = d2.this;
                                        d2Var.f7366e.p(d2Var.f7364c);
                                        d2.this.g(1025, null, 300000L);
                                        return;
                                    case 1016:
                                        if (j.m(d2.this.f7363b)) {
                                            com.autonavi.aps.amapapi.utils.d.a();
                                            d2.this.y0();
                                            return;
                                        } else if (d2.this.f7366e.v()) {
                                            d2.this.g(1016, null, 1000L);
                                            return;
                                        } else {
                                            d2.this.u0();
                                            return;
                                        }
                                    case 1017:
                                        d2.this.f7366e.c();
                                        d2.this.d(1025);
                                        return;
                                    case 1018:
                                        d2 d2Var2 = d2.this;
                                        AMapLocationClientOption aMapLocationClientOption = (AMapLocationClientOption) message.obj;
                                        d2Var2.f7364c = aMapLocationClientOption;
                                        if (aMapLocationClientOption != null) {
                                            d2Var2.z0();
                                            return;
                                        }
                                        return;
                                    default:
                                        switch (i4) {
                                            case 1023:
                                                d2.this.S(message);
                                                return;
                                            case 1024:
                                                d2.this.X(message);
                                                return;
                                            case 1025:
                                                if (d2.this.f7366e.F()) {
                                                    d2.this.f7366e.c();
                                                    d2 d2Var3 = d2.this;
                                                    d2Var3.f7366e.p(d2Var3.f7364c);
                                                }
                                                d2.this.g(1025, null, 300000L);
                                                return;
                                            case 1026:
                                                com.autonavi.aps.amapapi.utils.d.b();
                                                d2.this.f7367f.l(d2.this.f7364c);
                                                return;
                                            case 1027:
                                                d2.this.f7367f.b();
                                                return;
                                            case 1028:
                                                d2.this.k0((AMapLocation) message.obj);
                                                return;
                                            case 1029:
                                                Bundle bundle = new Bundle();
                                                bundle.putString("objHash", Integer.toString(System.identityHashCode(this)));
                                                d2.this.f(16, bundle);
                                                return;
                                            case 1030:
                                                Bundle bundle2 = new Bundle();
                                                bundle2.putString("objHash", Integer.toString(System.identityHashCode(this)));
                                                d2.this.f(17, bundle2);
                                                return;
                                            default:
                                                return;
                                        }
                                }
                        }
                    } catch (Throwable th) {
                        r02 = message;
                        th = th;
                        if (r02 == 0) {
                            r02 = "handleMessage";
                        }
                        com.autonavi.aps.amapapi.utils.b.a(th, "AMapLocationManage$MHandlerr", r02);
                    }
                } else {
                    d2.this.f(14, null);
                    d2.this.i0();
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* compiled from: AmapLocationManager.java */
    /* renamed from: com.amap.api.col.3l.d2$e */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class e extends HandlerThread {

        /* renamed from: a  reason: collision with root package name */
        d2 f7392a;

        public e(String str, d2 d2Var) {
            super(str);
            this.f7392a = d2Var;
        }

        @Override // android.os.HandlerThread
        protected final void onLooperPrepared() {
            try {
                this.f7392a.f7375n.b();
                g.a(this.f7392a.f7363b);
                this.f7392a.w0();
                d2 d2Var = this.f7392a;
                if (d2Var != null && d2Var.f7363b != null) {
                    com.autonavi.aps.amapapi.utils.a.b(this.f7392a.f7363b);
                    com.autonavi.aps.amapapi.utils.a.a(this.f7392a.f7363b);
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

    public d2(Context context, Intent intent, Looper looper) {
        this.f7378q = null;
        this.f7363b = context;
        this.f7378q = intent;
        H(looper);
    }

    private static void A(com.autonavi.aps.amapapi.b bVar, com.autonavi.aps.amapapi.model.a aVar) {
        if (aVar != null) {
            try {
                if (aVar.getErrorCode() == 0) {
                    bVar.b(aVar);
                }
            } catch (Throwable th) {
                com.autonavi.aps.amapapi.utils.b.a(th, "ALManager", "apsLocation:doFirstAddCache");
            }
        }
    }

    private boolean A0() {
        if (j.j(this.f7363b)) {
            int i4 = -1;
            try {
                i4 = com.autonavi.aps.amapapi.utils.f.b(((Application) StubApp.getOrigApplicationContext(this.f7363b.getApplicationContext())).getBaseContext(), "checkSelfPermission", "android.permission.FOREGROUND_SERVICE");
            } catch (Throwable unused) {
            }
            if (i4 != 0) {
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
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.autonavi.aps.amapapi.model.a F(com.autonavi.aps.amapapi.b r14) {
        /*
            Method dump skipped, instructions count: 331
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003l.d2.F(com.autonavi.aps.amapapi.b):com.autonavi.aps.amapapi.model.a");
    }

    private void H(Looper looper) {
        try {
            if (looper == null) {
                if (Looper.myLooper() == null) {
                    this.f7365d = new f(this.f7363b.getMainLooper());
                } else {
                    this.f7365d = new f();
                }
            } else {
                this.f7365d = new f(looper);
            }
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "ALManager", "init 1");
        }
        try {
            this.f7375n = new s7(this.f7363b);
            e eVar = new e("amapLocManagerThread", this);
            this.f7381t = eVar;
            eVar.setPriority(5);
            this.f7381t.start();
            this.I = a(this.f7381t.getLooper());
            try {
                this.f7366e = new t5(this.f7363b, this.f7365d);
                this.f7367f = new t4(this.f7363b, this.f7365d);
            } catch (Throwable th2) {
                com.autonavi.aps.amapapi.utils.b.a(th2, "ALManager", "init 3");
            }
            if (this.f7385x == null) {
                this.f7385x = new h();
            }
            h(this.f7363b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I(Message message) {
        try {
            AMapLocation aMapLocation = (AMapLocation) message.obj;
            if (this.f7372k && this.f7376o != null) {
                Bundle bundle = new Bundle();
                bundle.putBundle("optBundle", com.autonavi.aps.amapapi.utils.b.a(this.f7364c));
                f(0, bundle);
                if (this.f7369h) {
                    f(13, null);
                }
                this.f7372k = false;
            }
            u(aMapLocation, null);
            d(1025);
            g(1025, null, 300000L);
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "ALManager", "resultGpsLocationSuccess");
        }
    }

    private static void M(AMapLocation aMapLocation) {
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
    public void S(Message message) {
        if (message == null) {
            return;
        }
        try {
            Bundle data = message.getData();
            if (data == null) {
                return;
            }
            int i4 = data.getInt("i", 0);
            Intent x02 = x0();
            x02.putExtra("i", i4);
            x02.putExtra("h", (Notification) data.getParcelable("h"));
            x02.putExtra("g", 1);
            j(x02, true);
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "ALManager", "doEnableBackgroundLocation");
        }
    }

    private void U(AMapLocation aMapLocation) {
        StringBuilder sb;
        if (aMapLocation != null) {
            try {
                String locationDetail = aMapLocation.getLocationDetail();
                if (TextUtils.isEmpty(locationDetail)) {
                    sb = new StringBuilder();
                } else {
                    sb = new StringBuilder(locationDetail);
                }
                boolean c4 = j.c(this.f7363b, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19XSUZJX1NUQVRF");
                boolean c5 = j.c(this.f7363b, "WYW5kcm9pZC5wZXJtaXNzaW9uLkNIQU5HRV9XSUZJX1NUQVRF");
                boolean c6 = j.c(this.f7363b, "WYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19MT0NBVElPTl9FWFRSQV9DT01NQU5EUw==");
                boolean c7 = j.c(this.f7363b, "EYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU=");
                boolean c8 = j.c(this.f7363b, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19GSU5FX0xPQ0FUSU9O");
                boolean c9 = j.c(this.f7363b, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19DT0FSU0VfTE9DQVRJT04=");
                sb.append(c4 ? "#pm1" : "#pm0");
                String str = "1";
                sb.append(c5 ? "1" : "0");
                sb.append(c6 ? "1" : "0");
                sb.append(c7 ? "1" : "0");
                sb.append(c8 ? "1" : "0");
                if (!c9) {
                    str = "0";
                }
                sb.append(str);
                aMapLocation.setLocationDetail(sb.toString());
            } catch (Throwable unused) {
                com.autonavi.aps.amapapi.utils.d.b();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V(AMapLocationListener aMapLocationListener) {
        if (aMapLocationListener != null) {
            if (this.f7370i == null) {
                this.f7370i = new ArrayList<>();
            }
            if (this.f7370i.contains(aMapLocationListener)) {
                return;
            }
            this.f7370i.add(aMapLocationListener);
            return;
        }
        throw new IllegalArgumentException("listener\u53c2\u6570\u4e0d\u80fd\u4e3anull");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X(Message message) {
        if (message == null) {
            return;
        }
        try {
            Bundle data = message.getData();
            if (data == null) {
                return;
            }
            boolean z3 = data.getBoolean("j", true);
            Intent x02 = x0();
            x02.putExtra("j", z3);
            x02.putExtra("g", 2);
            j(x02, false);
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "ALManager", "doDisableBackgroundLocation");
        }
    }

    private d a(Looper looper) {
        d dVar;
        synchronized (this.f7384w) {
            dVar = new d(looper);
            this.I = dVar;
        }
        return dVar;
    }

    private void a0(AMapLocation aMapLocation) {
        Message obtainMessage = this.f7365d.obtainMessage();
        obtainMessage.what = 10;
        obtainMessage.obj = aMapLocation;
        this.f7365d.sendMessage(obtainMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b0(AMapLocationListener aMapLocationListener) {
        if (!this.f7370i.isEmpty() && this.f7370i.contains(aMapLocationListener)) {
            this.f7370i.remove(aMapLocationListener);
        }
        if (this.f7370i.isEmpty()) {
            s0();
        }
    }

    private com.autonavi.aps.amapapi.model.a c(com.autonavi.aps.amapapi.b bVar, boolean z3) {
        if (this.f7364c.isLocationCacheEnable()) {
            try {
                return bVar.b(z3);
            } catch (Throwable th) {
                com.autonavi.aps.amapapi.utils.b.a(th, "ALManager", "doFirstCacheLoc");
                return null;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(int i4) {
        synchronized (this.f7384w) {
            d dVar = this.I;
            if (dVar != null) {
                dVar.removeMessages(i4);
            }
        }
    }

    private synchronized void e0(AMapLocation aMapLocation) {
        if (aMapLocation == null) {
            try {
                aMapLocation = new AMapLocation("");
                aMapLocation.setErrorCode(8);
                aMapLocation.setLocationDetail("coarse amapLocation is null#2005");
            } catch (Throwable th) {
                com.autonavi.aps.amapapi.utils.b.a(th, "ALManager", "handlerCoarseLocation part2");
                return;
            }
        }
        if (this.E == null) {
            this.E = new AMapLocationQualityReport();
        }
        this.E.setLocationMode(this.f7364c.getLocationMode());
        if (this.f7367f != null) {
            this.E.setGPSSatellites(aMapLocation.getSatellites());
            this.E.setGpsStatus(this.f7367f.n());
        }
        this.E.setWifiAble(j.g(this.f7363b));
        this.E.setNetworkType(j.h(this.f7363b));
        this.E.setNetUseTime(0L);
        this.E.setInstallHighDangerMockApp(N);
        aMapLocation.setLocationQualityReport(this.E);
        if (this.f7369h) {
            h.a(this.f7363b, aMapLocation);
            a0(aMapLocation.m15clone());
            g.a(this.f7363b).a(aMapLocation);
            g.a(this.f7363b).b();
        }
        if (this.f7382u) {
            return;
        }
        if (this.f7367f != null) {
            s0();
        }
        f(14, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(int i4, Bundle bundle) {
        if (bundle == null) {
            try {
                bundle = new Bundle();
            } catch (Throwable th) {
                boolean z3 = (th instanceof IllegalStateException) && th.getMessage().contains("sending message to a Handler on a dead thread");
                if ((th instanceof RemoteException) || z3) {
                    this.f7376o = null;
                    this.f7368g = false;
                }
                com.autonavi.aps.amapapi.utils.b.a(th, "ALManager", "sendLocMessage");
                return;
            }
        }
        if (TextUtils.isEmpty(this.C)) {
            this.C = com.autonavi.aps.amapapi.utils.b.b(this.f7363b);
        }
        bundle.putString("c", this.C);
        Message obtain = Message.obtain();
        obtain.what = i4;
        obtain.setData(bundle);
        obtain.replyTo = this.f7377p;
        Messenger messenger = this.f7376o;
        if (messenger != null) {
            messenger.send(obtain);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(int i4, Object obj, long j4) {
        synchronized (this.f7384w) {
            if (this.I != null) {
                Message obtain = Message.obtain();
                obtain.what = i4;
                if (obj instanceof Bundle) {
                    obtain.setData((Bundle) obj);
                } else {
                    obtain.obj = obj;
                }
                this.I.sendMessageDelayed(obtain, j4);
            }
        }
    }

    private static void h(Context context) {
        if (O.compareAndSet(false, true)) {
            z7.h().b(new a(context));
        }
    }

    private void h0(AMapLocation aMapLocation) {
        if (aMapLocation == null) {
            return;
        }
        AMapLocation aMapLocation2 = null;
        try {
            com.autonavi.aps.amapapi.storage.b bVar = s7.f8957g;
            if (bVar == null) {
                s7 s7Var = this.f7375n;
                if (s7Var != null) {
                    aMapLocation2 = s7Var.d();
                }
            } else {
                aMapLocation2 = bVar.a();
            }
            h.a(aMapLocation2, aMapLocation);
        } catch (Throwable unused) {
        }
    }

    private void i(Intent intent) {
        try {
            this.f7363b.bindService(intent, this.D, 1);
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "ALManager", "startServiceImpl");
        }
    }

    private void j(Intent intent, boolean z3) {
        Context context = this.f7363b;
        if (context != null) {
            if (Build.VERSION.SDK_INT >= 26 && z3) {
                if (!A0()) {
                    Log.e("amapapi", "-------------\u8c03\u7528\u540e\u53f0\u5b9a\u4f4d\u670d\u52a1\uff0c\u7f3a\u5c11\u6743\u9650\uff1aandroid.permission.FOREGROUND_SERVICE--------------");
                    return;
                } else {
                    try {
                        this.f7363b.getClass().getMethod("startForegroundService", Intent.class).invoke(this.f7363b, intent);
                    } catch (Throwable unused) {
                        this.f7363b.startService(intent);
                    }
                }
            } else {
                context.startService(intent);
            }
            this.K = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(Bundle bundle) {
        com.autonavi.aps.amapapi.a aVar;
        AMapLocation aMapLocation;
        t5 t5Var;
        AMapLocation aMapLocation2 = null;
        if (bundle != null) {
            try {
                bundle.setClassLoader(AMapLocation.class.getClassLoader());
                aMapLocation = (AMapLocation) bundle.getParcelable("loc");
                this.J = bundle.getString("nb");
                aVar = (com.autonavi.aps.amapapi.a) bundle.getParcelable("statics");
                if (aMapLocation != null) {
                    try {
                        if (aMapLocation.getErrorCode() == 0 && (t5Var = this.f7366e) != null) {
                            t5Var.x();
                            if (!TextUtils.isEmpty(aMapLocation.getAdCode())) {
                                t5.J = aMapLocation;
                            }
                        }
                    } catch (Throwable th) {
                        th = th;
                        com.autonavi.aps.amapapi.utils.b.a(th, "AmapLocationManager", "resultLbsLocationSuccess");
                        u(aMapLocation2, aVar);
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                aVar = null;
                com.autonavi.aps.amapapi.utils.b.a(th, "AmapLocationManager", "resultLbsLocationSuccess");
                u(aMapLocation2, aVar);
            }
        } else {
            aVar = null;
            aMapLocation = null;
        }
        t5 t5Var2 = this.f7366e;
        aMapLocation2 = t5Var2 != null ? t5Var2.b(aMapLocation, this.J) : aMapLocation;
        u(aMapLocation2, aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k0(AMapLocation aMapLocation) {
        try {
            if (this.f7373l && this.f7376o != null) {
                Bundle bundle = new Bundle();
                bundle.putBundle("optBundle", com.autonavi.aps.amapapi.utils.b.a(this.f7364c));
                f(0, bundle);
                if (this.f7369h) {
                    f(13, null);
                }
                this.f7373l = false;
            }
            e0(aMapLocation);
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "ALManager", "resultGpsLocationSuccess");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(Message message) {
        try {
            Bundle data = message.getData();
            AMapLocation aMapLocation = (AMapLocation) data.getParcelable("loc");
            String string = data.getString("lastLocNb");
            h0(aMapLocation);
            if (this.f7375n.c(aMapLocation, string)) {
                this.f7375n.f();
            }
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "ALManager", "doSaveLastLocation");
        }
    }

    private void l0() {
        synchronized (this.f7384w) {
            d dVar = this.I;
            if (dVar != null) {
                dVar.removeCallbacksAndMessages(null);
            }
            this.I = null;
        }
    }

    private boolean o0() {
        boolean z3 = false;
        int i4 = 0;
        do {
            try {
                if (this.f7376o != null) {
                    break;
                }
                Thread.sleep(100L);
                i4++;
            } catch (Throwable th) {
                com.autonavi.aps.amapapi.utils.b.a(th, "ALManager", "checkAPSManager");
            }
        } while (i4 < 50);
        if (this.f7376o == null) {
            Message obtain = Message.obtain();
            Bundle bundle = new Bundle();
            AMapLocation aMapLocation = new AMapLocation("");
            aMapLocation.setErrorCode(10);
            if (!j.k(StubApp.getOrigApplicationContext(this.f7363b.getApplicationContext()))) {
                aMapLocation.setLocationDetail("\u8bf7\u68c0\u67e5\u914d\u7f6e\u6587\u4ef6\u662f\u5426\u914d\u7f6e\u670d\u52a1\uff0c\u5e76\u4e14manifest\u4e2dservice\u6807\u7b7e\u662f\u5426\u914d\u7f6e\u5728application\u6807\u7b7e\u5185#1003");
            } else {
                aMapLocation.setLocationDetail("\u542f\u52a8ApsServcie\u5931\u8d25#1001");
            }
            bundle.putParcelable("loc", aMapLocation);
            obtain.setData(bundle);
            obtain.what = 1;
            this.f7365d.sendMessage(obtain);
        } else {
            z3 = true;
        }
        if (!z3) {
            if (!j.k(StubApp.getOrigApplicationContext(this.f7363b.getApplicationContext()))) {
                h.a((String) null, 2103);
            } else {
                h.a((String) null, 2101);
            }
        }
        return z3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void p0() {
        int i4 = Build.VERSION.SDK_INT;
        if ((i4 < 29 && i4 >= 23 && !j.c(this.f7363b, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19DT0FSU0VfTE9DQVRJT04=") && !j.c(this.f7363b, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19GSU5FX0xPQ0FUSU9O")) || ((i4 < 31 && i4 >= 29 && this.f7363b.getApplicationInfo().targetSdkVersion >= 29 && !j.c(this.f7363b, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19GSU5FX0xPQ0FUSU9O")) || ((i4 < 31 && i4 >= 29 && this.f7363b.getApplicationInfo().targetSdkVersion < 29 && !j.c(this.f7363b, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19DT0FSU0VfTE9DQVRJT04=") && !j.c(this.f7363b, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19GSU5FX0xPQ0FUSU9O")) || (i4 >= 31 && !j.c(this.f7363b, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19DT0FSU0VfTE9DQVRJT04=") && !j.c(this.f7363b, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19GSU5FX0xPQ0FUSU9O"))))) {
            r0();
            return;
        }
        if (this.f7364c == null) {
            this.f7364c = new AMapLocationClientOption();
        }
        if (this.f7369h) {
            return;
        }
        this.f7369h = true;
        long j4 = 0;
        g(1029, null, 0L);
        int i5 = c.f7390a[this.f7364c.getLocationMode().ordinal()];
        if (i5 == 1) {
            g(1027, null, 0L);
            g(1017, null, 0L);
            g(1016, null, 0L);
        } else if (i5 == 2) {
            if (j.m(this.f7363b)) {
                d(1016);
                g(1017, null, 0L);
                g(1026, null, 0L);
                return;
            }
            d(1016);
            g(1027, null, 0L);
            g(1015, null, 0L);
        } else {
            if (i5 == 3) {
                if (j.m(this.f7363b)) {
                    d(1016);
                    g(1017, null, 0L);
                    g(1026, null, 0L);
                    return;
                }
                g(1027, null, 0L);
                g(1015, null, 0L);
                if (this.f7364c.isGpsFirst() && this.f7364c.isOnceLocation()) {
                    j4 = this.f7364c.getGpsFirstTimeout();
                }
                g(1016, null, j4);
            }
        }
    }

    private void r0() {
        AMapLocation aMapLocation = new AMapLocation("");
        aMapLocation.setErrorCode(12);
        aMapLocation.setLocationDetail("\u5b9a\u4f4d\u6743\u9650\u88ab\u7981\u7528,\u8bf7\u6388\u4e88\u5e94\u7528\u5b9a\u4f4d\u6743\u9650 #1201");
        if (this.E == null) {
            this.E = new AMapLocationQualityReport();
        }
        AMapLocationQualityReport aMapLocationQualityReport = new AMapLocationQualityReport();
        this.E = aMapLocationQualityReport;
        aMapLocationQualityReport.setGpsStatus(4);
        this.E.setGPSSatellites(0);
        this.E.setLocationMode(this.f7364c.getLocationMode());
        this.E.setWifiAble(j.g(this.f7363b));
        this.E.setNetworkType(j.h(this.f7363b));
        this.E.setNetUseTime(0L);
        aMapLocation.setLocationQualityReport(this.E);
        h.a((String) null, 2121);
        a0(aMapLocation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s0() {
        try {
            d(1025);
            t5 t5Var = this.f7366e;
            if (t5Var != null) {
                t5Var.c();
            }
            t4 t4Var = this.f7367f;
            if (t4Var != null) {
                t4Var.b();
            }
            d(1016);
            g(1030, null, 0L);
            this.f7369h = false;
            this.f7379r = 0;
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "ALManager", "stopLocation");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(AMapLocation aMapLocation) {
        try {
            if (aMapLocation.getErrorCode() != 0) {
                aMapLocation.setLocationType(0);
            }
            if (aMapLocation.getErrorCode() == 0) {
                double latitude = aMapLocation.getLatitude();
                double longitude = aMapLocation.getLongitude();
                if ((latitude == 0.0d && longitude == 0.0d) || latitude < -90.0d || latitude > 90.0d || longitude < -180.0d || longitude > 180.0d) {
                    h.a("errorLatLng", aMapLocation.toStr());
                    aMapLocation.setLocationType(0);
                    aMapLocation.setErrorCode(8);
                    aMapLocation.setLocationDetail("LatLng is error#0802");
                }
            }
            if ("gps".equalsIgnoreCase(aMapLocation.getProvider()) || !this.f7366e.v()) {
                aMapLocation.setAltitude(j.c(aMapLocation.getAltitude()));
                aMapLocation.setBearing(j.a(aMapLocation.getBearing()));
                aMapLocation.setSpeed(j.a(aMapLocation.getSpeed()));
                U(aMapLocation);
                M(aMapLocation);
                Iterator<AMapLocationListener> it = this.f7370i.iterator();
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

    private void t0() {
        com.autonavi.aps.amapapi.model.a F = F(new com.autonavi.aps.amapapi.b(true));
        if (o0()) {
            Bundle bundle = new Bundle();
            String str = (F == null || !(F.getLocationType() == 2 || F.getLocationType() == 4)) ? "0" : "1";
            bundle.putBundle("optBundle", com.autonavi.aps.amapapi.utils.b.a(this.f7364c));
            bundle.putString("isCacheLoc", str);
            f(0, bundle);
            if (this.f7369h) {
                f(13, null);
            }
        }
    }

    private synchronized void u(AMapLocation aMapLocation, com.autonavi.aps.amapapi.a aVar) {
        if (aMapLocation == null) {
            try {
                aMapLocation = new AMapLocation("");
                aMapLocation.setErrorCode(8);
                aMapLocation.setLocationDetail("amapLocation is null#0801");
            } catch (Throwable th) {
                com.autonavi.aps.amapapi.utils.b.a(th, "ALManager", "handlerLocation part3");
                return;
            }
        }
        if (!"gps".equalsIgnoreCase(aMapLocation.getProvider())) {
            aMapLocation.setProvider("lbs");
        }
        if (this.E == null) {
            this.E = new AMapLocationQualityReport();
        }
        this.E.setLocationMode(this.f7364c.getLocationMode());
        t5 t5Var = this.f7366e;
        if (t5Var != null) {
            this.E.setGPSSatellites(t5Var.C());
            this.E.setGpsStatus(this.f7366e.A());
        }
        this.E.setWifiAble(j.g(this.f7363b));
        this.E.setNetworkType(j.h(this.f7363b));
        if (aMapLocation.getLocationType() == 1 || "gps".equalsIgnoreCase(aMapLocation.getProvider())) {
            this.E.setNetUseTime(0L);
        }
        if (aVar != null) {
            this.E.setNetUseTime(aVar.a());
        }
        this.E.setInstallHighDangerMockApp(N);
        aMapLocation.setLocationQualityReport(this.E);
        if (this.f7369h) {
            v(aMapLocation, this.J);
            if (aVar != null) {
                aVar.d(j.b());
            }
            h.a(this.f7363b, aMapLocation, aVar);
            h.a(this.f7363b, aMapLocation);
            a0(aMapLocation.m15clone());
            g.a(this.f7363b).a(aMapLocation);
            g.a(this.f7363b).b();
        }
        if (this.f7382u) {
            return;
        }
        if (this.f7364c.isOnceLocation()) {
            s0();
            f(14, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u0() {
        try {
            if (!f7361L && (this.f7386y || this.H)) {
                if (this.f7386y && !C() && !this.G) {
                    this.G = true;
                    w0();
                }
                if (o0()) {
                    this.G = false;
                    Bundle bundle = new Bundle();
                    bundle.putBundle("optBundle", com.autonavi.aps.amapapi.utils.b.a(this.f7364c));
                    bundle.putString("d", UmidtokenInfo.getUmidtoken());
                    if (!this.f7366e.v()) {
                        f(1, bundle);
                    }
                }
            } else {
                f7361L = false;
                this.H = true;
                t0();
            }
        } catch (Throwable th) {
            try {
                com.autonavi.aps.amapapi.utils.b.a(th, "ALManager", "doLBSLocation");
                try {
                    if (this.f7364c.isOnceLocation()) {
                        return;
                    }
                    v0();
                } catch (Throwable unused) {
                }
            } finally {
                try {
                    if (!this.f7364c.isOnceLocation()) {
                        v0();
                    }
                } catch (Throwable unused2) {
                }
            }
        }
    }

    private void v(AMapLocation aMapLocation, String str) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("loc", aMapLocation);
        bundle.putString("lastLocNb", str);
        g(1014, bundle, 0L);
    }

    private void v0() {
        if (this.f7364c.getLocationMode() != AMapLocationClientOption.AMapLocationMode.Device_Sensors) {
            g(1016, null, this.f7364c.getInterval() >= 1000 ? this.f7364c.getInterval() : 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w0() {
        try {
            if (this.f7377p == null) {
                this.f7377p = new Messenger(this.f7365d);
            }
            i(x0());
        } catch (Throwable unused) {
        }
    }

    private Intent x0() {
        String str;
        if (this.f7378q == null) {
            this.f7378q = new Intent(this.f7363b, APSService.class);
        }
        try {
            if (!TextUtils.isEmpty(AMapLocationClientOption.getAPIKEY())) {
                str = AMapLocationClientOption.getAPIKEY();
            } else {
                str = e4.j(this.f7363b);
            }
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "ALManager", "startServiceImpl p2");
            str = "";
        }
        this.f7378q.putExtra("a", str);
        this.f7378q.putExtra("b", e4.g(this.f7363b));
        this.f7378q.putExtra("d", UmidtokenInfo.getUmidtoken());
        return this.f7378q;
    }

    private static void y(com.autonavi.aps.amapapi.b bVar) {
        try {
            bVar.d();
            bVar.a(new AMapLocationClientOption().setNeedAddress(false));
            bVar.a(true, new com.autonavi.aps.amapapi.a());
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "ALManager", "apsLocation:doFirstNetLocate 2");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y0() {
        try {
            StringBuilder sb = new StringBuilder();
            new com.autonavi.aps.amapapi.a().f("#2001");
            sb.append("\u6a21\u7cca\u6743\u9650\u4e0b\u4e0d\u652f\u6301\u4f4e\u529f\u8017\u5b9a\u4f4d#2001");
            h.a((String) null, 2153);
            com.autonavi.aps.amapapi.model.a aVar = new com.autonavi.aps.amapapi.model.a("");
            aVar.setErrorCode(20);
            aVar.setLocationDetail(sb.toString());
            k0(aVar);
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "ALManager", "apsLocation:callback");
        }
    }

    private void z(com.autonavi.aps.amapapi.b bVar, com.autonavi.aps.amapapi.a aVar) {
        try {
            bVar.a(this.f7363b);
            bVar.a(this.f7364c);
            bVar.b(aVar);
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "ALManager", "initApsBase");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z0() {
        this.f7366e.u(this.f7364c);
        this.f7367f.q(this.f7364c);
        if (this.f7369h && !this.f7364c.getLocationMode().equals(this.f7383v)) {
            s0();
            p0();
        }
        this.f7383v = this.f7364c.getLocationMode();
        if (this.f7385x != null) {
            if (this.f7364c.isOnceLocation()) {
                this.f7385x.a(this.f7363b, 0);
            } else {
                this.f7385x.a(this.f7363b, 1);
            }
            this.f7385x.a(this.f7363b, this.f7364c);
        }
    }

    public final void B(boolean z3) {
        try {
            Bundle bundle = new Bundle();
            bundle.putBoolean("j", z3);
            g(1024, bundle, 0L);
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "ALManager", "disableBackgroundLocation");
        }
    }

    public final boolean C() {
        return this.f7368g;
    }

    public final void G() {
        f fVar;
        try {
            if (this.A.getCacheCallBack() && (fVar = this.f7365d) != null) {
                fVar.sendEmptyMessageDelayed(13, this.A.getCacheCallBackTime());
            }
        } catch (Throwable unused) {
        }
        try {
            g(1003, null, 0L);
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "ALManager", "startLocation");
        }
    }

    public final void N(AMapLocationListener aMapLocationListener) {
        try {
            g(1005, aMapLocationListener, 0L);
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "ALManager", "unRegisterLocationListener");
        }
    }

    public final void R() {
        try {
            g(1004, null, 0L);
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "ALManager", "stopLocation");
        }
    }

    public final void W() {
        try {
            s6 s6Var = this.B;
            if (s6Var != null) {
                s6Var.h();
                this.B = null;
            }
            g(1011, null, 0L);
            this.f7382u = true;
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "ALManager", "onDestroy");
        }
    }

    public final AMapLocation c0() {
        AMapLocation aMapLocation = null;
        try {
            s7 s7Var = this.f7375n;
            if (s7Var != null && (aMapLocation = s7Var.d()) != null) {
                aMapLocation.setTrustedLevel(3);
            }
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "ALManager", "getLastKnownLocation");
        }
        return aMapLocation;
    }

    public final void e(int i4, Notification notification) {
        if (i4 == 0 || notification == null) {
            return;
        }
        try {
            if (this.f7374m && this.f7376o != null) {
                Bundle bundle = new Bundle();
                bundle.putBundle("optBundle", com.autonavi.aps.amapapi.utils.b.a(this.f7364c));
                f(0, bundle);
                this.f7374m = false;
            }
            Bundle bundle2 = new Bundle();
            bundle2.putInt("i", i4);
            bundle2.putParcelable("h", notification);
            g(1023, bundle2, 0L);
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "ALManager", "disableBackgroundLocation");
        }
    }

    public final void f0() {
        try {
            s6 s6Var = this.B;
            if (s6Var != null) {
                s6Var.h();
                this.B = null;
            }
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "ALManager", "stopAssistantLocation");
        }
    }

    final void i0() {
        f(12, null);
        this.f7372k = true;
        this.f7373l = true;
        this.f7374m = true;
        this.f7368g = false;
        this.f7386y = false;
        s0();
        h hVar = this.f7385x;
        if (hVar != null) {
            hVar.b(this.f7363b);
        }
        g.a(this.f7363b).a();
        h.a(this.f7363b);
        d3 d3Var = this.f7387z;
        if (d3Var != null) {
            d3Var.s().sendEmptyMessage(11);
        } else {
            ServiceConnection serviceConnection = this.D;
            if (serviceConnection != null) {
                this.f7363b.unbindService(serviceConnection);
            }
        }
        try {
            if (this.K) {
                this.f7363b.stopService(x0());
            }
        } catch (Throwable unused) {
        }
        this.K = false;
        ArrayList<AMapLocationListener> arrayList = this.f7370i;
        if (arrayList != null) {
            arrayList.clear();
            this.f7370i = null;
        }
        this.D = null;
        l0();
        e eVar = this.f7381t;
        if (eVar != null) {
            if (Build.VERSION.SDK_INT >= 18) {
                try {
                    com.autonavi.aps.amapapi.utils.f.a(eVar, HandlerThread.class, "quitSafely", new Object[0]);
                } catch (Throwable unused2) {
                    this.f7381t.quit();
                }
            } else {
                eVar.quit();
            }
        }
        this.f7381t = null;
        f fVar = this.f7365d;
        if (fVar != null) {
            fVar.removeCallbacksAndMessages(null);
        }
        s7 s7Var = this.f7375n;
        if (s7Var != null) {
            s7Var.e();
            this.f7375n = null;
        }
    }

    public final void m(WebView webView) {
        if (this.B == null) {
            this.B = new s6(this.f7363b, webView);
        }
        this.B.c();
    }

    public final void w(AMapLocationClientOption aMapLocationClientOption) {
        try {
            this.A = aMapLocationClientOption.m16clone();
            g(1018, aMapLocationClientOption.m16clone(), 0L);
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "ALManager", "setLocationOption");
        }
    }

    public final void x(AMapLocationListener aMapLocationListener) {
        try {
            g(1002, aMapLocationListener, 0L);
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "ALManager", "setLocationListener");
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* compiled from: AmapLocationManager.java */
    /* renamed from: com.amap.api.col.3l.d2$f */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public class f extends Handler {
        public f(Looper looper) {
            super(looper);
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            f fVar;
            f fVar2;
            try {
                super.handleMessage(message);
                d2 d2Var = d2.this;
                if (d2Var.f7382u) {
                    return;
                }
                int i4 = message.what;
                if (i4 != 1) {
                    if (i4 != 2) {
                        if (i4 != 13) {
                            switch (i4) {
                                case 5:
                                    Bundle data = message.getData();
                                    data.putBundle("optBundle", com.autonavi.aps.amapapi.utils.b.a(d2.this.f7364c));
                                    d2.this.f(10, data);
                                    return;
                                case 6:
                                    Bundle data2 = message.getData();
                                    t5 t5Var = d2.this.f7366e;
                                    if (t5Var != null) {
                                        t5Var.h(data2);
                                        return;
                                    }
                                    return;
                                case 7:
                                    d2.this.f7380s = message.getData().getBoolean("ngpsAble");
                                    return;
                                case 8:
                                    h.a((String) null, 2141);
                                    break;
                                case 9:
                                    boolean unused = d2.N = message.getData().getBoolean("installMockApp");
                                    return;
                                case 10:
                                    d2Var.t((AMapLocation) message.obj);
                                    return;
                                default:
                                    switch (i4) {
                                        case 100:
                                            h.a((String) null, 2155);
                                            break;
                                        case 101:
                                            break;
                                        case 102:
                                            Bundle data3 = message.getData();
                                            data3.putBundle("optBundle", com.autonavi.aps.amapapi.utils.b.a(d2.this.f7364c));
                                            d2.this.f(15, data3);
                                            return;
                                        case 103:
                                            Bundle data4 = message.getData();
                                            if (d2.this.f7367f != null) {
                                                d2.this.f7367f.f(data4);
                                                return;
                                            }
                                            return;
                                        default:
                                            return;
                                    }
                                    Message obtain = Message.obtain();
                                    obtain.what = 1028;
                                    obtain.obj = message.obj;
                                    d2.this.I.sendMessage(obtain);
                                    if (d2.this.A == null || !d2.this.A.getCacheCallBack() || (fVar2 = d2.this.f7365d) == null) {
                                        return;
                                    }
                                    fVar2.removeMessages(13);
                                    return;
                            }
                        } else {
                            com.autonavi.aps.amapapi.model.a aVar = d2Var.f7362a;
                            if (aVar != null) {
                                d2Var.t(aVar);
                                return;
                            }
                            AMapLocation aMapLocation = new AMapLocation("LBS");
                            aMapLocation.setErrorCode(33);
                            d2.this.t(aMapLocation);
                            return;
                        }
                    }
                    Message obtain2 = Message.obtain();
                    obtain2.what = 12;
                    obtain2.obj = message.obj;
                    d2.this.I.sendMessage(obtain2);
                    if (d2.this.A == null || !d2.this.A.getCacheCallBack() || (fVar = d2.this.f7365d) == null) {
                        return;
                    }
                    fVar.removeMessages(13);
                    return;
                }
                Message obtainMessage = d2Var.I.obtainMessage();
                obtainMessage.what = 11;
                obtainMessage.setData(message.getData());
                d2.this.I.sendMessage(obtainMessage);
            } catch (Throwable th) {
                com.autonavi.aps.amapapi.utils.b.a(th, "AmapLocationManager$MainHandler", 0 == 0 ? "handleMessage" : null);
            }
        }

        public f() {
        }
    }
}

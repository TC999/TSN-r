package com.amap.api.col.p0003l;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Process;
import android.text.TextUtils;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import com.autonavi.aps.amapapi.utils.d;
import com.autonavi.aps.amapapi.utils.f;
import com.autonavi.aps.amapapi.utils.h;
import com.autonavi.aps.amapapi.utils.j;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: ApsManager.java */
/* renamed from: com.amap.api.col.3l.d3  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class d3 {
    static boolean A;

    /* renamed from: l  reason: collision with root package name */
    Context f7405l;

    /* renamed from: s  reason: collision with root package name */
    private List<Messenger> f7412s;

    /* renamed from: a  reason: collision with root package name */
    private boolean f7394a = false;

    /* renamed from: b  reason: collision with root package name */
    private boolean f7395b = false;

    /* renamed from: c  reason: collision with root package name */
    String f7396c = null;

    /* renamed from: d  reason: collision with root package name */
    b f7397d = null;

    /* renamed from: e  reason: collision with root package name */
    private long f7398e = 0;

    /* renamed from: f  reason: collision with root package name */
    private long f7399f = 0;

    /* renamed from: g  reason: collision with root package name */
    private com.autonavi.aps.amapapi.model.a f7400g = null;

    /* renamed from: h  reason: collision with root package name */
    AMapLocation f7401h = null;

    /* renamed from: i  reason: collision with root package name */
    private long f7402i = 0;

    /* renamed from: j  reason: collision with root package name */
    private int f7403j = 0;

    /* renamed from: k  reason: collision with root package name */
    a f7404k = null;

    /* renamed from: m  reason: collision with root package name */
    private s7 f7406m = null;

    /* renamed from: n  reason: collision with root package name */
    com.autonavi.aps.amapapi.b f7407n = null;

    /* renamed from: o  reason: collision with root package name */
    HashMap<Messenger, Long> f7408o = new HashMap<>();

    /* renamed from: p  reason: collision with root package name */
    h f7409p = null;

    /* renamed from: q  reason: collision with root package name */
    long f7410q = 0;

    /* renamed from: r  reason: collision with root package name */
    long f7411r = 0;

    /* renamed from: t  reason: collision with root package name */
    private long f7413t = 0;

    /* renamed from: u  reason: collision with root package name */
    private HashMap<String, Boolean> f7414u = new HashMap<>();

    /* renamed from: v  reason: collision with root package name */
    String f7415v = null;

    /* renamed from: w  reason: collision with root package name */
    private boolean f7416w = true;

    /* renamed from: x  reason: collision with root package name */
    private String f7417x = "";

    /* renamed from: y  reason: collision with root package name */
    AMapLocationClientOption f7418y = null;

    /* renamed from: z  reason: collision with root package name */
    AMapLocationClientOption f7419z = new AMapLocationClientOption();

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* compiled from: ApsManager.java */
    /* renamed from: com.amap.api.col.3l.d3$a */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        /* JADX WARN: Removed duplicated region for block: B:23:0x005c  */
        /* JADX WARN: Removed duplicated region for block: B:62:0x014e A[Catch: all -> 0x015c, TryCatch #2 {all -> 0x015c, blocks: (B:21:0x0058, B:28:0x0067, B:30:0x006d, B:32:0x0085, B:34:0x008b, B:35:0x00a1, B:36:0x00af, B:38:0x00b3, B:40:0x00bb, B:42:0x00c7, B:43:0x00d0, B:45:0x00d8, B:47:0x00e4, B:48:0x00ec, B:50:0x00f0, B:52:0x00f8, B:54:0x0104, B:56:0x0119, B:57:0x011f, B:58:0x0125, B:59:0x012b, B:60:0x0138, B:63:0x0158, B:61:0x0143, B:62:0x014e, B:20:0x0051), top: B:72:0x0051 }] */
        @Override // android.os.Handler
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void handleMessage(android.os.Message r9) {
            /*
                Method dump skipped, instructions count: 380
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003l.d3.a.handleMessage(android.os.Message):void");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* compiled from: ApsManager.java */
    /* renamed from: com.amap.api.col.3l.d3$b */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public class b extends HandlerThread {
        public b(String str) {
            super(str);
        }

        @Override // android.os.HandlerThread
        protected final void onLooperPrepared() {
            try {
                d3.this.f7406m = new s7(d3.this.f7405l);
                com.autonavi.aps.amapapi.utils.a.b(d3.this.f7405l);
                com.autonavi.aps.amapapi.utils.a.a(d3.this.f7405l);
                d3.this.f7407n = new com.autonavi.aps.amapapi.b(false);
                super.onLooperPrepared();
            }
        }

        @Override // android.os.HandlerThread, java.lang.Thread, java.lang.Runnable
        public final void run() {
            try {
                super.run();
            } catch (Throwable th) {
                com.autonavi.aps.amapapi.utils.b.a(th, "APSManager$ActionThread", "run");
            }
        }
    }

    public d3(Context context) {
        this.f7405l = null;
        this.f7405l = context;
    }

    public static void E() {
        A = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F() {
        if (j.m(this.f7405l)) {
            d.a();
            return;
        }
        try {
            com.autonavi.aps.amapapi.b bVar = this.f7407n;
            if (bVar == null || bVar == null) {
                return;
            }
            bVar.a(this.f7404k);
            this.f7407n.g();
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "ApsServiceCore", "startColl");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G() {
        try {
            com.autonavi.aps.amapapi.utils.a.c(this.f7405l);
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "ApsServiceCore", "doCallOtherSer");
        }
    }

    private static com.autonavi.aps.amapapi.model.a b(int i4, String str) {
        try {
            com.autonavi.aps.amapapi.model.a aVar = new com.autonavi.aps.amapapi.model.a("");
            aVar.setErrorCode(i4);
            aVar.setLocationDetail(str);
            return aVar;
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "ApsServiceCore", "newInstanceAMapLoc");
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(Bundle bundle) {
        try {
            if (this.f7394a) {
                com.autonavi.aps.amapapi.b bVar = this.f7407n;
                if (bVar != null) {
                    bVar.a();
                    return;
                }
                return;
            }
            com.autonavi.aps.amapapi.utils.b.a(this.f7405l);
            if (bundle != null) {
                this.f7419z = com.autonavi.aps.amapapi.utils.b.a(bundle.getBundle("optBundle"));
            }
            this.f7407n.a(this.f7405l);
            this.f7407n.b();
            q(this.f7419z);
            this.f7407n.c();
            this.f7394a = true;
            this.f7416w = true;
            this.f7417x = "";
            List<Messenger> list = this.f7412s;
            if (list == null || list.size() <= 0) {
                return;
            }
            F();
        } catch (Throwable th) {
            this.f7416w = false;
            th.printStackTrace();
            this.f7417x = th.getMessage();
            com.autonavi.aps.amapapi.utils.b.a(th, "ApsServiceCore", "init");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(Messenger messenger) {
        this.f7408o.remove(messenger);
    }

    private static void g(Messenger messenger, int i4, Bundle bundle) {
        if (messenger != null) {
            try {
                Message obtain = Message.obtain();
                obtain.setData(bundle);
                obtain.what = i4;
                messenger.send(obtain);
            } catch (Throwable th) {
                com.autonavi.aps.amapapi.utils.b.a(th, "ApsServiceCore", "sendMessage");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(Messenger messenger, Bundle bundle) {
        if (bundle != null) {
            try {
                if (bundle.isEmpty() || this.f7395b) {
                    return;
                }
                this.f7395b = true;
                x(messenger);
            } catch (Throwable th) {
                com.autonavi.aps.amapapi.utils.b.a(th, "ApsServiceCore", "doInitAuth");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(Messenger messenger, AMapLocation aMapLocation, String str, com.autonavi.aps.amapapi.a aVar) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(AMapLocation.class.getClassLoader());
        bundle.putParcelable("loc", aMapLocation);
        bundle.putString("nb", str);
        bundle.putParcelable("statics", aVar);
        this.f7408o.put(messenger, Long.valueOf(j.b()));
        g(messenger, 1, bundle);
    }

    private void k(Messenger messenger, String str) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(AMapLocation.class.getClassLoader());
        bundle.putInt("I_MAX_GEO_DIS", com.autonavi.aps.amapapi.utils.a.i() * 3);
        bundle.putInt("I_MIN_GEO_DIS", com.autonavi.aps.amapapi.utils.a.i());
        bundle.putParcelable("loc", this.f7401h);
        if ("COARSE_LOC".equals(str)) {
            g(messenger, 103, bundle);
        } else {
            g(messenger, 6, bundle);
        }
    }

    private void q(AMapLocationClientOption aMapLocationClientOption) {
        try {
            com.autonavi.aps.amapapi.b bVar = this.f7407n;
            if (bVar != null) {
                bVar.a(aMapLocationClientOption);
            }
            if (aMapLocationClientOption != null) {
                A = aMapLocationClientOption.isKillProcess();
                if (this.f7418y != null) {
                    if (aMapLocationClientOption.isOffset() != this.f7418y.isOffset() || aMapLocationClientOption.isNeedAddress() != this.f7418y.isNeedAddress() || aMapLocationClientOption.isLocationCacheEnable() != this.f7418y.isLocationCacheEnable() || this.f7418y.getGeoLanguage() != aMapLocationClientOption.getGeoLanguage()) {
                        this.f7399f = 0L;
                    }
                    if (aMapLocationClientOption.isOffset() != this.f7418y.isOffset() || this.f7418y.getGeoLanguage() != aMapLocationClientOption.getGeoLanguage()) {
                        this.f7401h = null;
                    }
                }
                this.f7418y = aMapLocationClientOption;
            }
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "ApsServiceCore", "setExtra");
        }
    }

    private static AMapLocationClientOption t(Bundle bundle) {
        AMapLocationClientOption aMapLocationClientOption = null;
        try {
            aMapLocationClientOption = com.autonavi.aps.amapapi.utils.b.a(bundle.getBundle("optBundle"));
            String string = bundle.getString("d");
            if (!TextUtils.isEmpty(string)) {
                i4.s(string);
            }
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "APSManager", "parseBundle");
        }
        return aMapLocationClientOption;
    }

    static /* synthetic */ com.autonavi.aps.amapapi.model.a u(String str) {
        return b(10, str);
    }

    private void x(Messenger messenger) {
        try {
            this.f7407n.f();
            if (com.autonavi.aps.amapapi.utils.a.l()) {
                Bundle bundle = new Bundle();
                bundle.putBoolean("installMockApp", true);
                g(messenger, 9, bundle);
            }
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "ApsServiceCore", "initAuth");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0127 A[Catch: all -> 0x016d, TryCatch #2 {all -> 0x016d, blocks: (B:4:0x0008, B:7:0x0010, B:9:0x0029, B:11:0x002f, B:14:0x0047, B:16:0x004c, B:18:0x0079, B:20:0x0086, B:22:0x008f, B:24:0x00a0, B:43:0x011f, B:45:0x0127, B:46:0x012d, B:48:0x0131, B:49:0x013c, B:51:0x0140, B:62:0x0169, B:54:0x014f, B:56:0x0155, B:58:0x0159, B:26:0x00a9, B:28:0x00b9, B:31:0x00c3, B:33:0x00cb, B:38:0x00eb, B:34:0x00d3, B:36:0x00dc, B:37:0x00e4), top: B:67:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0131 A[Catch: all -> 0x016d, TryCatch #2 {all -> 0x016d, blocks: (B:4:0x0008, B:7:0x0010, B:9:0x0029, B:11:0x002f, B:14:0x0047, B:16:0x004c, B:18:0x0079, B:20:0x0086, B:22:0x008f, B:24:0x00a0, B:43:0x011f, B:45:0x0127, B:46:0x012d, B:48:0x0131, B:49:0x013c, B:51:0x0140, B:62:0x0169, B:54:0x014f, B:56:0x0155, B:58:0x0159, B:26:0x00a9, B:28:0x00b9, B:31:0x00c3, B:33:0x00cb, B:38:0x00eb, B:34:0x00d3, B:36:0x00dc, B:37:0x00e4), top: B:67:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0140 A[Catch: all -> 0x016d, TRY_LEAVE, TryCatch #2 {all -> 0x016d, blocks: (B:4:0x0008, B:7:0x0010, B:9:0x0029, B:11:0x002f, B:14:0x0047, B:16:0x004c, B:18:0x0079, B:20:0x0086, B:22:0x008f, B:24:0x00a0, B:43:0x011f, B:45:0x0127, B:46:0x012d, B:48:0x0131, B:49:0x013c, B:51:0x0140, B:62:0x0169, B:54:0x014f, B:56:0x0155, B:58:0x0159, B:26:0x00a9, B:28:0x00b9, B:31:0x00c3, B:33:0x00cb, B:38:0x00eb, B:34:0x00d3, B:36:0x00dc, B:37:0x00e4), top: B:67:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x014e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void y(android.os.Messenger r12, android.os.Bundle r13) {
        /*
            Method dump skipped, instructions count: 372
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003l.d3.y(android.os.Messenger, android.os.Bundle):void");
    }

    public final void B() {
        HashMap<String, Boolean> hashMap;
        if (this.f7407n == null || (hashMap = this.f7414u) == null || hashMap.isEmpty()) {
            return;
        }
        for (Boolean bool : this.f7414u.values()) {
            if (bool.booleanValue()) {
                this.f7407n.a(true);
                return;
            }
        }
        this.f7407n.a(false);
    }

    public final void C() {
        try {
            HashMap<Messenger, Long> hashMap = this.f7408o;
            if (hashMap != null) {
                hashMap.clear();
                this.f7408o = null;
            }
            List<Messenger> list = this.f7412s;
            if (list != null) {
                list.clear();
            }
            s7 s7Var = this.f7406m;
            if (s7Var != null) {
                s7Var.e();
                this.f7406m = null;
            }
            this.f7394a = false;
            this.f7395b = false;
            this.f7407n.e();
            a aVar = this.f7404k;
            if (aVar != null) {
                aVar.removeCallbacksAndMessages(null);
            }
            this.f7404k = null;
            b bVar = this.f7397d;
            if (bVar != null) {
                if (Build.VERSION.SDK_INT >= 18) {
                    f.a(bVar, HandlerThread.class, "quitSafely", new Object[0]);
                } else {
                    bVar.quit();
                }
            }
            this.f7397d = null;
            if (this.f7409p != null && this.f7410q != 0 && this.f7411r != 0) {
                long b4 = j.b() - this.f7410q;
                h.a(this.f7405l, this.f7409p.c(this.f7405l), this.f7409p.d(this.f7405l), this.f7411r, b4);
                this.f7409p.e(this.f7405l);
            }
            HashMap<String, Boolean> hashMap2 = this.f7414u;
            if (hashMap2 != null) {
                hashMap2.clear();
                this.f7414u = null;
            }
            h.a(this.f7405l);
            u5.m();
            if (A) {
                Process.killProcess(Process.myPid());
            }
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "apm", "tdest");
        }
    }

    public final void c() {
        try {
            this.f7409p = new h();
            b bVar = new b("amapLocCoreThread");
            this.f7397d = bVar;
            bVar.setPriority(5);
            this.f7397d.start();
            this.f7404k = new a(this.f7397d.getLooper());
            this.f7412s = new ArrayList();
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "ApsServiceCore", "onCreate");
        }
    }

    public final void d(Intent intent) {
        a aVar;
        if (!"true".equals(intent.getStringExtra("as")) || (aVar = this.f7404k) == null) {
            return;
        }
        aVar.sendEmptyMessageDelayed(9, 100L);
    }

    final void i(Messenger messenger, Bundle bundle, String str) {
        AMapLocationClientOption t3;
        float f4;
        if (bundle != null) {
            try {
                if (bundle.isEmpty()) {
                    return;
                }
                double d4 = bundle.getDouble("lat");
                double d5 = bundle.getDouble("lon");
                float f5 = bundle.getFloat("radius");
                long j4 = bundle.getLong("time");
                if ("FINE_LOC".equals(str)) {
                    AMapLocation aMapLocation = new AMapLocation("gps");
                    aMapLocation.setLatitude(d4);
                    aMapLocation.setLocationType(1);
                    aMapLocation.setLongitude(d5);
                    aMapLocation.setAccuracy(f5);
                    aMapLocation.setTime(j4);
                    this.f7407n.a(aMapLocation);
                }
                if (com.autonavi.aps.amapapi.utils.a.h() && (t3 = t(bundle)) != null && t3.isNeedAddress()) {
                    q(t3);
                    AMapLocation aMapLocation2 = this.f7401h;
                    if (aMapLocation2 != null) {
                        f4 = j.a(new double[]{d4, d5, aMapLocation2.getLatitude(), this.f7401h.getLongitude()});
                        if (f4 < com.autonavi.aps.amapapi.utils.a.i() * 3) {
                            k(messenger, str);
                        }
                    } else {
                        f4 = -1.0f;
                    }
                    if (f4 == -1.0f || (f4 > com.autonavi.aps.amapapi.utils.a.i() && j.b() - this.f7413t > com.autonavi.aps.amapapi.utils.a.j() * 1000)) {
                        e(bundle);
                        this.f7401h = this.f7407n.a(d4, d5);
                        this.f7413t = j.b();
                        AMapLocation aMapLocation3 = this.f7401h;
                        if (aMapLocation3 == null || TextUtils.isEmpty(aMapLocation3.getAdCode())) {
                            return;
                        }
                        k(messenger, str);
                    }
                }
            } catch (Throwable th) {
                com.autonavi.aps.amapapi.utils.b.a(th, "ApsServiceCore", "doLocationGeo");
            }
        }
    }

    public final boolean r(String str) {
        if (TextUtils.isEmpty(this.f7415v)) {
            this.f7415v = com.autonavi.aps.amapapi.utils.b.b(this.f7405l);
        }
        return !TextUtils.isEmpty(str) && str.equals(this.f7415v);
    }

    public final Handler s() {
        return this.f7404k;
    }

    public final void w(Intent intent) {
        String stringExtra = intent.getStringExtra("a");
        if (!TextUtils.isEmpty(stringExtra)) {
            g4.l(this.f7405l, stringExtra);
        }
        String stringExtra2 = intent.getStringExtra("b");
        this.f7396c = stringExtra2;
        e4.c(stringExtra2);
        String stringExtra3 = intent.getStringExtra("d");
        if (TextUtils.isEmpty(stringExtra3)) {
            return;
        }
        i4.s(stringExtra3);
    }
}

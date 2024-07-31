package com.amap.api.col.p0463l;

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
import com.amap.api.services.geocoder.GeocodeSearch;
import com.autonavi.aps.amapapi.AMapLocationStaticsEntity;
import com.autonavi.aps.amapapi.Aps;
import com.autonavi.aps.amapapi.model.AMapLocationServer;
import com.autonavi.aps.amapapi.utils.AuthUtil;
import com.autonavi.aps.amapapi.utils.C2428b;
import com.autonavi.aps.amapapi.utils.C2432j;
import com.autonavi.aps.amapapi.utils.DebugUtils;
import com.autonavi.aps.amapapi.utils.Reflect;
import com.autonavi.aps.amapapi.utils.ReportUtil;
import com.umeng.analytics.pro.UContent;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* renamed from: com.amap.api.col.3l.d3 */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class ApsManager {

    /* renamed from: A */
    static boolean f3838A;

    /* renamed from: l */
    Context f3850l;

    /* renamed from: s */
    private List<Messenger> f3857s;

    /* renamed from: a */
    private boolean f3839a = false;

    /* renamed from: b */
    private boolean f3840b = false;

    /* renamed from: c */
    String f3841c = null;

    /* renamed from: d */
    HandlerThreadC1769b f3842d = null;

    /* renamed from: e */
    private long f3843e = 0;

    /* renamed from: f */
    private long f3844f = 0;

    /* renamed from: g */
    private AMapLocationServer f3845g = null;

    /* renamed from: h */
    AMapLocation f3846h = null;

    /* renamed from: i */
    private long f3847i = 0;

    /* renamed from: j */
    private int f3848j = 0;

    /* renamed from: k */
    HandlerC1768a f3849k = null;

    /* renamed from: m */
    private LastLocationManager f3851m = null;

    /* renamed from: n */
    Aps f3852n = null;

    /* renamed from: o */
    HashMap<Messenger, Long> f3853o = new HashMap<>();

    /* renamed from: p */
    ReportUtil f3854p = null;

    /* renamed from: q */
    long f3855q = 0;

    /* renamed from: r */
    long f3856r = 0;

    /* renamed from: t */
    private long f3858t = 0;

    /* renamed from: u */
    private HashMap<String, Boolean> f3859u = new HashMap<>();

    /* renamed from: v */
    String f3860v = null;

    /* renamed from: w */
    private boolean f3861w = true;

    /* renamed from: x */
    private String f3862x = "";

    /* renamed from: y */
    AMapLocationClientOption f3863y = null;

    /* renamed from: z */
    AMapLocationClientOption f3864z = new AMapLocationClientOption();

    /* compiled from: ApsManager.java */
    /* renamed from: com.amap.api.col.3l.d3$a */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public class HandlerC1768a extends Handler {
        public HandlerC1768a(Looper looper) {
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
            throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0463l.ApsManager.HandlerC1768a.handleMessage(android.os.Message):void");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ApsManager.java */
    /* renamed from: com.amap.api.col.3l.d3$b */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public class HandlerThreadC1769b extends HandlerThread {
        public HandlerThreadC1769b(String str) {
            super(str);
        }

        @Override // android.os.HandlerThread
        protected final void onLooperPrepared() {
            try {
                ApsManager.this.f3851m = new LastLocationManager(ApsManager.this.f3850l);
                AuthUtil.m51340b(ApsManager.this.f3850l);
                AuthUtil.m51347a(ApsManager.this.f3850l);
                ApsManager.this.f3852n = new Aps(false);
                super.onLooperPrepared();
            }
        }

        @Override // android.os.HandlerThread, java.lang.Thread, java.lang.Runnable
        public final void run() {
            try {
                super.run();
            } catch (Throwable th) {
                C2428b.m51299a(th, "APSManager$ActionThread", "run");
            }
        }
    }

    public ApsManager(Context context) {
        this.f3850l = null;
        this.f3850l = context;
    }

    /* renamed from: E */
    public static void m55328E() {
        f3838A = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: F */
    public void m55327F() {
        if (C2432j.m51154m(this.f3850l)) {
            DebugUtils.m51285a();
            return;
        }
        try {
            Aps aps = this.f3852n;
            if (aps == null || aps == null) {
                return;
            }
            aps.m51712a(this.f3849k);
            this.f3852n.m51689g();
        } catch (Throwable th) {
            C2428b.m51299a(th, "ApsServiceCore", "startColl");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: G */
    public void m55326G() {
        try {
            AuthUtil.m51337c(this.f3850l);
        } catch (Throwable th) {
            C2428b.m51299a(th, "ApsServiceCore", "doCallOtherSer");
        }
    }

    /* renamed from: b */
    private static AMapLocationServer m55324b(int i, String str) {
        try {
            AMapLocationServer aMapLocationServer = new AMapLocationServer("");
            aMapLocationServer.setErrorCode(i);
            aMapLocationServer.setLocationDetail(str);
            return aMapLocationServer;
        } catch (Throwable th) {
            C2428b.m51299a(th, "ApsServiceCore", "newInstanceAMapLoc");
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m55321e(Bundle bundle) {
        try {
            if (this.f3839a) {
                Aps aps = this.f3852n;
                if (aps != null) {
                    aps.m51717a();
                    return;
                }
                return;
            }
            C2428b.m51306a(this.f3850l);
            if (bundle != null) {
                this.f3864z = C2428b.m51305a(bundle.getBundle("optBundle"));
            }
            this.f3852n.m51713a(this.f3850l);
            this.f3852n.m51702b();
            m55309q(this.f3864z);
            this.f3852n.m51696c();
            this.f3839a = true;
            this.f3861w = true;
            this.f3862x = "";
            List<Messenger> list = this.f3857s;
            if (list == null || list.size() <= 0) {
                return;
            }
            m55327F();
        } catch (Throwable th) {
            this.f3861w = false;
            th.printStackTrace();
            this.f3862x = th.getMessage();
            C2428b.m51299a(th, "ApsServiceCore", "init");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public void m55320f(Messenger messenger) {
        this.f3853o.remove(messenger);
    }

    /* renamed from: g */
    private static void m55319g(Messenger messenger, int i, Bundle bundle) {
        if (messenger != null) {
            try {
                Message obtain = Message.obtain();
                obtain.setData(bundle);
                obtain.what = i;
                messenger.send(obtain);
            } catch (Throwable th) {
                C2428b.m51299a(th, "ApsServiceCore", "sendMessage");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public void m55318h(Messenger messenger, Bundle bundle) {
        if (bundle != null) {
            try {
                if (bundle.isEmpty() || this.f3840b) {
                    return;
                }
                this.f3840b = true;
                m55302x(messenger);
            } catch (Throwable th) {
                C2428b.m51299a(th, "ApsServiceCore", "doInitAuth");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public void m55316j(Messenger messenger, AMapLocation aMapLocation, String str, AMapLocationStaticsEntity aMapLocationStaticsEntity) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(AMapLocation.class.getClassLoader());
        bundle.putParcelable("loc", aMapLocation);
        bundle.putString("nb", str);
        bundle.putParcelable("statics", aMapLocationStaticsEntity);
        this.f3853o.put(messenger, Long.valueOf(C2432j.m51186b()));
        m55319g(messenger, 1, bundle);
    }

    /* renamed from: k */
    private void m55315k(Messenger messenger, String str) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(AMapLocation.class.getClassLoader());
        bundle.putInt("I_MAX_GEO_DIS", AuthUtil.m51325i() * 3);
        bundle.putInt("I_MIN_GEO_DIS", AuthUtil.m51325i());
        bundle.putParcelable("loc", this.f3846h);
        if ("COARSE_LOC".equals(str)) {
            m55319g(messenger, 103, bundle);
        } else {
            m55319g(messenger, 6, bundle);
        }
    }

    /* renamed from: q */
    private void m55309q(AMapLocationClientOption aMapLocationClientOption) {
        try {
            Aps aps = this.f3852n;
            if (aps != null) {
                aps.m51710a(aMapLocationClientOption);
            }
            if (aMapLocationClientOption != null) {
                f3838A = aMapLocationClientOption.isKillProcess();
                if (this.f3863y != null) {
                    if (aMapLocationClientOption.isOffset() != this.f3863y.isOffset() || aMapLocationClientOption.isNeedAddress() != this.f3863y.isNeedAddress() || aMapLocationClientOption.isLocationCacheEnable() != this.f3863y.isLocationCacheEnable() || this.f3863y.getGeoLanguage() != aMapLocationClientOption.getGeoLanguage()) {
                        this.f3844f = 0L;
                    }
                    if (aMapLocationClientOption.isOffset() != this.f3863y.isOffset() || this.f3863y.getGeoLanguage() != aMapLocationClientOption.getGeoLanguage()) {
                        this.f3846h = null;
                    }
                }
                this.f3863y = aMapLocationClientOption;
            }
        } catch (Throwable th) {
            C2428b.m51299a(th, "ApsServiceCore", "setExtra");
        }
    }

    /* renamed from: t */
    private static AMapLocationClientOption m55306t(Bundle bundle) {
        AMapLocationClientOption aMapLocationClientOption = null;
        try {
            aMapLocationClientOption = C2428b.m51305a(bundle.getBundle("optBundle"));
            String string = bundle.getString("d");
            if (!TextUtils.isEmpty(string)) {
                DeviceInfo.m54765s(string);
            }
        } catch (Throwable th) {
            C2428b.m51299a(th, "APSManager", "parseBundle");
        }
        return aMapLocationClientOption;
    }

    /* renamed from: u */
    static /* synthetic */ AMapLocationServer m55305u(String str) {
        return m55324b(10, str);
    }

    /* renamed from: x */
    private void m55302x(Messenger messenger) {
        try {
            this.f3852n.m51690f();
            if (AuthUtil.m51321l()) {
                Bundle bundle = new Bundle();
                bundle.putBoolean("installMockApp", true);
                m55319g(messenger, 9, bundle);
            }
        } catch (Throwable th) {
            C2428b.m51299a(th, "ApsServiceCore", "initAuth");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0127 A[Catch: all -> 0x016d, TryCatch #2 {all -> 0x016d, blocks: (B:4:0x0008, B:7:0x0010, B:9:0x0029, B:11:0x002f, B:14:0x0047, B:16:0x004c, B:18:0x0079, B:20:0x0086, B:22:0x008f, B:24:0x00a0, B:43:0x011f, B:45:0x0127, B:46:0x012d, B:48:0x0131, B:49:0x013c, B:51:0x0140, B:62:0x0169, B:54:0x014f, B:56:0x0155, B:58:0x0159, B:26:0x00a9, B:28:0x00b9, B:31:0x00c3, B:33:0x00cb, B:38:0x00eb, B:34:0x00d3, B:36:0x00dc, B:37:0x00e4), top: B:67:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0131 A[Catch: all -> 0x016d, TryCatch #2 {all -> 0x016d, blocks: (B:4:0x0008, B:7:0x0010, B:9:0x0029, B:11:0x002f, B:14:0x0047, B:16:0x004c, B:18:0x0079, B:20:0x0086, B:22:0x008f, B:24:0x00a0, B:43:0x011f, B:45:0x0127, B:46:0x012d, B:48:0x0131, B:49:0x013c, B:51:0x0140, B:62:0x0169, B:54:0x014f, B:56:0x0155, B:58:0x0159, B:26:0x00a9, B:28:0x00b9, B:31:0x00c3, B:33:0x00cb, B:38:0x00eb, B:34:0x00d3, B:36:0x00dc, B:37:0x00e4), top: B:67:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0140 A[Catch: all -> 0x016d, TRY_LEAVE, TryCatch #2 {all -> 0x016d, blocks: (B:4:0x0008, B:7:0x0010, B:9:0x0029, B:11:0x002f, B:14:0x0047, B:16:0x004c, B:18:0x0079, B:20:0x0086, B:22:0x008f, B:24:0x00a0, B:43:0x011f, B:45:0x0127, B:46:0x012d, B:48:0x0131, B:49:0x013c, B:51:0x0140, B:62:0x0169, B:54:0x014f, B:56:0x0155, B:58:0x0159, B:26:0x00a9, B:28:0x00b9, B:31:0x00c3, B:33:0x00cb, B:38:0x00eb, B:34:0x00d3, B:36:0x00dc, B:37:0x00e4), top: B:67:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x014e  */
    /* renamed from: y */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m55301y(android.os.Messenger r12, android.os.Bundle r13) {
        /*
            Method dump skipped, instructions count: 372
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0463l.ApsManager.m55301y(android.os.Messenger, android.os.Bundle):void");
    }

    /* renamed from: B */
    public final void m55331B() {
        HashMap<String, Boolean> hashMap;
        if (this.f3852n == null || (hashMap = this.f3859u) == null || hashMap.isEmpty()) {
            return;
        }
        for (Boolean bool : this.f3859u.values()) {
            if (bool.booleanValue()) {
                this.f3852n.m51704a(true);
                return;
            }
        }
        this.f3852n.m51704a(false);
    }

    /* renamed from: C */
    public final void m55330C() {
        try {
            HashMap<Messenger, Long> hashMap = this.f3853o;
            if (hashMap != null) {
                hashMap.clear();
                this.f3853o = null;
            }
            List<Messenger> list = this.f3857s;
            if (list != null) {
                list.clear();
            }
            LastLocationManager lastLocationManager = this.f3851m;
            if (lastLocationManager != null) {
                lastLocationManager.m54030e();
                this.f3851m = null;
            }
            this.f3839a = false;
            this.f3840b = false;
            this.f3852n.m51691e();
            HandlerC1768a handlerC1768a = this.f3849k;
            if (handlerC1768a != null) {
                handlerC1768a.removeCallbacksAndMessages(null);
            }
            this.f3849k = null;
            HandlerThreadC1769b handlerThreadC1769b = this.f3842d;
            if (handlerThreadC1769b != null) {
                if (Build.VERSION.SDK_INT >= 18) {
                    Reflect.m51262a(handlerThreadC1769b, HandlerThread.class, "quitSafely", new Object[0]);
                } else {
                    handlerThreadC1769b.quit();
                }
            }
            this.f3842d = null;
            if (this.f3854p != null && this.f3855q != 0 && this.f3856r != 0) {
                long m51186b = C2432j.m51186b() - this.f3855q;
                ReportUtil.m51245a(this.f3850l, this.f3854p.m51227c(this.f3850l), this.f3854p.m51226d(this.f3850l), this.f3856r, m51186b);
                this.f3854p.m51225e(this.f3850l);
            }
            HashMap<String, Boolean> hashMap2 = this.f3859u;
            if (hashMap2 != null) {
                hashMap2.clear();
                this.f3859u = null;
            }
            ReportUtil.m51247a(this.f3850l);
            SDKLogHandler.m53866m();
            if (f3838A) {
                Process.killProcess(Process.myPid());
            }
        } catch (Throwable th) {
            C2428b.m51299a(th, "apm", "tdest");
        }
    }

    /* renamed from: c */
    public final void m55323c() {
        try {
            this.f3854p = new ReportUtil();
            HandlerThreadC1769b handlerThreadC1769b = new HandlerThreadC1769b("amapLocCoreThread");
            this.f3842d = handlerThreadC1769b;
            handlerThreadC1769b.setPriority(5);
            this.f3842d.start();
            this.f3849k = new HandlerC1768a(this.f3842d.getLooper());
            this.f3857s = new ArrayList();
        } catch (Throwable th) {
            C2428b.m51299a(th, "ApsServiceCore", "onCreate");
        }
    }

    /* renamed from: d */
    public final void m55322d(Intent intent) {
        HandlerC1768a handlerC1768a;
        if (!"true".equals(intent.getStringExtra(CommonNetImpl.f39530AS)) || (handlerC1768a = this.f3849k) == null) {
            return;
        }
        handlerC1768a.sendEmptyMessageDelayed(9, 100L);
    }

    /* renamed from: i */
    final void m55317i(Messenger messenger, Bundle bundle, String str) {
        AMapLocationClientOption m55306t;
        float f;
        if (bundle != null) {
            try {
                if (bundle.isEmpty()) {
                    return;
                }
                double d = bundle.getDouble(UContent.f38072C);
                double d2 = bundle.getDouble("lon");
                float f2 = bundle.getFloat("radius");
                long j = bundle.getLong(RtspHeaders.Values.TIME);
                if ("FINE_LOC".equals(str)) {
                    AMapLocation aMapLocation = new AMapLocation(GeocodeSearch.GPS);
                    aMapLocation.setLatitude(d);
                    aMapLocation.setLocationType(1);
                    aMapLocation.setLongitude(d2);
                    aMapLocation.setAccuracy(f2);
                    aMapLocation.setTime(j);
                    this.f3852n.m51711a(aMapLocation);
                }
                if (AuthUtil.m51327h() && (m55306t = m55306t(bundle)) != null && m55306t.isNeedAddress()) {
                    m55309q(m55306t);
                    AMapLocation aMapLocation2 = this.f3846h;
                    if (aMapLocation2 != null) {
                        f = C2432j.m51187a(new double[]{d, d2, aMapLocation2.getLatitude(), this.f3846h.getLongitude()});
                        if (f < AuthUtil.m51325i() * 3) {
                            m55315k(messenger, str);
                        }
                    } else {
                        f = -1.0f;
                    }
                    if (f == -1.0f || (f > AuthUtil.m51325i() && C2432j.m51186b() - this.f3858t > AuthUtil.m51323j() * 1000)) {
                        m55321e(bundle);
                        this.f3846h = this.f3852n.m51716a(d, d2);
                        this.f3858t = C2432j.m51186b();
                        AMapLocation aMapLocation3 = this.f3846h;
                        if (aMapLocation3 == null || TextUtils.isEmpty(aMapLocation3.getAdCode())) {
                            return;
                        }
                        m55315k(messenger, str);
                    }
                }
            } catch (Throwable th) {
                C2428b.m51299a(th, "ApsServiceCore", "doLocationGeo");
            }
        }
    }

    /* renamed from: r */
    public final boolean m55308r(String str) {
        if (TextUtils.isEmpty(this.f3860v)) {
            this.f3860v = C2428b.m51296b(this.f3850l);
        }
        return !TextUtils.isEmpty(str) && str.equals(this.f3860v);
    }

    /* renamed from: s */
    public final Handler m55307s() {
        return this.f3849k;
    }

    /* renamed from: w */
    public final void m55303w(Intent intent) {
        String stringExtra = intent.getStringExtra("a");
        if (!TextUtils.isEmpty(stringExtra)) {
            AuthConfigManager.m55052l(this.f3850l, stringExtra);
        }
        String stringExtra2 = intent.getStringExtra("b");
        this.f3841c = stringExtra2;
        C1780e4.m55247c(stringExtra2);
        String stringExtra3 = intent.getStringExtra("d");
        if (TextUtils.isEmpty(stringExtra3)) {
            return;
        }
        DeviceInfo.m54765s(stringExtra3);
    }
}

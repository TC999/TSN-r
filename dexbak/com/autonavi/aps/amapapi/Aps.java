package com.autonavi.aps.amapapi;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.provider.Settings;
import android.text.TextUtils;
import com.amap.api.col.p0463l.AmapWifi;
import com.amap.api.col.p0463l.C1925p4;
import com.amap.api.col.p0463l.ResponseEntity;
import com.amap.api.col.p0463l.SDKLogHandler;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import com.autonavi.aps.amapapi.filters.LocFilter;
import com.autonavi.aps.amapapi.model.AMapLocationServer;
import com.autonavi.aps.amapapi.restruct.AmapSensorManager;
import com.autonavi.aps.amapapi.restruct.Cgi;
import com.autonavi.aps.amapapi.restruct.CgiManager;
import com.autonavi.aps.amapapi.restruct.HistoryLocation;
import com.autonavi.aps.amapapi.restruct.HistoryLocationRecorder;
import com.autonavi.aps.amapapi.restruct.WifiManagerWrapper;
import com.autonavi.aps.amapapi.storage.C2423a;
import com.autonavi.aps.amapapi.trans.LocNetManager;
import com.autonavi.aps.amapapi.trans.Parser;
import com.autonavi.aps.amapapi.trans.Req;
import com.autonavi.aps.amapapi.utils.C2428b;
import com.autonavi.aps.amapapi.utils.C2432j;
import com.autonavi.aps.amapapi.utils.Reflect;
import com.autonavi.aps.amapapi.utils.ReportUtil;
import com.autonavi.base.amap.mapcore.tools.GLMapStaticValue;
import com.kuaishou.weapon.p205p0.C7282g;
import com.stub.StubApp;
import com.tencent.connect.common.Constants;
import com.umeng.socialize.common.SocializeConstants;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.ArrayList;
import java.util.Locale;

@SuppressLint({"NewApi"})
/* renamed from: com.autonavi.aps.amapapi.b */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class Aps {

    /* renamed from: A */
    static int f7991A = -1;

    /* renamed from: D */
    public static String[] f7992D = {C7282g.f24950h, C7282g.f24949g};

    /* renamed from: E */
    public static String f7993E = "android.permission.ACCESS_BACKGROUND_LOCATION";

    /* renamed from: K */
    private static boolean f7994K;

    /* renamed from: Q */
    private static volatile boolean f7995Q;

    /* renamed from: F */
    boolean f7998F;

    /* renamed from: N */
    private Handler f8005N;

    /* renamed from: O */
    private HistoryLocationRecorder f8006O;

    /* renamed from: P */
    private String f8007P;

    /* renamed from: R */
    private CollectionManager f8008R;

    /* renamed from: a */
    Context f8009a = null;

    /* renamed from: b */
    ConnectivityManager f8010b = null;

    /* renamed from: c */
    WifiManagerWrapper f8011c = null;

    /* renamed from: d */
    CgiManager f8012d = null;

    /* renamed from: e */
    C2423a f8013e = null;

    /* renamed from: f */
    Parser f8014f = null;

    /* renamed from: g */
    ArrayList<AmapWifi> f8015g = new ArrayList<>();

    /* renamed from: h */
    C2412a f8016h = null;

    /* renamed from: i */
    AMapLocationClientOption f8017i = new AMapLocationClientOption();

    /* renamed from: j */
    AMapLocationServer f8018j = null;

    /* renamed from: k */
    long f8019k = 0;

    /* renamed from: I */
    private int f8001I = 0;

    /* renamed from: l */
    Req f8020l = null;

    /* renamed from: m */
    boolean f8021m = false;

    /* renamed from: J */
    private String f8002J = null;

    /* renamed from: n */
    LocNetManager f8022n = null;

    /* renamed from: o */
    StringBuilder f8023o = new StringBuilder();

    /* renamed from: p */
    boolean f8024p = true;

    /* renamed from: q */
    boolean f8025q = true;

    /* renamed from: r */
    AMapLocationClientOption.GeoLanguage f8026r = AMapLocationClientOption.GeoLanguage.DEFAULT;

    /* renamed from: s */
    boolean f8027s = true;

    /* renamed from: t */
    boolean f8028t = false;

    /* renamed from: L */
    private String f8003L = null;

    /* renamed from: u */
    StringBuilder f8029u = null;

    /* renamed from: v */
    boolean f8030v = false;

    /* renamed from: w */
    public boolean f8031w = false;

    /* renamed from: x */
    int f8032x = 12;

    /* renamed from: M */
    private boolean f8004M = true;

    /* renamed from: y */
    AmapSensorManager f8033y = null;

    /* renamed from: z */
    boolean f8034z = false;

    /* renamed from: B */
    LocFilter f7996B = null;

    /* renamed from: C */
    String f7997C = null;

    /* renamed from: G */
    IntentFilter f7999G = null;

    /* renamed from: H */
    LocationManager f8000H = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Aps.java */
    /* renamed from: com.autonavi.aps.amapapi.b$1 */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static /* synthetic */ class C24111 {

        /* renamed from: a */
        static final /* synthetic */ int[] f8035a;

        static {
            int[] iArr = new int[AMapLocationClientOption.GeoLanguage.values().length];
            f8035a = iArr;
            try {
                iArr[AMapLocationClientOption.GeoLanguage.DEFAULT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f8035a[AMapLocationClientOption.GeoLanguage.ZH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f8035a[AMapLocationClientOption.GeoLanguage.EN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Aps.java */
    /* renamed from: com.autonavi.aps.amapapi.b$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public class C2412a extends BroadcastReceiver {
        C2412a() {
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            WifiManagerWrapper wifiManagerWrapper;
            WifiManagerWrapper wifiManagerWrapper2;
            if (context == null || intent == null) {
                return;
            }
            try {
                String action = intent.getAction();
                if (TextUtils.isEmpty(action)) {
                    return;
                }
                if (action.equals("android.net.wifi.SCAN_RESULTS")) {
                    WifiManagerWrapper wifiManagerWrapper3 = Aps.this.f8011c;
                    if (wifiManagerWrapper3 != null) {
                        wifiManagerWrapper3.m51475i();
                    }
                    try {
                        if (intent.getExtras() == null || !intent.getExtras().getBoolean("resultsUpdated", true) || (wifiManagerWrapper2 = Aps.this.f8011c) == null) {
                            return;
                        }
                        wifiManagerWrapper2.m51476h();
                    } catch (Throwable unused) {
                    }
                } else if (!action.equals("android.net.wifi.WIFI_STATE_CHANGED") || (wifiManagerWrapper = Aps.this.f8011c) == null) {
                } else {
                    wifiManagerWrapper.m51474j();
                }
            } catch (Throwable th) {
                C2428b.m51299a(th, "Aps", "onReceive");
            }
        }
    }

    public Aps(boolean z) {
        this.f7998F = z;
    }

    /* renamed from: i */
    private void m51687i() {
        if (this.f8022n != null) {
            try {
                if (this.f8017i == null) {
                    this.f8017i = new AMapLocationClientOption();
                }
                this.f8022n.m51385a(this.f8017i.getHttpTimeOut(), this.f8017i.getLocationProtocol().equals(AMapLocationClientOption.AMapLocationProtocol.HTTPS), m51686j());
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: j */
    private int m51686j() {
        int i;
        if (this.f8017i.getGeoLanguage() != null && (i = C24111.f8035a[this.f8017i.getGeoLanguage().ordinal()]) != 1) {
            if (i == 2) {
                return 1;
            }
            if (i == 3) {
                return 2;
            }
        }
        return 0;
    }

    /* renamed from: k */
    private void m51685k() {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        AMapLocationClientOption.GeoLanguage geoLanguage = AMapLocationClientOption.GeoLanguage.DEFAULT;
        boolean z5 = true;
        try {
            geoLanguage = this.f8017i.getGeoLanguage();
            z = this.f8017i.isNeedAddress();
            try {
                z3 = this.f8017i.isOffset();
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            z = true;
        }
        try {
            z4 = this.f8017i.isLocationCacheEnable();
            try {
                this.f8028t = this.f8017i.isOnceLocationLatest();
                this.f8034z = this.f8017i.isSensorEnable();
                if (z3 != this.f8025q || z != this.f8024p || z4 != this.f8027s || geoLanguage != this.f8026r) {
                    m51677s();
                }
            } catch (Throwable unused3) {
                z2 = z4;
                z5 = z3;
                boolean z6 = z2;
                z3 = z5;
                z4 = z6;
                this.f8025q = z3;
                this.f8024p = z;
                this.f8027s = z4;
                this.f8026r = geoLanguage;
            }
        } catch (Throwable unused4) {
            z5 = z3;
            z2 = true;
            boolean z62 = z2;
            z3 = z5;
            z4 = z62;
            this.f8025q = z3;
            this.f8024p = z;
            this.f8027s = z4;
            this.f8026r = geoLanguage;
        }
        this.f8025q = z3;
        this.f8024p = z;
        this.f8027s = z4;
        this.f8026r = geoLanguage;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x001c  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /* renamed from: l */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m51684l() {
        /*
            r4 = this;
            r0 = 0
            android.content.Context r1 = r4.f8009a     // Catch: java.lang.Throwable -> Lf
            if (r1 == 0) goto Lc
            com.autonavi.aps.amapapi.b$a r2 = r4.f8016h     // Catch: java.lang.Throwable -> Lf
            if (r2 == 0) goto Lc
            r1.unregisterReceiver(r2)     // Catch: java.lang.Throwable -> Lf
        Lc:
            r4.f8016h = r0
            goto L18
        Lf:
            r1 = move-exception
            java.lang.String r2 = "Aps"
            java.lang.String r3 = "destroy"
            com.autonavi.aps.amapapi.utils.C2428b.m51299a(r1, r2, r3)     // Catch: java.lang.Throwable -> L2b
            goto Lc
        L18:
            com.autonavi.aps.amapapi.restruct.e r0 = r4.f8012d
            if (r0 == 0) goto L21
            boolean r1 = r4.f7998F
            r0.m51559a(r1)
        L21:
            com.autonavi.aps.amapapi.restruct.k r0 = r4.f8011c
            if (r0 == 0) goto L2a
            boolean r1 = r4.f7998F
            r0.m51482c(r1)
        L2a:
            return
        L2b:
            r1 = move-exception
            r4.f8016h = r0
            goto L30
        L2f:
            throw r1
        L30:
            goto L2f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.aps.amapapi.Aps.m51684l():void");
    }

    /* renamed from: m */
    private void m51683m() {
        try {
            if (this.f8016h == null) {
                this.f8016h = new C2412a();
            }
            if (this.f7999G == null) {
                IntentFilter intentFilter = new IntentFilter();
                this.f7999G = intentFilter;
                intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
                this.f7999G.addAction("android.net.wifi.SCAN_RESULTS");
            }
            this.f8009a.registerReceiver(this.f8016h, this.f7999G);
        } catch (Throwable th) {
            C2428b.m51299a(th, "Aps", "initBroadcastListener");
        }
    }

    /* renamed from: n */
    private byte[] m51682n() throws Throwable {
        if (this.f8020l == null) {
            this.f8020l = new Req();
        }
        if (this.f8017i == null) {
            this.f8017i = new AMapLocationClientOption();
        }
        if (this.f8012d != null && this.f8011c != null) {
            this.f8020l.m51355a(this.f8009a, this.f8017i.isNeedAddress(), this.f8017i.isOffset(), this.f8012d, this.f8011c, this.f8010b, this.f7997C, this.f8006O);
        }
        return this.f8020l.m51356a();
    }

    /* renamed from: o */
    private boolean m51681o() {
        return this.f8019k == 0 || C2432j.m51186b() - this.f8019k > 20000;
    }

    /* renamed from: p */
    private void m51680p() {
        WifiManagerWrapper wifiManagerWrapper = this.f8011c;
        if (wifiManagerWrapper == null) {
            return;
        }
        wifiManagerWrapper.m51487a(this.f8021m);
    }

    /* renamed from: q */
    private boolean m51679q() {
        WifiManagerWrapper wifiManagerWrapper = this.f8011c;
        if (wifiManagerWrapper != null) {
            this.f8015g = wifiManagerWrapper.m51479e();
        }
        ArrayList<AmapWifi> arrayList = this.f8015g;
        return arrayList == null || arrayList.size() <= 0;
    }

    /* renamed from: r */
    private void m51678r() {
        if (this.f8003L != null) {
            this.f8003L = null;
        }
        StringBuilder sb = this.f8029u;
        if (sb != null) {
            sb.delete(0, sb.length());
        }
    }

    /* renamed from: s */
    private void m51677s() {
        try {
            C2423a c2423a = this.f8013e;
            if (c2423a != null) {
                c2423a.m51448a();
            }
            m51692d(null);
            this.f8004M = false;
            LocFilter locFilter = this.f7996B;
            if (locFilter != null) {
                locFilter.m51640a();
            }
        } catch (Throwable th) {
            C2428b.m51299a(th, "Aps", "cleanCache");
        }
    }

    /* renamed from: a */
    public final void m51712a(Handler handler) {
        this.f8005N = handler;
    }

    /* renamed from: b */
    public final void m51702b() {
        this.f8022n = LocNetManager.m51384a(this.f8009a);
        m51687i();
        if (this.f8010b == null) {
            this.f8010b = (ConnectivityManager) C2432j.m51203a(this.f8009a, "connectivity");
        }
        if (this.f8020l == null) {
            this.f8020l = new Req();
        }
    }

    /* renamed from: c */
    public final void m51696c() {
        if (this.f8033y == null) {
            this.f8033y = new AmapSensorManager(this.f8009a);
        }
        m51683m();
        WifiManagerWrapper wifiManagerWrapper = this.f8011c;
        if (wifiManagerWrapper != null) {
            wifiManagerWrapper.m51484b(false);
            this.f8015g = this.f8011c.m51479e();
        }
        CgiManager cgiManager = this.f8012d;
        if (cgiManager != null) {
            cgiManager.m51558a(false, m51679q());
        }
        this.f8013e.m51447a(this.f8009a);
        m51701b(this.f8009a);
        this.f8031w = true;
    }

    /* renamed from: d */
    public final void m51693d() {
        if (this.f8023o.length() > 0) {
            StringBuilder sb = this.f8023o;
            sb.delete(0, sb.length());
        }
    }

    @SuppressLint({"NewApi"})
    /* renamed from: e */
    public final void m51691e() {
        this.f7997C = null;
        this.f8030v = false;
        this.f8031w = false;
        C2423a c2423a = this.f8013e;
        if (c2423a != null) {
            c2423a.m51428b(this.f8009a);
        }
        LocFilter locFilter = this.f7996B;
        if (locFilter != null) {
            locFilter.m51640a();
        }
        if (this.f8014f != null) {
            this.f8014f = null;
        }
        HistoryLocationRecorder historyLocationRecorder = this.f8006O;
        if (historyLocationRecorder != null) {
            historyLocationRecorder.m51520a(this.f7998F);
        }
        m51684l();
        ArrayList<AmapWifi> arrayList = this.f8015g;
        if (arrayList != null) {
            arrayList.clear();
        }
        AmapSensorManager amapSensorManager = this.f8033y;
        if (amapSensorManager != null) {
            amapSensorManager.m51584f();
        }
        this.f8018j = null;
        this.f8009a = null;
        this.f8029u = null;
        this.f8000H = null;
    }

    /* renamed from: f */
    public final void m51690f() {
        CollectionManager collectionManager = this.f8008R;
        if (collectionManager != null) {
            collectionManager.m51658d();
        }
    }

    /* renamed from: g */
    public final void m51689g() {
        WifiManagerWrapper wifiManagerWrapper;
        try {
            if (this.f8009a == null) {
                return;
            }
            if (this.f8008R == null) {
                this.f8008R = new CollectionManager(this.f8009a);
            }
            CgiManager cgiManager = this.f8012d;
            if (cgiManager == null || (wifiManagerWrapper = this.f8011c) == null) {
                return;
            }
            this.f8008R.m51668a(cgiManager, wifiManagerWrapper, this.f8005N);
        } catch (Throwable th) {
            SDKLogHandler.m53863p(th, CommonNetImpl.f39530AS, "stc");
        }
    }

    /* renamed from: h */
    public final void m51688h() {
        CollectionManager collectionManager = this.f8008R;
        if (collectionManager != null) {
            collectionManager.m51676a();
        }
    }

    /* renamed from: a */
    public final void m51713a(Context context) {
        try {
            if (this.f8009a != null) {
                return;
            }
            this.f7996B = new LocFilter();
            Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
            this.f8009a = origApplicationContext;
            C2432j.m51183b(origApplicationContext);
            if (this.f8011c == null) {
                this.f8011c = new WifiManagerWrapper(this.f8009a, (WifiManager) C2432j.m51203a(this.f8009a, "wifi"), this.f8005N);
            }
            if (this.f8012d == null) {
                this.f8012d = new CgiManager(this.f8009a, this.f8005N);
            }
            this.f8006O = new HistoryLocationRecorder(context, this.f8005N);
            if (this.f8013e == null) {
                this.f8013e = new C2423a();
            }
            if (this.f8014f == null) {
                this.f8014f = new Parser();
            }
        } catch (Throwable th) {
            th.printStackTrace();
            C2428b.m51299a(th, "Aps", "initBase");
        }
    }

    /* renamed from: d */
    private void m51692d(AMapLocationServer aMapLocationServer) {
        if (aMapLocationServer != null) {
            this.f8018j = aMapLocationServer;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x0106 A[Catch: all -> 0x01fd, TRY_LEAVE, TryCatch #2 {all -> 0x01fd, blocks: (B:10:0x0052, B:12:0x007b, B:16:0x0086, B:18:0x008e, B:21:0x0096, B:22:0x0098, B:24:0x009e, B:25:0x00a8, B:29:0x00b1, B:31:0x00c4, B:33:0x00c8, B:34:0x00d2, B:37:0x00e8, B:39:0x00ee, B:41:0x00f2, B:44:0x0102, B:46:0x0106, B:42:0x00f9, B:43:0x00ff), top: B:102:0x0052 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x013e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x013f  */
    @android.annotation.SuppressLint({"NewApi"})
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.autonavi.aps.amapapi.model.AMapLocationServer m51697b(boolean r12, com.autonavi.aps.amapapi.AMapLocationStaticsEntity r13) {
        /*
            Method dump skipped, instructions count: 778
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.aps.amapapi.Aps.m51697b(boolean, com.autonavi.aps.amapapi.a):com.autonavi.aps.amapapi.model.a");
    }

    /* renamed from: c */
    private String m51695c(AMapLocationStaticsEntity aMapLocationStaticsEntity) {
        CgiManager cgiManager = this.f8012d;
        String str = "";
        if (cgiManager == null || this.f8011c == null) {
            return "";
        }
        int m51541h = cgiManager.m51541h();
        Cgi m51547e = this.f8012d.m51547e();
        Cgi m51545f = this.f8012d.m51545f();
        ArrayList<AmapWifi> arrayList = this.f8015g;
        boolean z = arrayList == null || arrayList.isEmpty();
        if (m51547e == null && m51545f == null && z) {
            if (this.f8010b == null) {
                this.f8010b = (ConnectivityManager) C2432j.m51203a(this.f8009a, "connectivity");
            }
            if (C2432j.m51177c() >= 31) {
                if (C2432j.m51204a(this.f8009a) && !this.f8011c.m51472l()) {
                    this.f8032x = 18;
                    this.f8023o.append("飞行模式下关闭了WIFI开关，请关闭飞行模式或者打开WIFI开关#1802");
                    ReportUtil.m51233a((String) null, 2132);
                    aMapLocationStaticsEntity.m51722f("#1802");
                    return "";
                }
            } else if (C2432j.m51204a(this.f8009a) && !this.f8011c.m51473k()) {
                this.f8032x = 18;
                this.f8023o.append("飞行模式下关闭了WIFI开关，请关闭飞行模式或者打开WIFI开关#1801");
                ReportUtil.m51233a((String) null, 2132);
                aMapLocationStaticsEntity.m51722f("#1801");
                return "";
            }
            if (C2432j.m51177c() >= 28) {
                if (this.f8000H == null) {
                    this.f8000H = (LocationManager) StubApp.getOrigApplicationContext(this.f8009a.getApplicationContext()).getSystemService(SocializeConstants.KEY_LOCATION);
                }
                if (!((Boolean) Reflect.m51261a(this.f8000H, "isLocationEnabled", new Object[0])).booleanValue()) {
                    this.f8032x = 12;
                    this.f8023o.append("定位服务没有开启，请在设置中打开定位服务开关#1206");
                    aMapLocationStaticsEntity.m51722f("#1206");
                    ReportUtil.m51233a((String) null, 2121);
                    return "";
                }
            }
            if (!C2432j.m51166e(this.f8009a)) {
                this.f8032x = 12;
                this.f8023o.append("定位权限被禁用,请授予应用定位权限#1201");
                aMapLocationStaticsEntity.m51722f("#1201");
                ReportUtil.m51233a((String) null, 2121);
                return "";
            } else if (C2432j.m51177c() >= 24 && C2432j.m51177c() < 28 && Settings.Secure.getInt(this.f8009a.getContentResolver(), "location_mode", 0) == 0) {
                this.f8032x = 12;
                aMapLocationStaticsEntity.m51722f("#1206");
                this.f8023o.append("定位服务没有开启，请在设置中打开定位服务开关#1206");
                ReportUtil.m51233a((String) null, 2121);
                return "";
            } else {
                String m51538k = this.f8012d.m51538k();
                String m51481d = this.f8011c.m51481d();
                if (this.f8011c.m51490a(this.f8010b) && m51481d != null) {
                    this.f8032x = 12;
                    aMapLocationStaticsEntity.m51722f("#1202");
                    this.f8023o.append("获取基站与获取WIFI的权限都被禁用，请在安全软件中打开应用的定位权限#1202");
                    ReportUtil.m51233a((String) null, 2121);
                    return "";
                } else if (m51538k != null) {
                    this.f8032x = 12;
                    if (!this.f8011c.m51473k()) {
                        aMapLocationStaticsEntity.m51722f("#1204");
                        this.f8023o.append("WIFI开关关闭，并且获取基站权限被禁用，请在安全软件中打开应用的定位权限或者打开WIFI开关#1204");
                    } else {
                        aMapLocationStaticsEntity.m51722f("#1205");
                        this.f8023o.append("获取的WIFI列表为空，并且获取基站权限被禁用，请在安全软件中打开应用的定位权限#1205");
                    }
                    ReportUtil.m51233a((String) null, 2121);
                    return "";
                } else if (!this.f8011c.m51473k() && !this.f8012d.m51535n()) {
                    this.f8032x = 19;
                    aMapLocationStaticsEntity.m51722f("#1901");
                    this.f8023o.append("没有检查到SIM卡，并且WIFI开关关闭，请打开WIFI开关或者插入SIM卡#1901");
                    ReportUtil.m51233a((String) null, 2133);
                    return "";
                } else {
                    if (!this.f8011c.m51473k()) {
                        aMapLocationStaticsEntity.m51722f("#1301");
                        this.f8023o.append("获取到的基站为空，并且关闭了WIFI开关，请您打开WIFI开关再发起定位#1301");
                    } else {
                        aMapLocationStaticsEntity.m51722f("#1302");
                        if (this.f8011c.m51483c() != null) {
                            this.f8023o.append("获取到的基站和WIFI信息均为空，请检查是否授予APP定位权限");
                            if (!C2432j.m51164f(this.f8009a)) {
                                this.f8023o.append("或后台运行没有后台定位权限");
                            }
                            this.f8023o.append("#1302");
                        } else {
                            this.f8023o.append("获取到的基站和WIFI信息均为空，请移动到有WIFI的区域，若确定当前区域有WIFI，请检查是否授予APP定位权限");
                            if (!C2432j.m51164f(this.f8009a)) {
                                this.f8023o.append("或后台运行没有后台定位权限");
                            }
                            this.f8023o.append("#1302");
                        }
                    }
                    this.f8032x = 13;
                    ReportUtil.m51233a((String) null, 2131);
                    return "";
                }
            }
        }
        boolean m51488a = this.f8011c.m51488a(this.f8011c.m51471m());
        String str2 = "cgi";
        if (m51541h == 0) {
            boolean z2 = !this.f8015g.isEmpty() || m51488a;
            boolean z3 = m51545f != null;
            if (!z3) {
                if (m51488a && this.f8015g.isEmpty()) {
                    this.f8032x = 2;
                    aMapLocationStaticsEntity.m51722f("#0201");
                    this.f8023o.append("当前基站为伪基站，并且WIFI权限被禁用，请在安全软件中打开应用的定位权限#0201");
                    ReportUtil.m51233a((String) null, 2021);
                    return "";
                } else if (this.f8015g.size() == 1) {
                    this.f8032x = 2;
                    if (!m51488a) {
                        aMapLocationStaticsEntity.m51722f("#0202");
                        this.f8023o.append("当前基站为伪基站，并且搜到的WIFI数量不足，请移动到WIFI比较丰富的区域#0202");
                        ReportUtil.m51233a((String) null, (int) GLMapStaticValue.MAP_PARAMETERNAME_CLEAR_INDOORBUILDING_LAST);
                        return "";
                    } else if (this.f8015g.get(0).f4591h) {
                        aMapLocationStaticsEntity.m51722f("#0202");
                        this.f8023o.append("当前基站为伪基站，并且搜到的WIFI数量不足，请移动到WIFI比较丰富的区域#0202");
                        ReportUtil.m51233a((String) null, 2021);
                        return "";
                    }
                }
            }
            String format = String.format(Locale.US, "#%s#", "network");
            if (z3) {
                StringBuilder sb = new StringBuilder();
                sb.append(m51545f.m51578b());
                str2 = (!this.f8015g.isEmpty() || m51488a) ? "cgiwifi" : "cgiwifi";
                sb.append("network");
                sb.append("#");
                sb.append(str2);
                str = sb.toString();
            } else if (z2) {
                str = format + "wifi";
            } else {
                this.f8032x = 2;
                if (!this.f8011c.m51473k()) {
                    aMapLocationStaticsEntity.m51722f("#0203");
                    this.f8023o.append("当前基站为伪基站,并且关闭了WIFI开关，请在设置中打开WIFI开关#0203");
                } else {
                    aMapLocationStaticsEntity.m51722f("#0204");
                    this.f8023o.append("当前基站为伪基站,并且没有搜索到WIFI，请移动到WIFI比较丰富的区域#0204");
                }
                ReportUtil.m51233a((String) null, (int) GLMapStaticValue.MAP_PARAMETERNAME_CLEAR_INDOORBUILDING_LAST);
            }
        } else if (m51541h != 1) {
            if (m51541h != 2) {
                this.f8032x = 11;
                ReportUtil.m51233a((String) null, 2111);
                aMapLocationStaticsEntity.m51722f("#1101");
                this.f8023o.append("get cgi failure#1101");
            } else if (m51547e != null) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(m51547e.f8121a);
                sb2.append("#");
                sb2.append(m51547e.f8122b);
                sb2.append("#");
                sb2.append(m51547e.f8128h);
                sb2.append("#");
                sb2.append(m51547e.f8129i);
                sb2.append("#");
                sb2.append(m51547e.f8130j);
                sb2.append("#");
                sb2.append("network");
                sb2.append("#");
                sb2.append((!this.f8015g.isEmpty() || m51488a) ? "cgiwifi" : "cgiwifi");
                str = sb2.toString();
            }
        } else if (m51547e != null) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(m51547e.f8121a);
            sb3.append("#");
            sb3.append(m51547e.f8122b);
            sb3.append("#");
            sb3.append(m51547e.f8123c);
            sb3.append("#");
            sb3.append(m51547e.f8124d);
            sb3.append("#");
            sb3.append("network");
            sb3.append("#");
            sb3.append((!this.f8015g.isEmpty() || m51488a) ? "cgiwifi" : "cgiwifi");
            str = sb3.toString();
        }
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        if (!str.startsWith("#")) {
            str = "#" + str;
        }
        return C2432j.m51167e() + str;
    }

    /* renamed from: a */
    public final void m51717a() {
        CgiManager cgiManager = this.f8012d;
        if (cgiManager != null) {
            cgiManager.m51557b();
        }
    }

    /* renamed from: a */
    public final void m51710a(AMapLocationClientOption aMapLocationClientOption) {
        this.f8017i = aMapLocationClientOption;
        if (aMapLocationClientOption == null) {
            this.f8017i = new AMapLocationClientOption();
        }
        WifiManagerWrapper wifiManagerWrapper = this.f8011c;
        if (wifiManagerWrapper != null) {
            this.f8017i.isWifiActiveScan();
            wifiManagerWrapper.m51486a(this.f8017i.isWifiScan(), this.f8017i.isMockEnable(), AMapLocationClientOption.isOpenAlwaysScanWifi(), aMapLocationClientOption.getScanWifiInterval());
        }
        m51687i();
        C2423a c2423a = this.f8013e;
        if (c2423a != null) {
            c2423a.m51444a(this.f8017i);
        }
        Parser parser = this.f8014f;
        if (parser != null) {
            parser.m51365a(this.f8017i);
        }
        CgiManager cgiManager = this.f8012d;
        if (cgiManager != null) {
            cgiManager.m51550c(this.f8017i.isNoLocReqCgiEnable());
        }
        m51685k();
    }

    /* JADX WARN: Can't wrap try/catch for region: R(13:20|(2:22|(1:24)(1:25))|26|(2:27|28)|(8:33|34|(1:36)|38|39|(1:41)|43|(2:45|46)(2:47|(11:53|(1:100)(1:57)|58|(1:60)(2:86|(3:88|(1:90)|91)(4:92|(1:96)|97|(1:99)))|61|62|(2:65|(1:67)(2:68|(1:70)(2:71|(1:73)(1:74))))|75|(2:77|(1:82)(1:81))|83|84)(2:51|52)))|103|34|(0)|38|39|(0)|43|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00a3, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00a4, code lost:
        com.autonavi.aps.amapapi.utils.C2428b.m51299a(r0, "Aps", "getLocation getCgiListParam");
     */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0085 A[Catch: all -> 0x0091, TRY_LEAVE, TryCatch #0 {all -> 0x0091, blocks: (B:27:0x006d, B:29:0x0075, B:34:0x0081, B:36:0x0085), top: B:104:0x006d }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x009b A[Catch: all -> 0x00a3, TRY_LEAVE, TryCatch #1 {all -> 0x00a3, blocks: (B:40:0x0097, B:42:0x009b), top: B:106:0x0097 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00c2  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.autonavi.aps.amapapi.model.AMapLocationServer m51709a(com.autonavi.aps.amapapi.AMapLocationStaticsEntity r18) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 488
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.aps.amapapi.Aps.m51709a(com.autonavi.aps.amapapi.a):com.autonavi.aps.amapapi.model.a");
    }

    /* renamed from: b */
    private void m51701b(Context context) {
        try {
            if (context.checkCallingOrSelfPermission(C1925p4.m54183u("EYW5kcm9pZC5wZXJtaXNzaW9uLldSSVRFX1NFQ1VSRV9TRVRUSU5HUw==")) == 0) {
                this.f8021m = true;
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: b */
    public final void m51700b(AMapLocationStaticsEntity aMapLocationStaticsEntity) {
        try {
        } catch (Throwable th) {
            C2428b.m51299a(th, "Aps", "initFirstLocateParam");
        }
        if (this.f8030v) {
            return;
        }
        m51678r();
        if (this.f8028t) {
            m51683m();
        }
        WifiManagerWrapper wifiManagerWrapper = this.f8011c;
        if (wifiManagerWrapper != null) {
            wifiManagerWrapper.m51484b(this.f8028t);
            this.f8015g = this.f8011c.m51479e();
        }
        CgiManager cgiManager = this.f8012d;
        if (cgiManager != null) {
            cgiManager.m51558a(true, m51679q());
        }
        String m51695c = m51695c(aMapLocationStaticsEntity);
        this.f8003L = m51695c;
        if (!TextUtils.isEmpty(m51695c)) {
            this.f8029u = m51705a(this.f8029u);
        }
        this.f8030v = true;
    }

    /* renamed from: a */
    public final AMapLocationServer m51708a(AMapLocationServer aMapLocationServer) {
        this.f7996B.m51637a(this.f8027s);
        return this.f7996B.m51638a(aMapLocationServer);
    }

    /* renamed from: a */
    public final void m51704a(boolean z) {
        CgiManager cgiManager = this.f8012d;
        if (cgiManager != null) {
            cgiManager.m51554b(z);
        }
    }

    /* renamed from: a */
    private boolean m51714a(long j) {
        if (!this.f8004M) {
            this.f8004M = true;
            return false;
        }
        if (C2432j.m51186b() - j < 800) {
            if ((C2432j.m51194a(this.f8018j) ? C2432j.m51211a() - this.f8018j.getTime() : 0L) <= 10000) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    private StringBuilder m51705a(StringBuilder sb) {
        if (sb == null) {
            sb = new StringBuilder(700);
        } else {
            sb.delete(0, sb.length());
        }
        CgiManager cgiManager = this.f8012d;
        if (cgiManager != null && this.f8011c != null) {
            sb.append(cgiManager.m51536m());
            sb.append(this.f8011c.m51469o());
        }
        return sb;
    }

    /* renamed from: b */
    public final AMapLocationServer m51698b(boolean z) {
        WifiManagerWrapper wifiManagerWrapper = this.f8011c;
        if (wifiManagerWrapper != null && wifiManagerWrapper.m51470n()) {
            return m51715a(15, "networkLocation has been mocked!#1502");
        }
        if (TextUtils.isEmpty(this.f8003L)) {
            return m51715a(this.f8032x, this.f8023o.toString());
        }
        AMapLocationServer m51446a = this.f8013e.m51446a(this.f8009a, this.f8003L, this.f8029u, true, z);
        if (C2432j.m51194a(m51446a)) {
            m51692d(m51446a);
        }
        return m51446a;
    }

    /* renamed from: a */
    private AMapLocationServer m51706a(AMapLocationServer aMapLocationServer, ResponseEntity responseEntity, AMapLocationStaticsEntity aMapLocationStaticsEntity) {
        if (responseEntity != null) {
            try {
                byte[] bArr = responseEntity.f5682a;
                if (bArr != null && bArr.length != 0) {
                    Parser parser = new Parser();
                    String str = new String(responseEntity.f5682a, "UTF-8");
                    if (str.contains("\"status\":\"0\"")) {
                        AMapLocationServer m51360a = parser.m51360a(str, this.f8009a, responseEntity, aMapLocationStaticsEntity);
                        m51360a.m51616h(this.f8029u.toString());
                        return m51360a;
                    } else if (str.contains("</body></html>")) {
                        aMapLocationServer.setErrorCode(5);
                        WifiManagerWrapper wifiManagerWrapper = this.f8011c;
                        if (wifiManagerWrapper != null && wifiManagerWrapper.m51490a(this.f8010b)) {
                            aMapLocationStaticsEntity.m51722f("#0501");
                            this.f8023o.append("您连接的是一个需要登录的网络，请确认已经登入网络#0501");
                            ReportUtil.m51233a((String) null, 2051);
                        } else {
                            aMapLocationStaticsEntity.m51722f("#0502");
                            this.f8023o.append("请求可能被劫持了#0502");
                            ReportUtil.m51233a((String) null, 2052);
                        }
                        aMapLocationServer.setLocationDetail(this.f8023o.toString());
                        return aMapLocationServer;
                    } else {
                        return null;
                    }
                }
            } catch (Throwable th) {
                aMapLocationServer.setErrorCode(4);
                C2428b.m51299a(th, "Aps", "checkResponseEntity");
                aMapLocationStaticsEntity.m51722f("#0403");
                StringBuilder sb = this.f8023o;
                sb.append("check response exception ex is" + th.getMessage() + "#0403");
                aMapLocationServer.setLocationDetail(this.f8023o.toString());
                return aMapLocationServer;
            }
        }
        aMapLocationServer.setErrorCode(4);
        this.f8023o.append("网络异常,请求异常#0403");
        aMapLocationStaticsEntity.m51722f("#0403");
        aMapLocationServer.m51616h(this.f8029u.toString());
        aMapLocationServer.setLocationDetail(this.f8023o.toString());
        if (responseEntity != null) {
            ReportUtil.m51233a(responseEntity.f5685d, 2041);
        }
        return aMapLocationServer;
    }

    /* renamed from: b */
    public final void m51699b(AMapLocationServer aMapLocationServer) {
        if (C2432j.m51194a(aMapLocationServer)) {
            this.f8013e.m51435a(this.f8003L, this.f8029u, aMapLocationServer, this.f8009a, true);
        }
    }

    /* renamed from: c */
    private static void m51694c(AMapLocationServer aMapLocationServer) {
        if (aMapLocationServer.getErrorCode() == 0 && aMapLocationServer.getLocationType() == 0) {
            if (!"-5".equals(aMapLocationServer.m51625d()) && !"1".equals(aMapLocationServer.m51625d()) && !"2".equals(aMapLocationServer.m51625d()) && !Constants.VIA_REPORT_TYPE_MAKE_FRIEND.equals(aMapLocationServer.m51625d()) && !Constants.VIA_REPORT_TYPE_CHAT_AIO.equals(aMapLocationServer.m51625d()) && !"-1".equals(aMapLocationServer.m51625d())) {
                aMapLocationServer.setLocationType(6);
            } else {
                aMapLocationServer.setLocationType(5);
            }
        }
    }

    /* renamed from: a */
    public final AMapLocationServer m51703a(boolean z, AMapLocationStaticsEntity aMapLocationStaticsEntity) {
        if (z) {
            aMapLocationStaticsEntity.m51724e("statics");
        } else {
            aMapLocationStaticsEntity.m51724e("first");
        }
        if (this.f8009a == null) {
            aMapLocationStaticsEntity.m51722f("#0101");
            this.f8023o.append("context is null#0101");
            ReportUtil.m51233a((String) null, (int) GLMapStaticValue.MAP_PARAMETERNAME_SATELLITE);
            return m51715a(1, this.f8023o.toString());
        }
        WifiManagerWrapper wifiManagerWrapper = this.f8011c;
        if (wifiManagerWrapper != null && wifiManagerWrapper.m51470n()) {
            aMapLocationStaticsEntity.m51722f("#1502");
            return m51715a(15, "networkLocation has been mocked!#1502");
        }
        m51702b();
        if (TextUtils.isEmpty(this.f8003L)) {
            return m51715a(this.f8032x, this.f8023o.toString());
        }
        AMapLocationServer m51697b = m51697b(z, aMapLocationStaticsEntity);
        if (C2432j.m51194a(m51697b) && !f7995Q) {
            this.f8013e.m51440a(this.f8029u.toString());
            CgiManager cgiManager = this.f8012d;
            if (cgiManager != null) {
                this.f8013e.m51442a(cgiManager.m51547e());
            }
            m51692d(m51697b);
        }
        f7995Q = true;
        return m51697b;
    }

    /* renamed from: a */
    public final AMapLocationServer m51716a(double d, double d2) {
        try {
            String m51383a = this.f8022n.m51383a(this.f8009a, d, d2);
            if (m51383a.contains("\"status\":\"1\"")) {
                AMapLocationServer m51361a = this.f8014f.m51361a(m51383a);
                m51361a.setLatitude(d);
                m51361a.setLongitude(d2);
                return m51361a;
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: a */
    public final void m51711a(AMapLocation aMapLocation) {
        if (aMapLocation.getErrorCode() != 0) {
            return;
        }
        HistoryLocation historyLocation = new HistoryLocation();
        historyLocation.f8166a = aMapLocation.getLocationType();
        historyLocation.f8169d = aMapLocation.getTime();
        historyLocation.f8170e = (int) aMapLocation.getAccuracy();
        historyLocation.f8167b = aMapLocation.getLatitude();
        historyLocation.f8168c = aMapLocation.getLongitude();
        if (aMapLocation.getLocationType() == 1) {
            this.f8006O.m51523a(historyLocation);
        }
    }

    /* renamed from: a */
    public final void m51707a(AMapLocationServer aMapLocationServer, int i) {
        if (aMapLocationServer != null && aMapLocationServer.getErrorCode() == 0) {
            HistoryLocation historyLocation = new HistoryLocation();
            historyLocation.f8169d = aMapLocationServer.getTime();
            historyLocation.f8170e = (int) aMapLocationServer.getAccuracy();
            historyLocation.f8167b = aMapLocationServer.getLatitude();
            historyLocation.f8168c = aMapLocationServer.getLongitude();
            historyLocation.f8166a = i;
            historyLocation.f8172g = Integer.parseInt(aMapLocationServer.m51625d());
            historyLocation.f8173h = aMapLocationServer.m51610l();
            this.f8006O.m51518b(historyLocation);
        }
    }

    /* renamed from: a */
    private static AMapLocationServer m51715a(int i, String str) {
        AMapLocationServer aMapLocationServer = new AMapLocationServer("");
        aMapLocationServer.setErrorCode(i);
        aMapLocationServer.setLocationDetail(str);
        if (i == 15) {
            ReportUtil.m51233a((String) null, 2151);
        }
        return aMapLocationServer;
    }
}

package com.autonavi.aps.amapapi.restruct;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.telephony.CellIdentityCdma;
import android.telephony.CellIdentityGsm;
import android.telephony.CellIdentityLte;
import android.telephony.CellIdentityWcdma;
import android.telephony.CellInfo;
import android.telephony.CellInfoCdma;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoNr;
import android.telephony.CellInfoWcdma;
import android.telephony.CellLocation;
import android.telephony.PhoneStateListener;
import android.telephony.ServiceState;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import android.text.TextUtils;
import com.amap.api.col.p0463l.AmapCell;
import com.amap.api.col.p0463l.AmapCellCdma;
import com.amap.api.col.p0463l.AmapCellGsm;
import com.amap.api.col.p0463l.AmapCellLte;
import com.amap.api.col.p0463l.AmapCellWcdma;
import com.amap.api.col.p0463l.ThreadPool;
import com.autonavi.aps.amapapi.CollectionManager;
import com.autonavi.aps.amapapi.utils.C2428b;
import com.autonavi.aps.amapapi.utils.C2432j;
import com.autonavi.aps.amapapi.utils.DebugUtils;
import com.kuaishou.weapon.p205p0.C7282g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import okhttp3.internal.p629ws.WebSocketProtocol;

@SuppressLint({"NewApi"})
/* renamed from: com.autonavi.aps.amapapi.restruct.e */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class CgiManager {

    /* renamed from: b */
    TelephonyManager f8142b;

    /* renamed from: d */
    SignalStrength f8144d;

    /* renamed from: h */
    private Context f8148h;

    /* renamed from: m */
    private CellAgeEstimator f8153m;
    @SuppressLint({"NewApi"})

    /* renamed from: q */
    private TelephonyManager.CellInfoCallback f8157q;

    /* renamed from: w */
    private CollectionManager f8163w;

    /* renamed from: i */
    private boolean f8149i = false;

    /* renamed from: j */
    private boolean f8150j = false;

    /* renamed from: a */
    ArrayList<Cgi> f8141a = new ArrayList<>();

    /* renamed from: k */
    private String f8151k = null;

    /* renamed from: l */
    private ArrayList<Cgi> f8152l = new ArrayList<>();

    /* renamed from: n */
    private long f8154n = 0;

    /* renamed from: c */
    PhoneStateListener f8143c = null;

    /* renamed from: o */
    private boolean f8155o = false;

    /* renamed from: p */
    private Object f8156p = new Object();

    /* renamed from: r */
    private boolean f8158r = false;

    /* renamed from: e */
    boolean f8145e = false;

    /* renamed from: f */
    StringBuilder f8146f = null;

    /* renamed from: s */
    private String f8159s = null;

    /* renamed from: t */
    private String f8160t = null;

    /* renamed from: g */
    String f8147g = null;

    /* renamed from: u */
    private volatile boolean f8161u = true;

    /* renamed from: v */
    private volatile boolean f8162v = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CgiManager.java */
    @SuppressLint({"NewApi"})
    /* renamed from: com.autonavi.aps.amapapi.restruct.e$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public class C2419a extends TelephonyManager.CellInfoCallback {
        C2419a() {
        }

        @Override // android.telephony.TelephonyManager.CellInfoCallback
        public final void onCellInfo(List<CellInfo> list) {
            try {
                DebugUtils.m51285a();
                StringBuilder sb = new StringBuilder("noLocReqCgiEnable:");
                sb.append(CgiManager.this.f8162v);
                sb.append(" isStartLocation:");
                sb.append(CgiManager.this.f8161u);
                DebugUtils.m51285a();
                if ((CgiManager.this.f8162v || CgiManager.this.f8161u) && C2432j.m51186b() - CgiManager.this.f8154n >= 500) {
                    CgiManager.m51548d(CgiManager.this);
                    CgiManager.this.m51565a(CgiManager.this.m51528u());
                    CgiManager.this.m51560a(list);
                    CgiManager.this.f8154n = C2432j.m51186b();
                }
            } catch (SecurityException e) {
                CgiManager.this.f8147g = e.getMessage();
            } catch (Throwable th) {
                C2428b.m51299a(th, "Cgi", "cellInfo");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CgiManager.java */
    /* renamed from: com.autonavi.aps.amapapi.restruct.e$b */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public class C2420b extends PhoneStateListener {
        C2420b() {
        }

        @Override // android.telephony.PhoneStateListener
        public final void onCellInfoChanged(List<CellInfo> list) {
            try {
                DebugUtils.m51285a();
                StringBuilder sb = new StringBuilder("noLocReqCgiEnable:");
                sb.append(CgiManager.this.f8162v);
                sb.append(" isStartLocation:");
                sb.append(CgiManager.this.f8161u);
                DebugUtils.m51285a();
                if (CgiManager.this.f8162v || CgiManager.this.f8161u) {
                    if (CgiManager.this.f8163w != null) {
                        CgiManager.this.f8163w.m51661c();
                    }
                    if (C2432j.m51186b() - CgiManager.this.f8154n < 500) {
                        return;
                    }
                    CgiManager.this.m51565a(CgiManager.this.m51528u());
                    CgiManager.this.m51560a(list);
                    CgiManager.this.f8154n = C2432j.m51186b();
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        @Override // android.telephony.PhoneStateListener
        public final void onCellLocationChanged(CellLocation cellLocation) {
            DebugUtils.m51285a();
            StringBuilder sb = new StringBuilder("noLocReqCgiEnable:");
            sb.append(CgiManager.this.f8162v);
            sb.append(" isStartLocation:");
            sb.append(CgiManager.this.f8161u);
            DebugUtils.m51285a();
            if ((CgiManager.this.f8162v || CgiManager.this.f8161u) && C2432j.m51186b() - CgiManager.this.f8154n >= 500) {
                try {
                    CgiManager.this.m51565a(cellLocation);
                    CgiManager.this.m51560a(CgiManager.this.m51527v());
                    CgiManager.this.f8154n = C2432j.m51186b();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }

        @Override // android.telephony.PhoneStateListener
        public final void onDataConnectionStateChanged(int i) {
            super.onDataConnectionStateChanged(i);
            DebugUtils.m51285a();
        }

        @Override // android.telephony.PhoneStateListener
        public final void onServiceStateChanged(ServiceState serviceState) {
            try {
                DebugUtils.m51285a();
                StringBuilder sb = new StringBuilder("noLocReqCgiEnable:");
                sb.append(CgiManager.this.f8162v);
                sb.append(" isStartLocation:");
                sb.append(CgiManager.this.f8161u);
                DebugUtils.m51285a();
                if (CgiManager.this.f8162v || CgiManager.this.f8161u) {
                    int state = serviceState.getState();
                    if (state == 0) {
                        CgiManager.this.m51558a(false, false);
                    } else if (state != 1) {
                    } else {
                        CgiManager.this.m51539j();
                    }
                }
            } catch (Throwable unused) {
            }
        }

        @Override // android.telephony.PhoneStateListener
        public final void onSignalStrengthChanged(int i) {
            super.onSignalStrengthChanged(i);
            DebugUtils.m51285a();
        }

        @Override // android.telephony.PhoneStateListener
        public final void onSignalStrengthsChanged(SignalStrength signalStrength) {
            DebugUtils.m51285a();
            StringBuilder sb = new StringBuilder("noLocReqCgiEnable:");
            sb.append(CgiManager.this.f8162v);
            sb.append(" isStartLocation:");
            sb.append(CgiManager.this.f8161u);
            DebugUtils.m51285a();
            if (signalStrength == null) {
                return;
            }
            CgiManager cgiManager = CgiManager.this;
            cgiManager.f8144d = signalStrength;
            if (cgiManager.f8162v || CgiManager.this.f8161u) {
                try {
                    if (CgiManager.this.f8163w != null) {
                        CgiManager.this.f8163w.m51661c();
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    public CgiManager(Context context, Handler handler) {
        this.f8142b = null;
        this.f8153m = null;
        this.f8148h = context;
        if (this.f8142b == null) {
            this.f8142b = (TelephonyManager) C2432j.m51203a(context, "phone");
        }
        m51534o();
        CellAgeEstimator cellAgeEstimator = new CellAgeEstimator(context, "cellAge", handler);
        this.f8153m = cellAgeEstimator;
        cellAgeEstimator.m51609a();
    }

    /* renamed from: a */
    public static boolean m51572a(int i) {
        return i > 0 && i <= 15;
    }

    /* renamed from: b */
    private static int m51556b(int i) {
        return (i * 2) - 113;
    }

    /* renamed from: d */
    static /* synthetic */ boolean m51548d(CgiManager cgiManager) {
        cgiManager.f8158r = true;
        return true;
    }

    /* renamed from: o */
    private void m51534o() {
        if (this.f8142b == null) {
            return;
        }
        m51533p();
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0036 A[Catch: Exception -> 0x007a, TryCatch #0 {Exception -> 0x007a, blocks: (B:2:0x0000, B:4:0x0004, B:5:0x000b, B:8:0x001b, B:10:0x0023, B:15:0x0036, B:19:0x0045, B:25:0x0053, B:26:0x0055, B:30:0x005f, B:34:0x0065, B:36:0x0070, B:38:0x0074, B:35:0x006b, B:11:0x0029, B:12:0x002f), top: B:43:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x006b A[Catch: Exception -> 0x007a, TryCatch #0 {Exception -> 0x007a, blocks: (B:2:0x0000, B:4:0x0004, B:5:0x000b, B:8:0x001b, B:10:0x0023, B:15:0x0036, B:19:0x0045, B:25:0x0053, B:26:0x0055, B:30:0x005f, B:34:0x0065, B:36:0x0070, B:38:0x0074, B:35:0x006b, B:11:0x0029, B:12:0x002f), top: B:43:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0074 A[Catch: Exception -> 0x007a, TRY_LEAVE, TryCatch #0 {Exception -> 0x007a, blocks: (B:2:0x0000, B:4:0x0004, B:5:0x000b, B:8:0x001b, B:10:0x0023, B:15:0x0036, B:19:0x0045, B:25:0x0053, B:26:0x0055, B:30:0x005f, B:34:0x0065, B:36:0x0070, B:38:0x0074, B:35:0x006b, B:11:0x0029, B:12:0x002f), top: B:43:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:? A[RETURN, SYNTHETIC] */
    /* renamed from: p */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m51533p() {
        /*
            r8 = this;
            android.telephony.PhoneStateListener r0 = r8.f8143c     // Catch: java.lang.Exception -> L7a
            if (r0 != 0) goto Lb
            com.autonavi.aps.amapapi.restruct.e$b r0 = new com.autonavi.aps.amapapi.restruct.e$b     // Catch: java.lang.Exception -> L7a
            r0.<init>()     // Catch: java.lang.Exception -> L7a
            r8.f8143c = r0     // Catch: java.lang.Exception -> L7a
        Lb:
            r0 = 320(0x140, float:4.48E-43)
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Exception -> L7a
            java.lang.String r2 = "hasFineLocPerm"
            java.lang.String r3 = "hasNoFineLocPerm"
            java.lang.String r4 = "android.permission.ACCESS_FINE_LOCATION"
            r5 = 336(0x150, float:4.71E-43)
            r6 = 31
            if (r1 < r6) goto L2f
            android.content.Context r7 = r8.f8148h     // Catch: java.lang.Exception -> L7a
            int r7 = r7.checkSelfPermission(r4)     // Catch: java.lang.Exception -> L7a
            if (r7 != 0) goto L29
            r8.f8160t = r2     // Catch: java.lang.Exception -> L7a
            com.autonavi.aps.amapapi.utils.DebugUtils.m51283b()     // Catch: java.lang.Exception -> L7a
            goto L32
        L29:
            r8.f8160t = r3     // Catch: java.lang.Exception -> L7a
            com.autonavi.aps.amapapi.utils.DebugUtils.m51283b()     // Catch: java.lang.Exception -> L7a
            goto L34
        L2f:
            com.autonavi.aps.amapapi.utils.DebugUtils.m51283b()     // Catch: java.lang.Exception -> L7a
        L32:
            r0 = 336(0x150, float:4.71E-43)
        L34:
            if (r1 < r6) goto L6b
            android.content.Context r1 = r8.f8148h     // Catch: java.lang.Exception -> L7a
            java.lang.String r5 = "android.permission.READ_PHONE_STATE"
            int r1 = r1.checkSelfPermission(r5)     // Catch: java.lang.Exception -> L7a
            r5 = 1
            r6 = 0
            if (r1 != 0) goto L44
            r1 = 1
            goto L45
        L44:
            r1 = 0
        L45:
            android.content.Context r7 = r8.f8148h     // Catch: java.lang.Exception -> L7a
            int r4 = r7.checkSelfPermission(r4)     // Catch: java.lang.Exception -> L7a
            if (r4 != 0) goto L4e
            goto L4f
        L4e:
            r5 = 0
        L4f:
            if (r1 == 0) goto L55
            if (r5 == 0) goto L55
            r0 = r0 | 1024(0x400, float:1.435E-42)
        L55:
            com.autonavi.aps.amapapi.utils.DebugUtils.m51283b()     // Catch: java.lang.Exception -> L7a
            if (r1 == 0) goto L5d
            java.lang.String r1 = "hasReadPhoneStatePerm"
            goto L5f
        L5d:
            java.lang.String r1 = "hasNoReadPhoneStatePerm"
        L5f:
            r8.f8159s = r1     // Catch: java.lang.Exception -> L7a
            if (r5 == 0) goto L64
            goto L65
        L64:
            r2 = r3
        L65:
            r8.f8160t = r2     // Catch: java.lang.Exception -> L7a
            com.autonavi.aps.amapapi.utils.DebugUtils.m51283b()     // Catch: java.lang.Exception -> L7a
            goto L70
        L6b:
            com.autonavi.aps.amapapi.utils.DebugUtils.m51283b()     // Catch: java.lang.Exception -> L7a
            r0 = r0 | 1024(0x400, float:1.435E-42)
        L70:
            android.telephony.PhoneStateListener r1 = r8.f8143c     // Catch: java.lang.Exception -> L7a
            if (r1 == 0) goto L79
            android.telephony.TelephonyManager r2 = r8.f8142b     // Catch: java.lang.Exception -> L7a
            r2.listen(r1, r0)     // Catch: java.lang.Exception -> L7a
        L79:
            return
        L7a:
            r0 = move-exception
            r0.printStackTrace()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.aps.amapapi.restruct.CgiManager.m51533p():void");
    }

    /* renamed from: q */
    private int m51532q() {
        Cgi m51547e = m51547e();
        if (m51547e != null) {
            return m51547e.f8132l;
        }
        return 0;
    }

    /* renamed from: r */
    private CellLocation m51531r() {
        TelephonyManager telephonyManager = this.f8142b;
        if (telephonyManager != null) {
            try {
                CellLocation cellLocation = telephonyManager.getCellLocation();
                DebugUtils.m51285a();
                this.f8147g = null;
                return cellLocation;
            } catch (SecurityException e) {
                this.f8147g = e.getMessage();
            } catch (Throwable th) {
                this.f8147g = null;
                C2428b.m51299a(th, "CgiManager", "getCellLocation");
            }
        }
        return null;
    }

    /* renamed from: s */
    private List<CellInfo> m51530s() {
        TelephonyManager telephonyManager = this.f8142b;
        if (telephonyManager != null) {
            List<CellInfo> allCellInfo = telephonyManager.getAllCellInfo();
            DebugUtils.m51285a();
            return allCellInfo;
        }
        return null;
    }

    /* renamed from: t */
    private boolean m51529t() {
        return !this.f8145e && C2432j.m51186b() - this.f8154n >= 45000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u */
    public CellLocation m51528u() {
        if (this.f8142b == null) {
            return null;
        }
        return m51531r();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"NewApi"})
    /* renamed from: v */
    public List<CellInfo> m51527v() {
        List<CellInfo> list;
        try {
            if (C2432j.m51177c() >= 18 && this.f8142b != null) {
                try {
                    list = m51530s();
                } catch (SecurityException e) {
                    e = e;
                    list = null;
                }
                try {
                    this.f8147g = null;
                } catch (SecurityException e2) {
                    e = e2;
                    this.f8147g = e.getMessage();
                    return list;
                }
                return list;
            }
            return null;
        } catch (Throwable th) {
            C2428b.m51299a(th, "Cgi", "getNewCells");
            return null;
        }
    }

    /* renamed from: h */
    public final int m51541h() {
        return m51532q() & 3;
    }

    /* renamed from: i */
    public final TelephonyManager m51540i() {
        return this.f8142b;
    }

    /* renamed from: j */
    final synchronized void m51539j() {
        this.f8147g = null;
        this.f8141a.clear();
        this.f8152l.clear();
        this.f8149i = false;
        this.f8150j = false;
    }

    /* renamed from: k */
    public final String m51538k() {
        return this.f8147g;
    }

    /* renamed from: l */
    public final String m51537l() {
        return this.f8151k;
    }

    /* renamed from: m */
    public final synchronized String m51536m() {
        if (this.f8145e) {
            m51539j();
        }
        StringBuilder sb = this.f8146f;
        if (sb == null) {
            this.f8146f = new StringBuilder();
        } else {
            sb.delete(0, sb.length());
        }
        if (m51541h() == 1) {
            for (int i = 1; i < this.f8141a.size(); i++) {
                StringBuilder sb2 = this.f8146f;
                sb2.append("#");
                sb2.append(this.f8141a.get(i).f8122b);
                StringBuilder sb3 = this.f8146f;
                sb3.append("|");
                sb3.append(this.f8141a.get(i).f8123c);
                StringBuilder sb4 = this.f8146f;
                sb4.append("|");
                sb4.append(this.f8141a.get(i).f8124d);
            }
        }
        for (int i2 = 1; i2 < this.f8152l.size(); i2++) {
            Cgi cgi = this.f8152l.get(i2);
            int i3 = cgi.f8132l;
            if (i3 != 1 && i3 != 3 && i3 != 4 && i3 != 5) {
                if (i3 == 2) {
                    StringBuilder sb5 = this.f8146f;
                    sb5.append("#");
                    sb5.append(cgi.f8132l);
                    StringBuilder sb6 = this.f8146f;
                    sb6.append("|");
                    sb6.append(cgi.f8121a);
                    StringBuilder sb7 = this.f8146f;
                    sb7.append("|");
                    sb7.append(cgi.f8128h);
                    StringBuilder sb8 = this.f8146f;
                    sb8.append("|");
                    sb8.append(cgi.f8129i);
                    StringBuilder sb9 = this.f8146f;
                    sb9.append("|");
                    sb9.append(cgi.f8130j);
                }
            }
            StringBuilder sb10 = this.f8146f;
            sb10.append("#");
            sb10.append(cgi.f8132l);
            StringBuilder sb11 = this.f8146f;
            sb11.append("|");
            sb11.append(cgi.f8121a);
            StringBuilder sb12 = this.f8146f;
            sb12.append("|");
            sb12.append(cgi.f8122b);
            StringBuilder sb13 = this.f8146f;
            sb13.append("|");
            sb13.append(cgi.f8123c);
            StringBuilder sb14 = this.f8146f;
            sb14.append("|");
            sb14.append(cgi.m51579a());
        }
        if (this.f8146f.length() > 0) {
            this.f8146f.deleteCharAt(0);
        }
        return this.f8146f.toString();
    }

    /* renamed from: n */
    public final boolean m51535n() {
        try {
            TelephonyManager telephonyManager = this.f8142b;
            if (telephonyManager != null) {
                if (!TextUtils.isEmpty(telephonyManager.getSimOperator())) {
                    return true;
                }
                if (!TextUtils.isEmpty(this.f8142b.getSimCountryIso())) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        try {
            int m51199a = C2432j.m51199a(C2432j.m51175c(this.f8148h));
            return m51199a == 0 || m51199a == 4 || m51199a == 2 || m51199a == 5 || m51199a == 3;
        } catch (Throwable unused2) {
            return false;
        }
    }

    /* renamed from: b */
    public final void m51557b() {
        boolean z = false;
        try {
            if (Build.VERSION.SDK_INT >= 31) {
                String str = this.f8148h.checkSelfPermission(C7282g.f24949g) == 0 ? "hasFineLocPerm" : "hasNoFineLocPerm";
                String str2 = this.f8148h.checkSelfPermission(C7282g.f24945c) == 0 ? "hasReadPhoneStatePerm" : "hasNoReadPhoneStatePerm";
                boolean z2 = true;
                if (!TextUtils.isEmpty(this.f8160t) && !this.f8160t.equals(str)) {
                    z = true;
                }
                if (TextUtils.isEmpty(this.f8159s) || this.f8159s.equals(str2)) {
                    z2 = z;
                }
                if (z2) {
                    DebugUtils.m51283b();
                    m51533p();
                }
            }
        } catch (Throwable unused) {
            DebugUtils.m51283b();
        }
    }

    /* renamed from: c */
    public final synchronized ArrayList<Cgi> m51552c() {
        ArrayList<Cgi> arrayList;
        arrayList = new ArrayList<>();
        ArrayList<Cgi> arrayList2 = this.f8141a;
        if (arrayList2 != null) {
            Iterator<Cgi> it = arrayList2.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().clone());
            }
        }
        return arrayList;
    }

    /* renamed from: d */
    public final synchronized ArrayList<Cgi> m51549d() {
        ArrayList<Cgi> arrayList;
        arrayList = new ArrayList<>();
        ArrayList<Cgi> arrayList2 = this.f8152l;
        if (arrayList2 != null) {
            Iterator<Cgi> it = arrayList2.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().clone());
            }
        }
        return arrayList;
    }

    /* renamed from: e */
    public final synchronized Cgi m51547e() {
        if (this.f8145e) {
            return null;
        }
        ArrayList<Cgi> arrayList = this.f8141a;
        if (arrayList.size() > 0) {
            return arrayList.get(0).clone();
        }
        return null;
    }

    /* renamed from: f */
    public final synchronized Cgi m51545f() {
        if (this.f8145e) {
            return null;
        }
        ArrayList<Cgi> arrayList = this.f8152l;
        if (arrayList.size() > 0) {
            Iterator<Cgi> it = arrayList.iterator();
            while (it.hasNext()) {
                Cgi next = it.next();
                if (next.f8134n) {
                    return next.clone();
                }
            }
            return arrayList.get(0).clone();
        }
        return null;
    }

    /* renamed from: g */
    public final int m51543g() {
        return m51532q() | (this.f8149i ? 4 : 0) | (this.f8150j ? 8 : 0);
    }

    /* renamed from: a */
    public final List<AmapCell> m51573a() {
        ArrayList arrayList = new ArrayList();
        List<CellInfo> m51530s = m51530s();
        if (m51530s != null) {
            for (CellInfo cellInfo : m51530s) {
                if (cellInfo instanceof CellInfoCdma) {
                    CellInfoCdma cellInfoCdma = (CellInfoCdma) cellInfo;
                    CellIdentityCdma cellIdentity = cellInfoCdma.getCellIdentity();
                    AmapCellCdma amapCellCdma = new AmapCellCdma(cellInfo.isRegistered(), true);
                    amapCellCdma.f4637m = cellIdentity.getLatitude();
                    amapCellCdma.f4638n = cellIdentity.getLongitude();
                    amapCellCdma.f4634j = cellIdentity.getSystemId();
                    amapCellCdma.f4635k = cellIdentity.getNetworkId();
                    amapCellCdma.f4636l = cellIdentity.getBasestationId();
                    amapCellCdma.f4628d = cellInfoCdma.getCellSignalStrength().getAsuLevel();
                    amapCellCdma.f4627c = cellInfoCdma.getCellSignalStrength().getCdmaDbm();
                    arrayList.add(amapCellCdma);
                } else if (cellInfo instanceof CellInfoGsm) {
                    CellInfoGsm cellInfoGsm = (CellInfoGsm) cellInfo;
                    CellIdentityGsm cellIdentity2 = cellInfoGsm.getCellIdentity();
                    AmapCellGsm amapCellGsm = new AmapCellGsm(cellInfo.isRegistered(), true);
                    amapCellGsm.f4625a = String.valueOf(cellIdentity2.getMcc());
                    amapCellGsm.f4626b = String.valueOf(cellIdentity2.getMnc());
                    amapCellGsm.f4639j = cellIdentity2.getLac();
                    amapCellGsm.f4640k = cellIdentity2.getCid();
                    amapCellGsm.f4627c = cellInfoGsm.getCellSignalStrength().getDbm();
                    amapCellGsm.f4628d = cellInfoGsm.getCellSignalStrength().getAsuLevel();
                    if (Build.VERSION.SDK_INT >= 24) {
                        amapCellGsm.f4642m = cellIdentity2.getArfcn();
                        amapCellGsm.f4643n = cellIdentity2.getBsic();
                    }
                    arrayList.add(amapCellGsm);
                } else if (cellInfo instanceof CellInfoLte) {
                    CellInfoLte cellInfoLte = (CellInfoLte) cellInfo;
                    CellIdentityLte cellIdentity3 = cellInfoLte.getCellIdentity();
                    AmapCellLte amapCellLte = new AmapCellLte(cellInfo.isRegistered());
                    amapCellLte.f4625a = String.valueOf(cellIdentity3.getMcc());
                    amapCellLte.f4626b = String.valueOf(cellIdentity3.getMnc());
                    amapCellLte.f4647l = cellIdentity3.getPci();
                    amapCellLte.f4628d = cellInfoLte.getCellSignalStrength().getAsuLevel();
                    amapCellLte.f4646k = cellIdentity3.getCi();
                    amapCellLte.f4645j = cellIdentity3.getTac();
                    amapCellLte.f4649n = cellInfoLte.getCellSignalStrength().getTimingAdvance();
                    amapCellLte.f4627c = cellInfoLte.getCellSignalStrength().getDbm();
                    if (Build.VERSION.SDK_INT >= 24) {
                        amapCellLte.f4648m = cellIdentity3.getEarfcn();
                    }
                    arrayList.add(amapCellLte);
                } else {
                    int i = Build.VERSION.SDK_INT;
                    if (i >= 18 && (cellInfo instanceof CellInfoWcdma)) {
                        CellInfoWcdma cellInfoWcdma = (CellInfoWcdma) cellInfo;
                        CellIdentityWcdma cellIdentity4 = cellInfoWcdma.getCellIdentity();
                        AmapCellWcdma amapCellWcdma = new AmapCellWcdma(cellInfo.isRegistered(), true);
                        amapCellWcdma.f4625a = String.valueOf(cellIdentity4.getMcc());
                        amapCellWcdma.f4626b = String.valueOf(cellIdentity4.getMnc());
                        amapCellWcdma.f4650j = cellIdentity4.getLac();
                        amapCellWcdma.f4651k = cellIdentity4.getCid();
                        amapCellWcdma.f4652l = cellIdentity4.getPsc();
                        amapCellWcdma.f4628d = cellInfoWcdma.getCellSignalStrength().getAsuLevel();
                        amapCellWcdma.f4627c = cellInfoWcdma.getCellSignalStrength().getDbm();
                        if (i >= 24) {
                            amapCellWcdma.f4653m = cellIdentity4.getUarfcn();
                        }
                        arrayList.add(amapCellWcdma);
                    }
                }
            }
        }
        return arrayList;
    }

    /* renamed from: c */
    public final void m51550c(boolean z) {
        this.f8162v = z;
    }

    /* renamed from: b */
    public final void m51554b(boolean z) {
        this.f8161u = z;
    }

    @SuppressLint({"NewApi"})
    /* renamed from: b */
    private void m51553b(boolean z, boolean z2) {
        if (!this.f8145e && this.f8142b != null && Build.VERSION.SDK_INT >= 29 && this.f8148h.getApplicationInfo().targetSdkVersion >= 29) {
            if (this.f8157q == null) {
                this.f8157q = new C2419a();
            }
            try {
                this.f8142b.requestCellInfoUpdate(ThreadPool.m53398h().m55650f(), this.f8157q);
            } catch (Throwable th) {
                C2428b.m51299a(th, "Cgi", "refreshCgi");
            }
            if (z2 || z) {
                for (int i = 0; !this.f8158r && i < 20; i++) {
                    try {
                        Thread.sleep(5L);
                    } catch (Throwable unused) {
                    }
                }
            }
        }
        this.f8150j = false;
        TelephonyManager telephonyManager = this.f8142b;
        if (telephonyManager != null) {
            String networkOperator = telephonyManager.getNetworkOperator();
            this.f8151k = networkOperator;
            if (!TextUtils.isEmpty(networkOperator)) {
                this.f8150j = true;
            }
        }
        this.f8154n = C2432j.m51186b();
    }

    /* renamed from: a */
    public final void m51558a(boolean z, boolean z2) {
        try {
            this.f8145e = C2432j.m51204a(this.f8148h);
            if (m51529t()) {
                m51553b(z, z2);
                m51565a(m51528u());
                m51560a(m51527v());
            }
            if (this.f8145e) {
                m51539j();
            }
        } catch (SecurityException e) {
            this.f8147g = e.getMessage();
        } catch (Throwable th) {
            C2428b.m51299a(th, "CgiManager", "refresh");
        }
    }

    /* renamed from: a */
    public final void m51559a(boolean z) {
        PhoneStateListener phoneStateListener;
        this.f8153m.m51604a(z);
        this.f8154n = 0L;
        synchronized (this.f8156p) {
            this.f8155o = true;
        }
        TelephonyManager telephonyManager = this.f8142b;
        if (telephonyManager != null && (phoneStateListener = this.f8143c) != null) {
            try {
                telephonyManager.listen(phoneStateListener, 0);
            } catch (Throwable th) {
                C2428b.m51299a(th, "CgiManager", "destroy");
            }
        }
        this.f8143c = null;
        this.f8144d = null;
        this.f8142b = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public synchronized void m51565a(CellLocation cellLocation) {
        String[] m51198a = C2432j.m51198a(this.f8142b);
        this.f8141a.clear();
        if (cellLocation instanceof GsmCellLocation) {
            GsmCellLocation gsmCellLocation = (GsmCellLocation) cellLocation;
            Cgi cgi = new Cgi(1, true);
            cgi.f8121a = C2432j.m51165e(m51198a[0]);
            cgi.f8122b = C2432j.m51165e(m51198a[1]);
            cgi.f8123c = gsmCellLocation.getLac();
            cgi.f8124d = gsmCellLocation.getCid();
            SignalStrength signalStrength = this.f8144d;
            if (signalStrength != null) {
                int gsmSignalStrength = signalStrength.getGsmSignalStrength();
                cgi.f8139s = gsmSignalStrength == 99 ? Integer.MAX_VALUE : m51556b(gsmSignalStrength);
            }
            cgi.f8138r = false;
            this.f8153m.m51606a((CellAgeEstimator) cgi);
            this.f8141a.add(cgi);
            return;
        }
        if (cellLocation instanceof CdmaCellLocation) {
            CdmaCellLocation cdmaCellLocation = (CdmaCellLocation) cellLocation;
            Cgi cgi2 = new Cgi(2, true);
            cgi2.f8121a = Integer.parseInt(m51198a[0]);
            cgi2.f8122b = Integer.parseInt(m51198a[1]);
            cgi2.f8126f = cdmaCellLocation.getBaseStationLatitude();
            cgi2.f8127g = cdmaCellLocation.getBaseStationLongitude();
            cgi2.f8128h = cdmaCellLocation.getSystemId();
            cgi2.f8129i = cdmaCellLocation.getNetworkId();
            cgi2.f8130j = cdmaCellLocation.getBaseStationId();
            SignalStrength signalStrength2 = this.f8144d;
            if (signalStrength2 != null) {
                cgi2.f8139s = signalStrength2.getCdmaDbm();
            }
            cgi2.f8138r = false;
            this.f8153m.m51606a((CellAgeEstimator) cgi2);
            this.f8141a.add(cgi2);
        }
    }

    /* renamed from: a */
    final synchronized void m51560a(List<CellInfo> list) {
        ArrayList<Cgi> arrayList = this.f8152l;
        if (arrayList != null) {
            arrayList.clear();
        }
        if (list != null && list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                CellInfo cellInfo = list.get(i);
                if (cellInfo != null) {
                    Cgi cgi = null;
                    boolean isRegistered = cellInfo.isRegistered();
                    if (cellInfo instanceof CellInfoCdma) {
                        cgi = m51570a((CellInfoCdma) cellInfo, isRegistered);
                    } else if (cellInfo instanceof CellInfoGsm) {
                        cgi = m51569a((CellInfoGsm) cellInfo, isRegistered);
                    } else if (cellInfo instanceof CellInfoWcdma) {
                        cgi = m51566a((CellInfoWcdma) cellInfo, isRegistered);
                    } else if (cellInfo instanceof CellInfoLte) {
                        cgi = m51568a((CellInfoLte) cellInfo, isRegistered);
                    } else if (Build.VERSION.SDK_INT >= 29 && (cellInfo instanceof CellInfoNr)) {
                        cgi = m51567a((CellInfoNr) cellInfo, isRegistered);
                    }
                    if (cgi != null) {
                        this.f8153m.m51606a((CellAgeEstimator) cgi);
                        cgi.f8133m = (short) Math.min((long) WebSocketProtocol.PAYLOAD_SHORT_MAX, this.f8153m.m51596e((CellAgeEstimator) cgi));
                        cgi.f8138r = true;
                        this.f8152l.add(cgi);
                    }
                }
            }
            this.f8149i = false;
            ArrayList<Cgi> arrayList2 = this.f8152l;
            if (arrayList2 != null && arrayList2.size() > 0) {
                this.f8149i = true;
            }
        }
    }

    @SuppressLint({"NewApi"})
    /* renamed from: a */
    private static Cgi m51569a(CellInfoGsm cellInfoGsm, boolean z) {
        if (cellInfoGsm == null || cellInfoGsm.getCellIdentity() == null) {
            return null;
        }
        CellIdentityGsm cellIdentity = cellInfoGsm.getCellIdentity();
        Cgi m51571a = m51571a(1, z, cellIdentity.getMcc(), cellIdentity.getMnc(), cellIdentity.getLac(), cellIdentity.getCid(), cellInfoGsm.getCellSignalStrength().getDbm());
        m51571a.f8135o = cellInfoGsm.getCellIdentity().getBsic();
        m51571a.f8136p = cellInfoGsm.getCellIdentity().getArfcn();
        m51571a.f8137q = cellInfoGsm.getCellSignalStrength().getTimingAdvance();
        m51571a.f8139s = cellInfoGsm.getCellSignalStrength().getDbm();
        return m51571a;
    }

    /* renamed from: a */
    private static Cgi m51566a(CellInfoWcdma cellInfoWcdma, boolean z) {
        if (cellInfoWcdma == null || cellInfoWcdma.getCellIdentity() == null) {
            return null;
        }
        CellIdentityWcdma cellIdentity = cellInfoWcdma.getCellIdentity();
        Cgi m51571a = m51571a(4, z, cellIdentity.getMcc(), cellIdentity.getMnc(), cellIdentity.getLac(), cellIdentity.getCid(), cellInfoWcdma.getCellSignalStrength().getDbm());
        m51571a.f8135o = cellIdentity.getPsc();
        m51571a.f8136p = cellInfoWcdma.getCellIdentity().getUarfcn();
        m51571a.f8139s = cellInfoWcdma.getCellSignalStrength().getDbm();
        return m51571a;
    }

    /* renamed from: a */
    private static Cgi m51568a(CellInfoLte cellInfoLte, boolean z) {
        if (cellInfoLte == null || cellInfoLte.getCellIdentity() == null) {
            return null;
        }
        CellIdentityLte cellIdentity = cellInfoLte.getCellIdentity();
        Cgi m51571a = m51571a(3, z, cellIdentity.getMcc(), cellIdentity.getMnc(), cellIdentity.getTac(), cellIdentity.getCi(), cellInfoLte.getCellSignalStrength().getDbm());
        m51571a.f8135o = cellIdentity.getPci();
        if (Build.VERSION.SDK_INT >= 24) {
            m51571a.f8136p = cellIdentity.getEarfcn();
        }
        m51571a.f8137q = cellInfoLte.getCellSignalStrength().getTimingAdvance();
        m51571a.f8139s = cellInfoLte.getCellSignalStrength().getDbm();
        return m51571a;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0073  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.autonavi.aps.amapapi.restruct.Cgi m51567a(android.telephony.CellInfoNr r14, boolean r15) {
        /*
            if (r14 == 0) goto L93
            android.telephony.CellIdentity r0 = r14.getCellIdentity()
            if (r0 != 0) goto La
            goto L93
        La:
            android.telephony.CellIdentity r0 = r14.getCellIdentity()
            android.telephony.CellIdentityNr r0 = (android.telephony.CellIdentityNr) r0
            int r1 = r0.getTac()
            r2 = 2147483647(0x7fffffff, float:NaN)
            r3 = 0
            if (r1 != r2) goto L31
            java.lang.String r2 = android.os.Build.MANUFACTURER
            java.lang.String r4 = "HUAWEI"
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L31
            java.lang.String r2 = "getHwTac"
            java.lang.Object[] r4 = new java.lang.Object[r3]     // Catch: java.lang.Throwable -> L2d
            int r1 = com.autonavi.aps.amapapi.utils.Reflect.m51258b(r0, r2, r4)     // Catch: java.lang.Throwable -> L2d
            goto L31
        L2d:
            r2 = move-exception
            r2.printStackTrace()
        L31:
            long r4 = r0.getNci()
            java.lang.String r2 = r0.getMccString()     // Catch: java.lang.Throwable -> L4a
            int r2 = java.lang.Integer.parseInt(r2)     // Catch: java.lang.Throwable -> L4a
            java.lang.String r6 = r0.getMncString()     // Catch: java.lang.Throwable -> L48
            int r3 = java.lang.Integer.parseInt(r6)     // Catch: java.lang.Throwable -> L48
            r9 = r2
            r10 = r3
            goto L51
        L48:
            r6 = move-exception
            goto L4c
        L4a:
            r6 = move-exception
            r2 = 0
        L4c:
            r6.printStackTrace()
            r9 = r2
            r10 = 0
        L51:
            android.telephony.CellSignalStrength r2 = r14.getCellSignalStrength()
            android.telephony.CellSignalStrengthNr r2 = (android.telephony.CellSignalStrengthNr) r2
            int r13 = r2.getSsRsrp()
            r7 = 5
            int r11 = r0.getTac()
            r12 = 0
            r8 = r15
            com.autonavi.aps.amapapi.restruct.d r15 = m51571a(r7, r8, r9, r10, r11, r12, r13)
            r15.f8125e = r4
            r2 = 16777215(0xffffff, float:2.3509886E-38)
            r3 = 65535(0xffff, float:9.1834E-41)
            if (r1 <= r2) goto L73
            r15.f8123c = r3
            goto L7c
        L73:
            if (r1 <= r3) goto L7a
            r15.f8123c = r3
            r15.f8137q = r1
            goto L7c
        L7a:
            r15.f8123c = r1
        L7c:
            int r1 = r0.getPci()
            r15.f8135o = r1
            int r0 = r0.getNrarfcn()
            r15.f8136p = r0
            android.telephony.CellSignalStrength r14 = r14.getCellSignalStrength()
            int r14 = r14.getDbm()
            r15.f8139s = r14
            return r15
        L93:
            r14 = 0
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.aps.amapapi.restruct.CgiManager.m51567a(android.telephony.CellInfoNr, boolean):com.autonavi.aps.amapapi.restruct.d");
    }

    /* renamed from: a */
    private Cgi m51570a(CellInfoCdma cellInfoCdma, boolean z) {
        int i;
        int i2;
        int i3;
        if (cellInfoCdma != null && cellInfoCdma.getCellIdentity() != null) {
            CellIdentityCdma cellIdentity = cellInfoCdma.getCellIdentity();
            if (cellIdentity.getSystemId() > 0 && cellIdentity.getNetworkId() >= 0 && cellIdentity.getBasestationId() >= 0) {
                CellIdentityCdma cellIdentity2 = cellInfoCdma.getCellIdentity();
                String[] m51198a = C2432j.m51198a(this.f8142b);
                try {
                    i = Integer.parseInt(m51198a[0]);
                    try {
                        i3 = Integer.parseInt(m51198a[1]);
                        i2 = i;
                    } catch (Throwable unused) {
                        i2 = i;
                        i3 = 0;
                        Cgi m51571a = m51571a(2, z, i2, i3, 0, 0, cellInfoCdma.getCellSignalStrength().getCdmaDbm());
                        m51571a.f8128h = cellIdentity2.getSystemId();
                        m51571a.f8129i = cellIdentity2.getNetworkId();
                        m51571a.f8130j = cellIdentity2.getBasestationId();
                        m51571a.f8126f = cellIdentity2.getLatitude();
                        m51571a.f8127g = cellIdentity2.getLongitude();
                        m51571a.f8139s = cellInfoCdma.getCellSignalStrength().getCdmaDbm();
                        return m51571a;
                    }
                } catch (Throwable unused2) {
                    i = 0;
                }
                Cgi m51571a2 = m51571a(2, z, i2, i3, 0, 0, cellInfoCdma.getCellSignalStrength().getCdmaDbm());
                m51571a2.f8128h = cellIdentity2.getSystemId();
                m51571a2.f8129i = cellIdentity2.getNetworkId();
                m51571a2.f8130j = cellIdentity2.getBasestationId();
                m51571a2.f8126f = cellIdentity2.getLatitude();
                m51571a2.f8127g = cellIdentity2.getLongitude();
                m51571a2.f8139s = cellInfoCdma.getCellSignalStrength().getCdmaDbm();
                return m51571a2;
            }
        }
        return null;
    }

    /* renamed from: a */
    private static Cgi m51571a(int i, boolean z, int i2, int i3, int i4, int i5, int i6) {
        Cgi cgi = new Cgi(i, z);
        cgi.f8121a = i2;
        cgi.f8122b = i3;
        cgi.f8123c = i4;
        cgi.f8124d = i5;
        cgi.f8131k = i6;
        return cgi;
    }

    /* renamed from: a */
    public final void m51564a(CollectionManager collectionManager) {
        this.f8163w = collectionManager;
    }
}

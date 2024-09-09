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
import com.amap.api.col.p0003l.ko;
import com.amap.api.col.p0003l.kp;
import com.amap.api.col.p0003l.kq;
import com.amap.api.col.p0003l.kr;
import com.amap.api.col.p0003l.ks;
import com.amap.api.col.p0003l.z7;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: CgiManager.java */
@SuppressLint({"NewApi"})
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class e {

    /* renamed from: b  reason: collision with root package name */
    TelephonyManager f11819b;

    /* renamed from: d  reason: collision with root package name */
    SignalStrength f11821d;

    /* renamed from: h  reason: collision with root package name */
    private Context f11825h;

    /* renamed from: m  reason: collision with root package name */
    private c f11830m;
    @SuppressLint({"NewApi"})

    /* renamed from: q  reason: collision with root package name */
    private TelephonyManager.CellInfoCallback f11834q;

    /* renamed from: w  reason: collision with root package name */
    private com.autonavi.aps.amapapi.c f11840w;

    /* renamed from: i  reason: collision with root package name */
    private boolean f11826i = false;

    /* renamed from: j  reason: collision with root package name */
    private boolean f11827j = false;

    /* renamed from: a  reason: collision with root package name */
    ArrayList<d> f11818a = new ArrayList<>();

    /* renamed from: k  reason: collision with root package name */
    private String f11828k = null;

    /* renamed from: l  reason: collision with root package name */
    private ArrayList<d> f11829l = new ArrayList<>();

    /* renamed from: n  reason: collision with root package name */
    private long f11831n = 0;

    /* renamed from: c  reason: collision with root package name */
    PhoneStateListener f11820c = null;

    /* renamed from: o  reason: collision with root package name */
    private boolean f11832o = false;

    /* renamed from: p  reason: collision with root package name */
    private Object f11833p = new Object();

    /* renamed from: r  reason: collision with root package name */
    private boolean f11835r = false;

    /* renamed from: e  reason: collision with root package name */
    boolean f11822e = false;

    /* renamed from: f  reason: collision with root package name */
    StringBuilder f11823f = null;

    /* renamed from: s  reason: collision with root package name */
    private String f11836s = null;

    /* renamed from: t  reason: collision with root package name */
    private String f11837t = null;

    /* renamed from: g  reason: collision with root package name */
    String f11824g = null;

    /* renamed from: u  reason: collision with root package name */
    private volatile boolean f11838u = true;

    /* renamed from: v  reason: collision with root package name */
    private volatile boolean f11839v = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: CgiManager.java */
    @SuppressLint({"NewApi"})
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public class a extends TelephonyManager.CellInfoCallback {
        a() {
        }

        @Override // android.telephony.TelephonyManager.CellInfoCallback
        public final void onCellInfo(List<CellInfo> list) {
            try {
                com.autonavi.aps.amapapi.utils.d.a();
                StringBuilder sb = new StringBuilder("noLocReqCgiEnable:");
                sb.append(e.this.f11839v);
                sb.append(" isStartLocation:");
                sb.append(e.this.f11838u);
                com.autonavi.aps.amapapi.utils.d.a();
                if ((e.this.f11839v || e.this.f11838u) && com.autonavi.aps.amapapi.utils.j.b() - e.this.f11831n >= 500) {
                    e.d(e.this);
                    e.this.a(e.this.u());
                    e.this.a(list);
                    e.this.f11831n = com.autonavi.aps.amapapi.utils.j.b();
                }
            } catch (SecurityException e4) {
                e.this.f11824g = e4.getMessage();
            } catch (Throwable th) {
                com.autonavi.aps.amapapi.utils.b.a(th, "Cgi", "cellInfo");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: CgiManager.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public class b extends PhoneStateListener {
        b() {
        }

        @Override // android.telephony.PhoneStateListener
        public final void onCellInfoChanged(List<CellInfo> list) {
            try {
                com.autonavi.aps.amapapi.utils.d.a();
                StringBuilder sb = new StringBuilder("noLocReqCgiEnable:");
                sb.append(e.this.f11839v);
                sb.append(" isStartLocation:");
                sb.append(e.this.f11838u);
                com.autonavi.aps.amapapi.utils.d.a();
                if (e.this.f11839v || e.this.f11838u) {
                    if (e.this.f11840w != null) {
                        e.this.f11840w.c();
                    }
                    if (com.autonavi.aps.amapapi.utils.j.b() - e.this.f11831n < 500) {
                        return;
                    }
                    e.this.a(e.this.u());
                    e.this.a(list);
                    e.this.f11831n = com.autonavi.aps.amapapi.utils.j.b();
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        @Override // android.telephony.PhoneStateListener
        public final void onCellLocationChanged(CellLocation cellLocation) {
            com.autonavi.aps.amapapi.utils.d.a();
            StringBuilder sb = new StringBuilder("noLocReqCgiEnable:");
            sb.append(e.this.f11839v);
            sb.append(" isStartLocation:");
            sb.append(e.this.f11838u);
            com.autonavi.aps.amapapi.utils.d.a();
            if ((e.this.f11839v || e.this.f11838u) && com.autonavi.aps.amapapi.utils.j.b() - e.this.f11831n >= 500) {
                try {
                    e.this.a(cellLocation);
                    e.this.a(e.this.v());
                    e.this.f11831n = com.autonavi.aps.amapapi.utils.j.b();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }

        @Override // android.telephony.PhoneStateListener
        public final void onDataConnectionStateChanged(int i4) {
            super.onDataConnectionStateChanged(i4);
            com.autonavi.aps.amapapi.utils.d.a();
        }

        @Override // android.telephony.PhoneStateListener
        public final void onServiceStateChanged(ServiceState serviceState) {
            try {
                com.autonavi.aps.amapapi.utils.d.a();
                StringBuilder sb = new StringBuilder("noLocReqCgiEnable:");
                sb.append(e.this.f11839v);
                sb.append(" isStartLocation:");
                sb.append(e.this.f11838u);
                com.autonavi.aps.amapapi.utils.d.a();
                if (e.this.f11839v || e.this.f11838u) {
                    int state = serviceState.getState();
                    if (state == 0) {
                        e.this.a(false, false);
                    } else if (state != 1) {
                    } else {
                        e.this.j();
                    }
                }
            } catch (Throwable unused) {
            }
        }

        @Override // android.telephony.PhoneStateListener
        public final void onSignalStrengthChanged(int i4) {
            super.onSignalStrengthChanged(i4);
            com.autonavi.aps.amapapi.utils.d.a();
        }

        @Override // android.telephony.PhoneStateListener
        public final void onSignalStrengthsChanged(SignalStrength signalStrength) {
            com.autonavi.aps.amapapi.utils.d.a();
            StringBuilder sb = new StringBuilder("noLocReqCgiEnable:");
            sb.append(e.this.f11839v);
            sb.append(" isStartLocation:");
            sb.append(e.this.f11838u);
            com.autonavi.aps.amapapi.utils.d.a();
            if (signalStrength == null) {
                return;
            }
            e eVar = e.this;
            eVar.f11821d = signalStrength;
            if (eVar.f11839v || e.this.f11838u) {
                try {
                    if (e.this.f11840w != null) {
                        e.this.f11840w.c();
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    public e(Context context, Handler handler) {
        this.f11819b = null;
        this.f11830m = null;
        this.f11825h = context;
        if (this.f11819b == null) {
            this.f11819b = (TelephonyManager) com.autonavi.aps.amapapi.utils.j.a(context, "phone");
        }
        o();
        c cVar = new c(context, "cellAge", handler);
        this.f11830m = cVar;
        cVar.a();
    }

    public static boolean a(int i4) {
        return i4 > 0 && i4 <= 15;
    }

    private static int b(int i4) {
        return (i4 * 2) - 113;
    }

    static /* synthetic */ boolean d(e eVar) {
        eVar.f11835r = true;
        return true;
    }

    private void o() {
        if (this.f11819b == null) {
            return;
        }
        p();
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0036 A[Catch: Exception -> 0x007a, TryCatch #0 {Exception -> 0x007a, blocks: (B:2:0x0000, B:4:0x0004, B:5:0x000b, B:8:0x001b, B:10:0x0023, B:15:0x0036, B:19:0x0045, B:25:0x0053, B:26:0x0055, B:30:0x005f, B:34:0x0065, B:36:0x0070, B:38:0x0074, B:35:0x006b, B:11:0x0029, B:12:0x002f), top: B:43:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x006b A[Catch: Exception -> 0x007a, TryCatch #0 {Exception -> 0x007a, blocks: (B:2:0x0000, B:4:0x0004, B:5:0x000b, B:8:0x001b, B:10:0x0023, B:15:0x0036, B:19:0x0045, B:25:0x0053, B:26:0x0055, B:30:0x005f, B:34:0x0065, B:36:0x0070, B:38:0x0074, B:35:0x006b, B:11:0x0029, B:12:0x002f), top: B:43:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0074 A[Catch: Exception -> 0x007a, TRY_LEAVE, TryCatch #0 {Exception -> 0x007a, blocks: (B:2:0x0000, B:4:0x0004, B:5:0x000b, B:8:0x001b, B:10:0x0023, B:15:0x0036, B:19:0x0045, B:25:0x0053, B:26:0x0055, B:30:0x005f, B:34:0x0065, B:36:0x0070, B:38:0x0074, B:35:0x006b, B:11:0x0029, B:12:0x002f), top: B:43:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void p() {
        /*
            r8 = this;
            android.telephony.PhoneStateListener r0 = r8.f11820c     // Catch: java.lang.Exception -> L7a
            if (r0 != 0) goto Lb
            com.autonavi.aps.amapapi.restruct.e$b r0 = new com.autonavi.aps.amapapi.restruct.e$b     // Catch: java.lang.Exception -> L7a
            r0.<init>()     // Catch: java.lang.Exception -> L7a
            r8.f11820c = r0     // Catch: java.lang.Exception -> L7a
        Lb:
            r0 = 320(0x140, float:4.48E-43)
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Exception -> L7a
            java.lang.String r2 = "hasFineLocPerm"
            java.lang.String r3 = "hasNoFineLocPerm"
            java.lang.String r4 = "android.permission.ACCESS_FINE_LOCATION"
            r5 = 336(0x150, float:4.71E-43)
            r6 = 31
            if (r1 < r6) goto L2f
            android.content.Context r7 = r8.f11825h     // Catch: java.lang.Exception -> L7a
            int r7 = r7.checkSelfPermission(r4)     // Catch: java.lang.Exception -> L7a
            if (r7 != 0) goto L29
            r8.f11837t = r2     // Catch: java.lang.Exception -> L7a
            com.autonavi.aps.amapapi.utils.d.b()     // Catch: java.lang.Exception -> L7a
            goto L32
        L29:
            r8.f11837t = r3     // Catch: java.lang.Exception -> L7a
            com.autonavi.aps.amapapi.utils.d.b()     // Catch: java.lang.Exception -> L7a
            goto L34
        L2f:
            com.autonavi.aps.amapapi.utils.d.b()     // Catch: java.lang.Exception -> L7a
        L32:
            r0 = 336(0x150, float:4.71E-43)
        L34:
            if (r1 < r6) goto L6b
            android.content.Context r1 = r8.f11825h     // Catch: java.lang.Exception -> L7a
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
            android.content.Context r7 = r8.f11825h     // Catch: java.lang.Exception -> L7a
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
            com.autonavi.aps.amapapi.utils.d.b()     // Catch: java.lang.Exception -> L7a
            if (r1 == 0) goto L5d
            java.lang.String r1 = "hasReadPhoneStatePerm"
            goto L5f
        L5d:
            java.lang.String r1 = "hasNoReadPhoneStatePerm"
        L5f:
            r8.f11836s = r1     // Catch: java.lang.Exception -> L7a
            if (r5 == 0) goto L64
            goto L65
        L64:
            r2 = r3
        L65:
            r8.f11837t = r2     // Catch: java.lang.Exception -> L7a
            com.autonavi.aps.amapapi.utils.d.b()     // Catch: java.lang.Exception -> L7a
            goto L70
        L6b:
            com.autonavi.aps.amapapi.utils.d.b()     // Catch: java.lang.Exception -> L7a
            r0 = r0 | 1024(0x400, float:1.435E-42)
        L70:
            android.telephony.PhoneStateListener r1 = r8.f11820c     // Catch: java.lang.Exception -> L7a
            if (r1 == 0) goto L79
            android.telephony.TelephonyManager r2 = r8.f11819b     // Catch: java.lang.Exception -> L7a
            r2.listen(r1, r0)     // Catch: java.lang.Exception -> L7a
        L79:
            return
        L7a:
            r0 = move-exception
            r0.printStackTrace()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.aps.amapapi.restruct.e.p():void");
    }

    private int q() {
        d e4 = e();
        if (e4 != null) {
            return e4.f11809l;
        }
        return 0;
    }

    private CellLocation r() {
        TelephonyManager telephonyManager = this.f11819b;
        if (telephonyManager != null) {
            try {
                CellLocation cellLocation = telephonyManager.getCellLocation();
                com.autonavi.aps.amapapi.utils.d.a();
                this.f11824g = null;
                return cellLocation;
            } catch (SecurityException e4) {
                this.f11824g = e4.getMessage();
            } catch (Throwable th) {
                this.f11824g = null;
                com.autonavi.aps.amapapi.utils.b.a(th, "CgiManager", "getCellLocation");
            }
        }
        return null;
    }

    private List<CellInfo> s() {
        TelephonyManager telephonyManager = this.f11819b;
        if (telephonyManager != null) {
            List<CellInfo> allCellInfo = telephonyManager.getAllCellInfo();
            com.autonavi.aps.amapapi.utils.d.a();
            return allCellInfo;
        }
        return null;
    }

    private boolean t() {
        return !this.f11822e && com.autonavi.aps.amapapi.utils.j.b() - this.f11831n >= 45000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public CellLocation u() {
        if (this.f11819b == null) {
            return null;
        }
        return r();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"NewApi"})
    public List<CellInfo> v() {
        List<CellInfo> list;
        try {
            if (com.autonavi.aps.amapapi.utils.j.c() >= 18 && this.f11819b != null) {
                try {
                    list = s();
                } catch (SecurityException e4) {
                    e = e4;
                    list = null;
                }
                try {
                    this.f11824g = null;
                } catch (SecurityException e5) {
                    e = e5;
                    this.f11824g = e.getMessage();
                    return list;
                }
                return list;
            }
            return null;
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "Cgi", "getNewCells");
            return null;
        }
    }

    public final int h() {
        return q() & 3;
    }

    public final TelephonyManager i() {
        return this.f11819b;
    }

    final synchronized void j() {
        this.f11824g = null;
        this.f11818a.clear();
        this.f11829l.clear();
        this.f11826i = false;
        this.f11827j = false;
    }

    public final String k() {
        return this.f11824g;
    }

    public final String l() {
        return this.f11828k;
    }

    public final synchronized String m() {
        if (this.f11822e) {
            j();
        }
        StringBuilder sb = this.f11823f;
        if (sb == null) {
            this.f11823f = new StringBuilder();
        } else {
            sb.delete(0, sb.length());
        }
        if (h() == 1) {
            for (int i4 = 1; i4 < this.f11818a.size(); i4++) {
                StringBuilder sb2 = this.f11823f;
                sb2.append("#");
                sb2.append(this.f11818a.get(i4).f11799b);
                StringBuilder sb3 = this.f11823f;
                sb3.append("|");
                sb3.append(this.f11818a.get(i4).f11800c);
                StringBuilder sb4 = this.f11823f;
                sb4.append("|");
                sb4.append(this.f11818a.get(i4).f11801d);
            }
        }
        for (int i5 = 1; i5 < this.f11829l.size(); i5++) {
            d dVar = this.f11829l.get(i5);
            int i6 = dVar.f11809l;
            if (i6 != 1 && i6 != 3 && i6 != 4 && i6 != 5) {
                if (i6 == 2) {
                    StringBuilder sb5 = this.f11823f;
                    sb5.append("#");
                    sb5.append(dVar.f11809l);
                    StringBuilder sb6 = this.f11823f;
                    sb6.append("|");
                    sb6.append(dVar.f11798a);
                    StringBuilder sb7 = this.f11823f;
                    sb7.append("|");
                    sb7.append(dVar.f11805h);
                    StringBuilder sb8 = this.f11823f;
                    sb8.append("|");
                    sb8.append(dVar.f11806i);
                    StringBuilder sb9 = this.f11823f;
                    sb9.append("|");
                    sb9.append(dVar.f11807j);
                }
            }
            StringBuilder sb10 = this.f11823f;
            sb10.append("#");
            sb10.append(dVar.f11809l);
            StringBuilder sb11 = this.f11823f;
            sb11.append("|");
            sb11.append(dVar.f11798a);
            StringBuilder sb12 = this.f11823f;
            sb12.append("|");
            sb12.append(dVar.f11799b);
            StringBuilder sb13 = this.f11823f;
            sb13.append("|");
            sb13.append(dVar.f11800c);
            StringBuilder sb14 = this.f11823f;
            sb14.append("|");
            sb14.append(dVar.a());
        }
        if (this.f11823f.length() > 0) {
            this.f11823f.deleteCharAt(0);
        }
        return this.f11823f.toString();
    }

    public final boolean n() {
        try {
            TelephonyManager telephonyManager = this.f11819b;
            if (telephonyManager != null) {
                if (!TextUtils.isEmpty(telephonyManager.getSimOperator())) {
                    return true;
                }
                if (!TextUtils.isEmpty(this.f11819b.getSimCountryIso())) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        try {
            int a4 = com.autonavi.aps.amapapi.utils.j.a(com.autonavi.aps.amapapi.utils.j.c(this.f11825h));
            return a4 == 0 || a4 == 4 || a4 == 2 || a4 == 5 || a4 == 3;
        } catch (Throwable unused2) {
            return false;
        }
    }

    public final void b() {
        boolean z3 = false;
        try {
            if (Build.VERSION.SDK_INT >= 31) {
                String str = this.f11825h.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0 ? "hasFineLocPerm" : "hasNoFineLocPerm";
                String str2 = this.f11825h.checkSelfPermission("android.permission.READ_PHONE_STATE") == 0 ? "hasReadPhoneStatePerm" : "hasNoReadPhoneStatePerm";
                boolean z4 = true;
                if (!TextUtils.isEmpty(this.f11837t) && !this.f11837t.equals(str)) {
                    z3 = true;
                }
                if (TextUtils.isEmpty(this.f11836s) || this.f11836s.equals(str2)) {
                    z4 = z3;
                }
                if (z4) {
                    com.autonavi.aps.amapapi.utils.d.b();
                    p();
                }
            }
        } catch (Throwable unused) {
            com.autonavi.aps.amapapi.utils.d.b();
        }
    }

    public final synchronized ArrayList<d> c() {
        ArrayList<d> arrayList;
        arrayList = new ArrayList<>();
        ArrayList<d> arrayList2 = this.f11818a;
        if (arrayList2 != null) {
            Iterator<d> it = arrayList2.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().clone());
            }
        }
        return arrayList;
    }

    public final synchronized ArrayList<d> d() {
        ArrayList<d> arrayList;
        arrayList = new ArrayList<>();
        ArrayList<d> arrayList2 = this.f11829l;
        if (arrayList2 != null) {
            Iterator<d> it = arrayList2.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().clone());
            }
        }
        return arrayList;
    }

    public final synchronized d e() {
        if (this.f11822e) {
            return null;
        }
        ArrayList<d> arrayList = this.f11818a;
        if (arrayList.size() > 0) {
            return arrayList.get(0).clone();
        }
        return null;
    }

    public final synchronized d f() {
        if (this.f11822e) {
            return null;
        }
        ArrayList<d> arrayList = this.f11829l;
        if (arrayList.size() > 0) {
            Iterator<d> it = arrayList.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next.f11811n) {
                    return next.clone();
                }
            }
            return arrayList.get(0).clone();
        }
        return null;
    }

    public final int g() {
        return q() | (this.f11826i ? 4 : 0) | (this.f11827j ? 8 : 0);
    }

    public final List<ko> a() {
        ArrayList arrayList = new ArrayList();
        List<CellInfo> s3 = s();
        if (s3 != null) {
            for (CellInfo cellInfo : s3) {
                if (cellInfo instanceof CellInfoCdma) {
                    CellInfoCdma cellInfoCdma = (CellInfoCdma) cellInfo;
                    CellIdentityCdma cellIdentity = cellInfoCdma.getCellIdentity();
                    kp kpVar = new kp(cellInfo.isRegistered(), true);
                    kpVar.f8273m = cellIdentity.getLatitude();
                    kpVar.f8274n = cellIdentity.getLongitude();
                    kpVar.f8270j = cellIdentity.getSystemId();
                    kpVar.f8271k = cellIdentity.getNetworkId();
                    kpVar.f8272l = cellIdentity.getBasestationId();
                    kpVar.f8264d = cellInfoCdma.getCellSignalStrength().getAsuLevel();
                    kpVar.f8263c = cellInfoCdma.getCellSignalStrength().getCdmaDbm();
                    arrayList.add(kpVar);
                } else if (cellInfo instanceof CellInfoGsm) {
                    CellInfoGsm cellInfoGsm = (CellInfoGsm) cellInfo;
                    CellIdentityGsm cellIdentity2 = cellInfoGsm.getCellIdentity();
                    kq kqVar = new kq(cellInfo.isRegistered(), true);
                    kqVar.f8261a = String.valueOf(cellIdentity2.getMcc());
                    kqVar.f8262b = String.valueOf(cellIdentity2.getMnc());
                    kqVar.f8275j = cellIdentity2.getLac();
                    kqVar.f8276k = cellIdentity2.getCid();
                    kqVar.f8263c = cellInfoGsm.getCellSignalStrength().getDbm();
                    kqVar.f8264d = cellInfoGsm.getCellSignalStrength().getAsuLevel();
                    if (Build.VERSION.SDK_INT >= 24) {
                        kqVar.f8278m = cellIdentity2.getArfcn();
                        kqVar.f8279n = cellIdentity2.getBsic();
                    }
                    arrayList.add(kqVar);
                } else if (cellInfo instanceof CellInfoLte) {
                    CellInfoLte cellInfoLte = (CellInfoLte) cellInfo;
                    CellIdentityLte cellIdentity3 = cellInfoLte.getCellIdentity();
                    kr krVar = new kr(cellInfo.isRegistered());
                    krVar.f8261a = String.valueOf(cellIdentity3.getMcc());
                    krVar.f8262b = String.valueOf(cellIdentity3.getMnc());
                    krVar.f8283l = cellIdentity3.getPci();
                    krVar.f8264d = cellInfoLte.getCellSignalStrength().getAsuLevel();
                    krVar.f8282k = cellIdentity3.getCi();
                    krVar.f8281j = cellIdentity3.getTac();
                    krVar.f8285n = cellInfoLte.getCellSignalStrength().getTimingAdvance();
                    krVar.f8263c = cellInfoLte.getCellSignalStrength().getDbm();
                    if (Build.VERSION.SDK_INT >= 24) {
                        krVar.f8284m = cellIdentity3.getEarfcn();
                    }
                    arrayList.add(krVar);
                } else {
                    int i4 = Build.VERSION.SDK_INT;
                    if (i4 >= 18 && (cellInfo instanceof CellInfoWcdma)) {
                        CellInfoWcdma cellInfoWcdma = (CellInfoWcdma) cellInfo;
                        CellIdentityWcdma cellIdentity4 = cellInfoWcdma.getCellIdentity();
                        ks ksVar = new ks(cellInfo.isRegistered(), true);
                        ksVar.f8261a = String.valueOf(cellIdentity4.getMcc());
                        ksVar.f8262b = String.valueOf(cellIdentity4.getMnc());
                        ksVar.f8286j = cellIdentity4.getLac();
                        ksVar.f8287k = cellIdentity4.getCid();
                        ksVar.f8288l = cellIdentity4.getPsc();
                        ksVar.f8264d = cellInfoWcdma.getCellSignalStrength().getAsuLevel();
                        ksVar.f8263c = cellInfoWcdma.getCellSignalStrength().getDbm();
                        if (i4 >= 24) {
                            ksVar.f8289m = cellIdentity4.getUarfcn();
                        }
                        arrayList.add(ksVar);
                    }
                }
            }
        }
        return arrayList;
    }

    public final void c(boolean z3) {
        this.f11839v = z3;
    }

    public final void b(boolean z3) {
        this.f11838u = z3;
    }

    @SuppressLint({"NewApi"})
    private void b(boolean z3, boolean z4) {
        if (!this.f11822e && this.f11819b != null && Build.VERSION.SDK_INT >= 29 && this.f11825h.getApplicationInfo().targetSdkVersion >= 29) {
            if (this.f11834q == null) {
                this.f11834q = new a();
            }
            try {
                this.f11819b.requestCellInfoUpdate(z7.h().f(), this.f11834q);
            } catch (Throwable th) {
                com.autonavi.aps.amapapi.utils.b.a(th, "Cgi", "refreshCgi");
            }
            if (z4 || z3) {
                for (int i4 = 0; !this.f11835r && i4 < 20; i4++) {
                    try {
                        Thread.sleep(5L);
                    } catch (Throwable unused) {
                    }
                }
            }
        }
        this.f11827j = false;
        TelephonyManager telephonyManager = this.f11819b;
        if (telephonyManager != null) {
            String networkOperator = telephonyManager.getNetworkOperator();
            this.f11828k = networkOperator;
            if (!TextUtils.isEmpty(networkOperator)) {
                this.f11827j = true;
            }
        }
        this.f11831n = com.autonavi.aps.amapapi.utils.j.b();
    }

    public final void a(boolean z3, boolean z4) {
        try {
            this.f11822e = com.autonavi.aps.amapapi.utils.j.a(this.f11825h);
            if (t()) {
                b(z3, z4);
                a(u());
                a(v());
            }
            if (this.f11822e) {
                j();
            }
        } catch (SecurityException e4) {
            this.f11824g = e4.getMessage();
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "CgiManager", "refresh");
        }
    }

    public final void a(boolean z3) {
        PhoneStateListener phoneStateListener;
        this.f11830m.a(z3);
        this.f11831n = 0L;
        synchronized (this.f11833p) {
            this.f11832o = true;
        }
        TelephonyManager telephonyManager = this.f11819b;
        if (telephonyManager != null && (phoneStateListener = this.f11820c) != null) {
            try {
                telephonyManager.listen(phoneStateListener, 0);
            } catch (Throwable th) {
                com.autonavi.aps.amapapi.utils.b.a(th, "CgiManager", "destroy");
            }
        }
        this.f11820c = null;
        this.f11821d = null;
        this.f11819b = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(CellLocation cellLocation) {
        String[] a4 = com.autonavi.aps.amapapi.utils.j.a(this.f11819b);
        this.f11818a.clear();
        if (cellLocation instanceof GsmCellLocation) {
            GsmCellLocation gsmCellLocation = (GsmCellLocation) cellLocation;
            d dVar = new d(1, true);
            dVar.f11798a = com.autonavi.aps.amapapi.utils.j.e(a4[0]);
            dVar.f11799b = com.autonavi.aps.amapapi.utils.j.e(a4[1]);
            dVar.f11800c = gsmCellLocation.getLac();
            dVar.f11801d = gsmCellLocation.getCid();
            SignalStrength signalStrength = this.f11821d;
            if (signalStrength != null) {
                int gsmSignalStrength = signalStrength.getGsmSignalStrength();
                dVar.f11816s = gsmSignalStrength == 99 ? Integer.MAX_VALUE : b(gsmSignalStrength);
            }
            dVar.f11815r = false;
            this.f11830m.a((c) dVar);
            this.f11818a.add(dVar);
            return;
        }
        if (cellLocation instanceof CdmaCellLocation) {
            CdmaCellLocation cdmaCellLocation = (CdmaCellLocation) cellLocation;
            d dVar2 = new d(2, true);
            dVar2.f11798a = Integer.parseInt(a4[0]);
            dVar2.f11799b = Integer.parseInt(a4[1]);
            dVar2.f11803f = cdmaCellLocation.getBaseStationLatitude();
            dVar2.f11804g = cdmaCellLocation.getBaseStationLongitude();
            dVar2.f11805h = cdmaCellLocation.getSystemId();
            dVar2.f11806i = cdmaCellLocation.getNetworkId();
            dVar2.f11807j = cdmaCellLocation.getBaseStationId();
            SignalStrength signalStrength2 = this.f11821d;
            if (signalStrength2 != null) {
                dVar2.f11816s = signalStrength2.getCdmaDbm();
            }
            dVar2.f11815r = false;
            this.f11830m.a((c) dVar2);
            this.f11818a.add(dVar2);
        }
    }

    final synchronized void a(List<CellInfo> list) {
        ArrayList<d> arrayList = this.f11829l;
        if (arrayList != null) {
            arrayList.clear();
        }
        if (list != null && list.size() > 0) {
            for (int i4 = 0; i4 < list.size(); i4++) {
                CellInfo cellInfo = list.get(i4);
                if (cellInfo != null) {
                    d dVar = null;
                    boolean isRegistered = cellInfo.isRegistered();
                    if (cellInfo instanceof CellInfoCdma) {
                        dVar = a((CellInfoCdma) cellInfo, isRegistered);
                    } else if (cellInfo instanceof CellInfoGsm) {
                        dVar = a((CellInfoGsm) cellInfo, isRegistered);
                    } else if (cellInfo instanceof CellInfoWcdma) {
                        dVar = a((CellInfoWcdma) cellInfo, isRegistered);
                    } else if (cellInfo instanceof CellInfoLte) {
                        dVar = a((CellInfoLte) cellInfo, isRegistered);
                    } else if (Build.VERSION.SDK_INT >= 29 && (cellInfo instanceof CellInfoNr)) {
                        dVar = a((CellInfoNr) cellInfo, isRegistered);
                    }
                    if (dVar != null) {
                        this.f11830m.a((c) dVar);
                        dVar.f11810m = (short) Math.min(65535L, this.f11830m.e((c) dVar));
                        dVar.f11815r = true;
                        this.f11829l.add(dVar);
                    }
                }
            }
            this.f11826i = false;
            ArrayList<d> arrayList2 = this.f11829l;
            if (arrayList2 != null && arrayList2.size() > 0) {
                this.f11826i = true;
            }
        }
    }

    @SuppressLint({"NewApi"})
    private static d a(CellInfoGsm cellInfoGsm, boolean z3) {
        if (cellInfoGsm == null || cellInfoGsm.getCellIdentity() == null) {
            return null;
        }
        CellIdentityGsm cellIdentity = cellInfoGsm.getCellIdentity();
        d a4 = a(1, z3, cellIdentity.getMcc(), cellIdentity.getMnc(), cellIdentity.getLac(), cellIdentity.getCid(), cellInfoGsm.getCellSignalStrength().getDbm());
        a4.f11812o = cellInfoGsm.getCellIdentity().getBsic();
        a4.f11813p = cellInfoGsm.getCellIdentity().getArfcn();
        a4.f11814q = cellInfoGsm.getCellSignalStrength().getTimingAdvance();
        a4.f11816s = cellInfoGsm.getCellSignalStrength().getDbm();
        return a4;
    }

    private static d a(CellInfoWcdma cellInfoWcdma, boolean z3) {
        if (cellInfoWcdma == null || cellInfoWcdma.getCellIdentity() == null) {
            return null;
        }
        CellIdentityWcdma cellIdentity = cellInfoWcdma.getCellIdentity();
        d a4 = a(4, z3, cellIdentity.getMcc(), cellIdentity.getMnc(), cellIdentity.getLac(), cellIdentity.getCid(), cellInfoWcdma.getCellSignalStrength().getDbm());
        a4.f11812o = cellIdentity.getPsc();
        a4.f11813p = cellInfoWcdma.getCellIdentity().getUarfcn();
        a4.f11816s = cellInfoWcdma.getCellSignalStrength().getDbm();
        return a4;
    }

    private static d a(CellInfoLte cellInfoLte, boolean z3) {
        if (cellInfoLte == null || cellInfoLte.getCellIdentity() == null) {
            return null;
        }
        CellIdentityLte cellIdentity = cellInfoLte.getCellIdentity();
        d a4 = a(3, z3, cellIdentity.getMcc(), cellIdentity.getMnc(), cellIdentity.getTac(), cellIdentity.getCi(), cellInfoLte.getCellSignalStrength().getDbm());
        a4.f11812o = cellIdentity.getPci();
        if (Build.VERSION.SDK_INT >= 24) {
            a4.f11813p = cellIdentity.getEarfcn();
        }
        a4.f11814q = cellInfoLte.getCellSignalStrength().getTimingAdvance();
        a4.f11816s = cellInfoLte.getCellSignalStrength().getDbm();
        return a4;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0073  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.autonavi.aps.amapapi.restruct.d a(android.telephony.CellInfoNr r14, boolean r15) {
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
            int r1 = com.autonavi.aps.amapapi.utils.f.b(r0, r2, r4)     // Catch: java.lang.Throwable -> L2d
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
            com.autonavi.aps.amapapi.restruct.d r15 = a(r7, r8, r9, r10, r11, r12, r13)
            r15.f11802e = r4
            r2 = 16777215(0xffffff, float:2.3509886E-38)
            r3 = 65535(0xffff, float:9.1834E-41)
            if (r1 <= r2) goto L73
            r15.f11800c = r3
            goto L7c
        L73:
            if (r1 <= r3) goto L7a
            r15.f11800c = r3
            r15.f11814q = r1
            goto L7c
        L7a:
            r15.f11800c = r1
        L7c:
            int r1 = r0.getPci()
            r15.f11812o = r1
            int r0 = r0.getNrarfcn()
            r15.f11813p = r0
            android.telephony.CellSignalStrength r14 = r14.getCellSignalStrength()
            int r14 = r14.getDbm()
            r15.f11816s = r14
            return r15
        L93:
            r14 = 0
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.aps.amapapi.restruct.e.a(android.telephony.CellInfoNr, boolean):com.autonavi.aps.amapapi.restruct.d");
    }

    private d a(CellInfoCdma cellInfoCdma, boolean z3) {
        int i4;
        int i5;
        int i6;
        if (cellInfoCdma != null && cellInfoCdma.getCellIdentity() != null) {
            CellIdentityCdma cellIdentity = cellInfoCdma.getCellIdentity();
            if (cellIdentity.getSystemId() > 0 && cellIdentity.getNetworkId() >= 0 && cellIdentity.getBasestationId() >= 0) {
                CellIdentityCdma cellIdentity2 = cellInfoCdma.getCellIdentity();
                String[] a4 = com.autonavi.aps.amapapi.utils.j.a(this.f11819b);
                try {
                    i4 = Integer.parseInt(a4[0]);
                    try {
                        i6 = Integer.parseInt(a4[1]);
                        i5 = i4;
                    } catch (Throwable unused) {
                        i5 = i4;
                        i6 = 0;
                        d a5 = a(2, z3, i5, i6, 0, 0, cellInfoCdma.getCellSignalStrength().getCdmaDbm());
                        a5.f11805h = cellIdentity2.getSystemId();
                        a5.f11806i = cellIdentity2.getNetworkId();
                        a5.f11807j = cellIdentity2.getBasestationId();
                        a5.f11803f = cellIdentity2.getLatitude();
                        a5.f11804g = cellIdentity2.getLongitude();
                        a5.f11816s = cellInfoCdma.getCellSignalStrength().getCdmaDbm();
                        return a5;
                    }
                } catch (Throwable unused2) {
                    i4 = 0;
                }
                d a52 = a(2, z3, i5, i6, 0, 0, cellInfoCdma.getCellSignalStrength().getCdmaDbm());
                a52.f11805h = cellIdentity2.getSystemId();
                a52.f11806i = cellIdentity2.getNetworkId();
                a52.f11807j = cellIdentity2.getBasestationId();
                a52.f11803f = cellIdentity2.getLatitude();
                a52.f11804g = cellIdentity2.getLongitude();
                a52.f11816s = cellInfoCdma.getCellSignalStrength().getCdmaDbm();
                return a52;
            }
        }
        return null;
    }

    private static d a(int i4, boolean z3, int i5, int i6, int i7, int i8, int i9) {
        d dVar = new d(i4, z3);
        dVar.f11798a = i5;
        dVar.f11799b = i6;
        dVar.f11800c = i7;
        dVar.f11801d = i8;
        dVar.f11808k = i9;
        return dVar;
    }

    public final void a(com.autonavi.aps.amapapi.c cVar) {
        this.f11840w = cVar;
    }
}

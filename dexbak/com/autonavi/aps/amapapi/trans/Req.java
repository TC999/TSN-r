package com.autonavi.aps.amapapi.trans;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.amap.api.col.p0463l.AmapWifi;
import com.amap.api.col.p0463l.C1780e4;
import com.amap.api.col.p0463l.DeviceInfo;
import com.autonavi.aps.amapapi.restruct.Cgi;
import com.autonavi.aps.amapapi.restruct.CgiManager;
import com.autonavi.aps.amapapi.restruct.HistoryLocation;
import com.autonavi.aps.amapapi.restruct.HistoryLocationRecorder;
import com.autonavi.aps.amapapi.restruct.WifiInfoWrapper;
import com.autonavi.aps.amapapi.restruct.WifiManagerWrapper;
import com.autonavi.aps.amapapi.utils.C2428b;
import com.autonavi.aps.amapapi.utils.C2432j;
import com.baidu.idl.face.platform.FaceEnvironment;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

@SuppressLint({"NewApi"})
/* renamed from: com.autonavi.aps.amapapi.trans.f */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class Req {

    /* renamed from: I */
    protected static String f8278I;

    /* renamed from: K */
    protected static String f8279K;

    /* renamed from: a */
    public String f8298a = "1";

    /* renamed from: b */
    protected short f8299b = 0;

    /* renamed from: c */
    protected String f8300c = null;

    /* renamed from: d */
    protected String f8301d = null;

    /* renamed from: e */
    protected String f8302e = null;

    /* renamed from: f */
    protected String f8303f = null;

    /* renamed from: g */
    protected String f8304g = null;

    /* renamed from: h */
    public String f8305h = null;

    /* renamed from: i */
    public String f8306i = null;

    /* renamed from: j */
    protected String f8307j = null;

    /* renamed from: k */
    protected String f8308k = null;

    /* renamed from: l */
    protected String f8309l = null;

    /* renamed from: m */
    protected String f8310m = null;

    /* renamed from: n */
    protected String f8311n = null;

    /* renamed from: o */
    protected String f8312o = null;

    /* renamed from: p */
    protected String f8313p = null;

    /* renamed from: q */
    protected String f8314q = null;

    /* renamed from: r */
    protected String f8315r = null;

    /* renamed from: s */
    protected String f8316s = null;

    /* renamed from: t */
    protected String f8317t = null;

    /* renamed from: u */
    protected String f8318u = null;

    /* renamed from: v */
    protected String f8319v = null;

    /* renamed from: w */
    protected String f8320w = null;

    /* renamed from: x */
    protected String f8321x = null;

    /* renamed from: y */
    protected String f8322y = null;

    /* renamed from: z */
    protected int f8323z = 0;

    /* renamed from: A */
    protected ArrayList<Cgi> f8280A = new ArrayList<>();

    /* renamed from: B */
    protected ArrayList<Cgi> f8281B = new ArrayList<>();

    /* renamed from: C */
    protected String f8282C = null;

    /* renamed from: D */
    protected String f8283D = null;

    /* renamed from: E */
    protected ArrayList<AmapWifi> f8284E = new ArrayList<>();

    /* renamed from: F */
    protected String f8285F = null;

    /* renamed from: G */
    protected String f8286G = null;

    /* renamed from: H */
    protected byte[] f8287H = null;

    /* renamed from: Q */
    private byte[] f8294Q = null;

    /* renamed from: R */
    private int f8295R = 0;

    /* renamed from: J */
    protected String f8288J = null;

    /* renamed from: L */
    protected String f8289L = null;

    /* renamed from: M */
    protected String f8290M = null;

    /* renamed from: N */
    protected String f8291N = null;

    /* renamed from: O */
    protected int f8292O = 0;

    /* renamed from: S */
    private List<HistoryLocation> f8296S = null;

    /* renamed from: T */
    private List<Cgi> f8297T = Collections.synchronizedList(new ArrayList());

    /* renamed from: P */
    final int f8293P = 3;

    /* renamed from: b */
    private void m51350b() {
        String[] strArr = new String[27];
        strArr[0] = this.f8298a;
        strArr[1] = this.f8300c;
        strArr[2] = this.f8301d;
        strArr[3] = this.f8302e;
        strArr[4] = this.f8303f;
        strArr[5] = this.f8304g;
        strArr[6] = this.f8305h;
        strArr[7] = this.f8306i;
        strArr[8] = this.f8309l;
        strArr[9] = this.f8310m;
        strArr[10] = this.f8311n;
        strArr[11] = this.f8312o;
        strArr[12] = this.f8313p;
        strArr[13] = this.f8314q;
        strArr[14] = this.f8315r;
        strArr[15] = this.f8316s;
        strArr[16] = this.f8317t;
        strArr[17] = this.f8318u;
        strArr[18] = this.f8319v;
        strArr[19] = this.f8320w;
        strArr[20] = this.f8321x;
        strArr[21] = this.f8283D;
        strArr[22] = this.f8285F;
        strArr[23] = this.f8286G;
        strArr[24] = f8278I;
        strArr[25] = this.f8290M;
        strArr[26] = this.f8291N;
        for (int i = 0; i < 27; i++) {
            if (TextUtils.isEmpty(strArr[i])) {
                strArr[i] = "";
            }
        }
        if (TextUtils.isEmpty(this.f8307j)) {
            this.f8307j = "0";
        } else if (!"0".equals(this.f8307j) && !"2".equals(this.f8307j)) {
            this.f8307j = "0";
        }
        if (TextUtils.isEmpty(this.f8308k)) {
            this.f8308k = "0";
        } else if (!"0".equals(this.f8308k) && !"1".equals(this.f8308k)) {
            this.f8308k = "0";
        }
        if (TextUtils.isEmpty(this.f8322y)) {
            this.f8322y = "0";
        } else if (!"1".equals(this.f8322y) && !"2".equals(this.f8322y)) {
            this.f8322y = "0";
        }
        if (!CgiManager.m51572a(this.f8323z)) {
            this.f8323z = 0;
        }
        if (this.f8287H == null) {
            this.f8287H = new byte[0];
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(19:12|13|14|(17:276|(1:278)(1:380)|279|(7:281|(1:283)(1:357)|284|(1:286)(1:356)|287|(1:289)(1:355)|290)(12:(11:359|(1:361)(1:379)|362|(1:364)(1:378)|365|(1:367)(1:377)|368|(1:370)(1:376)|371|(1:373)(1:375)|374)|292|(1:294)(1:354)|(1:296)|297|(1:299)(1:352)|300|(1:302)|303|(1:305)|306|(2:308|(2:310|311)(3:312|(11:314|(1:316)(1:347)|317|(1:319)(1:346)|320|(1:322)(1:345)|323|(1:325)|326|(2:341|342)(8:328|(1:330)(1:340)|331|(1:333)|334|(1:336)|337|338)|339)|348))(2:349|(2:351|311)))|291|292|(0)(0)|(0)|296|297|(0)(0)|300|(0)|303|(0)|306|(0)(0))(1:17)|18|(13:22|23|24|25|(1:272)(4:28|(6:30|(3:85|(1:87)|88)(1:(3:36|(1:38)|39)(2:78|(3:80|(1:82)|83)(1:84)))|40|(1:42)|43|(3:64|(1:75)(5:66|(1:68)|(1:70)|71|(3:73|59|60)(1:74))|61)(3:49|(6:53|(1:55)|(1:57)|58|59|60)|61))|89|90)|91|(1:271)(14:95|96|97|98|99|(1:101)|102|103|104|(5:266|(1:268)|107|(2:109|110)|112)|106|107|(0)|112)|113|(1:115)(7:234|(1:236)(1:265)|(1:238)|239|(10:241|242|243|244|245|(1:247)(2:258|(1:260))|248|(1:257)|(2:253|254)(1:256)|255)|263|264)|116|117|118|(28:120|121|122|123|124|(1:126)|127|128|(3:218|219|220)|130|131|132|133|134|135|136|137|(1:139)(1:213)|140|(1:142)|143|(5:145|(1:147)(1:185)|148|(5:151|152|(9:155|(2:162|(6:164|(1:166)|167|168|169|170)(4:171|(3:173|(1:175)|176)|169|170))|177|(1:179)|180|168|169|170|153)|181|182)|150)|186|(4:188|(1:190)(1:206)|191|(3:193|(6:196|(1:198)|199|(2:201|202)(1:204)|203|194)|205))|207|(1:209)|210|211)(3:225|(1:227)|(29:229|230|121|122|123|124|(0)|127|128|(0)|130|131|132|133|134|135|136|137|(0)(0)|140|(0)|143|(0)|186|(0)|207|(0)|210|211)(28:231|232|122|123|124|(0)|127|128|(0)|130|131|132|133|134|135|136|137|(0)(0)|140|(0)|143|(0)|186|(0)|207|(0)|210|211)))|275|25|(0)|272|91|(1:93)|271|113|(0)(0)|116|117|118|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:271:0x06d5, code lost:
        r7[r9] = 0;
     */
    /* JADX WARN: Removed duplicated region for block: B:124:0x031c  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x035e A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:203:0x0541  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x05b9 A[Catch: all -> 0x05c9, TRY_LEAVE, TryCatch #7 {all -> 0x05c9, blocks: (B:207:0x054f, B:216:0x0588, B:222:0x059a, B:224:0x05b9, B:209:0x0565, B:212:0x0572), top: B:373:0x054f }] */
    /* JADX WARN: Removed duplicated region for block: B:232:0x0601  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x0607  */
    /* JADX WARN: Removed duplicated region for block: B:263:0x06b4 A[Catch: all -> 0x06d5, TryCatch #3 {all -> 0x06d5, blocks: (B:261:0x06b0, B:263:0x06b4, B:264:0x06b7, B:268:0x06c3, B:269:0x06c7), top: B:367:0x06b0 }] */
    /* JADX WARN: Removed duplicated region for block: B:264:0x06b7 A[Catch: all -> 0x06d5, TryCatch #3 {all -> 0x06d5, blocks: (B:261:0x06b0, B:263:0x06b4, B:264:0x06b7, B:268:0x06c3, B:269:0x06c7), top: B:367:0x06b0 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:277:0x06e8 A[Catch: all -> 0x0709, TryCatch #6 {all -> 0x0709, blocks: (B:275:0x06e0, B:277:0x06e8, B:278:0x06f2), top: B:371:0x06e0 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:291:0x0721  */
    /* JADX WARN: Removed duplicated region for block: B:292:0x0723  */
    /* JADX WARN: Removed duplicated region for block: B:295:0x0732  */
    /* JADX WARN: Removed duplicated region for block: B:298:0x074c  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:338:0x0842  */
    /* JADX WARN: Removed duplicated region for block: B:356:0x08ec  */
    /* JADX WARN: Removed duplicated region for block: B:369:0x06fa A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0205  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0210  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0215 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0224  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0237  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0242  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0247  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0255  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final byte[] m51356a() {
        /*
            Method dump skipped, instructions count: 2335
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.aps.amapapi.trans.Req.m51356a():byte[]");
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x000d, code lost:
        if (r0.length != 6) goto L3;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private byte[] m51353a(java.lang.String r7) {
        /*
            r6 = this;
            java.lang.String r0 = ":"
            java.lang.String[] r0 = r7.split(r0)
            r1 = 6
            byte[] r2 = new byte[r1]
            r3 = 0
            if (r0 == 0) goto Lf
            int r4 = r0.length     // Catch: java.lang.Throwable -> L3e
            if (r4 == r1) goto L1b
        Lf:
            java.lang.String[] r0 = new java.lang.String[r1]     // Catch: java.lang.Throwable -> L3e
            r4 = 0
        L12:
            if (r4 >= r1) goto L1b
            java.lang.String r5 = "0"
            r0[r4] = r5     // Catch: java.lang.Throwable -> L3e
            int r4 = r4 + 1
            goto L12
        L1b:
            r1 = 0
        L1c:
            int r4 = r0.length     // Catch: java.lang.Throwable -> L3e
            if (r1 >= r4) goto L50
            r4 = r0[r1]     // Catch: java.lang.Throwable -> L3e
            int r4 = r4.length()     // Catch: java.lang.Throwable -> L3e
            r5 = 2
            if (r4 <= r5) goto L30
            r4 = r0[r1]     // Catch: java.lang.Throwable -> L3e
            java.lang.String r4 = r4.substring(r3, r5)     // Catch: java.lang.Throwable -> L3e
            r0[r1] = r4     // Catch: java.lang.Throwable -> L3e
        L30:
            r4 = r0[r1]     // Catch: java.lang.Throwable -> L3e
            r5 = 16
            int r4 = java.lang.Integer.parseInt(r4, r5)     // Catch: java.lang.Throwable -> L3e
            byte r4 = (byte) r4     // Catch: java.lang.Throwable -> L3e
            r2[r1] = r4     // Catch: java.lang.Throwable -> L3e
            int r1 = r1 + 1
            goto L1c
        L3e:
            r0 = move-exception
            java.lang.String r1 = "getMacBa "
            java.lang.String r7 = r1.concat(r7)
            java.lang.String r1 = "Req"
            com.autonavi.aps.amapapi.utils.C2428b.m51299a(r0, r1, r7)
            java.lang.String r7 = "00:00:00:00:00:00"
            byte[] r2 = r6.m51353a(r7)
        L50:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.aps.amapapi.trans.Req.m51353a(java.lang.String):byte[]");
    }

    /* renamed from: a */
    public final void m51355a(Context context, boolean z, boolean z2, CgiManager cgiManager, WifiManagerWrapper wifiManagerWrapper, ConnectivityManager connectivityManager, String str, HistoryLocationRecorder historyLocationRecorder) {
        String str2;
        String str3;
        String str4;
        NetworkInfo networkInfo;
        String str5;
        String str6;
        ArrayList<AmapWifi> arrayList;
        int i;
        String m55240j = C1780e4.m55240j(context);
        int m51171d = C2432j.m51171d();
        this.f8288J = str;
        this.f8296S = null;
        if (z2) {
            str2 = "api_serverSDK_130905";
            str3 = "S128DF1572465B890OE3F7A13167KLEI";
        } else {
            str2 = "UC_nlp_20131029";
            str3 = "BKZCHMBBSSUK7U8GLUKHBB56CCFF78U";
        }
        String str7 = str3;
        String str8 = str2;
        StringBuilder sb = new StringBuilder();
        int m51543g = cgiManager.m51543g();
        int m51541h = cgiManager.m51541h();
        TelephonyManager m51540i = cgiManager.m51540i();
        ArrayList<Cgi> m51552c = cgiManager.m51552c();
        ArrayList<Cgi> m51549d = cgiManager.m51549d();
        ArrayList<AmapWifi> m51479e = wifiManagerWrapper.m51479e();
        String str9 = m51541h == 2 ? "1" : "0";
        if (m51540i != null) {
            if (TextUtils.isEmpty(C2428b.f8373g)) {
                try {
                    C2428b.f8373g = DeviceInfo.m54806P();
                } catch (Throwable th) {
                    C2428b.m51299a(th, "Aps", "getApsReq part4");
                }
            }
            str4 = "1";
            if (TextUtils.isEmpty(C2428b.f8373g) && Build.VERSION.SDK_INT < 29) {
                C2428b.f8373g = "888888888888888";
            }
            if (TextUtils.isEmpty(C2428b.f8374h)) {
                try {
                    C2428b.f8374h = DeviceInfo.m54801U();
                } catch (SecurityException unused) {
                } catch (Throwable th2) {
                    C2428b.m51299a(th2, "Aps", "getApsReq part2");
                }
            }
            if (TextUtils.isEmpty(C2428b.f8374h) && Build.VERSION.SDK_INT < 29) {
                C2428b.f8374h = "888888888888888";
            }
        } else {
            str4 = "1";
        }
        try {
            networkInfo = connectivityManager.getActiveNetworkInfo();
        } catch (Throwable th3) {
            C2428b.m51299a(th3, "Aps", "getApsReq part");
            networkInfo = null;
        }
        boolean m51490a = wifiManagerWrapper.m51490a(connectivityManager);
        if (C2432j.m51199a(networkInfo) != -1) {
            str5 = C2432j.m51200a(connectivityManager);
            str6 = m51490a ? "2" : str4;
        } else {
            str5 = "";
            str6 = str5;
        }
        if ((m51543g & 4) == 4 && !m51549d.isEmpty()) {
            this.f8281B.clear();
            this.f8281B.addAll(m51549d);
        } else {
            this.f8281B.clear();
        }
        this.f8280A.clear();
        this.f8280A.addAll(m51552c);
        StringBuilder sb2 = new StringBuilder();
        if (wifiManagerWrapper.m51473k()) {
            if (m51490a) {
                WifiInfoWrapper m51471m = wifiManagerWrapper.m51471m();
                if (wifiManagerWrapper.m51488a(m51471m)) {
                    sb2.append(m51471m.m51498a());
                    sb2.append(",");
                    int m51496c = m51471m.m51496c();
                    if (m51496c < -128 || m51496c > 127) {
                        m51496c = 0;
                    }
                    sb2.append(m51496c);
                    sb2.append(",");
                    String m51497b = m51471m.m51497b();
                    try {
                        i = m51497b.getBytes("UTF-8").length;
                    } catch (Exception unused2) {
                        i = 32;
                    }
                    if (i >= 32) {
                        m51497b = "unkwn";
                    }
                    sb2.append(m51497b.replace("*", "."));
                }
            }
            if (m51479e != null && (arrayList = this.f8284E) != null) {
                arrayList.clear();
                this.f8284E.addAll(m51479e);
            }
        } else {
            wifiManagerWrapper.m51477g();
            ArrayList<AmapWifi> arrayList2 = this.f8284E;
            if (arrayList2 != null) {
                arrayList2.clear();
            }
        }
        this.f8299b = (short) 0;
        if (!z) {
            this.f8299b = (short) (2 | 0);
        }
        this.f8300c = str8;
        this.f8301d = str7;
        this.f8303f = Build.MODEL;
        this.f8304g = FaceEnvironment.f8430OS + Build.VERSION.RELEASE;
        this.f8305h = C2432j.m51183b(context);
        this.f8306i = str9;
        this.f8307j = "0";
        this.f8308k = "0";
        this.f8309l = "0";
        this.f8310m = "0";
        this.f8311n = "0";
        this.f8312o = m55240j;
        this.f8313p = C2428b.f8373g;
        this.f8314q = C2428b.f8374h;
        this.f8316s = String.valueOf(m51171d);
        this.f8317t = C2432j.m51158i(context);
        this.f8319v = "6.4.3";
        this.f8320w = null;
        this.f8318u = "";
        this.f8321x = str5;
        this.f8322y = str6;
        this.f8323z = m51543g;
        this.f8282C = cgiManager.m51537l();
        this.f8285F = WifiManagerWrapper.m51468p();
        this.f8283D = sb2.toString();
        this.f8292O = (int) ((C2432j.m51186b() - wifiManagerWrapper.m51467q()) / 1000);
        try {
            if (TextUtils.isEmpty(f8278I)) {
                f8278I = DeviceInfo.m54816F(context);
            }
        } catch (Throwable unused3) {
        }
        try {
            if (TextUtils.isEmpty(f8279K)) {
                f8279K = DeviceInfo.m54769o(context);
            }
        } catch (Throwable unused4) {
        }
        try {
            if (TextUtils.isEmpty(this.f8290M)) {
                this.f8290M = DeviceInfo.m54817E();
            }
        } catch (Throwable unused5) {
        }
        try {
            if (TextUtils.isEmpty(this.f8291N)) {
                this.f8291N = DeviceInfo.m54818D(context);
            }
        } catch (Throwable unused6) {
        }
        try {
            this.f8296S = historyLocationRecorder.m51521a(this.f8281B, this.f8284E);
            m51351a(this.f8280A, this.f8281B);
        } catch (Throwable th4) {
            th4.printStackTrace();
        }
        sb.delete(0, sb.length());
        sb2.delete(0, sb2.length());
    }

    /* renamed from: a */
    private void m51351a(ArrayList<Cgi> arrayList, ArrayList<Cgi> arrayList2) {
        if (arrayList2 != null && arrayList2.size() > 0) {
            Iterator<Cgi> it = arrayList2.iterator();
            while (it.hasNext()) {
                Cgi next = it.next();
                if (next.f8138r && next.f8134n) {
                    m51354a(next, this.f8297T);
                    return;
                }
            }
        }
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        m51354a(arrayList.get(0), this.f8297T);
    }

    /* renamed from: a */
    private static void m51354a(Cgi cgi, List<Cgi> list) {
        if (cgi == null || list == null) {
            return;
        }
        int size = list.size();
        if (size == 0) {
            list.add(cgi);
            return;
        }
        long j = Long.MAX_VALUE;
        int i = 0;
        int i2 = -1;
        int i3 = -1;
        while (true) {
            if (i >= size) {
                i2 = i3;
                break;
            }
            Cgi cgi2 = list.get(i);
            if (cgi.m51577c() != null && cgi.m51577c().equals(cgi2.m51577c())) {
                int i4 = cgi.f8139s;
                if (i4 != cgi2.f8139s) {
                    cgi2.f8140t = cgi.f8140t;
                    cgi2.f8139s = i4;
                }
            } else {
                j = Math.min(j, cgi2.f8140t);
                if (j == cgi2.f8140t) {
                    i3 = i;
                }
                i++;
            }
        }
        if (i2 >= 0) {
            if (size < 3) {
                list.add(cgi);
            } else if (cgi.f8140t <= j || i2 >= size) {
            } else {
                list.remove(i2);
                list.add(cgi);
            }
        }
    }

    /* renamed from: a */
    private static int m51352a(String str, byte[] bArr, int i) {
        try {
        } catch (Throwable th) {
            C2428b.m51299a(th, "Req", "copyContentWithByteLen");
            bArr[i] = 0;
        }
        if (TextUtils.isEmpty(str)) {
            bArr[i] = 0;
            return i + 1;
        }
        byte[] bytes = str.getBytes("GBK");
        int length = bytes.length;
        if (length > 127) {
            length = 127;
        }
        bArr[i] = (byte) length;
        int i2 = i + 1;
        System.arraycopy(bytes, 0, bArr, i2, length);
        return i2 + length;
    }
}

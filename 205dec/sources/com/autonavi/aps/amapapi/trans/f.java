package com.autonavi.aps.amapapi.trans;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.amap.api.col.p0003l.e4;
import com.amap.api.col.p0003l.i4;
import com.amap.api.col.p0003l.k9;
import com.autonavi.aps.amapapi.restruct.g;
import com.autonavi.aps.amapapi.restruct.k;
import com.autonavi.aps.amapapi.utils.j;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: Req.java */
@SuppressLint({"NewApi"})
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class f {
    protected static String I;
    protected static String K;

    /* renamed from: a  reason: collision with root package name */
    public String f11951a = "1";

    /* renamed from: b  reason: collision with root package name */
    protected short f11952b = 0;

    /* renamed from: c  reason: collision with root package name */
    protected String f11953c = null;

    /* renamed from: d  reason: collision with root package name */
    protected String f11954d = null;

    /* renamed from: e  reason: collision with root package name */
    protected String f11955e = null;

    /* renamed from: f  reason: collision with root package name */
    protected String f11956f = null;

    /* renamed from: g  reason: collision with root package name */
    protected String f11957g = null;

    /* renamed from: h  reason: collision with root package name */
    public String f11958h = null;

    /* renamed from: i  reason: collision with root package name */
    public String f11959i = null;

    /* renamed from: j  reason: collision with root package name */
    protected String f11960j = null;

    /* renamed from: k  reason: collision with root package name */
    protected String f11961k = null;

    /* renamed from: l  reason: collision with root package name */
    protected String f11962l = null;

    /* renamed from: m  reason: collision with root package name */
    protected String f11963m = null;

    /* renamed from: n  reason: collision with root package name */
    protected String f11964n = null;

    /* renamed from: o  reason: collision with root package name */
    protected String f11965o = null;

    /* renamed from: p  reason: collision with root package name */
    protected String f11966p = null;

    /* renamed from: q  reason: collision with root package name */
    protected String f11967q = null;

    /* renamed from: r  reason: collision with root package name */
    protected String f11968r = null;

    /* renamed from: s  reason: collision with root package name */
    protected String f11969s = null;

    /* renamed from: t  reason: collision with root package name */
    protected String f11970t = null;

    /* renamed from: u  reason: collision with root package name */
    protected String f11971u = null;

    /* renamed from: v  reason: collision with root package name */
    protected String f11972v = null;

    /* renamed from: w  reason: collision with root package name */
    protected String f11973w = null;

    /* renamed from: x  reason: collision with root package name */
    protected String f11974x = null;

    /* renamed from: y  reason: collision with root package name */
    protected String f11975y = null;

    /* renamed from: z  reason: collision with root package name */
    protected int f11976z = 0;
    protected ArrayList<com.autonavi.aps.amapapi.restruct.d> A = new ArrayList<>();
    protected ArrayList<com.autonavi.aps.amapapi.restruct.d> B = new ArrayList<>();
    protected String C = null;
    protected String D = null;
    protected ArrayList<k9> E = new ArrayList<>();
    protected String F = null;
    protected String G = null;
    protected byte[] H = null;
    private byte[] Q = null;
    private int R = 0;
    protected String J = null;

    /* renamed from: L  reason: collision with root package name */
    protected String f11950L = null;
    protected String M = null;
    protected String N = null;
    protected int O = 0;
    private List<com.autonavi.aps.amapapi.restruct.f> S = null;
    private List<com.autonavi.aps.amapapi.restruct.d> T = Collections.synchronizedList(new ArrayList());
    final int P = 3;

    private void b() {
        String[] strArr = new String[27];
        strArr[0] = this.f11951a;
        strArr[1] = this.f11953c;
        strArr[2] = this.f11954d;
        strArr[3] = this.f11955e;
        strArr[4] = this.f11956f;
        strArr[5] = this.f11957g;
        strArr[6] = this.f11958h;
        strArr[7] = this.f11959i;
        strArr[8] = this.f11962l;
        strArr[9] = this.f11963m;
        strArr[10] = this.f11964n;
        strArr[11] = this.f11965o;
        strArr[12] = this.f11966p;
        strArr[13] = this.f11967q;
        strArr[14] = this.f11968r;
        strArr[15] = this.f11969s;
        strArr[16] = this.f11970t;
        strArr[17] = this.f11971u;
        strArr[18] = this.f11972v;
        strArr[19] = this.f11973w;
        strArr[20] = this.f11974x;
        strArr[21] = this.D;
        strArr[22] = this.F;
        strArr[23] = this.G;
        strArr[24] = I;
        strArr[25] = this.M;
        strArr[26] = this.N;
        for (int i4 = 0; i4 < 27; i4++) {
            if (TextUtils.isEmpty(strArr[i4])) {
                strArr[i4] = "";
            }
        }
        if (TextUtils.isEmpty(this.f11960j)) {
            this.f11960j = "0";
        } else if (!"0".equals(this.f11960j) && !"2".equals(this.f11960j)) {
            this.f11960j = "0";
        }
        if (TextUtils.isEmpty(this.f11961k)) {
            this.f11961k = "0";
        } else if (!"0".equals(this.f11961k) && !"1".equals(this.f11961k)) {
            this.f11961k = "0";
        }
        if (TextUtils.isEmpty(this.f11975y)) {
            this.f11975y = "0";
        } else if (!"1".equals(this.f11975y) && !"2".equals(this.f11975y)) {
            this.f11975y = "0";
        }
        if (!com.autonavi.aps.amapapi.restruct.e.a(this.f11976z)) {
            this.f11976z = 0;
        }
        if (this.H == null) {
            this.H = new byte[0];
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
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final byte[] a() {
        /*
            Method dump skipped, instructions count: 2335
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.aps.amapapi.trans.f.a():byte[]");
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x000d, code lost:
        if (r0.length != 6) goto L3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private byte[] a(java.lang.String r7) {
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
            com.autonavi.aps.amapapi.utils.b.a(r0, r1, r7)
            java.lang.String r7 = "00:00:00:00:00:00"
            byte[] r2 = r6.a(r7)
        L50:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.aps.amapapi.trans.f.a(java.lang.String):byte[]");
    }

    public final void a(Context context, boolean z3, boolean z4, com.autonavi.aps.amapapi.restruct.e eVar, k kVar, ConnectivityManager connectivityManager, String str, g gVar) {
        String str2;
        String str3;
        String str4;
        NetworkInfo networkInfo;
        String str5;
        String str6;
        ArrayList<k9> arrayList;
        int i4;
        String j4 = e4.j(context);
        int d4 = j.d();
        this.J = str;
        this.S = null;
        if (z4) {
            str2 = "api_serverSDK_130905";
            str3 = "S128DF1572465B890OE3F7A13167KLEI";
        } else {
            str2 = "UC_nlp_20131029";
            str3 = "BKZCHMBBSSUK7U8GLUKHBB56CCFF78U";
        }
        String str7 = str3;
        String str8 = str2;
        StringBuilder sb = new StringBuilder();
        int g4 = eVar.g();
        int h4 = eVar.h();
        TelephonyManager i5 = eVar.i();
        ArrayList<com.autonavi.aps.amapapi.restruct.d> c4 = eVar.c();
        ArrayList<com.autonavi.aps.amapapi.restruct.d> d5 = eVar.d();
        ArrayList<k9> e4 = kVar.e();
        String str9 = h4 == 2 ? "1" : "0";
        if (i5 != null) {
            if (TextUtils.isEmpty(com.autonavi.aps.amapapi.utils.b.f12011g)) {
                try {
                    com.autonavi.aps.amapapi.utils.b.f12011g = i4.P();
                } catch (Throwable th) {
                    com.autonavi.aps.amapapi.utils.b.a(th, "Aps", "getApsReq part4");
                }
            }
            str4 = "1";
            if (TextUtils.isEmpty(com.autonavi.aps.amapapi.utils.b.f12011g) && Build.VERSION.SDK_INT < 29) {
                com.autonavi.aps.amapapi.utils.b.f12011g = "888888888888888";
            }
            if (TextUtils.isEmpty(com.autonavi.aps.amapapi.utils.b.f12012h)) {
                try {
                    com.autonavi.aps.amapapi.utils.b.f12012h = i4.U();
                } catch (SecurityException unused) {
                } catch (Throwable th2) {
                    com.autonavi.aps.amapapi.utils.b.a(th2, "Aps", "getApsReq part2");
                }
            }
            if (TextUtils.isEmpty(com.autonavi.aps.amapapi.utils.b.f12012h) && Build.VERSION.SDK_INT < 29) {
                com.autonavi.aps.amapapi.utils.b.f12012h = "888888888888888";
            }
        } else {
            str4 = "1";
        }
        try {
            networkInfo = connectivityManager.getActiveNetworkInfo();
        } catch (Throwable th3) {
            com.autonavi.aps.amapapi.utils.b.a(th3, "Aps", "getApsReq part");
            networkInfo = null;
        }
        boolean a4 = kVar.a(connectivityManager);
        if (j.a(networkInfo) != -1) {
            str5 = j.a(connectivityManager);
            str6 = a4 ? "2" : str4;
        } else {
            str5 = "";
            str6 = str5;
        }
        if ((g4 & 4) == 4 && !d5.isEmpty()) {
            this.B.clear();
            this.B.addAll(d5);
        } else {
            this.B.clear();
        }
        this.A.clear();
        this.A.addAll(c4);
        StringBuilder sb2 = new StringBuilder();
        if (kVar.k()) {
            if (a4) {
                com.autonavi.aps.amapapi.restruct.j m4 = kVar.m();
                if (kVar.a(m4)) {
                    sb2.append(m4.a());
                    sb2.append(",");
                    int c5 = m4.c();
                    if (c5 < -128 || c5 > 127) {
                        c5 = 0;
                    }
                    sb2.append(c5);
                    sb2.append(",");
                    String b4 = m4.b();
                    try {
                        i4 = b4.getBytes("UTF-8").length;
                    } catch (Exception unused2) {
                        i4 = 32;
                    }
                    if (i4 >= 32) {
                        b4 = "unkwn";
                    }
                    sb2.append(b4.replace("*", "."));
                }
            }
            if (e4 != null && (arrayList = this.E) != null) {
                arrayList.clear();
                this.E.addAll(e4);
            }
        } else {
            kVar.g();
            ArrayList<k9> arrayList2 = this.E;
            if (arrayList2 != null) {
                arrayList2.clear();
            }
        }
        this.f11952b = (short) 0;
        if (!z3) {
            this.f11952b = (short) (2 | 0);
        }
        this.f11953c = str8;
        this.f11954d = str7;
        this.f11956f = Build.MODEL;
        this.f11957g = "android" + Build.VERSION.RELEASE;
        this.f11958h = j.b(context);
        this.f11959i = str9;
        this.f11960j = "0";
        this.f11961k = "0";
        this.f11962l = "0";
        this.f11963m = "0";
        this.f11964n = "0";
        this.f11965o = j4;
        this.f11966p = com.autonavi.aps.amapapi.utils.b.f12011g;
        this.f11967q = com.autonavi.aps.amapapi.utils.b.f12012h;
        this.f11969s = String.valueOf(d4);
        this.f11970t = j.i(context);
        this.f11972v = "6.4.3";
        this.f11973w = null;
        this.f11971u = "";
        this.f11974x = str5;
        this.f11975y = str6;
        this.f11976z = g4;
        this.C = eVar.l();
        this.F = k.p();
        this.D = sb2.toString();
        this.O = (int) ((j.b() - kVar.q()) / 1000);
        try {
            if (TextUtils.isEmpty(I)) {
                I = i4.F(context);
            }
        } catch (Throwable unused3) {
        }
        try {
            if (TextUtils.isEmpty(K)) {
                K = i4.o(context);
            }
        } catch (Throwable unused4) {
        }
        try {
            if (TextUtils.isEmpty(this.M)) {
                this.M = i4.E();
            }
        } catch (Throwable unused5) {
        }
        try {
            if (TextUtils.isEmpty(this.N)) {
                this.N = i4.D(context);
            }
        } catch (Throwable unused6) {
        }
        try {
            this.S = gVar.a(this.B, this.E);
            a(this.A, this.B);
        } catch (Throwable th4) {
            th4.printStackTrace();
        }
        sb.delete(0, sb.length());
        sb2.delete(0, sb2.length());
    }

    private void a(ArrayList<com.autonavi.aps.amapapi.restruct.d> arrayList, ArrayList<com.autonavi.aps.amapapi.restruct.d> arrayList2) {
        if (arrayList2 != null && arrayList2.size() > 0) {
            Iterator<com.autonavi.aps.amapapi.restruct.d> it = arrayList2.iterator();
            while (it.hasNext()) {
                com.autonavi.aps.amapapi.restruct.d next = it.next();
                if (next.f11815r && next.f11811n) {
                    a(next, this.T);
                    return;
                }
            }
        }
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        a(arrayList.get(0), this.T);
    }

    private static void a(com.autonavi.aps.amapapi.restruct.d dVar, List<com.autonavi.aps.amapapi.restruct.d> list) {
        if (dVar == null || list == null) {
            return;
        }
        int size = list.size();
        if (size == 0) {
            list.add(dVar);
            return;
        }
        long j4 = Long.MAX_VALUE;
        int i4 = 0;
        int i5 = -1;
        int i6 = -1;
        while (true) {
            if (i4 >= size) {
                i5 = i6;
                break;
            }
            com.autonavi.aps.amapapi.restruct.d dVar2 = list.get(i4);
            if (dVar.c() != null && dVar.c().equals(dVar2.c())) {
                int i7 = dVar.f11816s;
                if (i7 != dVar2.f11816s) {
                    dVar2.f11817t = dVar.f11817t;
                    dVar2.f11816s = i7;
                }
            } else {
                j4 = Math.min(j4, dVar2.f11817t);
                if (j4 == dVar2.f11817t) {
                    i6 = i4;
                }
                i4++;
            }
        }
        if (i5 >= 0) {
            if (size < 3) {
                list.add(dVar);
            } else if (dVar.f11817t <= j4 || i5 >= size) {
            } else {
                list.remove(i5);
                list.add(dVar);
            }
        }
    }

    private static int a(String str, byte[] bArr, int i4) {
        try {
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "Req", "copyContentWithByteLen");
            bArr[i4] = 0;
        }
        if (TextUtils.isEmpty(str)) {
            bArr[i4] = 0;
            return i4 + 1;
        }
        byte[] bytes = str.getBytes("GBK");
        int length = bytes.length;
        if (length > 127) {
            length = 127;
        }
        bArr[i4] = (byte) length;
        int i5 = i4 + 1;
        System.arraycopy(bytes, 0, bArr, i5, length);
        return i5 + length;
    }
}

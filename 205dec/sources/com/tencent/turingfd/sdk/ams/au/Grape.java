package com.tencent.turingfd.sdk.ams.au;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class Grape {

    /* renamed from: g  reason: collision with root package name */
    public static final Grape f52082g = new Grape();

    /* renamed from: h  reason: collision with root package name */
    public static final Set<Integer> f52083h;

    /* renamed from: d  reason: collision with root package name */
    public Cumquat f52087d;

    /* renamed from: e  reason: collision with root package name */
    public Ginkgo f52088e;

    /* renamed from: a  reason: collision with root package name */
    public final Set<Integer> f52084a = new HashSet();

    /* renamed from: b  reason: collision with root package name */
    public final Set<Integer> f52085b = new HashSet();

    /* renamed from: c  reason: collision with root package name */
    public final Object f52086c = new Object();

    /* renamed from: f  reason: collision with root package name */
    public final CanisMinor f52089f = new Cdo(this);

    /* compiled from: A */
    /* renamed from: com.tencent.turingfd.sdk.ams.au.Grape$do  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class Cdo implements CanisMinor {
        public Cdo(Grape grape) {
        }
    }

    static {
        HashSet hashSet = new HashSet();
        hashSet.add(2);
        hashSet.add(6);
        hashSet.add(3);
        hashSet.add(32);
        hashSet.add(5);
        hashSet.add(4);
        hashSet.add(40);
        hashSet.add(43);
        hashSet.add(19);
        hashSet.add(36);
        hashSet.add(10001);
        hashSet.add(45);
        hashSet.add(136);
        hashSet.add(143);
        hashSet.add(144);
        hashSet.add(10002);
        hashSet.add(10003);
        int i4 = Betelnut.f51924a;
        if (i4 == 105668) {
            hashSet.add(18);
        } else if (i4 == 105928) {
            hashSet.add(18);
        } else if (i4 == 108168) {
            hashSet.add(18);
        }
        f52083h = Collections.unmodifiableSet(hashSet);
    }

    public long a(Context context) {
        long currentTimeMillis;
        long j4 = 0;
        if (Gooseberry.f52078f.e()) {
            return 0L;
        }
        try {
            long currentTimeMillis2 = System.currentTimeMillis();
            b(context);
            currentTimeMillis = System.currentTimeMillis() - currentTimeMillis2;
        } catch (Throwable unused) {
        }
        try {
            b();
            return currentTimeMillis;
        } catch (Throwable unused2) {
            j4 = currentTimeMillis;
            return j4;
        }
    }

    public final void b() {
        Map<Integer, Integer> emptyMap;
        try {
            Cpackage b4 = Gooseberry.f52078f.b();
            if (b4 == null || (emptyMap = b4.f52339g) == null) {
                emptyMap = Collections.emptyMap();
            }
            HashSet hashSet = new HashSet();
            HashSet hashSet2 = new HashSet();
            for (Map.Entry<Integer, Integer> entry : emptyMap.entrySet()) {
                if (entry.getValue().intValue() == 0) {
                    hashSet.add(entry.getKey());
                } else {
                    hashSet2.add(entry.getKey());
                }
            }
            synchronized (this.f52085b) {
                this.f52085b.clear();
                this.f52085b.addAll(f52083h);
                this.f52085b.addAll(hashSet);
                this.f52085b.removeAll(hashSet2);
                synchronized (this.f52084a) {
                    this.f52085b.addAll(this.f52084a);
                }
            }
        } catch (Throwable unused) {
        }
    }

    public final byte[] a(Context context, boolean z3) {
        byte[] bArr = new byte[0];
        HashMap hashMap = new HashMap();
        StringBuilder a4 = Almond.a("");
        a4.append(Betelnut.f51924a);
        hashMap.put("1", a4.toString());
        Cumquat cumquat = this.f52087d;
        hashMap.put("101", TextUtils.isEmpty(cumquat.f51997q) ? "" : cumquat.f51997q);
        hashMap.put("2002", Gooseberry.f52078f.c());
        hashMap.put("207", Foxnut.f52052l.a(context).f52017a);
        if (z3) {
            hashMap.put("264", Cthrows.a());
        } else {
            hashMap.put("264", "PPNA");
        }
        try {
            SparseArray<Object> e89_DEE08458D4E8C7EA = TNative$aa.e89_DEE08458D4E8C7EA(new SparseArray(), context, hashMap, Damson.f52015g);
            return Norma.b(e89_DEE08458D4E8C7EA) != 0 ? bArr : Norma.a(e89_DEE08458D4E8C7EA);
        } catch (Throwable unused) {
            return bArr;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0019, code lost:
        if (r4 <= 0) goto L27;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void b(android.content.Context r11) {
        /*
            r10 = this;
            java.lang.Object r0 = r10.f52086c     // Catch: java.lang.Throwable -> L85
            monitor-enter(r0)     // Catch: java.lang.Throwable -> L85
            com.tencent.turingfd.sdk.ams.au.Ginkgo r1 = r10.f52088e     // Catch: java.lang.Throwable -> L82
            java.lang.String r2 = "501"
            long r1 = r1.a(r11, r2)     // Catch: java.lang.Throwable -> L82
            com.tencent.turingfd.sdk.ams.au.Gooseberry r3 = com.tencent.turingfd.sdk.ams.au.Gooseberry.f52078f     // Catch: java.lang.Throwable -> L82
            com.tencent.turingfd.sdk.ams.au.package r4 = r3.b()     // Catch: java.lang.Throwable -> L82
            if (r4 == 0) goto L1b
            long r4 = r4.f52340h     // Catch: java.lang.Throwable -> L82
            r6 = 0
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 > 0) goto L1e
        L1b:
            r4 = 57600(0xe100, double:2.8458E-319)
        L1e:
            long r6 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L82
            long r6 = r6 - r1
            long r1 = java.lang.Math.abs(r6)     // Catch: java.lang.Throwable -> L82
            r6 = 1000(0x3e8, double:4.94E-321)
            long r4 = r4 * r6
            int r6 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r6 > 0) goto L31
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L82
            return
        L31:
            com.tencent.turingfd.sdk.ams.au.Cumquat r1 = r10.f52087d     // Catch: java.lang.Throwable -> L82
            com.tencent.turingfd.sdk.ams.au.CanisMajor r1 = r1.c()     // Catch: java.lang.Throwable -> L82
            boolean r1 = r1.a()     // Catch: java.lang.Throwable -> L82
            byte[] r6 = r10.a(r11, r1)     // Catch: java.lang.Throwable -> L82
            int r2 = r6.length     // Catch: java.lang.Throwable -> L82
            if (r2 != 0) goto L44
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L82
            return
        L44:
            com.tencent.turingfd.sdk.ams.au.Guava r4 = com.tencent.turingfd.sdk.ams.au.Guava.f52091b     // Catch: java.lang.Throwable -> L82
            r5 = 4
            r7 = 8119(0x1fb7, float:1.1377E-41)
            r8 = 18119(0x46c7, float:2.539E-41)
            com.tencent.turingfd.sdk.ams.au.CanisMinor r9 = r10.f52089f     // Catch: java.lang.Throwable -> L82
            com.tencent.turingfd.sdk.ams.au.Herbaceous r2 = r4.a(r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L82
            byte[] r2 = r2.f52100d     // Catch: java.lang.Throwable -> L82
            com.tencent.turingfd.sdk.ams.au.package r2 = r10.a(r2)     // Catch: java.lang.Throwable -> L82
            if (r2 != 0) goto L5b
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L82
            return
        L5b:
            r3.a(r2, r1)     // Catch: java.lang.Throwable -> L82
            if (r1 == 0) goto L80
            com.tencent.turingfd.sdk.ams.au.Ginkgo r1 = r10.f52088e     // Catch: java.lang.Throwable -> L82
            r1.getClass()     // Catch: java.lang.Throwable -> L82
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L82
            r2.<init>()     // Catch: java.lang.Throwable -> L82
            java.lang.String r3 = ""
            r2.append(r3)     // Catch: java.lang.Throwable -> L82
            long r3 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L82
            r2.append(r3)     // Catch: java.lang.Throwable -> L82
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L82
            java.lang.String r3 = "501"
            r4 = 1
            r1.a(r11, r3, r2, r4)     // Catch: java.lang.Throwable -> L82
        L80:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L82
            goto L85
        L82:
            r11 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L82
            throw r11     // Catch: java.lang.Throwable -> L85
        L85:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.turingfd.sdk.ams.au.Grape.b(android.content.Context):void");
    }

    public final Cpackage a(byte[] bArr) {
        byte[] bArr2 = new byte[0];
        int i4 = Damson.f52015g;
        if (i4 == 1) {
            try {
                bArr = Norma.a(TNative$aa.f89_DEE08458D4E8C7EA(new SparseArray(), bArr, i4));
            } catch (Throwable unused) {
                return null;
            }
        } else if (i4 != 0) {
            bArr = bArr2;
        }
        try {
            Bergamot bergamot = new Bergamot();
            bergamot.a(new Cygnus(bArr));
            int i5 = bergamot.f51915c;
            if (i5 < 0) {
                return null;
            }
            if (i5 == 1) {
                return new Cpackage();
            }
            Cpackage cpackage = bergamot.f51916d;
            if (cpackage == null) {
                return new Cpackage();
            }
            Log.e("D" + Betelnut.f51924a, "s:" + cpackage.f52335c + ",v:" + cpackage.f52337e);
            for (Map.Entry<Integer, Integer> entry : cpackage.f52339g.entrySet()) {
            }
            Map<String, String> map = cpackage.f52341i;
            if (map != null) {
                for (String str : map.keySet()) {
                }
            }
            return cpackage;
        } catch (Throwable unused2) {
            return null;
        }
    }

    public boolean a(int i4) {
        boolean z3;
        synchronized (this.f52085b) {
            z3 = !this.f52085b.contains(Integer.valueOf(i4));
        }
        return z3;
    }

    public String a() {
        StringBuilder sb = new StringBuilder();
        synchronized (this.f52085b) {
            for (Integer num : this.f52085b) {
                if (sb.length() > 0) {
                    sb.append(",");
                }
                sb.append(num);
            }
        }
        return sb.toString();
    }
}

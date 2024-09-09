package com.autonavi.aps.amapapi.storage;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.amap.api.col.p0003l.j4;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import com.autonavi.aps.amapapi.restruct.d;
import com.autonavi.aps.amapapi.utils.j;
import com.bytedance.msdk.api.NetworkPlatformConst;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: Cache.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    Hashtable<String, ArrayList<C0108a>> f11893a = new Hashtable<>();

    /* renamed from: i  reason: collision with root package name */
    private long f11901i = 0;

    /* renamed from: j  reason: collision with root package name */
    private boolean f11902j = false;

    /* renamed from: k  reason: collision with root package name */
    private String f11903k = "2.0.201501131131".replace(".", "");

    /* renamed from: l  reason: collision with root package name */
    private String f11904l = null;

    /* renamed from: b  reason: collision with root package name */
    boolean f11894b = true;

    /* renamed from: c  reason: collision with root package name */
    long f11895c = 0;

    /* renamed from: d  reason: collision with root package name */
    String f11896d = null;

    /* renamed from: e  reason: collision with root package name */
    d f11897e = null;

    /* renamed from: m  reason: collision with root package name */
    private String f11905m = null;

    /* renamed from: n  reason: collision with root package name */
    private long f11906n = 0;

    /* renamed from: f  reason: collision with root package name */
    boolean f11898f = true;

    /* renamed from: g  reason: collision with root package name */
    boolean f11899g = true;

    /* renamed from: h  reason: collision with root package name */
    String f11900h = String.valueOf(AMapLocationClientOption.GeoLanguage.DEFAULT);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: Cache.java */
    /* renamed from: com.autonavi.aps.amapapi.storage.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class C0108a {

        /* renamed from: a  reason: collision with root package name */
        private com.autonavi.aps.amapapi.model.a f11907a = null;

        /* renamed from: b  reason: collision with root package name */
        private String f11908b = null;

        protected C0108a() {
        }

        public final com.autonavi.aps.amapapi.model.a a() {
            return this.f11907a;
        }

        public final String b() {
            return this.f11908b;
        }

        public final void a(com.autonavi.aps.amapapi.model.a aVar) {
            this.f11907a = aVar;
        }

        public final void a(String str) {
            if (TextUtils.isEmpty(str)) {
                this.f11908b = null;
            } else {
                this.f11908b = str.replace("##", "#");
            }
        }
    }

    private boolean b() {
        long b4 = j.b();
        long j4 = this.f11901i;
        long j5 = b4 - j4;
        if (j4 == 0) {
            return false;
        }
        return this.f11893a.size() > 360 || j5 > 172800000;
    }

    private void c() {
        this.f11901i = 0L;
        if (!this.f11893a.isEmpty()) {
            this.f11893a.clear();
        }
        this.f11902j = false;
    }

    public final void a(String str, StringBuilder sb, com.autonavi.aps.amapapi.model.a aVar, Context context, boolean z3) {
        try {
            if (j.a(aVar)) {
                String str2 = str + "&" + aVar.isOffset() + "&" + aVar.i() + "&" + aVar.j();
                if (!a(str2, aVar) || aVar.e().equals("mem") || aVar.e().equals("file") || aVar.e().equals("wifioff") || NetworkPlatformConst.AD_NETWORK_NO_PERMISSION.equals(aVar.d())) {
                    return;
                }
                if (b()) {
                    c();
                }
                JSONObject f4 = aVar.f();
                if (j.a(f4, "offpct")) {
                    f4.remove("offpct");
                    aVar.a(f4);
                }
                if (str2.contains("wifi")) {
                    if (TextUtils.isEmpty(sb)) {
                        return;
                    }
                    if (aVar.getAccuracy() >= 300.0f) {
                        int i4 = 0;
                        for (String str3 : sb.toString().split("#")) {
                            if (str3.contains(",")) {
                                i4++;
                            }
                        }
                        if (i4 >= 8) {
                            return;
                        }
                    } else if (aVar.getAccuracy() <= 3.0f) {
                        return;
                    }
                    if (str2.contains("cgiwifi") && !TextUtils.isEmpty(aVar.g())) {
                        String replace = str2.replace("cgiwifi", "cgi");
                        com.autonavi.aps.amapapi.model.a h4 = aVar.h();
                        if (j.a(h4)) {
                            a(replace, new StringBuilder(), h4, context, true);
                        }
                    }
                } else if (str2.contains("cgi") && ((sb != null && sb.indexOf(",") != -1) || "4".equals(aVar.d()))) {
                    return;
                }
                com.autonavi.aps.amapapi.model.a a4 = a(str2, sb, false);
                if (j.a(a4) && a4.toStr().equals(aVar.toStr(3))) {
                    return;
                }
                this.f11901i = j.b();
                C0108a c0108a = new C0108a();
                c0108a.a(aVar);
                c0108a.a(TextUtils.isEmpty(sb) ? null : sb.toString());
                if (this.f11893a.containsKey(str2)) {
                    this.f11893a.get(str2).add(c0108a);
                } else {
                    ArrayList<C0108a> arrayList = new ArrayList<>();
                    arrayList.add(c0108a);
                    this.f11893a.put(str2, arrayList);
                }
                if (z3) {
                    a(str2, aVar, sb, context);
                }
            }
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "Cache", "add");
        }
    }

    public final void b(Context context) {
        try {
            c();
            c(context);
            this.f11902j = false;
            this.f11896d = null;
            this.f11906n = 0L;
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "Cache", "destroy part");
        }
    }

    private void c(Context context) throws Exception {
        if (context == null) {
            return;
        }
        SQLiteDatabase sQLiteDatabase = null;
        try {
            SQLiteDatabase openOrCreateDatabase = context.openOrCreateDatabase("hmdb", 0, null);
            if (!j.a(openOrCreateDatabase, "hist")) {
                if (openOrCreateDatabase == null || !openOrCreateDatabase.isOpen()) {
                    return;
                }
                openOrCreateDatabase.close();
                return;
            }
            String[] strArr = {String.valueOf(j.a() - 172800000)};
            openOrCreateDatabase.delete("hist" + this.f11903k, "time<?", strArr);
            if (openOrCreateDatabase == null || !openOrCreateDatabase.isOpen()) {
                return;
            }
            openOrCreateDatabase.close();
        } catch (Throwable th) {
            try {
                com.autonavi.aps.amapapi.utils.b.a(th, "DB", "clearHist p2");
            } finally {
                if (0 != 0 && sQLiteDatabase.isOpen()) {
                    sQLiteDatabase.close();
                }
            }
        }
    }

    public final com.autonavi.aps.amapapi.model.a a(Context context, String str, StringBuilder sb, boolean z3, boolean z4) {
        if (!TextUtils.isEmpty(str) && com.autonavi.aps.amapapi.utils.a.e()) {
            String str2 = str + "&" + this.f11898f + "&" + this.f11899g + "&" + this.f11900h;
            if (str2.contains("gps") || !com.autonavi.aps.amapapi.utils.a.e() || sb == null) {
                return null;
            }
            if (b()) {
                c();
                return null;
            }
            if (z3 && !this.f11902j) {
                try {
                    String a4 = a(str2, sb, context);
                    c();
                    a(context, a4, z4);
                } catch (Throwable unused) {
                }
            }
            if (this.f11893a.isEmpty()) {
                return null;
            }
            return a(str2, sb, z4);
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x008b A[Catch: all -> 0x0094, TryCatch #0 {all -> 0x0094, blocks: (B:3:0x0001, B:5:0x0009, B:8:0x0012, B:10:0x001a, B:12:0x0022, B:14:0x0030, B:18:0x0048, B:20:0x0052, B:22:0x0064, B:25:0x006f, B:27:0x0073, B:29:0x0079, B:30:0x0085, B:32:0x008b, B:33:0x008f, B:16:0x0042), top: B:38:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.autonavi.aps.amapapi.model.a a(java.lang.String r5, java.lang.StringBuilder r6, boolean r7) {
        /*
            r4 = this;
            r0 = 0
            java.lang.String r1 = "cgiwifi"
            boolean r1 = r5.contains(r1)     // Catch: java.lang.Throwable -> L94
            if (r1 != 0) goto L42
            java.lang.String r1 = "wifi"
            boolean r1 = r5.contains(r1)     // Catch: java.lang.Throwable -> L94
            if (r1 == 0) goto L12
            goto L42
        L12:
            java.lang.String r6 = "cgi"
            boolean r6 = r5.contains(r6)     // Catch: java.lang.Throwable -> L94
            if (r6 == 0) goto L40
            java.util.Hashtable<java.lang.String, java.util.ArrayList<com.autonavi.aps.amapapi.storage.a$a>> r6 = r4.f11893a     // Catch: java.lang.Throwable -> L94
            boolean r6 = r6.containsKey(r5)     // Catch: java.lang.Throwable -> L94
            if (r6 == 0) goto L40
            java.util.Hashtable<java.lang.String, java.util.ArrayList<com.autonavi.aps.amapapi.storage.a$a>> r6 = r4.f11893a     // Catch: java.lang.Throwable -> L94
            java.lang.Object r6 = r6.get(r5)     // Catch: java.lang.Throwable -> L94
            java.util.ArrayList r6 = (java.util.ArrayList) r6     // Catch: java.lang.Throwable -> L94
            int r6 = r6.size()     // Catch: java.lang.Throwable -> L94
            if (r6 <= 0) goto L40
            java.util.Hashtable<java.lang.String, java.util.ArrayList<com.autonavi.aps.amapapi.storage.a$a>> r6 = r4.f11893a     // Catch: java.lang.Throwable -> L94
            java.lang.Object r6 = r6.get(r5)     // Catch: java.lang.Throwable -> L94
            java.util.ArrayList r6 = (java.util.ArrayList) r6     // Catch: java.lang.Throwable -> L94
            r1 = 0
            java.lang.Object r6 = r6.get(r1)     // Catch: java.lang.Throwable -> L94
            com.autonavi.aps.amapapi.storage.a$a r6 = (com.autonavi.aps.amapapi.storage.a.C0108a) r6     // Catch: java.lang.Throwable -> L94
            goto L46
        L40:
            r6 = r0
            goto L46
        L42:
            com.autonavi.aps.amapapi.storage.a$a r6 = r4.a(r6, r5)     // Catch: java.lang.Throwable -> L94
        L46:
            if (r6 == 0) goto L9c
            com.autonavi.aps.amapapi.model.a r1 = r6.a()     // Catch: java.lang.Throwable -> L94
            boolean r1 = com.autonavi.aps.amapapi.utils.j.a(r1)     // Catch: java.lang.Throwable -> L94
            if (r1 == 0) goto L9c
            com.autonavi.aps.amapapi.model.a r1 = r6.a()     // Catch: java.lang.Throwable -> L94
            java.lang.String r2 = "mem"
            r1.e(r2)     // Catch: java.lang.Throwable -> L94
            java.lang.String r2 = r6.b()     // Catch: java.lang.Throwable -> L94
            r1.h(r2)     // Catch: java.lang.Throwable -> L94
            if (r7 != 0) goto L85
            long r2 = r1.getTime()     // Catch: java.lang.Throwable -> L94
            boolean r7 = com.autonavi.aps.amapapi.utils.a.a(r2)     // Catch: java.lang.Throwable -> L94
            if (r7 == 0) goto L6f
            goto L85
        L6f:
            java.util.Hashtable<java.lang.String, java.util.ArrayList<com.autonavi.aps.amapapi.storage.a$a>> r7 = r4.f11893a     // Catch: java.lang.Throwable -> L94
            if (r7 == 0) goto L9c
            boolean r7 = r7.containsKey(r5)     // Catch: java.lang.Throwable -> L94
            if (r7 == 0) goto L9c
            java.util.Hashtable<java.lang.String, java.util.ArrayList<com.autonavi.aps.amapapi.storage.a$a>> r7 = r4.f11893a     // Catch: java.lang.Throwable -> L94
            java.lang.Object r5 = r7.get(r5)     // Catch: java.lang.Throwable -> L94
            java.util.ArrayList r5 = (java.util.ArrayList) r5     // Catch: java.lang.Throwable -> L94
            r5.remove(r6)     // Catch: java.lang.Throwable -> L94
            goto L9c
        L85:
            boolean r5 = com.autonavi.aps.amapapi.utils.j.a(r1)     // Catch: java.lang.Throwable -> L94
            if (r5 == 0) goto L8f
            r5 = 0
            r4.f11895c = r5     // Catch: java.lang.Throwable -> L94
        L8f:
            r5 = 4
            r1.setLocationType(r5)     // Catch: java.lang.Throwable -> L94
            return r1
        L94:
            r5 = move-exception
            java.lang.String r6 = "Cache"
            java.lang.String r7 = "get1"
            com.autonavi.aps.amapapi.utils.b.a(r5, r6, r7)
        L9c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.aps.amapapi.storage.a.a(java.lang.String, java.lang.StringBuilder, boolean):com.autonavi.aps.amapapi.model.a");
    }

    private static boolean a(String str, com.autonavi.aps.amapapi.model.a aVar) {
        if (TextUtils.isEmpty(str) || !j.a(aVar) || str.startsWith("#")) {
            return false;
        }
        return str.contains("network");
    }

    private C0108a a(StringBuilder sb, String str) {
        C0108a c0108a;
        boolean z3;
        C0108a c0108a2;
        if (this.f11893a.isEmpty() || TextUtils.isEmpty(sb)) {
            return null;
        }
        if (this.f11893a.containsKey(str)) {
            Hashtable hashtable = new Hashtable();
            Hashtable hashtable2 = new Hashtable();
            Hashtable hashtable3 = new Hashtable();
            ArrayList<C0108a> arrayList = this.f11893a.get(str);
            char c4 = 1;
            int size = arrayList.size() - 1;
            while (size >= 0) {
                C0108a c0108a3 = arrayList.get(size);
                if (!TextUtils.isEmpty(c0108a3.b())) {
                    if (!a(c0108a3.b(), sb)) {
                        z3 = false;
                    } else if (j.a(c0108a3.b(), sb.toString())) {
                        c0108a2 = c0108a3;
                        c0108a = c0108a2;
                        break;
                    } else {
                        z3 = true;
                    }
                    a(c0108a3.b(), hashtable);
                    a(sb.toString(), hashtable2);
                    hashtable3.clear();
                    for (String str2 : hashtable.keySet()) {
                        hashtable3.put(str2, "");
                    }
                    for (String str3 : hashtable2.keySet()) {
                        hashtable3.put(str3, "");
                    }
                    Set keySet = hashtable3.keySet();
                    double[] dArr = new double[keySet.size()];
                    double[] dArr2 = new double[keySet.size()];
                    Iterator it = keySet.iterator();
                    int i4 = 0;
                    while (it != null && it.hasNext()) {
                        String str4 = (String) it.next();
                        double d4 = 1.0d;
                        dArr[i4] = hashtable.containsKey(str4) ? 1.0d : 0.0d;
                        if (!hashtable2.containsKey(str4)) {
                            d4 = 0.0d;
                        }
                        dArr2[i4] = d4;
                        i4++;
                    }
                    keySet.clear();
                    double[] a4 = a(dArr, dArr2);
                    if (a4[0] < 0.800000011920929d) {
                        c0108a2 = c0108a3;
                        if (a4[c4] < Math.min(com.autonavi.aps.amapapi.utils.a.g(), 0.618d)) {
                            if (z3 && a4[0] >= Math.min(com.autonavi.aps.amapapi.utils.a.g(), 0.618d)) {
                            }
                        }
                        c0108a = c0108a2;
                        break;
                    }
                    c0108a2 = c0108a3;
                    c0108a = c0108a2;
                    break;
                }
                size--;
                c4 = 1;
            }
            c0108a = null;
            hashtable.clear();
            hashtable2.clear();
            hashtable3.clear();
            return c0108a;
        }
        return null;
    }

    private static boolean a(String str, StringBuilder sb) {
        String str2;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(sb) || !str.contains(",access") || sb.indexOf(",access") == -1) {
            return false;
        }
        String[] split = str.split(",access");
        if (split[0].contains("#")) {
            str2 = split[0].substring(split[0].lastIndexOf("#") + 1);
        } else {
            str2 = split[0];
        }
        if (TextUtils.isEmpty(str2)) {
            return false;
        }
        String sb2 = sb.toString();
        return sb2.contains(str2 + ",access");
    }

    private static void a(String str, Hashtable<String, String> hashtable) {
        String[] split;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        hashtable.clear();
        for (String str2 : str.split("#")) {
            if (!TextUtils.isEmpty(str2) && !str2.contains("|")) {
                hashtable.put(str2, "");
            }
        }
    }

    private static double[] a(double[] dArr, double[] dArr2) {
        double[] dArr3 = new double[3];
        double d4 = 0.0d;
        double d5 = 0.0d;
        double d6 = 0.0d;
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 0; i6 < dArr.length; i6++) {
            d5 += dArr[i6] * dArr[i6];
            d6 += dArr2[i6] * dArr2[i6];
            d4 += dArr[i6] * dArr2[i6];
            if (dArr2[i6] == 1.0d) {
                i5++;
                if (dArr[i6] == 1.0d) {
                    i4++;
                }
            }
        }
        dArr3[0] = d4 / (Math.sqrt(d5) * Math.sqrt(d6));
        double d7 = i4;
        Double.isNaN(d7);
        double d8 = i5;
        Double.isNaN(d8);
        dArr3[1] = (d7 * 1.0d) / d8;
        dArr3[2] = d7;
        for (int i7 = 0; i7 < 2; i7++) {
            if (dArr3[i7] > 1.0d) {
                dArr3[i7] = 1.0d;
            }
        }
        return dArr3;
    }

    public final void a(Context context) {
        if (this.f11902j) {
            return;
        }
        try {
            c();
            a(context, (String) null, false);
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "Cache", "loadDB");
        }
        this.f11902j = true;
    }

    private String a(String str, StringBuilder sb, Context context) {
        String str2;
        if (context == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            this.f11904l = j.l(context);
            if (str.contains("&")) {
                str = str.substring(0, str.indexOf("&"));
            }
            String substring = str.substring(str.lastIndexOf("#") + 1);
            if (substring.equals("cgi")) {
                jSONObject.put("cgi", str.substring(0, str.length() - 12));
            } else if (!TextUtils.isEmpty(sb) && sb.indexOf(",access") != -1) {
                jSONObject.put("cgi", str.substring(0, str.length() - (substring.length() + 9)));
                String[] split = sb.toString().split(",access");
                if (split[0].contains("#")) {
                    str2 = split[0].substring(split[0].lastIndexOf("#") + 1);
                } else {
                    str2 = split[0];
                }
                jSONObject.put("mmac", str2);
            }
            return j4.f(com.autonavi.aps.amapapi.security.a.a(jSONObject.toString().getBytes("UTF-8"), this.f11904l));
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX WARN: Finally extract failed */
    private void a(String str, AMapLocation aMapLocation, StringBuilder sb, Context context) throws Exception {
        if (context == null) {
            return;
        }
        if (this.f11904l == null) {
            this.f11904l = j.l(context);
        }
        String a4 = a(str, sb, context);
        StringBuilder sb2 = new StringBuilder();
        SQLiteDatabase sQLiteDatabase = null;
        try {
            sQLiteDatabase = context.openOrCreateDatabase("hmdb", 0, null);
            sb2.append("CREATE TABLE IF NOT EXISTS hist");
            sb2.append(this.f11903k);
            sb2.append(" (feature VARCHAR PRIMARY KEY, nb VARCHAR, loc VARCHAR, time VARCHAR);");
            sQLiteDatabase.execSQL(sb2.toString());
            sb2.delete(0, sb2.length());
            sb2.append("REPLACE INTO ");
            sb2.append("hist");
            sb2.append(this.f11903k);
            sb2.append(" VALUES (?, ?, ?, ?)");
            Object[] objArr = new Object[4];
            objArr[0] = a4;
            byte[] a5 = com.autonavi.aps.amapapi.security.a.a(sb.toString().getBytes("UTF-8"), this.f11904l);
            objArr[1] = a5;
            objArr[2] = com.autonavi.aps.amapapi.security.a.a(aMapLocation.toStr().getBytes("UTF-8"), this.f11904l);
            objArr[3] = Long.valueOf(aMapLocation.getTime());
            for (int i4 = 1; i4 < 3; i4++) {
                objArr[i4] = j4.f((byte[]) objArr[i4]);
            }
            sQLiteDatabase.execSQL(sb2.toString(), objArr);
            sb2.delete(0, sb2.length());
            sb2.delete(0, sb2.length());
            if (sQLiteDatabase.isOpen()) {
                sQLiteDatabase.close();
            }
        } catch (Throwable th) {
            try {
                com.autonavi.aps.amapapi.utils.b.a(th, "DB", "updateHist");
                sb2.delete(0, sb2.length());
                if (sQLiteDatabase == null || !sQLiteDatabase.isOpen()) {
                    return;
                }
                sQLiteDatabase.close();
            } catch (Throwable th2) {
                sb2.delete(0, sb2.length());
                if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                    sQLiteDatabase.close();
                }
                throw th2;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x02b2 A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:108:0x02b7 A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0276 A[EDGE_INSN: B:135:0x0276->B:85:0x0276 ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:139:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0286 A[LOOP:0: B:40:0x00d8->B:87:0x0286, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(android.content.Context r20, java.lang.String r21, boolean r22) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 725
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.aps.amapapi.storage.a.a(android.content.Context, java.lang.String, boolean):void");
    }

    public final void a(AMapLocationClientOption aMapLocationClientOption) {
        this.f11899g = aMapLocationClientOption.isNeedAddress();
        this.f11898f = aMapLocationClientOption.isOffset();
        this.f11894b = aMapLocationClientOption.isLocationCacheEnable();
        this.f11900h = String.valueOf(aMapLocationClientOption.getGeoLanguage());
    }

    public final void a(d dVar) {
        this.f11897e = dVar;
    }

    private boolean a(com.autonavi.aps.amapapi.model.a aVar, boolean z3) {
        if (a(z3)) {
            return aVar == null || com.autonavi.aps.amapapi.utils.a.a(aVar.getTime()) || z3;
        }
        return false;
    }

    private boolean a(boolean z3) {
        if (com.autonavi.aps.amapapi.utils.a.e() || z3) {
            return this.f11894b || com.autonavi.aps.amapapi.utils.a.f() || z3;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0029 A[Catch: all -> 0x00f0, TryCatch #0 {all -> 0x00f0, blocks: (B:5:0x000f, B:7:0x0015, B:17:0x0029, B:27:0x004b, B:31:0x0053, B:33:0x0061, B:45:0x0086, B:47:0x008f, B:49:0x0093, B:51:0x0099, B:53:0x00a4, B:62:0x00c9, B:65:0x00d8, B:74:0x00e9, B:54:0x00a8, B:55:0x00b1, B:57:0x00b5, B:58:0x00be, B:46:0x008d, B:39:0x0073, B:41:0x0079, B:9:0x0019, B:11:0x001d), top: B:78:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0086 A[Catch: all -> 0x00f0, TryCatch #0 {all -> 0x00f0, blocks: (B:5:0x000f, B:7:0x0015, B:17:0x0029, B:27:0x004b, B:31:0x0053, B:33:0x0061, B:45:0x0086, B:47:0x008f, B:49:0x0093, B:51:0x0099, B:53:0x00a4, B:62:0x00c9, B:65:0x00d8, B:74:0x00e9, B:54:0x00a8, B:55:0x00b1, B:57:0x00b5, B:58:0x00be, B:46:0x008d, B:39:0x0073, B:41:0x0079, B:9:0x0019, B:11:0x001d), top: B:78:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x008d A[Catch: all -> 0x00f0, TryCatch #0 {all -> 0x00f0, blocks: (B:5:0x000f, B:7:0x0015, B:17:0x0029, B:27:0x004b, B:31:0x0053, B:33:0x0061, B:45:0x0086, B:47:0x008f, B:49:0x0093, B:51:0x0099, B:53:0x00a4, B:62:0x00c9, B:65:0x00d8, B:74:0x00e9, B:54:0x00a8, B:55:0x00b1, B:57:0x00b5, B:58:0x00be, B:46:0x008d, B:39:0x0073, B:41:0x0079, B:9:0x0019, B:11:0x001d), top: B:78:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00b5 A[Catch: all -> 0x00f0, TryCatch #0 {all -> 0x00f0, blocks: (B:5:0x000f, B:7:0x0015, B:17:0x0029, B:27:0x004b, B:31:0x0053, B:33:0x0061, B:45:0x0086, B:47:0x008f, B:49:0x0093, B:51:0x0099, B:53:0x00a4, B:62:0x00c9, B:65:0x00d8, B:74:0x00e9, B:54:0x00a8, B:55:0x00b1, B:57:0x00b5, B:58:0x00be, B:46:0x008d, B:39:0x0073, B:41:0x0079, B:9:0x0019, B:11:0x001d), top: B:78:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00be A[Catch: all -> 0x00f0, TryCatch #0 {all -> 0x00f0, blocks: (B:5:0x000f, B:7:0x0015, B:17:0x0029, B:27:0x004b, B:31:0x0053, B:33:0x0061, B:45:0x0086, B:47:0x008f, B:49:0x0093, B:51:0x0099, B:53:0x00a4, B:62:0x00c9, B:65:0x00d8, B:74:0x00e9, B:54:0x00a8, B:55:0x00b1, B:57:0x00b5, B:58:0x00be, B:46:0x008d, B:39:0x0073, B:41:0x0079, B:9:0x0019, B:11:0x001d), top: B:78:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00c7 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00d8 A[Catch: all -> 0x00f0, TryCatch #0 {all -> 0x00f0, blocks: (B:5:0x000f, B:7:0x0015, B:17:0x0029, B:27:0x004b, B:31:0x0053, B:33:0x0061, B:45:0x0086, B:47:0x008f, B:49:0x0093, B:51:0x0099, B:53:0x00a4, B:62:0x00c9, B:65:0x00d8, B:74:0x00e9, B:54:0x00a8, B:55:0x00b1, B:57:0x00b5, B:58:0x00be, B:46:0x008d, B:39:0x0073, B:41:0x0079, B:9:0x0019, B:11:0x001d), top: B:78:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00e3 A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.autonavi.aps.amapapi.model.a a(com.autonavi.aps.amapapi.restruct.e r16, boolean r17, com.autonavi.aps.amapapi.model.a r18, com.autonavi.aps.amapapi.restruct.k r19, java.lang.StringBuilder r20, java.lang.String r21, android.content.Context r22, boolean r23) {
        /*
            Method dump skipped, instructions count: 241
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.aps.amapapi.storage.a.a(com.autonavi.aps.amapapi.restruct.e, boolean, com.autonavi.aps.amapapi.model.a, com.autonavi.aps.amapapi.restruct.k, java.lang.StringBuilder, java.lang.String, android.content.Context, boolean):com.autonavi.aps.amapapi.model.a");
    }

    public final void a(String str) {
        this.f11896d = str;
    }

    public final void a() {
        this.f11895c = 0L;
        this.f11896d = null;
    }
}

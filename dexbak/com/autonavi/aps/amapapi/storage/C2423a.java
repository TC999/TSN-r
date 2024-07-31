package com.autonavi.aps.amapapi.storage;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.amap.api.col.p0463l.Encrypt;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.autonavi.aps.amapapi.model.AMapLocationServer;
import com.autonavi.aps.amapapi.restruct.Cgi;
import com.autonavi.aps.amapapi.security.C2422a;
import com.autonavi.aps.amapapi.utils.AuthUtil;
import com.autonavi.aps.amapapi.utils.C2428b;
import com.autonavi.aps.amapapi.utils.C2432j;
import com.baidu.mobads.sdk.internal.C2624bk;
import com.bytedance.msdk.api.NetworkPlatformConst;
import com.github.mikephil.charting.utils.Utils;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;
import master.flame.danmaku.danmaku.parser.IDataSource;
import org.json.JSONObject;

/* compiled from: Cache.java */
/* renamed from: com.autonavi.aps.amapapi.storage.a */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class C2423a {

    /* renamed from: a */
    Hashtable<String, ArrayList<C2424a>> f8221a = new Hashtable<>();

    /* renamed from: i */
    private long f8229i = 0;

    /* renamed from: j */
    private boolean f8230j = false;

    /* renamed from: k */
    private String f8231k = "2.0.201501131131".replace(".", "");

    /* renamed from: l */
    private String f8232l = null;

    /* renamed from: b */
    boolean f8222b = true;

    /* renamed from: c */
    long f8223c = 0;

    /* renamed from: d */
    String f8224d = null;

    /* renamed from: e */
    Cgi f8225e = null;

    /* renamed from: m */
    private String f8233m = null;

    /* renamed from: n */
    private long f8234n = 0;

    /* renamed from: f */
    boolean f8226f = true;

    /* renamed from: g */
    boolean f8227g = true;

    /* renamed from: h */
    String f8228h = String.valueOf(AMapLocationClientOption.GeoLanguage.DEFAULT);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Cache.java */
    /* renamed from: com.autonavi.aps.amapapi.storage.a$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class C2424a {

        /* renamed from: a */
        private AMapLocationServer f8235a = null;

        /* renamed from: b */
        private String f8236b = null;

        protected C2424a() {
        }

        /* renamed from: a */
        public final AMapLocationServer m51425a() {
            return this.f8235a;
        }

        /* renamed from: b */
        public final String m51422b() {
            return this.f8236b;
        }

        /* renamed from: a */
        public final void m51424a(AMapLocationServer aMapLocationServer) {
            this.f8235a = aMapLocationServer;
        }

        /* renamed from: a */
        public final void m51423a(String str) {
            if (TextUtils.isEmpty(str)) {
                this.f8236b = null;
            } else {
                this.f8236b = str.replace("##", "#");
            }
        }
    }

    /* renamed from: b */
    private boolean m51429b() {
        long m51186b = C2432j.m51186b();
        long j = this.f8229i;
        long j2 = m51186b - j;
        if (j == 0) {
            return false;
        }
        return this.f8221a.size() > 360 || j2 > C2624bk.f8681e;
    }

    /* renamed from: c */
    private void m51427c() {
        this.f8229i = 0L;
        if (!this.f8221a.isEmpty()) {
            this.f8221a.clear();
        }
        this.f8230j = false;
    }

    /* renamed from: a */
    public final void m51435a(String str, StringBuilder sb, AMapLocationServer aMapLocationServer, Context context, boolean z) {
        try {
            if (C2432j.m51194a(aMapLocationServer)) {
                String str2 = str + "&" + aMapLocationServer.isOffset() + "&" + aMapLocationServer.m51615i() + "&" + aMapLocationServer.m51613j();
                if (!m51438a(str2, aMapLocationServer) || aMapLocationServer.m51623e().equals("mem") || aMapLocationServer.m51623e().equals(IDataSource.f43973c) || aMapLocationServer.m51623e().equals("wifioff") || NetworkPlatformConst.AD_NETWORK_NO_PERMISSION.equals(aMapLocationServer.m51625d())) {
                    return;
                }
                if (m51429b()) {
                    m51427c();
                }
                JSONObject m51621f = aMapLocationServer.m51621f();
                if (C2432j.m51189a(m51621f, "offpct")) {
                    m51621f.remove("offpct");
                    aMapLocationServer.m51632a(m51621f);
                }
                if (str2.contains("wifi")) {
                    if (TextUtils.isEmpty(sb)) {
                        return;
                    }
                    if (aMapLocationServer.getAccuracy() >= 300.0f) {
                        int i = 0;
                        for (String str3 : sb.toString().split("#")) {
                            if (str3.contains(",")) {
                                i++;
                            }
                        }
                        if (i >= 8) {
                            return;
                        }
                    } else if (aMapLocationServer.getAccuracy() <= 3.0f) {
                        return;
                    }
                    if (str2.contains("cgiwifi") && !TextUtils.isEmpty(aMapLocationServer.m51619g())) {
                        String replace = str2.replace("cgiwifi", "cgi");
                        AMapLocationServer m51617h = aMapLocationServer.m51617h();
                        if (C2432j.m51194a(m51617h)) {
                            m51435a(replace, new StringBuilder(), m51617h, context, true);
                        }
                    }
                } else if (str2.contains("cgi") && ((sb != null && sb.indexOf(",") != -1) || "4".equals(aMapLocationServer.m51625d()))) {
                    return;
                }
                AMapLocationServer m51434a = m51434a(str2, sb, false);
                if (C2432j.m51194a(m51434a) && m51434a.toStr().equals(aMapLocationServer.toStr(3))) {
                    return;
                }
                this.f8229i = C2432j.m51186b();
                C2424a c2424a = new C2424a();
                c2424a.m51424a(aMapLocationServer);
                c2424a.m51423a(TextUtils.isEmpty(sb) ? null : sb.toString());
                if (this.f8221a.containsKey(str2)) {
                    this.f8221a.get(str2).add(c2424a);
                } else {
                    ArrayList<C2424a> arrayList = new ArrayList<>();
                    arrayList.add(c2424a);
                    this.f8221a.put(str2, arrayList);
                }
                if (z) {
                    m51439a(str2, aMapLocationServer, sb, context);
                }
            }
        } catch (Throwable th) {
            C2428b.m51299a(th, "Cache", "add");
        }
    }

    /* renamed from: b */
    public final void m51428b(Context context) {
        try {
            m51427c();
            m51426c(context);
            this.f8230j = false;
            this.f8224d = null;
            this.f8234n = 0L;
        } catch (Throwable th) {
            C2428b.m51299a(th, "Cache", "destroy part");
        }
    }

    /* renamed from: c */
    private void m51426c(Context context) throws Exception {
        if (context == null) {
            return;
        }
        SQLiteDatabase sQLiteDatabase = null;
        try {
            SQLiteDatabase openOrCreateDatabase = context.openOrCreateDatabase("hmdb", 0, null);
            if (!C2432j.m51202a(openOrCreateDatabase, "hist")) {
                if (openOrCreateDatabase == null || !openOrCreateDatabase.isOpen()) {
                    return;
                }
                openOrCreateDatabase.close();
                return;
            }
            String[] strArr = {String.valueOf(C2432j.m51211a() - C2624bk.f8681e)};
            openOrCreateDatabase.delete("hist" + this.f8231k, "time<?", strArr);
            if (openOrCreateDatabase == null || !openOrCreateDatabase.isOpen()) {
                return;
            }
            openOrCreateDatabase.close();
        } catch (Throwable th) {
            try {
                C2428b.m51299a(th, "DB", "clearHist p2");
            } finally {
                if (0 != 0 && sQLiteDatabase.isOpen()) {
                    sQLiteDatabase.close();
                }
            }
        }
    }

    /* renamed from: a */
    public final AMapLocationServer m51446a(Context context, String str, StringBuilder sb, boolean z, boolean z2) {
        if (!TextUtils.isEmpty(str) && AuthUtil.m51333e()) {
            String str2 = str + "&" + this.f8226f + "&" + this.f8227g + "&" + this.f8228h;
            if (str2.contains(GeocodeSearch.GPS) || !AuthUtil.m51333e() || sb == null) {
                return null;
            }
            if (m51429b()) {
                m51427c();
                return null;
            }
            if (z && !this.f8230j) {
                try {
                    String m51436a = m51436a(str2, sb, context);
                    m51427c();
                    m51445a(context, m51436a, z2);
                } catch (Throwable unused) {
                }
            }
            if (this.f8221a.isEmpty()) {
                return null;
            }
            return m51434a(str2, sb, z2);
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x008b A[Catch: all -> 0x0094, TryCatch #0 {all -> 0x0094, blocks: (B:3:0x0001, B:5:0x0009, B:8:0x0012, B:10:0x001a, B:12:0x0022, B:14:0x0030, B:18:0x0048, B:20:0x0052, B:22:0x0064, B:25:0x006f, B:27:0x0073, B:29:0x0079, B:30:0x0085, B:32:0x008b, B:33:0x008f, B:16:0x0042), top: B:38:0x0001 }] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.autonavi.aps.amapapi.model.AMapLocationServer m51434a(java.lang.String r5, java.lang.StringBuilder r6, boolean r7) {
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
            java.util.Hashtable<java.lang.String, java.util.ArrayList<com.autonavi.aps.amapapi.storage.a$a>> r6 = r4.f8221a     // Catch: java.lang.Throwable -> L94
            boolean r6 = r6.containsKey(r5)     // Catch: java.lang.Throwable -> L94
            if (r6 == 0) goto L40
            java.util.Hashtable<java.lang.String, java.util.ArrayList<com.autonavi.aps.amapapi.storage.a$a>> r6 = r4.f8221a     // Catch: java.lang.Throwable -> L94
            java.lang.Object r6 = r6.get(r5)     // Catch: java.lang.Throwable -> L94
            java.util.ArrayList r6 = (java.util.ArrayList) r6     // Catch: java.lang.Throwable -> L94
            int r6 = r6.size()     // Catch: java.lang.Throwable -> L94
            if (r6 <= 0) goto L40
            java.util.Hashtable<java.lang.String, java.util.ArrayList<com.autonavi.aps.amapapi.storage.a$a>> r6 = r4.f8221a     // Catch: java.lang.Throwable -> L94
            java.lang.Object r6 = r6.get(r5)     // Catch: java.lang.Throwable -> L94
            java.util.ArrayList r6 = (java.util.ArrayList) r6     // Catch: java.lang.Throwable -> L94
            r1 = 0
            java.lang.Object r6 = r6.get(r1)     // Catch: java.lang.Throwable -> L94
            com.autonavi.aps.amapapi.storage.a$a r6 = (com.autonavi.aps.amapapi.storage.C2423a.C2424a) r6     // Catch: java.lang.Throwable -> L94
            goto L46
        L40:
            r6 = r0
            goto L46
        L42:
            com.autonavi.aps.amapapi.storage.a$a r6 = r4.m51432a(r6, r5)     // Catch: java.lang.Throwable -> L94
        L46:
            if (r6 == 0) goto L9c
            com.autonavi.aps.amapapi.model.a r1 = r6.m51425a()     // Catch: java.lang.Throwable -> L94
            boolean r1 = com.autonavi.aps.amapapi.utils.C2432j.m51194a(r1)     // Catch: java.lang.Throwable -> L94
            if (r1 == 0) goto L9c
            com.autonavi.aps.amapapi.model.a r1 = r6.m51425a()     // Catch: java.lang.Throwable -> L94
            java.lang.String r2 = "mem"
            r1.m51622e(r2)     // Catch: java.lang.Throwable -> L94
            java.lang.String r2 = r6.m51422b()     // Catch: java.lang.Throwable -> L94
            r1.m51616h(r2)     // Catch: java.lang.Throwable -> L94
            if (r7 != 0) goto L85
            long r2 = r1.getTime()     // Catch: java.lang.Throwable -> L94
            boolean r7 = com.autonavi.aps.amapapi.utils.AuthUtil.m51348a(r2)     // Catch: java.lang.Throwable -> L94
            if (r7 == 0) goto L6f
            goto L85
        L6f:
            java.util.Hashtable<java.lang.String, java.util.ArrayList<com.autonavi.aps.amapapi.storage.a$a>> r7 = r4.f8221a     // Catch: java.lang.Throwable -> L94
            if (r7 == 0) goto L9c
            boolean r7 = r7.containsKey(r5)     // Catch: java.lang.Throwable -> L94
            if (r7 == 0) goto L9c
            java.util.Hashtable<java.lang.String, java.util.ArrayList<com.autonavi.aps.amapapi.storage.a$a>> r7 = r4.f8221a     // Catch: java.lang.Throwable -> L94
            java.lang.Object r5 = r7.get(r5)     // Catch: java.lang.Throwable -> L94
            java.util.ArrayList r5 = (java.util.ArrayList) r5     // Catch: java.lang.Throwable -> L94
            r5.remove(r6)     // Catch: java.lang.Throwable -> L94
            goto L9c
        L85:
            boolean r5 = com.autonavi.aps.amapapi.utils.C2432j.m51194a(r1)     // Catch: java.lang.Throwable -> L94
            if (r5 == 0) goto L8f
            r5 = 0
            r4.f8223c = r5     // Catch: java.lang.Throwable -> L94
        L8f:
            r5 = 4
            r1.setLocationType(r5)     // Catch: java.lang.Throwable -> L94
            return r1
        L94:
            r5 = move-exception
            java.lang.String r6 = "Cache"
            java.lang.String r7 = "get1"
            com.autonavi.aps.amapapi.utils.C2428b.m51299a(r5, r6, r7)
        L9c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.aps.amapapi.storage.C2423a.m51434a(java.lang.String, java.lang.StringBuilder, boolean):com.autonavi.aps.amapapi.model.a");
    }

    /* renamed from: a */
    private static boolean m51438a(String str, AMapLocationServer aMapLocationServer) {
        if (TextUtils.isEmpty(str) || !C2432j.m51194a(aMapLocationServer) || str.startsWith("#")) {
            return false;
        }
        return str.contains("network");
    }

    /* renamed from: a */
    private C2424a m51432a(StringBuilder sb, String str) {
        C2424a c2424a;
        boolean z;
        C2424a c2424a2;
        if (this.f8221a.isEmpty() || TextUtils.isEmpty(sb)) {
            return null;
        }
        if (this.f8221a.containsKey(str)) {
            Hashtable hashtable = new Hashtable();
            Hashtable hashtable2 = new Hashtable();
            Hashtable hashtable3 = new Hashtable();
            ArrayList<C2424a> arrayList = this.f8221a.get(str);
            char c = 1;
            int size = arrayList.size() - 1;
            while (size >= 0) {
                C2424a c2424a3 = arrayList.get(size);
                if (!TextUtils.isEmpty(c2424a3.m51422b())) {
                    if (!m51437a(c2424a3.m51422b(), sb)) {
                        z = false;
                    } else if (C2432j.m51190a(c2424a3.m51422b(), sb.toString())) {
                        c2424a2 = c2424a3;
                        c2424a = c2424a2;
                        break;
                    } else {
                        z = true;
                    }
                    m51433a(c2424a3.m51422b(), hashtable);
                    m51433a(sb.toString(), hashtable2);
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
                    int i = 0;
                    while (it != null && it.hasNext()) {
                        String str4 = (String) it.next();
                        double d = 1.0d;
                        dArr[i] = hashtable.containsKey(str4) ? 1.0d : 0.0d;
                        if (!hashtable2.containsKey(str4)) {
                            d = 0.0d;
                        }
                        dArr2[i] = d;
                        i++;
                    }
                    keySet.clear();
                    double[] m51430a = m51430a(dArr, dArr2);
                    if (m51430a[0] < 0.800000011920929d) {
                        c2424a2 = c2424a3;
                        if (m51430a[c] < Math.min(AuthUtil.m51329g(), 0.618d)) {
                            if (z && m51430a[0] >= Math.min(AuthUtil.m51329g(), 0.618d)) {
                            }
                        }
                        c2424a = c2424a2;
                        break;
                    }
                    c2424a2 = c2424a3;
                    c2424a = c2424a2;
                    break;
                }
                size--;
                c = 1;
            }
            c2424a = null;
            hashtable.clear();
            hashtable2.clear();
            hashtable3.clear();
            return c2424a;
        }
        return null;
    }

    /* renamed from: a */
    private static boolean m51437a(String str, StringBuilder sb) {
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

    /* renamed from: a */
    private static void m51433a(String str, Hashtable<String, String> hashtable) {
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

    /* renamed from: a */
    private static double[] m51430a(double[] dArr, double[] dArr2) {
        double[] dArr3 = new double[3];
        double d = Utils.DOUBLE_EPSILON;
        double d2 = 0.0d;
        double d3 = 0.0d;
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < dArr.length; i3++) {
            d2 += dArr[i3] * dArr[i3];
            d3 += dArr2[i3] * dArr2[i3];
            d += dArr[i3] * dArr2[i3];
            if (dArr2[i3] == 1.0d) {
                i2++;
                if (dArr[i3] == 1.0d) {
                    i++;
                }
            }
        }
        dArr3[0] = d / (Math.sqrt(d2) * Math.sqrt(d3));
        double d4 = i;
        Double.isNaN(d4);
        double d5 = i2;
        Double.isNaN(d5);
        dArr3[1] = (d4 * 1.0d) / d5;
        dArr3[2] = d4;
        for (int i4 = 0; i4 < 2; i4++) {
            if (dArr3[i4] > 1.0d) {
                dArr3[i4] = 1.0d;
            }
        }
        return dArr3;
    }

    /* renamed from: a */
    public final void m51447a(Context context) {
        if (this.f8230j) {
            return;
        }
        try {
            m51427c();
            m51445a(context, (String) null, false);
        } catch (Throwable th) {
            C2428b.m51299a(th, "Cache", "loadDB");
        }
        this.f8230j = true;
    }

    /* renamed from: a */
    private String m51436a(String str, StringBuilder sb, Context context) {
        String str2;
        if (context == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            this.f8232l = C2432j.m51155l(context);
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
            return Encrypt.m54719f(C2422a.m51453a(jSONObject.toString().getBytes("UTF-8"), this.f8232l));
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX WARN: Finally extract failed */
    /* renamed from: a */
    private void m51439a(String str, AMapLocation aMapLocation, StringBuilder sb, Context context) throws Exception {
        if (context == null) {
            return;
        }
        if (this.f8232l == null) {
            this.f8232l = C2432j.m51155l(context);
        }
        String m51436a = m51436a(str, sb, context);
        StringBuilder sb2 = new StringBuilder();
        SQLiteDatabase sQLiteDatabase = null;
        try {
            sQLiteDatabase = context.openOrCreateDatabase("hmdb", 0, null);
            sb2.append("CREATE TABLE IF NOT EXISTS hist");
            sb2.append(this.f8231k);
            sb2.append(" (feature VARCHAR PRIMARY KEY, nb VARCHAR, loc VARCHAR, time VARCHAR);");
            sQLiteDatabase.execSQL(sb2.toString());
            sb2.delete(0, sb2.length());
            sb2.append("REPLACE INTO ");
            sb2.append("hist");
            sb2.append(this.f8231k);
            sb2.append(" VALUES (?, ?, ?, ?)");
            Object[] objArr = new Object[4];
            objArr[0] = m51436a;
            byte[] m51453a = C2422a.m51453a(sb.toString().getBytes("UTF-8"), this.f8232l);
            objArr[1] = m51453a;
            objArr[2] = C2422a.m51453a(aMapLocation.toStr().getBytes("UTF-8"), this.f8232l);
            objArr[3] = Long.valueOf(aMapLocation.getTime());
            for (int i = 1; i < 3; i++) {
                objArr[i] = Encrypt.m54719f((byte[]) objArr[i]);
            }
            sQLiteDatabase.execSQL(sb2.toString(), objArr);
            sb2.delete(0, sb2.length());
            sb2.delete(0, sb2.length());
            if (sQLiteDatabase.isOpen()) {
                sQLiteDatabase.close();
            }
        } catch (Throwable th) {
            try {
                C2428b.m51299a(th, "DB", "updateHist");
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
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m51445a(android.content.Context r20, java.lang.String r21, boolean r22) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 725
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.aps.amapapi.storage.C2423a.m51445a(android.content.Context, java.lang.String, boolean):void");
    }

    /* renamed from: a */
    public final void m51444a(AMapLocationClientOption aMapLocationClientOption) {
        this.f8227g = aMapLocationClientOption.isNeedAddress();
        this.f8226f = aMapLocationClientOption.isOffset();
        this.f8222b = aMapLocationClientOption.isLocationCacheEnable();
        this.f8228h = String.valueOf(aMapLocationClientOption.getGeoLanguage());
    }

    /* renamed from: a */
    public final void m51442a(Cgi cgi) {
        this.f8225e = cgi;
    }

    /* renamed from: a */
    private boolean m51443a(AMapLocationServer aMapLocationServer, boolean z) {
        if (m51431a(z)) {
            return aMapLocationServer == null || AuthUtil.m51348a(aMapLocationServer.getTime()) || z;
        }
        return false;
    }

    /* renamed from: a */
    private boolean m51431a(boolean z) {
        if (AuthUtil.m51333e() || z) {
            return this.f8222b || AuthUtil.m51331f() || z;
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
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.autonavi.aps.amapapi.model.AMapLocationServer m51441a(com.autonavi.aps.amapapi.restruct.CgiManager r16, boolean r17, com.autonavi.aps.amapapi.model.AMapLocationServer r18, com.autonavi.aps.amapapi.restruct.WifiManagerWrapper r19, java.lang.StringBuilder r20, java.lang.String r21, android.content.Context r22, boolean r23) {
        /*
            Method dump skipped, instructions count: 241
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.aps.amapapi.storage.C2423a.m51441a(com.autonavi.aps.amapapi.restruct.e, boolean, com.autonavi.aps.amapapi.model.a, com.autonavi.aps.amapapi.restruct.k, java.lang.StringBuilder, java.lang.String, android.content.Context, boolean):com.autonavi.aps.amapapi.model.a");
    }

    /* renamed from: a */
    public final void m51440a(String str) {
        this.f8224d = str;
    }

    /* renamed from: a */
    public final void m51448a() {
        this.f8223c = 0L;
        this.f8224d = null;
    }
}

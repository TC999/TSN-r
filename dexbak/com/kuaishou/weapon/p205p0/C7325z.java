package com.kuaishou.weapon.p205p0;

import java.util.HashSet;
import java.util.Set;
import org.json.JSONObject;

/* renamed from: com.kuaishou.weapon.p0.z */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C7325z {

    /* renamed from: e */
    private Set<String> f25246e = new HashSet();

    /* renamed from: f */
    private Set<String> f25247f = new HashSet();

    /* renamed from: g */
    private Set<String> f25248g = new HashSet();

    /* renamed from: h */
    private Set<String> f25249h = new HashSet();

    /* renamed from: a */
    private String f25242a = C7284i.m33864a("f118f1f9431de3a626df48d7302911", "0820");

    /* renamed from: b */
    private String f25243b = C7284i.m33864a("f118f1ef4616f3fc27d1", "0820");

    /* renamed from: c */
    private String f25244c = C7284i.m33864a("f118f1e84f0bf5ba3bd1579c6d35", "0820");

    /* renamed from: d */
    private String f25245d = C7284i.m33864a("fc03e7a44510", "0820");

    /* JADX WARN: Code restructure failed: missing block: B:120:0x01f2, code lost:
        if (r1 == null) goto L144;
     */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0122 A[Catch: all -> 0x01e5, Exception -> 0x01e8, TryCatch #8 {Exception -> 0x01e8, all -> 0x01e5, blocks: (B:4:0x000d, B:8:0x0048, B:9:0x005c, B:11:0x0062, B:13:0x006b, B:15:0x0073, B:17:0x007b, B:19:0x0083, B:25:0x0091, B:27:0x0099, B:29:0x00a1, B:31:0x00a9, B:33:0x00b1, B:35:0x00bd, B:37:0x00c5, B:40:0x00cf, B:42:0x00d7, B:44:0x00df, B:46:0x00e7, B:47:0x00ec, B:49:0x00f4, B:51:0x00fc, B:53:0x0104, B:55:0x010a, B:57:0x0112, B:59:0x011a, B:61:0x0122, B:63:0x0128, B:65:0x0130, B:67:0x0138, B:69:0x0140, B:71:0x0148, B:73:0x0150, B:75:0x0158, B:77:0x0160, B:80:0x0169, B:82:0x0171, B:84:0x0179, B:86:0x0181, B:89:0x018a, B:91:0x0192, B:93:0x0198, B:95:0x01a3, B:97:0x01ab, B:99:0x01b3, B:102:0x01bd, B:103:0x01c4, B:104:0x01cb, B:105:0x01d2, B:107:0x01d8), top: B:135:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0127  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public org.json.JSONArray m33478a(android.content.Context r9) {
        /*
            Method dump skipped, instructions count: 502
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kuaishou.weapon.p205p0.C7325z.m33478a(android.content.Context):org.json.JSONArray");
    }

    /* renamed from: b */
    public Set<String> m33477b() {
        try {
            Set<String> set = this.f25248g;
            if (set == null || set.size() <= 0) {
                return null;
            }
            return this.f25248g;
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: c */
    public Set<String> m33476c() {
        try {
            Set<String> set = this.f25249h;
            if (set == null || set.size() <= 0) {
                return null;
            }
            return this.f25249h;
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: d */
    public JSONObject m33475d() {
        try {
            Set<String> set = this.f25246e;
            if (set == null || set.size() <= 0) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            for (String str : this.f25246e) {
                if (str.contains(this.f25242a)) {
                    jSONObject.put("0", 1);
                } else if (str.contains(this.f25243b)) {
                    jSONObject.put("1", 1);
                } else if (str.contains(this.f25244c)) {
                    jSONObject.put("2", 1);
                }
            }
            if (jSONObject.length() > 0) {
                return jSONObject;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: e */
    public Set m33474e() {
        try {
            HashSet hashSet = new HashSet();
            Set<String> set = this.f25246e;
            if (set == null || set.size() <= 0) {
                return null;
            }
            for (String str : this.f25246e) {
                if (str.endsWith("dex")) {
                    hashSet.add(str);
                }
                if (hashSet.size() > 5) {
                    break;
                }
            }
            if (hashSet.size() > 0) {
                return hashSet;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: a */
    public int m33479a() {
        try {
            Set<String> set = this.f25247f;
            if (set == null || set.size() <= 0) {
                return 0;
            }
            return this.f25247f.size();
        } catch (Exception unused) {
            return 0;
        }
    }
}

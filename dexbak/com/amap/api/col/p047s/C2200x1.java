package com.amap.api.col.p047s;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.col.p047s.C2023c1;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: NetReuestParam.java */
/* renamed from: com.amap.api.col.s.x1 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class C2200x1 {

    /* renamed from: b */
    private static final String f6653b = C2079j1.m52857t("SRFZHZUVZT3BOa0ZiemZRQQ");

    /* renamed from: c */
    private static final String f6654c = C2079j1.m52857t("FbGJzX3Nkaw");

    /* renamed from: d */
    private static final String f6655d = C2079j1.m52857t("SWjJuYVh2eEMwSzVmNklFSmh0UXpVb2xtOVM4eU9Ua3E");

    /* renamed from: e */
    private static final String f6656e = C2079j1.m52857t("FQU5EU0RLMTA");

    /* renamed from: f */
    private static final String f6657f = C2079j1.m52857t("FMTAw");

    /* renamed from: g */
    private static boolean f6658g = false;

    /* renamed from: a */
    private String f6659a = "";

    /* compiled from: NetReuestParam.java */
    /* renamed from: com.amap.api.col.s.x1$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    final class C2201a implements C2023c1.InterfaceC2026c {

        /* renamed from: a */
        private C2200x1 f6660a = new C2200x1();

        C2201a() {
        }

        @Override // com.amap.api.col.p047s.C2023c1.InterfaceC2026c
        /* renamed from: a */
        public final String mo52318a() {
            return C2200x1.m52320e();
        }

        @Override // com.amap.api.col.p047s.C2023c1.InterfaceC2026c
        /* renamed from: b */
        public final AbstractC2044dz mo52314b(byte[] bArr, Map<String, String> map) {
            return new C2153t2(bArr, map);
        }

        @Override // com.amap.api.col.p047s.C2023c1.InterfaceC2026c
        /* renamed from: a */
        public final String mo52317a(Context context, String str) {
            return C2200x1.m52323b(context, str);
        }

        @Override // com.amap.api.col.p047s.C2023c1.InterfaceC2026c
        /* renamed from: b */
        public final Map<String, String> mo52315b() {
            return this.f6660a.m52321d();
        }

        @Override // com.amap.api.col.p047s.C2023c1.InterfaceC2026c
        /* renamed from: a */
        public final String mo52316a(String str, String str2, String str3, String str4) {
            return this.f6660a.m52322c(str, str2, str3, str4);
        }
    }

    /* renamed from: a */
    public static C2023c1.InterfaceC2026c m52324a() {
        return new C2201a();
    }

    /* renamed from: b */
    public static String m52323b(Context context, String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.optInt(C2079j1.m52857t("UY29kZQ")) == 1) {
                String optString = new JSONObject(jSONObject.optString(C2079j1.m52857t("FZGF0YQ"))).optString(C2079j1.m52857t("FYWRpdQ"));
                if (TextUtils.isEmpty(optString)) {
                    return "";
                }
                C2223y1.m52189b(optString);
                C2152t1.m52445a(context).m52443c(optString);
                return optString;
            }
            return "";
        } catch (JSONException e) {
            e.printStackTrace();
            return "";
        }
    }

    /* renamed from: e */
    public static String m52320e() {
        return C2223y1.m52190a();
    }

    /* renamed from: f */
    private String m52319f() {
        if (!TextUtils.isEmpty(this.f6659a)) {
            return this.f6659a;
        }
        String m53096a = C2040d1.m53096a("TUpJaVFGNk5LXHtSX1ZwQlRiV1VVZmtYWU1haV1hYWHCiXJtZcKLdmp8wpFewo1/wphwwoFzZmR8aWp6X2k6XsKDwoF+WGbChGdAScKLwoVXfmNxYEvCjcKLSG7CjGNvwoZtVFZ7WMKXYMKfwo5dZcKHfzZXUG85X0hNOVJrb2U8ZlJGW8KCe8KOV8KQWllrcGrCjcKIT25lUHPCicKGVsKKeG5fwp56XsKbc8KJbUVYR0pqU09gfE5/WT5YeHNAwoDCh1Z4V8KQT3JQYmxQbcKYwpFxdG/Ci3rCmMKQwop+YVbCmWFxwpxBdW07Zjp/ODlAbcKEY1pQwoJowohbV1VmV1laWmtcYGbClXfCk2NvesKdwohdWFnCol/CjWTCmMKicG1ENnAvPFtpcXtfclhfXsKAwolgRWNbS29OwpFafV3CkMKLTcKCwolrU3DCmGnCmX9wdsKPcXDCg3LCnFpGcDVTeTxNWW07bXJePVRfQn3ChGNraFhbwpNcwpXChMKNaFVjeVF8wojChm9YbmvChGDCmHvChGVQWjo0Z3o9djleOztWcVxSfWE9woLChkZdcGTCgVzCjMKUVE12wpV5bcKVwprCnntZworCgsKfwpHCksKnwpHClURURW9YaDtwXU1bck5YX3hSVFZUYlxKWFlua1xeYm9jU8KDa3ZrwpZ5am9Za3jCknR3fA");
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < m53096a.length(); i++) {
            stringBuffer.append((char) (m53096a.charAt(i) - (i % 48)));
        }
        String stringBuffer2 = stringBuffer.toString();
        StringBuffer stringBuffer3 = new StringBuffer();
        for (int i2 = 0; i2 < stringBuffer2.length() / 2; i2++) {
            stringBuffer3.append((char) ((stringBuffer2.charAt(i2) + stringBuffer2.charAt((stringBuffer2.length() - 1) - i2)) / 2));
        }
        String stringBuffer4 = stringBuffer3.toString();
        this.f6659a = stringBuffer4;
        return stringBuffer4;
    }

    /* renamed from: c */
    public final String m52322c(String str, String str2, String str3, String str4) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(C2079j1.m52857t("LdGlk"), str);
            jSONObject.put(C2079j1.m52857t("FZGl1"), str2);
            jSONObject.put(C2079j1.m52857t("AZGl1Mg"), str3);
            jSONObject.put(C2079j1.m52857t("EZGl1Mw"), str4);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        String jSONObject2 = jSONObject.toString();
        if (TextUtils.isEmpty(jSONObject2)) {
            return null;
        }
        String m53263b = C2018a2.m53263b();
        if (!TextUtils.isEmpty(m53263b)) {
            String m52395a = C2187v1.m52395a(C2124q2.m52646a((jSONObject2 + "\u0000").getBytes(), m53263b.getBytes()));
            if (!TextUtils.isEmpty(m52395a)) {
                try {
                    String m52395a2 = C2187v1.m52395a(C2226z1.m52177b(m53263b.getBytes("utf-8"), C2226z1.m52178a(m52319f())));
                    return C2079j1.m52857t("Fa2V5PQ") + URLEncoder.encode(m52395a2) + C2079j1.m52857t("SJmRhdGE9") + URLEncoder.encode(m52395a);
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
        }
        return null;
    }

    /* renamed from: d */
    public final synchronized Map<String, String> m52321d() {
        if (f6658g) {
            return null;
        }
        f6658g = true;
        HashMap hashMap = new HashMap();
        hashMap.put(C2079j1.m52857t("FZW50"), C2079j1.m52857t("FMg"));
        StringBuilder sb = new StringBuilder();
        sb.append(C2079j1.m52857t("SY2hhbm5lbD0"));
        String str = f6654c;
        sb.append(str);
        sb.append(C2079j1.m52857t("SJmRpdj0"));
        String str2 = f6656e;
        sb.append(str2);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        stringBuffer.append(str2);
        stringBuffer.append(C2079j1.m52857t("FQA"));
        stringBuffer.append(f6655d);
        String m53261d = C2018a2.m53261d(stringBuffer.toString());
        sb.append(C2079j1.m52857t("FJnNpZ249"));
        sb.append(m53261d.toUpperCase(Locale.US));
        sb.append(C2079j1.m52857t("SJm91dHB1dD1qc29u") + "\u0000");
        hashMap.put(C2079j1.m52857t("FaW4"), C2187v1.m52395a(C2124q2.m52646a(sb.toString().getBytes(), f6653b.getBytes())));
        hashMap.put(C2079j1.m52857t("Sa2V5dA"), f6657f);
        return hashMap;
    }
}

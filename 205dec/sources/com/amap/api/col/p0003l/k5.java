package com.amap.api.col.p0003l;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.col.p0003l.i4;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: NetReuestParam.java */
/* renamed from: com.amap.api.col.3l.k5  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class k5 {

    /* renamed from: b  reason: collision with root package name */
    private static final String f8242b = q4.u("SRFZHZUVZT3BOa0ZiemZRQQ");

    /* renamed from: c  reason: collision with root package name */
    private static final String f8243c = q4.u("FbGJzX3Nkaw");

    /* renamed from: d  reason: collision with root package name */
    private static final String f8244d = q4.u("SWjJuYVh2eEMwSzVmNklFSmh0UXpVb2xtOVM4eU9Ua3E");

    /* renamed from: e  reason: collision with root package name */
    private static final String f8245e = q4.u("FQU5EU0RLMTA");

    /* renamed from: f  reason: collision with root package name */
    private static final String f8246f = q4.u("FMTAw");

    /* renamed from: g  reason: collision with root package name */
    private static boolean f8247g = false;

    /* renamed from: a  reason: collision with root package name */
    private String f8248a = "";

    /* compiled from: NetReuestParam.java */
    /* renamed from: com.amap.api.col.3l.k5$a */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    final class a implements i4.c {

        /* renamed from: a  reason: collision with root package name */
        private k5 f8249a = new k5();

        a() {
        }

        @Override // com.amap.api.col.p0003l.i4.c
        public final String a() {
            return k5.e();
        }

        @Override // com.amap.api.col.p0003l.i4.c
        public final Cif b(byte[] bArr, Map<String, String> map) {
            return new p6(bArr, map);
        }

        @Override // com.amap.api.col.p0003l.i4.c
        public final String a(Context context, String str) {
            return k5.b(context, str);
        }

        @Override // com.amap.api.col.p0003l.i4.c
        public final Map<String, String> b() {
            return this.f8249a.d();
        }

        @Override // com.amap.api.col.p0003l.i4.c
        public final String a(String str, String str2, String str3, String str4) {
            return this.f8249a.c(str, str2, str3, str4);
        }
    }

    public static i4.c a() {
        return new a();
    }

    public static String b(Context context, String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.optInt(q4.u("UY29kZQ")) == 1) {
                String optString = new JSONObject(jSONObject.optString(q4.u("FZGF0YQ"))).optString(q4.u("FYWRpdQ"));
                if (TextUtils.isEmpty(optString)) {
                    return "";
                }
                l5.b(optString);
                g5.a(context).c(optString);
                return optString;
            }
            return "";
        } catch (JSONException e4) {
            e4.printStackTrace();
            return "";
        }
    }

    public static String e() {
        return l5.a();
    }

    private String f() {
        if (!TextUtils.isEmpty(this.f8248a)) {
            return this.f8248a;
        }
        String a4 = j4.a("TUpJaVFGNk5LXHtSX1ZwQlRiV1VVZmtYWU1haV1hYWHCiXJtZcKLdmp8wpFewo1/wphwwoFzZmR8aWp6X2k6XsKDwoF+WGbChGdAScKLwoVXfmNxYEvCjcKLSG7CjGNvwoZtVFZ7WMKXYMKfwo5dZcKHfzZXUG85X0hNOVJrb2U8ZlJGW8KCe8KOV8KQWllrcGrCjcKIT25lUHPCicKGVsKKeG5fwp56XsKbc8KJbUVYR0pqU09gfE5/WT5YeHNAwoDCh1Z4V8KQT3JQYmxQbcKYwpFxdG/Ci3rCmMKQwop+YVbCmWFxwpxBdW07Zjp/ODlAbcKEY1pQwoJowohbV1VmV1laWmtcYGbClXfCk2NvesKdwohdWFnCol/CjWTCmMKicG1ENnAvPFtpcXtfclhfXsKAwolgRWNbS29OwpFafV3CkMKLTcKCwolrU3DCmGnCmX9wdsKPcXDCg3LCnFpGcDVTeTxNWW07bXJePVRfQn3ChGNraFhbwpNcwpXChMKNaFVjeVF8wojChm9YbmvChGDCmHvChGVQWjo0Z3o9djleOztWcVxSfWE9woLChkZdcGTCgVzCjMKUVE12wpV5bcKVwprCnntZworCgsKfwpHCksKnwpHClURURW9YaDtwXU1bck5YX3hSVFZUYlxKWFlua1xeYm9jU8KDa3ZrwpZ5am9Za3jCknR3fA");
        StringBuffer stringBuffer = new StringBuffer();
        for (int i4 = 0; i4 < a4.length(); i4++) {
            stringBuffer.append((char) (a4.charAt(i4) - (i4 % 48)));
        }
        String stringBuffer2 = stringBuffer.toString();
        StringBuffer stringBuffer3 = new StringBuffer();
        for (int i5 = 0; i5 < stringBuffer2.length() / 2; i5++) {
            stringBuffer3.append((char) ((stringBuffer2.charAt(i5) + stringBuffer2.charAt((stringBuffer2.length() - 1) - i5)) / 2));
        }
        String stringBuffer4 = stringBuffer3.toString();
        this.f8248a = stringBuffer4;
        return stringBuffer4;
    }

    public final String c(String str, String str2, String str3, String str4) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(q4.u("LdGlk"), str);
            jSONObject.put(q4.u("FZGl1"), str2);
            jSONObject.put(q4.u("AZGl1Mg"), str3);
            jSONObject.put(q4.u("EZGl1Mw"), str4);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        String jSONObject2 = jSONObject.toString();
        if (TextUtils.isEmpty(jSONObject2)) {
            return null;
        }
        String b4 = n5.b();
        if (!TextUtils.isEmpty(b4)) {
            String a4 = i5.a(m6.a((jSONObject2 + "\u0000").getBytes(), b4.getBytes()));
            if (!TextUtils.isEmpty(a4)) {
                try {
                    String a5 = i5.a(m5.b(b4.getBytes("utf-8"), m5.a(f())));
                    return q4.u("Fa2V5PQ") + URLEncoder.encode(a5) + q4.u("SJmRhdGE9") + URLEncoder.encode(a4);
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
        }
        return null;
    }

    public final synchronized Map<String, String> d() {
        if (f8247g) {
            return null;
        }
        f8247g = true;
        HashMap hashMap = new HashMap();
        hashMap.put(q4.u("FZW50"), q4.u("FMg"));
        StringBuilder sb = new StringBuilder();
        sb.append(q4.u("SY2hhbm5lbD0"));
        String str = f8243c;
        sb.append(str);
        sb.append(q4.u("SJmRpdj0"));
        String str2 = f8245e;
        sb.append(str2);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        stringBuffer.append(str2);
        stringBuffer.append(q4.u("FQA"));
        stringBuffer.append(f8244d);
        String d4 = n5.d(stringBuffer.toString());
        sb.append(q4.u("FJnNpZ249"));
        sb.append(d4.toUpperCase(Locale.US));
        sb.append(q4.u("SJm91dHB1dD1qc29u") + "\u0000");
        hashMap.put(q4.u("FaW4"), i5.a(m6.a(sb.toString().getBytes(), f8242b.getBytes())));
        hashMap.put(q4.u("Sa2V5dA"), f8246f);
        return hashMap;
    }
}
